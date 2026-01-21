package io.reactivex;

/* loaded from: classes5.dex */
public interface MaybeConverter<T, R> {
    R apply(Maybe<T> maybe);
}
