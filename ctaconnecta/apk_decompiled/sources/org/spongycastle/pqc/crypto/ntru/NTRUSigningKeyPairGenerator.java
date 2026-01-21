package org.spongycastle.pqc.crypto.ntru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Resultant;

/* loaded from: classes6.dex */
public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUSigningKeyGenerationParameters params;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i = this.params.B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            Object[] objArr = 0;
            if (i < 0) {
                break;
            }
            arrayList.add(executorServiceNewCachedThreadPool.submit(new BasisGenerationTask()));
            i--;
        }
        executorServiceNewCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = this.params.B; i2 >= 0; i2--) {
            Future future = (Future) arrayList.get(i2);
            try {
                arrayList2.add(future.get());
                if (i2 == this.params.B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).h, this.params.getSigningParameters());
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i = this.params.B; i >= 0; i--) {
            NTRUSigningPrivateKeyParameters.Basis basisGenerateBoundedBasis = generateBoundedBasis();
            arrayList.add(basisGenerateBoundedBasis);
            if (i == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(basisGenerateBoundedBasis.h, this.params.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList, nTRUSigningPublicKeyParameters));
    }

    private void minimizeFG(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += i * 2 * ((integerPolynomial.coeffs[i3] * integerPolynomial.coeffs[i3]) + (integerPolynomial2.coeffs[i3] * integerPolynomial2.coeffs[i3]));
        }
        int i4 = i2 - 4;
        IntegerPolynomial integerPolynomial5 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial6 = (IntegerPolynomial) integerPolynomial2.clone();
        int i5 = 0;
        int i6 = 0;
        while (i5 < i && i6 < i) {
            int i7 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                i7 += i * 4 * ((integerPolynomial3.coeffs[i8] * integerPolynomial.coeffs[i8]) + (integerPolynomial4.coeffs[i8] * integerPolynomial2.coeffs[i8]));
            }
            int iSumCoeffs = i7 - ((integerPolynomial3.sumCoeffs() + integerPolynomial4.sumCoeffs()) * 4);
            if (iSumCoeffs > i4) {
                integerPolynomial3.sub(integerPolynomial5);
                integerPolynomial4.sub(integerPolynomial6);
            } else if (iSumCoeffs < (-i4)) {
                integerPolynomial3.add(integerPolynomial5);
                integerPolynomial4.add(integerPolynomial6);
            } else {
                i6++;
                integerPolynomial5.rotate1();
                integerPolynomial6.rotate1();
            }
            i5++;
            i6 = 0;
            i6++;
            integerPolynomial5.rotate1();
            integerPolynomial6.rotate1();
        }
    }

    private FGBasis generateBasis() {
        Polynomial polynomialGenerateRandom;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial integerPolynomialInvertFq;
        Resultant resultant;
        Polynomial polynomialGenerateRandom2;
        IntegerPolynomial integerPolynomial2;
        int i;
        Resultant resultant2;
        BigIntEuclidean bigIntEuclideanCalculate;
        BigIntPolynomial bigIntPolynomialRound;
        IntegerPolynomial integerPolynomialMult;
        NTRUSigningKeyPairGenerator nTRUSigningKeyPairGenerator = this;
        int i2 = nTRUSigningKeyPairGenerator.params.N;
        int i3 = nTRUSigningKeyPairGenerator.params.q;
        int i4 = nTRUSigningKeyPairGenerator.params.d;
        int i5 = nTRUSigningKeyPairGenerator.params.d1;
        int i6 = nTRUSigningKeyPairGenerator.params.d2;
        int i7 = nTRUSigningKeyPairGenerator.params.d3;
        int i8 = nTRUSigningKeyPairGenerator.params.basisType;
        int i9 = (i2 * 2) + 1;
        boolean z = nTRUSigningKeyPairGenerator.params.primeCheck;
        while (true) {
            polynomialGenerateRandom = nTRUSigningKeyPairGenerator.params.polyType == 0 ? DenseTernaryPolynomial.generateRandom(i2, i4 + 1, i4, new SecureRandom()) : ProductFormPolynomial.generateRandom(i2, i5, i6, i7 + 1, i7, new SecureRandom());
            integerPolynomial = polynomialGenerateRandom.toIntegerPolynomial();
            if (!z || !integerPolynomial.resultant(i9).res.equals(BigInteger.ZERO)) {
                integerPolynomialInvertFq = integerPolynomial.invertFq(i3);
                if (integerPolynomialInvertFq != null) {
                    break;
                }
                nTRUSigningKeyPairGenerator = this;
            }
        }
        Resultant resultant3 = integerPolynomial.resultant();
        while (true) {
            if (nTRUSigningKeyPairGenerator.params.polyType == 0) {
                polynomialGenerateRandom2 = DenseTernaryPolynomial.generateRandom(i2, i4 + 1, i4, new SecureRandom());
                resultant = resultant3;
            } else {
                resultant = resultant3;
                polynomialGenerateRandom2 = ProductFormPolynomial.generateRandom(i2, i5, i6, i7 + 1, i7, new SecureRandom());
            }
            integerPolynomial2 = polynomialGenerateRandom2.toIntegerPolynomial();
            int i10 = i4;
            if (z) {
                i = i5;
                if (integerPolynomial2.resultant(i9).res.equals(BigInteger.ZERO)) {
                    resultant3 = resultant;
                    i4 = i10;
                    i5 = i;
                }
            } else {
                i = i5;
            }
            if (integerPolynomial2.invertFq(i3) != null) {
                resultant2 = integerPolynomial2.resultant();
                int i11 = i6;
                bigIntEuclideanCalculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                int i12 = i7;
                if (bigIntEuclideanCalculate.gcd.equals(BigInteger.ONE)) {
                    break;
                }
                nTRUSigningKeyPairGenerator = this;
                resultant3 = resultant;
                i4 = i10;
                i5 = i;
                i6 = i11;
                i7 = i12;
            } else {
                nTRUSigningKeyPairGenerator = this;
                resultant3 = resultant;
                i4 = i10;
                i5 = i;
            }
        }
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) resultant.rho.clone();
        bigIntPolynomial.mult(bigIntEuclideanCalculate.x.multiply(BigInteger.valueOf(i3)));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant2.rho.clone();
        bigIntPolynomial2.mult(bigIntEuclideanCalculate.y.multiply(BigInteger.valueOf(-i3)));
        int i13 = 0;
        if (nTRUSigningKeyPairGenerator.params.keyGenAlg == 0) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            iArr[0] = integerPolynomial.coeffs[0];
            iArr2[0] = integerPolynomial2.coeffs[0];
            for (int i14 = 1; i14 < i2; i14++) {
                int i15 = i2 - i14;
                iArr[i14] = integerPolynomial.coeffs[i15];
                iArr2[i14] = integerPolynomial2.coeffs[i15];
            }
            IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(iArr2);
            IntegerPolynomial integerPolynomialMult2 = polynomialGenerateRandom.mult(integerPolynomial3);
            integerPolynomialMult2.add(polynomialGenerateRandom2.mult(integerPolynomial4));
            Resultant resultant4 = integerPolynomialMult2.resultant();
            BigIntPolynomial bigIntPolynomialMult = integerPolynomial3.mult(bigIntPolynomial2);
            bigIntPolynomialMult.add(integerPolynomial4.mult(bigIntPolynomial));
            bigIntPolynomialRound = bigIntPolynomialMult.mult(resultant4.rho);
            bigIntPolynomialRound.div(resultant4.res);
        } else {
            for (int i16 = 1; i16 < i2; i16 *= 10) {
                i13++;
            }
            BigDecimalPolynomial bigDecimalPolynomialDiv = resultant.rho.div(new BigDecimal(resultant.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i13);
            BigDecimalPolynomial bigDecimalPolynomialDiv2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial.getMaxCoeffLength() + 1 + i13);
            BigDecimalPolynomial bigDecimalPolynomialMult = bigDecimalPolynomialDiv.mult(bigIntPolynomial2);
            bigDecimalPolynomialMult.add(bigDecimalPolynomialDiv2.mult(bigIntPolynomial));
            bigDecimalPolynomialMult.halve();
            bigIntPolynomialRound = bigDecimalPolynomialMult.round();
        }
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial3.sub(polynomialGenerateRandom.mult(bigIntPolynomialRound));
        BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial.clone();
        bigIntPolynomial4.sub(polynomialGenerateRandom2.mult(bigIntPolynomialRound));
        IntegerPolynomial integerPolynomial5 = new IntegerPolynomial(bigIntPolynomial3);
        IntegerPolynomial integerPolynomial6 = new IntegerPolynomial(bigIntPolynomial4);
        nTRUSigningKeyPairGenerator.minimizeFG(integerPolynomial, integerPolynomial2, integerPolynomial5, integerPolynomial6, i2);
        if (i8 == 0) {
            integerPolynomialMult = polynomialGenerateRandom2.mult(integerPolynomialInvertFq, i3);
            polynomialGenerateRandom2 = integerPolynomial5;
        } else {
            integerPolynomialMult = integerPolynomial5.mult(integerPolynomialInvertFq, i3);
        }
        integerPolynomialMult.modPositive(i3);
        return nTRUSigningKeyPairGenerator.new FGBasis(polynomialGenerateRandom, polynomialGenerateRandom2, integerPolynomialMult, integerPolynomial5, integerPolynomial6, nTRUSigningKeyPairGenerator.params);
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        FGBasis fGBasisGenerateBasis;
        do {
            fGBasisGenerateBasis = generateBasis();
        } while (!fGBasisGenerateBasis.isNormOk());
        return fGBasisGenerateBasis;
    }

    private class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        private BasisGenerationTask() {
        }

        @Override // java.util.concurrent.Callable
        public NTRUSigningPrivateKeyParameters.Basis call() throws Exception {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {
        public IntegerPolynomial F;
        public IntegerPolynomial G;

        FGBasis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.F = integerPolynomial2;
            this.G = integerPolynomial3;
        }

        boolean isNormOk() {
            double d = this.params.keyNormBoundSq;
            int i = this.params.q;
            return ((double) this.F.centeredNormSq(i)) < d && ((double) this.G.centeredNormSq(i)) < d;
        }
    }
}
