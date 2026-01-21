package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbtw {
    private static final zzbwf zza;
    private static final zzbtt[] zzb;
    private static final Map zzc;

    static {
        zzbwe zzbweVar = zzbwf.zza;
        zza = zzbwe.zza(":");
        int i = 0;
        zzb = new zzbtt[]{new zzbtt(zzbtt.zze, zzbwe.zza("")), new zzbtt(zzbtt.zzb, zzbwe.zza("GET")), new zzbtt(zzbtt.zzb, zzbwe.zza("POST")), new zzbtt(zzbtt.zzc, zzbwe.zza(RemoteSettings.FORWARD_SLASH_STRING)), new zzbtt(zzbtt.zzc, zzbwe.zza("/index.html")), new zzbtt(zzbtt.zzd, zzbwe.zza("http")), new zzbtt(zzbtt.zzd, zzbwe.zza("https")), new zzbtt(zzbtt.zza, zzbwe.zza("200")), new zzbtt(zzbtt.zza, zzbwe.zza("204")), new zzbtt(zzbtt.zza, zzbwe.zza("206")), new zzbtt(zzbtt.zza, zzbwe.zza("304")), new zzbtt(zzbtt.zza, zzbwe.zza("400")), new zzbtt(zzbtt.zza, zzbwe.zza("404")), new zzbtt(zzbtt.zza, zzbwe.zza("500")), new zzbtt("accept-charset", ""), new zzbtt("accept-encoding", "gzip, deflate"), new zzbtt("accept-language", ""), new zzbtt("accept-ranges", ""), new zzbtt("accept", ""), new zzbtt("access-control-allow-origin", ""), new zzbtt("age", ""), new zzbtt("allow", ""), new zzbtt("authorization", ""), new zzbtt("cache-control", ""), new zzbtt("content-disposition", ""), new zzbtt("content-encoding", ""), new zzbtt("content-language", ""), new zzbtt("content-length", ""), new zzbtt("content-location", ""), new zzbtt("content-range", ""), new zzbtt("content-type", ""), new zzbtt("cookie", ""), new zzbtt("date", ""), new zzbtt("etag", ""), new zzbtt("expect", ""), new zzbtt("expires", ""), new zzbtt("from", ""), new zzbtt("host", ""), new zzbtt("if-match", ""), new zzbtt("if-modified-since", ""), new zzbtt("if-none-match", ""), new zzbtt("if-range", ""), new zzbtt("if-unmodified-since", ""), new zzbtt("last-modified", ""), new zzbtt("link", ""), new zzbtt(FirebaseAnalytics.Param.LOCATION, ""), new zzbtt("max-forwards", ""), new zzbtt("proxy-authenticate", ""), new zzbtt("proxy-authorization", ""), new zzbtt("range", ""), new zzbtt("referer", ""), new zzbtt("refresh", ""), new zzbtt("retry-after", ""), new zzbtt("server", ""), new zzbtt("set-cookie", ""), new zzbtt("strict-transport-security", ""), new zzbtt("transfer-encoding", ""), new zzbtt("user-agent", ""), new zzbtt("vary", ""), new zzbtt("via", ""), new zzbtt("www-authenticate", "")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        while (true) {
            zzbtt[] zzbttVarArr = zzb;
            int length = zzbttVarArr.length;
            if (i >= 61) {
                zzc = Collections.unmodifiableMap(linkedHashMap);
                return;
            } else {
                if (!linkedHashMap.containsKey(zzbttVarArr[i].zzh)) {
                    linkedHashMap.put(zzbttVarArr[i].zzh, Integer.valueOf(i));
                }
                i++;
            }
        }
    }

    static /* bridge */ /* synthetic */ zzbwf zzc(zzbwf zzbwfVar) throws IOException {
        int iZzc = zzbwfVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            byte bZza = zzbwfVar.zza(i);
            if (bZza >= 65 && bZza <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(zzbwfVar.zzf()));
            }
        }
        return zzbwfVar;
    }
}
