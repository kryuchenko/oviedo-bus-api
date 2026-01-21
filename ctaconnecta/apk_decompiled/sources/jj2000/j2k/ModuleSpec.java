package jj2000.j2k;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Hashtable;
import jj2000.j2k.image.Coord;

/* loaded from: classes5.dex */
public class ModuleSpec implements Cloneable {
    public static final byte SPEC_COMP_DEF = 1;
    public static final byte SPEC_DEF = 0;
    public static final byte SPEC_TILE_COMP = 3;
    public static final byte SPEC_TILE_DEF = 2;
    public static final byte SPEC_TYPE_COMP = 0;
    public static final byte SPEC_TYPE_TILE = 1;
    public static final byte SPEC_TYPE_TILE_COMP = 2;
    protected int nComp;
    protected int nTiles;
    protected int specType;
    protected byte[][] specValType;
    protected Hashtable tileCompVal;
    protected Object def = null;
    protected Object[] compDef = null;
    protected Object[] tileDef = null;

    public ModuleSpec getCopy() {
        return (ModuleSpec) clone();
    }

    protected Object clone() {
        int i;
        try {
            ModuleSpec moduleSpec = (ModuleSpec) super.clone();
            moduleSpec.specValType = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.nTiles, this.nComp);
            int i2 = 0;
            while (true) {
                i = this.nTiles;
                if (i2 >= i) {
                    break;
                }
                for (int i3 = 0; i3 < this.nComp; i3++) {
                    moduleSpec.specValType[i2][i3] = this.specValType[i2][i3];
                }
                i2++;
            }
            if (this.tileDef != null) {
                moduleSpec.tileDef = new Object[i];
                for (int i4 = 0; i4 < this.nTiles; i4++) {
                    moduleSpec.tileDef[i4] = this.tileDef[i4];
                }
            }
            if (this.tileCompVal != null) {
                moduleSpec.tileCompVal = new Hashtable();
                Enumeration enumerationKeys = this.tileCompVal.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    moduleSpec.tileCompVal.put(str, this.tileCompVal.get(str));
                }
            }
            return moduleSpec;
        } catch (CloneNotSupportedException unused) {
            throw new Error("Error when cloning ModuleSpec instance");
        }
    }

    public void rotate90(Coord coord) {
        byte[][] bArr = new byte[this.nTiles][];
        Coord coord2 = new Coord(coord.y, coord.x);
        for (int i = 0; i < coord2.y; i++) {
            for (int i2 = 0; i2 < coord2.x; i2++) {
                bArr[(coord.x * i2) + ((coord2.y - i) - 1)] = this.specValType[(coord2.x * i) + i2];
            }
        }
        this.specValType = bArr;
        if (this.tileDef != null) {
            Object[] objArr = new Object[this.nTiles];
            for (int i3 = 0; i3 < coord2.y; i3++) {
                for (int i4 = 0; i4 < coord2.x; i4++) {
                    objArr[(coord.x * i4) + ((coord2.y - i3) - 1)] = this.tileDef[(coord2.x * i3) + i4];
                }
            }
            this.tileDef = objArr;
        }
        Hashtable hashtable = this.tileCompVal;
        if (hashtable == null || hashtable.size() <= 0) {
            return;
        }
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = this.tileCompVal.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            Object obj = this.tileCompVal.get(str);
            int iIndexOf = str.indexOf(116);
            int iIndexOf2 = str.indexOf(99);
            hashtable2.put("t" + (((coord2.y - (r5 / coord2.x)) - 1) + ((new Integer(str.substring(iIndexOf + 1, iIndexOf2)).intValue() % coord2.x) * coord.x)) + str.substring(iIndexOf2), obj);
        }
        this.tileCompVal = hashtable2;
    }

    public ModuleSpec(int i, int i2, byte b) {
        this.nTiles = i;
        this.nComp = i2;
        this.specValType = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, i2);
        if (b == 0) {
            this.specType = 0;
        } else if (b == 1) {
            this.specType = 1;
        } else {
            if (b != 2) {
                return;
            }
            this.specType = 2;
        }
    }

    public void setDefault(Object obj) {
        this.def = obj;
    }

    public Object getDefault() {
        return this.def;
    }

    public void setCompDef(int i, Object obj) {
        if (this.specType == 1) {
            throw new Error("Option whose value is '" + obj + "' cannot be specified for components as it is a 'tile only' specific option");
        }
        if (this.compDef == null) {
            this.compDef = new Object[this.nComp];
        }
        for (int i2 = 0; i2 < this.nTiles; i2++) {
            byte[] bArr = this.specValType[i2];
            if (bArr[i] < 1) {
                bArr[i] = 1;
            }
        }
        this.compDef[i] = obj;
    }

    public Object getCompDef(int i) {
        Object obj;
        if (this.specType == 1) {
            throw new Error("Illegal use of ModuleSpec class");
        }
        Object[] objArr = this.compDef;
        return (objArr == null || (obj = objArr[i]) == null) ? getDefault() : obj;
    }

    public void setTileDef(int i, Object obj) {
        if (this.specType == 0) {
            throw new Error("Option whose value is '" + obj + "' cannot be specified for tiles as it is a 'component only' specific option");
        }
        if (this.tileDef == null) {
            this.tileDef = new Object[this.nTiles];
        }
        for (int i2 = 0; i2 < this.nComp; i2++) {
            byte[] bArr = this.specValType[i];
            if (bArr[i2] < 2) {
                bArr[i2] = 2;
            }
        }
        this.tileDef[i] = obj;
    }

    public Object getTileDef(int i) {
        Object obj;
        if (this.specType == 0) {
            throw new Error("Illegal use of ModuleSpec class");
        }
        Object[] objArr = this.tileDef;
        return (objArr == null || (obj = objArr[i]) == null) ? getDefault() : obj;
    }

    public void setTileCompVal(int i, int i2, Object obj) {
        if (this.specType != 2) {
            String str = "Option whose value is '" + obj + "' cannot be specified for ";
            int i3 = this.specType;
            if (i3 == 0) {
                str = str + "tiles as it is a 'component only' specific option";
            } else if (i3 == 1) {
                str = str + "components as it is a 'tile only' specific option";
            }
            throw new Error(str);
        }
        if (this.tileCompVal == null) {
            this.tileCompVal = new Hashtable();
        }
        this.specValType[i][i2] = 3;
        this.tileCompVal.put("t" + i + "c" + i2, obj);
    }

    public Object getTileCompVal(int i, int i2) {
        if (this.specType != 2) {
            throw new Error("Illegal use of ModuleSpec class");
        }
        return getSpec(i, i2);
    }

    protected Object getSpec(int i, int i2) {
        byte b = this.specValType[i][i2];
        if (b == 0) {
            return getDefault();
        }
        if (b == 1) {
            return getCompDef(i2);
        }
        if (b == 2) {
            return getTileDef(i);
        }
        if (b == 3) {
            return this.tileCompVal.get("t" + i + "c" + i2);
        }
        throw new IllegalArgumentException("Not recognized spec type");
    }

    public byte getSpecValType(int i, int i2) {
        return this.specValType[i][i2];
    }

    public boolean isCompSpecified(int i) {
        Object[] objArr = this.compDef;
        return (objArr == null || objArr[i] == null) ? false : true;
    }

    public boolean isTileSpecified(int i) {
        Object[] objArr = this.tileDef;
        return (objArr == null || objArr[i] == null) ? false : true;
    }

    public boolean isTileCompSpecified(int i, int i2) {
        Hashtable hashtable = this.tileCompVal;
        if (hashtable == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder("t");
        sb.append(i);
        sb.append("c");
        sb.append(i2);
        return hashtable.get(sb.toString()) != null;
    }

    public static final boolean[] parseIdx(String str, int i) {
        int length = str.length();
        str.charAt(0);
        boolean[] zArr = new boolean[i];
        int i2 = -1;
        boolean z = false;
        int i3 = -1;
        for (int i4 = 1; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isDigit(cCharAt)) {
                if (i2 == -1) {
                    i2 = 0;
                }
                i2 = (i2 * 10) + (cCharAt - 48);
            } else {
                if (i2 == -1 || !(cCharAt == ',' || cCharAt == '-')) {
                    throw new IllegalArgumentException("Bad construction for parameter: " + str);
                }
                if (i2 < 0 || i2 >= i) {
                    throw new IllegalArgumentException("Out of range index in parameter `" + str + "' : " + i2);
                }
                if (cCharAt == ',') {
                    if (z) {
                        while (true) {
                            i3++;
                            if (i3 >= i2) {
                                break;
                            }
                            zArr[i3] = true;
                        }
                    }
                    z = false;
                } else {
                    z = true;
                }
                zArr[i2] = true;
                i3 = i2;
                i2 = -1;
            }
        }
        if (i2 < 0 || i2 >= i) {
            throw new IllegalArgumentException("Out of range index in parameter `" + str + "' : " + i2);
        }
        if (z) {
            for (int i5 = i3 + 1; i5 < i2; i5++) {
                zArr[i5] = true;
            }
        }
        zArr[i2] = true;
        return zArr;
    }
}
