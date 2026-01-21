package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzlb implements zzkz {
    private static final zzbj<Long> zzahg;
    private static final zzbj<Boolean> zzahh;
    private static final zzbj<Boolean> zzahi;
    private static final zzbj<Boolean> zzahj;
    private static final zzbj<Boolean> zzahk;
    private static final zzbj<Boolean> zzahl;
    private static final zzbj<Boolean> zzahm;
    private static final zzbj<Boolean> zzahn;
    private static final zzbj<Boolean> zzaho;
    private static final zzbj<Boolean> zzahp;
    private static final zzbj<Boolean> zzahq;
    private static final zzbj<Boolean> zzahr;
    private static final zzbj<Long> zzahs;
    private static final zzbj<Long> zzaht;

    @Override // com.google.android.gms.internal.vision.zzkz
    public final boolean zzjq() {
        return zzahi.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.vision.zzkz
    public final boolean zzjr() {
        return zzahm.get().booleanValue();
    }

    static {
        zzbp zzbpVarZzf = new zzbp(zzbg.getContentProviderUri("com.google.android.gms.vision.sdk")).zzf("vision.sdk:");
        zzahg = zzbpVarZzf.zza("OptionalModule__check_alarm_seconds", 10L);
        zzahh = zzbpVarZzf.zza("OptionalModule__enable_barcode_optional_module", false);
        zzahi = zzbpVarZzf.zza("OptionalModule__enable_barcode_optional_module_v25", false);
        zzahj = zzbpVarZzf.zza("OptionalModule__enable_face_optional_module", false);
        zzahk = zzbpVarZzf.zza("OptionalModule__enable_face_optional_module_v25", true);
        zzahl = zzbpVarZzf.zza("OptionalModule__enable_ica_optional_module", false);
        zzahm = zzbpVarZzf.zza("OptionalModule__enable_ica_optional_module_v25", false);
        zzahn = zzbpVarZzf.zza("OptionalModule__enable_ocr_optional_module", false);
        zzaho = zzbpVarZzf.zza("OptionalModule__enable_ocr_optional_module_v25", false);
        zzahp = zzbpVarZzf.zza("OptionalModule__enable_old_download_path", true);
        zzahq = zzbpVarZzf.zza("OptionalModule__enable_optional_module_download_retry", false);
        zzahr = zzbpVarZzf.zza("OptionalModule__enable_progress_listener_for_optional_module_download", false);
        zzahs = zzbpVarZzf.zza("OptionalModule__listener_timeout_in_minutes", 5L);
        zzaht = zzbpVarZzf.zza("OptionalModule__max_download_status_pending_count", 5L);
    }
}
