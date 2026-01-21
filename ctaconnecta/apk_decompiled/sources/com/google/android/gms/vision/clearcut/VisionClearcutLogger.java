package com.google.android.gms.vision.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzdx;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzgi;
import com.google.android.gms.vision.L;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class VisionClearcutLogger {
    private final ClearcutLogger zzcd;
    private boolean zzce = true;

    public VisionClearcutLogger(Context context) {
        this.zzcd = new ClearcutLogger(context, "VISION", null);
    }

    public final void zzb(int i, zzef.zzo zzoVar) {
        byte[] byteArray = zzoVar.toByteArray();
        if (i < 0 || i > 3) {
            L.i("Illegal event code: %d", Integer.valueOf(i));
            return;
        }
        try {
            if (this.zzce) {
                this.zzcd.newEvent(byteArray).setEventCode(i).log();
                return;
            }
            zzef.zzo.zza zzaVarZzdj = zzef.zzo.zzdj();
            try {
                zzaVarZzdj.zza(byteArray, 0, byteArray.length, zzgi.zzfn());
                L.e("Would have logged:\n%s", zzaVarZzdj.toString());
            } catch (Exception e) {
                L.e(e, "Parsing error", new Object[0]);
            }
        } catch (Exception e2) {
            zzdx.zza(e2);
            L.e(e2, "Failed to log", new Object[0]);
        }
    }
}
