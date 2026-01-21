package com.iecisa.ctausuario.utils.rx;

import io.reactivex.Scheduler;

/* loaded from: classes5.dex */
public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
