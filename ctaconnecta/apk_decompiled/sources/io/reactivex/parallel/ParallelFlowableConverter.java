package io.reactivex.parallel;

/* loaded from: classes5.dex */
public interface ParallelFlowableConverter<T, R> {
    R apply(ParallelFlowable<T> parallelFlowable);
}
