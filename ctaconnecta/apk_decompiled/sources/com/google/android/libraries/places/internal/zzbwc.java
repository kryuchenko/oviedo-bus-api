package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public interface zzbwc extends WritableByteChannel, zzbwq {
    @Override // com.google.android.libraries.places.internal.zzbwq, java.io.Flushable
    void flush() throws IOException;

    zzbwc zzv(int i) throws IOException;

    zzbwc zzw(int i) throws IOException;

    zzbwc zzx(String str) throws IOException;
}
