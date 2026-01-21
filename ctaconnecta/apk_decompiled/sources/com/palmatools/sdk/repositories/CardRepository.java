package com.palmatools.sdk.repositories;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.palmatools.sdk.model.ClsApduMessage;
import com.palmatools.sdk.model.ClsErrorMessage;
import com.palmatools.sdk.model.ClsReaderMessage;
import com.palmatools.sdk.model.ClsTextMessage;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: CardRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0094\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052h\u0010\u0011\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0012J\u0094\u0001\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052h\u0010\u0011\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0012J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/palmatools/sdk/repositories/CardRepository;", "", "baseUrl", "", "headers", "", "(Ljava/lang/String;Ljava/util/Map;)V", "createWebservice", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getTask", "", "taskName", "sessionId", "params", "completion", "Lkotlin/Function4;", "Lcom/palmatools/sdk/model/ClsApduMessage;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "apduMessage", "Lcom/palmatools/sdk/model/ClsReaderMessage;", "readerMessage", "Lcom/palmatools/sdk/model/ClsTextMessage;", "textMessage", "Lcom/palmatools/sdk/model/ClsErrorMessage;", "errorMessage", "postTask", "trustEveryone", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardRepository {
    private final String baseUrl;
    private final Map<String, String> headers;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createWebservice$lambda$0(String str, SSLSession sSLSession) {
        return true;
    }

    public CardRepository(String baseUrl, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.baseUrl = baseUrl;
        this.headers = headers;
    }

    private final <T> T createWebservice(Class<T> clazz) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS);
        builder.hostnameVerifier(new HostnameVerifier() { // from class: com.palmatools.sdk.repositories.CardRepository$$ExternalSyntheticLambda0
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return CardRepository.createWebservice$lambda$0(str, sSLSession);
            }
        });
        builder.addInterceptor(new Interceptor() { // from class: com.palmatools.sdk.repositories.CardRepository$createWebservice$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Request.Builder builderNewBuilder = chain.request().newBuilder();
                for (Map.Entry entry : this.this$0.headers.entrySet()) {
                    builderNewBuilder.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
                return chain.proceed(builderNewBuilder.build());
            }
        });
        return (T) new Retrofit.Builder().baseUrl(this.baseUrl).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build().create(clazz);
    }

    public final void getTask(String taskName, String sessionId, Map<String, String> params, final Function4<? super ClsApduMessage, ? super ClsReaderMessage, ? super ClsTextMessage, ? super ClsErrorMessage, Unit> completion) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(completion, "completion");
        ((CardWebservice) createWebservice(CardWebservice.class)).getTask(taskName, sessionId, params).enqueue(new Callback<ResponseBody>() { // from class: com.palmatools.sdk.repositories.CardRepository.getTask.1
            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                completion.invoke(null, null, null, new ClsErrorMessage(-1, t, null));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) throws JSONException {
                String strString;
                Unit unit;
                Unit unit2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                        strString = "{}";
                    }
                    JSONObject jSONObject = new JSONObject(strString);
                    if (jSONObject.opt("errorCode") != null) {
                        completion.invoke(null, null, null, (ClsErrorMessage) new Gson().fromJson(jSONObject.toString(), ClsErrorMessage.class));
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        Function4<ClsApduMessage, ClsReaderMessage, ClsTextMessage, ClsErrorMessage, Unit> function4 = completion;
                        Object objOpt = jSONObject.opt("apdu");
                        String str = objOpt instanceof String ? (String) objOpt : null;
                        if (str != null) {
                            function4.invoke(new ClsApduMessage(str), new ClsReaderMessage(jSONObject.getInt("ClsReaderMessageId")), null, null);
                            unit2 = Unit.INSTANCE;
                        } else {
                            unit2 = null;
                        }
                        if (unit2 == null) {
                            String string = jSONObject.getString("text");
                            Intrinsics.checkNotNullExpressionValue(string, "responseObject.getString(\"text\")");
                            function4.invoke(null, null, new ClsTextMessage(string), null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iCode = response.code();
                ResponseBody responseBodyErrorBody = response.errorBody();
                completion.invoke(null, null, null, new ClsErrorMessage(iCode, null, responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
            }
        });
    }

    public final void postTask(String taskName, String sessionId, Map<String, String> params, final Function4<? super ClsApduMessage, ? super ClsReaderMessage, ? super ClsTextMessage, ? super ClsErrorMessage, Unit> completion) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(completion, "completion");
        JsonObject jsonObject = new JsonObject();
        Iterator<T> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
        }
        ((CardWebservice) createWebservice(CardWebservice.class)).postTask(taskName, sessionId, jsonObject).enqueue(new Callback<ResponseBody>() { // from class: com.palmatools.sdk.repositories.CardRepository.postTask.2
            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                completion.invoke(null, null, null, new ClsErrorMessage(-1, t, null));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) throws JSONException {
                String strString;
                Unit unit;
                Unit unit2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                        strString = "{}";
                    }
                    JSONObject jSONObject = new JSONObject(strString);
                    if (jSONObject.opt("errorCode") != null) {
                        completion.invoke(null, null, null, (ClsErrorMessage) new Gson().fromJson(jSONObject.toString(), ClsErrorMessage.class));
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        Function4<ClsApduMessage, ClsReaderMessage, ClsTextMessage, ClsErrorMessage, Unit> function4 = completion;
                        Object objOpt = jSONObject.opt("apdu");
                        String str = objOpt instanceof String ? (String) objOpt : null;
                        if (str != null) {
                            function4.invoke(new ClsApduMessage(str), new ClsReaderMessage(jSONObject.getInt("ClsReaderMessageId")), null, null);
                            unit2 = Unit.INSTANCE;
                        } else {
                            unit2 = null;
                        }
                        if (unit2 == null) {
                            String string = jSONObject.getString("text");
                            Intrinsics.checkNotNullExpressionValue(string, "responseObject.getString(\"text\")");
                            function4.invoke(null, null, new ClsTextMessage(string), null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iCode = response.code();
                ResponseBody responseBodyErrorBody = response.errorBody();
                completion.invoke(null, null, null, new ClsErrorMessage(iCode, null, responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
            }
        });
    }

    public final SSLSocketFactory trustEveryone(X509TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
            return socketFactory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
