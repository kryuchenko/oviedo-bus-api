package com.cexmobility.core.widgets.dialog;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class DisplayUtil {
    public static int dp2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Point getScreenSize(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }
}
