package jj2000.j2k.codestream.writer;

import jj2000.j2k.util.ArrayUtil;

/* loaded from: classes5.dex */
public class BitOutputBuffer {
    public static final int SZ_INCR = 16;
    public static final int SZ_INIT = 32;
    int avbits = 8;
    byte[] buf = new byte[32];
    int curbyte;

    public void reset() {
        this.curbyte = 0;
        this.avbits = 8;
        ArrayUtil.byteArraySet(this.buf, (byte) 0);
    }

    public final void writeBit(int i) {
        byte[] bArr = this.buf;
        int i2 = this.curbyte;
        byte b = bArr[i2];
        int i3 = this.avbits - 1;
        this.avbits = i3;
        byte b2 = (byte) ((i << i3) | b);
        bArr[i2] = b2;
        if (i3 > 0) {
            return;
        }
        if (b2 != -1) {
            this.avbits = 8;
        } else {
            this.avbits = 7;
        }
        int i4 = i2 + 1;
        this.curbyte = i4;
        if (i4 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length + 16];
            this.buf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public final void writeBits(int i, int i2) {
        byte[] bArr = this.buf;
        if ((((bArr.length - this.curbyte) << 3) - 8) + this.avbits <= i2 + 2) {
            byte[] bArr2 = new byte[bArr.length + 16];
            this.buf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        int i3 = this.avbits;
        if (i2 >= i3) {
            i2 -= i3;
            byte[] bArr3 = this.buf;
            int i4 = this.curbyte;
            byte b = (byte) (bArr3[i4] | (i >> i2));
            bArr3[i4] = b;
            if (b != -1) {
                this.avbits = 8;
            } else {
                this.avbits = 7;
            }
            this.curbyte = i4 + 1;
            while (true) {
                int i5 = this.avbits;
                if (i2 < i5) {
                    break;
                }
                i2 -= i5;
                byte[] bArr4 = this.buf;
                int i6 = this.curbyte;
                byte b2 = (byte) (((~(1 << i5)) & (i >> i2)) | bArr4[i6]);
                bArr4[i6] = b2;
                if (b2 != -1) {
                    this.avbits = 8;
                } else {
                    this.avbits = 7;
                }
                this.curbyte = i6 + 1;
            }
        }
        if (i2 > 0) {
            int i7 = this.avbits - i2;
            this.avbits = i7;
            byte[] bArr5 = this.buf;
            int i8 = this.curbyte;
            bArr5[i8] = (byte) (((i & ((1 << i2) - 1)) << i7) | bArr5[i8]);
        }
        if (this.avbits == 0) {
            byte[] bArr6 = this.buf;
            int i9 = this.curbyte;
            if (bArr6[i9] != -1) {
                this.avbits = 8;
            } else {
                this.avbits = 7;
            }
            this.curbyte = i9 + 1;
        }
    }

    public final int getLength() {
        if (this.avbits == 8) {
            return this.curbyte;
        }
        return this.curbyte + 1;
    }

    public final byte[] getBuffer() {
        return this.buf;
    }

    public byte[] toByteArray(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[this.avbits == 8 ? this.curbyte : this.curbyte + 1];
        }
        System.arraycopy(this.buf, 0, bArr, 0, this.avbits == 8 ? this.curbyte : this.curbyte + 1);
        return bArr;
    }

    public String toString() {
        return "bits written = " + ((this.curbyte * 8) + (8 - this.avbits)) + ", curbyte = " + this.curbyte + ", avbits = " + this.avbits;
    }
}
