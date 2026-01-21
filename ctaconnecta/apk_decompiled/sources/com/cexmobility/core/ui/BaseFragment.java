package com.cexmobility.core.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.cexmobility.core.widgets.dialog.BaseDialog;
import com.google.android.material.snackbar.Snackbar;
import dagger.android.support.AndroidSupportInjection;

/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {
    private BaseDialog dialog;

    protected abstract int getLayoutResource();

    protected abstract boolean hasInjection();

    protected abstract void initializeView();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws NoSuchMethodException, SecurityException {
        View viewInflate = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        if (hasInjection()) {
            AndroidSupportInjection.inject(this);
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeView();
    }

    public void showLoading() {
        ((BaseActivity) getActivity()).showLoading();
    }

    public void hideLoading() {
        ((BaseActivity) getActivity()).hideLoading();
    }

    public Snackbar showSnackBar(String message) {
        return ((BaseActivity) getActivity()).showSnackBar(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showErrorDialog(String errorDescription) {
        if (this.dialog == null) {
            this.dialog = new BaseDialog(getContext());
        }
        if (this.dialog.isShowing()) {
            return;
        }
        this.dialog.setDialogType(2);
        this.dialog.setAnimationEnable(true);
        this.dialog.setTitleText("Error");
        this.dialog.setContentText(errorDescription);
        this.dialog.setPositiveListener("Ok", new BaseDialog.onClickCommentsDialog() { // from class: com.cexmobility.core.ui.BaseFragment$$ExternalSyntheticLambda0
            @Override // com.cexmobility.core.widgets.dialog.BaseDialog.onClickCommentsDialog
            public final void onClickPositive(BaseDialog baseDialog) {
                this.f$0.lambda$showErrorDialog$0(baseDialog);
            }
        });
        this.dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$0(BaseDialog baseDialog) {
        this.dialog.dismiss();
    }
}
