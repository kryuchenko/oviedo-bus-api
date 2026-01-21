package com.google.android.libraries.places.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzbwz {
    public static final int zza(zzbwp zzbwpVar, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(zzbwpVar, "<this>");
        int[] iArrZzq = zzbwpVar.zzq();
        int length = zzbwpVar.zzr().length;
        Intrinsics.checkNotNullParameter(iArrZzq, "<this>");
        int i3 = length - 1;
        int i4 = 0;
        while (true) {
            if (i4 <= i3) {
                int i5 = i + 1;
                i2 = (i4 + i3) >>> 1;
                int i6 = iArrZzq[i2];
                if (i6 >= i5) {
                    if (i6 <= i5) {
                        break;
                    }
                    i3 = i2 - 1;
                } else {
                    i4 = i2 + 1;
                }
            } else {
                i2 = (-i4) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : ~i2;
    }
}
