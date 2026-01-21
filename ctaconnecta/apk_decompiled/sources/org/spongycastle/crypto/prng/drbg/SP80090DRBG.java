package org.spongycastle.crypto.prng.drbg;

/* loaded from: classes6.dex */
public interface SP80090DRBG {
    int generate(byte[] bArr, byte[] bArr2, boolean z);

    int getBlockSize();

    void reseed(byte[] bArr);
}
