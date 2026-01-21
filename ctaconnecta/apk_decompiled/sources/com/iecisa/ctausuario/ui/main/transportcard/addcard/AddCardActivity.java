package com.iecisa.ctausuario.ui.main.transportcard.addcard;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AddCardActivity extends CustomToolbarActivity {

    @BindView(R.id.etAlias)
    EditText etAlias;

    @BindView(R.id.etCardNumber)
    EditText etCardNumber;

    @BindView(R.id.etCharacter)
    EditText etCharacter;
    private NfcAdapter nfcAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private AddCardViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_add_card;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (AddCardViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(AddCardViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_add_card));
        initNFC();
        setupNfc();
    }

    private void initNFC() {
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    private void setupNfc() {
        if (checkNFC()) {
            Intent intent = new Intent(this, (Class<?>) ReadCardNfcActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_READ_CARD, 4);
            startActivityForResult(intent, 4);
        }
    }

    private boolean checkNFC() {
        Resource.Status statusInitNfcAdapter = this.viewModel.initNfcAdapter(this.nfcAdapter);
        return (statusInitNfcAdapter == Resource.Status.ERROR || statusInitNfcAdapter == Resource.Status.LOADING) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            if (resultCode == 0) {
                onBackPressed();
            }
        } else {
            if (data == null || data.getExtras() == null) {
                return;
            }
            this.etCardNumber.setText(data.getExtras().getString(Constants.NFCValues.NFC_KEY_CARD));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @OnTextChanged({R.id.etCardNumber, R.id.etCharacter})
    public void onTextChanged() {
        if (TextUtils.isEmpty(this.etCardNumber.getText()) || TextUtils.isEmpty(this.etCharacter.getText())) {
            return;
        }
        this.tvInfoMessage.setVisibility(8);
    }

    @OnClick({R.id.btLogin})
    public void onViewClicked() {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(this.etCardNumber.getText()) && !TextUtils.isEmpty(this.etCharacter.getText())) {
            intent.putExtra(Constants.NFCValues.NFC_KEY_CARD, this.etCardNumber.getText().toString());
            intent.putExtra(Constants.NFCValues.NFC_KEY_CHARACTER, this.etCharacter.getText().toString());
            intent.putExtra(Constants.NFCValues.NFC_KEY_ALIAS, this.etAlias.getText().toString());
            setResult(-1, intent);
            finish();
            return;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(getString(R.string.label_empty_card_field));
    }
}
