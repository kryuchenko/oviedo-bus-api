package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzfs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final class zzfq<T extends zzfs<T>> {
    private static final zzfq zzd = new zzfq(true);
    final zzhy<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzfq() {
        this.zza = zzhy.zza(16);
    }

    private zzfq(boolean z) {
        this(zzhy.zza(0));
        zzb();
    }

    private zzfq(zzhy<T, Object> zzhyVar) {
        this.zza = zzhyVar;
        zzb();
    }

    public static <T extends zzfs<T>> zzfq<T> zza() {
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
        if (obj instanceof zzfq) {
            return this.zza.equals(((zzfq) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzgm(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzgm(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzgl)) {
            return obj;
        }
        return zzgl.zza();
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
        if (obj instanceof zzgl) {
            this.zzc = true;
        }
        this.zza.zza((zzhy<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzjd zzjdVar, Object obj) {
        zzgb.zza(obj);
        boolean z = true;
        switch (zzft.zza[zzjdVar.zza().ordinal()]) {
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
                if (!(obj instanceof zzeu) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzga)) {
                }
                break;
            case 9:
                if (!(obj instanceof zzhg) && !(obj instanceof zzgl)) {
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

    private static <T extends zzfs<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzjg.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzhg) it.next()).a_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhg) {
                    if (!((zzhg) value).a_()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzgl) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfq<T> zzfqVar) {
        for (int i = 0; i < zzfqVar.zza.zzc(); i++) {
            zzb(zzfqVar.zza.zzb(i));
        }
        Iterator it = zzfqVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzhm) {
            return ((zzhm) obj).clone();
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
        zzhg zzhgVarZzh;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgl) {
            value = zzgl.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzfq<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.zza((zzhy<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzc() == zzjg.MESSAGE) {
            Object objZza2 = zza((zzfq<T>) key);
            if (objZza2 == null) {
                this.zza.zza((zzhy<T, Object>) key, (T) zza(value));
                return;
            }
            if (objZza2 instanceof zzhm) {
                zzhgVarZzh = key.zza((zzhm) objZza2, (zzhm) value);
            } else {
                zzhgVarZzh = key.zza(((zzhg) objZza2).zzm(), (zzhg) value).zzh();
            }
            this.zza.zza((zzhy<T, Object>) key, (T) zzhgVarZzh);
            return;
        }
        this.zza.zza((zzhy<T, Object>) key, (T) zza(value));
    }

    static void zza(zzfl zzflVar, zzjd zzjdVar, int i, Object obj) throws IOException {
        if (zzjdVar == zzjd.zzj) {
            zzhg zzhgVar = (zzhg) obj;
            zzgb.zza(zzhgVar);
            zzflVar.zza(i, 3);
            zzhgVar.zza(zzflVar);
            zzflVar.zza(i, 4);
        }
        zzflVar.zza(i, zzjdVar.zzb());
        switch (zzft.zzb[zzjdVar.ordinal()]) {
            case 1:
                zzflVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzflVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzflVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzflVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzflVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzflVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzflVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzflVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzhg) obj).zza(zzflVar);
                break;
            case 10:
                zzflVar.zza((zzhg) obj);
                break;
            case 11:
                if (obj instanceof zzeu) {
                    zzflVar.zza((zzeu) obj);
                    break;
                } else {
                    zzflVar.zza((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzeu) {
                    zzflVar.zza((zzeu) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzflVar.zzb(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzflVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzflVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzflVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzflVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzflVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzga) {
                    zzflVar.zza(((zzga) obj).zza());
                    break;
                } else {
                    zzflVar.zza(((Integer) obj).intValue());
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
        if (key.zzc() == zzjg.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzgl) {
                return zzfl.zzb(entry.getKey().zza(), (zzgl) value);
            }
            return zzfl.zzb(entry.getKey().zza(), (zzhg) value);
        }
        return zza((zzfs<?>) key, value);
    }

    static int zza(zzjd zzjdVar, int i, Object obj) {
        int iZze = zzfl.zze(i);
        if (zzjdVar == zzjd.zzj) {
            zzgb.zza((zzhg) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzjdVar, obj);
    }

    private static int zzb(zzjd zzjdVar, Object obj) {
        switch (zzft.zzb[zzjdVar.ordinal()]) {
            case 1:
                return zzfl.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfl.zzb(((Float) obj).floatValue());
            case 3:
                return zzfl.zzd(((Long) obj).longValue());
            case 4:
                return zzfl.zze(((Long) obj).longValue());
            case 5:
                return zzfl.zzf(((Integer) obj).intValue());
            case 6:
                return zzfl.zzg(((Long) obj).longValue());
            case 7:
                return zzfl.zzi(((Integer) obj).intValue());
            case 8:
                return zzfl.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzfl.zzc((zzhg) obj);
            case 10:
                if (obj instanceof zzgl) {
                    return zzfl.zza((zzgl) obj);
                }
                return zzfl.zzb((zzhg) obj);
            case 11:
                if (obj instanceof zzeu) {
                    return zzfl.zzb((zzeu) obj);
                }
                return zzfl.zzb((String) obj);
            case 12:
                if (obj instanceof zzeu) {
                    return zzfl.zzb((zzeu) obj);
                }
                return zzfl.zzb((byte[]) obj);
            case 13:
                return zzfl.zzg(((Integer) obj).intValue());
            case 14:
                return zzfl.zzj(((Integer) obj).intValue());
            case 15:
                return zzfl.zzh(((Long) obj).longValue());
            case 16:
                return zzfl.zzh(((Integer) obj).intValue());
            case 17:
                return zzfl.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzga) {
                    return zzfl.zzk(((zzga) obj).zza());
                }
                return zzfl.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzfs<?> zzfsVar, Object obj) {
        zzjd zzjdVarZzb = zzfsVar.zzb();
        int iZza = zzfsVar.zza();
        if (zzfsVar.zzd()) {
            int iZza2 = 0;
            if (zzfsVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzjdVarZzb, it.next());
                }
                return zzfl.zze(iZza) + iZza2 + zzfl.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzjdVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzjdVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfq zzfqVar = new zzfq();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzfqVar.zzb((zzfq) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzfqVar.zzb((zzfq) entry.getKey(), entry.getValue());
        }
        zzfqVar.zzc = this.zzc;
        return zzfqVar;
    }
}
