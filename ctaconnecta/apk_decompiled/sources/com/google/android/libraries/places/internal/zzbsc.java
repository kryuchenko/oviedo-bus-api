package com.google.android.libraries.places.internal;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzbsc implements Runnable {
    final /* synthetic */ CountDownLatch zza;
    final /* synthetic */ zzbri zzb;
    final /* synthetic */ zzbsf zzc;

    zzbsc(zzbsf zzbsfVar, CountDownLatch countDownLatch, zzbri zzbriVar) {
        this.zza = countDownLatch;
        this.zzb = zzbriVar;
        this.zzc = zzbsfVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        Socket socketZzA;
        try {
            this.zza.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        zzbwd zzbwdVarZzb = zzbwh.zzb(new zzbsb(this));
        try {
            try {
                zzbsf zzbsfVar = this.zzc;
                zzbaa zzbaaVar = zzbsfVar.zza;
                SSLSession session = null;
                if (zzbaaVar == null) {
                    socketZzA = zzbsfVar.zzE.createSocket(zzbsfVar.zze.getAddress(), this.zzc.zze.getPort());
                } else {
                    if (!(zzbaaVar.zze() instanceof InetSocketAddress)) {
                        throw new zzbdp(zzbdo.zzo.zzg("Unsupported SocketAddress implementation " + String.valueOf(this.zzc.zza.zze().getClass())), null);
                    }
                    socketZzA = zzbsf.zzA(zzbsfVar, zzbaaVar.zzd(), (InetSocketAddress) zzbaaVar.zze(), this.zzc.zza.zzc(), this.zzc.zza.zzb());
                }
                zzbsf zzbsfVar2 = this.zzc;
                Socket socket = socketZzA;
                if (zzbsfVar2.zzF != null) {
                    SSLSocketFactory sSLSocketFactory = zzbsfVar2.zzF;
                    String strZzy = zzbsfVar2.zzy();
                    int iZzi = this.zzc.zzi();
                    zzbsz zzbszVar = this.zzc.zzJ;
                    zzmt.zzc(sSLSocketFactory, "sslSocketFactory");
                    zzmt.zzc(socketZzA, "socket");
                    zzmt.zzc(zzbszVar, "spec");
                    SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socketZzA, strZzy, iZzi, true);
                    zzbszVar.zza(sSLSocket, false);
                    String strZzb = zzbsk.zzd().zzb(sSLSocket, strZzy, zzbszVar.zzb() ? zzbsm.zza : null);
                    zzmt.zzr(zzbsm.zza.contains(zzbtm.zza(strZzb)), "Only " + String.valueOf(zzbsm.zza) + " are supported, but negotiated protocol is %s", strZzb);
                    if (!zzbte.zza.verify((strZzy.startsWith("[") && strZzy.endsWith("]")) ? strZzy.substring(1, strZzy.length() - 1) : strZzy, sSLSocket.getSession())) {
                        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(strZzy)));
                    }
                    session = sSLSocket.getSession();
                    socket = sSLSocket;
                }
                socket.setTcpNoDelay(true);
                zzbwd zzbwdVarZzb2 = zzbwh.zzb(zzbwh.zzd(socket));
                this.zzb.zzm(zzbwh.zzc(socket), socket);
                zzbsf zzbsfVar3 = this.zzc;
                zzayb zzaybVarZzb = zzbsfVar3.zzy.zzb();
                zzaybVarZzb.zzb(zzazw.zza, socket.getRemoteSocketAddress());
                zzaybVarZzb.zzb(zzazw.zzb, socket.getLocalSocketAddress());
                zzaybVarZzb.zzb(zzazw.zzc, session);
                zzaybVarZzb.zzb(zzbit.zza, session == null ? zzbdf.NONE : zzbdf.PRIVACY_AND_INTEGRITY);
                zzbsfVar3.zzy = zzaybVarZzb.zzc();
                zzbsf zzbsfVar4 = this.zzc;
                zzbsfVar4.zzx = new zzbse(zzbsfVar4, zzbsfVar4.zzk.zzc(zzbwdVarZzb2, true));
                synchronized (this.zzc.zzo) {
                    zzbsf zzbsfVar5 = this.zzc;
                    zzmt.zzc(socket, "socket");
                    zzbsfVar5.zzG = socket;
                    if (session != null) {
                        this.zzc.zzP = new zzbaf(new zzbag(session));
                    }
                }
            } finally {
                zzbsf zzbsfVar6 = this.zzc;
                zzbsfVar6.zzx = new zzbse(zzbsfVar6, zzbsfVar6.zzk.zzc(zzbwdVarZzb, true));
            }
        } catch (zzbdp e) {
            this.zzc.zzaa(0, zzbtp.INTERNAL_ERROR, e.zza());
        } catch (Exception e2) {
            this.zzc.zzb(e2);
        }
    }
}
