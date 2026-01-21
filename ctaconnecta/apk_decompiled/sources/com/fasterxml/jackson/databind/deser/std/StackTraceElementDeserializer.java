package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();
    private static final long serialVersionUID = 1;

    public StackTraceElementDeserializer() {
        super((Class<?>) StackTraceElement.class);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            String text = "";
            String text2 = "";
            String text3 = text2;
            int intValue = -1;
            while (true) {
                JsonToken jsonTokenNextValue = jsonParser.nextValue();
                if (jsonTokenNextValue != JsonToken.END_OBJECT) {
                    String currentName = jsonParser.getCurrentName();
                    if ("className".equals(currentName)) {
                        text = jsonParser.getText();
                    } else if ("fileName".equals(currentName)) {
                        text3 = jsonParser.getText();
                    } else if ("lineNumber".equals(currentName)) {
                        if (jsonTokenNextValue.isNumeric()) {
                            intValue = jsonParser.getIntValue();
                        } else {
                            throw JsonMappingException.from(jsonParser, "Non-numeric token (" + jsonTokenNextValue + ") for property 'lineNumber'");
                        }
                    } else if ("methodName".equals(currentName)) {
                        text2 = jsonParser.getText();
                    } else if (!"nativeMethod".equals(currentName)) {
                        handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, currentName);
                    }
                } else {
                    return new StackTraceElement(text, text2, text3, intValue);
                }
            }
        } else {
            throw deserializationContext.mappingException(this._valueClass, currentToken);
        }
    }
}
