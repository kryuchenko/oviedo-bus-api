package com.iecisa.ctausuario.ui.main.more.news;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class NewsActivity_ViewBinding implements Unbinder {
    private NewsActivity target;

    public NewsActivity_ViewBinding(NewsActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public NewsActivity_ViewBinding(NewsActivity target, View source) {
        this.target = target;
        target.sTypeNews = (AutoCompleteTextView) Utils.findRequiredViewAsType(source, R.id.sTypeNews, "field 'sTypeNews'", AutoCompleteTextView.class);
        target.rvNews = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvNews, "field 'rvNews'", RecyclerView.class);
        target.tvErrorNewsData = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorNewsData, "field 'tvErrorNewsData'", TextView.class);
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewsActivity newsActivity = this.target;
        if (newsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newsActivity.sTypeNews = null;
        newsActivity.rvNews = null;
        newsActivity.tvErrorNewsData = null;
        newsActivity.toolbar = null;
    }
}
