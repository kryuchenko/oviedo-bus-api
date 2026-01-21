package com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials;

import android.content.Intent;
import android.text.Spanned;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.maputils.HtmlUtils;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NextArrivalsFragment extends BaseFragment {

    @BindView(R.id.btRefresh)
    MaterialButton btRefresh;

    @BindView(R.id.clStopsToDestination)
    ConstraintLayout clStopsToDestination;

    @BindView(R.id.ivRemoveUserDestination)
    ImageView ivRemoveUserDestination;
    private LinesAdapter linesAdapter;
    private NextArrivalsViewModel nextArrivalsViewModel;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.rvStops)
    RecyclerView rvStops;

    @BindView(R.id.swOnlyDestination)
    Switch swOnlyDestination;

    @BindView(R.id.tvErrorStopData)
    TextView tvErrorStopData;

    @BindView(R.id.tvLabelDestination)
    TextView tvLabelDestination;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_next_arrivals;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.nextArrivalsViewModel = (NextArrivalsViewModel) new ViewModelProvider(this, this.viewModelFactory).get(NextArrivalsViewModelImpl.class);
        setOnCheckedDestinationFilterSwitch();
        this.swOnlyDestination.setChecked(DetailStopActivity.isDestinationSearchAddessActive());
        loadData();
    }

    private void loadData() {
        if (Constants.EMPTY_SEARCH_ADDRESS.equals(DetailStopActivity.getSearchAddressDestination())) {
            this.tvLabelDestination.setText(getMyDestinationName(null));
            getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop());
        } else {
            this.tvLabelDestination.setText(getMyDestinationName(DetailStopActivity.getSearchAddressDestination().getNameAddress()));
            getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop());
        }
    }

    private void setUpLinesList(List<StopItinerary> stopItineraryList) {
        this.tvErrorStopData.setVisibility(8);
        this.rvStops.setVisibility(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvStops.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvStops.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        if (this.rvStops.getItemDecorationCount() == 0) {
            this.rvStops.addItemDecoration(dividerItemDecoration);
        }
        LinesAdapter linesAdapter = this.linesAdapter;
        if (linesAdapter == null) {
            LinesAdapter linesAdapter2 = new LinesAdapter(stopItineraryList, true, getContext());
            this.linesAdapter = linesAdapter2;
            linesAdapter2.setOnStopClickListener(new LinesAdapter.OnStopClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment.1
                @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter.OnStopClickListener
                public void onAlertStopClick(StopItinerary line) {
                }

                @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter.OnStopClickListener
                public void onStopClick(StopItinerary stopItinerary) {
                    Intent intent = new Intent(NextArrivalsFragment.this.getActivity(), (Class<?>) LinesRealTimeActivity.class);
                    intent.putExtra(Constants.IntentData.INTENT_LINE_DETAIL, stopItinerary);
                    intent.putExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL, DetailStopActivity.getMapStop());
                    NextArrivalsFragment.this.startActivity(intent);
                }
            });
        } else {
            linesAdapter.setStopItineraryList(stopItineraryList);
            this.linesAdapter.notifyDataSetChanged();
        }
        this.rvStops.setAdapter(this.linesAdapter);
    }

    private void updateLinesList(List<StopItinerary> stopItineraryList) {
        ((LinesAdapter) this.rvStops.getAdapter()).setStopItineraryList(stopItineraryList);
        this.rvStops.getAdapter().notifyDataSetChanged();
    }

    @OnClick({R.id.tvLabelDestination, R.id.swOnlyDestination, R.id.ivRemoveUserDestination, R.id.btRefresh})
    public void onEventsClick(View view) {
        int id = view.getId();
        if (id == R.id.btRefresh) {
            loadData();
        } else if (id == R.id.ivRemoveUserDestination) {
            removeUserDestination();
        } else {
            if (id != R.id.tvLabelDestination) {
                return;
            }
            goToUserDestinationSelector();
        }
    }

    private void goToUserDestinationSelector() {
        Intent intent = new Intent(getActivity(), (Class<?>) DestinationUserSelectorActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_STOP_DETAIL, DetailStopActivity.getMapStop());
        startActivityForResult(intent, 1);
    }

    private void removeUserDestination() {
        DetailStopActivity.setSearchAddressDestination(Constants.EMPTY_SEARCH_ADDRESS);
        getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop());
        if (this.swOnlyDestination.isChecked()) {
            this.swOnlyDestination.setChecked(false);
        } else {
            clearMyDestinationFilter();
        }
    }

    private void getItineraryStopsFromStop(Integer idStop) {
        getItineraryStopsFromStop(idStop, null);
    }

    private void getItineraryStopsFromStop(Integer idStop, LatLng destinationCoordinates) {
        this.nextArrivalsViewModel.getStopsItineraryNextArrivalsByMapStop(idStop, getContext(), destinationCoordinates, 500.0d).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getItineraryStopsFromStop$0((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getItineraryStopsFromStop$0(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            Toast.makeText(getContext(), resource.message, 0).show();
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (((List) resource.data).isEmpty()) {
            showErrorNoLines();
        } else if (this.rvStops.getAdapter() == null) {
            setUpLinesList((List) resource.data);
        } else {
            updateLinesList((List) resource.data);
        }
        hideLoading();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || data.getExtras() == null) {
            return;
        }
        DetailStopActivity.setSearchAddressDestination((SearchAddress) data.getExtras().getParcelable(Constants.IntentData.INTENT_USER_DESTINATION));
        this.tvLabelDestination.setText(getMyDestinationName(DetailStopActivity.getSearchAddressDestination().getNameAddress()));
        if (this.swOnlyDestination.isChecked()) {
            getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop(), new LatLng(DetailStopActivity.getSearchAddressDestination().getLatitude().doubleValue(), DetailStopActivity.getSearchAddressDestination().getLongitude().doubleValue()));
        } else {
            this.swOnlyDestination.setChecked(true);
        }
    }

    private void showErrorNoLines() {
        this.tvErrorStopData.setVisibility(0);
        RecyclerView recyclerView = this.rvStops;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    private void setOnCheckedDestinationFilterSwitch() {
        this.swOnlyDestination.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$setOnCheckedDestinationFilterSwitch$1(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnCheckedDestinationFilterSwitch$1(CompoundButton compoundButton, boolean z) {
        DetailStopActivity.setDestinationSearchAddessActive(z);
        if (!Constants.EMPTY_SEARCH_ADDRESS.equals(DetailStopActivity.getSearchAddressDestination())) {
            this.ivRemoveUserDestination.setVisibility(0);
            if (z) {
                getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop(), new LatLng(DetailStopActivity.getSearchAddressDestination().getLatitude().doubleValue(), DetailStopActivity.getSearchAddressDestination().getLongitude().doubleValue()));
                return;
            } else {
                getItineraryStopsFromStop(DetailStopActivity.getMapStop().getIdStop());
                return;
            }
        }
        if (z) {
            this.swOnlyDestination.setChecked(false);
            DetailStopActivity.setDestinationSearchAddessActive(false);
            goToUserDestinationSelector();
            return;
        }
        clearMyDestinationFilter();
    }

    private void clearMyDestinationFilter() {
        this.ivRemoveUserDestination.setVisibility(8);
        this.tvLabelDestination.setText(getMyDestinationName(null));
    }

    private Spanned getMyDestinationName(String addressName) {
        if (addressName == null) {
            addressName = getString(R.string.label_destination_address);
        }
        return HtmlUtils.fromHtml(getString(R.string.label_only_stops_to_destination_detail_stop, addressName));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
