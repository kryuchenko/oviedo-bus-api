package com.google.android.libraries.places.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzkr;
import com.google.android.libraries.places.internal.zzks;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzkw;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class Autocomplete {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static class IntentBuilder {
        private final zzks zza;

        public IntentBuilder(zzkt zzktVar) {
            this.zza = zzktVar.zzg();
        }

        public IntentBuilder(AutocompleteActivityMode autocompleteActivityMode, List<Place.Field> list) {
            this.zza = zzkt.zzo(autocompleteActivityMode, list, zzkr.INTENT);
        }

        public Intent build(Context context) {
            try {
                Intent intent = new Intent(context, (Class<?>) AutocompleteActivity.class);
                zzks zzksVar = this.zza;
                Resources.Theme theme = context.getTheme();
                TypedValue typedValue = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                    zzksVar.zzi(typedValue.data);
                }
                TypedValue typedValue2 = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue2, true)) {
                    zzksVar.zzj(typedValue2.data);
                }
                intent.putExtra("places/AutocompleteOptions", this.zza.zzn());
                return intent;
            } catch (Error | RuntimeException e) {
                zzkd.zzb(e);
                throw e;
            }
        }

        public IntentBuilder setCountries(List<String> list) {
            this.zza.zza(list);
            return this;
        }

        @Deprecated
        public IntentBuilder setCountry(String str) {
            this.zza.zzo(str);
            return this;
        }

        public IntentBuilder setHint(String str) {
            this.zza.zzb(str);
            return this;
        }

        public IntentBuilder setInitialQuery(String str) {
            this.zza.zzc(str);
            return this;
        }

        public IntentBuilder setLocationBias(LocationBias locationBias) {
            this.zza.zzd(locationBias);
            return this;
        }

        public IntentBuilder setLocationRestriction(LocationRestriction locationRestriction) {
            this.zza.zze(locationRestriction);
            return this;
        }

        public IntentBuilder setRegionCode(String str) {
            this.zza.zzk(str);
            return this;
        }

        @Deprecated
        public IntentBuilder setTypeFilter(TypeFilter typeFilter) {
            this.zza.zzl(typeFilter);
            return this;
        }

        public IntentBuilder setTypesFilter(List<String> list) {
            this.zza.zzm(list);
            return this;
        }

        public final IntentBuilder zza(zzkr zzkrVar) {
            this.zza.zzg(zzkrVar);
            return this;
        }
    }

    private Autocomplete() {
    }

    public static Place getPlaceFromIntent(Intent intent) {
        return zzkw.zzb(intent);
    }

    public static Status getStatusFromIntent(Intent intent) {
        return zzkw.zza(intent);
    }
}
