package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Tracker<T> zzas;
    private int zzav;
    private Detector<T> zzx;
    private int zzat = 3;
    private boolean zzau = false;
    private int zzaw = 0;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzx = detector;
        this.zzas = tracker;
    }

    public abstract int selectFocus(Detector.Detections<T> detections);

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        this.zzas.onDone();
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzaw == this.zzat) {
                this.zzas.onDone();
                this.zzau = false;
            } else {
                this.zzas.onMissing(detections);
            }
            this.zzaw++;
            return;
        }
        this.zzaw = 0;
        if (this.zzau) {
            T t = detectedItems.get(this.zzav);
            if (t != null) {
                this.zzas.onUpdate(detections, t);
                return;
            } else {
                this.zzas.onDone();
                this.zzau = false;
            }
        }
        int iSelectFocus = selectFocus(detections);
        T t2 = detectedItems.get(iSelectFocus);
        if (t2 == null) {
            StringBuilder sb = new StringBuilder(35);
            sb.append("Invalid focus selected: ");
            sb.append(iSelectFocus);
            Log.w("FocusingProcessor", sb.toString());
            return;
        }
        this.zzau = true;
        this.zzav = iSelectFocus;
        this.zzx.setFocus(iSelectFocus);
        this.zzas.onNewItem(this.zzav, t2);
        this.zzas.onUpdate(detections, t2);
    }

    protected final void zza(int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid max gap: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.zzat = i;
    }
}
