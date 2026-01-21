package com.google.android.libraries.places.internal;

import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzoz extends zzpb {
    private final char[][] zza;
    private final int zzb;
    private final char zzc;

    protected zzoz(zzpa zzpaVar, char c, char c2) {
        char[][] cArrZzb = zzpaVar.zzb();
        this.zza = cArrZzb;
        this.zzb = cArrZzb.length;
        this.zzc = CharCompanionObject.MAX_VALUE;
    }

    @Override // com.google.android.libraries.places.internal.zzpb
    @CheckForNull
    protected final char[] zzb(char c) {
        char[] cArr;
        if (c >= this.zzb || (cArr = this.zza[c]) == null) {
            return null;
        }
        return cArr;
    }

    @Override // com.google.android.libraries.places.internal.zzpb, com.google.android.libraries.places.internal.zzpd
    public final String zza(String str) {
        str.getClass();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < this.zzb && this.zza[cCharAt] != null) || cCharAt > this.zzc) {
                return zzc(str, i);
            }
        }
        return str;
    }
}
