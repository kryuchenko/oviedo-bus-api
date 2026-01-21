package com.iecisa.ctausuario.ui.main.transportcard;

import android.content.Intent;
import android.view.View;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.logintransportcard.LoginTransportCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.loginusercard.LoginUserCardActivity;
import com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.TransportCardRequestActivity;
import com.iecisa.ctausuario.utils.Constants;

/* loaded from: classes5.dex */
public class TransportCardFragment extends BaseFragment {
    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_transport_card;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || data.getExtras() == null) {
            return;
        }
        startActivity(new Intent(getActivity(), (Class<?>) DetailTransportCardActivity.class));
        data.getExtras().getString(Constants.NFCValues.NFC_KEY_CARD);
    }

    @OnClick({R.id.btPersonalCard, R.id.btImpersonalCard, R.id.btRequestCard})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btImpersonalCard) {
            Intent intent = new Intent(getActivity(), (Class<?>) LoginTransportCardActivity.class);
            intent.putExtra(Constants.IntentData.INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL, true);
            startActivity(intent);
        } else if (id == R.id.btPersonalCard) {
            startActivity(new Intent(getActivity(), (Class<?>) LoginUserCardActivity.class));
        } else {
            if (id != R.id.btRequestCard) {
                return;
            }
            startActivity(new Intent(getActivity(), (Class<?>) TransportCardRequestActivity.class));
        }
    }
}
