package jj2000.j2k.codestream.writer;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.StringTokenizer;
import java.util.Vector;
import jj2000.j2k.codestream.Markers;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.entropy.Progression;
import jj2000.j2k.entropy.StdEntropyCoderOptions;
import jj2000.j2k.entropy.encoder.PostCompRateAllocator;
import jj2000.j2k.image.Coord;
import jj2000.j2k.image.ImgData;
import jj2000.j2k.image.Tiler;
import jj2000.j2k.io.BinaryDataOutput;
import jj2000.j2k.quantization.quantizer.StdQuantizer;
import jj2000.j2k.roi.encoder.ROIScaler;
import jj2000.j2k.util.MathUtil;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.wavelet.analysis.AnWTFilter;
import jj2000.j2k.wavelet.analysis.ForwardWT;
import jj2000.j2k.wavelet.analysis.SubbandAn;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class HeaderEncoder implements Markers, StdEntropyCoderOptions {
    public static final char OPT_PREFIX = 'H';
    private static final String[][] pinfo = {new String[]{"Hjj2000_COM", null, "Writes or not the JJ2000 COM marker in the codestream", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"HCOM", "<Comment 1>[#<Comment 2>[#<Comment3...>]]", "Adds COM marker segments in the codestream. Comments must be separated with '#' and are written into distinct maker segments.", null}};
    protected ByteArrayOutputStream baos;
    private int defimgn;
    private int deftilenr;
    protected ForwardWT dwt;
    private boolean enJJ2KMarkSeg;
    protected EncoderSpecs encSpec;
    protected DataOutputStream hbuf;
    protected boolean[] isOrigSig;
    private int nComp;
    protected ImgData origSrc;
    private String otherCOMMarkSeg;
    protected PostCompRateAllocator ralloc;
    protected ROIScaler roiSc;
    protected Tiler tiler;

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public HeaderEncoder(ImgData imgData, boolean[] zArr, ForwardWT forwardWT, Tiler tiler, EncoderSpecs encoderSpecs, ROIScaler rOIScaler, PostCompRateAllocator postCompRateAllocator, ParameterList parameterList) {
        this.enJJ2KMarkSeg = true;
        this.otherCOMMarkSeg = null;
        parameterList.checkList('H', ParameterList.toNameArray(pinfo));
        if (imgData.getNumComps() != zArr.length) {
            throw new IllegalArgumentException();
        }
        this.origSrc = imgData;
        this.isOrigSig = zArr;
        this.dwt = forwardWT;
        this.tiler = tiler;
        this.encSpec = encoderSpecs;
        this.roiSc = rOIScaler;
        this.ralloc = postCompRateAllocator;
        this.baos = new ByteArrayOutputStream();
        this.hbuf = new DataOutputStream(this.baos);
        this.nComp = imgData.getNumComps();
        this.enJJ2KMarkSeg = parameterList.getBooleanParameter("Hjj2000_COM");
        this.otherCOMMarkSeg = parameterList.getParameter("HCOM");
    }

    public void reset() {
        this.baos.reset();
        this.hbuf = new DataOutputStream(this.baos);
    }

    protected byte[] getBuffer() {
        return this.baos.toByteArray();
    }

    public int getLength() {
        return this.hbuf.size();
    }

    public void writeTo(BinaryDataOutput binaryDataOutput) throws IOException {
        byte[] buffer = getBuffer();
        int length = getLength();
        for (int i = 0; i < length; i++) {
            binaryDataOutput.writeByte(buffer[i]);
        }
    }

    protected int getBufferLength() {
        return this.baos.size();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getBuffer(), 0, getBufferLength());
    }

    private void writeSOC() throws IOException {
        this.hbuf.writeShort(-177);
    }

    private void writeSIZ() throws IOException {
        this.hbuf.writeShort(-175);
        this.hbuf.writeShort((this.nComp * 3) + 38);
        this.hbuf.writeShort(0);
        this.hbuf.writeInt(this.tiler.getImgWidth() + this.tiler.getImgULX());
        this.hbuf.writeInt(this.tiler.getImgHeight() + this.tiler.getImgULY());
        this.hbuf.writeInt(this.tiler.getImgULX());
        this.hbuf.writeInt(this.tiler.getImgULY());
        this.hbuf.writeInt(this.tiler.getNomTileWidth());
        this.hbuf.writeInt(this.tiler.getNomTileHeight());
        Coord tilingOrigin = this.tiler.getTilingOrigin(null);
        this.hbuf.writeInt(tilingOrigin.x);
        this.hbuf.writeInt(tilingOrigin.y);
        this.hbuf.writeShort(this.nComp);
        for (int i = 0; i < this.nComp; i++) {
            this.hbuf.write((this.origSrc.getNomRangeBits(i) - 1) | ((this.isOrigSig[i] ? 1 : 0) << 7));
            this.hbuf.write(this.tiler.getCompSubsX(i));
            this.hbuf.write(this.tiler.getCompSubsY(i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0249 A[PHI: r4
      0x0249: PHI (r4v31 boolean) = (r4v76 boolean), (r4v77 boolean) binds: [B:79:0x0247, B:64:0x01df] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeCOD(boolean z, int i) throws IOException {
        int iIntValue;
        int ppx;
        int ppy;
        Progression[] progressionArr;
        String str;
        boolean z2;
        int i2;
        Vector[] vectorArr;
        int iIntValue2;
        int iIntValue3;
        if (z) {
            iIntValue = ((Integer) this.encSpec.dls.getDefault()).intValue();
            ppx = this.encSpec.pss.getPPX(-1, -1, iIntValue);
            ppy = this.encSpec.pss.getPPY(-1, -1, iIntValue);
            progressionArr = (Progression[]) this.encSpec.pocs.getDefault();
        } else {
            iIntValue = ((Integer) this.encSpec.dls.getTileDef(i)).intValue();
            ppx = this.encSpec.pss.getPPX(i, -1, iIntValue);
            ppy = this.encSpec.pss.getPPY(i, -1, iIntValue);
            progressionArr = (Progression[]) this.encSpec.pocs.getTileDef(i);
        }
        int i3 = (ppx == 65535 && ppy == 65535) ? 0 : 1;
        int i4 = i3 != 0 ? iIntValue + 1 : 0;
        this.hbuf.writeShort(-174);
        this.hbuf.writeShort(i4 + 12);
        int i5 = (!z ? this.encSpec.sops.getTileDef(i).toString().equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON) : this.encSpec.sops.getDefault().toString().equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) ? i3 : i3 | 2;
        if (!z ? this.encSpec.ephs.getTileDef(i).toString().equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON) : this.encSpec.ephs.getDefault().toString().equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            i5 |= 4;
        }
        if (this.dwt.getCbULX() != 0) {
            i5 |= 8;
        }
        if (this.dwt.getCbULY() != 0) {
            i5 |= 16;
        }
        this.hbuf.write(i5);
        this.hbuf.write(progressionArr[0].type);
        this.hbuf.writeShort(this.ralloc.getNumLayers());
        if (z) {
            str = (String) this.encSpec.cts.getDefault();
        } else {
            str = (String) this.encSpec.cts.getTileDef(i);
        }
        if (str.equals("none")) {
            this.hbuf.write(0);
        } else {
            this.hbuf.write(1);
        }
        this.hbuf.write(iIntValue);
        if (z) {
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkWidth((byte) 0, -1, -1)) - 2);
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkHeight((byte) 0, -1, -1)) - 2);
        } else {
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkWidth((byte) 2, i, -1)) - 2);
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkHeight((byte) 2, i, -1)) - 2);
        }
        if (z) {
            boolean zEquals = ((String) this.encSpec.bms.getDefault()).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            boolean z3 = zEquals;
            if (((String) this.encSpec.mqrs.getDefault()).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z3 = (zEquals ? 1 : 0) | 2;
            }
            boolean z4 = z3;
            if (((String) this.encSpec.rts.getDefault()).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z4 = (z3 ? 1 : 0) | 4;
            }
            boolean z5 = z4;
            if (((String) this.encSpec.css.getDefault()).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z5 = (z4 ? 1 : 0) | '\b';
            }
            boolean z6 = z5;
            if (((String) this.encSpec.tts.getDefault()).equals("predict")) {
                z6 = (z5 ? 1 : 0) | 16;
            }
            i2 = z6;
            z2 = z6;
            if (((String) this.encSpec.sss.getDefault()).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                i2 = z2 | 32;
            }
        } else {
            boolean zEquals2 = ((String) this.encSpec.bms.getTileDef(i)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            boolean z7 = zEquals2;
            if (((String) this.encSpec.mqrs.getTileDef(i)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z7 = (zEquals2 ? 1 : 0) | 2;
            }
            boolean z8 = z7;
            if (((String) this.encSpec.rts.getTileDef(i)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z8 = (z7 ? 1 : 0) | 4;
            }
            boolean z9 = z8;
            if (((String) this.encSpec.css.getTileDef(i)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z9 = (z8 ? 1 : 0) | '\b';
            }
            boolean z10 = z9;
            if (((String) this.encSpec.tts.getTileDef(i)).equals("predict")) {
                z10 = (z9 ? 1 : 0) | 16;
            }
            i2 = z10;
            z2 = z10;
            if (((String) this.encSpec.sss.getTileDef(i)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            }
        }
        this.hbuf.write(i2);
        if (z) {
            this.hbuf.write(((AnWTFilter[][]) this.encSpec.wfs.getDefault())[0][0].getFilterType());
        } else {
            this.hbuf.write(((AnWTFilter[][]) this.encSpec.wfs.getTileDef(i))[0][0].getFilterType());
        }
        if (i3 != 0) {
            if (z) {
                vectorArr = (Vector[]) this.encSpec.pss.getDefault();
            } else {
                vectorArr = (Vector[]) this.encSpec.pss.getTileDef(i);
            }
            while (iIntValue >= 0) {
                if (iIntValue >= vectorArr[1].size()) {
                    Vector vector = vectorArr[1];
                    iIntValue2 = ((Integer) vector.elementAt(vector.size() - 1)).intValue();
                } else {
                    iIntValue2 = ((Integer) vectorArr[1].elementAt(iIntValue)).intValue();
                }
                int iLog2 = (MathUtil.log2(iIntValue2) << 4) & 240;
                if (iIntValue >= vectorArr[0].size()) {
                    Vector vector2 = vectorArr[0];
                    iIntValue3 = ((Integer) vector2.elementAt(vector2.size() - 1)).intValue();
                } else {
                    iIntValue3 = ((Integer) vectorArr[0].elementAt(iIntValue)).intValue();
                }
                this.hbuf.write(iLog2 | (MathUtil.log2(iIntValue3) & 15));
                iIntValue--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd A[PHI: r4
      0x01bd: PHI (r4v26 boolean) = (r4v68 boolean), (r4v69 boolean) binds: [B:57:0x01bb, B:42:0x0153] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeCOC(boolean z, int i, int i2) throws IOException {
        int iIntValue;
        int ppx;
        int ppy;
        boolean z2;
        int i3;
        Vector[] vectorArr;
        int iIntValue2;
        int iIntValue3;
        if (z) {
            iIntValue = ((Integer) this.encSpec.dls.getCompDef(i2)).intValue();
            ppx = this.encSpec.pss.getPPX(-1, i2, iIntValue);
            ppy = this.encSpec.pss.getPPY(-1, i2, iIntValue);
        } else {
            iIntValue = ((Integer) this.encSpec.dls.getTileCompVal(i, i2)).intValue();
            ppx = this.encSpec.pss.getPPX(i, i2, iIntValue);
            ppy = this.encSpec.pss.getPPY(i, i2, iIntValue);
        }
        int i4 = (ppx == 65535 && ppy == 65535) ? 0 : 1;
        int i5 = i4 != 0 ? iIntValue + 1 : 0;
        this.hbuf.writeShort(-173);
        this.hbuf.writeShort((this.nComp < 257 ? 1 : 2) + 8 + i5);
        if (this.nComp < 257) {
            this.hbuf.write(i2);
        } else {
            this.hbuf.writeShort(i2);
        }
        this.hbuf.write(i4);
        this.hbuf.write(iIntValue);
        if (z) {
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkWidth((byte) 1, -1, i2)) - 2);
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkHeight((byte) 1, -1, i2)) - 2);
        } else {
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkWidth((byte) 3, i, i2)) - 2);
            this.hbuf.write(MathUtil.log2(this.encSpec.cblks.getCBlkHeight((byte) 3, i, i2)) - 2);
        }
        if (z) {
            boolean zEquals = ((String) this.encSpec.bms.getCompDef(i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            boolean z3 = zEquals;
            if (((String) this.encSpec.mqrs.getCompDef(i2)).equalsIgnoreCase(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z3 = (zEquals ? 1 : 0) | 2;
            }
            boolean z4 = z3;
            if (((String) this.encSpec.rts.getCompDef(i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z4 = (z3 ? 1 : 0) | 4;
            }
            boolean z5 = z4;
            if (((String) this.encSpec.css.getCompDef(i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z5 = (z4 ? 1 : 0) | '\b';
            }
            boolean z6 = z5;
            if (((String) this.encSpec.tts.getCompDef(i2)).equals("predict")) {
                z6 = (z5 ? 1 : 0) | 16;
            }
            i3 = z6;
            z2 = z6;
            if (((String) this.encSpec.sss.getCompDef(i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                i3 = z2 | 32;
            }
        } else {
            boolean zEquals2 = ((String) this.encSpec.bms.getTileCompVal(i, i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON);
            boolean z7 = zEquals2;
            if (((String) this.encSpec.mqrs.getTileCompVal(i, i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z7 = (zEquals2 ? 1 : 0) | 2;
            }
            boolean z8 = z7;
            if (((String) this.encSpec.rts.getTileCompVal(i, i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z8 = (z7 ? 1 : 0) | 4;
            }
            boolean z9 = z8;
            if (((String) this.encSpec.css.getTileCompVal(i, i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                z9 = (z8 ? 1 : 0) | '\b';
            }
            boolean z10 = z9;
            if (((String) this.encSpec.tts.getTileCompVal(i, i2)).equals("predict")) {
                z10 = (z9 ? 1 : 0) | 16;
            }
            i3 = z10;
            z2 = z10;
            if (((String) this.encSpec.sss.getTileCompVal(i, i2)).equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            }
        }
        this.hbuf.write(i3);
        if (z) {
            this.hbuf.write(((AnWTFilter[][]) this.encSpec.wfs.getCompDef(i2))[0][0].getFilterType());
        } else {
            this.hbuf.write(((AnWTFilter[][]) this.encSpec.wfs.getTileCompVal(i, i2))[0][0].getFilterType());
        }
        if (i4 != 0) {
            if (z) {
                vectorArr = (Vector[]) this.encSpec.pss.getCompDef(i2);
            } else {
                vectorArr = (Vector[]) this.encSpec.pss.getTileCompVal(i, i2);
            }
            while (iIntValue >= 0) {
                if (iIntValue >= vectorArr[1].size()) {
                    Vector vector = vectorArr[1];
                    iIntValue2 = ((Integer) vector.elementAt(vector.size() - 1)).intValue();
                } else {
                    iIntValue2 = ((Integer) vectorArr[1].elementAt(iIntValue)).intValue();
                }
                int iLog2 = (MathUtil.log2(iIntValue2) << 4) & 240;
                if (iIntValue >= vectorArr[0].size()) {
                    Vector vector2 = vectorArr[0];
                    iIntValue3 = ((Integer) vector2.elementAt(vector2.size() - 1)).intValue();
                } else {
                    iIntValue3 = ((Integer) vectorArr[0].elementAt(iIntValue)).intValue();
                }
                this.hbuf.write(iLog2 | (MathUtil.log2(iIntValue3) & 15));
                iIntValue--;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeMainQCD() throws IOException {
        int i;
        int i2;
        String str = (String) this.encSpec.qts.getDefault();
        float fFloatValue = ((Float) this.encSpec.qsss.getDefault()).floatValue();
        int iIntValue = ((Integer) this.encSpec.gbs.getDefault()).intValue();
        boolean zEquals = str.equals("derived");
        boolean zEquals2 = str.equals("reversible");
        int iIntValue2 = ((Integer) this.encSpec.dls.getDefault()).intValue();
        int numTiles = this.dwt.getNumTiles();
        int numComps = this.dwt.getNumComps();
        int[] iArr = new int[2];
        boolean z = true;
        for (int i3 = 0; i3 < numTiles && z; i3++) {
            for (int i4 = 0; i4 < numComps && z; i4++) {
                int iIntValue3 = ((Integer) this.encSpec.dls.getTileCompVal(i3, i4)).intValue();
                String str2 = (String) this.encSpec.qts.getTileCompVal(i3, i4);
                if (iIntValue3 == iIntValue2 && str2.equals(str)) {
                    iArr[0] = i3;
                    iArr[1] = i4;
                    z = false;
                }
            }
        }
        if (z) {
            throw new Error("Default representative for quantization type  and number of decomposition levels not found  in main QCD marker segment. You have found a JJ2000 bug.");
        }
        SubbandAn anSubbandTree = this.dwt.getAnSubbandTree(iArr[0], iArr[1]);
        this.defimgn = this.dwt.getNomRangeBits(iArr[1]);
        int i5 = zEquals2 ? 0 : zEquals ? 1 : 2;
        this.hbuf.writeShort(-164);
        if (i5 == 0) {
            SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            i2 = 0;
            for (i = 0; i <= iIntValue2; i++) {
                for (SubbandAn subbandAn2 = subbandAn; subbandAn2 != null; subbandAn2 = (SubbandAn) subbandAn2.nextSubband()) {
                    i2++;
                }
                subbandAn = (SubbandAn) subbandAn.getNextResLevel();
            }
        } else if (i5 != 1) {
            if (i5 != 2) {
                throw new Error("Internal JJ2000 error");
            }
            SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            i2 = 0;
            while (i <= iIntValue2) {
            }
        } else {
            i2 = 1;
        }
        if (!zEquals2) {
            i2 *= 2;
        }
        this.hbuf.writeShort(i2 + 3);
        this.hbuf.write((iIntValue << 5) + i5);
        if (i5 == 0) {
            SubbandAn subbandAn4 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            for (int i6 = 0; i6 <= iIntValue2; i6++) {
                for (SubbandAn subbandAn5 = subbandAn4; subbandAn5 != null; subbandAn5 = (SubbandAn) subbandAn5.nextSubband()) {
                    this.hbuf.write((this.defimgn + subbandAn5.anGainExp) << 3);
                }
                subbandAn4 = (SubbandAn) subbandAn4.getNextResLevel();
            }
            return;
        }
        if (i5 == 1) {
            this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (1 << ((SubbandAn) anSubbandTree.getSubbandByIdx(0, 0)).level)));
            return;
        }
        if (i5 == 2) {
            SubbandAn subbandAn6 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            for (int i7 = 0; i7 <= iIntValue2; i7++) {
                for (SubbandAn subbandAn7 = subbandAn6; subbandAn7 != null; subbandAn7 = (SubbandAn) subbandAn7.nextSubband()) {
                    this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (subbandAn7.l2Norm * (1 << subbandAn7.anGainExp))));
                }
                subbandAn6 = (SubbandAn) subbandAn6.getNextResLevel();
            }
            return;
        }
        throw new Error("Internal JJ2000 error");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc A[LOOP:6: B:33:0x00c8->B:35:0x00cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeMainQCC(int i) throws IOException {
        SubbandAn subbandAn;
        int i2;
        int i3;
        int nomRangeBits = this.dwt.getNomRangeBits(i);
        String str = (String) this.encSpec.qts.getCompDef(i);
        float fFloatValue = ((Float) this.encSpec.qsss.getCompDef(i)).floatValue();
        int iIntValue = ((Integer) this.encSpec.gbs.getCompDef(i)).intValue();
        boolean zEquals = str.equals("reversible");
        boolean zEquals2 = str.equals("derived");
        int iIntValue2 = ((Integer) this.encSpec.dls.getCompDef(i)).intValue();
        int numTiles = this.dwt.getNumTiles();
        int numComps = this.dwt.getNumComps();
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        while (i4 < numTiles && z) {
            int i6 = 0;
            while (i6 < numComps && z) {
                int iIntValue3 = ((Integer) this.encSpec.dls.getTileCompVal(i4, i6)).intValue();
                int i7 = nomRangeBits;
                String str2 = (String) this.encSpec.qts.getTileCompVal(i4, i6);
                if (iIntValue3 == iIntValue2 && str2.equals(str)) {
                    i5 = i4;
                    z = false;
                }
                i6++;
                nomRangeBits = i7;
            }
            i4++;
            nomRangeBits = nomRangeBits;
        }
        int i8 = nomRangeBits;
        if (z) {
            throw new Error("Default representative for quantization type  and number of decomposition levels not found  in main QCC (c=" + i + ") marker segment. You have found a JJ2000 bug.");
        }
        SubbandAn anSubbandTree = this.dwt.getAnSubbandTree(i5, i);
        int i9 = zEquals ? 0 : zEquals2 ? 1 : 2;
        this.hbuf.writeShort(-163);
        if (i9 == 0) {
            iIntValue2 = anSubbandTree.resLvl;
            subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (subbandAn.resLvl != 0) {
                subbandAn = subbandAn.subb_LL;
            }
            i3 = 0;
            for (i2 = 0; i2 <= iIntValue2; i2++) {
                for (SubbandAn subbandAn2 = subbandAn; subbandAn2 != null; subbandAn2 = (SubbandAn) subbandAn2.nextSubband()) {
                    i3++;
                }
                subbandAn = (SubbandAn) subbandAn.getNextResLevel();
            }
        } else if (i9 != 1) {
            if (i9 != 2) {
                throw new Error("Internal JJ2000 error");
            }
            iIntValue2 = anSubbandTree.resLvl;
            subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (subbandAn.resLvl != 0) {
            }
            i3 = 0;
            while (i2 <= iIntValue2) {
            }
        } else {
            i3 = 1;
        }
        int i10 = (this.nComp < 257 ? 1 : 2) + 3;
        if (!zEquals) {
            i3 *= 2;
        }
        this.hbuf.writeShort(i10 + i3);
        if (this.nComp < 257) {
            this.hbuf.write(i);
        } else {
            this.hbuf.writeShort(i);
        }
        this.hbuf.write((iIntValue << 5) + i9);
        if (i9 == 0) {
            SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            for (int i11 = 0; i11 <= iIntValue2; i11++) {
                for (SubbandAn subbandAn4 = subbandAn3; subbandAn4 != null; subbandAn4 = (SubbandAn) subbandAn4.nextSubband()) {
                    this.hbuf.write((i8 + subbandAn4.anGainExp) << 3);
                }
                subbandAn3 = (SubbandAn) subbandAn3.getNextResLevel();
            }
            return;
        }
        int i12 = 1;
        if (i9 == 1) {
            this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (1 << ((SubbandAn) anSubbandTree.getSubbandByIdx(0, 0)).level)));
            return;
        }
        if (i9 == 2) {
            int i13 = anSubbandTree.resLvl;
            SubbandAn subbandAn5 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            int i14 = 0;
            while (i14 <= i13) {
                SubbandAn subbandAn6 = subbandAn5;
                while (subbandAn6 != null) {
                    this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (subbandAn6.l2Norm * (i12 << subbandAn6.anGainExp))));
                    subbandAn6 = (SubbandAn) subbandAn6.nextSubband();
                    i12 = 1;
                }
                subbandAn5 = (SubbandAn) subbandAn5.getNextResLevel();
                i14++;
                i12 = 1;
            }
            return;
        }
        throw new Error("Internal JJ2000 error");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeTileQCD(int i) throws IOException {
        int i2;
        int i3;
        String str = (String) this.encSpec.qts.getTileDef(i);
        float fFloatValue = ((Float) this.encSpec.qsss.getTileDef(i)).floatValue();
        int iIntValue = ((Integer) this.encSpec.dls.getTileDef(i)).intValue();
        int numComps = this.dwt.getNumComps();
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        for (int i6 = 0; i6 < numComps && z; i6++) {
            int iIntValue2 = ((Integer) this.encSpec.dls.getTileCompVal(i, i6)).intValue();
            String str2 = (String) this.encSpec.qts.getTileCompVal(i, i6);
            if (iIntValue2 == iIntValue && str2.equals(str)) {
                i5 = i6;
                z = false;
            }
        }
        if (z) {
            throw new Error("Default representative for quantization type  and number of decomposition levels not found  in tile QCD (t=" + i + ") marker segment. You have found a JJ2000 bug.");
        }
        SubbandAn anSubbandTree = this.dwt.getAnSubbandTree(i, i5);
        this.deftilenr = this.dwt.getNomRangeBits(i5);
        int iIntValue3 = ((Integer) this.encSpec.gbs.getTileDef(i)).intValue();
        boolean zEquals = str.equals("derived");
        boolean zEquals2 = str.equals("reversible");
        int i7 = zEquals2 ? 0 : zEquals ? 1 : 2;
        this.hbuf.writeShort(-164);
        if (i7 == 0) {
            SubbandAn subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            i3 = 0;
            for (i2 = 0; i2 <= iIntValue; i2++) {
                for (SubbandAn subbandAn2 = subbandAn; subbandAn2 != null; subbandAn2 = (SubbandAn) subbandAn2.nextSubband()) {
                    i3++;
                }
                subbandAn = (SubbandAn) subbandAn.getNextResLevel();
            }
        } else if (i7 != 1) {
            if (i7 != 2) {
                throw new Error("Internal JJ2000 error");
            }
            SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            i3 = 0;
            while (i2 <= iIntValue) {
            }
        } else {
            i3 = 1;
        }
        if (!zEquals2) {
            i3 *= 2;
        }
        this.hbuf.writeShort(i3 + 3);
        this.hbuf.write((iIntValue3 << 5) + i7);
        if (i7 == 0) {
            SubbandAn subbandAn4 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (i4 <= iIntValue) {
                for (SubbandAn subbandAn5 = subbandAn4; subbandAn5 != null; subbandAn5 = (SubbandAn) subbandAn5.nextSubband()) {
                    this.hbuf.write((this.deftilenr + subbandAn5.anGainExp) << 3);
                }
                subbandAn4 = (SubbandAn) subbandAn4.getNextResLevel();
                i4++;
            }
            return;
        }
        if (i7 == 1) {
            this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (1 << ((SubbandAn) anSubbandTree.getSubbandByIdx(0, 0)).level)));
            return;
        }
        if (i7 == 2) {
            SubbandAn subbandAn6 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (i4 <= iIntValue) {
                for (SubbandAn subbandAn7 = subbandAn6; subbandAn7 != null; subbandAn7 = (SubbandAn) subbandAn7.nextSubband()) {
                    this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (subbandAn7.l2Norm * (1 << subbandAn7.anGainExp))));
                }
                subbandAn6 = (SubbandAn) subbandAn6.getNextResLevel();
                i4++;
            }
            return;
        }
        throw new Error("Internal JJ2000 error");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082 A[LOOP:4: B:17:0x007e->B:19:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void writeTileQCC(int i, int i2) throws IOException {
        SubbandAn subbandAn;
        int i3;
        int i4;
        SubbandAn anSubbandTree = this.dwt.getAnSubbandTree(i, i2);
        int nomRangeBits = this.dwt.getNomRangeBits(i2);
        String str = (String) this.encSpec.qts.getTileCompVal(i, i2);
        float fFloatValue = ((Float) this.encSpec.qsss.getTileCompVal(i, i2)).floatValue();
        int iIntValue = ((Integer) this.encSpec.gbs.getTileCompVal(i, i2)).intValue();
        boolean zEquals = str.equals("reversible");
        boolean zEquals2 = str.equals("derived");
        int iIntValue2 = ((Integer) this.encSpec.dls.getTileCompVal(i, i2)).intValue();
        int i5 = 0;
        int i6 = zEquals ? 0 : zEquals2 ? 1 : 2;
        this.hbuf.writeShort(-163);
        if (i6 == 0) {
            iIntValue2 = anSubbandTree.resLvl;
            subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (subbandAn.resLvl != 0) {
                subbandAn = subbandAn.subb_LL;
            }
            i4 = 0;
            for (i3 = 0; i3 <= iIntValue2; i3++) {
                for (SubbandAn subbandAn2 = subbandAn; subbandAn2 != null; subbandAn2 = (SubbandAn) subbandAn2.nextSubband()) {
                    i4++;
                }
                subbandAn = (SubbandAn) subbandAn.getNextResLevel();
            }
        } else if (i6 != 1) {
            if (i6 != 2) {
                throw new Error("Internal JJ2000 error");
            }
            iIntValue2 = anSubbandTree.resLvl;
            subbandAn = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (subbandAn.resLvl != 0) {
            }
            i4 = 0;
            while (i3 <= iIntValue2) {
            }
        } else {
            i4 = 1;
        }
        int i7 = (this.nComp < 257 ? 1 : 2) + 3;
        if (!zEquals) {
            i4 *= 2;
        }
        this.hbuf.writeShort(i7 + i4);
        if (this.nComp < 257) {
            this.hbuf.write(i2);
        } else {
            this.hbuf.writeShort(i2);
        }
        this.hbuf.write((iIntValue << 5) + i6);
        if (i6 == 0) {
            SubbandAn subbandAn3 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (i5 <= iIntValue2) {
                for (SubbandAn subbandAn4 = subbandAn3; subbandAn4 != null; subbandAn4 = (SubbandAn) subbandAn4.nextSubband()) {
                    this.hbuf.write((subbandAn4.anGainExp + nomRangeBits) << 3);
                }
                subbandAn3 = (SubbandAn) subbandAn3.getNextResLevel();
                i5++;
            }
            return;
        }
        if (i6 == 1) {
            this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (1 << ((SubbandAn) anSubbandTree.getSubbandByIdx(0, 0)).level)));
            return;
        }
        if (i6 == 2) {
            int i8 = anSubbandTree.resLvl;
            SubbandAn subbandAn5 = (SubbandAn) anSubbandTree.getSubbandByIdx(0, 0);
            while (i5 <= i8) {
                for (SubbandAn subbandAn6 = subbandAn5; subbandAn6 != null; subbandAn6 = (SubbandAn) subbandAn6.nextSubband()) {
                    this.hbuf.writeShort(StdQuantizer.convertToExpMantissa(fFloatValue / (subbandAn6.l2Norm * (1 << subbandAn6.anGainExp))));
                }
                subbandAn5 = (SubbandAn) subbandAn5.getNextResLevel();
                i5++;
            }
            return;
        }
        throw new Error("Internal JJ2000 error");
    }

    protected void writePOC(boolean z, int i) throws IOException {
        Progression[] progressionArr;
        if (z) {
            progressionArr = (Progression[]) this.encSpec.pocs.getDefault();
        } else {
            progressionArr = (Progression[]) this.encSpec.pocs.getTileDef(i);
        }
        int i2 = this.nComp < 257 ? 1 : 2;
        this.hbuf.writeShort(-161);
        int length = progressionArr.length;
        this.hbuf.writeShort(((i2 + 4 + i2 + 1) * length) + 2);
        for (int i3 = 0; i3 < length; i3++) {
            this.hbuf.write(progressionArr[i3].rs);
            if (i2 == 2) {
                this.hbuf.writeShort(progressionArr[i3].cs);
            } else {
                this.hbuf.write(progressionArr[i3].cs);
            }
            this.hbuf.writeShort(progressionArr[i3].lye);
            this.hbuf.write(progressionArr[i3].re);
            if (i2 == 2) {
                this.hbuf.writeShort(progressionArr[i3].ce);
            } else {
                this.hbuf.write(progressionArr[i3].ce);
            }
            this.hbuf.write(progressionArr[i3].type);
        }
    }

    public void encodeMainHeader() throws IOException {
        writeSOC();
        writeSIZ();
        boolean zEquals = ((String) this.encSpec.tts.getDefault()).equals("predict");
        writeCOD(true, 0);
        for (int i = 0; i < this.nComp; i++) {
            boolean zEquals2 = ((String) this.encSpec.tts.getCompDef(i)).equals("predict");
            if (this.encSpec.wfs.isCompSpecified(i) || this.encSpec.dls.isCompSpecified(i) || this.encSpec.bms.isCompSpecified(i) || this.encSpec.mqrs.isCompSpecified(i) || this.encSpec.rts.isCompSpecified(i) || this.encSpec.sss.isCompSpecified(i) || this.encSpec.css.isCompSpecified(i) || this.encSpec.pss.isCompSpecified(i) || this.encSpec.cblks.isCompSpecified(i) || zEquals != zEquals2) {
                writeCOC(true, 0, i);
            }
        }
        writeMainQCD();
        for (int i2 = 0; i2 < this.nComp; i2++) {
            if (this.dwt.getNomRangeBits(i2) != this.defimgn || this.encSpec.qts.isCompSpecified(i2) || this.encSpec.qsss.isCompSpecified(i2) || this.encSpec.dls.isCompSpecified(i2) || this.encSpec.gbs.isCompSpecified(i2)) {
                writeMainQCC(i2);
            }
        }
        if (((Progression[]) this.encSpec.pocs.getDefault()).length > 1) {
            writePOC(true, 0);
        }
        writeCOM();
    }

    private void writeCOM() throws IOException {
        if (this.enJJ2KMarkSeg) {
            this.hbuf.writeShort(-156);
            this.hbuf.writeShort(34);
            this.hbuf.writeShort(1);
            for (byte b : "Created by: JJ2000 version 5.1".getBytes()) {
                this.hbuf.writeByte(b);
            }
        }
        if (this.otherCOMMarkSeg != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.otherCOMMarkSeg, "#");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                this.hbuf.writeShort(-156);
                this.hbuf.writeShort(strNextToken.length() + 4);
                this.hbuf.writeShort(1);
                for (byte b2 : strNextToken.getBytes()) {
                    this.hbuf.writeByte(b2);
                }
            }
        }
    }

    private void writeRGN(int i) throws IOException {
        for (int i2 = 0; i2 < this.nComp; i2++) {
            this.hbuf.writeShort(-162);
            this.hbuf.writeShort((this.nComp < 257 ? 1 : 2) + 4);
            if (this.nComp < 257) {
                this.hbuf.writeByte(i2);
            } else {
                this.hbuf.writeShort(i2);
            }
            this.hbuf.writeByte(0);
            this.hbuf.writeByte(((Integer) this.encSpec.rois.getTileCompVal(i, i2)).intValue());
        }
    }

    public void encodeTilePartHeader(int i, int i2) throws IOException {
        boolean z;
        boolean z2;
        Coord numTiles = this.ralloc.getNumTiles(null);
        this.ralloc.setTile(i2 % numTiles.x, i2 / numTiles.x);
        this.hbuf.writeByte(-1);
        this.hbuf.writeByte(-112);
        this.hbuf.writeByte(0);
        this.hbuf.writeByte(10);
        if (i2 > 65534) {
            throw new IllegalArgumentException("Trying to write a tile-part header whose tile index is too high");
        }
        this.hbuf.writeByte(i2 >> 8);
        this.hbuf.writeByte(i2);
        this.hbuf.writeByte(i >> 24);
        this.hbuf.writeByte(i >> 16);
        this.hbuf.writeByte(i >> 8);
        this.hbuf.writeByte(i);
        this.hbuf.writeByte(0);
        this.hbuf.writeByte(1);
        boolean zEquals = ((String) this.encSpec.tts.getDefault()).equals("predict");
        boolean zEquals2 = ((String) this.encSpec.tts.getTileDef(i2)).equals("predict");
        if (this.encSpec.wfs.isTileSpecified(i2) || this.encSpec.cts.isTileSpecified(i2) || this.encSpec.dls.isTileSpecified(i2) || this.encSpec.bms.isTileSpecified(i2) || this.encSpec.mqrs.isTileSpecified(i2) || this.encSpec.rts.isTileSpecified(i2) || this.encSpec.css.isTileSpecified(i2) || this.encSpec.pss.isTileSpecified(i2) || this.encSpec.sops.isTileSpecified(i2) || this.encSpec.sss.isTileSpecified(i2) || this.encSpec.pocs.isTileSpecified(i2) || this.encSpec.ephs.isTileSpecified(i2) || this.encSpec.cblks.isTileSpecified(i2) || zEquals != zEquals2) {
            writeCOD(false, i2);
            z = true;
        } else {
            z = false;
        }
        for (int i3 = 0; i3 < this.nComp; i3++) {
            boolean zEquals3 = ((String) this.encSpec.tts.getTileCompVal(i2, i3)).equals("predict");
            if (this.encSpec.wfs.isTileCompSpecified(i2, i3) || this.encSpec.dls.isTileCompSpecified(i2, i3) || this.encSpec.bms.isTileCompSpecified(i2, i3) || this.encSpec.mqrs.isTileCompSpecified(i2, i3) || this.encSpec.rts.isTileCompSpecified(i2, i3) || this.encSpec.css.isTileCompSpecified(i2, i3) || this.encSpec.pss.isTileCompSpecified(i2, i3) || this.encSpec.sss.isTileCompSpecified(i2, i3) || this.encSpec.cblks.isTileCompSpecified(i2, i3) || zEquals3 != zEquals) {
                writeCOC(false, i2, i3);
            } else if (z && (this.encSpec.wfs.isCompSpecified(i3) || this.encSpec.dls.isCompSpecified(i3) || this.encSpec.bms.isCompSpecified(i3) || this.encSpec.mqrs.isCompSpecified(i3) || this.encSpec.rts.isCompSpecified(i3) || this.encSpec.sss.isCompSpecified(i3) || this.encSpec.css.isCompSpecified(i3) || this.encSpec.pss.isCompSpecified(i3) || this.encSpec.cblks.isCompSpecified(i3) || (this.encSpec.tts.isCompSpecified(i3) && ((String) this.encSpec.tts.getCompDef(i3)).equals("predict")))) {
                writeCOC(false, i2, i3);
            }
        }
        if (this.encSpec.qts.isTileSpecified(i2) || this.encSpec.qsss.isTileSpecified(i2) || this.encSpec.dls.isTileSpecified(i2) || this.encSpec.gbs.isTileSpecified(i2)) {
            writeTileQCD(i2);
            z2 = true;
        } else {
            this.deftilenr = this.defimgn;
            z2 = false;
        }
        for (int i4 = 0; i4 < this.nComp; i4++) {
            if (this.dwt.getNomRangeBits(i4) != this.deftilenr || this.encSpec.qts.isTileCompSpecified(i2, i4) || this.encSpec.qsss.isTileCompSpecified(i2, i4) || this.encSpec.dls.isTileCompSpecified(i2, i4) || this.encSpec.gbs.isTileCompSpecified(i2, i4)) {
                writeTileQCC(i2, i4);
            } else if (z2 && (this.encSpec.qts.isCompSpecified(i4) || this.encSpec.qsss.isCompSpecified(i4) || this.encSpec.dls.isCompSpecified(i4) || this.encSpec.gbs.isCompSpecified(i4))) {
                writeTileQCC(i2, i4);
            }
        }
        if (this.roiSc.useRoi() && !this.roiSc.getBlockAligned()) {
            writeRGN(i2);
        }
        if (this.encSpec.pocs.isTileSpecified(i2) && ((Progression[]) this.encSpec.pocs.getTileDef(i2)).length > 1) {
            writePOC(false, i2);
        }
        this.hbuf.writeByte(-1);
        this.hbuf.writeByte(-109);
    }
}
