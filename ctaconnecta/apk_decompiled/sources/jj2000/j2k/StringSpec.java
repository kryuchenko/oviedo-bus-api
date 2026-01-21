package jj2000.j2k;

import java.util.StringTokenizer;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class StringSpec extends ModuleSpec {
    public StringSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public StringSpec(int i, int i2, byte b, String str, String[] strArr, ParameterList parameterList) {
        super(i, i2, b);
        String parameter = parameterList.getParameter(str);
        int i3 = 0;
        if (parameter == null) {
            String parameter2 = parameterList.getDefaultParameterList().getParameter(str);
            for (int length = strArr.length - 1; length >= 0; length--) {
                if (parameter2.equalsIgnoreCase(strArr[length])) {
                    i3 = 1;
                }
            }
            if (i3 == 0) {
                throw new IllegalArgumentException("Default parameter of option -" + str + " not recognized: " + parameter2);
            }
            setDefault(parameter2);
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        char c = 0;
        boolean[] idx = null;
        boolean z = false;
        while (true) {
            boolean[] idx2 = null;
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                char cCharAt = strNextToken.charAt(i3);
                if (cCharAt == 'c') {
                    idx2 = parseIdx(strNextToken, this.nComp);
                    if (c == 2) {
                        i3 = 0;
                        c = 3;
                    } else {
                        i3 = 0;
                        c = 1;
                    }
                } else if (cCharAt == 't') {
                    idx = parseIdx(strNextToken, this.nTiles);
                    if (c == 1) {
                        i3 = 0;
                        c = 3;
                    } else {
                        i3 = 0;
                        c = 2;
                    }
                } else {
                    z = false;
                    for (int length2 = strArr.length - 1; length2 >= 0; length2--) {
                        if (strNextToken.equalsIgnoreCase(strArr[length2])) {
                            z = true;
                        }
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Default parameter of option -" + str + " not recognized: " + strNextToken);
                    }
                    if (c == 0) {
                        setDefault(strNextToken);
                    } else if (c == 2) {
                        for (int length3 = idx.length - 1; length3 >= 0; length3--) {
                            if (idx[length3]) {
                                setTileDef(length3, strNextToken);
                            }
                        }
                    } else if (c == 1) {
                        for (int length4 = idx2.length - 1; length4 >= 0; length4--) {
                            if (idx2[length4]) {
                                setCompDef(length4, strNextToken);
                            }
                        }
                    } else {
                        for (int length5 = idx.length - 1; length5 >= 0; length5--) {
                            for (int length6 = idx2.length - 1; length6 >= 0; length6--) {
                                if (idx[length5] && idx2[length6]) {
                                    setTileCompVal(length5, length6, strNextToken);
                                }
                            }
                        }
                    }
                    i3 = 0;
                    c = 0;
                    idx = null;
                }
            }
            if (getDefault() == null) {
                int i4 = i - 1;
                int i5 = 0;
                for (int i6 = i4; i6 >= 0; i6--) {
                    for (int i7 = i2 - 1; i7 >= 0; i7--) {
                        if (this.specValType[i6][i7] == 0) {
                            i5++;
                        }
                    }
                }
                if (i5 != 0) {
                    String parameter3 = parameterList.getDefaultParameterList().getParameter(str);
                    for (int length7 = strArr.length - 1; length7 >= 0; length7--) {
                        if (parameter3.equalsIgnoreCase(strArr[length7])) {
                            z = true;
                        }
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Default parameter of option -" + str + " not recognized: " + parameter3);
                    }
                    setDefault(parameter3);
                    return;
                }
                setDefault(getSpec(0, 0));
                byte b2 = this.specValType[0][0];
                if (b2 == 1) {
                    while (i4 >= 0) {
                        if (this.specValType[i4][0] == 1) {
                            this.specValType[i4][0] = 0;
                        }
                        i4--;
                    }
                    this.compDef[0] = null;
                    return;
                }
                if (b2 != 2) {
                    if (b2 != 3) {
                        return;
                    }
                    this.specValType[0][0] = 0;
                    this.tileCompVal.put("t0c0", null);
                    return;
                }
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    if (this.specValType[0][i8] == 2) {
                        this.specValType[0][i8] = 0;
                    }
                }
                this.tileDef[0] = null;
                return;
            }
            return;
        }
    }
}
