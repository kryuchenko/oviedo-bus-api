package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzey;
import com.google.android.gms.internal.vision.zzfb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfb<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>> implements zzig {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzfy zzfyVar, zzgi zzgiVar) throws IOException;

    @Override // 
    /* renamed from: zzdo, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
        try {
            zzfy zzfyVarZza = zzfy.zza(bArr, 0, i2, false);
            zza(zzfyVarZza, zzgiVar);
            zzfyVarZza.zzar(0);
            return this;
        } catch (zzhh e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 70);
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzig
    public final /* synthetic */ zzig zza(zzih zzihVar) {
        if (!zzge().getClass().isInstance(zzihVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzfb<MessageType, BuilderType>) zzihVar);
    }
}
