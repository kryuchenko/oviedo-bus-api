package colorspace.boxes;

import androidx.exifinterface.media.ExifInterface;
import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class PaletteBox extends JP2Box {
    private short[] bitdepth;
    private int[][] entries;
    private int ncolumns;
    private int nentries;

    static {
        type = FileFormatBoxes.PALETTE_BOX;
    }

    public PaletteBox(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        super(randomAccessIO, i);
        readBox();
    }

    void readBox() throws ColorSpaceException, IOException {
        int i;
        short s;
        byte[] bArr = new byte[4];
        this.in.seek(this.dataStart);
        this.in.readFully(bArr, 0, 3);
        this.nentries = ICCProfile.getShort(bArr, 0) & UShort.MAX_VALUE;
        int i2 = bArr[2] & 65535;
        this.ncolumns = i2;
        this.bitdepth = new short[i2];
        byte[] bArr2 = new byte[i2];
        this.in.readFully(bArr2, 0, this.ncolumns);
        int i3 = 0;
        while (true) {
            i = this.ncolumns;
            if (i3 >= i) {
                break;
            }
            this.bitdepth[i3] = (short) (bArr2[i3] & 4095);
            i3++;
        }
        this.entries = new int[this.nentries * i][];
        byte[] bArr3 = new byte[2];
        for (int i4 = 0; i4 < this.nentries; i4++) {
            this.entries[i4] = new int[this.ncolumns];
            for (int i5 = 0; i5 < this.ncolumns; i5++) {
                short bitDepth = getBitDepth(i5);
                boolean zIsSigned = isSigned(i5);
                int entrySize = getEntrySize(i5);
                if (entrySize == 1) {
                    this.in.readFully(bArr3, 0, 1);
                    s = bArr3[0];
                } else if (entrySize == 2) {
                    this.in.readFully(bArr3, 0, 2);
                    s = ICCProfile.getShort(bArr3, 0);
                } else {
                    throw new ColorSpaceException("palettes greater than 16 bits deep not supported");
                }
                if (!zIsSigned) {
                    this.entries[i4][i5] = ((1 << bitDepth) - 1) & s;
                } else if (((1 << (bitDepth - 1)) & s) == 0) {
                    this.entries[i4][i5] = ((1 << bitDepth) - 1) & s;
                } else {
                    this.entries[i4][i5] = ((-1) << bitDepth) | s;
                }
            }
        }
    }

    public int getNumEntries() {
        return this.nentries;
    }

    public int getNumColumns() {
        return this.ncolumns;
    }

    public boolean isSigned(int i) {
        return (this.bitdepth[i] & 128) == 1;
    }

    public boolean isUnSigned(int i) {
        return !isSigned(i);
    }

    public short getBitDepth(int i) {
        return (short) ((this.bitdepth[i] & 127) + 1);
    }

    public int getEntry(int i, int i2) {
        return this.entries[i2][i];
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[PaletteBox nentries= ").append(String.valueOf(this.nentries)).append(", ncolumns= ").append(String.valueOf(this.ncolumns)).append(", bitdepth per column= (");
        int i = 0;
        while (i < this.ncolumns) {
            stringBufferAppend.append((int) getBitDepth(i)).append(isSigned(i) ? ExifInterface.LATITUDE_SOUTH : "U").append(i < this.ncolumns + (-1) ? ", " : "");
            i++;
        }
        return stringBufferAppend.append(")]").toString();
    }

    private int getEntrySize(int i) {
        short bitDepth = getBitDepth(i);
        return (bitDepth / 8) + (bitDepth % 8) == 0 ? 0 : 1;
    }
}
