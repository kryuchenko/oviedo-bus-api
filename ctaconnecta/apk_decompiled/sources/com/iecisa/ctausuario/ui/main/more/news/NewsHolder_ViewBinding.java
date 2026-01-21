package com.iecisa.ctausuario.ui.main.more.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class NewsHolder_ViewBinding implements Unbinder {
    private NewsHolder target;

    public NewsHolder_ViewBinding(NewsHolder target, View source) {
        this.target = target;
        target.rowNews = (ConstraintLayout) Utils.findRequiredViewAsType(source, R.id.rowNews, "field 'rowNews'", ConstraintLayout.class);
        target.ivAlert = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivAlert, "field 'ivAlert'", ImageView.class);
        target.tvTitleNew = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitleNew, "field 'tvTitleNew'", TextView.class);
        target.tvSubtitleNew = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSubtitleNew, "field 'tvSubtitleNew'", TextView.class);
        target.tvTypeNew = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTypeNew, "field 'tvTypeNew'", TextView.class);
        target.tvSeparator = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSeparator, "field 'tvSeparator'", TextView.class);
        target.tvDateNew = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDateNew, "field 'tvDateNew'", TextView.class);
        target.ivNewImage = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivNewImage, "field 'ivNewImage'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewsHolder newsHolder = this.target;
        if (newsHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newsHolder.rowNews = null;
        newsHolder.ivAlert = null;
        newsHolder.tvTitleNew = null;
        newsHolder.tvSubtitleNew = null;
        newsHolder.tvTypeNew = null;
        newsHolder.tvSeparator = null;
        newsHolder.tvDateNew = null;
        newsHolder.ivNewImage = null;
    }
}
