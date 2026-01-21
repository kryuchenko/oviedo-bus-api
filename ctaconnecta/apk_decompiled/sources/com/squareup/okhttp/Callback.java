package com.squareup.okhttp;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface Callback {
    void onFailure(Request request, IOException iOException);

    void onResponse(Response response) throws IOException;
}
