package jj2000.j2k.fileformat.writer;

import java.io.IOException;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.BEBufferedRandomAccessFile;

/* loaded from: classes5.dex */
public class FileFormatWriter implements FileFormatBoxes {
    private static final int BPC_LENGTH = 8;
    private static final int CSB_LENGTH = 15;
    private static final int FTB_LENGTH = 20;
    private static final int IHB_LENGTH = 22;
    private int[] bpc;
    private boolean bpcVaries;
    private int clength;
    private BEBufferedRandomAccessFile fi;
    private String filename;
    private int height;
    private int nc;
    private int width;

    public FileFormatWriter(String str, int i, int i2, int i3, int[] iArr, int i4) {
        this.height = i;
        this.width = i2;
        this.nc = i3;
        this.bpc = iArr;
        this.filename = str;
        this.clength = i4;
        this.bpcVaries = false;
        int i5 = iArr[0];
        for (int i6 = i3 - 1; i6 > 0; i6--) {
            if (iArr[i6] != i5) {
                this.bpcVaries = true;
            }
        }
    }

    public int writeFileFormat() throws IOException {
        try {
            BEBufferedRandomAccessFile bEBufferedRandomAccessFile = new BEBufferedRandomAccessFile(this.filename, "rw+");
            this.fi = bEBufferedRandomAccessFile;
            int i = this.clength;
            byte[] bArr = new byte[i];
            bEBufferedRandomAccessFile.readFully(bArr, 0, i);
            this.fi.seek(0);
            this.fi.writeInt(12);
            this.fi.writeInt(FileFormatBoxes.JP2_SIGNATURE_BOX);
            this.fi.writeInt(218793738);
            writeFileTypeBox();
            writeJP2HeaderBox();
            writeContiguousCodeStreamBox(bArr);
            this.fi.close();
            if (this.bpcVaries) {
                return this.nc + 93;
            }
            return 85;
        } catch (Exception unused) {
            throw new Error("Error while writing JP2 file format");
        }
    }

    public void writeFileTypeBox() throws IOException {
        this.fi.writeInt(20);
        this.fi.writeInt(FileFormatBoxes.FILE_TYPE_BOX);
        this.fi.writeInt(FileFormatBoxes.FT_BR);
        this.fi.writeInt(0);
        this.fi.writeInt(FileFormatBoxes.FT_BR);
    }

    public void writeJP2HeaderBox() throws IOException {
        if (this.bpcVaries) {
            this.fi.writeInt(this.nc + 53);
        } else {
            this.fi.writeInt(45);
        }
        this.fi.writeInt(FileFormatBoxes.JP2_HEADER_BOX);
        writeImageHeaderBox();
        writeColourSpecificationBox();
        if (this.bpcVaries) {
            writeBitsPerComponentBox();
        }
    }

    public void writeBitsPerComponentBox() throws IOException {
        this.fi.writeInt(this.nc + 8);
        this.fi.writeInt(FileFormatBoxes.BITS_PER_COMPONENT_BOX);
        for (int i = 0; i < this.nc; i++) {
            this.fi.writeByte(this.bpc[i] - 1);
        }
    }

    public void writeColourSpecificationBox() throws IOException {
        this.fi.writeInt(15);
        this.fi.writeInt(FileFormatBoxes.COLOUR_SPECIFICATION_BOX);
        this.fi.writeByte(1);
        this.fi.writeByte(0);
        this.fi.writeByte(0);
        if (this.nc > 1) {
            this.fi.writeInt(16);
        } else {
            this.fi.writeInt(17);
        }
    }

    public void writeImageHeaderBox() throws IOException {
        this.fi.writeInt(22);
        this.fi.writeInt(FileFormatBoxes.IMAGE_HEADER_BOX);
        this.fi.writeInt(this.height);
        this.fi.writeInt(this.width);
        this.fi.writeShort(this.nc);
        if (this.bpcVaries) {
            this.fi.writeByte(255);
        } else {
            this.fi.writeByte(this.bpc[0] - 1);
        }
        this.fi.writeByte(7);
        this.fi.writeByte(1);
        this.fi.writeByte(0);
    }

    public void writeContiguousCodeStreamBox(byte[] bArr) throws IOException {
        this.fi.writeInt(this.clength + 8);
        this.fi.writeInt(FileFormatBoxes.CONTIGUOUS_CODESTREAM_BOX);
        for (int i = 0; i < this.clength; i++) {
            this.fi.writeByte(bArr[i]);
        }
    }
}
