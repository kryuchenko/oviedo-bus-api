package com.iecisa.ctausuario.ui.main.transportcard.readcardnfc;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class ReadCardNfcActivity_ViewBinding implements Unbinder {
    private ReadCardNfcActivity target;
    private View view7f0a0418;

    public ReadCardNfcActivity_ViewBinding(ReadCardNfcActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public ReadCardNfcActivity_ViewBinding(final ReadCardNfcActivity target, View source) {
        this.target = target;
        target.tvInfo = (TextView) Utils.findRequiredViewAsType(source, R.id.tvInfo, "field 'tvInfo'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.tvLabelChangeMyMind, "field 'tvLabelChangeMyMind' and method 'onChangeMyMindClickEvent'");
        target.tvLabelChangeMyMind = (TextView) Utils.castView(viewFindRequiredView, R.id.tvLabelChangeMyMind, "field 'tvLabelChangeMyMind'", TextView.class);
        this.view7f0a0418 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.readcardnfc.ReadCardNfcActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onChangeMyMindClickEvent();
            }
        });
        target.tvLabelGetCardCloseToPhone = (TextView) Utils.findRequiredViewAsType(source, R.id.tvLabelGetCardCloseToPhone, "field 'tvLabelGetCardCloseToPhone'", TextView.class);
        target.lottieAnimationView = (LottieAnimationView) Utils.findRequiredViewAsType(source, R.id.lottieCard, "field 'lottieAnimationView'", LottieAnimationView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReadCardNfcActivity readCardNfcActivity = this.target;
        if (readCardNfcActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        readCardNfcActivity.tvInfo = null;
        readCardNfcActivity.tvLabelChangeMyMind = null;
        readCardNfcActivity.tvLabelGetCardCloseToPhone = null;
        readCardNfcActivity.lottieAnimationView = null;
        this.view7f0a0418.setOnClickListener(null);
        this.view7f0a0418 = null;
    }
}
