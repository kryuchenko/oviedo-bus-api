package com.iecisa.ctausuario.ui.main.transportcard.transportcardrequest.continuerequest;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.utils.DateUtils;
import java.util.Date;

/* loaded from: classes5.dex */
public class PendingRequestsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rowTransportCardRequest)
    ConstraintLayout rowLine;

    @BindView(R.id.tvRequestDateTime)
    TextView tvRequestDateTime;

    @BindView(R.id.tvRequestNumber)
    TextView tvRequestNumber;

    public PendingRequestsHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(Date requestDate, String requestNumber, Context context) {
        this.tvRequestDateTime.setText(context.getString(R.string.label_continue_request_datetime, DateUtils.dateToString(requestDate)));
        this.tvRequestNumber.setText(context.getString(R.string.label_continue_request_transaction, requestNumber));
    }
}
