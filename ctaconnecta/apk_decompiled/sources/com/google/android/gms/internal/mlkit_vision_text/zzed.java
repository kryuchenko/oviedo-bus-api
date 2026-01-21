package com.google.android.gms.internal.mlkit_vision_text;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzed implements ComponentFactory {
    static final ComponentFactory zza = new zzed();

    private zzed() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzee((zzea) componentContainer.get(zzea.class), (zzdy) componentContainer.get(zzdy.class));
    }
}
