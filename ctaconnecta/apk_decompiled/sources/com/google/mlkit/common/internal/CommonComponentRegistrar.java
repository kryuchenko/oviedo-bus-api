package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzct;
import com.google.android.gms.internal.mlkit_common.zzcv;
import com.google.android.gms.internal.mlkit_common.zzcz;
import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.android.gms.internal.mlkit_common.zzdg;
import com.google.android.gms.internal.mlkit_common.zzl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class CommonComponentRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return zzl.zza(zzdb.zza, SharedPrefManager.COMPONENT, zzdg.zza, zzcz.zza, zzcv.zza, zzct.zza, Component.builder(ModelFileHelper.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(zzb.zza).build(), Component.builder(MlKitThreadPool.class).factory(zza.zza).build(), Component.builder(RemoteModelManager.class).add(Dependency.setOf((Class<?>) RemoteModelManager.RemoteModelManagerRegistration.class)).factory(zzd.zza).build(), Component.builder(ExecutorSelector.class).add(Dependency.requiredProvider((Class<?>) MlKitThreadPool.class)).factory(zzc.zza).build(), Component.builder(Cleaner.class).factory(zzf.zza).build(), Component.builder(CloseGuard.Factory.class).add(Dependency.required((Class<?>) Cleaner.class)).add(Dependency.required((Class<?>) zzdb.class)).factory(zze.zza).build(), new Component[0]);
    }
}
