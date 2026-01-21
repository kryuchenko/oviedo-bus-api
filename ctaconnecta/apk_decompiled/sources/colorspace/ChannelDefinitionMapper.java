package colorspace;

import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;

/* loaded from: classes.dex */
public class ChannelDefinitionMapper extends ColorSpaceMapper {
    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        return new ChannelDefinitionMapper(blkImgDataSrc, colorSpace);
    }

    protected ChannelDefinitionMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc, colorSpace);
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return this.src.getCompData(dataBlk, this.csMap.getChannelDefinition(i));
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return this.src.getInternCompData(dataBlk, this.csMap.getChannelDefinition(i));
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getNomRangeBits(int i) {
        return this.src.getNomRangeBits(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgHeight(int i) {
        return this.src.getCompImgHeight(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompImgWidth(int i) {
        return this.src.getCompImgWidth(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsX(int i) {
        return this.src.getCompSubsX(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompSubsY(int i) {
        return this.src.getCompSubsY(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompULX(int i) {
        return this.src.getCompULX(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getCompULY(int i) {
        return this.src.getCompULY(this.csMap.getChannelDefinition(i));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompHeight(int i, int i2) {
        return this.src.getTileCompHeight(i, this.csMap.getChannelDefinition(i2));
    }

    @Override // jj2000.j2k.image.ImgDataAdapter, jj2000.j2k.image.ImgData
    public int getTileCompWidth(int i, int i2) {
        return this.src.getTileCompWidth(i, this.csMap.getChannelDefinition(i2));
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[ChannelDefinitionMapper nchannels= ").append(this.ncomps);
        for (int i = 0; i < this.ncomps; i++) {
            stringBufferAppend.append(eol).append("  component[").append(i).append("] mapped to channel[").append(this.csMap.getChannelDefinition(i)).append("]");
        }
        return stringBufferAppend.append("]").toString();
    }
}
