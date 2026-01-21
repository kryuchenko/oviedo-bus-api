package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzmt;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class AuthorAttribution implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public AuthorAttribution build() {
            zzmt.zzf(!zzb().getName().isEmpty(), "Name must not be empty.");
            return zzb();
        }

        public abstract String getPhotoUri();

        public abstract String getUri();

        public abstract Builder setPhotoUri(String str);

        public abstract Builder setUri(String str);

        abstract AuthorAttribution zzb();
    }

    public static Builder builder(String str) {
        zzd zzdVar = new zzd();
        zzdVar.zza(str);
        return zzdVar;
    }

    public abstract String getName();

    public abstract String getPhotoUri();

    public abstract String getUri();
}
