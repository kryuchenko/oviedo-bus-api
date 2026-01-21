package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Type;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzew {
    DOUBLE(0, zzey.SCALAR, zzfj.DOUBLE),
    FLOAT(1, zzey.SCALAR, zzfj.FLOAT),
    INT64(2, zzey.SCALAR, zzfj.LONG),
    UINT64(3, zzey.SCALAR, zzfj.LONG),
    INT32(4, zzey.SCALAR, zzfj.INT),
    FIXED64(5, zzey.SCALAR, zzfj.LONG),
    FIXED32(6, zzey.SCALAR, zzfj.INT),
    BOOL(7, zzey.SCALAR, zzfj.BOOLEAN),
    STRING(8, zzey.SCALAR, zzfj.STRING),
    MESSAGE(9, zzey.SCALAR, zzfj.MESSAGE),
    BYTES(10, zzey.SCALAR, zzfj.BYTE_STRING),
    UINT32(11, zzey.SCALAR, zzfj.INT),
    ENUM(12, zzey.SCALAR, zzfj.ENUM),
    SFIXED32(13, zzey.SCALAR, zzfj.INT),
    SFIXED64(14, zzey.SCALAR, zzfj.LONG),
    SINT32(15, zzey.SCALAR, zzfj.INT),
    SINT64(16, zzey.SCALAR, zzfj.LONG),
    GROUP(17, zzey.SCALAR, zzfj.MESSAGE),
    DOUBLE_LIST(18, zzey.VECTOR, zzfj.DOUBLE),
    FLOAT_LIST(19, zzey.VECTOR, zzfj.FLOAT),
    INT64_LIST(20, zzey.VECTOR, zzfj.LONG),
    UINT64_LIST(21, zzey.VECTOR, zzfj.LONG),
    INT32_LIST(22, zzey.VECTOR, zzfj.INT),
    FIXED64_LIST(23, zzey.VECTOR, zzfj.LONG),
    FIXED32_LIST(24, zzey.VECTOR, zzfj.INT),
    BOOL_LIST(25, zzey.VECTOR, zzfj.BOOLEAN),
    STRING_LIST(26, zzey.VECTOR, zzfj.STRING),
    MESSAGE_LIST(27, zzey.VECTOR, zzfj.MESSAGE),
    BYTES_LIST(28, zzey.VECTOR, zzfj.BYTE_STRING),
    UINT32_LIST(29, zzey.VECTOR, zzfj.INT),
    ENUM_LIST(30, zzey.VECTOR, zzfj.ENUM),
    SFIXED32_LIST(31, zzey.VECTOR, zzfj.INT),
    SFIXED64_LIST(32, zzey.VECTOR, zzfj.LONG),
    SINT32_LIST(33, zzey.VECTOR, zzfj.INT),
    SINT64_LIST(34, zzey.VECTOR, zzfj.LONG),
    DOUBLE_LIST_PACKED(35, zzey.PACKED_VECTOR, zzfj.DOUBLE),
    FLOAT_LIST_PACKED(36, zzey.PACKED_VECTOR, zzfj.FLOAT),
    INT64_LIST_PACKED(37, zzey.PACKED_VECTOR, zzfj.LONG),
    UINT64_LIST_PACKED(38, zzey.PACKED_VECTOR, zzfj.LONG),
    INT32_LIST_PACKED(39, zzey.PACKED_VECTOR, zzfj.INT),
    FIXED64_LIST_PACKED(40, zzey.PACKED_VECTOR, zzfj.LONG),
    FIXED32_LIST_PACKED(41, zzey.PACKED_VECTOR, zzfj.INT),
    BOOL_LIST_PACKED(42, zzey.PACKED_VECTOR, zzfj.BOOLEAN),
    UINT32_LIST_PACKED(43, zzey.PACKED_VECTOR, zzfj.INT),
    ENUM_LIST_PACKED(44, zzey.PACKED_VECTOR, zzfj.ENUM),
    SFIXED32_LIST_PACKED(45, zzey.PACKED_VECTOR, zzfj.INT),
    SFIXED64_LIST_PACKED(46, zzey.PACKED_VECTOR, zzfj.LONG),
    SINT32_LIST_PACKED(47, zzey.PACKED_VECTOR, zzfj.INT),
    SINT64_LIST_PACKED(48, zzey.PACKED_VECTOR, zzfj.LONG),
    GROUP_LIST(49, zzey.VECTOR, zzfj.MESSAGE),
    MAP(50, zzey.MAP, zzfj.VOID);

    private static final zzew[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzfj zzaz;
    private final int zzba;
    private final zzey zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    zzew(int i, zzey zzeyVar, zzfj zzfjVar) {
        int i2;
        this.zzba = i;
        this.zzbb = zzeyVar;
        this.zzaz = zzfjVar;
        int i3 = zzev.zza[zzeyVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.zzbc = zzfjVar.zza();
        } else {
            this.zzbc = null;
        }
        this.zzbd = (zzeyVar != zzey.SCALAR || (i2 = zzev.zzb[zzfjVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzew[] zzewVarArrValues = values();
        zzbe = new zzew[zzewVarArrValues.length];
        for (zzew zzewVar : zzewVarArrValues) {
            zzbe[zzewVar.zzba] = zzewVar;
        }
    }
}
