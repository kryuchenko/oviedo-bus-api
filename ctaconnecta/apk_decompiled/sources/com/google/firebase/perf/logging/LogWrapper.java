package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes4.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    public static synchronized LogWrapper getInstance() {
        if (instance == null) {
            instance = new LogWrapper();
        }
        return instance;
    }

    void d(String str) {
        Log.d(LOG_TAG, str);
    }

    void v(String str) {
        Log.v(LOG_TAG, str);
    }

    void i(String str) {
        Log.i(LOG_TAG, str);
    }

    void w(String str) {
        Log.w(LOG_TAG, str);
    }

    void e(String str) {
        Log.e(LOG_TAG, str);
    }

    private LogWrapper() {
    }
}
