package com.jakewharton.retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* loaded from: classes5.dex */
final class RxJava2CallAdapter implements CallAdapter<Object> {
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    RxJava2CallAdapter(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.responseType = type;
        this.scheduler = scheduler;
        this.isResult = z;
        this.isBody = z2;
        this.isFlowable = z3;
        this.isSingle = z4;
        this.isMaybe = z5;
        this.isCompletable = z6;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object adapt(Call<R> call) {
        Observable bodyObservable;
        Scheduler scheduler;
        Observable callObservable = new CallObservable(call);
        if (this.isResult) {
            bodyObservable = new ResultObservable(callObservable);
        } else {
            if (this.isBody) {
                bodyObservable = new BodyObservable(callObservable);
            }
            scheduler = this.scheduler;
            if (scheduler != null) {
                callObservable = callObservable.subscribeOn(scheduler);
            }
            if (!this.isFlowable) {
                return callObservable.toFlowable(BackpressureStrategy.LATEST);
            }
            if (this.isSingle) {
                return callObservable.singleOrError();
            }
            if (this.isMaybe) {
                return callObservable.singleElement();
            }
            return this.isCompletable ? callObservable.ignoreElements() : callObservable;
        }
        callObservable = bodyObservable;
        scheduler = this.scheduler;
        if (scheduler != null) {
        }
        if (!this.isFlowable) {
        }
    }
}
