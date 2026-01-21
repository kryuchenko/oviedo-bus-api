package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdp;
import com.google.android.gms.internal.mlkit_common.zzdq;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdp<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzdp<MessageType, BuilderType>> implements zzgk {
    protected abstract BuilderType zza(MessageType messagetype);

    @Override // 
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    @Override // com.google.android.gms.internal.mlkit_common.zzgk
    public final /* synthetic */ zzgk zza(zzgh zzghVar) {
        if (!zzi().getClass().isInstance(zzghVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzdp<MessageType, BuilderType>) zzghVar);
    }
}
