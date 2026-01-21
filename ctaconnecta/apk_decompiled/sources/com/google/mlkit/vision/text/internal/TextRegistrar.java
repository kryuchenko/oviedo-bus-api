package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text.zzal;
import com.google.android.gms.internal.mlkit_vision_text.zzdy;
import com.google.android.gms.internal.mlkit_vision_text.zzea;
import com.google.android.gms.internal.mlkit_vision_text.zzee;
import com.google.android.gms.internal.mlkit_vision_text.zzeg;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class TextRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzal.zza(zzee.zza, zzea.zza, zzdy.zza, zzeg.zza, Component.builder(zzb.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(zzd.zza).build());
    }
}
