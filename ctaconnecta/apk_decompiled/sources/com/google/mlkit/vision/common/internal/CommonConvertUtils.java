package com.google.mlkit.vision.common.internal;

import com.google.mlkit.vision.common.InputImage;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class CommonConvertUtils {
    public static int convertToAndroidImageFormat(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 35;
            if (i != 35) {
                i2 = InputImage.IMAGE_FORMAT_YV12;
                if (i != 842094169) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public static int convertToMVRotation(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Invalid rotation: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
