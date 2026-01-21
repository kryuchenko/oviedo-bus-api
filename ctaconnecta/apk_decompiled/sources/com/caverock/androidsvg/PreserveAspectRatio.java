package com.caverock.androidsvg;

/* loaded from: classes.dex */
public class PreserveAspectRatio {
    private Alignment alignment;
    private Scale scale;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio LETTERBOX = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio START = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio END = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio TOP = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio BOTTOM = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio FULLSCREEN = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio FULLSCREEN_START = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);

    public enum Alignment {
        None,
        XMinYMin,
        XMidYMin,
        XMaxYMin,
        XMinYMid,
        XMidYMid,
        XMaxYMid,
        XMinYMax,
        XMidYMax,
        XMaxYMax;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Alignment[] valuesCustom() {
            Alignment[] alignmentArrValuesCustom = values();
            int length = alignmentArrValuesCustom.length;
            Alignment[] alignmentArr = new Alignment[length];
            System.arraycopy(alignmentArrValuesCustom, 0, alignmentArr, 0, length);
            return alignmentArr;
        }
    }

    public enum Scale {
        Meet,
        Slice;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Scale[] valuesCustom() {
            Scale[] scaleArrValuesCustom = values();
            int length = scaleArrValuesCustom.length;
            Scale[] scaleArr = new Scale[length];
            System.arraycopy(scaleArrValuesCustom, 0, scaleArr, 0, length);
            return scaleArr;
        }
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.alignment = alignment;
        this.scale = scale;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Scale getScale() {
        return this.scale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale;
    }
}
