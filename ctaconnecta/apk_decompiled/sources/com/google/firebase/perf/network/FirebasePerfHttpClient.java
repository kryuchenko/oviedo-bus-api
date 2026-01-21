package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes4.dex */
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpClient, httpUriRequest, new Timer(), TransportManager.getInstance());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpUriRequest, httpContext, new Timer(), TransportManager.getInstance());
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return (T) execute(httpClient, httpUriRequest, responseHandler, new Timer(), TransportManager.getInstance());
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) execute(httpClient, httpUriRequest, responseHandler, httpContext, new Timer(), TransportManager.getInstance());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpClient, httpHost, httpRequest, new Timer(), TransportManager.getInstance());
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return execute(httpClient, httpHost, httpRequest, httpContext, new Timer(), TransportManager.getInstance());
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(httpClient, httpHost, httpRequest, responseHandler, new Timer(), TransportManager.getInstance());
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) execute(httpClient, httpHost, httpRequest, responseHandler, httpContext, new Timer(), TransportManager.getInstance());
    }

    static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest);
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilderBuilder.setHttpResponseCode(httpResponseExecute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponseExecute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilderBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponseExecute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilderBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilderBuilder.build();
            return httpResponseExecute;
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpUriRequest, httpContext);
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilderBuilder.setHttpResponseCode(httpResponseExecute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponseExecute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilderBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponseExecute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilderBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilderBuilder.build();
            return httpResponseExecute;
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            return (T) httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilderBuilder));
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpUriRequest.getURI().toString()).setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            return (T) httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilderBuilder), httpContext);
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest);
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilderBuilder.setHttpResponseCode(httpResponseExecute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponseExecute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilderBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponseExecute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilderBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilderBuilder.build();
            return httpResponseExecute;
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            HttpResponse httpResponseExecute = httpClient.execute(httpHost, httpRequest, httpContext);
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilderBuilder.setHttpResponseCode(httpResponseExecute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpResponseExecute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilderBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponseExecute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilderBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilderBuilder.build();
            return httpResponseExecute;
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            return (T) httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilderBuilder));
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, Timer timer, TransportManager transportManager) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        try {
            networkRequestMetricBuilderBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri()).setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilderBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(timer.getMicros());
            return (T) httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilderBuilder), httpContext);
        } catch (IOException e) {
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }
}
