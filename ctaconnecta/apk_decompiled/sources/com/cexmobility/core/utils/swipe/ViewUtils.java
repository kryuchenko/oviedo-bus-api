package com.cexmobility.core.utils.swipe;

import android.widget.ScrollView;

/* loaded from: classes.dex */
public class ViewUtils {
    public static boolean isScrollBottomReached(ScrollView scrollView) {
        return scrollView.getChildAt(0).getBottom() <= scrollView.getHeight() + scrollView.getScrollY();
    }
}
