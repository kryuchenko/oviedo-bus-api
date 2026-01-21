package com.iecisa.ctausuario.ui.main.route.detailroute;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.maps.android.PolyUtil;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.DetailRouteModel;
import com.iecisa.ctausuario.model.routes.Leg;
import com.iecisa.ctausuario.model.routes.PolylineData;
import com.iecisa.ctausuario.model.routes.Step;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.route.adapter.WayListAdapter;
import com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteAdapter;
import com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder;
import com.iecisa.ctausuario.utils.Constants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DetailRouteActivity extends CustomToolbarActivity implements OnMapReadyCallback {
    private BottomSheetBehavior bsBehavior;

    @BindView(R.id.clBottomSheet)
    ConstraintLayout clBottomSheet;
    private Leg detailRoute;
    private GoogleMap googleMap;

    @BindView(R.id.rvResume)
    RecyclerView rvResume;

    @BindView(R.id.rvRoute)
    RecyclerView rvRoute;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvTime)
    TextView tvTime;
    private DetailRouteViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_detail_route;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (DetailRouteViewModel) new ViewModelProvider(this, this.viewModelFactory).get(DetailRouteViewModelImpl.class);
        setupMap();
        setupToolbar();
        setupView();
        setListRoutes();
    }

    private void setupMap() {
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fMap);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    private void setupView() {
        if (getIntent().getExtras() != null) {
            this.detailRoute = (Leg) getIntent().getSerializableExtra(Constants.IntentData.INTENT_DETAIL_ROUTE);
        }
        this.bsBehavior = BottomSheetBehavior.from(this.clBottomSheet);
        setupResume();
    }

    private void setupResume() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.rvResume.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvResume.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.drawable_separator_recyclerview, getTheme()));
        this.rvResume.addItemDecoration(dividerItemDecoration);
        this.rvResume.setAdapter(new WayListAdapter(this.viewModel.getDataRouteDetail(this.detailRoute.getSteps())));
        if (TextUtils.isEmpty(this.detailRoute.getDuration().getText())) {
            return;
        }
        this.tvTime.setText(this.detailRoute.getDuration().getText());
    }

    private void setupToolbar() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_calculate_route));
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) throws Resources.NotFoundException {
        BitmapDescriptor markerIconFromDrawable;
        BitmapDescriptor markerIconFromDrawable2;
        this.googleMap = googleMap;
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.googleMap.setMyLocationEnabled(true);
        }
        List<Step> steps = this.detailRoute.getSteps();
        if (steps == null || steps.size() <= 0) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Step step : steps) {
            int color = getResources().getColor(R.color.colorPrimary);
            List<LatLng> listDecode = PolyUtil.decode(step.getPolyline().getPoints());
            if (step.getTravelMode().equals(Constants.Routes.ROUTE_TRAVEL_MODE_TRANSIT) && step.getTransitDetails().getLine().getVehicle().getType().equals(Constants.Routes.ROUTE_TRAVEL_MODE_HEAVY_RAIL) && step.getTransitDetails().getLine().getColor() != null) {
                color = Color.parseColor(step.getTransitDetails().getLine().getColor());
            }
            List<PatternItem> listSingletonList = Collections.singletonList(new Dot());
            PolylineOptions polylineOptionsWidth = new PolylineOptions().addAll(listDecode).color(color).width(10.0f);
            if (!step.getTravelMode().equals(Constants.Routes.ROUTE_TRAVEL_MODE_WALKING)) {
                listSingletonList = null;
            }
            googleMap.addPolyline(polylineOptionsWidth.pattern(listSingletonList).geodesic(true));
            if (!listDecode.isEmpty()) {
                Iterator<LatLng> it = listDecode.iterator();
                while (it.hasNext()) {
                    builder.include(it.next());
                }
            }
            if (step == steps.get(0)) {
                markerIconFromDrawable = getMarkerIconFromDrawable(getDrawable(R.drawable.ic_my_location));
            } else {
                markerIconFromDrawable = getMarkerIconFromDrawable(getDrawable(R.drawable.ic_route_middle_location));
            }
            if (step == steps.get(steps.size() - 1)) {
                markerIconFromDrawable2 = getMarkerIconFromDrawable(getDrawable(R.drawable.ic_end_route_location));
            } else {
                markerIconFromDrawable2 = getMarkerIconFromDrawable(getDrawable(R.drawable.ic_route_middle_location));
            }
            googleMap.addMarker(new MarkerOptions().icon(markerIconFromDrawable).position(new LatLng(step.getStartLocation().getLat().doubleValue(), step.getStartLocation().getLng().doubleValue())));
            googleMap.addMarker(new MarkerOptions().icon(markerIconFromDrawable2).position(new LatLng(step.getEndLocation().getLat().doubleValue(), step.getEndLocation().getLng().doubleValue())));
        }
        moveMapCamera(builder);
    }

    private BitmapDescriptor getMarkerIconFromDrawable(Drawable drawable) {
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
    }

    private void setListRoutes() {
        this.rvRoute.setLayoutManager(new LinearLayoutManager(this));
        if (this.detailRoute.getDepartureTime() == null || this.detailRoute.getArrivalTime() == null) {
            return;
        }
        this.rvRoute.setAdapter(new DetailRouteAdapter(this.detailRoute.getSteps(), new DetailRouteModel(this.detailRoute.getStartAddress(), this.detailRoute.getDepartureTime().getText()), new DetailRouteModel(this.detailRoute.getEndAddress(), this.detailRoute.getArrivalTime().getText()), new DetailRouteBaseViewHolder.OnRouteClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.route.detailroute.adapter.DetailRouteBaseViewHolder.OnRouteClickListener
            public final void onClickMap(PolylineData polylineData) {
                this.f$0.loadPolylines(polylineData);
            }
        }));
    }

    @OnClick({R.id.ivSlider})
    public void onEventClick(View view) {
        if (this.bsBehavior.getState() == 4) {
            this.bsBehavior.setState(3);
        } else {
            this.bsBehavior.setState(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPolylines(PolylineData data) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<LatLng> listDecode = PolyUtil.decode(data.getPoints());
        if (!listDecode.isEmpty()) {
            Iterator<LatLng> it = listDecode.iterator();
            while (it.hasNext()) {
                builder.include(it.next());
            }
        }
        this.bsBehavior.setState(4);
        moveMapCamera(builder);
    }

    private void moveMapCamera(LatLngBounds.Builder builder) {
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = getResources().getDisplayMetrics().heightPixels;
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i, i2, (int) (i2 * 0.08d)));
    }
}
