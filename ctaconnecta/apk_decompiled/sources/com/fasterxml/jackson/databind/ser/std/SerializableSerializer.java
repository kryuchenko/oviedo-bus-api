package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

@JacksonStdImpl
/* loaded from: classes3.dex */
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
    public static final SerializableSerializer instance = new SerializableSerializer();
    private static final AtomicReference<ObjectMapper> _mapperReference = new AtomicReference<>();

    protected SerializableSerializer() {
        super(JsonSerializable.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonSerializable.serialize(jsonGenerator, serializerProvider);
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public final void serializeWithType(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonSerializable.serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        String strSchemaType;
        String strSchemaItemDefinition;
        ObjectNode objectNodeCreateObjectNode = createObjectNode();
        if (type != null) {
            Class<?> clsRawClass = TypeFactory.rawClass(type);
            if (clsRawClass.isAnnotationPresent(JsonSerializableSchema.class)) {
                JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) clsRawClass.getAnnotation(JsonSerializableSchema.class);
                strSchemaType = jsonSerializableSchema.schemaType();
                String strSchemaObjectPropertiesDefinition = !JsonSerializableSchema.NO_VALUE.equals(jsonSerializableSchema.schemaObjectPropertiesDefinition()) ? jsonSerializableSchema.schemaObjectPropertiesDefinition() : null;
                strSchemaItemDefinition = JsonSerializableSchema.NO_VALUE.equals(jsonSerializableSchema.schemaItemDefinition()) ? null : jsonSerializableSchema.schemaItemDefinition();
                str = strSchemaObjectPropertiesDefinition;
            } else {
                strSchemaType = "any";
                strSchemaItemDefinition = null;
            }
        }
        objectNodeCreateObjectNode.put("type", strSchemaType);
        if (str != null) {
            try {
                objectNodeCreateObjectNode.put("properties", _getObjectMapper().readTree(str));
            } catch (IOException unused) {
                throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaObjectPropertiesDefinition value");
            }
        }
        if (strSchemaItemDefinition == null) {
            return objectNodeCreateObjectNode;
        }
        try {
            objectNodeCreateObjectNode.put(FirebaseAnalytics.Param.ITEMS, _getObjectMapper().readTree(strSchemaItemDefinition));
            return objectNodeCreateObjectNode;
        } catch (IOException unused2) {
            throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaItemDefinition value");
        }
    }

    private static final synchronized ObjectMapper _getObjectMapper() {
        ObjectMapper objectMapper;
        AtomicReference<ObjectMapper> atomicReference = _mapperReference;
        objectMapper = atomicReference.get();
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            atomicReference.set(objectMapper);
        }
        return objectMapper;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        jsonFormatVisitorWrapper.expectAnyFormat(javaType);
    }
}
