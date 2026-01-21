package com.iecisa.ctausuario.ui.main.more.news.newsdetail;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.BuildConfig;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsCta;
import com.iecisa.ctausuario.model.NewsDetail;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.glide.GlideApp;
import javax.inject.Inject;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class NewsDetailActivity extends CustomToolbarActivity {
    protected static final String COMMA = ", ";
    protected static final String EMPTY = "";

    @BindView(R.id.ivAlert)
    ImageView ivAlert;

    @BindView(R.id.ivNewImage)
    ImageView ivNewImage;
    private NewsDetailViewModel newsDetailViewModel;

    @BindView(R.id.rvSectionsNew)
    RecyclerView rvSectionsNew;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvDateNewDetail)
    TextView tvDateNewDetail;

    @BindView(R.id.tvErrorNewDetailData)
    TextView tvErrorNewDetailData;

    @BindView(R.id.tvSeparator)
    TextView tvSeparator;

    @BindView(R.id.tvSubtitleNewDetail)
    TextView tvSubtitleNewDetail;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvTypeNewDetail)
    TextView tvTypeNewDetail;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_new_detail;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.newsDetailViewModel = (NewsDetailViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(NewsDetailViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_news_detail));
        if (getIntent().getExtras() != null) {
            NewsCta newsCta = (NewsCta) getIntent().getExtras().getParcelable(Constants.IntentData.INTENT_NEWS_DETAIL);
            if (newsCta != null) {
                getDataFromNew(newsCta.getNewsId());
                return;
            } else {
                BaseUtils.showKoDialog(this, getString(R.string.error_news_unable_get_new_detail));
                return;
            }
        }
        BaseUtils.showKoDialog(this, getString(R.string.error_news_unable_get_new_detail));
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$data$Resource$Status;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            $SwitchMap$com$cexmobility$core$data$Resource$Status = iArr;
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$data$Resource$Status[Resource.Status.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void getDataFromNew(String idNew) {
        this.newsDetailViewModel.getNewsDetail(idNew, this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getDataFromNew$0((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getDataFromNew$0(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            Timber.d(resource.message, new Object[0]);
            BaseUtils.showKoDialog(this, getString(R.string.error_news_unable_get_new_detail));
        } else {
            if (i != 3) {
                return;
            }
            setUpView((NewsDetail) resource.data);
        }
    }

    private void setUpView(NewsDetail newCta) {
        if (!TextUtils.isEmpty(newCta.getImageNewDetail())) {
            GlideApp.with((FragmentActivity) this).load(BuildConfig.BASE_URL_WEB + newCta.getImageNewDetail()).into(this.ivNewImage);
        } else {
            this.ivNewImage.setVisibility(8);
        }
        this.tvTitle.setText(newCta.getTitleNewDetail());
        this.tvSubtitleNewDetail.setText(newCta.getShortDescriptionNewDetail());
        StringBuilder sb = new StringBuilder();
        this.ivAlert.setVisibility(8);
        int i = 0;
        while (true) {
            if (i >= newCta.getCategoryNew().size()) {
                break;
            }
            sb.append(newCta.getCategoryNew().get(i).getName());
            sb.append(newCta.getCategoryNew().size() + (-1) != i ? COMMA : "");
            if (newCta.getCategoryNew().get(i).getName().equals(getString(R.string.label_news_alert))) {
                this.ivAlert.setVisibility(0);
            }
            i++;
        }
        if (sb.length() > 0) {
            this.tvTypeNewDetail.setText(sb);
            this.tvSeparator.setVisibility(0);
        } else {
            this.tvTypeNewDetail.setText("");
            this.tvSeparator.setVisibility(8);
        }
        this.tvDateNewDetail.setText(newCta.getDateNewDetail());
        setUpBodyNew(newCta);
    }

    private void setUpBodyNew(NewsDetail newCta) {
        if (newCta.getSectionsNew() != null && newCta.getSectionsNew().size() > 0) {
            this.rvSectionsNew.setLayoutManager(new LinearLayoutManager(this));
            this.rvSectionsNew.setAdapter(new NewsDetailAdapter(newCta.getSectionsNew(), this));
            return;
        }
        showErrorNoSections();
    }

    private void showErrorNoSections() {
        this.tvErrorNewDetailData.setVisibility(0);
        RecyclerView recyclerView = this.rvSectionsNew;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
    }
}
