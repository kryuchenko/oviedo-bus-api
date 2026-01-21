package com.google.android.libraries.places.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbjd {
    public static final zzbde zzm;
    public static final zzbde zzn;
    public static final zzayh zzo;
    public static final zzbql zzp;
    public static final zzbql zzq;
    public static final zznc zzr;
    private static final zzayx zzu;
    private static final Logger zzs = Logger.getLogger(zzbjd.class.getName());
    private static final Set zzt = Collections.unmodifiableSet(EnumSet.of(zzbdj.OK, zzbdj.INVALID_ARGUMENT, zzbdj.NOT_FOUND, zzbdj.ALREADY_EXISTS, zzbdj.FAILED_PRECONDITION, zzbdj.ABORTED, zzbdj.OUT_OF_RANGE, zzbdj.DATA_LOSS));
    public static final Charset zza = Charset.forName("US-ASCII");
    public static final zzbca zzb = zzbca.zzc("grpc-timeout", new zzbjc());
    public static final zzbca zzc = zzbca.zzc("grpc-encoding", zzbcf.zzb);
    public static final zzbca zzd = zzbar.zzb("grpc-accept-encoding", new zzbja(null));
    public static final zzbca zze = zzbca.zzc("content-encoding", zzbcf.zzb);
    public static final zzbca zzf = zzbar.zzb("accept-encoding", new zzbja(null));
    static final zzbca zzg = zzbca.zzc("content-length", zzbcf.zzb);
    public static final zzbca zzh = zzbca.zzc("content-type", zzbcf.zzb);
    public static final zzbca zzi = zzbca.zzc("te", zzbcf.zzb);
    public static final zzbca zzj = zzbca.zzc("user-agent", zzbcf.zzb);
    public static final zzmy zzk = zzmy.zzb(zzma.zzb(',')).zzc(zzma.zzc());
    public static final long zzl = TimeUnit.SECONDS.toNanos(20);

    static {
        TimeUnit.HOURS.toNanos(2L);
        TimeUnit.SECONDS.toNanos(20L);
        zzm = new zzbnu();
        zzn = new zzbiu();
        zzo = zzayh.zza("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        zzu = new zzbiv();
        zzp = new zzbiw();
        zzq = new zzbix();
        zzr = new zzbiy();
    }

    private zzbjd() {
    }

    public static zzbdo zzb(zzbdo zzbdoVar) {
        if (!zzt.contains(zzbdoVar.zza())) {
            return zzbdoVar;
        }
        return zzbdo.zzo.zzg("Inappropriate status code from control plane: " + zzbdoVar.zza().toString() + " " + zzbdoVar.zzi()).zzf(zzbdoVar.zzj());
    }

    @Nullable
    static zzbfu zzc(zzbbe zzbbeVar, boolean z) {
        zzbfu zzbfuVarZzh;
        zzbbj zzbbjVarZze = zzbbeVar.zze();
        if (zzbbjVarZze != null) {
            zzblx zzblxVar = (zzblx) zzbbjVarZze;
            zzmt.zzp(zzblxVar.zzg, "Subchannel is not started");
            zzbfuVarZzh = zzblxVar.zzf.zzh();
        } else {
            zzbfuVarZzh = null;
        }
        if (zzbfuVarZzh != null) {
            return zzbfuVarZzh;
        }
        if (!zzbbeVar.zzf().zzl()) {
            if (zzbbeVar.zzg()) {
                return new zzbim(zzb(zzbbeVar.zzf()), zzbfs.DROPPED);
            }
            if (!z) {
                return new zzbim(zzb(zzbbeVar.zzf()), zzbfs.PROCESSED);
            }
        }
        return null;
    }

    public static String zzd(String str, int i) {
        try {
            return new URI(null, null, "places.googleapis.com", 443, null, null, null).getAuthority();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid host or port: places.googleapis.com 443", e);
        }
    }

    public static String zze(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static URI zzf(String str) {
        String str2;
        zzmt.zzc(str, "authority");
        try {
            str2 = str;
            try {
                return new URI(null, str2, null, null, null);
            } catch (URISyntaxException e) {
                e = e;
                throw new IllegalArgumentException("Invalid authority: ".concat(String.valueOf(str2)), e);
            }
        } catch (URISyntaxException e2) {
            e = e2;
            str2 = str;
        }
    }

    public static ThreadFactory zzg(String str, boolean z) {
        zzakd zzakdVar = new zzakd();
        zzakdVar.zza(true);
        zzakdVar.zzb(str);
        return zzakdVar.zzc();
    }

    static void zzh(zzbqq zzbqqVar) throws IOException {
        while (true) {
            InputStream inputStreamZza = zzbqqVar.zza();
            if (inputStreamZza == null) {
                return;
            } else {
                zzi(inputStreamZza);
            }
        }
    }

    public static void zzi(@Nullable Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (IOException e) {
            zzs.logp(Level.WARNING, "io.grpc.internal.GrpcUtil", "closeQuietly", "exception caught in closeQuietly", (Throwable) e);
        }
    }

    public static boolean zzj(String str, boolean z) {
        String strTrim = System.getenv(str);
        if (strTrim == null) {
            strTrim = System.getProperty(str);
        }
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        return zznb.zzd(strTrim) || Boolean.parseBoolean(strTrim);
    }

    public static zzayx[] zzk(zzayj zzayjVar, zzbcf zzbcfVar, int i, boolean z) {
        List listZzm = zzayjVar.zzm();
        int size = listZzm.size();
        zzayx[] zzayxVarArr = new zzayx[size + 1];
        zzayv zzayvVarZza = zzayw.zza();
        zzayvVarZza.zza(zzayjVar);
        zzayvVarZza.zzc(i);
        zzayvVarZza.zzb(z);
        zzayw zzaywVarZzd = zzayvVarZza.zzd();
        for (int i2 = 0; i2 < listZzm.size(); i2++) {
            zzayxVarArr[i2] = ((zzayu) listZzm.get(i2)).zza(zzaywVarZzd, zzbcfVar);
        }
        zzayxVarArr[size] = zzu;
        return zzayxVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzbdo zza(int i) {
        zzbdj zzbdjVar;
        if ((i < 100 || i >= 200) && i != 400) {
            if (i == 401) {
                zzbdjVar = zzbdj.UNAUTHENTICATED;
            } else if (i == 403) {
                zzbdjVar = zzbdj.PERMISSION_DENIED;
            } else if (i == 404) {
                zzbdjVar = zzbdj.UNIMPLEMENTED;
            } else if (i == 429) {
                zzbdjVar = zzbdj.UNAVAILABLE;
            } else if (i != 431) {
                switch (i) {
                    case 502:
                    case 503:
                    case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                        break;
                    default:
                        zzbdjVar = zzbdj.UNKNOWN;
                        break;
                }
            } else {
                zzbdjVar = zzbdj.INTERNAL;
            }
        }
        return zzbdjVar.zzb().zzg("HTTP status code " + i);
    }
}
