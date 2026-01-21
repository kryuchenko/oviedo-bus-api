package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzdb;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zze implements ComponentFactory {
    static final ComponentFactory zza = new zze();

    private zze() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new CloseGuard.Factory((Cleaner) componentContainer.get(Cleaner.class), (zzdb) componentContainer.get(zzdb.class));
    }
}
