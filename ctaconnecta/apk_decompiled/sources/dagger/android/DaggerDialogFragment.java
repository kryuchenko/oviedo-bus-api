package dagger.android;

import android.app.DialogFragment;
import android.content.Context;
import javax.inject.Inject;

@Deprecated
/* loaded from: classes5.dex */
public abstract class DaggerDialogFragment extends DialogFragment implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        return this.androidInjector;
    }
}
