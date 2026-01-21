package com.google.mlkit.vision.text.internal;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_text.zzbh;
import com.google.android.gms.internal.mlkit_vision_text.zzbr;
import com.google.android.gms.internal.mlkit_vision_text.zzbs;
import com.google.android.gms.internal.mlkit_vision_text.zzeg;
import com.google.android.gms.internal.mlkit_vision_text.zzek;
import com.google.android.gms.internal.mlkit_vision_text.zzfy;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class zzb extends MLTask<Text, InputImage> {
    private static boolean zza = true;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private TextRecognizer zzc;
    private final Context zzd;
    private final zzeg zze;

    public zzb(MlKitContext mlKitContext) {
        Preconditions.checkNotNull(mlKitContext, "MlKitContext can not be null");
        this.zzd = mlKitContext.getApplicationContext();
        this.zze = (zzeg) mlKitContext.get(zzeg.class);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public synchronized void load() {
        if (this.zzc == null) {
            this.zzc = new TextRecognizer.Builder(this.zzd).build();
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public synchronized void release() {
        TextRecognizer textRecognizer = this.zzc;
        if (textRecognizer != null) {
            textRecognizer.release();
            this.zzc = null;
        }
        zza = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized Text run(InputImage inputImage) throws MlKitException {
        Frame frameBuild;
        SparseArray<TextBlock> sparseArrayDetect;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        TextRecognizer textRecognizer = this.zzc;
        if (textRecognizer == null) {
            zza(zzbr.UNKNOWN_ERROR, jElapsedRealtime, inputImage);
            throw new MlKitException("Model source is unavailable. Please load the model resource first.", 13);
        }
        if (!textRecognizer.isOperational()) {
            zza(zzbr.MODEL_NOT_DOWNLOADED, jElapsedRealtime, inputImage);
            throw new MlKitException("Waiting for the text recognition model to be downloaded. Please wait.", 14);
        }
        if (inputImage.getFormat() == -1) {
            frameBuild = new Frame.Builder().setBitmap(inputImage.getBitmapInternal()).setRotation(CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())).build();
        } else {
            frameBuild = new Frame.Builder().setBitmap(ImageConvertUtils.getInstance().convertToUpRightBitmap(inputImage)).setRotation(0).build();
        }
        sparseArrayDetect = this.zzc.detect(frameBuild);
        zza(zzbr.NO_ERROR, jElapsedRealtime, inputImage);
        zza = false;
        return new Text(sparseArrayDetect);
    }

    private final void zza(final zzbr zzbrVar, long j, final InputImage inputImage) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zza(new zzeg.zzc(jElapsedRealtime, zzbrVar, inputImage) { // from class: com.google.mlkit.vision.text.internal.zza
            private final long zza;
            private final zzbr zzb;
            private final InputImage zzc;

            {
                this.zza = jElapsedRealtime;
                this.zzb = zzbrVar;
                this.zzc = inputImage;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_text.zzeg.zzc
            public final zzbh.zzad.zza zza() {
                return zzb.zza(this.zza, this.zzb, this.zzc);
            }
        }, zzbs.ON_DEVICE_TEXT_DETECT);
        zzbh.zzi.zzb.zza zzaVarZza = zzbh.zzi.zzb.zza().zza(zzbrVar).zza(zza);
        ImageUtils imageUtils = zzb;
        this.zze.zza((zzbh.zzi.zzb) ((zzfy) zzaVarZza.zza(zzek.zza(imageUtils.getMobileVisionImageFormat(inputImage), imageUtils.getMobileVisionImageSize(inputImage))).zzh()), jElapsedRealtime, zzbs.AGGREGATED_ON_DEVICE_TEXT_DETECTION, zzc.zza);
    }

    static final /* synthetic */ zzbh.zzad.zza zza(long j, zzbr zzbrVar, InputImage inputImage) {
        zzbh.zzbd.zza zzaVarZza = zzbh.zzbd.zza().zza(zzbh.zzaf.zza().zza(j).zza(zzbrVar).zza(zza).zzb(true).zzc(true));
        ImageUtils imageUtils = zzb;
        return zzbh.zzad.zzb().zza((zzbh.zzbd) ((zzfy) zzaVarZza.zza(zzek.zza(imageUtils.getMobileVisionImageFormat(inputImage), imageUtils.getMobileVisionImageSize(inputImage))).zzh()));
    }
}
