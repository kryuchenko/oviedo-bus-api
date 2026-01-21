package icc;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;
import colorspace.ColorSpaceMapper;
import icc.lut.MatrixBasedTransformException;
import icc.lut.MatrixBasedTransformTosRGB;
import icc.lut.MonochromeTransformException;
import icc.lut.MonochromeTransformTosRGB;
import java.io.IOException;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.DataBlk;
import jj2000.j2k.image.DataBlkFloat;
import jj2000.j2k.image.DataBlkInt;
import jj2000.j2k.util.FacilityManager;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class ICCProfiler extends ColorSpaceMapper {
    private static final int BLUE = 2;
    private static final int GRAY = 0;
    private static final int GREEN = 1;
    public static final char OPT_PREFIX = 'I';
    private static final int RED = 0;
    protected static final String eol = System.getProperty("line.separator");

    /* renamed from: icc, reason: collision with root package name */
    ICCProfile f4icc;
    private RestrictedICCProfile iccp;
    RestrictedICCProfile ricc;
    private DataBlkFloat[] tempFloat;
    private DataBlkInt[] tempInt;
    private Object xform;

    public static BlkImgDataSrc createInstance(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException, ICCProfileException {
        return new ICCProfiler(blkImgDataSrc, colorSpace);
    }

    protected ICCProfiler(BlkImgDataSrc blkImgDataSrc, ColorSpace colorSpace) throws ColorSpaceException, IOException, ICCProfileException, IllegalArgumentException {
        super(blkImgDataSrc, colorSpace);
        this.ricc = null;
        this.f4icc = null;
        this.xform = null;
        this.iccp = null;
        initialize();
        this.iccp = getICCProfile(colorSpace);
        if (this.ncomps == 1) {
            this.xform = new MonochromeTransformTosRGB(this.iccp, this.maxValueArray[0], this.shiftValueArray[0]);
        } else {
            this.xform = new MatrixBasedTransformTosRGB(this.iccp, this.maxValueArray, this.shiftValueArray);
        }
    }

    private void initialize() {
        this.tempInt = new DataBlkInt[this.ncomps];
        this.tempFloat = new DataBlkFloat[this.ncomps];
        for (int i = 0; i < this.ncomps; i++) {
            this.tempInt[i] = new DataBlkInt();
            this.tempFloat[i] = new DataBlkFloat();
        }
    }

    private RestrictedICCProfile getICCProfile(ColorSpace colorSpace) throws ColorSpaceException, ICCProfileException, IllegalArgumentException {
        int i = this.ncomps;
        if (i == 1) {
            ICCMonochromeInputProfile iCCMonochromeInputProfileCreateInstance = ICCMonochromeInputProfile.createInstance(colorSpace);
            this.f4icc = iCCMonochromeInputProfileCreateInstance;
            RestrictedICCProfile restrictedICCProfile = iCCMonochromeInputProfileCreateInstance.parse();
            this.ricc = restrictedICCProfile;
            if (restrictedICCProfile.getType() != 0) {
                throw new IllegalArgumentException("wrong ICCProfile type for image");
            }
        } else if (i == 3) {
            ICCMatrixBasedInputProfile iCCMatrixBasedInputProfileCreateInstance = ICCMatrixBasedInputProfile.createInstance(colorSpace);
            this.f4icc = iCCMatrixBasedInputProfileCreateInstance;
            RestrictedICCProfile restrictedICCProfile2 = iCCMatrixBasedInputProfileCreateInstance.parse();
            this.ricc = restrictedICCProfile2;
            if (restrictedICCProfile2.getType() != 1) {
                throw new IllegalArgumentException("wrong ICCProfile type for image");
            }
        } else {
            throw new IllegalArgumentException("illegal number of components (" + this.ncomps + ") in image");
        }
        return this.ricc;
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getCompData(DataBlk dataBlk, int i) {
        DataBlk dataBlk2;
        int i2 = 3;
        try {
            if (this.ncomps != 1 && this.ncomps != 3) {
                FacilityManager.getMsgLogger().printmsg(2, "ICCProfiler: icc profile _not_ applied to " + this.ncomps + " component image");
                return this.src.getCompData(dataBlk, i);
            }
            int dataType = dataBlk.getDataType();
            int i3 = 0;
            while (i3 < this.ncomps) {
                int fixedPoint = this.src.getFixedPoint(i3);
                int i4 = this.shiftValueArray[i3];
                int i5 = this.maxValueArray[i3];
                if (dataType == i2) {
                    copyGeometry(this.workInt[i3], dataBlk);
                    copyGeometry(this.tempInt[i3], dataBlk);
                    copyGeometry(this.inInt[i3], dataBlk);
                    setInternalBuffer(dataBlk);
                    this.workDataInt[i3] = (int[]) this.workInt[i3].getData();
                    this.inInt[i3] = (DataBlkInt) this.src.getInternCompData(this.inInt[i3], i3);
                    this.dataInt[i3] = this.inInt[i3].getDataInt();
                    for (int i6 = 0; i6 < dataBlk.h; i6++) {
                        int i7 = this.inInt[i3].offset + (this.inInt[i3].scanw * i6);
                        int i8 = this.inInt[i3].w + i7;
                        int i9 = dataBlk.offset + (dataBlk.scanw * i6);
                        int i10 = dataBlk.w;
                        while (i7 < i8) {
                            int i11 = (this.dataInt[i3][i7] >> fixedPoint) + i4;
                            int[] iArr = this.workDataInt[i3];
                            if (i11 < 0) {
                                i11 = 0;
                            } else if (i11 > i5) {
                                i11 = i5;
                            }
                            iArr[i9] = i11;
                            i7++;
                            i9++;
                        }
                    }
                } else {
                    if (dataType != 4) {
                        throw new IllegalArgumentException("Invalid source datablock type");
                    }
                    copyGeometry(this.workFloat[i3], dataBlk);
                    copyGeometry(this.tempFloat[i3], dataBlk);
                    copyGeometry(this.inFloat[i3], dataBlk);
                    setInternalBuffer(dataBlk);
                    dataBlk2 = null;
                    try {
                        this.workDataFloat[i3] = (float[]) this.workFloat[i3].getData();
                        this.inFloat[i3] = (DataBlkFloat) this.src.getInternCompData(this.inFloat[i3], i3);
                        this.dataFloat[i3] = this.inFloat[i3].getDataFloat();
                        for (int i12 = 0; i12 < dataBlk.h; i12++) {
                            int i13 = this.inFloat[i3].offset + (this.inFloat[i3].scanw * i12);
                            int i14 = this.inFloat[i3].w + i13;
                            int i15 = dataBlk.offset + (dataBlk.scanw * i12);
                            int i16 = dataBlk.w;
                            while (i13 < i14) {
                                float f = (this.dataFloat[i3][i13] / (1 << fixedPoint)) + i4;
                                float[] fArr = this.workDataFloat[i3];
                                if (f < 0.0f) {
                                    f = 0.0f;
                                } else {
                                    float f2 = i5;
                                    if (f > f2) {
                                        f = f2;
                                    }
                                }
                                fArr[i15] = f;
                                i13++;
                                i15++;
                            }
                        }
                    } catch (MatrixBasedTransformException e) {
                        e = e;
                        FacilityManager.getMsgLogger().printmsg(3, "matrix transform problem:\n" + e.getMessage());
                        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                            e.printStackTrace();
                        } else {
                            FacilityManager.getMsgLogger().printmsg(3, "Use '-debug' option for more details");
                        }
                        return dataBlk2;
                    } catch (MonochromeTransformException e2) {
                        e = e2;
                        FacilityManager.getMsgLogger().printmsg(3, "monochrome transform problem:\n" + e.getMessage());
                        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                            e.printStackTrace();
                        } else {
                            FacilityManager.getMsgLogger().printmsg(3, "Use '-debug' option for more details");
                        }
                        return dataBlk2;
                    }
                }
                i3++;
                i2 = 3;
            }
            if (dataType == 3) {
                if (this.ncomps == 1) {
                    ((MonochromeTransformTosRGB) this.xform).apply(this.workInt[i], this.tempInt[i]);
                } else {
                    ((MatrixBasedTransformTosRGB) this.xform).apply(this.workInt, this.tempInt);
                }
                dataBlk.progressive = this.inInt[i].progressive;
                dataBlk.setData(this.tempInt[i].getData());
            } else {
                if (dataType != 4) {
                    throw new IllegalArgumentException("invalid source datablock type");
                }
                if (this.ncomps == 1) {
                    ((MonochromeTransformTosRGB) this.xform).apply(this.workFloat[i], this.tempFloat[i]);
                } else {
                    ((MatrixBasedTransformTosRGB) this.xform).apply(this.workFloat, this.tempFloat);
                }
                dataBlk.progressive = this.inFloat[i].progressive;
                dataBlk.setData(this.tempFloat[i].getData());
            }
            dataBlk.offset = 0;
            dataBlk.scanw = dataBlk.w;
            return dataBlk;
        } catch (MatrixBasedTransformException e3) {
            e = e3;
            dataBlk2 = null;
        } catch (MonochromeTransformException e4) {
            e = e4;
            dataBlk2 = null;
        }
    }

    @Override // colorspace.ColorSpaceMapper, jj2000.j2k.image.BlkImgDataSrc
    public DataBlk getInternCompData(DataBlk dataBlk, int i) {
        return getCompData(dataBlk, i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ICCProfiler:");
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.f4icc != null) {
            stringBuffer2.append(eol).append(ColorSpace.indent("  ", this.f4icc.toString()));
        }
        if (this.xform != null) {
            stringBuffer2.append(eol).append(ColorSpace.indent("  ", this.xform.toString()));
        }
        stringBuffer.append(ColorSpace.indent("  ", stringBuffer2));
        return stringBuffer.append("]").toString();
    }
}
