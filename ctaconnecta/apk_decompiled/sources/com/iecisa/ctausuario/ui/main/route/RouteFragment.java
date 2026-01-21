package com.iecisa.ctausuario.ui.main.route;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.model.routes.Route;
import com.iecisa.ctausuario.model.routes.RoutesModelRequest;
import com.iecisa.ctausuario.model.routes.RoutesResponse;
import com.iecisa.ctausuario.ui.main.route.adapter.RouteListAdapter;
import com.iecisa.ctausuario.ui.main.route.detailroute.DetailRouteActivity;
import com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity;
import com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class RouteFragment extends BaseFragment {
    private SearchAddress addressDestination;
    private SearchAddress addressOrigin;

    @BindView(R.id.btAnyway)
    MaterialButton btAnyway;

    @BindView(R.id.btBus)
    MaterialButton btBus;

    @BindView(R.id.btCalculate)
    MaterialButton btCalculate;

    @BindView(R.id.btTrain)
    MaterialButton btTrain;

    @BindView(R.id.ivChangeWay)
    ImageView ivChangeWay;
    private RouteListAdapter routeListAdapter;
    private RouteViewModel routeViewModel;
    private RoutesResponse routes;

    @BindView(R.id.rvRoutes)
    RecyclerView rvRoutes;
    private Calendar selectedDateTime;

    @BindView(R.id.tvDestination)
    TextView tvDestination;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;

    @BindView(R.id.tvOrigin)
    TextView tvOrigin;

    @BindView(R.id.tvSelectDate)
    TextView tvSelectDate;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private boolean isBus = true;
    private boolean isTrain = true;
    private boolean isArrival = false;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_route;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.routeViewModel = (RouteViewModel) new ViewModelProvider(this, this.viewModelFactory).get(RouteViewModelImpl.class);
        SearchAddress searchAddress = this.addressOrigin;
        if (searchAddress != null) {
            this.tvOrigin.setText(searchAddress.getNameAddress());
        }
        SearchAddress searchAddress2 = this.addressDestination;
        if (searchAddress2 != null) {
            this.tvDestination.setText(searchAddress2.getNameAddress());
        }
        validateFields();
        if (this.selectedDateTime == null) {
            this.tvSelectDate.setText(getString(R.string.departure) + " " + getString(R.string.now));
        } else {
            setUpDateTimeView();
        }
        if (this.isBus && this.isTrain) {
            this.btAnyway.setSelected(true);
            this.btBus.setSelected(false);
            this.btTrain.setSelected(false);
        } else {
            this.btAnyway.setSelected(false);
            this.btBus.setSelected(this.isBus);
            this.btTrain.setSelected(this.isTrain);
        }
        RoutesResponse routesResponse = this.routes;
        if (routesResponse == null || routesResponse.getRoutes().isEmpty()) {
            return;
        }
        setResults();
    }

    @OnTextChanged({R.id.tvOrigin})
    public void onTextChangedCarOrigin(CharSequence text) {
        validateFields();
    }

    @OnTextChanged({R.id.tvDestination})
    public void onTextChangedDestiny(CharSequence text) {
        validateFields();
    }

    private void validateFields() {
        String strValueOf = String.valueOf(this.tvOrigin.getText());
        String strValueOf2 = String.valueOf(this.tvDestination.getText());
        this.btCalculate.setEnabled((strValueOf.equals(getString(R.string.label_origin)) || strValueOf.equals(getString(R.string.label_destination)) || strValueOf2.equals(getString(R.string.label_origin)) || strValueOf2.equals(getString(R.string.label_destination))) ? false : true);
    }

    @OnClick({R.id.tvSelectDate, R.id.ivChangeWay, R.id.tvOrigin, R.id.tvDestination, R.id.btBus, R.id.btTrain, R.id.btAnyway})
    public void onClickEvents(View view) {
        Intent intent = new Intent(getActivity(), (Class<?>) AddressPickerActivity.class);
        RouteListAdapter routeListAdapter = this.routeListAdapter;
        if (routeListAdapter != null) {
            routeListAdapter.clearAll();
        }
        this.btCalculate.setVisibility(0);
        switch (view.getId()) {
            case R.id.btAnyway /* 2131361916 */:
                this.isBus = true;
                this.isTrain = true;
                this.btAnyway.setSelected(true);
                this.btBus.setSelected(false);
                this.btTrain.setSelected(false);
                break;
            case R.id.btBus /* 2131361917 */:
                this.isBus = true;
                this.isTrain = false;
                this.btAnyway.setSelected(false);
                this.btBus.setSelected(true);
                this.btTrain.setSelected(false);
                break;
            case R.id.btTrain /* 2131361947 */:
                this.isBus = false;
                this.isTrain = true;
                this.btAnyway.setSelected(false);
                this.btBus.setSelected(false);
                this.btTrain.setSelected(true);
                break;
            case R.id.ivChangeWay /* 2131362279 */:
                changeWayOnClicked();
                break;
            case R.id.tvDestination /* 2131362798 */:
                intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, true);
                startActivityForResult(intent, 5);
                break;
            case R.id.tvOrigin /* 2131362916 */:
                intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, false);
                startActivityForResult(intent, 4);
                break;
            case R.id.tvSelectDate /* 2131362936 */:
                showDateDialog();
                break;
        }
    }

    @OnClick({R.id.btCalculate})
    public void onViewClicked() {
        if (this.addressOrigin != null && this.addressDestination != null) {
            try {
                showLoading();
                this.routeViewModel.calculateRoute(getContext(), new RoutesModelRequest(!this.isArrival, this.isBus, this.isTrain, this.selectedDateTime, this.addressOrigin, this.addressDestination, getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128).metaData.getString("com.google.android.geo.API_KEY"))).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment$$ExternalSyntheticLambda1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        this.f$0.lambda$onViewClicked$0((Resource) obj);
                    }
                });
                return;
            } catch (PackageManager.NameNotFoundException e) {
                Timber.e(e);
                return;
            }
        }
        this.tvErrorMessage.setText(getString(R.string.error_required_fields_way));
        this.tvErrorMessage.setVisibility(0);
        this.btCalculate.setEnabled(false);
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.route.RouteFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onViewClicked$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
        } else {
            if (i != 3) {
                return;
            }
            this.routes = (RoutesResponse) resource.data;
            setResults();
            hideLoading();
        }
    }

    private void setResults() {
        if (this.rvRoutes.getAdapter() == null) {
            setListRoutes();
        } else {
            updateListRoutes();
        }
        this.btCalculate.setVisibility(8);
    }

    private void setListRoutes() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvRoutes.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvRoutes.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvRoutes.addItemDecoration(dividerItemDecoration);
        RouteListAdapter routeListAdapter = this.routeListAdapter;
        if (routeListAdapter == null) {
            RouteListAdapter routeListAdapter2 = new RouteListAdapter(this.routes.getRoutes());
            this.routeListAdapter = routeListAdapter2;
            routeListAdapter2.setOnStopClickListener(new RouteListAdapter.OnRouteClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment$$ExternalSyntheticLambda2
                @Override // com.iecisa.ctausuario.ui.main.route.adapter.RouteListAdapter.OnRouteClickListener
                public final void onClickRoute(Route route) {
                    this.f$0.lambda$setListRoutes$1(route);
                }
            });
        } else {
            routeListAdapter.setListRoutes(this.routes.getRoutes());
            this.routeListAdapter.notifyDataSetChanged();
        }
        this.rvRoutes.setAdapter(this.routeListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setListRoutes$1(Route route) {
        Intent intent = new Intent(getActivity(), (Class<?>) DetailRouteActivity.class);
        if (route.getLegs() != null && route.getLegs().size() > 0) {
            intent.putExtra(Constants.IntentData.INTENT_DETAIL_ROUTE, route.getLegs().get(0));
        }
        startActivity(intent);
    }

    private void updateListRoutes() {
        ((RouteListAdapter) this.rvRoutes.getAdapter()).setListRoutes(this.routes.getRoutes());
        this.rvRoutes.getAdapter().notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        SearchAddress searchAddress;
        SearchAddress searchAddress2;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == 5) {
                if (data == null || data.getExtras() == null || (searchAddress2 = (SearchAddress) data.getExtras().getParcelable(Constants.IntentData.INTENT_SEARCH_ADDRESS)) == null || TextUtils.isEmpty(searchAddress2.getNameAddress())) {
                    return;
                }
                this.addressDestination = searchAddress2;
                this.tvDestination.setText(searchAddress2.getNameAddress());
                return;
            }
            if (requestCode != 4 || data == null || data.getExtras() == null || (searchAddress = (SearchAddress) data.getExtras().getParcelable(Constants.IntentData.INTENT_SEARCH_ADDRESS)) == null || TextUtils.isEmpty(searchAddress.getNameAddress())) {
                return;
            }
            this.addressOrigin = searchAddress;
            this.tvOrigin.setText(searchAddress.getNameAddress());
        }
    }

    private void showDateDialog() {
        new TimePickerDialogFragment(this.selectedDateTime, new TimePickerDialogFragment.OnNewClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.RouteFragment$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.route.timepicker.TimePickerDialogFragment.OnNewClickListener
            public final void onNewClick(boolean z, int i, int i2, int i3, int i4, int i5) {
                this.f$0.lambda$showDateDialog$2(z, i, i2, i3, i4, i5);
            }
        }).show(getParentFragmentManager().beginTransaction(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDateDialog$2(boolean z, int i, int i2, int i3, int i4, int i5) {
        this.isArrival = z;
        Calendar calendar = Calendar.getInstance();
        this.selectedDateTime = calendar;
        calendar.set(1, i3);
        this.selectedDateTime.set(2, i2);
        this.selectedDateTime.set(5, i);
        this.selectedDateTime.set(11, i4);
        this.selectedDateTime.set(12, i5);
        setUpDateTimeView();
    }

    private void setUpDateTimeView() {
        String string;
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(12, -1);
        if (this.selectedDateTime.after(calendar2) && this.selectedDateTime.before(calendar)) {
            string = getString(R.string.now);
            this.selectedDateTime = null;
        } else {
            string = getString(R.string.time, new SimpleDateFormat(DateUtils.TEXT_DATE_FORMAT).format(this.selectedDateTime.getTime()));
        }
        if (this.isArrival) {
            this.tvSelectDate.setText(getString(R.string.arrival) + " " + string);
            return;
        }
        this.tvSelectDate.setText(getString(R.string.departure) + " " + string);
    }

    private void changeWayOnClicked() {
        String string = this.tvOrigin.getText().toString();
        this.tvOrigin.setText(this.tvDestination.getText().toString());
        this.tvDestination.setText(string);
        SearchAddress searchAddress = this.addressOrigin;
        this.addressOrigin = this.addressDestination;
        this.addressDestination = searchAddress;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
