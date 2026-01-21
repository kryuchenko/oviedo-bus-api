package com.tecalis.identitysdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes5.dex */
public class Toolbox {
    public static void setTimeout(Runnable runnable, long j) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
    }

    public static Date stringToDate(String str) {
        return stringToDate(str, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public static Date stringToDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
