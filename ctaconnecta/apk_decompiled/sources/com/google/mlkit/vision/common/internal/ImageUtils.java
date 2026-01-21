package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public static Bitmap zza(ContentResolver contentResolver, Uri uri) throws IOException {
        Bitmap bitmapCreateBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            int iZzb = zzb(contentResolver, uri);
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            switch (iZzb) {
                case 2:
                    matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    break;
                default:
                    matrix = null;
                    break;
            }
            Matrix matrix2 = matrix;
            if (matrix2 == null || bitmap == (bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix2, true))) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (FileNotFoundException e) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 21);
            sb.append("Could not open file: ");
            sb.append(strValueOf);
            gmsLogger.e("MLKitImageUtils", sb.toString(), e);
            throw e;
        }
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return inputImage.getBitmapInternal().getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return inputImage.getByteBuffer().limit();
        }
        if (inputImage.getFormat() == 35) {
            return (inputImage.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        return 0;
    }

    private static int zzb(ContentResolver contentResolver, Uri uri) throws IOException {
        if (!FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && !"file".equals(uri.getScheme())) {
            return 0;
        }
        ExifInterface exifInterface = null;
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    exifInterface = new ExifInterface(inputStreamOpenInputStream);
                } finally {
                }
            }
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
        } catch (IOException e) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 48);
            sb.append("failed to open file to read rotation meta data: ");
            sb.append(strValueOf);
            gmsLogger.e("MLKitImageUtils", sb.toString(), e);
        }
        if (exifInterface == null) {
            return 0;
        }
        return exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
    }
}
