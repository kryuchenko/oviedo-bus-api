package com.iecisa.ctausuario.ui.main.stops.detailstop.alllines;

import android.content.Intent;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class AllLinesFragment extends BaseFragment {
    private AllLinesViewModel detailStopViewModel;
    private LinesAdapter linesAdapter;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.rvStops)
    RecyclerView rvStops;
    private List<StopItinerary> stopItineraries;

    @BindView(R.id.tvErrorStopData)
    TextView tvErrorStopData;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    static /* synthetic */ void lambda$showErrorNotifications$0() {
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_all_lines;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.detailStopViewModel = (AllLinesViewModel) new ViewModelProvider(this, this.viewModelFactory).get(AllLinesViewModelImpl.class);
        if (this.stopItineraries != null) {
            setupList();
        } else {
            getLinesForStop(DetailStopActivity.getMapStop().getIdStop());
        }
    }

    private void setUpLinesList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvStops.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvStops.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvStops.addItemDecoration(dividerItemDecoration);
        LinesAdapter linesAdapter = this.linesAdapter;
        if (linesAdapter == null) {
            LinesAdapter linesAdapter2 = new LinesAdapter(this.stopItineraries, false, getContext());
            this.linesAdapter = linesAdapter2;
            linesAdapter2.setOnStopClickListener(new LinesAdapter.OnStopClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment.1
                @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter.OnStopClickListener
                public void onStopClick(StopItinerary stopItinerary) {
                    Intent intent = new Intent(AllLinesFragment.this.getActivity(), (Class<?>) LinesRealTimeActivity.class);
                    intent.putExtra(Constants.IntentData.INTENT_LINE_DETAIL, stopItinerary);
                    intent.putExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL, DetailStopActivity.getMapStop());
                    intent.putExtra("fromAllLines", true);
                    AllLinesFragment.this.startActivity(intent);
                }

                @Override // com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.LinesAdapter.OnStopClickListener
                public void onAlertStopClick(StopItinerary stopItinerary) {
                    AllLinesFragment.this.setNotificationItinerary(stopItinerary);
                }
            });
        } else {
            linesAdapter.setStopItineraryList(this.stopItineraries);
            this.linesAdapter.notifyDataSetChanged();
        }
        this.rvStops.setAdapter(this.linesAdapter);
    }

    private void updateLinesList() {
        ((LinesAdapter) this.rvStops.getAdapter()).setStopItineraryList(this.stopItineraries);
        this.rvStops.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNotificationItinerary(StopItinerary stopItinerary) {
        if (stopItinerary.isNotificationActive()) {
            deleteItinerary(stopItinerary);
        } else {
            addItinerary(stopItinerary);
        }
    }

    private void showErrorNotifications(String message) {
        BaseUtils.showInfoDialog(getContext(), 2, getString(R.string.error), message, getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                AllLinesFragment.lambda$showErrorNotifications$0();
            }
        });
    }

    private void getNotificationItineraries(final List<StopItinerary> stopItineraries) {
        this.detailStopViewModel.getNotificationItineraries(getContext(), getDeviceToken()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getNotificationItineraries$1(stopItineraries, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNotificationItineraries$1(List list, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            setupDatList(list);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            if (resource.data != 0) {
                setNotifications((List) resource.data, list);
            } else {
                setupDatList(list);
            }
            hideLoading();
        }
    }

    private void setNotifications(List<Integer> itineraries, List<StopItinerary> stopItineraries) {
        Iterator<Integer> it = itineraries.iterator();
        while (it.hasNext()) {
            findItinerary(it.next(), stopItineraries);
        }
        setupDatList(stopItineraries);
    }

    private void setupDatList(List<StopItinerary> stopItineraryList) {
        this.stopItineraries = stopItineraryList;
        setupList();
    }

    private void setupList() {
        if (this.rvStops.getAdapter() == null) {
            setUpLinesList();
        } else {
            updateLinesList();
        }
    }

    private void findItinerary(Integer i, List<StopItinerary> data) {
        for (StopItinerary stopItinerary : data) {
            if (i.equals(stopItinerary.getItineraryId())) {
                stopItinerary.setNotificationActive(true);
            }
        }
    }

    private String getDeviceToken() {
        String pendingDeviceToken = this.preferences.getPendingDeviceToken();
        return pendingDeviceToken == null ? this.preferences.getDeviceToken() : pendingDeviceToken;
    }

    private void deleteItinerary(final StopItinerary stopItinerary) {
        this.detailStopViewModel.deleteItinerary(getContext(), stopItinerary.getItineraryId(), getDeviceToken()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$deleteItinerary$2(stopItinerary, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteItinerary$2(StopItinerary stopItinerary, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
            showErrorNotifications(resource.message);
            hideLoading();
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            ((LinesAdapter) this.rvStops.getAdapter()).setItineraryNotification(stopItinerary.getItineraryId(), false);
            hideLoading();
        }
    }

    private void addItinerary(final StopItinerary stopItinerary) {
        this.detailStopViewModel.addItinerary(getContext(), stopItinerary.getItineraryId(), getDeviceToken()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$addItinerary$3(stopItinerary, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addItinerary$3(StopItinerary stopItinerary, Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
            showErrorNotifications(resource.message);
            hideLoading();
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            ((LinesAdapter) this.rvStops.getAdapter()).setItineraryNotification(stopItinerary.getItineraryId(), true);
            hideLoading();
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$2, reason: invalid class name */
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

    private void getLinesForStop(Integer idStop) {
        this.detailStopViewModel.getStopsItineraryByMapStop(idStop, getContext()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getLinesForStop$4((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinesForStop$4(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showErrorDialog(resource.message);
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            getNotificationItineraries((List) resource.data);
        } else {
            hideLoading();
            showErrorNoLines();
        }
    }

    private void showErrorNoLines() {
        this.tvErrorStopData.setVisibility(0);
        RecyclerView recyclerView = this.rvStops;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
