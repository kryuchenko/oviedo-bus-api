package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
class CaptureProcessorPipeline implements CaptureProcessor {
    private static final String TAG = "CaptureProcessorPipeline";
    CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private ListenableFuture<Void> mCloseFuture;
    final Executor mExecutor;
    private final int mMaxImages;
    private final CaptureProcessor mPostCaptureProcessor;
    private final CaptureProcessor mPreCaptureProcessor;
    private ImageReaderProxy mIntermediateImageReader = null;
    private ImageInfo mSourceImageInfo = null;
    private final Object mLock = new Object();
    private boolean mClosed = false;
    private boolean mProcessing = false;

    CaptureProcessorPipeline(CaptureProcessor captureProcessor, int i, CaptureProcessor captureProcessor2, Executor executor) {
        this.mPreCaptureProcessor = captureProcessor;
        this.mPostCaptureProcessor = captureProcessor2;
        this.mExecutor = executor;
        this.mMaxImages = i;
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onOutputSurface(Surface surface, int i) {
        this.mPostCaptureProcessor.onOutputSurface(surface, i);
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void process(ImageProxyBundle imageProxyBundle) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mProcessing = true;
            ListenableFuture<ImageProxy> imageProxy = imageProxyBundle.getImageProxy(imageProxyBundle.getCaptureIds().get(0).intValue());
            Preconditions.checkArgument(imageProxy.isDone());
            try {
                this.mSourceImageInfo = imageProxy.get().getImageInfo();
                this.mPreCaptureProcessor.process(imageProxyBundle);
            } catch (InterruptedException | ExecutionException unused) {
                throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onResolutionUpdate(Size size) {
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, this.mMaxImages));
        this.mIntermediateImageReader = androidImageReaderProxy;
        this.mPreCaptureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), 35);
        this.mPreCaptureProcessor.onResolutionUpdate(size);
        this.mPostCaptureProcessor.onResolutionUpdate(size);
        this.mIntermediateImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.CaptureProcessorPipeline$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                this.f$0.m140x3f602b2(imageReaderProxy);
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: lambda$onResolutionUpdate$1$androidx-camera-core-CaptureProcessorPipeline, reason: not valid java name */
    /* synthetic */ void m140x3f602b2(ImageReaderProxy imageReaderProxy) {
        final ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
        try {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.CaptureProcessorPipeline$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m139x8e7bdc71(imageProxyAcquireNextImage);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "The executor for post-processing might have been shutting down or terminated!");
            imageProxyAcquireNextImage.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: postProcess, reason: merged with bridge method [inline-methods] */
    public void m139x8e7bdc71(ImageProxy imageProxy) {
        CallbackToFutureAdapter.Completer<Void> completer;
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        Preconditions.checkNotNull(this.mSourceImageInfo);
        String next = this.mSourceImageInfo.getTagBundle().listKeys().iterator().next();
        Integer num = (Integer) this.mSourceImageInfo.getTagBundle().getTag(next);
        num.intValue();
        SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, this.mSourceImageInfo);
        this.mSourceImageInfo = null;
        SettableImageProxyBundle settableImageProxyBundle = new SettableImageProxyBundle(Collections.singletonList(num), next);
        settableImageProxyBundle.addImageProxy(settableImageProxy);
        this.mPostCaptureProcessor.process(settableImageProxyBundle);
        synchronized (this.mLock) {
            this.mProcessing = false;
            if (this.mClosed && (completer = this.mCloseCompleter) != null) {
                completer.set(null);
            }
        }
    }

    void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            ImageReaderProxy imageReaderProxy = this.mIntermediateImageReader;
            if (imageReaderProxy != null) {
                imageReaderProxy.clearOnImageAvailableListener();
                this.mIntermediateImageReader.close();
            }
            if (!this.mProcessing && (completer = this.mCloseCompleter) != null) {
                completer.set(null);
            }
            this.mClosed = true;
        }
    }

    ListenableFuture<Void> getCloseFuture() {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating;
        synchronized (this.mLock) {
            if (this.mClosed && !this.mProcessing) {
                listenableFutureNonCancellationPropagating = Futures.immediateFuture(null);
            } else {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.CaptureProcessorPipeline$$ExternalSyntheticLambda1
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return this.f$0.m138x31550d84(completer);
                        }
                    });
                }
                listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
        }
        return listenableFutureNonCancellationPropagating;
    }

    /* renamed from: lambda$getCloseFuture$2$androidx-camera-core-CaptureProcessorPipeline, reason: not valid java name */
    /* synthetic */ Object m138x31550d84(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "CaptureProcessorPipeline-close";
    }
}
