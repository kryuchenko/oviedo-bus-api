package com.tecalis.identitysdk.listeners;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* loaded from: classes5.dex */
public class WebAppInterface {
    Context mContext;

    @JavascriptInterface
    public void onFlowComplete() {
    }

    WebAppInterface(Context context) {
        this.mContext = context;
    }
}
