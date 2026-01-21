package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzoc;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
final class zzu extends zzmx {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzw> zzc;
    private Long zzd;
    private Long zze;

    private final zzw zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzw zzwVar = new zzw(this, this.zza);
        this.zzc.put(num, zzwVar);
        return zzwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzmx
    protected final boolean zzc() {
        return false;
    }

    final List<zzfn.zzd> zza(String str, List<zzfn.zzf> list, List<zzfn.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    final List<zzfn.zzd> zza(String str, List<zzfn.zzf> list, List<zzfn.zzo> list2, Long l, Long l2, boolean z) throws IllegalStateException {
        boolean z2;
        HashSet hashSet;
        Map<Integer, zzfn.zzm> map;
        List<zzff.zzb> list3;
        boolean z3;
        Map<Integer, zzfn.zzm> map2;
        Iterator it;
        zzfn.zzm zzmVar;
        Iterator<zzfn.zze> it2;
        Long l3;
        HashSet hashSet2;
        Map<Integer, List<Integer>> map3;
        Iterator<Integer> it3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfn.zzf> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it4.next().zzg())) {
                z2 = true;
                break;
            }
        }
        boolean z4 = zzoc.zza() && zze().zzf(this.zza, zzbf.zzbk);
        boolean z5 = zzoc.zza() && zze().zzf(this.zza, zzbf.zzbj);
        if (z2) {
            zzal zzalVarZzh = zzh();
            String str2 = this.zza;
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzalVarZzh.e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzfw.zza(str2), e);
            }
        }
        Map<Integer, List<zzff.zzb>> mapZzm = Collections.EMPTY_MAP;
        if (z5 && z4) {
            mapZzm = zzh().zzm(this.zza);
        }
        Map<Integer, zzfn.zzm> mapZzl = zzh().zzl(this.zza);
        if (!mapZzl.isEmpty()) {
            HashSet hashSet3 = new HashSet(mapZzl.keySet());
            if (z2) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> mapZzn = zzh().zzn(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzl);
                ArrayMap arrayMap = new ArrayMap();
                if (!mapZzl.isEmpty()) {
                    Iterator<Integer> it5 = mapZzl.keySet().iterator();
                    while (it5.hasNext()) {
                        Integer next = it5.next();
                        next.intValue();
                        zzfn.zzm zzmVar2 = mapZzl.get(next);
                        List<Integer> list4 = mapZzn.get(next);
                        if (list4 == null || list4.isEmpty()) {
                            hashSet2 = hashSet3;
                            map3 = mapZzn;
                            it3 = it5;
                            arrayMap.put(next, zzmVar2);
                        } else {
                            hashSet2 = hashSet3;
                            List<Long> listZza = g_().zza(zzmVar2.zzi(), list4);
                            if (listZza.isEmpty()) {
                                hashSet3 = hashSet2;
                            } else {
                                zzfn.zzm.zza zzaVarZzb = zzmVar2.zzcc().zzb().zzb(listZza);
                                zzaVarZzb.zzd().zzd(g_().zza(zzmVar2.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzfn.zze zzeVar : zzmVar2.zzh()) {
                                    Map<Integer, List<Integer>> map4 = mapZzn;
                                    Iterator<Integer> it6 = it5;
                                    if (!list4.contains(Integer.valueOf(zzeVar.zza()))) {
                                        arrayList.add(zzeVar);
                                    }
                                    mapZzn = map4;
                                    it5 = it6;
                                }
                                map3 = mapZzn;
                                it3 = it5;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfn.zzn zznVar : zzmVar2.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zznVar.zzb()))) {
                                        arrayList2.add(zznVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                arrayMap.put(next, (zzfn.zzm) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzb.zzai()));
                            }
                        }
                        hashSet3 = hashSet2;
                        mapZzn = map3;
                        it5 = it3;
                    }
                }
                hashSet = hashSet3;
                map = arrayMap;
            } else {
                hashSet = hashSet3;
                map = mapZzl;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                Integer num = (Integer) it7.next();
                num.intValue();
                zzfn.zzm zzmVar3 = map.get(num);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                zzfn.zzm zzmVar4 = zzmVar3;
                ArrayMap arrayMap2 = new ArrayMap();
                if (zzmVar4 != null && zzmVar4.zza() != 0) {
                    Iterator<zzfn.zze> it8 = zzmVar4.zzh().iterator();
                    while (it8.hasNext()) {
                        zzfn.zze next2 = it8.next();
                        if (next2.zzf()) {
                            zzmVar = zzmVar4;
                            Integer numValueOf = Integer.valueOf(next2.zza());
                            if (next2.zze()) {
                                Long lValueOf = Long.valueOf(next2.zzb());
                                it2 = it8;
                                l3 = lValueOf;
                            } else {
                                it2 = it8;
                                l3 = null;
                            }
                            arrayMap2.put(numValueOf, l3);
                        } else {
                            zzmVar = zzmVar4;
                            it2 = it8;
                        }
                        it8 = it2;
                        zzmVar4 = zzmVar;
                    }
                }
                zzfn.zzm zzmVar5 = zzmVar4;
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzmVar5 != null && zzmVar5.zzc() != 0) {
                    Iterator<zzfn.zzn> it9 = zzmVar5.zzj().iterator();
                    while (it9.hasNext()) {
                        Iterator<zzfn.zzn> it10 = it9;
                        zzfn.zzn next3 = it9.next();
                        if (!next3.zzf() || next3.zza() <= 0) {
                            map2 = map;
                            it = it7;
                        } else {
                            map2 = map;
                            it = it7;
                            arrayMap3.put(Integer.valueOf(next3.zzb()), Long.valueOf(next3.zza(next3.zza() - 1)));
                        }
                        it9 = it10;
                        map = map2;
                        it7 = it;
                    }
                }
                Map<Integer, zzfn.zzm> map5 = map;
                Iterator it11 = it7;
                if (zzmVar5 != null) {
                    int i = 0;
                    while (i < (zzmVar5.zzd() << 6)) {
                        if (zznl.zza(zzmVar5.zzk(), i)) {
                            z3 = z4;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", num, Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zznl.zza(zzmVar5.zzi(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            z4 = z3;
                        } else {
                            z3 = z4;
                        }
                        arrayMap2.remove(Integer.valueOf(i));
                        i++;
                        z4 = z3;
                    }
                }
                boolean z6 = z4;
                zzfn.zzm zzmVar6 = mapZzl.get(num);
                if (z5 && z6 && (list3 = mapZzm.get(num)) != null && this.zze != null && this.zzd != null) {
                    for (zzff.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        Map<Integer, List<zzff.zzb>> map6 = mapZzm;
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap2.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        mapZzm = map6;
                    }
                }
                this.zzc.put(num, new zzw(this, this.zza, zzmVar6, bitSet, bitSet2, arrayMap2, arrayMap3));
                mapZzl = mapZzl;
                z4 = z6;
                mapZzm = mapZzm;
                map = map5;
                it7 = it11;
            }
        }
        if (com.google.android.gms.internal.measurement.zznk.zza() && zze().zzf(null, zzbf.zzcv)) {
            zza(list, z);
            if (z) {
                return new ArrayList();
            }
            zza(list2);
            return zzu();
        }
        zza(list, true);
        zza(list2);
        return zzu();
    }

    private final List<zzfn.zzd> zzu() throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        for (Integer num : setKeySet) {
            int iIntValue = num.intValue();
            zzw zzwVar = this.zzc.get(num);
            Preconditions.checkNotNull(zzwVar);
            zzfn.zzd zzdVarZza = zzwVar.zza(iIntValue);
            arrayList.add(zzdVarZza);
            zzal zzalVarZzh = zzh();
            String str = this.zza;
            zzfn.zzm zzmVarZzd = zzdVarZza.zzd();
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzmVarZzd);
            byte[] bArrZzbz = zzmVarZzd.zzbz();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", bArrZzbz);
            try {
                if (zzalVarZzh.e_().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzalVarZzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzfw.zza(str));
                }
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error storing filter results. appId", zzfw.zza(str), e);
            }
        }
        return arrayList;
    }

    zzu(zznc zzncVar) {
        super(zzncVar);
    }

    private final void zza(List<zzfn.zzf> list, boolean z) throws IllegalStateException {
        ArrayMap arrayMap;
        zzy zzyVar;
        zzaz zzazVar;
        zzx zzxVar;
        if (list.isEmpty()) {
            return;
        }
        zzx zzxVar2 = null;
        zzy zzyVar2 = new zzy(this);
        ArrayMap arrayMap2 = new ArrayMap();
        for (zzfn.zzf zzfVar : list) {
            zzfn.zzf zzfVarZza = zzyVar2.zza(this.zza, zzfVar);
            if (zzfVarZza != null) {
                zzal zzalVarZzh = zzh();
                String str = this.zza;
                String strZzg = zzfVarZza.zzg();
                zzaz zzazVarZzd = zzalVarZzh.zzd(str, zzfVar.zzg());
                if (zzazVarZzd == null) {
                    zzalVarZzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfw.zza(str), zzalVarZzh.zzi().zza(strZzg));
                    zzyVar = zzyVar2;
                    arrayMap = arrayMap2;
                    zzazVar = new zzaz(str, zzfVar.zzg(), 1L, 1L, 1L, zzfVar.zzd(), 0L, null, null, null, null);
                } else {
                    arrayMap = arrayMap2;
                    zzyVar = zzyVar2;
                    zzazVar = new zzaz(zzazVarZzd.zza, zzazVarZzd.zzb, zzazVarZzd.zzc + 1, zzazVarZzd.zzd + 1, zzazVarZzd.zze + 1, zzazVarZzd.zzf, zzazVarZzd.zzg, zzazVarZzd.zzh, zzazVarZzd.zzi, zzazVarZzd.zzj, zzazVarZzd.zzk);
                }
                zzh().zza(zzazVar);
                if (com.google.android.gms.internal.measurement.zznk.zza()) {
                    zzxVar = null;
                    if (zze().zzf(null, zzbf.zzcv) && z) {
                        zzxVar2 = null;
                        arrayMap2 = arrayMap;
                    }
                    zzyVar2 = zzyVar;
                } else {
                    zzxVar = null;
                }
                long j = zzazVar.zzc;
                String strZzg2 = zzfVarZza.zzg();
                ArrayMap arrayMap3 = arrayMap;
                Map<Integer, List<zzff.zzb>> mapZzf = (Map) arrayMap3.get(strZzg2);
                if (mapZzf == null) {
                    mapZzf = zzh().zzf(this.zza, strZzg2);
                    arrayMap3.put(strZzg2, mapZzf);
                }
                for (Integer num : mapZzf.keySet()) {
                    int iIntValue = num.intValue();
                    if (this.zzb.contains(num)) {
                        zzj().zzp().zza("Skipping failed audience ID", num);
                    } else {
                        Iterator<zzff.zzb> it = mapZzf.get(num).iterator();
                        boolean z2 = true;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zzff.zzb next = it.next();
                            zzaa zzaaVar = new zzaa(this, this.zza, iIntValue, next);
                            boolean zZza = zzaaVar.zza(this.zzd, this.zze, zzfVarZza, j, zzazVar, zza(iIntValue, next.zzb()));
                            if (zZza) {
                                zza(num).zza(zzaaVar);
                                z2 = zZza;
                            } else {
                                this.zzb.add(num);
                                z2 = zZza;
                                break;
                            }
                        }
                        if (!z2) {
                            this.zzb.add(num);
                        }
                    }
                }
                zzx zzxVar3 = zzxVar;
                arrayMap2 = arrayMap3;
                zzxVar2 = zzxVar3;
                zzyVar2 = zzyVar;
            } else {
                arrayMap2 = arrayMap2;
                zzxVar2 = zzxVar2;
            }
        }
    }

    private final void zza(List<zzfn.zzo> list) throws IllegalStateException {
        zzff.zze next;
        if (list.isEmpty()) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzfn.zzo zzoVar : list) {
            String strZzg = zzoVar.zzg();
            Map<Integer, List<zzff.zze>> mapZzg = (Map) arrayMap.get(strZzg);
            if (mapZzg == null) {
                mapZzg = zzh().zzg(this.zza, strZzg);
                arrayMap.put(strZzg, mapZzg);
            }
            Iterator<Integer> it = mapZzg.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Integer next2 = it.next();
                    int iIntValue = next2.intValue();
                    if (this.zzb.contains(next2)) {
                        zzj().zzp().zza("Skipping failed audience ID", next2);
                        break;
                    }
                    Iterator<zzff.zze> it2 = mapZzg.get(next2).iterator();
                    boolean zZza = true;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        next = it2.next();
                        if (zzj().zza(2)) {
                            zzj().zzp().zza("Evaluating filter. audience, filter, property", next2, next.zzi() ? Integer.valueOf(next.zza()) : null, zzi().zzc(next.zze()));
                            zzj().zzp().zza("Filter definition", g_().zza(next));
                        }
                        if (!next.zzi() || next.zza() > 256) {
                            break;
                        }
                        zzac zzacVar = new zzac(this, this.zza, iIntValue, next);
                        zZza = zzacVar.zza(this.zzd, this.zze, zzoVar, zza(iIntValue, next.zza()));
                        if (zZza) {
                            zza(next2).zza(zzacVar);
                        } else {
                            this.zzb.add(next2);
                            break;
                        }
                    }
                    zzj().zzu().zza("Invalid property filter ID. appId, id", zzfw.zza(this.zza), String.valueOf(next.zzi() ? Integer.valueOf(next.zza()) : null));
                    zZza = false;
                    if (!zZza) {
                        this.zzb.add(next2);
                    }
                }
            }
        }
    }

    private final boolean zza(int i, int i2) {
        zzw zzwVar = this.zzc.get(Integer.valueOf(i));
        if (zzwVar == null) {
            return false;
        }
        return zzwVar.zzd.get(i2);
    }
}
