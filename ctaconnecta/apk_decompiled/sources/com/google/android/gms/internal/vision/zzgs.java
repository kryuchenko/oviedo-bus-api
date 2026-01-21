package com.google.android.gms.internal.vision;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public enum zzgs {
    DOUBLE(0, zzgu.SCALAR, zzhj.DOUBLE),
    FLOAT(1, zzgu.SCALAR, zzhj.FLOAT),
    INT64(2, zzgu.SCALAR, zzhj.LONG),
    UINT64(3, zzgu.SCALAR, zzhj.LONG),
    INT32(4, zzgu.SCALAR, zzhj.INT),
    FIXED64(5, zzgu.SCALAR, zzhj.LONG),
    FIXED32(6, zzgu.SCALAR, zzhj.INT),
    BOOL(7, zzgu.SCALAR, zzhj.BOOLEAN),
    STRING(8, zzgu.SCALAR, zzhj.STRING),
    MESSAGE(9, zzgu.SCALAR, zzhj.MESSAGE),
    BYTES(10, zzgu.SCALAR, zzhj.BYTE_STRING),
    UINT32(11, zzgu.SCALAR, zzhj.INT),
    ENUM(12, zzgu.SCALAR, zzhj.ENUM),
    SFIXED32(13, zzgu.SCALAR, zzhj.INT),
    SFIXED64(14, zzgu.SCALAR, zzhj.LONG),
    SINT32(15, zzgu.SCALAR, zzhj.INT),
    SINT64(16, zzgu.SCALAR, zzhj.LONG),
    GROUP(17, zzgu.SCALAR, zzhj.MESSAGE),
    DOUBLE_LIST(18, zzgu.VECTOR, zzhj.DOUBLE),
    FLOAT_LIST(19, zzgu.VECTOR, zzhj.FLOAT),
    INT64_LIST(20, zzgu.VECTOR, zzhj.LONG),
    UINT64_LIST(21, zzgu.VECTOR, zzhj.LONG),
    INT32_LIST(22, zzgu.VECTOR, zzhj.INT),
    FIXED64_LIST(23, zzgu.VECTOR, zzhj.LONG),
    FIXED32_LIST(24, zzgu.VECTOR, zzhj.INT),
    BOOL_LIST(25, zzgu.VECTOR, zzhj.BOOLEAN),
    STRING_LIST(26, zzgu.VECTOR, zzhj.STRING),
    MESSAGE_LIST(27, zzgu.VECTOR, zzhj.MESSAGE),
    BYTES_LIST(28, zzgu.VECTOR, zzhj.BYTE_STRING),
    UINT32_LIST(29, zzgu.VECTOR, zzhj.INT),
    ENUM_LIST(30, zzgu.VECTOR, zzhj.ENUM),
    SFIXED32_LIST(31, zzgu.VECTOR, zzhj.INT),
    SFIXED64_LIST(32, zzgu.VECTOR, zzhj.LONG),
    SINT32_LIST(33, zzgu.VECTOR, zzhj.INT),
    SINT64_LIST(34, zzgu.VECTOR, zzhj.LONG),
    DOUBLE_LIST_PACKED(35, zzgu.PACKED_VECTOR, zzhj.DOUBLE),
    FLOAT_LIST_PACKED(36, zzgu.PACKED_VECTOR, zzhj.FLOAT),
    INT64_LIST_PACKED(37, zzgu.PACKED_VECTOR, zzhj.LONG),
    UINT64_LIST_PACKED(38, zzgu.PACKED_VECTOR, zzhj.LONG),
    INT32_LIST_PACKED(39, zzgu.PACKED_VECTOR, zzhj.INT),
    FIXED64_LIST_PACKED(40, zzgu.PACKED_VECTOR, zzhj.LONG),
    FIXED32_LIST_PACKED(41, zzgu.PACKED_VECTOR, zzhj.INT),
    BOOL_LIST_PACKED(42, zzgu.PACKED_VECTOR, zzhj.BOOLEAN),
    UINT32_LIST_PACKED(43, zzgu.PACKED_VECTOR, zzhj.INT),
    ENUM_LIST_PACKED(44, zzgu.PACKED_VECTOR, zzhj.ENUM),
    SFIXED32_LIST_PACKED(45, zzgu.PACKED_VECTOR, zzhj.INT),
    SFIXED64_LIST_PACKED(46, zzgu.PACKED_VECTOR, zzhj.LONG),
    SINT32_LIST_PACKED(47, zzgu.PACKED_VECTOR, zzhj.INT),
    SINT64_LIST_PACKED(48, zzgu.PACKED_VECTOR, zzhj.LONG),
    GROUP_LIST(49, zzgu.VECTOR, zzhj.MESSAGE),
    MAP(50, zzgu.MAP, zzhj.VOID);

    private static final zzgs[] zzwc;
    private static final Type[] zzwd = new Type[0];
    private final int id;
    private final zzhj zzvy;
    private final zzgu zzvz;
    private final Class<?> zzwa;
    private final boolean zzwb;

    zzgs(int i, zzgu zzguVar, zzhj zzhjVar) {
        int i2;
        this.id = i;
        this.zzvz = zzguVar;
        this.zzvy = zzhjVar;
        int i3 = zzgr.zztx[zzguVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.zzwa = zzhjVar.zzgw();
        } else {
            this.zzwa = null;
        }
        this.zzwb = (zzguVar != zzgu.SCALAR || (i2 = zzgr.zzty[zzhjVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzgs[] zzgsVarArrValues = values();
        zzwc = new zzgs[zzgsVarArrValues.length];
        for (zzgs zzgsVar : zzgsVarArrValues) {
            zzwc[zzgsVar.id] = zzgsVar;
        }
    }
}
