package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.MunicipalityResponseModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MunicipalityAdapter extends ArrayAdapter<MunicipalityResponseModel> {
    private List<MunicipalityResponseModel> modelList;
    private List<MunicipalityResponseModel> modelListFull;
    private Filter municipalityFilter;

    public MunicipalityAdapter(Context context, List<MunicipalityResponseModel> modelList) {
        super(context, 0, modelList);
        this.modelList = new ArrayList();
        this.modelListFull = new ArrayList();
        this.municipalityFilter = new Filter() { // from class: com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard.changezonerecharge.calculatezone.MunicipalityAdapter.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence constraint) {
                MunicipalityAdapter.this.modelList.clear();
                MunicipalityAdapter.this.modelList.addAll(MunicipalityAdapter.this.modelListFull);
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (constraint == null || constraint.length() == 0) {
                    arrayList.addAll(MunicipalityAdapter.this.modelList);
                } else {
                    String strTrim = constraint.toString().toLowerCase().trim();
                    for (MunicipalityResponseModel municipalityResponseModel : MunicipalityAdapter.this.modelList) {
                        if (municipalityResponseModel.getName().toLowerCase().contains(strTrim)) {
                            arrayList.add(municipalityResponseModel);
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                MunicipalityAdapter.this.clear();
                MunicipalityAdapter.this.addAll((List) results.values);
                MunicipalityAdapter.this.notifyDataSetChanged();
            }

            @Override // android.widget.Filter
            public CharSequence convertResultToString(Object resultValue) {
                return ((MunicipalityResponseModel) resultValue).getName();
            }
        };
        this.modelList.addAll(modelList);
        this.modelListFull.addAll(modelList);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return this.municipalityFilter;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_municipality_item, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tvName);
        MunicipalityResponseModel item = getItem(position);
        if (item != null) {
            textView.setText(item.getName());
        }
        return convertView;
    }
}
