package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be A[PHI: r6
      0x00be: PHI (r6v30 java.lang.String) = (r6v2 java.lang.String), (r6v3 java.lang.String), (r6v4 java.lang.String), (r6v31 java.lang.String) binds: [B:107:0x01c2, B:103:0x01b3, B:99:0x01a4, B:43:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019e  */
    @Override // com.google.android.gms.internal.measurement.zzaq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        String str2;
        String str3;
        char c;
        String str4;
        String str5;
        String str6;
        int i;
        zzas zzasVar;
        String strZzf;
        String strZzf2;
        double dMin;
        double dMin2;
        int i2;
        int length;
        zzh zzhVar2;
        String strZzf3;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !FirebaseAnalytics.Event.SEARCH.equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str) && !"toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                if (!"trim".equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            str.hashCode();
            c = 65535;
            switch (str.hashCode()) {
                case -1789698943:
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                    if (str.equals(str5)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1776922004:
                    str4 = "charAt";
                    if (str.equals("toString")) {
                        str5 = str3;
                        c = 1;
                    } else {
                        str5 = str3;
                    }
                    str6 = "toString";
                    break;
                case -1464939364:
                    str4 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        str5 = str3;
                        c = 2;
                    }
                    str6 = "toString";
                    break;
                case -1361633751:
                    str4 = "charAt";
                    if (str.equals(str4)) {
                        str5 = str3;
                        c = 3;
                    }
                    str6 = "toString";
                    break;
                case -1354795244:
                    if (str.equals("concat")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 4;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 5;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case -906336856:
                    if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 6;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case -726908483:
                    if (str.equals(str2)) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 7;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = '\b';
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = '\t';
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 3568674:
                    if (str.equals("trim")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = '\n';
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 103668165:
                    if (str.equals("match")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 11;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 109526418:
                    if (str.equals("slice")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = '\f';
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 109648666:
                    if (str.equals("split")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = '\r';
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 530542161:
                    if (str.equals("substring")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 14;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 1094496948:
                    if (str.equals("replace")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 15;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                case 1943291465:
                    if (str.equals("indexOf")) {
                        str4 = "charAt";
                        str5 = str3;
                        c = 16;
                        str6 = "toString";
                        break;
                    }
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                default:
                    str4 = "charAt";
                    str5 = str3;
                    str6 = "toString";
                    break;
            }
            switch (c) {
                case 0:
                    zzg.zza(str5, 1, list);
                    String str7 = this.zza;
                    zzaq zzaqVarZza = zzhVar.zza(list.get(0));
                    if ("length".equals(zzaqVarZza.zzf())) {
                        return zzag.zzh;
                    }
                    double dDoubleValue = zzaqVarZza.zze().doubleValue();
                    if (dDoubleValue == Math.floor(dDoubleValue) && (i = (int) dDoubleValue) >= 0 && i < str7.length()) {
                        return zzag.zzh;
                    }
                    return zzag.zzi;
                case 1:
                    zzg.zza(str6, 0, list);
                    return this;
                case 2:
                    zzg.zza("toLocaleLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase());
                case 3:
                    zzg.zzc(str4, 1, list);
                    int iZza = !list.isEmpty() ? (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue()) : 0;
                    String str8 = this.zza;
                    if (iZza < 0 || iZza >= str8.length()) {
                        return zzaq.zzj;
                    }
                    return new zzas(String.valueOf(str8.charAt(iZza)));
                case 4:
                    zzasVar = this;
                    if (!list.isEmpty()) {
                        StringBuilder sb = new StringBuilder(zzasVar.zza);
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            sb.append(zzhVar.zza(list.get(i3)).zzf());
                        }
                        return new zzas(sb.toString());
                    }
                    return zzasVar;
                case 5:
                    zzg.zza("toLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
                case 6:
                    zzg.zzc(FirebaseAnalytics.Event.SEARCH, 1, list);
                    if (!list.isEmpty()) {
                        strZzf = zzhVar.zza(list.get(0)).zzf();
                    } else {
                        strZzf = zzaq.zzc.zzf();
                    }
                    if (Pattern.compile(strZzf).matcher(this.zza).find()) {
                        return new zzai(Double.valueOf(r0.start()));
                    }
                    return new zzai(Double.valueOf(-1.0d));
                case 7:
                    zzg.zza(str2, 0, list);
                    return new zzas(this.zza.toUpperCase());
                case '\b':
                    zzg.zzc("lastIndexOf", 2, list);
                    String str9 = this.zza;
                    if (list.size() <= 0) {
                        strZzf2 = zzaq.zzc.zzf();
                    } else {
                        strZzf2 = zzhVar.zza(list.get(0)).zzf();
                    }
                    return new zzai(Double.valueOf(str9.lastIndexOf(strZzf2, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzhVar.zza(list.get(1)).zze().doubleValue()) ? Double.POSITIVE_INFINITY : zzg.zza(r2)))));
                case '\t':
                    zzg.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
                case '\n':
                    zzg.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.trim());
                case 11:
                    zzg.zzc("match", 1, list);
                    Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzhVar.zza(list.get(0)).zzf()).matcher(this.zza);
                    if (matcher.find()) {
                        return new zzaf(new zzas(matcher.group()));
                    }
                    return zzaq.zzd;
                case '\f':
                    zzg.zzc("slice", 2, list);
                    String str10 = this.zza;
                    double dZza = zzg.zza(!list.isEmpty() ? zzhVar.zza(list.get(0)).zze().doubleValue() : 0.0d);
                    if (dZza < 0.0d) {
                        dMin = Math.max(str10.length() + dZza, 0.0d);
                    } else {
                        dMin = Math.min(dZza, str10.length());
                    }
                    int i4 = (int) dMin;
                    double dZza2 = zzg.zza(list.size() > 1 ? zzhVar.zza(list.get(1)).zze().doubleValue() : str10.length());
                    if (dZza2 < 0.0d) {
                        dMin2 = Math.max(str10.length() + dZza2, 0.0d);
                    } else {
                        dMin2 = Math.min(dZza2, str10.length());
                    }
                    return new zzas(str10.substring(i4, Math.max(0, ((int) dMin2) - i4) + i4));
                case '\r':
                    zzg.zzc("split", 2, list);
                    String str11 = this.zza;
                    if (str11.length() == 0) {
                        return new zzaf(this);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        String strZzf4 = zzhVar.zza(list.get(0)).zzf();
                        long jZzc = list.size() > 1 ? zzg.zzc(zzhVar.zza(list.get(1)).zze().doubleValue()) : 2147483647L;
                        if (jZzc == 0) {
                            return new zzaf();
                        }
                        String[] strArrSplit = str11.split(Pattern.quote(strZzf4), ((int) jZzc) + 1);
                        int length2 = strArrSplit.length;
                        if (!strZzf4.isEmpty() || strArrSplit.length <= 0) {
                            i2 = 0;
                        } else {
                            boolean zIsEmpty = strArrSplit[0].isEmpty();
                            i2 = zIsEmpty;
                            if (strArrSplit[strArrSplit.length - 1].isEmpty()) {
                                length2 = strArrSplit.length - 1;
                                i2 = zIsEmpty;
                            }
                        }
                        if (strArrSplit.length > jZzc) {
                            length2--;
                        }
                        while (i2 < length2) {
                            arrayList.add(new zzas(strArrSplit[i2]));
                            i2++;
                        }
                    }
                    return new zzaf(arrayList);
                case 14:
                    zzg.zzc("substring", 2, list);
                    String str12 = this.zza;
                    int iZza2 = !list.isEmpty() ? (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue()) : 0;
                    if (list.size() > 1) {
                        length = (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                    } else {
                        length = str12.length();
                    }
                    int iMin = Math.min(Math.max(iZza2, 0), str12.length());
                    int iMin2 = Math.min(Math.max(length, 0), str12.length());
                    return new zzas(str12.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                case 15:
                    zzasVar = this;
                    zzg.zzc("replace", 2, list);
                    String strZzf5 = zzaq.zzc.zzf();
                    zzaq zzaqVarZza2 = zzaq.zzc;
                    if (!list.isEmpty()) {
                        strZzf5 = zzhVar.zza(list.get(0)).zzf();
                        if (list.size() > 1) {
                            zzaqVarZza2 = zzhVar.zza(list.get(1));
                        }
                    }
                    String str13 = zzasVar.zza;
                    int iIndexOf = str13.indexOf(strZzf5);
                    if (iIndexOf >= 0) {
                        if (zzaqVarZza2 instanceof zzal) {
                            zzaqVarZza2 = ((zzal) zzaqVarZza2).zza(zzhVar, Arrays.asList(new zzas(strZzf5), new zzai(Double.valueOf(iIndexOf)), zzasVar));
                        }
                        return new zzas(str13.substring(0, iIndexOf) + zzaqVarZza2.zzf() + str13.substring(iIndexOf + strZzf5.length()));
                    }
                    return zzasVar;
                case 16:
                    zzg.zzc("indexOf", 2, list);
                    String str14 = this.zza;
                    if (list.size() <= 0) {
                        strZzf3 = zzaq.zzc.zzf();
                        zzhVar2 = zzhVar;
                    } else {
                        zzhVar2 = zzhVar;
                        strZzf3 = zzhVar2.zza(list.get(0)).zzf();
                    }
                    return new zzai(Double.valueOf(str14.indexOf(strZzf3, (int) zzg.zza(list.size() >= 2 ? zzhVar2.zza(list.get(1)).zze().doubleValue() : 0.0d))));
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        str3 = "hasOwnProperty";
        str.hashCode();
        c = 65535;
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        switch (c) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }
}
