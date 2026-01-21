package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;

@JacksonStdImpl
/* loaded from: classes3.dex */
public class ClassDeserializer extends StdScalarDeserializer<Class<?>> {
    public static final ClassDeserializer instance = new ClassDeserializer();
    private static final long serialVersionUID = 1;

    public ClassDeserializer() {
        super((Class<?>) Class.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Class<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_STRING) {
            try {
                return deserializationContext.findClass(jsonParser.getText().trim());
            } catch (Exception e) {
                throw deserializationContext.instantiationException(this._valueClass, ClassUtil.getRootCause(e));
            }
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }
}
