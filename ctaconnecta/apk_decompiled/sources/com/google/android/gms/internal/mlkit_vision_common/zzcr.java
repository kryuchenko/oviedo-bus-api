package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcr implements ComponentFactory {
    static final ComponentFactory zza = new zzcr();

    private zzcr() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzco((zzck) componentContainer.get(zzck.class), (zzcj) componentContainer.get(zzcj.class));
    }
}
