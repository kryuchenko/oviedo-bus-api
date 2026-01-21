package com.google.mlkit.vision.common.internal;

import com.google.android.gms.internal.mlkit_vision_common.zzcj;
import com.google.android.gms.internal.mlkit_vision_common.zzck;
import com.google.android.gms.internal.mlkit_vision_common.zzco;
import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzh;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzh.zza(zzco.zza, zzck.zza, zzcj.zza, zzcq.zza, Component.builder(MultiFlavorDetectorCreator.class).add(Dependency.setOf((Class<?>) MultiFlavorDetectorCreator.Registration.class)).factory(zzd.zza).build());
    }
}
