package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ContentProvider;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class AndroidInjection {
    private static final String TAG = "dagger.android";

    public static void inject(Activity activity) {
        AndroidInjector<Object> androidInjectorActivityInjector;
        Preconditions.checkNotNull(activity, "activity");
        ComponentCallbacks2 application = activity.getApplication();
        if (application instanceof HasAndroidInjector) {
            androidInjectorActivityInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjectorActivityInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasActivityInjector) {
            androidInjectorActivityInjector = ((HasActivityInjector) application).activityInjector();
            Preconditions.checkNotNull(androidInjectorActivityInjector, "%s.activityInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasActivityInjector.class.getCanonicalName()));
        }
        androidInjectorActivityInjector.inject(activity);
    }

    public static void inject(Fragment fragment) {
        AndroidInjector<Object> androidInjectorFragmentInjector;
        Preconditions.checkNotNull(fragment, "fragment");
        Object objFindHasFragmentInjector = findHasFragmentInjector(fragment);
        if (objFindHasFragmentInjector instanceof HasAndroidInjector) {
            androidInjectorFragmentInjector = ((HasAndroidInjector) objFindHasFragmentInjector).androidInjector();
            Preconditions.checkNotNull(androidInjectorFragmentInjector, "%s.androidInjector() returned null", objFindHasFragmentInjector.getClass());
        } else if (objFindHasFragmentInjector instanceof HasFragmentInjector) {
            androidInjectorFragmentInjector = ((HasFragmentInjector) objFindHasFragmentInjector).fragmentInjector();
            Preconditions.checkNotNull(androidInjectorFragmentInjector, "%s.fragmentInjector() returned null", objFindHasFragmentInjector.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", objFindHasFragmentInjector.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasFragmentInjector.class.getCanonicalName()));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, String.format("An injector for %s was found in %s", fragment.getClass().getCanonicalName(), objFindHasFragmentInjector.getClass().getCanonicalName()));
        }
        androidInjectorFragmentInjector.inject(fragment);
    }

    private static Object findHasFragmentInjector(Fragment fragment) {
        Fragment parentFragment = fragment;
        do {
            parentFragment = parentFragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment instanceof HasAndroidInjector) {
                    break;
                }
            } else {
                Activity activity = fragment.getActivity();
                boolean z = activity instanceof HasAndroidInjector;
                Application application = activity;
                if (!z) {
                    boolean z2 = activity instanceof HasFragmentInjector;
                    application = activity;
                    if (!z2) {
                        Application application2 = activity.getApplication();
                        boolean z3 = application2 instanceof HasAndroidInjector;
                        application = application2;
                        if (!z3) {
                            boolean z4 = application2 instanceof HasFragmentInjector;
                            application = application2;
                            if (!z4) {
                                throw new IllegalArgumentException(String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
                            }
                        }
                    }
                }
                return application;
            }
        } while (!(parentFragment instanceof HasFragmentInjector));
        return parentFragment;
    }

    public static void inject(Service service) {
        AndroidInjector<Object> androidInjectorServiceInjector;
        Preconditions.checkNotNull(service, NotificationCompat.CATEGORY_SERVICE);
        ComponentCallbacks2 application = service.getApplication();
        if (application instanceof HasAndroidInjector) {
            androidInjectorServiceInjector = ((HasAndroidInjector) application).androidInjector();
            Preconditions.checkNotNull(androidInjectorServiceInjector, "%s.androidInjector() returned null", application.getClass());
        } else if (application instanceof HasServiceInjector) {
            androidInjectorServiceInjector = ((HasServiceInjector) application).serviceInjector();
            Preconditions.checkNotNull(androidInjectorServiceInjector, "%s.serviceInjector() returned null", application.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", application.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasServiceInjector.class.getCanonicalName()));
        }
        androidInjectorServiceInjector.inject(service);
    }

    public static void inject(BroadcastReceiver broadcastReceiver, Context context) {
        AndroidInjector<Object> androidInjectorBroadcastReceiverInjector;
        Preconditions.checkNotNull(broadcastReceiver, "broadcastReceiver");
        Preconditions.checkNotNull(context, "context");
        ComponentCallbacks2 componentCallbacks2 = (Application) context.getApplicationContext();
        if (componentCallbacks2 instanceof HasAndroidInjector) {
            androidInjectorBroadcastReceiverInjector = ((HasAndroidInjector) componentCallbacks2).androidInjector();
            Preconditions.checkNotNull(androidInjectorBroadcastReceiverInjector, "%s.androidInjector() returned null", componentCallbacks2.getClass());
        } else if (componentCallbacks2 instanceof HasBroadcastReceiverInjector) {
            androidInjectorBroadcastReceiverInjector = ((HasBroadcastReceiverInjector) componentCallbacks2).broadcastReceiverInjector();
            Preconditions.checkNotNull(androidInjectorBroadcastReceiverInjector, "%s.broadcastReceiverInjector() returned null", componentCallbacks2.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", componentCallbacks2.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName()));
        }
        androidInjectorBroadcastReceiverInjector.inject(broadcastReceiver);
    }

    public static void inject(ContentProvider contentProvider) {
        AndroidInjector<Object> androidInjectorContentProviderInjector;
        Preconditions.checkNotNull(contentProvider, "contentProvider");
        ComponentCallbacks2 componentCallbacks2 = (Application) contentProvider.getContext().getApplicationContext();
        if (componentCallbacks2 instanceof HasAndroidInjector) {
            androidInjectorContentProviderInjector = ((HasAndroidInjector) componentCallbacks2).androidInjector();
            Preconditions.checkNotNull(androidInjectorContentProviderInjector, "%s.androidInjector() returned null", componentCallbacks2.getClass());
        } else if (componentCallbacks2 instanceof HasContentProviderInjector) {
            androidInjectorContentProviderInjector = ((HasContentProviderInjector) componentCallbacks2).contentProviderInjector();
            Preconditions.checkNotNull(androidInjectorContentProviderInjector, "%s.contentProviderInjector() returned null", componentCallbacks2.getClass());
        } else {
            throw new RuntimeException(String.format("%s does not implement %s or %s", componentCallbacks2.getClass().getCanonicalName(), HasAndroidInjector.class.getCanonicalName(), HasBroadcastReceiverInjector.class.getCanonicalName()));
        }
        androidInjectorContentProviderInjector.inject(contentProvider);
    }

    private AndroidInjection() {
    }
}
