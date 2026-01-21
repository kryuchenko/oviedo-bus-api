package jj2000.j2k.codestream.reader;

import java.io.IOException;
import jj2000.j2k.codestream.HeaderInfo;
import jj2000.j2k.decoder.DecoderSpecs;
import jj2000.j2k.entropy.decoder.CodedCBlkDataSrcDec;
import jj2000.j2k.image.Coord;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.quantization.dequantizer.StdDequantizerParams;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.synthesis.SubbandSyn;

/* loaded from: classes5.dex */
public abstract class BitstreamReaderAgent implements CodedCBlkDataSrcDec {
    public static final char OPT_PREFIX = 'B';
    private static final String[][] pinfo = null;
    protected int anbytes;
    protected float arate;
    protected final int ax;
    protected final int ay;
    protected int ctX;
    protected int ctY;
    protected final int[] culx;
    protected final int[] culy;
    protected DecoderSpecs decSpec;
    protected final HeaderDecoder hd;
    protected final int imgH;
    protected final int imgW;
    protected int[] mdl;
    protected final int nc;
    protected final int nt;
    protected final int ntH;
    protected final int ntW;
    protected final int ntX;
    protected final int ntY;
    protected final int[] offX;
    protected final int[] offY;
    protected final int px;
    protected final int py;
    protected SubbandSyn[] subbTrees;
    protected int targetRes;
    protected int tnbytes;
    protected float trate;
    protected boolean[] derived = null;
    protected int[] gb = null;
    protected StdDequantizerParams[] params = null;

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public abstract void nextTile();

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public abstract void setTile(int i, int i2);

    static {
    }

    protected BitstreamReaderAgent(HeaderDecoder headerDecoder, DecoderSpecs decoderSpecs) {
        this.decSpec = decoderSpecs;
        this.hd = headerDecoder;
        int numComps = headerDecoder.getNumComps();
        this.nc = numComps;
        this.offX = new int[numComps];
        this.offY = new int[numComps];
        this.culx = new int[numComps];
        this.culy = new int[numComps];
        this.imgW = headerDecoder.getImgWidth();
        this.imgH = headerDecoder.getImgHeight();
        this.ax = headerDecoder.getImgULX();
        this.ay = headerDecoder.getImgULY();
        Coord tilingOrigin = headerDecoder.getTilingOrigin(null);
        this.px = tilingOrigin.x;
        this.py = tilingOrigin.y;
        int nomTileWidth = headerDecoder.getNomTileWidth();
        this.ntW = nomTileWidth;
        int nomTileHeight = headerDecoder.getNomTileHeight();
        this.ntH = nomTileHeight;
        int i = ((((r2 + r8) - r4) + nomTileWidth) - 1) / nomTileWidth;
        this.ntX = i;
        int i2 = ((((r3 + r1) - r0) + nomTileHeight) - 1) / nomTileHeight;
        this.ntY = i2;
        this.nt = i * i2;
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public final int getCbULX() {
        return this.hd.getCbULX();
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData
    public int getCbULY() {
        return this.hd.getCbULY();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getNumComps() {
        return this.nc;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getCompSubsX(int i) {
        return this.hd.getCompSubsX(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getCompSubsY(int i) {
        return this.hd.getCompSubsY(i);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileWidth(int i) {
        int minInTile = this.decSpec.dls.getMinInTile(getTileIdx());
        if (i > minInTile) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one component in tile: " + this.ctX + "x" + this.ctY);
        }
        int i2 = minInTile - i;
        int i3 = this.ctX;
        int i4 = i3 == 0 ? this.ax : this.px + (this.ntW * i3);
        int i5 = i3 < this.ntX - 1 ? this.px + ((i3 + 1) * this.ntW) : this.imgW + this.ax;
        int i6 = 1 << i2;
        return (((i5 + i6) - 1) / i6) - (((i4 + i6) - 1) / i6);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTileHeight(int i) {
        int minInTile = this.decSpec.dls.getMinInTile(getTileIdx());
        if (i > minInTile) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one component in tile: " + this.ctX + "x" + this.ctY);
        }
        int i2 = minInTile - i;
        int i3 = this.ctY;
        int i4 = i3 == 0 ? this.ay : this.py + (this.ntH * i3);
        int i5 = i3 < this.ntY - 1 ? this.py + ((i3 + 1) * this.ntH) : this.imgH + this.ay;
        int i6 = 1 << i2;
        return (((i5 + i6) - 1) / i6) - (((i4 + i6) - 1) / i6);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgWidth(int i) {
        int min = this.decSpec.dls.getMin();
        if (i > min) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        int i2 = min - i;
        int i3 = this.ax;
        int i4 = 1 << i2;
        return ((((this.imgW + i3) + i4) - 1) / i4) - (((i3 + i4) - 1) / i4);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgHeight(int i) {
        int min = this.decSpec.dls.getMin();
        if (i > min) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        int i2 = min - i;
        int i3 = this.ay;
        int i4 = 1 << i2;
        return ((((this.imgH + i3) + i4) - 1) / i4) - (((i3 + i4) - 1) / i4);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgULX(int i) {
        int min = this.decSpec.dls.getMin();
        if (i > min) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        int i2 = 1 << (min - i);
        return ((this.ax + i2) - 1) / i2;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getImgULY(int i) {
        int min = this.decSpec.dls.getMin();
        if (i > min) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one tile-component");
        }
        int i2 = 1 << (min - i);
        return ((this.ay + i2) - 1) / i2;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getTileCompWidth(int i, int i2, int i3) {
        int i4;
        if (i != getTileIdx()) {
            throw new Error("Asking the tile-component width of a tile different  from the current one.");
        }
        int i5 = this.mdl[i2] - i3;
        int i6 = this.ctX;
        if (i6 < this.ntX - 1) {
            i4 = this.px + ((i6 + 1) * this.ntW);
        } else {
            i4 = this.imgW + this.ax;
        }
        int i7 = 1 << i5;
        return ((((((i4 + this.hd.getCompSubsX(i2)) - 1) / this.hd.getCompSubsX(i2)) + i7) - 1) / i7) - (((this.culx[i2] + i7) - 1) / i7);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getTileCompHeight(int i, int i2, int i3) {
        int i4;
        if (i != getTileIdx()) {
            throw new Error("Asking the tile-component width of a tile different  from the current one.");
        }
        int i5 = this.mdl[i2] - i3;
        int i6 = this.ctY;
        if (i6 < this.ntY - 1) {
            i4 = this.py + ((i6 + 1) * this.ntH);
        } else {
            i4 = this.imgH + this.ay;
        }
        int i7 = 1 << i5;
        return ((((((i4 + this.hd.getCompSubsY(i2)) - 1) / this.hd.getCompSubsY(i2)) + i7) - 1) / i7) - (((this.culy[i2] + i7) - 1) / i7);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getCompImgWidth(int i, int i2) {
        int minInComp = this.decSpec.dls.getMinInComp(i) - i2;
        int compSubsX = ((this.ax + this.hd.getCompSubsX(i)) - 1) / this.hd.getCompSubsX(i);
        int compSubsX2 = (((this.ax + this.imgW) + this.hd.getCompSubsX(i)) - 1) / this.hd.getCompSubsX(i);
        int i3 = 1 << minInComp;
        return (((compSubsX2 + i3) - 1) / i3) - (((compSubsX + i3) - 1) / i3);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getCompImgHeight(int i, int i2) {
        int minInComp = this.decSpec.dls.getMinInComp(i) - i2;
        int compSubsY = ((this.ay + this.hd.getCompSubsY(i)) - 1) / this.hd.getCompSubsY(i);
        int compSubsY2 = (((this.ay + this.imgH) + this.hd.getCompSubsY(i)) - 1) / this.hd.getCompSubsY(i);
        int i3 = 1 << minInComp;
        return (((compSubsY2 + i3) - 1) / i3) - (((compSubsY + i3) - 1) / i3);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final Coord getTile(Coord coord) {
        if (coord != null) {
            coord.x = this.ctX;
            coord.y = this.ctY;
            return coord;
        }
        return new Coord(this.ctX, this.ctY);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getTileIdx() {
        return (this.ctY * this.ntX) + this.ctX;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getResULX(int i, int i2) {
        if (this.mdl[i] - i2 < 0) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one component in tile: " + this.ctX + "x" + this.ctY);
        }
        return (int) Math.ceil(((int) Math.ceil(Math.max(this.px + (this.ctX * this.ntW), this.ax) / getCompSubsX(i))) / (1 << r0));
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getResULY(int i, int i2) {
        if (this.mdl[i] - i2 < 0) {
            throw new IllegalArgumentException("Requested resolution level is not available for, at least, one component in tile: " + this.ctX + "x" + this.ctY);
        }
        return (int) Math.ceil(((int) Math.ceil(Math.max(this.py + (this.ctY * this.ntH), this.ay) / getCompSubsY(i))) / (1 << r0));
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final Coord getNumTiles(Coord coord) {
        if (coord != null) {
            coord.x = this.ntX;
            coord.y = this.ntY;
            return coord;
        }
        return new Coord(this.ntX, this.ntY);
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final int getNumTiles() {
        return this.ntX * this.ntY;
    }

    @Override // jj2000.j2k.wavelet.synthesis.InvWTData, jj2000.j2k.wavelet.synthesis.MultiResImgData
    public final SubbandSyn getSynSubbandTree(int i, int i2) {
        if (i != getTileIdx()) {
            throw new IllegalArgumentException("Can not request subband tree of a different tile than the current one");
        }
        if (i2 < 0 || i2 >= this.nc) {
            throw new IllegalArgumentException("Component index out of range");
        }
        return this.subbTrees[i2];
    }

    public static BitstreamReaderAgent createInstance(RandomAccessIO randomAccessIO, HeaderDecoder headerDecoder, ParameterList parameterList, DecoderSpecs decoderSpecs, boolean z, HeaderInfo headerInfo) throws IOException {
        parameterList.checkList(OPT_PREFIX, ParameterList.toNameArray(getParameterInfo()));
        return new FileBitstreamReaderAgent(headerDecoder, randomAccessIO, decoderSpecs, parameterList, z, headerInfo);
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public final int getPPX(int i, int i2, int i3) {
        return this.decSpec.pss.getPPX(i, i2, i3);
    }

    public final int getPPY(int i, int i2, int i3) {
        return this.decSpec.pss.getPPY(i, i2, i3);
    }

    protected void initSubbandsFields(int i, SubbandSyn subbandSyn) {
        int tileIdx = getTileIdx();
        int i2 = subbandSyn.resLvl;
        int cBlkWidth = this.decSpec.cblks.getCBlkWidth((byte) 3, tileIdx, i);
        int cBlkHeight = this.decSpec.cblks.getCBlkHeight((byte) 3, tileIdx, i);
        if (!subbandSyn.isNode) {
            if (this.hd.precinctPartitionUsed()) {
                int iLog2 = MathUtil.log2(getPPX(tileIdx, i, i2));
                int iLog22 = MathUtil.log2(getPPY(tileIdx, i, i2));
                int iLog23 = MathUtil.log2(cBlkWidth);
                int iLog24 = MathUtil.log2(cBlkHeight);
                if (subbandSyn.resLvl == 0) {
                    subbandSyn.nomCBlkW = iLog23 < iLog2 ? 1 << iLog23 : 1 << iLog2;
                    subbandSyn.nomCBlkH = iLog24 < iLog22 ? 1 << iLog24 : 1 << iLog22;
                } else {
                    int i3 = iLog2 - 1;
                    subbandSyn.nomCBlkW = iLog23 < i3 ? 1 << iLog23 : 1 << i3;
                    int i4 = iLog22 - 1;
                    subbandSyn.nomCBlkH = iLog24 < i4 ? 1 << iLog24 : 1 << i4;
                }
            } else {
                subbandSyn.nomCBlkW = cBlkWidth;
                subbandSyn.nomCBlkH = cBlkHeight;
            }
            if (subbandSyn.numCb == null) {
                subbandSyn.numCb = new Coord();
            }
            if (subbandSyn.w == 0 || subbandSyn.h == 0) {
                subbandSyn.numCb.x = 0;
                subbandSyn.numCb.y = 0;
            } else {
                int cbULX = getCbULX();
                int cbULY = getCbULY();
                int i5 = subbandSyn.sbandIdx;
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new Error("Internal JJ2000 error");
                            }
                            cbULX = 0;
                        }
                        cbULY = 0;
                    } else {
                        cbULX = 0;
                    }
                }
                if (subbandSyn.ulcx - cbULX < 0 || subbandSyn.ulcy - cbULY < 0) {
                    throw new IllegalArgumentException("Invalid code-blocks partition origin or image offset in the reference grid.");
                }
                int i6 = (subbandSyn.ulcx - cbULX) + subbandSyn.nomCBlkW;
                subbandSyn.numCb.x = (((subbandSyn.w + i6) - 1) / subbandSyn.nomCBlkW) - ((i6 / subbandSyn.nomCBlkW) - 1);
                int i7 = (subbandSyn.ulcy - cbULY) + subbandSyn.nomCBlkH;
                subbandSyn.numCb.y = (((subbandSyn.h + i7) - 1) / subbandSyn.nomCBlkH) - ((i7 / subbandSyn.nomCBlkH) - 1);
            }
            if (this.derived[i]) {
                subbandSyn.magbits = (this.gb[i] + (this.params[i].exp[0][0] - (this.mdl[i] - subbandSyn.level))) - 1;
                return;
            } else {
                subbandSyn.magbits = (this.gb[i] + this.params[i].exp[subbandSyn.resLvl][subbandSyn.sbandIdx]) - 1;
                return;
            }
        }
        initSubbandsFields(i, (SubbandSyn) subbandSyn.getLL());
        initSubbandsFields(i, (SubbandSyn) subbandSyn.getHL());
        initSubbandsFields(i, (SubbandSyn) subbandSyn.getLH());
        initSubbandsFields(i, (SubbandSyn) subbandSyn.getHH());
    }

    public int getImgRes() {
        return this.targetRes;
    }

    public float getTargetRate() {
        return this.trate;
    }

    public float getActualRate() {
        float maxCompImgWidth = ((this.anbytes * 8.0f) / this.hd.getMaxCompImgWidth()) / this.hd.getMaxCompImgHeight();
        this.arate = maxCompImgWidth;
        return maxCompImgWidth;
    }

    public int getTargetNbytes() {
        return this.tnbytes;
    }

    public int getActualNbytes() {
        return this.anbytes;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTilePartULX() {
        return this.hd.getTilingOrigin(null).x;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getTilePartULY() {
        return this.hd.getTilingOrigin(null).y;
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNomTileWidth() {
        return this.hd.getNomTileWidth();
    }

    @Override // jj2000.j2k.wavelet.synthesis.MultiResImgData
    public int getNomTileHeight() {
        return this.hd.getNomTileHeight();
    }
}
