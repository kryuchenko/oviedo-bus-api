package jj2000.j2k.wavelet.analysis;

import java.lang.reflect.Array;
import java.util.StringTokenizer;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.quantization.QuantTypeSpec;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class AnWTFilterSpec extends ModuleSpec {
    private static final String NON_REV_FILTER_STR = "w9x7";
    private static final String REV_FILTER_STR = "w5x3";

    public AnWTFilterSpec(int i, int i2, byte b, QuantTypeSpec quantTypeSpec, ParameterList parameterList) {
        super(i, i2, b);
        parameterList.checkList(AnWTFilter.OPT_PREFIX, ParameterList.toNameArray(AnWTFilter.getParameterInfo()));
        String parameter = parameterList.getParameter("Ffilters");
        int i3 = 0;
        if (parameter == null) {
            if (parameterList.getBooleanParameter("lossless")) {
                setDefault(parseFilters(REV_FILTER_STR));
                return;
            }
            for (int i4 = i - 1; i4 >= 0; i4--) {
                for (int i5 = i2 - 1; i5 >= 0; i5--) {
                    byte specValType = quantTypeSpec.getSpecValType(i4, i5);
                    if (specValType == 0) {
                        if (getDefault() == null) {
                            if (parameterList.getBooleanParameter("lossless")) {
                                setDefault(parseFilters(REV_FILTER_STR));
                            }
                            if (((String) quantTypeSpec.getDefault()).equals("reversible")) {
                                setDefault(parseFilters(REV_FILTER_STR));
                            } else {
                                setDefault(parseFilters(NON_REV_FILTER_STR));
                            }
                        }
                        this.specValType[i4][i5] = 0;
                    } else if (specValType == 1) {
                        if (!isCompSpecified(i5)) {
                            if (((String) quantTypeSpec.getCompDef(i5)).equals("reversible")) {
                                setCompDef(i5, parseFilters(REV_FILTER_STR));
                            } else {
                                setCompDef(i5, parseFilters(NON_REV_FILTER_STR));
                            }
                        }
                        this.specValType[i4][i5] = 1;
                    } else if (specValType == 2) {
                        if (!isTileSpecified(i4)) {
                            if (((String) quantTypeSpec.getTileDef(i4)).equals("reversible")) {
                                setTileDef(i4, parseFilters(REV_FILTER_STR));
                            } else {
                                setTileDef(i4, parseFilters(NON_REV_FILTER_STR));
                            }
                        }
                        this.specValType[i4][i5] = 2;
                    } else if (specValType == 3) {
                        if (!isTileCompSpecified(i4, i5)) {
                            if (((String) quantTypeSpec.getTileCompVal(i4, i5)).equals("reversible")) {
                                setTileCompVal(i4, i5, parseFilters(REV_FILTER_STR));
                            } else {
                                setTileCompVal(i4, i5, parseFilters(NON_REV_FILTER_STR));
                            }
                        }
                        this.specValType[i4][i5] = 3;
                    } else {
                        throw new IllegalArgumentException("Unsupported specification type");
                    }
                }
            }
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        while (true) {
            char c = 0;
            boolean[] idx = null;
            boolean[] idx2 = null;
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                char cCharAt = strNextToken.charAt(i3);
                if (cCharAt != 'C') {
                    if (cCharAt != 'T') {
                        if (cCharAt != 'W') {
                            if (cCharAt != 'c') {
                                if (cCharAt != 't') {
                                    if (cCharAt != 'w') {
                                        throw new IllegalArgumentException("Bad construction for parameter: " + strNextToken);
                                    }
                                }
                            }
                        }
                        if (parameterList.getBooleanParameter("lossless") && strNextToken.equalsIgnoreCase(NON_REV_FILTER_STR)) {
                            throw new IllegalArgumentException("Cannot use non reversible wavelet transform with '-lossless' option");
                        }
                        AnWTFilter[][] filters = parseFilters(strNextToken);
                        if (c == 0) {
                            setDefault(filters);
                        } else if (c == 2) {
                            for (int length = idx.length - 1; length >= 0; length--) {
                                if (idx[length]) {
                                    setTileDef(length, filters);
                                }
                            }
                        } else if (c == 1) {
                            for (int length2 = idx2.length - 1; length2 >= 0; length2--) {
                                if (idx2[length2]) {
                                    setCompDef(length2, filters);
                                }
                            }
                        } else {
                            for (int length3 = idx.length - 1; length3 >= 0; length3--) {
                                for (int length4 = idx2.length - 1; length4 >= 0; length4--) {
                                    if (idx[length3] && idx2[length4]) {
                                        setTileCompVal(length3, length4, filters);
                                    }
                                }
                            }
                        }
                        i3 = 0;
                    }
                    idx = parseIdx(strNextToken, this.nTiles);
                    if (c == 1) {
                        i3 = 0;
                        c = 3;
                    } else {
                        i3 = 0;
                        c = 2;
                    }
                }
                idx2 = parseIdx(strNextToken, this.nComp);
                if (c == 2) {
                    i3 = 0;
                    c = 3;
                } else {
                    i3 = 0;
                    c = 1;
                }
            }
            if (getDefault() == null) {
                int i6 = i - 1;
                int i7 = 0;
                for (int i8 = i6; i8 >= 0; i8--) {
                    for (int i9 = i2 - 1; i9 >= 0; i9--) {
                        if (this.specValType[i8][i9] == 0) {
                            i7++;
                        }
                    }
                }
                if (i7 != 0) {
                    if (((String) quantTypeSpec.getDefault()).equals("reversible")) {
                        setDefault(parseFilters(REV_FILTER_STR));
                    } else {
                        setDefault(parseFilters(NON_REV_FILTER_STR));
                    }
                } else {
                    setDefault(getTileCompVal(0, 0));
                    byte b2 = this.specValType[0][0];
                    if (b2 == 1) {
                        while (i6 >= 0) {
                            if (this.specValType[i6][0] == 1) {
                                this.specValType[i6][0] = 0;
                            }
                            i6--;
                        }
                        this.compDef[0] = null;
                    } else if (b2 == 2) {
                        for (int i10 = i2 - 1; i10 >= 0; i10--) {
                            if (this.specValType[0][i10] == 2) {
                                this.specValType[0][i10] = 0;
                            }
                        }
                        this.tileDef[0] = null;
                    } else if (b2 == 3) {
                        this.specValType[0][0] = 0;
                        this.tileCompVal.put("t0c0", null);
                    }
                }
            }
            for (int i11 = i - 1; i11 >= 0; i11--) {
                for (int i12 = i2 - 1; i12 >= 0; i12--) {
                    if (((String) quantTypeSpec.getTileCompVal(i11, i12)).equals("reversible")) {
                        if (!isReversible(i11, i12)) {
                            throw new IllegalArgumentException("Filter of tile-component (" + i11 + "," + i12 + ") does not allow reversible quantization. Specify '-Qtype expounded' or '-Qtype derived'in the command line.");
                        }
                    } else if (isReversible(i11, i12)) {
                        throw new IllegalArgumentException("Filter of tile-component (" + i11 + "," + i12 + ") does not allow non-reversible quantization. Specify '-Qtype reversible' in the command line");
                    }
                }
            }
            return;
        }
    }

    private AnWTFilter[][] parseFilters(String str) {
        AnWTFilter[][] anWTFilterArr = (AnWTFilter[][]) Array.newInstance((Class<?>) AnWTFilter.class, 2, 1);
        if (str.equalsIgnoreCase(REV_FILTER_STR)) {
            anWTFilterArr[0][0] = new AnWTFilterIntLift5x3();
            anWTFilterArr[1][0] = new AnWTFilterIntLift5x3();
            return anWTFilterArr;
        }
        if (str.equalsIgnoreCase(NON_REV_FILTER_STR)) {
            anWTFilterArr[0][0] = new AnWTFilterFloatLift9x7();
            anWTFilterArr[1][0] = new AnWTFilterFloatLift9x7();
            return anWTFilterArr;
        }
        throw new IllegalArgumentException("Non JPEG 2000 part I filter: " + str);
    }

    public int getWTDataType(int i, int i2) {
        return ((AnWTFilter[][]) getSpec(i, i2))[0][0].getDataType();
    }

    public AnWTFilter[] getHFilters(int i, int i2) {
        return ((AnWTFilter[][]) getSpec(i, i2))[0];
    }

    public AnWTFilter[] getVFilters(int i, int i2) {
        return ((AnWTFilter[][]) getSpec(i, i2))[1];
    }

    public String toString() {
        String str = "nTiles=" + this.nTiles + "\nnComp=" + this.nComp + "\n\n";
        for (int i = 0; i < this.nTiles; i++) {
            for (int i2 = 0; i2 < this.nComp; i2++) {
                AnWTFilter[][] anWTFilterArr = (AnWTFilter[][]) getSpec(i, i2);
                String str2 = (str + "(t:" + i + ",c:" + i2 + ")\n") + "\tH:";
                for (int i3 = 0; i3 < anWTFilterArr[0].length; i3++) {
                    str2 = str2 + " " + anWTFilterArr[0][i3];
                }
                String str3 = str2 + "\n\tV:";
                for (int i4 = 0; i4 < anWTFilterArr[1].length; i4++) {
                    str3 = str3 + " " + anWTFilterArr[1][i4];
                }
                str = str3 + "\n";
            }
        }
        return str;
    }

    public boolean isReversible(int i, int i2) {
        AnWTFilter[] hFilters = getHFilters(i, i2);
        AnWTFilter[] vFilters = getVFilters(i, i2);
        for (int length = hFilters.length - 1; length >= 0; length--) {
            if (!hFilters[length].isReversible() || !vFilters[length].isReversible()) {
                return false;
            }
        }
        return true;
    }
}
