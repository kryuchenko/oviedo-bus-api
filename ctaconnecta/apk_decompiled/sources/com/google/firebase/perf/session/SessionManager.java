package com.google.firebase.perf.session;

import android.content.Context;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class SessionManager extends AppStateUpdateHandler {
    private static final SessionManager instance = new SessionManager();
    private final AppStateMonitor appStateMonitor;
    private final Set<WeakReference<SessionAwareObject>> clients;
    private final GaugeManager gaugeManager;
    private PerfSession perfSession;
    private Future syncInitFuture;

    public static SessionManager getInstance() {
        return instance;
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    private SessionManager() {
        this(GaugeManager.getInstance(), PerfSession.createWithId(UUID.randomUUID().toString()), AppStateMonitor.getInstance());
    }

    public SessionManager(GaugeManager gaugeManager, PerfSession perfSession, AppStateMonitor appStateMonitor) {
        this.clients = new HashSet();
        this.gaugeManager = gaugeManager;
        this.perfSession = perfSession;
        this.appStateMonitor = appStateMonitor;
        registerForAppState();
    }

    public void setApplicationContext(final Context context) {
        final PerfSession perfSession = this.perfSession;
        this.syncInitFuture = Executors.newSingleThreadExecutor().submit(new Runnable() { // from class: com.google.firebase.perf.session.SessionManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m652xa16819e0(context, perfSession);
            }
        });
    }

    /* renamed from: lambda$setApplicationContext$0$com-google-firebase-perf-session-SessionManager, reason: not valid java name */
    /* synthetic */ void m652xa16819e0(Context context, PerfSession perfSession) {
        this.gaugeManager.initializeGaugeMetadataManager(context);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(perfSession.sessionId(), ApplicationProcessState.FOREGROUND);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler, com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        if (this.appStateMonitor.isColdStart()) {
            return;
        }
        if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
            updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
        } else if (this.perfSession.isSessionRunningTooLong()) {
            updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
        } else {
            startOrStopCollectingGauges(applicationProcessState);
        }
    }

    public void stopGaugeCollectionIfSessionRunningTooLong() {
        if (this.perfSession.isSessionRunningTooLong()) {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    public void updatePerfSession(PerfSession perfSession) {
        if (perfSession.sessionId() == this.perfSession.sessionId()) {
            return;
        }
        this.perfSession = perfSession;
        synchronized (this.clients) {
            Iterator<WeakReference<SessionAwareObject>> it = this.clients.iterator();
            while (it.hasNext()) {
                SessionAwareObject sessionAwareObject = it.next().get();
                if (sessionAwareObject != null) {
                    sessionAwareObject.updateSession(perfSession);
                } else {
                    it.remove();
                }
            }
        }
        logGaugeMetadataIfCollectionEnabled(this.appStateMonitor.getAppState());
        startOrStopCollectingGauges(this.appStateMonitor.getAppState());
    }

    public void initializeGaugeCollection() {
        logGaugeMetadataIfCollectionEnabled(ApplicationProcessState.FOREGROUND);
        startOrStopCollectingGauges(ApplicationProcessState.FOREGROUND);
    }

    public void registerForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.add(weakReference);
        }
    }

    public void unregisterForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.remove(weakReference);
        }
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(this.perfSession.sessionId(), applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.startCollectingGauges(this.perfSession, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    public void setPerfSession(PerfSession perfSession) {
        this.perfSession = perfSession;
    }

    public Future getSyncInitFuture() {
        return this.syncInitFuture;
    }
}
