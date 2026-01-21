package com.palmatools.sdk.repositories;

import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* compiled from: CardWebservice.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH'J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/palmatools/sdk/repositories/CardWebservice;", "", "getTask", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "taskName", "", "sessionId", "params", "", "postTask", "body", "Lcom/google/gson/JsonObject;", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CardWebservice {
    @GET("{taskName}/")
    Call<ResponseBody> getTask(@Path("taskName") String taskName, @Query("id") String sessionId, @QueryMap Map<String, String> params);

    @POST("{taskName}")
    Call<ResponseBody> postTask(@Path("taskName") String taskName, @Query("id") String sessionId, @Body JsonObject body);
}
