package jj2000.j2k.codestream;

import java.util.Hashtable;
import jj2000.j2k.quantization.quantizer.StdQuantizer;
import jj2000.j2k.wavelet.FilterTypes;

/* loaded from: classes5.dex */
public class HeaderInfo implements Markers, ProgressionType, FilterTypes, Cloneable {
    public CRG crg;
    public SIZ siz;
    public Hashtable sot = new Hashtable();
    public Hashtable cod = new Hashtable();
    public Hashtable coc = new Hashtable();
    public Hashtable rgn = new Hashtable();
    public Hashtable qcd = new Hashtable();
    public Hashtable qcc = new Hashtable();
    public Hashtable poc = new Hashtable();

    /* renamed from: com, reason: collision with root package name */
    public Hashtable f5com = new Hashtable();
    private int ncom = 0;

    public class SIZ implements Cloneable {
        public int csiz;
        public int lsiz;
        public int rsiz;
        public int[] ssiz;
        public int x0siz;
        public int[] xrsiz;
        public int xsiz;
        public int xt0siz;
        public int xtsiz;
        public int y0siz;
        public int[] yrsiz;
        public int ysiz;
        public int yt0siz;
        public int ytsiz;
        private int[] compWidth = null;
        private int maxCompWidth = -1;
        private int[] compHeight = null;
        private int maxCompHeight = -1;
        private int numTiles = -1;
        private boolean[] origSigned = null;
        private int[] origBitDepth = null;

        public SIZ() {
        }

        public int getCompImgWidth(int i) {
            if (this.compWidth == null) {
                this.compWidth = new int[this.csiz];
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    this.compWidth[i2] = (int) (Math.ceil(this.xsiz / this.xrsiz[i2]) - Math.ceil(this.x0siz / this.xrsiz[i2]));
                }
            }
            return this.compWidth[i];
        }

        public int getMaxCompWidth() {
            if (this.compWidth == null) {
                this.compWidth = new int[this.csiz];
                for (int i = 0; i < this.csiz; i++) {
                    this.compWidth[i] = (int) (Math.ceil(this.xsiz / this.xrsiz[i]) - Math.ceil(this.x0siz / this.xrsiz[i]));
                }
            }
            if (this.maxCompWidth == -1) {
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    int i3 = this.compWidth[i2];
                    if (i3 > this.maxCompWidth) {
                        this.maxCompWidth = i3;
                    }
                }
            }
            return this.maxCompWidth;
        }

        public int getCompImgHeight(int i) {
            if (this.compHeight == null) {
                this.compHeight = new int[this.csiz];
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    this.compHeight[i2] = (int) (Math.ceil(this.ysiz / this.yrsiz[i2]) - Math.ceil(this.y0siz / this.yrsiz[i2]));
                }
            }
            return this.compHeight[i];
        }

        public int getMaxCompHeight() {
            if (this.compHeight == null) {
                this.compHeight = new int[this.csiz];
                for (int i = 0; i < this.csiz; i++) {
                    this.compHeight[i] = (int) (Math.ceil(this.ysiz / this.yrsiz[i]) - Math.ceil(this.y0siz / this.yrsiz[i]));
                }
            }
            if (this.maxCompHeight == -1) {
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    int i3 = this.compHeight[i2];
                    if (i3 != this.maxCompHeight) {
                        this.maxCompHeight = i3;
                    }
                }
            }
            return this.maxCompHeight;
        }

        public int getNumTiles() {
            if (this.numTiles == -1) {
                int i = this.xsiz - this.xt0siz;
                int i2 = ((i + r1) - 1) / this.xtsiz;
                int i3 = this.ysiz - this.yt0siz;
                this.numTiles = i2 * (((i3 + r2) - 1) / this.ytsiz);
            }
            return this.numTiles;
        }

        public boolean isOrigSigned(int i) {
            if (this.origSigned == null) {
                this.origSigned = new boolean[this.csiz];
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    boolean[] zArr = this.origSigned;
                    boolean z = true;
                    if ((this.ssiz[i2] >>> 7) != 1) {
                        z = false;
                    }
                    zArr[i2] = z;
                }
            }
            return this.origSigned[i];
        }

        public int getOrigBitDepth(int i) {
            if (this.origBitDepth == null) {
                this.origBitDepth = new int[this.csiz];
                for (int i2 = 0; i2 < this.csiz; i2++) {
                    this.origBitDepth[i2] = (this.ssiz[i2] & 127) + 1;
                }
            }
            return this.origBitDepth[i];
        }

        public SIZ getCopy() {
            try {
                return (SIZ) clone();
            } catch (CloneNotSupportedException unused) {
                throw new Error("Cannot clone SIZ marker segment");
            }
        }

        public String toString() {
            String str = ((((("\n --- SIZ (" + this.lsiz + " bytes) ---\n") + " Capabilities : " + this.rsiz + "\n") + " Image dim.   : " + (this.xsiz - this.x0siz) + "x" + (this.ysiz - this.y0siz) + ", (off=" + this.x0siz + "," + this.y0siz + ")\n") + " Tile dim.    : " + this.xtsiz + "x" + this.ytsiz + ", (off=" + this.xt0siz + "," + this.yt0siz + ")\n") + " Component(s) : " + this.csiz + "\n") + " Orig. depth  : ";
            for (int i = 0; i < this.csiz; i++) {
                str = str + getOrigBitDepth(i) + " ";
            }
            String str2 = (str + "\n") + " Orig. signed : ";
            for (int i2 = 0; i2 < this.csiz; i2++) {
                str2 = str2 + isOrigSigned(i2) + " ";
            }
            String str3 = (str2 + "\n") + " Subs. factor : ";
            for (int i3 = 0; i3 < this.csiz; i3++) {
                str3 = str3 + this.xrsiz[i3] + "," + this.yrsiz[i3] + " ";
            }
            return str3 + "\n";
        }
    }

    public SIZ getNewSIZ() {
        return new SIZ();
    }

    public class SOT {
        public int isot;
        public int lsot;
        public int psot;
        public int tnsot;
        public int tpsot;

        public SOT() {
        }

        public String toString() {
            return ((((("\n --- SOT (" + this.lsot + " bytes) ---\n") + "Tile index         : " + this.isot + "\n") + "Tile-part length   : " + this.psot + " bytes\n") + "Tile-part index    : " + this.tpsot + "\n") + "Num. of tile-parts : " + this.tnsot + "\n") + "\n";
        }
    }

    public SOT getNewSOT() {
        return new SOT();
    }

    public class COD implements Cloneable {
        public int lcod;
        public int scod;
        public int sgcod_mct;
        public int sgcod_nl;
        public int sgcod_po;
        public int spcod_ch;
        public int spcod_cs;
        public int spcod_cw;
        public int spcod_ndl;
        public int[] spcod_ps;
        public int[] spcod_t = new int[1];

        public COD() {
        }

        public COD getCopy() {
            try {
                return (COD) clone();
            } catch (CloneNotSupportedException unused) {
                throw new Error("Cannot clone SIZ marker segment");
            }
        }

        public String toString() {
            String str = ("\n --- COD (" + this.lcod + " bytes) ---\n") + " Coding style   : ";
            int i = this.scod;
            if (i == 0) {
                str = str + "Default";
            } else {
                if ((i & 1) != 0) {
                    str = str + "Precints ";
                }
                if ((this.scod & 2) != 0) {
                    str = str + "SOP ";
                }
                if ((this.scod & 4) != 0) {
                    str = str + "EPH ";
                }
                int i2 = this.scod;
                int i3 = (i2 & 8) != 0 ? 1 : 0;
                int i4 = (i2 & 16) != 0 ? 1 : 0;
                if (i3 != 0 || i4 != 0) {
                    str = (str + "Code-blocks offset") + "\n Cblk partition : " + i3 + "," + i4;
                }
            }
            String str2 = (str + "\n") + " Cblk style     : ";
            int i5 = this.spcod_cs;
            if (i5 == 0) {
                str2 = str2 + "Default";
            } else {
                if ((i5 & 1) != 0) {
                    str2 = str2 + "Bypass ";
                }
                if ((this.spcod_cs & 2) != 0) {
                    str2 = str2 + "Reset ";
                }
                if ((this.spcod_cs & 4) != 0) {
                    str2 = str2 + "Terminate ";
                }
                if ((this.spcod_cs & 8) != 0) {
                    str2 = str2 + "Vert_causal ";
                }
                if ((this.spcod_cs & 16) != 0) {
                    str2 = str2 + "Predict ";
                }
                if ((this.spcod_cs & 32) != 0) {
                    str2 = str2 + "Seg_symb ";
                }
            }
            String str3 = (str2 + "\n") + " Num. of levels : " + this.spcod_ndl + "\n";
            int i6 = this.sgcod_po;
            if (i6 == 0) {
                str3 = str3 + " Progress. type : LY_RES_COMP_POS_PROG\n";
            } else if (i6 == 1) {
                str3 = str3 + " Progress. type : RES_LY_COMP_POS_PROG\n";
            } else if (i6 == 2) {
                str3 = str3 + " Progress. type : RES_POS_COMP_LY_PROG\n";
            } else if (i6 == 3) {
                str3 = str3 + " Progress. type : POS_COMP_RES_LY_PROG\n";
            } else if (i6 == 4) {
                str3 = str3 + " Progress. type : COMP_POS_RES_LY_PROG\n";
            }
            String str4 = (str3 + " Num. of layers : " + this.sgcod_nl + "\n") + " Cblk dimension : " + (1 << (this.spcod_cw + 2)) + "x" + (1 << (this.spcod_ch + 2)) + "\n";
            int i7 = this.spcod_t[0];
            if (i7 == 0) {
                str4 = str4 + " Filter         : 9-7 irreversible\n";
            } else if (i7 == 1) {
                str4 = str4 + " Filter         : 5-3 reversible\n";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(" Multi comp tr. : ");
            sb.append(this.sgcod_mct == 1);
            sb.append("\n");
            String string = sb.toString();
            if (this.spcod_ps != null) {
                string = string + " Precincts      : ";
                for (int i8 = 0; i8 < this.spcod_ps.length; i8++) {
                    string = string + (1 << (this.spcod_ps[i8] & 15)) + "x" + (1 << ((this.spcod_ps[i8] & 240) >> 4)) + " ";
                }
            }
            return string + "\n";
        }
    }

    public COD getNewCOD() {
        return new COD();
    }

    public class COC {
        public int ccoc;
        public int lcoc;
        public int scoc;
        public int spcoc_ch;
        public int spcoc_cs;
        public int spcoc_cw;
        public int spcoc_ndl;
        public int[] spcoc_ps;
        public int[] spcoc_t = new int[1];

        public COC() {
        }

        public String toString() {
            String str = (("\n --- COC (" + this.lcoc + " bytes) ---\n") + " Component      : " + this.ccoc + "\n") + " Coding style   : ";
            int i = this.scoc;
            if (i == 0) {
                str = str + "Default";
            } else {
                if ((i & 1) != 0) {
                    str = str + "Precints ";
                }
                if ((this.scoc & 2) != 0) {
                    str = str + "SOP ";
                }
                if ((this.scoc & 4) != 0) {
                    str = str + "EPH ";
                }
            }
            String str2 = (str + "\n") + " Cblk style     : ";
            int i2 = this.spcoc_cs;
            if (i2 == 0) {
                str2 = str2 + "Default";
            } else {
                if ((i2 & 1) != 0) {
                    str2 = str2 + "Bypass ";
                }
                if ((this.spcoc_cs & 2) != 0) {
                    str2 = str2 + "Reset ";
                }
                if ((this.spcoc_cs & 4) != 0) {
                    str2 = str2 + "Terminate ";
                }
                if ((this.spcoc_cs & 8) != 0) {
                    str2 = str2 + "Vert_causal ";
                }
                if ((this.spcoc_cs & 16) != 0) {
                    str2 = str2 + "Predict ";
                }
                if ((this.spcoc_cs & 32) != 0) {
                    str2 = str2 + "Seg_symb ";
                }
            }
            String str3 = ((str2 + "\n") + " Num. of levels : " + this.spcoc_ndl + "\n") + " Cblk dimension : " + (1 << (this.spcoc_cw + 2)) + "x" + (1 << (this.spcoc_ch + 2)) + "\n";
            int i3 = this.spcoc_t[0];
            if (i3 == 0) {
                str3 = str3 + " Filter         : 9-7 irreversible\n";
            } else if (i3 == 1) {
                str3 = str3 + " Filter         : 5-3 reversible\n";
            }
            if (this.spcoc_ps != null) {
                str3 = str3 + " Precincts      : ";
                for (int i4 = 0; i4 < this.spcoc_ps.length; i4++) {
                    str3 = str3 + (1 << (this.spcoc_ps[i4] & 15)) + "x" + (1 << ((this.spcoc_ps[i4] & 240) >> 4)) + " ";
                }
            }
            return str3 + "\n";
        }
    }

    public COC getNewCOC() {
        return new COC();
    }

    public class RGN {
        public int crgn;
        public int lrgn;
        public int sprgn;
        public int srgn;

        public RGN() {
        }

        public String toString() {
            String str;
            String str2 = ("\n --- RGN (" + this.lrgn + " bytes) ---\n") + " Component : " + this.crgn + "\n";
            if (this.srgn == 0) {
                str = str2 + " ROI style : Implicit\n";
            } else {
                str = str2 + " ROI style : Unsupported\n";
            }
            return (str + " ROI shift : " + this.sprgn + "\n") + "\n";
        }
    }

    public RGN getNewRGN() {
        return new RGN();
    }

    public class QCD {
        public int lqcd;
        public int[][] spqcd;
        public int sqcd;
        private int qType = -1;
        private int gb = -1;

        public QCD() {
        }

        public int getQuantType() {
            if (this.qType == -1) {
                this.qType = this.sqcd & (-225);
            }
            return this.qType;
        }

        public int getNumGuardBits() {
            if (this.gb == -1) {
                this.gb = (this.sqcd >> 5) & 7;
            }
            return this.gb;
        }

        public String toString() {
            String str;
            String str2 = ("\n --- QCD (" + this.lqcd + " bytes) ---\n") + " Quant. type    : ";
            int quantType = getQuantType();
            if (quantType == 0) {
                str2 = str2 + "No quantization \n";
            } else if (quantType == 1) {
                str2 = str2 + "Scalar derived\n";
            } else if (quantType == 2) {
                str2 = str2 + "Scalar expounded\n";
            }
            String str3 = str2 + " Guard bits     : " + getNumGuardBits() + "\n";
            if (quantType == 0) {
                str = str3 + " Exponents   :\n";
                for (int i = 0; i < this.spqcd.length; i++) {
                    int i2 = 0;
                    while (true) {
                        int[][] iArr = this.spqcd;
                        int[] iArr2 = iArr[i];
                        if (i2 < iArr2.length) {
                            if (i == 0 && i2 == 0) {
                                str = str + "\tr=0 : " + ((iArr[0][0] >> 3) & 31) + "\n";
                            } else if (i != 0 && i2 > 0) {
                                str = str + "\tr=" + i + ",s=" + i2 + " : " + ((iArr2[i2] >> 3) & 31) + "\n";
                            }
                            i2++;
                        }
                    }
                }
            } else {
                str = str3 + " Exp / Mantissa : \n";
                for (int i3 = 0; i3 < this.spqcd.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        int[][] iArr3 = this.spqcd;
                        int[] iArr4 = iArr3[i3];
                        if (i4 < iArr4.length) {
                            if (i3 == 0 && i4 == 0) {
                                str = str + "\tr=0 : " + ((iArr3[0][0] >> 11) & 31) + " / " + (((-1.0f) - ((r9 & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r10)) + "\n";
                            } else if (i3 != 0 && i4 > 0) {
                                str = str + "\tr=" + i3 + ",s=" + i4 + " : " + ((iArr4[i4] >> 11) & 31) + " / " + (((-1.0f) - ((r9 & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r10)) + "\n";
                            }
                            i4++;
                        }
                    }
                }
            }
            return str + "\n";
        }
    }

    public QCD getNewQCD() {
        return new QCD();
    }

    public class QCC {
        public int cqcc;
        public int lqcc;
        public int[][] spqcc;
        public int sqcc;
        private int qType = -1;
        private int gb = -1;

        public QCC() {
        }

        public int getQuantType() {
            if (this.qType == -1) {
                this.qType = this.sqcc & (-225);
            }
            return this.qType;
        }

        public int getNumGuardBits() {
            if (this.gb == -1) {
                this.gb = (this.sqcc >> 5) & 7;
            }
            return this.gb;
        }

        public String toString() {
            String str;
            String str2 = (("\n --- QCC (" + this.lqcc + " bytes) ---\n") + " Component      : " + this.cqcc + "\n") + " Quant. type    : ";
            int quantType = getQuantType();
            if (quantType == 0) {
                str2 = str2 + "No quantization \n";
            } else if (quantType == 1) {
                str2 = str2 + "Scalar derived\n";
            } else if (quantType == 2) {
                str2 = str2 + "Scalar expounded\n";
            }
            String str3 = str2 + " Guard bits     : " + getNumGuardBits() + "\n";
            if (quantType == 0) {
                str = str3 + " Exponents   :\n";
                for (int i = 0; i < this.spqcc.length; i++) {
                    int i2 = 0;
                    while (true) {
                        int[][] iArr = this.spqcc;
                        int[] iArr2 = iArr[i];
                        if (i2 < iArr2.length) {
                            if (i == 0 && i2 == 0) {
                                str = str + "\tr=0 : " + ((iArr[0][0] >> 3) & 31) + "\n";
                            } else if (i != 0 && i2 > 0) {
                                str = str + "\tr=" + i + ",s=" + i2 + " : " + ((iArr2[i2] >> 3) & 31) + "\n";
                            }
                            i2++;
                        }
                    }
                }
            } else {
                str = str3 + " Exp / Mantissa : \n";
                for (int i3 = 0; i3 < this.spqcc.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        int[][] iArr3 = this.spqcc;
                        int[] iArr4 = iArr3[i3];
                        if (i4 < iArr4.length) {
                            if (i3 == 0 && i4 == 0) {
                                str = str + "\tr=0 : " + ((iArr3[0][0] >> 11) & 31) + " / " + (((-1.0f) - ((r9 & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r10)) + "\n";
                            } else if (i3 != 0 && i4 > 0) {
                                str = str + "\tr=" + i3 + ",s=" + i4 + " : " + ((iArr4[i4] >> 11) & 31) + " / " + (((-1.0f) - ((r9 & StdQuantizer.QSTEP_MAX_MANTISSA) / 2048.0f)) / ((-1) << r10)) + "\n";
                            }
                            i4++;
                        }
                    }
                }
            }
            return str + "\n";
        }
    }

    public QCC getNewQCC() {
        return new QCC();
    }

    public class POC {
        public int[] cepoc;
        public int[] cspoc;
        public int lpoc;
        public int[] lyepoc;
        public int[] ppoc;
        public int[] repoc;
        public int[] rspoc;

        public POC() {
        }

        public String toString() {
            String str = ("\n --- POC (" + this.lpoc + " bytes) ---\n") + " Chg_idx RSpoc CSpoc LYEpoc REpoc CEpoc Ppoc\n";
            for (int i = 0; i < this.rspoc.length; i++) {
                str = str + "   " + i + "      " + this.rspoc[i] + "     " + this.cspoc[i] + "     " + this.lyepoc[i] + "      " + this.repoc[i] + "     " + this.cepoc[i];
                int i2 = this.ppoc[i];
                if (i2 == 0) {
                    str = str + "  LY_RES_COMP_POS_PROG\n";
                } else if (i2 == 1) {
                    str = str + "  RES_LY_COMP_POS_PROG\n";
                } else if (i2 == 2) {
                    str = str + "  RES_POS_COMP_LY_PROG\n";
                } else if (i2 == 3) {
                    str = str + "  POS_COMP_RES_LY_PROG\n";
                } else if (i2 == 4) {
                    str = str + "  COMP_POS_RES_LY_PROG\n";
                }
            }
            return str + "\n";
        }
    }

    public POC getNewPOC() {
        return new POC();
    }

    public class CRG {
        public int lcrg;
        public int[] xcrg;
        public int[] ycrg;

        public CRG() {
        }

        public String toString() {
            String str = "\n --- CRG (" + this.lcrg + " bytes) ---\n";
            for (int i = 0; i < this.xcrg.length; i++) {
                str = str + " Component " + i + " offset : " + this.xcrg[i] + "," + this.ycrg[i] + "\n";
            }
            return str + "\n";
        }
    }

    public CRG getNewCRG() {
        return new CRG();
    }

    public class COM {
        public byte[] ccom;
        public int lcom;
        public int rcom;

        public COM() {
        }

        public String toString() {
            String str;
            String str2 = "\n --- COM (" + this.lcom + " bytes) ---\n";
            int i = this.rcom;
            if (i == 0) {
                str = str2 + " Registration : General use (binary values)\n";
            } else if (i == 1) {
                str = (str2 + " Registration : General use (IS 8859-15:1999 (Latin) values)\n") + " Text         : " + new String(this.ccom) + "\n";
            } else {
                str = str2 + " Registration : Unknown\n";
            }
            return str + "\n";
        }
    }

    public COM getNewCOM() {
        this.ncom++;
        return new COM();
    }

    public int getNumCOM() {
        return this.ncom;
    }

    public String toStringMainHeader() {
        int i = this.siz.csiz;
        String string = "" + this.siz;
        if (this.cod.get("main") != null) {
            string = string + "" + ((COD) this.cod.get("main"));
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.coc.get("main_c" + i2) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append("");
                sb.append((COC) this.coc.get("main_c" + i2));
                string = sb.toString();
            }
        }
        if (this.qcd.get("main") != null) {
            string = string + "" + ((QCD) this.qcd.get("main"));
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (this.qcc.get("main_c" + i3) != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append("");
                sb2.append((QCC) this.qcc.get("main_c" + i3));
                string = sb2.toString();
            }
        }
        for (int i4 = 0; i4 < i; i4++) {
            if (this.rgn.get("main_c" + i4) != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append("");
                sb3.append((RGN) this.rgn.get("main_c" + i4));
                string = sb3.toString();
            }
        }
        if (this.poc.get("main") != null) {
            string = string + "" + ((POC) this.poc.get("main"));
        }
        if (this.crg != null) {
            string = string + "" + this.crg;
        }
        for (int i5 = 0; i5 < this.ncom; i5++) {
            if (this.f5com.get("main_" + i5) != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string);
                sb4.append("");
                sb4.append((COM) this.f5com.get("main_" + i5));
                string = sb4.toString();
            }
        }
        return string;
    }

    public String toStringTileHeader(int i, int i2) {
        int i3 = this.siz.csiz;
        String string = "";
        for (int i4 = 0; i4 < i2; i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(string + "Tile-part " + i4 + ", tile " + i + ":\n");
            sb.append("");
            sb.append((SOT) this.sot.get("t" + i + "_tp" + i4));
            string = sb.toString();
        }
        if (this.cod.get("t" + i) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append("");
            sb2.append((COD) this.cod.get("t" + i));
            string = sb2.toString();
        }
        for (int i5 = 0; i5 < i3; i5++) {
            if (this.coc.get("t" + i + "_c" + i5) != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append("");
                sb3.append((COC) this.coc.get("t" + i + "_c" + i5));
                string = sb3.toString();
            }
        }
        if (this.qcd.get("t" + i) != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string);
            sb4.append("");
            sb4.append((QCD) this.qcd.get("t" + i));
            string = sb4.toString();
        }
        for (int i6 = 0; i6 < i3; i6++) {
            if (this.qcc.get("t" + i + "_c" + i6) != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(string);
                sb5.append("");
                sb5.append((QCC) this.qcc.get("t" + i + "_c" + i6));
                string = sb5.toString();
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            if (this.rgn.get("t" + i + "_c" + i7) != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(string);
                sb6.append("");
                sb6.append((RGN) this.rgn.get("t" + i + "_c" + i7));
                string = sb6.toString();
            }
        }
        if (this.poc.get("t" + i) == null) {
            return string;
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(string);
        sb7.append("");
        sb7.append((POC) this.poc.get("t" + i));
        return sb7.toString();
    }

    public String toStringThNoSOT(int i, int i2) {
        String string;
        int i3 = this.siz.csiz;
        if (this.cod.get("t" + i) != null) {
            StringBuilder sb = new StringBuilder("");
            sb.append((COD) this.cod.get("t" + i));
            string = sb.toString();
        } else {
            string = "";
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.coc.get("t" + i + "_c" + i4) != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append("");
                sb2.append((COC) this.coc.get("t" + i + "_c" + i4));
                string = sb2.toString();
            }
        }
        if (this.qcd.get("t" + i) != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("");
            sb3.append((QCD) this.qcd.get("t" + i));
            string = sb3.toString();
        }
        for (int i5 = 0; i5 < i3; i5++) {
            if (this.qcc.get("t" + i + "_c" + i5) != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string);
                sb4.append("");
                sb4.append((QCC) this.qcc.get("t" + i + "_c" + i5));
                string = sb4.toString();
            }
        }
        for (int i6 = 0; i6 < i3; i6++) {
            if (this.rgn.get("t" + i + "_c" + i6) != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(string);
                sb5.append("");
                sb5.append((RGN) this.rgn.get("t" + i + "_c" + i6));
                string = sb5.toString();
            }
        }
        if (this.poc.get("t" + i) == null) {
            return string;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(string);
        sb6.append("");
        sb6.append((POC) this.poc.get("t" + i));
        return sb6.toString();
    }

    public HeaderInfo getCopy(int i) {
        try {
            HeaderInfo headerInfo = (HeaderInfo) clone();
            headerInfo.siz = this.siz.getCopy();
            if (this.cod.get("main") != null) {
                headerInfo.cod.put("main", ((COD) this.cod.get("main")).getCopy());
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (this.cod.get("t" + i2) != null) {
                    COD cod = (COD) this.cod.get("t" + i2);
                    headerInfo.cod.put("t" + i2, cod.getCopy());
                }
            }
            return headerInfo;
        } catch (CloneNotSupportedException unused) {
            throw new Error("Cannot clone HeaderInfo instance");
        }
    }
}
