package com.iecisa.ctausuario.ui.main.linesrealtime.lineslist;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopItinerary;
import com.iecisa.ctausuario.ui.main.datelines.DateTimeLineActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.LinesRealTimeActivity;
import com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.StopLineAdapter;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;

/* loaded from: classes5.dex */
public class LinesRealTimeListFragment extends BaseFragment {

    @BindView(R.id.btRefresh)
    MaterialButton btRefresh;
    private StopLineAdapter linesAdapter;

    @BindView(R.id.rvStopsLine)
    RecyclerView rvStopsLine;
    private StopItinerary selectedStop;

    @BindView(R.id.tvErrorListStops)
    TextView tvErrorListStops;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_lines_real_time_list;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.selectedStop = (StopItinerary) getArguments().getParcelable(Constants.IntentData.INTENT_LINE_DETAIL);
        loadStops();
    }

    public void loadStops() {
        List<StopItinerary> stopsList = ((LinesRealTimeActivity) getActivity()).getStopsList();
        if (stopsList == null || stopsList.isEmpty()) {
            showErrorNoStops();
            return;
        }
        hideErrorNoStops();
        if (this.rvStopsLine.getAdapter() == null) {
            setUpStopsForLine(stopsList);
        } else {
            updateStopsForLine(stopsList);
        }
    }

    private void showErrorNoStops() {
        this.tvErrorListStops.setVisibility(0);
        RecyclerView recyclerView = this.rvStopsLine;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }

    private void hideErrorNoStops() {
        this.tvErrorListStops.setVisibility(4);
        RecyclerView recyclerView = this.rvStopsLine;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private void setUpStopsForLine(List<StopItinerary> stopsList) {
        this.rvStopsLine.setLayoutManager(new LinearLayoutManager(getContext()));
        StopLineAdapter stopLineAdapter = this.linesAdapter;
        if (stopLineAdapter == null) {
            StopLineAdapter stopLineAdapter2 = new StopLineAdapter(stopsList, this.selectedStop, getContext());
            this.linesAdapter = stopLineAdapter2;
            stopLineAdapter2.setOnStopForLineClickListener(new StopLineAdapter.OnStopForLineClickListener() { // from class: com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.LinesRealTimeListFragment$$ExternalSyntheticLambda0
                @Override // com.iecisa.ctausuario.ui.main.linesrealtime.lineslist.StopLineAdapter.OnStopForLineClickListener
                public final void onStopClick(StopItinerary stopItinerary) {
                    this.f$0.lambda$setUpStopsForLine$0(stopItinerary);
                }
            });
        } else {
            stopLineAdapter.setListStopsLine(stopsList);
            this.linesAdapter.notifyDataSetChanged();
        }
        this.rvStopsLine.setAdapter(this.linesAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpStopsForLine$0(StopItinerary stopItinerary) {
        Intent intent = new Intent(getActivity(), (Class<?>) DateTimeLineActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_STOP_DETAIL, stopItinerary);
        startActivity(intent);
    }

    private void updateStopsForLine(List<StopItinerary> listStops) {
        ((StopLineAdapter) this.rvStopsLine.getAdapter()).setListStopsLine(listStops);
        this.rvStopsLine.getAdapter().notifyDataSetChanged();
    }

    @OnClick({R.id.btRefresh})
    public void onEventsClick(View view) {
        if (view.getId() != R.id.btRefresh) {
            return;
        }
        ((LinesRealTimeActivity) getActivity()).getAllStopsFromLine(this.selectedStop.getDirectionId(), this.selectedStop.getVehicleId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
