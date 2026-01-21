package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzja<FieldDescriptorType> extends zzjb<FieldDescriptorType, Object> {
    zzja(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.zzjb
    public final void zzdq() {
        if (!isImmutable()) {
            for (int i = 0; i < zzhy(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryZzbv = zzbv(i);
                if (((zzgp) entryZzbv.getKey()).zzfv()) {
                    entryZzbv.setValue(Collections.unmodifiableList((List) entryZzbv.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzhz()) {
                if (((zzgp) entry.getKey()).zzfv()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzdq();
    }
}
