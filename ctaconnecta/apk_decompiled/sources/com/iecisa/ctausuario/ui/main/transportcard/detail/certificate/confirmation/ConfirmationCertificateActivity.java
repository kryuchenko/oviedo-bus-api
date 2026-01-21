package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.confirmation;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class ConfirmationCertificateActivity extends CustomToolbarActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvAdviceOffice)
    TextView tvAdviceOffice;

    @BindView(R.id.tvDetail)
    TextView tvDetail;

    @BindView(R.id.tvDetailTitle)
    TextView tvDetailTitle;

    @BindView(R.id.tvDetailValue)
    TextView tvDetailValue;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_confirmation_certificate;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recharge_certificate));
        if (getIntent().getExtras() != null) {
            setupView(getIntent().getStringExtra(Constants.IntentData.INTENT_DELIVERY_METHOD), getIntent().getStringExtra(Constants.IntentData.INTENT_DELIVERY_TITLE), getIntent().getStringExtra(Constants.IntentData.INTENT_DELIVERY_VALUE));
        }
    }

    private void setupView(String method, String title, String value) {
        method.hashCode();
        switch (method) {
            case "postal":
                this.tvDetail.setText(getString(R.string.label_confirmation_certificate_detail_address));
                break;
            case "cta":
                this.tvDetail.setText(getString(R.string.label_confirmation_certificate_detail_office));
                this.tvAdviceOffice.setVisibility(0);
                break;
            case "email":
                this.tvDetail.setText(getString(R.string.label_confirmation_certificate_detail_mail));
                break;
        }
        this.tvDetailTitle.setText(title);
        this.tvDetailValue.setText(value);
    }

    @OnClick({R.id.btOk})
    public void onViewClicked() {
        setResult(-1, new Intent());
        finish();
    }
}
