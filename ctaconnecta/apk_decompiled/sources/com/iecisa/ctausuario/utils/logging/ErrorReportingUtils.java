package com.iecisa.ctausuario.utils.logging;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class ErrorReportingUtils {
    public static void sendErrorToFirebase(String key, Map<String, String> values) throws NonFatalException {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        try {
            throw new NonFatalException(key);
        } catch (NonFatalException e) {
            Timber.w(e);
            for (Map.Entry<String, String> entry : values.entrySet()) {
                firebaseCrashlytics.setCustomKey(entry.getKey(), entry.getValue());
            }
            firebaseCrashlytics.recordException(e);
        }
    }
}
