package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcy implements ComponentFactory {
    static final ComponentFactory zza = new zzcy();

    private zzcy() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzcz((zzcv) componentContainer.get(zzcv.class), (zzct) componentContainer.get(zzct.class));
    }
}
