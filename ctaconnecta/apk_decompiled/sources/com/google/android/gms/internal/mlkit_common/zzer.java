package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzer<T extends zzet<T>> {
    private static final zzer zzd = new zzer(true);
    final zzgz<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzer() {
        this.zza = zzgz.zza(16);
    }

    private zzer(boolean z) {
        this(zzgz.zza(0));
        zzb();
    }

    private zzer(zzgz<T, Object> zzgzVar) {
        this.zza = zzgzVar;
        zzb();
    }

    public static <T extends zzet<T>> zzer<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            return this.zza.equals(((zzer) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfn(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfn(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfm)) {
            return obj;
        }
        return zzfm.zza();
    }

    private final void zzb(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzb(), obj);
        }
        if (obj instanceof zzfm) {
            this.zzc = true;
        }
        this.zza.zza((zzgz<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzie zzieVar, Object obj) {
        zzfc.zza(obj);
        boolean z = true;
        switch (zzeu.zza[zzieVar.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdv) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfb)) {
                }
                break;
            case 9:
                if (!(obj instanceof zzgh) && !(obj instanceof zzfm)) {
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzet<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzih.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgh) it.next()).a_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgh) {
                    if (!((zzgh) value).a_()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfm) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzer<T> zzerVar) {
        for (int i = 0; i < zzerVar.zza.zzc(); i++) {
            zzb(zzerVar.zza.zzb(i));
        }
        Iterator it = zzerVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgn) {
            return ((zzgn) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzgh zzghVarZzh;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfm) {
            value = zzfm.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzer<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.zza((zzgz<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzc() == zzih.MESSAGE) {
            Object objZza2 = zza((zzer<T>) key);
            if (objZza2 == null) {
                this.zza.zza((zzgz<T, Object>) key, (T) zza(value));
                return;
            }
            if (objZza2 instanceof zzgn) {
                zzghVarZzh = key.zza((zzgn) objZza2, (zzgn) value);
            } else {
                zzghVarZzh = key.zza(((zzgh) objZza2).zzm(), (zzgh) value).zzh();
            }
            this.zza.zza((zzgz<T, Object>) key, (T) zzghVarZzh);
            return;
        }
        this.zza.zza((zzgz<T, Object>) key, (T) zza(value));
    }

    static void zza(zzem zzemVar, zzie zzieVar, int i, Object obj) throws IOException {
        if (zzieVar == zzie.zzj) {
            zzgh zzghVar = (zzgh) obj;
            zzfc.zza(zzghVar);
            zzemVar.zza(i, 3);
            zzghVar.zza(zzemVar);
            zzemVar.zza(i, 4);
        }
        zzemVar.zza(i, zzieVar.zzb());
        switch (zzeu.zzb[zzieVar.ordinal()]) {
            case 1:
                zzemVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzemVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzemVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzemVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzemVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzemVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzemVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzemVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzgh) obj).zza(zzemVar);
                break;
            case 10:
                zzemVar.zza((zzgh) obj);
                break;
            case 11:
                if (obj instanceof zzdv) {
                    zzemVar.zza((zzdv) obj);
                    break;
                } else {
                    zzemVar.zza((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzdv) {
                    zzemVar.zza((zzdv) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzemVar.zzb(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzemVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzemVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzemVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzemVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzemVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzfb) {
                    zzemVar.zza(((zzfb) obj).zza());
                    break;
                } else {
                    zzemVar.zza(((Integer) obj).intValue());
                    break;
                }
        }
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzih.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzfm) {
                return zzem.zzb(entry.getKey().zza(), (zzfm) value);
            }
            return zzem.zzb(entry.getKey().zza(), (zzgh) value);
        }
        return zza((zzet<?>) key, value);
    }

    static int zza(zzie zzieVar, int i, Object obj) {
        int iZze = zzem.zze(i);
        if (zzieVar == zzie.zzj) {
            zzfc.zza((zzgh) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzieVar, obj);
    }

    private static int zzb(zzie zzieVar, Object obj) {
        switch (zzeu.zzb[zzieVar.ordinal()]) {
            case 1:
                return zzem.zzb(((Double) obj).doubleValue());
            case 2:
                return zzem.zzb(((Float) obj).floatValue());
            case 3:
                return zzem.zzd(((Long) obj).longValue());
            case 4:
                return zzem.zze(((Long) obj).longValue());
            case 5:
                return zzem.zzf(((Integer) obj).intValue());
            case 6:
                return zzem.zzg(((Long) obj).longValue());
            case 7:
                return zzem.zzi(((Integer) obj).intValue());
            case 8:
                return zzem.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzem.zzc((zzgh) obj);
            case 10:
                if (obj instanceof zzfm) {
                    return zzem.zza((zzfm) obj);
                }
                return zzem.zzb((zzgh) obj);
            case 11:
                if (obj instanceof zzdv) {
                    return zzem.zzb((zzdv) obj);
                }
                return zzem.zzb((String) obj);
            case 12:
                if (obj instanceof zzdv) {
                    return zzem.zzb((zzdv) obj);
                }
                return zzem.zzb((byte[]) obj);
            case 13:
                return zzem.zzg(((Integer) obj).intValue());
            case 14:
                return zzem.zzj(((Integer) obj).intValue());
            case 15:
                return zzem.zzh(((Long) obj).longValue());
            case 16:
                return zzem.zzh(((Integer) obj).intValue());
            case 17:
                return zzem.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfb) {
                    return zzem.zzk(((zzfb) obj).zza());
                }
                return zzem.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzet<?> zzetVar, Object obj) {
        zzie zzieVarZzb = zzetVar.zzb();
        int iZza = zzetVar.zza();
        if (zzetVar.zzd()) {
            int iZza2 = 0;
            if (zzetVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzieVarZzb, it.next());
                }
                return zzem.zze(iZza) + iZza2 + zzem.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzieVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzieVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzer zzerVar = new zzer();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzerVar.zzb((zzer) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzerVar.zzb((zzer) entry.getKey(), entry.getValue());
        }
        zzerVar.zzc = this.zzc;
        return zzerVar;
    }
}
