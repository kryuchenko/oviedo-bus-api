package com.google.mlkit.common.sdkinternal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzo implements ComponentFactory {
    static final ComponentFactory zza = new zzo();

    private zzo() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return SharedPrefManager.zza(componentContainer);
    }
}
