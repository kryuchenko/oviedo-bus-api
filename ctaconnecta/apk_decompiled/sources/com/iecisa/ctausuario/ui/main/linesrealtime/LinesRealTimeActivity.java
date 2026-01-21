package com.iecisa.ctausuario.ui.main.linesrealtime;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment;
import com.iecisa.ctausuario.ui.main.linesrealtime.linesmap.LinesRealTimeMapFragment;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class LinesRealTimeActivity extends CustomToolbarActivity {
    public static final int FRAGMENT_STOPS_LIST = 0;
    public static final int FRAGMENT_STOPS_MAP = 1;
    private LinesRealTimeViewModel linesRealTimeViewModel;
    private MapStop stopFis;
    private StopItinerary stopItinerary;
    private List<StopItinerary> stopsList;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindViews({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    List<TextView> tvLineAction;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final LinesRealTimeListFragment fragmentLinesRealTimeList = new LinesRealTimeListFragment();
    private final LinesRealTimeMapFragment fragmentLinesRealTimeMap = new LinesRealTimeMapFragment();

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_lines_real_time;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.linesRealTimeViewModel = (LinesRealTimeViewModel) new ViewModelProvider(this, this.viewModelFactory).get(LinesRealTimeViewModelImpl.class);
        setUpToolbar();
    }

    private void setUpToolbar() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_line_detail));
        this.tvLineAction.get(0).setSelected(true);
        this.tvLineAction.get(1).setSelected(false);
        if (getIntent().getExtras() != null) {
            this.stopItinerary = (StopItinerary) getIntent().getParcelableExtra(Constants.IntentData.INTENT_LINE_DETAIL);
            this.stopFis = (MapStop) getIntent().getParcelableExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL);
            setToolbarTitle(this.stopItinerary.getDirectionDesc());
            setUpNavigationBar();
            getAllStopsFromLine(this.stopItinerary.getDirectionId(), this.stopItinerary.getVehicleId());
        }
    }

    private void setUpNavigationBar() {
        this.tvLineAction.get(0).setText(getString(R.string.label_tab_list_stops));
        this.tvLineAction.get(1).setText(getString(R.string.label_tab_map_stops));
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.IntentData.INTENT_LINE_DETAIL, this.stopItinerary);
        this.fragmentLinesRealTimeList.setArguments(bundle);
        this.fragmentLinesRealTimeMap.setArguments(bundle);
    }

    public void getAllStopsFromLine(Integer lineId, Integer vehicleId) {
        this.linesRealTimeViewModel.getAllStopsFromLine(lineId, vehicleId, getIntent().getBooleanExtra("fromAllLines", false), this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getAllStopsFromLine$0((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$getAllStopsFromLine$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            setFragment(this.fragmentLinesRealTimeList);
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (!((List) resource.data).isEmpty()) {
            this.stopsList = (List) resource.data;
            if (this.fragmentLinesRealTimeList.isVisible()) {
                this.fragmentLinesRealTimeList.loadStops();
                return;
            } else {
                setFragment(this.fragmentLinesRealTimeList);
                return;
            }
        }
        setFragment(this.fragmentLinesRealTimeList);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    public void onClickEvents(View view) {
        int id = view.getId();
        if (id == R.id.tvInfoTransportCardAction) {
            setFragment(this.fragmentLinesRealTimeList);
            this.tvLineAction.get(1).setSelected(false);
            this.tvLineAction.get(0).setSelected(true);
        } else {
            if (id == R.id.tvRechargeTransportCardAction) {
                setFragment(this.fragmentLinesRealTimeMap);
                this.tvLineAction.get(0).setSelected(false);
                this.tvLineAction.get(1).setSelected(true);
                return;
            }
            Timber.d("Unknown Action Selected", new Object[0]);
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    public List<StopItinerary> getStopsList() {
        return this.stopsList;
    }
}
