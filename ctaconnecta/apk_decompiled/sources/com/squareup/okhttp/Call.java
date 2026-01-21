package com.squareup.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;

/* loaded from: classes5.dex */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.cancel();
        }
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        Request request() {
            return Call.this.originalRequest;
        }

        Object tag() {
            return Call.this.originalRequest.tag();
        }

        void cancel() {
            Call.this.cancel();
        }

        Call get() {
            return Call.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v20, types: [com.squareup.okhttp.Dispatcher] */
        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            IOException e;
            boolean z;
            Response responseWithInterceptorChain;
            String str = "Callback failure for ";
            try {
                try {
                    responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                    z = true;
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (Call.this.canceled) {
                        this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(responseWithInterceptorChain);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Internal.logger.log(Level.INFO, str + Call.this.toLoggableString(), (Throwable) e);
                    } else {
                        this.responseCallback.onFailure(Call.this.engine == null ? Call.this.originalRequest : Call.this.engine.getRequest(), e);
                    }
                }
            } finally {
                Call.this.client.getDispatcher().finished(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        return (this.canceled ? "canceled call" : NotificationCompat.CATEGORY_CALL) + " to " + this.originalRequest.httpUrl().resolve("/...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            if (this.index < Call.this.client.interceptors().size()) {
                ApplicationInterceptorChain applicationInterceptorChain = Call.this.new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
                Interceptor interceptor = Call.this.client.interceptors().get(this.index);
                Response responseIntercept = interceptor.intercept(applicationInterceptorChain);
                if (responseIntercept != null) {
                    return responseIntercept;
                }
                throw new NullPointerException("application interceptor " + interceptor + " returned null");
            }
            return Call.this.getResponse(request, this.forWebSocket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Response getResponse(Request request, boolean z) throws Throwable {
        Request requestBuild;
        Response response;
        Request requestFollowUpRequest;
        StreamAllocation streamAllocation;
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Request.Builder builderNewBuilder = request.newBuilder();
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header(HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                builderNewBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
            } else {
                builderNewBuilder.header(HttpHeaders.TRANSFER_ENCODING, "chunked");
                builderNewBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            }
            requestBuild = builderNewBuilder.build();
        } else {
            requestBuild = request;
        }
        this.engine = new HttpEngine(this.client, requestBuild, false, false, z, null, null, null);
        boolean z2 = false;
        int i = 0;
        while (!this.canceled) {
            try {
                try {
                    try {
                        try {
                            this.engine.sendRequest();
                            this.engine.readResponse();
                            response = this.engine.getResponse();
                            requestFollowUpRequest = this.engine.followUpRequest();
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            if (z2) {
                            }
                            throw th;
                        }
                    } catch (IOException e) {
                        HttpEngine httpEngineRecover = this.engine.recover(e, null);
                        if (httpEngineRecover != null) {
                            try {
                                this.engine = httpEngineRecover;
                            } catch (Throwable th2) {
                                th = th2;
                                if (z2) {
                                    this.engine.close().release();
                                }
                                throw th;
                            }
                        } else {
                            throw e;
                        }
                    }
                } catch (RequestException e2) {
                    throw e2.getCause();
                }
            } catch (RouteException e3) {
                HttpEngine httpEngineRecover2 = this.engine.recover(e3);
                if (httpEngineRecover2 != null) {
                    this.engine = httpEngineRecover2;
                } else {
                    throw e3.getLastConnectException();
                }
            }
            if (requestFollowUpRequest == null) {
                if (!z) {
                    this.engine.releaseStreamAllocation();
                }
                return response;
            }
            StreamAllocation streamAllocationClose = this.engine.close();
            i++;
            if (i > 20) {
                streamAllocationClose.release();
                throw new ProtocolException("Too many follow-up requests: " + i);
            }
            if (this.engine.sameConnection(requestFollowUpRequest.httpUrl())) {
                streamAllocation = streamAllocationClose;
            } else {
                streamAllocationClose.release();
                streamAllocation = null;
            }
            this.engine = new HttpEngine(this.client, requestFollowUpRequest, false, false, z, streamAllocation, null, response);
        }
        this.engine.releaseStreamAllocation();
        throw new IOException("Canceled");
    }
}
