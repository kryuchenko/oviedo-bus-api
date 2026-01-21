package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcp implements ComponentFactory {
    static final ComponentFactory zza = new zzcp();

    private zzcp() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzck((Context) componentContainer.get(Context.class));
    }
}
