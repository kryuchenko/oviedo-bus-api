package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwh {
    public static final zzbwc zza(zzbwq zzbwqVar) {
        Intrinsics.checkNotNullParameter(zzbwqVar, "<this>");
        return new zzbwk(zzbwqVar);
    }

    public static final zzbwd zzb(zzbws zzbwsVar) {
        Intrinsics.checkNotNullParameter(zzbwsVar, "<this>");
        return new zzbwl(zzbwsVar);
    }

    public static final zzbwq zzc(Socket socket) throws IOException {
        int i = zzbwi.zza;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzbwr zzbwrVar = new zzbwr(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        zzbwj sink = new zzbwj(outputStream, zzbwrVar);
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new zzbvx(zzbwrVar, sink);
    }

    public static final zzbws zzd(Socket socket) throws IOException {
        int i = zzbwi.zza;
        Intrinsics.checkNotNullParameter(socket, "<this>");
        zzbwr zzbwrVar = new zzbwr(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        zzbwg source = new zzbwg(inputStream, zzbwrVar);
        Intrinsics.checkNotNullParameter(source, "source");
        return new zzbvy(zzbwrVar, source);
    }
}
