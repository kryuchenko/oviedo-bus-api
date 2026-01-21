package com.iecisa.ctausuario.ui.main.stops.detailstop;

import android.app.backup.BackupManager;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.MapStop;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.stops.detailstop.alllines.AllLinesFragment;
import com.iecisa.ctausuario.ui.main.stops.detailstop.nextarrvials.NextArrivalsFragment;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class DetailStopActivity extends CustomToolbarActivity {
    public static final int TAB_ALL_LINES = 1;
    public static final int TAB_NEXT_ARRIVALS = 0;
    private static Boolean destinationSearchAddessActive;
    private static MapStop mapStop;
    private static SearchAddress searchAddressDestination;
    private DetailStopViewModel detailStopViewModel;
    private MenuItem menuItem;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindViews({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    List<TextView> tvStopsAction;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.vpContainer)
    ViewPager vpContainer;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragmentNextArrivals = new NextArrivalsFragment();
    private Fragment fragmentAllLines = new AllLinesFragment();

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_detail_stop;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.detailStopViewModel = (DetailStopViewModel) new ViewModelProvider(this, this.viewModelFactory).get(DetailStopViewModelImpl.class);
        setUpNavigationBar();
        setUpToolbar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, getSearchAddressDestination());
        intent.putExtra(Constants.IntentData.INTENT_DESTINATION_FILTER_ENABLED, isDestinationSearchAddessActive());
        setResult(-1, intent);
        onBackPressed();
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_drawer, menu);
        this.menuItem = menu.findItem(R.id.nav_favourite);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.menuItem = menu.findItem(R.id.nav_favourite);
        checkStopIsFavourite();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_favourite) {
            onClickFavouriteStop();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_stop_detail));
        if (getIntent().getExtras() != null) {
            mapStop = (MapStop) getIntent().getParcelableExtra(Constants.IntentData.INTENT_MAP_STOP_DETAIL);
            searchAddressDestination = (SearchAddress) getIntent().getExtras().getParcelable(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS);
            destinationSearchAddessActive = Boolean.valueOf(getIntent().getExtras().getBoolean(Constants.IntentData.INTENT_DESTINATION_FILTER_ENABLED));
            MapStop mapStop2 = mapStop;
            if (mapStop2 != null) {
                setToolbarTitle(mapStop2.getNameStop(), "Parada " + String.valueOf(mapStop.getIdStop()));
            }
        }
    }

    private void setUpNavigationBar() {
        this.tvStopsAction.get(0).setText(getString(R.string.label_tab_next_arrivals));
        this.tvStopsAction.get(0).setSelected(true);
        this.tvStopsAction.get(1).setText(getString(R.string.label_tab_all_lines));
        this.tvStopsAction.get(1).setSelected(false);
        setFragment(this.fragmentNextArrivals);
        setTab(0);
    }

    @OnClick({R.id.tvInfoTransportCardAction, R.id.tvRechargeTransportCardAction})
    public void onClickEvents(View view) {
        int id = view.getId();
        if (id == R.id.tvInfoTransportCardAction) {
            setFragment(this.fragmentNextArrivals);
            setTab(0);
        } else if (id == R.id.tvRechargeTransportCardAction) {
            setFragment(this.fragmentAllLines);
            setTab(1);
        } else {
            Timber.w("Unknown Action Selected", new Object[0]);
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    private void setTab(int selectedTab) {
        for (int i = 0; i < this.tvStopsAction.size(); i++) {
            if (i == selectedTab) {
                this.tvStopsAction.get(i).setSelected(true);
            } else {
                this.tvStopsAction.get(i).setSelected(false);
            }
        }
    }

    private void checkStopIsFavourite() {
        this.detailStopViewModel.isFavouriteStopInDB(mapStop.getIdStop()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkStopIsFavourite$0((MapStop) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkStopIsFavourite$0(MapStop mapStop2) {
        if (mapStop2 != null) {
            showStopAsFavourite();
            mapStop.setFavourite(true);
        } else {
            showStopAsNotFavourite();
            mapStop.setFavourite(false);
        }
    }

    private void showStopAsFavourite() {
        this.menuItem.setIcon(R.drawable.ic_heart_fill);
        this.menuItem.setTitle(R.string.label_favourite_stop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStopAsNotFavourite() {
        this.menuItem.setIcon(R.drawable.ic_heart_outlined);
        this.menuItem.setTitle(R.string.label_not_favourite_stop);
    }

    private void onClickFavouriteStop() {
        if (!this.preferences.isMessageCloudShown().booleanValue()) {
            showCloudDialog();
        } else {
            setFavouriteStop();
        }
    }

    private void showCloudDialog() {
        BaseUtils.showDialog(this, 0, getString(R.string.label_title_save_drive), getString(R.string.label_description_save_drive), getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                DetailStopActivity.this.preferences.messageCloudShown();
                DetailStopActivity.this.preferences.activateCloud();
                DetailStopActivity.this.setFavouriteStop();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                DetailStopActivity.this.preferences.messageCloudShown();
                DetailStopActivity.this.preferences.desactivateCloud();
                DetailStopActivity.this.setFavouriteStop();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFavouriteStop() {
        if (mapStop.isFavourite()) {
            BaseUtils.showDialog(this, 1, getString(R.string.label_confirm_stop_deletion), getString(R.string.label_confirm_stop_deletion_confirm, new Object[]{mapStop.getNameStop()}), getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.stops.detailstop.DetailStopActivity.2
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                public void onClickNegative() {
                }

                @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                public void onClickPositive() {
                    DetailStopActivity.this.detailStopViewModel.deleteFavouriteStop(DetailStopActivity.mapStop.getIdStop());
                    DetailStopActivity.this.showStopAsNotFavourite();
                    DetailStopActivity.mapStop.setFavourite(false);
                }
            });
        } else {
            this.detailStopViewModel.insertFavouriteStop(mapStop);
            showStopAsFavourite();
            mapStop.setFavourite(true);
        }
        new BackupManager(this).dataChanged();
    }

    public static MapStop getMapStop() {
        return mapStop;
    }

    public static SearchAddress getSearchAddressDestination() {
        return searchAddressDestination;
    }

    public static void setSearchAddressDestination(SearchAddress searchAddressDestination2) {
        searchAddressDestination = searchAddressDestination2;
    }

    public static boolean isDestinationSearchAddessActive() {
        return destinationSearchAddessActive.booleanValue();
    }

    public static void setDestinationSearchAddessActive(boolean destinationSearchAddessActive2) {
        destinationSearchAddessActive = Boolean.valueOf(destinationSearchAddessActive2);
    }
}
