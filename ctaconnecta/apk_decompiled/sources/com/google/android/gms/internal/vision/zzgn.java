package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzgn<T extends zzgp<T>> {
    private static final zzgn zztt = new zzgn(true);
    final zzjb<T, Object> zztq;
    private boolean zztr;
    private boolean zzts;

    private zzgn() {
        this.zztq = zzjb.zzbu(16);
    }

    private zzgn(boolean z) {
        this(zzjb.zzbu(0));
        zzdq();
    }

    private zzgn(zzjb<T, Object> zzjbVar) {
        this.zztq = zzjbVar;
        zzdq();
    }

    public static <T extends zzgp<T>> zzgn<T> zzfo() {
        return zztt;
    }

    public final void zzdq() {
        if (this.zztr) {
            return;
        }
        this.zztq.zzdq();
        this.zztr = true;
    }

    public final boolean isImmutable() {
        return this.zztr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgn) {
            return this.zztq.equals(((zzgn) obj).zztq);
        }
        return false;
    }

    public final int hashCode() {
        return this.zztq.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzts) {
            return new zzhn(this.zztq.entrySet().iterator());
        }
        return this.zztq.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzts) {
            return new zzhn(this.zztq.zzia().iterator());
        }
        return this.zztq.zzia().iterator();
    }

    public final Object zza(T t) {
        Object obj = this.zztq.get(t);
        if (!(obj instanceof zzhi)) {
            return obj;
        }
        return zzhi.zzgv();
    }

    public final void zza(T t, Object obj) {
        if (t.zzfv()) {
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
                zza(t.zzft(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzft(), obj);
        }
        if (obj instanceof zzhi) {
            this.zzts = true;
        }
        this.zztq.zza((zzjb<T, Object>) t, (T) obj);
    }

    public final void zzb(T t, Object obj) {
        List arrayList;
        if (!t.zzfv()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zza(t.zzft(), obj);
        Object objZza = zza((zzgn<T>) t);
        if (objZza == null) {
            arrayList = new ArrayList();
            this.zztq.zza((zzjb<T, Object>) t, (T) arrayList);
        } else {
            arrayList = (List) objZza;
        }
        arrayList.add(obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzkf zzkfVar, Object obj) {
        zzgy.checkNotNull(obj);
        boolean z = true;
        switch (zzgq.zztw[zzkfVar.zziq().ordinal()]) {
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
                if (!(obj instanceof zzfm) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzhb)) {
                }
                break;
            case 9:
                if (!(obj instanceof zzih) && !(obj instanceof zzhi)) {
                }
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zztq.zzhy(); i++) {
            if (!zzb(this.zztq.zzbv(i))) {
                return false;
            }
        }
        Iterator it = this.zztq.zzhz().iterator();
        while (it.hasNext()) {
            if (!zzb((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzgp<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzfu() == zzki.MESSAGE) {
            if (key.zzfv()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzih) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzih) {
                    if (!((zzih) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzhi) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzgn<T> zzgnVar) {
        for (int i = 0; i < zzgnVar.zztq.zzhy(); i++) {
            zzc(zzgnVar.zztq.zzbv(i));
        }
        Iterator it = zzgnVar.zztq.zzhz().iterator();
        while (it.hasNext()) {
            zzc((Map.Entry) it.next());
        }
    }

    private static Object zzi(Object obj) {
        if (obj instanceof zzim) {
            return ((zzim) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzih zzihVarZzgd;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhi) {
            value = zzhi.zzgv();
        }
        if (key.zzfv()) {
            Object objZza = zza((zzgn<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zzi(it.next()));
            }
            this.zztq.zza((zzjb<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzfu() == zzki.MESSAGE) {
            Object objZza2 = zza((zzgn<T>) key);
            if (objZza2 == null) {
                this.zztq.zza((zzjb<T, Object>) key, (T) zzi(value));
                return;
            }
            if (objZza2 instanceof zzim) {
                zzihVarZzgd = key.zza((zzim) objZza2, (zzim) value);
            } else {
                zzihVarZzgd = key.zza(((zzih) objZza2).zzgj(), (zzih) value).zzgd();
            }
            this.zztq.zza((zzjb<T, Object>) key, (T) zzihVarZzgd);
            return;
        }
        this.zztq.zza((zzjb<T, Object>) key, (T) zzi(value));
    }

    static void zza(zzgf zzgfVar, zzkf zzkfVar, int i, Object obj) throws IOException {
        if (zzkfVar == zzkf.zzack) {
            zzih zzihVar = (zzih) obj;
            zzgy.zzf(zzihVar);
            zzgfVar.writeTag(i, 3);
            zzihVar.zzb(zzgfVar);
            zzgfVar.writeTag(i, 4);
        }
        zzgfVar.writeTag(i, zzkfVar.zzir());
        switch (zzgq.zzsg[zzkfVar.ordinal()]) {
            case 1:
                zzgfVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzgfVar.zzs(((Float) obj).floatValue());
                break;
            case 3:
                zzgfVar.zzs(((Long) obj).longValue());
                break;
            case 4:
                zzgfVar.zzs(((Long) obj).longValue());
                break;
            case 5:
                zzgfVar.zzax(((Integer) obj).intValue());
                break;
            case 6:
                zzgfVar.zzu(((Long) obj).longValue());
                break;
            case 7:
                zzgfVar.zzba(((Integer) obj).intValue());
                break;
            case 8:
                zzgfVar.zzk(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzih) obj).zzb(zzgfVar);
                break;
            case 10:
                zzgfVar.zzb((zzih) obj);
                break;
            case 11:
                if (obj instanceof zzfm) {
                    zzgfVar.zza((zzfm) obj);
                    break;
                } else {
                    zzgfVar.zzx((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzfm) {
                    zzgfVar.zza((zzfm) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzgfVar.zze(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzgfVar.zzay(((Integer) obj).intValue());
                break;
            case 14:
                zzgfVar.zzba(((Integer) obj).intValue());
                break;
            case 15:
                zzgfVar.zzu(((Long) obj).longValue());
                break;
            case 16:
                zzgfVar.zzaz(((Integer) obj).intValue());
                break;
            case 17:
                zzgfVar.zzt(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzhb) {
                    zzgfVar.zzax(((zzhb) obj).zzah());
                    break;
                } else {
                    zzgfVar.zzax(((Integer) obj).intValue());
                    break;
                }
        }
    }

    public final int zzfp() {
        int iZzd = 0;
        for (int i = 0; i < this.zztq.zzhy(); i++) {
            iZzd += zzd(this.zztq.zzbv(i));
        }
        Iterator it = this.zztq.zzhz().iterator();
        while (it.hasNext()) {
            iZzd += zzd((Map.Entry) it.next());
        }
        return iZzd;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzfu() == zzki.MESSAGE && !key.zzfv() && !key.zzfw()) {
            if (value instanceof zzhi) {
                return zzgf.zzb(entry.getKey().zzah(), (zzhi) value);
            }
            return zzgf.zzb(entry.getKey().zzah(), (zzih) value);
        }
        return zzc(key, value);
    }

    static int zza(zzkf zzkfVar, int i, Object obj) {
        int iZzbb = zzgf.zzbb(i);
        if (zzkfVar == zzkf.zzack) {
            zzgy.zzf((zzih) obj);
            iZzbb <<= 1;
        }
        return iZzbb + zzb(zzkfVar, obj);
    }

    private static int zzb(zzkf zzkfVar, Object obj) {
        switch (zzgq.zzsg[zzkfVar.ordinal()]) {
            case 1:
                return zzgf.zzb(((Double) obj).doubleValue());
            case 2:
                return zzgf.zzt(((Float) obj).floatValue());
            case 3:
                return zzgf.zzv(((Long) obj).longValue());
            case 4:
                return zzgf.zzw(((Long) obj).longValue());
            case 5:
                return zzgf.zzbc(((Integer) obj).intValue());
            case 6:
                return zzgf.zzy(((Long) obj).longValue());
            case 7:
                return zzgf.zzbf(((Integer) obj).intValue());
            case 8:
                return zzgf.zzl(((Boolean) obj).booleanValue());
            case 9:
                return zzgf.zzd((zzih) obj);
            case 10:
                if (obj instanceof zzhi) {
                    return zzgf.zza((zzhi) obj);
                }
                return zzgf.zzc((zzih) obj);
            case 11:
                if (obj instanceof zzfm) {
                    return zzgf.zzb((zzfm) obj);
                }
                return zzgf.zzy((String) obj);
            case 12:
                if (obj instanceof zzfm) {
                    return zzgf.zzb((zzfm) obj);
                }
                return zzgf.zzf((byte[]) obj);
            case 13:
                return zzgf.zzbd(((Integer) obj).intValue());
            case 14:
                return zzgf.zzbg(((Integer) obj).intValue());
            case 15:
                return zzgf.zzz(((Long) obj).longValue());
            case 16:
                return zzgf.zzbe(((Integer) obj).intValue());
            case 17:
                return zzgf.zzx(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzhb) {
                    return zzgf.zzbh(((zzhb) obj).zzah());
                }
                return zzgf.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzgp<?> zzgpVar, Object obj) {
        zzkf zzkfVarZzft = zzgpVar.zzft();
        int iZzah = zzgpVar.zzah();
        if (zzgpVar.zzfv()) {
            int iZza = 0;
            if (zzgpVar.zzfw()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza += zzb(zzkfVarZzft, it.next());
                }
                return zzgf.zzbb(iZzah) + iZza + zzgf.zzbj(iZza);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza += zza(zzkfVarZzft, iZzah, it2.next());
            }
            return iZza;
        }
        return zza(zzkfVarZzft, iZzah, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgn zzgnVar = new zzgn();
        for (int i = 0; i < this.zztq.zzhy(); i++) {
            Map.Entry<K, Object> entryZzbv = this.zztq.zzbv(i);
            zzgnVar.zza((zzgn) entryZzbv.getKey(), entryZzbv.getValue());
        }
        Iterator it = this.zztq.zzhz().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzgnVar.zza((zzgn) entry.getKey(), entry.getValue());
        }
        zzgnVar.zzts = this.zzts;
        return zzgnVar;
    }
}
