package com.iecisa.ctausuario.ui.main.stops.searchstop;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.stops.searchstop.StopSearchAdapter;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SearchStopsFragment extends BaseFragment {

    @BindView(R.id.etSearch)
    EditText etSearch;

    @BindView(R.id.pbLoadingStopData)
    ProgressBar pbLoadingStopData;

    @BindView(R.id.rvSearchResult)
    RecyclerView rvSearchResult;
    private SearchStopViewModel searchStopViewModel;
    private StopSearchAdapter stopSearchAdapter;

    @BindView(R.id.tvErrorStopData)
    TextView tvErrorStopData;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_search_stop;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.searchStopViewModel = (SearchStopViewModel) new ViewModelProvider(this, this.viewModelFactory).get(SearchStopViewModelImpl.class);
        setAdapterToSearchResults();
        getTextForSearch();
    }

    private void getTextForSearch() {
        this.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$getTextForSearch$0(textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getTextForSearch$0(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        queryForSearchString(this.etSearch.getText().toString().trim());
        return false;
    }

    private void queryForSearchString(String searchQuery) {
        if (TextUtils.isEmpty(searchQuery)) {
            return;
        }
        this.searchStopViewModel.getSearchPlaces(searchQuery, getContext()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$queryForSearchString$1((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$queryForSearchString$1(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            showErrorTimetable(resource.message);
            return;
        }
        if (i == 2) {
            showProgressBarTimetable();
            return;
        }
        if (i != 3) {
            return;
        }
        hideProgressBarTimetable();
        this.stopSearchAdapter.setListStops((List) resource.data);
        this.stopSearchAdapter.notifyDataSetChanged();
        if (resource.data == 0 || ((List) resource.data).size() == 0) {
            showErrorTimetable(getString(R.string.label_error_data_stop));
        }
    }

    private void setAdapterToSearchResults() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvSearchResult.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvSearchResult.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvSearchResult.addItemDecoration(dividerItemDecoration);
        if (this.stopSearchAdapter == null) {
            StopSearchAdapter stopSearchAdapter = new StopSearchAdapter();
            this.stopSearchAdapter = stopSearchAdapter;
            stopSearchAdapter.setOnSearchStopClickListener(new StopSearchAdapter.OnSearchStopClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment$$ExternalSyntheticLambda2
                @Override // com.iecisa.ctausuario.ui.main.stops.searchstop.StopSearchAdapter.OnSearchStopClickListener
                public final void onStopClick(MapStop mapStop) {
                    this.f$0.lambda$setAdapterToSearchResults$2(mapStop);
                }
            });
        }
        this.rvSearchResult.setAdapter(this.stopSearchAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAdapterToSearchResults$2(MapStop mapStop) {
        Intent intent = new Intent(getActivity(), (Class<?>) DetailStopActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL, mapStop);
        intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, Constants.EMPTY_SEARCH_ADDRESS);
        startActivity(intent);
    }

    public void showProgressBarTimetable() {
        this.pbLoadingStopData.setVisibility(0);
        this.tvErrorStopData.setVisibility(8);
        RecyclerView recyclerView = this.rvSearchResult;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    public void showErrorTimetable(String msg) {
        this.pbLoadingStopData.setVisibility(8);
        this.tvErrorStopData.setVisibility(0);
        this.tvErrorStopData.setText(msg);
        RecyclerView recyclerView = this.rvSearchResult;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    public void hideProgressBarTimetable() {
        this.pbLoadingStopData.setVisibility(8);
        this.tvErrorStopData.setVisibility(8);
        RecyclerView recyclerView = this.rvSearchResult;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
