package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JavaTypeDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes3.dex */
public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
    static final HashMap<String, Class<? extends Map>> _mapFallbacks;
    protected final DeserializerFactoryConfig _factoryConfig;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_BUFFER = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");

    protected abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    static {
        HashMap<String, Class<? extends Map>> map = new HashMap<>();
        _mapFallbacks = map;
        map.put(Map.class.getName(), LinkedHashMap.class);
        map.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        map.put(SortedMap.class.getName(), TreeMap.class);
        map.put("java.util.NavigableMap", TreeMap.class);
        try {
            map.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        } catch (Throwable th) {
            System.err.println("Problems with (optional) types: " + th);
        }
        HashMap<String, Class<? extends Collection>> map2 = new HashMap<>();
        _collectionFallbacks = map2;
        map2.put(Collection.class.getName(), ArrayList.class);
        map2.put(List.class.getName(), ArrayList.class);
        map2.put(Set.class.getName(), HashSet.class);
        map2.put(SortedSet.class.getName(), TreeSet.class);
        map2.put(Queue.class.getName(), LinkedList.class);
        map2.put("java.util.Deque", LinkedList.class);
        map2.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(deserializers));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(keyDeserializers));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        return withConfig(this._factoryConfig.withDeserializerModifier(beanDeserializerModifier));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(abstractTypeResolver));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public final DeserializerFactory withValueInstantiators(ValueInstantiators valueInstantiators) {
        return withConfig(this._factoryConfig.withValueInstantiators(valueInstantiators));
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType javaType_mapAbstractType2;
        while (true) {
            javaType_mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (javaType_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = javaType_mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                break;
            }
            javaType = javaType_mapAbstractType2;
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + javaType_mapAbstractType2 + ": latter is not a subtype of former");
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (!this._factoryConfig.hasAbstractTypeResolvers()) {
            return null;
        }
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeFindTypeMapping = it.next().findTypeMapping(deserializationConfig, javaType);
            if (javaTypeFindTypeMapping != null && javaTypeFindTypeMapping.getRawClass() != rawClass) {
                return javaTypeFindTypeMapping;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedClass classInfo = beanDescription.getClassInfo();
        Object objFindValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(classInfo);
        ValueInstantiator valueInstantiator_valueInstantiatorInstance = objFindValueInstantiator != null ? _valueInstantiatorInstance(config, classInfo, objFindValueInstantiator) : null;
        if (valueInstantiator_valueInstantiatorInstance == null && (valueInstantiator_valueInstantiatorInstance = _findStdValueInstantiator(config, beanDescription)) == null) {
            valueInstantiator_valueInstantiatorInstance = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators valueInstantiators : this._factoryConfig.valueInstantiators()) {
                valueInstantiator_valueInstantiatorInstance = valueInstantiators.findValueInstantiator(config, beanDescription, valueInstantiator_valueInstantiatorInstance);
                if (valueInstantiator_valueInstantiatorInstance == null) {
                    throw new JsonMappingException("Broken registered ValueInstantiators (of type " + valueInstantiators.getClass().getName() + "): returned null ValueInstantiator");
                }
            }
        }
        if (valueInstantiator_valueInstantiatorInstance.getIncompleteParameter() == null) {
            return valueInstantiator_valueInstantiatorInstance;
        }
        AnnotatedParameter incompleteParameter = valueInstantiator_valueInstantiatorInstance.getIncompleteParameter();
        throw new IllegalArgumentException("Argument #" + incompleteParameter.getIndex() + " of constructor " + incompleteParameter.getOwner() + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
    }

    private ValueInstantiator _findStdValueInstantiator(DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        if (beanDescription.getBeanClass() == JsonLocation.class) {
            return JsonLocationInstantiator.instance;
        }
        return null;
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        CreatorCollector creatorCollector = new CreatorCollector(beanDescription, deserializationContext.canOverrideAccessModifiers());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        VisibilityChecker<?> visibilityCheckerFindAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(beanDescription.getClassInfo(), config.getDefaultVisibilityChecker());
        _addDeserializerFactoryMethods(deserializationContext, beanDescription, visibilityCheckerFindAutoDetectVisibility, annotationIntrospector, creatorCollector);
        if (beanDescription.getType().isConcrete()) {
            _addDeserializerConstructors(deserializationContext, beanDescription, visibilityCheckerFindAutoDetectVisibility, annotationIntrospector, creatorCollector);
        }
        return creatorCollector.constructValueInstantiator(config);
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) throws JsonMappingException {
        ValueInstantiator valueInstantiatorValueInstantiatorInstance;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class<?> cls = (Class) obj;
        if (cls == NoClass.class) {
            return null;
        }
        if (!ValueInstantiator.class.isAssignableFrom(cls)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
        }
        HandlerInstantiator handlerInstantiator = deserializationConfig.getHandlerInstantiator();
        return (handlerInstantiator == null || (valueInstantiatorValueInstantiatorInstance = handlerInstantiator.valueInstantiatorInstance(deserializationConfig, annotated, cls)) == null) ? (ValueInstantiator) ClassUtil.createInstance(cls, deserializationConfig.canOverrideAccessModifiers()) : valueInstantiatorValueInstantiatorInstance;
    }

    protected void _addDeserializerConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector) throws JsonMappingException {
        PropertyName propertyName;
        BasicDeserializerFactory basicDeserializerFactory;
        BeanDescription beanDescription2;
        VisibilityChecker<?> visibilityChecker2;
        int i;
        AnnotatedConstructor annotatedConstructorFindDefaultConstructor = beanDescription.findDefaultConstructor();
        if (annotatedConstructorFindDefaultConstructor != null && (!creatorCollector.hasDefaultCreator() || annotationIntrospector.hasCreatorAnnotation(annotatedConstructorFindDefaultConstructor))) {
            creatorCollector.setDefaultCreator(annotatedConstructorFindDefaultConstructor);
        }
        AnnotatedConstructor annotatedConstructor = null;
        PropertyName[] propertyNameArr = null;
        for (BeanPropertyDefinition beanPropertyDefinition : beanDescription.findProperties()) {
            if (beanPropertyDefinition.getConstructorParameter() != null) {
                AnnotatedParameter constructorParameter = beanPropertyDefinition.getConstructorParameter();
                AnnotatedWithParams owner = constructorParameter.getOwner();
                if (owner instanceof AnnotatedConstructor) {
                    if (annotatedConstructor == null) {
                        AnnotatedConstructor annotatedConstructor2 = (AnnotatedConstructor) owner;
                        annotatedConstructor = annotatedConstructor2;
                        propertyNameArr = new PropertyName[annotatedConstructor2.getParameterCount()];
                    }
                    propertyNameArr[constructorParameter.getIndex()] = beanPropertyDefinition.getFullName();
                }
            }
        }
        Iterator<AnnotatedConstructor> it = beanDescription.getConstructors().iterator();
        while (it.hasNext()) {
            AnnotatedConstructor next = it.next();
            int parameterCount = next.getParameterCount();
            int i2 = 0;
            boolean z = annotationIntrospector.hasCreatorAnnotation(next) || next == annotatedConstructor;
            boolean zIsCreatorVisible = visibilityChecker.isCreatorVisible(next);
            if (parameterCount == 1) {
                if (next == annotatedConstructor) {
                    propertyName = propertyNameArr[0];
                    beanDescription2 = beanDescription;
                    visibilityChecker2 = visibilityChecker;
                    basicDeserializerFactory = this;
                } else {
                    propertyName = null;
                    basicDeserializerFactory = this;
                    beanDescription2 = beanDescription;
                    visibilityChecker2 = visibilityChecker;
                }
                basicDeserializerFactory._handleSingleArgumentConstructor(deserializationContext, beanDescription2, visibilityChecker2, annotationIntrospector, creatorCollector, next, z, zIsCreatorVisible, propertyName);
            } else if (z || zIsCreatorVisible) {
                CreatorProperty[] creatorPropertyArr = new CreatorProperty[parameterCount];
                AnnotatedParameter annotatedParameter = null;
                int i3 = 0;
                int i4 = 0;
                while (i2 < parameterCount) {
                    AnnotatedParameter parameter = next.getParameter(i2);
                    PropertyName propertyNameFindNameForDeserialization = next == annotatedConstructor ? propertyNameArr[i2] : null;
                    if (propertyNameFindNameForDeserialization == null) {
                        propertyNameFindNameForDeserialization = parameter == null ? null : annotationIntrospector.findNameForDeserialization(parameter);
                    }
                    PropertyName propertyName2 = propertyNameFindNameForDeserialization;
                    Object objFindInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
                    if (propertyName2 == null || !propertyName2.hasSimpleName()) {
                        i = i2;
                        if (objFindInjectableValueId != null) {
                            i4++;
                            creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName2, i, parameter, objFindInjectableValueId);
                        } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                            creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i, parameter, null);
                            i3++;
                        } else if (annotatedParameter == null) {
                            annotatedParameter = parameter;
                        }
                    } else {
                        i3++;
                        i = i2;
                        creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName2, i, parameter, objFindInjectableValueId);
                    }
                    i2 = i + 1;
                }
                if (z || i3 > 0 || i4 > 0) {
                    if (i3 + i4 == parameterCount) {
                        creatorCollector.addPropertyCreator(next, creatorPropertyArr);
                    } else if (i3 == 0 && i4 + 1 == parameterCount) {
                        creatorCollector.addDelegatingCreator(next, creatorPropertyArr);
                    } else {
                        creatorCollector.addIncompeteParameter(annotatedParameter);
                    }
                }
            }
        }
    }

    protected boolean _handleSingleArgumentConstructor(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedConstructor annotatedConstructor, boolean z, boolean z2, PropertyName propertyName) throws JsonMappingException {
        PropertyName propertyNameFindNameForDeserialization;
        AnnotatedParameter parameter = annotatedConstructor.getParameter(0);
        if (propertyName == null) {
            propertyNameFindNameForDeserialization = parameter == null ? null : annotationIntrospector.findNameForDeserialization(parameter);
        } else {
            propertyNameFindNameForDeserialization = propertyName;
        }
        Object objFindInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
        if (objFindInjectableValueId != null || (propertyNameFindNameForDeserialization != null && propertyNameFindNameForDeserialization.hasSimpleName())) {
            creatorCollector.addPropertyCreator(annotatedConstructor, new CreatorProperty[]{constructCreatorProperty(deserializationContext, beanDescription, propertyNameFindNameForDeserialization, 0, parameter, objFindInjectableValueId)});
            return true;
        }
        Class<?> rawParameterType = annotatedConstructor.getRawParameterType(0);
        if (rawParameterType == String.class) {
            if (z || z2) {
                creatorCollector.addStringCreator(annotatedConstructor);
            }
            return true;
        }
        if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z || z2) {
                creatorCollector.addIntCreator(annotatedConstructor);
            }
            return true;
        }
        if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z || z2) {
                creatorCollector.addLongCreator(annotatedConstructor);
            }
            return true;
        }
        if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z || z2) {
                creatorCollector.addDoubleCreator(annotatedConstructor);
            }
            return true;
        }
        if (!z) {
            return false;
        }
        creatorCollector.addDelegatingCreator(annotatedConstructor, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector) throws JsonMappingException {
        int i;
        int i2;
        DeserializationConfig config = deserializationContext.getConfig();
        for (AnnotatedMethod annotatedMethod : beanDescription.getFactoryMethods()) {
            boolean zHasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedMethod);
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount != 0) {
                int i3 = 0;
                if (parameterCount == 1) {
                    AnnotatedParameter parameter = annotatedMethod.getParameter(0);
                    PropertyName propertyNameFindNameForDeserialization = parameter == null ? null : annotationIntrospector.findNameForDeserialization(parameter);
                    String simpleName = propertyNameFindNameForDeserialization == null ? null : propertyNameFindNameForDeserialization.getSimpleName();
                    if (annotationIntrospector.findInjectableValueId(parameter) == null && (simpleName == null || simpleName.length() == 0)) {
                        _handleSingleArgumentFactory(config, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, annotatedMethod, zHasCreatorAnnotation);
                    } else {
                        CreatorProperty[] creatorPropertyArr = new CreatorProperty[parameterCount];
                        AnnotatedParameter annotatedParameter = null;
                        i2 = 0;
                        for (i = 0; i < parameterCount; i++) {
                            AnnotatedParameter parameter2 = annotatedMethod.getParameter(i);
                            PropertyName propertyNameFindNameForDeserialization2 = parameter2 == null ? null : annotationIntrospector.findNameForDeserialization(parameter2);
                            Object objFindInjectableValueId = annotationIntrospector.findInjectableValueId(parameter2);
                            if (propertyNameFindNameForDeserialization2 != null && propertyNameFindNameForDeserialization2.hasSimpleName()) {
                                i3++;
                                creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyNameFindNameForDeserialization2, i, parameter2, objFindInjectableValueId);
                            } else if (objFindInjectableValueId != null) {
                                i2++;
                                creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyNameFindNameForDeserialization2, i, parameter2, objFindInjectableValueId);
                            } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter2) != null) {
                                creatorPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i, parameter2, null);
                                i3++;
                            } else if (annotatedParameter == null) {
                                annotatedParameter = parameter2;
                            }
                        }
                        if (!zHasCreatorAnnotation || i3 > 0 || i2 > 0) {
                            if (i3 + i2 != parameterCount) {
                                creatorCollector.addPropertyCreator(annotatedMethod, creatorPropertyArr);
                            } else if (i3 == 0 && i2 + 1 == parameterCount) {
                                creatorCollector.addDelegatingCreator(annotatedMethod, creatorPropertyArr);
                            } else {
                                throw new IllegalArgumentException("Argument #" + annotatedParameter.getIndex() + " of factory method " + annotatedMethod + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                            }
                        }
                    }
                } else if (annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
                    CreatorProperty[] creatorPropertyArr2 = new CreatorProperty[parameterCount];
                    AnnotatedParameter annotatedParameter2 = null;
                    i2 = 0;
                    while (i < parameterCount) {
                    }
                    if (!zHasCreatorAnnotation) {
                    }
                    if (i3 + i2 != parameterCount) {
                    }
                } else {
                    continue;
                }
            } else if (zHasCreatorAnnotation) {
                creatorCollector.setDefaultCreator(annotatedMethod);
            }
        }
    }

    protected boolean _handleSingleArgumentFactory(DeserializationConfig deserializationConfig, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedMethod annotatedMethod, boolean z) throws JsonMappingException {
        Class<?> rawParameterType = annotatedMethod.getRawParameterType(0);
        if (rawParameterType == String.class) {
            if (z || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                creatorCollector.addStringCreator(annotatedMethod);
            }
            return true;
        }
        if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                creatorCollector.addIntCreator(annotatedMethod);
            }
            return true;
        }
        if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                creatorCollector.addLongCreator(annotatedMethod);
            }
            return true;
        }
        if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                creatorCollector.addDoubleCreator(annotatedMethod);
            }
            return true;
        }
        if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z || visibilityChecker.isCreatorVisible(annotatedMethod)) {
                creatorCollector.addBooleanCreator(annotatedMethod);
            }
            return true;
        }
        if (!annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
            return false;
        }
        creatorCollector.addDelegatingCreator(annotatedMethod, null);
        return true;
    }

    protected CreatorProperty constructCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, Object obj) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Boolean boolHasRequiredMarker = annotationIntrospector == null ? null : annotationIntrospector.hasRequiredMarker(annotatedParameter);
        PropertyMetadata propertyMetadataConstruct = PropertyMetadata.construct(boolHasRequiredMarker != null && boolHasRequiredMarker.booleanValue(), annotationIntrospector != null ? annotationIntrospector.findPropertyDescription(annotatedParameter) : null);
        JavaType javaTypeConstructType = config.getTypeFactory().constructType(annotatedParameter.getParameterType(), beanDescription.bindingsForBeanType());
        BeanProperty.Std std = new BeanProperty.Std(propertyName, javaTypeConstructType, annotationIntrospector.findWrapperName(annotatedParameter), beanDescription.getClassAnnotations(), annotatedParameter, propertyMetadataConstruct);
        JavaType javaTypeResolveType = resolveType(deserializationContext, beanDescription, javaTypeConstructType, annotatedParameter);
        if (javaTypeResolveType != javaTypeConstructType) {
            std = std.withType(javaTypeResolveType);
        }
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        JavaType javaTypeModifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, annotatedParameter, javaTypeResolveType);
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) javaTypeModifyTypeByAnnotation.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, javaTypeModifyTypeByAnnotation);
        }
        CreatorProperty creatorProperty = new CreatorProperty(propertyName, javaTypeModifyTypeByAnnotation, std.getWrapperName(), typeDeserializerFindTypeDeserializer, beanDescription.getClassAnnotations(), annotatedParameter, i, obj, propertyMetadataConstruct);
        return jsonDeserializerFindDeserializerFromAnnotation != null ? creatorProperty.withValueDeserializer(jsonDeserializerFindDeserializerFromAnnotation) : creatorProperty;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, beanDescription, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomArrayDeserializer == null) {
            if (jsonDeserializer == null) {
                Class<?> rawClass = contentType.getRawClass();
                if (contentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            jsonDeserializer_findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, jsonDeserializer, typeDeserializer);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomArrayDeserializer = it.next().modifyArrayDeserializer(config, arrayType, beanDescription, jsonDeserializer_findCustomArrayDeserializer);
            }
        }
        return jsonDeserializer_findCustomArrayDeserializer;
    }

    protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            ArrayType arrayType2 = arrayType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindArrayDeserializer = it.next().findArrayDeserializer(arrayType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindArrayDeserializer != null) {
                return jsonDeserializerFindArrayDeserializer;
            }
            arrayType = arrayType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        CollectionType collectionType2 = collectionType;
        BeanDescription beanDescriptionIntrospectForCreation = beanDescription;
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType2, config, beanDescriptionIntrospectForCreation, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            Class<?> rawClass = collectionType2.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(rawClass)) {
                jsonDeserializer_findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (jsonDeserializer_findCustomCollectionDeserializer == null) {
            if (collectionType2.isInterface() || collectionType2.isAbstract()) {
                CollectionType collectionType_mapAbstractCollectionType = _mapAbstractCollectionType(collectionType2, config);
                if (collectionType_mapAbstractCollectionType == null) {
                    if (collectionType2.getTypeHandler() == null) {
                        throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + collectionType2);
                    }
                    jsonDeserializer_findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(beanDescriptionIntrospectForCreation);
                } else {
                    beanDescriptionIntrospectForCreation = config.introspectForCreation(collectionType_mapAbstractCollectionType);
                    collectionType2 = collectionType_mapAbstractCollectionType;
                }
            }
            if (jsonDeserializer_findCustomCollectionDeserializer == null) {
                ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescriptionIntrospectForCreation);
                if (!valueInstantiatorFindValueInstantiator.canCreateUsingDefault() && collectionType2.getRawClass() == ArrayBlockingQueue.class) {
                    return new ArrayBlockingQueueDeserializer(collectionType2, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator, null);
                }
                if (contentType.getRawClass() == String.class) {
                    jsonDeserializer_findCustomCollectionDeserializer = new StringCollectionDeserializer(collectionType2, jsonDeserializer, valueInstantiatorFindValueInstantiator);
                } else {
                    jsonDeserializer_findCustomCollectionDeserializer = new CollectionDeserializer(collectionType2, jsonDeserializer, typeDeserializer, valueInstantiatorFindValueInstantiator);
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionDeserializer = it.next().modifyCollectionDeserializer(config, collectionType2, beanDescriptionIntrospectForCreation, jsonDeserializer_findCustomCollectionDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionDeserializer;
    }

    protected CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<? extends Collection> cls = _collectionFallbacks.get(javaType.getRawClass().getName());
        if (cls == null) {
            return null;
        }
        return (CollectionType) deserializationConfig.constructSpecializedType(javaType, cls);
    }

    protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            CollectionType collectionType2 = collectionType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindCollectionDeserializer = it.next().findCollectionDeserializer(collectionType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindCollectionDeserializer != null) {
                return jsonDeserializerFindCollectionDeserializer;
            }
            collectionType = collectionType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionLikeType.getContentType();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> jsonDeserializer_findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, beanDescription, typeDeserializerFindTypeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomCollectionLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomCollectionLikeDeserializer = it.next().modifyCollectionLikeDeserializer(config, collectionLikeType, beanDescription, jsonDeserializer_findCustomCollectionLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomCollectionLikeDeserializer;
    }

    protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            CollectionLikeType collectionLikeType2 = collectionLikeType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindCollectionLikeDeserializer = it.next().findCollectionLikeDeserializer(collectionLikeType2, deserializationConfig2, beanDescription2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindCollectionLikeDeserializer != null) {
                return jsonDeserializerFindCollectionLikeDeserializer;
            }
            collectionLikeType = collectionLikeType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7 A[PHI: r8
      0x00c7: PHI (r8v1 com.fasterxml.jackson.databind.JsonDeserializer<?>) = (r8v0 com.fasterxml.jackson.databind.JsonDeserializer<?>), (r8v6 com.fasterxml.jackson.databind.JsonDeserializer<?>) binds: [B:6:0x0033, B:16:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.fasterxml.jackson.databind.deser.std.MapDeserializer] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonDeserializer<?> createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, BeanDescription beanDescription) throws JsonMappingException {
        BeanDescription beanDescriptionIntrospectForCreation;
        JsonDeserializer<?> jsonDeserializerModifyMapDeserializer;
        MapType mapType2;
        ?? ConstructForNonPOJO;
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType keyType = mapType.getKeyType();
        JavaType contentType = mapType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer = typeDeserializerFindTypeDeserializer;
        MapType mapType3 = mapType;
        JsonDeserializer<?> jsonDeserializer_findCustomMapDeserializer = _findCustomMapDeserializer(mapType3, config, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomMapDeserializer == null) {
            Class<?> rawClass = mapType3.getRawClass();
            jsonDeserializer_findCustomMapDeserializer = jsonDeserializer_findCustomMapDeserializer;
            if (EnumMap.class.isAssignableFrom(rawClass)) {
                Class<?> rawClass2 = keyType.getRawClass();
                if (rawClass2 == null || !rawClass2.isEnum()) {
                    throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                }
                jsonDeserializer_findCustomMapDeserializer = new EnumMapDeserializer(mapType3, null, jsonDeserializer, typeDeserializer);
            }
            if (jsonDeserializer_findCustomMapDeserializer == null) {
                if (mapType3.isInterface() || mapType3.isAbstract()) {
                    Class<? extends Map> cls = _mapFallbacks.get(rawClass.getName());
                    if (cls != null) {
                        mapType3 = (MapType) config.constructSpecializedType(mapType3, cls);
                        beanDescriptionIntrospectForCreation = config.introspectForCreation(mapType3);
                    } else {
                        if (mapType3.getTypeHandler() == null) {
                            throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + mapType3);
                        }
                        mapType2 = mapType3;
                        ConstructForNonPOJO = AbstractDeserializer.constructForNonPOJO(beanDescription);
                        beanDescriptionIntrospectForCreation = beanDescription;
                        if (ConstructForNonPOJO == 0) {
                            ConstructForNonPOJO = new MapDeserializer(mapType2, findValueInstantiator(deserializationContext, beanDescriptionIntrospectForCreation), keyDeserializer, (JsonDeserializer<Object>) jsonDeserializer, typeDeserializer);
                            ConstructForNonPOJO.setIgnorableProperties(config.getAnnotationIntrospector().findPropertiesToIgnore(beanDescriptionIntrospectForCreation.getClassInfo()));
                        }
                        mapType3 = mapType2;
                        jsonDeserializerModifyMapDeserializer = ConstructForNonPOJO;
                    }
                } else {
                    beanDescriptionIntrospectForCreation = beanDescription;
                }
                mapType2 = mapType3;
                ConstructForNonPOJO = jsonDeserializer_findCustomMapDeserializer;
                if (ConstructForNonPOJO == 0) {
                }
                mapType3 = mapType2;
                jsonDeserializerModifyMapDeserializer = ConstructForNonPOJO;
            } else {
                beanDescriptionIntrospectForCreation = beanDescription;
                jsonDeserializerModifyMapDeserializer = jsonDeserializer_findCustomMapDeserializer;
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            jsonDeserializerModifyMapDeserializer = jsonDeserializerModifyMapDeserializer;
            while (it.hasNext()) {
                jsonDeserializerModifyMapDeserializer = it.next().modifyMapDeserializer(config, mapType3, beanDescriptionIntrospectForCreation, jsonDeserializerModifyMapDeserializer);
            }
        }
        return jsonDeserializerModifyMapDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<?> jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializerFindTypeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializerFindTypeDeserializer == null) {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> jsonDeserializer_findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, beanDescription, keyDeserializer, typeDeserializerFindTypeDeserializer, jsonDeserializer);
        if (jsonDeserializer_findCustomMapLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                jsonDeserializer_findCustomMapLikeDeserializer = it.next().modifyMapLikeDeserializer(config, mapLikeType, beanDescription, jsonDeserializer_findCustomMapLikeDeserializer);
            }
        }
        return jsonDeserializer_findCustomMapLikeDeserializer;
    }

    protected JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            MapType mapType2 = mapType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            KeyDeserializer keyDeserializer2 = keyDeserializer;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindMapDeserializer = it.next().findMapDeserializer(mapType2, deserializationConfig2, beanDescription2, keyDeserializer2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindMapDeserializer != null) {
                return jsonDeserializerFindMapDeserializer;
            }
            mapType = mapType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            keyDeserializer = keyDeserializer2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            MapLikeType mapLikeType2 = mapLikeType;
            DeserializationConfig deserializationConfig2 = deserializationConfig;
            BeanDescription beanDescription2 = beanDescription;
            KeyDeserializer keyDeserializer2 = keyDeserializer;
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            JsonDeserializer<?> jsonDeserializer2 = jsonDeserializer;
            JsonDeserializer<?> jsonDeserializerFindMapLikeDeserializer = it.next().findMapLikeDeserializer(mapLikeType2, deserializationConfig2, beanDescription2, keyDeserializer2, typeDeserializer2, jsonDeserializer2);
            if (jsonDeserializerFindMapLikeDeserializer != null) {
                return jsonDeserializerFindMapLikeDeserializer;
            }
            mapLikeType = mapLikeType2;
            deserializationConfig = deserializationConfig2;
            beanDescription = beanDescription2;
            keyDeserializer = keyDeserializer2;
            typeDeserializer = typeDeserializer2;
            jsonDeserializer = jsonDeserializer2;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r2 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        r2 = new com.fasterxml.jackson.databind.deser.std.EnumDeserializer(constructEnumResolver(r1, r0, r9.findJsonValueMethod()));
     */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonDeserializer<?> createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescription);
        if (jsonDeserializer_findCustomEnumDeserializer == null) {
            Iterator<AnnotatedMethod> it = beanDescription.getFactoryMethods().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedMethod next = it.next();
                if (deserializationContext.getAnnotationIntrospector().hasCreatorAnnotation(next)) {
                    if (next.getParameterCount() == 1 && next.getRawReturnType().isAssignableFrom(rawClass)) {
                        jsonDeserializer_findCustomEnumDeserializer = EnumDeserializer.deserializerForCreator(config, rawClass, next);
                    } else {
                        throw new IllegalArgumentException("Unsuitable method (" + next + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
                    }
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializer_findCustomEnumDeserializer = it2.next().modifyEnumDeserializer(config, javaType, beanDescription, jsonDeserializer_findCustomEnumDeserializer);
            }
        }
        return jsonDeserializer_findCustomEnumDeserializer;
    }

    protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindEnumDeserializer = it.next().findEnumDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindEnumDeserializer != null) {
                return jsonDeserializerFindEnumDeserializer;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanDescription);
        return jsonDeserializer_findCustomTreeNodeDeserializer != null ? jsonDeserializer_findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindTreeNodeDeserializer = it.next().findTreeNodeDeserializer(cls, deserializationConfig, beanDescription);
            if (jsonDeserializerFindTreeNodeDeserializer != null) {
                return jsonDeserializerFindTreeNodeDeserializer;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Collection<NamedType> collectionCollectAndResolveSubtypes;
        JavaType javaTypeMapAbstractType;
        AnnotatedClass classInfo = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> typeResolverBuilderFindTypeResolver = annotationIntrospector.findTypeResolver(deserializationConfig, classInfo, javaType);
        if (typeResolverBuilderFindTypeResolver == null) {
            typeResolverBuilderFindTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            collectionCollectAndResolveSubtypes = null;
            if (typeResolverBuilderFindTypeResolver == null) {
                return null;
            }
        } else {
            collectionCollectAndResolveSubtypes = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(classInfo, deserializationConfig, annotationIntrospector);
        }
        if (typeResolverBuilderFindTypeResolver.getDefaultImpl() == null && javaType.isAbstract() && (javaTypeMapAbstractType = mapAbstractType(deserializationConfig, javaType)) != null && javaTypeMapAbstractType.getRawClass() != javaType.getRawClass()) {
            typeResolverBuilderFindTypeResolver = typeResolverBuilderFindTypeResolver.defaultImpl(javaTypeMapAbstractType.getRawClass());
        }
        return typeResolverBuilderFindTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collectionCollectAndResolveSubtypes);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws SecurityException, JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        KeyDeserializer keyDeserializerModifyKeyDeserializer = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            BeanDescription beanDescriptionIntrospectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            Iterator<KeyDeserializers> it = this._factoryConfig.keyDeserializers().iterator();
            while (it.hasNext() && (keyDeserializerModifyKeyDeserializer = it.next().findKeyDeserializer(javaType, config, beanDescriptionIntrospectClassAnnotations)) == null) {
            }
        }
        if (keyDeserializerModifyKeyDeserializer == null) {
            if (javaType.isEnumType()) {
                return _createEnumKeyDeserializer(deserializationContext, javaType);
            }
            keyDeserializerModifyKeyDeserializer = StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
        }
        if (keyDeserializerModifyKeyDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                keyDeserializerModifyKeyDeserializer = it2.next().modifyKeyDeserializer(config, javaType, keyDeserializerModifyKeyDeserializer);
            }
        }
        return keyDeserializerModifyKeyDeserializer;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws SecurityException, JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDescription beanDescriptionIntrospect = config.introspect(javaType);
        JsonDeserializer<Object> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, beanDescriptionIntrospect.getClassInfo());
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializerFindDeserializerFromAnnotation);
        }
        Class<?> rawClass = javaType.getRawClass();
        JsonDeserializer<?> jsonDeserializer_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, beanDescriptionIntrospect);
        if (jsonDeserializer_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, jsonDeserializer_findCustomEnumDeserializer);
        }
        EnumResolver<?> enumResolverConstructEnumResolver = constructEnumResolver(rawClass, config, beanDescriptionIntrospect.findJsonValueMethod());
        for (AnnotatedMethod annotatedMethod : beanDescriptionIntrospect.getFactoryMethods()) {
            if (config.getAnnotationIntrospector().hasCreatorAnnotation(annotatedMethod)) {
                if (annotatedMethod.getParameterCount() == 1 && annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    if (annotatedMethod.getGenericParameterType(0) != String.class) {
                        throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String");
                    }
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(annotatedMethod.getMember());
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver, annotatedMethod);
                }
                throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyTypeResolver = annotationIntrospector.findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (typeResolverBuilderFindPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        return typeResolverBuilderFindPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, deserializationConfig, annotationIntrospector, javaType));
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        TypeResolverBuilder<?> typeResolverBuilderFindPropertyContentTypeResolver = annotationIntrospector.findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        if (typeResolverBuilderFindPropertyContentTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, contentType);
        }
        return typeResolverBuilderFindPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedMember, deserializationConfig, annotationIntrospector, contentType));
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        String name = rawClass.getName();
        if (rawClass.isPrimitive() || name.startsWith("java.")) {
            if (rawClass == CLASS_OBJECT) {
                return new UntypedObjectDeserializer();
            }
            if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_BUFFER) {
                return StringDeserializer.instance;
            }
            if (rawClass == CLASS_ITERABLE) {
                return createCollectionDeserializer(deserializationContext, deserializationContext.getTypeFactory().constructCollectionType(Collection.class, javaType.containedTypeCount() > 0 ? javaType.containedType(0) : TypeFactory.unknownType()), beanDescription);
            }
            JsonDeserializer<?> jsonDeserializerFind = NumberDeserializers.find(rawClass, name);
            if (jsonDeserializerFind != null) {
                return jsonDeserializerFind;
            }
            JsonDeserializer<?> jsonDeserializerFind2 = DateDeserializers.find(rawClass, name);
            return jsonDeserializerFind2 == null ? JdkDeserializers.find(rawClass, name) : jsonDeserializerFind2;
        }
        if (!name.startsWith("com.fasterxml.")) {
            return null;
        }
        if (rawClass == TokenBuffer.class) {
            return TokenBufferDeserializer.instance;
        }
        if (JavaType.class.isAssignableFrom(rawClass)) {
            return JavaTypeDeserializer.instance;
        }
        return null;
    }

    protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        Object objFindDeserializer = deserializationContext.getAnnotationIntrospector().findDeserializer(annotated);
        if (objFindDeserializer == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(annotated, objFindDeserializer);
    }

    protected <T extends JavaType> T modifyTypeByAnnotation(DeserializationContext deserializationContext, Annotated annotated, T t) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Class<?> clsFindDeserializationType = annotationIntrospector.findDeserializationType(annotated, t);
        JavaType javaType = t;
        if (clsFindDeserializationType != null) {
            try {
                javaType = (T) t.narrowBy(clsFindDeserializationType);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException("Failed to narrow type " + t + " with concrete-type annotation (value " + clsFindDeserializationType.getName() + "), method '" + annotated.getName() + "': " + e.getMessage(), null, e);
            }
        }
        boolean zIsContainerType = javaType.isContainerType();
        JavaType javaType2 = javaType;
        if (zIsContainerType) {
            Class<?> clsFindDeserializationKeyType = annotationIntrospector.findDeserializationKeyType(annotated, javaType.getKeyType());
            T t2 = javaType;
            if (clsFindDeserializationKeyType != null) {
                if (!(javaType instanceof MapLikeType)) {
                    throw new JsonMappingException("Illegal key-type annotation: type " + javaType + " is not a Map(-like) type");
                }
                try {
                    t2 = (T) javaType.narrowKey(clsFindDeserializationKeyType);
                } catch (IllegalArgumentException e2) {
                    throw new JsonMappingException("Failed to narrow key type " + javaType + " with key-type annotation (" + clsFindDeserializationKeyType.getName() + "): " + e2.getMessage(), null, e2);
                }
            }
            JavaType keyType = t2.getKeyType();
            JavaType javaType3 = t2;
            if (keyType != null) {
                javaType3 = t2;
                if (keyType.getValueHandler() == null) {
                    KeyDeserializer keyDeserializerKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotated, annotationIntrospector.findKeyDeserializer(annotated));
                    javaType3 = t2;
                    if (keyDeserializerKeyDeserializerInstance != null) {
                        MapLikeType mapLikeTypeWithKeyValueHandler = ((MapLikeType) t2).withKeyValueHandler(keyDeserializerKeyDeserializerInstance);
                        mapLikeTypeWithKeyValueHandler.getKeyType();
                        javaType3 = mapLikeTypeWithKeyValueHandler;
                    }
                }
            }
            Class<?> clsFindDeserializationContentType = annotationIntrospector.findDeserializationContentType(annotated, javaType3.getContentType());
            JavaType javaTypeNarrowContentsBy = javaType3;
            if (clsFindDeserializationContentType != null) {
                try {
                    javaTypeNarrowContentsBy = javaType3.narrowContentsBy(clsFindDeserializationContentType);
                } catch (IllegalArgumentException e3) {
                    throw new JsonMappingException("Failed to narrow content type " + javaType3 + " with content-type annotation (" + clsFindDeserializationContentType.getName() + "): " + e3.getMessage(), null, e3);
                }
            }
            Object valueHandler = javaTypeNarrowContentsBy.getContentType().getValueHandler();
            javaType2 = javaTypeNarrowContentsBy;
            if (valueHandler == null) {
                JsonDeserializer<Object> jsonDeserializerDeserializerInstance = deserializationContext.deserializerInstance(annotated, annotationIntrospector.findContentDeserializer(annotated));
                javaType2 = javaTypeNarrowContentsBy;
                if (jsonDeserializerDeserializerInstance != null) {
                    return (T) javaTypeNarrowContentsBy.withContentValueHandler(jsonDeserializerDeserializerInstance);
                }
            }
        }
        return (T) javaType2;
    }

    protected JavaType resolveType(DeserializationContext deserializationContext, BeanDescription beanDescription, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeDeserializer typeDeserializerFindTypeDeserializer;
        TypeDeserializer typeDeserializerFindPropertyContentTypeDeserializer;
        KeyDeserializer keyDeserializerKeyDeserializerInstance;
        if (javaType.isContainerType()) {
            AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
            if (javaType.getKeyType() != null && (keyDeserializerKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember))) != null) {
                javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerKeyDeserializerInstance);
                javaType.getKeyType();
            }
            JsonDeserializer<Object> jsonDeserializerDeserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (jsonDeserializerDeserializerInstance != null) {
                javaType = javaType.withContentValueHandler(jsonDeserializerDeserializerInstance);
            }
            if ((annotatedMember instanceof AnnotatedMember) && (typeDeserializerFindPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember)) != null) {
                javaType = javaType.withContentTypeHandler(typeDeserializerFindPropertyContentTypeDeserializer);
            }
        }
        if (annotatedMember instanceof AnnotatedMember) {
            typeDeserializerFindTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        } else {
            typeDeserializerFindTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), javaType);
        }
        return typeDeserializerFindTypeDeserializer != null ? javaType.withTypeHandler(typeDeserializerFindTypeDeserializer) : javaType;
    }

    protected EnumResolver<?> constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMethod annotatedMethod) throws SecurityException {
        if (annotatedMethod != null) {
            Method annotated = annotatedMethod.getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(annotated);
            }
            return EnumResolver.constructUnsafeUsingMethod(cls, annotated);
        }
        if (deserializationConfig.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
            return EnumResolver.constructUnsafeUsingToString(cls);
        }
        return EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
    }

    protected AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return deserializationConfig.introspect(javaType).findJsonValueMethod();
    }
}
