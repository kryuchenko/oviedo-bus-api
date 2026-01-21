package jj2000.j2k.entropy.decoder;

/* loaded from: classes5.dex */
public class ByteToBitInput {
    int bbuf;
    int bpos = -1;
    ByteInputBuffer in;

    public ByteToBitInput(ByteInputBuffer byteInputBuffer) {
        this.in = byteInputBuffer;
    }

    public final int readBit() {
        if (this.bpos < 0) {
            if ((this.bbuf & 255) != 255) {
                this.bbuf = this.in.read();
                this.bpos = 7;
            } else {
                this.bbuf = this.in.read();
                this.bpos = 6;
            }
        }
        int i = this.bbuf;
        int i2 = this.bpos;
        this.bpos = i2 - 1;
        return (i >> i2) & 1;
    }

    public boolean checkBytePadding() {
        if (this.bpos < 0 && (this.bbuf & 255) == 255) {
            this.bbuf = this.in.read();
            this.bpos = 6;
        }
        int i = this.bpos;
        if (i >= 0 && (this.bbuf & ((1 << (i + 1)) - 1)) != (85 >> (7 - i))) {
            return true;
        }
        int i2 = this.bbuf;
        if (i2 != -1) {
            return (i2 == 255 && i == 0) ? (this.in.read() & 255) >= 128 : this.in.read() != -1;
        }
        return false;
    }

    final void flush() {
        this.bbuf = 0;
        this.bpos = -1;
    }

    final void setByteArray(byte[] bArr, int i, int i2) {
        this.in.setByteArray(bArr, i, i2);
        this.bbuf = 0;
        this.bpos = -1;
    }
}
