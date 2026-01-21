package com.iecisa.ctausuario.utils.rx;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class SchedulerProviderImpl_Factory implements Factory<SchedulerProviderImpl> {
    @Override // javax.inject.Provider
    public SchedulerProviderImpl get() {
        return newInstance();
    }

    public static SchedulerProviderImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SchedulerProviderImpl newInstance() {
        return new SchedulerProviderImpl();
    }

    private static final class InstanceHolder {
        private static final SchedulerProviderImpl_Factory INSTANCE = new SchedulerProviderImpl_Factory();

        private InstanceHolder() {
        }
    }
}
