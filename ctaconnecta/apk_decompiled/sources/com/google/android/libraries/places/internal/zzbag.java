package com.google.android.libraries.places.internal;

import java.security.cert.Certificate;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbag {
    public final String zza;

    @Nullable
    public final Certificate zzb;

    @Nullable
    public final Certificate zzc;

    public zzbag(SSLSession sSLSession) throws SSLPeerUnverifiedException {
        String cipherSuite = sSLSession.getCipherSuite();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        Certificate certificate = null;
        Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates != null) {
                certificate = peerCertificates[0];
            }
        } catch (SSLPeerUnverifiedException e) {
            zzbah.zza.logp(Level.FINE, "io.grpc.InternalChannelz$Tls", "<init>", String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e);
        }
        this.zza = cipherSuite;
        this.zzb = certificate2;
        this.zzc = certificate;
    }
}
