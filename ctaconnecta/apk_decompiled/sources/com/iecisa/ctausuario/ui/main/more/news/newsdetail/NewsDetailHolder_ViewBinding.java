package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class NewsDetailHolder_ViewBinding implements Unbinder {
    private NewsDetailHolder target;

    public NewsDetailHolder_ViewBinding(NewsDetailHolder target, View source) {
        this.target = target;
        target.rowDetailNews = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowDetailNews, "field 'rowDetailNews'", ConstraintLayout.class);
        target.ivSectionImage = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivSectionImage, "field 'ivSectionImage'", ImageView.class);
        target.tvTitleSection = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitleSection, "field 'tvTitleSection'", TextView.class);
        target.tvSubtitleSection = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSubtitleSection, "field 'tvSubtitleSection'", TextView.class);
        target.tvTextSection = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTextSection, "field 'tvTextSection'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewsDetailHolder newsDetailHolder = this.target;
        if (newsDetailHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newsDetailHolder.rowDetailNews = null;
        newsDetailHolder.ivSectionImage = null;
        newsDetailHolder.tvTitleSection = null;
        newsDetailHolder.tvSubtitleSection = null;
        newsDetailHolder.tvTextSection = null;
    }
}
