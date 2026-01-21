package com.google.api.client.http;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface HttpExecuteInterceptor {
    void intercept(HttpRequest httpRequest) throws IOException;
}
