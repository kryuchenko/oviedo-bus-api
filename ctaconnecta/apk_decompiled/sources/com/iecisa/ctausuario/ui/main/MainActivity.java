package com.iecisa.ctausuario.ui.main;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.accessibility.AccessibilityEventCompat;
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
import com.cexmobility.core.ui.BaseActivity$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iecisa.ctausuario.App;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.TransportCard;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment;
import com.iecisa.ctausuario.ui.main.more.MoreFragment;
import com.iecisa.ctausuario.ui.main.route.RouteFragment;
import com.iecisa.ctausuario.ui.main.stops.StopsFragment;
import com.iecisa.ctausuario.ui.main.transportcard.TransportCardFragment;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class MainActivity extends CustomToolbarActivity {
    public static final int TAB_INCIDENTS = 3;
    public static final int TAB_MORE = 4;
    public static final int TAB_ROUTE = 2;
    public static final int TAB_STOPS = 0;
    public static final int TAB_TRANSPORT_CARD = 1;
    private MainViewModel mainViewModel;
    private NfcAdapter nfcAdapter;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindViews({R.id.tvStopsActionMenu, R.id.tvTransportCardActionMenu, R.id.tvRouteActionMenu, R.id.tvIncidentsActionMenu, R.id.tvMoreActionMenu})
    List<TextView> tvMenuActions;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Fragment fragmentStops = new StopsFragment();
    private final Fragment fragmentTransportCard = new TransportCardFragment();
    private final Fragment fragmentRoute = new RouteFragment();
    private final Fragment fragmentIncidents = new IncidentsFragment();
    private final Fragment fragmentMore = new MoreFragment();

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        setFragment(this.fragmentStops);
        setTab(0);
        setToolbar(this.toolbar, ToolbarActions.NONE, getString(R.string.title_toolbar_stops));
        this.mainViewModel = (MainViewModel) new ViewModelProvider(this, this.viewModelFactory).get(MainViewModelImpl.class);
        initNFC();
        createNotificationChannel();
        retrieveNotificationToken();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(R.string.title_notifications);
            String string2 = getString(R.string.summary_notifications);
            NotificationChannel notificationChannelM = BaseActivity$$ExternalSyntheticApiModelOutline0.m("channel_id", string, 3);
            notificationChannelM.setDescription(string2);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelM);
        }
    }

    public void retrieveNotificationToken() {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this, new OnSuccessListener() { // from class: com.iecisa.ctausuario.ui.main.MainActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$retrieveNotificationToken$0((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$retrieveNotificationToken$0(String str) {
        if (str != null) {
            this.preferences.savePendingDeviceToken(str);
            App.getInstance().updateNotificationTokenStatus(str);
        }
    }

    @OnClick({R.id.tvStopsActionMenu, R.id.tvTransportCardActionMenu, R.id.tvRouteActionMenu, R.id.tvIncidentsActionMenu, R.id.tvMoreActionMenu})
    public void onClickEvents(View view) {
        switch (view.getId()) {
            case R.id.tvIncidentsActionMenu /* 2131362824 */:
                setToolbarTitle(getString(R.string.title_toolbar_incidents));
                setFragment(this.fragmentIncidents);
                setTab(3);
                break;
            case R.id.tvMoreActionMenu /* 2131362900 */:
                setToolbarTitle(getString(R.string.title_toolbar_more));
                setFragment(this.fragmentMore);
                setTab(4);
                break;
            case R.id.tvRouteActionMenu /* 2131362935 */:
                setToolbarTitle(getString(R.string.title_toolbar_route));
                setFragment(this.fragmentRoute);
                setTab(2);
                break;
            case R.id.tvStopsActionMenu /* 2131362947 */:
                setToolbarTitle(getString(R.string.title_toolbar_stops));
                setFragment(this.fragmentStops);
                setTab(0);
                break;
            case R.id.tvTransportCardActionMenu /* 2131362981 */:
                setToolbarTitle(getString(R.string.title_toolbar_transport_card));
                setFragment(this.fragmentTransportCard);
                setTab(1);
                break;
            default:
                Timber.d("Unknown Action Selected", new Object[0]);
                break;
        }
    }

    private void setFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, selectedFragment);
        fragmentTransactionBeginTransaction.commit();
    }

    private void setTab(int selectedTab) {
        for (int i = 0; i < this.tvMenuActions.size(); i++) {
            if (i == selectedTab) {
                this.tvMenuActions.get(i).setSelected(true);
            } else {
                this.tvMenuActions.get(i).setSelected(false);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (checkNFC()) {
            launchPendingIntent();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter == null || !nfcAdapter.isEnabled()) {
            return;
        }
        this.nfcAdapter.disableForegroundDispatch(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (this.fragmentTransportCard.isVisible()) {
            super.onNewIntent(intent);
            this.mainViewModel.onNfcIntentRecived(intent, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.MainActivity$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onNewIntent$1((Resource) obj);
                }
            });
            if (intent.getBooleanExtra(Constants.IntentData.INTENT_LOGIN_AFTER_CHANGE_PASSWORD, false)) {
                Intent intent2 = new Intent(this, (Class<?>) LoginUserCardActivity.class);
                intent2.putExtra(Constants.IntentData.INTENT_LOGIN_AFTER_CHANGE_PASSWORD, true);
                startActivity(intent2);
            }
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.MainActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$onNewIntent$1(Resource resource) {
        if (AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()] != 3) {
            return;
        }
        checkNFCAnswer((String) resource.data);
    }

    private void checkNFCAnswer(String data) {
        if (data != null) {
            TransportCard transportCard = new TransportCard();
            transportCard.setIdFavouriteTrasnportCard(data);
            Intent intent = new Intent(this, (Class<?>) DetailTransportCardActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_FAVOURITE_TRANSPORT_CARD_DATA, transportCard);
            startActivity(intent);
        }
    }

    private void initNFC() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    private boolean checkNFC() {
        Resource.Status statusInitNfcAdapter = this.mainViewModel.initNfcAdapter(this.nfcAdapter);
        if (statusInitNfcAdapter == Resource.Status.ERROR) {
            setResult(0, new Intent());
            return false;
        }
        if (statusInitNfcAdapter != Resource.Status.LOADING) {
            return true;
        }
        setResult(0, new Intent());
        return false;
    }

    public void launchPendingIntent() {
        Intent intent = new Intent(getApplicationContext(), getClass());
        intent.addFlags(536870912);
        this.nfcAdapter.enableForegroundDispatch(this, PendingIntent.getActivity(getApplicationContext(), 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), new IntentFilter[]{new IntentFilter("android.nfc.action.TAG_DISCOVERED"), new IntentFilter("android.nfc.action.NDEF_DISCOVERED"), new IntentFilter("android.nfc.action.TECH_DISCOVERED")}, null);
    }
}
