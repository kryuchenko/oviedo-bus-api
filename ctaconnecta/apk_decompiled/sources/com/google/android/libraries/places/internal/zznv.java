package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zznv extends zzni {
    private final zznx zza;

    zznv(zznx zznxVar, int i) {
        super(zznxVar.size(), i);
        this.zza = zznxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzni
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
