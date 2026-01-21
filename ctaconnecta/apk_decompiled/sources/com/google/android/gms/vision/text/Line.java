package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public class Line implements Text {
    private zzah zzeg;
    private List<Element> zzeh;

    Line(zzah zzahVar) {
        this.zzeg = zzahVar;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        return this.zzeg.zzek;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        return this.zzeg.zzet;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        return zzc.zza(this.zzeg.zzeq);
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zzeg.zzep.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzeh == null) {
            this.zzeh = new ArrayList(this.zzeg.zzep.length);
            for (zzao zzaoVar : this.zzeg.zzep) {
                this.zzeh.add(new Element(zzaoVar));
            }
        }
        return this.zzeh;
    }

    public float getAngle() {
        return this.zzeg.zzeq.zzeo;
    }

    public boolean isVertical() {
        return this.zzeg.zzev;
    }
}
