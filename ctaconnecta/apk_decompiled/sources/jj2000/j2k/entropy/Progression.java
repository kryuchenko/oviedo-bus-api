package jj2000.j2k.entropy;

import jj2000.j2k.codestream.ProgressionType;

/* loaded from: classes5.dex */
public class Progression implements ProgressionType {
    public int ce;
    public int cs;
    public int lye;
    public int re;
    public int rs;
    public int type;

    public Progression(int i, int i2, int i3, int i4, int i5, int i6) {
        this.type = i;
        this.cs = i2;
        this.ce = i3;
        this.rs = i4;
        this.re = i5;
        this.lye = i6;
    }

    public String toString() {
        String str;
        int i = this.type;
        if (i == 0) {
            str = "type= layer, ";
        } else if (i == 1) {
            str = "type= res, ";
        } else if (i != 2) {
            str = "type= pos-comp, ";
            if (i != 3 && i != 4) {
                throw new Error("Unknown progression type");
            }
        } else {
            str = "type= res-pos, ";
        }
        return ((str + "comp.: " + this.cs + "-" + this.ce + ", ") + "res.: " + this.rs + "-" + this.re + ", ") + "layer: up to " + this.lye;
    }
}
