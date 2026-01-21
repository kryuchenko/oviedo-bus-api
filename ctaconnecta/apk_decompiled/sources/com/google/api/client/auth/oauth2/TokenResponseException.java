package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

/* loaded from: classes4.dex */
public class TokenResponseException extends HttpResponseException {
    private static final long serialVersionUID = 4020689092957439244L;
    private final transient TokenErrorResponse details;

    TokenResponseException(HttpResponseException.Builder builder, TokenErrorResponse tokenErrorResponse) {
        super(builder);
        this.details = tokenErrorResponse;
    }

    public final TokenErrorResponse getDetails() {
        return this.details;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.api.client.auth.oauth2.TokenErrorResponse] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.api.client.auth.oauth2.TokenErrorResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TokenResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) {
        ?? r6;
        ?? r62;
        String asString;
        HttpResponseException.Builder builder = new HttpResponseException.Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        String contentType = httpResponse.getContentType();
        String str = null;
        try {
            if (!httpResponse.isSuccessStatusCode() && contentType != null && httpResponse.getContent() != null && HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, contentType)) {
                r6 = (TokenErrorResponse) new JsonObjectParser(jsonFactory).parseAndClose(httpResponse.getContent(), httpResponse.getContentCharset(), TokenErrorResponse.class);
                try {
                    str = r6;
                    asString = r6.toPrettyString();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    r62 = r6;
                    StringBuilder sbComputeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                    if (!Strings.isNullOrEmpty(str)) {
                    }
                    builder.setMessage(sbComputeMessageBuffer.toString());
                    return new TokenResponseException(builder, r62);
                }
            } else {
                asString = httpResponse.parseAsString();
            }
            String str2 = str;
            str = asString;
            r62 = str2;
        } catch (IOException e2) {
            e = e2;
            r6 = 0;
        }
        StringBuilder sbComputeMessageBuffer2 = HttpResponseException.computeMessageBuffer(httpResponse);
        if (!Strings.isNullOrEmpty(str)) {
            sbComputeMessageBuffer2.append(StringUtils.LINE_SEPARATOR);
            sbComputeMessageBuffer2.append(str);
            builder.setContent(str);
        }
        builder.setMessage(sbComputeMessageBuffer2.toString());
        return new TokenResponseException(builder, r62);
    }
}
