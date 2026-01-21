package jj2000.j2k.entropy;

import java.util.StringTokenizer;
import java.util.Vector;
import jj2000.j2k.IntegerSpec;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class ProgressionSpec extends ModuleSpec {
    public ProgressionSpec(int i, int i2, byte b) {
        super(i, i2, b);
        if (b != 1) {
            throw new Error("Illegal use of class ProgressionSpec !");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ProgressionSpec(int i, int i2, int i3, IntegerSpec integerSpec, byte b, ParameterList parameterList) {
        int iCheckProgMode;
        int iCheckProgMode2;
        Vector vector;
        StringTokenizer stringTokenizer;
        Progression progression;
        int iCheckProgMode3;
        int i4 = i2;
        super(i, i4, b);
        String parameter = parameterList.getParameter("Aptype");
        int i5 = 0;
        if (parameter == null) {
            if (parameterList.getParameter("Rroi") == null) {
                iCheckProgMode3 = checkProgMode("res");
            } else {
                iCheckProgMode3 = checkProgMode("layer");
            }
            if (iCheckProgMode3 == -1) {
                throw new IllegalArgumentException("Unknown progression type : '" + parameter + "'");
            }
            setDefault(new Progression[]{new Progression(iCheckProgMode3, 0, i4, 0, integerSpec.getMax() + 1, i3)});
            return;
        }
        int i6 = i3;
        StringTokenizer stringTokenizer2 = new StringTokenizer(parameter);
        Vector vector2 = new Vector();
        int i7 = 0;
        Progression progression2 = null;
        char c = 0;
        boolean z = false;
        boolean[] idx = null;
        while (stringTokenizer2.hasMoreTokens()) {
            String strNextToken = stringTokenizer2.nextToken();
            if (strNextToken.charAt(i5) == 't') {
                StringTokenizer stringTokenizer3 = stringTokenizer2;
                Vector vector3 = vector2;
                if (vector3.size() > 0) {
                    progression2.ce = i4;
                    progression2.lye = i6;
                    progression2.re = integerSpec.getMax() + 1;
                    Progression[] progressionArr = new Progression[vector3.size()];
                    vector3.copyInto(progressionArr);
                    char c2 = c;
                    if (c2 == 0) {
                        setDefault(progressionArr);
                    } else if (c2 == 2) {
                        boolean[] zArr = idx;
                        for (int length = zArr.length - 1; length >= 0; length--) {
                            if (zArr[length]) {
                                setTileDef(length, progressionArr);
                            }
                        }
                    }
                }
                vector3.removeAllElements();
                idx = parseIdx(strNextToken, this.nTiles);
                vector2 = vector3;
                stringTokenizer2 = stringTokenizer3;
                i7 = -1;
                i5 = 0;
                c = 2;
            } else if (z) {
                try {
                    int iIntValue = new Integer(strNextToken).intValue();
                    if (i7 == 0) {
                        if (iIntValue < 0 || iIntValue > integerSpec.getMax() + 1) {
                            throw new IllegalArgumentException("Invalid res_start in '-Aptype' option: " + iIntValue);
                        }
                        progression2.rs = iIntValue;
                    } else if (i7 == 1) {
                        if (iIntValue < 0 || iIntValue > i4) {
                            throw new IllegalArgumentException("Invalid comp_start in '-Aptype' option: " + iIntValue);
                        }
                        progression2.cs = iIntValue;
                    } else if (i7 == 2) {
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException("Invalid layer_end in '-Aptype' option: " + iIntValue);
                        }
                        progression2.lye = iIntValue > i6 ? i6 : iIntValue;
                    } else if (i7 == 3) {
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException("Invalid res_end in '-Aptype' option: " + iIntValue);
                        }
                        progression2.re = iIntValue > integerSpec.getMax() + 1 ? integerSpec.getMax() + 1 : iIntValue;
                    } else if (i7 == 4) {
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException("Invalid comp_end in '-Aptype' option: " + iIntValue);
                        }
                        progression2.ce = iIntValue > i4 ? i4 : iIntValue;
                    }
                    if (i7 < 4) {
                        i7++;
                        i5 = 0;
                        z = true;
                    } else {
                        if (i7 != 4) {
                            throw new Error("Error in usage of 'Aptype' option: " + parameter);
                        }
                        i7 = 0;
                        i5 = 0;
                    }
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Progression order specification has missing parameters: " + parameter);
                }
            } else if (z) {
                i5 = 0;
            } else {
                int iCheckProgMode4 = checkProgMode(strNextToken);
                if (iCheckProgMode4 == -1) {
                    throw new IllegalArgumentException("Unknown progression type : '" + strNextToken + "'");
                }
                if (vector2.size() == 0) {
                    stringTokenizer = stringTokenizer2;
                    vector = vector2;
                    progression = new Progression(iCheckProgMode4, 0, i2, 0, integerSpec.getMax() + 1, i6);
                    i4 = i2;
                    i6 = i3;
                } else {
                    vector = vector2;
                    stringTokenizer = stringTokenizer2;
                    progression = new Progression(iCheckProgMode4, 0, i2, 0, integerSpec.getMax() + 1, i3);
                    i4 = i2;
                    i6 = i3;
                }
                progression2 = progression;
                vector.addElement(progression2);
                vector2 = vector;
                stringTokenizer2 = stringTokenizer;
                i7 = 0;
                i5 = 0;
                z = true;
            }
            z = false;
        }
        Vector vector4 = vector2;
        char c3 = c;
        boolean[] zArr2 = idx;
        if (vector4.size() == 0) {
            if (parameterList.getParameter("Rroi") == null) {
                iCheckProgMode2 = checkProgMode("res");
            } else {
                iCheckProgMode2 = checkProgMode("layer");
            }
            int i8 = iCheckProgMode2;
            if (i8 == -1) {
                throw new IllegalArgumentException("Unknown progression type : '" + parameter + "'");
            }
            setDefault(new Progression[]{new Progression(i8, 0, i4, 0, integerSpec.getMax() + 1, i6)});
            return;
        }
        progression2.ce = i4;
        progression2.lye = i6;
        progression2.re = integerSpec.getMax() + 1;
        Progression[] progressionArr2 = new Progression[vector4.size()];
        vector4.copyInto(progressionArr2);
        if (c3 == 0) {
            setDefault(progressionArr2);
        } else if (c3 == 2) {
            for (int length2 = zArr2.length - 1; length2 >= 0; length2--) {
                if (zArr2[length2]) {
                    setTileDef(length2, progressionArr2);
                }
            }
        }
        if (getDefault() == null) {
            int i9 = i - 1;
            int i10 = 0;
            for (int i11 = i9; i11 >= 0; i11--) {
                for (int i12 = i4 - 1; i12 >= 0; i12--) {
                    if (this.specValType[i11][i12] == 0) {
                        i10++;
                    }
                }
            }
            if (i10 != 0) {
                if (parameterList.getParameter("Rroi") == null) {
                    iCheckProgMode = checkProgMode("res");
                } else {
                    iCheckProgMode = checkProgMode("layer");
                }
                int i13 = iCheckProgMode;
                if (i13 == -1) {
                    throw new IllegalArgumentException("Unknown progression type : '" + parameter + "'");
                }
                setDefault(new Progression[]{new Progression(i13, 0, i4, 0, integerSpec.getMax() + 1, i6)});
                return;
            }
            setDefault(getTileCompVal(0, 0));
            byte b2 = this.specValType[0][0];
            if (b2 == 1) {
                while (i9 >= 0) {
                    if (this.specValType[i9][0] == 1) {
                        this.specValType[i9][0] = 0;
                    }
                    i9--;
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
            for (int i14 = i2 - 1; i14 >= 0; i14--) {
                if (this.specValType[0][i14] == 2) {
                    this.specValType[0][i14] = 0;
                }
            }
            this.tileDef[0] = null;
        }
    }

    private int checkProgMode(String str) {
        if (str.equals("res")) {
            return 1;
        }
        if (str.equals("layer")) {
            return 0;
        }
        if (str.equals("pos-comp")) {
            return 3;
        }
        if (str.equals("comp-pos")) {
            return 4;
        }
        return str.equals("res-pos") ? 2 : -1;
    }
}
