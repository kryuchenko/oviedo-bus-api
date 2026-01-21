package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public enum zzhj {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzfm.class, zzfm.class, zzfm.zzsm),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> zzyh;
    private final Class<?> zzyi;
    private final Object zzyj;

    zzhj(Class cls, Class cls2, Object obj) {
        this.zzyh = cls;
        this.zzyi = cls2;
        this.zzyj = obj;
    }

    public final Class<?> zzgw() {
        return this.zzyi;
    }
}
