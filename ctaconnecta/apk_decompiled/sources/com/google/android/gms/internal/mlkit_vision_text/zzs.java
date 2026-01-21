package com.google.android.gms.internal.mlkit_vision_text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzs<K, V> extends zzv<K, V> {
    private transient int zza;

    public static <K, V> zzs<K, V> zzf() {
        return new zzs<>();
    }

    private zzs() {
        this(12, 3);
    }

    private zzs(int i, int i2) {
        super(new zzw(12));
        zzu.zza(3, "expectedValuesPerKey");
        this.zza = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zze
    /* renamed from: zza */
    public final List<V> zzb() {
        return new ArrayList(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt
    public final /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt, com.google.android.gms.internal.mlkit_vision_text.zzax
    public final /* bridge */ /* synthetic */ Map zzg() {
        return super.zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zzh, com.google.android.gms.internal.mlkit_vision_text.zzt, com.google.android.gms.internal.mlkit_vision_text.zzax
    public final /* bridge */ /* synthetic */ boolean zza(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.zza((zzs<K, V>) obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text.zze, com.google.android.gms.internal.mlkit_vision_text.zzap
    public final /* bridge */ /* synthetic */ List zza(@NullableDecl Object obj) {
        return super.zza((zzs<K, V>) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzh
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zze, com.google.android.gms.internal.mlkit_vision_text.zzh
    final /* synthetic */ Collection zzb() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt
    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text.zzt, com.google.android.gms.internal.mlkit_vision_text.zzax
    public final /* bridge */ /* synthetic */ Set zzh() {
        return super.zzh();
    }
}
