package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzoj;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
final class zzki implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zziv zza;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5 A[Catch: RuntimeException -> 0x0197, TryCatch #0 {RuntimeException -> 0x0197, blocks: (B:3:0x000b, B:5:0x0018, B:9:0x0029, B:38:0x00ac, B:40:0x00b8, B:45:0x00cd, B:47:0x00d5, B:50:0x00e2, B:52:0x00e8, B:53:0x00fb, B:54:0x0107, B:57:0x010f, B:61:0x0132, B:63:0x014e, B:62:0x013f, B:65:0x0155, B:67:0x015b, B:69:0x0161, B:71:0x0167, B:73:0x016d, B:75:0x0175, B:77:0x017d, B:79:0x0183, B:81:0x0189, B:13:0x003d, B:16:0x0045, B:18:0x004d, B:20:0x0053, B:22:0x0059, B:24:0x005f, B:26:0x0067, B:28:0x006f, B:30:0x0077, B:32:0x007f, B:33:0x008b, B:35:0x00a3), top: B:86:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void zza(zzki zzkiVar, boolean z, Uri uri, String str, String str2) throws IllegalStateException {
        Bundle bundleZza;
        char c;
        Bundle bundleZza2;
        zzkiVar.zza.zzt();
        try {
            zznp zznpVarZzq = zzkiVar.zza.zzq();
            boolean z2 = zzoj.zza() && zzkiVar.zza.zze().zza(zzbf.zzcl);
            if (TextUtils.isEmpty(str2)) {
                bundleZza = null;
            } else if (str2.contains("gclid") || ((z2 && str2.contains("gbraid")) || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id"))) {
                bundleZza = zznpVarZzq.zza(Uri.parse("https://google.com/search?" + str2), z2);
                if (bundleZza != null) {
                    bundleZza.putString("_cis", "referrer");
                }
            } else {
                zznpVarZzq.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                bundleZza = null;
            }
            if (z) {
                zznp zznpVarZzq2 = zzkiVar.zza.zzq();
                if (zzoj.zza()) {
                    c = 0;
                    boolean z3 = zzkiVar.zza.zze().zza(zzbf.zzcl);
                    bundleZza2 = zznpVarZzq2.zza(uri, z3);
                    if (bundleZza2 != null) {
                        bundleZza2.putString("_cis", "intent");
                        if (!bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                            Object[] objArr = new Object[1];
                            objArr[c] = bundleZza.getString("gclid");
                            bundleZza2.putString("_cer", String.format("gclid=%s", objArr));
                        }
                        zzkiVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza2);
                        zzkiVar.zza.zza.zza(str, bundleZza2);
                    }
                } else {
                    c = 0;
                }
                bundleZza2 = zznpVarZzq2.zza(uri, z3);
                if (bundleZza2 != null) {
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            zzkiVar.zza.zzj().zzc().zza("Activity created with referrer", str2);
            if (zzkiVar.zza.zze().zza(zzbf.zzbl)) {
                if (bundleZza != null) {
                    zzkiVar.zza.zzc(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZza);
                    zzkiVar.zza.zza.zza(str, bundleZza);
                } else {
                    zzkiVar.zza.zzj().zzc().zza("Referrer does not contain valid parameters", str2);
                }
                zzkiVar.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                zzkiVar.zza.zzj().zzc().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                zzkiVar.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", (Object) str2, true);
            }
        } catch (RuntimeException e) {
            zzkiVar.zza.zzj().zzg().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    zzki(zziv zzivVar) {
        this.zza = zzivVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        zzki zzkiVar;
        Intent intent;
        String str;
        try {
            try {
                this.zza.zzj().zzp().zza("onActivityCreated");
                intent = activity.getIntent();
            } catch (Throwable th) {
                th = th;
                this.zza.zzn().zza(activity, bundle);
                throw th;
            }
        } catch (RuntimeException e) {
            e = e;
            zzkiVar = this;
        } catch (Throwable th2) {
            th = th2;
            this.zza.zzn().zza(activity, bundle);
            throw th;
        }
        if (intent == null) {
            this.zza.zzn().zza(activity, bundle);
            return;
        }
        Uri data = intent.getData();
        if (data == null || !data.isHierarchical()) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("com.android.vending.referral_url");
                data = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            }
            zzkiVar.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
            zzkiVar.zza.zzn().zza(activity, bundle);
            return;
        }
        Uri uri = data;
        if (uri != null && uri.isHierarchical()) {
            this.zza.zzq();
            if (zznp.zza(intent)) {
                str = "gs";
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            }
            String str2 = str;
            String queryParameter = uri.getQueryParameter("referrer");
            zzkiVar = this;
            try {
                this.zza.zzl().zzb(new zzkh(zzkiVar, bundle == null, uri, str2, queryParameter));
                zzkiVar.zza.zzn().zza(activity, bundle);
                return;
            } catch (RuntimeException e2) {
                e = e2;
            }
        }
        this.zza.zzn().zza(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) throws IllegalStateException {
        this.zza.zzn().zzb(activity);
        zzmh zzmhVarZzp = this.zza.zzp();
        zzmhVarZzp.zzl().zzb(new zzmj(zzmhVarZzp, zzmhVarZzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) throws IllegalStateException {
        zzmh zzmhVarZzp = this.zza.zzp();
        zzmhVarZzp.zzl().zzb(new zzmk(zzmhVarZzp, zzmhVarZzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }
}
