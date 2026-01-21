package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

/* loaded from: classes6.dex */
public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;
    private SecureRandom sr;
    private int[] vi;

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
        int[] iArr = this.vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.rainbowParams = rainbowKeyGenerationParameters;
        this.sr = rainbowKeyGenerationParameters.getRandom();
        this.vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    private void generateL1() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1] - iArr[0];
        this.A1 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i, i);
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A1[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.A1);
        }
        this.b1 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b1[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1];
        this.A2 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i, i);
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A2inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A2[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.A2);
        }
        this.b2 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b2[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i = 0;
        while (i < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.vi;
            int i2 = i + 1;
            layerArr[i] = new Layer(iArr[i], iArr[i2], this.sr);
            i = i2;
        }
    }

    private void computePublicKey() {
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.vi;
        int i = 0;
        int i2 = iArr[iArr.length - 1] - iArr[0];
        int i3 = iArr[iArr.length - 1];
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, i2, i3, i3);
        this.pub_singular = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i2, i3);
        this.pub_scalar = new short[i2];
        short[] sArr2 = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i4 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i4].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i4].getCoeffBeta();
            short[][] coeffGamma = this.layers[i4].getCoeffGamma();
            short[] coeffEta = this.layers[i4].getCoeffEta();
            int length = coeffAlpha[i].length;
            int length2 = coeffBeta[i].length;
            while (i < length) {
                for (int i6 = 0; i6 < length; i6++) {
                    int i7 = 0;
                    while (i7 < length2) {
                        int i8 = i3;
                        int i9 = i;
                        int i10 = i6 + length2;
                        short[] sArrMultVect = computeInField.multVect(coeffAlpha[i][i6][i7], this.A2[i10]);
                        int i11 = i5 + i9;
                        int i12 = i7;
                        sArr[i11] = computeInField.addSquareMatrix(sArr[i11], computeInField.multVects(sArrMultVect, this.A2[i12]));
                        short[] sArrMultVect2 = computeInField.multVect(this.b2[i12], sArrMultVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i11] = computeInField.addVect(sArrMultVect2, sArr3[i11]);
                        short[] sArrMultVect3 = computeInField.multVect(this.b2[i10], computeInField.multVect(coeffAlpha[i9][i6][i12], this.A2[i12]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i11] = computeInField.addVect(sArrMultVect3, sArr4[i11]);
                        short sMultElem = GF2Field.multElem(coeffAlpha[i9][i6][i12], this.b2[i10]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i11] = GF2Field.addElem(sArr5[i11], GF2Field.multElem(sMultElem, this.b2[i12]));
                        i7 = i12 + 1;
                        i = i9;
                        i3 = i8;
                    }
                }
                int i13 = i3;
                int i14 = i;
                int i15 = 0;
                while (i15 < length2) {
                    int i16 = 0;
                    while (i16 < length2) {
                        short[] sArrMultVect4 = computeInField.multVect(coeffBeta[i14][i15][i16], this.A2[i15]);
                        int i17 = i5 + i14;
                        int i18 = i15;
                        int i19 = length2;
                        sArr[i17] = computeInField.addSquareMatrix(sArr[i17], computeInField.multVects(sArrMultVect4, this.A2[i16]));
                        short[] sArrMultVect5 = computeInField.multVect(this.b2[i16], sArrMultVect4);
                        short[][] sArr6 = this.pub_singular;
                        sArr6[i17] = computeInField.addVect(sArrMultVect5, sArr6[i17]);
                        short[] sArrMultVect6 = computeInField.multVect(this.b2[i18], computeInField.multVect(coeffBeta[i14][i18][i16], this.A2[i16]));
                        short[][] sArr7 = this.pub_singular;
                        sArr7[i17] = computeInField.addVect(sArrMultVect6, sArr7[i17]);
                        short sMultElem2 = GF2Field.multElem(coeffBeta[i14][i18][i16], this.b2[i18]);
                        short[] sArr8 = this.pub_scalar;
                        sArr8[i17] = GF2Field.addElem(sArr8[i17], GF2Field.multElem(sMultElem2, this.b2[i16]));
                        i16++;
                        i15 = i18;
                        length2 = i19;
                    }
                    i15++;
                }
                int i20 = length2;
                int i21 = 0;
                while (i21 < i20 + length) {
                    short[] sArrMultVect7 = computeInField.multVect(coeffGamma[i14][i21], this.A2[i21]);
                    short[][] sArr9 = this.pub_singular;
                    int i22 = i5 + i14;
                    sArr9[i22] = computeInField.addVect(sArrMultVect7, sArr9[i22]);
                    short[] sArr10 = this.pub_scalar;
                    int i23 = i21;
                    sArr10[i22] = GF2Field.addElem(sArr10[i22], GF2Field.multElem(coeffGamma[i14][i21], this.b2[i23]));
                    i21 = i23 + 1;
                }
                short[] sArr11 = this.pub_scalar;
                int i24 = i5 + i14;
                sArr11[i24] = GF2Field.addElem(sArr11[i24], coeffEta[i14]);
                i = i14 + 1;
                i3 = i13;
                length2 = i20;
            }
            i5 += length;
            i4++;
            i = 0;
        }
        int i25 = i3;
        short[][][] sArr12 = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, i2, i25, i25);
        short[][] sArr13 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i2, i25);
        short[] sArr14 = new short[i2];
        for (int i26 = 0; i26 < i2; i26++) {
            int i27 = 0;
            while (true) {
                short[][] sArr15 = this.A1;
                if (i27 < sArr15.length) {
                    sArr12[i26] = computeInField.addSquareMatrix(sArr12[i26], computeInField.multMatrix(sArr15[i26][i27], sArr[i27]));
                    sArr13[i26] = computeInField.addVect(sArr13[i26], computeInField.multVect(this.A1[i26][i27], this.pub_singular[i27]));
                    sArr14[i26] = GF2Field.addElem(sArr14[i26], GF2Field.multElem(this.A1[i26][i27], this.pub_scalar[i27]));
                    i27++;
                }
            }
            sArr14[i26] = GF2Field.addElem(sArr14[i26], this.b1[i26]);
        }
        this.pub_singular = sArr13;
        this.pub_scalar = sArr14;
        compactPublicKey(sArr12);
    }

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        this.pub_quadratic = (short[][]) Array.newInstance((Class<?>) Short.TYPE, length, ((length2 + 1) * length2) / 2);
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < length2; i3++) {
                for (int i4 = i3; i4 < length2; i4++) {
                    if (i4 == i3) {
                        this.pub_quadratic[i][i2] = sArr[i][i3][i4];
                    } else {
                        short[] sArr2 = this.pub_quadratic[i];
                        short[][] sArr3 = sArr[i];
                        sArr2[i2] = GF2Field.addElem(sArr3[i3][i4], sArr3[i4][i3]);
                    }
                    i2++;
                }
            }
        }
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
