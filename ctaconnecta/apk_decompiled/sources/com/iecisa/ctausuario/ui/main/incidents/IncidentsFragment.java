package com.iecisa.ctausuario.ui.main.incidents;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.messaging.Constants;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.HolderResponseModel;
import com.iecisa.ctausuario.model.IncidenceTypeResponseModel;
import com.iecisa.ctausuario.model.LoginRequest;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.model.incidence.IncidenceRequestModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.transportcard.detail.incident.IncidentActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import com.iecisa.ctausuario.utils.ValidatorUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class IncidentsFragment extends BaseFragment {

    @BindView(R.id.btCamera)
    MaterialButton btCamera;

    @BindView(R.id.btSendIncident)
    MaterialButton btSendIncident;

    @BindView(R.id.cbAceptTerms)
    CheckBox cbAcceptTerms;

    @BindView(R.id.cvFirstPicture)
    CardView cvFirstPicture;

    @BindView(R.id.cvSecondPicture)
    CardView cvSecondPicture;

    @BindView(R.id.etCommentIncidence)
    EditText etCommentIncidence;

    @BindView(R.id.etLastname)
    EditText etLastname;

    @BindView(R.id.etSecondPhone)
    EditText etSecondPhone;

    @BindView(R.id.etUserEmail)
    EditText etUserEmail;

    @BindView(R.id.etName)
    EditText etUserName;

    @BindView(R.id.etCard)
    EditText etUserNumberTransportCard;

    @BindView(R.id.etPhone)
    EditText etUserPhone;

    @BindView(R.id.etSurname)
    EditText etUserSurname;
    private HolderResponseModel holderModel;
    private IncidenceTypeAdapter incidenceAdapter;
    private IncidenceTypeResponseModel incidenceTypeModel;

    @BindView(R.id.ivFirstDelete)
    ImageView ivFirstDelete;

    @BindView(R.id.ivFirstPicture)
    ImageView ivFirstPicture;
    private ImageView ivPhoto;

    @BindView(R.id.ivSecondDelete)
    ImageView ivSecondDelete;

    @BindView(R.id.ivSecondPicture)
    ImageView ivSecondPicture;

    @BindView(R.id.mbLogin)
    TextView mbLogin;

    @Inject
    public PreferencesHelper preferences;

    @BindView(R.id.sTypeIncident)
    AutoCompleteTextView sTypeIncident;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;

    @BindView(R.id.tvLabelAceptTerms)
    TextView tvLabelAcceptTerms;

    @BindView(R.id.tvLabelCard)
    TextView tvLabelCard;
    private List<ValidatorModel> validatorModelList;
    private IncidentsViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public void onError() {
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_incidents;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        if (this.viewModel == null) {
            this.viewModel = (IncidentsViewModel) new ViewModelProvider(this, this.viewModelFactory).get(IncidentsViewModelImpl.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setupView();
        setupListeners();
        createValidator();
        if (this.incidenceTypeModel != null) {
            this.btSendIncident.setEnabled(true);
        }
        validateFields();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.preferences.setLoginUser();
    }

    private void setupView() {
        if (getActivity() instanceof IncidentActivity) {
            TransportCardModel model = ((IncidentActivity) getActivity()).getModel();
            this.tvLabelCard.setText(getString(R.string.label_user_number_transport_card_mandatory));
            loadDetailCard(model);
            if (this.incidenceTypeModel == null) {
                getIncidentTypes(model.getCardNumber());
            } else {
                this.sTypeIncident.setAdapter(this.incidenceAdapter);
            }
        } else if (this.preferences.getUser().equals(0) && this.preferences.getBearerToken() == null) {
            login();
        } else if (this.incidenceTypeModel == null) {
            getIncidentTypes(null);
        } else {
            this.sTypeIncident.setAdapter(this.incidenceAdapter);
        }
        if (this.preferences.getUser().equals(1)) {
            this.mbLogin.setVisibility(8);
            getHolderData();
        } else if (this.preferences.getUser().equals(4)) {
            this.mbLogin.setVisibility(8);
        } else {
            this.mbLogin.setVisibility(0);
        }
    }

    private void setupListeners() {
        this.sTypeIncident.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$0(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$0(AdapterView adapterView, View view, int i, long j) {
        IncidenceTypeAdapter incidenceTypeAdapter = this.incidenceAdapter;
        if (incidenceTypeAdapter != null) {
            this.incidenceTypeModel = incidenceTypeAdapter.getItem(i);
            BaseUtils.setupAdapter(this.incidenceAdapter, this.sTypeIncident);
        }
    }

    private void createValidator() {
        ArrayList arrayList = new ArrayList();
        this.validatorModelList = arrayList;
        arrayList.add(new ValidatorModel(5, this.etCommentIncidence));
        if (!TextUtils.isEmpty(this.etCommentIncidence.getText())) {
            ValidatorUtils.activateValidator(this.etCommentIncidence, this.validatorModelList);
        }
        this.validatorModelList.add(new ValidatorModel(5, this.etUserName));
        if (!TextUtils.isEmpty(this.etUserName.getText())) {
            ValidatorUtils.activateValidator(this.etUserName, this.validatorModelList);
        }
        this.validatorModelList.add(new ValidatorModel(5, this.etUserSurname));
        if (!TextUtils.isEmpty(this.etUserSurname.getText())) {
            ValidatorUtils.activateValidator(this.etUserSurname, this.validatorModelList);
        }
        this.validatorModelList.add(new ValidatorModel(5, this.etLastname));
        if (!TextUtils.isEmpty(this.etLastname.getText())) {
            ValidatorUtils.activateValidator(this.etLastname, this.validatorModelList);
        }
        this.validatorModelList.add(new ValidatorModel(1, this.etUserEmail));
        if (!TextUtils.isEmpty(this.etUserEmail.getText())) {
            ValidatorUtils.activateValidator(this.etUserEmail, this.validatorModelList);
        }
        this.validatorModelList.add(new ValidatorModel(8, this.etUserPhone));
        ValidatorUtils.activateValidator(this.etUserPhone, this.validatorModelList);
        this.validatorModelList.add(new ValidatorModel(9, this.etSecondPhone));
        ValidatorUtils.activateValidator(this.etSecondPhone, this.validatorModelList);
        this.validatorModelList.add(new ValidatorModel(3, this.cbAcceptTerms.isChecked()));
        if (this.cbAcceptTerms.isChecked()) {
            ValidatorUtils.setValidatorChecked(true, this.validatorModelList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateFields() {
        ValidatorResponseModel validatorResponseModelValidateField = ValidatorUtils.validateField(getContext(), this.validatorModelList);
        ValidatorUtils.showErrorField(validatorResponseModelValidateField.getModel(), this.validatorModelList);
        if (validatorResponseModelValidateField.getMessage() == null) {
            this.tvInfoMessage.setVisibility(8);
            this.btSendIncident.setEnabled(true);
            return true;
        }
        if (validatorResponseModelValidateField.getMessage().isEmpty()) {
            this.tvInfoMessage.setVisibility(8);
            this.btSendIncident.setEnabled(false);
            return false;
        }
        this.tvInfoMessage.setVisibility(0);
        this.tvInfoMessage.setText(validatorResponseModelValidateField.getMessage());
        this.btSendIncident.setEnabled(false);
        return false;
    }

    private void login() {
        this.viewModel.login(new LoginRequest(BuildConfig.LOGIN_USER, BuildConfig.LOGIN_PASS), getActivity()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$login$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$login$1(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_login_error, resource.message));
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0) {
            this.preferences.saveTokens(((TokenModel) resource.data).getToken(), ((TokenModel) resource.data).getRefreshToken());
            if (this.incidenceTypeModel == null) {
                getIncidentTypes(null);
                return;
            } else {
                this.sTypeIncident.setAdapter(this.incidenceAdapter);
                hideLoading();
                return;
            }
        }
        hideLoading();
        BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_login_error));
    }

    private void getIncidentTypes(String cardNumber) {
        this.viewModel.getTypeIncidence(getContext(), cardNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getIncidentTypes$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getIncidentTypes$2(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_type_error, resource.message));
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0 && ((List) resource.data).size() > 0) {
            loadIncidenceAdapter((List) resource.data);
            hideLoading();
        } else {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_type_error));
        }
    }

    private void loadIncidenceAdapter(List<IncidenceTypeResponseModel> incidentTypes) {
        IncidenceTypeAdapter incidenceTypeAdapter = this.incidenceAdapter;
        if (incidenceTypeAdapter != null) {
            incidenceTypeAdapter.setModelList(incidentTypes);
            this.incidenceAdapter.notifyDataSetChanged();
        } else {
            IncidenceTypeAdapter incidenceTypeAdapter2 = new IncidenceTypeAdapter(getContext(), incidentTypes);
            this.incidenceAdapter = incidenceTypeAdapter2;
            incidenceTypeAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
        this.sTypeIncident.setAdapter(this.incidenceAdapter);
        this.sTypeIncident.setText(incidentTypes.get(0).getName());
        this.incidenceTypeModel = incidentTypes.get(0);
        BaseUtils.setupAdapter(this.incidenceAdapter, this.sTypeIncident);
    }

    private void getHolderData() {
        this.viewModel.getDetailsAccount(getContext()).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getHolderData$3((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getHolderData$3(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_holder_error, resource.message));
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        if (resource.data != 0) {
            this.holderModel = (HolderResponseModel) resource.data;
            loadHolderData();
            hideLoading();
        } else {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_holder_error));
        }
    }

    private void loadHolderData() {
        this.etUserName.setText(this.holderModel.getName());
        if (!TextUtils.isEmpty(this.etUserName.getText())) {
            ValidatorUtils.activateValidator(this.etUserName, this.validatorModelList);
        }
        this.etUserSurname.setText(this.holderModel.getSurname());
        if (!TextUtils.isEmpty(this.etUserSurname.getText())) {
            ValidatorUtils.activateValidator(this.etUserSurname, this.validatorModelList);
        }
        this.etLastname.setText(this.holderModel.getLastName());
        if (!TextUtils.isEmpty(this.etLastname.getText())) {
            ValidatorUtils.activateValidator(this.etLastname, this.validatorModelList);
        }
        this.etUserEmail.setText(this.holderModel.getEmail());
        if (!TextUtils.isEmpty(this.etUserEmail.getText())) {
            ValidatorUtils.activateValidator(this.etUserEmail, this.validatorModelList);
        }
        this.etUserPhone.setText(this.holderModel.getMobilePhone());
        if (!TextUtils.isEmpty(this.etUserPhone.getText())) {
            ValidatorUtils.activateValidator(this.etUserPhone, this.validatorModelList);
        }
        this.etSecondPhone.setText(this.holderModel.getPhone());
        if (!TextUtils.isEmpty(this.etSecondPhone.getText())) {
            ValidatorUtils.activateValidator(this.etSecondPhone, this.validatorModelList);
        }
        this.mbLogin.setVisibility(8);
        validateFields();
    }

    private void loadDetailCard(TransportCardModel model) {
        this.etUserNumberTransportCard.setText(model.getCardNumber());
        this.etUserNumberTransportCard.setEnabled(false);
    }

    @OnClick({R.id.mbLogin, R.id.btSendIncident, R.id.tvLabelAceptTerms, R.id.ivFirstPicture, R.id.ivSecondPicture, R.id.btCamera})
    public void onEventClickListener(View view) {
        switch (view.getId()) {
            case R.id.btCamera /* 2131361920 */:
                showBottomSheet();
                break;
            case R.id.btSendIncident /* 2131361944 */:
                createIncidence();
                break;
            case R.id.ivFirstPicture /* 2131362287 */:
            case R.id.ivSecondPicture /* 2131362303 */:
                showDialogRemoveImage(view);
                break;
            case R.id.mbLogin /* 2131362389 */:
                Intent intent = new Intent(getActivity(), (Class<?>) LoginUserCardActivity.class);
                intent.putExtra(Constants.IntentData.INTENT_REQUEST_INCIDENT, 0);
                startActivityForResult(intent, 0);
                break;
            case R.id.tvLabelAceptTerms /* 2131362830 */:
                setupConditions();
                break;
        }
    }

    private void showBottomSheet() {
        this.ivPhoto = findEmptyImage();
        BottomDialogFragment.newInstance(new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                IncidentsFragment.this.checkPermissionsTakePhoto();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                IncidentsFragment.this.checkPermissionsTakeGallery();
            }
        }).show(getFragmentManager(), BottomDialogFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImage(View view) {
        ImageView imageView = (ImageView) view;
        this.ivPhoto = imageView;
        if (imageView == this.ivFirstPicture && this.ivSecondPicture.getDrawable() != null) {
            this.ivFirstPicture.setImageDrawable(this.ivSecondPicture.getDrawable());
            this.ivPhoto = this.ivSecondPicture;
        }
        this.ivPhoto.setActivated(false);
        if (this.ivPhoto == this.ivFirstPicture) {
            this.cvFirstPicture.setVisibility(8);
        } else {
            this.cvSecondPicture.setVisibility(8);
        }
        this.ivPhoto.setImageDrawable(null);
        this.btCamera.setVisibility(0);
    }

    private void createIncidence() {
        IncidenceRequestModel incidenceRequestModel = new IncidenceRequestModel();
        IncidenceTypeResponseModel incidenceTypeResponseModel = this.incidenceTypeModel;
        if (incidenceTypeResponseModel != null) {
            incidenceRequestModel.setIncidenceType(incidenceTypeResponseModel.getId());
            incidenceRequestModel.setDescription(this.etCommentIncidence.getText().toString());
            if (this.ivFirstPicture.getDrawable() != null) {
                incidenceRequestModel.setFile1(getBase64(this.ivFirstPicture));
            }
            if (this.ivSecondPicture.getDrawable() != null) {
                incidenceRequestModel.setFile2(getBase64(this.ivSecondPicture));
            }
            incidenceRequestModel.setName(this.etUserName.getText().toString());
            incidenceRequestModel.setSurName(this.etUserSurname.getText().toString());
            incidenceRequestModel.setDate(DateUtils.dateToZuluString());
            incidenceRequestModel.setEmail(this.etUserEmail.getText().toString());
            incidenceRequestModel.setPhone1(this.etUserPhone.getText().toString());
            incidenceRequestModel.setPhone2(this.etSecondPhone.getText().toString());
            if (!TextUtils.isEmpty(this.etUserNumberTransportCard.getText())) {
                incidenceRequestModel.setCardNumber(this.etUserNumberTransportCard.getText().toString());
            }
            sendIncidence(incidenceRequestModel);
            return;
        }
        BaseUtils.showInfoDialog(getContext(), 2, getString(R.string.error), getString(R.string.label_text_incident_send_error), getString(R.string.label_accept), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.onError();
            }
        });
    }

    private String getBase64(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    private void sendIncidence(IncidenceRequestModel requestModel) {
        this.viewModel.sendIncidence(getContext(), requestModel).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$sendIncidence$4((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendIncidence$4(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.label_text_incident_send_error, resource.message));
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            clearFields();
            hideLoading();
            showDialogSuccess();
        }
    }

    private void clearFields() {
        this.ivFirstPicture.setActivated(false);
        this.ivFirstPicture.setVisibility(8);
        this.ivSecondPicture.setActivated(false);
        this.ivSecondPicture.setVisibility(8);
    }

    private void showDialogSuccess() {
        BaseUtils.showInfoDialog(getContext(), 3, getString(R.string.label_title_send_incident), getString(R.string.label_text_send_incident), getString(R.string.label_finish_recharge_button), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda9
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                this.f$0.lambda$showDialogSuccess$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogSuccess$5() {
        this.etCommentIncidence.setText("");
        ValidatorUtils.deactivateValidator(this.etCommentIncidence, this.validatorModelList);
        validateFields();
    }

    private ImageView findEmptyImage() {
        if (this.ivFirstPicture.getDrawable() == null) {
            return this.ivFirstPicture;
        }
        if (this.ivSecondPicture.getDrawable() == null) {
            return this.ivSecondPicture;
        }
        return null;
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
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

    private void setupConditions() {
        this.viewModel.getLegalConditions(getContext(), BuildConfig.CONDITIONS_INCIDENCES).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupConditions$6((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupConditions$6(Resource resource) {
        int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            BaseUtils.showKoDialog(getContext(), getString(R.string.error_getting_terms) + ": " + resource.message);
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
            BaseUtils.showDialog(getContext(), 1, ((ConditionsResponseModel) resource.data).getTitle(), ((ConditionsResponseModel) resource.data).getDescription(), getString(R.string.label_payment_one_click_ok), getString(R.string.label_payment_one_click_ko), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment.2
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                public void onClickPositive() {
                    ValidatorUtils.setValidatorChecked(true, IncidentsFragment.this.validatorModelList);
                    IncidentsFragment.this.cbAcceptTerms.setChecked(true);
                    IncidentsFragment.this.validateFields();
                }

                @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
                public void onClickNegative() {
                    ValidatorUtils.setValidatorChecked(true, IncidentsFragment.this.validatorModelList);
                    IncidentsFragment.this.cbAcceptTerms.setChecked(false);
                    IncidentsFragment.this.validateFields();
                }
            });
        } else {
            BaseUtils.showKoDialog(getContext(), getString(R.string.error_getting_terms));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1004) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                if (Build.VERSION.SDK_INT >= 33) {
                    getImageFromGallery();
                } else {
                    openOldGallery();
                }
            } else {
                Toast.makeText(getActivity(), getString(R.string.label_denied_permission), 0).show();
            }
        } else if (requestCode == 1003) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                captureImage();
            } else {
                Toast.makeText(getContext(), getString(R.string.label_denied_permission), 0).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermissionsTakeGallery() {
        this.preferences.setExtLoginUser();
        if (Build.VERSION.SDK_INT >= 33) {
            getImageFromGallery();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1004);
                return;
            } else {
                openOldGallery();
                return;
            }
        }
        openOldGallery();
    }

    private void openOldGallery() {
        startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 8);
    }

    private void getImageFromGallery() {
        Intent intent = new Intent("android.provider.action.PICK_IMAGES");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        startActivityForResult(intent, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermissionsTakePhoto() {
        this.preferences.setExtLoginUser();
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 1003);
        } else {
            captureImage();
        }
    }

    private void captureImage() {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri data2;
        Bitmap bitmap;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == -1) {
                getHolderData();
                return;
            }
            return;
        }
        if (requestCode == 2) {
            if (resultCode != -1 || data == null || data.getExtras() == null || (bitmap = (Bitmap) data.getExtras().get(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) == null) {
                return;
            }
            ImageView imageView = this.ivPhoto;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            setupCanvas();
            savePhoto(bitmap);
            return;
        }
        if (requestCode != 8 || resultCode != -1 || data == null || (data2 = data.getData()) == null) {
            return;
        }
        try {
            Bitmap bitmapFromUri = getBitmapFromUri(getContext(), data2);
            ImageView imageView2 = this.ivPhoto;
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmapFromUri);
            }
            setupCanvas();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public static Bitmap getBitmapFromUri(Context context, Uri uri) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT >= 28) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uri));
        }
        return MediaStore.Images.Media.getBitmap(contentResolver, uri);
    }

    private void setupCanvas() {
        if (this.ivPhoto == this.ivFirstPicture) {
            this.cvFirstPicture.setVisibility(0);
        } else {
            this.cvSecondPicture.setVisibility(0);
        }
        if (this.ivFirstPicture.getDrawable() == null || this.ivSecondPicture.getDrawable() == null) {
            return;
        }
        this.btCamera.setVisibility(4);
    }

    private void savePhoto(Bitmap photo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), getString(R.string.label_incidence_name)));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @OnTextChanged({R.id.etCommentIncidence})
    public void onTextChangedComment(CharSequence text) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etCommentIncidence, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etName})
    public void onTextChangedUserName(CharSequence text) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etUserName, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etSurname})
    public void onTextChangedUserSurname(CharSequence text) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etUserSurname, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etLastname})
    public void onTextChangedUserLastname(CharSequence text) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etLastname, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etUserEmail})
    public void onTextChangedUserMail(CharSequence text) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etUserEmail, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etPhone})
    public void onTextChangedUserPhone() {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etUserPhone, list);
            validateFields();
        }
    }

    @OnTextChanged({R.id.etSecondPhone})
    public void onTextChangedSecondPhone() {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.activateValidator(this.etSecondPhone, list);
            validateFields();
        }
    }

    @OnCheckedChanged({R.id.cbAceptTerms})
    public void onChechedChanged(boolean checked) {
        List<ValidatorModel> list = this.validatorModelList;
        if (list != null) {
            ValidatorUtils.setValidatorChecked(checked, list);
            this.cbAcceptTerms.setChecked(checked);
            validateFields();
        }
    }

    private void showDialogRemoveImage(final View view) {
        BaseUtils.showDialog(getContext(), 0, getString(R.string.label_title_remove_image), getString(R.string.label_description_remove_image), getString(R.string.label_yes), getString(R.string.label_no), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment.3
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                IncidentsFragment.this.removeImage(view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.validatorModelList.clear();
        this.validatorModelList = null;
        hideLoading();
        super.onDestroyView();
    }
}
