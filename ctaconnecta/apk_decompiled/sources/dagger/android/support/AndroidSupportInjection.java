package dagger.android.support;

import android.app.Application;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import dagger.android.AndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AndroidSupportInjection {
    private static final String TAG = "dagger.android.support";

    public static void inject(Fragment fragment) {
        AndroidInjector<Object> androidInjectorSupportFragmentInjector;
        Preconditions.checkNotNull(fragment, "fragment");
        Object objFindHasSupportFragmentInjector = findHasSupportFragmentInjector(fragment);
        if (objFindHasSupportFragmentInjector instanceof HasAndroidInjector) {
            androidInjectorSupportFragmentInjector = ((HasAndroidInjector) objFindHasSupportFragmentInjector).androidInjector();
            Preconditions.checkNotNull(androidInjectorSupportFragmentInjector, "%s.androidInjector() returned null", objFindHasSupportFragmentInjector.getClass());
        } else if (objFindHasSupportFragmentInjector instanceof HasSupportFragmentInjector) {
            androidInjectorSupportFragmentInjector = ((HasSupportFragmentInjector) objFindHasSupportFragmentInjector).supportFragmentInjector();
            Preconditions.checkNotNull(androidInjectorSupportFragmentInjector, "%s.supportFragmentInjector() returned null", objFindHasSupportFragmentInjector.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", objFindHasSupportFragmentInjector.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasSupportFragmentInjector.class.getCanonicalName()));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.format("An injector for %s was found in %s", fragment.getClass().getCanonicalName(), objFindHasSupportFragmentInjector.getClass().getCanonicalName()));
        }
        androidInjectorSupportFragmentInjector.inject(fragment);
    }

    private static Object findHasSupportFragmentInjector(Fragment fragment) {
        Fragment parentFragment = fragment;
        do {
            parentFragment = parentFragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment instanceof HasAndroidInjector) {
                    break;
                }
            } else {
                FragmentActivity activity = fragment.getActivity();
                boolean z = activity instanceof HasAndroidInjector;
                Application application = activity;
                if (!z) {
                    boolean z2 = activity instanceof HasSupportFragmentInjector;
                    application = activity;
                    if (!z2) {
                        Application application2 = activity.getApplication();
                        boolean z3 = application2 instanceof HasAndroidInjector;
                        application = application2;
                        if (!z3) {
                            boolean z4 = application2 instanceof HasSupportFragmentInjector;
                            application = application2;
                            if (!z4) {
                                throw new IllegalArgumentException(String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
                            }
                        }
                    }
                }
                return application;
            }
        } while (!(parentFragment instanceof HasSupportFragmentInjector));
        return parentFragment;
    }

    private AndroidSupportInjection() {
    }
}
