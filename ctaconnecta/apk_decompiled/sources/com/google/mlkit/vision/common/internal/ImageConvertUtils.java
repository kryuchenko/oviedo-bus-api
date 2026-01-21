package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class ImageConvertUtils {
    private static final ImageConvertUtils zza = new ImageConvertUtils();

    private ImageConvertUtils() {
    }

    public static ImageConvertUtils getInstance() {
        return zza;
    }

    public Bitmap getUpRightBitmap(InputImage inputImage) throws MlKitException {
        if (inputImage.getBitmapInternal() != null) {
            return zza(inputImage.getBitmapInternal(), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        return convertToUpRightBitmap(inputImage);
    }

    public ByteBuffer convertToNv21Buffer(InputImage inputImage, boolean z) throws MlKitException {
        ByteBuffer byteBufferAllocateDirect;
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format == 35) {
                    return zza(inputImage.getPlanes(), inputImage.getWidth(), inputImage.getHeight());
                }
                if (format == 842094169) {
                    return zza(inputImage.getByteBuffer(), z);
                }
                throw new MlKitException("Unsupported image format", 13);
            }
            if (z) {
                ByteBuffer byteBuffer = inputImage.getByteBuffer();
                if (byteBuffer.hasArray()) {
                    return byteBuffer;
                }
                byteBuffer.rewind();
                byte[] bArr = new byte[byteBuffer.limit()];
                byteBuffer.get(bArr);
                return ByteBuffer.wrap(bArr);
            }
            return inputImage.getByteBuffer();
        }
        Bitmap bitmapInternal = inputImage.getBitmapInternal();
        int width = bitmapInternal.getWidth();
        int height = bitmapInternal.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmapInternal.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (((int) Math.ceil(height / 2.0d)) * 2 * ((int) Math.ceil(width / 2.0d))) + i;
        if (z) {
            byteBufferAllocateDirect = ByteBuffer.allocate(iCeil);
        } else {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(iCeil);
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            int i5 = 0;
            while (i5 < width) {
                int i6 = iArr[i3];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                int i9 = i6 & 255;
                int i10 = (((((i7 * 66) + (i8 * 129)) + (i9 * 25)) + 128) >> 8) + 16;
                int i11 = (((((i7 * (-38)) - (i8 * 74)) + (i9 * 112)) + 128) >> 8) + 128;
                int i12 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i13 = i2 + 1;
                byteBufferAllocateDirect.put(i2, (byte) (i10 < 0 ? 0 : Math.min(255, i10)));
                if (i4 % 2 == 0 && i3 % 2 == 0) {
                    int i14 = i + 1;
                    byteBufferAllocateDirect.put(i, (byte) (i12 < 0 ? 0 : Math.min(255, i12)));
                    i += 2;
                    byteBufferAllocateDirect.put(i14, (byte) (i11 < 0 ? 0 : Math.min(255, i11)));
                }
                i3++;
                i5++;
                i2 = i13;
            }
        }
        return byteBufferAllocateDirect;
    }

    public Bitmap convertToUpRightBitmap(InputImage inputImage) throws MlKitException, IOException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return zza(inputImage.getBitmapInternal(), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        if (format == 17) {
            return zza(inputImage.getByteBuffer(), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 35) {
            return zza(zza(inputImage.getPlanes(), inputImage.getWidth(), inputImage.getHeight()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 842094169) {
            ByteBuffer byteBuffer = inputImage.getByteBuffer();
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();
            int rotationDegrees = inputImage.getRotationDegrees();
            byte[] bArrZza = zza(zza(byteBuffer, true).array(), width, height);
            return zza(BitmapFactory.decodeByteArray(bArrZza, 0, bArrZza.length), rotationDegrees, width, height);
        }
        throw new MlKitException("Unsupported image format", 13);
    }

    public ByteBuffer cloneByteBuffer(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        byteBufferAllocate.put(byteBuffer);
        byteBuffer.rewind();
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public Bitmap convertJpegToUpRightBitmap(Image image, int i) {
        Preconditions.checkArgument(image.getFormat() == 256, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.get(bArr);
        return zza(BitmapFactory.decodeByteArray(bArr, 0, iRemaining), i, image.getWidth(), image.getHeight());
    }

    public byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    private static byte[] zza(byte[] bArr, int i, int i2) throws IOException {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    zzn.zza(th, th2);
                    throw th;
                }
            }
        } catch (IOException unused) {
            byteArray = null;
        }
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused2) {
            Log.w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
            return byteArray;
        }
    }

    private final Bitmap zza(ByteBuffer byteBuffer, int i, int i2, int i3) throws IOException {
        byte[] bArrZza = zza(byteBufferToByteArray(byteBuffer), i, i2);
        return zza(BitmapFactory.decodeByteArray(bArrZza, 0, bArrZza.length), i3, i, i2);
    }

    private static ByteBuffer zza(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[((i3 / 4) * 2) + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i4 = (i3 * 2) / 4;
        boolean z = buffer2.remaining() == i4 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i4 - 1);
        } else {
            zza(planeArr[0], i, i2, bArr, 0, 1);
            zza(planeArr[1], i, i2, bArr, i3 + 1, 2);
            zza(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    private static Bitmap zza(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    private static void zza(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i5 = i / (i2 / iLimit);
        int rowStride = 0;
        for (int i6 = 0; i6 < iLimit; i6++) {
            int pixelStride = rowStride;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i3] = buffer.get(pixelStride);
                i3 += i4;
                pixelStride += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBufferAllocateDirect;
        int i;
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit / 6;
        if (z) {
            byteBufferAllocateDirect = ByteBuffer.allocate(iLimit);
        } else {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(iLimit);
        }
        int i3 = 0;
        while (true) {
            i = i2 << 2;
            if (i3 >= i) {
                break;
            }
            byteBufferAllocateDirect.put(i3, byteBuffer.get(i3));
            i3++;
        }
        for (int i4 = 0; i4 < (i2 << 1); i4++) {
            byteBufferAllocateDirect.put(i + i4, byteBuffer.get(((i4 % 2) * i2) + i + (i4 / 2)));
        }
        return byteBufferAllocateDirect;
    }
}
