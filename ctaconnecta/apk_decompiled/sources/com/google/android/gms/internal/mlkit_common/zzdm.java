package com.google.android.gms.internal.mlkit_common;

import kotlin.text.Typography;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzdm implements zzfb {
    UNRECOGNIZED(0),
    CODE_128(1),
    CODE_39(2),
    CODE_93(3),
    CODABAR(4),
    DATA_MATRIX(5),
    EAN_13(6),
    EAN_8(7),
    ITF(8),
    QR_CODE(9),
    UPC_A(10),
    UPC_E(11),
    PDF417(12),
    AZTEC(13),
    DATABAR(14),
    TEZ_CODE(16);

    private static final zzfe<zzdm> zzq = new zzfe<zzdm>() { // from class: com.google.android.gms.internal.mlkit_common.zzdo
    };
    private final int zzr;

    @Override // com.google.android.gms.internal.mlkit_common.zzfb
    public final int zza() {
        return this.zzr;
    }

    public static zzfd zzb() {
        return zzdn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + Typography.greater;
    }

    zzdm(int i) {
        this.zzr = i;
    }
}
