package com.fasterxml.jackson.databind.ser.std;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    protected final DateFormat _customFormat;
    protected final boolean _useTimestamp;

    protected abstract long _timestamp(T t);

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public abstract void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public abstract DateTimeSerializerBase<T> withFormat(boolean z, DateFormat dateFormat);

    protected DateTimeSerializerBase(Class<T> cls, boolean z, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = z;
        this._customFormat = dateFormat;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value valueFindFormat;
        DateFormat iSO8601Format;
        if (beanProperty != null && (valueFindFormat = serializerProvider.getAnnotationIntrospector().findFormat(beanProperty.getMember())) != null) {
            if (valueFindFormat.getShape().isNumeric()) {
                return withFormat(true, null);
            }
            TimeZone timeZone = valueFindFormat.getTimeZone();
            String pattern = valueFindFormat.getPattern();
            if (pattern.length() > 0) {
                Locale locale = valueFindFormat.getLocale();
                if (locale == null) {
                    locale = serializerProvider.getLocale();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
                if (timeZone == null) {
                    timeZone = serializerProvider.getTimeZone();
                }
                simpleDateFormat.setTimeZone(timeZone);
                return withFormat(false, simpleDateFormat);
            }
            if (timeZone != null) {
                DateFormat dateFormat = serializerProvider.getConfig().getDateFormat();
                if (dateFormat.getClass() == StdDateFormat.class) {
                    iSO8601Format = StdDateFormat.getISO8601Format(timeZone);
                } else {
                    iSO8601Format = (DateFormat) dateFormat.clone();
                    iSO8601Format.setTimeZone(timeZone);
                }
                return withFormat(false, iSO8601Format);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(T t) {
        return t == null || _timestamp(t) == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        boolean zIsEnabled = this._useTimestamp;
        if (!zIsEnabled && this._customFormat == null) {
            zIsEnabled = serializerProvider.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        return createSchemaNode(zIsEnabled ? "number" : TypedValues.Custom.S_STRING, true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        boolean zIsEnabled = this._useTimestamp;
        if (!zIsEnabled && this._customFormat == null) {
            zIsEnabled = jsonFormatVisitorWrapper.getProvider().isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        if (zIsEnabled) {
            JsonIntegerFormatVisitor jsonIntegerFormatVisitorExpectIntegerFormat = jsonFormatVisitorWrapper.expectIntegerFormat(javaType);
            if (jsonIntegerFormatVisitorExpectIntegerFormat != null) {
                jsonIntegerFormatVisitorExpectIntegerFormat.numberType(JsonParser.NumberType.LONG);
                jsonIntegerFormatVisitorExpectIntegerFormat.format(JsonValueFormat.UTC_MILLISEC);
                return;
            }
            return;
        }
        JsonStringFormatVisitor jsonStringFormatVisitorExpectStringFormat = jsonFormatVisitorWrapper.expectStringFormat(javaType);
        if (jsonStringFormatVisitorExpectStringFormat != null) {
            jsonStringFormatVisitorExpectStringFormat.format(JsonValueFormat.DATE_TIME);
        }
    }
}
