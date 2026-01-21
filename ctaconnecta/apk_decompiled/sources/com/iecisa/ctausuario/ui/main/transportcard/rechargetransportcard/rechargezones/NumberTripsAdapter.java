package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.rechargezones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class NumberTripsAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private List<Integer> numberTrips;

    public NumberTripsAdapter(Context context, List<Integer> modelList) {
        super(context, 0, modelList);
        ArrayList arrayList = new ArrayList();
        this.numberTrips = arrayList;
        this.context = context;
        arrayList.addAll(modelList);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_simple_adapter, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        Integer item = getItem(position);
        if (item != null) {
            if (item.intValue() == 1) {
                textView.setText(this.context.getString(R.string.buy_trip));
                return convertView;
            }
            textView.setText(this.context.getString(R.string.buy_trips, item));
        }
        return convertView;
    }
}
