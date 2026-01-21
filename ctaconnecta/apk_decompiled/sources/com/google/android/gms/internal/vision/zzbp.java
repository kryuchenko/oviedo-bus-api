package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzbp {
    final String zzgu;
    final Uri zzgv;
    final String zzgw;
    final String zzgx;
    final boolean zzgy;
    final boolean zzgz;
    final boolean zzha;
    final boolean zzhb;

    @Nullable
    final zzcq<Context, Boolean> zzhc;

    public zzbp(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzbp(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcq<Context, Boolean> zzcqVar) {
        this.zzgu = str;
        this.zzgv = uri;
        this.zzgw = str2;
        this.zzgx = str3;
        this.zzgy = z;
        this.zzgz = z2;
        this.zzha = z3;
        this.zzhb = z4;
        this.zzhc = zzcqVar;
    }

    public final zzbp zzf(String str) {
        boolean z = this.zzgy;
        if (z) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new zzbp(this.zzgu, this.zzgv, str, this.zzgx, z, this.zzgz, this.zzha, this.zzhb, this.zzhc);
    }

    public final zzbj<Long> zza(String str, long j) {
        return zzbj.zza(this, str, j, true);
    }

    public final zzbj<Boolean> zza(String str, boolean z) {
        return zzbj.zza(this, str, z, true);
    }

    public final <T> zzbj<T> zza(String str, T t, zzbm<T> zzbmVar) {
        return zzbj.zza(this, str, t, zzbmVar, true);
    }
}
