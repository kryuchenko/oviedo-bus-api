package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzeh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzef<T extends zzeh<T>> {
    private static final zzef zzd = new zzef(true);
    final zzgn<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzef() {
        this.zza = zzgn.zza(16);
    }

    private zzef(boolean z) {
        this(zzgn.zza(0));
        zzb();
    }

    private zzef(zzgn<T, Object> zzgnVar) {
        this.zza = zzgnVar;
        zzb();
    }

    public static <T extends zzeh<T>> zzef<T> zza() {
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
        if (obj instanceof zzef) {
            return this.zza.equals(((zzef) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfb(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfb(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzew)) {
            return obj;
        }
        return zzew.zza();
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
        if (obj instanceof zzew) {
            this.zzc = true;
        }
        this.zza.zza((zzgn<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzho zzhoVar, Object obj) {
        zzem.zza(obj);
        boolean z = true;
        switch (zzee.zza[zzhoVar.zza().ordinal()]) {
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
                if (!(obj instanceof zzdj) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzep)) {
                }
                break;
            case 9:
                if (!(obj instanceof zzfv) && !(obj instanceof zzew)) {
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

    private static <T extends zzeh<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzhv.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzfv) it.next()).zzi()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzfv) {
                    if (!((zzfv) value).zzi()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzew) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzef<T> zzefVar) {
        for (int i = 0; i < zzefVar.zza.zzc(); i++) {
            zzb(zzefVar.zza.zzb(i));
        }
        Iterator it = zzefVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgb) {
            return ((zzgb) obj).clone();
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
        zzfv zzfvVarZzg;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzew) {
            value = zzew.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzef<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.zza((zzgn<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzc() == zzhv.MESSAGE) {
            Object objZza2 = zza((zzef<T>) key);
            if (objZza2 == null) {
                this.zza.zza((zzgn<T, Object>) key, (T) zza(value));
                return;
            }
            if (objZza2 instanceof zzgb) {
                zzfvVarZzg = key.zza((zzgb) objZza2, (zzgb) value);
            } else {
                zzfvVarZzg = key.zza(((zzfv) objZza2).zzm(), (zzfv) value).zzg();
            }
            this.zza.zza((zzgn<T, Object>) key, (T) zzfvVarZzg);
            return;
        }
        this.zza.zza((zzgn<T, Object>) key, (T) zza(value));
    }

    static void zza(zzdw zzdwVar, zzho zzhoVar, int i, Object obj) throws IOException {
        if (zzhoVar == zzho.zzj) {
            zzfv zzfvVar = (zzfv) obj;
            zzem.zza(zzfvVar);
            zzdwVar.zza(i, 3);
            zzfvVar.zza(zzdwVar);
            zzdwVar.zza(i, 4);
        }
        zzdwVar.zza(i, zzhoVar.zzb());
        switch (zzee.zzb[zzhoVar.ordinal()]) {
            case 1:
                zzdwVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzdwVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzdwVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzdwVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzdwVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzdwVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzdwVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzdwVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzfv) obj).zza(zzdwVar);
                break;
            case 10:
                zzdwVar.zza((zzfv) obj);
                break;
            case 11:
                if (obj instanceof zzdj) {
                    zzdwVar.zza((zzdj) obj);
                    break;
                } else {
                    zzdwVar.zza((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzdj) {
                    zzdwVar.zza((zzdj) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzdwVar.zzb(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzdwVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzdwVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzdwVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzdwVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzdwVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzep) {
                    zzdwVar.zza(((zzep) obj).zza());
                    break;
                } else {
                    zzdwVar.zza(((Integer) obj).intValue());
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
        if (key.zzc() == zzhv.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzew) {
                return zzdw.zzb(entry.getKey().zza(), (zzew) value);
            }
            return zzdw.zzb(entry.getKey().zza(), (zzfv) value);
        }
        return zza((zzeh<?>) key, value);
    }

    static int zza(zzho zzhoVar, int i, Object obj) {
        int iZze = zzdw.zze(i);
        if (zzhoVar == zzho.zzj) {
            zzem.zza((zzfv) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzhoVar, obj);
    }

    private static int zzb(zzho zzhoVar, Object obj) {
        switch (zzee.zzb[zzhoVar.ordinal()]) {
            case 1:
                return zzdw.zzb(((Double) obj).doubleValue());
            case 2:
                return zzdw.zzb(((Float) obj).floatValue());
            case 3:
                return zzdw.zzd(((Long) obj).longValue());
            case 4:
                return zzdw.zze(((Long) obj).longValue());
            case 5:
                return zzdw.zzf(((Integer) obj).intValue());
            case 6:
                return zzdw.zzg(((Long) obj).longValue());
            case 7:
                return zzdw.zzi(((Integer) obj).intValue());
            case 8:
                return zzdw.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzdw.zzc((zzfv) obj);
            case 10:
                if (obj instanceof zzew) {
                    return zzdw.zza((zzew) obj);
                }
                return zzdw.zzb((zzfv) obj);
            case 11:
                if (obj instanceof zzdj) {
                    return zzdw.zzb((zzdj) obj);
                }
                return zzdw.zzb((String) obj);
            case 12:
                if (obj instanceof zzdj) {
                    return zzdw.zzb((zzdj) obj);
                }
                return zzdw.zzb((byte[]) obj);
            case 13:
                return zzdw.zzg(((Integer) obj).intValue());
            case 14:
                return zzdw.zzj(((Integer) obj).intValue());
            case 15:
                return zzdw.zzh(((Long) obj).longValue());
            case 16:
                return zzdw.zzh(((Integer) obj).intValue());
            case 17:
                return zzdw.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzep) {
                    return zzdw.zzk(((zzep) obj).zza());
                }
                return zzdw.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzeh<?> zzehVar, Object obj) {
        zzho zzhoVarZzb = zzehVar.zzb();
        int iZza = zzehVar.zza();
        if (zzehVar.zzd()) {
            int iZza2 = 0;
            if (zzehVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzhoVarZzb, it.next());
                }
                return zzdw.zze(iZza) + iZza2 + zzdw.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzhoVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzhoVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzef zzefVar = new zzef();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzefVar.zzb((zzef) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzefVar.zzb((zzef) entry.getKey(), entry.getValue());
        }
        zzefVar.zzc = this.zzc;
        return zzefVar;
    }
}
