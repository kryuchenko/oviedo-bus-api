package jj2000.j2k.entropy;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import jj2000.j2k.ModuleSpec;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public class CBlkSizeSpec extends ModuleSpec {
    private static final String optName = "Cblksiz";
    private int maxCBlkHeight;
    private int maxCBlkWidth;

    public CBlkSizeSpec(int i, int i2, byte b) {
        super(i, i2, b);
        this.maxCBlkWidth = 0;
        this.maxCBlkHeight = 0;
    }

    public CBlkSizeSpec(int i, int i2, byte b, ParameterList parameterList) {
        super(i, i2, b);
        this.maxCBlkWidth = 0;
        this.maxCBlkHeight = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(parameterList.getParameter(optName));
        boolean[] idx = null;
        boolean[] idx2 = null;
        char c = 0;
        boolean z = true;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            char cCharAt = strNextToken.charAt(0);
            if (cCharAt == 'c') {
                idx = parseIdx(strNextToken, this.nComp);
                if (c != 2) {
                    c = 1;
                }
            } else if (cCharAt == 't') {
                idx2 = parseIdx(strNextToken, this.nTiles);
                c = c == 1 ? (char) 3 : (char) 2;
            } else {
                if (!Character.isDigit(strNextToken.charAt(0))) {
                    throw new IllegalArgumentException("Bad construction for parameter: " + strNextToken);
                }
                Integer[] numArr = new Integer[2];
                try {
                    Integer num = new Integer(strNextToken);
                    numArr[0] = num;
                    if (num.intValue() > 1024) {
                        throw new IllegalArgumentException("'Cblksiz' option : the code-block's width cannot be greater than 1024");
                    }
                    if (numArr[0].intValue() < 4) {
                        throw new IllegalArgumentException("'Cblksiz' option : the code-block's width cannot be less than 4");
                    }
                    if (numArr[0].intValue() != (1 << MathUtil.log2(numArr[0].intValue()))) {
                        throw new IllegalArgumentException("'Cblksiz' option : the code-block's width must be a power of 2");
                    }
                    try {
                        try {
                            Integer num2 = new Integer(stringTokenizer.nextToken());
                            numArr[1] = num2;
                            if (num2.intValue() > 1024) {
                                throw new IllegalArgumentException("'Cblksiz' option : the code-block's height cannot be greater than 1024");
                            }
                            if (numArr[1].intValue() < 4) {
                                throw new IllegalArgumentException("'Cblksiz' option : the code-block's height cannot be less than 4");
                            }
                            if (numArr[1].intValue() != (1 << MathUtil.log2(numArr[1].intValue()))) {
                                throw new IllegalArgumentException("'Cblksiz' option : the code-block's height must be a power of 2");
                            }
                            if (numArr[0].intValue() * numArr[1].intValue() > 4096) {
                                throw new IllegalArgumentException("'Cblksiz' option : The code-block's area (i.e. width*height) cannot be greater than 4096");
                            }
                            if (numArr[0].intValue() > this.maxCBlkWidth) {
                                this.maxCBlkWidth = numArr[0].intValue();
                            }
                            if (numArr[1].intValue() > this.maxCBlkHeight) {
                                this.maxCBlkHeight = numArr[1].intValue();
                            }
                            if (z) {
                                setDefault(numArr);
                                z = false;
                            }
                            if (c == 0) {
                                setDefault(numArr);
                            } else if (c == 1) {
                                for (int length = idx.length - 1; length >= 0; length--) {
                                    if (idx[length]) {
                                        setCompDef(length, numArr);
                                    }
                                }
                            } else if (c == 2) {
                                for (int length2 = idx2.length - 1; length2 >= 0; length2--) {
                                    if (idx2[length2]) {
                                        setTileDef(length2, numArr);
                                    }
                                }
                            } else {
                                for (int length3 = idx2.length - 1; length3 >= 0; length3--) {
                                    for (int length4 = idx.length - 1; length4 >= 0; length4--) {
                                        if (idx2[length3] && idx[length4]) {
                                            setTileCompVal(length3, length4, numArr);
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException unused) {
                            throw new IllegalArgumentException("'Cblksiz' option : the code-block's height could not be parsed.");
                        }
                    } catch (NoSuchElementException unused2) {
                        throw new IllegalArgumentException("'Cblksiz' option : could not parse the code-block's height");
                    }
                } catch (NumberFormatException unused3) {
                    throw new IllegalArgumentException("'Cblksiz' option : the code-block's width could not be parsed.");
                }
            }
        }
    }

    public int getMaxCBlkWidth() {
        return this.maxCBlkWidth;
    }

    public int getMaxCBlkHeight() {
        return this.maxCBlkHeight;
    }

    public int getCBlkWidth(byte b, int i, int i2) {
        Integer[] numArr;
        if (b == 0) {
            numArr = (Integer[]) getDefault();
        } else if (b == 1) {
            numArr = (Integer[]) getCompDef(i2);
        } else if (b == 2) {
            numArr = (Integer[]) getTileDef(i);
        } else {
            numArr = b != 3 ? null : (Integer[]) getTileCompVal(i, i2);
        }
        return numArr[0].intValue();
    }

    public int getCBlkHeight(byte b, int i, int i2) {
        Integer[] numArr;
        if (b == 0) {
            numArr = (Integer[]) getDefault();
        } else if (b == 1) {
            numArr = (Integer[]) getCompDef(i2);
        } else if (b == 2) {
            numArr = (Integer[]) getTileDef(i);
        } else {
            numArr = b != 3 ? null : (Integer[]) getTileCompVal(i, i2);
        }
        return numArr[1].intValue();
    }

    @Override // jj2000.j2k.ModuleSpec
    public void setDefault(Object obj) {
        super.setDefault(obj);
        storeHighestDims((Integer[]) obj);
    }

    @Override // jj2000.j2k.ModuleSpec
    public void setTileDef(int i, Object obj) {
        super.setTileDef(i, obj);
        storeHighestDims((Integer[]) obj);
    }

    @Override // jj2000.j2k.ModuleSpec
    public void setCompDef(int i, Object obj) {
        super.setCompDef(i, obj);
        storeHighestDims((Integer[]) obj);
    }

    @Override // jj2000.j2k.ModuleSpec
    public void setTileCompVal(int i, int i2, Object obj) {
        super.setTileCompVal(i, i2, obj);
        storeHighestDims((Integer[]) obj);
    }

    private void storeHighestDims(Integer[] numArr) {
        if (numArr[0].intValue() > this.maxCBlkWidth) {
            this.maxCBlkWidth = numArr[0].intValue();
        }
        if (numArr[1].intValue() > this.maxCBlkHeight) {
            this.maxCBlkHeight = numArr[1].intValue();
        }
    }
}
