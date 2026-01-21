package com.google.android.libraries.places.internal;

import net.sf.scuba.smartcards.ISO7816;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbjf implements zzbaq {
    zzbjf() {
    }

    @Override // com.google.android.libraries.places.internal.zzbce
    public final /* bridge */ /* synthetic */ Object zza(byte[] bArr) {
        if (bArr.length < 3) {
            throw new NumberFormatException("Malformed status code ".concat(new String(bArr, zzbar.zza)));
        }
        return Integer.valueOf(((bArr[0] + ISO7816.INS_WRITE_BINARY) * 100) + ((bArr[1] + ISO7816.INS_WRITE_BINARY) * 10) + bArr[2] + ISO7816.INS_WRITE_BINARY);
    }

    @Override // com.google.android.libraries.places.internal.zzbce
    public final /* synthetic */ byte[] zzb(Object obj) {
        throw new UnsupportedOperationException();
    }
}
