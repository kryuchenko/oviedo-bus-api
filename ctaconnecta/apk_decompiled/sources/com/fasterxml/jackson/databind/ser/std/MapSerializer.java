package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
/* loaded from: classes3.dex */
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final HashSet<String> _ignoredEntries;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    protected MapSerializer(HashSet<String> hashSet, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyMap();
        this._property = null;
        this._filterId = null;
    }

    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
    }

    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = obj;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public MapSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        return new MapSerializer(this, typeSerializer);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, HashSet<String> hashSet) {
        return new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, hashSet);
    }

    public MapSerializer withFilterId(Object obj) {
        return this._filterId == obj ? this : new MapSerializer(this, obj);
    }

    @Deprecated
    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2) {
        return construct(strArr, javaType, z, typeSerializer, jsonSerializer, jsonSerializer2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        JavaType keyType;
        JavaType contentType;
        boolean z2;
        HashSet<String> set = toSet(strArr);
        if (javaType == null) {
            keyType = UNSPECIFIED_TYPE;
            contentType = keyType;
        } else {
            keyType = javaType.getKeyType();
            contentType = javaType.getContentType();
        }
        if (!z) {
            z = contentType != null && contentType.isFinal();
        } else {
            if (contentType.getRawClass() == Object.class) {
                z2 = false;
            }
            MapSerializer mapSerializer = new MapSerializer(set, keyType, contentType, z2, typeSerializer, jsonSerializer, jsonSerializer2);
            return obj == null ? mapSerializer.withFilterId(obj) : mapSerializer;
        }
        z2 = z;
        MapSerializer mapSerializer2 = new MapSerializer(set, keyType, contentType, z2, typeSerializer, jsonSerializer, jsonSerializer2);
        if (obj == null) {
        }
    }

    private static HashSet<String> toSet(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>(strArr.length);
        for (String str : strArr) {
            hashSet.add(str);
        }
        return hashSet;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContextualSerializer
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerSerializerInstance;
        JsonSerializer<?> jsonSerializerHandleSecondaryContextualization;
        Object objFindFilterId;
        String[] strArrFindPropertiesToIgnore;
        AnnotatedMember member;
        JsonSerializer<Object> jsonSerializerSerializerInstance2 = null;
        if (beanProperty == null || (member = beanProperty.getMember()) == null) {
            jsonSerializerSerializerInstance = null;
        } else {
            AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
            Object objFindKeySerializer = annotationIntrospector.findKeySerializer(member);
            jsonSerializerSerializerInstance = objFindKeySerializer != null ? serializerProvider.serializerInstance(member, objFindKeySerializer) : null;
            Object objFindContentSerializer = annotationIntrospector.findContentSerializer(member);
            if (objFindContentSerializer != null) {
                jsonSerializerSerializerInstance2 = serializerProvider.serializerInstance(member, objFindContentSerializer);
            }
        }
        if (jsonSerializerSerializerInstance2 == null) {
            jsonSerializerSerializerInstance2 = this._valueSerializer;
        }
        JsonSerializer<?> jsonSerializerFindConvertingContentSerializer = findConvertingContentSerializer(serializerProvider, beanProperty, jsonSerializerSerializerInstance2);
        if (jsonSerializerFindConvertingContentSerializer == null) {
            if ((this._valueTypeIsStatic && this._valueType.getRawClass() != Object.class) || hasContentTypeAnnotation(serializerProvider, beanProperty)) {
                jsonSerializerFindConvertingContentSerializer = serializerProvider.findValueSerializer(this._valueType, beanProperty);
            }
        } else {
            jsonSerializerFindConvertingContentSerializer = serializerProvider.handleSecondaryContextualization(jsonSerializerFindConvertingContentSerializer, beanProperty);
        }
        if (jsonSerializerSerializerInstance == null) {
            jsonSerializerSerializerInstance = this._keySerializer;
        }
        if (jsonSerializerSerializerInstance == null) {
            jsonSerializerHandleSecondaryContextualization = serializerProvider.findKeySerializer(this._keyType, beanProperty);
        } else {
            jsonSerializerHandleSecondaryContextualization = serializerProvider.handleSecondaryContextualization(jsonSerializerSerializerInstance, beanProperty);
        }
        HashSet<String> hashSet = this._ignoredEntries;
        AnnotationIntrospector annotationIntrospector2 = serializerProvider.getAnnotationIntrospector();
        if (annotationIntrospector2 != null && beanProperty != null && (strArrFindPropertiesToIgnore = annotationIntrospector2.findPropertiesToIgnore(beanProperty.getMember())) != null) {
            hashSet = hashSet == null ? new HashSet<>() : new HashSet<>(hashSet);
            for (String str : strArrFindPropertiesToIgnore) {
                hashSet.add(str);
            }
        }
        MapSerializer mapSerializerWithResolved = withResolved(beanProperty, jsonSerializerHandleSecondaryContextualization, jsonSerializerFindConvertingContentSerializer, hashSet);
        return (beanProperty == null || (objFindFilterId = annotationIntrospector2.findFilterId(beanProperty.getMember())) == null) ? mapSerializerWithResolved : mapSerializerWithResolved.withFilterId(objFindFilterId);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return this._valueType;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JsonSerializer<?> getContentSerializer() {
        return this._valueSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    public JsonSerializer<?> getKeySerializer() {
        return this._keySerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        if (!map.isEmpty()) {
            Object obj = this._filterId;
            if (obj != null) {
                serializeFilteredFields(map, jsonGenerator, serializerProvider, findPropertyFilter(serializerProvider, obj, map));
                return;
            }
            if (serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map);
            }
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer != null) {
                serializeFieldsUsing(map, jsonGenerator, serializerProvider, jsonSerializer);
            } else {
                serializeFields(map, jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndObject();
    }

    @Override // com.fasterxml.jackson.databind.JsonSerializer
    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        typeSerializer.writeTypePrefixForObject(map, jsonGenerator);
        if (!map.isEmpty()) {
            if (serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map);
            }
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer != null) {
                serializeFieldsUsing(map, jsonGenerator, serializerProvider, jsonSerializer);
            } else {
                serializeFields(map, jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.writeTypeSuffixForObject(map, jsonGenerator);
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer_findAndAddDynamic;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider);
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._keySerializer;
        HashSet<String> hashSet = this._ignoredEntries;
        boolean zIsEnabled = serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (zIsEnabled || value != null) {
                if (hashSet == null || !hashSet.contains(key)) {
                    jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
                }
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerSerializerFor = propertySerializerMap.serializerFor(cls);
                if (jsonSerializerSerializerFor == null) {
                    if (this._valueType.hasGenericTypes()) {
                        jsonSerializer_findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                    } else {
                        jsonSerializer_findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                    }
                    jsonSerializerSerializerFor = jsonSerializer_findAndAddDynamic;
                    propertySerializerMap = this._dynamicValueSerializers;
                }
                try {
                    jsonSerializerSerializerFor.serialize(value, jsonGenerator, serializerProvider);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, e, map, "" + key);
                }
            }
        }
    }

    protected void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException {
        JsonSerializer<Object> jsonSerializer2 = this._keySerializer;
        HashSet<String> hashSet = this._ignoredEntries;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        boolean zIsEnabled = serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (zIsEnabled || value != null) {
                if (hashSet == null || !hashSet.contains(key)) {
                    jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
                }
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else if (typeSerializer == null) {
                try {
                    jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, e, map, "" + key);
                }
            } else {
                jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(2:35|7)(1:(2:37|(2:39|15)(2:42|40))(2:41|40))|(1:17)(2:18|(3:20|(1:22)(1:23)|24)(1:25))|26|32|27|43|40|3) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        wrapAndThrow(r13, r5, r11, "" + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter) throws IOException {
        JsonSerializer<Object> jsonSerializerFindNullKeySerializer;
        JsonSerializer<Object> defaultNullValueSerializer;
        JsonSerializer<Object> jsonSerializer_findAndAddDynamic;
        HashSet<String> hashSet = this._ignoredEntries;
        boolean zIsEnabled = serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                jsonSerializerFindNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (zIsEnabled || value != null) {
                if (hashSet == null || !hashSet.contains(key)) {
                    jsonSerializerFindNullKeySerializer = this._keySerializer;
                }
            }
            if (value == null) {
                defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
            } else {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerSerializerFor = propertySerializerMap.serializerFor(cls);
                if (jsonSerializerSerializerFor == null) {
                    if (this._valueType.hasGenericTypes()) {
                        jsonSerializer_findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                    } else {
                        jsonSerializer_findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                    }
                    defaultNullValueSerializer = jsonSerializer_findAndAddDynamic;
                    propertySerializerMap = this._dynamicValueSerializers;
                } else {
                    defaultNullValueSerializer = jsonSerializerSerializerFor;
                }
            }
            mapProperty.reset(key, value, jsonSerializerFindNullKeySerializer, defaultNullValueSerializer);
            propertyFilter.serializeAsField(map, jsonGenerator, serializerProvider, mapProperty);
        }
    }

    protected void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerFindValueSerializer;
        JsonSerializer<Object> jsonSerializer = this._keySerializer;
        HashSet<String> hashSet = this._ignoredEntries;
        boolean zIsEnabled = serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES);
        Class<?> cls = null;
        JsonSerializer<Object> jsonSerializer2 = null;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (zIsEnabled || value != null) {
                if (hashSet == null || !hashSet.contains(key)) {
                    jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
                }
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else {
                Class<?> cls2 = value.getClass();
                if (cls2 != cls) {
                    if (this._valueType.hasGenericTypes()) {
                        jsonSerializerFindValueSerializer = serializerProvider.findValueSerializer(serializerProvider.constructSpecializedType(this._valueType, cls2), this._property);
                    } else {
                        jsonSerializerFindValueSerializer = serializerProvider.findValueSerializer(cls2, this._property);
                    }
                    jsonSerializer2 = jsonSerializerFindValueSerializer;
                    cls = cls2;
                }
                try {
                    jsonSerializer2.serializeWithType(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, e, map, "" + key);
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.jsonschema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("object", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonMapFormatVisitor jsonMapFormatVisitorExpectMapFormat = jsonFormatVisitorWrapper == null ? null : jsonFormatVisitorWrapper.expectMapFormat(javaType);
        if (jsonMapFormatVisitorExpectMapFormat != null) {
            jsonMapFormatVisitorExpectMapFormat.keyFormat(this._keySerializer, this._keyType);
            JsonSerializer<Object> jsonSerializer_findAndAddDynamic = this._valueSerializer;
            if (jsonSerializer_findAndAddDynamic == null) {
                jsonSerializer_findAndAddDynamic = _findAndAddDynamic(this._dynamicValueSerializers, this._valueType, jsonFormatVisitorWrapper.getProvider());
            }
            jsonMapFormatVisitorExpectMapFormat.valueFormat(jsonSerializer_findAndAddDynamic, this._valueType);
        }
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult serializerAndMapResultFindAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        if (propertySerializerMap != serializerAndMapResultFindAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = serializerAndMapResultFindAndAddSecondarySerializer.map;
        }
        return serializerAndMapResultFindAndAddSecondarySerializer.serializer;
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult serializerAndMapResultFindAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != serializerAndMapResultFindAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = serializerAndMapResultFindAndAddSecondarySerializer.map;
        }
        return serializerAndMapResultFindAndAddSecondarySerializer.serializer;
    }

    protected Map<?, ?> _orderEntries(Map<?, ?> map) {
        return map instanceof SortedMap ? map : new TreeMap(map);
    }
}
