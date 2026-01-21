package com.iecisa.ctausuario.utils.maputils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/* loaded from: classes5.dex */
public class HtmlUtils {
    public static Spanned fromHtml(String html) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(html, 0);
        }
        return Html.fromHtml(html);
    }
}
