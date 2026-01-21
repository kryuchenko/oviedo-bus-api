package com.iecisa.ctausuario.ui.main.more.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsCta;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private Context context;
    private List<NewsCta> listNews;
    private OnNewClickListener onNewClickListener;

    public interface OnNewClickListener {
        void onNewClick(NewsCta newsCta);
    }

    public NewsAdapter(Context context, List<NewsCta> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    public void setOnNewClickListener(OnNewClickListener onNewClickListener) {
        this.onNewClickListener = onNewClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final NewsHolder holder, int position) {
        holder.bindView(this.listNews.get(position), this.context);
        holder.rowNews.setOnClickListener(new View.OnClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.news.NewsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(NewsHolder newsHolder, View view) {
        this.onNewClickListener.onNewClick(this.listNews.get(newsHolder.getAdapterPosition()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listNews.size();
    }

    public void addAll(List<NewsCta> news) {
        this.listNews.clear();
        Iterator<NewsCta> it = news.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        notifyDataSetChanged();
    }

    public void add(NewsCta model) {
        this.listNews.add(model);
        notifyDataSetChanged();
        notifyItemChanged(findPosition(model.getNewsId()));
    }

    private int findPosition(String idNew) {
        for (int i = 0; i < this.listNews.size(); i++) {
            if (this.listNews.get(i).getNewsId().equals(idNew)) {
                return i;
            }
        }
        return -1;
    }
}
