package jj2000.j2k.quantization;

import java.util.StringTokenizer;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class QuantTypeSpec extends ModuleSpec {
    public QuantTypeSpec(int i, int i2, byte b) {
        super(i, i2, b);
    }

    public QuantTypeSpec(int i, int i2, byte b, ParameterList parameterList) {
        super(i, i2, b);
        String parameter = parameterList.getParameter("Qtype");
        if (parameter == null) {
            if (parameterList.getBooleanParameter("lossless")) {
                setDefault("reversible");
                return;
            } else {
                setDefault("expounded");
                return;
            }
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        while (true) {
            char c = 0;
            boolean[] idx = null;
            boolean[] idx2 = null;
            while (stringTokenizer.hasMoreTokens()) {
                String lowerCase = stringTokenizer.nextToken().toLowerCase();
                char cCharAt = lowerCase.charAt(0);
                if (cCharAt != 'r') {
                    if (cCharAt == 't') {
                        idx = parseIdx(lowerCase, this.nTiles);
                        c = c == 1 ? (char) 3 : (char) 2;
                    } else {
                        switch (cCharAt) {
                            case 'c':
                                idx2 = parseIdx(lowerCase, this.nComp);
                                if (c == 2) {
                                    break;
                                } else {
                                    c = 1;
                                    break;
                                }
                            case 'd':
                            case 'e':
                                break;
                            default:
                                throw new IllegalArgumentException("Unknown parameter for '-Qtype' option: " + lowerCase);
                        }
                    }
                }
                if (!lowerCase.equalsIgnoreCase("reversible") && !lowerCase.equalsIgnoreCase("derived") && !lowerCase.equalsIgnoreCase("expounded")) {
                    throw new IllegalArgumentException("Unknown parameter for '-Qtype' option: " + lowerCase);
                }
                if (!parameterList.getBooleanParameter("lossless") || (!lowerCase.equalsIgnoreCase("derived") && !lowerCase.equalsIgnoreCase("expounded"))) {
                    if (c == 0) {
                        setDefault(lowerCase);
                    } else if (c == 2) {
                        for (int length = idx.length - 1; length >= 0; length--) {
                            if (idx[length]) {
                                setTileDef(length, lowerCase);
                            }
                        }
                    } else if (c == 1) {
                        for (int length2 = idx2.length - 1; length2 >= 0; length2--) {
                            if (idx2[length2]) {
                                setCompDef(length2, lowerCase);
                            }
                        }
                    } else {
                        for (int length3 = idx.length - 1; length3 >= 0; length3--) {
                            for (int length4 = idx2.length - 1; length4 >= 0; length4--) {
                                if (idx[length3] && idx2[length4]) {
                                    setTileCompVal(length3, length4, lowerCase);
                                }
                            }
                        }
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
                    if (parameterList.getBooleanParameter("lossless")) {
                        setDefault("reversible");
                        return;
                    } else {
                        setDefault("expounded");
                        return;
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
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot use non reversible quantization with '-lossless' option");
    }

    public boolean isDerived(int i, int i2) {
        return ((String) getTileCompVal(i, i2)).equals("derived");
    }

    public boolean isReversible(int i, int i2) {
        return ((String) getTileCompVal(i, i2)).equals("reversible");
    }

    public boolean isFullyReversible() {
        if (!((String) getDefault()).equals("reversible")) {
            return false;
        }
        for (int i = this.nTiles - 1; i >= 0; i--) {
            for (int i2 = this.nComp - 1; i2 >= 0; i2--) {
                if (this.specValType[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFullyNonReversible() {
        for (int i = this.nTiles - 1; i >= 0; i--) {
            for (int i2 = this.nComp - 1; i2 >= 0; i2--) {
                if (((String) getSpec(i, i2)).equals("reversible")) {
                    return false;
                }
            }
        }
        return true;
    }
}
