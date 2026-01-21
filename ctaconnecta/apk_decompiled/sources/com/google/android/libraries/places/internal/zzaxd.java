package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public enum zzaxd {
    DOUBLE(zzaxe.DOUBLE, 1),
    FLOAT(zzaxe.FLOAT, 5),
    INT64(zzaxe.LONG, 0),
    UINT64(zzaxe.LONG, 0),
    INT32(zzaxe.INT, 0),
    FIXED64(zzaxe.LONG, 1),
    FIXED32(zzaxe.INT, 5),
    BOOL(zzaxe.BOOLEAN, 0),
    STRING(zzaxe.STRING, 2),
    GROUP(zzaxe.MESSAGE, 3),
    MESSAGE(zzaxe.MESSAGE, 2),
    BYTES(zzaxe.BYTE_STRING, 2),
    UINT32(zzaxe.INT, 0),
    ENUM(zzaxe.ENUM, 0),
    SFIXED32(zzaxe.INT, 5),
    SFIXED64(zzaxe.LONG, 1),
    SINT32(zzaxe.INT, 0),
    SINT64(zzaxe.LONG, 0);

    private final zzaxe zzt;

    zzaxd(zzaxe zzaxeVar, int i) {
        this.zzt = zzaxeVar;
    }

    public final zzaxe zza() {
        return this.zzt;
    }
}
