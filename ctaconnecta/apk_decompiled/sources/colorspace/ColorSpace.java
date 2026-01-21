package colorspace;

import colorspace.boxes.ChannelDefinitionBox;
import colorspace.boxes.ColorSpecificationBox;
import colorspace.boxes.ComponentMappingBox;
import colorspace.boxes.ImageHeaderBox;
import colorspace.boxes.PaletteBox;
import icc.ICCProfile;
import java.io.IOException;
import jj2000.j2k.codestream.reader.HeaderDecoder;
import jj2000.j2k.fileformat.FileFormatBoxes;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.util.ParameterList;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public class ColorSpace {
    static final int BLUE = 3;
    static final int GRAY = 0;
    static final int GREEN = 2;
    static final int RED = 1;
    public HeaderDecoder hd;
    private RandomAccessIO in;
    public ParameterList pl;
    public static final String eol = System.getProperty("line.separator");
    public static final MethodEnum ICC_PROFILED = new MethodEnum("profiled");
    public static final MethodEnum ENUMERATED = new MethodEnum("enumerated");
    public static final CSEnum sRGB = new CSEnum("sRGB");
    public static final CSEnum GreyScale = new CSEnum("GreyScale");
    public static final CSEnum sYCC = new CSEnum("sYCC");
    public static final CSEnum Illegal = new CSEnum("Illegal");
    public static final CSEnum Unknown = new CSEnum("Unknown");
    private PaletteBox pbox = null;
    private ComponentMappingBox cmbox = null;
    private ColorSpecificationBox csbox = null;
    private ChannelDefinitionBox cdbox = null;
    private ImageHeaderBox ihbox = null;

    public byte[] getICCProfile() {
        return this.csbox.getICCProfile();
    }

    public static String indent(String str, StringBuffer stringBuffer) {
        return indent(str, stringBuffer.toString());
    }

    public static String indent(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str2);
        char cCharAt = eol.charAt(0);
        int length = stringBuffer.length();
        while (true) {
            int i = length - 1;
            if (i > 0) {
                if (stringBuffer.charAt(i) == cCharAt) {
                    stringBuffer.insert(length, str);
                }
                length = i;
            } else {
                return str + stringBuffer.toString();
            }
        }
    }

    public ColorSpace(RandomAccessIO randomAccessIO, HeaderDecoder headerDecoder, ParameterList parameterList) throws ColorSpaceException, IOException {
        this.pl = parameterList;
        this.in = randomAccessIO;
        this.hd = headerDecoder;
        getBoxes();
    }

    protected final void getBoxes() throws ColorSpaceException, IOException {
        byte[] bArr = new byte[16];
        int i = 0;
        int i2 = 0;
        while (true) {
            this.in.seek(i);
            this.in.readFully(bArr, 0, 16);
            long j = ICCProfile.getInt(bArr, 0);
            if (j == 1) {
                j = ICCProfile.getLong(bArr, 8);
            }
            int i3 = ICCProfile.getInt(bArr, 4);
            if (i2 == 0 && i3 != 1783636000) {
                throw new ColorSpaceException("first box in image not signature");
            }
            if (i2 == 1 && i3 != 1718909296) {
                throw new ColorSpaceException("second box in image not file");
            }
            if (i3 == 1785737827) {
                throw new ColorSpaceException("header box not found in image");
            }
            if (i3 == 1785737832) {
                long j2 = i + j;
                if (j == 1) {
                    i += 8;
                }
                int i4 = i + 8;
                while (true) {
                    long j3 = i4;
                    if (j3 < j2) {
                        this.in.seek(i4);
                        this.in.readFully(bArr, 0, 16);
                        long j4 = ICCProfile.getInt(bArr, 0);
                        if (j4 == 1) {
                            throw new ColorSpaceException("Extended length boxes not supported");
                        }
                        switch (ICCProfile.getInt(bArr, 4)) {
                            case FileFormatBoxes.CHANNEL_DEFINITION_BOX /* 1667523942 */:
                                this.cdbox = new ChannelDefinitionBox(this.in, i4);
                                break;
                            case FileFormatBoxes.COMPONENT_MAPPING_BOX /* 1668112752 */:
                                this.cmbox = new ComponentMappingBox(this.in, i4);
                                break;
                            case FileFormatBoxes.COLOUR_SPECIFICATION_BOX /* 1668246642 */:
                                this.csbox = new ColorSpecificationBox(this.in, i4);
                                break;
                            case FileFormatBoxes.IMAGE_HEADER_BOX /* 1768449138 */:
                                this.ihbox = new ImageHeaderBox(this.in, i4);
                                break;
                            case FileFormatBoxes.PALETTE_BOX /* 1885564018 */:
                                this.pbox = new PaletteBox(this.in, i4);
                                break;
                        }
                        i4 = (int) (j3 + j4);
                    } else {
                        if (this.ihbox == null) {
                            throw new ColorSpaceException("image header box not found");
                        }
                        PaletteBox paletteBox = this.pbox;
                        if ((paletteBox == null && this.cmbox != null) || (paletteBox != null && this.cmbox == null)) {
                            throw new ColorSpaceException("palette box and component mapping box inconsistency");
                        }
                        return;
                    }
                }
            } else {
                i2++;
                i = (int) (i + j);
            }
        }
    }

    public int getChannelDefinition(int i) {
        ChannelDefinitionBox channelDefinitionBox = this.cdbox;
        return channelDefinitionBox == null ? i : channelDefinitionBox.getCn(i + 1);
    }

    public MethodEnum getMethod() {
        return this.csbox.getMethod();
    }

    public CSEnum getColorSpace() {
        return this.csbox.getColorSpace();
    }

    public PaletteBox getPaletteBox() {
        return this.pbox;
    }

    public int getPaletteChannels() {
        PaletteBox paletteBox = this.pbox;
        if (paletteBox == null) {
            return 0;
        }
        return paletteBox.getNumColumns();
    }

    public int getPaletteChannelBits(int i) {
        PaletteBox paletteBox = this.pbox;
        if (paletteBox == null) {
            return 0;
        }
        return paletteBox.getBitDepth(i);
    }

    public int getPalettizedSample(int i, int i2) {
        PaletteBox paletteBox = this.pbox;
        if (paletteBox == null) {
            return 0;
        }
        return paletteBox.getEntry(i, i2);
    }

    public boolean isPalettized() {
        return this.pbox != null;
    }

    public boolean isOutputSigned(int i) {
        PaletteBox paletteBox = this.pbox;
        return paletteBox != null ? paletteBox.isSigned(i) : this.hd.isOriginalSigned(i);
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[ColorSpace is ").append(this.csbox.getMethodString()).append(isPalettized() ? "  and palettized " : " ").append(getMethod() == ENUMERATED ? this.csbox.getColorSpaceString() : "");
        if (this.ihbox != null) {
            stringBufferAppend.append(eol).append(indent("    ", this.ihbox.toString()));
        }
        if (this.cdbox != null) {
            stringBufferAppend.append(eol).append(indent("    ", this.cdbox.toString()));
        }
        if (this.csbox != null) {
            stringBufferAppend.append(eol).append(indent("    ", this.csbox.toString()));
        }
        if (this.pbox != null) {
            stringBufferAppend.append(eol).append(indent("    ", this.pbox.toString()));
        }
        if (this.cmbox != null) {
            stringBufferAppend.append(eol).append(indent("    ", this.cmbox.toString()));
        }
        return stringBufferAppend.append("]").toString();
    }

    public boolean debugging() {
        return this.pl.getProperty("colorspace_debug") != null && this.pl.getProperty("colorspace_debug").equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON);
    }

    public static class Enumeration {
        public final String value;

        public Enumeration(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public static class MethodEnum extends Enumeration {
        public MethodEnum(String str) {
            super(str);
        }
    }

    public static class CSEnum extends Enumeration {
        public CSEnum(String str) {
            super(str);
        }
    }
}
