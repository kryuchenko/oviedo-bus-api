package com.iecisa.ctausuario.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SchedulerProviderImpl implements SchedulerProvider {
    @Inject
    public SchedulerProviderImpl() {
    }

    @Override // com.iecisa.ctausuario.utils.rx.SchedulerProvider
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override // com.iecisa.ctausuario.utils.rx.SchedulerProvider
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override // com.iecisa.ctausuario.utils.rx.SchedulerProvider
    public Scheduler io() {
        return Schedulers.io();
    }
}
