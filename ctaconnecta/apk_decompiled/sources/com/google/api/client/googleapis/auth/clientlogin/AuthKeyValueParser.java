package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes4.dex */
final class AuthKeyValueParser implements ObjectParser {
    public static final AuthKeyValueParser INSTANCE = new AuthKeyValueParser();

    public String getContentType() {
        return "text/plain";
    }

    public <T> T parse(HttpResponse httpResponse, Class<T> cls) throws IOException {
        httpResponse.setContentLoggingLimit(0);
        InputStream content = httpResponse.getContent();
        try {
            return (T) parse(content, cls);
        } finally {
            content.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T parse(InputStream inputStream, Class<T> cls) throws IllegalAccessException, IOException, IllegalArgumentException {
        ClassInfo classInfoOf = ClassInfo.of(cls);
        T t = (T) Types.newInstance(cls);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return t;
            }
            int iIndexOf = line.indexOf(61);
            String strSubstring = line.substring(0, iIndexOf);
            String strSubstring2 = line.substring(iIndexOf + 1);
            Field field = classInfoOf.getField(strSubstring);
            if (field != null) {
                Class<?> type = field.getType();
                if (type != Boolean.TYPE) {
                    Object objValueOf = strSubstring2;
                    if (type == Boolean.class) {
                        objValueOf = Boolean.valueOf(strSubstring2);
                    }
                    FieldInfo.setFieldValue(field, t, objValueOf);
                }
            } else if (GenericData.class.isAssignableFrom(cls)) {
                ((GenericData) t).set(strSubstring, strSubstring2);
            } else if (Map.class.isAssignableFrom(cls)) {
                ((Map) t).put(strSubstring, strSubstring2);
            }
        }
    }

    private AuthKeyValueParser() {
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) parseAndClose((Reader) new InputStreamReader(inputStream, charset), (Class) cls);
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:2:0x0000, B:3:0x000d, B:8:0x0019, B:10:0x002e, B:15:0x003e, B:14:0x003a, B:16:0x0042, B:18:0x004a, B:19:0x0051, B:21:0x0059), top: B:26:0x0000 }] */
    @Override // com.google.api.client.util.ObjectParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T parseAndClose(Reader reader, Class<T> cls) throws IOException {
        try {
            ClassInfo classInfoOf = ClassInfo.of(cls);
            T t = (T) Types.newInstance(cls);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return t;
                }
                int iIndexOf = line.indexOf(61);
                String strSubstring = line.substring(0, iIndexOf);
                String strSubstring2 = line.substring(iIndexOf + 1);
                Field field = classInfoOf.getField(strSubstring);
                if (field != null) {
                    Class<?> type = field.getType();
                    if (type != Boolean.TYPE) {
                        Object objValueOf = strSubstring2;
                        if (type == Boolean.class) {
                            objValueOf = Boolean.valueOf(strSubstring2);
                        }
                        FieldInfo.setFieldValue(field, t, objValueOf);
                    }
                } else if (GenericData.class.isAssignableFrom(cls)) {
                    ((GenericData) t).set(strSubstring, strSubstring2);
                } else if (Map.class.isAssignableFrom(cls)) {
                    ((Map) t).put(strSubstring, strSubstring2);
                }
            }
        } finally {
            reader.close();
        }
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(Reader reader, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }
}
