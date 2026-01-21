package retrofit2;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes6.dex */
public final /* synthetic */ class Platform$$ExternalSyntheticApiModelOutline0 {
    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m2723m() {
        return CompletableFuture.class;
    }

    public static /* bridge */ /* synthetic */ MethodHandles.Lookup m(Object obj) {
        return (MethodHandles.Lookup) obj;
    }

    public static /* synthetic */ StringJoiner m(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CompletableFuture m2728m() {
        return new CompletableFuture();
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CompletionException m2729m(Object obj) {
        return (CompletionException) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BiFunction m2730m(Object obj) {
        return (BiFunction) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m2733m(Object obj) {
        return obj instanceof CompletionException;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return Optional.class;
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return MethodHandles.Lookup.class;
    }
}
