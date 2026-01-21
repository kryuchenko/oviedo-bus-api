package com.iecisa.ctausuario.ui.main.datelines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.StopTime;
import java.util.List;

/* loaded from: classes5.dex */
public class TimesAdapter extends BaseAdapter {
    private Context context;
    private List<StopTime> listTimes;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public TimesAdapter(List<StopTime> listTimes, Context context) {
        this.listTimes = listTimes;
        this.context = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.listTimes.size();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_times, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.tvTime)).setText(this.listTimes.get(position).getStopTime());
        return convertView;
    }

    public void setListTimes(List<StopTime> listTimes) {
        this.listTimes = listTimes;
    }
}
