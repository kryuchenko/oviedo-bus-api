package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

/* loaded from: classes3.dex */
public class JavaTypeDeserializer extends StdScalarDeserializer<JavaType> {
    public static final JavaTypeDeserializer instance = new JavaTypeDeserializer();
    private static final long serialVersionUID = 1;

    public JavaTypeDeserializer() {
        super((Class<?>) JavaType.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public JavaType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0) {
                return getEmptyValue();
            }
            return deserializationContext.getTypeFactory().constructFromCanonical(strTrim);
        }
        if (currentToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return (JavaType) jsonParser.getEmbeddedObject();
        }
        throw deserializationContext.mappingException(this._valueClass);
    }
}
