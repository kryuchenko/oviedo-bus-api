package dagger.android;

import android.app.Activity;
import android.os.Bundle;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public abstract class DaggerActivity extends Activity implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        AndroidInjection.inject(this);
        super.onCreate(bundle);
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        return this.androidInjector;
    }
}
