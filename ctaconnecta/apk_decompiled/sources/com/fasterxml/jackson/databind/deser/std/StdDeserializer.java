package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.maps.android.BuildConfig;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import jj2000.j2k.entropy.encoder.StdEntropyCoder;

/* loaded from: classes3.dex */
public abstract class StdDeserializer<T> extends JsonDeserializer<T> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;

    public JavaType getValueType() {
        return null;
    }

    protected StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    protected StdDeserializer(JavaType javaType) {
        this._valueClass = javaType == null ? null : javaType.getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Class<?> handledType() {
        return this._valueClass;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    protected boolean isDefaultDeserializer(JsonDeserializer<?> jsonDeserializer) {
        return ClassUtil.isJacksonStdImpl(jsonDeserializer);
    }

    protected boolean isDefaultKeyDeserializer(KeyDeserializer keyDeserializer) {
        return ClassUtil.isJacksonStdImpl(keyDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    protected final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (currentToken == JsonToken.VALUE_FALSE || currentToken == JsonToken.VALUE_NULL) {
            return false;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.getNumberType() == JsonParser.NumberType.INT) {
                return jsonParser.getIntValue() != 0;
            }
            return _parseBooleanFromNumber(jsonParser, deserializationContext);
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if ("true".equals(strTrim) || "True".equals(strTrim)) {
                return true;
            }
            if ("false".equals(strTrim) || "False".equals(strTrim) || strTrim.length() == 0 || _hasTextualNull(strTrim)) {
                return false;
            }
            throw deserializationContext.weirdStringException(strTrim, this._valueClass, "only \"true\" or \"false\" recognized");
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final Boolean _parseBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (currentToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.getNumberType() == JsonParser.NumberType.INT) {
                return jsonParser.getIntValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
            }
            return Boolean.valueOf(_parseBooleanFromNumber(jsonParser, deserializationContext));
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Boolean) getNullValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if ("true".equals(strTrim) || "True".equals(strTrim)) {
                return Boolean.TRUE;
            }
            if ("false".equals(strTrim) || "False".equals(strTrim)) {
                return Boolean.FALSE;
            }
            if (strTrim.length() == 0) {
                return (Boolean) getEmptyValue();
            }
            if (_hasTextualNull(strTrim)) {
                return (Boolean) getNullValue();
            }
            throw deserializationContext.weirdStringException(strTrim, this._valueClass, "only \"true\" or \"false\" recognized");
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final boolean _parseBooleanFromNumber(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.getNumberType() == JsonParser.NumberType.LONG) {
            return (jsonParser.getLongValue() == 0 ? Boolean.FALSE : Boolean.TRUE).booleanValue();
        }
        String text = jsonParser.getText();
        if (IdManager.DEFAULT_VERSION_NAME.equals(text) || StdEntropyCoder.DEF_THREADS_NUM.equals(text)) {
            return Boolean.FALSE.booleanValue();
        }
        return Boolean.TRUE.booleanValue();
    }

    protected Byte _parseByte(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Byte.valueOf(jsonParser.getByteValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (_hasTextualNull(strTrim)) {
                return (Byte) getNullValue();
            }
            try {
                if (strTrim.length() == 0) {
                    return (Byte) getEmptyValue();
                }
                int i = NumberInput.parseInt(strTrim);
                if (i < -128 || i > 255) {
                    throw deserializationContext.weirdStringException(strTrim, this._valueClass, "overflow, value can not be represented as 8-bit value");
                }
                return Byte.valueOf((byte) i);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Byte value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Byte) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Short.valueOf(jsonParser.getShortValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            try {
                if (strTrim.length() == 0) {
                    return (Short) getEmptyValue();
                }
                if (_hasTextualNull(strTrim)) {
                    return (Short) getNullValue();
                }
                int i = NumberInput.parseInt(strTrim);
                if (i < -32768 || i > 32767) {
                    throw deserializationContext.weirdStringException(strTrim, this._valueClass, "overflow, value can not be represented as 16-bit value");
                }
                return Short.valueOf((short) i);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Short value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Short) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws NumberFormatException, IOException {
        int i_parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (i_parseIntPrimitive < -32768 || i_parseIntPrimitive > 32767) {
            throw deserializationContext.weirdStringException(String.valueOf(i_parseIntPrimitive), this._valueClass, "overflow, value can not be represented as 16-bit value");
        }
        return (short) i_parseIntPrimitive;
    }

    protected final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws NumberFormatException, IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getIntValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (_hasTextualNull(strTrim)) {
                return 0;
            }
            try {
                int length = strTrim.length();
                if (length <= 9) {
                    if (length == 0) {
                        return 0;
                    }
                    return NumberInput.parseInt(strTrim);
                }
                long j = Long.parseLong(strTrim);
                if (j >= -2147483648L && j <= 2147483647L) {
                    return (int) j;
                }
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "Overflow: numeric value (" + strTrim + ") out of range of int (-2147483648 - 2147483647)");
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid int value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return 0;
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final Integer _parseInteger(JsonParser jsonParser, DeserializationContext deserializationContext) throws NumberFormatException, IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Integer.valueOf(jsonParser.getIntValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            try {
                int length = strTrim.length();
                if (_hasTextualNull(strTrim)) {
                    return (Integer) getNullValue();
                }
                if (length <= 9) {
                    if (length == 0) {
                        return (Integer) getEmptyValue();
                    }
                    return Integer.valueOf(NumberInput.parseInt(strTrim));
                }
                long j = Long.parseLong(strTrim);
                if (j < -2147483648L || j > 2147483647L) {
                    throw deserializationContext.weirdStringException(strTrim, this._valueClass, "Overflow: numeric value (" + strTrim + ") out of range of Integer (-2147483648 - 2147483647)");
                }
                return Integer.valueOf((int) j);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Integer value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Integer) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final Long _parseLong(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Long.valueOf(jsonParser.getLongValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0) {
                return (Long) getEmptyValue();
            }
            if (_hasTextualNull(strTrim)) {
                return (Long) getNullValue();
            }
            try {
                return Long.valueOf(NumberInput.parseLong(strTrim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Long value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Long) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getLongValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0 || _hasTextualNull(strTrim)) {
                return 0L;
            }
            try {
                return NumberInput.parseLong(strTrim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid long value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return 0L;
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.getFloatValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0) {
                return (Float) getEmptyValue();
            }
            if (_hasTextualNull(strTrim)) {
                return (Float) getNullValue();
            }
            char cCharAt = strTrim.charAt(0);
            if (cCharAt != '-') {
                if (cCharAt == 'I') {
                    if ("Infinity".equals(strTrim) || "INF".equals(strTrim)) {
                        return Float.valueOf(Float.POSITIVE_INFINITY);
                    }
                } else if (cCharAt == 'N' && "NaN".equals(strTrim)) {
                    return Float.valueOf(Float.NaN);
                }
            } else if ("-Infinity".equals(strTrim) || "-INF".equals(strTrim)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            try {
                return Float.valueOf(Float.parseFloat(strTrim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Float value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Float) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getFloatValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0 || _hasTextualNull(strTrim)) {
                return 0.0f;
            }
            char cCharAt = strTrim.charAt(0);
            if (cCharAt != '-') {
                if (cCharAt == 'I') {
                    if (_isPosInf(strTrim)) {
                        return Float.POSITIVE_INFINITY;
                    }
                } else if (cCharAt == 'N' && _isNaN(strTrim)) {
                    return Float.NaN;
                }
            } else if (_isNegInf(strTrim)) {
                return Float.NEGATIVE_INFINITY;
            }
            try {
                return Float.parseFloat(strTrim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid float value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return 0.0f;
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.getDoubleValue());
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0) {
                return (Double) getEmptyValue();
            }
            if (_hasTextualNull(strTrim)) {
                return (Double) getNullValue();
            }
            char cCharAt = strTrim.charAt(0);
            if (cCharAt != '-') {
                if (cCharAt == 'I') {
                    if (_isPosInf(strTrim)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                } else if (cCharAt == 'N' && _isNaN(strTrim)) {
                    return Double.valueOf(Double.NaN);
                }
            } else if (_isNegInf(strTrim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            try {
                return Double.valueOf(parseDouble(strTrim));
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid Double value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Double) getNullValue();
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getDoubleValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            String strTrim = jsonParser.getText().trim();
            if (strTrim.length() == 0 || _hasTextualNull(strTrim)) {
                return 0.0d;
            }
            char cCharAt = strTrim.charAt(0);
            if (cCharAt != '-') {
                if (cCharAt == 'I') {
                    if (_isPosInf(strTrim)) {
                        return Double.POSITIVE_INFINITY;
                    }
                } else if (cCharAt == 'N' && _isNaN(strTrim)) {
                    return Double.NaN;
                }
            } else if (_isNegInf(strTrim)) {
                return Double.NEGATIVE_INFINITY;
            }
            try {
                return parseDouble(strTrim);
            } catch (IllegalArgumentException unused) {
                throw deserializationContext.weirdStringException(strTrim, this._valueClass, "not a valid double value");
            }
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return 0.0d;
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jsonParser.getLongValue());
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return (Date) getNullValue();
        }
        if (currentToken == JsonToken.VALUE_STRING) {
            try {
                String strTrim = jsonParser.getText().trim();
                if (strTrim.length() == 0) {
                    return (Date) getEmptyValue();
                }
                if (_hasTextualNull(strTrim)) {
                    return (Date) getNullValue();
                }
                return deserializationContext.parseDate(strTrim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(null, this._valueClass, "not a valid representation (error: " + e.getMessage() + ")");
            }
        }
        throw deserializationContext.mappingException(this._valueClass, currentToken);
    }

    protected static final double parseDouble(String str) throws NumberFormatException {
        if (NumberInput.NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    protected final String _parseString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String valueAsString = jsonParser.getValueAsString();
        if (valueAsString != null) {
            return valueAsString;
        }
        throw deserializationContext.mappingException(String.class, jsonParser.getCurrentToken());
    }

    protected boolean _hasTextualNull(String str) {
        return BuildConfig.TRAVIS.equals(str);
    }

    protected final boolean _isNegInf(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    protected final boolean _isPosInf(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    protected final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    protected JsonDeserializer<Object> findDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return deserializationContext.findContextualValueDeserializer(javaType, beanProperty);
    }

    protected JsonDeserializer<?> findConvertingContentDeserializer(DeserializationContext deserializationContext, BeanProperty beanProperty, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Object objFindDeserializationContentConverter;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || beanProperty == null || (objFindDeserializationContentConverter = annotationIntrospector.findDeserializationContentConverter(beanProperty.getMember())) == null) {
            return jsonDeserializer;
        }
        Converter<Object, Object> converterConverterInstance = deserializationContext.converterInstance(beanProperty.getMember(), objFindDeserializationContentConverter);
        JavaType inputType = converterConverterInstance.getInputType(deserializationContext.getTypeFactory());
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.findContextualValueDeserializer(inputType, beanProperty);
        }
        return new StdDelegatingDeserializer(converterConverterInstance, inputType, jsonDeserializer);
    }

    protected void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (obj == null) {
            obj = handledType();
        }
        if (deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            return;
        }
        deserializationContext.reportUnknownProperty(obj, str, this);
        jsonParser.skipChildren();
    }
}
