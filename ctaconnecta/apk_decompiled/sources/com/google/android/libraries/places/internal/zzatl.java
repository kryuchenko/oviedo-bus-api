package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public enum zzatl {
    DOUBLE(0, 1, zzaug.DOUBLE),
    FLOAT(1, 1, zzaug.FLOAT),
    INT64(2, 1, zzaug.LONG),
    UINT64(3, 1, zzaug.LONG),
    INT32(4, 1, zzaug.INT),
    FIXED64(5, 1, zzaug.LONG),
    FIXED32(6, 1, zzaug.INT),
    BOOL(7, 1, zzaug.BOOLEAN),
    STRING(8, 1, zzaug.STRING),
    MESSAGE(9, 1, zzaug.MESSAGE),
    BYTES(10, 1, zzaug.BYTE_STRING),
    UINT32(11, 1, zzaug.INT),
    ENUM(12, 1, zzaug.ENUM),
    SFIXED32(13, 1, zzaug.INT),
    SFIXED64(14, 1, zzaug.LONG),
    SINT32(15, 1, zzaug.INT),
    SINT64(16, 1, zzaug.LONG),
    GROUP(17, 1, zzaug.MESSAGE),
    DOUBLE_LIST(18, 2, zzaug.DOUBLE),
    FLOAT_LIST(19, 2, zzaug.FLOAT),
    INT64_LIST(20, 2, zzaug.LONG),
    UINT64_LIST(21, 2, zzaug.LONG),
    INT32_LIST(22, 2, zzaug.INT),
    FIXED64_LIST(23, 2, zzaug.LONG),
    FIXED32_LIST(24, 2, zzaug.INT),
    BOOL_LIST(25, 2, zzaug.BOOLEAN),
    STRING_LIST(26, 2, zzaug.STRING),
    MESSAGE_LIST(27, 2, zzaug.MESSAGE),
    BYTES_LIST(28, 2, zzaug.BYTE_STRING),
    UINT32_LIST(29, 2, zzaug.INT),
    ENUM_LIST(30, 2, zzaug.ENUM),
    SFIXED32_LIST(31, 2, zzaug.INT),
    SFIXED64_LIST(32, 2, zzaug.LONG),
    SINT32_LIST(33, 2, zzaug.INT),
    SINT64_LIST(34, 2, zzaug.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzaug.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzaug.FLOAT),
    INT64_LIST_PACKED(37, 3, zzaug.LONG),
    UINT64_LIST_PACKED(38, 3, zzaug.LONG),
    INT32_LIST_PACKED(39, 3, zzaug.INT),
    FIXED64_LIST_PACKED(40, 3, zzaug.LONG),
    FIXED32_LIST_PACKED(41, 3, zzaug.INT),
    BOOL_LIST_PACKED(42, 3, zzaug.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzaug.INT),
    ENUM_LIST_PACKED(44, 3, zzaug.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzaug.INT),
    SFIXED64_LIST_PACKED(46, 3, zzaug.LONG),
    SINT32_LIST_PACKED(47, 3, zzaug.INT),
    SINT64_LIST_PACKED(48, 3, zzaug.LONG),
    GROUP_LIST(49, 2, zzaug.MESSAGE),
    MAP(50, 4, zzaug.VOID);

    private static final zzatl[] zzZ;
    private final zzaug zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzatl[] zzatlVarArrValues = values();
        zzZ = new zzatl[zzatlVarArrValues.length];
        for (zzatl zzatlVar : zzatlVarArrValues) {
            zzZ[zzatlVar.zzac] = zzatlVar;
        }
    }

    zzatl(int i, int i2, zzaug zzaugVar) {
        this.zzac = i;
        this.zzab = zzaugVar;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzaugVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzaug zzaugVar2 = zzaug.VOID;
            zzaugVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
