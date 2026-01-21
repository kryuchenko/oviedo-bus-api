package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzba implements zzaz {
    private static zzba zzfz;

    @Nullable
    private final ContentObserver zzft;

    @Nullable
    private final Context zzg;

    static zzba zze(Context context) {
        zzba zzbaVar;
        synchronized (zzba.class) {
            if (zzfz == null) {
                zzfz = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzba(context) : new zzba();
            }
            zzbaVar = zzfz;
        }
        return zzbaVar;
    }

    private zzba(Context context) {
        this.zzg = context;
        zzbc zzbcVar = new zzbc(this, null);
        this.zzft = zzbcVar;
        context.getContentResolver().registerContentObserver(zzaq.CONTENT_URI, true, zzbcVar);
    }

    private zzba() {
        this.zzg = null;
        this.zzft = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.vision.zzaz
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        if (this.zzg == null) {
            return null;
        }
        try {
            return (String) zzay.zza(new zzbb(this, str) { // from class: com.google.android.gms.internal.vision.zzbd
                private final zzba zzga;
                private final String zzgb;

                {
                    this.zzga = this;
                    this.zzgb = str;
                }

                @Override // com.google.android.gms.internal.vision.zzbb
                public final Object zzu() {
                    return this.zzga.zzd(this.zzgb);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zzab() {
        Context context;
        zzba zzbaVar = zzfz;
        if (zzbaVar != null && (context = zzbaVar.zzg) != null && zzbaVar.zzft != null) {
            context.getContentResolver().unregisterContentObserver(zzfz.zzft);
        }
        zzfz = null;
    }

    final /* synthetic */ String zzd(String str) {
        return zzaq.zza(this.zzg.getContentResolver(), str, (String) null);
    }
}
