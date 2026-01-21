package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzeo;
import com.google.android.gms.internal.mlkit_vision_text.zzep;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzeo<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> implements zzhj {
    protected abstract BuilderType zza(MessageType messagetype);

    @Override // 
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhj
    public final /* synthetic */ zzhj zza(zzhg zzhgVar) {
        if (!zzi().getClass().isInstance(zzhgVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzeo<MessageType, BuilderType>) zzhgVar);
    }
}
