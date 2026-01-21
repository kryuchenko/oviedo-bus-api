package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzcx;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class InputImage implements MLTaskInput {
    public static final int IMAGE_FORMAT_BITMAP = -1;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;
    private volatile Bitmap zza;
    private volatile ByteBuffer zzb;
    private volatile zza zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    @Retention(RetentionPolicy.CLASS)
    public @interface ImageFormat {
    }

    public static InputImage fromByteBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(byteBuffer, i, i2, i3, i4);
        zzcx.zza(i4, 3, jElapsedRealtime, i2, i, byteBuffer.limit());
        return inputImage;
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    static class zza {
        private final Image.Plane[] zza;

        zza(Image.Plane[] planeArr) {
            this.zza = planeArr;
        }

        final Image.Plane[] zza() {
            return this.zza;
        }
    }

    public static InputImage fromByteArray(byte[] bArr, int i, int i2, int i3, int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bArr, i, i2, i3, i4);
        zzcx.zza(i4, 2, jElapsedRealtime, i2, i, bArr.length);
        return inputImage;
    }

    public static InputImage fromBitmap(Bitmap bitmap, int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, i);
        zzcx.zza(-1, 1, jElapsedRealtime, -1, -1, bitmap.getAllocationByteCount());
        return inputImage;
    }

    public static InputImage fromMediaImage(Image image, int i) {
        InputImage inputImage;
        int iLimit;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Preconditions.checkNotNull(image, "Please provide a valid image");
        boolean z = true;
        Preconditions.checkArgument(i == 0 || i == 90 || i == 180 || i == 270, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        if (image.getFormat() != 256 && image.getFormat() != 35) {
            z = false;
        }
        Preconditions.checkArgument(z, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            inputImage = new InputImage(ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, i), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            inputImage = new InputImage(planes, image.getWidth(), image.getHeight(), i);
            iLimit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        InputImage inputImage2 = inputImage;
        zzcx.zza(image.getFormat(), 5, jElapsedRealtime, image.getHeight(), image.getWidth(), iLimit);
        return inputImage2;
    }

    public static InputImage fromFilePath(Context context, Uri uri) throws IOException {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ImageUtils.getInstance();
        Bitmap bitmapZza = ImageUtils.zza(context.getContentResolver(), uri);
        InputImage inputImage = new InputImage(bitmapZza, 0);
        zzcx.zza(-1, 4, jElapsedRealtime, -1, -1, bitmapZza.getAllocationByteCount());
        return inputImage;
    }

    private InputImage(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        Preconditions.checkArgument(i4 == 842094169 || i4 == 17);
        this.zzb = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = i4;
    }

    private InputImage(Image.Plane[] planeArr, int i, int i2, int i3) {
        Preconditions.checkNotNull(planeArr);
        this.zzc = new zza(planeArr);
        this.zzd = i;
        this.zze = i2;
        this.zzf = i3;
        this.zzg = 35;
    }

    private InputImage(byte[] bArr, int i, int i2, int i3, int i4) {
        this(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), i, i2, i3, i4);
    }

    private InputImage(Bitmap bitmap, int i) {
        this.zza = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.zzd = bitmap.getWidth();
        this.zze = bitmap.getHeight();
        this.zzf = i;
        this.zzg = -1;
    }

    public Bitmap getBitmapInternal() {
        return this.zza;
    }

    public Image.Plane[] getPlanes() {
        if (this.zzc == null) {
            return null;
        }
        return this.zzc.zza();
    }

    public ByteBuffer getByteBuffer() {
        return this.zzb;
    }

    public int getWidth() {
        return this.zzd;
    }

    public int getHeight() {
        return this.zze;
    }

    public int getRotationDegrees() {
        return this.zzf;
    }

    public int getFormat() {
        return this.zzg;
    }
}
