package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzps;
import com.google.android.gms.measurement.internal.zzin;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.maps.android.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzfq extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zze;
    private long zzf;
    private List<String> zzg;
    private String zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private long zzm;
    private String zzn;

    final int zzaa() {
        zzu();
        return this.zzi;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return true;
    }

    final int zzab() {
        zzu();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzo zza(String str) throws IllegalStateException {
        long jMin;
        String str2;
        String str3;
        int iZzc;
        String strZzb;
        zzt();
        String strZzad = zzad();
        String strZzae = zzae();
        zzu();
        String str4 = this.zzb;
        long jZzab = zzab();
        zzu();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzu();
        zzt();
        if (this.zze == 0) {
            this.zze = this.zzu.zzt().zza(zza(), zza().getPackageName());
        }
        long j = this.zze;
        boolean zZzac = this.zzu.zzac();
        boolean z = !zzk().zzm;
        zzt();
        String str6 = null;
        String strZzah = !this.zzu.zzac() ? null : zzah();
        long jZzh = 0;
        zzhj zzhjVar = this.zzu;
        String str7 = strZzah;
        long jZza = zzhjVar.zzn().zzc.zza();
        if (jZza == 0) {
            jMin = zzhjVar.zza;
        } else {
            jMin = Math.min(zzhjVar.zza, jZza);
        }
        int iZzaa = zzaa();
        boolean zZzu = zze().zzu();
        zzgh zzghVarZzk = zzk();
        zzghVarZzk.zzt();
        boolean z2 = zzghVarZzk.zzg().getBoolean("deferred_analytics_collection", false);
        String strZzac = zzac();
        Boolean boolValueOf = zze().zze("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r14.booleanValue());
        long j2 = this.zzf;
        List<String> list = this.zzg;
        String strZzh = zzk().zzn().zzh();
        if (this.zzh == null) {
            this.zzh = zzq().zzp();
        }
        String str8 = this.zzh;
        if (com.google.android.gms.internal.measurement.zznk.zza()) {
            str2 = str8;
            str3 = strZzh;
            if (!zze().zza(zzbf.zzcu) || zzk().zzn().zza(zzin.zza.ANALYTICS_STORAGE)) {
            }
            Boolean boolZze = zze().zze("google_analytics_sgtm_upload_enabled");
            boolean zBooleanValue = boolZze != null ? false : boolZze.booleanValue();
            long jZzc = zzq().zzc(zzad());
            int iZza = zzk().zzn().zza();
            String strZzf = zzk().zzm().zzf();
            if (zzpg.zza() || !zze().zza(zzbf.zzca)) {
                iZzc = 0;
            } else {
                zzq();
                iZzc = zznp.zzc();
            }
            if (zzpg.zza() && zze().zza(zzbf.zzca)) {
                jZzh = zzq().zzh();
            }
            long j3 = jZzh;
            String strZzp = zze().zzp();
            if (!com.google.android.gms.internal.measurement.zzne.zza() && zze().zza(zzbf.zzcq)) {
                strZzb = new zzgi(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
            } else {
                strZzb = "";
            }
            return new zzo(strZzad, strZzae, str4, jZzab, str5, 97001L, j, str, zZzac, z, str7, 0L, jMin, iZzaa, zZzu, z2, strZzac, boolValueOf, j2, list, (String) null, str3, str2, str6, zBooleanValue, jZzc, iZza, strZzf, iZzc, j3, strZzp, strZzb);
        }
        str2 = str8;
        str3 = strZzh;
        zzt();
        if (this.zzm != 0) {
            long jCurrentTimeMillis = zzb().currentTimeMillis() - this.zzm;
            if (this.zzl != null && jCurrentTimeMillis > 86400000 && this.zzn == null) {
                zzag();
            }
        }
        if (this.zzl == null) {
            zzag();
        }
        str6 = this.zzl;
        Boolean boolZze2 = zze().zze("google_analytics_sgtm_upload_enabled");
        if (boolZze2 != null) {
        }
        long jZzc2 = zzq().zzc(zzad());
        int iZza2 = zzk().zzn().zza();
        String strZzf2 = zzk().zzm().zzf();
        if (zzpg.zza()) {
            iZzc = 0;
        }
        if (zzpg.zza()) {
            jZzh = zzq().zzh();
        }
        long j32 = jZzh;
        String strZzp2 = zze().zzp();
        if (!com.google.android.gms.internal.measurement.zzne.zza()) {
            strZzb = "";
        }
        return new zzo(strZzad, strZzae, str4, jZzab, str5, 97001L, j, str, zZzac, z, str7, 0L, jMin, iZzaa, zZzu, z2, strZzac, boolValueOf, j2, list, (String) null, str3, str2, str6, zBooleanValue, jZzc2, iZza2, strZzf2, iZzc, j32, strZzp2, strZzb);
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzax zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfq zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfp zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzgh zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzhc zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zziv zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzks zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzmh zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zznp zzq() {
        return super.zzq();
    }

    final String zzac() {
        zzu();
        return this.zzk;
    }

    final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (zzps.zza() && zze().zza(zzbf.zzbm)) {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                } catch (Exception unused) {
                    zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    final List<String> zzaf() {
        return this.zzg;
    }

    zzfq(zzhj zzhjVar, long j) {
        super(zzhjVar);
        this.zzm = 0L;
        this.zzn = null;
        this.zzf = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0190 A[Catch: IllegalStateException -> 0x01c6, TryCatch #3 {IllegalStateException -> 0x01c6, blocks: (B:49:0x016b, B:53:0x0188, B:55:0x0190, B:57:0x01a9, B:59:0x01bd, B:61:0x01c2, B:60:0x01c0), top: B:88:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9 A[Catch: IllegalStateException -> 0x01c6, TryCatch #3 {IllegalStateException -> 0x01c6, blocks: (B:49:0x016b, B:53:0x0188, B:55:0x0190, B:57:0x01a9, B:59:0x01bd, B:61:0x01c2, B:60:0x01c0), top: B:88:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0227  */
    @Override // com.google.android.gms.measurement.internal.zze
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzx() throws IllegalStateException, Resources.NotFoundException, PackageManager.NameNotFoundException {
        String str;
        boolean z;
        int iZzc;
        boolean z2;
        List<String> listZzg;
        String strZza;
        String packageName = zza().getPackageName();
        PackageManager packageManager = zza().getPackageManager();
        String str2 = "";
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        String str3 = "Unknown";
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            zzj().zzg().zza("PackageManager is null, app identity information might be inaccurate. appId", zzfw.zza(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                zzj().zzg().zza("Error retrieving app installer package name. appId", zzfw.zza(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(zza().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    String string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        zzj().zzg().zza("Error retrieving package info. appId, appName", zzfw.zza(packageName), str3);
                        str3 = str;
                        this.zza = packageName;
                        this.zzd = installerPackageName;
                        this.zzb = str3;
                        this.zzc = i;
                        this.zze = 0L;
                        if (TextUtils.isEmpty(this.zzu.zzu())) {
                        }
                        iZzc = this.zzu.zzc();
                        switch (iZzc) {
                        }
                        if (iZzc == 0) {
                        }
                        this.zzj = "";
                        this.zzk = "";
                        if (z) {
                        }
                        strZza = new zzhd(zza(), this.zzu.zzx()).zza("google_app_id");
                        if (TextUtils.isEmpty(strZza)) {
                        }
                        this.zzj = str2;
                        if (!TextUtils.isEmpty(strZza)) {
                        }
                        if (z2) {
                        }
                        this.zzg = null;
                        listZzg = zze().zzg("analytics.safelisted_events");
                        if (listZzg != null) {
                        }
                        if (packageManager == null) {
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = "Unknown";
            }
        }
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = 0L;
        z = TextUtils.isEmpty(this.zzu.zzu()) && "am".equals(this.zzu.zzv());
        iZzc = this.zzu.zzc();
        switch (iZzc) {
            case 0:
                zzj().zzp().zza("App measurement collection enabled");
                break;
            case 1:
                zzj().zzn().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                zzj().zzp().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                zzj().zzn().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                zzj().zzn().zza("App measurement disabled via the manifest");
                break;
            case 5:
                zzj().zzp().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                zzj().zzv().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                zzj().zzn().zza("App measurement disabled via the global data collection setting");
                break;
            case 8:
                zzj().zzn().zza("App measurement disabled due to denied storage consent");
                break;
            default:
                zzj().zzn().zza("App measurement disabled");
                zzj().zzm().zza("Invalid scion state in identity");
                break;
        }
        z2 = iZzc == 0;
        this.zzj = "";
        this.zzk = "";
        if (z) {
            this.zzk = this.zzu.zzu();
        }
        try {
            strZza = new zzhd(zza(), this.zzu.zzx()).zza("google_app_id");
            if (TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzj = str2;
            if (!TextUtils.isEmpty(strZza)) {
                this.zzk = new zzhd(zza(), this.zzu.zzx()).zza("admob_app_id");
            }
            if (z2) {
                zzj().zzp().zza("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzj) ? this.zzk : this.zzj);
            }
        } catch (IllegalStateException e) {
            zzj().zzg().zza("Fetching Google App Id failed with exception. appId", zzfw.zza(packageName), e);
        }
        this.zzg = null;
        listZzg = zze().zzg("analytics.safelisted_events");
        if (listZzg != null) {
            if (listZzg.isEmpty()) {
                zzj().zzv().zza("Safelisted event list is empty. Ignoring");
            } else {
                Iterator<String> it = listZzg.iterator();
                while (it.hasNext()) {
                    if (!zzq().zzb("safelisted event", it.next())) {
                    }
                }
                this.zzg = listZzg;
            }
        } else {
            this.zzg = listZzg;
        }
        if (packageManager == null) {
            this.zzi = InstantApps.isInstantApp(zza()) ? 1 : 0;
        } else {
            this.zzi = 0;
        }
    }

    final void zzag() {
        String str;
        zzt();
        if (!zzk().zzn().zza(zzin.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? BuildConfig.TRAVIS : "not null"));
        this.zzl = str;
        this.zzm = zzb().currentTimeMillis();
    }

    final boolean zzb(String str) {
        String str2 = this.zzn;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzn = str;
        return z;
    }
}
