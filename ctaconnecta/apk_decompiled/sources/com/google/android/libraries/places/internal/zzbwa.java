package com.google.android.libraries.places.internal;

import java.io.Closeable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwa implements Closeable, AutoCloseable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("not attached to a buffer");
    }
}
