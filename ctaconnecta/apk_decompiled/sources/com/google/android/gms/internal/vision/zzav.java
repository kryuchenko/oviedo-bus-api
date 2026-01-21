package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzav implements zzaz {
    private static final Map<Uri, zzav> zzfr = new ArrayMap();
    private static final String[] zzfx = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfs;
    private final ContentObserver zzft;
    private final Object zzfu;
    private volatile Map<String, String> zzfv;
    private final List<zzaw> zzfw;

    private zzav(ContentResolver contentResolver, Uri uri) {
        zzax zzaxVar = new zzax(this, null);
        this.zzft = zzaxVar;
        this.zzfu = new Object();
        this.zzfw = new ArrayList();
        this.zzfs = contentResolver;
        this.uri = uri;
        contentResolver.registerContentObserver(uri, false, zzaxVar);
    }

    public static zzav zza(ContentResolver contentResolver, Uri uri) {
        zzav zzavVar;
        synchronized (zzav.class) {
            Map<Uri, zzav> map = zzfr;
            zzavVar = map.get(uri);
            if (zzavVar == null) {
                try {
                    zzav zzavVar2 = new zzav(contentResolver, uri);
                    try {
                        map.put(uri, zzavVar2);
                    } catch (SecurityException unused) {
                    }
                    zzavVar = zzavVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzavVar;
    }

    private final Map<String, String> zzv() {
        Map<String, String> mapZzx = this.zzfv;
        if (mapZzx == null) {
            synchronized (this.zzfu) {
                mapZzx = this.zzfv;
                if (mapZzx == null) {
                    mapZzx = zzx();
                    this.zzfv = mapZzx;
                }
            }
        }
        return mapZzx != null ? mapZzx : Collections.EMPTY_MAP;
    }

    public final void zzw() {
        synchronized (this.zzfu) {
            this.zzfv = null;
            zzbj.zzac();
        }
        synchronized (this) {
            Iterator<zzaw> it = this.zzfw.iterator();
            while (it.hasNext()) {
                it.next().zzaa();
            }
        }
    }

    private final Map<String, String> zzx() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzay.zza(new zzbb(this) { // from class: com.google.android.gms.internal.vision.zzau
                    private final zzav zzfq;

                    {
                        this.zzfq = this;
                    }

                    @Override // com.google.android.gms.internal.vision.zzbb
                    public final Object zzu() {
                        return this.zzfq.zzz();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static synchronized void zzy() {
        for (zzav zzavVar : zzfr.values()) {
            zzavVar.zzfs.unregisterContentObserver(zzavVar.zzft);
        }
        zzfr.clear();
    }

    @Override // com.google.android.gms.internal.vision.zzaz
    public final /* synthetic */ Object zzb(String str) {
        return zzv().get(str);
    }

    final /* synthetic */ Map zzz() {
        Map map;
        Cursor cursorQuery = this.zzfs.query(this.uri, zzfx, null, null, null);
        if (cursorQuery == null) {
            return Collections.EMPTY_MAP;
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.EMPTY_MAP;
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
