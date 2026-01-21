package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zzrz;
import com.google.android.libraries.places.internal.zzsa;
import com.google.android.libraries.places.internal.zzsb;
import com.google.android.libraries.places.internal.zzsc;
import com.iecisa.ctausuario.utils.Constants;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class Review implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public Review build() {
            Double rating = zzd().getRating();
            boolean z = false;
            if (rating.doubleValue() >= 1.0d && rating.doubleValue() <= 5.0d) {
                z = true;
            }
            zzmt.zzj(z, "Rating must between 1.0 and 5.0 (inclusive), but was: %s.", rating);
            return zzd();
        }

        public abstract String getOriginalText();

        public abstract String getOriginalTextLanguageCode();

        public abstract String getPublishTime();

        public abstract String getRelativePublishTimeDescription();

        public abstract String getText();

        public abstract String getTextLanguageCode();

        public abstract Builder setOriginalText(String str);

        public abstract Builder setOriginalTextLanguageCode(String str);

        public abstract Builder setPublishTime(String str);

        public abstract Builder setRelativePublishTimeDescription(String str);

        public abstract Builder setText(String str);

        public abstract Builder setTextLanguageCode(String str);

        abstract Builder zza(String str);

        abstract Builder zzb(AuthorAttribution authorAttribution);

        abstract Review zzd();
    }

    public static Builder builder(Double d, AuthorAttribution authorAttribution) {
        String strZzc = zznb.zzc(authorAttribution.getUri());
        if (strZzc.startsWith("//")) {
            strZzc = Constants.Routes.ROUTE_HTTP.concat(strZzc);
        }
        zzsa zzsaVar = new zzsa("a");
        int i = zzsc.zza;
        zzsaVar.zzc(zzsc.zza(strZzc, zzsb.zza));
        zzsaVar.zzb(authorAttribution.getName());
        zzrz zzrzVarZza = zzsaVar.zza();
        zzad zzadVar = new zzad();
        zzadVar.zzc(d);
        zzadVar.zzb(authorAttribution);
        zzadVar.zza(zzrzVarZza.zza());
        return zzadVar;
    }

    public abstract String getAttribution();

    public abstract AuthorAttribution getAuthorAttribution();

    public abstract String getOriginalText();

    public abstract String getOriginalTextLanguageCode();

    public abstract String getPublishTime();

    public abstract Double getRating();

    public abstract String getRelativePublishTimeDescription();

    public abstract String getText();

    public abstract String getTextLanguageCode();
}
