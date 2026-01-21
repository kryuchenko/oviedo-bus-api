package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumMapSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdContainerSerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class BasicSerializerFactory extends SerializerFactory implements Serializable {
    protected static final HashMap<String, JsonSerializer<?>> _concrete;
    protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy;
    protected final SerializerFactoryConfig _factoryConfig;

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public abstract JsonSerializer<Object> createSerializer(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException;

    protected abstract Iterable<Serializers> customSerializers();

    public abstract SerializerFactory withConfig(SerializerFactoryConfig serializerFactoryConfig);

    static {
        HashMap<String, JsonSerializer<?>> map = new HashMap<>();
        _concrete = map;
        HashMap<String, Class<? extends JsonSerializer<?>>> map2 = new HashMap<>();
        _concreteLazy = map2;
        map.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        map.put(StringBuffer.class.getName(), toStringSerializer);
        map.put(StringBuilder.class.getName(), toStringSerializer);
        map.put(Character.class.getName(), toStringSerializer);
        map.put(Character.TYPE.getName(), toStringSerializer);
        NumberSerializers.addAll(map);
        map.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        map.put(Boolean.class.getName(), new BooleanSerializer(false));
        NumberSerializers.NumberSerializer numberSerializer = new NumberSerializers.NumberSerializer();
        map.put(BigInteger.class.getName(), numberSerializer);
        map.put(BigDecimal.class.getName(), numberSerializer);
        map.put(Calendar.class.getName(), CalendarSerializer.instance);
        DateSerializer dateSerializer = DateSerializer.instance;
        map.put(Date.class.getName(), dateSerializer);
        map.put(Timestamp.class.getName(), dateSerializer);
        map2.put(java.sql.Date.class.getName(), SqlDateSerializer.class);
        map2.put(Time.class.getName(), SqlTimeSerializer.class);
        for (Map.Entry<Class<?>, Object> entry : StdJdkSerializers.all()) {
            Object value = entry.getValue();
            if (value instanceof JsonSerializer) {
                _concrete.put(entry.getKey().getName(), (JsonSerializer) value);
            } else if (value instanceof Class) {
                _concreteLazy.put(entry.getKey().getName(), (Class) value);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + entry.getClass().getName());
            }
        }
        _concreteLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
    }

    protected BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        this._factoryConfig = serializerFactoryConfig == null ? new SerializerFactoryConfig() : serializerFactoryConfig;
    }

    public SerializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withAdditionalSerializers(Serializers serializers) {
        return withConfig(this._factoryConfig.withAdditionalSerializers(serializers));
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withAdditionalKeySerializers(Serializers serializers) {
        return withConfig(this._factoryConfig.withAdditionalKeySerializers(serializers));
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withSerializerModifier(BeanSerializerModifier beanSerializerModifier) {
        return withConfig(this._factoryConfig.withSerializerModifier(beanSerializerModifier));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public JsonSerializer<Object> createKeySerializer(SerializationConfig serializationConfig, JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        BeanDescription beanDescriptionIntrospectClassAnnotations = serializationConfig.introspectClassAnnotations(javaType.getRawClass());
        JsonSerializer<?> jsonSerializerFindSerializer = null;
        if (this._factoryConfig.hasKeySerializers()) {
            Iterator<Serializers> it = this._factoryConfig.keySerializers().iterator();
            while (it.hasNext() && (jsonSerializerFindSerializer = it.next().findSerializer(serializationConfig, javaType, beanDescriptionIntrospectClassAnnotations)) == null) {
            }
        }
        if (jsonSerializerFindSerializer != null) {
            jsonSerializer = jsonSerializerFindSerializer;
        } else if (jsonSerializer == null) {
            jsonSerializer = StdKeySerializers.getStdKeySerializer(javaType);
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonSerializer = it2.next().modifyKeySerializer(serializationConfig, javaType, beanDescriptionIntrospectClassAnnotations, jsonSerializer);
            }
        }
        return jsonSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public TypeSerializer createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType) {
        Collection<NamedType> collectionCollectAndResolveSubtypes;
        AnnotatedClass classInfo = serializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> typeResolverBuilderFindTypeResolver = annotationIntrospector.findTypeResolver(serializationConfig, classInfo, javaType);
        if (typeResolverBuilderFindTypeResolver == null) {
            typeResolverBuilderFindTypeResolver = serializationConfig.getDefaultTyper(javaType);
            collectionCollectAndResolveSubtypes = null;
        } else {
            collectionCollectAndResolveSubtypes = serializationConfig.getSubtypeResolver().collectAndResolveSubtypes(classInfo, serializationConfig, annotationIntrospector);
        }
        if (typeResolverBuilderFindTypeResolver == null) {
            return null;
        }
        return typeResolverBuilderFindTypeResolver.buildTypeSerializer(serializationConfig, javaType, collectionCollectAndResolveSubtypes);
    }

    protected final JsonSerializer<?> findSerializerByLookup(JavaType javaType, SerializationConfig serializationConfig, BeanDescription beanDescription, boolean z) {
        Class<? extends JsonSerializer<?>> cls;
        String name = javaType.getRawClass().getName();
        JsonSerializer<?> jsonSerializer = _concrete.get(name);
        if (jsonSerializer != null || (cls = _concreteLazy.get(name)) == null) {
            return jsonSerializer;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate standard serializer (of type " + cls.getName() + "): " + e.getMessage(), e);
        }
    }

    protected final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        if (JsonSerializable.class.isAssignableFrom(javaType.getRawClass())) {
            return SerializableSerializer.instance;
        }
        AnnotatedMethod annotatedMethodFindJsonValueMethod = beanDescription.findJsonValueMethod();
        if (annotatedMethodFindJsonValueMethod == null) {
            return null;
        }
        Method annotated = annotatedMethodFindJsonValueMethod.getAnnotated();
        if (serializerProvider.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotated);
        }
        return new JsonValueSerializer(annotated, findSerializerFromAnnotation(serializerProvider, annotatedMethodFindJsonValueMethod));
    }

    protected final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        JsonSerializer<?> jsonSerializerFindOptionalStdSerializer = findOptionalStdSerializer(serializerProvider, javaType, beanDescription, z);
        if (jsonSerializerFindOptionalStdSerializer != null) {
            return jsonSerializerFindOptionalStdSerializer;
        }
        if (Calendar.class.isAssignableFrom(rawClass)) {
            return CalendarSerializer.instance;
        }
        if (Date.class.isAssignableFrom(rawClass)) {
            return DateSerializer.instance;
        }
        if (ByteBuffer.class.isAssignableFrom(rawClass)) {
            return ByteBufferSerializer.instance;
        }
        if (InetAddress.class.isAssignableFrom(rawClass)) {
            return InetAddressSerializer.instance;
        }
        if (InetSocketAddress.class.isAssignableFrom(rawClass)) {
            return InetSocketAddressSerializer.instance;
        }
        if (TimeZone.class.isAssignableFrom(rawClass)) {
            return TimeZoneSerializer.instance;
        }
        if (Charset.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        if (Number.class.isAssignableFrom(rawClass)) {
            return NumberSerializers.NumberSerializer.instance;
        }
        if (Enum.class.isAssignableFrom(rawClass)) {
            return buildEnumSerializer(serializerProvider.getConfig(), javaType, beanDescription);
        }
        return null;
    }

    protected JsonSerializer<?> findOptionalStdSerializer(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findSerializer(serializerProvider.getConfig(), javaType, beanDescription);
    }

    protected final JsonSerializer<?> findSerializerByAddonType(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (Iterator.class.isAssignableFrom(rawClass)) {
            return buildIteratorSerializer(serializationConfig, javaType, beanDescription, z);
        }
        if (Iterable.class.isAssignableFrom(rawClass)) {
            return buildIterableSerializer(serializationConfig, javaType, beanDescription, z);
        }
        if (CharSequence.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        return null;
    }

    protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objFindSerializer = serializerProvider.getAnnotationIntrospector().findSerializer(annotated);
        if (objFindSerializer == null) {
            return null;
        }
        return findConvertingSerializer(serializerProvider, annotated, serializerProvider.serializerInstance(annotated, objFindSerializer));
    }

    protected JsonSerializer<?> findConvertingSerializer(SerializerProvider serializerProvider, Annotated annotated, JsonSerializer<?> jsonSerializer) throws JsonMappingException {
        Converter<Object, Object> converterFindConverter = findConverter(serializerProvider, annotated);
        return converterFindConverter == null ? jsonSerializer : new StdDelegatingSerializer(converterFindConverter, converterFindConverter.getOutputType(serializerProvider.getTypeFactory()), jsonSerializer);
    }

    protected Converter<Object, Object> findConverter(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objFindSerializationConverter = serializerProvider.getAnnotationIntrospector().findSerializationConverter(annotated);
        if (objFindSerializationConverter == null) {
            return null;
        }
        return serializerProvider.converterInstance(annotated, objFindSerializationConverter);
    }

    @Deprecated
    protected final JsonSerializer<?> buildContainerSerializer(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, BeanProperty beanProperty, boolean z) throws JsonMappingException {
        return buildContainerSerializer(serializerProvider, javaType, beanDescription, z);
    }

    protected JsonSerializer<?> buildContainerSerializer(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        SerializationConfig config = serializerProvider.getConfig();
        if (!z && javaType.useStaticType() && (!javaType.isContainerType() || javaType.getContentType().getRawClass() != Object.class)) {
            z = true;
        }
        TypeSerializer typeSerializerCreateTypeSerializer = createTypeSerializer(config, javaType.getContentType());
        boolean z2 = typeSerializerCreateTypeSerializer != null ? false : z;
        JsonSerializer<Object> jsonSerializer_findContentSerializer = _findContentSerializer(serializerProvider, beanDescription.getClassInfo());
        if (javaType.isMapLikeType()) {
            MapLikeType mapLikeType = (MapLikeType) javaType;
            JsonSerializer<Object> jsonSerializer_findKeySerializer = _findKeySerializer(serializerProvider, beanDescription.getClassInfo());
            if (mapLikeType.isTrueMapType()) {
                return buildMapSerializer(config, (MapType) mapLikeType, beanDescription, z2, jsonSerializer_findKeySerializer, typeSerializerCreateTypeSerializer, jsonSerializer_findContentSerializer);
            }
            Iterator<Serializers> it = customSerializers().iterator();
            while (it.hasNext()) {
                JsonSerializer<?> jsonSerializerFindMapLikeSerializer = it.next().findMapLikeSerializer(config, mapLikeType, beanDescription, jsonSerializer_findKeySerializer, typeSerializerCreateTypeSerializer, jsonSerializer_findContentSerializer);
                if (jsonSerializerFindMapLikeSerializer != null) {
                    if (this._factoryConfig.hasSerializerModifiers()) {
                        Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
                        while (it2.hasNext()) {
                            jsonSerializerFindMapLikeSerializer = it2.next().modifyMapLikeSerializer(config, mapLikeType, beanDescription, jsonSerializerFindMapLikeSerializer);
                        }
                    }
                    return jsonSerializerFindMapLikeSerializer;
                }
            }
            return null;
        }
        if (javaType.isCollectionLikeType()) {
            CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
            if (collectionLikeType.isTrueCollectionType()) {
                return buildCollectionSerializer(config, (CollectionType) collectionLikeType, beanDescription, z2, typeSerializerCreateTypeSerializer, jsonSerializer_findContentSerializer);
            }
            Iterator<Serializers> it3 = customSerializers().iterator();
            while (it3.hasNext()) {
                TypeSerializer typeSerializer = typeSerializerCreateTypeSerializer;
                JsonSerializer<?> jsonSerializerFindCollectionLikeSerializer = it3.next().findCollectionLikeSerializer(config, collectionLikeType, beanDescription, typeSerializer, jsonSerializer_findContentSerializer);
                typeSerializerCreateTypeSerializer = typeSerializer;
                if (jsonSerializerFindCollectionLikeSerializer != null) {
                    if (this._factoryConfig.hasSerializerModifiers()) {
                        Iterator<BeanSerializerModifier> it4 = this._factoryConfig.serializerModifiers().iterator();
                        while (it4.hasNext()) {
                            jsonSerializerFindCollectionLikeSerializer = it4.next().modifyCollectionLikeSerializer(config, collectionLikeType, beanDescription, jsonSerializerFindCollectionLikeSerializer);
                        }
                    }
                    return jsonSerializerFindCollectionLikeSerializer;
                }
            }
            return null;
        }
        if (javaType.isArrayType()) {
            return buildArraySerializer(config, (ArrayType) javaType, beanDescription, z2, typeSerializerCreateTypeSerializer, jsonSerializer_findContentSerializer);
        }
        return null;
    }

    @Deprecated
    protected final JsonSerializer<?> buildCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, BeanProperty beanProperty, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) throws JsonMappingException {
        return buildCollectionSerializer(serializationConfig, collectionType, beanDescription, z, typeSerializer, jsonSerializer);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected JsonSerializer<?> buildCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) throws JsonMappingException {
        SerializationConfig serializationConfig2;
        CollectionType collectionType2;
        BeanDescription beanDescription2;
        TypeSerializer typeSerializer2;
        JsonSerializer<Object> jsonSerializer2;
        JsonSerializer<?> jsonSerializerIndexedListSerializer;
        Iterator<Serializers> it = customSerializers().iterator();
        JsonSerializer<?> jsonSerializerModifyCollectionSerializer = null;
        while (true) {
            if (!it.hasNext()) {
                serializationConfig2 = serializationConfig;
                collectionType2 = collectionType;
                beanDescription2 = beanDescription;
                typeSerializer2 = typeSerializer;
                jsonSerializer2 = jsonSerializer;
                break;
            }
            serializationConfig2 = serializationConfig;
            collectionType2 = collectionType;
            beanDescription2 = beanDescription;
            typeSerializer2 = typeSerializer;
            jsonSerializer2 = jsonSerializer;
            jsonSerializerModifyCollectionSerializer = it.next().findCollectionSerializer(serializationConfig2, collectionType2, beanDescription2, typeSerializer2, jsonSerializer2);
            if (jsonSerializerModifyCollectionSerializer != null) {
                break;
            }
            serializationConfig = serializationConfig2;
            collectionType = collectionType2;
            beanDescription = beanDescription2;
            typeSerializer = typeSerializer2;
            jsonSerializer = jsonSerializer2;
        }
        if (jsonSerializerModifyCollectionSerializer == null) {
            JsonFormat.Value valueFindExpectedFormat = beanDescription2.findExpectedFormat(null);
            if (valueFindExpectedFormat != null && valueFindExpectedFormat.getShape() == JsonFormat.Shape.OBJECT) {
                return null;
            }
            Class<?> rawClass = collectionType2.getRawClass();
            if (EnumSet.class.isAssignableFrom(rawClass)) {
                JavaType contentType = collectionType2.getContentType();
                jsonSerializerModifyCollectionSerializer = StdContainerSerializers.enumSetSerializer(contentType.isEnumType() ? contentType : null);
            } else {
                Class<?> rawClass2 = collectionType2.getContentType().getRawClass();
                if (isIndexedList(rawClass)) {
                    if (rawClass2 == String.class) {
                        if (jsonSerializer2 == null || ClassUtil.isJacksonStdImpl(jsonSerializer2)) {
                            jsonSerializerIndexedListSerializer = IndexedStringListSerializer.instance;
                        }
                        if (jsonSerializerModifyCollectionSerializer == null) {
                            jsonSerializerModifyCollectionSerializer = StdContainerSerializers.collectionSerializer(collectionType2.getContentType(), z, typeSerializer2, jsonSerializer2);
                        }
                    } else {
                        jsonSerializerIndexedListSerializer = StdContainerSerializers.indexedListSerializer(collectionType2.getContentType(), z, typeSerializer2, jsonSerializer2);
                    }
                    jsonSerializerModifyCollectionSerializer = jsonSerializerIndexedListSerializer;
                    if (jsonSerializerModifyCollectionSerializer == null) {
                    }
                } else {
                    if (rawClass2 == String.class && (jsonSerializer2 == null || ClassUtil.isJacksonStdImpl(jsonSerializer2))) {
                        jsonSerializerIndexedListSerializer = StringCollectionSerializer.instance;
                        jsonSerializerModifyCollectionSerializer = jsonSerializerIndexedListSerializer;
                    }
                    if (jsonSerializerModifyCollectionSerializer == null) {
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonSerializerModifyCollectionSerializer = it2.next().modifyCollectionSerializer(serializationConfig2, collectionType2, beanDescription2, jsonSerializerModifyCollectionSerializer);
            }
        }
        return jsonSerializerModifyCollectionSerializer;
    }

    protected boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    protected JsonSerializer<?> buildMapSerializer(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, boolean z, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) throws JsonMappingException {
        SerializationConfig serializationConfig2;
        BeanDescription beanDescription2;
        Iterator<Serializers> it = customSerializers().iterator();
        JsonSerializer<?> jsonSerializerModifyMapSerializer = null;
        while (true) {
            if (!it.hasNext()) {
                serializationConfig2 = serializationConfig;
                beanDescription2 = beanDescription;
                break;
            }
            serializationConfig2 = serializationConfig;
            beanDescription2 = beanDescription;
            jsonSerializerModifyMapSerializer = it.next().findMapSerializer(serializationConfig2, mapType, beanDescription2, jsonSerializer, typeSerializer, jsonSerializer2);
            if (jsonSerializerModifyMapSerializer != null) {
                break;
            }
        }
        if (jsonSerializerModifyMapSerializer == null) {
            if (EnumMap.class.isAssignableFrom(mapType.getRawClass())) {
                JavaType keyType = mapType.getKeyType();
                jsonSerializerModifyMapSerializer = new EnumMapSerializer(mapType.getContentType(), z, keyType.isEnumType() ? EnumValues.construct(keyType.getRawClass(), serializationConfig2.getAnnotationIntrospector()) : null, typeSerializer, jsonSerializer2);
            } else {
                jsonSerializerModifyMapSerializer = MapSerializer.construct(serializationConfig2.getAnnotationIntrospector().findPropertiesToIgnore(beanDescription2.getClassInfo()), mapType, z, typeSerializer, jsonSerializer, jsonSerializer2, findFilterId(serializationConfig2, beanDescription2));
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonSerializerModifyMapSerializer = it2.next().modifyMapSerializer(serializationConfig2, mapType, beanDescription2, jsonSerializerModifyMapSerializer);
            }
        }
        return jsonSerializerModifyMapSerializer;
    }

    protected JsonSerializer<?> buildArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) throws JsonMappingException {
        SerializationConfig serializationConfig2;
        ArrayType arrayType2;
        BeanDescription beanDescription2;
        TypeSerializer typeSerializer2;
        JsonSerializer<Object> jsonSerializer2;
        Iterator<Serializers> it = customSerializers().iterator();
        JsonSerializer<?> jsonSerializerModifyArraySerializer = null;
        while (true) {
            if (!it.hasNext()) {
                serializationConfig2 = serializationConfig;
                arrayType2 = arrayType;
                beanDescription2 = beanDescription;
                typeSerializer2 = typeSerializer;
                jsonSerializer2 = jsonSerializer;
                break;
            }
            serializationConfig2 = serializationConfig;
            arrayType2 = arrayType;
            beanDescription2 = beanDescription;
            typeSerializer2 = typeSerializer;
            jsonSerializer2 = jsonSerializer;
            jsonSerializerModifyArraySerializer = it.next().findArraySerializer(serializationConfig2, arrayType2, beanDescription2, typeSerializer2, jsonSerializer2);
            if (jsonSerializerModifyArraySerializer != null) {
                break;
            }
            serializationConfig = serializationConfig2;
            arrayType = arrayType2;
            beanDescription = beanDescription2;
            typeSerializer = typeSerializer2;
            jsonSerializer = jsonSerializer2;
        }
        if (jsonSerializerModifyArraySerializer == null) {
            Class<?> rawClass = arrayType2.getRawClass();
            if (jsonSerializer2 == null || ClassUtil.isJacksonStdImpl(jsonSerializer2)) {
                if (String[].class == rawClass) {
                    jsonSerializerModifyArraySerializer = StringArraySerializer.instance;
                } else {
                    jsonSerializerModifyArraySerializer = StdArraySerializers.findStandardImpl(rawClass);
                }
            }
            if (jsonSerializerModifyArraySerializer == null) {
                jsonSerializerModifyArraySerializer = new ObjectArraySerializer(arrayType2.getContentType(), z, typeSerializer2, jsonSerializer2);
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it2 = this._factoryConfig.serializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonSerializerModifyArraySerializer = it2.next().modifyArraySerializer(serializationConfig2, arrayType2, beanDescription2, jsonSerializerModifyArraySerializer);
            }
        }
        return jsonSerializerModifyArraySerializer;
    }

    protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        JavaType javaTypeContainedType = javaType.containedType(0);
        if (javaTypeContainedType == null) {
            javaTypeContainedType = TypeFactory.unknownType();
        }
        TypeSerializer typeSerializerCreateTypeSerializer = createTypeSerializer(serializationConfig, javaTypeContainedType);
        return StdContainerSerializers.iteratorSerializer(javaTypeContainedType, usesStaticTyping(serializationConfig, beanDescription, typeSerializerCreateTypeSerializer), typeSerializerCreateTypeSerializer);
    }

    protected JsonSerializer<?> buildIterableSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription, boolean z) throws JsonMappingException {
        JavaType javaTypeContainedType = javaType.containedType(0);
        if (javaTypeContainedType == null) {
            javaTypeContainedType = TypeFactory.unknownType();
        }
        TypeSerializer typeSerializerCreateTypeSerializer = createTypeSerializer(serializationConfig, javaTypeContainedType);
        return StdContainerSerializers.iterableSerializer(javaTypeContainedType, usesStaticTyping(serializationConfig, beanDescription, typeSerializerCreateTypeSerializer), typeSerializerCreateTypeSerializer);
    }

    protected JsonSerializer<?> buildEnumSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JsonFormat.Value valueFindExpectedFormat = beanDescription.findExpectedFormat(null);
        if (valueFindExpectedFormat != null && valueFindExpectedFormat.getShape() == JsonFormat.Shape.OBJECT) {
            ((BasicBeanDescription) beanDescription).removeProperty("declaringClass");
            return null;
        }
        JsonSerializer<?> jsonSerializerConstruct = EnumSerializer.construct(javaType.getRawClass(), serializationConfig, beanDescription, valueFindExpectedFormat);
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<BeanSerializerModifier> it = this._factoryConfig.serializerModifiers().iterator();
            while (it.hasNext()) {
                jsonSerializerConstruct = it.next().modifyEnumSerializer(serializationConfig, javaType, beanDescription, jsonSerializerConstruct);
            }
        }
        return jsonSerializerConstruct;
    }

    protected <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig serializationConfig, Annotated annotated, T t) {
        Class<?> clsFindSerializationType = serializationConfig.getAnnotationIntrospector().findSerializationType(annotated);
        if (clsFindSerializationType != null) {
            try {
                t = (T) t.widenBy(clsFindSerializationType);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to widen type " + t + " with concrete-type annotation (value " + clsFindSerializationType.getName() + "), method '" + annotated.getName() + "': " + e.getMessage());
            }
        }
        return (T) modifySecondaryTypesByAnnotation(serializationConfig, annotated, t);
    }

    protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig serializationConfig, Annotated annotated, T t) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        if (t.isContainerType()) {
            Class<?> clsFindSerializationKeyType = annotationIntrospector.findSerializationKeyType(annotated, t.getKeyType());
            if (clsFindSerializationKeyType != null) {
                if (!(t instanceof MapType)) {
                    throw new IllegalArgumentException("Illegal key-type annotation: type " + t + " is not a Map type");
                }
                try {
                    t = (T) ((MapType) t).widenKey(clsFindSerializationKeyType);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Failed to narrow key type " + t + " with key-type annotation (" + clsFindSerializationKeyType.getName() + "): " + e.getMessage());
                }
            }
            Class<?> clsFindSerializationContentType = annotationIntrospector.findSerializationContentType(annotated, t.getContentType());
            if (clsFindSerializationContentType != null) {
                try {
                    return (T) t.widenContentsBy(clsFindSerializationContentType);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Failed to narrow content type " + t + " with content-type annotation (" + clsFindSerializationContentType.getName() + "): " + e2.getMessage());
                }
            }
        }
        return t;
    }

    protected JsonSerializer<Object> _findKeySerializer(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objFindKeySerializer = serializerProvider.getAnnotationIntrospector().findKeySerializer(annotated);
        if (objFindKeySerializer != null) {
            return serializerProvider.serializerInstance(annotated, objFindKeySerializer);
        }
        return null;
    }

    protected JsonSerializer<Object> _findContentSerializer(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objFindContentSerializer = serializerProvider.getAnnotationIntrospector().findContentSerializer(annotated);
        if (objFindContentSerializer != null) {
            return serializerProvider.serializerInstance(annotated, objFindContentSerializer);
        }
        return null;
    }

    protected Object findFilterId(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        return serializationConfig.getAnnotationIntrospector().findFilterId((Annotated) beanDescription.getClassInfo());
    }

    @Deprecated
    protected final boolean usesStaticTyping(SerializationConfig serializationConfig, BeanDescription beanDescription, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        return usesStaticTyping(serializationConfig, beanDescription, typeSerializer);
    }

    protected boolean usesStaticTyping(SerializationConfig serializationConfig, BeanDescription beanDescription, TypeSerializer typeSerializer) {
        if (typeSerializer != null) {
            return false;
        }
        JsonSerialize.Typing typingFindSerializationTyping = serializationConfig.getAnnotationIntrospector().findSerializationTyping(beanDescription.getClassInfo());
        if (typingFindSerializationTyping == null || typingFindSerializationTyping == JsonSerialize.Typing.DEFAULT_TYPING) {
            return serializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
        }
        return typingFindSerializationTyping == JsonSerialize.Typing.STATIC;
    }

    protected Class<?> _verifyAsClass(Object obj, String str, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        Class<?> cls2 = (Class) obj;
        if (cls2 == cls || cls2 == NoClass.class) {
            return null;
        }
        return cls2;
    }
}
