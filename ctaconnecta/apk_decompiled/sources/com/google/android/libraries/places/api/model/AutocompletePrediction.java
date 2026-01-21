package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zznx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class AutocompletePrediction implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public AutocompletePrediction build() {
            AutocompletePrediction autocompletePredictionZze = zze();
            setPlaceTypes(zznx.zzj(autocompletePredictionZze.getPlaceTypes()));
            setTypes(zznx.zzj(autocompletePredictionZze.getTypes()));
            zza(zznx.zzj(autocompletePredictionZze.zzd()));
            zzc(zznx.zzj(autocompletePredictionZze.zze()));
            zzd(zznx.zzj(autocompletePredictionZze.zzf()));
            return zze();
        }

        public abstract Integer getDistanceMeters();

        public abstract String getFullText();

        public abstract List<Place.Type> getPlaceTypes();

        public abstract String getPrimaryText();

        public abstract String getSecondaryText();

        public abstract List<String> getTypes();

        public abstract Builder setDistanceMeters(Integer num);

        public abstract Builder setFullText(String str);

        public abstract Builder setPlaceTypes(List<Place.Type> list);

        public abstract Builder setPrimaryText(String str);

        public abstract Builder setSecondaryText(String str);

        public abstract Builder setTypes(List<String> list);

        public abstract Builder zza(List list);

        abstract Builder zzb(String str);

        public abstract Builder zzc(List list);

        public abstract Builder zzd(List list);

        abstract AutocompletePrediction zze();
    }

    public static Builder builder(String str) {
        zzg zzgVar = new zzg();
        zzgVar.zza(new ArrayList());
        zzgVar.zzb(str);
        zzgVar.setPlaceTypes(new ArrayList());
        zzgVar.zzc(new ArrayList());
        zzgVar.zzd(new ArrayList());
        zzgVar.setTypes(new ArrayList());
        zzgVar.setFullText("");
        zzgVar.setPrimaryText("");
        zzgVar.setSecondaryText("");
        return zzgVar;
    }

    private static final SpannableString zzg(String str, List list, CharacterStyle characterStyle) {
        SpannableString spannableString = new SpannableString(str);
        if (str.length() != 0 && characterStyle != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzby zzbyVar = (zzby) it.next();
                spannableString.setSpan(CharacterStyle.wrap(characterStyle), zzbyVar.zzb(), zzbyVar.zzb() + zzbyVar.zza(), 0);
            }
        }
        return spannableString;
    }

    public abstract Integer getDistanceMeters();

    public SpannableString getFullText(CharacterStyle characterStyle) {
        return zzg(zza(), zzd(), characterStyle);
    }

    public abstract String getPlaceId();

    @Deprecated
    public abstract List<Place.Type> getPlaceTypes();

    public SpannableString getPrimaryText(CharacterStyle characterStyle) {
        return zzg(zzb(), zze(), characterStyle);
    }

    public SpannableString getSecondaryText(CharacterStyle characterStyle) {
        return zzg(zzc(), zzf(), characterStyle);
    }

    public abstract List<String> getTypes();

    abstract String zza();

    abstract String zzb();

    abstract String zzc();

    abstract List zzd();

    abstract List zze();

    abstract List zzf();
}
