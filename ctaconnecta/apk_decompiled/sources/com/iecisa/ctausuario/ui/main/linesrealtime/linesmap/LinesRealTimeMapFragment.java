package com.iecisa.ctausuario.ui.main.linesrealtime.linesmap;

import android.content.Intent;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.model.vehicles.VehicleCoordinates;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.maputils.MapUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class LinesRealTimeMapFragment extends BaseFragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private List<Marker> busMarker;
    private boolean busRefreshTimeRead;
    private GoogleMap googleMap;
    private CameraPosition lastMapCameraPositon;
    private LinesRealTimeMapViewModel linesRealTimeMapViewModel;
    private SupportMapFragment mapFragment;
    private List<LatLng> polyline;
    private StopItinerary selectedStop;
    private List<StopItinerary> stopsList;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private Integer busId = null;
    private Boolean multipleBuses = false;
    private Handler handler = new Handler();
    private Integer busRefreshTime = Integer.valueOf(Constants.MapStops.DEFAULT_BUS_REFRESH_TIME);
    private final Runnable runnable = new Runnable() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (LinesRealTimeMapFragment.this.busId != null) {
                if (LinesRealTimeMapFragment.this.multipleBuses.booleanValue()) {
                    LinesRealTimeMapFragment linesRealTimeMapFragment = LinesRealTimeMapFragment.this;
                    linesRealTimeMapFragment.addBussesLine(linesRealTimeMapFragment.selectedStop.getDirectionId());
                } else {
                    LinesRealTimeMapFragment linesRealTimeMapFragment2 = LinesRealTimeMapFragment.this;
                    linesRealTimeMapFragment2.addBus(linesRealTimeMapFragment2.busId);
                }
                LinesRealTimeMapFragment.this.handler.postDelayed(this, LinesRealTimeMapFragment.this.busRefreshTime.intValue());
            }
        }
    };

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_lines_real_time_map;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.linesRealTimeMapViewModel = (LinesRealTimeMapViewModel) new ViewModelProvider(this, this.viewModelFactory).get(LinesRealTimeMapViewModelImpl.class);
        this.selectedStop = (StopItinerary) getArguments().getParcelable(Constants.IntentData.INTENT_LINE_DETAIL);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        this.mapFragment = supportMapFragment;
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
        if (this.busRefreshTimeRead) {
            return;
        }
        getBusRefreshTime();
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.googleMap.setMyLocationEnabled(true);
        }
        if (this.lastMapCameraPositon != null) {
            restoreMapState();
        }
        this.busMarker = new ArrayList();
        setupGoogleMapsListeners();
        addStops();
    }

    private void addStops() {
        List<StopItinerary> stopsList = ((LinesRealTimeActivity) getActivity()).getStopsList();
        this.stopsList = stopsList;
        if (stopsList == null || stopsList.isEmpty()) {
            return;
        }
        if (this.polyline == null) {
            getPolyline();
        } else {
            addPolyline(false);
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<StopItinerary> it = this.stopsList.iterator();
        while (it.hasNext()) {
            Integer vehicleId = it.next().getVehicleId();
            if (vehicleId.intValue() != 0 && hashSet.add(vehicleId)) {
                arrayList.add(vehicleId);
            }
        }
        this.multipleBuses = Boolean.valueOf(arrayList.size() > 1);
        listenerBus(getVehicle(this.selectedStop.getId()));
        addStopsToMap();
    }

    private void restoreMapState() {
        this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(this.lastMapCameraPositon));
    }

    private void setupGoogleMapsListeners() {
        this.googleMap.setOnMarkerClickListener(this);
        this.googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment.1
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public void onCameraMove() {
                LinesRealTimeMapFragment linesRealTimeMapFragment = LinesRealTimeMapFragment.this;
                linesRealTimeMapFragment.lastMapCameraPositon = linesRealTimeMapFragment.googleMap.getCameraPosition();
            }
        });
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (!(marker.getTag() instanceof StopItinerary)) {
            return false;
        }
        StopItinerary stopItinerary = (StopItinerary) marker.getTag();
        Intent intent = new Intent(getActivity(), (Class<?>) DateTimeLineActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_STOP_DETAIL, stopItinerary);
        startActivity(intent);
        return false;
    }

    private StopItinerary findStop(Integer id) {
        for (StopItinerary stopItinerary : this.stopsList) {
            if (stopItinerary.getId() != null && stopItinerary.getId().equals(id)) {
                return stopItinerary;
            }
        }
        return null;
    }

    private void addStopsToMap() {
        for (StopItinerary stopItinerary : this.stopsList) {
            MarkerOptions markerOptionsPosition = new MarkerOptions().position(new LatLng(stopItinerary.getLatitude().doubleValue(), stopItinerary.getLongitude().doubleValue()));
            if (stopItinerary.equals(this.selectedStop)) {
                markerOptionsPosition.icon(MapUtils.createTextMarkerIcon(getActivity(), findStop(this.selectedStop.getId()).getIdParada().toString(), R.drawable.ic_marker_selected_stop)).zIndex(this.stopsList.size() + 2);
            } else {
                markerOptionsPosition.icon(MapUtils.getMapStopMarker(getActivity()));
            }
            this.googleMap.addMarker(markerOptionsPosition).setTag(stopItinerary);
        }
    }

    private void getPolyline() {
        this.linesRealTimeMapViewModel.getPolyline(this.stopsList.get(0).getDirectionId(), getContext()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getPolyline$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPolyline$0(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i != 1) {
            if (i == 2 && resource.data != 0 && ((List) resource.data).size() > 0) {
                this.polyline = (List) resource.data;
                addPolyline(true);
                return;
            }
            return;
        }
        showErrorDialog(resource.message);
    }

    private Integer getVehicle(Integer id) {
        for (StopItinerary stopItinerary : this.stopsList) {
            if (stopItinerary.getId().equals(id)) {
                return stopItinerary.getVehicleId();
            }
        }
        return null;
    }

    private void addPolyline(boolean moveMapCamera) {
        this.googleMap.addPolyline(new PolylineOptions().addAll(this.polyline).color(getResources().getColor(R.color.colorPrimary)).width(10.0f));
        if (moveMapCamera) {
            moveMapCamera();
        }
    }

    private void moveMapCamera() {
        if (this.polyline.isEmpty()) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<LatLng> it = this.polyline.iterator();
        while (it.hasNext()) {
            builder.include(it.next());
        }
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = getResources().getDisplayMetrics().heightPixels;
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i, i2, (int) (i2 * 0.08d)));
        this.lastMapCameraPositon = this.googleMap.getCameraPosition();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.handler.removeCallbacks(this.runnable);
    }

    private void listenerBus(Integer id) {
        this.busId = id;
        this.handler.post(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBus(Integer id) {
        this.linesRealTimeMapViewModel.getVehicleCoordinates(getContext(), id).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addBus$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addBus$1(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.e(resource.message, new Object[0]);
            return;
        }
        if (i != 2) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            printBus((List) resource.data);
        } else {
            Timber.i("No se ha recuperado la posición del bus.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBussesLine(Integer id) {
        this.linesRealTimeMapViewModel.getVehiclesCoordinates(getContext(), id).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addBussesLine$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addBussesLine$2(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.e(resource.message, new Object[0]);
            return;
        }
        if (i != 2) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            printBus((List) resource.data);
        } else {
            Timber.i("No se ha recuperado la posición del bus.", new Object[0]);
        }
    }

    private void removeMarker(Marker marker) {
        marker.remove();
    }

    private void printBus(List<VehicleCoordinates> vehicleCoordinates) {
        for (int i = 0; i < this.busMarker.size(); i++) {
            this.busMarker.get(i).remove();
        }
        this.busMarker.clear();
        if (vehicleCoordinates.size() > 0) {
            for (int i2 = 0; i2 < vehicleCoordinates.size(); i2++) {
                VehicleCoordinates vehicleCoordinates2 = vehicleCoordinates.get(i2);
                MarkerOptions markerOptionsPosition = new MarkerOptions().position(new LatLng(vehicleCoordinates2.getLatitude(), vehicleCoordinates2.getLongitude()));
                markerOptionsPosition.icon(MapUtils.bitmapDescriptorFromVector(getContext(), R.drawable.ic_cta_bus));
                Marker markerAddMarker = this.googleMap.addMarker(markerOptionsPosition);
                markerAddMarker.setZIndex(this.stopsList.size());
                markerAddMarker.setTag(vehicleCoordinates);
                this.busMarker.add(markerAddMarker);
            }
        }
    }

    private void getBusRefreshTime() {
        this.linesRealTimeMapViewModel.getBusRefreshTime(getContext()).observe(getViewLifecycleOwner(), new Observer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getBusRefreshTime$3((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getBusRefreshTime$3(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.e(resource.message, new Object[0]);
            return;
        }
        if (i != 2) {
            return;
        }
        if (resource.data != 0) {
            this.busRefreshTime = Integer.valueOf(((Integer) resource.data).intValue() * 1000);
            this.busRefreshTimeRead = true;
            Timber.d("Tiempo de refresco de la posición del bus: " + resource.data + " segundos.", new Object[0]);
            return;
        }
        Timber.i("No se ha recuperado el tiempo de refresco de la posición del bus.", new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
