package com.google.android.libraries.places.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import net.sf.scuba.smartcards.ISO7816;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
@CheckReturnValue
/* loaded from: classes3.dex */
public final class zzbdo {
    public static final zzbdo zza;
    public static final zzbdo zzb;
    public static final zzbdo zzc;
    public static final zzbdo zzd;
    public static final zzbdo zze;
    public static final zzbdo zzf;
    public static final zzbdo zzg;
    public static final zzbdo zzh;
    public static final zzbdo zzi;
    public static final zzbdo zzj;
    public static final zzbdo zzk;
    public static final zzbdo zzl;
    public static final zzbdo zzm;
    public static final zzbdo zzn;
    public static final zzbdo zzo;
    public static final zzbdo zzp;
    public static final zzbdo zzq;
    static final zzbca zzr;
    static final zzbca zzs;
    private static final List zzt;
    private static final zzbce zzu;
    private final zzbdj zzv;
    private final String zzw;
    private final Throwable zzx;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TreeMap treeMap = new TreeMap();
        zzbdj[] zzbdjVarArrValues = zzbdj.values();
        int length = zzbdjVarArrValues.length;
        boolean z = false;
        int i = 0;
        while (true) {
            zzbdk zzbdkVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (i >= length) {
                zzt = Collections.unmodifiableList(new ArrayList(treeMap.values()));
                zza = zzbdj.OK.zzb();
                zzb = zzbdj.CANCELLED.zzb();
                zzc = zzbdj.UNKNOWN.zzb();
                zzd = zzbdj.INVALID_ARGUMENT.zzb();
                zze = zzbdj.DEADLINE_EXCEEDED.zzb();
                zzf = zzbdj.NOT_FOUND.zzb();
                zzg = zzbdj.ALREADY_EXISTS.zzb();
                zzh = zzbdj.PERMISSION_DENIED.zzb();
                zzi = zzbdj.UNAUTHENTICATED.zzb();
                zzj = zzbdj.RESOURCE_EXHAUSTED.zzb();
                zzk = zzbdj.FAILED_PRECONDITION.zzb();
                zzl = zzbdj.ABORTED.zzb();
                zzm = zzbdj.OUT_OF_RANGE.zzb();
                zzn = zzbdj.UNIMPLEMENTED.zzb();
                zzo = zzbdj.INTERNAL.zzb();
                zzp = zzbdj.UNAVAILABLE.zzb();
                zzq = zzbdj.DATA_LOSS.zzb();
                zzr = new zzbcd("grpc-status", z, new zzbdl(zzbdkVar), objArr3 == true ? 1 : 0);
                zzbdn zzbdnVar = new zzbdn(objArr2 == true ? 1 : 0);
                zzu = zzbdnVar;
                zzs = new zzbcd("grpc-message", z, zzbdnVar, objArr == true ? 1 : 0);
                return;
            }
            zzbdj zzbdjVar = zzbdjVarArrValues[i];
            zzbdo zzbdoVar = (zzbdo) treeMap.put(Integer.valueOf(zzbdjVar.zza()), new zzbdo(zzbdjVar, null, null));
            if (zzbdoVar != null) {
                throw new IllegalStateException("Code value duplication between " + zzbdoVar.zzv.name() + " & " + zzbdjVar.name());
            }
            i++;
        }
    }

    private zzbdo(zzbdj zzbdjVar, @Nullable String str, @Nullable Throwable th) {
        zzmt.zzc(zzbdjVar, "code");
        this.zzv = zzbdjVar;
        this.zzw = str;
        this.zzx = th;
    }

    static /* bridge */ /* synthetic */ zzbdo zzb(byte[] bArr) {
        int i;
        byte b;
        int length = bArr.length;
        char c = 0;
        if (length == 1) {
            if (bArr[0] == 48) {
                return zza;
            }
            length = 1;
        }
        if (length != 1) {
            if (length == 2 && (b = bArr[0]) >= 48 && b <= 57) {
                i = (b + ISO7816.INS_WRITE_BINARY) * 10;
                c = 1;
            }
            return zzc.zzg("Unknown code ".concat(new String(bArr, zzmb.zza)));
        }
        i = 0;
        byte b2 = bArr[c];
        if (b2 >= 48 && b2 <= 57) {
            int i2 = i + b2 + ISO7816.INS_WRITE_BINARY;
            List list = zzt;
            if (i2 < list.size()) {
                return (zzbdo) list.get(i2);
            }
        }
        return zzc.zzg("Unknown code ".concat(new String(bArr, zzmb.zza)));
    }

    public static zzbdo zzd(int i) {
        if (i >= 0) {
            List list = zzt;
            if (i < list.size()) {
                return (zzbdo) list.get(i);
            }
        }
        return zzc.zzg("Unknown code " + i);
    }

    public static zzbdo zze(Throwable th) {
        zzmt.zzc(th, "t");
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof zzbdp) {
                return ((zzbdp) cause).zza();
            }
            if (cause instanceof zzbdq) {
                return ((zzbdq) cause).zza();
            }
        }
        return zzc.zzf(th);
    }

    static String zzh(zzbdo zzbdoVar) {
        String str = zzbdoVar.zzw;
        zzbdj zzbdjVar = zzbdoVar.zzv;
        if (str == null) {
            return zzbdjVar.toString();
        }
        return zzbdjVar.toString() + ": " + str;
    }

    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzd("code", this.zzv.name());
        zzmmVarZzb.zzd("description", this.zzw);
        Throwable th = this.zzx;
        Object string = th;
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        zzmmVarZzb.zzd("cause", string);
        return zzmmVarZzb.toString();
    }

    public final zzbdj zza() {
        return this.zzv;
    }

    public final zzbdo zzc(String str) {
        String str2 = this.zzw;
        if (str2 == null) {
            return new zzbdo(this.zzv, str, this.zzx);
        }
        return new zzbdo(this.zzv, str2 + "\n" + str, this.zzx);
    }

    public final zzbdo zzf(Throwable th) {
        return zzmo.zza(this.zzx, th) ? this : new zzbdo(this.zzv, this.zzw, th);
    }

    public final zzbdo zzg(String str) {
        return zzmo.zza(this.zzw, str) ? this : new zzbdo(this.zzv, str, this.zzx);
    }

    @Nullable
    public final String zzi() {
        return this.zzw;
    }

    @Nullable
    public final Throwable zzj() {
        return this.zzx;
    }

    public final boolean zzl() {
        return zzbdj.OK == this.zzv;
    }
}
