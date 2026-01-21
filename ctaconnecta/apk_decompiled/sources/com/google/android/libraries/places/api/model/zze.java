package com.google.android.libraries.places.api.model;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zze extends AuthorAttribution {
    private final String zza;
    private final String zzb;
    private final String zzc;

    zze(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthorAttribution) {
            AuthorAttribution authorAttribution = (AuthorAttribution) obj;
            if (this.zza.equals(authorAttribution.getName()) && ((str = this.zzb) != null ? str.equals(authorAttribution.getUri()) : authorAttribution.getUri() == null) && ((str2 = this.zzc) != null ? str2.equals(authorAttribution.getPhotoUri()) : authorAttribution.getPhotoUri() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String getName() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String getPhotoUri() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String getUri() {
        return this.zzb;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzc;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "AuthorAttribution{name=" + this.zza + ", uri=" + this.zzb + ", photoUri=" + this.zzc + "}";
    }
}
