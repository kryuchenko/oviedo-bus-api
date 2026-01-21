package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.room.util.CursorUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzoj;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzin;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes3.dex */
final class zzal extends zzmx {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzar zzl;
    private final zzmr zzm;

    public final int zza(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfw.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzmx
    protected final boolean zzc() {
        return false;
    }

    public final long zza(String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        try {
            return e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbf.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfw.zza(str), e);
            return 0L;
        }
    }

    public final long b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zza(zzfn.zzk zzkVar) throws IllegalStateException, IOException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        byte[] bArrZzbz = zzkVar.zzbz();
        long jZza = g_().zza(bArrZzbz);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzz());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbz);
        try {
            e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfw.zza(zzkVar.zzz()), e);
            throw e;
        }
    }

    protected final long zzb(String str, String str2) {
        long jZza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        long j = 0;
        try {
            try {
                jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jZza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseE_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzfw.zza(str), str2);
                        sQLiteDatabaseE_.endTransaction();
                        return -1L;
                    }
                    jZza = 0;
                }
            } catch (SQLiteException e) {
                e = e;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + jZza));
                if (sQLiteDatabaseE_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzfw.zza(str), str2);
                    sQLiteDatabaseE_.endTransaction();
                    return -1L;
                }
                sQLiteDatabaseE_.setTransactionSuccessful();
                sQLiteDatabaseE_.endTransaction();
                return jZza;
            } catch (SQLiteException e2) {
                e = e2;
                j = jZza;
                zzj().zzg().zza("Error inserting column. appId", zzfw.zza(str), str2, e);
                sQLiteDatabaseE_.endTransaction();
                return j;
            }
        } catch (Throwable th) {
            sQLiteDatabaseE_.endTransaction();
            throw th;
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0088: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:33:0x0088 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzd(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzt();
        zzal();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("Default event parameters not found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    try {
                        zzfn.zzf zzfVar = (zzfn.zzf) ((com.google.android.gms.internal.measurement.zzjk) ((zzfn.zzf.zza) zznl.zza(zzfn.zzf.zze(), cursorRawQuery.getBlob(0))).zzai());
                        g_();
                        Bundle bundleZza = zznl.zza(zzfVar.zzh());
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return bundleZza;
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to retrieve default event parameters. appId", zzfw.zza(str), e);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:33:0x008e */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<zzfn.zzf, Long> zza(String str, Long l) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzt();
        zzal();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("Main event not found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    try {
                        Pair<zzfn.zzf, Long> pairCreate = Pair.create((zzfn.zzf) ((com.google.android.gms.internal.measurement.zzjk) ((zzfn.zzf.zza) zznl.zza(zzfn.zzf.zze(), cursorRawQuery.getBlob(0))).zzai()), Long.valueOf(cursorRawQuery.getLong(1)));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return pairCreate;
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge main event. appId, eventId", zzfw.zza(str), l, e);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzj().zzg().zza("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0399: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:131:0x0399 */
    /* JADX WARN: Removed duplicated region for block: B:133:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzg zze(String str) {
        Cursor cursorQuery;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    zzg zzgVar = new zzg(this.zzf.zzk(), str);
                    if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv) || this.zzf.zzb(str).zza(zzin.zza.ANALYTICS_STORAGE)) {
                        zzgVar.zzb(cursorQuery.getString(0));
                    }
                    zzgVar.zzf(cursorQuery.getString(1));
                    if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv) || this.zzf.zzb(str).zza(zzin.zza.AD_STORAGE)) {
                        zzgVar.zzh(cursorQuery.getString(2));
                    }
                    zzgVar.zzq(cursorQuery.getLong(3));
                    zzgVar.zzr(cursorQuery.getLong(4));
                    zzgVar.zzp(cursorQuery.getLong(5));
                    zzgVar.zzd(cursorQuery.getString(6));
                    zzgVar.zzc(cursorQuery.getString(7));
                    zzgVar.zzn(cursorQuery.getLong(8));
                    zzgVar.zzk(cursorQuery.getLong(9));
                    zzgVar.zzb(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    zzgVar.zzj(cursorQuery.getLong(11));
                    zzgVar.zzh(cursorQuery.getLong(12));
                    zzgVar.zzg(cursorQuery.getLong(13));
                    zzgVar.zze(cursorQuery.getLong(14));
                    zzgVar.zzd(cursorQuery.getLong(15));
                    zzgVar.zzm(cursorQuery.getLong(16));
                    zzgVar.zzb(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    zzgVar.zze(cursorQuery.getString(18));
                    zzgVar.zzf(cursorQuery.getLong(19));
                    zzgVar.zzi(cursorQuery.getLong(20));
                    zzgVar.zzg(cursorQuery.getString(21));
                    zzgVar.zza(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    zzgVar.zza(cursorQuery.getString(24));
                    zzgVar.zzl(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        zzgVar.zza(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv) || this.zzf.zzb(str).zza(zzin.zza.ANALYTICS_STORAGE)) {
                        zzgVar.zzj(cursorQuery.getString(28));
                    }
                    if (zzpn.zza() && zze().zza(zzbf.zzbs)) {
                        zzq();
                        if (zznp.zzf(str)) {
                            zzgVar.zzc((cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true);
                            zzgVar.zzo(cursorQuery.getLong(39));
                            if (zze().zza(zzbf.zzbt)) {
                                zzgVar.zzk(cursorQuery.getString(36));
                            }
                        }
                    }
                    zzgVar.zzt(cursorQuery.getLong(30));
                    zzgVar.zzs(cursorQuery.getLong(31));
                    if (zzpg.zza() && zze().zze(str, zzbf.zzbz)) {
                        zzgVar.zza(cursorQuery.getInt(32));
                        zzgVar.zzc(cursorQuery.getLong(35));
                    }
                    if (com.google.android.gms.internal.measurement.zznl.zza() && zze().zze(str, zzbf.zzck)) {
                        zzgVar.zzd((cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true);
                    }
                    if (cursorQuery.isNull(34)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getInt(34) != 0);
                    }
                    zzgVar.zza(boolValueOf);
                    zzgVar.zzc(cursorQuery.getInt(37));
                    zzgVar.zzb(cursorQuery.getInt(38));
                    if (com.google.android.gms.internal.measurement.zzne.zza() && zze().zze(str, zzbf.zzcp)) {
                        String string = cursorQuery.getString(40);
                        if (string == null) {
                            string = "";
                        }
                        zzgVar.zzi(string);
                    }
                    if (zze().zza(zzbf.zzcs)) {
                        if (!cursorQuery.isNull(41)) {
                            zzgVar.zza(Long.valueOf(cursorQuery.getLong(41)));
                        }
                        if (!cursorQuery.isNull(42)) {
                            zzgVar.zzb(Long.valueOf(cursorQuery.getLong(42)));
                        }
                    }
                    if (zzoj.zza() && zze().zze(str, zzbf.zzcm)) {
                        zzgVar.zza(cursorQuery.getBlob(43));
                    }
                    zzgVar.zzao();
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for app, expected one. appId", zzfw.zza(str));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzgVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying app. appId", zzfw.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0117: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:38:0x0117 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzae zzc(String str, String str2) throws Throwable {
        String str3;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str4 = string;
                    Object objZza = zza(cursorQuery, 1);
                    boolean z = cursorQuery.getInt(2) != 0;
                    String string2 = cursorQuery.getString(3);
                    long j = cursorQuery.getLong(4);
                    str3 = str2;
                    try {
                        zzae zzaeVar = new zzae(str, str4, new zzno(str3, cursorQuery.getLong(8), objZza, str4), cursorQuery.getLong(6), z, string2, (zzbd) g_().zza(cursorQuery.getBlob(5), zzbd.CREATOR), j, (zzbd) g_().zza(cursorQuery.getBlob(7), zzbd.CREATOR), cursorQuery.getLong(9), (zzbd) g_().zza(cursorQuery.getBlob(10), zzbd.CREATOR));
                        if (cursorQuery.moveToNext()) {
                            zzj().zzg().zza("Got multiple records for conditional property, expected one", zzfw.zza(str), zzi().zzc(str3));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzaeVar;
                    } catch (SQLiteException e) {
                        e = e;
                        zzj().zzg().zza("Error querying conditional property", zzfw.zza(str), zzi().zzc(str3), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str2;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str3 = str2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x008c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzan zzf(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = e_().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery.getString(2);
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for app config, expected one. appId", zzfw.zza(str));
                    }
                    if (blob == null) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    zzan zzanVar = new zzan(blob, string, string2);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzanVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying remote config. appId", zzfw.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 == null) {
                    cursor2.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 == null) {
            }
        }
    }

    public final zzaq zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6);
    }

    public final zzaq zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        String[] strArr = {str};
        zzaq zzaqVar = new zzaq();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseE_ = e_();
                Cursor cursorQuery = sQLiteDatabaseE_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzfw.zza(str));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return zzaqVar;
                    }
                } else {
                    if (cursorQuery.getLong(0) == j) {
                        zzaqVar.zzb = cursorQuery.getLong(1);
                        zzaqVar.zza = cursorQuery.getLong(2);
                        zzaqVar.zzc = cursorQuery.getLong(3);
                        zzaqVar.zzd = cursorQuery.getLong(4);
                        zzaqVar.zze = cursorQuery.getLong(5);
                        zzaqVar.zzf = cursorQuery.getLong(6);
                    }
                    if (z) {
                        zzaqVar.zzb += j2;
                    }
                    if (z2) {
                        zzaqVar.zza += j2;
                    }
                    if (z3) {
                        zzaqVar.zzc += j2;
                    }
                    if (z4) {
                        zzaqVar.zzd += j2;
                    }
                    if (z5) {
                        zzaqVar.zze += j2;
                    }
                    if (z6) {
                        zzaqVar.zzf += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzaqVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzaqVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzaqVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzaqVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzaqVar.zze));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaqVar.zzf));
                    sQLiteDatabaseE_.update("apps", contentValues, "app_id=?", strArr);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return zzaqVar;
                    }
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error updating daily counts. appId", zzfw.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
            }
            return zzaqVar;
        } finally {
        }
    }

    public final zzav zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzav.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzaz zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzaz zzc(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzt();
        zzal();
        CursorUtil.AnonymousClass2 anonymousClass2 = 0;
        try {
            try {
                cursorQuery = e_().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    long j2 = cursorQuery.getLong(1);
                    long j3 = cursorQuery.getLong(2);
                    long j4 = 0;
                    long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    if (!cursorQuery.isNull(8)) {
                        j4 = cursorQuery.getLong(8);
                    }
                    zzaz zzazVar = new zzaz(str2, str3, j, j2, j4, j3, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for event aggregates, expected one. appId", zzfw.zza(str2));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzazVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying events. appId", zzfw.zza(str2), zzi().zza(str3), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                anonymousClass2 = "current_bundle_count";
                if (anonymousClass2 != 0) {
                    anonymousClass2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (anonymousClass2 != 0) {
            }
            throw th;
        }
    }

    public final zzin zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzin.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzin zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        zzin zzinVar = (zzin) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzas() { // from class: com.google.android.gms.measurement.internal.zzao
            @Override // com.google.android.gms.measurement.internal.zzas
            public final Object zza(Cursor cursor) {
                return zzin.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zzinVar == null ? zzin.zza : zzinVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zznq zze(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        Cursor cursor = null;
        try {
            cursorQuery = e_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    long j = cursorQuery.getLong(0);
                    Object objZza = zza(cursorQuery, 1);
                    if (objZza == null) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    str3 = str;
                    str4 = str2;
                    try {
                        zznq zznqVar = new zznq(str3, cursorQuery.getString(2), str4, j, objZza);
                        if (cursorQuery.moveToNext()) {
                            zzj().zzg().zza("Got multiple records for user property, expected one. appId", zzfw.zza(str3));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zznqVar;
                    } catch (SQLiteException e) {
                        e = e;
                        sQLiteException = e;
                        zzj().zzg().zza("Error querying user property. appId", zzfw.zza(str3), zzi().zzc(str4), sQLiteException);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor == null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            str3 = str;
            str4 = str2;
            sQLiteException = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor == null) {
            }
        }
    }

    private final Object zza(Cursor cursor, int i) throws IllegalStateException {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T> T zza(String str, String[] strArr, zzas<T> zzasVar) throws Throwable {
        Cursor cursorRawQuery;
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("No data found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    T tZza = zzasVar.zza(cursorRawQuery);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return tZza;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error querying database.", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = str;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zza(long j) throws Throwable {
        Cursor cursorRawQuery;
        zzt();
        zzal();
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().zzp().zza("No expired configs for apps with pending events");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = j;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String f_() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = e_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    zzj().zzg().zza("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
            if (cursorRawQuery != null) {
            }
            throw th;
        }
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getString(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public final List<Pair<zzfn.zzk, Long>> zza(String str, int i, int i2) {
        byte[] bArrZzc;
        long jZzc;
        long jZzc2;
        zzt();
        zzal();
        int i3 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("queue", new String[]{"rowid", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzfn.zzk, Long>> list = Collections.EMPTY_LIST;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return list;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzc = g_().zzc(cursorQuery.getBlob(i3));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzfw.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzc.length + length > i2) {
                        break;
                    }
                    try {
                        zzfn.zzk.zza zzaVar = (zzfn.zzk.zza) zznl.zza(zzfn.zzk.zzw(), bArrZzc);
                        if (!arrayList.isEmpty()) {
                            zzfn.zzk zzkVar = (zzfn.zzk) ((Pair) arrayList.get(0)).first;
                            zzfn.zzk zzkVar2 = (zzfn.zzk) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzai());
                            if (!zzkVar.zzae().equals(zzkVar2.zzae()) || !zzkVar.zzad().equals(zzkVar2.zzad()) || zzkVar.zzau() != zzkVar2.zzau() || !zzkVar.zzaf().equals(zzkVar2.zzaf())) {
                                break;
                            }
                            Iterator<zzfn.zzo> it = zzkVar.zzas().iterator();
                            while (true) {
                                jZzc = -1;
                                if (!it.hasNext()) {
                                    jZzc2 = -1;
                                    break;
                                }
                                zzfn.zzo next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    jZzc2 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzfn.zzo> it2 = zzkVar2.zzas().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzfn.zzo next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    jZzc = next2.zzc();
                                    break;
                                }
                            }
                            if (jZzc2 != jZzc) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzc.length;
                        arrayList.add(Pair.create((zzfn.zzk) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzai()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzfw.zza(str), e2);
                    }
                    if (!cursorQuery.moveToNext() || length > i2) {
                        break;
                    }
                    i3 = 1;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzj().zzg().zza("Error querying bundles. appId", zzfw.zza(str), e3);
                List<Pair<zzfn.zzk, Long>> list2 = Collections.EMPTY_LIST;
                if (0 != 0) {
                    cursor.close();
                }
                return list2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0052, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0063, code lost:
    
        r22 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzae> zza(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", "1001");
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            if (arrayList.size() >= 1000) {
                                break;
                            }
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            Object objZza = zza(cursorQuery, 3);
                            boolean z = cursorQuery.getInt(4) != 0;
                            String string4 = cursorQuery.getString(5);
                            long j = cursorQuery.getLong(6);
                            zzbd zzbdVar = (zzbd) g_().zza(cursorQuery.getBlob(7), zzbd.CREATOR);
                            long j2 = cursorQuery.getLong(8);
                            zzbd zzbdVar2 = (zzbd) g_().zza(cursorQuery.getBlob(9), zzbd.CREATOR);
                            long j3 = cursorQuery.getLong(10);
                            cursor = cursorQuery;
                            try {
                                arrayList.add(new zzae(string, string2, new zzno(string3, j3, objZza, string2), j2, z, string4, zzbdVar, j, zzbdVar2, cursorQuery.getLong(11), (zzbd) g_().zza(cursorQuery.getBlob(12), zzbd.CREATOR)));
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                cursorQuery = cursor;
                            } catch (SQLiteException e) {
                                e = e;
                                cursorQuery = cursor;
                                zzj().zzg().zza("Error querying conditional user property value", e);
                                List<zzae> list = Collections.EMPTY_LIST;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return list;
                            } catch (Throwable th) {
                                th = th;
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw th;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    return arrayList;
                } catch (SQLiteException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final List<zzmu> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzmu(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else if (cursorQuery != null) {
                    cursorQuery.close();
                    return arrayList;
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzfw.zza(str), e);
                List<zzmu> list = Collections.EMPTY_LIST;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return list;
            }
        } finally {
        }
    }

    public final List<zznq> zzk(String str) {
        String str2;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str3 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objZza = zza(cursorQuery, 3);
                        if (objZza == null) {
                            zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzfw.zza(str));
                            str2 = str;
                        } else {
                            str2 = str;
                            try {
                                arrayList.add(new zznq(str2, str3, string, j, objZza));
                            } catch (SQLiteException e) {
                                e = e;
                                zzj().zzg().zza("Error querying user properties. appId", zzfw.zza(str2), e);
                                List<zznq> list = Collections.EMPTY_LIST;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return list;
                            }
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        str = str2;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } else if (cursorQuery != null) {
                    cursorQuery.close();
                    return arrayList;
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                str2 = str;
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zznq> zzb(String str, String str2, String str3) throws Throwable {
        zzal zzalVar;
        String string;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    ArrayList arrayList2 = new ArrayList(3);
                    String str4 = str;
                    arrayList2.add(str4);
                    StringBuilder sb = new StringBuilder("app_id=?");
                    if (TextUtils.isEmpty(str2)) {
                        string = str2;
                    } else {
                        string = str2;
                        try {
                            arrayList2.add(string);
                            sb.append(" and origin=?");
                        } catch (SQLiteException e) {
                            e = e;
                            zzalVar = this;
                            zzalVar.zzj().zzg().zza("(2)Error querying user properties", zzfw.zza(str), string, e);
                            List<zznq> list = Collections.EMPTY_LIST;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return list;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb.append(" and name glob ?");
                    }
                    cursorQuery = e_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            if (arrayList.size() >= 1000) {
                                break;
                            }
                            String string2 = cursorQuery.getString(0);
                            long j = cursorQuery.getLong(1);
                            zzalVar = this;
                            try {
                                Object objZza = zzalVar.zza(cursorQuery, 2);
                                string = cursorQuery.getString(3);
                                if (objZza == null) {
                                    zzalVar.zzj().zzg().zza("(2)Read invalid user property value, ignoring it", zzfw.zza(str4), string, str3);
                                } else {
                                    arrayList.add(new zznq(str4, string, string2, j, objZza));
                                }
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                str4 = str;
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzalVar.zzj().zzg().zza("(2)Error querying user properties", zzfw.zza(str), string, e);
                                List<zznq> list2 = Collections.EMPTY_LIST;
                                if (cursorQuery != null) {
                                }
                                return list2;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    return arrayList;
                } catch (SQLiteException e3) {
                    e = e3;
                    zzalVar = this;
                    string = str2;
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    final Map<Integer, zzfn.zzm> zzl(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, zzfn.zzm> map = Collections.EMPTY_MAP;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzfn.zzm) ((com.google.android.gms.internal.measurement.zzjk) ((zzfn.zzm.zza) zznl.zza(zzfn.zzm.zze(), cursorQuery.getBlob(1))).zzai()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfw.zza(str), Integer.valueOf(i), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzfw.zza(str), e2);
                Map<Integer, zzfn.zzm> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } finally {
        }
    }

    final Map<Integer, List<zzff.zzb>> zzm(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> map = Collections.EMPTY_MAP;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznl.zza(zzff.zzb.zzc(), cursorQuery.getBlob(1))).zzai());
                        if (zzbVar.zzk()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
                Map<Integer, List<zzff.zzb>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } finally {
        }
    }

    final Map<Integer, List<zzff.zzb>> zzf(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> map = Collections.EMPTY_MAP;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznl.zza(zzff.zzb.zzc(), cursorQuery.getBlob(1))).zzai());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } finally {
            }
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
            Map<Integer, List<zzff.zzb>> map2 = Collections.EMPTY_MAP;
            if (0 != 0) {
                cursor.close();
            }
            return map2;
        }
    }

    final Map<Integer, List<zzff.zze>> zzg(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("property_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zze>> map = Collections.EMPTY_MAP;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                do {
                    try {
                        zzff.zze zzeVar = (zzff.zze) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zze.zza) zznl.zza(zzff.zze.zzc(), cursorQuery.getBlob(1))).zzai());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } finally {
            }
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
            Map<Integer, List<zzff.zze>> map2 = Collections.EMPTY_MAP;
            if (0 != 0) {
                cursor.close();
            }
            return map2;
        }
    }

    final Map<Integer, List<Integer>> zzn(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> map = Collections.EMPTY_MAP;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return map;
                }
                do {
                    int i = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzfw.zza(str), e);
                Map<Integer, List<Integer>> map2 = Collections.EMPTY_MAP;
                if (0 != 0) {
                    cursor.close();
                }
                return map2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    zzal(zznc zzncVar) {
        super(zzncVar);
        this.zzm = new zzmr(zzb());
        this.zzl = new zzar(this, zza(), "google_app_measurement.db");
    }

    public final void zzp() {
        zzal();
        e_().beginTransaction();
    }

    private final void zzi(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzfw.zza(str2), e);
        }
    }

    public final void zzo(String str) throws IllegalStateException {
        zzaz zzazVarZzd;
        zzi("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("events", (String[]) Collections.singletonList(AppMeasurementSdk.ConditionalUserProperty.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (zzazVarZzd = zzd(str, string)) != null) {
                        zza("events_snapshot", zzazVarZzd);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error creating snapshot. appId", zzfw.zza(str), e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } finally {
        }
    }

    public final void zzu() {
        zzal();
        e_().endTransaction();
    }

    final void zza(List<Long> list) throws IllegalStateException, SQLException {
        zzt();
        zzal();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzaa()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzv() {
        int iDelete;
        zzt();
        zzal();
        if (zzaa()) {
            long jZza = zzn().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbf.zzy.zza(null).longValue()) {
                zzn().zza.zza(jElapsedRealtime);
                zzt();
                zzal();
                if (!zzaa() || (iDelete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final void zzh(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfw.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzp(String str) throws Throwable {
        boolean z;
        zzaz zzazVarZzc;
        ArrayList arrayList = new ArrayList(Arrays.asList(AppMeasurementSdk.ConditionalUserProperty.NAME, "lifetime_count"));
        zzaz zzazVarZzd = zzd(str, "_f");
        zzaz zzazVarZzd2 = zzd(str, "_v");
        zzi("events", str);
        boolean z2 = false;
        Cursor cursorQuery = null;
        try {
            cursorQuery = e_().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (!cursorQuery.moveToFirst()) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (zzazVarZzd != null) {
                    zza("events", zzazVarZzd);
                } else if (zzazVarZzd2 != null) {
                    zza("events", zzazVarZzd2);
                }
                zzi("events_snapshot", str);
                return;
            }
            boolean z3 = false;
            z = false;
            do {
                try {
                    String string = cursorQuery.getString(0);
                    if (zze().zza(zzbf.zzcx)) {
                        if (cursorQuery.getLong(1) >= 1) {
                            if ("_f".equals(string)) {
                                z3 = true;
                            } else if ("_v".equals(string)) {
                                z = true;
                            }
                        }
                    } else if ("_f".equals(string)) {
                        z3 = true;
                    } else if ("_v".equals(string)) {
                        z = true;
                    }
                    if (string != null && (zzazVarZzc = zzc("events_snapshot", str, string)) != null) {
                        zza("events", zzazVarZzc);
                    }
                } catch (SQLiteException e) {
                    e = e;
                    z2 = z3;
                    try {
                        zzj().zzg().zza("Error querying snapshot. appId", zzfw.zza(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (!z2 && zzazVarZzd != null) {
                            zza("events", zzazVarZzd);
                        } else if (!z && zzazVarZzd2 != null) {
                            zza("events", zzazVarZzd2);
                        }
                        zzi("events_snapshot", str);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (z2 && zzazVarZzd != null) {
                            zza("events", zzazVarZzd);
                        } else if (!z && zzazVarZzd2 != null) {
                            zza("events", zzazVarZzd2);
                        }
                        zzi("events_snapshot", str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = z3;
                    if (cursorQuery != null) {
                    }
                    if (z2) {
                        if (!z) {
                            zza("events", zzazVarZzd2);
                        }
                    }
                    zzi("events_snapshot", str);
                    throw th;
                }
            } while (cursorQuery.moveToNext());
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (!z3 && zzazVarZzd != null) {
                zza("events", zzazVarZzd);
            } else if (!z && zzazVarZzd2 != null) {
                zza("events", zzazVarZzd2);
            }
            zzi("events_snapshot", str);
        } catch (SQLiteException e2) {
            e = e2;
            z = false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    final void zza(String str, List<zzff.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzff.zza.C0022zza c0022zzaZzcc = list.get(i).zzcc();
            if (c0022zzaZzcc.zza() != 0) {
                for (int i2 = 0; i2 < c0022zzaZzcc.zza(); i2++) {
                    zzff.zzb.zza zzaVarZzcc = c0022zzaZzcc.zza(i2).zzcc();
                    zzff.zzb.zza zzaVar = (zzff.zzb.zza) ((zzjk.zzb) zzaVarZzcc.clone());
                    String strZzb = zziq.zzb(zzaVarZzcc.zzb());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzcc.zza(); i3++) {
                        zzff.zzc zzcVarZza = zzaVarZzcc.zza(i3);
                        String strZza = zzip.zza(zzcVarZza.zze());
                        if (strZza != null) {
                            zzaVar.zza(i3, (zzff.zzc) ((com.google.android.gms.internal.measurement.zzjk) zzcVarZza.zzcc().zza(strZza).zzai()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c0022zzaZzcc = c0022zzaZzcc.zza(i2, zzaVar);
                        list.set(i, (zzff.zza) ((com.google.android.gms.internal.measurement.zzjk) c0022zzaZzcc.zzai()));
                    }
                }
            }
            if (c0022zzaZzcc.zzb() != 0) {
                for (int i4 = 0; i4 < c0022zzaZzcc.zzb(); i4++) {
                    zzff.zze zzeVarZzb = c0022zzaZzcc.zzb(i4);
                    String strZza2 = zzis.zza(zzeVarZzb.zze());
                    if (strZza2 != null) {
                        c0022zzaZzcc = c0022zzaZzcc.zza(i4, zzeVarZzb.zzcc().zza(strZza2));
                        list.set(i, (zzff.zza) ((com.google.android.gms.internal.measurement.zzjk) c0022zzaZzcc.zzai()));
                    }
                }
            }
        }
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        try {
            zzal();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseE_2 = e_();
            sQLiteDatabaseE_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseE_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzff.zza zzaVar2 : list) {
                zzal();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzfw.zza(str));
                } else {
                    int iZza = zzaVar2.zza();
                    Iterator<zzff.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator<zzff.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator<zzff.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, iZza, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzff.zze> it4 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, iZza, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzal();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseE_3 = e_();
                                        sQLiteDatabaseE_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseE_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzff.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseE_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseE_.endTransaction();
        }
    }

    public final void zzw() {
        zzal();
        e_().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzg zzgVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzgVar);
        zzt();
        zzal();
        String strZzac = zzgVar.zzac();
        Preconditions.checkNotNull(strZzac);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzac);
        if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv)) {
            contentValues.put("app_instance_id", zzgVar.zzad());
        } else if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzf.zzb(strZzac).zza(zzin.zza.ANALYTICS_STORAGE)) {
        }
        contentValues.put("gmp_app_id", zzgVar.zzah());
        if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv) || this.zzf.zzb(strZzac).zza(zzin.zza.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzgVar.zzaj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzs()));
        contentValues.put("app_version", zzgVar.zzaf());
        contentValues.put("app_store", zzgVar.zzae());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzar()));
        contentValues.put("day", Long.valueOf(zzgVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zze()));
        contentValues.put("firebase_instance_id", zzgVar.zzag());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzl()));
        contentValues.put("health_monitor_sample", zzgVar.zzai());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzd()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaq()));
        contentValues.put("admob_app_id", zzgVar.zzaa());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzo()));
        if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zza(zzbf.zzcv) || this.zzf.zzb(strZzac).zza(zzin.zza.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzgVar.zzal());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzgVar.zzat()));
        contentValues.put("target_os_version", Long.valueOf(zzgVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzgVar.zzv()));
        if (zzpg.zza() && zze().zze(strZzac, zzbf.zzbz)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzgVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzgVar.zzf()));
        }
        if (com.google.android.gms.internal.measurement.zznl.zza() && zze().zze(strZzac, zzbf.zzck)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzgVar.zzau()));
        }
        contentValues.put("npa_metadata_value", zzgVar.zzx());
        if (zzpn.zza() && zze().zze(strZzac, zzbf.zzbs)) {
            zzq();
            if (zznp.zzf(strZzac)) {
                contentValues.put("bundle_delivery_index", Long.valueOf(zzgVar.zzr()));
            }
        }
        if (zzpn.zza() && zze().zze(strZzac, zzbf.zzbt)) {
            contentValues.put("sgtm_preview_key", zzgVar.zzam());
        }
        contentValues.put("dma_consent_state", Integer.valueOf(zzgVar.zzc()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzgVar.zzb()));
        if (com.google.android.gms.internal.measurement.zzne.zza() && zze().zze(strZzac, zzbf.zzcp)) {
            contentValues.put("serialized_npa_metadata", zzgVar.zzak());
        }
        List<String> listZzan = zzgVar.zzan();
        if (listZzan != null) {
            if (listZzan.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", strZzac);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzan));
            }
        }
        if (zznw.zza() && zze().zza(zzbf.zzbp) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        if (zze().zza(zzbf.zzcs)) {
            contentValues.put("unmatched_pfo", zzgVar.zzy());
            contentValues.put("unmatched_uwa", zzgVar.zzz());
        }
        if (zzoj.zza() && zze().zze(strZzac, zzbf.zzcm)) {
            contentValues.put("ad_campaign_info", zzgVar.zzav());
        }
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (sQLiteDatabaseE_.update("apps", contentValues, "app_id = ?", new String[]{strZzac}) == 0 && sQLiteDatabaseE_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzfw.zza(strZzac));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzfw.zza(strZzac), e);
        }
    }

    public final void zza(String str, zzav zzavVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzavVar);
        zzt();
        zzal();
        if (zze().zza(zzbf.zzcj) && zzi(str) == zzin.zza) {
            zzb(str, zzin.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzavVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzaz zzazVar) throws IllegalStateException {
        zza("events", zzazVar);
    }

    private final void zza(String str, zzaz zzazVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzazVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzazVar.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzazVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzazVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzazVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzazVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzazVar.zzg));
        contentValues.put("last_bundled_day", zzazVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzazVar.zzi);
        contentValues.put("last_sampling_rate", zzazVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzazVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzazVar.zzk == null || !zzazVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfw.zza(zzazVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfw.zza(zzazVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) throws IllegalStateException {
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfw.zza(str2));
                return;
            }
            if (sQLiteDatabaseE_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && sQLiteDatabaseE_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfw.zza(str), zzfw.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfw.zza(str), zzfw.zza(str2), e);
        }
    }

    public final void zza(String str, zzin zzinVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzal();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzinVar.zzh());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzin zzinVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzinVar.zzh());
        contentValues.put("consent_source", Integer.valueOf(zzinVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzal();
        zzt();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(com.google.firebase.perf.util.Constants.MAX_URL_LENGTH, zze().zzb(str, zzbf.zzaf)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb.append(str2);
            sb.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseE_.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzfn.zzk zzkVar, boolean z) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        Preconditions.checkState(zzkVar.zzbi());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzkVar.zzm() < jCurrentTimeMillis - zzag.zzm() || zzkVar.zzm() > zzag.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfw.zza(zzkVar.zzz()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzkVar.zzm()));
        }
        try {
            byte[] bArrZzb = g_().zzb(zzkVar.zzbz());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzz());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzm()));
            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkVar.zzbp()) {
                contentValues.put("retry_count", Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfw.zza(zzkVar.zzz()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfw.zza(zzkVar.zzz()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfw.zza(zzkVar.zzz()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zzb zzbVar) throws IllegalStateException {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbz = zzbVar.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzbz);
        try {
            if (e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfw.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zze zzeVar) throws IllegalStateException {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbz = zzeVar.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzbz);
        try {
            if (e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzba zzbaVar, long j, boolean z) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbaVar);
        Preconditions.checkNotEmpty(zzbaVar.zza);
        byte[] bArrZzbz = g_().zza(zzbaVar).zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbaVar.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbaVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbaVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzbz);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfw.zza(zzbaVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfw.zza(zzbaVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmu zzmuVar) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzmuVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzmuVar.zzb < jCurrentTimeMillis - zzag.zzm() || zzmuVar.zzb > zzag.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfw.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzmuVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmuVar.zza);
        contentValues.put("source", Integer.valueOf(zzmuVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmuVar.zzb));
        try {
            if (e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfw.zza(str), e);
            return false;
        }
    }

    protected final boolean zzaa() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzfn.zzf zzfVar) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzfVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbz = zzfVar.zzbz();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzae zzaeVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaeVar);
        zzt();
        zzal();
        String str = zzaeVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzaeVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaeVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaeVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzaeVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaeVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaeVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaeVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zznp.zza((Parcelable) zzaeVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaeVar.zzd));
        zzq();
        contentValues.put("triggered_event", zznp.zza((Parcelable) zzaeVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaeVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaeVar.zzj));
        zzq();
        contentValues.put("expired_event", zznp.zza((Parcelable) zzaeVar.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfw.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfw.zza(str), e);
            return true;
        }
    }

    final boolean zza(String str, Bundle bundle) {
        zzt();
        zzal();
        byte[] bArrZzbz = g_().zza(new zzba(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbz();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zznq zznqVar) {
        Preconditions.checkNotNull(zznqVar);
        zzt();
        zzal();
        if (zze(zznqVar.zza, zznqVar.zzc) == null) {
            if (zznp.zzh(zznqVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznqVar.zza}) >= zze().zza(zznqVar.zza, zzbf.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zznqVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznqVar.zza, zznqVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznqVar.zza);
        contentValues.put("origin", zznqVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zznqVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznqVar.zzd));
        zza(contentValues, "value", zznqVar.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfw.zza(zznqVar.zza));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfw.zza(zznqVar.zza), e);
            return true;
        }
    }
}
