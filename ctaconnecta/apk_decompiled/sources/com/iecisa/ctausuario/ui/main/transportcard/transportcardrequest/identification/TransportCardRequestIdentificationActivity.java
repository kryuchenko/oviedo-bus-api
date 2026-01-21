package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.identification;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class TransportCardRequestIdentificationActivity extends CustomToolbarActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvUserId)
    TextView tvUserId;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_transport_card_request_identification;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.request_card));
        setupView();
    }

    private void setupView() {
        Intent intent = getIntent();
        if (intent != null) {
            this.tvUserId.setText(intent.getStringExtra(Constants.IntentData.INTENT_DOB_USER_ID));
        }
    }

    @OnClick({R.id.btContinueCardRequest})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.btContinueCardRequest) {
            return;
        }
        setResult(-1, new Intent());
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        setResult(-1, new Intent());
        finish();
        return true;
    }
}
