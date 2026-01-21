package com.tecalis.identitysdk.network;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.common.net.HttpHeaders;
import com.tecalis.identitysdk.network.VolleyMultipartRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class NetworkManager {
    private static final int MY_SOCKET_TIMEOUT_MS = 30000;
    private static final RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();

    public static void post(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        post(str, jSONObject, true, listener, errorListener);
    }

    public static void post(String str, JSONObject jSONObject, Boolean bool, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        connect(1, str, jSONObject, bool, listener, errorListener);
    }

    public static void get(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        get(str, null, true, listener, errorListener);
    }

    public static void get(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        get(str, jSONObject, true, listener, errorListener);
    }

    public static void get(String str, JSONObject jSONObject, Boolean bool, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        connect(0, str, jSONObject, bool, listener, errorListener);
    }

    public static void patch(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        patch(str, jSONObject, true, listener, errorListener);
    }

    public static void patch(String str, JSONObject jSONObject, Boolean bool, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        connect(7, str, jSONObject, bool, listener, errorListener);
    }

    public static void delete(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        delete(str, null, true, listener, errorListener);
    }

    public static void delete(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        delete(str, jSONObject, true, listener, errorListener);
    }

    public static void delete(String str, JSONObject jSONObject, Boolean bool, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        connect(3, str, jSONObject, bool, listener, errorListener);
    }

    public static void multipart(String str, Map<String, String> map, Map<String, byte[]> map2, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        multipart(1, str, true, map, map2, listener, errorListener);
    }

    public static void multipart(String str, Map<String, String> map, Boolean bool, Map<String, byte[]> map2, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        multipart(1, str, bool, map, map2, listener, errorListener);
    }

    public static void multipart(int i, String str, Boolean bool, final Map<String, String> map, final Map<String, byte[]> map2, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(i, str, listener, errorListener) { // from class: com.tecalis.identitysdk.network.NetworkManager.1
            @Override // com.tecalis.identitysdk.network.VolleyMultipartRequest, com.android.volley.Request
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap();
            }

            @Override // com.android.volley.Request
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }

            @Override // com.tecalis.identitysdk.network.VolleyMultipartRequest
            protected Map<String, VolleyMultipartRequest.DataPart> getByteData() throws AuthFailureError {
                HashMap map3 = new HashMap();
                for (Map.Entry entry : map2.entrySet()) {
                    map3.put((String) entry.getKey(), new VolleyMultipartRequest.DataPart(System.currentTimeMillis() + ".jpg", (byte[]) entry.getValue()));
                }
                return map3;
            }
        };
        volleyMultipartRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0f));
        requestQueue.add(volleyMultipartRequest);
    }

    public static void downloadFile(String str, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        downloadFile(str, true, listener, errorListener);
    }

    public static void downloadFile(String str, boolean z, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        InputStreamVolleyRequest inputStreamVolleyRequest = new InputStreamVolleyRequest(0, str, listener, errorListener, null) { // from class: com.tecalis.identitysdk.network.NetworkManager.2
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap();
            }
        };
        inputStreamVolleyRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0f));
        requestQueue.add(inputStreamVolleyRequest);
    }

    private static void connect(int i, String str, JSONObject jSONObject, Boolean bool, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(i, str, jSONObject, listener, errorListener) { // from class: com.tecalis.identitysdk.network.NetworkManager.3
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put(HttpHeaders.ACCEPT, "application/json");
                map.put("Content-Type", "application/json");
                return map;
            }
        };
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0f));
        requestQueue.add(jsonObjectRequest);
    }

    public static String parseVolleyError(VolleyError volleyError) {
        try {
            return new JSONObject(new String(volleyError.networkResponse.data, StandardCharsets.UTF_8)).optString(NotificationCompat.CATEGORY_MESSAGE);
        } catch (JSONException e) {
            Log.e("document", e.toString());
            return volleyError.toString();
        }
    }
}
