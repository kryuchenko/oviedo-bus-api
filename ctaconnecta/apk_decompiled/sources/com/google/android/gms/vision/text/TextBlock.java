package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
/* loaded from: classes3.dex */
public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzah[] zzei;
    private List<Line> zzej;
    private String zzek;
    private Rect zzel;

    TextBlock(SparseArray<zzah> sparseArray) {
        this.zzei = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zzei;
            if (i >= zzahVarArr.length) {
                return;
            }
            zzahVarArr[i] = sparseArray.valueAt(i);
            i++;
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzek;
        if (str != null) {
            return str;
        }
        HashMap map = new HashMap();
        for (zzah zzahVar : this.zzei) {
            map.put(zzahVar.zzek, Integer.valueOf((map.containsKey(zzahVar.zzek) ? ((Integer) map.get(zzahVar.zzek)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(map.entrySet(), new zza(this))).getKey();
        this.zzek = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzek = "und";
        }
        return this.zzek;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        if (this.zzei.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(this.zzei[0].zzet);
        for (int i = 1; i < this.zzei.length; i++) {
            sb.append("\n");
            sb.append(this.zzei[i].zzet);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        zzah[] zzahVarArr;
        if (this.cornerPoints == null) {
            char c = 0;
            if (this.zzei.length == 0) {
                this.cornerPoints = new Point[0];
            } else {
                int iMax = Integer.MIN_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                int i = 0;
                while (true) {
                    zzahVarArr = this.zzei;
                    if (i >= zzahVarArr.length) {
                        break;
                    }
                    zzab zzabVar = zzahVarArr[i].zzeq;
                    zzab zzabVar2 = this.zzei[c].zzeq;
                    int i2 = -zzabVar2.left;
                    int i3 = -zzabVar2.top;
                    double dSin = Math.sin(Math.toRadians(zzabVar2.zzeo));
                    double dCos = Math.cos(Math.toRadians(zzabVar2.zzeo));
                    Point point = new Point(zzabVar.left, zzabVar.top);
                    point.offset(i2, i3);
                    int i4 = (int) ((pointArr[0].x * dCos) + (pointArr[0].y * dSin));
                    int i5 = (int) (((-pointArr[0].x) * dSin) + (pointArr[0].y * dCos));
                    pointArr[0].x = i4;
                    pointArr[0].y = i5;
                    Point[] pointArr = {point, new Point(zzabVar.width + i4, i5), new Point(zzabVar.width + i4, zzabVar.height + i5), new Point(i4, i5 + zzabVar.height)};
                    iMax2 = iMax2;
                    for (int i6 = 0; i6 < 4; i6++) {
                        Point point2 = pointArr[i6];
                        iMin = Math.min(iMin, point2.x);
                        iMax = Math.max(iMax, point2.x);
                        iMin2 = Math.min(iMin2, point2.y);
                        iMax2 = Math.max(iMax2, point2.y);
                    }
                    i++;
                    c = 0;
                }
                int i7 = iMax2;
                zzab zzabVar3 = zzahVarArr[0].zzeq;
                int i8 = zzabVar3.left;
                int i9 = zzabVar3.top;
                double dSin2 = Math.sin(Math.toRadians(zzabVar3.zzeo));
                double dCos2 = Math.cos(Math.toRadians(zzabVar3.zzeo));
                Point point3 = new Point(iMin, iMin2);
                Point point4 = new Point(iMax, iMin2);
                Point point5 = new Point(iMax, i7);
                Point point6 = new Point(iMin, i7);
                Point[] pointArr2 = {point3, point4, point5, point6};
                int i10 = 0;
                for (int i11 = 4; i10 < i11; i11 = 4) {
                    pointArr2[i10].x = (int) ((pointArr2[i10].x * dCos2) - (pointArr2[i10].y * dSin2));
                    pointArr2[i10].y = (int) ((pointArr2[i10].x * dSin2) + (pointArr2[i10].y * dCos2));
                    pointArr2[i10].offset(i8, i9);
                    i10++;
                }
                this.cornerPoints = pointArr2;
            }
        }
        return this.cornerPoints;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zzei.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzej == null) {
            this.zzej = new ArrayList(this.zzei.length);
            for (zzah zzahVar : this.zzei) {
                this.zzej.add(new Line(zzahVar));
            }
        }
        return this.zzej;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zzel == null) {
            this.zzel = zzc.zza(this);
        }
        return this.zzel;
    }
}
