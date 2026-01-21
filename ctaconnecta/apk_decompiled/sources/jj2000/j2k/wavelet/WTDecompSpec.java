package jj2000.j2k.wavelet;

import jj2000.j2k.NotImplementedError;

/* loaded from: classes5.dex */
public class WTDecompSpec {
    public static final byte DEC_SPEC_COMP_DEF = 1;
    public static final byte DEC_SPEC_MAIN_DEF = 0;
    public static final byte DEC_SPEC_TILE_COMP = 3;
    public static final byte DEC_SPEC_TILE_DEF = 2;
    public static final int WT_DECOMP_DYADIC = 0;
    public static final int WT_DECOMP_PACKET = 1;
    public static final int WT_DECOMP_SPACL = 2;
    private int[] compMainDefDecompType;
    private int[] compMainDefLevels;
    private int mainDefDecompType;
    private int mainDefLevels;
    private byte[] specValType;

    public WTDecompSpec(int i, int i2, int i3) {
        this.mainDefDecompType = i2;
        this.mainDefLevels = i3;
        this.specValType = new byte[i];
    }

    public void setMainCompDefDecompType(int i, int i2, int i3) {
        if (i2 < 0 && i3 < 0) {
            throw new IllegalArgumentException();
        }
        byte[] bArr = this.specValType;
        bArr[i] = 1;
        if (this.compMainDefDecompType == null) {
            this.compMainDefDecompType = new int[bArr.length];
            this.compMainDefLevels = new int[bArr.length];
        }
        int[] iArr = this.compMainDefDecompType;
        if (i2 < 0) {
            i2 = this.mainDefDecompType;
        }
        iArr[i] = i2;
        int[] iArr2 = this.compMainDefLevels;
        if (i3 < 0) {
            i3 = this.mainDefLevels;
        }
        iArr2[i] = i3;
        throw new NotImplementedError("Currently, in JJ2000, all components and tiles must have the same decomposition type and number of levels");
    }

    public byte getDecSpecType(int i) {
        return this.specValType[i];
    }

    public int getMainDefDecompType() {
        return this.mainDefDecompType;
    }

    public int getMainDefLevels() {
        return this.mainDefLevels;
    }

    public int getDecompType(int i) {
        byte b = this.specValType[i];
        if (b == 0) {
            return this.mainDefDecompType;
        }
        if (b == 1) {
            return this.compMainDefDecompType[i];
        }
        if (b == 2) {
            throw new NotImplementedError();
        }
        if (b == 3) {
            throw new NotImplementedError();
        }
        throw new Error("Internal JJ2000 error");
    }

    public int getLevels(int i) {
        byte b = this.specValType[i];
        if (b == 0) {
            return this.mainDefLevels;
        }
        if (b == 1) {
            return this.compMainDefLevels[i];
        }
        if (b == 2) {
            throw new NotImplementedError();
        }
        if (b == 3) {
            throw new NotImplementedError();
        }
        throw new Error("Internal JJ2000 error");
    }
}
