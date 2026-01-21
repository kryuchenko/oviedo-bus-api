package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbvn extends zzbvk {
    protected zzbbk zzi;
    private final AtomicInteger zzj;

    public zzbvn(zzbbd zzbbdVar) {
        super(zzbbdVar);
        this.zzj = new AtomicInteger(new Random().nextInt());
        this.zzi = new zzbvl();
    }

    private final void zzn(zzaze zzazeVar, zzbbk zzbbkVar) {
        if (zzazeVar == this.zzh && zzbbkVar.equals(this.zzi)) {
            return;
        }
        zzh().zze(zzazeVar, zzbbkVar);
        this.zzh = zzazeVar;
        this.zzi = zzbbkVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbvk
    protected final void zzl() {
        ArrayList arrayList = new ArrayList();
        for (zzbvi zzbviVar : zzi()) {
            if (!zzbviVar.zzm() && zzbviVar.zza() == zzaze.READY) {
                arrayList.add(zzbviVar);
            }
        }
        if (!arrayList.isEmpty()) {
            zzn(zzaze.READY, zzm(arrayList));
            return;
        }
        Iterator it = zzi().iterator();
        while (it.hasNext()) {
            zzaze zzazeVarZza = ((zzbvi) it.next()).zza();
            if (zzazeVarZza == zzaze.CONNECTING || zzazeVarZza == zzaze.IDLE) {
                zzn(zzaze.CONNECTING, new zzbvl());
                return;
            }
        }
        zzn(zzaze.TRANSIENT_FAILURE, zzm(zzi()));
    }

    protected final zzbbk zzm(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzbvi) it.next()).zzb());
        }
        return new zzbvm(arrayList, this.zzj);
    }
}
