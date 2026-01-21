package com.iecisa.ctausuario.ui.main.more.settings;

import android.app.Activity;
import android.app.backup.BackupManager;
import android.content.Intent;
import android.widget.Switch;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.enums.ToolbarActions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnSuccessListener;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SettingsActivity extends CustomToolbarActivity {

    @BindView(R.id.clSaveFavourites)
    ConstraintLayout clSaveFavpurites;

    @Inject
    PreferencesHelper preferences;

    @BindView(R.id.swSaveOnDrive)
    Switch swSaveOnDrive;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SettingsViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_settings;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.viewModel = (SettingsViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(SettingsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.label_settings));
        this.swSaveOnDrive.setChecked(this.preferences.isCloudActivated().booleanValue());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    @OnClick({R.id.clSaveFavourites, R.id.swSaveOnDrive})
    public void onClickEvents() {
        if (!this.preferences.isCloudActivated().booleanValue()) {
            saveFavourites();
            return;
        }
        this.preferences.desactivateCloud();
        this.swSaveOnDrive.setChecked(false);
        notifyDataChanged();
    }

    private void saveFavourites() {
        BaseUtils.showDialog(this, 0, getString(R.string.label_title_save_favourites), getString(R.string.label_text_save_favourites), getString(R.string.label_ok_save), getString(R.string.label_ko_save), new BaseUtils.onDialogListener() { // from class: com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity.1
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickPositive() {
                SettingsActivity.this.preferences.activateCloud();
                SettingsActivity.this.preferences.messageCloudShown();
                SettingsActivity.this.swSaveOnDrive.setChecked(true);
                SettingsActivity.this.notifyDataChanged();
            }

            @Override // com.iecisa.ctausuario.utils.BaseUtils.onDialogListener
            public void onClickNegative() {
                SettingsActivity.this.preferences.desactivateCloud();
                SettingsActivity.this.preferences.messageCloudShown();
                SettingsActivity.this.swSaveOnDrive.setChecked(false);
            }
        });
    }

    public void signIn() {
        startActivityForResult(GoogleSignIn.getClient((Activity) this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestScopes(new Scope("https://www.googleapis.com/auth/drive.file"), new Scope[0]).build()).getSignInIntent(), 400);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 400 && resultCode == -1) {
            handleSignIntent(data);
        }
    }

    private void handleSignIntent(Intent data) {
        GoogleSignIn.getSignedInAccountFromIntent(data).addOnSuccessListener(new OnSuccessListener() { // from class: com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.lambda$handleSignIntent$0((GoogleSignInAccount) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSignIntent$0(GoogleSignInAccount googleSignInAccount) {
        this.preferences.messageCloudShown();
        this.preferences.activateCloud();
        this.swSaveOnDrive.setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataChanged() {
        new BackupManager(getBaseContext()).dataChanged();
    }
}
