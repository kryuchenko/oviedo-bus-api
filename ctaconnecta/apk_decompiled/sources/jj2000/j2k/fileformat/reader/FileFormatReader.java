package jj2000.j2k.fileformat.reader;

import java.io.EOFException;
import java.io.IOException;
import java.util.Vector;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.util.FacilityManager;

/* loaded from: classes5.dex */
public class FileFormatReader implements FileFormatBoxes {
    public boolean JP2FFUsed;
    private Vector codeStreamLength;
    private Vector codeStreamPos;
    private RandomAccessIO in;

    public void readIntPropertyBox(int i) {
    }

    public void readUUIDBox(int i) {
    }

    public void readUUIDInfoBox(int i) {
    }

    public void readXMLBox(int i) {
    }

    public FileFormatReader(RandomAccessIO randomAccessIO) {
        this.in = randomAccessIO;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x002d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readFileFormat() throws IOException {
        FileFormatReader fileFormatReader;
        try {
            boolean z = false;
            try {
                if (this.in.readInt() == 12 && this.in.readInt() == 1783636000 && this.in.readInt() == 218793738) {
                    this.JP2FFUsed = true;
                    if (!readFileTypeBox()) {
                        throw new Error("Invalid JP2 file: File Type box missing");
                    }
                    boolean z2 = false;
                    while (!z) {
                        int pos = this.in.getPos();
                        int length = this.in.readInt();
                        if (pos + length == this.in.length()) {
                            z = true;
                        }
                        int i = this.in.readInt();
                        if (length == 0) {
                            length = this.in.length() - this.in.getPos();
                            z = true;
                        } else if (length == 1) {
                            this.in.readLong();
                            throw new IOException("File too long.");
                        }
                        int i2 = length;
                        switch (i) {
                            case FileFormatBoxes.INTELLECTUAL_PROPERTY_BOX /* 1685074537 */:
                                fileFormatReader = this;
                                readIntPropertyBox(i2);
                                if (!z) {
                                    fileFormatReader.in.seek(pos + i2);
                                }
                            case FileFormatBoxes.CONTIGUOUS_CODESTREAM_BOX /* 1785737827 */:
                                if (!z2) {
                                    throw new Error("Invalid JP2 file: JP2Header box not found before Contiguous codestream box ");
                                }
                                fileFormatReader = this;
                                fileFormatReader.readContiguousCodeStreamBox(pos, i2, 0L);
                                if (!z) {
                                }
                                break;
                            case FileFormatBoxes.JP2_HEADER_BOX /* 1785737832 */:
                                if (z2) {
                                    throw new Error("Invalid JP2 file: Multiple JP2Header boxes found");
                                }
                                readJP2HeaderBox(pos, i2, 0L);
                                z2 = true;
                                fileFormatReader = this;
                                if (!z) {
                                }
                                break;
                            case FileFormatBoxes.UUID_INFO_BOX /* 1969843814 */:
                                readUUIDInfoBox(i2);
                                fileFormatReader = this;
                                if (!z) {
                                }
                                break;
                            case FileFormatBoxes.UUID_BOX /* 1970628964 */:
                                readUUIDBox(i2);
                                fileFormatReader = this;
                                if (!z) {
                                }
                                break;
                            case FileFormatBoxes.XML_BOX /* 2020437024 */:
                                readXMLBox(i2);
                                fileFormatReader = this;
                                if (!z) {
                                }
                                break;
                            default:
                                fileFormatReader = this;
                                FacilityManager.getMsgLogger().printmsg(2, "Unknown box-type: 0x" + Integer.toHexString(i));
                                if (!z) {
                                }
                                break;
                        }
                    }
                    if (this.codeStreamPos.size() == 0) {
                        throw new Error("Invalid JP2 file: Contiguous codestream box missing");
                    }
                    return;
                }
                this.in.seek(0);
                if (this.in.readShort() != -177) {
                    throw new Error("File is neither valid JP2 file nor valid JPEG 2000 codestream");
                }
                this.JP2FFUsed = false;
                this.in.seek(0);
            } catch (EOFException unused) {
                throw new Error("EOF reached before finding Contiguous Codestream Box");
            }
        } catch (EOFException unused2) {
        }
    }

    public boolean readFileTypeBox() throws IOException {
        this.in.getPos();
        int i = this.in.readInt();
        if (i == 0) {
            throw new Error("Zero-length of Profile Box");
        }
        if (this.in.readInt() != 1718909296) {
            return false;
        }
        if (i == 1) {
            this.in.readLong();
            throw new IOException("File too long.");
        }
        this.in.readInt();
        this.in.readInt();
        boolean z = false;
        for (int i2 = (i - 16) / 4; i2 > 0; i2--) {
            if (this.in.readInt() == 1785737760) {
                z = true;
            }
        }
        return z;
    }

    public boolean readJP2HeaderBox(long j, int i, long j2) throws IOException {
        if (i != 0) {
            return true;
        }
        throw new Error("Zero-length of JP2Header Box");
    }

    public boolean readContiguousCodeStreamBox(long j, int i, long j2) throws IOException {
        int pos = this.in.getPos();
        if (this.codeStreamPos == null) {
            this.codeStreamPos = new Vector();
        }
        this.codeStreamPos.addElement(new Integer(pos));
        if (this.codeStreamLength == null) {
            this.codeStreamLength = new Vector();
        }
        this.codeStreamLength.addElement(new Integer(i));
        return true;
    }

    public long[] getCodeStreamPos() {
        int size = this.codeStreamPos.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Integer) this.codeStreamPos.elementAt(i)).longValue();
        }
        return jArr;
    }

    public int getFirstCodeStreamPos() {
        return ((Integer) this.codeStreamPos.elementAt(0)).intValue();
    }

    public int getFirstCodeStreamLength() {
        return ((Integer) this.codeStreamLength.elementAt(0)).intValue();
    }
}
