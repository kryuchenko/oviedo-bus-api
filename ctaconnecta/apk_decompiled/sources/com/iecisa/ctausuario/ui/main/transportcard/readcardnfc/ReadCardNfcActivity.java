package com.iecisa.ctausuario.ui.main.transportcard.readcardnfc;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseActivity;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ReadCardNfcActivity extends BaseActivity {
    private boolean close = false;
    private Integer id;

    @BindView(R.id.lottieCard)
    LottieAnimationView lottieAnimationView;
    private NfcAdapter nfcAdapter;
    private ReadCardNfcViewModel readCardNfcViewModel;

    @BindView(R.id.tvInfo)
    TextView tvInfo;

    @BindView(R.id.tvLabelChangeMyMind)
    TextView tvLabelChangeMyMind;

    @BindView(R.id.tvLabelGetCardCloseToPhone)
    TextView tvLabelGetCardCloseToPhone;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_read_card_nfc;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.readCardNfcViewModel = (ReadCardNfcViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(ReadCardNfcViewModelImpl.class);
        this.lottieAnimationView.setRepeatCount(-1);
        this.lottieAnimationView.playAnimation();
        setupView();
        initNFC();
    }

    private void setupView() {
        Integer numValueOf = Integer.valueOf(getIntent().getIntExtra(Constants.IntentData.INTENT_READ_CARD, 0));
        this.id = numValueOf;
        if (numValueOf.intValue() == 0 || this.id.intValue() == 8 || this.id.intValue() == 4) {
            this.tvLabelChangeMyMind.setText(getString(R.string.label_pay_card_without_nfc));
        } else if (this.id.intValue() == 1) {
            this.tvLabelChangeMyMind.setText(getString(R.string.label_not_have_card));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (checkNFC()) {
            comeBackToReadNFC();
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
        super.onNewIntent(intent);
        this.readCardNfcViewModel.onNfcIntentRecived(intent, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onNewIntent$0((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$onNewIntent$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            setResult(0, new Intent());
            showErrorNfc(getString(R.string.error_inspection_nfc), getString(R.string.error_card_can_not_read_card_broken));
        } else {
            if (i != 3) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(Constants.NFCValues.NFC_KEY_CARD, (String) resource.data);
            setResult(-1, intent);
            finish();
        }
    }

    @OnClick({R.id.tvLabelChangeMyMind})
    public void onChangeMyMindClickEvent() {
        setResult(1, new Intent());
        finish();
        this.close = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || data.getExtras() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(Constants.NFCValues.NFC_KEY_CARD, data.getExtras().getString(Constants.NFCValues.NFC_KEY_CARD));
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, new Intent());
        finish();
        this.close = true;
    }

    private void showErrorNfc(String textErrorLabel, String textError) {
        this.tvLabelGetCardCloseToPhone.setText(textErrorLabel);
    }

    private void comeBackToReadNFC() {
        this.tvLabelGetCardCloseToPhone.setText(getString(R.string.label_get_card_close_to_phone));
    }

    private void initNFC() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    private boolean checkNFC() {
        Resource.Status statusInitNfcAdapter = this.readCardNfcViewModel.initNfcAdapter(this.nfcAdapter);
        if (statusInitNfcAdapter == Resource.Status.ERROR) {
            setResult(0, new Intent());
            showErrorNfc(getString(R.string.label_error_inspection_nfc_off), getString(R.string.error_inspection_nfc_off));
            return false;
        }
        if (statusInitNfcAdapter != Resource.Status.LOADING) {
            return true;
        }
        setResult(0, new Intent());
        showErrorNfc(getString(R.string.label_error_inspection_nfc_off), getString(R.string.error_inspection_nfc_off));
        return false;
    }

    private void launchPendingIntent() {
        Intent intent = new Intent(getApplicationContext(), getClass());
        intent.addFlags(536870912);
        this.nfcAdapter.enableForegroundDispatch(this, PendingIntent.getActivity(getApplicationContext(), 0, intent, MediaHttpDownloader.MAXIMUM_CHUNK_SIZE), new IntentFilter[]{new IntentFilter("android.nfc.action.TAG_DISCOVERED"), new IntentFilter("android.nfc.action.NDEF_DISCOVERED"), new IntentFilter("android.nfc.action.TECH_DISCOVERED")}, null);
    }
}
