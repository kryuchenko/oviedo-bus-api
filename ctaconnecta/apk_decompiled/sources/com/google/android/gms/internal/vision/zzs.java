package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzs<T> {
    private static String PREFIX = "com.google.android.gms.vision.dynamite";
    private final String tag;
    private final String zzdm;
    private final String zzdn;
    private final boolean zzdo;
    private T zzdr;
    private final Context zzg;
    private final Object lock = new Object();
    private boolean zzdp = false;
    private boolean zzdq = false;

    public zzs(Context context, String str, String str2) {
        boolean z = false;
        this.zzg = context;
        this.tag = str;
        String str3 = PREFIX;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(".");
        sb.append(str2);
        this.zzdm = sb.toString();
        this.zzdn = str2;
        if (context != null) {
            zzbj.maybeInit(context);
            zzdl zzdlVarZza = zzdl.zza("barcode", Boolean.valueOf(zzla.zzjq()), "face", Boolean.TRUE, "ica", Boolean.valueOf(zzla.zzjr()), "ocr", Boolean.TRUE);
            if (zzdlVarZza.containsKey(str2) && ((Boolean) zzdlVarZza.get(str2)).booleanValue()) {
                z = true;
            }
        }
        this.zzdo = z;
    }

    protected abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    protected abstract void zzo() throws RemoteException;

    public final boolean isOperational() {
        return zzq() != null;
    }

    public final void zzp() {
        synchronized (this.lock) {
            if (this.zzdr == null) {
                return;
            }
            try {
                zzo();
            } catch (RemoteException e) {
                Log.e(this.tag, "Could not finalize native handle", e);
            }
        }
    }

    protected final T zzq() {
        DynamiteModule dynamiteModuleZza;
        synchronized (this.lock) {
            T t = this.zzdr;
            if (t != null) {
                return t;
            }
            try {
                dynamiteModuleZza = DynamiteModule.load(this.zzg, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzdm);
            } catch (DynamiteModule.LoadingException unused) {
                Log.d(this.tag, "Cannot load feature, fall back to load dynamite module.");
                dynamiteModuleZza = zzw.zza(this.zzg, this.zzdn, this.zzdo);
                if (dynamiteModuleZza == null && this.zzdo && !this.zzdp) {
                    String str = this.tag;
                    String strValueOf = String.valueOf(this.zzdn);
                    Log.d(str, strValueOf.length() != 0 ? "Broadcasting download intent for dependency ".concat(strValueOf) : new String("Broadcasting download intent for dependency "));
                    String str2 = this.zzdn;
                    Intent intent = new Intent();
                    intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                    intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                    intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                    this.zzg.sendBroadcast(intent);
                    this.zzdp = true;
                }
            }
            if (dynamiteModuleZza != null) {
                try {
                    this.zzdr = zza(dynamiteModuleZza, this.zzg);
                } catch (RemoteException | DynamiteModule.LoadingException e) {
                    Log.e(this.tag, "Error creating remote native handle", e);
                }
            }
            boolean z = this.zzdq;
            if (!z && this.zzdr == null) {
                Log.w(this.tag, "Native handle not yet available. Reverting to no-op handle.");
                this.zzdq = true;
            } else if (z && this.zzdr != null) {
                Log.w(this.tag, "Native handle is now available.");
            }
            return this.zzdr;
        }
    }
}
