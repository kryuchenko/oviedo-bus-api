package jj2000.j2k;

import java.util.StringTokenizer;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class IntegerSpec extends ModuleSpec {
    protected static int MAX_INT = Integer.MAX_VALUE;

    public IntegerSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public IntegerSpec(int i, int i2, byte b, ParameterList parameterList, String str) {
        super(i, i2, b);
        String parameter = parameterList.getParameter(str);
        if (parameter == null) {
            String parameter2 = parameterList.getDefaultParameterList().getParameter(str);
            try {
                setDefault(new Integer(parameter2));
                return;
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Non recognized value for option -" + str + ": " + parameter2);
            }
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        loop0: while (true) {
            boolean[] idx = null;
            boolean[] idx2 = null;
            char c = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                char cCharAt = strNextToken.charAt(0);
                if (cCharAt == 'c') {
                    idx2 = parseIdx(strNextToken, this.nComp);
                    if (c != 2) {
                        c = 1;
                    }
                } else if (cCharAt == 't') {
                    idx = parseIdx(strNextToken, this.nTiles);
                    c = c == 1 ? (char) 3 : (char) 2;
                } else {
                    try {
                        Integer num = new Integer(strNextToken);
                        if (c == 0) {
                            setDefault(num);
                        } else if (c == 2) {
                            for (int length = idx.length - 1; length >= 0; length--) {
                                if (idx[length]) {
                                    setTileDef(length, num);
                                }
                            }
                        } else if (c == 1) {
                            for (int length2 = idx2.length - 1; length2 >= 0; length2--) {
                                if (idx2[length2]) {
                                    setCompDef(length2, num);
                                }
                            }
                        } else {
                            for (int length3 = idx.length - 1; length3 >= 0; length3--) {
                                for (int length4 = idx2.length - 1; length4 >= 0; length4--) {
                                    if (idx[length3] && idx2[length4]) {
                                        setTileCompVal(length3, length4, num);
                                    }
                                }
                            }
                        }
                    } catch (NumberFormatException unused2) {
                        throw new IllegalArgumentException("Non recognized value for option -" + str + ": " + strNextToken);
                    }
                }
            }
            break loop0;
        }
        if (getDefault() == null) {
            int i3 = i - 1;
            int i4 = 0;
            for (int i5 = i3; i5 >= 0; i5--) {
                for (int i6 = i2 - 1; i6 >= 0; i6--) {
                    if (this.specValType[i5][i6] == 0) {
                        i4++;
                    }
                }
            }
            if (i4 != 0) {
                String parameter3 = parameterList.getDefaultParameterList().getParameter(str);
                try {
                    setDefault(new Integer(parameter3));
                    return;
                } catch (NumberFormatException unused3) {
                    throw new IllegalArgumentException("Non recognized value for option -" + str + ": " + parameter3);
                }
            }
            setDefault(getTileCompVal(0, 0));
            byte b2 = this.specValType[0][0];
            if (b2 == 1) {
                while (i3 >= 0) {
                    if (this.specValType[i3][0] == 1) {
                        this.specValType[i3][0] = 0;
                    }
                    i3--;
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
            for (int i7 = i2 - 1; i7 >= 0; i7--) {
                if (this.specValType[0][i7] == 2) {
                    this.specValType[0][i7] = 0;
                }
            }
            this.tileDef[0] = null;
        }
    }

    public int getMax() {
        int iIntValue = ((Integer) this.def).intValue();
        for (int i = 0; i < this.nTiles; i++) {
            for (int i2 = 0; i2 < this.nComp; i2++) {
                int iIntValue2 = ((Integer) getSpec(i, i2)).intValue();
                if (iIntValue < iIntValue2) {
                    iIntValue = iIntValue2;
                }
            }
        }
        return iIntValue;
    }

    public int getMin() {
        int iIntValue = ((Integer) this.def).intValue();
        for (int i = 0; i < this.nTiles; i++) {
            for (int i2 = 0; i2 < this.nComp; i2++) {
                int iIntValue2 = ((Integer) getSpec(i, i2)).intValue();
                if (iIntValue > iIntValue2) {
                    iIntValue = iIntValue2;
                }
            }
        }
        return iIntValue;
    }

    public int getMaxInComp(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.nTiles; i3++) {
            int iIntValue = ((Integer) getSpec(i3, i)).intValue();
            if (i2 < iIntValue) {
                i2 = iIntValue;
            }
        }
        return i2;
    }

    public int getMinInComp(int i) {
        int i2 = MAX_INT;
        for (int i3 = 0; i3 < this.nTiles; i3++) {
            int iIntValue = ((Integer) getSpec(i3, i)).intValue();
            if (i2 > iIntValue) {
                i2 = iIntValue;
            }
        }
        return i2;
    }

    public int getMaxInTile(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.nComp; i3++) {
            int iIntValue = ((Integer) getSpec(i, i3)).intValue();
            if (i2 < iIntValue) {
                i2 = iIntValue;
            }
        }
        return i2;
    }

    public int getMinInTile(int i) {
        int i2 = MAX_INT;
        for (int i3 = 0; i3 < this.nComp; i3++) {
            int iIntValue = ((Integer) getSpec(i, i3)).intValue();
            if (i2 > iIntValue) {
                i2 = iIntValue;
            }
        }
        return i2;
    }
}
