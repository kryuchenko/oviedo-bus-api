package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzmt;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class PhotoMetadata implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public PhotoMetadata build() {
            PhotoMetadata photoMetadataZzc = zzc();
            int width = photoMetadataZzc.getWidth();
            zzmt.zzq(width >= 0, "Width must not be < 0, but was: %s.", width);
            int height = photoMetadataZzc.getHeight();
            zzmt.zzq(height >= 0, "Height must not be < 0, but was: %s.", height);
            zzmt.zzp(!photoMetadataZzc.zzb().isEmpty(), "PhotoReference must not be null or empty.");
            return photoMetadataZzc;
        }

        public abstract String getAttributions();

        public abstract AuthorAttributions getAuthorAttributions();

        public abstract int getHeight();

        public abstract int getWidth();

        public abstract Builder setAttributions(String str);

        public abstract Builder setAuthorAttributions(AuthorAttributions authorAttributions);

        public abstract Builder setHeight(int i);

        public abstract Builder setWidth(int i);

        public abstract Builder zza(String str);

        abstract PhotoMetadata zzc();
    }

    public static Builder builder(String str) {
        zzu zzuVar = new zzu();
        zzuVar.zzb(str);
        zzuVar.setWidth(0);
        zzuVar.setHeight(0);
        zzuVar.setAttributions("");
        return zzuVar;
    }

    public abstract String getAttributions();

    public abstract AuthorAttributions getAuthorAttributions();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String zza();

    public abstract String zzb();
}
