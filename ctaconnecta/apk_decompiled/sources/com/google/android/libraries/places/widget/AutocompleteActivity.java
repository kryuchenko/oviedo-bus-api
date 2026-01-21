package com.google.android.libraries.places.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.widget.internal.ui.AutocompleteImplFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class AutocompleteActivity extends AppCompatActivity implements PlaceSelectionListener {
    public static final int RESULT_ERROR = 2;
    private int zza;
    private int zzb;
    private boolean zzc;

    public AutocompleteActivity() {
        super(R.layout.places_autocomplete_activity);
        this.zzc = false;
    }

    private final void zzc(int i, Place place, Status status) {
        try {
            Intent intent = new Intent();
            if (place != null) {
                intent.putExtra("places/selected_place", place);
            }
            intent.putExtra("places/status", status);
            setResult(i, intent);
            finish();
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            zzmt.zzp(Places.isInitialized(), "Places must be initialized.");
            zzmt.zzp(getCallingActivity() != null, "Cannot find caller. startActivityForResult should be used.");
            zzkt zzktVar = (zzkt) getIntent().getParcelableExtra("places/AutocompleteOptions");
            if (zzktVar == null) {
                throw null;
            }
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int iOrdinal = zzktVar.zzh().ordinal();
            if (iOrdinal == 0) {
                this.zza = R.layout.places_autocomplete_impl_fragment_fullscreen;
                this.zzb = R.style.PlacesAutocompleteFullscreen;
            } else if (iOrdinal == 1) {
                this.zza = R.layout.places_autocomplete_impl_fragment_overlay;
                this.zzb = R.style.PlacesAutocompleteOverlay;
            }
            getSupportFragmentManager().setFragmentFactory(new com.google.android.libraries.places.widget.internal.ui.zzh(this.zza, this, zzktVar));
            setTheme(this.zzb);
            super.onCreate(bundle);
            final AutocompleteImplFragment autocompleteImplFragment = (AutocompleteImplFragment) getSupportFragmentManager().findFragmentById(R.id.places_autocomplete_content);
            zzmt.zzo(autocompleteImplFragment != null);
            autocompleteImplFragment.zzh(this);
            final View viewFindViewById = findViewById(android.R.id.content);
            viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.libraries.places.widget.zza
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.zza.zzb(autocompleteImplFragment, viewFindViewById, view, motionEvent);
                }
            });
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.zza.zza(view);
                }
            });
            if (zzktVar.zzj().isEmpty()) {
                zzc(2, null, new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty."));
            }
        } catch (Error | RuntimeException e) {
            zzkd.zzb(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public void onError(Status status) {
        zzc(true != status.isCanceled() ? 2 : 0, null, status);
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public void onPlaceSelected(Place place) {
        zzc(-1, place, Status.RESULT_SUCCESS);
    }

    final /* synthetic */ void zza(View view) {
        if (this.zzc) {
            zzc(0, null, new Status(16));
        }
    }

    final /* synthetic */ boolean zzb(AutocompleteImplFragment autocompleteImplFragment, View view, View view2, MotionEvent motionEvent) {
        this.zzc = false;
        if (autocompleteImplFragment.getView() == null || motionEvent.getY() <= r1.getBottom()) {
            return false;
        }
        this.zzc = true;
        view.performClick();
        return true;
    }
}
