package com.iecisa.ctausuario.ui.main.stops.mapstops;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spanned;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.maputils.BoundLocationManager;
import com.iecisa.ctausuario.utils.maputils.ClusterableAndNonClusterableMapStopAlgorithm;
import com.iecisa.ctausuario.utils.maputils.HtmlUtils;
import com.iecisa.ctausuario.utils.maputils.MapUtils;
import com.iecisa.ctausuario.utils.maputils.MarkerClusterRenderer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class MapStopsFragment extends BaseFragment implements OnMapReadyCallback {
    private static final MapStop CURRENT_LOCATION_MAP_ITEM = new MapStop(0, "Posición actual");

    @BindView(R.id.clSnackBarTop)
    ConstraintLayout clSnackBarTop;

    @BindView(R.id.clStopsToDestination)
    ConstraintLayout clStopsToDestination;

    @BindView(R.id.clSwipeNoDirectConnections)
    ConstraintLayout clSwipeNoDirectConnections;

    @BindView(R.id.clSwipeStop)
    ConstraintLayout clSwipeStop;
    private GoogleMap googleMap;

    @BindView(R.id.ivCloseStopData)
    ImageView ivCloseStopData;

    @BindView(R.id.ivRemoveUserDestination)
    ImageView ivRemoveDestination;

    @BindView(R.id.ivUserLocation)
    ImageView ivUserLocation;
    private CameraPosition lastMapCameraPositon;
    private ClusterManagerWrapper mapClusterManager;
    private MapStop mapStopSelected;
    private MapStopsViewModel mapStopsViewModel;

    @BindView(R.id.swOnlyDestination)
    Switch swOnlyDestination;

    @BindView(R.id.tvLabelDestination)
    TextView tvLabelDestination;

    @BindView(R.id.tvLabelEnterDirection)
    TextView tvLabelEnterDirection;

    @BindView(R.id.tvMessageSnackBarTop)
    TextView tvMessageSnackBarTop;

    @BindView(R.id.tvStopName)
    TextView tvStopName;

    @BindView(R.id.tvStopNumber)
    TextView tvStopNumber;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private boolean stopsLoadedFistTime = false;
    private boolean mapLoadedFistTime = true;
    private final Handler handler = new Handler();
    private SearchAddress myDestinationSearchAddress = Constants.EMPTY_SEARCH_ADDRESS;
    private Set<MapStop> mapStopSet = new HashSet();
    private MapStop selectedLocationMapItem = CURRENT_LOCATION_MAP_ITEM;
    private ActivityResultLauncher<Intent> placeLauncher = null;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_map_stops;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.placeLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$onCreate$0((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(ActivityResult activityResult) {
        Intent data;
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        resultPlaceSearch(Autocomplete.getPlaceFromIntent(data));
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.mapStopsViewModel = (MapStopsViewModel) new ViewModelProvider(this, this.viewModelFactory).get(MapStopsViewModelImpl.class);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
        this.tvLabelDestination.setText(getMyDestinationName(null));
        setOnCheckedDestinationFilterSwitch();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.placeLauncher = null;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        ClusterManagerWrapper clusterManagerWrapper = new ClusterManagerWrapper(getActivity(), this.googleMap);
        this.mapClusterManager = clusterManagerWrapper;
        this.googleMap.setOnCameraIdleListener(clusterManagerWrapper);
        this.googleMap.setOnMarkerClickListener(this.mapClusterManager);
        this.googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        if (this.lastMapCameraPositon != null) {
            restoreMapState();
        } else {
            initUserLocation();
        }
        this.stopsLoadedFistTime = true;
        setupGoogleMapsListeners();
        updateLocationUIControls();
    }

    private void setupGoogleMapsListeners() {
        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                this.f$0.lambda$setupGoogleMapsListeners$1(latLng);
            }
        });
        this.googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
            public final void onMapLongClick(LatLng latLng) {
                this.f$0.lambda$setupGoogleMapsListeners$2(latLng);
            }
        });
        this.googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment.1
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public void onCameraMove() {
                MapStopsFragment mapStopsFragment = MapStopsFragment.this;
                mapStopsFragment.lastMapCameraPositon = mapStopsFragment.googleMap.getCameraPosition();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupGoogleMapsListeners$1(LatLng latLng) {
        MapUtils.animateSlideDown(getActivity(), this.clSwipeStop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupGoogleMapsListeners$2(LatLng latLng) {
        loadStopsOnMap(latLng, this.myDestinationSearchAddress, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAddress(LatLng location) {
        SearchAddress searchAddressBuildSearchAddress = MapUtils.buildSearchAddress(MapUtils.getAddressByCoordinates(location.latitude, location.longitude, getContext()));
        if (searchAddressBuildSearchAddress != null) {
            return searchAddressBuildSearchAddress.getNameAddress();
        }
        return "";
    }

    private void restoreMapState() {
        MapStopsFragment mapStopsFragment;
        this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.lastMapCameraPositon));
        if (this.mapStopSet.size() > 0) {
            mapStopsFragment = this;
            mapStopsFragment.addNewMapStopsToMap(new ArrayList(this.mapStopSet), true, this.myDestinationSearchAddress, 500.0d);
        } else {
            mapStopsFragment = this;
        }
        MapStop mapStop = mapStopsFragment.selectedLocationMapItem;
        if (mapStop == null || mapStop.getLocation() == null) {
            return;
        }
        mapStopsFragment.tvLabelEnterDirection.setText(getAddress(mapStopsFragment.selectedLocationMapItem.getLocation()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedLocation(LatLng placeLocation, String placeName) {
        this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(placeLocation, 15.0f));
        this.selectedLocationMapItem.setLocation(placeLocation);
        loadStopsOnMap(500.0d, placeLocation, this.myDestinationSearchAddress, true);
        this.tvLabelEnterDirection.setText(placeName);
    }

    @OnClick({R.id.ivUserLocation, R.id.tvLabelDestination, R.id.clSwipeStop, R.id.ivCloseStopData, R.id.tvLabelEnterDirection, R.id.ivRemoveUserDestination, R.id.ivCloseNoConnections})
    public void onEventClick(View view) {
        switch (view.getId()) {
            case R.id.clSwipeStop /* 2131362009 */:
                intentDetailStop();
                break;
            case R.id.ivCloseNoConnections /* 2131362280 */:
                this.clSwipeNoDirectConnections.setVisibility(8);
                break;
            case R.id.ivCloseStopData /* 2131362282 */:
                MapUtils.animateSlideDown(getActivity(), this.clSwipeStop);
                break;
            case R.id.ivRemoveUserDestination /* 2131362298 */:
                removeUserDestination();
                break;
            case R.id.ivUserLocation /* 2131362312 */:
                getLocationUpdates();
                break;
            case R.id.tvLabelDestination /* 2131362847 */:
                goToUserDestinationSelector();
                break;
            case R.id.tvLabelEnterDirection /* 2131362850 */:
                intentPlaceAutocomplete();
                break;
        }
    }

    private void intentDetailStop() {
        if (this.mapStopSelected != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) DetailStopActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL, this.mapStopSelected);
            intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, this.myDestinationSearchAddress);
            intent.putExtra(Constants.IntentData.INTENT_DESTINATION_FILTER_ENABLED, this.swOnlyDestination.isChecked());
            startActivityForResult(intent, 6);
        }
    }

    private void intentPlaceAutocomplete() {
        Intent intentBuild = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME)).setLocationRestriction(RectangularBounds.newInstance(new LatLng(Constants.MapBorder.South.doubleValue(), Constants.MapBorder.East.doubleValue()), new LatLng(Constants.MapBorder.North.doubleValue(), Constants.MapBorder.West.doubleValue()))).build(getContext());
        ActivityResultLauncher<Intent> activityResultLauncher = this.placeLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intentBuild);
        }
    }

    private void removeUserDestination() {
        this.myDestinationSearchAddress = Constants.EMPTY_SEARCH_ADDRESS;
        loadStopsCloseToUser();
        if (this.swOnlyDestination.isChecked()) {
            this.swOnlyDestination.setChecked(false);
        } else {
            this.ivRemoveDestination.setVisibility(8);
            this.tvLabelDestination.setText(getMyDestinationName(null));
        }
    }

    private void goToUserDestinationSelector() {
        Intent intent = new Intent(getActivity(), (Class<?>) DestinationUserSelectorActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_ADDRESS_PICKER, true);
        startActivityForResult(intent, 1);
    }

    private void initUserLocation() {
        if (!BoundLocationManager.isLocationEnabled(getActivity().getApplicationContext())) {
            requestLocationPermission();
        } else {
            getLocationUpdates();
        }
    }

    private void requestLocationPermission() {
        if (Build.VERSION.SDK_INT < 33) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.POST_NOTIFICATIONS"}, 1001);
        }
    }

    private void getLocationUpdates() {
        final Context applicationContext = getActivity().getApplicationContext();
        if (!BoundLocationManager.isLocationEnabled(applicationContext)) {
            setDefaultUserLocation();
        } else {
            BoundLocationManager.getInstance(applicationContext).observe(this, new Observer<Location>() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(Location location) {
                    if (location != null) {
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                        MapStopsFragment.this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                        MapStopsFragment mapStopsFragment = MapStopsFragment.this;
                        mapStopsFragment.updateSelectedLocation(latLng, mapStopsFragment.getAddress(latLng));
                        BoundLocationManager.getInstance(applicationContext).removeObserver(this);
                        return;
                    }
                    MapStopsFragment mapStopsFragment2 = MapStopsFragment.this;
                    mapStopsFragment2.showErrorDialog(mapStopsFragment2.getString(R.string.error_unable_establish_user_location));
                }
            });
        }
    }

    private void updateLocationUIControls() {
        if (BoundLocationManager.isLocationEnabled(getActivity().getApplicationContext())) {
            this.googleMap.setMyLocationEnabled(true);
            this.ivUserLocation.setVisibility(0);
        } else {
            this.googleMap.setMyLocationEnabled(false);
            this.ivUserLocation.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1001 && grantResults.length > 0 && grantResults[0] == 0) {
            this.stopsLoadedFistTime = true;
            updateLocationUIControls();
            getLocationUpdates();
            return;
        }
        setDefaultUserLocation();
    }

    private void setDefaultUserLocation() {
        updateSelectedLocation(new LatLng(43.3623743d, -5.8484256d), Constants.MapStops.DEFAULT_LOCATION_NAME);
    }

    private void loadStopsCloseToUser() {
        loadStopsCloseToUser(Constants.EMPTY_SEARCH_ADDRESS, true);
    }

    private void loadStopsCloseToUser(SearchAddress destinationAddress, boolean clearMapItems) {
        loadStopsOnMap(500.0d, this.selectedLocationMapItem.getLocation(), destinationAddress, clearMapItems);
    }

    private void loadStopsOnMap(LatLng originLocation, SearchAddress destinationAddress, boolean clearMapItems) {
        loadStopsOnMap(500.0d, originLocation, destinationAddress, clearMapItems);
    }

    private void loadStopsOnMap(final double radius, LatLng originLocation, final SearchAddress destinationAddress, final boolean clearMapItems) {
        this.mapStopsViewModel.getStops(originLocation, radius, getContext(), destinationAddress).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$loadStopsOnMap$3(clearMapItems, destinationAddress, radius, (Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStopsOnMap$3(boolean z, SearchAddress searchAddress, double d, Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            showLoading();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            hideLoading();
            Toast.makeText(getContext(), resource.message, 0).show();
            return;
        }
        if (resource.data != 0) {
            this.mapStopSet.addAll((Collection) resource.data);
        }
        addNewMapStopsToMap((List) resource.data, z, searchAddress, d);
        hideLoading();
    }

    private void addNewMapStopsToMap(List<MapStop> mapStops, boolean clearMapItems, SearchAddress destinationAddress, double radius) {
        if (clearMapItems) {
            this.mapClusterManager.clearItems();
            this.mapClusterManager.cluster();
        }
        boolean zAddItem = false;
        if (!mapStops.isEmpty()) {
            this.mapClusterManager.addItem(this.selectedLocationMapItem);
            for (MapStop mapStop : mapStops) {
                if (!this.mapClusterManager.contains(mapStop)) {
                    zAddItem = this.mapClusterManager.addItem(mapStop);
                }
            }
            if (zAddItem) {
                this.mapClusterManager.cluster();
                return;
            }
            return;
        }
        if (Constants.EMPTY_SEARCH_ADDRESS.equals(destinationAddress)) {
            showAdviceMessage(getString(R.string.label_error_map_find_stops, Double.valueOf(radius)));
        } else {
            this.clSwipeNoDirectConnections.setVisibility(0);
        }
    }

    private void showAdviceMessage(String message) {
        this.tvMessageSnackBarTop.setText(message);
        this.clSnackBarTop.setVisibility(0);
        this.handler.postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAdviceMessage$4();
            }
        }, Constants.MapStops.SHOW_STOPS_MESSAGE_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAdviceMessage$4() {
        this.clSnackBarTop.setVisibility(8);
        this.tvMessageSnackBarTop.setText("Toque y mantenga pulsado para actualizar el mapa.");
    }

    private void setOnCheckedDestinationFilterSwitch() {
        this.swOnlyDestination.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$setOnCheckedDestinationFilterSwitch$5(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnCheckedDestinationFilterSwitch$5(CompoundButton compoundButton, boolean z) {
        if (!Constants.EMPTY_SEARCH_ADDRESS.equals(this.myDestinationSearchAddress)) {
            this.ivRemoveDestination.setVisibility(0);
            if (z) {
                loadStopsCloseToUser(this.myDestinationSearchAddress, true);
                return;
            } else {
                loadStopsCloseToUser();
                return;
            }
        }
        if (z) {
            this.swOnlyDestination.setChecked(false);
            goToUserDestinationSelector();
        } else {
            this.ivRemoveDestination.setVisibility(8);
            this.tvLabelDestination.setText(getMyDestinationName(null));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            resultUserDestination(data);
        } else if (requestCode == 6) {
            resultUserDestinationFilter(data);
        } else {
            Timber.w("Unknown Action Selected", new Object[0]);
        }
    }

    private void resultPlaceSearch(Place place) {
        SearchAddress searchAddressBuildSearchAddress = MapUtils.buildSearchAddress(place, getContext());
        this.mapStopSet.clear();
        updateSelectedLocation(place.getLatLng(), searchAddressBuildSearchAddress.getNameAddress());
        saveLocation(searchAddressBuildSearchAddress);
    }

    private void resultUserDestination(Intent data) {
        if (data == null || data.getExtras() == null) {
            return;
        }
        SearchAddress searchAddress = (SearchAddress) data.getExtras().getParcelable(Constants.IntentData.INTENT_USER_DESTINATION);
        this.myDestinationSearchAddress = searchAddress;
        this.tvLabelDestination.setText(getMyDestinationName(searchAddress.getNameAddress()));
        if (this.swOnlyDestination.isChecked()) {
            loadStopsCloseToUser(this.myDestinationSearchAddress, true);
        } else {
            this.swOnlyDestination.setChecked(true);
        }
        saveLocation(this.myDestinationSearchAddress);
    }

    private void saveLocation(final SearchAddress address) {
        this.mapStopsViewModel.getSearchAdress(address).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$saveLocation$7(address, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveLocation$7(SearchAddress searchAddress, List list) {
        if (list == null || list.isEmpty()) {
            this.mapStopsViewModel.insertSearchAddress(searchAddress).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$saveLocation$6((Long) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveLocation$6(Long l) {
        if (l != null) {
            this.mapStopsViewModel.deleteOldSearchAddresses();
        }
    }

    private void resultUserDestinationFilter(Intent data) {
        if (data == null || data.getExtras() == null) {
            return;
        }
        SearchAddress searchAddress = (SearchAddress) data.getExtras().getParcelable(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS);
        if (!this.myDestinationSearchAddress.equals(searchAddress)) {
            if (Constants.EMPTY_SEARCH_ADDRESS.equals(searchAddress)) {
                removeUserDestination();
                return;
            } else {
                this.tvLabelDestination.setText(getMyDestinationName(searchAddress.getNameAddress()));
                this.myDestinationSearchAddress = searchAddress;
            }
        }
        boolean z = data.getExtras().getBoolean(Constants.IntentData.INTENT_DESTINATION_FILTER_ENABLED);
        if (this.swOnlyDestination.isChecked() != z) {
            this.swOnlyDestination.setChecked(z);
        } else {
            loadStopsCloseToUser(this.myDestinationSearchAddress, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageToShowStops() {
        this.clSnackBarTop.setVisibility(0);
        this.handler.postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showMessageToShowStops$8();
            }
        }, Constants.MapStops.SHOW_STOPS_MESSAGE_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMessageToShowStops$8() {
        this.clSnackBarTop.setVisibility(8);
    }

    private Spanned getMyDestinationName(String addressName) {
        if (addressName == null) {
            addressName = getString(R.string.label_destination_address);
        }
        return HtmlUtils.fromHtml(getString(R.string.label_only_stops_to_destination, addressName));
    }

    protected class ClusterManagerWrapper extends ClusterManager<MapStop> {
        ClusterableAndNonClusterableMapStopAlgorithm algorithm;
        MarkerClusterRenderer mapStopRenderer;

        public ClusterManagerWrapper(Context context, GoogleMap map) {
            super(context, map);
            this.algorithm = new ClusterableAndNonClusterableMapStopAlgorithm();
            this.mapStopRenderer = new MarkerClusterRenderer(MapStopsFragment.this.getActivity(), MapStopsFragment.this.googleMap, this, MapUtils.getMapStopMarker(MapStopsFragment.this.getActivity()), MapUtils.getCurrentPositionMarker(MapStopsFragment.this.getActivity()));
            setAlgorithm(this.algorithm);
            setRenderer(this.mapStopRenderer);
            setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$ClusterManagerWrapper$$ExternalSyntheticLambda0
                @Override // com.google.maps.android.clustering.ClusterManager.OnClusterItemClickListener
                public final boolean onClusterItemClick(ClusterItem clusterItem) {
                    return this.f$0.lambda$new$0((MapStop) clusterItem);
                }
            });
            setOnClusterClickListener(new ClusterManager.OnClusterClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment$ClusterManagerWrapper$$ExternalSyntheticLambda1
                @Override // com.google.maps.android.clustering.ClusterManager.OnClusterClickListener
                public final boolean onClusterClick(Cluster cluster) {
                    return this.f$0.onClusterClick(cluster);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$0(MapStop mapStop) {
            MapStopsFragment.this.mapStopSelected = mapStop;
            if (mapStop == null) {
                return false;
            }
            fillSlideUpStop(mapStop);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean onClusterClick(Cluster<MapStop> cluster) {
            MapStopsFragment.this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(cluster.getPosition().latitude, cluster.getPosition().longitude), MapStopsFragment.this.googleMap.getCameraPosition().zoom + 1.0f));
            return true;
        }

        private void fillSlideUpStop(MapStop stopMarker) {
            if (stopMarker.equals(MapStopsFragment.CURRENT_LOCATION_MAP_ITEM)) {
                return;
            }
            MapStopsFragment.this.tvStopNumber.setText(String.valueOf(stopMarker.getIdStop()));
            MapStopsFragment.this.tvStopName.setText(stopMarker.getNameStop());
            MapUtils.animateSlideUp(MapStopsFragment.this.getActivity(), MapStopsFragment.this.clSwipeStop);
        }

        @Override // com.google.maps.android.clustering.ClusterManager, com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
        public void onCameraIdle() {
            if (MapStopsFragment.this.stopsLoadedFistTime) {
                if (MapStopsFragment.this.mapLoadedFistTime) {
                    MapStopsFragment.this.mapLoadedFistTime = false;
                } else {
                    MapStopsFragment.this.showMessageToShowStops();
                }
            }
            super.onCameraIdle();
        }

        public boolean contains(MapStop item) {
            return this.algorithm.contains(item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
