package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbsj extends zzbsk {
    private static final zzbtf zzb = new zzbtf(null, "setUseSessionTickets", Boolean.TYPE);
    private static final zzbtf zzc = new zzbtf(null, "setHostname", String.class);
    private static final zzbtf zzd = new zzbtf(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
    private static final zzbtf zze = new zzbtf(null, "setAlpnProtocols", byte[].class);
    private static final zzbtf zzf = new zzbtf(byte[].class, "getNpnSelectedProtocol", new Class[0]);
    private static final zzbtf zzg = new zzbtf(null, "setNpnProtocols", byte[].class);
    private static final Method zzh;
    private static final Method zzi;
    private static final Method zzj;
    private static final Method zzk;
    private static final Method zzl;
    private static final Method zzm;
    private static final Constructor zzn;

    static {
        NoSuchMethodException noSuchMethodException;
        Method method;
        Method method2;
        Method method3;
        ClassNotFoundException classNotFoundException;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        Method method9;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            method2 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            try {
                method5 = SSLParameters.class.getMethod("getApplicationProtocols", null);
                try {
                    method7 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                    try {
                        cls = Class.forName("android.net.ssl.SSLSockets");
                        method8 = cls.getMethod("isSupportedSocket", SSLSocket.class);
                    } catch (ClassNotFoundException e) {
                        classNotFoundException = e;
                        method4 = null;
                        method = method5;
                        method3 = method7;
                    } catch (NoSuchMethodException e2) {
                        noSuchMethodException = e2;
                        method4 = null;
                        method = method5;
                        method3 = method7;
                    }
                    try {
                        method6 = cls.getMethod("setUseSessionTickets", SSLSocket.class, Boolean.TYPE);
                    } catch (ClassNotFoundException e3) {
                        classNotFoundException = e3;
                        method = method5;
                        method3 = method7;
                        method4 = method8;
                        zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                        method5 = method;
                        method6 = null;
                        method7 = method3;
                        method8 = method4;
                        zzj = method2;
                        zzk = method5;
                        zzl = method7;
                        zzh = method8;
                        zzi = method6;
                        method9 = SSLParameters.class.getMethod("setServerNames", List.class);
                        try {
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        } catch (ClassNotFoundException e4) {
                            e = e4;
                            zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) e);
                            zzm = method9;
                            zzn = constructor;
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (Throwable) e);
                            zzm = method9;
                            zzn = constructor;
                        }
                        zzm = method9;
                        zzn = constructor;
                    } catch (NoSuchMethodException e6) {
                        noSuchMethodException = e6;
                        method = method5;
                        method3 = method7;
                        method4 = method8;
                        zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                        method5 = method;
                        method6 = null;
                        method7 = method3;
                        method8 = method4;
                        zzj = method2;
                        zzk = method5;
                        zzl = method7;
                        zzh = method8;
                        zzi = method6;
                        method9 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        zzm = method9;
                        zzn = constructor;
                    }
                } catch (ClassNotFoundException e7) {
                    classNotFoundException = e7;
                    method3 = null;
                    method4 = null;
                    method = method5;
                } catch (NoSuchMethodException e8) {
                    noSuchMethodException = e8;
                    method3 = null;
                    method4 = null;
                    method = method5;
                }
            } catch (ClassNotFoundException e9) {
                classNotFoundException = e9;
                method = null;
                method3 = null;
                method4 = method3;
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) classNotFoundException);
                method5 = method;
                method6 = null;
                method7 = method3;
                method8 = method4;
                zzj = method2;
                zzk = method5;
                zzl = method7;
                zzh = method8;
                zzi = method6;
                method9 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                zzm = method9;
                zzn = constructor;
            } catch (NoSuchMethodException e10) {
                noSuchMethodException = e10;
                method = null;
                method3 = null;
                method4 = method3;
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 10.0+ APIs", (Throwable) noSuchMethodException);
                method5 = method;
                method6 = null;
                method7 = method3;
                method8 = method4;
                zzj = method2;
                zzk = method5;
                zzl = method7;
                zzh = method8;
                zzi = method6;
                method9 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                zzm = method9;
                zzn = constructor;
            }
        } catch (ClassNotFoundException e11) {
            classNotFoundException = e11;
            method = null;
            method2 = null;
            method3 = null;
        } catch (NoSuchMethodException e12) {
            noSuchMethodException = e12;
            method = null;
            method2 = null;
            method3 = null;
        }
        zzj = method2;
        zzk = method5;
        zzl = method7;
        zzh = method8;
        zzi = method6;
        try {
            method9 = SSLParameters.class.getMethod("setServerNames", List.class);
            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
        } catch (ClassNotFoundException e13) {
            e = e13;
            method9 = null;
        } catch (NoSuchMethodException e14) {
            e = e14;
            method9 = null;
        }
        zzm = method9;
        zzn = constructor;
    }

    zzbsj(zzbtl zzbtlVar) {
        super(zzbtlVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zza(SSLSocket sSLSocket) {
        Method method = zzl;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                if (!(e2.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e2);
                }
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        if (this.zza.zzc() == 1) {
            try {
                byte[] bArr = (byte[]) zzd.zzb(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, zzbto.zzb);
                }
            } catch (Exception e3) {
                zzbsk.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getAlpnSelectedProtocol()", (Throwable) e3);
            }
        }
        if (this.zza.zzc() != 3) {
            try {
                byte[] bArr2 = (byte[]) zzf.zzb(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, zzbto.zzb);
                }
            } catch (Exception e4) {
                zzbsk.zzb.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getNpnSelectedProtocol()", (Throwable) e4);
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zzb(SSLSocket sSLSocket, String str, List list) throws IOException {
        String strZza = zza(sSLSocket);
        return strZza == null ? super.zzb(sSLSocket, str, list) : strZza;
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    protected final void zzc(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor constructor;
        boolean z;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzbtm) it.next()).toString());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (!str.contains("_")) {
                        try {
                            zzmt.zzj(zzbjd.zzf(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
                            Method method2 = zzh;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                zzb.zza(sSLSocket, true);
                            } else {
                                zzi.invoke(null, sSLSocket, true);
                            }
                            Method method3 = zzm;
                            if (method3 == null || (constructor = zzn) == null) {
                                zzc.zza(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            }
        }
        Method method4 = zzl;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, null);
                zzj.invoke(sSLParameters, strArr);
                z = true;
            } catch (InvocationTargetException e4) {
                if (!(e4.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e4;
                }
                zzbsk.zzb.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "configureTlsExtensions", "setApplicationProtocol unsupported, will try old methods");
            }
        } else {
            z = false;
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z && (method = zzk) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
            return;
        }
        Object[] objArr = {zzbtl.zzg(list)};
        if (this.zza.zzc() == 1) {
            zze.zzb(sSLSocket, objArr);
        }
        if (this.zza.zzc() == 3) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        zzg.zzb(sSLSocket, objArr);
    }
}
