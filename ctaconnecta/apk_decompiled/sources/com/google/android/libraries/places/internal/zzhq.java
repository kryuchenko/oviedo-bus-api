package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
final class zzhq {
    private String description;
    private Integer distanceMeters;
    private zzb[] matchedSubstrings;
    private String placeId;
    private zza structuredFormatting;
    private String[] types;

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zza {
        private String mainText;
        private zzb[] mainTextMatchedSubstrings;
        private String secondaryText;
        private zzb[] secondaryTextMatchedSubstrings;

        zza() {
        }

        final zznx zza() {
            zzb[] zzbVarArr = this.mainTextMatchedSubstrings;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        final zznx zzb() {
            zzb[] zzbVarArr = this.secondaryTextMatchedSubstrings;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        final String zzc() {
            return this.mainText;
        }

        final String zzd() {
            return this.secondaryText;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    class zzb {
        Integer length;
        Integer offset;

        zzb() {
        }
    }

    zzhq() {
    }

    final zza zza() {
        return this.structuredFormatting;
    }

    final zznx zzb() {
        zzb[] zzbVarArr = this.matchedSubstrings;
        return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
    }

    final zznx zzc() {
        String[] strArr = this.types;
        return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
    }

    final Integer zzd() {
        return this.distanceMeters;
    }

    final String zze() {
        return this.description;
    }

    final String zzf() {
        return this.placeId;
    }
}
