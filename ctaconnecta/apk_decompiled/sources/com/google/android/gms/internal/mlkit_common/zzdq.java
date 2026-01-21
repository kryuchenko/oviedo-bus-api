package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdp;
import com.google.android.gms.internal.mlkit_common.zzdq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdq<MessageType extends zzdq<MessageType, BuilderType>, BuilderType extends zzdp<MessageType, BuilderType>> implements zzgh {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.mlkit_common.zzgh
    public final zzdv zze() {
        try {
            zzed zzedVarZzc = zzdv.zzc(zzj());
            zza(zzedVarZzc.zzb());
            return zzedVarZzc.zza();
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
            zzem zzemVarZza = zzem.zza(bArr);
            zza(zzemVarZza);
            zzemVarZza.zzb();
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
        zzfc.zza(iterable);
        if (iterable instanceof zzfs) {
            List<?> listZzd = ((zzfs) iterable).zzd();
            zzfs zzfsVar = (zzfs) list;
            int size = list.size();
            for (Object obj : listZzd) {
                if (obj == null) {
                    int size2 = zzfsVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzfsVar.size() - 1; size3 >= size; size3--) {
                        zzfsVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzdv) {
                    zzfsVar.zza((zzdv) obj);
                } else {
                    zzfsVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzgu) {
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
