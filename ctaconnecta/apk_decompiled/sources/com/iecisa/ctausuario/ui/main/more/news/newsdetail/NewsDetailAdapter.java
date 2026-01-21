package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsSection;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsDetailAdapter extends RecyclerView.Adapter<NewsDetailHolder> {
    private Context context;
    private List<NewsSection> listNewsSection;

    public NewsDetailAdapter(List<NewsSection> listNewsSection, Context context) {
        this.listNewsSection = listNewsSection;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NewsDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsDetailHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_new_detail, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NewsDetailHolder holder, int position) {
        holder.bindView(this.listNewsSection.get(position), this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listNewsSection.size();
    }
}
