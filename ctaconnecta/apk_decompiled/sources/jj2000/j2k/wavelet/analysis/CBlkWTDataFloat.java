package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public class CBlkWTDataFloat extends CBlkWTData {
    public float[] data;

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final int getDataType() {
        return 4;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final Object getData() {
        return this.data;
    }

    public final float[] getDataFloat() {
        return this.data;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final void setData(Object obj) {
        this.data = (float[]) obj;
    }

    public final void setDataFloat(float[] fArr) {
        this.data = fArr;
    }
}
