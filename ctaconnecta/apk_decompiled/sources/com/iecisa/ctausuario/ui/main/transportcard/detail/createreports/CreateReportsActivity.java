package com.iecisa.ctausuario.ui.main.transportcard.detail.createreports;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.DateUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class CreateReportsActivity extends CustomToolbarActivity {
    private String cardNumber;
    private CreateReportsViewModel createReportsViewModel;

    @BindView(R.id.mbRechargeTrips)
    MaterialButton mbRechargeTrips;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvDateSince)
    TextView tvDateSince;

    @BindView(R.id.tvDateTo)
    TextView tvDateTo;

    @BindView(R.id.tvErrorMessage)
    TextView tvErrorMessage;
    private Integer userType;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_create_reports;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.createReportsViewModel = (CreateReportsViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(CreateReportsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_create_report));
        checkPermissionDownload();
        setupView();
        if (getIntent().getExtras() != null) {
            this.cardNumber = getIntent().getExtras().getString(Constants.IntentData.INTENT_CREATE_REPORT);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        return super.lambda$showIsRepresentativeDialog$3();
    }

    private void setupView() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        showDate(calendar, this.tvDateTo);
        calendar.setTime(new Date(date.getTime() - 604800000));
        showDate(calendar, this.tvDateSince);
    }

    private void checkPermissionDownload() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                setExtUser();
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1002);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1002);
            }
        }
    }

    @OnClick({R.id.tvDateSince, R.id.tvDateTo, R.id.mbRechargeTrips})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mbRechargeTrips /* 2131362398 */:
                if (!TextUtils.isEmpty(this.tvDateSince.getText()) && !TextUtils.isEmpty(this.tvDateTo.getText()) && !this.cardNumber.isEmpty()) {
                    createReport();
                    break;
                }
                break;
            case R.id.tvDateSince /* 2131362791 */:
                loadDatePicker(this.tvDateSince);
                break;
            case R.id.tvDateTo /* 2131362792 */:
                loadDatePicker(this.tvDateTo);
                break;
        }
    }

    private void createReport() {
        this.createReportsViewModel.createReport(this, this.cardNumber, DateUtils.getDateTimeReports(this.tvDateSince.getText().toString()), DateUtils.getDateTimeReportsEnd(this.tvDateTo.getText().toString())).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws IOException {
                this.f$0.lambda$createReport$0((Resource) obj);
            }
        });
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity$1, reason: invalid class name */
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
    public /* synthetic */ void lambda$createReport$0(Resource resource) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            this.tvErrorMessage.setText(resource.message);
            BaseUtils.showInfoMessage(this.tvErrorMessage);
        } else if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                downloadPdf(resource, new File(getExternalFilesDir(null).getAbsolutePath(), getString(R.string.label_report_name, new Object[]{DateUtils.getDateReport(this.tvDateSince.getText().toString()), DateUtils.getDateReport(this.tvDateTo.getText().toString())})));
            }
        }
    }

    private void downloadPdf(Resource<String> response, File pdfFile) throws IOException {
        byte[] bArrDecode = Base64.decode(response.data, 0);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfFile);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.flush();
                fileOutputStream.close();
                showPdf(pdfFile);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            Timber.e(e);
            BaseUtils.showKoDialog(this, e.getMessage());
        }
    }

    private void showPdf(File file) {
        setExtUser();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + Constants.Reports.PROVIDER, file), Constants.Reports.PDF_APP);
        intent.addFlags(1);
        startActivityForResult(intent, 12);
    }

    private void setExtUser() {
        this.userType = this.preferences.getUser();
        this.preferences.setExtUser();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reloadUser();
    }

    private void loadDatePicker(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity$$ExternalSyntheticLambda2
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                this.f$0.lambda$loadDatePicker$1(textView, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDatePicker$1(TextView textView, DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i2, i3);
        showDate(calendar, textView);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        reloadUser();
        setResult(0, new Intent());
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        reloadUser();
    }

    private void reloadUser() {
        Integer num = this.userType;
        if (num != null) {
            this.preferences.saveUser(num);
        }
    }

    private void showDate(Calendar date, TextView textView) {
        textView.setText(new SimpleDateFormat(DateUtils.DATE_FORMAT, Locale.ENGLISH).format(date.getTime()));
    }
}
