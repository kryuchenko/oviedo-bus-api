package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcw implements ComponentFactory {
    static final ComponentFactory zza = new zzcw();

    private zzcw() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzcv((Context) componentContainer.get(Context.class));
    }
}
