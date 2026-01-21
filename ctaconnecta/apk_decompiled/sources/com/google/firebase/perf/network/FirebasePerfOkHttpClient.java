package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    public static Response execute(Call call) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilderBuilder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            Response responseExecute = call.execute();
            sendNetworkMetric(responseExecute, networkRequestMetricBuilderBuilder, micros, timer.getDurationMicros());
            return responseExecute;
        } catch (IOException e) {
            Request request = call.request();
            if (request != null) {
                HttpUrl httpUrlUrl = request.url();
                if (httpUrlUrl != null) {
                    networkRequestMetricBuilderBuilder.setUrl(httpUrlUrl.url().toString());
                }
                if (request.method() != null) {
                    networkRequestMetricBuilderBuilder.setHttpMethod(request.method());
                }
            }
            networkRequestMetricBuilderBuilder.setRequestStartTimeMicros(micros);
            networkRequestMetricBuilderBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilderBuilder);
            throw e;
        }
    }

    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        call.enqueue(new InstrumentOkHttpEnqueueCallback(callback, TransportManager.getInstance(), timer, timer.getMicros()));
    }

    static void sendNetworkMetric(Response response, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j, long j2) throws IOException {
        Request request = response.request();
        if (request == null) {
            return;
        }
        networkRequestMetricBuilder.setUrl(request.url().url().toString());
        networkRequestMetricBuilder.setHttpMethod(request.method());
        if (request.body() != null) {
            long jContentLength = request.body().contentLength();
            if (jContentLength != -1) {
                networkRequestMetricBuilder.setRequestPayloadBytes(jContentLength);
            }
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            long contentLength = responseBodyBody.getContentLength();
            if (contentLength != -1) {
                networkRequestMetricBuilder.setResponsePayloadBytes(contentLength);
            }
            MediaType mediaType = responseBodyBody.get$contentType();
            if (mediaType != null) {
                networkRequestMetricBuilder.setResponseContentType(mediaType.getMediaType());
            }
        }
        networkRequestMetricBuilder.setHttpResponseCode(response.code());
        networkRequestMetricBuilder.setRequestStartTimeMicros(j);
        networkRequestMetricBuilder.setTimeToResponseCompletedMicros(j2);
        networkRequestMetricBuilder.build();
    }
}
