package com.cexmobility.core.utils;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class ColorUtils {
    public static Drawable changeDrawableColorForReadability(Drawable drawable, int backgroundColor, int desiredColor, int darkColor) {
        if (androidx.core.graphics.ColorUtils.calculateContrast(desiredColor, backgroundColor) < 1.5d) {
            drawable.setTint(darkColor);
        }
        return drawable;
    }

    public static int getInvertedColorForReadability(int backgroundColor, int foregroundColor) {
        return androidx.core.graphics.ColorUtils.calculateContrast(foregroundColor, backgroundColor) < 1.5d ? 16777215 ^ foregroundColor : foregroundColor;
    }
}
