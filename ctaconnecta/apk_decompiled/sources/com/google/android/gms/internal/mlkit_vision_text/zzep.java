package com.google.android.gms.internal.mlkit_vision_text;

import com.google.android.gms.internal.mlkit_vision_text.zzeo;
import com.google.android.gms.internal.mlkit_vision_text.zzep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public abstract class zzep<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> implements zzhg {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzhg
    public final zzeu zze() {
        try {
            zzfc zzfcVarZzc = zzeu.zzc(zzj());
            zza(zzfcVarZzc.zzb());
            return zzfcVarZzc.zza();
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
            zzfl zzflVarZza = zzfl.zza(bArr);
            zza(zzflVarZza);
            zzflVarZza.zzb();
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
        zzgb.zza(iterable);
        if (iterable instanceof zzgr) {
            List<?> listZzd = ((zzgr) iterable).zzd();
            zzgr zzgrVar = (zzgr) list;
            int size = list.size();
            for (Object obj : listZzd) {
                if (obj == null) {
                    int size2 = zzgrVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzgrVar.size() - 1; size3 >= size; size3--) {
                        zzgrVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzeu) {
                    zzgrVar.zza((zzeu) obj);
                } else {
                    zzgrVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzht) {
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
