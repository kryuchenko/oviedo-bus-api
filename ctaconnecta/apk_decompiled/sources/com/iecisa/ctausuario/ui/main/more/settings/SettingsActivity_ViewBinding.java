package com.iecisa.ctausuario.ui.main.more.settings;

import android.view.View;
import android.widget.Switch;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class SettingsActivity_ViewBinding implements Unbinder {
    private SettingsActivity target;
    private View view7f0a00d5;
    private View view7f0a037f;

    public SettingsActivity_ViewBinding(SettingsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public SettingsActivity_ViewBinding(final SettingsActivity target, View source) {
        this.target = target;
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View viewFindRequiredView = Utils.findRequiredView(source, R.id.clSaveFavourites, "field 'clSaveFavpurites' and method 'onClickEvents'");
        target.clSaveFavpurites = (ConstraintLayout) Utils.castView(viewFindRequiredView, R.id.clSaveFavourites, "field 'clSaveFavpurites'", ConstraintLayout.class);
        this.view7f0a00d5 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(source, R.id.swSaveOnDrive, "field 'swSaveOnDrive' and method 'onClickEvents'");
        target.swSaveOnDrive = (Switch) Utils.castView(viewFindRequiredView2, R.id.swSaveOnDrive, "field 'swSaveOnDrive'", Switch.class);
        this.view7f0a037f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View p0) {
                target.onClickEvents();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettingsActivity settingsActivity = this.target;
        if (settingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingsActivity.toolbar = null;
        settingsActivity.clSaveFavpurites = null;
        settingsActivity.swSaveOnDrive = null;
        this.view7f0a00d5.setOnClickListener(null);
        this.view7f0a00d5 = null;
        this.view7f0a037f.setOnClickListener(null);
        this.view7f0a037f = null;
    }
}
