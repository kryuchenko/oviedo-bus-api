package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzv {
    public static Bitmap zzb(Bitmap bitmap, zzu zzuVar) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzuVar.rotation != 0) {
            Matrix matrix = new Matrix();
            int i2 = zzuVar.rotation;
            if (i2 == 0) {
                i = 0;
            } else if (i2 == 1) {
                i = 90;
            } else if (i2 == 2) {
                i = CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            } else {
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unsupported rotation degree.");
                }
                i = 270;
            }
            matrix.postRotate(i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (zzuVar.rotation != 1 && zzuVar.rotation != 3) {
            return bitmap;
        }
        zzuVar.width = height;
        zzuVar.height = width;
        return bitmap;
    }
}
