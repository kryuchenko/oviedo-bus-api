package jj2000.j2k.image.forwcomptransf;

import java.util.StringTokenizer;
import jj2000.j2k.image.CompTransfSpec;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.FilterTypes;
import jj2000.j2k.wavelet.analysis.AnWTFilter;
import jj2000.j2k.wavelet.analysis.AnWTFilterSpec;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class ForwCompTransfSpec extends CompTransfSpec implements FilterTypes {
    public ForwCompTransfSpec(int i, int i2, byte b, AnWTFilterSpec anWTFilterSpec, ParameterList parameterList) {
        super(i, i2, b);
        String parameter = parameterList.getParameter("Mct");
        int i3 = 0;
        if (parameter == null) {
            if (i2 < 3) {
                setDefault("none");
                return;
            }
            if (parameterList.getBooleanParameter("lossless")) {
                setDefault("rct");
                return;
            }
            int[] iArr = new int[this.nComp];
            for (int i4 = 0; i4 < 3; i4++) {
                iArr[i4] = ((AnWTFilter[][]) anWTFilterSpec.getCompDef(i4))[0][0].getFilterType();
            }
            boolean z = false;
            for (int i5 = 1; i5 < 3; i5++) {
                if (iArr[i5] != iArr[0]) {
                    z = true;
                }
            }
            if (z) {
                setDefault("none");
            } else if (((AnWTFilter[][]) anWTFilterSpec.getCompDef(0))[0][0].getFilterType() == 0) {
                setDefault("ict");
            } else {
                setDefault("rct");
            }
            for (int i6 = 0; i6 < i; i6++) {
                int[] iArr2 = new int[this.nComp];
                for (int i7 = 0; i7 < 3; i7++) {
                    iArr2[i7] = ((AnWTFilter[][]) anWTFilterSpec.getTileCompVal(i6, i7))[0][0].getFilterType();
                }
                boolean z2 = false;
                for (int i8 = 1; i8 < this.nComp; i8++) {
                    if (iArr2[i8] != iArr2[0]) {
                        z2 = true;
                    }
                }
                if (z2) {
                    setTileDef(i6, "none");
                } else if (((AnWTFilter[][]) anWTFilterSpec.getTileCompVal(i6, 0))[0][0].getFilterType() == 0) {
                    setTileDef(i6, "ict");
                } else {
                    setTileDef(i6, "rct");
                }
            }
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        while (true) {
            char c = 0;
            boolean[] idx = null;
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                char cCharAt = strNextToken.charAt(i3);
                if (cCharAt == 'c') {
                    throw new IllegalArgumentException("Component specific  parameters not allowed with '-Mct' option");
                }
                if (cCharAt == 't') {
                    idx = parseIdx(strNextToken, this.nTiles);
                    if (c == 1) {
                        i3 = 0;
                        c = 3;
                    } else {
                        i3 = 0;
                        c = 2;
                    }
                } else {
                    if (!strNextToken.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        if (!strNextToken.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                            throw new IllegalArgumentException("Default parameter of option Mct not recognized: " + parameter);
                        }
                        if (i2 < 3) {
                            throw new IllegalArgumentException("Cannot use component transformation on a image with less than three components");
                        }
                        if (c == 0) {
                            setDefault("rct");
                        } else if (c == 2) {
                            for (int length = idx.length - 1; length >= 0; length--) {
                                if (idx[length]) {
                                    if (getFilterType(length, anWTFilterSpec) == 1) {
                                        setTileDef(length, "rct");
                                    } else {
                                        setTileDef(length, "ict");
                                    }
                                }
                            }
                        }
                    } else if (c == 0) {
                        setDefault("none");
                    } else if (c == 2) {
                        for (int length2 = idx.length - 1; length2 >= 0; length2--) {
                            if (idx[length2]) {
                                setTileDef(length2, "none");
                            }
                        }
                    }
                    i3 = 0;
                }
            }
            char c2 = 0;
            if (getDefault() == null) {
                setDefault("none");
                int i9 = 0;
                while (i9 < i) {
                    if (!isTileSpecified(i9)) {
                        int[] iArr3 = new int[this.nComp];
                        for (int i10 = 0; i10 < 3; i10++) {
                            iArr3[i10] = ((AnWTFilter[][]) anWTFilterSpec.getTileCompVal(i9, i10))[c2][c2].getFilterType();
                        }
                        boolean z3 = false;
                        for (int i11 = 1; i11 < this.nComp; i11++) {
                            if (iArr3[i11] != iArr3[c2]) {
                                z3 = true;
                            }
                        }
                        if (z3) {
                            setTileDef(i9, "none");
                        } else if (((AnWTFilter[][]) anWTFilterSpec.getTileCompVal(i9, 0))[0][0].getFilterType() == 0) {
                            setTileDef(i9, "ict");
                        } else {
                            setTileDef(i9, "rct");
                        }
                    }
                    i9++;
                    c2 = 0;
                }
            }
            for (int i12 = i - 1; i12 >= 0; i12--) {
                if (!((String) getTileDef(i12)).equals("none")) {
                    if (((String) getTileDef(i12)).equals("rct")) {
                        int filterType = getFilterType(i12, anWTFilterSpec);
                        if (filterType == 0) {
                            if (isTileSpecified(i12)) {
                                throw new IllegalArgumentException("Cannot use RCT with 9x7 filter in tile " + i12);
                            }
                            setTileDef(i12, "ict");
                        } else if (filterType != 1) {
                            throw new IllegalArgumentException("Default filter is not JPEG 2000 part I compliant");
                        }
                    } else {
                        int filterType2 = getFilterType(i12, anWTFilterSpec);
                        if (filterType2 != 0) {
                            if (filterType2 == 1) {
                                if (isTileSpecified(i12)) {
                                    throw new IllegalArgumentException("Cannot use ICT with filter 5x3 in tile " + i12);
                                }
                                setTileDef(i12, "rct");
                            } else {
                                throw new IllegalArgumentException("Default filter is not JPEG 2000 part I compliant");
                            }
                        }
                    }
                }
            }
            return;
        }
    }

    private int getFilterType(int i, AnWTFilterSpec anWTFilterSpec) {
        Object tileCompVal;
        int[] iArr = new int[this.nComp];
        for (int i2 = 0; i2 < this.nComp; i2++) {
            if (i == -1) {
                tileCompVal = anWTFilterSpec.getCompDef(i2);
            } else {
                tileCompVal = anWTFilterSpec.getTileCompVal(i, i2);
            }
            iArr[i2] = ((AnWTFilter[][]) tileCompVal)[0][0].getFilterType();
        }
        boolean z = false;
        for (int i3 = 1; i3 < this.nComp; i3++) {
            if (iArr[i3] != iArr[0]) {
                z = true;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can not use component transformation when components do not use the same filters");
        }
        return iArr[0];
    }
}
