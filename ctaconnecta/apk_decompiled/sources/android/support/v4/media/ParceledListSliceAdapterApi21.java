package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes.dex */
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        try {
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e = e;
        }
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (NoSuchMethodException e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    static Object newInstance(List<MediaBrowser.MediaItem> list) {
        try {
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e = e;
        }
        try {
            return sConstructor.newInstance(list);
        } catch (IllegalAccessException e2) {
            e = e2;
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e = e3;
            e.printStackTrace();
            return null;
        }
    }

    private ParceledListSliceAdapterApi21() {
    }
}
