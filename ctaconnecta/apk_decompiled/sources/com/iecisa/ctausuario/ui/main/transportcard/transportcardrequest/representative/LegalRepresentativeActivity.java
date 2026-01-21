package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class LegalRepresentativeActivity extends CustomToolbarActivity {

    @BindView(R.id.btStartRepresentativeRequest)
    MaterialButton btStartRepresentativeRequest;

    @BindView(R.id.cbAcceptRepresentativeRequestTerms)
    CheckBox cbAcceptRepresentativeRequestTerms;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvLabelAceptTermsRepresentativeRequest)
    TextView tvLabelAceptTermsRepresentativeRequest;
    LegalRepresentativeViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_transport_card_request_legal_representative;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (LegalRepresentativeViewModel) new ViewModelProvider(this, this.viewModelFactory).get(LegalRepresentativeViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.legal_representative));
        checkIsRepresentative();
    }

    @OnClick({R.id.tvLabelAceptTermsRepresentativeRequest, R.id.btStartRepresentativeRequest})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btStartRepresentativeRequest) {
            makeUserRepresentative();
        } else {
            if (id != R.id.tvLabelAceptTermsRepresentativeRequest) {
                return;
            }
            getLegalConditions();
        }
    }

    private void checkIsRepresentative() {
        this.viewModel.getRepresentative(this, this.preferences.getUsername()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$checkIsRepresentative$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$checkIsRepresentative$0(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (resource.data != 0) {
            if (((Boolean) resource.data).booleanValue()) {
                showIsRepresentativeDialog();
                return;
            }
            return;
        }
        BaseUtils.showKoDialog(this, getString(R.string.error_getting_is_representative));
    }

    private void getLegalConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_LEGAL_REPRESENTATIVE).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getLegalConditions$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getLegalConditions$1(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
        } else {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity.1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        LegalRepresentativeActivity.this.cbAcceptRepresentativeRequestTerms.setChecked(true);
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        LegalRepresentativeActivity.this.cbAcceptRepresentativeRequestTerms.setChecked(false);
                    }
                });
            } else {
                BaseUtils.showKoDialog(this, getString(R.string.error_getting_terms));
            }
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity$2, reason: invalid class name */
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

    private void makeUserRepresentative() {
        this.viewModel.makeUserRepresentative(this, this.preferences.getUsername()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$makeUserRepresentative$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeUserRepresentative$2(Resource resource) {
        int i = AnonymousClass2.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(this, resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            showIsRepresentativeDialog();
        }
    }

    private void showIsRepresentativeDialog() {
        BaseUtils.showInfoDialog(this, 3, getString(R.string.label_title_already_representative), getString(R.string.label_description_already_representative), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.representative.LegalRepresentativeActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showIsRepresentativeDialog$3();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp, reason: merged with bridge method [inline-methods] */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    @OnCheckedChanged({R.id.cbAcceptRepresentativeRequestTerms})
    public void onCheckedChanged(boolean checked) {
        this.btStartRepresentativeRequest.setEnabled(checked);
    }
}
