package com.cexmobility.core.utils;

/* loaded from: classes.dex */
public class TimeUtils {
    public static String formatMinutesToString(long totalMinutes, String separator) {
        String str;
        if (totalMinutes > 60) {
            int i = (int) totalMinutes;
            int i2 = i / 60;
            int i3 = i - (i2 * 60);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(" h");
            if (i3 > 0) {
                str = separator + i3 + " min";
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }
        return totalMinutes + " min";
    }
}
