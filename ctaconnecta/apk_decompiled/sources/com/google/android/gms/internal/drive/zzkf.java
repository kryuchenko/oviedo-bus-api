package com.google.android.gms.internal.drive;

/* loaded from: classes3.dex */
final /* synthetic */ class zzkf {
    static final /* synthetic */ int[] zzre;
    static final /* synthetic */ int[] zzrf;

    static {
        int[] iArr = new int[zzks.values().length];
        zzrf = iArr;
        try {
            iArr[zzks.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzrf[zzks.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzrf[zzks.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[zzkg.values().length];
        zzre = iArr2;
        try {
            iArr2[zzkg.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zzre[zzkg.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            zzre[zzkg.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
