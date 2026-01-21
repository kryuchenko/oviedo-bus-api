package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsSection;
import com.iecisa.ctausuario.utils.glide.GlideApp;

/* loaded from: classes5.dex */
public class NewsDetailHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivSectionImage)
    ImageView ivSectionImage;

    @BindView(R.id.rowDetailNews)
    ConstraintLayout rowDetailNews;

    @BindView(R.id.tvSubtitleSection)
    TextView tvSubtitleSection;

    @BindView(R.id.tvTextSection)
    TextView tvTextSection;

    @BindView(R.id.tvTitleSection)
    TextView tvTitleSection;

    public NewsDetailHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(NewsSection section, Context context) {
        setImageSection(section, context);
        if (!TextUtils.isEmpty(section.getTitle())) {
            this.tvTitleSection.setText(Html.fromHtml(section.getTitle()));
            this.tvTitleSection.setVisibility(0);
        } else {
            this.tvTitleSection.setVisibility(8);
        }
        if (!TextUtils.isEmpty(section.getShortDescription())) {
            this.tvSubtitleSection.setText(Html.fromHtml(section.getShortDescription()));
            this.tvSubtitleSection.setVisibility(0);
        } else {
            this.tvSubtitleSection.setVisibility(8);
        }
        if (!TextUtils.isEmpty(section.getTextSection())) {
            this.tvTextSection.setText(Html.fromHtml(section.getTextSection()));
            this.tvTextSection.setVisibility(0);
        } else {
            this.tvTextSection.setVisibility(8);
        }
    }

    private void setImageSection(NewsSection newsSection, Context context) {
        if (!TextUtils.isEmpty(newsSection.getImageSection())) {
            GlideApp.with(context).load(BuildConfig.BASE_URL_WEB + newsSection.getImageSection()).into(this.ivSectionImage);
            return;
        }
        this.ivSectionImage.setVisibility(8);
    }
}
