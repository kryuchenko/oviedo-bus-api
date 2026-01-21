package com.google.mlkit.common.sdkinternal;

import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final class zzi extends ThreadLocal<Deque<Runnable>> {
    zzi() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Deque<Runnable> initialValue() {
        return new ArrayDeque();
    }
}
