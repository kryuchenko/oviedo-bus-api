package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text.zzbh;
import com.google.android.gms.internal.mlkit_vision_text.zzbs;
import com.google.android.gms.internal.mlkit_vision_text.zzeg;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizer;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class TextRecognizerImpl extends MobileVisionBase<Text> implements TextRecognizer {
    public static TextRecognizerImpl zzb() {
        return new TextRecognizerImpl(MlKitContext.getInstance());
    }

    private TextRecognizerImpl(MlKitContext mlKitContext) {
        this(mlKitContext, (zzb) mlKitContext.get(zzb.class));
    }

    private TextRecognizerImpl(MlKitContext mlKitContext, zzb zzbVar) {
        super(zzbVar, MLTaskExecutor.workerThreadExecutor());
        ((zzeg) mlKitContext.get(zzeg.class)).zza(zzbh.zzad.zzb().zza(zzbh.zzbd.zzb()), zzbs.ON_DEVICE_TEXT_CREATE);
    }

    @Override // com.google.mlkit.vision.text.TextRecognizer
    public Task<Text> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
