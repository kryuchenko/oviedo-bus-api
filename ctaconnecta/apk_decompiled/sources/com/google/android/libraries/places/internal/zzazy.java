package com.google.android.libraries.places.internal;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzazy {
    private SocketAddress zza;
    private InetSocketAddress zzb;

    @Nullable
    private String zzc;

    @Nullable
    private String zzd;

    private zzazy() {
        throw null;
    }

    /* synthetic */ zzazy(zzazx zzazxVar) {
    }

    public final zzazy zza(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    public final zzazy zzb(SocketAddress socketAddress) {
        zzmt.zzc(socketAddress, "proxyAddress");
        this.zza = socketAddress;
        return this;
    }

    public final zzazy zzc(InetSocketAddress inetSocketAddress) {
        zzmt.zzc(inetSocketAddress, "targetAddress");
        this.zzb = inetSocketAddress;
        return this;
    }

    public final zzazy zzd(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzbaa zze() {
        return new zzbaa(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
