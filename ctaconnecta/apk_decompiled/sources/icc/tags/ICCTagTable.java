package icc.tags;

import colorspace.ColorSpace;
import icc.ICCProfile;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes5.dex */
public class ICCTagTable extends Hashtable {
    private static final String eol = System.getProperty("line.separator");
    private static final int offTagCount = 128;
    private static final int offTags = 132;
    private int tagCount;
    private final Vector trios = new Vector();

    private static class Triplet {
        public static final int size = 12;
        private int count;
        private int offset;
        private int signature;

        Triplet(int i, int i2, int i3) {
            this.signature = i;
            this.offset = i2;
            this.count = i3;
        }
    }

    @Override // java.util.Hashtable
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ICCTagTable containing " + this.tagCount + " tags:");
        StringBuffer stringBuffer2 = new StringBuffer("  ");
        Enumeration enumerationKeys = keys();
        while (enumerationKeys.hasMoreElements()) {
            stringBuffer2.append(eol).append(((ICCTag) get((Integer) enumerationKeys.nextElement())).toString());
        }
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }

    public static ICCTagTable createInstance(byte[] bArr) {
        return new ICCTagTable(bArr);
    }

    protected ICCTagTable(byte[] bArr) {
        this.tagCount = ICCProfile.getInt(bArr, 128);
        int i = 132;
        for (int i2 = 0; i2 < this.tagCount; i2++) {
            this.trios.addElement(new Triplet(ICCProfile.getInt(bArr, i), ICCProfile.getInt(bArr, i + 4), ICCProfile.getInt(bArr, i + 8)));
            i += 12;
        }
        Enumeration enumerationElements = this.trios.elements();
        while (enumerationElements.hasMoreElements()) {
            Triplet triplet = (Triplet) enumerationElements.nextElement();
            ICCTag iCCTagCreateInstance = ICCTag.createInstance(triplet.signature, bArr, triplet.offset, triplet.count);
            put(new Integer(iCCTagCreateInstance.signature), iCCTagCreateInstance);
        }
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        int size = this.trios.size();
        int i = 132;
        int i2 = (size * 12) + 132;
        randomAccessFile.seek(128);
        randomAccessFile.writeInt(size);
        Enumeration enumerationElements = this.trios.elements();
        while (enumerationElements.hasMoreElements()) {
            ICCTag iCCTag = (ICCTag) get(new Integer(((Triplet) enumerationElements.nextElement()).signature));
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(iCCTag.signature);
            randomAccessFile.writeInt(i2);
            randomAccessFile.writeInt(iCCTag.count);
            i += 36;
            randomAccessFile.seek(i2);
            randomAccessFile.write(iCCTag.data, iCCTag.offset, iCCTag.count);
            i2 += iCCTag.count;
        }
    }
}
