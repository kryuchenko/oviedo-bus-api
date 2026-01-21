package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {
    private static final long serialVersionUID = 1;

    protected abstract T _deserialize(String str, DeserializationContext deserializationContext) throws IOException;

    protected T _deserializeFromEmptyString() {
        return null;
    }

    protected FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public final T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        if (valueAsString != null) {
            if (valueAsString.length() != 0) {
                String strTrim = valueAsString.trim();
                if (strTrim.length() != 0) {
                    try {
                        T t_deserialize = _deserialize(strTrim, deserializationContext);
                        if (t_deserialize != null) {
                            return t_deserialize;
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid textual representation");
                }
            }
            return _deserializeFromEmptyString();
        }
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_EMBEDDED_OBJECT) {
            T t = (T) jsonParser.getEmbeddedObject();
            if (t == null) {
                return null;
            }
            return this._valueClass.isAssignableFrom(t.getClass()) ? t : _deserializeEmbedded(t, deserializationContext);
        }
        throw deserializationContext.mappingException(this._valueClass);
    }

    protected T _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) throws IOException {
        throw deserializationContext.mappingException("Don't know how to convert embedded Object of type " + obj.getClass().getName() + " into " + this._valueClass.getName());
    }
}
