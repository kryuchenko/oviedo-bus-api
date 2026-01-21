package jj2000.j2k.wavelet.analysis;

/* loaded from: classes5.dex */
public class CBlkWTDataInt extends CBlkWTData {
    public int[] data;

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final int getDataType() {
        return 3;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final Object getData() {
        return this.data;
    }

    public final int[] getDataInt() {
        return this.data;
    }

    @Override // jj2000.j2k.wavelet.analysis.CBlkWTData
    public final void setData(Object obj) {
        this.data = (int[]) obj;
    }

    public final void setDataInt(int[] iArr) {
        this.data = iArr;
    }
}
