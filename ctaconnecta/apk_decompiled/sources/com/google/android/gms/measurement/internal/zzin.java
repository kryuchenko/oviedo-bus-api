package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzin {
    public static final zzin zza = new zzin(null, null, 100);
    private final EnumMap<zza, zzim> zzb;
    private final int zzc;

    public static boolean zza(int i, int i2) {
        if (i == -20 && i2 == -30) {
            return true;
        }
        return (i == -30 && i2 == -20) || i == i2 || i < i2;
    }

    static char zza(zzim zzimVar) {
        if (zzimVar == null) {
            return '-';
        }
        int iOrdinal = zzimVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int iHashCode = this.zzc * 17;
        Iterator<zzim> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.zzb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strZzb = zzb((zzim) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zza) entry.getKey()).zze, strZzb);
            }
        }
        return bundle;
    }

    static zzim zza(String str) {
        if (str == null) {
            return zzim.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzim.GRANTED;
        }
        if (str.equals("denied")) {
            return zzim.DENIED;
        }
        return zzim.UNINITIALIZED;
    }

    public final zzim zzc() {
        zzim zzimVar = this.zzb.get(zza.AD_STORAGE);
        return zzimVar == null ? zzim.UNINITIALIZED : zzimVar;
    }

    public final zzim zzd() {
        zzim zzimVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzimVar == null ? zzim.UNINITIALIZED : zzimVar;
    }

    static zzim zza(char c) {
        if (c == '+') {
            return zzim.POLICY;
        }
        if (c == '0') {
            return zzim.DENIED;
        }
        if (c == '1') {
            return zzim.GRANTED;
        }
        return zzim.UNINITIALIZED;
    }

    static zzim zza(Boolean bool) {
        if (bool == null) {
            return zzim.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzim.GRANTED;
        }
        return zzim.DENIED;
    }

    public static zzin zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzin(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzio.STORAGE.zzd) {
            enumMap.put((EnumMap) zzaVar, (zza) zza(bundle.getString(zzaVar.zze)));
        }
        return new zzin(enumMap, i);
    }

    public static zzin zza(zzim zzimVar, zzim zzimVar2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzimVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzimVar2);
        return new zzin(enumMap, -10);
    }

    public static zzin zzb(String str) {
        return zza(str, 100);
    }

    public static zzin zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzio.STORAGE.zza();
        for (int i2 = 0; i2 < zzaVarArrZza.length; i2++) {
            zza zzaVar = zzaVarArrZza[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzim.UNINITIALIZED);
            }
        }
        return new zzin(enumMap, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzin zza(zzin zzinVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzio.STORAGE.zzd) {
            zzim zzimVar = this.zzb.get(zzaVar);
            zzim zzimVar2 = zzinVar.zzb.get(zzaVar);
            if (zzimVar != null) {
                if (zzimVar2 != null) {
                    if (zzimVar != zzim.UNINITIALIZED) {
                        if (zzimVar2 != zzim.UNINITIALIZED) {
                            if (zzimVar == zzim.POLICY) {
                                zzimVar = zzimVar2;
                            } else if (zzimVar2 != zzim.POLICY) {
                                zzimVar = (zzimVar == zzim.DENIED || zzimVar2 == zzim.DENIED) ? zzim.DENIED : zzim.GRANTED;
                            }
                        }
                    }
                }
            }
            if (zzimVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzimVar);
            }
        }
        return new zzin(enumMap, 100);
    }

    public final zzin zzb(zzin zzinVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzio.STORAGE.zzd) {
            zzim zzimVar = this.zzb.get(zzaVar);
            if (zzimVar == zzim.UNINITIALIZED) {
                zzimVar = zzinVar.zzb.get(zzaVar);
            }
            if (zzimVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzimVar);
            }
        }
        return new zzin(enumMap, this.zzc);
    }

    public final Boolean zze() {
        zzim zzimVar = this.zzb.get(zza.AD_STORAGE);
        if (zzimVar == null) {
            return null;
        }
        int iOrdinal = zzimVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return true;
    }

    public final Boolean zzf() {
        zzim zzimVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zzimVar == null) {
            return null;
        }
        int iOrdinal = zzimVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return true;
    }

    static String zza(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i == 90) {
            return "REMOTE_CONFIG";
        }
        if (i == 100) {
            return "UNKNOWN";
        }
        return "OTHER";
    }

    static String zzb(zzim zzimVar) {
        int iOrdinal = zzimVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzio.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string != null) {
                    if (string.equals("granted")) {
                        bool = Boolean.TRUE;
                    } else if (string.equals("denied")) {
                        bool = Boolean.FALSE;
                    }
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzg() {
        int iOrdinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzio.STORAGE.zza()) {
            zzim zzimVar = this.zzb.get(zzaVar);
            char c = '-';
            if (zzimVar != null && (iOrdinal = zzimVar.ordinal()) != 0) {
                if (iOrdinal == 1) {
                    c = '1';
                } else if (iOrdinal == 2) {
                    c = '0';
                } else if (iOrdinal != 3) {
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzio.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zza(this.zzc));
        for (zza zzaVar : zzio.STORAGE.zzd) {
            sb.append(",");
            sb.append(zzaVar.zze);
            sb.append("=");
            zzim zzimVar = this.zzb.get(zzaVar);
            if (zzimVar == null) {
                zzimVar = zzim.UNINITIALIZED;
            }
            sb.append(zzimVar);
        }
        return sb.toString();
    }

    private zzin(EnumMap<zza, zzim> enumMap, int i) {
        EnumMap<zza, zzim> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzin(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zzim> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, zzim>) zza.AD_STORAGE, (zza) zza(bool));
        enumMap.put((EnumMap<zza, zzim>) zza.ANALYTICS_STORAGE, (zza) zza(bool2));
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzin)) {
            return false;
        }
        zzin zzinVar = (zzin) obj;
        for (zza zzaVar : zzio.STORAGE.zzd) {
            if (this.zzb.get(zzaVar) != zzinVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzinVar.zzc;
    }

    public final boolean zza(zzin zzinVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zzinVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzim.DENIED;
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        Iterator<zzim> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzim.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzin zzinVar) {
        return zzb(zzinVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final boolean zzb(zzin zzinVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zzim zzimVar = this.zzb.get(zzaVar);
            zzim zzimVar2 = zzinVar.zzb.get(zzaVar);
            if (zzimVar == zzim.DENIED && zzimVar2 != zzim.DENIED) {
                return true;
            }
        }
        return false;
    }
}
