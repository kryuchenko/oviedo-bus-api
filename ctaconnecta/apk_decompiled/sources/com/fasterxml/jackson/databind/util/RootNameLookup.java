package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class RootNameLookup implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient LRUMap<ClassKey, SerializedString> _rootNames;

    public SerializedString findRootName(JavaType javaType, MapperConfig<?> mapperConfig) {
        return findRootName(javaType.getRawClass(), mapperConfig);
    }

    public SerializedString findRootName(Class<?> cls, MapperConfig<?> mapperConfig) {
        String simpleName;
        ClassKey classKey = new ClassKey(cls);
        synchronized (this) {
            LRUMap<ClassKey, SerializedString> lRUMap = this._rootNames;
            if (lRUMap == null) {
                this._rootNames = new LRUMap<>(20, 200);
            } else {
                SerializedString serializedString = lRUMap.get(classKey);
                if (serializedString != null) {
                    return serializedString;
                }
            }
            PropertyName propertyNameFindRootName = mapperConfig.getAnnotationIntrospector().findRootName(mapperConfig.introspectClassAnnotations(cls).getClassInfo());
            if (propertyNameFindRootName == null || !propertyNameFindRootName.hasSimpleName()) {
                simpleName = cls.getSimpleName();
            } else {
                simpleName = propertyNameFindRootName.getSimpleName();
            }
            SerializedString serializedString2 = new SerializedString(simpleName);
            synchronized (this) {
                this._rootNames.put(classKey, serializedString2);
            }
            return serializedString2;
        }
    }
}
