package jj2000.j2k;

/* loaded from: classes5.dex */
public class JJ2KExceptionHandler {
    public static void handleException(Throwable th) {
        th.fillInStackTrace();
        th.printStackTrace();
        System.err.println("The Thread is being terminated bacause an Exception (shown above)\nhas been thrown and no special action was defined for this Thread.");
        throw new ThreadDeath();
    }
}
