package com.iecisa.ctausuario.ui.main.more.news.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsCategory;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class CategoriesAdapter extends ArrayAdapter<NewsCategory> {
    private Context context;
    private List<NewsCategory> modelList;

    public CategoriesAdapter(Context context, List<NewsCategory> modelList) {
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
            textView.setText(getItem(position).getName());
        }
        return convertView;
    }
}
