package androidx.camera.core.internal;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class YuvToJpegProcessor implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT = new Rect(0, 0, 0, 0);
    CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private ListenableFuture<Void> mCloseFuture;
    private ImageWriter mImageWriter;
    private final int mMaxImages;
    private int mQuality;
    private final Object mLock = new Object();
    private int mRotationDegrees = 0;
    private boolean mClosed = false;
    private int mProcessingImages = 0;
    private Rect mImageRect = UNINITIALIZED_RECT;

    public YuvToJpegProcessor(int i, int i2) {
        this.mQuality = i;
        this.mMaxImages = i2;
    }

    public void setJpegQuality(int i) {
        synchronized (this.mLock) {
            this.mQuality = i;
        }
    }

    public void setRotationDegrees(int i) {
        synchronized (this.mLock) {
            this.mRotationDegrees = i;
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onOutputSurface(Surface surface, int i) {
        Preconditions.checkState(i == 256, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.mLock) {
            if (!this.mClosed) {
                if (this.mImageWriter != null) {
                    throw new IllegalStateException("Output surface already set.");
                }
                this.mImageWriter = ImageWriterCompat.newInstance(surface, this.mMaxImages, i);
            } else {
                Logger.w(TAG, "Cannot set output surface. Processor is closed.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12, types: [int] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.camera.core.ImageProxy] */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.camera.core.ImageProxy] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r6v10, types: [int] */
    /* JADX WARN: Type inference failed for: r6v13, types: [int] */
    @Override // androidx.camera.core.impl.CaptureProcessor
    public void process(ImageProxyBundle imageProxyBundle) throws Throwable {
        ImageWriter imageWriter;
        boolean z;
        Rect rect;
        int i;
        int i2;
        ImageProxy imageProxy;
        Image imageDequeueInputImage;
        ImageProxy imageProxyPosition;
        List<Integer> captureIds = imageProxyBundle.getCaptureIds();
        int i3 = 0;
        Preconditions.checkArgument(captureIds.size() == 1, "Processing image bundle have single capture id, but found " + captureIds.size());
        ListenableFuture<ImageProxy> imageProxy2 = imageProxyBundle.getImageProxy(captureIds.get(0).intValue());
        Preconditions.checkArgument(imageProxy2.isDone());
        synchronized (this.mLock) {
            imageWriter = this.mImageWriter;
            z = this.mClosed;
            rect = this.mImageRect;
            if (!z) {
                this.mProcessingImages++;
            }
            i = this.mQuality;
            i2 = this.mRotationDegrees;
        }
        try {
            try {
                imageProxyPosition = imageProxy2.get();
                try {
                    if (z) {
                        Logger.w(TAG, "Image enqueued for processing on closed processor.");
                        imageProxyPosition.close();
                        z = z;
                        synchronized (this.mLock) {
                            if (!z) {
                                try {
                                    int i4 = this.mProcessingImages;
                                    ?? r6 = i4 - 1;
                                    this.mProcessingImages = r6;
                                    z = r6;
                                    if (i4 == 0) {
                                        z = r6;
                                        if (this.mClosed) {
                                            i3 = 1;
                                            z = r6;
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        if (i3 != 0) {
                            imageWriter.close();
                            Logger.d(TAG, "Closed after completion of last image processed.");
                            synchronized (this.mLock) {
                                CallbackToFutureAdapter.Completer<Void> completer = this.mCloseCompleter;
                                if (completer != null) {
                                    completer.set(null);
                                }
                            }
                        }
                    } else {
                        imageDequeueInputImage = imageWriter.dequeueInputImage();
                        try {
                            ImageProxy imageProxy3 = imageProxy2.get();
                            try {
                                Preconditions.checkState(imageProxy3.getFormat() == 35, "Input image is not expected YUV_420_888 image format");
                                YuvImage yuvImage = new YuvImage(ImageUtil.yuv_420_888toNv21(imageProxy3), 17, imageProxy3.getWidth(), imageProxy3.getHeight(), null);
                                ?? buffer = imageDequeueInputImage.getPlanes()[0].getBuffer();
                                imageProxyPosition = buffer.position();
                                yuvImage.compressToJpeg(rect, i, new ExifOutputStream(new ByteBufferOutputStream(buffer), getExifData(imageProxy3, i2)));
                                imageProxy3.close();
                                try {
                                    buffer.limit(buffer.position());
                                    buffer.position(imageProxyPosition);
                                    imageWriter.queueInputImage(imageDequeueInputImage);
                                    z = z;
                                    synchronized (this.mLock) {
                                        if (!z) {
                                            try {
                                                int i5 = this.mProcessingImages;
                                                ?? r62 = i5 - 1;
                                                this.mProcessingImages = r62;
                                                z = r62;
                                                if (i5 == 0) {
                                                    z = r62;
                                                    if (this.mClosed) {
                                                        i3 = 1;
                                                        z = r62;
                                                    }
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                    if (i3 != 0) {
                                        imageWriter.close();
                                        Logger.d(TAG, "Closed after completion of last image processed.");
                                        synchronized (this.mLock) {
                                            CallbackToFutureAdapter.Completer<Void> completer2 = this.mCloseCompleter;
                                            if (completer2 != null) {
                                                completer2.set(null);
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    imageProxyPosition = 0;
                                    if (!z) {
                                        Logger.e(TAG, "Failed to process YUV -> JPEG", e);
                                        imageDequeueInputImage = imageWriter.dequeueInputImage();
                                        ByteBuffer buffer2 = imageDequeueInputImage.getPlanes()[i3].getBuffer();
                                        buffer2.rewind();
                                        buffer2.limit(i3);
                                        imageWriter.queueInputImage(imageDequeueInputImage);
                                    }
                                    synchronized (this.mLock) {
                                        if (!z) {
                                            try {
                                                int i6 = this.mProcessingImages;
                                                this.mProcessingImages = i6 - 1;
                                                if (i6 == 0 && this.mClosed) {
                                                    i3 = 1;
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                    if (imageDequeueInputImage != null) {
                                        imageDequeueInputImage.close();
                                    }
                                    if (imageProxyPosition != 0) {
                                        imageProxyPosition.close();
                                    }
                                    if (i3 != 0) {
                                        imageWriter.close();
                                        Logger.d(TAG, "Closed after completion of last image processed.");
                                        synchronized (this.mLock) {
                                            CallbackToFutureAdapter.Completer<Void> completer3 = this.mCloseCompleter;
                                            if (completer3 != null) {
                                                completer3.set(null);
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    imageProxy = null;
                                    synchronized (this.mLock) {
                                        if (!z) {
                                            try {
                                                int i7 = this.mProcessingImages;
                                                this.mProcessingImages = i7 - 1;
                                                if (i7 == 0 && this.mClosed) {
                                                    i3 = 1;
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                    if (imageDequeueInputImage != null) {
                                        imageDequeueInputImage.close();
                                    }
                                    if (imageProxy != null) {
                                        imageProxy.close();
                                    }
                                    if (i3 != 0) {
                                        imageWriter.close();
                                        Logger.d(TAG, "Closed after completion of last image processed.");
                                        synchronized (this.mLock) {
                                            CallbackToFutureAdapter.Completer<Void> completer4 = this.mCloseCompleter;
                                            if (completer4 != null) {
                                                completer4.set(null);
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                imageProxyPosition = imageProxy3;
                            } catch (Throwable th2) {
                                th = th2;
                                imageProxy = imageProxy3;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    imageDequeueInputImage = null;
                } catch (Throwable th3) {
                    th = th3;
                    imageDequeueInputImage = null;
                    imageProxy = imageProxyPosition;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e5) {
            e = e5;
            imageProxyPosition = 0;
            imageDequeueInputImage = null;
        } catch (Throwable th5) {
            th = th5;
            imageProxy = null;
            imageDequeueInputImage = null;
        }
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                if (this.mProcessingImages == 0 && this.mImageWriter != null) {
                    Logger.d(TAG, "No processing in progress. Closing immediately.");
                    this.mImageWriter.close();
                    CallbackToFutureAdapter.Completer<Void> completer = this.mCloseCompleter;
                    if (completer != null) {
                        completer.set(null);
                    }
                } else {
                    Logger.d(TAG, "close() called while processing. Will close after completion.");
                }
            }
        }
    }

    public ListenableFuture<Void> getCloseFuture() {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating;
        synchronized (this.mLock) {
            if (this.mClosed && this.mProcessingImages == 0) {
                listenableFutureNonCancellationPropagating = Futures.immediateFuture(null);
            } else {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.internal.YuvToJpegProcessor$$ExternalSyntheticLambda3
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return this.f$0.m186x89b5c91(completer);
                        }
                    });
                }
                listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
        }
        return listenableFutureNonCancellationPropagating;
    }

    /* renamed from: lambda$getCloseFuture$0$androidx-camera-core-internal-YuvToJpegProcessor, reason: not valid java name */
    /* synthetic */ Object m186x89b5c91(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "YuvToJpegProcessor-close";
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onResolutionUpdate(Size size) {
        synchronized (this.mLock) {
            this.mImageRect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }

    private static ExifData getExifData(ImageProxy imageProxy, int i) {
        ExifData.Builder builderBuilderForDevice = ExifData.builderForDevice();
        imageProxy.getImageInfo().populateExifData(builderBuilderForDevice);
        builderBuilderForDevice.setOrientationDegrees(i);
        return builderBuilderForDevice.setImageWidth(imageProxy.getWidth()).setImageHeight(imageProxy.getHeight()).build();
    }

    private static final class ByteBufferOutputStream extends OutputStream {
        private final ByteBuffer mByteBuffer;

        ByteBufferOutputStream(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            if (!this.mByteBuffer.hasRemaining()) {
                throw new EOFException("Output ByteBuffer has no bytes remaining.");
            }
            this.mByteBuffer.put((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            bArr.getClass();
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            if (this.mByteBuffer.remaining() < i2) {
                throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
            }
            this.mByteBuffer.put(bArr, i, i2);
        }
    }
}
