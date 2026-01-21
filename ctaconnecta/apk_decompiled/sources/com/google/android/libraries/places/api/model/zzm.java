package com.google.android.libraries.places.api.model;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzm extends zzca {
    private int zza;
    private int zzb;
    private int zzc;
    private byte zzd;

    zzm() {
    }

    @Override // com.google.android.libraries.places.api.model.zzca
    final zzca zza(int i) {
        this.zzc = i;
        this.zzd = (byte) (this.zzd | 4);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzca
    final zzca zzb(int i) {
        this.zzb = i;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    final zzca zzc(int i) {
        this.zza = i;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.zzca
    final LocalDate zzd() {
        if (this.zzd == 7) {
            return new zzba(this.zza, this.zzb, this.zzc);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzd & 1) == 0) {
            sb.append(" year");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" month");
        }
        if ((this.zzd & 4) == 0) {
            sb.append(" day");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
