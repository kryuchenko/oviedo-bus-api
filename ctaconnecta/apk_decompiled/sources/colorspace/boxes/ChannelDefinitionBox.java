package colorspace.boxes;

import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class ChannelDefinitionBox extends JP2Box {
    private Hashtable definitions;
    private int ndefs;

    static {
        type = FileFormatBoxes.CHANNEL_DEFINITION_BOX;
    }

    public ChannelDefinitionBox(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        super(randomAccessIO, i);
        this.definitions = new Hashtable();
        readBox();
    }

    private void readBox() throws IOException {
        byte[] bArr = new byte[8];
        this.in.seek(this.dataStart);
        this.in.readFully(bArr, 0, 2);
        this.ndefs = ICCProfile.getShort(bArr, 0) & UShort.MAX_VALUE;
        this.in.seek(this.dataStart + 2);
        for (int i = 0; i < this.ndefs; i++) {
            this.in.readFully(bArr, 0, 6);
            ICCProfile.getShort(bArr, 0);
            int[] iArr = {getCn(bArr), getTyp(bArr), getAsoc(bArr)};
            this.definitions.put(new Integer(iArr[0]), iArr);
        }
    }

    public int getNDefs() {
        return this.ndefs;
    }

    public int getCn(int i) {
        Enumeration enumerationKeys = this.definitions.keys();
        while (enumerationKeys.hasMoreElements()) {
            int[] iArr = (int[]) this.definitions.get(enumerationKeys.nextElement());
            if (i == getAsoc(iArr)) {
                return getCn(iArr);
            }
        }
        return i;
    }

    public int getTyp(int i) {
        return getTyp((int[]) this.definitions.get(new Integer(i)));
    }

    public int getAsoc(int i) {
        return getAsoc((int[]) this.definitions.get(new Integer(i)));
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[ChannelDefinitionBox ").append(eol).append("  ndefs= ");
        stringBufferAppend.append(String.valueOf(this.ndefs));
        Enumeration enumerationKeys = this.definitions.keys();
        while (enumerationKeys.hasMoreElements()) {
            int[] iArr = (int[]) this.definitions.get(enumerationKeys.nextElement());
            stringBufferAppend.append(eol).append("  Cn= ").append(String.valueOf(getCn(iArr))).append(", Typ= ").append(String.valueOf(getTyp(iArr))).append(", Asoc= ").append(String.valueOf(getAsoc(iArr)));
        }
        stringBufferAppend.append("]");
        return stringBufferAppend.toString();
    }

    private int getCn(byte[] bArr) {
        return ICCProfile.getShort(bArr, 0);
    }

    private int getTyp(byte[] bArr) {
        return ICCProfile.getShort(bArr, 2);
    }

    private int getAsoc(byte[] bArr) {
        return ICCProfile.getShort(bArr, 4);
    }

    private int getCn(int[] iArr) {
        return iArr[0];
    }

    private int getTyp(int[] iArr) {
        return iArr[1];
    }

    private int getAsoc(int[] iArr) {
        return iArr[2];
    }
}
