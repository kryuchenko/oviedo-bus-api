package jj2000.j2k.util;

import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Vector;
import jj2000.j2k.io.BEBufferedRandomAccessFile;
import jj2000.j2k.io.BufferedRandomAccessFile;

/* loaded from: classes5.dex */
public class CodestreamManipulator {
    private static int MAX_TPSOT = 16;
    private static int TP_HEAD_LEN = 14;
    private byte[] mainHeader;
    private int maxtp;
    private int nt;
    private String outname;
    private byte[][][] packetData;
    private byte[][][] packetHeaders;
    private Integer[] positions;
    private boolean ppmUsed;
    private int[] ppt;
    private boolean pptUsed;
    private int pptp;
    private byte[][][] sopMarkSeg;
    private boolean tempEph;
    private boolean tempSop;
    private byte[][] tileHeaders;
    private byte[][][] tileParts;

    public CodestreamManipulator(String str, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.ppt = new int[this.nt];
        this.outname = str;
        this.nt = i;
        this.pptp = i2;
        this.ppmUsed = z;
        this.pptUsed = z2;
        this.tempSop = z3;
        this.tempEph = z4;
    }

    public int doCodestreamManipulation() throws IOException {
        int i = this.nt;
        this.ppt = new int[i];
        this.tileParts = new byte[i][][];
        this.tileHeaders = new byte[i][];
        this.packetHeaders = new byte[i][][];
        this.packetData = new byte[i][][];
        this.sopMarkSeg = new byte[i][][];
        if (!this.ppmUsed && !this.pptUsed && this.pptp == 0) {
            return 0;
        }
        BEBufferedRandomAccessFile bEBufferedRandomAccessFile = new BEBufferedRandomAccessFile(this.outname, "rw+");
        int length = 0 - bEBufferedRandomAccessFile.length();
        parseAndFind(bEBufferedRandomAccessFile);
        readAndBuffer(bEBufferedRandomAccessFile);
        bEBufferedRandomAccessFile.close();
        BEBufferedRandomAccessFile bEBufferedRandomAccessFile2 = new BEBufferedRandomAccessFile(this.outname, "rw");
        createTileParts();
        writeNewCodestream(bEBufferedRandomAccessFile2);
        bEBufferedRandomAccessFile2.flush();
        int length2 = length + bEBufferedRandomAccessFile2.length();
        bEBufferedRandomAccessFile2.close();
        return length2;
    }

    private void parseAndFind(BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        Vector vector = new Vector();
        bufferedRandomAccessFile.readUnsignedShort();
        int unsignedShort = bufferedRandomAccessFile.readUnsignedShort();
        while (true) {
            short s = (short) unsignedShort;
            if (s == -112) {
                break;
            }
            int pos = bufferedRandomAccessFile.getPos();
            int unsignedShort2 = bufferedRandomAccessFile.readUnsignedShort();
            if (s == -174) {
                int unsignedByte = bufferedRandomAccessFile.readUnsignedByte();
                if (this.tempSop) {
                    unsignedByte &= 253;
                }
                if (this.tempEph) {
                    unsignedByte &= 251;
                }
                bufferedRandomAccessFile.seek(pos + 2);
                bufferedRandomAccessFile.write(unsignedByte);
            }
            bufferedRandomAccessFile.seek(pos + unsignedShort2);
            unsignedShort = bufferedRandomAccessFile.readUnsignedShort();
        }
        bufferedRandomAccessFile.seek(bufferedRandomAccessFile.getPos() - 2);
        for (int i = 0; i < this.nt; i++) {
            bufferedRandomAccessFile.readUnsignedShort();
            int pos2 = bufferedRandomAccessFile.getPos();
            vector.addElement(new Integer(bufferedRandomAccessFile.getPos()));
            bufferedRandomAccessFile.readInt();
            int i2 = bufferedRandomAccessFile.readInt();
            bufferedRandomAccessFile.readUnsignedShort();
            int i3 = (pos2 + i2) - 2;
            int unsignedShort3 = bufferedRandomAccessFile.readUnsignedShort();
            while (true) {
                short s2 = (short) unsignedShort3;
                if (s2 == -109) {
                    break;
                }
                int pos3 = bufferedRandomAccessFile.getPos();
                int unsignedShort4 = bufferedRandomAccessFile.readUnsignedShort();
                if (s2 == -174) {
                    int unsignedByte2 = bufferedRandomAccessFile.readUnsignedByte();
                    if (this.tempSop) {
                        unsignedByte2 &= 253;
                    }
                    if (this.tempEph) {
                        unsignedByte2 &= 251;
                    }
                    bufferedRandomAccessFile.seek(pos3 + 2);
                    bufferedRandomAccessFile.write(unsignedByte2);
                }
                bufferedRandomAccessFile.seek(pos3 + unsignedShort4);
                unsignedShort3 = bufferedRandomAccessFile.readUnsignedShort();
            }
            int pos4 = bufferedRandomAccessFile.getPos();
            while (pos4 < i3) {
                short unsignedByte3 = (short) bufferedRandomAccessFile.readUnsignedByte();
                if (unsignedByte3 == 255) {
                    short unsignedByte4 = (short) ((unsignedByte3 << 8) + bufferedRandomAccessFile.readUnsignedByte());
                    int i4 = pos4 + 1;
                    if (unsignedByte4 == -111) {
                        vector.addElement(new Integer(bufferedRandomAccessFile.getPos()));
                        int[] iArr = this.ppt;
                        iArr[i] = iArr[i] + 1;
                        bufferedRandomAccessFile.skipBytes(4);
                        pos4 += 5;
                    } else {
                        pos4 = i4;
                    }
                    if (unsignedByte4 == -110) {
                        vector.addElement(new Integer(bufferedRandomAccessFile.getPos()));
                    }
                }
                pos4++;
            }
        }
        vector.addElement(new Integer(bufferedRandomAccessFile.getPos() + 2));
        Integer[] numArr = new Integer[vector.size()];
        this.positions = numArr;
        vector.copyInto(numArr);
    }

    private void readAndBuffer(BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        int i;
        bufferedRandomAccessFile.seek(0);
        int iIntValue = this.positions[0].intValue() - 2;
        byte[] bArr = new byte[iIntValue];
        this.mainHeader = bArr;
        bufferedRandomAccessFile.readFully(bArr, 0, iIntValue);
        int i2 = 0;
        for (int i3 = 0; i3 < this.nt; i3++) {
            int i4 = this.ppt[i3];
            this.packetHeaders[i3] = new byte[i4][];
            this.packetData[i3] = new byte[i4][];
            this.sopMarkSeg[i3] = new byte[i4][];
            int i5 = i2 + 1;
            int iIntValue2 = this.positions[i5].intValue() - this.positions[i2].intValue();
            byte[] bArr2 = new byte[iIntValue2];
            this.tileHeaders[i3] = bArr2;
            bufferedRandomAccessFile.readFully(bArr2, 0, iIntValue2);
            i2 = i5;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = i2 + 1;
                int iIntValue3 = this.positions[i7].intValue() - this.positions[i2].intValue();
                if (this.tempSop) {
                    i = iIntValue3 - 6;
                    bufferedRandomAccessFile.skipBytes(6);
                } else {
                    i = iIntValue3 - 6;
                    byte[][][] bArr3 = this.sopMarkSeg;
                    bArr3[i3][i6] = new byte[6];
                    bufferedRandomAccessFile.readFully(bArr3[i3][i6], 0, 6);
                }
                if (!this.tempEph) {
                    i += 2;
                }
                byte[][][] bArr4 = this.packetHeaders;
                bArr4[i3][i6] = new byte[i];
                bufferedRandomAccessFile.readFully(bArr4[i3][i6], 0, i);
                i2 += 2;
                int iIntValue4 = (this.positions[i2].intValue() - this.positions[i7].intValue()) - 2;
                if (this.tempEph) {
                    bufferedRandomAccessFile.skipBytes(2);
                }
                byte[][][] bArr5 = this.packetData;
                bArr5[i3][i6] = new byte[iIntValue4];
                bufferedRandomAccessFile.readFully(bArr5[i3][i6], 0, iIntValue4);
            }
        }
    }

    private void createTileParts() throws IOException {
        char c;
        char c2;
        int i;
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.tileParts = new byte[this.nt][][];
        int i3 = 0;
        this.maxtp = 0;
        int i4 = 0;
        while (i4 < this.nt) {
            if (this.pptp == 0) {
                this.pptp = this.ppt[i4];
            }
            int i5 = this.ppt[i4];
            int iCeil = (int) Math.ceil(i5 / this.pptp);
            int length = this.packetHeaders[i4].length;
            int i6 = this.maxtp;
            if (iCeil > i6) {
                i6 = iCeil;
            }
            this.maxtp = i6;
            this.tileParts[i4] = new byte[iCeil][];
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i7 < iCeil) {
                int i11 = this.pptp;
                if (i11 > i5) {
                    i11 = i5;
                }
                if (i7 == 0) {
                    byte[] bArr = this.tileHeaders[i4];
                    byteArrayOutputStream.write(bArr, i3, bArr.length - 2);
                } else {
                    int i12 = TP_HEAD_LEN;
                    byteArrayOutputStream.write(new byte[i12 - 2], i3, i12 - 2);
                }
                if (this.pptUsed) {
                    i10 = i8;
                    int i13 = 0;
                    int i14 = 3;
                    c = 2;
                    c2 = 3;
                    for (int i15 = i11; i15 > 0; i15--) {
                        int length2 = this.packetHeaders[i4][i10].length;
                        if (i14 + length2 > 65535) {
                            byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
                            byteArrayOutputStream.write(-159);
                            byteArrayOutputStream.write(i14 >>> 8);
                            byteArrayOutputStream.write(i14);
                            int i16 = i13 + 1;
                            byteArrayOutputStream.write(i13);
                            while (i8 < i10) {
                                byte[] bArr2 = this.packetHeaders[i4][i8];
                                byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                                i8++;
                            }
                            i13 = i16;
                            i8 = i10;
                            i14 = 3;
                        }
                        i14 += length2;
                        i10++;
                    }
                    byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
                    byteArrayOutputStream.write(-159);
                    byteArrayOutputStream.write(i14 >>> 8);
                    byteArrayOutputStream.write(i14);
                    byteArrayOutputStream.write(i13);
                    while (i8 < i10) {
                        byte[] bArr3 = this.packetHeaders[i4][i8];
                        byteArrayOutputStream.write(bArr3, 0, bArr3.length);
                        i8++;
                    }
                } else {
                    c = 2;
                    c2 = 3;
                }
                i8 = i10;
                byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
                byteArrayOutputStream.write(-109);
                i10 = i9;
                while (true) {
                    i = i9 + i11;
                    if (i10 >= i) {
                        break;
                    }
                    if (this.tempSop) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        byteArrayOutputStream.write(this.sopMarkSeg[i4][i10], 0, 6);
                    }
                    if (!this.ppmUsed && !this.pptUsed) {
                        byte[] bArr4 = this.packetHeaders[i4][i10];
                        byteArrayOutputStream.write(bArr4, i2, bArr4.length);
                    }
                    byte[] bArr5 = this.packetData[i4][i10];
                    byteArrayOutputStream.write(bArr5, i2, bArr5.length);
                    i10++;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.tileParts[i4][i7] = byteArray;
                int size = byteArrayOutputStream.size();
                if (i7 == 0) {
                    byteArray[6] = (byte) (size >>> 24);
                    byteArray[7] = (byte) (size >>> 16);
                    byteArray[8] = (byte) (size >>> 8);
                    byteArray[9] = (byte) size;
                    byteArray[10] = 0;
                    byteArray[11] = (byte) iCeil;
                } else {
                    byteArray[0] = -1;
                    byteArray[1] = -112;
                    byteArray[c] = 0;
                    byteArray[c2] = 10;
                    byteArray[4] = (byte) (i4 >>> 8);
                    byteArray[5] = (byte) i4;
                    byteArray[6] = (byte) (size >>> 24);
                    byteArray[7] = (byte) (size >>> 16);
                    byteArray[8] = (byte) (size >>> 8);
                    byteArray[9] = (byte) size;
                    byteArray[10] = (byte) i7;
                    byteArray[11] = (byte) iCeil;
                }
                byteArrayOutputStream.reset();
                i5 -= i11;
                i7++;
                i9 = i;
                i3 = 0;
            }
            i4++;
            i3 = 0;
        }
        byteArrayOutputStream.close();
    }

    private void writeNewCodestream(BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        int i;
        int length = this.tileParts.length;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, this.maxtp);
        byte[] bArr = this.mainHeader;
        bufferedRandomAccessFile.write(bArr, 0, bArr.length);
        if (this.ppmUsed) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int[] iArr2 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr2[i2] = this.packetHeaders[i2].length;
            }
            int i3 = 0;
            while (i3 < this.maxtp) {
                for (int i4 = 0; i4 < length; i4++) {
                    byte[][] bArr2 = this.tileParts[i4];
                    if (bArr2.length > i3) {
                        int length2 = this.packetHeaders[i4].length;
                        int i5 = i3 == bArr2.length - 1 ? iArr2[i4] : this.pptp;
                        int i6 = length2 - iArr2[i4];
                        int i7 = i6 + i5;
                        while (i6 < i7) {
                            int[] iArr3 = iArr[i4];
                            iArr3[i3] = iArr3[i3] + this.packetHeaders[i4][i6].length;
                            i6++;
                        }
                        iArr2[i4] = iArr2[i4] - i5;
                    }
                }
                i3++;
            }
            byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
            byteArrayOutputStream.write(-160);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            for (int i8 = 0; i8 < length; i8++) {
                iArr2[i8] = this.packetHeaders[i8].length;
            }
            int i9 = 0;
            int length3 = 3;
            int i10 = 1;
            while (i9 < this.maxtp) {
                for (int i11 = 0; i11 < length; i11++) {
                    byte[][] bArr3 = this.tileParts[i11];
                    if (bArr3.length > i9) {
                        int length4 = this.packetHeaders[i11].length;
                        int i12 = i9 == bArr3.length + (-1) ? iArr2[i11] : this.pptp;
                        int i13 = length4 - iArr2[i11];
                        int i14 = i13 + i12;
                        if (length3 + 4 > 65535) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            int length5 = byteArray.length;
                            int i15 = length5 - 2;
                            byteArray[2] = (byte) (i15 >>> 8);
                            byteArray[3] = (byte) i15;
                            bufferedRandomAccessFile.write(byteArray, 0, length5);
                            byteArrayOutputStream.reset();
                            byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
                            byteArrayOutputStream.write(-160);
                            byteArrayOutputStream.write(0);
                            byteArrayOutputStream.write(0);
                            byteArrayOutputStream.write(i10);
                            i10++;
                            length3 = 3;
                        }
                        int i16 = iArr[i11][i9];
                        byteArrayOutputStream.write(i16 >>> 24);
                        byteArrayOutputStream.write(i16 >>> 16);
                        byteArrayOutputStream.write(i16 >>> 8);
                        byteArrayOutputStream.write(i16);
                        length3 += 4;
                        while (i13 < i14) {
                            if (this.packetHeaders[i11][i13].length + length3 > 65535) {
                                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                                int length6 = byteArray2.length;
                                int i17 = length6 - 2;
                                byteArray2[2] = (byte) (i17 >>> 8);
                                byteArray2[3] = (byte) i17;
                                i = 0;
                                bufferedRandomAccessFile.write(byteArray2, 0, length6);
                                byteArrayOutputStream.reset();
                                byteArrayOutputStream.write(ViewCompat.MEASURED_SIZE_MASK);
                                byteArrayOutputStream.write(-160);
                                byteArrayOutputStream.write(0);
                                byteArrayOutputStream.write(0);
                                byteArrayOutputStream.write(i10);
                                i10++;
                                length3 = 3;
                            } else {
                                i = 0;
                            }
                            byte[] bArr4 = this.packetHeaders[i11][i13];
                            byteArrayOutputStream.write(bArr4, i, bArr4.length);
                            length3 += this.packetHeaders[i11][i13].length;
                            i13++;
                        }
                        iArr2[i11] = iArr2[i11] - i12;
                    }
                }
                i9++;
            }
            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
            int length7 = byteArray3.length;
            int i18 = length7 - 2;
            byteArray3[2] = (byte) (i18 >>> 8);
            byteArray3[3] = (byte) i18;
            bufferedRandomAccessFile.write(byteArray3, 0, length7);
        }
        for (int i19 = 0; i19 < this.maxtp; i19++) {
            for (int i20 = 0; i20 < this.nt; i20++) {
                byte[][] bArr5 = this.tileParts[i20];
                if (bArr5.length > i19) {
                    byte[] bArr6 = bArr5[i19];
                    bufferedRandomAccessFile.write(bArr6, 0, bArr6.length);
                }
            }
        }
        bufferedRandomAccessFile.writeShort(-39);
    }
}
