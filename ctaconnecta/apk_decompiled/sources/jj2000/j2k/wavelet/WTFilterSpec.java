package jj2000.j2k.wavelet;

/* loaded from: classes5.dex */
public abstract class WTFilterSpec {
    public static final byte FILTER_SPEC_COMP_DEF = 1;
    public static final byte FILTER_SPEC_MAIN_DEF = 0;
    public static final byte FILTER_SPEC_TILE_COMP = 3;
    public static final byte FILTER_SPEC_TILE_DEF = 2;
    protected byte[] specValType;

    public abstract int getWTDataType();

    protected WTFilterSpec(int i) {
        this.specValType = new byte[i];
    }

    public byte getKerSpecType(int i) {
        return this.specValType[i];
    }
}
