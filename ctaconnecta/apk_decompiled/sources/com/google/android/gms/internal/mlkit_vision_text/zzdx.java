package com.google.android.gms.internal.mlkit_vision_text;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzdx implements ComponentFactory {
    static final ComponentFactory zza = new zzdx();

    private zzdx() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzdy((Context) componentContainer.get(Context.class));
    }
}
