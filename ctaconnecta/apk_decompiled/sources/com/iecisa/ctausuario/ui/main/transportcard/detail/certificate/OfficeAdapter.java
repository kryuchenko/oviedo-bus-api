package com.iecisa.ctausuario.ui.main.transportcard.detail.certificate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.OfficeResponseModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class OfficeAdapter extends ArrayAdapter<OfficeResponseModel> {
    private Context context;
    private List<OfficeResponseModel> officeList;

    public OfficeAdapter(Context context, List<OfficeResponseModel> officeList) {
        super(context, 0, officeList);
        ArrayList arrayList = new ArrayList();
        this.officeList = arrayList;
        this.context = context;
        arrayList.addAll(officeList);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_office_detail, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        TextView textView2 = (TextView) convertView.findViewById(R.id.tvAddress);
        OfficeResponseModel item = getItem(position);
        if (item != null) {
            textView.setText(item.getName());
            textView2.setText(this.context.getString(R.string.label_office_detail_row, item.getAddress(), item.getPostalCode(), item.getTown()));
        }
        return convertView;
    }

    public void clearAll() {
        this.officeList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<OfficeResponseModel> models) {
        this.officeList.clear();
        this.officeList.addAll(models);
        notifyDataSetChanged();
    }
}
