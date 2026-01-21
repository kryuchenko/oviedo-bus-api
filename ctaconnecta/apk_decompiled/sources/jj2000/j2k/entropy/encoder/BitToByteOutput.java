package jj2000.j2k.entropy.encoder;

/* loaded from: classes5.dex */
class BitToByteOutput {
    static final int PAD_SEQ = 42;
    int bbuf;
    ByteOutputBuffer out;
    private boolean isPredTerm = false;
    boolean delFF = false;
    int bpos = 7;
    int nb = 0;

    BitToByteOutput(ByteOutputBuffer byteOutputBuffer) {
        this.out = byteOutputBuffer;
    }

    final void writeBits(int[] iArr, int i) {
        int i2;
        int i3 = this.bbuf;
        int i4 = this.bpos;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 - 1;
            i3 |= (iArr[i5] & 1) << i4;
            if (i6 < 0) {
                if (i3 != 255) {
                    if (this.delFF) {
                        this.out.write(255);
                        this.nb++;
                        this.delFF = false;
                    }
                    this.out.write(i3);
                    this.nb++;
                    i2 = 7;
                } else {
                    this.delFF = true;
                    i2 = 6;
                }
                i4 = i2;
                i3 = 0;
            } else {
                i4 = i6;
            }
        }
        this.bbuf = i3;
        this.bpos = i4;
    }

    final void writeBit(int i) {
        int i2 = this.bbuf;
        int i3 = this.bpos;
        int i4 = i3 - 1;
        this.bpos = i4;
        int i5 = ((i & 1) << i3) | i2;
        this.bbuf = i5;
        if (i4 < 0) {
            if (i5 != 255) {
                if (this.delFF) {
                    this.out.write(255);
                    this.nb++;
                    this.delFF = false;
                }
                this.out.write(this.bbuf);
                this.nb++;
                this.bpos = 7;
            } else {
                this.delFF = true;
                this.bpos = 6;
            }
            this.bbuf = 0;
        }
    }

    void flush() {
        if (this.delFF) {
            if (this.bpos != 6) {
                this.out.write(255);
                this.nb++;
                this.delFF = false;
                int i = this.bbuf | (42 >>> (6 - this.bpos));
                this.bbuf = i;
                this.out.write(i);
                this.nb++;
                this.bpos = 7;
                this.bbuf = 0;
                return;
            }
            if (this.isPredTerm) {
                this.out.write(255);
                this.nb++;
                this.out.write(42);
                this.nb++;
                this.bpos = 7;
                this.bbuf = 0;
                this.delFF = false;
                return;
            }
            return;
        }
        int i2 = this.bpos;
        if (i2 != 7) {
            int i3 = (42 >>> (6 - i2)) | this.bbuf;
            this.bbuf = i3;
            this.out.write(i3);
            this.nb++;
            this.bpos = 7;
            this.bbuf = 0;
        }
    }

    public int terminate() {
        flush();
        int i = this.nb;
        reset();
        return i;
    }

    void reset() {
        this.delFF = false;
        this.bpos = 7;
        this.bbuf = 0;
        this.nb = 0;
    }

    int length() {
        if (this.delFF) {
            return this.nb + 2;
        }
        return this.nb + (this.bpos == 7 ? 0 : 1);
    }

    void setPredTerm(boolean z) {
        this.isPredTerm = z;
    }
}
