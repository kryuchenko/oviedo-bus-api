package com.iecisa.ctausuario.ui.main.route.selectoradress;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.route.selectoradress.SearchAdapter;
import com.iecisa.ctausuario.ui.userdestination.DestinationUserSelectorActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.maputils.BoundLocationManager;
import com.iecisa.ctausuario.utils.maputils.MapUtils;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class AddressPickerActivity extends CustomToolbarActivity {
    private AddressPickerViewModel addressPickerViewModel;
    private ActivityResultLauncher<Intent> placeLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$0((ActivityResult) obj);
        }
    });

    @BindView(R.id.rvSaveSearch)
    RecyclerView rvSaveSearch;
    private SearchAddress searchAddress;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvOrigin)
    TextView tvOrigin;

    @BindView(R.id.tvSelectOnMap)
    TextView tvSelectOnMap;

    @BindView(R.id.tvUserLocation)
    TextView tvUserLocation;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_address_picker;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        if (activityResult.getResultCode() == -1) {
            if (data != null) {
                showAndSaveLocation(MapUtils.buildSearchAddress(Autocomplete.getPlaceFromIntent(data), this), true);
            }
        } else if (activityResult.getResultCode() == 2) {
            Timber.e(Autocomplete.getStatusFromIntent(data).getStatusMessage(), new Object[0]);
        }
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.addressPickerViewModel = (AddressPickerViewModel) new ViewModelProvider(this, this.viewModelFactory).get(AddressPickerViewModelImpl.class);
        setToolbarData();
        setUpViewLastSearchs();
    }

    @OnClick({R.id.tvOrigin, R.id.tvUserLocation, R.id.tvSelectOnMap})
    public void onEventsClick(View view) {
        int id = view.getId();
        if (id == R.id.tvOrigin) {
            intentPlaceAutocomplete();
            return;
        }
        if (id != R.id.tvSelectOnMap) {
            if (id != R.id.tvUserLocation) {
                return;
            }
            checkPermissions();
        } else {
            Intent intent = new Intent(this, (Class<?>) DestinationUserSelectorActivity.class);
            if (getIntent().getExtras() != null) {
                intent.putExtra(Constants.IntentData.INTENT_ADDRESS_PICKER, getIntent().getBooleanExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, true));
            }
            startActivityForResult(intent, 1);
        }
    }

    private void onAddressSelected() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_SEARCH_ADDRESS, this.searchAddress);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        setResult(0, new Intent());
        finish();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new Intent());
        finish();
    }

    private void intentPlaceAutocomplete() {
        this.placeLauncher.launch(new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME)).setLocationRestriction(RectangularBounds.newInstance(new LatLng(Constants.MapBorder.South.doubleValue(), Constants.MapBorder.East.doubleValue()), new LatLng(Constants.MapBorder.North.doubleValue(), Constants.MapBorder.West.doubleValue()))).build(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode != 1 || intent == null || intent.getExtras() == null) {
            return;
        }
        SearchAddress searchAddress = (SearchAddress) intent.getExtras().getParcelable(Constants.IntentData.INTENT_USER_DESTINATION);
        if (searchAddress != null && !TextUtils.isEmpty(searchAddress.getNameAddress()) && !TextUtils.isEmpty(searchAddress.getDetailAddress())) {
            showAndSaveLocation(searchAddress, true);
        } else {
            showKoDialog(getString(R.string.label_error_place_location));
        }
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                return;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                return;
            }
        }
        getLocationUpdates();
    }

    private void getLocationUpdates() {
        BoundLocationManager.getInstance(getApplicationContext()).observe(this, new Observer<Location>() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Location location) {
                if (location != null) {
                    BoundLocationManager.getInstance(AddressPickerActivity.this.getApplicationContext()).removeObserver(this);
                    AddressPickerActivity.this.showAndSaveLocation(new SearchAddress(AddressPickerActivity.this.getString(R.string.label_user_location), location.getLongitude(), location.getLatitude()), false);
                } else {
                    AddressPickerActivity addressPickerActivity = AddressPickerActivity.this;
                    addressPickerActivity.showKoDialog(addressPickerActivity.getString(R.string.error_unable_establish_user_location));
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1001) {
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAndSaveLocation(SearchAddress address, boolean saveLocation) {
        this.searchAddress = address;
        this.tvOrigin.setText(address.getNameAddress());
        if (saveLocation) {
            this.addressPickerViewModel.getSearchAdress(address).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity$$ExternalSyntheticLambda5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$showAndSaveLocation$2((List) obj);
                }
            });
        } else {
            onAddressSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAndSaveLocation$2(List list) {
        if (list == null || list.isEmpty()) {
            this.addressPickerViewModel.insertSearchAddress(this.searchAddress).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity$$ExternalSyntheticLambda3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$showAndSaveLocation$1((Long) obj);
                }
            });
        } else {
            onAddressSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAndSaveLocation$1(Long l) {
        if (l != null) {
            this.addressPickerViewModel.deleteOldSearchAddresses();
        }
        onAddressSelected();
    }

    private void setUpViewLastSearchs() {
        this.addressPickerViewModel.getAllSearchAddress().observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setUpViewLastSearchs$4((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpViewLastSearchs$4(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rvSaveSearch.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvSaveSearch.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvSaveSearch.addItemDecoration(dividerItemDecoration);
        SearchAdapter searchAdapter = new SearchAdapter();
        searchAdapter.addAll(list);
        this.rvSaveSearch.setAdapter(searchAdapter);
        searchAdapter.setOnSearchAddressClickListener(new SearchAdapter.OnSearchAddressClickListener() { // from class: com.iecisa.ctausuario.ui.main.route.selectoradress.AddressPickerActivity$$ExternalSyntheticLambda2
            @Override // com.iecisa.ctausuario.ui.main.route.selectoradress.SearchAdapter.OnSearchAddressClickListener
            public final void onSearchAddressClick(SearchAddress searchAddress) {
                this.f$0.lambda$setUpViewLastSearchs$3(searchAddress);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpViewLastSearchs$3(SearchAddress searchAddress) {
        showAndSaveLocation(searchAddress, false);
    }

    private void setToolbarData() {
        String string;
        if (!(getIntent().getExtras() != null ? getIntent().getBooleanExtra(Constants.IntentData.INTENT_SEARCH_DESTINATION_ADDRESS, true) : false)) {
            string = getString(R.string.label_origin);
            this.tvOrigin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_my_location, 0, 0, 0);
        } else {
            string = getString(R.string.label_destination);
            this.tvOrigin.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pointer_destination, 0, 0, 0);
        }
        setToolbar(this.toolbar, ToolbarActions.BACK, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKoDialog(String message) {
        BaseUtils.showKoDialog(this, message);
    }
}
