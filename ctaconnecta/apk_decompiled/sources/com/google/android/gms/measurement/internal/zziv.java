package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzin;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zziv extends zze {
    final zzr zza;
    private zzki zzb;
    private zzir zzc;
    private final Set<zziu> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzat zzj;
    private PriorityQueue<zzmu> zzk;
    private zzin zzl;
    private final AtomicLong zzm;
    private long zzn;
    private boolean zzo;
    private zzat zzp;
    private SharedPreferences.OnSharedPreferenceChangeListener zzq;
    private zzat zzr;
    private final zznr zzs;

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final Application.ActivityLifecycleCallbacks zzaa() {
        return this.zzb;
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

    public final zzaj zzab() {
        zzt();
        return zzo().zzaa();
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

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzjf(this, atomicReference));
    }

    public final Double zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzkb(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzkc(this, atomicReference));
    }

    public final Long zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzjz(this, atomicReference));
    }

    public final String zzag() {
        return this.zzf.get();
    }

    public final String zzah() {
        zzkp zzkpVarZzaa = this.zzu.zzq().zzaa();
        if (zzkpVarZzaa != null) {
            return zzkpVarZzaa.zzb;
        }
        return null;
    }

    public final String zzai() {
        zzkp zzkpVarZzaa = this.zzu.zzq().zzaa();
        if (zzkpVarZzaa != null) {
            return zzkpVarZzaa.zza;
        }
        return null;
    }

    public final String zzaj() throws IllegalStateException {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhd(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzak() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzjs(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get conditional user properties", new zzjv(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zznp.zzb((List<zzae>) list);
    }

    public final List<zzno> zza(boolean z) throws IllegalStateException {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.EMPTY_LIST;
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.EMPTY_LIST;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get user properties", new zzjp(this, atomicReference, z));
        List<zzno> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.EMPTY_LIST;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get user properties", new zzjy(this, atomicReference, null, str, str2, z));
        List<zzno> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzno zznoVar : list) {
            Object objZza = zznoVar.zza();
            if (objZza != null) {
                arrayMap.put(zznoVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    final PriorityQueue<zzmu> zzal() {
        if (this.zzk == null) {
            Trace$$ExternalSyntheticApiModelOutline0.m409m$1();
            this.zzk = Trace$$ExternalSyntheticApiModelOutline0.m(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zziy
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzmu) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzix
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzk;
    }

    static /* synthetic */ void zza(zziv zzivVar, Bundle bundle) throws IllegalStateException {
        zzivVar.zzt();
        zzivVar.zzu();
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!zzivVar.zzu.zzac()) {
            zzivVar.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzivVar.zzo().zza(new zzae(bundle.getString("app_id"), "", new zzno(strCheckNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzivVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zziv zzivVar, zzin zzinVar, zzin zzinVar2) {
        if (com.google.android.gms.internal.measurement.zznk.zza() && zzivVar.zze().zza(zzbf.zzcu)) {
            return;
        }
        boolean zZza = zzinVar.zza(zzinVar2, zzin.zza.ANALYTICS_STORAGE, zzin.zza.AD_STORAGE);
        boolean zZzb = zzinVar.zzb(zzinVar2, zzin.zza.ANALYTICS_STORAGE, zzin.zza.AD_STORAGE);
        if (zZza || zZzb) {
            zzivVar.zzg().zzag();
        }
    }

    static /* synthetic */ void zzb(zziv zzivVar, Bundle bundle) throws IllegalStateException {
        zzivVar.zzt();
        zzivVar.zzu();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzivVar.zzu.zzac()) {
            zzivVar.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzno zznoVar = new zzno(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzbd zzbdVarZza = zzivVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true, true);
            zzivVar.zzo().zza(new zzae(bundle.getString("app_id"), string2, zznoVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzivVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true, true), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzbdVarZza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzivVar.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zziv zzivVar, zzin zzinVar, long j, boolean z, boolean z2) throws IllegalStateException {
        zzivVar.zzt();
        zzivVar.zzu();
        zzin zzinVarZzn = zzivVar.zzk().zzn();
        if (j <= zzivVar.zzn && zzin.zza(zzinVarZzn.zza(), zzinVar.zza())) {
            zzivVar.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zzinVar);
            return;
        }
        if (zzivVar.zzk().zza(zzinVar)) {
            zzivVar.zzj().zzp().zza("Setting storage consent(FE)", zzinVar);
            zzivVar.zzn = j;
            if (zzivVar.zzo().zzan()) {
                zzivVar.zzo().zzb(z);
            } else {
                zzivVar.zzo().zza(z);
            }
            if (z2) {
                zzivVar.zzo().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzivVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzinVar.zza()));
    }

    static /* synthetic */ void zzb(zziv zzivVar, int i) {
        if (zzivVar.zzj == null) {
            zzivVar.zzj = new zzjk(zzivVar, zzivVar.zzu);
        }
        zzivVar.zzj.zza(i * 1000);
    }

    protected zziv(zzhj zzhjVar) {
        super(zzhjVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzo = true;
        this.zzs = new zzka(this);
        this.zzf = new AtomicReference<>();
        this.zzl = zzin.zza;
        this.zzn = -1L;
        this.zzm = new AtomicLong(0L);
        this.zza = new zzr(zzhjVar);
    }

    public final void zzam() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean boolZze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (boolZze != null && boolZze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzje
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.zza.zzap();
                    }
                });
            }
            zzo().zzac();
            this.zzo = false;
            String strZzw = zzk().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzf().zzac();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
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

    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzjw(this, bundle2));
    }

    public final void zzan() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    final void zzao() throws IllegalStateException {
        if (zzpg.zza() && zze().zza(zzbf.zzca)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzab.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzja
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziz
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.zza.zza(list);
                    }
                });
            }
        }
    }

    public final void zzap() throws IllegalStateException {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().zzp.zza();
        zzk().zzp.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (this.zzp == null) {
                this.zzp = new zzjr(this, this.zzu);
            }
            this.zzp.zza(0L);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdg zzdgVar) throws IllegalStateException, RemoteException {
        zzl().zzb(new zzjx(this, zzdgVar));
    }

    public final void zzaq() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zzms zzmsVarZza = zzms.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zzmsVarZza);
        if (zzk().zza(zzmsVarZza)) {
            Bundle bundleZza = zzmsVarZza.zza();
            zzj().zzp().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                zza(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zzmsVarZza.zzb());
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
        }
    }

    final /* synthetic */ void zza(AtomicReference atomicReference) {
        Bundle bundleZza = zzk().zzi.zza();
        zzkx zzkxVarZzo = zzo();
        if (bundleZza == null) {
            bundleZza = new Bundle();
        }
        zzkxVarZzo.zza((AtomicReference<List<zzmu>>) atomicReference, bundleZza);
    }

    final /* synthetic */ void zza(List list) throws IllegalStateException {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayZzh = zzk().zzh();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzmu zzmuVar = (zzmu) it.next();
                if (!sparseArrayZzh.contains(zzmuVar.zzc) || sparseArrayZzh.get(zzmuVar.zzc).longValue() < zzmuVar.zzb) {
                    zzal().add(zzmuVar);
                }
            }
            zzar();
        }
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzat) Preconditions.checkNotNull(this.zzr)).zza(500L);
        }
    }

    final /* synthetic */ void zza(Bundle bundle, long j) throws IllegalStateException {
        if (TextUtils.isEmpty(zzg().zzae())) {
            zza(bundle, 0, j);
        } else {
            zzj().zzv().zza("Using developer consent only; google app id found");
        }
    }

    final /* synthetic */ void zza(Bundle bundle) throws IllegalStateException {
        if (bundle == null) {
            zzk().zzt.zza(new Bundle());
            return;
        }
        Bundle bundleZza = zzk().zzt.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                zzq();
                if (zznp.zza(obj)) {
                    zzq();
                    zznp.zza(this.zzs, 27, (String) null, (String) null, 0);
                }
                zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
            } else if (zznp.zzg(str)) {
                zzj().zzv().zza("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                zzq().zza(bundleZza, str, obj);
            }
        }
        zzq();
        if (zznp.zza(bundleZza, zze().zzg())) {
            zzq();
            zznp.zza(this.zzs, 26, (String) null, (String) null, 0);
            zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzk().zzt.zza(bundleZza);
        zzo().zza(bundleZza);
    }

    final /* synthetic */ void zzb(String str) {
        if (zzg().zzb(str)) {
            zzg().zzag();
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzn().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zznp.zzg(str2), z, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) throws IllegalStateException {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
        zza(str, str2, bundle, true, false, j);
    }

    final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zznp.zzg(str2), true, null);
    }

    protected final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        long j2;
        boolean zZza;
        String str4;
        boolean z4;
        long j3;
        int length;
        Class<?> cls;
        String str5 = str;
        Preconditions.checkNotEmpty(str5);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listZzaf = zzg().zzaf();
        if (listZzaf != null && !listZzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzag()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzn().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
        }
        zziv zzivVar = this;
        if (z && zznp.zzj(str2)) {
            zzivVar.zzq().zza(bundle, zzivVar.zzk().zzt.zza());
        }
        if (!z3 && !"_iap".equals(str2)) {
            zznp zznpVarZzt = zzivVar.zzu.zzt();
            int i = 2;
            if (zznpVarZzt.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!zznpVarZzt.zza(NotificationCompat.CATEGORY_EVENT, zziq.zza, zziq.zzb, str2)) {
                    i = 13;
                } else if (zznpVarZzt.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i = 0;
                }
            }
            if (i != 0) {
                zzivVar.zzj().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzivVar.zzi().zza(str2));
                zzivVar.zzu.zzt();
                String strZza = zznp.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                zzivVar.zzu.zzt();
                zznp.zza(zzivVar.zzs, i, "_ev", strZza, length);
                return;
            }
        }
        zzkp zzkpVarZza = zzivVar.zzn().zza(false);
        if (zzkpVarZza != null && !bundle.containsKey("_sc")) {
            zzkpVarZza.zzd = true;
        }
        zznp.zza(zzkpVarZza, bundle, z && !z3);
        boolean zEquals = "am".equals(str5);
        boolean zZzg = zznp.zzg(str2);
        if (z && zzivVar.zzc != null && !zZzg && !zEquals) {
            zzivVar.zzj().zzc().zza("Passing event to registered event handler (FE)", zzivVar.zzi().zza(str2), zzivVar.zzi().zza(bundle));
            Preconditions.checkNotNull(zzivVar.zzc);
            zzivVar.zzc.interceptEvent(str5, str2, bundle, j);
            return;
        }
        long j4 = j;
        if (zzivVar.zzu.zzaf()) {
            int iZza = zzivVar.zzq().zza(str2);
            if (iZza != 0) {
                zzivVar.zzj().zzh().zza("Invalid event name. Event will not be logged (FE)", zzivVar.zzi().zza(str2));
                zzivVar.zzq();
                String strZza2 = zznp.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                zzivVar.zzu.zzt();
                zznp.zza(zzivVar.zzs, str3, iZza, "_ev", strZza2, length);
                return;
            }
            Bundle bundleZza = zzivVar.zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(bundleZza);
            if (zzivVar.zzn().zza(false) == null || !"_ae".equals(str2)) {
                j2 = 0;
            } else {
                zzmn zzmnVar = zzivVar.zzp().zzb;
                j2 = 0;
                long jElapsedRealtime = zzmnVar.zzb.zzb().elapsedRealtime();
                long j5 = jElapsedRealtime - zzmnVar.zza;
                zzmnVar.zza = jElapsedRealtime;
                if (j5 > 0) {
                    zzivVar.zzq().zza(bundleZza, j5);
                }
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str5) && "_ssr".equals(str2)) {
                zznp zznpVarZzq = zzivVar.zzq();
                String string = bundleZza.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zznpVarZzq.zzk().zzq.zza())) {
                    zznpVarZzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zznpVarZzq.zzk().zzq.zza(string);
            } else if ("_ae".equals(str2)) {
                String strZza3 = zzivVar.zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(strZza3)) {
                    bundleZza.putString("_ffr", strZza3);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZza);
            if (zzivVar.zze().zza(zzbf.zzcg)) {
                zZza = zzivVar.zzp().zzaa();
            } else {
                zZza = zzivVar.zzk().zzn.zza();
            }
            if (zzivVar.zzk().zzk.zza() <= j2 || !zzivVar.zzk().zza(j4) || !zZza) {
                str4 = "_ae";
                z4 = zEquals;
                j3 = j2;
            } else {
                zzivVar.zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                z4 = zEquals;
                j3 = j2;
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzivVar.zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", (Object) null, zzb().currentTimeMillis());
                zzivVar = this;
                zzivVar.zzk().zzl.zza(j3);
            }
            if (bundleZza.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j3) == 1) {
                zzivVar.zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                zzivVar.zzu.zzs().zza.zza(j4, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleZza.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str6 = (String) obj;
                if (str6 != null) {
                    zzivVar.zzq();
                    Bundle[] bundleArrZzb = zznp.zzb(bundleZza.get(str6));
                    if (bundleArrZzb != null) {
                        bundleZza.putParcelableArray(str6, bundleArrZzb);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                Bundle bundleZza2 = (Bundle) arrayList.get(i3);
                String str7 = i3 != 0 ? "_ep" : str2;
                bundleZza2.putString("_o", str5);
                if (z2) {
                    bundleZza2 = zzivVar.zzq().zza(bundleZza2, (String) null);
                }
                String str8 = str5;
                Bundle bundle2 = bundleZza2;
                zzivVar.zzo().zza(new zzbd(str7, new zzbc(bundleZza2), str8, j4), str3);
                if (!z4) {
                    Iterator<zziu> it = zzivVar.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
                i3++;
                str5 = str;
                j4 = j;
            }
            if (zzivVar.zzn().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzivVar.zzp().zza(true, true, zzivVar.zzb().elapsedRealtime());
        }
    }

    final void zzar() throws IllegalStateException {
        zzmu zzmuVarPoll;
        MeasurementManagerFutures measurementManagerFuturesZzn;
        zzt();
        if (zzal().isEmpty() || this.zzh || (zzmuVarPoll = zzal().poll()) == null || (measurementManagerFuturesZzn = zzq().zzn()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", zzmuVarPoll.zza);
        ListenableFuture<Unit> listenableFutureRegisterTriggerAsync = measurementManagerFuturesZzn.registerTriggerAsync(Uri.parse(zzmuVarPoll.zza));
        if (listenableFutureRegisterTriggerAsync == null) {
            this.zzh = false;
            zzal().add(zzmuVarPoll);
            return;
        }
        if (!zze().zza(zzbf.zzcf)) {
            SparseArray<Long> sparseArrayZzh = zzk().zzh();
            sparseArrayZzh.put(zzmuVarPoll.zzc, Long.valueOf(zzmuVarPoll.zzb));
            zzk().zza(sparseArrayZzh);
        }
        Futures.addCallback(listenableFutureRegisterTriggerAsync, new zzjh(this, zzmuVarPoll), new zzji(this));
    }

    public final void zza(zziu zziuVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zziuVar);
        if (this.zzd.add(zziuVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    public final void zzas() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzq == null) {
            this.zzr = new zzjo(this, this.zzu);
            this.zzq = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzjd
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
                    this.zza.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzq);
    }

    public final void zza(long j) throws IllegalStateException {
        zzc((String) null);
        zzl().zzb(new zzju(this, j));
    }

    final void zzb(long j) throws IllegalStateException {
        zza(j, true);
    }

    final void zza(long j, boolean z) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzmh zzmhVarZzp = zzp();
        zzmhVarZzp.zzt();
        zzmhVarZzp.zzb.zza();
        zzg().zzag();
        boolean zZzac = this.zzu.zzac();
        zzgh zzghVarZzk = zzk();
        zzghVarZzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzghVarZzk.zzk().zzq.zza())) {
            zzghVarZzk.zzq.zza(null);
        }
        zzghVarZzk.zzk.zza(0L);
        zzghVarZzk.zzl.zza(0L);
        if (!zzghVarZzk.zze().zzw()) {
            zzghVarZzk.zzb(!zZzac);
        }
        zzghVarZzk.zzr.zza(null);
        zzghVarZzk.zzs.zza(0L);
        zzghVarZzk.zzt.zza(null);
        if (z) {
            zzo().zzah();
        }
        zzp().zza.zza();
        this.zzo = !zZzac;
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException {
        zzl().zzb(new zzjn(this, str, str2, j, zznp.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) throws IllegalStateException {
        zzl().zzb(new zzjq(this, str, str2, obj, j));
    }

    public final void zzb(boolean z) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzki(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzp().zza("Registered activity lifecycle callback");
            }
        }
    }

    final void zzc(String str) {
        this.zzf.set(str);
    }

    public final void zzb(Bundle bundle) throws IllegalStateException {
        zzb(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(Bundle bundle, long j) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzik.zza(bundle2, "app_id", String.class, null);
        zzik.zza(bundle2, "origin", String.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzik.zza(bundle2, "value", Object.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzik.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objZzc = zzq().zzc(string, obj);
        if (objZzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzik.zza(bundle2, objZzc);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
        } else {
            zzl().zzb(new zzjt(this, bundle2));
        }
    }

    public final void zzc(final Bundle bundle, final long j) throws IllegalStateException {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjb
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.zza.zza(bundle, j);
            }
        });
    }

    private final void zza(Bundle bundle, int i, long j) throws IllegalStateException {
        String str;
        zzu();
        String strZza = zzin.zza(bundle);
        if (strZza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", strZza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zZzg = zzl().zzg();
        zzin zzinVarZza = zzin.zza(bundle, i);
        if (zzinVarZza.zzk()) {
            zza(zzinVarZza, j, zZzg);
        }
        zzav zzavVarZza = zzav.zza(bundle, i);
        if (zzavVarZza.zzg()) {
            zza(zzavVarZza, zZzg);
        }
        Boolean boolZza = zzav.zza(bundle);
        if (boolZza != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            zza(str, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) boolZza.toString(), false);
        }
    }

    public final void zzd(Bundle bundle, long j) throws IllegalStateException {
        zza(bundle, -20, j);
    }

    public final void zzc(boolean z) throws IllegalStateException {
        zzu();
        zzl().zzb(new zzjj(this, z));
    }

    public final void zzc(Bundle bundle) throws IllegalStateException {
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjc
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.zza.zza(bundle2);
            }
        });
    }

    final void zza(zzav zzavVar, boolean z) {
        zzkd zzkdVar = new zzkd(this, zzavVar);
        if (z) {
            zzt();
            zzkdVar.run();
        } else {
            zzl().zzb(zzkdVar);
        }
    }

    public final void zza(zzir zzirVar) {
        zzir zzirVar2;
        zzt();
        zzu();
        if (zzirVar != null && zzirVar != (zzirVar2 = this.zzc)) {
            Preconditions.checkState(zzirVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzirVar;
    }

    public final void zza(Boolean bool) throws IllegalStateException {
        zzu();
        zzl().zzb(new zzke(this, bool));
    }

    final void zza(zzin zzinVar) {
        zzt();
        boolean z = (zzinVar.zzj() && zzinVar.zzi()) || zzo().zzam();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean boolZzu = zzk().zzu();
            if (!z || boolZzu == null || boolZzu.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzat();
        }
    }

    public final void zzc(long j) throws IllegalStateException {
        zzl().zzb(new zzjl(this, j));
    }

    public final void zza(Intent intent) throws IllegalStateException {
        if (zzpn.zza() && zze().zza(zzbf.zzbt)) {
            Uri data = intent.getData();
            if (data == null) {
                zzj().zzn().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                zzj().zzn().zza("Preview Mode was not enabled.");
                zze().zzh(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzj().zzn().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zze().zzh(queryParameter2);
        }
    }

    public final void zza(zzin zzinVar, long j, boolean z) {
        zzin zzinVar2;
        boolean z2;
        zzin zzinVarZzb;
        boolean zZzc;
        boolean z3;
        zzu();
        int iZza = zzinVar.zza();
        if (com.google.android.gms.internal.measurement.zzne.zza() && zze().zza(zzbf.zzcq)) {
            if (iZza != -10 && zzinVar.zzc() == zzim.UNINITIALIZED && zzinVar.zzd() == zzim.UNINITIALIZED) {
                zzj().zzv().zza("Ignoring empty consent settings");
                return;
            }
        } else if (iZza != -10 && zzinVar.zze() == null && zzinVar.zzf() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zzinVar2 = this.zzl;
            z2 = false;
            if (zzin.zza(iZza, zzinVar2.zza())) {
                zZzc = zzinVar.zzc(this.zzl);
                if (zzinVar.zzj() && !this.zzl.zzj()) {
                    z2 = true;
                }
                zzinVarZzb = zzinVar.zzb(this.zzl);
                this.zzl = zzinVarZzb;
                z3 = z2;
                z2 = true;
            } else {
                zzinVarZzb = zzinVar;
                zZzc = false;
                z3 = false;
            }
        }
        if (!z2) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zzinVarZzb);
            return;
        }
        long andIncrement = this.zzm.getAndIncrement();
        if (zZzc) {
            zzc((String) null);
            zzkg zzkgVar = new zzkg(this, zzinVarZzb, j, andIncrement, z3, zzinVar2);
            if (z) {
                zzt();
                zzkgVar.run();
                return;
            } else {
                zzl().zzc(zzkgVar);
                return;
            }
        }
        zzkf zzkfVar = new zzkf(this, zzinVarZzb, andIncrement, z3, zzinVar2);
        if (z) {
            zzt();
            zzkfVar.run();
        } else if (iZza == 30 || iZza == -10) {
            zzl().zzc(zzkfVar);
        } else {
            zzl().zzb(zzkfVar);
        }
    }

    public final void zza(final String str, long j) throws IllegalStateException {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(str);
                }
            });
            zza((String) null, "_id", (Object) str, true, j);
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(String str, String str2, Object obj, boolean z, long j) throws IllegalStateException {
        int iZzb;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            iZzb = zzq().zzb(str2);
        } else {
            zznp zznpVarZzq = zzq();
            if (zznpVarZzq.zzc("user property", str2)) {
                if (zznpVarZzq.zza("user property", zzis.zza, str2)) {
                    iZzb = !zznpVarZzq.zza("user property", 24, str2) ? 6 : 0;
                } else {
                    iZzb = 15;
                }
            }
        }
        if (iZzb != 0) {
            zzq();
            String strZza = zznp.zza(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.zzu.zzt();
            zznp.zza(this.zzs, iZzb, "_ev", strZza, length);
            return;
        }
        if (obj != null) {
            int iZza = zzq().zza(str2, obj);
            if (iZza != 0) {
                zzq();
                String strZza2 = zznp.zza(str2, 24, true);
                length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
                this.zzu.zzt();
                zznp.zza(this.zzs, iZza, "_ev", strZza2, length);
                return;
            }
            Object objZzc = zzq().zzc(str2, obj);
            if (objZzc != null) {
                zza(str3, str2, j, objZzc);
                return;
            }
            return;
        }
        zza(str3, str2, j, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zza(String str, String str2, Object obj, long j) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzu();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long lValueOf = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    zzk().zzh.zza(lValueOf.longValue() == 1 ? "true" : "false");
                    obj = lValueOf;
                } else {
                    if (obj == null) {
                        zzk().zzh.zza("unset");
                    }
                    zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
                str2 = "_npa";
                zzj().zzp().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
            }
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzac()) {
            zzj().zzp().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzaf()) {
            zzo().zza(new zzno(str4, j, obj2, str));
        }
    }

    public final void zzb(zziu zziuVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zziuVar);
        if (this.zzd.remove(zziuVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzat() throws IllegalStateException {
        zziv zzivVar;
        zzt();
        String strZza = zzk().zzh.zza();
        if (strZza == null) {
            zzivVar = this;
        } else if ("unset".equals(strZza)) {
            zzivVar = this;
            zzivVar.zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
        } else {
            zza("app", "_npa", Long.valueOf("true".equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            zzivVar = this;
        }
        if (zzivVar.zzu.zzac() && zzivVar.zzo) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzam();
            zzp().zza.zza();
            zzl().zzb(new zzjm(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzo().zzaj();
    }
}
