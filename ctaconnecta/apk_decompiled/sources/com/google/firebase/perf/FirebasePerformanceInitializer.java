package com.google.firebase.perf;

import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes4.dex */
public final class FirebasePerformanceInitializer implements AppStateMonitor.AppColdStartCallback {
    private static final AndroidLogger logger = AndroidLogger.getInstance();

    @Override // com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback
    public void onAppColdStart() {
        try {
            FirebasePerformance.getInstance();
        } catch (IllegalStateException e) {
            logger.warn("FirebaseApp is not initialized. Firebase Performance will not be collecting any performance metrics until initialized. %s", e);
        }
    }
}
