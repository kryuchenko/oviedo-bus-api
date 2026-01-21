package com.cexmobility.core.ui;

import android.R;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.cexmobility.core.utils.BaseUtils;
import com.cexmobility.core.widgets.dialog.BaseDialog;
import com.google.android.material.snackbar.Snackbar;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

/* loaded from: classes.dex */
public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private ProgressDialog progressDialog;

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    protected int getLayoutResource() {
        return -1;
    }

    protected View getLayoutView() {
        return null;
    }

    protected abstract boolean hasInjection();

    protected abstract void initializeView();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        if (hasInjection()) {
            AndroidInjection.inject(this);
        }
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (getLayoutResource() != -1) {
            setContentView(getLayoutResource());
        } else if (getLayoutView() != null) {
            setContentView(getLayoutView());
        }
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.cexmobility.core.ui.BaseActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return BaseActivity.lambda$onCreate$0(view, windowInsets);
            }
        });
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, viewFindViewById);
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);
        ButterKnife.bind(this);
        initializeView();
    }

    static /* synthetic */ WindowInsets lambda$onCreate$0(View view, WindowInsets windowInsets) {
        view.setPadding(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        return windowInsets.consumeSystemWindowInsets();
    }

    protected void hideKeyboard() {
        View rootView;
        if (findViewById(R.id.content) == null || (rootView = getWindow().getDecorView().getRootView()) == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }

    protected void showErrorDialog(String errorDescription) {
        final BaseDialog baseDialog = new BaseDialog(this);
        baseDialog.setDialogType(2);
        baseDialog.setAnimationEnable(true);
        baseDialog.setTitleText("Error");
        baseDialog.setContentText(errorDescription);
        baseDialog.setPositiveListener("Ok", new BaseDialog.onClickCommentsDialog() { // from class: com.cexmobility.core.ui.BaseActivity$$ExternalSyntheticLambda1
            @Override // com.cexmobility.core.widgets.dialog.BaseDialog.onClickCommentsDialog
            public final void onClickPositive(BaseDialog baseDialog2) {
                baseDialog.dismiss();
            }
        });
        baseDialog.show();
    }

    public void showLoading() {
        showLoading(0);
    }

    public void showLoading(int messageStringId) {
        hideLoading();
        this.progressDialog = BaseUtils.showLoadingDialog(this, messageStringId);
    }

    public void hideLoading() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.cancel();
    }

    public Snackbar showSnackBar(String message) {
        Snackbar snackbarMake = Snackbar.make(findViewById(R.id.content), message, 0);
        View view = snackbarMake.getView();
        ((TextView) view.findViewById(com.cexmobility.core.R.id.toolbar)).setTextColor(ContextCompat.getColor(this, com.cexmobility.core.R.color.black));
        view.setBackgroundColor(ContextCompat.getColor(this, com.cexmobility.core.R.color.grey_dark_more));
        return snackbarMake;
    }

    @Override // dagger.android.support.HasSupportFragmentInjector
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.supportFragmentInjector;
    }
}
