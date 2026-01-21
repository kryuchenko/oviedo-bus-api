package jj2000.j2k.image.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import jj2000.j2k.JJ2KExceptionHandler;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.io.EndianType;

/* loaded from: classes5.dex */
public class ImgReaderPGX extends ImgReader implements EndianType {
    private int bitDepth;
    private byte[] buf;
    private int byteOrder;
    private RandomAccessFile in;
    private DataBlkInt intBlk;
    private boolean isSigned;
    private int offset;
    private int packBytes;

    public ImgReaderPGX(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException("PGX file " + file.getName() + " does not exist");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.in = randomAccessFile;
        try {
            String line = randomAccessFile.readLine();
            if (line == null) {
                throw new IOException(file.getName() + " is an empty file");
            }
            this.offset = line.length() + 1;
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            try {
                int iCountTokens = stringTokenizer.countTokens();
                if (!stringTokenizer.nextToken().equals("PG")) {
                    throw new IOException(file.getName() + " is not a PGX file");
                }
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.equals("LM")) {
                    this.byteOrder = 1;
                } else {
                    if (!strNextToken.equals("ML")) {
                        throw new IOException(file.getName() + " is not a PGX file");
                    }
                    this.byteOrder = 0;
                }
                if (iCountTokens == 6) {
                    String strNextToken2 = stringTokenizer.nextToken();
                    if (strNextToken2.equals("+")) {
                        this.isSigned = false;
                    } else {
                        if (!strNextToken2.equals("-")) {
                            throw new IOException(file.getName() + " is not a PGX file");
                        }
                        this.isSigned = true;
                    }
                }
                try {
                    int iIntValue = new Integer(stringTokenizer.nextToken()).intValue();
                    this.bitDepth = iIntValue;
                    if (iIntValue <= 0 || iIntValue > 31) {
                        throw new IOException(file.getName() + " is not a valid PGX file");
                    }
                    this.w = new Integer(stringTokenizer.nextToken()).intValue();
                    this.h = new Integer(stringTokenizer.nextToken()).intValue();
                    this.nc = 1;
                    int i = this.bitDepth;
                    if (i <= 8) {
                        this.packBytes = 1;
                    } else if (i <= 16) {
                        this.packBytes = 2;
                    } else {
                        this.packBytes = 4;
                    }
                } catch (NumberFormatException unused) {
                    throw new IOException(file.getName() + " is not a PGX file");
                }
            } catch (NoSuchElementException unused2) {
                throw new IOException(file.getName() + " is not a PGX file");
            }
        } catch (IOException unused3) {
            throw new IOException(file.getName() + " is not a PGX file");
        }
    }

    public ImgReaderPGX(String str) throws IOException {
        this(new File(str));
    }

    @Override // jj2000.j2k.image.input.ImgReader
    public void close() throws IOException {
        this.in.close();
        this.in = null;
        this.buf = null;
    }

    @Override // jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        if (i != 0) {
            throw new IllegalArgumentException();
        }
        return this.bitDepth;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        if (i == 0) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) throws IOException {
        DataBlk dataBlk2 = dataBlk;
        int i2 = 1 << (this.bitDepth - 1);
        if (i != 0) {
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
        int[] iArr = (int[]) dataBlk3.getData();
        if (iArr == null || iArr.length < dataBlk3.w * dataBlk3.h * this.packBytes) {
            iArr = new int[dataBlk3.w * dataBlk3.h];
            dataBlk3.setData(iArr);
        }
        int i3 = 32 - this.bitDepth;
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < this.packBytes * dataBlk3.w) {
            this.buf = new byte[this.packBytes * dataBlk3.w];
        }
        try {
            int i4 = this.packBytes;
            if (i4 != 1) {
                int i5 = 2;
                if (i4 == 2) {
                    int i6 = dataBlk3.uly + dataBlk3.h;
                    if (this.isSigned) {
                        for (int i7 = dataBlk3.uly; i7 < i6; i7++) {
                            this.in.seek(this.offset + (((this.w * i7) + dataBlk3.ulx) * 2));
                            this.in.read(this.buf, 0, dataBlk3.w << 1);
                            int i8 = this.byteOrder;
                            if (i8 == 0) {
                                int i9 = (((i7 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i10 = (dataBlk3.w << 1) - 1;
                                while (i10 >= 0) {
                                    byte[] bArr2 = this.buf;
                                    int i11 = i10 - 1;
                                    int i12 = bArr2[i10] & 255;
                                    i10 -= 2;
                                    iArr[i9] = ((((bArr2[i11] & 255) << 8) | i12) << i3) >> i3;
                                    i9--;
                                }
                            } else if (i8 == 1) {
                                int i13 = (((i7 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i14 = (dataBlk3.w << 1) - 1;
                                while (i14 >= 0) {
                                    byte[] bArr3 = this.buf;
                                    int i15 = i14 - 1;
                                    int i16 = (bArr3[i14] & 255) << 8;
                                    i14 -= 2;
                                    iArr[i13] = (((bArr3[i15] & 255) | i16) << i3) >> i3;
                                    i13--;
                                }
                            } else {
                                throw new Error("Internal JJ2000 bug");
                            }
                        }
                    } else {
                        for (int i17 = dataBlk3.uly; i17 < i6; i17++) {
                            this.in.seek(this.offset + (((this.w * i17) + dataBlk3.ulx) * 2));
                            this.in.read(this.buf, 0, dataBlk3.w << 1);
                            int i18 = this.byteOrder;
                            if (i18 == 0) {
                                int i19 = (((i17 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i20 = (dataBlk3.w << 1) - 1;
                                while (i20 >= 0) {
                                    byte[] bArr4 = this.buf;
                                    int i21 = i20 - 1;
                                    int i22 = bArr4[i20] & 255;
                                    i20 -= 2;
                                    iArr[i19] = (((((bArr4[i21] & 255) << 8) | i22) << i3) >>> i3) - i2;
                                    i19--;
                                }
                            } else if (i18 == 1) {
                                int i23 = (((i17 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i24 = (dataBlk3.w << 1) - 1;
                                while (i24 >= 0) {
                                    byte[] bArr5 = this.buf;
                                    int i25 = i24 - 1;
                                    int i26 = (bArr5[i24] & 255) << 8;
                                    i24 -= 2;
                                    iArr[i23] = ((((bArr5[i25] & 255) | i26) << i3) >>> i3) - i2;
                                    i23--;
                                }
                            } else {
                                throw new Error("Internal JJ2000 bug");
                            }
                        }
                    }
                } else if (i4 == 4) {
                    int i27 = dataBlk3.uly + dataBlk3.h;
                    if (this.isSigned) {
                        int i28 = dataBlk3.uly;
                        while (i28 < i27) {
                            this.in.seek(this.offset + (((this.w * i28) + dataBlk3.ulx) * 4));
                            this.in.read(this.buf, 0, dataBlk3.w << i5);
                            int i29 = this.byteOrder;
                            if (i29 == 0) {
                                int i30 = (((i28 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i31 = (dataBlk3.w << 2) - 1;
                                while (i31 >= 0) {
                                    byte[] bArr6 = this.buf;
                                    int i32 = i31 - 3;
                                    int i33 = ((bArr6[i31 - 1] & 255) << 8) | (bArr6[i31] & 255) | ((bArr6[i31 - 2] & 255) << 16);
                                    i31 -= 4;
                                    iArr[i30] = ((((bArr6[i32] & 255) << 24) | i33) << i3) >> i3;
                                    i30--;
                                }
                            } else if (i29 == 1) {
                                int i34 = (((i28 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i35 = (dataBlk3.w << i5) - 1;
                                while (i35 >= 0) {
                                    byte[] bArr7 = this.buf;
                                    int i36 = i35 - 3;
                                    int i37 = ((bArr7[i35 - 2] & 255) << 8) | ((bArr7[i35 - 1] & 255) << 16) | ((bArr7[i35] & 255) << 24);
                                    i35 -= 4;
                                    iArr[i34] = ((i37 | (bArr7[i36] & 255)) << i3) >> i3;
                                    i34--;
                                }
                            } else {
                                throw new Error("Internal JJ2000 bug");
                            }
                            i28++;
                            i5 = 2;
                        }
                    } else {
                        for (int i38 = dataBlk3.uly; i38 < i27; i38++) {
                            this.in.seek(this.offset + (((this.w * i38) + dataBlk3.ulx) * 4));
                            this.in.read(this.buf, 0, dataBlk3.w << 2);
                            int i39 = this.byteOrder;
                            if (i39 == 0) {
                                int i40 = (((i38 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i41 = (dataBlk3.w << 2) - 1;
                                while (i41 >= 0) {
                                    byte[] bArr8 = this.buf;
                                    int i42 = i41 - 3;
                                    int i43 = ((bArr8[i41 - 1] & 255) << 8) | (bArr8[i41] & 255) | ((bArr8[i41 - 2] & 255) << 16);
                                    i41 -= 4;
                                    iArr[i40] = (((((bArr8[i42] & 255) << 24) | i43) << i3) >>> i3) - i2;
                                    i40--;
                                }
                            } else if (i39 == 1) {
                                int i44 = (((i38 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                                int i45 = (dataBlk3.w << 2) - 1;
                                while (i45 >= 0) {
                                    byte[] bArr9 = this.buf;
                                    int i46 = i45 - 3;
                                    int i47 = ((bArr9[i45 - 2] & 255) << 8) | ((bArr9[i45 - 1] & 255) << 16) | ((bArr9[i45] & 255) << 24);
                                    i45 -= 4;
                                    iArr[i44] = (((i47 | (bArr9[i46] & 255)) << i3) >>> i3) - i2;
                                    i44--;
                                }
                            } else {
                                throw new Error("Internal JJ2000 bug");
                            }
                        }
                    }
                } else {
                    throw new IOException("PGX supports only bit-depth between 1 and 31");
                }
            } else {
                int i48 = dataBlk3.uly + dataBlk3.h;
                if (this.isSigned) {
                    for (int i49 = dataBlk3.uly; i49 < i48; i49++) {
                        this.in.seek(this.offset + (this.w * i49) + dataBlk3.ulx);
                        this.in.read(this.buf, 0, dataBlk3.w);
                        int i50 = (((i49 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                        for (int i51 = dataBlk3.w - 1; i51 >= 0; i51--) {
                            iArr[i50] = ((this.buf[i51] & 255) << i3) >> i3;
                            i50--;
                        }
                    }
                } else {
                    for (int i52 = dataBlk3.uly; i52 < i48; i52++) {
                        this.in.seek(this.offset + (this.w * i52) + dataBlk3.ulx);
                        this.in.read(this.buf, 0, dataBlk3.w);
                        int i53 = (((i52 - dataBlk3.uly) * dataBlk3.w) + dataBlk3.w) - 1;
                        int i54 = dataBlk3.w - 1;
                        while (i54 >= 0) {
                            int i55 = i54 - 1;
                            iArr[i53] = (((this.buf[i54] & 255) << i3) >>> i3) - i2;
                            i53--;
                            i54 = i55;
                        }
                    }
                }
            }
        } catch (IOException e) {
            JJ2KExceptionHandler.handleException(e);
        }
        dataBlk3.progressive = false;
        dataBlk3.offset = 0;
        dataBlk3.scanw = dataBlk3.w;
        return dataBlk3;
    }

    @Override // jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return getInternCompData(dataBlk, i);
    }

    @Override // jj2000.j2k.image.input.ImgReader
    public boolean isOrigSigned(int i) {
        if (i != 0) {
            throw new IllegalArgumentException();
        }
        return this.isSigned;
    }

    public String toString() {
        return "ImgReaderPGX: WxH = " + this.w + "x" + this.h + ", Component = 0, Bit-depth = " + this.bitDepth + ", signed = " + this.isSigned + "\nUnderlying RandomAccessIO:\n" + this.in.toString();
    }
}
