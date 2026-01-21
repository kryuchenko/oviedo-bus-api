package com.iecisa.ctausuario.ui.main.transportcard.dataprotection;

import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.dataprotection.ConsentModel;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionRequestModel;
import com.iecisa.ctausuario.model.dataprotection.DataProtectionResponseModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DataProtectionActivity extends CustomToolbarActivity {
    private DataProtectionAdapter adapter;
    private DataProtectionAdapter adapterMandatory;

    @BindView(R.id.rvProtection)
    RecyclerView rvProtection;

    @BindView(R.id.rvProtectionMandatory)
    RecyclerView rvProtectionMandatory;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvLabelDataMandatory)
    TextView tvLabelDataMandatory;

    @BindView(R.id.tvLabelDataNotMandatory)
    TextView tvLabelDataNotMandatory;
    private DataProtectionViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_data_protection;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (DataProtectionViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(DataProtectionViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_data_protection));
        setupView();
    }

    private void setupView() {
        this.viewModel.getDataProtection(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupView$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setupView$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
                setupAdapter((DataProtectionResponseModel) resource.data);
            }
        }
    }

    private void setupAdapter(DataProtectionResponseModel dataProtectionResponseModel) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        this.rvProtection.setLayoutManager(linearLayoutManager);
        this.rvProtectionMandatory.setLayoutManager(linearLayoutManager2);
        this.adapter = new DataProtectionAdapter(false);
        this.adapterMandatory = new DataProtectionAdapter(true);
        this.rvProtection.setAdapter(this.adapter);
        this.rvProtectionMandatory.setAdapter(this.adapterMandatory);
        this.adapterMandatory.addAll(dataProtectionResponseModel.getMandatoryConsents());
        this.adapter.addAll(dataProtectionResponseModel.getOtherConsents());
        this.tvLabelDataMandatory.setVisibility(this.adapterMandatory.getItemCount() > 0 ? 0 : 8);
        this.tvLabelDataNotMandatory.setVisibility(this.adapter.getItemCount() <= 0 ? 8 : 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.btSave})
    public void onViewClicked() {
        DataProtectionAdapter dataProtectionAdapter = this.adapter;
        if (dataProtectionAdapter != null) {
            List<ConsentModel> items = dataProtectionAdapter.getItems();
            ArrayList arrayList = new ArrayList();
            for (ConsentModel consentModel : items) {
                arrayList.add(new DataProtectionRequestModel(consentModel.getConsentId(), consentModel.getAccepted()));
            }
            this.viewModel.saveDataProtection(this, arrayList).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f$0.lambda$onViewClicked$1((Resource) obj);
                }
            });
        }
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.dataprotection.DataProtectionActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$onViewClicked$1(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
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
            Toast.makeText(this, R.string.label_updated_data, 1).show();
        }
    }
}
