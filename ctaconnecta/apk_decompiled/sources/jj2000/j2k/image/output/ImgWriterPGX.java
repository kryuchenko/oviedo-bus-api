package jj2000.j2k.image.output;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class ImgWriterPGX extends ImgWriter {
    private int bitDepth;
    private byte[] buf;
    private int c;
    private DataBlkInt db;
    private int fb;
    boolean isSigned;
    int levShift;
    int maxVal;
    int minVal;
    private int offset;
    private RandomAccessFile out;
    private int packBytes;

    public ImgWriterPGX(File file, BlkImgDataSrc blkImgDataSrc, int i, boolean z) throws IOException {
        this.db = new DataBlkInt();
        this.c = i;
        if (file.exists() && !file.delete()) {
            throw new IOException("Could not reset file");
        }
        this.out = new RandomAccessFile(file, "rw");
        this.isSigned = z;
        this.src = blkImgDataSrc;
        this.w = this.src.getImgWidth();
        this.h = this.src.getImgHeight();
        this.fb = blkImgDataSrc.getFixedPoint(i);
        int nomRangeBits = this.src.getNomRangeBits(this.c);
        this.bitDepth = nomRangeBits;
        if (nomRangeBits <= 0 || nomRangeBits > 31) {
            throw new IOException("PGX supports only bit-depth between 1 and 31");
        }
        if (nomRangeBits <= 8) {
            this.packBytes = 1;
        } else if (nomRangeBits <= 16) {
            this.packBytes = 2;
        } else {
            this.packBytes = 4;
        }
        StringBuilder sb = new StringBuilder("PG ML ");
        sb.append(this.isSigned ? "- " : "+ ");
        sb.append(this.bitDepth);
        sb.append(" ");
        sb.append(this.w);
        sb.append(" ");
        sb.append(this.h);
        sb.append("\n");
        byte[] bytes = sb.toString().getBytes();
        for (byte b : bytes) {
            this.out.write(b);
        }
        this.offset = bytes.length;
        this.maxVal = (1 << (this.isSigned ? this.src.getNomRangeBits(i) - 1 : this.src.getNomRangeBits(i))) - 1;
        this.minVal = this.isSigned ? (1 << (this.src.getNomRangeBits(i) - 1)) * (-1) : 0;
        this.levShift = this.isSigned ? 0 : 1 << (this.src.getNomRangeBits(i) - 1);
    }

    public ImgWriterPGX(String str, BlkImgDataSrc blkImgDataSrc, int i, boolean z) throws IOException {
        this(new File(str), blkImgDataSrc, i, z);
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void close() throws IOException {
        if (this.out.length() != (this.w * this.h * this.packBytes) + this.offset) {
            RandomAccessFile randomAccessFile = this.out;
            randomAccessFile.seek(randomAccessFile.length());
            for (int length = (this.offset + ((this.w * this.h) * this.packBytes)) - ((int) this.out.length()); length > 0; length--) {
                this.out.writeByte(0);
            }
        }
        this.out.close();
        this.src = null;
        this.out = null;
        this.db = null;
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void flush() throws IOException {
        this.buf = null;
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void write(int i, int i2, int i3, int i4) throws IOException {
        DataBlkInt dataBlkInt;
        int i5 = this.fb;
        this.db.ulx = i;
        this.db.uly = i2;
        this.db.w = i3;
        this.db.h = i4;
        int compULX = this.src.getCompULX(this.c) - ((int) Math.ceil(this.src.getImgULX() / this.src.getCompSubsX(this.c)));
        int compULY = this.src.getCompULY(this.c) - ((int) Math.ceil(this.src.getImgULY() / this.src.getCompSubsY(this.c)));
        if (this.db.data != null && this.db.data.length < i3 * i4) {
            this.db.data = null;
        }
        do {
            dataBlkInt = (DataBlkInt) this.src.getInternCompData(this.db, this.c);
            this.db = dataBlkInt;
        } while (dataBlkInt.progressive);
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < this.packBytes * i3) {
            this.buf = new byte[this.packBytes * i3];
        }
        int i6 = this.packBytes;
        int i7 = 1;
        if (i6 == 1) {
            for (int i8 = 0; i8 < i4; i8++) {
                this.out.seek(this.offset + (this.w * (i2 + compULY + i8)) + i + compULX);
                if (i5 == 0) {
                    int i9 = ((this.db.offset + (this.db.scanw * i8)) + i3) - 1;
                    int i10 = i3 - 1;
                    while (i10 >= 0) {
                        int i11 = this.db.data[i9] + this.levShift;
                        byte[] bArr2 = this.buf;
                        int i12 = i10 - 1;
                        int i13 = this.minVal;
                        if (i11 < i13 || i11 > (i13 = this.maxVal)) {
                            i11 = i13;
                        }
                        bArr2[i10] = (byte) i11;
                        i9--;
                        i10 = i12;
                    }
                } else {
                    int i14 = ((this.db.offset + (this.db.scanw * i8)) + i3) - 1;
                    int i15 = i3 - 1;
                    while (i15 >= 0) {
                        int i16 = (this.db.data[i14] >>> i5) + this.levShift;
                        byte[] bArr3 = this.buf;
                        int i17 = i15 - 1;
                        int i18 = this.minVal;
                        if (i16 < i18 || i16 > (i18 = this.maxVal)) {
                            i16 = i18;
                        }
                        bArr3[i15] = (byte) i16;
                        i14--;
                        i15 = i17;
                    }
                }
                this.out.write(this.buf, 0, i3);
            }
            return;
        }
        if (i6 == 2) {
            for (int i19 = 0; i19 < i4; i19++) {
                this.out.seek(this.offset + (((this.w * (i2 + compULY + i19)) + i + compULX) * 2));
                if (i5 == 0) {
                    int i20 = ((this.db.offset + (this.db.scanw * i19)) + i3) - 1;
                    int i21 = (i3 << 1) - 1;
                    while (i21 >= 0) {
                        int i22 = this.db.data[i20] + this.levShift;
                        int i23 = this.minVal;
                        if (i22 < i23 || i22 > (i23 = this.maxVal)) {
                            i22 = i23;
                        }
                        byte[] bArr4 = this.buf;
                        int i24 = i21 - 1;
                        bArr4[i21] = (byte) i22;
                        i21 -= 2;
                        bArr4[i24] = (byte) (i22 >>> 8);
                        i20--;
                    }
                } else {
                    int i25 = ((this.db.offset + (this.db.scanw * i19)) + i3) - 1;
                    int i26 = (i3 << 1) - 1;
                    while (i26 >= 0) {
                        int i27 = (this.db.data[i25] >>> i5) + this.levShift;
                        int i28 = this.minVal;
                        if (i27 < i28 || i27 > (i28 = this.maxVal)) {
                            i27 = i28;
                        }
                        byte[] bArr5 = this.buf;
                        int i29 = i26 - 1;
                        bArr5[i26] = (byte) i27;
                        i26 -= 2;
                        bArr5[i29] = (byte) (i27 >>> 8);
                        i25--;
                    }
                }
                this.out.write(this.buf, 0, i3 << 1);
            }
            return;
        }
        if (i6 != 4) {
            throw new IOException("PGX supports only bit-depth between 1 and 31");
        }
        int i30 = 0;
        while (i30 < i4) {
            this.out.seek(this.offset + (((this.w * (i2 + compULY + i30)) + i + compULX) * 4));
            if (i5 == 0) {
                int i31 = ((this.db.offset + (this.db.scanw * i30)) + i3) - i7;
                int i32 = (i3 << 2) - i7;
                while (i32 >= 0) {
                    int i33 = this.db.data[i31] + this.levShift;
                    int i34 = this.minVal;
                    if (i33 < i34 || i33 > (i34 = this.maxVal)) {
                        i33 = i34;
                    }
                    byte[] bArr6 = this.buf;
                    bArr6[i32] = (byte) i33;
                    bArr6[i32 - 1] = (byte) (i33 >>> 8);
                    int i35 = i32 - 3;
                    bArr6[i32 - 2] = (byte) (i33 >>> 16);
                    i32 -= 4;
                    bArr6[i35] = (byte) (i33 >>> 24);
                    i31--;
                }
            } else {
                int i36 = ((this.db.offset + (this.db.scanw * i30)) + i3) - 1;
                int i37 = (i3 << 2) - 1;
                while (i37 >= 0) {
                    int i38 = (this.db.data[i36] >>> i5) + this.levShift;
                    int i39 = this.minVal;
                    if (i38 < i39 || i38 > (i39 = this.maxVal)) {
                        i38 = i39;
                    }
                    byte[] bArr7 = this.buf;
                    bArr7[i37] = (byte) i38;
                    bArr7[i37 - 1] = (byte) (i38 >>> 8);
                    int i40 = i37 - 3;
                    bArr7[i37 - 2] = (byte) (i38 >>> 16);
                    i37 -= 4;
                    bArr7[i40] = (byte) (i38 >>> 24);
                    i36--;
                }
            }
            this.out.write(this.buf, 0, i3 << 2);
            i30++;
            i7 = 1;
        }
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void write() throws IOException {
        int tileIdx = this.src.getTileIdx();
        int tileCompWidth = this.src.getTileCompWidth(tileIdx, this.c);
        int tileCompHeight = this.src.getTileCompHeight(tileIdx, this.c);
        for (int i = 0; i < tileCompHeight; i += 64) {
            int i2 = tileCompHeight - i;
            if (i2 >= 64) {
                i2 = 64;
            }
            write(0, i, tileCompWidth, i2);
        }
    }

    public String toString() {
        return "ImgWriterPGX: WxH = " + this.w + "x" + this.h + ", Component = " + this.c + ", Bit-depth = " + this.bitDepth + ", signed = " + this.isSigned + "\nUnderlying RandomAccessFile:\n" + this.out.toString();
    }
}
