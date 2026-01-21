package com.iecisa.ctausuario.ui.main.transportcard.detail.alias;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.routes.ChangeAliasRequestModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ChangeAliasActivity extends CustomToolbarActivity {

    @BindView(R.id.etAlias)
    EditText etAlias;
    private String numCard;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;
    private ChangeAliasViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_change_alias;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (ChangeAliasViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(ChangeAliasViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_change_alias));
        if (getIntent().getExtras() != null) {
            String stringExtra = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_ALIAS);
            this.numCard = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            if (stringExtra != null) {
                this.etAlias.setText(stringExtra);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.btSave})
    public void onViewClicked() {
        rechargeCard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rechargeCard() {
        this.viewModel.updateAlias(this, new ChangeAliasRequestModel(this.numCard, this.etAlias.getText().toString())).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$rechargeCard$0((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
    public /* synthetic */ void lambda$rechargeCard$0(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog();
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            showOkDialog();
        }
    }

    private void showKoDialog() {
        BaseUtils.showDialog(this, 2, getString(R.string.label_ko_alias_changed), null, getString(R.string.label_retry), getString(R.string.label_retry_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                ChangeAliasActivity.this.rechargeCard();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                ChangeAliasActivity.this.setResult(0, new Intent());
                ChangeAliasActivity.this.finish();
            }
        });
    }

    private void showOkDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_ok_alias_changed), null, getString(R.string.label_ok), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.alias.ChangeAliasActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showOkDialog$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOkDialog$1() {
        Intent intent = new Intent();
        intent.putExtra(Constants.IntentData.INTENT_RECHARGE_ALIAS, this.etAlias.getText().toString());
        setResult(-1, intent);
        finish();
    }
}
