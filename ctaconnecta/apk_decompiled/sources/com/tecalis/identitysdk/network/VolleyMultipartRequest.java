package com.tecalis.identitysdk.network;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes5.dex */
public class VolleyMultipartRequest extends Request<NetworkResponse> {
    private final String boundary;
    private final String lineEnd;
    private Response.ErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private Response.Listener<NetworkResponse> mListener;
    private final String twoHyphens;

    protected Map<String, DataPart> getByteData() throws AuthFailureError {
        return null;
    }

    public VolleyMultipartRequest(String str, Map<String, String> map, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        super(1, str, errorListener);
        this.twoHyphens = "--";
        this.lineEnd = "\r\n";
        this.boundary = "apiclient-" + System.currentTimeMillis();
        this.mListener = listener;
        this.mErrorListener = errorListener;
        this.mHeaders = map;
    }

    public VolleyMultipartRequest(int i, String str, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.twoHyphens = "--";
        this.lineEnd = "\r\n";
        this.boundary = "apiclient-" + System.currentTimeMillis();
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.mHeaders;
        return map != null ? map : super.getHeaders();
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return "multipart/form-data;boundary=" + this.boundary;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws IOException, AuthFailureError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            Map<String, String> params = getParams();
            if (params != null && params.size() > 0) {
                textParse(dataOutputStream, params, getParamsEncoding());
            }
            Map<String, DataPart> byteData = getByteData();
            if (byteData != null && byteData.size() > 0) {
                dataParse(dataOutputStream, byteData);
            }
            dataOutputStream.writeBytes("--" + this.boundary + "--\r\n");
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.android.volley.Request
    protected Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(networkResponse, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void deliverResponse(NetworkResponse networkResponse) {
        this.mListener.onResponse(networkResponse);
    }

    @Override // com.android.volley.Request
    public void deliverError(VolleyError volleyError) {
        this.mErrorListener.onErrorResponse(volleyError);
    }

    private void textParse(DataOutputStream dataOutputStream, Map<String, String> map, String str) throws IOException {
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                buildTextPart(dataOutputStream, entry.getKey(), entry.getValue());
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    private void dataParse(DataOutputStream dataOutputStream, Map<String, DataPart> map) throws IOException {
        for (Map.Entry<String, DataPart> entry : map.entrySet()) {
            buildDataPart(dataOutputStream, entry.getValue(), entry.getKey());
        }
    }

    private void buildTextPart(DataOutputStream dataOutputStream, String str, String str2) throws IOException {
        dataOutputStream.writeBytes("--" + this.boundary + "\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(str2.getBytes(StandardCharsets.UTF_8));
        dataOutputStream.writeBytes("\r\n");
    }

    private void buildDataPart(DataOutputStream dataOutputStream, DataPart dataPart, String str) throws IOException {
        dataOutputStream.writeBytes("--" + this.boundary + "\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + dataPart.getFileName() + "\"\r\n");
        if (dataPart.getType() != null && !dataPart.getType().trim().isEmpty()) {
            dataOutputStream.writeBytes("Content-Type: " + dataPart.getType() + "\r\n");
        }
        dataOutputStream.writeBytes("\r\n");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataPart.getContent());
        int iMin = Math.min(byteArrayInputStream.available(), 1048576);
        byte[] bArr = new byte[iMin];
        int i = byteArrayInputStream.read(bArr, 0, iMin);
        while (i > 0) {
            dataOutputStream.write(bArr, 0, iMin);
            iMin = Math.min(byteArrayInputStream.available(), 1048576);
            i = byteArrayInputStream.read(bArr, 0, iMin);
        }
        dataOutputStream.writeBytes("\r\n");
    }

    public class DataPart {
        private byte[] content;
        private String fileName;
        private String type;

        public DataPart() {
        }

        public DataPart(String str, byte[] bArr) {
            this.fileName = str;
            this.content = bArr;
        }

        public DataPart(String str, byte[] bArr, String str2) {
            this.fileName = str;
            this.content = bArr;
            this.type = str2;
        }

        public String getFileName() {
            return this.fileName;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }

        public byte[] getContent() {
            return this.content;
        }

        public void setContent(byte[] bArr) {
            this.content = bArr;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }
    }
}
