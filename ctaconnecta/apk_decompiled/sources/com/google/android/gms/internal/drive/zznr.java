package com.google.android.gms.internal.drive;

/* loaded from: classes3.dex */
public enum zznr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzjc.zznq),
    ENUM(null),
    MESSAGE(null);

    private final Object zztd;

    zznr(Object obj) {
        this.zztd = obj;
    }
}
