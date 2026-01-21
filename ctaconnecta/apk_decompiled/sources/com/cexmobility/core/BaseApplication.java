package com.cexmobility.core;

import android.app.Application;
import android.util.Log;

/* loaded from: classes.dex */
public class BaseApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Log.e("paco", "on create core module");
    }
}
