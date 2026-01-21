package colorspace.boxes;

import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class ComponentMappingBox extends JP2Box {
    private Vector map;
    private int nChannels;

    static {
        type = FileFormatBoxes.COMPONENT_MAPPING_BOX;
    }

    public ComponentMappingBox(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        super(randomAccessIO, i);
        this.map = new Vector();
        readBox();
    }

    void readBox() throws IOException {
        this.nChannels = (this.boxEnd - this.dataStart) / 4;
        this.in.seek(this.dataStart);
        for (int i = this.dataStart; i < this.boxEnd; i += 4) {
            byte[] bArr = new byte[4];
            this.in.readFully(bArr, 0, 4);
            this.map.addElement(bArr);
        }
    }

    public int getNChannels() {
        return this.nChannels;
    }

    public int getCMP(int i) {
        return ICCProfile.getShort((byte[]) this.map.elementAt(i), 0) & UShort.MAX_VALUE;
    }

    public short getMTYP(int i) {
        return (short) (((byte[]) this.map.elementAt(i))[2] & 255);
    }

    public short getPCOL(int i) {
        return (short) (((byte[]) this.map.elementAt(i))[3] & 255);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ComponentMappingBox   nChannels= ");
        stringBuffer.append(String.valueOf(this.nChannels));
        Enumeration enumerationElements = this.map.elements();
        while (enumerationElements.hasMoreElements()) {
            byte[] bArr = (byte[]) enumerationElements.nextElement();
            stringBuffer.append(eol).append("  CMP= ").append(String.valueOf(getCMP(bArr))).append(", MTYP= ");
            stringBuffer.append(String.valueOf((int) getMTYP(bArr))).append(", PCOL= ");
            stringBuffer.append(String.valueOf((int) getPCOL(bArr)));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private int getCMP(byte[] bArr) {
        return ICCProfile.getShort(bArr, 0) & UShort.MAX_VALUE;
    }

    private short getMTYP(byte[] bArr) {
        return (short) (bArr[2] & 255);
    }

    private short getPCOL(byte[] bArr) {
        return (short) (bArr[3] & 255);
    }
}
