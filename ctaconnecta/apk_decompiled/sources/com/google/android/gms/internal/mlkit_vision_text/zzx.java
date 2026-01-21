package com.google.android.gms.internal.mlkit_vision_text;

import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzx {
    static boolean zza(Collection<?> collection, @NullableDecl Object obj) {
        zzd.zza(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
