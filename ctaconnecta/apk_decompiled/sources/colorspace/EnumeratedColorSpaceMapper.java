package colorspace;

import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;

/* loaded from: classes.dex */
public class EnumeratedColorSpaceMapper extends ColorSpaceMapper {
    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        return new EnumeratedColorSpaceMapper(blkImgDataSrc, colorSpace);
    }

    protected EnumeratedColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc, colorSpace);
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return this.src.getCompData(dataBlk, i);
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return this.src.getInternCompData(dataBlk, i);
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("ncomps= ").append(String.valueOf(this.ncomps));
        StringBuffer stringBuffer = new StringBuffer("fixedPointBits= (");
        StringBuffer stringBuffer2 = new StringBuffer("shiftValue= (");
        StringBuffer stringBuffer3 = new StringBuffer("maxValue= (");
        for (int i = 0; i < this.ncomps; i++) {
            if (i != 0) {
                stringBuffer2.append(", ");
                stringBuffer3.append(", ");
                stringBuffer.append(", ");
            }
            stringBuffer2.append(String.valueOf(this.shiftValueArray[i]));
            stringBuffer3.append(String.valueOf(this.maxValueArray[i]));
            stringBuffer.append(String.valueOf(this.fixedPtBitsArray[i]));
        }
        stringBuffer2.append(")");
        stringBuffer3.append(")");
        stringBuffer.append(")");
        StringBuffer stringBuffer4 = new StringBuffer("[EnumeratedColorSpaceMapper ");
        stringBuffer4.append(stringBufferAppend);
        stringBuffer4.append(eol).append("  ").append(stringBuffer2);
        stringBuffer4.append(eol).append("  ").append(stringBuffer3);
        stringBuffer4.append(eol).append("  ").append(stringBuffer);
        return stringBuffer4.append("]").toString();
    }
}
