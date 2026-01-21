package jj2000.j2k.util;

/* loaded from: classes5.dex */
public final class NativeServices {
    private static final int LIB_STATE_LOADED = 1;
    private static final int LIB_STATE_NOT_FOUND = 2;
    private static final int LIB_STATE_NOT_LOADED = 0;
    public static final String SHLIB_NAME = "jj2000";
    private static int libState;

    private static native int getThreadConcurrencyN();

    private static native void setThreadConcurrencyN(int i);

    private NativeServices() {
        throw new IllegalArgumentException("Class can not be instantiated");
    }

    public static void setThreadConcurrency(int i) {
        checkLibrary();
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        setThreadConcurrencyN(i);
    }

    public static int getThreadConcurrency() {
        checkLibrary();
        return getThreadConcurrencyN();
    }

    public static boolean loadLibrary() {
        if (libState == 1) {
            return true;
        }
        try {
            System.loadLibrary(SHLIB_NAME);
            libState = 1;
            return true;
        } catch (UnsatisfiedLinkError unused) {
            libState = 2;
            return false;
        }
    }

    private static void checkLibrary() {
        int i = libState;
        if (i != 0) {
            if (i != 2) {
                return;
            }
        } else if (loadLibrary()) {
            return;
        }
        throw new UnsatisfiedLinkError("NativeServices: native shared library could not be loaded");
    }
}
