package jj2000.j2k.entropy;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;
import jj2000.j2k.IntegerSpec;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class PrecinctSizeSpec extends ModuleSpec {
    private static final String optName = "Cpp";
    private IntegerSpec dls;

    public PrecinctSizeSpec(int i, int i2, byte b, IntegerSpec integerSpec) {
        super(i, i2, b);
        this.dls = integerSpec;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
    
        if (r2 != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c9, code lost:
    
        setDefault(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cd, code lost:
    
        if (r2 != 2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cf, code lost:
    
        r13 = r3.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d1, code lost:
    
        if (r13 < 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d5, code lost:
    
        if (r3[r13] == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        setTileDef(r13, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:
    
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dd, code lost:
    
        if (r2 != 1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
    
        r13 = r4.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e1, code lost:
    
        if (r13 < 0) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e5, code lost:
    
        if (r4[r13] == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
    
        setCompDef(r13, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
    
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
    
        r13 = r3.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ef, code lost:
    
        if (r13 < 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
    
        r2 = r4.length - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f3, code lost:
    
        if (r2 < 0) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f7, code lost:
    
        if (r3[r13] == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
    
        if (r4[r2] == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fd, code lost:
    
        setTileCompVal(r13, r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0100, code lost:
    
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
    
        r13 = r13 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PrecinctSizeSpec(int i, int i2, byte b, BlkImgDataSrc blkImgDataSrc, IntegerSpec integerSpec, ParameterList parameterList) {
        super(i, i2, b);
        this.dls = integerSpec;
        String parameter = parameterList.getParameter(optName);
        Vector vector = new Vector();
        vector.addElement(new Integer(65535));
        Vector vector2 = new Vector();
        vector2.addElement(new Integer(65535));
        setDefault(new Vector[]{vector, vector2});
        if (parameter == null) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(parameter);
        String strNextToken = null;
        boolean[] idx = null;
        boolean[] idx2 = null;
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            char c = 0;
            while (true) {
                if ((!stringTokenizer.hasMoreTokens() && !z) || z2) {
                    return;
                }
                strNextToken = z ? strNextToken : stringTokenizer.nextToken();
                char cCharAt = strNextToken.charAt(0);
                if (cCharAt == 'c') {
                    idx2 = parseIdx(strNextToken, this.nComp);
                    if (c == 2) {
                        z = false;
                        c = 3;
                    } else {
                        z = false;
                        c = 1;
                    }
                } else if (cCharAt == 't') {
                    idx = parseIdx(strNextToken, this.nTiles);
                    if (c == 1) {
                        z = false;
                        c = 3;
                    } else {
                        z = false;
                        c = 2;
                    }
                } else {
                    if (!Character.isDigit(strNextToken.charAt(0))) {
                        throw new IllegalArgumentException("Bad construction for parameter: " + strNextToken);
                    }
                    Vector[] vectorArr = {new Vector(), new Vector()};
                    do {
                        try {
                            Integer num = new Integer(strNextToken);
                            try {
                                strNextToken = stringTokenizer.nextToken();
                                Integer num2 = new Integer(strNextToken);
                                if (num.intValue() != (1 << MathUtil.log2(num.intValue())) || num2.intValue() != (1 << MathUtil.log2(num2.intValue()))) {
                                    break loop0;
                                }
                                vectorArr[0].addElement(num);
                                vectorArr[1].addElement(num2);
                                if (stringTokenizer.hasMoreTokens()) {
                                    strNextToken = stringTokenizer.nextToken();
                                } else {
                                    if (c == 0) {
                                        setDefault(vectorArr);
                                    } else if (c == 2) {
                                        for (int length = idx.length - 1; length >= 0; length--) {
                                            if (idx[length]) {
                                                setTileDef(length, vectorArr);
                                            }
                                        }
                                    } else if (c == 1) {
                                        for (int length2 = idx2.length - 1; length2 >= 0; length2--) {
                                            if (idx2[length2]) {
                                                setCompDef(length2, vectorArr);
                                            }
                                        }
                                    } else {
                                        for (int length3 = idx.length - 1; length3 >= 0; length3--) {
                                            for (int length4 = idx2.length - 1; length4 >= 0; length4--) {
                                                if (idx[length3] && idx2[length4]) {
                                                    setTileCompVal(length3, length4, vectorArr);
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    z2 = true;
                                }
                            } catch (NoSuchElementException unused) {
                                throw new IllegalArgumentException("'Cpp' option : could not parse the precinct's width");
                            }
                        } catch (NumberFormatException unused2) {
                            throw new IllegalArgumentException("'Cpp' option : the argument '" + strNextToken + "' could not be parsed.");
                        }
                    } while (Character.isDigit(strNextToken.charAt(0)));
                }
            }
            idx = null;
            idx2 = null;
            z = true;
        }
        throw new IllegalArgumentException("Precinct dimensions must be powers of 2");
    }

    public int getPPX(int i, int i2, int i3) {
        int iIntValue;
        Vector[] vectorArr;
        boolean z = i != -1;
        boolean z2 = i2 != -1;
        if (z && z2) {
            iIntValue = ((Integer) this.dls.getTileCompVal(i, i2)).intValue();
            vectorArr = (Vector[]) getTileCompVal(i, i2);
        } else if (z && !z2) {
            iIntValue = ((Integer) this.dls.getTileDef(i)).intValue();
            vectorArr = (Vector[]) getTileDef(i);
        } else if (!z && z2) {
            iIntValue = ((Integer) this.dls.getCompDef(i2)).intValue();
            vectorArr = (Vector[]) getCompDef(i2);
        } else {
            iIntValue = ((Integer) this.dls.getDefault()).intValue();
            vectorArr = (Vector[]) getDefault();
        }
        int i4 = iIntValue - i3;
        if (vectorArr[0].size() > i4) {
            return ((Integer) vectorArr[0].elementAt(i4)).intValue();
        }
        Vector vector = vectorArr[0];
        return ((Integer) vector.elementAt(vector.size() - 1)).intValue();
    }

    public int getPPY(int i, int i2, int i3) {
        int iIntValue;
        Vector[] vectorArr;
        boolean z = i != -1;
        boolean z2 = i2 != -1;
        if (z && z2) {
            iIntValue = ((Integer) this.dls.getTileCompVal(i, i2)).intValue();
            vectorArr = (Vector[]) getTileCompVal(i, i2);
        } else if (z && !z2) {
            iIntValue = ((Integer) this.dls.getTileDef(i)).intValue();
            vectorArr = (Vector[]) getTileDef(i);
        } else if (!z && z2) {
            iIntValue = ((Integer) this.dls.getCompDef(i2)).intValue();
            vectorArr = (Vector[]) getCompDef(i2);
        } else {
            iIntValue = ((Integer) this.dls.getDefault()).intValue();
            vectorArr = (Vector[]) getDefault();
        }
        int i4 = iIntValue - i3;
        if (vectorArr[1].size() > i4) {
            return ((Integer) vectorArr[1].elementAt(i4)).intValue();
        }
        Vector vector = vectorArr[1];
        return ((Integer) vector.elementAt(vector.size() - 1)).intValue();
    }
}
