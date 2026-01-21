package com.iecisa.ctausuario.di;

import com.iecisa.ctausuario.ui.main.more.news.NewsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {NewsActivitySubcomponent.class})
/* loaded from: classes5.dex */
public abstract class ActivityModule_ContributesNewsActivity {

    @Subcomponent
    public interface NewsActivitySubcomponent extends AndroidInjector<NewsActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<NewsActivity> {
        }
    }

    @Binds
    @ClassKey(NewsActivity.class)
    @IntoMap
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(NewsActivitySubcomponent.Factory builder);

    private ActivityModule_ContributesNewsActivity() {
    }
}
