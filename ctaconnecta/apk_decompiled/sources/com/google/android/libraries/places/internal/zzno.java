package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzno extends zznp {
    @Override // com.google.android.libraries.places.internal.zznp
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "\\" + this.zza.toString() + RemoteSettings.FORWARD_SLASH_STRING;
    }

    @Override // com.google.android.libraries.places.internal.zznp
    final void zzc(StringBuilder sb) {
        sb.append('[');
        sb.append(this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zznp
    final void zzd(StringBuilder sb) {
        sb.append(this.zza);
        sb.append(')');
    }

    @Override // com.google.android.libraries.places.internal.zznp
    final boolean zze(Comparable comparable) {
        int i = zzok.zzc;
        return this.zza.compareTo(comparable) <= 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzno(Comparable comparable) {
        super(comparable);
        comparable.getClass();
    }
}
