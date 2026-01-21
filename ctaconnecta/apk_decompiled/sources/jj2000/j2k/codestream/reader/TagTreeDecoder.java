package jj2000.j2k.codestream.reader;

import java.io.IOException;
import jj2000.j2k.util.ArrayUtil;

/* loaded from: classes5.dex */
public class TagTreeDecoder {
    protected int h;
    protected int lvls;
    protected int[][] treeS;
    protected int[][] treeV;
    protected int w;

    public TagTreeDecoder(int i, int i2) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException();
        }
        this.w = i2;
        this.h = i;
        if (i2 == 0 || i == 0) {
            this.lvls = 0;
        } else {
            this.lvls = 1;
            while (true) {
                if (i == 1 && i2 == 1) {
                    break;
                }
                i2 = (i2 + 1) >> 1;
                i = (i + 1) >> 1;
                this.lvls++;
            }
        }
        int i3 = this.lvls;
        this.treeV = new int[i3][];
        this.treeS = new int[i3][];
        int i4 = this.w;
        int i5 = this.h;
        for (int i6 = 0; i6 < this.lvls; i6++) {
            int i7 = i5 * i4;
            int[] iArr = new int[i7];
            this.treeV[i6] = iArr;
            ArrayUtil.intArraySet(iArr, Integer.MAX_VALUE);
            this.treeS[i6] = new int[i7];
            i4 = (i4 + 1) >> 1;
            i5 = (i5 + 1) >> 1;
        }
    }

    public final int getWidth() {
        return this.w;
    }

    public final int getHeight() {
        return this.h;
    }

    public int update(int i, int i2, int i3, PktHeaderBitReader pktHeaderBitReader) throws IOException {
        int i4;
        if (i >= this.h || i2 >= (i4 = this.w) || i3 < 0) {
            throw new IllegalArgumentException();
        }
        int i5 = this.lvls - 1;
        int i6 = this.treeS[i5][0];
        int i7 = (i >> i5) * (((i4 + (1 << i5)) - 1) >> i5);
        int i8 = i2 >> i5;
        while (true) {
            int i9 = i7 + i8;
            int i10 = this.treeS[i5][i9];
            int i11 = this.treeV[i5][i9];
            if (i10 >= i6) {
                i6 = i10;
            }
            while (true) {
                if (i3 > i6) {
                    if (i11 < i6) {
                        i6 = i3;
                        break;
                    }
                    if (pktHeaderBitReader.readBit() == 0) {
                        i6++;
                    } else {
                        i11 = i6;
                        i6++;
                    }
                } else {
                    break;
                }
            }
            this.treeS[i5][i9] = i6;
            this.treeV[i5][i9] = i11;
            if (i5 <= 0) {
                return i11;
            }
            if (i6 >= i11) {
                i6 = i11;
            }
            i5--;
            i8 = (i >> i5) * (((this.w + (1 << i5)) - 1) >> i5);
            i7 = i2 >> i5;
        }
    }

    public int getValue(int i, int i2) {
        int i3;
        if (i >= this.h || i2 >= (i3 = this.w)) {
            throw new IllegalArgumentException();
        }
        return this.treeV[0][(i * i3) + i2];
    }
}
