package com.google.android.libraries.places.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbih extends zzbcv {
    static final boolean zza;
    static final boolean zzb;
    protected static final boolean zzc;
    private static final Logger zzg;
    private static final Set zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    private static final zzbig zzl;
    private static String zzm;
    private boolean zzA;
    private zzbcr zzB;
    final zzbde zzd;
    protected boolean zzf;
    private final String zzp;
    private final String zzq;
    private final int zzr;
    private final zzbql zzs;
    private final long zzt;
    private final zzbdw zzu;
    private final zzna zzv;
    private boolean zzw;
    private Executor zzx;
    private final boolean zzy;
    private final zzbcu zzz;
    private final Random zzn = new Random();
    protected volatile zzbhz zze = zzbic.INSTANCE;
    private final AtomicReference zzo = new AtomicReference();

    static {
        Logger logger = Logger.getLogger(zzbih.class.getName());
        zzg = logger;
        zzh = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        zzi = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        zzj = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        zzk = property3;
        zza = Boolean.parseBoolean(property);
        zzb = Boolean.parseBoolean(property2);
        zzc = Boolean.parseBoolean(property3);
        zzbig zzbigVar = null;
        try {
            try {
                try {
                    zzbig zzbigVar2 = (zzbig) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, zzbih.class.getClassLoader()).asSubclass(zzbig.class).getConstructor(null).newInstance(null);
                    if (zzbigVar2.zzb() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", zzbigVar2.zzb());
                    } else {
                        zzbigVar = zzbigVar2;
                    }
                } catch (Exception e) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e);
                }
            } catch (Exception e2) {
                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e2);
            }
        } catch (ClassCastException e3) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e3);
        } catch (ClassNotFoundException e4) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e4);
        }
        zzl = zzbigVar;
    }

    protected zzbih(@Nullable String str, String str2, zzbco zzbcoVar, zzbql zzbqlVar, zzna zznaVar, boolean z) throws NumberFormatException {
        zzmt.zzc(zzbcoVar, "args");
        this.zzs = zzbqlVar;
        zzmt.zzc(str2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        URI uriCreate = URI.create("//".concat(str2));
        zzmt.zzj(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        String authority = uriCreate.getAuthority();
        zzmt.zzd(authority, "nameUri (%s) doesn't have an authority", uriCreate);
        this.zzp = authority;
        this.zzq = uriCreate.getHost();
        if (uriCreate.getPort() == -1) {
            this.zzr = zzbcoVar.zza();
        } else {
            this.zzr = uriCreate.getPort();
        }
        this.zzd = zzbcoVar.zzd();
        long nanos = 0;
        if (!z) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j = 30;
            if (property != null) {
                try {
                    j = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    zzg.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            nanos = j > 0 ? TimeUnit.SECONDS.toNanos(j) : j;
        }
        this.zzt = nanos;
        this.zzv = zznaVar;
        this.zzu = zzbcoVar.zze();
        Executor executorZzf = zzbcoVar.zzf();
        this.zzx = executorZzf;
        this.zzy = executorZzf == null;
        this.zzz = zzbcoVar.zzc();
    }

    static /* bridge */ /* synthetic */ zzazs zzg(zzbih zzbihVar) throws IOException {
        zzbdd zzbddVarZza = zzbihVar.zzd.zza(InetSocketAddress.createUnresolved(zzbihVar.zzq, zzbihVar.zzr));
        if (zzbddVarZza == null) {
            return null;
        }
        return new zzazs(Collections.singletonList(zzbddVarZza), zzaye.zza);
    }

    private static String zzm() {
        if (zzm == null) {
            try {
                zzm = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
        return zzm;
    }

    private final void zzn() {
        if (this.zzA || this.zzw) {
            return;
        }
        if (this.zzf) {
            long j = this.zzt;
            if (j != 0 && (j <= 0 || this.zzv.zza(TimeUnit.NANOSECONDS) <= this.zzt)) {
                return;
            }
        }
        this.zzA = true;
        this.zzx.execute(new zzbie(this, this.zzB));
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final String zza() {
        return this.zzp;
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzb() {
        zzmt.zzp(this.zzB != null, "not started");
        zzn();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzc() {
        if (this.zzw) {
            return;
        }
        this.zzw = true;
        Executor executor = this.zzx;
        if (executor == null || !this.zzy) {
            return;
        }
        zzbqm.zzc(this.zzs, executor);
        this.zzx = null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.concurrent.Executor] */
    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzd(zzbcr zzbcrVar) {
        zzmt.zzp(this.zzB == null, "already started");
        if (this.zzy) {
            this.zzx = zzbqm.zza(this.zzs);
        }
        this.zzB = zzbcrVar;
        zzn();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[LOOP:2: B:61:0x012b->B:156:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018c A[Catch: RuntimeException -> 0x01e6, TryCatch #0 {RuntimeException -> 0x01e6, blocks: (B:64:0x0137, B:65:0x013f, B:67:0x0145, B:68:0x015b, B:70:0x0163, B:72:0x0169, B:73:0x016d, B:75:0x0173, B:79:0x0184, B:81:0x018c, B:86:0x0199, B:89:0x01a5, B:91:0x01ad, B:93:0x01b3, B:94:0x01b7, B:96:0x01bd, B:98:0x01c9, B:103:0x01d3, B:104:0x01e5), top: B:134:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a5 A[Catch: RuntimeException -> 0x01e6, TryCatch #0 {RuntimeException -> 0x01e6, blocks: (B:64:0x0137, B:65:0x013f, B:67:0x0145, B:68:0x015b, B:70:0x0163, B:72:0x0169, B:73:0x016d, B:75:0x0173, B:79:0x0184, B:81:0x018c, B:86:0x0199, B:89:0x01a5, B:91:0x01ad, B:93:0x01b3, B:94:0x01b7, B:96:0x01bd, B:98:0x01c9, B:103:0x01d3, B:104:0x01e5), top: B:134:0x0137 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final zzbib zzi(boolean z) {
        zzbif zzbifVarZza;
        zzbig zzbigVar;
        zzbcp zzbcpVarZzb;
        Double dZzb;
        Exception exc = null;
        zzbcpVarZzb = null;
        zzbcp zzbcpVarZzb2 = null;
        exc = null;
        zzbib zzbibVar = new zzbib(null);
        try {
            try {
                try {
                    List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(this.zzq)));
                    ArrayList arrayList = new ArrayList(listUnmodifiableList.size());
                    Iterator it = listUnmodifiableList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new zzazs(Collections.singletonList(new InetSocketAddress((InetAddress) it.next(), this.zzr)), zzaye.zza));
                    }
                    zzbibVar.zzb = Collections.unmodifiableList(arrayList);
                    if (zzc) {
                        String str = this.zzq;
                        List<String> listZza = Collections.EMPTY_LIST;
                        boolean z2 = zza;
                        boolean z3 = zzb;
                        if (z2) {
                            if (!"localhost".equalsIgnoreCase(str)) {
                                if (!str.contains(":")) {
                                    boolean z4 = true;
                                    for (int i = 0; i < str.length(); i++) {
                                        char cCharAt = str.charAt(i);
                                        if (cCharAt != '.') {
                                            z4 &= cCharAt >= '0' && cCharAt <= '9';
                                        }
                                    }
                                    if (z4) {
                                    }
                                }
                                zzbifVarZza = null;
                            } else if (z3) {
                                zzbifVarZza = (zzbif) this.zzo.get();
                                if (zzbifVarZza == null && (zzbigVar = zzl) != null) {
                                    zzbifVarZza = zzbigVar.zza();
                                }
                            } else {
                                zzbifVarZza = null;
                            }
                            if (zzbifVarZza != null) {
                                try {
                                    listZza = zzbifVarZza.zza();
                                } catch (Exception e) {
                                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "ServiceConfig resolution failure", (Throwable) e);
                                }
                            }
                            if (listZza.isEmpty()) {
                                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveServiceConfig", "No TXT records found for {0}", new Object[]{this.zzq});
                            } else {
                                Random random = this.zzn;
                                String strZzm = zzm();
                                try {
                                    ArrayList<Map> arrayList2 = new ArrayList();
                                    for (String str2 : listZza) {
                                        if (str2.startsWith("grpc_config=")) {
                                            Object objZza = zzbkf.zza(str2.substring(12));
                                            if (!(objZza instanceof List)) {
                                                throw new ClassCastException("wrong type ".concat(String.valueOf(String.valueOf(objZza))));
                                            }
                                            List list = (List) objZza;
                                            zzbkg.zzf(list);
                                            arrayList2.addAll(list);
                                        } else {
                                            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "parseTxtResults", "Ignoring non service config {0}", new Object[]{str2});
                                        }
                                    }
                                    Map map = null;
                                    for (Map map2 : arrayList2) {
                                        try {
                                            for (Map.Entry entry : map2.entrySet()) {
                                                zzng.zza(zzh.contains(entry.getKey()), "Bad key: %s", entry);
                                            }
                                            List listZzi = zzbkg.zzi(map2, "clientLanguage");
                                            if (listZzi == null || listZzi.isEmpty()) {
                                                dZzb = zzbkg.zzb(map2, "percentage");
                                                if (dZzb == null) {
                                                    List listZzi2 = zzbkg.zzi(map2, "clientHostname");
                                                    if (listZzi2 != null && !listZzi2.isEmpty()) {
                                                        Iterator it2 = listZzi2.iterator();
                                                        while (it2.hasNext()) {
                                                            if (((String) it2.next()).equals(strZzm)) {
                                                            }
                                                        }
                                                        map = null;
                                                        if (map == null) {
                                                            break;
                                                        }
                                                    }
                                                    Map mapZzj = zzbkg.zzj(map2, "serviceConfig");
                                                    if (mapZzj == null) {
                                                        throw new zznh(String.format("key '%s' missing in '%s'", map2, "serviceConfig"));
                                                    }
                                                    map = mapZzj;
                                                    if (map == null) {
                                                    }
                                                } else {
                                                    int iIntValue = dZzb.intValue();
                                                    zzng.zza(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dZzb);
                                                    if (random.nextInt(100) >= iIntValue) {
                                                    }
                                                    map = null;
                                                    if (map == null) {
                                                    }
                                                }
                                            } else {
                                                Iterator it3 = listZzi.iterator();
                                                while (it3.hasNext()) {
                                                    if ("java".equalsIgnoreCase((String) it3.next())) {
                                                        dZzb = zzbkg.zzb(map2, "percentage");
                                                        if (dZzb == null) {
                                                        }
                                                    }
                                                }
                                                map = null;
                                                if (map == null) {
                                                }
                                            }
                                        } catch (RuntimeException e2) {
                                            zzbcpVarZzb = zzbcp.zzb(zzbdo.zzc.zzg("failed to pick service config choice").zzf(e2));
                                        }
                                    }
                                    zzbcpVarZzb = map == null ? null : zzbcp.zza(map);
                                } catch (IOException | RuntimeException e3) {
                                    zzbcpVarZzb = zzbcp.zzb(zzbdo.zzc.zzg("failed to parse TXT records").zzf(e3));
                                }
                                if (zzbcpVarZzb != null) {
                                    zzbcpVarZzb2 = zzbcpVarZzb.zzc() != null ? zzbcp.zzb(zzbcpVarZzb.zzc()) : this.zzz.zza((Map) zzbcpVarZzb.zzd());
                                }
                            }
                            zzbibVar.zzc = zzbcpVarZzb2;
                        }
                    }
                    return zzbibVar;
                } catch (Exception e4) {
                    exc = e4;
                    zznd.zza(exc);
                    throw new RuntimeException(exc);
                }
            } catch (Throwable th) {
                Exception exc2 = exc;
                if (exc2 != null) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "resolveAddresses", "Address resolution failure", (Throwable) exc2);
                }
                throw th;
            }
        } catch (Exception e5) {
            zzbibVar.zza = zzbdo.zzp.zzg("Unable to resolve host ".concat(String.valueOf(this.zzq))).zzf(e5);
            return zzbibVar;
        }
    }
}
