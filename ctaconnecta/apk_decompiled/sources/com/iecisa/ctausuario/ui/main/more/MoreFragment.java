package com.iecisa.ctausuario.ui.main.more;

import android.content.Intent;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.more.news.NewsActivity;
import com.iecisa.ctausuario.ui.main.more.settings.SettingsActivity;

/* loaded from: classes5.dex */
public class MoreFragment extends BaseFragment {

    @BindView(R.id.btLabelNews)
    MaterialButton btLabelNews;

    @BindView(R.id.btLabelPrice)
    MaterialButton btLabelPrice;

    @BindView(R.id.btLabelSettings)
    MaterialButton btLabelSettings;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_more;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
    }

    @OnClick({R.id.btLabelNews, R.id.btLabelPrice, R.id.btLabelSettings})
    public void onEventClick(View view) {
        int id = view.getId();
        if (id == R.id.btLabelNews) {
            startActivity(new Intent(getActivity(), (Class<?>) NewsActivity.class));
        } else {
            if (id != R.id.btLabelSettings) {
                return;
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
        }
    }
}
