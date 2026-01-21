package jj2000.j2k.image.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import jj2000.j2k.JJ2KExceptionHandler;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class ImgReaderPGM extends ImgReader {
    public static int DC_OFFSET = 128;
    private byte[] buf;
    private RandomAccessFile in;
    private DataBlkInt intBlk;
    private int offset;
    private int rb;

    public ImgReaderPGM(File file) throws IOException {
        this(new RandomAccessFile(file, "r"));
    }

    public ImgReaderPGM(String str) throws IOException {
        this(new RandomAccessFile(str, "r"));
    }

    public ImgReaderPGM(RandomAccessFile randomAccessFile) throws IOException {
        this.in = randomAccessFile;
        confirmFileType();
        skipCommentAndWhiteSpace();
        this.w = readHeaderInt();
        skipCommentAndWhiteSpace();
        this.h = readHeaderInt();
        skipCommentAndWhiteSpace();
        readHeaderInt();
        this.nc = 1;
        this.rb = 8;
    }

    @Override // jj2000.j2k.image.input.ImgReader
    public void close() throws IOException {
        this.in.close();
        this.in = null;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        if (i != 0) {
            throw new IllegalArgumentException();
        }
        return this.rb;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        if (i == 0) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public final DataBlk getInternCompData(DataBlk dataBlk, int i) throws IOException {
        if (i != 0) {
            throw new IllegalArgumentException();
        }
        if (dataBlk.getDataType() != 3) {
            DataBlkInt dataBlkInt = this.intBlk;
            if (dataBlkInt == null) {
                this.intBlk = new DataBlkInt(dataBlk.ulx, dataBlk.uly, dataBlk.w, dataBlk.h);
            } else {
                dataBlkInt.ulx = dataBlk.ulx;
                this.intBlk.uly = dataBlk.uly;
                this.intBlk.w = dataBlk.w;
                this.intBlk.h = dataBlk.h;
            }
            dataBlk = this.intBlk;
        }
        int[] iArr = (int[]) dataBlk.getData();
        if (iArr == null || iArr.length < dataBlk.w * dataBlk.h) {
            iArr = new int[dataBlk.w * dataBlk.h];
            dataBlk.setData(iArr);
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < dataBlk.w) {
            this.buf = new byte[dataBlk.w];
        }
        try {
            int i2 = dataBlk.uly + dataBlk.h;
            for (int i3 = dataBlk.uly; i3 < i2; i3++) {
                this.in.seek(this.offset + (this.w * i3) + dataBlk.ulx);
                this.in.read(this.buf, 0, dataBlk.w);
                int i4 = (((i3 - dataBlk.uly) * dataBlk.w) + dataBlk.w) - 1;
                int i5 = dataBlk.w - 1;
                while (i5 >= 0) {
                    iArr[i4] = (this.buf[i5] & 255) - DC_OFFSET;
                    i5--;
                    i4--;
                }
            }
        } catch (IOException e) {
            JJ2KExceptionHandler.handleException(e);
        }
        dataBlk.progressive = false;
        dataBlk.offset = 0;
        dataBlk.scanw = dataBlk.w;
        return dataBlk;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return getInternCompData(dataBlk, i);
    }

    private byte countedByteRead() throws IOException {
        this.offset++;
        return this.in.readByte();
    }

    private void confirmFileType() throws IOException {
        byte[] bArr = {80, 53};
        for (int i = 0; i < 2; i++) {
            byte bCountedByteRead = countedByteRead();
            if (bCountedByteRead != bArr[i]) {
                if (i == 1 && bCountedByteRead == 50) {
                    throw new IllegalArgumentException("JJ2000 does not support ascii-PGM files. Use  raw-PGM file instead. ");
                }
                throw new IllegalArgumentException("Not a raw-PGM file");
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
        if (i == 0) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "ImgReaderPGM: WxH = " + this.w + "x" + this.h + ", Component = 0\nUnderlying RandomAccessIO:\n" + this.in.toString();
    }
}
