package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.OfficeResponseModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.dataprotection.CertificateRequestModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.confirmation.ConfirmationCertificateActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CertificateActivity extends CustomToolbarActivity {
    private OfficeAdapter adapter;
    private String cardNumber;
    private Integer cardTypeId;

    @BindView(R.id.cbAceptTermsPayment)
    CheckBox cbAceptTermsPayment;

    @BindView(R.id.etDocument)
    EditText etDocument;

    @BindView(R.id.etMail)
    EditText etMail;

    @BindView(R.id.etName)
    EditText etName;

    @BindView(R.id.etPhone)
    EditText etPhone;

    @BindView(R.id.etSurname)
    EditText etSurname;

    @BindView(R.id.gpImpersonal)
    Group gpImpersonal;

    @BindView(R.id.gpPersonal)
    Group gpPersonal;

    @BindView(R.id.mbRequestCertificate)
    MaterialButton mbRequestCertificate;
    private HolderResponseModel model;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.rbAddress)
    RadioButton rbAddress;

    @BindView(R.id.rbMail)
    RadioButton rbMail;

    @BindView(R.id.rbOffice)
    RadioButton rbOffice;

    @BindView(R.id.rgDeliverMethod)
    RadioGroup rgDeliverMethod;

    @BindView(R.id.spOffice)
    Spinner spOffice;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvDateSince)
    TextView tvDateSince;

    @BindView(R.id.tvDateTo)
    TextView tvDateTo;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;
    private List<ValidatorModel> validatorModelList;
    private CertificateViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_certificate;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (CertificateViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(CertificateViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_recharge_certificate));
        if (getIntent().getExtras() != null) {
            this.cardTypeId = Integer.valueOf(getIntent().getIntExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_TYPE, 1));
            this.cardNumber = getIntent().getStringExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            loadOffices();
        }
    }

    private void getDetailAccount() {
        if (this.preferences.getUser().equals(1) && (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA) || this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO))) {
            this.viewModel.getDetailsAccount(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$$ExternalSyntheticLambda4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$getDetailAccount$0((Resource) obj);
                }
            });
        } else {
            setupAnonymousView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getDetailAccount$0(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            setupAnonymousView();
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
            createValidatorPass();
            this.model = (HolderResponseModel) resource.data;
            setupView();
        }
    }

    private void setupAnonymousView() {
        createValidatorAccount();
        this.rbAddress.setVisibility(8);
        this.rbMail.setVisibility(8);
    }

    private void loadOffices() {
        this.viewModel.loadOffices(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$loadOffices$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadOffices$1(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            getDetailAccount();
            this.rbOffice.setVisibility(8);
        } else {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            hideLoading();
            getDetailAccount();
            if (resource.data == 0 || ((List) resource.data).size() <= 0) {
                return;
            }
            setupAdapterOffices((List) resource.data);
        }
    }

    private void setupAdapterOffices(List<OfficeResponseModel> data) {
        OfficeAdapter officeAdapter = this.adapter;
        if (officeAdapter != null) {
            officeAdapter.addAll(data);
            return;
        }
        OfficeAdapter officeAdapter2 = new OfficeAdapter(this, data);
        this.adapter = officeAdapter2;
        officeAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spOffice.setAdapter((SpinnerAdapter) this.adapter);
    }

    private void setupView() {
        this.gpPersonal.setVisibility(8);
        HolderResponseModel holderResponseModel = this.model;
        if (holderResponseModel != null) {
            this.rbAddress.setText(getString(R.string.label_deliver_address, new Object[]{holderResponseModel.getAddress(), this.model.getPostalCode(), this.model.getCity(), this.model.getProvince()}));
            this.rbMail.setText(getString(R.string.label_deliver_mail, new Object[]{this.model.getEmail()}));
        }
    }

    private void createValidatorAccount() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(5, this.tvDateSince));
        this.validatorModelList.add(new ValidatorModel(5, this.tvDateTo));
        this.validatorModelList.add(new ValidatorModel(5, this.etName));
        this.validatorModelList.add(new ValidatorModel(5, this.etSurname));
        this.validatorModelList.add(new ValidatorModel(21, this.etDocument));
        this.validatorModelList.add(new ValidatorModel(6, this.etPhone));
        this.validatorModelList.add(new ValidatorModel(1, this.etMail));
        this.validatorModelList.add(new ValidatorModel(3, this.cbAceptTermsPayment.isChecked()));
        validateFields();
    }

    private void createValidatorPass() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(10, this.tvDateSince));
        this.validatorModelList.add(new ValidatorModel(10, this.tvDateTo));
        validateFields();
    }

    @OnTextChanged({R.id.tvDateSince})
    public void onTextChangedDateSince(CharSequence text) {
        onTexchangedValidator(text, this.tvDateSince);
    }

    @OnTextChanged({R.id.tvDateTo})
    public void onTextChangedDateTo(CharSequence text) {
        onTexchangedValidator(text, this.tvDateTo);
    }

    @OnTextChanged({R.id.etName})
    public void onTextChangedName(CharSequence text) {
        onTexchangedValidator(text, this.etName);
    }

    @OnTextChanged({R.id.etSurname})
    public void onTextChangedSurname(CharSequence text) {
        onTexchangedValidator(text, this.etSurname);
    }

    @OnTextChanged({R.id.etDocument})
    public void onTextChangedDocument(CharSequence text) {
        onTexchangedValidator(text, this.etDocument);
    }

    @OnTextChanged({R.id.etPhone})
    public void onTextChangedPhone(CharSequence text) {
        onTexchangedValidator(text, this.etPhone);
    }

    @OnTextChanged({R.id.etMail})
    public void onTextChangedMail(CharSequence text) {
        onTexchangedValidator(text, this.etMail);
    }

    @OnCheckedChanged({R.id.cbAceptTermsPayment})
    public void onCheckedChanged(boolean checked) {
        ValidatorUtils.setValidatorChecked(checked, this.validatorModelList);
        validateFields();
    }

    private void onTexchangedValidator(CharSequence text, TextView textView) {
        if (!TextUtils.isEmpty(text)) {
            ValidatorUtils.activateValidator(textView, this.validatorModelList);
        }
        validateFields();
    }

    private boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(this, this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvErrorMessage.setVisibility(8);
            this.mbRequestCertificate.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvErrorMessage.setVisibility(8);
            this.mbRequestCertificate.setEnabled(false);
            return false;
        }
        this.tvErrorMessage.setVisibility(0);
        this.tvErrorMessage.setText(validatorResponseModelValidateField.getMessage());
        this.mbRequestCertificate.setEnabled(false);
        return false;
    }

    @OnClick({R.id.tvDateSince, R.id.tvDateTo, R.id.mbRequestCertificate, R.id.tvLabelAceptTermsPayment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mbRequestCertificate /* 2131362401 */:
                loadData();
                break;
            case R.id.tvDateSince /* 2131362791 */:
                loadDatePicker(this.tvDateSince);
                break;
            case R.id.tvDateTo /* 2131362792 */:
                loadDatePicker(this.tvDateTo);
                break;
            case R.id.tvLabelAceptTermsPayment /* 2131362832 */:
                setupConditions();
                break;
        }
    }

    private void setupConditions() {
        this.viewModel.getLegalConditions(this, BuildConfig.CONDITIONS_CERTIFICATE_RECHARGE).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupConditions$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupConditions$2(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            return;
        }
        if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                BaseUtils.showDialog(this, 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity.1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickPositive() {
                        CertificateActivity.this.cbAceptTermsPayment.setChecked(true);
                    }

                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                    public void onClickNegative() {
                        CertificateActivity.this.cbAceptTermsPayment.setChecked(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_ABONO_CTA) || this.cardTypeId.equals(Constants.Cards.TRANSPORT_CARD_TYPE_BILLETE_UNICO)) {
            if (checkDates()) {
                createCertificate(new CertificateRequestModel(BaseUtils.getUserId(this.preferences.getBearerToken()), this.cardNumber, DateUtils.getDateTimeReports(this.tvDateSince.getText().toString()), DateUtils.getDateTimeReports(this.tvDateTo.getText().toString())));
            }
        } else if (checkDates()) {
            createCertificate(new CertificateRequestModel(this.etName.getText().toString(), this.etSurname.getText().toString(), this.etDocument.getText().toString(), this.etPhone.getText().toString(), this.etMail.getText().toString(), this.cardNumber, DateUtils.getDateTimeReports(this.tvDateSince.getText().toString()), DateUtils.getDateTimeReports(this.tvDateTo.getText().toString())));
        }
    }

    private void createCertificate(CertificateRequestModel requestModel) {
        OfficeResponseModel officeResponseModel;
        requestModel.setDeliveryMethod(getDeliveryMethod());
        if (getDeliveryMethod().equals(Constants.DeliveryMethod.OFFICE) && (officeResponseModel = (OfficeResponseModel) this.spOffice.getSelectedItem()) != null) {
            requestModel.setOfficeId(officeResponseModel.getId());
        }
        this.viewModel.createCertificate(this, requestModel).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$createCertificate$3((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
    public /* synthetic */ void lambda$createCertificate$3(Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            showKoDialog(resource.message);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            goToSuccessCertificate();
        }
    }

    private void goToSuccessCertificate() {
        String email;
        String string;
        if (getDeliveryMethod().equals(Constants.DeliveryMethod.OFFICE)) {
            OfficeResponseModel officeResponseModel = (OfficeResponseModel) this.spOffice.getSelectedItem();
            email = officeResponseModel.getName();
            string = getString(R.string.label_office_detail_row, new Object[]{officeResponseModel.getAddress(), officeResponseModel.getPostalCode(), officeResponseModel.getTown()});
        } else if (getDeliveryMethod().equals(Constants.DeliveryMethod.ADDRESS)) {
            email = this.model.getAddress();
            string = getString(R.string.label_office_detail_row, new Object[]{this.model.getCity(), this.model.getProvince(), this.model.getPostalCode()});
        } else {
            email = this.model.getEmail();
            string = null;
        }
        Intent intent = new Intent(this, (Class<?>) ConfirmationCertificateActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_DELIVERY_METHOD, getDeliveryMethod());
        intent.putExtra(Constants.IntentData.INTENT_DELIVERY_TITLE, email);
        intent.putExtra(Constants.IntentData.INTENT_DELIVERY_VALUE, string);
        startActivityForResult(intent, 11);
    }

    private void showKoDialog(String description) {
        BaseUtils.showDialog(this, 2, getString(R.string.error), description, getString(R.string.label_retry), getString(R.string.label_retry_later), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity.2
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                CertificateActivity.this.loadData();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                CertificateActivity.this.onBackPressed();
            }
        });
    }

    private boolean checkDates() {
        if (TextUtils.isEmpty(this.tvDateSince.getText()) && TextUtils.isEmpty(this.tvDateTo.getText())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (TextUtils.isEmpty(this.tvDateSince.getText())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date_since));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (TextUtils.isEmpty(this.tvDateTo.getText())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date_to));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (DateUtils.compareDates(this.tvDateSince.getText().toString(), this.tvDateTo.getText().toString())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_compare_dates));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (DateUtils.afterNow(this.tvDateSince.getText().toString()) && DateUtils.afterNow(this.tvDateTo.getText().toString())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date_before));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (DateUtils.afterNow(this.tvDateSince.getText().toString())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date_before_since));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        if (DateUtils.afterNow(this.tvDateTo.getText().toString())) {
            this.tvErrorMessage.setText(getString(R.string.label_empty_certificate_field_date_before_to));
            this.tvErrorMessage.setVisibility(0);
            return false;
        }
        this.tvErrorMessage.setVisibility(8);
        return true;
    }

    private String getDeliveryMethod() {
        int checkedRadioButtonId = this.rgDeliverMethod.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.rbAddress) {
            return Constants.DeliveryMethod.ADDRESS;
        }
        if (checkedRadioButtonId == R.id.rbMail) {
            return "email";
        }
        return Constants.DeliveryMethod.OFFICE;
    }

    private void loadDatePicker(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.CertificateActivity$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$loadDatePicker$4(textView, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDatePicker$4(TextView textView, DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3);
        showDate(calendar, textView);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == -1) {
            onBackPressed();
        }
    }

    private void showDate(Calendar date, TextView textView) {
        textView.setText(new SimpleDateFormat(DateUtils.DATE_FORMAT, Constants.SPANISH).format(date.getTime()));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        return true;
    }
}
