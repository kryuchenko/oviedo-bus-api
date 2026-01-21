package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import com.google.firebase.messaging.Constants;
import java.io.IOException;

/* loaded from: classes4.dex */
public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;
    private final transient GoogleJsonError details;

    public GoogleJsonResponseException(HttpResponseException.Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.details = googleJsonError;
    }

    public final GoogleJsonError getDetails() {
        return this.details;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00af A[Catch: IOException -> 0x009a, TryCatch #0 {IOException -> 0x009a, blocks: (B:53:0x00ab, B:55:0x00b2, B:54:0x00af, B:44:0x0096, B:48:0x00a0), top: B:66:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3 A[Catch: IOException -> 0x00b8, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00b8, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0027, B:56:0x00b3), top: B:67:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.api.client.googleapis.json.GoogleJsonError] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GoogleJsonResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) throws Throwable {
        String asString;
        JsonParser jsonParserCreateJsonParser;
        GoogleJsonError googleJsonError;
        HttpResponseException.Builder builder = new HttpResponseException.Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            if (!httpResponse.isSuccessStatusCode()) {
                String contentType = httpResponse.getContentType();
                if (HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, contentType)) {
                    try {
                        if (httpResponse.getContent() != null) {
                            try {
                                jsonParserCreateJsonParser = jsonFactory.createJsonParser(httpResponse.getContent());
                                try {
                                    JsonToken currentToken = jsonParserCreateJsonParser.getCurrentToken();
                                    if (currentToken == null) {
                                        currentToken = jsonParserCreateJsonParser.nextToken();
                                    }
                                    if (currentToken != null) {
                                        jsonParserCreateJsonParser.skipToKey(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                                        if (jsonParserCreateJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                                            asString = jsonParserCreateJsonParser.getText();
                                        } else if (jsonParserCreateJsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                                            GoogleJsonError googleJsonError2 = (GoogleJsonError) jsonParserCreateJsonParser.parseAndClose(GoogleJsonError.class);
                                            try {
                                                asString = googleJsonError2.toPrettyString();
                                                r1 = googleJsonError2;
                                            } catch (IOException e) {
                                                googleJsonError = googleJsonError2;
                                                e = e;
                                                try {
                                                    e.printStackTrace();
                                                    if (jsonParserCreateJsonParser == null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    asString = null;
                                                    r1 = googleJsonError;
                                                    StringBuilder sbComputeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                                    if (!Strings.isNullOrEmpty(asString)) {
                                                    }
                                                    builder.setMessage(sbComputeMessageBuffer.toString());
                                                    return new GoogleJsonResponseException(builder, r1);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (jsonParserCreateJsonParser != null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                googleJsonError = googleJsonError2;
                                                th = th2;
                                                if (jsonParserCreateJsonParser != null) {
                                                }
                                                throw th;
                                            }
                                        } else {
                                            asString = null;
                                        }
                                        try {
                                            if (jsonParserCreateJsonParser == null) {
                                                httpResponse.ignore();
                                            } else if (r1 == 0) {
                                                jsonParserCreateJsonParser.close();
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            r1 = r1;
                                            e.printStackTrace();
                                            StringBuilder sbComputeMessageBuffer2 = HttpResponseException.computeMessageBuffer(httpResponse);
                                            if (!Strings.isNullOrEmpty(asString)) {
                                            }
                                            builder.setMessage(sbComputeMessageBuffer2.toString());
                                            return new GoogleJsonResponseException(builder, r1);
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    googleJsonError = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    googleJsonError = null;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            } catch (Throwable th4) {
                                th = th4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            }
                        } else {
                            asString = httpResponse.parseAsString();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        asString = null;
                        r1 = contentType;
                    }
                }
            }
        } catch (IOException e6) {
            e = e6;
            asString = null;
        }
        StringBuilder sbComputeMessageBuffer22 = HttpResponseException.computeMessageBuffer(httpResponse);
        if (!Strings.isNullOrEmpty(asString)) {
            sbComputeMessageBuffer22.append(StringUtils.LINE_SEPARATOR);
            sbComputeMessageBuffer22.append(asString);
            builder.setContent(asString);
        }
        builder.setMessage(sbComputeMessageBuffer22.toString());
        return new GoogleJsonResponseException(builder, r1);
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest httpRequest) throws IOException {
        Preconditions.checkNotNull(jsonFactory);
        boolean throwExceptionOnExecuteError = httpRequest.getThrowExceptionOnExecuteError();
        if (throwExceptionOnExecuteError) {
            httpRequest.setThrowExceptionOnExecuteError(false);
        }
        HttpResponse httpResponseExecute = httpRequest.execute();
        httpRequest.setThrowExceptionOnExecuteError(throwExceptionOnExecuteError);
        if (!throwExceptionOnExecuteError || httpResponseExecute.isSuccessStatusCode()) {
            return httpResponseExecute;
        }
        throw from(jsonFactory, httpResponseExecute);
    }
}
