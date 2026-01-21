package com.google.api.client.http;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.25.0 (gzip)";
    public static final String VERSION = "1.25.0";

    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int readTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private boolean followRedirects = true;
    private boolean throwExceptionOnExecuteError = true;

    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;

    HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:(1:11)|12|(1:14)|15|(1:20)(1:19)|(21:22|(2:24|(1:26))|29|(1:(1:32)(1:33))|34|(1:36)|37|(1:43)(1:42)|44|(7:46|(1:48)(1:49)|50|(1:52)(3:53|(1:55)(1:56)|57)|(5:59|(2:61|(1:63))(1:64)|(2:66|(1:68))|69|(1:71))(1:72)|(1:74)|75)(1:76)|(2:78|(3:80|(1:82)|83))|(1:87)(1:86)|88|166|89|168|90|91|(3:170|110|(5:112|(1:114)(1:115)|(2:117|(1:(3:125|126|(3:162|128|119)))(1:119))|131|(1:133))(2:(1:140)(1:141)|142))(0)|143|(2:175|(4:146|(1:148)|149|(1:159)(3:164|154|155))(1:160))(1:161))(1:27)|28|29|(0)|34|(0)|37|(2:39|43)(0)|44|(0)(0)|(0)|(1:87)(0)|88|166|89|168|90|91|(0)(0)|143|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0213, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0214, code lost:
    
        if (r19 != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0216, code lost:
    
        r7.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x021d, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0203, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0206, code lost:
    
        if (r20.retryOnExecuteIOException != false) goto L106;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029d A[LOOP:0: B:10:0x0021->B:161:0x029d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0220 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x027c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e4  */
    /* JADX WARN: Type inference failed for: r3v16, types: [com.google.api.client.util.LoggingStreamingContent] */
    /* JADX WARN: Type inference failed for: r4v15, types: [com.google.api.client.http.HttpEncodingStreamingContent, com.google.api.client.util.StreamingContent] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpResponse execute() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        HttpContent loggingStreamingContent;
        int i;
        boolean z;
        long j;
        HttpResponse httpResponse;
        boolean z2;
        BackOffPolicy backOffPolicy;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        String name;
        long jComputeLength;
        Preconditions.checkArgument(this.numRetries >= 0);
        int i2 = this.numRetries;
        BackOffPolicy backOffPolicy2 = this.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(this.requestMethod);
        Preconditions.checkNotNull(this.url);
        int i3 = i2;
        HttpResponse httpResponse2 = null;
        while (true) {
            if (httpResponse2 != null) {
                httpResponse2.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = this.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(this);
            }
            String strBuild = this.url.build();
            LowLevelHttpRequest lowLevelHttpRequestBuildRequest = this.transport.buildRequest(this.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z3 = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                if (z3) {
                    sb = new StringBuilder();
                    sb.append("-------------- REQUEST  --------------");
                    sb.append(StringUtils.LINE_SEPARATOR);
                    sb.append(this.requestMethod);
                    sb.append(' ');
                    sb.append(strBuild);
                    sb.append(StringUtils.LINE_SEPARATOR);
                    if (this.curlLoggingEnabled) {
                        sb2 = new StringBuilder("curl -v --compressed");
                        if (!this.requestMethod.equals("GET")) {
                            sb2.append(" -X ");
                            sb2.append(this.requestMethod);
                        }
                    }
                    String userAgent = this.headers.getUserAgent();
                    if (!this.suppressUserAgentSuffix) {
                        if (userAgent == null) {
                            this.headers.setUserAgent(USER_AGENT_SUFFIX);
                        } else {
                            this.headers.setUserAgent(userAgent + " Google-HTTP-Java-Client/1.25.0 (gzip)");
                        }
                    }
                    HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
                    if (!this.suppressUserAgentSuffix) {
                        this.headers.setUserAgent(userAgent);
                    }
                    loggingStreamingContent = this.content;
                    boolean z4 = loggingStreamingContent != null || loggingStreamingContent.retrySupported();
                    if (loggingStreamingContent == null) {
                        String type = this.content.getType();
                        if (z3) {
                            j = -1;
                            loggingStreamingContent = new LoggingStreamingContent(loggingStreamingContent, HttpTransport.LOGGER, Level.CONFIG, this.contentLoggingLimit);
                        } else {
                            j = -1;
                        }
                        HttpEncoding httpEncoding = this.encoding;
                        if (httpEncoding == null) {
                            jComputeLength = this.content.getLength();
                            name = null;
                        } else {
                            name = httpEncoding.getName();
                            ?? httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, this.encoding);
                            jComputeLength = z4 ? IOUtils.computeLength(httpEncodingStreamingContent) : j;
                            loggingStreamingContent = httpEncodingStreamingContent;
                        }
                        if (z3) {
                            i = i3;
                            if (type != null) {
                                z = z3;
                                String str = "Content-Type: " + type;
                                sb.append(str);
                                sb.append(StringUtils.LINE_SEPARATOR);
                                if (sb2 != null) {
                                    sb2.append(" -H '" + str + "'");
                                }
                            } else {
                                z = z3;
                            }
                            if (name != null) {
                                String str2 = "Content-Encoding: " + name;
                                sb.append(str2);
                                sb.append(StringUtils.LINE_SEPARATOR);
                                if (sb2 != null) {
                                    sb2.append(" -H '" + str2 + "'");
                                }
                            }
                            if (jComputeLength >= 0) {
                                sb.append("Content-Length: " + jComputeLength);
                                sb.append(StringUtils.LINE_SEPARATOR);
                            }
                        } else {
                            i = i3;
                            z = z3;
                        }
                        if (sb2 != null) {
                            sb2.append(" -d '@-'");
                        }
                        lowLevelHttpRequestBuildRequest.setContentType(type);
                        lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                        lowLevelHttpRequestBuildRequest.setContentLength(jComputeLength);
                        lowLevelHttpRequestBuildRequest.setStreamingContent(loggingStreamingContent);
                    } else {
                        i = i3;
                        z = z3;
                        j = -1;
                    }
                    if (z) {
                        logger.config(sb.toString());
                        if (sb2 != null) {
                            sb2.append(" -- '");
                            sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                            sb2.append("'");
                            if (loggingStreamingContent != null) {
                                sb2.append(" << $$$");
                            }
                            logger.config(sb2.toString());
                        }
                    }
                    boolean z5 = !z4 && i > 0;
                    lowLevelHttpRequestBuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
                    lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
                    httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                    e = null;
                    if (httpResponse == null) {
                        try {
                            if (httpResponse.isSuccessStatusCode()) {
                                z2 = z5 & (httpResponse == null);
                            } else {
                                HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler = this.unsuccessfulResponseHandler;
                                boolean zHandleResponse = httpUnsuccessfulResponseHandler != null ? httpUnsuccessfulResponseHandler.handleResponse(this, httpResponse, z5) : false;
                                if (!zHandleResponse) {
                                    if (handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                        zHandleResponse = true;
                                    } else if (z5 && (backOffPolicy = this.backOffPolicy) != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                                        long nextBackOffMillis = this.backOffPolicy.getNextBackOffMillis();
                                        if (nextBackOffMillis != j) {
                                            try {
                                                this.sleeper.sleep(nextBackOffMillis);
                                            } catch (InterruptedException unused) {
                                            }
                                            zHandleResponse = true;
                                        }
                                    }
                                }
                                z2 = z5 & zHandleResponse;
                                if (z2) {
                                    httpResponse.ignore();
                                }
                            }
                        } catch (Throwable th) {
                            if (httpResponse != null) {
                            }
                            throw th;
                        }
                    }
                    i3 = i - 1;
                    if (z2) {
                        if (httpResponse == null) {
                            throw e;
                        }
                        HttpResponseInterceptor httpResponseInterceptor = this.responseInterceptor;
                        if (httpResponseInterceptor != null) {
                            httpResponseInterceptor.interceptResponse(httpResponse);
                        }
                        if (!this.throwExceptionOnExecuteError || httpResponse.isSuccessStatusCode()) {
                            return httpResponse;
                        }
                        try {
                            throw new HttpResponseException(httpResponse);
                        } finally {
                            httpResponse.disconnect();
                        }
                    }
                    httpResponse2 = httpResponse;
                } else {
                    sb = null;
                }
                httpResponse = new HttpResponse(this, lowLevelHttpResponseExecute);
                e = null;
                if (httpResponse == null) {
                }
                i3 = i - 1;
                if (z2) {
                }
            } catch (Throwable th2) {
                InputStream content = lowLevelHttpResponseExecute.getContent();
                if (content != null) {
                    content.close();
                }
                throw th2;
            }
            sb2 = null;
            String userAgent2 = this.headers.getUserAgent();
            if (!this.suppressUserAgentSuffix) {
            }
            HttpHeaders.serializeHeaders(this.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
            if (!this.suppressUserAgentSuffix) {
            }
            loggingStreamingContent = this.content;
            if (loggingStreamingContent != null) {
            }
            if (loggingStreamingContent == null) {
            }
            if (z) {
            }
            if (z4) {
            }
            lowLevelHttpRequestBuildRequest.setTimeout(this.connectTimeout, this.readTimeout);
            lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
        }
    }

    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() { // from class: com.google.api.client.http.HttpRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location)));
        if (i == 303) {
            setRequestMethod("GET");
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }
}
