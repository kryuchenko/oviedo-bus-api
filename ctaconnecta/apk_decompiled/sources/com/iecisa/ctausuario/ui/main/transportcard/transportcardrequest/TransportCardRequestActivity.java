package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.info.TransportCardRequestInfoActivity;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class TransportCardRequestActivity extends CustomToolbarActivity {

    @BindView(R.id.btContinueCardRequest)
    MaterialButton btContinueCardRequest;

    @BindView(R.id.btNewCardRequest)
    MaterialButton btNewCardRequest;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_transport_card_request;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.request_card));
    }

    @OnClick({R.id.btNewCardRequest, R.id.btContinueCardRequest, R.id.btNewRepresentativeRequest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btContinueCardRequest /* 2131361922 */:
                startActivity(new Intent(this, (Class<?>) TransportCardContinueRequestActivity.class));
                break;
            case R.id.btNewCardRequest /* 2131361933 */:
                Intent intent = new Intent(this, (Class<?>) TransportCardRequestInfoActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_DOB_REPRESENTATIVE_REQUEST, false);
                startActivity(intent);
                break;
            case R.id.btNewRepresentativeRequest /* 2131361934 */:
                Intent intent2 = new Intent(this, (Class<?>) TransportCardRequestInfoActivity.class);
                intent2.putExtra(Constants.IntentData.INTENT_DOB_REPRESENTATIVE_REQUEST, true);
                startActivity(intent2);
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        setResult(-1, new Intent());
        finish();
        return true;
    }
}
