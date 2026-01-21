package org.jnbis;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class Bitmap implements Serializable {
    private final int depth;
    private final int height;
    private final int length;
    private final int lossyFlag;
    private final byte[] pixels;
    private final int ppi;
    private final int width;

    public Bitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        this.pixels = bArr;
        this.width = i;
        this.height = i2;
        this.ppi = i3;
        this.depth = i4;
        this.lossyFlag = i5;
        this.length = bArr != null ? bArr.length : 0;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPpi() {
        return this.ppi;
    }

    public byte[] getPixels() {
        return this.pixels;
    }

    public int getLength() {
        return this.length;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getLossyFlag() {
        return this.lossyFlag;
    }
}
