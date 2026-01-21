package androidx.tracing;

import android.app.NotificationChannel;
import android.graphics.ImageDecoder;
import android.security.keystore.KeyGenParameterSpec;
import android.view.DisplayCutout;
import android.view.inspector.InspectionCompanion;
import dalvik.system.DelegateLastClassLoader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Trace$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* bridge */ /* synthetic */ ImageDecoder.Source m(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* synthetic */ KeyGenParameterSpec.Builder m(String str, int i) {
        return new KeyGenParameterSpec.Builder(str, i);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DisplayCutout m394m(Object obj) {
        return (DisplayCutout) obj;
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException m397m() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m398m() {
        return Consumer.class;
    }

    public static /* synthetic */ PriorityQueue m(Comparator comparator) {
        return new PriorityQueue(comparator);
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m402m() {
    }

    /* renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m407m(Object obj) {
        return obj instanceof DisplayCutout;
    }

    /* renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m409m$1() {
    }
}
