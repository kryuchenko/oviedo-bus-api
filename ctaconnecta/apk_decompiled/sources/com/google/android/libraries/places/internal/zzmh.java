package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzmh {
    private final String zza;

    private zzmh(String str) {
        this.zza = str;
    }

    public static zzmh zzb(char c) {
        return new zzmh(",");
    }

    public static zzmh zzc(String str) {
        return new zzmh(str);
    }

    static final CharSequence zzh(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Appendable zza(Appendable appendable, Iterator it) throws IOException {
        if (it.hasNext()) {
            appendable.append(zzh(it.next()));
            while (it.hasNext()) {
                appendable.append(this.zza);
                appendable.append(zzh(it.next()));
            }
        }
        return appendable;
    }

    public final zzmh zzd() {
        return new zzme(this, this);
    }

    public final String zzf(Iterable iterable) {
        Iterator it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        zzg(sb, it);
        return sb.toString();
    }

    public final StringBuilder zzg(StringBuilder sb, Iterator it) {
        try {
            zza(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
