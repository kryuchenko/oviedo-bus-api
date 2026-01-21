package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.PropertyName;
import com.google.maps.android.BuildConfig;

/* loaded from: classes3.dex */
public class ObjectIdInfo {
    protected final boolean _alwaysAsId;
    protected final Class<? extends ObjectIdGenerator<?>> _generator;
    protected final PropertyName _propertyName;
    protected final Class<?> _scope;

    public ObjectIdInfo(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2) {
        this(propertyName, cls, cls2, false);
    }

    @Deprecated
    public ObjectIdInfo(String str, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2) {
        this(new PropertyName(str), cls, cls2, false);
    }

    protected ObjectIdInfo(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, boolean z) {
        this._propertyName = propertyName;
        this._scope = cls;
        this._generator = cls2;
        this._alwaysAsId = z;
    }

    public ObjectIdInfo withAlwaysAsId(boolean z) {
        return this._alwaysAsId == z ? this : new ObjectIdInfo(this._propertyName, this._scope, this._generator, z);
    }

    public PropertyName getPropertyName() {
        return this._propertyName;
    }

    public Class<?> getScope() {
        return this._scope;
    }

    public Class<? extends ObjectIdGenerator<?>> getGeneratorType() {
        return this._generator;
    }

    public boolean getAlwaysAsId() {
        return this._alwaysAsId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectIdInfo: propName=");
        sb.append(this._propertyName);
        sb.append(", scope=");
        Class<?> cls = this._scope;
        String name = BuildConfig.TRAVIS;
        sb.append(cls == null ? BuildConfig.TRAVIS : cls.getName());
        sb.append(", generatorType=");
        Class<? extends ObjectIdGenerator<?>> cls2 = this._generator;
        if (cls2 != null) {
            name = cls2.getName();
        }
        sb.append(name);
        sb.append(", alwaysAsId=");
        sb.append(this._alwaysAsId);
        return sb.toString();
    }
}
