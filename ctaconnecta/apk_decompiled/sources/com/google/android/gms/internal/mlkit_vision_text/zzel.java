package com.google.android.gms.internal.mlkit_vision_text;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public enum zzel implements zzga {
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

    private static final zzgd<zzel> zzq = new zzgd<zzel>() { // from class: com.google.android.gms.internal.mlkit_vision_text.zzen
    };
    private final int zzr;

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzga
    public final int zza() {
        return this.zzr;
    }

    public static zzgc zzb() {
        return zzem.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + Typography.greater;
    }

    zzel(int i) {
        this.zzr = i;
    }
}
