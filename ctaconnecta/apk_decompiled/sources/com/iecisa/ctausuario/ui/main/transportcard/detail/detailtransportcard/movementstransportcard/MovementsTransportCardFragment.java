package com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.movementstransportcard;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cexmobility.core.ui.BaseFragment;
import com.google.android.material.button.MaterialButton;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.transportcarddetail.HistoricsData;
import com.iecisa.ctausuario.model.transportcarddetail.MovementsHistoryModel;
import com.iecisa.ctausuario.model.transportcarddetail.TransportCardModel;
import com.iecisa.ctausuario.ui.main.transportcard.detail.createreports.CreateReportsActivity;
import com.iecisa.ctausuario.ui.main.transportcard.detail.detailtransportcard.DetailTransportCardActivity;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MovementsTransportCardFragment extends BaseFragment {
    private MovementsTransportCardAdapter adapter;
    private TransportCardModel cardDetailModel;

    @BindView(R.id.mbReports)
    MaterialButton mbReports;

    @BindView(R.id.rvLastActionsTransportCard)
    RecyclerView rvLastActionsTransportCard;

    @BindView(R.id.tvNoMovements)
    TextView tvNoMovements;

    @Override // com.cexmobility.core.ui.BaseFragment
    protected int getLayoutResource() {
        return R.layout.fragment_info_transport_card;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected boolean hasInjection() {
        return false;
    }

    @Override // com.cexmobility.core.ui.BaseFragment
    protected void initializeView() {
        setUpViews();
    }

    private void setUpViews() {
        if (getActivity() instanceof DetailTransportCardActivity) {
            TransportCardModel cardDetailModel = ((DetailTransportCardActivity) getActivity()).getCardDetailModel();
            this.cardDetailModel = cardDetailModel;
            if (cardDetailModel != null && cardDetailModel.getHistoricsData() != null && this.cardDetailModel.getHistoricsData().size() > 0) {
                setupAdapter(this.cardDetailModel.getHistoricsData());
            } else {
                showEmptyFragment();
            }
        }
    }

    private void showEmptyFragment() {
        this.mbReports.setVisibility(8);
        this.tvNoMovements.setVisibility(0);
    }

    private void setupAdapter(List<HistoricsData> historicsData) {
        List<MovementsHistoryModel> movementsDataModel = getMovementsDataModel(historicsData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.rvLastActionsTransportCard.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvLastActionsTransportCard.getContext(), linearLayoutManager.getOrientation());
        Drawable drawable = ContextCompat.getDrawable(this.rvLastActionsTransportCard.getContext(), R.drawable.drawable_separator_recyclerview);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        this.rvLastActionsTransportCard.addItemDecoration(dividerItemDecoration);
        MovementsTransportCardAdapter movementsTransportCardAdapter = new MovementsTransportCardAdapter(movementsDataModel, this.cardDetailModel.getCardTypeId());
        this.adapter = movementsTransportCardAdapter;
        this.rvLastActionsTransportCard.setAdapter(movementsTransportCardAdapter);
    }

    private List<MovementsHistoryModel> getMovementsDataModel(List<HistoricsData> historicsData) {
        ArrayList arrayList = new ArrayList();
        for (HistoricsData historicsData2 : historicsData) {
            if (historicsData2.getRechargeHistoryModel() != null) {
                arrayList.add(new MovementsHistoryModel(historicsData2.getHistoricDate(), historicsData2.getRechargeHistoryModel()));
            }
            if (historicsData2.getValidationHistoryModel() != null) {
                arrayList.add(new MovementsHistoryModel(historicsData2.getHistoricDate(), historicsData2.getValidationHistoryModel()));
            }
        }
        return arrayList;
    }

    public void refreshAdapter(List<HistoricsData> historicsData) {
        List<MovementsHistoryModel> movementsDataModel = getMovementsDataModel(historicsData);
        MovementsTransportCardAdapter movementsTransportCardAdapter = this.adapter;
        if (movementsTransportCardAdapter != null) {
            movementsTransportCardAdapter.addAll(movementsDataModel);
        } else if (historicsData.size() > 0) {
            showInfoFragment();
            setupAdapter(historicsData);
        }
    }

    private void showInfoFragment() {
        this.mbReports.setVisibility(0);
        this.tvNoMovements.setVisibility(8);
    }

    @OnClick({R.id.mbReports})
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), (Class<?>) CreateReportsActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_CREATE_REPORT, this.cardDetailModel.getCardNumber());
        startActivity(intent);
    }
}
