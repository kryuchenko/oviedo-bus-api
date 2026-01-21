package com.iecisa.ctausuario.ui.userdestination;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.maputils.BoundLocationManager;
import com.iecisa.ctausuario.utils.maputils.MapUtils;
import java.util.Arrays;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class DestinationUserSelectorActivity extends CustomToolbarActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private ActivityResultLauncher<Intent> autocompleteLauncher;

    @BindView(R.id.clSnackBarTop)
    ConstraintLayout clSnackBarTop;
    private GoogleMap googleMap;

    @BindView(R.id.ivUserLocation)
    ImageView ivUserLocation;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvLabelEnterDirection)
    TextView tvLabelEnterDirection;

    @BindView(R.id.tvMessageSnackBarTop)
    TextView tvMessageSnackBarTop;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    final Handler handler = new Handler();
    private SearchAddress searchAddress = new SearchAddress();

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_destination_user_selector;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        if (getIntent().getExtras() != null) {
            boolean booleanExtra = getIntent().getBooleanExtra(Constants.IntentData.INTENT_ADDRESS_PICKER, true);
            setToolbarWithSubtitle(this.toolbar, ToolbarActions.BACK, getString(booleanExtra ? R.string.title_toolbar_user_destination : R.string.title_toolbar_user_origin), getString(R.string.label_use_zoom));
            this.tvMessageSnackBarTop.setText(getString(booleanExtra ? R.string.label_touch_map_to_select_destination : R.string.label_touch_map_to_select_origin));
        }
        this.autocompleteLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$initializeView$0((ActivityResult) obj);
            }
        });
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeView$0(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        if (activityResult.getResultCode() == -1) {
            updateSearchAdress(MapUtils.buildSearchAddress(Autocomplete.getPlaceFromIntent(data), this));
        } else if (activityResult.getResultCode() == 2) {
            Timber.e(Autocomplete.getStatusFromIntent(data).getStatusMessage(), new Object[0]);
        }
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.googleMap.setMyLocationEnabled(true);
        }
        checkPermissions();
        this.googleMap.setOnMarkerClickListener(this);
        this.googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                this.f$0.lambda$onMapReady$1();
            }
        });
        this.googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback
            public final void onMapLoaded() {
                this.f$0.lambda$onMapReady$2();
            }
        });
        this.googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public final void onMapLongClick(LatLng latLng) {
                this.f$0.lambda$onMapReady$3(latLng);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$2() {
        showLocation(obtainCurrentLocation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMapReady$3(LatLng latLng) {
        this.googleMap.clear();
        SearchAddress searchAddressBuildSearchAddress = MapUtils.buildSearchAddress(MapUtils.getAddressByCoordinates(latLng.latitude, latLng.longitude, this));
        this.searchAddress = searchAddressBuildSearchAddress;
        if (searchAddressBuildSearchAddress != null) {
            this.tvLabelEnterDirection.setText(searchAddressBuildSearchAddress.getNameAddress());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(this.searchAddress.getNameAddress());
            markerOptions.icon(MapUtils.getSelectedDestinationMarker(this));
            this.googleMap.addMarker(markerOptions).showInfoWindow();
        }
    }

    private void showLocation(LatLng location) {
        this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15.0f));
    }

    private LatLng obtainCurrentLocation() {
        LatLng latLng = this.googleMap.getCameraPosition().target;
        return !BaseUtils.isValidLocation(Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude)) ? new LatLng(43.3623743d, -5.8484256d) : latLng;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        setResult(0, new Intent());
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new Intent());
        finish();
    }

    @OnClick({R.id.ivUserLocation, R.id.mbGoToGoogleMaps, R.id.tvLabelEnterDirection})
    public void onEventClick(View view) {
        int id = view.getId();
        if (id == R.id.ivUserLocation) {
            getLocationUpdates();
        } else if (id == R.id.mbGoToGoogleMaps) {
            goBackToActivity();
        } else {
            if (id != R.id.tvLabelEnterDirection) {
                return;
            }
            intentPlaceAutocomplete();
        }
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                return;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                return;
            }
        }
        getLocationUpdates();
        this.googleMap.setMyLocationEnabled(true);
        this.ivUserLocation.setVisibility(0);
    }

    private void getLocationUpdates() {
        BoundLocationManager.getInstance(getApplicationContext()).observe(this, new Observer<Location>() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Location location) {
                if (location != null) {
                    DestinationUserSelectorActivity.this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15.0f));
                    BoundLocationManager.getInstance(DestinationUserSelectorActivity.this.getApplicationContext()).removeObserver(this);
                } else {
                    DestinationUserSelectorActivity destinationUserSelectorActivity = DestinationUserSelectorActivity.this;
                    destinationUserSelectorActivity.showKoDialog(destinationUserSelectorActivity.getString(R.string.error_unable_establish_user_location));
                }
            }
        });
    }

    private void intentPlaceAutocomplete() {
        this.autocompleteLauncher.launch(new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME)).setLocationRestriction(RectangularBounds.newInstance(new LatLng(Constants.MapBorder.South.doubleValue(), Constants.MapBorder.East.doubleValue()), new LatLng(Constants.MapBorder.North.doubleValue(), Constants.MapBorder.West.doubleValue()))).build(this));
    }

    private void updateSearchAdress(SearchAddress address) {
        this.searchAddress = address;
        this.tvLabelEnterDirection.setText(address.getNameAddress());
        this.googleMap.clear();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(this.searchAddress.getLatitude().doubleValue(), this.searchAddress.getLongitude().doubleValue()));
        markerOptions.title(this.searchAddress.getNameAddress());
        markerOptions.icon(MapUtils.getSelectedDestinationMarker(this));
        this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.searchAddress.getLatitude().doubleValue(), this.searchAddress.getLongitude().doubleValue()), 15.0f));
        this.googleMap.addMarker(markerOptions).showInfoWindow();
    }

    private void goBackToActivity() {
        SearchAddress searchAddress = this.searchAddress;
        if (searchAddress != null && searchAddress.getLatitude() != null && this.searchAddress.getLongitude() != null) {
            Intent intent = new Intent();
            intent.putExtra(Constants.IntentData.INTENT_USER_DESTINATION, this.searchAddress);
            setResult(-1, intent);
            finish();
            return;
        }
        setResult(0, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showMessageToShowStops, reason: merged with bridge method [inline-methods] */
    public void lambda$onMapReady$1() {
        this.clSnackBarTop.setVisibility(0);
        this.handler.postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showMessageToShowStops$4();
            }
        }, Constants.MapStops.SHOW_STOPS_MESSAGE_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMessageToShowStops$4() {
        this.clSnackBarTop.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String message) {
        BaseUtils.showKoDialog(this, message);
    }
}
