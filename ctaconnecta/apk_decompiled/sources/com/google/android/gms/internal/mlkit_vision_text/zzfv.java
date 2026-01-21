package com.google.android.gms.internal.mlkit_vision_text;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzfv {
    DOUBLE(0, zzfx.SCALAR, zzgi.DOUBLE),
    FLOAT(1, zzfx.SCALAR, zzgi.FLOAT),
    INT64(2, zzfx.SCALAR, zzgi.LONG),
    UINT64(3, zzfx.SCALAR, zzgi.LONG),
    INT32(4, zzfx.SCALAR, zzgi.INT),
    FIXED64(5, zzfx.SCALAR, zzgi.LONG),
    FIXED32(6, zzfx.SCALAR, zzgi.INT),
    BOOL(7, zzfx.SCALAR, zzgi.BOOLEAN),
    STRING(8, zzfx.SCALAR, zzgi.STRING),
    MESSAGE(9, zzfx.SCALAR, zzgi.MESSAGE),
    BYTES(10, zzfx.SCALAR, zzgi.BYTE_STRING),
    UINT32(11, zzfx.SCALAR, zzgi.INT),
    ENUM(12, zzfx.SCALAR, zzgi.ENUM),
    SFIXED32(13, zzfx.SCALAR, zzgi.INT),
    SFIXED64(14, zzfx.SCALAR, zzgi.LONG),
    SINT32(15, zzfx.SCALAR, zzgi.INT),
    SINT64(16, zzfx.SCALAR, zzgi.LONG),
    GROUP(17, zzfx.SCALAR, zzgi.MESSAGE),
    DOUBLE_LIST(18, zzfx.VECTOR, zzgi.DOUBLE),
    FLOAT_LIST(19, zzfx.VECTOR, zzgi.FLOAT),
    INT64_LIST(20, zzfx.VECTOR, zzgi.LONG),
    UINT64_LIST(21, zzfx.VECTOR, zzgi.LONG),
    INT32_LIST(22, zzfx.VECTOR, zzgi.INT),
    FIXED64_LIST(23, zzfx.VECTOR, zzgi.LONG),
    FIXED32_LIST(24, zzfx.VECTOR, zzgi.INT),
    BOOL_LIST(25, zzfx.VECTOR, zzgi.BOOLEAN),
    STRING_LIST(26, zzfx.VECTOR, zzgi.STRING),
    MESSAGE_LIST(27, zzfx.VECTOR, zzgi.MESSAGE),
    BYTES_LIST(28, zzfx.VECTOR, zzgi.BYTE_STRING),
    UINT32_LIST(29, zzfx.VECTOR, zzgi.INT),
    ENUM_LIST(30, zzfx.VECTOR, zzgi.ENUM),
    SFIXED32_LIST(31, zzfx.VECTOR, zzgi.INT),
    SFIXED64_LIST(32, zzfx.VECTOR, zzgi.LONG),
    SINT32_LIST(33, zzfx.VECTOR, zzgi.INT),
    SINT64_LIST(34, zzfx.VECTOR, zzgi.LONG),
    DOUBLE_LIST_PACKED(35, zzfx.PACKED_VECTOR, zzgi.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfx.PACKED_VECTOR, zzgi.FLOAT),
    INT64_LIST_PACKED(37, zzfx.PACKED_VECTOR, zzgi.LONG),
    UINT64_LIST_PACKED(38, zzfx.PACKED_VECTOR, zzgi.LONG),
    INT32_LIST_PACKED(39, zzfx.PACKED_VECTOR, zzgi.INT),
    FIXED64_LIST_PACKED(40, zzfx.PACKED_VECTOR, zzgi.LONG),
    FIXED32_LIST_PACKED(41, zzfx.PACKED_VECTOR, zzgi.INT),
    BOOL_LIST_PACKED(42, zzfx.PACKED_VECTOR, zzgi.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfx.PACKED_VECTOR, zzgi.INT),
    ENUM_LIST_PACKED(44, zzfx.PACKED_VECTOR, zzgi.ENUM),
    SFIXED32_LIST_PACKED(45, zzfx.PACKED_VECTOR, zzgi.INT),
    SFIXED64_LIST_PACKED(46, zzfx.PACKED_VECTOR, zzgi.LONG),
    SINT32_LIST_PACKED(47, zzfx.PACKED_VECTOR, zzgi.INT),
    SINT64_LIST_PACKED(48, zzfx.PACKED_VECTOR, zzgi.LONG),
    GROUP_LIST(49, zzfx.VECTOR, zzgi.MESSAGE),
    MAP(50, zzfx.MAP, zzgi.VOID);

    private static final zzfv[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzgi zzaz;
    private final int zzba;
    private final zzfx zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    zzfv(int i, zzfx zzfxVar, zzgi zzgiVar) {
        int i2;
        this.zzba = i;
        this.zzbb = zzfxVar;
        this.zzaz = zzgiVar;
        int i3 = zzfu.zza[zzfxVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.zzbc = zzgiVar.zza();
        } else {
            this.zzbc = null;
        }
        this.zzbd = (zzfxVar != zzfx.SCALAR || (i2 = zzfu.zzb[zzgiVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzfv[] zzfvVarArrValues = values();
        zzbe = new zzfv[zzfvVarArrValues.length];
        for (zzfv zzfvVar : zzfvVarArrValues) {
            zzbe[zzfvVar.zzba] = zzfvVar;
        }
    }
}
