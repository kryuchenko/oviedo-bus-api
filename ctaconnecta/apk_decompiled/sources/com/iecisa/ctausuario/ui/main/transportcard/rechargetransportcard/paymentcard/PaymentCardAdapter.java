package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.paymentcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.PaymentCardModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class PaymentCardAdapter extends ArrayAdapter<PaymentCardModel> {
    private Context context;
    private List<PaymentCardModel> modelList;

    public PaymentCardAdapter(Context context, List<PaymentCardModel> modelList) {
        super(context, 0, modelList);
        ArrayList arrayList = new ArrayList();
        this.modelList = arrayList;
        this.context = context;
        arrayList.addAll(modelList);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_simple_adapter, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        if (getItem(position) != null) {
            textView.setText(getItem(position).getCardNumber());
        }
        return convertView;
    }
}
