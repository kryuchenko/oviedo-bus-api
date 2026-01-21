package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzbi extends zzay {
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzay
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        switch (zzbl.zza[zzg.zza(str).ordinal()]) {
            case 1:
                zzg.zza(zzbv.FOR_IN, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                String strZzf = list.get(0).zzf();
                return zza(new zzbp(zzhVar, strZzf), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 2:
                zzg.zza(zzbv.FOR_IN_CONST, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                String strZzf2 = list.get(0).zzf();
                return zza(new zzbk(zzhVar, strZzf2), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 3:
                zzg.zza(zzbv.FOR_IN_LET, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                String strZzf3 = list.get(0).zzf();
                return zza(new zzbn(zzhVar, strZzf3), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 4:
                zzg.zza(zzbv.FOR_LET, 4, list);
                zzaq zzaqVarZza = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza instanceof zzaf)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                zzaf zzafVar = (zzaf) zzaqVarZza;
                zzaq zzaqVar = list.get(1);
                zzaq zzaqVar2 = list.get(2);
                zzaq zzaqVarZza2 = zzhVar.zza(list.get(3));
                zzh zzhVarZza = zzhVar.zza();
                for (int i = 0; i < zzafVar.zzb(); i++) {
                    String strZzf4 = zzafVar.zza(i).zzf();
                    zzhVarZza.zzc(strZzf4, zzhVar.zza(strZzf4));
                }
                while (zzhVar.zza(zzaqVar).zzd().booleanValue()) {
                    zzaq zzaqVarZza3 = zzhVar.zza((zzaf) zzaqVarZza2);
                    if (zzaqVarZza3 instanceof zzaj) {
                        zzaj zzajVar = (zzaj) zzaqVarZza3;
                        if ("break".equals(zzajVar.zzb())) {
                            return zzaq.zzc;
                        }
                        if ("return".equals(zzajVar.zzb())) {
                            return zzajVar;
                        }
                    }
                    zzh zzhVarZza2 = zzhVar.zza();
                    for (int i2 = 0; i2 < zzafVar.zzb(); i2++) {
                        String strZzf5 = zzafVar.zza(i2).zzf();
                        zzhVarZza2.zzc(strZzf5, zzhVarZza.zza(strZzf5));
                    }
                    zzhVarZza2.zza(zzaqVar2);
                    zzhVarZza = zzhVarZza2;
                }
                return zzaq.zzc;
            case 5:
                zzg.zza(zzbv.FOR_OF, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                String strZzf6 = list.get(0).zzf();
                return zzb(new zzbp(zzhVar, strZzf6), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 6:
                zzg.zza(zzbv.FOR_OF_CONST, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                String strZzf7 = list.get(0).zzf();
                return zzb(new zzbk(zzhVar, strZzf7), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 7:
                zzg.zza(zzbv.FOR_OF_LET, 3, list);
                if (!(list.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                String strZzf8 = list.get(0).zzf();
                return zzb(new zzbn(zzhVar, strZzf8), zzhVar.zza(list.get(1)), zzhVar.zza(list.get(2)));
            case 8:
                zzg.zza(zzbv.WHILE, 4, list);
                zzaq zzaqVar3 = list.get(0);
                zzaq zzaqVar4 = list.get(1);
                zzaq zzaqVar5 = list.get(2);
                zzaq zzaqVarZza4 = zzhVar.zza(list.get(3));
                if (zzhVar.zza(zzaqVar5).zzd().booleanValue()) {
                    zzaq zzaqVarZza5 = zzhVar.zza((zzaf) zzaqVarZza4);
                    if (zzaqVarZza5 instanceof zzaj) {
                        zzaj zzajVar2 = (zzaj) zzaqVarZza5;
                        if (!"break".equals(zzajVar2.zzb())) {
                            if ("return".equals(zzajVar2.zzb())) {
                                return zzajVar2;
                            }
                            while (zzhVar.zza(zzaqVar3).zzd().booleanValue()) {
                                zzaq zzaqVarZza6 = zzhVar.zza((zzaf) zzaqVarZza4);
                                if (zzaqVarZza6 instanceof zzaj) {
                                    zzaj zzajVar3 = (zzaj) zzaqVarZza6;
                                    if (!"break".equals(zzajVar3.zzb())) {
                                        if ("return".equals(zzajVar3.zzb())) {
                                            return zzajVar3;
                                        }
                                    }
                                }
                                zzhVar.zza(zzaqVar4);
                            }
                        }
                    } else {
                        while (zzhVar.zza(zzaqVar3).zzd().booleanValue()) {
                        }
                    }
                }
                return zzaq.zzc;
            default:
                return super.zza(str);
        }
    }

    private static zzaq zza(zzbm zzbmVar, Iterator<zzaq> it, zzaq zzaqVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzaq zzaqVarZza = zzbmVar.zza(it.next()).zza((zzaf) zzaqVar);
                if (zzaqVarZza instanceof zzaj) {
                    zzaj zzajVar = (zzaj) zzaqVarZza;
                    if ("break".equals(zzajVar.zzb())) {
                        return zzaq.zzc;
                    }
                    if ("return".equals(zzajVar.zzb())) {
                        return zzajVar;
                    }
                }
            }
        }
        return zzaq.zzc;
    }

    private static zzaq zza(zzbm zzbmVar, zzaq zzaqVar, zzaq zzaqVar2) {
        return zza(zzbmVar, zzaqVar.zzh(), zzaqVar2);
    }

    private static zzaq zzb(zzbm zzbmVar, zzaq zzaqVar, zzaq zzaqVar2) {
        if (zzaqVar instanceof Iterable) {
            return zza(zzbmVar, (Iterator<zzaq>) ((Iterable) zzaqVar).iterator(), zzaqVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    protected zzbi() {
        this.zza.add(zzbv.FOR_IN);
        this.zza.add(zzbv.FOR_IN_CONST);
        this.zza.add(zzbv.FOR_IN_LET);
        this.zza.add(zzbv.FOR_LET);
        this.zza.add(zzbv.FOR_OF);
        this.zza.add(zzbv.FOR_OF_CONST);
        this.zza.add(zzbv.FOR_OF_LET);
        this.zza.add(zzbv.WHILE);
    }
}
