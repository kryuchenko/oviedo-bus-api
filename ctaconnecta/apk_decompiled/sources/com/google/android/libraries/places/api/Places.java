package com.google.android.libraries.places.api;

import android.content.Context;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzjo;
import com.google.android.libraries.places.internal.zzjp;
import com.google.android.libraries.places.internal.zzjq;
import com.google.android.libraries.places.internal.zzjs;
import com.google.android.libraries.places.internal.zzkb;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzmt;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class Places {
    private static final zzjs zza = new zzjs();
    private static volatile zzjq zzb;

    private Places() {
    }

    public static synchronized PlacesClient createClient(Context context) {
        try {
            zzmt.zzc(context, "Context must not be null.");
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
        return zza(context, zzkb.zzd(context).zze());
    }

    public static synchronized void deinitialize() {
        zza.zzc();
    }

    public static void initialize(Context context, String str) {
        try {
            zzb(context, str, null, false, false);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(Context context, String str) {
        try {
            zzb(context, str, null, false, true);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public static synchronized boolean isInitialized() {
        try {
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
        return zza.zzg();
    }

    public static synchronized PlacesClient zza(Context context, zzkb zzkbVar) {
        zzjp zzjpVarZza;
        try {
            zzmt.zzc(context, "Context must not be null.");
            zzmt.zzp(isInitialized(), "Places must be initialized first.");
            zzjpVarZza = zzjo.zza();
            zzjpVarZza.zzc(context);
            zzjpVarZza.zza(zza);
            zzjpVarZza.zzb(zzkbVar);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
        return zzjpVarZza.zzd().zza();
    }

    public static synchronized void zzb(Context context, String str, Locale locale, boolean z, boolean z2) {
        try {
            zzmt.zzc(context, "Application context must not be null.");
            zzmt.zzc(str, "API Key must not be null.");
            zzmt.zzf(!str.isEmpty(), "API Key must not be empty.");
            zzkd.zza(context.getApplicationContext(), false);
            if (z2) {
                zza.zze(str, locale, false);
            } else {
                zza.zzd(str, locale, false);
            }
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public static synchronized zzjs zzc() {
        return zza;
    }

    public static void initialize(Context context, String str, Locale locale) {
        try {
            zzb(context, str, locale, false, false);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(Context context, String str, Locale locale) {
        try {
            zzb(context, str, locale, false, true);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }
}
