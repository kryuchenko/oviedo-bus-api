package com.iecisa.ctausuario.ui.main;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.cexmobility.core.data.Resource;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.model.TokenModel;
import com.iecisa.ctausuario.utils.BaseUtils;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public abstract class BaseTransportCardActivity extends CustomToolbarActivity {

    @Inject
    PreferencesHelper preferences;
    private BaseTransportCardViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initializeViewModel() {
        if (this.viewModel == null) {
            this.viewModel = (BaseTransportCardViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(BaseTransportCardViewModelImpl.class);
        }
    }

    public void refreshToken(final BaseUtils.onRefreshToken listener) {
        initializeViewModel();
        this.viewModel.refreshToken(this, new TokenModel(this.preferences.getBearerToken(), this.preferences.getRefreshToken())).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.BaseTransportCardActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$refreshToken$0(listener, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$refreshToken$0(BaseUtils.onRefreshToken onrefreshtoken, Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            onrefreshtoken.onError();
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
            saveTokens((TokenModel) resource.data);
            onrefreshtoken.onSuccess();
        } else {
            onrefreshtoken.onError();
        }
    }

    public void getConditions(String idConditions, final BaseUtils.onGetConditions listener) {
        initializeViewModel();
        this.viewModel.getLegalConditions(this, idConditions).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.BaseTransportCardActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getConditions$1(listener, (Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.BaseTransportCardActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$getConditions$1(BaseUtils.onGetConditions ongetconditions, Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
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
            ongetconditions.onSuccess((ConditionsResponseModel) resource.data);
        } else {
            ongetconditions.onError(resource.code, resource.message);
        }
    }

    private void saveTokens(TokenModel model) {
        this.preferences.saveTokens(model.getToken(), model.getRefreshToken());
    }
}
