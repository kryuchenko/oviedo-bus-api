package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzfp extends zze {
    private final zzfs zza;
    private boolean zzb;

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (cursorQuery.moveToFirst()) {
                long j = cursorQuery.getLong(0);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return j;
            }
            if (cursorQuery == null) {
                return -1L;
            }
            cursorQuery.close();
            return -1L;
        } finally {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final SQLiteDatabase zzad() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
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

    /* JADX WARN: Removed duplicated region for block: B:120:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AbstractSafeParcelable> zza(int i) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzad;
        Cursor cursorQuery;
        String str;
        String[] strArr;
        Parcel parcelObtain;
        zzno zznoVarCreateFromParcel;
        zzae zzaeVarCreateFromParcel;
        zzt();
        Cursor cursor = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (zzae()) {
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                try {
                    sQLiteDatabaseZzad = zzad();
                    if (sQLiteDatabaseZzad == null) {
                        this.zzb = true;
                        if (sQLiteDatabaseZzad != null) {
                            sQLiteDatabaseZzad.close();
                        }
                        return null;
                    }
                    try {
                        sQLiteDatabaseZzad.beginTransaction();
                        long jZza = zza(sQLiteDatabaseZzad);
                        long j = -1;
                        if (jZza != -1) {
                            strArr = new String[]{String.valueOf(jZza)};
                            str = "rowid<?";
                        } else {
                            str = null;
                            strArr = null;
                        }
                        cursorQuery = sQLiteDatabaseZzad.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                        while (cursorQuery.moveToNext()) {
                            try {
                                j = cursorQuery.getLong(0);
                                int i4 = cursorQuery.getInt(1);
                                byte[] blob = cursorQuery.getBlob(2);
                                if (i4 == 0) {
                                    parcelObtain = Parcel.obtain();
                                    try {
                                        try {
                                            parcelObtain.unmarshall(blob, 0, blob.length);
                                            parcelObtain.setDataPosition(0);
                                            zzbd zzbdVarCreateFromParcel = zzbd.CREATOR.createFromParcel(parcelObtain);
                                            if (zzbdVarCreateFromParcel != null) {
                                                arrayList.add(zzbdVarCreateFromParcel);
                                            }
                                        } catch (SafeParcelReader.ParseException unused) {
                                            zzj().zzg().zza("Failed to load event from local database");
                                            parcelObtain.recycle();
                                        }
                                    } finally {
                                    }
                                } else if (i4 == 1) {
                                    parcelObtain = Parcel.obtain();
                                    try {
                                        try {
                                            parcelObtain.unmarshall(blob, 0, blob.length);
                                            parcelObtain.setDataPosition(0);
                                            zznoVarCreateFromParcel = zzno.CREATOR.createFromParcel(parcelObtain);
                                        } catch (SafeParcelReader.ParseException unused2) {
                                            zzj().zzg().zza("Failed to load user property from local database");
                                            parcelObtain.recycle();
                                            zznoVarCreateFromParcel = null;
                                        }
                                        if (zznoVarCreateFromParcel != null) {
                                            arrayList.add(zznoVarCreateFromParcel);
                                        }
                                    } finally {
                                    }
                                } else if (i4 == 2) {
                                    parcelObtain = Parcel.obtain();
                                    try {
                                        try {
                                            parcelObtain.unmarshall(blob, 0, blob.length);
                                            parcelObtain.setDataPosition(0);
                                            zzaeVarCreateFromParcel = zzae.CREATOR.createFromParcel(parcelObtain);
                                        } catch (SafeParcelReader.ParseException unused3) {
                                            zzj().zzg().zza("Failed to load conditional user property from local database");
                                            parcelObtain.recycle();
                                            zzaeVarCreateFromParcel = null;
                                        }
                                        if (zzaeVarCreateFromParcel != null) {
                                            arrayList.add(zzaeVarCreateFromParcel);
                                        }
                                    } finally {
                                    }
                                } else if (i4 == 3) {
                                    zzj().zzu().zza("Skipping app launch break");
                                } else {
                                    zzj().zzg().zza("Unknown record type in local database");
                                }
                            } catch (SQLiteDatabaseLockedException unused4) {
                                SystemClock.sleep(i2);
                                i2 += 20;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabaseZzad != null) {
                                    sQLiteDatabaseZzad.close();
                                }
                            } catch (SQLiteFullException e) {
                                e = e;
                                zzj().zzg().zza("Error reading entries from local database", e);
                                this.zzb = true;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabaseZzad != null) {
                                    sQLiteDatabaseZzad.close();
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                if (sQLiteDatabaseZzad != null) {
                                    try {
                                        if (sQLiteDatabaseZzad.inTransaction()) {
                                            sQLiteDatabaseZzad.endTransaction();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursorQuery;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabaseZzad != null) {
                                            sQLiteDatabaseZzad.close();
                                        }
                                        throw th;
                                    }
                                }
                                zzj().zzg().zza("Error reading entries from local database", e);
                                this.zzb = true;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabaseZzad != null) {
                                    sQLiteDatabaseZzad.close();
                                }
                            }
                        }
                        if (sQLiteDatabaseZzad.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                            zzj().zzg().zza("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabaseZzad.setTransactionSuccessful();
                        sQLiteDatabaseZzad.endTransaction();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabaseZzad != null) {
                            sQLiteDatabaseZzad.close();
                        }
                    } catch (SQLiteDatabaseLockedException unused5) {
                        cursorQuery = null;
                    } catch (SQLiteFullException e3) {
                        e = e3;
                        cursorQuery = null;
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursorQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabaseZzad != null) {
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused6) {
                    sQLiteDatabaseZzad = null;
                    cursorQuery = null;
                } catch (SQLiteFullException e5) {
                    e = e5;
                    sQLiteDatabaseZzad = null;
                    cursorQuery = null;
                } catch (SQLiteException e6) {
                    e = e6;
                    sQLiteDatabaseZzad = null;
                    cursorQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabaseZzad = null;
                }
            }
            zzj().zzu().zza("Failed to read events from database in reasonable time");
            return null;
        }
        return arrayList;
    }

    zzfp(zzhj zzhjVar) {
        super(zzhjVar);
        this.zza = new zzfs(this, zza(), "google_app_measurement_local.db");
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

    public final void zzaa() {
        int iDelete;
        zzt();
        try {
            SQLiteDatabase sQLiteDatabaseZzad = zzad();
            if (sQLiteDatabaseZzad == null || (iDelete = sQLiteDatabaseZzad.delete("messages", null, null)) <= 0) {
                return;
            }
            zzj().zzp().zza("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzab() {
        return zza(3, new byte[0]);
    }

    private final boolean zzae() {
        return zza().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zzac() throws IllegalStateException {
        zzt();
        if (this.zzb || !zzae()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabaseZzad = zzad();
                if (sQLiteDatabaseZzad == null) {
                    this.zzb = true;
                    if (sQLiteDatabaseZzad != null) {
                        sQLiteDatabaseZzad.close();
                    }
                    return false;
                }
                sQLiteDatabaseZzad.beginTransaction();
                sQLiteDatabaseZzad.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabaseZzad.setTransactionSuccessful();
                sQLiteDatabaseZzad.endTransaction();
                if (sQLiteDatabaseZzad != null) {
                    sQLiteDatabaseZzad.close();
                }
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e) {
                zzj().zzg().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                zzj().zzg().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzj().zzu().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final boolean zza(zzae zzaeVar) throws IllegalStateException {
        zzq();
        byte[] bArrZza = zznp.zza((Parcelable) zzaeVar);
        if (bArrZza.length > 131072) {
            zzj().zzm().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zza(2, bArrZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0155  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zza(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzad;
        ?? RawQuery;
        boolean z;
        zzt();
        ?? r2 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            Cursor cursor = null;
            cursor = null;
            cursor = null;
            cursor = null;
            Cursor cursor2 = null;
            cursor = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseZzad = zzad();
                if (sQLiteDatabaseZzad == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabaseZzad != null) {
                            sQLiteDatabaseZzad.close();
                        }
                        return r2;
                    } catch (SQLiteFullException e) {
                        e = e;
                        try {
                            zzj().zzg().zza("Error writing entry; local database full", e);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabaseZzad == null) {
                            }
                            i2++;
                            r2 = 0;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        RawQuery = 0;
                        sQLiteDatabase = sQLiteDatabaseZzad;
                        RawQuery = RawQuery;
                        if (sQLiteDatabase != null) {
                        }
                        zzj().zzg().zza("Error writing entry to local database", e);
                        this.zzb = true;
                        if (RawQuery != 0) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        i2++;
                        r2 = 0;
                    }
                } else {
                    try {
                        try {
                            sQLiteDatabaseZzad.beginTransaction();
                            RawQuery = sQLiteDatabaseZzad.rawQuery("select count(1) from messages", null);
                            if (RawQuery != 0) {
                                try {
                                    try {
                                        try {
                                            long j = RawQuery.moveToFirst() ? RawQuery.getLong(r2) : 0L;
                                            if (j >= 100000) {
                                                try {
                                                    zzj().zzg().zza("Data loss, local db full");
                                                    long j2 = 100001 - j;
                                                    long jDelete = sQLiteDatabaseZzad.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                                                    if (jDelete != j2) {
                                                        try {
                                                            try {
                                                                z = true;
                                                            } catch (SQLiteDatabaseLockedException unused) {
                                                                cursor2 = RawQuery;
                                                                SystemClock.sleep(i3);
                                                                i3 += 20;
                                                                if (cursor2 != null) {
                                                                    cursor2.close();
                                                                }
                                                                if (sQLiteDatabaseZzad == null) {
                                                                    sQLiteDatabaseZzad.close();
                                                                }
                                                                i2++;
                                                                r2 = 0;
                                                            }
                                                            try {
                                                                zzj().zzg().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                                            } catch (SQLiteFullException e3) {
                                                                e = e3;
                                                                cursor = RawQuery;
                                                                zzj().zzg().zza("Error writing entry; local database full", e);
                                                                this.zzb = true;
                                                                if (cursor != null) {
                                                                }
                                                                if (sQLiteDatabaseZzad == null) {
                                                                }
                                                                i2++;
                                                                r2 = 0;
                                                            } catch (SQLiteException e4) {
                                                                e = e4;
                                                                sQLiteDatabase = sQLiteDatabaseZzad;
                                                                RawQuery = RawQuery;
                                                                if (sQLiteDatabase != null) {
                                                                }
                                                                zzj().zzg().zza("Error writing entry to local database", e);
                                                                this.zzb = true;
                                                                if (RawQuery != 0) {
                                                                }
                                                                if (sQLiteDatabase == null) {
                                                                }
                                                                i2++;
                                                                r2 = 0;
                                                            }
                                                        } catch (SQLiteFullException e5) {
                                                            e = e5;
                                                            cursor = RawQuery;
                                                            zzj().zzg().zza("Error writing entry; local database full", e);
                                                            this.zzb = true;
                                                            if (cursor != null) {
                                                            }
                                                            if (sQLiteDatabaseZzad == null) {
                                                            }
                                                            i2++;
                                                            r2 = 0;
                                                        } catch (SQLiteException e6) {
                                                            e = e6;
                                                            sQLiteDatabase = sQLiteDatabaseZzad;
                                                            RawQuery = RawQuery;
                                                            if (sQLiteDatabase != null) {
                                                            }
                                                            zzj().zzg().zza("Error writing entry to local database", e);
                                                            this.zzb = true;
                                                            if (RawQuery != 0) {
                                                            }
                                                            if (sQLiteDatabase == null) {
                                                            }
                                                            i2++;
                                                            r2 = 0;
                                                        }
                                                    } else {
                                                        z = true;
                                                    }
                                                } catch (SQLiteFullException e7) {
                                                    e = e7;
                                                } catch (SQLiteException e8) {
                                                    e = e8;
                                                }
                                            }
                                            sQLiteDatabaseZzad.insertOrThrow("messages", null, contentValues);
                                            sQLiteDatabaseZzad.setTransactionSuccessful();
                                            sQLiteDatabaseZzad.endTransaction();
                                            if (RawQuery != 0) {
                                                RawQuery.close();
                                            }
                                            if (sQLiteDatabaseZzad != null) {
                                                sQLiteDatabaseZzad.close();
                                            }
                                            return z;
                                        } catch (SQLiteDatabaseLockedException unused2) {
                                            cursor2 = RawQuery;
                                            SystemClock.sleep(i3);
                                            i3 += 20;
                                            if (cursor2 != null) {
                                            }
                                            if (sQLiteDatabaseZzad == null) {
                                            }
                                            i2++;
                                            r2 = 0;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = RawQuery;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabaseZzad != null) {
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteFullException e9) {
                                    e = e9;
                                    cursor = RawQuery;
                                    zzj().zzg().zza("Error writing entry; local database full", e);
                                    this.zzb = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabaseZzad == null) {
                                        sQLiteDatabaseZzad.close();
                                    }
                                    i2++;
                                    r2 = 0;
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    sQLiteDatabase = sQLiteDatabaseZzad;
                                    RawQuery = RawQuery;
                                    if (sQLiteDatabase != null) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            sQLiteDatabaseZzad = sQLiteDatabase;
                                            cursor = RawQuery;
                                            if (cursor != null) {
                                            }
                                            if (sQLiteDatabaseZzad != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    zzj().zzg().zza("Error writing entry to local database", e);
                                    this.zzb = true;
                                    if (RawQuery != 0) {
                                        RawQuery.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        sQLiteDatabase.close();
                                    }
                                    i2++;
                                    r2 = 0;
                                }
                            }
                        } catch (SQLiteDatabaseLockedException unused3) {
                        }
                    } catch (SQLiteFullException e11) {
                        e = e11;
                    } catch (SQLiteException e12) {
                        e = e12;
                        RawQuery = 0;
                    }
                }
            } catch (SQLiteDatabaseLockedException unused4) {
                sQLiteDatabaseZzad = null;
            } catch (SQLiteFullException e13) {
                e = e13;
                sQLiteDatabaseZzad = null;
            } catch (SQLiteException e14) {
                e = e14;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseZzad = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabaseZzad != null) {
                sQLiteDatabaseZzad.close();
            }
            throw th;
        }
        zzj().zzp().zza("Failed to write entry to local database");
        return false;
    }

    public final boolean zza(zzbd zzbdVar) throws IllegalStateException {
        Parcel parcelObtain = Parcel.obtain();
        zzbdVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzj().zzm().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zza(0, bArrMarshall);
    }

    public final boolean zza(zzno zznoVar) throws IllegalStateException {
        Parcel parcelObtain = Parcel.obtain();
        zznoVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzj().zzm().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zza(1, bArrMarshall);
    }
}
