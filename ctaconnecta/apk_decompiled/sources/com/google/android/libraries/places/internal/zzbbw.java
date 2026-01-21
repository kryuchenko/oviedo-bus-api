package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbbw extends zzbca {
    private final zzbbx zza;

    /* synthetic */ zzbbw(String str, boolean z, zzbbx zzbbxVar, zzbbv zzbbvVar) {
        super(str, false, zzbbxVar, null);
        zzmt.zzl(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
        zzmt.zzc(zzbbxVar, "marshaller");
        this.zza = zzbbxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbca
    final Object zza(byte[] bArr) {
        return this.zza.zza(new String(bArr, zzmb.zza));
    }

    @Override // com.google.android.libraries.places.internal.zzbca
    final byte[] zzb(Object obj) {
        String strZzb = this.zza.zzb(obj);
        zzmt.zzc(strZzb, "null marshaller.toAsciiString()");
        return strZzb.getBytes(zzmb.zza);
    }
}
