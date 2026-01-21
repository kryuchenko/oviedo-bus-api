package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(final RSAPublicKey pubKey, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(pubKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(pubKey.getPublicExponent());
        this.publicKey = pubKey;
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        int iBitLength2 = (modulus.bitLength() + 6) / 8;
        if (iBitLength != signature.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(signature);
        if (bigIntegerBytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        emsaPssVerify(data, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
    }

    private void emsaPssVerify(byte[] m, byte[] em, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(m);
        int digestLength = engineFactory.getDigestLength();
        int length = em.length;
        if (length < this.saltLength + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (em[em.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i = (length - digestLength) - 1;
        byte[] bArrCopyOf = Arrays.copyOf(em, i);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(em, bArrCopyOf.length, bArrCopyOf.length + digestLength);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            long j = (length * 8) - emBits;
            if (i2 < j) {
                if (((bArrCopyOf[i3 / 8] >> (7 - (i3 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i2 = i3 + 1;
                i = i4;
            } else {
                byte[] bArrMgf1 = SubtleUtil.mgf1(bArrCopyOfRange, i4, this.mgf1Hash);
                int length2 = bArrMgf1.length;
                byte[] bArr = new byte[length2];
                for (int i5 = 0; i5 < length2; i5++) {
                    bArr[i5] = (byte) (bArrMgf1[i5] ^ bArrCopyOf[i5]);
                }
                for (int i6 = 0; i6 <= j; i6++) {
                    int i7 = i6 / 8;
                    bArr[i7] = (byte) ((~(1 << (7 - (i6 % 8)))) & bArr[i7]);
                }
                int i8 = 0;
                while (true) {
                    int i9 = this.saltLength;
                    if (i8 < (r6 - i9) - 2) {
                        if (bArr[i8] != 0) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        i8++;
                    } else {
                        if (bArr[(r6 - i9) - 2] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, length2 - i9, length2);
                        int i10 = digestLength + 8;
                        byte[] bArr2 = new byte[this.saltLength + i10];
                        System.arraycopy(bArrDigest, 0, bArr2, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr2, i10, bArrCopyOfRange2.length);
                        if (!Bytes.equal(engineFactory.digest(bArr2), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                }
            }
        }
    }
}
