package com.tecalis.identitysdk.network;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class InputStreamVolleyRequest extends Request<byte[]> {
    private final Response.Listener<byte[]> mListener;
    private Map<String, String> mParams;
    public Map<String, String> responseHeaders;

    public InputStreamVolleyRequest(int i, String str, Response.Listener<byte[]> listener, Response.ErrorListener errorListener, HashMap<String, String> map) {
        super(i, str, errorListener);
        setShouldCache(false);
        this.mListener = listener;
        this.mParams = map;
    }

    @Override // com.android.volley.Request
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(byte[] bArr) {
        this.mListener.onResponse(bArr);
    }

    @Override // com.android.volley.Request
    protected Response<byte[]> parseNetworkResponse(NetworkResponse networkResponse) {
        this.responseHeaders = networkResponse.headers;
        return Response.success(networkResponse.data, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
