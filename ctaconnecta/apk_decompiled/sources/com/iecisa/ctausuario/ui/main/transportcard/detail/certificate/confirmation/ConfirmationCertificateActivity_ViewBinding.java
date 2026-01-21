package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.confirmation;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ConfirmationCertificateActivity_ViewBinding implements Unbinder {
    private ConfirmationCertificateActivity target;
    private View view7f0a0090;

    public ConfirmationCertificateActivity_ViewBinding(ConfirmationCertificateActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public ConfirmationCertificateActivity_ViewBinding(final ConfirmationCertificateActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target.tvDetail = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDetail, "field 'tvDetail'", TextView.class);
        target.tvDetailTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDetailTitle, "field 'tvDetailTitle'", TextView.class);
        target.tvDetailValue = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDetailValue, "field 'tvDetailValue'", TextView.class);
        target.tvAdviceOffice = (TextView) Utils.findRequiredViewAsType(source, R.id.tvAdviceOffice, "field 'tvAdviceOffice'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.btOk, "method 'onViewClicked'");
        this.view7f0a0090 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.detail.certificate.confirmation.ConfirmationCertificateActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ConfirmationCertificateActivity confirmationCertificateActivity = this.target;
        if (confirmationCertificateActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        confirmationCertificateActivity.toolbar = null;
        confirmationCertificateActivity.tvDetail = null;
        confirmationCertificateActivity.tvDetailTitle = null;
        confirmationCertificateActivity.tvDetailValue = null;
        confirmationCertificateActivity.tvAdviceOffice = null;
        this.view7f0a0090.setOnClickListener(null);
        this.view7f0a0090 = null;
    }
}
