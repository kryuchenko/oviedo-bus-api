package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

/* loaded from: classes6.dex */
public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    private int[] K;
    private byte[][] currentRootSigs;
    private byte[][] currentSeeds;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSKeyGenerationParameters gmssParams;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private boolean initialized = false;
    private int mdLength;
    private Digest messDigestTree;
    private byte[][] nextNextSeeds;
    private int numLayer;
    private int[] otsIndex;

    public GMSSKeyPairGenerator(GMSSDigestProvider gMSSDigestProvider) {
        this.digestProvider = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTree = digest;
        this.mdLength = digest.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTree);
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        int i;
        int i2;
        GMSSRootCalc gMSSRootCalcGenerateCurrentAuthpathAndRoot;
        if (!this.initialized) {
            initializeDefault();
        }
        int i3 = this.numLayer;
        byte[][][] bArr = new byte[i3][][];
        byte[][][] bArr2 = new byte[i3 - 1][][];
        Treehash[][] treehashArr = new Treehash[i3][];
        Treehash[][] treehashArr2 = new Treehash[i3 - 1][];
        Vector[] vectorArr = new Vector[i3];
        Vector[] vectorArr2 = new Vector[i3 - 1];
        Vector[][] vectorArr3 = new Vector[i3][];
        Vector[][] vectorArr4 = new Vector[i3 - 1][];
        int i4 = 0;
        while (true) {
            i = this.numLayer;
            if (i4 >= i) {
                break;
            }
            bArr[i4] = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.heightOfTrees[i4], this.mdLength);
            int i5 = this.heightOfTrees[i4];
            treehashArr[i4] = new Treehash[i5 - this.K[i4]];
            if (i4 > 0) {
                int i6 = i4 - 1;
                bArr2[i6] = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i5, this.mdLength);
                treehashArr2[i6] = new Treehash[this.heightOfTrees[i4] - this.K[i4]];
            }
            vectorArr[i4] = new Vector();
            if (i4 > 0) {
                vectorArr2[i4 - 1] = new Vector();
            }
            i4++;
        }
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, this.mdLength);
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.numLayer - 1, this.mdLength);
        byte[][] bArr5 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.numLayer, this.mdLength);
        int i7 = 0;
        while (true) {
            i2 = this.numLayer;
            if (i7 >= i2) {
                break;
            }
            System.arraycopy(this.currentSeeds[i7], 0, bArr5[i7], 0, this.mdLength);
            i7++;
        }
        this.currentRootSigs = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2 - 1, this.mdLength);
        int i8 = this.numLayer - 1;
        while (i8 >= 0) {
            byte[][] bArr6 = bArr5;
            GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i8], this.K[i8], this.digestProvider);
            try {
                if (i8 == this.numLayer - 1) {
                    gMSSRootCalcGenerateCurrentAuthpathAndRoot = generateCurrentAuthpathAndRoot(null, vectorArr[i8], bArr6[i8], i8);
                } else {
                    gMSSRootCalcGenerateCurrentAuthpathAndRoot = generateCurrentAuthpathAndRoot(bArr3[i8 + 1], vectorArr[i8], bArr6[i8], i8);
                }
                gMSSRootCalc = gMSSRootCalcGenerateCurrentAuthpathAndRoot;
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i9 = 0;
            while (i9 < this.heightOfTrees[i8]) {
                System.arraycopy(gMSSRootCalc.getAuthPath()[i9], 0, bArr[i8][i9], 0, this.mdLength);
                i9++;
                i8 = i8;
            }
            int i10 = i8;
            vectorArr3[i10] = gMSSRootCalc.getRetain();
            treehashArr[i10] = gMSSRootCalc.getTreehash();
            System.arraycopy(gMSSRootCalc.getRoot(), 0, bArr3[i10], 0, this.mdLength);
            i8 = i10 - 1;
            bArr5 = bArr6;
        }
        byte[][] bArr7 = bArr5;
        int i11 = this.numLayer - 2;
        while (i11 >= 0) {
            int i12 = i11 + 1;
            GMSSRootCalc gMSSRootCalcGenerateNextAuthpathAndRoot = generateNextAuthpathAndRoot(vectorArr2[i11], bArr7[i12], i12);
            int i13 = 0;
            while (i13 < this.heightOfTrees[i12]) {
                System.arraycopy(gMSSRootCalcGenerateNextAuthpathAndRoot.getAuthPath()[i13], 0, bArr2[i11][i13], 0, this.mdLength);
                i13++;
                gMSSRootCalcGenerateNextAuthpathAndRoot = gMSSRootCalcGenerateNextAuthpathAndRoot;
                i11 = i11;
                i12 = i12;
            }
            int i14 = i11;
            GMSSRootCalc gMSSRootCalc2 = gMSSRootCalcGenerateNextAuthpathAndRoot;
            vectorArr4[i14] = gMSSRootCalc2.getRetain();
            treehashArr2[i14] = gMSSRootCalc2.getTreehash();
            System.arraycopy(gMSSRootCalc2.getRoot(), 0, bArr4[i14], 0, this.mdLength);
            System.arraycopy(bArr7[i12], 0, this.nextNextSeeds[i14], 0, this.mdLength);
            i11 = i14 - 1;
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GMSSPublicKeyParameters(bArr3[0], this.gmssPS), (AsymmetricKeyParameter) new GMSSPrivateKeyParameters(this.currentSeeds, this.nextNextSeeds, bArr, bArr2, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, bArr4, this.currentRootSigs, this.gmssPS, this.digestProvider));
    }

    private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] bArr, Vector vector, byte[] bArr2, int i) {
        byte[] bArrVerify;
        int i2 = this.mdLength;
        byte[] bArr3 = new byte[i2];
        byte[] bArr4 = new byte[i2];
        byte[] bArrNextSeed = this.gmssRandom.nextSeed(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i], this.K[i], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        if (i == this.numLayer - 1) {
            bArrVerify = new WinternitzOTSignature(bArrNextSeed, this.digestProvider.get(), this.otsIndex[i]).getPublicKey();
        } else {
            this.currentRootSigs[i] = new WinternitzOTSignature(bArrNextSeed, this.digestProvider.get(), this.otsIndex[i]).getSignature(bArr);
            bArrVerify = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[i]).Verify(bArr, this.currentRootSigs[i]);
        }
        gMSSRootCalc.update(bArrVerify);
        int i3 = 3;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int i6 = this.heightOfTrees[i];
            if (i5 >= (1 << i6)) {
                break;
            }
            if (i5 == i3 && i4 < i6 - this.K[i]) {
                gMSSRootCalc.initializeTreehashSeed(bArr2, i4);
                i3 *= 2;
                i4++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr2), this.digestProvider.get(), this.otsIndex[i]).getPublicKey());
            i5++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private GMSSRootCalc generateNextAuthpathAndRoot(Vector vector, byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.numLayer];
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.heightOfTrees[i], this.K[i], this.digestProvider);
        gMSSRootCalc.initialize(vector);
        int i2 = 3;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.heightOfTrees[i];
            if (i3 >= (1 << i5)) {
                break;
            }
            if (i3 == i2 && i4 < i5 - this.K[i]) {
                gMSSRootCalc.initializeTreehashSeed(bArr, i4);
                i2 *= 2;
                i4++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr), this.digestProvider.get(), this.otsIndex[i]).getPublicKey());
            i3++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    public void initialize(int i, SecureRandom secureRandom) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters;
        if (i <= 10) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else if (i <= 20) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2}));
        } else {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        }
        initialize(gMSSKeyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        this.gmssParams = (GMSSKeyGenerationParameters) keyGenerationParameters;
        GMSSParameters gMSSParameters = new GMSSParameters(this.gmssParams.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
        this.gmssPS = gMSSParameters;
        this.numLayer = gMSSParameters.getNumOfLayers();
        this.heightOfTrees = this.gmssPS.getHeightOfTrees();
        this.otsIndex = this.gmssPS.getWinternitzParameter();
        this.K = this.gmssPS.getK();
        this.currentSeeds = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.numLayer, this.mdLength);
        this.nextNextSeeds = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.numLayer - 1, this.mdLength);
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < this.numLayer; i++) {
            secureRandom.nextBytes(this.currentSeeds[i]);
            this.gmssRandom.nextSeed(this.currentSeeds[i]);
        }
        this.initialized = true;
    }

    private void initializeDefault() {
        initialize(new GMSSKeyGenerationParameters(new SecureRandom(), new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }
}
