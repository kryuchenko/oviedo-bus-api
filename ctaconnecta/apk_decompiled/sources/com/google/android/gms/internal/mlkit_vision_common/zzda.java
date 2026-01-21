package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzdd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzda<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzdd<MessageType, BuilderType>> implements zzfv {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfv
    public final zzdj zze() {
        try {
            zzdr zzdrVarZzc = zzdj.zzc(zzj());
            zza(zzdrVarZzc.zzb());
            return zzdrVarZzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] zzf() {
        try {
            byte[] bArr = new byte[zzj()];
            zzdw zzdwVarZza = zzdw.zza(bArr);
            zza(zzdwVarZza);
            zzdwVarZza.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int zzg() {
        throw new UnsupportedOperationException();
    }

    void zza(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzem.zza(iterable);
        if (iterable instanceof zzfc) {
            List<?> listZzb = ((zzfc) iterable).zzb();
            zzfc zzfcVar = (zzfc) list;
            int size = list.size();
            for (Object obj : listZzb) {
                if (obj == null) {
                    int size2 = zzfcVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzfcVar.size() - 1; size3 >= size; size3--) {
                        zzfcVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzdj) {
                    zzfcVar.zza((zzdj) obj);
                } else {
                    zzfcVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzge) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }
}
