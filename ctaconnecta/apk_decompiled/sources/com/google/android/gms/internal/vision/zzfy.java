package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfy {
    int zzsu;
    int zzsv;
    private int zzsw;
    zzgd zzsx;
    private boolean zzsy;

    static zzfy zza(byte[] bArr, int i, int i2, boolean z) {
        zzga zzgaVar = new zzga(bArr, 0, i2, false);
        try {
            zzgaVar.zzat(i2);
            return zzgaVar;
        } catch (zzhh e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzav(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzr(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract void zzar(int i) throws zzhh;

    public abstract boolean zzas(int i) throws IOException;

    public abstract int zzat(int i) throws zzhh;

    public abstract void zzau(int i);

    public abstract boolean zzdu() throws IOException;

    public abstract long zzdx() throws IOException;

    public abstract long zzdy() throws IOException;

    public abstract int zzdz() throws IOException;

    public abstract long zzea() throws IOException;

    public abstract int zzeb() throws IOException;

    public abstract boolean zzec() throws IOException;

    public abstract String zzed() throws IOException;

    public abstract zzfm zzee() throws IOException;

    public abstract int zzef() throws IOException;

    public abstract int zzeg() throws IOException;

    public abstract int zzeh() throws IOException;

    public abstract long zzei() throws IOException;

    public abstract int zzej() throws IOException;

    public abstract long zzek() throws IOException;

    public abstract int zzey() throws IOException;

    abstract long zzez() throws IOException;

    public abstract int zzfa();

    private zzfy() {
        this.zzsv = 100;
        this.zzsw = Integer.MAX_VALUE;
        this.zzsy = false;
    }
}
