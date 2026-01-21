package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iecisa.ctausuario.R;

/* loaded from: classes5.dex */
public class NewsDetailActivity_ViewBinding implements Unbinder {
    private NewsDetailActivity target;

    public NewsDetailActivity_ViewBinding(NewsDetailActivity target) {
        this(target, target.getWindow().getDecorView());
    }

    public NewsDetailActivity_ViewBinding(NewsDetailActivity target, View source) {
        this.target = target;
        target.ivNewImage = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivNewImage, "field 'ivNewImage'", ImageView.class);
        target.ivAlert = (ImageView) Utils.findRequiredViewAsType(source, R.id.ivAlert, "field 'ivAlert'", ImageView.class);
        target.tvTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
        target.tvSubtitleNewDetail = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSubtitleNewDetail, "field 'tvSubtitleNewDetail'", TextView.class);
        target.tvTypeNewDetail = (TextView) Utils.findRequiredViewAsType(source, R.id.tvTypeNewDetail, "field 'tvTypeNewDetail'", TextView.class);
        target.tvSeparator = (TextView) Utils.findRequiredViewAsType(source, R.id.tvSeparator, "field 'tvSeparator'", TextView.class);
        target.tvDateNewDetail = (TextView) Utils.findRequiredViewAsType(source, R.id.tvDateNewDetail, "field 'tvDateNewDetail'", TextView.class);
        target.rvSectionsNew = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.rvSectionsNew, "field 'rvSectionsNew'", RecyclerView.class);
        target.tvErrorNewDetailData = (TextView) Utils.findRequiredViewAsType(source, R.id.tvErrorNewDetailData, "field 'tvErrorNewDetailData'", TextView.class);
        target.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewsDetailActivity newsDetailActivity = this.target;
        if (newsDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newsDetailActivity.ivNewImage = null;
        newsDetailActivity.ivAlert = null;
        newsDetailActivity.tvTitle = null;
        newsDetailActivity.tvSubtitleNewDetail = null;
        newsDetailActivity.tvTypeNewDetail = null;
        newsDetailActivity.tvSeparator = null;
        newsDetailActivity.tvDateNewDetail = null;
        newsDetailActivity.rvSectionsNew = null;
        newsDetailActivity.tvErrorNewDetailData = null;
        newsDetailActivity.toolbar = null;
    }
}
