package jj2000.j2k.quantization;

import java.util.StringTokenizer;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class GuardBitsSpec extends ModuleSpec {
    public GuardBitsSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public GuardBitsSpec(int i, int i2, byte b, ParameterList parameterList) {
        super(i, i2, b);
        String parameter = parameterList.getParameter("Qguard_bits");
        if (parameter == null) {
            throw new IllegalArgumentException("Qguard_bits option not specified");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        while (true) {
            boolean[] idx = null;
            boolean[] idx2 = null;
            char c = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String lowerCase = stringTokenizer.nextToken().toLowerCase();
                char cCharAt = lowerCase.charAt(0);
                if (cCharAt == 'c') {
                    idx2 = parseIdx(lowerCase, this.nComp);
                    if (c != 2) {
                        c = 1;
                    }
                } else if (cCharAt == 't') {
                    idx = parseIdx(lowerCase, this.nTiles);
                    c = c == 1 ? (char) 3 : (char) 2;
                } else {
                    try {
                        Integer num = new Integer(lowerCase);
                        if (num.floatValue() <= 0.0f) {
                            throw new IllegalArgumentException("Guard bits value must be positive : " + num);
                        }
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
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("Bad parameter for -Qguard_bits option : " + lowerCase);
                    }
                }
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
                    setDefault(new Integer(parameterList.getDefaultParameterList().getParameter("Qguard_bits")));
                    return;
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
                return;
            }
            return;
        }
    }
}
