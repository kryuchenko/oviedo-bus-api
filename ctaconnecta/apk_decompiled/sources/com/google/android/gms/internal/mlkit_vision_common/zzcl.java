package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcl implements ComponentFactory {
    static final ComponentFactory zza = new zzcl();

    private zzcl() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzcj((Context) componentContainer.get(Context.class));
    }
}
