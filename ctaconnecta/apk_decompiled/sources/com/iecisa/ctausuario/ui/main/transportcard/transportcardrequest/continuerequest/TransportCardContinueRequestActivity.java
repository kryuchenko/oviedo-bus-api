package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.transportcardrequest.DoBUserDataModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.PendingRequestsAdapter;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.data.TransportCardRequestDataActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransportCardContinueRequestActivity extends CustomToolbarActivity {
    public static final String DICTAMINATION_KO = "Verification KO";
    public static final String DICTAMINATION_OK = "Verification OK";
    PendingRequestsAdapter pendingRequestsAdapter;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.rvPendingRequests)
    RecyclerView rvPendingRequests;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvInfoMessage)
    TextView tvInfoMessage;

    @BindView(R.id.tvLabelRequestNumber)
    TextView tvLabelRequestNumber;

    @BindView(R.id.tvNoPendingRequests)
    TextView tvNoPendingRequests;
    TransportCardContinueRequestViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_transport_card_request_continue;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (TransportCardContinueRequestViewModel) new ViewModelProvider(this, this.viewModelFactory).get(TransportCardContinueRequestViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.label_card_request_continue));
        setUpPendingRequestsList();
        loadIntent();
    }

    private void setUpPendingRequestsList() {
        List<PendingCardRequest> listLoadPendingRequestsList = this.preferences.loadPendingRequestsList();
        if (listLoadPendingRequestsList.isEmpty()) {
            this.tvNoPendingRequests.setVisibility(0);
            this.tvLabelRequestNumber.setVisibility(8);
            this.rvPendingRequests.setVisibility(8);
            return;
        }
        this.tvNoPendingRequests.setVisibility(8);
        this.tvLabelRequestNumber.setVisibility(0);
        this.rvPendingRequests.setVisibility(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rvPendingRequests.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvPendingRequests.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.drawable_separator_recyclerview, null));
        this.rvPendingRequests.addItemDecoration(dividerItemDecoration);
        PendingRequestsAdapter pendingRequestsAdapter = new PendingRequestsAdapter(listLoadPendingRequestsList, this);
        this.pendingRequestsAdapter = pendingRequestsAdapter;
        this.rvPendingRequests.setAdapter(pendingRequestsAdapter);
        this.pendingRequestsAdapter.setOnPendingRequestClickListener(new PendingRequestsAdapter.OnPendingRequestClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.PendingRequestsAdapter.OnPendingRequestClickListener
            public final void onPendingRequestClick(PendingCardRequest pendingCardRequest) {
                this.f$0.lambda$setUpPendingRequestsList$0(pendingCardRequest);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpPendingRequestsList$0(PendingCardRequest pendingCardRequest) {
        getUserData(pendingCardRequest.requestNumber, false);
    }

    private void loadIntent() {
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.IntentData.INTENT_DOB_USER_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        getUserData(stringExtra, true);
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$3, reason: invalid class name */
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

    private void getUserData(final String requestNumber, final boolean dictaminationReceived) {
        this.viewModel.getUserData(this, requestNumber).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getUserData$1(requestNumber, dictaminationReceived, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getUserData$1(String str, boolean z, Resource resource) {
        int i = AnonymousClass3.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i != 1) {
            if (i == 2) {
                showLoading();
                return;
            }
            if (i != 3) {
                return;
            }
            if (resource.data != 0) {
                loadUserData(str, (DoBUserDataModel) resource.data, z);
                return;
            } else {
                hideLoading();
                BaseUtils.showKoDialog(this, getString(R.string.label_date_error_getting_user_data));
                return;
            }
        }
        hideLoading();
        if (resource.code.intValue() == 404) {
            this.preferences.removePendingCardRequest(str);
            loadRequestNumberNotFound();
            lambda$loadUserData$5(z);
        } else {
            BaseUtils.showKoDialog(this, "(" + resource.code + ") " + resource.message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updatePendingRequestsList, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$loadUserData$5(boolean dictaminationReceived) {
        if (dictaminationReceived) {
            finish();
            return;
        }
        List<PendingCardRequest> listLoadPendingRequestsList = this.preferences.loadPendingRequestsList();
        this.pendingRequestsAdapter.setPendingCardRequestsList(listLoadPendingRequestsList);
        this.pendingRequestsAdapter.notifyDataSetChanged();
        if (listLoadPendingRequestsList.isEmpty()) {
            this.tvNoPendingRequests.setVisibility(0);
            this.tvLabelRequestNumber.setVisibility(8);
            this.rvPendingRequests.setVisibility(8);
        } else {
            this.tvNoPendingRequests.setVisibility(8);
            this.tvLabelRequestNumber.setVisibility(0);
            this.rvPendingRequests.setVisibility(0);
        }
    }

    private void loadUserData(String requestNumber, DoBUserDataModel doBUserData, final boolean dictaminationReceived) {
        Integer statusCode = doBUserData.getStatusCode();
        if (DoBUserDataModel.STATUS_CODE_USER_EXISTS.equals(statusCode)) {
            this.preferences.removePendingCardRequest(requestNumber);
            hideLoading();
            BaseUtils.showInfoDialog(this, 2, getString(R.string.label_continue_title_dictamination_user_exits), getString(R.string.label_continue_description_dictamination_user_exists), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity.1
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public void onClickPositive() {
                    TransportCardContinueRequestActivity.this.lambda$loadUserData$5(dictaminationReceived);
                }
            });
            return;
        }
        if (DoBUserDataModel.STATUS_CODE_REPRESENTATIVE_EXISTS.equals(statusCode)) {
            this.preferences.removePendingCardRequest(requestNumber);
            hideLoading();
            BaseUtils.showInfoDialog(this, 2, getString(R.string.label_continue_title_dictamination_user_exits), getString(R.string.label_continue_description_dictamination_representative_exists), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity.2
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public void onClickPositive() {
                    TransportCardContinueRequestActivity.this.lambda$loadUserData$5(dictaminationReceived);
                }
            });
            return;
        }
        if (DoBUserDataModel.STATUS_CODE_IN_PROGRESS.equals(statusCode)) {
            hideLoading();
            BaseUtils.showInfoDialog(this, getString(R.string.label_dictamination_in_progress_title), getString(R.string.label_dictamination_in_progress_description));
            return;
        }
        if (!doBUserData.getComplete().booleanValue()) {
            if (doBUserData.getDictaminationResult().equalsIgnoreCase(DICTAMINATION_KO)) {
                this.preferences.removePendingCardRequest(requestNumber);
                hideLoading();
                BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.label_continue_description_dictamination_wrong_not_finished), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda1
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                    public final void onClickPositive() {
                        this.f$0.lambda$loadUserData$2(dictaminationReceived);
                    }
                });
                return;
            } else if (doBUserData.getRepresentative().booleanValue() && DateUtils.calculateAge(DateUtils.getDate(doBUserData.getBirthDate())) < 18) {
                this.preferences.removePendingCardRequest(requestNumber);
                hideLoading();
                BaseUtils.showInfoDialog(this, 2, getString(R.string.label_something_go_wrong), getString(R.string.label_continue_description_dictamination_minor), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda2
                    @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                    public final void onClickPositive() {
                        this.f$0.lambda$loadUserData$3(dictaminationReceived);
                    }
                });
                return;
            } else {
                Intent intent = new Intent(getBaseContext(), (Class<?>) TransportCardRequestDataActivity.class);
                intent.setFlags(335544320);
                intent.putExtra(Constants.IntentData.INTENT_DOB_USER_DATA, doBUserData);
                intent.putExtra(Constants.IntentData.INTENT_DOB_USER_ID, requestNumber);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (doBUserData.getDictaminationResult().equalsIgnoreCase(DICTAMINATION_OK)) {
            this.preferences.removePendingCardRequest(requestNumber);
            hideLoading();
            BaseUtils.showInfoDialog(this, 3, getString(R.string.label_continue_title_dictamination_ok, new Object[]{doBUserData.getName()}), getString(R.string.label_continue_description_dictamination_ok), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda3
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    this.f$0.lambda$loadUserData$4(dictaminationReceived);
                }
            });
        } else if (doBUserData.getDictaminationResult().equalsIgnoreCase(DICTAMINATION_KO)) {
            this.preferences.removePendingCardRequest(requestNumber);
            hideLoading();
            BaseUtils.showInfoDialog(this, 2, getString(R.string.label_continue_title_dictamination_ko, new Object[]{doBUserData.getName()}), getString(R.string.label_continue_description_dictamination_ko), getString(R.string.label_understand), new BaseUtils.onPositiveDialogListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest.TransportCardContinueRequestActivity$$ExternalSyntheticLambda4
                @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
                public final void onClickPositive() {
                    this.f$0.lambda$loadUserData$5(dictaminationReceived);
                }
            });
        } else {
            hideLoading();
            BaseUtils.showKoDialog(this, getString(R.string.label_continue_description_dictamination_wrong));
        }
    }

    private void loadRequestNumberNotFound() {
        this.tvInfoMessage.setText(getString(R.string.label_continue_request_number_not_found));
        this.tvInfoMessage.setVisibility(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }
}
