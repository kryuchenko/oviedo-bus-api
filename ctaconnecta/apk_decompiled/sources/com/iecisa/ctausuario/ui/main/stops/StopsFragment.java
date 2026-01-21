package com.iecisa.ctausuario.ui.main.stops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindViews;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.stops.favouritestops.FavouriteStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.mapstops.MapStopsFragment;
import com.iecisa.ctausuario.ui.main.stops.searchstop.SearchStopsFragment;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class StopsFragment extends BaseFragment {
    public static final int TAB_FAVOURITE_STOPS = 2;
    public static final int TAB_STOPS_MAP = 0;
    public static final int TAB_STOPS_SEARCH = 1;
    private int activeTab;
    private FragmentManager fragmentManager;

    @BindViews({R.id.ivMapStopAction, R.id.ivSearchStopAction, R.id.ivFavouriteStopAction})
    List<ImageView> ivStopsActions;
    private final Fragment fragmentMapStops = new MapStopsFragment();
    private final Fragment fragmentSearchStops = new SearchStopsFragment();
    private final Fragment fragmentFavouriteStops = new FavouriteStopsFragment();

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_stops;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
    }

    @Override // com.cexmobility.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NoSuchMethodException, SecurityException {
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        this.fragmentManager = getChildFragmentManager();
        int i = this.activeTab;
        if (i == 0) {
            setFragment(this.fragmentMapStops);
        } else if (i == 1) {
            setFragment(this.fragmentSearchStops);
        } else if (i == 2) {
            setFragment(this.fragmentFavouriteStops);
        }
        setTab(this.activeTab);
        return viewOnCreateView;
    }

    @OnClick({R.id.ivMapStopAction, R.id.ivSearchStopAction, R.id.ivFavouriteStopAction})
    public void onClickEvents(View view) {
        int id = view.getId();
        if (id == R.id.ivFavouriteStopAction) {
            setFragment(this.fragmentFavouriteStops);
            setTab(2);
            this.activeTab = 2;
        } else if (id == R.id.ivMapStopAction) {
            setFragment(this.fragmentMapStops);
            setTab(0);
            this.activeTab = 0;
        } else {
            if (id == R.id.ivSearchStopAction) {
                setFragment(this.fragmentSearchStops);
                setTab(1);
                this.activeTab = 1;
                return;
            }
            Timber.d("Unknown Action Selected", new Object[0]);
        }
    }

    private void setTab(int selectedTab) {
        for (int i = 0; i < this.ivStopsActions.size(); i++) {
            if (i == selectedTab) {
                this.ivStopsActions.get(i).setSelected(true);
            } else {
                this.ivStopsActions.get(i).setSelected(false);
            }
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }
}
