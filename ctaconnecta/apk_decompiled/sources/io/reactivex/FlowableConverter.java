package io.reactivex;

/* loaded from: classes5.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
