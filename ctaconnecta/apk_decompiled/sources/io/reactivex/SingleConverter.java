package io.reactivex;

/* loaded from: classes5.dex */
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
