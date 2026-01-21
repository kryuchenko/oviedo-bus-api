package com.iecisa.ctausuario.ui.main.more.news;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.cexmobility.core.data.Resource;
import com.cexmobility.core.enums.ToolbarActions;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.NewsCategory;
import com.iecisa.ctausuario.model.NewsCategoryResponseModel;
import com.iecisa.ctausuario.model.NewsCta;
import com.iecisa.ctausuario.model.NewsResponse;
import com.iecisa.ctausuario.ui.main.CustomToolbarActivity;
import com.iecisa.ctausuario.ui.main.more.news.NewsAdapter;
import com.iecisa.ctausuario.ui.main.more.news.categories.CategoriesAdapter;
import com.iecisa.ctausuario.ui.main.more.news.newsdetail.NewsDetailActivity;
import com.iecisa.ctausuario.utils.BaseUtils;
import com.iecisa.ctausuario.utils.Constants;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class NewsActivity extends CustomToolbarActivity {
    private CategoriesAdapter adapter;
    private NewsAdapter newsAdapter;
    private NewsViewModel newsViewModel;

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    @BindView(R.id.sTypeNews)
    AutoCompleteTextView sTypeNews;
    private NewsCategory selectedModel;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tvErrorNewsData)
    TextView tvErrorNewsData;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override // com.cexmobility.core.ui.BaseActivity
    protected int getLayoutResource() {
        return R.layout.activity_news;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected boolean hasInjection() {
        return true;
    }

    @Override // com.cexmobility.core.ui.BaseActivity
    protected void initializeView() {
        this.newsViewModel = (NewsViewModel) ViewModelProviders.of(this, this.viewModelFactory).get(NewsViewModelImpl.class);
        setToolbar(this.toolbar, ToolbarActions.BACK, getString(R.string.title_toolbar_news));
        getNews(null);
        getCategories();
        setupListeners();
    }

    private void setupListeners() {
        this.sTypeNews.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.news.NewsActivity$$ExternalSyntheticLambda2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupListeners$0(adapterView, view, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupListeners$0(AdapterView adapterView, View view, int i, long j) {
        CategoriesAdapter categoriesAdapter = this.adapter;
        if (categoriesAdapter != null) {
            this.selectedModel = categoriesAdapter.getItem(i);
            BaseUtils.setupAdapter(this.adapter, this.sTypeNews);
            NewsCategory newsCategory = this.selectedModel;
            if (newsCategory != null) {
                getNews(newsCategory.getId());
            }
        }
    }

    private void getCategories() {
        this.newsViewModel.getCategories(this).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.more.news.NewsActivity$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getCategories$1((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getCategories$1(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            return;
        }
        if (i == 2) {
            showLoading();
        } else {
            if (i != 3) {
                return;
            }
            hideLoading();
            if (resource.data != 0) {
                setupAdapter(((NewsCategoryResponseModel) resource.data).getCategories());
            }
        }
    }

    private void setupAdapter(List<NewsCategory> categories) {
        categories.add(0, new NewsCategory(null, getString(R.string.label_all_news_item)));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this, categories);
        this.adapter = categoriesAdapter;
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sTypeNews.setAdapter(this.adapter);
        this.sTypeNews.setText(getString(R.string.label_all_news_item));
        BaseUtils.setupAdapter(this.adapter, this.sTypeNews);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    /* renamed from: onSupportNavigateUp */
    public boolean lambda$showIsRepresentativeDialog$3() {
        onBackPressed();
        finish();
        return true;
    }

    /* renamed from: com.iecisa.ctausuario.ui.main.more.news.NewsActivity$1, reason: invalid class name */
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

    private void getNews(String category) {
        this.newsViewModel.getNewsList(0, this, category).observe(this, new Observer() { // from class: com.iecisa.ctausuario.ui.main.more.news.NewsActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$getNews$2((Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getNews$2(Resource resource) {
        int i = AnonymousClass1.$SwitchMap$com$cexmobility$core$data$Resource$Status[resource.status.ordinal()];
        if (i == 1) {
            hideLoading();
            return;
        }
        if (i == 2) {
            showLoading();
            return;
        }
        if (i != 3) {
            return;
        }
        hideLoading();
        if (resource.data != 0 && ((NewsResponse) resource.data).getListNews() != null && !((NewsResponse) resource.data).getListNews().isEmpty()) {
            showErrorNoNews(true);
            if (this.newsAdapter != null) {
                reloadNews(((NewsResponse) resource.data).getListNews());
                return;
            } else {
                setUpView(((NewsResponse) resource.data).getListNews());
                return;
            }
        }
        showErrorNoNews(false);
    }

    private void reloadNews(List<NewsCta> listNews) {
        this.newsAdapter.addAll(listNews);
    }

    private void setUpView(List<NewsCta> listNews) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rvNews.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvNews.getContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.drawable_separator_recyclerview));
        this.rvNews.addItemDecoration(dividerItemDecoration);
        NewsAdapter newsAdapter = new NewsAdapter(this, listNews);
        this.newsAdapter = newsAdapter;
        this.rvNews.setAdapter(newsAdapter);
        this.newsAdapter.setOnNewClickListener(new NewsAdapter.OnNewClickListener() { // from class: com.iecisa.ctausuario.ui.main.more.news.NewsActivity$$ExternalSyntheticLambda0
            @Override // com.iecisa.ctausuario.ui.main.more.news.NewsAdapter.OnNewClickListener
            public final void onNewClick(NewsCta newsCta) {
                this.f$0.onNewClick(newsCta);
            }
        });
    }

    private void showErrorNoNews(boolean areNews) {
        this.tvErrorNewsData.setVisibility(areNews ? 8 : 0);
        RecyclerView recyclerView = this.rvNews;
        if (recyclerView != null) {
            recyclerView.setVisibility(areNews ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewClick(NewsCta newsCta) {
        Intent intent = new Intent(this, (Class<?>) NewsDetailActivity.class);
        intent.putExtra(Constants.IntentData.INTENT_NEWS_DETAIL, newsCta);
        startActivity(intent);
    }
}
