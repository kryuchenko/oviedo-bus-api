package jj2000.j2k.image.output;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes5.dex */
public class ImgWriterPGM extends ImgWriter {
    private byte[] buf;
    private int c;
    private DataBlkInt db;
    private int fb;
    private int levShift;
    private int offset;
    private RandomAccessFile out;

    public ImgWriterPGM(File file, BlkImgDataSrc blkImgDataSrc, int i) throws IOException {
        this.db = new DataBlkInt();
        if (i < 0 || i >= blkImgDataSrc.getNumComps()) {
            throw new IllegalArgumentException("Invalid number of components");
        }
        if (blkImgDataSrc.getNomRangeBits(i) > 8) {
            FacilityManager.getMsgLogger().println("Warning: Component " + i + " has nominal bitdepth " + blkImgDataSrc.getNomRangeBits(i) + ". Pixel values will be down-shifted to fit bitdepth of 8 for PGM file", 8, 8);
        }
        if (file.exists() && !file.delete()) {
            throw new IOException("Could not reset file");
        }
        this.out = new RandomAccessFile(file, "rw");
        this.src = blkImgDataSrc;
        this.c = i;
        this.w = blkImgDataSrc.getImgWidth();
        this.h = blkImgDataSrc.getImgHeight();
        this.fb = blkImgDataSrc.getFixedPoint(i);
        this.levShift = 1 << (blkImgDataSrc.getNomRangeBits(i) - 1);
        writeHeaderInfo();
    }

    public ImgWriterPGM(String str, BlkImgDataSrc blkImgDataSrc, int i) throws IOException {
        this(new File(str), blkImgDataSrc, i);
    }

    @Override // jj2000.j2k.image.output.ImgWriter
    public void close() throws IOException {
        if (this.out.length() != (this.w * this.h) + this.offset) {
            RandomAccessFile randomAccessFile = this.out;
            randomAccessFile.seek(randomAccessFile.length());
            for (int length = (this.offset + (this.w * this.h)) - ((int) this.out.length()); length > 0; length--) {
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
        int i6 = 1;
        int nomRangeBits = (1 << this.src.getNomRangeBits(this.c)) - 1;
        int nomRangeBits2 = this.src.getNomRangeBits(this.c) - 8;
        if (nomRangeBits2 < 0) {
            nomRangeBits2 = 0;
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i3) {
            this.buf = new byte[i3];
        }
        int i7 = 0;
        while (i7 < i4) {
            this.out.seek(this.offset + (this.w * (i2 + compULY + i7)) + i + compULX);
            if (i5 == 0) {
                int i8 = ((this.db.offset + (this.db.scanw * i7)) + i3) - i6;
                int i9 = i3 - 1;
                while (i9 >= 0) {
                    int i10 = this.db.data[i8] + this.levShift;
                    byte[] bArr2 = this.buf;
                    if (i10 < 0) {
                        i10 = 0;
                    } else if (i10 > nomRangeBits) {
                        i10 = nomRangeBits;
                    }
                    bArr2[i9] = (byte) (i10 >> nomRangeBits2);
                    i9--;
                    i8--;
                }
            } else {
                int i11 = ((this.db.offset + (this.db.scanw * i7)) + i3) - 1;
                int i12 = i3 - 1;
                while (i12 >= 0) {
                    int i13 = (this.db.data[i11] >> i5) + this.levShift;
                    byte[] bArr3 = this.buf;
                    if (i13 < 0) {
                        i13 = 0;
                    } else if (i13 > nomRangeBits) {
                        i13 = nomRangeBits;
                    }
                    bArr3[i12] = (byte) (i13 >> nomRangeBits2);
                    i12--;
                    i11--;
                }
            }
            this.out.write(this.buf, 0, i3);
            i7++;
            i6 = 1;
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

    private void writeHeaderInfo() throws IOException {
        this.out.writeByte(80);
        this.out.write(53);
        this.out.write(10);
        this.offset = 3;
        for (byte b : String.valueOf(this.w).getBytes()) {
            this.out.writeByte(b);
            this.offset++;
        }
        this.out.write(32);
        this.offset++;
        for (byte b2 : String.valueOf(this.h).getBytes()) {
            this.out.writeByte(b2);
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
        return "ImgWriterPGM: WxH = " + this.w + "x" + this.h + ", Component=" + this.c + "\nUnderlying RandomAccessFile:\n" + this.out.toString();
    }
}
