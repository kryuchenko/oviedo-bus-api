package com.google.android.libraries.places.internal;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbdb {
    private static final Logger zza = Logger.getLogger(zzbdb.class.getName());
    private static zzbdb zzb;
    private final zzbcq zzc = new zzbcy(this, null);
    private String zzd = EnvironmentCompat.MEDIA_UNKNOWN;
    private final LinkedHashSet zze = new LinkedHashSet();
    private zzoa zzf = zzoa.zzd();

    public static synchronized zzbdb zzb() {
        if (zzb == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzbii"));
            } catch (ClassNotFoundException e) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e);
            }
            List<zzbcw> listZza = zzbdi.zza(zzbcw.class, Collections.unmodifiableList(arrayList), zzbcw.class.getClassLoader(), new zzbda(null));
            if (listZza.isEmpty()) {
                zza.logp(Level.WARNING, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            zzb = new zzbdb();
            for (zzbcw zzbcwVar : listZza) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(zzbcwVar))));
                zzb.zze(zzbcwVar);
            }
            zzb.zzf();
        }
        return zzb;
    }

    private final synchronized void zze(zzbcw zzbcwVar) {
        zzbcwVar.zze();
        this.zze.add(zzbcwVar);
    }

    private final synchronized void zzf() {
        HashMap map = new HashMap();
        Iterator it = this.zze.iterator();
        String strZzb = EnvironmentCompat.MEDIA_UNKNOWN;
        char c = 0;
        while (it.hasNext()) {
            zzbcw zzbcwVar = (zzbcw) it.next();
            String strZzb2 = zzbcwVar.zzb();
            if (((zzbcw) map.get(strZzb2)) != null) {
                zzbcwVar.zzc();
            } else {
                map.put(strZzb2, zzbcwVar);
            }
            zzbcwVar.zzc();
            if (c < 5) {
                zzbcwVar.zzc();
                strZzb = zzbcwVar.zzb();
            }
            c = 5;
        }
        this.zzf = zzoa.zzc(map.entrySet());
        this.zzd = strZzb;
    }

    public final zzbcw zza(String str) {
        if (str == null) {
            return null;
        }
        return (zzbcw) zzd().get(str.toLowerCase(Locale.US));
    }

    public final synchronized String zzc() {
        return this.zzd;
    }

    final synchronized Map zzd() {
        return this.zzf;
    }
}
