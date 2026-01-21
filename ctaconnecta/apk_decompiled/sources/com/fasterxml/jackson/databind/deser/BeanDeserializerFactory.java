package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.iecisa.ctausuario.utils.Constants;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    private static final Class<?>[] NO_VIEWS = new Class[0];
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final long serialVersionUID = 1;

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    @Override // com.fasterxml.jackson.databind.deser.BasicDeserializerFactory
    public DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        if (getClass() != BeanDeserializerFactory.class) {
            throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with additional deserializer definitions");
        }
        return new BeanDeserializerFactory(deserializerFactoryConfig);
    }

    protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Iterator<Deserializers> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            JsonDeserializer<?> jsonDeserializerFindBeanDeserializer = it.next().findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            if (jsonDeserializerFindBeanDeserializer != null) {
                return jsonDeserializerFindBeanDeserializer;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType javaTypeMaterializeAbstractType;
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<Object> jsonDeserializer_findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, beanDescription);
        if (jsonDeserializer_findCustomBeanDeserializer != null) {
            return jsonDeserializer_findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, beanDescription);
        }
        if (javaType.isAbstract() && (javaTypeMaterializeAbstractType = materializeAbstractType(deserializationContext, javaType, beanDescription)) != null) {
            return buildBeanDeserializer(deserializationContext, javaTypeMaterializeAbstractType, config.introspect(javaTypeMaterializeAbstractType));
        }
        JsonDeserializer<?> jsonDeserializerFindStdDeserializer = findStdDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindStdDeserializer != null) {
            return jsonDeserializerFindStdDeserializer;
        }
        if (isPotentialBeanType(javaType.getRawClass())) {
            return buildBeanDeserializer(deserializationContext, javaType, beanDescription);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription, Class<?> cls) throws JsonMappingException {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.constructType(cls)));
    }

    protected JsonDeserializer<?> findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType javaTypeUnknownType;
        JsonDeserializer<?> jsonDeserializerFindDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindDefaultDeserializer != null) {
            return jsonDeserializerFindDefaultDeserializer;
        }
        if (AtomicReference.class.isAssignableFrom(javaType.getRawClass())) {
            JavaType[] javaTypeArrFindTypeParameters = deserializationContext.getTypeFactory().findTypeParameters(javaType, AtomicReference.class);
            if (javaTypeArrFindTypeParameters == null || javaTypeArrFindTypeParameters.length < 1) {
                javaTypeUnknownType = TypeFactory.unknownType();
            } else {
                javaTypeUnknownType = javaTypeArrFindTypeParameters[0];
            }
            return new AtomicReferenceDeserializer(javaTypeUnknownType, findTypeDeserializer(deserializationContext.getConfig(), javaTypeUnknownType), findDeserializerFromAnnotation(deserializationContext, deserializationContext.getConfig().introspectClassAnnotations(javaTypeUnknownType).getClassInfo()));
        }
        return findOptionalStdDeserializer(deserializationContext, javaType, beanDescription);
    }

    protected JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), beanDescription);
    }

    protected JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType type = beanDescription.getType();
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeResolveAbstractType = it.next().resolveAbstractType(deserializationContext.getConfig(), type);
            if (javaTypeResolveAbstractType != null) {
                return javaTypeResolveAbstractType;
            }
        }
        return null;
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        JsonDeserializer<?> jsonDeserializerBuild;
        ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        DeserializationConfig config = deserializationContext.getConfig();
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            }
        }
        if (javaType.isAbstract() && !valueInstantiatorFindValueInstantiator.canInstantiate()) {
            jsonDeserializerBuild = beanDeserializerBuilderConstructBeanDeserializerBuilder.buildAbstract();
        } else {
            jsonDeserializerBuild = beanDeserializerBuilderConstructBeanDeserializerBuilder.build();
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializerBuild = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuild);
            }
        }
        return jsonDeserializerBuild;
    }

    protected JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        JsonPOJOBuilder.Value valueFindPOJOBuilderConfig = beanDescription.findPOJOBuilderConfig();
        String str = valueFindPOJOBuilderConfig == null ? "build" : valueFindPOJOBuilderConfig.buildMethodName;
        AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod(str, null);
        if (annotatedMethodFindMethod != null && config.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotatedMethodFindMethod.getMember());
        }
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setPOJOBuilder(annotatedMethodFindMethod, valueFindPOJOBuilderConfig);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> jsonDeserializerBuildBuilderBased = beanDeserializerBuilderConstructBeanDeserializerBuilder.buildBuilderBased(javaType, str);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializerBuildBuilderBased = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuildBuilderBased);
            }
        }
        return jsonDeserializerBuildBuilderBased;
    }

    protected void addObjectIdReader(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        SettableBeanProperty settableBeanPropertyFindProperty;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        JavaType type;
        ObjectIdInfo objectIdInfo = beanDescription.getObjectIdInfo();
        if (objectIdInfo == null) {
            return;
        }
        Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfo.getGeneratorType();
        if (generatorType == ObjectIdGenerators.PropertyGenerator.class) {
            PropertyName propertyName = objectIdInfo.getPropertyName();
            settableBeanPropertyFindProperty = beanDeserializerBuilder.findProperty(propertyName);
            if (settableBeanPropertyFindProperty == null) {
                throw new IllegalArgumentException("Invalid Object Id definition for " + beanDescription.getBeanClass().getName() + ": can not find property with name '" + propertyName + "'");
            }
            type = settableBeanPropertyFindProperty.getType();
            objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
        } else {
            JavaType javaType = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType((Class<?>) generatorType), ObjectIdGenerator.class)[0];
            settableBeanPropertyFindProperty = null;
            objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(beanDescription.getClassInfo(), objectIdInfo);
            type = javaType;
        }
        beanDeserializerBuilder.setObjectIdReader(ObjectIdReader.construct(type, objectIdInfo.getPropertyName(), objectIdGeneratorObjectIdGeneratorInstance, (JsonDeserializer<?>) deserializationContext.findRootValueDeserializer(type), settableBeanPropertyFindProperty));
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws SecurityException, JsonMappingException {
        SettableBeanProperty settableBeanPropertyConstructSettableProperty;
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator(deserializationContext, beanDescription));
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (annotatedMethodFindMethod != null && (settableBeanPropertyConstructSettableProperty = constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), annotatedMethodFindMethod, "cause"), annotatedMethodFindMethod.getGenericParameterType(0))) != null) {
            beanDeserializerBuilderConstructBeanDeserializerBuilder.addOrReplaceProperty(settableBeanPropertyConstructSettableProperty, true);
        }
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable("localizedMessage");
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable("suppressed");
        beanDeserializerBuilderConstructBeanDeserializerBuilder.addIgnorable(Constants.Notification.DATA_MESSAGE);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            while (it.hasNext()) {
                beanDeserializerBuilderConstructBeanDeserializerBuilder = it.next().updateBuilder(config, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            }
        }
        JsonDeserializer<?> jsonDeserializerBuild = beanDeserializerBuilderConstructBeanDeserializerBuilder.build();
        if (jsonDeserializerBuild instanceof BeanDeserializer) {
            jsonDeserializerBuild = new ThrowableDeserializer((BeanDeserializer) jsonDeserializerBuild);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            while (it2.hasNext()) {
                jsonDeserializerBuild = it2.next().modifyDeserializer(config, beanDescription, jsonDeserializerBuild);
            }
        }
        return jsonDeserializerBuild;
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        return new BeanDeserializerBuilder(beanDescription, deserializationContext.getConfig());
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void addBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws SecurityException, JsonMappingException {
        SettableBeanProperty settableBeanPropertyConstructSetterlessProperty;
        Set<String> ignoredPropertyNames;
        SettableBeanProperty[] fromObjectArguments = beanDeserializerBuilder.getValueInstantiator().getFromObjectArguments(deserializationContext.getConfig());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Boolean boolFindIgnoreUnknownProperties = annotationIntrospector.findIgnoreUnknownProperties(beanDescription.getClassInfo());
        if (boolFindIgnoreUnknownProperties != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(boolFindIgnoreUnknownProperties.booleanValue());
        }
        HashSet hashSetArrayToSet = ArrayBuilders.arrayToSet(annotationIntrospector.findPropertiesToIgnore(beanDescription.getClassInfo()));
        Iterator<String> it = hashSetArrayToSet.iterator();
        while (it.hasNext()) {
            beanDeserializerBuilder.addIgnorable(it.next());
        }
        AnnotatedMethod annotatedMethodFindAnySetter = beanDescription.findAnySetter();
        if (annotatedMethodFindAnySetter != null) {
            beanDeserializerBuilder.setAnySetter(constructAnySetter(deserializationContext, beanDescription, annotatedMethodFindAnySetter));
        }
        if (annotatedMethodFindAnySetter == null && (ignoredPropertyNames = beanDescription.getIgnoredPropertyNames()) != null) {
            Iterator<String> it2 = ignoredPropertyNames.iterator();
            while (it2.hasNext()) {
                beanDeserializerBuilder.addIgnorable(it2.next());
            }
        }
        boolean z = deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
        List<BeanPropertyDefinition> listFilterBeanProps = filterBeanProps(deserializationContext, beanDescription, beanDeserializerBuilder, beanDescription.findProperties(), hashSetArrayToSet);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it3 = this._factoryConfig.deserializerModifiers().iterator();
            while (it3.hasNext()) {
                listFilterBeanProps = it3.next().updateProperties(deserializationContext.getConfig(), beanDescription, listFilterBeanProps);
            }
        }
        for (BeanPropertyDefinition beanPropertyDefinition : listFilterBeanProps) {
            CreatorProperty creatorPropertyWithFallbackSetter = null;
            if (beanPropertyDefinition.hasSetter()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getSetter().getGenericParameterType(0));
            } else if (beanPropertyDefinition.hasField()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getField().getGenericType());
            } else if (z && beanPropertyDefinition.hasGetter()) {
                Class<?> rawType = beanPropertyDefinition.getGetter().getRawType();
                if (Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType)) {
                    settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, beanDescription, beanPropertyDefinition);
                }
            } else {
                settableBeanPropertyConstructSetterlessProperty = null;
            }
            if (beanPropertyDefinition.hasConstructorParameter()) {
                String name = beanPropertyDefinition.getName();
                if (fromObjectArguments != null) {
                    int length = fromObjectArguments.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        SettableBeanProperty settableBeanProperty = fromObjectArguments[i];
                        if (name.equals(settableBeanProperty.getName())) {
                            creatorPropertyWithFallbackSetter = (CreatorProperty) settableBeanProperty;
                            break;
                        }
                        i++;
                    }
                }
                if (creatorPropertyWithFallbackSetter == null) {
                    throw deserializationContext.mappingException("Could not find creator property with name '" + name + "' (in class " + beanDescription.getBeanClass().getName() + ")");
                }
                if (settableBeanPropertyConstructSetterlessProperty != null) {
                    creatorPropertyWithFallbackSetter = creatorPropertyWithFallbackSetter.withFallbackSetter(settableBeanPropertyConstructSetterlessProperty);
                }
                beanDeserializerBuilder.addCreatorProperty(creatorPropertyWithFallbackSetter);
            } else if (settableBeanPropertyConstructSetterlessProperty != null) {
                Class<?>[] clsArrFindViews = beanPropertyDefinition.findViews();
                if (clsArrFindViews == null && !deserializationContext.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                    clsArrFindViews = NO_VIEWS;
                }
                settableBeanPropertyConstructSetterlessProperty.setViews(clsArrFindViews);
                beanDeserializerBuilder.addProperty(settableBeanPropertyConstructSetterlessProperty);
            }
        }
    }

    protected List<BeanPropertyDefinition> filterBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder, List<BeanPropertyDefinition> list, Set<String> set) throws JsonMappingException {
        Class<?> rawType;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap map = new HashMap();
        for (BeanPropertyDefinition beanPropertyDefinition : list) {
            String name = beanPropertyDefinition.getName();
            if (!set.contains(name)) {
                if (!beanPropertyDefinition.hasConstructorParameter()) {
                    if (beanPropertyDefinition.hasSetter()) {
                        rawType = beanPropertyDefinition.getSetter().getRawParameterType(0);
                    } else {
                        rawType = beanPropertyDefinition.hasField() ? beanPropertyDefinition.getField().getRawType() : null;
                    }
                    if (rawType != null && isIgnorableType(deserializationContext.getConfig(), beanDescription, rawType, map)) {
                        beanDeserializerBuilder.addIgnorable(name);
                    }
                }
                arrayList.add(beanPropertyDefinition);
            }
        }
        return arrayList;
    }

    protected void addReferenceProperties(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws JsonMappingException {
        Type rawType;
        Map<String, AnnotatedMember> mapFindBackReferenceProperties = beanDescription.findBackReferenceProperties();
        if (mapFindBackReferenceProperties != null) {
            for (Map.Entry<String, AnnotatedMember> entry : mapFindBackReferenceProperties.entrySet()) {
                String key = entry.getKey();
                AnnotatedMember value = entry.getValue();
                if (value instanceof AnnotatedMethod) {
                    rawType = ((AnnotatedMethod) value).getGenericParameterType(0);
                } else {
                    rawType = value.getRawType();
                }
                beanDeserializerBuilder.addBackReferenceProperty(key, constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), value), rawType));
            }
        }
    }

    protected void addInjectables(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws SecurityException, JsonMappingException {
        Map<Object, AnnotatedMember> mapFindInjectables = beanDescription.findInjectables();
        if (mapFindInjectables != null) {
            boolean zCanOverrideAccessModifiers = deserializationContext.canOverrideAccessModifiers();
            for (Map.Entry<Object, AnnotatedMember> entry : mapFindInjectables.entrySet()) {
                AnnotatedMember value = entry.getValue();
                if (zCanOverrideAccessModifiers) {
                    value.fixAccess();
                }
                beanDeserializerBuilder.addInjectable(new PropertyName(value.getName()), beanDescription.resolveType(value.getGenericType()), beanDescription.getClassAnnotations(), value, entry.getKey());
            }
        }
    }

    protected SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedMethod annotatedMethod) throws JsonMappingException {
        if (deserializationContext.canOverrideAccessModifiers()) {
            annotatedMethod.fixAccess();
        }
        JavaType javaTypeResolveType = beanDescription.bindingsForBeanType().resolveType(annotatedMethod.getGenericParameterType(1));
        BeanProperty.Std std = new BeanProperty.Std(new PropertyName(annotatedMethod.getName()), javaTypeResolveType, (PropertyName) null, beanDescription.getClassAnnotations(), annotatedMethod, PropertyMetadata.STD_OPTIONAL);
        JavaType javaTypeResolveType2 = resolveType(deserializationContext, beanDescription, javaTypeResolveType, annotatedMethod);
        JsonDeserializer<Object> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMethod);
        JavaType javaTypeModifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, annotatedMethod, javaTypeResolveType2);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeModifyTypeByAnnotation.getValueHandler();
        }
        return new SettableAnyProperty(std, annotatedMethod, javaTypeModifyTypeByAnnotation, jsonDeserializerFindDeserializerFromAnnotation, (TypeDeserializer) javaTypeModifyTypeByAnnotation.getTypeHandler());
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, Type type) throws SecurityException, JsonMappingException {
        SettableBeanProperty fieldProperty;
        AnnotatedMember nonConstructorMutator = beanPropertyDefinition.getNonConstructorMutator();
        if (deserializationContext.canOverrideAccessModifiers()) {
            nonConstructorMutator.fixAccess();
        }
        JavaType javaTypeResolveType = beanDescription.resolveType(type);
        BeanProperty.Std std = new BeanProperty.Std(beanPropertyDefinition.getFullName(), javaTypeResolveType, beanPropertyDefinition.getWrapperName(), beanDescription.getClassAnnotations(), nonConstructorMutator, beanPropertyDefinition.getMetadata());
        JavaType javaTypeResolveType2 = resolveType(deserializationContext, beanDescription, javaTypeResolveType, nonConstructorMutator);
        if (javaTypeResolveType2 != javaTypeResolveType) {
            std.withType(javaTypeResolveType2);
        }
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, nonConstructorMutator);
        JavaType javaTypeModifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, nonConstructorMutator, javaTypeResolveType2);
        TypeDeserializer typeDeserializer = (TypeDeserializer) javaTypeModifyTypeByAnnotation.getTypeHandler();
        if (nonConstructorMutator instanceof AnnotatedMethod) {
            fieldProperty = new MethodProperty(beanPropertyDefinition, javaTypeModifyTypeByAnnotation, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedMethod) nonConstructorMutator);
        } else {
            fieldProperty = new FieldProperty(beanPropertyDefinition, javaTypeModifyTypeByAnnotation, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedField) nonConstructorMutator);
        }
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            fieldProperty = fieldProperty.withValueDeserializer(jsonDeserializerFindDeserializerFromAnnotation);
        }
        AnnotationIntrospector.ReferenceProperty referencePropertyFindReferenceType = beanPropertyDefinition.findReferenceType();
        if (referencePropertyFindReferenceType != null && referencePropertyFindReferenceType.isManagedReference()) {
            fieldProperty.setManagedReferenceName(referencePropertyFindReferenceType.getName());
        }
        return fieldProperty;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) throws JsonMappingException {
        AnnotatedMethod getter = beanPropertyDefinition.getGetter();
        if (deserializationContext.canOverrideAccessModifiers()) {
            getter.fixAccess();
        }
        JavaType type = getter.getType(beanDescription.bindingsForBeanType());
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, getter);
        JavaType javaTypeModifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, getter, type);
        SetterlessProperty setterlessProperty = new SetterlessProperty(beanPropertyDefinition, javaTypeModifyTypeByAnnotation, (TypeDeserializer) javaTypeModifyTypeByAnnotation.getTypeHandler(), beanDescription.getClassAnnotations(), getter);
        return jsonDeserializerFindDeserializerFromAnnotation != null ? setterlessProperty.withValueDeserializer(jsonDeserializerFindDeserializerFromAnnotation) : setterlessProperty;
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        String strCanBeABeanType = ClassUtil.canBeABeanType(cls);
        if (strCanBeABeanType != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + strCanBeABeanType + ") as a Bean");
        }
        if (ClassUtil.isProxyType(cls)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        }
        String strIsLocalType = ClassUtil.isLocalType(cls, true);
        if (strIsLocalType == null) {
            return true;
        }
        throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + strIsLocalType + ") as a Bean");
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationConfig, BeanDescription beanDescription, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean boolIsIgnorableType = map.get(cls);
        if (boolIsIgnorableType == null) {
            boolIsIgnorableType = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations(cls).getClassInfo());
            if (boolIsIgnorableType == null) {
                boolIsIgnorableType = Boolean.FALSE;
            }
        }
        return boolIsIgnorableType.booleanValue();
    }
}
