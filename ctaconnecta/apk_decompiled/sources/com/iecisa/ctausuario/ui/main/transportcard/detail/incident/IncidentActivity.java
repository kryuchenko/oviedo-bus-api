package com.iecisa.ctausuario.ui.main.transportcard.detail.incident;

import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.incidents.IncidentsFragment;
import com.iecisa.ctausuario.utils.Constants;
import javax.inject.Inject;
import jj2000.j2k.entropy.encoder.StdEntropyCoder;

/* loaded from: classes5.dex */
public class IncidentActivity extends CustomToolbarActivity {

    @BindView(R.id.container)
    FrameLayout container;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Fragment incidentsFragment = new IncidentsFragment();
    private TransportCardModel model;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_incident;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        setToolbar(this.toolbar, ToolbarActions.NO_ACTION, getString(R.string.label_menu_incidents));
        if (getIntent().getExtras() != null) {
            TransportCardModel transportCardModel = (TransportCardModel) getIntent().getSerializableExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_USER);
            this.model = transportCardModel;
            if (transportCardModel != null && transportCardModel.getCardNumber() != null) {
                setToolbarTitle(getString(R.string.label_menu_incident_transport_card), this.model.getCardNumber());
            } else {
                setToolbarTitle(getString(R.string.label_menu_incident_transport_card));
            }
            loadIncident();
        }
    }

    private void loadIncident() {
        this.toolbar.setVisibility(0);
        this.container.setVisibility(0);
        this.fragmentManager.beginTransaction().add(R.id.container, this.incidentsFragment, StdEntropyCoder.DEF_THREADS_NUM).commit();
    }

    public TransportCardModel getModel() {
        return this.model;
    }
}
