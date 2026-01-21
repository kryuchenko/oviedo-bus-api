package jj2000.j2k.image.output;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class ImgWriterPPM extends ImgWriter {
    private byte[] buf;
    private int[] cps;
    private DataBlkInt db;
    private int[] fb;
    private int[] levShift;
    private int offset;
    private RandomAccessFile out;

    public ImgWriterPPM(File file, BlkImgDataSrc blkImgDataSrc, int i, int i2, int i3) throws IOException {
        this.levShift = new int[3];
        this.cps = new int[3];
        this.fb = new int[3];
        this.db = new DataBlkInt();
        if (i < 0 || i >= blkImgDataSrc.getNumComps() || i2 < 0 || i2 >= blkImgDataSrc.getNumComps() || i3 < 0 || i3 >= blkImgDataSrc.getNumComps() || blkImgDataSrc.getNomRangeBits(i) > 8 || blkImgDataSrc.getNomRangeBits(i2) > 8 || blkImgDataSrc.getNomRangeBits(i3) > 8) {
            throw new IllegalArgumentException("Invalid component indexes");
        }
        this.w = blkImgDataSrc.getCompImgWidth(i);
        this.h = blkImgDataSrc.getCompImgHeight(i);
        if (this.w != blkImgDataSrc.getCompImgWidth(i2) || this.w != blkImgDataSrc.getCompImgWidth(i3) || this.h != blkImgDataSrc.getCompImgHeight(i2) || this.h != blkImgDataSrc.getCompImgHeight(i3)) {
            throw new IllegalArgumentException("All components must have the same dimensions and no subsampling");
        }
        this.w = blkImgDataSrc.getImgWidth();
        this.h = blkImgDataSrc.getImgHeight();
        if (file.exists() && !file.delete()) {
            throw new IOException("Could not reset file");
        }
        this.out = new RandomAccessFile(file, "rw");
        this.src = blkImgDataSrc;
        int[] iArr = this.cps;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        this.fb[0] = blkImgDataSrc.getFixedPoint(i);
        this.fb[1] = blkImgDataSrc.getFixedPoint(i2);
        this.fb[2] = blkImgDataSrc.getFixedPoint(i3);
        this.levShift[0] = 1 << (blkImgDataSrc.getNomRangeBits(i) - 1);
        this.levShift[1] = 1 << (blkImgDataSrc.getNomRangeBits(i2) - 1);
        this.levShift[2] = 1 << (blkImgDataSrc.getNomRangeBits(i3) - 1);
        writeHeaderInfo();
    }

    public ImgWriterPPM(String str, BlkImgDataSrc blkImgDataSrc, int i, int i2, int i3) throws IOException {
        this(new File(str), blkImgDataSrc, i, i2, i3);
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void close() throws IOException {
        if (this.out.length() != (this.w * 3 * this.h) + this.offset) {
            RandomAccessFile randomAccessFile = this.out;
            randomAccessFile.seek(randomAccessFile.length());
            for (int length = (((this.w * 3) * this.h) + this.offset) - ((int) this.out.length()); length > 0; length--) {
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
        int compULX = this.src.getCompULX(this.cps[0]) - ((int) Math.ceil(this.src.getImgULX() / this.src.getCompSubsX(this.cps[0])));
        int compULY = this.src.getCompULY(this.cps[0]) - ((int) Math.ceil(this.src.getImgULY() / this.src.getCompSubsY(this.cps[0])));
        if (this.db.data != null && this.db.data.length < i3) {
            this.db.data = null;
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i3 * 3) {
            this.buf = new byte[i3 * 3];
        }
        for (int i5 = 0; i5 < i4; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                int nomRangeBits = (1 << this.src.getNomRangeBits(this.cps[i6])) - 1;
                int i7 = this.levShift[i6];
                this.db.ulx = i;
                this.db.uly = i2 + i5;
                this.db.w = i3;
                this.db.h = 1;
                do {
                    dataBlkInt = (DataBlkInt) this.src.getInternCompData(this.db, this.cps[i6]);
                    this.db = dataBlkInt;
                } while (dataBlkInt.progressive);
                int i8 = this.fb[i6];
                if (i8 == 0) {
                    int i9 = (this.db.offset + i3) - 1;
                    int i10 = (((i3 * 3) - 1) + i6) - 2;
                    while (i10 >= 0) {
                        int i11 = this.db.data[i9] + i7;
                        byte[] bArr2 = this.buf;
                        if (i11 < 0) {
                            i11 = 0;
                        } else if (i11 > nomRangeBits) {
                            i11 = nomRangeBits;
                        }
                        bArr2[i10] = (byte) i11;
                        i10 -= 3;
                        i9--;
                    }
                } else {
                    int i12 = (this.db.offset + i3) - 1;
                    int i13 = (((i3 * 3) - 1) + i6) - 2;
                    while (i13 >= 0) {
                        int i14 = (this.db.data[i12] >>> i8) + i7;
                        byte[] bArr3 = this.buf;
                        if (i14 < 0) {
                            i14 = 0;
                        } else if (i14 > nomRangeBits) {
                            i14 = nomRangeBits;
                        }
                        bArr3[i13] = (byte) i14;
                        i13 -= 3;
                        i12--;
                    }
                }
            }
            this.out.seek(this.offset + (((this.w * (i2 + compULY + i5)) + i + compULX) * 3));
            this.out.write(this.buf, 0, i3 * 3);
        }
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void write() throws IOException {
        int tileIdx = this.src.getTileIdx();
        int tileCompWidth = this.src.getTileCompWidth(tileIdx, 0);
        int tileCompHeight = this.src.getTileCompHeight(tileIdx, 0);
        for (int i = 0; i < tileCompHeight; i += 64) {
            int i2 = tileCompHeight - i;
            if (i2 >= 64) {
                i2 = 64;
            }
            write(0, i, tileCompWidth, i2);
        }
    }

    private void writeHeaderInfo() throws IOException {
        this.out.seek(0L);
        this.out.write(80);
        this.out.write(54);
        this.out.write(10);
        this.offset = 3;
        for (byte b : String.valueOf(this.w).getBytes()) {
            this.out.write(b);
            this.offset++;
        }
        this.out.write(32);
        this.offset++;
        for (byte b2 : String.valueOf(this.h).getBytes()) {
            this.out.write(b2);
            this.offset++;
        }
        this.out.write(10);
        this.out.write(50);
        this.out.write(53);
        this.out.write(53);
        this.out.write(10);
        this.offset += 5;
    }

    public String toString() {
        return "ImgWriterPPM: WxH = " + this.w + "x" + this.h + ", Components = " + this.cps[0] + "," + this.cps[1] + "," + this.cps[2] + "\nUnderlying RandomAccessFile:\n" + this.out.toString();
    }
}
