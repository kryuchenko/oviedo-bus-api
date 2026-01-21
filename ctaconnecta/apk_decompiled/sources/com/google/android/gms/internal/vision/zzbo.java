package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzbo implements zzaz {
    private static final Map<String, zzbo> zzgr = new ArrayMap();
    private final Object zzfu;
    private volatile Map<String, ?> zzfv;
    private final List<zzaw> zzfw;
    private final SharedPreferences zzgs;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzgt;

    static zzbo zzb(Context context, String str) {
        zzbo zzboVar;
        if (!((!zzas.zzt() || str.startsWith("direct_boot:")) ? true : zzas.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbo.class) {
            Map<String, zzbo> map = zzgr;
            zzboVar = map.get(str);
            if (zzboVar == null) {
                zzboVar = new zzbo(zzc(context, str));
                map.put(str, zzboVar);
            }
        }
        return zzboVar;
    }

    private static SharedPreferences zzc(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzas.zzt()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            return context.getSharedPreferences(str, 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private zzbo(SharedPreferences sharedPreferences) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.vision.zzbr
            private final zzbo zzhn;

            {
                this.zzhn = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.zzhn.zza(sharedPreferences2, str);
            }
        };
        this.zzgt = onSharedPreferenceChangeListener;
        this.zzfu = new Object();
        this.zzfw = new ArrayList();
        this.zzgs = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.google.android.gms.internal.vision.zzaz
    public final Object zzb(String str) {
        Map<String, ?> map = this.zzfv;
        if (map == null) {
            synchronized (this.zzfu) {
                map = this.zzfv;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzgs.getAll();
                        this.zzfv = all;
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zzy() {
        for (zzbo zzboVar : zzgr.values()) {
            zzboVar.zzgs.unregisterOnSharedPreferenceChangeListener(zzboVar.zzgt);
        }
        zzgr.clear();
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzfu) {
            this.zzfv = null;
            zzbj.zzac();
        }
        synchronized (this) {
            Iterator<zzaw> it = this.zzfw.iterator();
            while (it.hasNext()) {
                it.next().zzaa();
            }
        }
    }
}
