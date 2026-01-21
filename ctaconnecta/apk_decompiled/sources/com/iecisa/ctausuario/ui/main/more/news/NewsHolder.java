package com.iecisa.ctausuario.ui.main.more.news;

import android.content.Context;
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
import com.iecisa.ctausuario.model.NewsCta;
import com.iecisa.ctausuario.utils.glide.GlideApp;

/* loaded from: classes5.dex */
public class NewsHolder extends RecyclerView.ViewHolder {
    protected static final String COMMA = ", ";
    protected static final String EMPTY = "";

    @BindView(R.id.ivAlert)
    ImageView ivAlert;

    @BindView(R.id.ivNewImage)
    ImageView ivNewImage;

    @BindView(R.id.rowNews)
    ConstraintLayout rowNews;

    @BindView(R.id.tvDateNew)
    TextView tvDateNew;

    @BindView(R.id.tvSeparator)
    TextView tvSeparator;

    @BindView(R.id.tvSubtitleNew)
    TextView tvSubtitleNew;

    @BindView(R.id.tvTitleNew)
    TextView tvTitleNew;

    @BindView(R.id.tvTypeNew)
    TextView tvTypeNew;

    public NewsHolder(View itemView) throws NoSuchMethodException, SecurityException {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(NewsCta newsCta, Context context) {
        getImageNew(newsCta, context);
        this.tvTitleNew.setText(newsCta.getNewsTitle());
        this.tvSubtitleNew.setText(newsCta.getNewsSubtitle());
        this.tvDateNew.setText(newsCta.getNewsDate());
        getTypeNew(context, newsCta);
    }

    public void getTypeNew(Context context, NewsCta newsCta) {
        if (newsCta.getNewsCategoriesList() != null && newsCta.getNewsCategoriesList().size() > 0) {
            StringBuilder sb = new StringBuilder();
            this.ivAlert.setVisibility(8);
            int i = 0;
            while (i < newsCta.getNewsCategoriesList().size()) {
                sb.append(newsCta.getNewsCategoriesList().get(i).getName());
                sb.append(newsCta.getNewsCategoriesList().size() + (-1) == i ? "" : COMMA);
                if (newsCta.getNewsCategoriesList().get(i).getName().equals(context.getString(R.string.label_news_alert))) {
                    this.ivAlert.setVisibility(0);
                }
                i++;
            }
            this.tvTypeNew.setText(sb);
            this.tvSeparator.setVisibility(0);
            return;
        }
        this.tvTypeNew.setText("");
        this.tvSeparator.setVisibility(8);
    }

    private void getImageNew(NewsCta newsCta, Context context) {
        if (!TextUtils.isEmpty(newsCta.getNewsImage())) {
            GlideApp.with(context).load(BuildConfig.BASE_URL_WEB + newsCta.getNewsImage()).into(this.ivNewImage);
            this.ivNewImage.setVisibility(0);
            return;
        }
        this.ivNewImage.setVisibility(8);
    }
}
