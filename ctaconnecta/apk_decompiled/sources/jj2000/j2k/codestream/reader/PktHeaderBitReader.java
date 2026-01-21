package jj2000.j2k.codestream.reader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import jj2000.j2k.io.RandomAccessIO;

/* loaded from: classes5.dex */
class PktHeaderBitReader {
    ByteArrayInputStream bais;
    int bbuf;
    int bpos;
    RandomAccessIO in;
    int nextbbuf;
    boolean usebais = true;

    PktHeaderBitReader(RandomAccessIO randomAccessIO) {
        this.in = randomAccessIO;
    }

    PktHeaderBitReader(ByteArrayInputStream byteArrayInputStream) {
        this.bais = byteArrayInputStream;
    }

    final int readBit() throws IOException {
        if (this.bpos == 0) {
            if (this.bbuf != 255) {
                if (this.usebais) {
                    this.bbuf = this.bais.read();
                } else {
                    this.bbuf = this.in.read();
                }
                this.bpos = 8;
                if (this.bbuf == 255) {
                    if (this.usebais) {
                        this.nextbbuf = this.bais.read();
                    } else {
                        this.nextbbuf = this.in.read();
                    }
                }
            } else {
                this.bbuf = this.nextbbuf;
                this.bpos = 7;
            }
        }
        int i = this.bbuf;
        int i2 = this.bpos - 1;
        this.bpos = i2;
        return (i >> i2) & 1;
    }

    final int readBits(int i) throws IOException {
        int i2;
        int i3 = this.bpos;
        if (i <= i3) {
            int i4 = this.bbuf;
            int i5 = i3 - i;
            this.bpos = i5;
            return ((1 << i) - 1) & (i4 >> i5);
        }
        int bits = 0;
        do {
            int i6 = this.bpos;
            i -= i6;
            bits = (bits << i6) | readBits(i6);
            if (this.bbuf != 255) {
                if (this.usebais) {
                    this.bbuf = this.bais.read();
                } else {
                    this.bbuf = this.in.read();
                }
                this.bpos = 8;
                if (this.bbuf == 255) {
                    if (this.usebais) {
                        this.nextbbuf = this.bais.read();
                    } else {
                        this.nextbbuf = this.in.read();
                    }
                }
            } else {
                this.bbuf = this.nextbbuf;
                this.bpos = 7;
            }
            i2 = this.bpos;
        } while (i > i2);
        int i7 = bits << i;
        int i8 = this.bbuf;
        int i9 = i2 - i;
        this.bpos = i9;
        return (((1 << i) - 1) & (i8 >> i9)) | i7;
    }

    void sync() {
        this.bbuf = 0;
        this.bpos = 0;
    }

    void setInput(RandomAccessIO randomAccessIO) {
        this.in = randomAccessIO;
        this.bbuf = 0;
        this.bpos = 0;
    }

    void setInput(ByteArrayInputStream byteArrayInputStream) {
        this.bais = byteArrayInputStream;
        this.bbuf = 0;
        this.bpos = 0;
    }
}
