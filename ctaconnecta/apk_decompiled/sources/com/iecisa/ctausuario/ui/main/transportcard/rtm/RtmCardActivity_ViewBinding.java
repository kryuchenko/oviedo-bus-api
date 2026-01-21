package com.iecisa.ctausuario.ui.main.transportcard.rtm;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class RtmCardActivity_ViewBinding implements Unbinder {
    private RtmCardActivity target;
    private View view7f0a024f;

    public RtmCardActivity_ViewBinding(RtmCardActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public RtmCardActivity_ViewBinding(final RtmCardActivity target, View source) {
        this.target = target;
        target.tvInfoMessage = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfoMessage, "field 'tvInfoMessage'", TextView.class);
        target.tvLabelGetCardCloseToPhone = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelGetCardCloseToPhone, "field 'tvLabelGetCardCloseToPhone'", TextView.class);
        target.lottieAnimationView = (LottieAnimationView) Utils.findRequiredViewAsType(source, R.id.lottieCard, "field 'lottieAnimationView'", LottieAnimationView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.mbCancel, "method 'onViewClicked'");
        this.view7f0a024f = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rtm.RtmCardActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onViewClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RtmCardActivity rtmCardActivity = this.target;
        if (rtmCardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rtmCardActivity.tvInfoMessage = null;
        rtmCardActivity.tvLabelGetCardCloseToPhone = null;
        rtmCardActivity.lottieAnimationView = null;
        this.view7f0a024f.setOnClickListener(null);
        this.view7f0a024f = null;
    }
}
