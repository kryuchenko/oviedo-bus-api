package jj2000.j2k.image.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import jj2000.j2k.JJ2KExceptionHandler;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class ImgReaderPPM extends ImgReader {
    public static int DC_OFFSET = 128;
    private int[][] barr;
    private byte[] buf;
    private DataBlkInt dbi;
    private RandomAccessFile in;
    private DataBlkInt intBlk;
    private int offset;
    private int rb;

    public ImgReaderPPM(File file) throws IOException {
        this(new RandomAccessFile(file, "r"));
    }

    public ImgReaderPPM(String str) throws IOException {
        this(new RandomAccessFile(str, "r"));
    }

    private ImgReaderPPM(RandomAccessFile randomAccessFile) throws IOException {
        this.barr = new int[3][];
        this.dbi = new DataBlkInt();
        this.in = randomAccessFile;
        confirmFileType();
        skipCommentAndWhiteSpace();
        this.w = readHeaderInt();
        skipCommentAndWhiteSpace();
        this.h = readHeaderInt();
        skipCommentAndWhiteSpace();
        readHeaderInt();
        this.nc = 3;
        this.rb = 8;
    }

    @Override // jj2000.j2k.image.input.ImgReader
    public void close() throws IOException {
        this.in.close();
        this.in = null;
        int[][] iArr = this.barr;
        iArr[0] = null;
        iArr[1] = null;
        iArr[2] = null;
        this.buf = null;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
        return this.rb;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
        return 0;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getInternCompData(DataBlk dataBlk, int i) throws IOException {
        char c;
        DataBlk dataBlk2 = dataBlk;
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
        if (dataBlk2.getDataType() != 3) {
            DataBlkInt dataBlkInt = this.intBlk;
            if (dataBlkInt == null) {
                this.intBlk = new DataBlkInt(dataBlk2.ulx, dataBlk2.uly, dataBlk2.w, dataBlk2.h);
            } else {
                dataBlkInt.ulx = dataBlk2.ulx;
                this.intBlk.uly = dataBlk2.uly;
                this.intBlk.w = dataBlk2.w;
                this.intBlk.h = dataBlk2.h;
            }
            dataBlk2 = this.intBlk;
        }
        DataBlk dataBlk3 = dataBlk2;
        if (this.barr[i] == null || this.dbi.ulx > dataBlk3.ulx || this.dbi.uly > dataBlk3.uly || this.dbi.ulx + this.dbi.w < dataBlk3.ulx + dataBlk3.w || this.dbi.uly + this.dbi.h < dataBlk3.uly + dataBlk3.h) {
            int[] iArr = this.barr[i];
            if (iArr == null || iArr.length < dataBlk3.w * dataBlk3.h) {
                this.barr[i] = new int[dataBlk3.w * dataBlk3.h];
            }
            dataBlk3.setData(this.barr[i]);
            int i2 = (i + 1) % 3;
            int[] iArr2 = this.barr[i2];
            if (iArr2 == null || iArr2.length < dataBlk3.w * dataBlk3.h) {
                this.barr[i2] = new int[dataBlk3.w * dataBlk3.h];
            }
            int i3 = (i + 2) % 3;
            int[] iArr3 = this.barr[i3];
            if (iArr3 == null || iArr3.length < dataBlk3.w * dataBlk3.h) {
                this.barr[i3] = new int[dataBlk3.w * dataBlk3.h];
            }
            this.dbi.ulx = dataBlk3.ulx;
            this.dbi.uly = dataBlk3.uly;
            this.dbi.w = dataBlk3.w;
            this.dbi.h = dataBlk3.h;
            byte[] bArr = this.buf;
            if (bArr == null || bArr.length < dataBlk3.w * 3) {
                this.buf = new byte[dataBlk3.w * 3];
            }
            int[][] iArr4 = this.barr;
            int[] iArr5 = iArr4[0];
            int[] iArr6 = iArr4[1];
            int[] iArr7 = iArr4[2];
            try {
                int i4 = dataBlk3.uly + dataBlk3.h;
                for (int i5 = dataBlk3.uly; i5 < i4; i5++) {
                    this.in.seek(this.offset + (i5 * 3 * this.w) + (dataBlk3.ulx * 3));
                    this.in.read(this.buf, 0, dataBlk3.w * 3);
                    int i6 = (((i5 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                    int i7 = (dataBlk3.w * 3) - 1;
                    while (i7 >= 0) {
                        byte[] bArr2 = this.buf;
                        int i8 = i7 - 1;
                        c = 2;
                        try {
                            int i9 = bArr2[i7] & 255;
                            int i10 = DC_OFFSET;
                            iArr7[i6] = i9 - i10;
                            int i11 = i7 - 2;
                            iArr6[i6] = (bArr2[i8] & 255) - i10;
                            i7 -= 3;
                            iArr5[i6] = (bArr2[i11] & 255) - i10;
                            i6--;
                        } catch (IOException e) {
                            e = e;
                            JJ2KExceptionHandler.handleException(e);
                            int[][] iArr8 = this.barr;
                            iArr8[0] = iArr5;
                            iArr8[1] = iArr6;
                            iArr8[c] = iArr7;
                            dataBlk3.setData(iArr8[i]);
                            dataBlk3.offset = 0;
                            dataBlk3.scanw = dataBlk3.w;
                            dataBlk3.progressive = false;
                            return dataBlk3;
                        }
                    }
                }
                c = 2;
            } catch (IOException e2) {
                e = e2;
                c = 2;
            }
            int[][] iArr82 = this.barr;
            iArr82[0] = iArr5;
            iArr82[1] = iArr6;
            iArr82[c] = iArr7;
            dataBlk3.setData(iArr82[i]);
            dataBlk3.offset = 0;
            dataBlk3.scanw = dataBlk3.w;
        } else {
            dataBlk3.setData(this.barr[i]);
            dataBlk3.offset = (((dataBlk3.ulx - this.dbi.ulx) * this.dbi.w) + dataBlk3.ulx) - this.dbi.ulx;
            dataBlk3.scanw = this.dbi.scanw;
        }
        dataBlk3.progressive = false;
        return dataBlk3;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getCompData(DataBlk dataBlk, int i) throws IOException {
        if (dataBlk.getDataType() != 3) {
            dataBlk = new DataBlkInt(dataBlk.ulx, dataBlk.uly, dataBlk.w, dataBlk.h);
        }
        int[] iArr = (int[]) dataBlk.getData();
        int i2 = dataBlk.ulx;
        int i3 = dataBlk.uly;
        int i4 = dataBlk.w;
        int i5 = dataBlk.h;
        dataBlk.setData(null);
        getInternCompData(dataBlk, i);
        if (iArr == null) {
            iArr = new int[i4 * i5];
        }
        if (dataBlk.offset == 0 && dataBlk.scanw == i4) {
            System.arraycopy(dataBlk.getData(), 0, iArr, 0, i4 * i5);
        } else {
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                System.arraycopy(dataBlk.getData(), dataBlk.offset + (dataBlk.scanw * i6), iArr, i6 * i4, i4);
            }
        }
        dataBlk.setData(iArr);
        dataBlk.offset = 0;
        dataBlk.scanw = dataBlk.w;
        return dataBlk;
    }

    private byte countedByteRead() throws IOException {
        this.offset++;
        return this.in.readByte();
    }

    private void confirmFileType() throws IOException {
        byte[] bArr = {80, 54};
        for (int i = 0; i < 2; i++) {
            byte bCountedByteRead = countedByteRead();
            if (bCountedByteRead != bArr[i]) {
                if (i == 1 && bCountedByteRead == 51) {
                    throw new IllegalArgumentException("JJ2000 does not support ascii-PPM files. Use  raw-PPM file instead. ");
                }
                throw new IllegalArgumentException("Not a raw-PPM file");
            }
        }
    }

    private void skipCommentAndWhiteSpace() throws IOException {
        boolean z = false;
        while (!z) {
            byte bCountedByteRead = countedByteRead();
            if (bCountedByteRead == 35) {
                while (bCountedByteRead != 10 && bCountedByteRead != 13) {
                    bCountedByteRead = countedByteRead();
                }
            } else if (bCountedByteRead != 9 && bCountedByteRead != 10 && bCountedByteRead != 13 && bCountedByteRead != 32) {
                z = true;
            }
        }
        int i = this.offset - 1;
        this.offset = i;
        this.in.seek(i);
    }

    private int readHeaderInt() throws IOException {
        byte bCountedByteRead = countedByteRead();
        int i = 0;
        while (bCountedByteRead != 32 && bCountedByteRead != 10 && bCountedByteRead != 9 && bCountedByteRead != 13) {
            i = ((i * 10) + bCountedByteRead) - 48;
            bCountedByteRead = countedByteRead();
        }
        return i;
    }

    @Override // jj2000.j2k.image.input.ImgReader
    public boolean isOrigSigned(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    public String toString() {
        return "ImgReaderPPM: WxH = " + this.w + "x" + this.h + ", Component = 0,1,2\nUnderlying RandomAccessFile:\n" + this.in.toString();
    }
}
