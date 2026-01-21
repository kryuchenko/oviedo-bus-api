package org.spongycastle.crypto.tls;

/* loaded from: classes6.dex */
public class AlertLevel {
    public static final short fatal = 2;
    public static final short warning = 1;

    public static String getName(short s) {
        if (s == 1) {
            return "warning";
        }
        if (s == 2) {
            return "fatal";
        }
        return "UNKNOWN";
    }

    public static String getText(short s) {
        return getName(s) + "(" + ((int) s) + ")";
    }
}
