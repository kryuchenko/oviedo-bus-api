package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Type;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzeg {
    DOUBLE(0, zzei.SCALAR, zzex.DOUBLE),
    FLOAT(1, zzei.SCALAR, zzex.FLOAT),
    INT64(2, zzei.SCALAR, zzex.LONG),
    UINT64(3, zzei.SCALAR, zzex.LONG),
    INT32(4, zzei.SCALAR, zzex.INT),
    FIXED64(5, zzei.SCALAR, zzex.LONG),
    FIXED32(6, zzei.SCALAR, zzex.INT),
    BOOL(7, zzei.SCALAR, zzex.BOOLEAN),
    STRING(8, zzei.SCALAR, zzex.STRING),
    MESSAGE(9, zzei.SCALAR, zzex.MESSAGE),
    BYTES(10, zzei.SCALAR, zzex.BYTE_STRING),
    UINT32(11, zzei.SCALAR, zzex.INT),
    ENUM(12, zzei.SCALAR, zzex.ENUM),
    SFIXED32(13, zzei.SCALAR, zzex.INT),
    SFIXED64(14, zzei.SCALAR, zzex.LONG),
    SINT32(15, zzei.SCALAR, zzex.INT),
    SINT64(16, zzei.SCALAR, zzex.LONG),
    GROUP(17, zzei.SCALAR, zzex.MESSAGE),
    DOUBLE_LIST(18, zzei.VECTOR, zzex.DOUBLE),
    FLOAT_LIST(19, zzei.VECTOR, zzex.FLOAT),
    INT64_LIST(20, zzei.VECTOR, zzex.LONG),
    UINT64_LIST(21, zzei.VECTOR, zzex.LONG),
    INT32_LIST(22, zzei.VECTOR, zzex.INT),
    FIXED64_LIST(23, zzei.VECTOR, zzex.LONG),
    FIXED32_LIST(24, zzei.VECTOR, zzex.INT),
    BOOL_LIST(25, zzei.VECTOR, zzex.BOOLEAN),
    STRING_LIST(26, zzei.VECTOR, zzex.STRING),
    MESSAGE_LIST(27, zzei.VECTOR, zzex.MESSAGE),
    BYTES_LIST(28, zzei.VECTOR, zzex.BYTE_STRING),
    UINT32_LIST(29, zzei.VECTOR, zzex.INT),
    ENUM_LIST(30, zzei.VECTOR, zzex.ENUM),
    SFIXED32_LIST(31, zzei.VECTOR, zzex.INT),
    SFIXED64_LIST(32, zzei.VECTOR, zzex.LONG),
    SINT32_LIST(33, zzei.VECTOR, zzex.INT),
    SINT64_LIST(34, zzei.VECTOR, zzex.LONG),
    DOUBLE_LIST_PACKED(35, zzei.PACKED_VECTOR, zzex.DOUBLE),
    FLOAT_LIST_PACKED(36, zzei.PACKED_VECTOR, zzex.FLOAT),
    INT64_LIST_PACKED(37, zzei.PACKED_VECTOR, zzex.LONG),
    UINT64_LIST_PACKED(38, zzei.PACKED_VECTOR, zzex.LONG),
    INT32_LIST_PACKED(39, zzei.PACKED_VECTOR, zzex.INT),
    FIXED64_LIST_PACKED(40, zzei.PACKED_VECTOR, zzex.LONG),
    FIXED32_LIST_PACKED(41, zzei.PACKED_VECTOR, zzex.INT),
    BOOL_LIST_PACKED(42, zzei.PACKED_VECTOR, zzex.BOOLEAN),
    UINT32_LIST_PACKED(43, zzei.PACKED_VECTOR, zzex.INT),
    ENUM_LIST_PACKED(44, zzei.PACKED_VECTOR, zzex.ENUM),
    SFIXED32_LIST_PACKED(45, zzei.PACKED_VECTOR, zzex.INT),
    SFIXED64_LIST_PACKED(46, zzei.PACKED_VECTOR, zzex.LONG),
    SINT32_LIST_PACKED(47, zzei.PACKED_VECTOR, zzex.INT),
    SINT64_LIST_PACKED(48, zzei.PACKED_VECTOR, zzex.LONG),
    GROUP_LIST(49, zzei.VECTOR, zzex.MESSAGE),
    MAP(50, zzei.MAP, zzex.VOID);

    private static final zzeg[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzex zzaz;
    private final int zzba;
    private final zzei zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    zzeg(int i, zzei zzeiVar, zzex zzexVar) {
        int i2;
        this.zzba = i;
        this.zzbb = zzeiVar;
        this.zzaz = zzexVar;
        int i3 = zzej.zza[zzeiVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.zzbc = zzexVar.zza();
        } else {
            this.zzbc = null;
        }
        this.zzbd = (zzeiVar != zzei.SCALAR || (i2 = zzej.zzb[zzexVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzeg[] zzegVarArrValues = values();
        zzbe = new zzeg[zzegVarArrValues.length];
        for (zzeg zzegVar : zzegVarArrValues) {
            zzbe[zzegVar.zzba] = zzegVar;
        }
    }
}
