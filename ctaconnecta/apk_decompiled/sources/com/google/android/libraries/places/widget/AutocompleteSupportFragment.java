package com.google.android.libraries.places.widget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzkr;
import com.google.android.libraries.places.internal.zzks;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzkw;
import com.google.android.libraries.places.internal.zznx;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class AutocompleteSupportFragment extends Fragment {
    private final MutableLiveData zza;
    private final MutableLiveData zzb;
    private zzks zzc;
    private PlaceSelectionListener zzd;

    public AutocompleteSupportFragment() {
        super(R.layout.places_autocomplete_fragment);
        this.zza = new MutableLiveData();
        this.zzb = new MutableLiveData();
        this.zzc = zzkt.zzo(AutocompleteActivityMode.OVERLAY, zznx.zzl(), zzkr.FRAGMENT);
    }

    public static AutocompleteSupportFragment newInstance() {
        return new AutocompleteSupportFragment();
    }

    static /* synthetic */ void zzd(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setHint(charSequence);
            view.setContentDescription(charSequence);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    private final void zze() {
        Intent intentBuild = new Autocomplete.IntentBuilder(this.zzc.zzn()).build(requireContext());
        if (requireView().isEnabled()) {
            requireView().setEnabled(false);
            startActivityForResult(intentBuild, 30421);
        }
    }

    private final void zzf(View view) {
        view.setVisibility(true != TextUtils.isEmpty((CharSequence) this.zza.getValue()) ? 0 : 8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 30421) {
            try {
                PlaceSelectionListener placeSelectionListener = this.zzd;
                if (placeSelectionListener == null) {
                    if (Log.isLoggable("Places", 5)) {
                        Log.w("Places", "No PlaceSelectionListener is set. No result will be delivered.");
                    }
                } else if (intent == null) {
                    if (Log.isLoggable("Places", 6)) {
                        Log.e("Places", "Intent data was null.");
                    }
                } else {
                    if (i2 != -1) {
                        placeSelectionListener.onError(Autocomplete.getStatusFromIntent(intent));
                        return;
                    }
                    Place placeFromIntent = Autocomplete.getPlaceFromIntent(intent);
                    placeSelectionListener.onPlaceSelected(placeFromIntent);
                    setText(placeFromIntent.getName());
                }
            } catch (Error | RuntimeException e) {
                zzkd.zzb(e);
                throw e;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                zzkt zzktVar = (zzkt) bundle.getParcelable("options");
                if (zzktVar == null) {
                    return;
                }
                if (this.zza.getValue() == 0) {
                    this.zza.postValue(zzktVar.zzm());
                }
                if (this.zzb.getValue() == 0) {
                    this.zzb.postValue(zzktVar.zzl());
                }
                this.zzc = zzktVar.zzg();
            } catch (Error | RuntimeException e) {
                zzkd.zzb(e);
                throw e;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireView().setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("options", this.zzc.zzn());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        final View viewFindViewById = view.findViewById(R.id.places_autocomplete_search_button);
        final View viewFindViewById2 = view.findViewById(R.id.places_autocomplete_clear_button);
        final EditText editText = (EditText) view.findViewById(R.id.places_autocomplete_search_input);
        editText.setHint(zzkw.zzc(requireContext(), R.string.places_autocomplete_search_hint));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zze
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.zza.zza(view2);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.zza.zzb(view2);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.zza.setText(null);
            }
        });
        zzf(viewFindViewById2);
        this.zza.observe(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.zzh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.zza.zzc(editText, viewFindViewById2, (CharSequence) obj);
            }
        });
        this.zzb.observe(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.zzi
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AutocompleteSupportFragment.zzd(editText, viewFindViewById, (CharSequence) obj);
            }
        });
    }

    public AutocompleteSupportFragment setActivityMode(AutocompleteActivityMode autocompleteActivityMode) {
        this.zzc.zzf(autocompleteActivityMode);
        return this;
    }

    public AutocompleteSupportFragment setCountries(List<String> list) {
        this.zzc.zza(list);
        return this;
    }

    @Deprecated
    public AutocompleteSupportFragment setCountry(String str) {
        this.zzc.zzo(str);
        return this;
    }

    public AutocompleteSupportFragment setHint(CharSequence charSequence) {
        try {
            if (charSequence != null) {
                this.zzc.zzb(charSequence.toString());
                this.zzb.postValue(charSequence);
                return this;
            }
            String string = getString(R.string.places_autocomplete_search_hint);
            this.zzc.zzb(string);
            this.zzb.postValue(string);
            return this;
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public AutocompleteSupportFragment setLocationBias(LocationBias locationBias) {
        this.zzc.zzd(locationBias);
        return this;
    }

    public AutocompleteSupportFragment setLocationRestriction(LocationRestriction locationRestriction) {
        this.zzc.zze(locationRestriction);
        return this;
    }

    public AutocompleteSupportFragment setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.zzd = placeSelectionListener;
        return this;
    }

    public AutocompleteSupportFragment setPlaceFields(List<Place.Field> list) {
        this.zzc.zzh(list);
        return this;
    }

    public AutocompleteSupportFragment setRegionCode(String str) {
        this.zzc.zzk(str);
        return this;
    }

    public AutocompleteSupportFragment setText(CharSequence charSequence) {
        try {
            this.zzc.zzc(TextUtils.isEmpty(charSequence) ? null : charSequence.toString());
            this.zza.postValue(charSequence);
            return this;
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    @Deprecated
    public AutocompleteSupportFragment setTypeFilter(TypeFilter typeFilter) {
        this.zzc.zzl(typeFilter);
        return this;
    }

    public AutocompleteSupportFragment setTypesFilter(List<String> list) {
        this.zzc.zzm(list);
        return this;
    }

    final /* synthetic */ void zza(View view) {
        zze();
    }

    final /* synthetic */ void zzb(View view) {
        zze();
    }

    final /* synthetic */ void zzc(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setText(charSequence);
            zzf(view);
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    public AutocompleteSupportFragment setCountries(String... strArr) {
        this.zzc.zza(zznx.zzk(strArr));
        return this;
    }
}
