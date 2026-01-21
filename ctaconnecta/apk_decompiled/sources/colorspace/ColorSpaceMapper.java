package colorspace;

import colorspace.ColorSpace;
import icc.ICCProfileException;
import icc.ICCProfiler;
import java.io.IOException;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.util.ParameterList;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public abstract class ColorSpaceMapper extends ImgDataAdapter implements BlkImgDataSrc {
    public static final char OPT_PREFIX = 'I';
    protected static final String eol = System.getProperty("line.separator");
    private static final String[][] pinfo = {new String[]{"IcolorSpacedebug", null, "Print debugging messages during colorspace mapping.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}};
    protected ComputedComponents computed;
    protected ColorSpace csMap;
    protected float[][] dataFloat;
    protected int[][] dataInt;
    protected int[] fixedPtBitsArray;
    protected DataBlkFloat[] inFloat;
    protected DataBlkInt[] inInt;
    protected int[] maxValueArray;
    protected int ncomps;
    protected ParameterList pl;
    protected int[] shiftValueArray;
    protected BlkImgDataSrc src;
    protected DataBlk[] srcBlk;
    protected float[][] workDataFloat;
    protected int[][] workDataInt;
    protected DataBlkFloat[] workFloat;
    protected DataBlkInt[] workInt;

    protected class ComputedComponents {
        private int tIdx = -1;
        private int h = -1;
        private int w = -1;
        private int ulx = -1;
        private int uly = -1;
        private int offset = -1;
        private int scanw = -1;

        public ComputedComponents() {
            clear();
        }

        public ComputedComponents(DataBlk dataBlk) {
            set(dataBlk);
        }

        public void set(DataBlk dataBlk) {
            this.h = dataBlk.h;
            this.w = dataBlk.w;
            this.ulx = dataBlk.ulx;
            this.uly = dataBlk.uly;
            this.offset = dataBlk.offset;
            this.scanw = dataBlk.scanw;
        }

        public void clear() {
            this.scanw = -1;
            this.offset = -1;
            this.uly = -1;
            this.ulx = -1;
            this.w = -1;
            this.h = -1;
        }

        public boolean equals(ComputedComponents computedComponents) {
            return this.h == computedComponents.h && this.w == computedComponents.w && this.ulx == computedComponents.ulx && this.uly == computedComponents.uly && this.offset == computedComponents.offset && this.scanw == computedComponents.scanw;
        }
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    protected static void setInternalBuffer(DataBlk dataBlk) {
        int dataType = dataBlk.getDataType();
        if (dataType == 3) {
            if (dataBlk.getData() == null || ((int[]) dataBlk.getData()).length < dataBlk.w * dataBlk.h) {
                dataBlk.setData(new int[dataBlk.w * dataBlk.h]);
                return;
            }
            return;
        }
        if (dataType == 4) {
            if (dataBlk.getData() == null || ((float[]) dataBlk.getData()).length < dataBlk.w * dataBlk.h) {
                dataBlk.setData(new float[dataBlk.w * dataBlk.h]);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid output datablock type");
    }

    protected static void copyGeometry(DataBlk dataBlk, DataBlk dataBlk2) {
        dataBlk.offset = 0;
        dataBlk.h = dataBlk2.h;
        dataBlk.w = dataBlk2.w;
        dataBlk.ulx = dataBlk2.ulx;
        dataBlk.uly = dataBlk2.uly;
        dataBlk.scanw = dataBlk2.w;
        setInternalBuffer(dataBlk);
    }

    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException, ICCProfileException {
        ParameterList parameterList = colorSpace.pl;
        ParameterList parameterList2 = colorSpace.pl;
        parameterList.checkList('I', ParameterList.toNameArray(pinfo));
        if (colorSpace.getMethod() == ColorSpace.ICC_PROFILED) {
            return ICCProfiler.createInstance(blkImgDataSrc, colorSpace);
        }
        ColorSpace.CSEnum colorSpace2 = colorSpace.getColorSpace();
        if (colorSpace2 == ColorSpace.sRGB) {
            return EnumeratedColorSpaceMapper.createInstance(blkImgDataSrc, colorSpace);
        }
        if (colorSpace2 == ColorSpace.GreyScale) {
            return EnumeratedColorSpaceMapper.createInstance(blkImgDataSrc, colorSpace);
        }
        if (colorSpace2 == ColorSpace.sYCC) {
            return SYccColorSpaceMapper.createInstance(blkImgDataSrc, colorSpace);
        }
        if (colorSpace2 == ColorSpace.Unknown) {
            return null;
        }
        throw new ColorSpaceException("Bad color space specification in image");
    }

    protected ColorSpaceMapper(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException {
        super(blkImgDataSrc);
        this.shiftValueArray = null;
        this.maxValueArray = null;
        this.fixedPtBitsArray = null;
        this.pl = null;
        this.csMap = null;
        this.ncomps = 0;
        this.src = null;
        this.srcBlk = null;
        this.computed = new ComputedComponents();
        this.src = blkImgDataSrc;
        this.csMap = colorSpace;
        initialize();
    }

    private void initialize() throws ColorSpaceException {
        this.pl = this.csMap.pl;
        int numComps = this.src.getNumComps();
        this.ncomps = numComps;
        this.shiftValueArray = new int[numComps];
        this.maxValueArray = new int[numComps];
        this.fixedPtBitsArray = new int[numComps];
        this.srcBlk = new DataBlk[numComps];
        this.inInt = new DataBlkInt[numComps];
        this.inFloat = new DataBlkFloat[numComps];
        this.workInt = new DataBlkInt[numComps];
        this.workFloat = new DataBlkFloat[numComps];
        this.dataInt = new int[numComps][];
        this.dataFloat = new float[numComps][];
        this.workDataInt = new int[numComps][];
        this.workDataFloat = new float[numComps][];
        this.dataInt = new int[numComps][];
        this.dataFloat = new float[numComps][];
        for (int i = 0; i < this.ncomps; i++) {
            this.shiftValueArray[i] = 1 << (this.src.getNomRangeBits(i) - 1);
            this.maxValueArray[i] = (1 << this.src.getNomRangeBits(i)) - 1;
            this.fixedPtBitsArray[i] = this.src.getFixedPoint(i);
            this.inInt[i] = new DataBlkInt();
            this.inFloat[i] = new DataBlkFloat();
            this.workInt[i] = new DataBlkInt();
            this.workInt[i].progressive = this.inInt[i].progressive;
            this.workFloat[i] = new DataBlkFloat();
            this.workFloat[i].progressive = this.inFloat[i].progressive;
        }
    }

    public int getFixedPoint(int i) {
        return this.src.getFixedPoint(i);
    }

    public DataBlk getCompData(DataBlk dataBlk, int i) {
        return this.src.getCompData(dataBlk, i);
    }

    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return this.src.getInternCompData(dataBlk, i);
    }
}
