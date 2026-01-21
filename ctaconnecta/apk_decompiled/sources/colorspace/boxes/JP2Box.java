package colorspace.boxes;

import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import java.util.Hashtable;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;

/* loaded from: classes.dex */
public abstract class JP2Box {
    public static final String eol = System.getProperty("line.separator");
    public static int type;
    protected int boxEnd;
    protected int boxStart;
    protected int dataStart;
    protected RandomAccessIO in;
    public int length;

    public static String getTypeString(int i) {
        return BoxType.get(i);
    }

    public JP2Box() throws ColorSpaceException {
        try {
            throw new ColorSpaceException("JP2Box empty ctor called!!");
        } catch (ColorSpaceException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public JP2Box(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        byte[] bArr = new byte[16];
        this.in = randomAccessIO;
        this.boxStart = i;
        randomAccessIO.seek(i);
        this.in.readFully(bArr, 0, 8);
        this.dataStart = i + 8;
        int i2 = ICCProfile.getInt(bArr, 0);
        this.length = i2;
        this.boxEnd = i + i2;
        if (i2 == 1) {
            throw new ColorSpaceException("extended length boxes not supported");
        }
    }

    public String getTypeString() {
        return BoxType.get(type);
    }

    protected static class BoxType extends Hashtable {
        private static Hashtable map = new Hashtable();

        protected BoxType() {
        }

        static {
            put(FileFormatBoxes.BITS_PER_COMPONENT_BOX, "BITS_PER_COMPONENT_BOX");
            put(FileFormatBoxes.CAPTURE_RESOLUTION_BOX, "CAPTURE_RESOLUTION_BOX");
            put(FileFormatBoxes.CHANNEL_DEFINITION_BOX, "CHANNEL_DEFINITION_BOX");
            put(FileFormatBoxes.COLOUR_SPECIFICATION_BOX, "COLOUR_SPECIFICATION_BOX");
            put(FileFormatBoxes.COMPONENT_MAPPING_BOX, "COMPONENT_MAPPING_BOX");
            put(FileFormatBoxes.CONTIGUOUS_CODESTREAM_BOX, "CONTIGUOUS_CODESTREAM_BOX");
            put(FileFormatBoxes.DEFAULT_DISPLAY_RESOLUTION_BOX, "DEFAULT_DISPLAY_RESOLUTION_BOX");
            put(FileFormatBoxes.FILE_TYPE_BOX, "FILE_TYPE_BOX");
            put(FileFormatBoxes.IMAGE_HEADER_BOX, "IMAGE_HEADER_BOX");
            put(FileFormatBoxes.INTELLECTUAL_PROPERTY_BOX, "INTELLECTUAL_PROPERTY_BOX");
            put(FileFormatBoxes.JP2_HEADER_BOX, "JP2_HEADER_BOX");
            put(FileFormatBoxes.JP2_SIGNATURE_BOX, "JP2_SIGNATURE_BOX");
            put(FileFormatBoxes.PALETTE_BOX, "PALETTE_BOX");
            put(FileFormatBoxes.RESOLUTION_BOX, "RESOLUTION_BOX");
            put(FileFormatBoxes.URL_BOX, "URL_BOX");
            put(FileFormatBoxes.UUID_BOX, "UUID_BOX");
            put(FileFormatBoxes.UUID_INFO_BOX, "UUID_INFO_BOX");
            put(FileFormatBoxes.UUID_LIST_BOX, "UUID_LIST_BOX");
            put(FileFormatBoxes.XML_BOX, "XML_BOX");
        }

        private static void put(int i, String str) {
            map.put(new Integer(i), str);
        }

        public static String get(int i) {
            return (String) map.get(new Integer(i));
        }
    }
}
