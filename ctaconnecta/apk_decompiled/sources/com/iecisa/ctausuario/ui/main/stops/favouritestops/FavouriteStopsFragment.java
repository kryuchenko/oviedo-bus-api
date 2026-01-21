package com.iecisa.ctausuario.ui.main.stops.favouritestops;

import android.app.backup.BackupManager;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsAdapter;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class FavouriteStopsFragment extends BaseFragment {
    private FavouriteStopsAdapter favouriteStopsAdapter;
    private FavouriteStopsViewModel favouriteStopsViewModel;

    @BindView(R.id.ivBackgroundNoFavouriteStops)
    ImageView ivBackgroundNoFavouriteStops;

    @BindView(R.id.rvFavouriteStops)
    RecyclerView rvFavouriteStops;

    @BindView(R.id.tvLabelNoFavouriteStops)
    TextView tvLabelNoFavouriteStops;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_favourite_stops;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        this.favouriteStopsViewModel = (FavouriteStopsViewModel) new ViewModelProvider(this, this.viewModelFactory).get(FavouriteStopsViewModelImpl.class);
        getFavouriteStops();
    }

    private void setUpFavouriteStopsList(List<MapStop> listStops) {
        this.rvFavouriteStops.setVisibility(0);
        this.ivBackgroundNoFavouriteStops.setVisibility(8);
        this.tvLabelNoFavouriteStops.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvFavouriteStops.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvFavouriteStops.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getActivity().getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvFavouriteStops.addItemDecoration(dividerItemDecoration);
        FavouriteStopsAdapter favouriteStopsAdapter = this.favouriteStopsAdapter;
        if (favouriteStopsAdapter == null) {
            FavouriteStopsAdapter favouriteStopsAdapter2 = new FavouriteStopsAdapter(listStops);
            this.favouriteStopsAdapter = favouriteStopsAdapter2;
            favouriteStopsAdapter2.setOnFavouriteStopClickListener(new FavouriteStopsAdapter.OnFavouriteStopClickListener() { // from class: com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment.1
                @Override // com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsAdapter.OnFavouriteStopClickListener
                public void onFavouriteStopClick(MapStop favouriteStop) {
                    Intent intent = new Intent(FavouriteStopsFragment.this.getActivity(), (Class<?>) DetailStopActivity.class);
                    intent.putExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL, favouriteStop);
                    intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, Constants.EMPTY_SEARCH_ADDRESS);
                    FavouriteStopsFragment.this.startActivity(intent);
                }

                @Override // com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsAdapter.OnFavouriteStopClickListener
                public void onHeartFavouriteStopClick(final MapStop favouriteStop) {
                    if (favouriteStop != null) {
                        BaseUtils.showDialog(FavouriteStopsFragment.this.getContext(), 1, FavouriteStopsFragment.this.getString(R.string.label_confirm_stop_deletion), FavouriteStopsFragment.this.getString(R.string.label_confirm_stop_deletion_confirm, favouriteStop.getNameStop()), FavouriteStopsFragment.this.getString(R.string.label_yes), FavouriteStopsFragment.this.getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment.1.1
                            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                            public void onClickNegative() {
                            }

                            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                            public void onClickPositive() {
                                FavouriteStopsFragment.this.deleteFavouriteStopAndUpdate(favouriteStop);
                            }
                        });
                    }
                }
            });
        } else {
            favouriteStopsAdapter.setListFavouriteStops(listStops);
            this.favouriteStopsAdapter.notifyDataSetChanged();
        }
        this.rvFavouriteStops.setAdapter(this.favouriteStopsAdapter);
    }

    private void updateFavouriteStopsList(List<MapStop> listStops) {
        ((FavouriteStopsAdapter) this.rvFavouriteStops.getAdapter()).setListFavouriteStops(listStops);
        this.rvFavouriteStops.getAdapter().notifyDataSetChanged();
    }

    private void getFavouriteStops() {
        this.favouriteStopsViewModel.getAllFavouriteStops().observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getFavouriteStops$0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getFavouriteStops$0(List list) {
        if (list != null && list.size() > 0) {
            if (this.rvFavouriteStops.getAdapter() == null) {
                setUpFavouriteStopsList(list);
                return;
            } else {
                updateFavouriteStopsList(list);
                return;
            }
        }
        setUpNoFavouriteStops();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFavouriteStopAndUpdate(MapStop favouriteStop) {
        this.favouriteStopsViewModel.deleteFavouriteStop(favouriteStop.getIdStop());
        new BackupManager(getContext()).dataChanged();
    }

    private void setUpNoFavouriteStops() {
        this.rvFavouriteStops.setVisibility(8);
        this.ivBackgroundNoFavouriteStops.setVisibility(0);
        this.tvLabelNoFavouriteStops.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
