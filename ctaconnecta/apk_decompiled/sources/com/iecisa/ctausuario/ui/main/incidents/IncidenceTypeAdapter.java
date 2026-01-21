package com.iecisa.ctausuario.ui.main.incidents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.IncidenceTypeResponseModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class IncidenceTypeAdapter extends ArrayAdapter<IncidenceTypeResponseModel> {
    private List<IncidenceTypeResponseModel> modelList;

    public IncidenceTypeAdapter(Context context, List<IncidenceTypeResponseModel> modelList) {
        super(context, 0, modelList);
        ArrayList arrayList = new ArrayList();
        this.modelList = arrayList;
        arrayList.addAll(modelList);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_simple_adapter, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        if (getItem(position) != null) {
            textView.setText(getItem(position).getName());
        }
        return convertView;
    }

    public void setModelList(List<IncidenceTypeResponseModel> modelList) {
        this.modelList = modelList;
    }
}
