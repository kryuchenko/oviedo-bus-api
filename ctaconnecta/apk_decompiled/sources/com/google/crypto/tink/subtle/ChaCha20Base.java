package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

/* loaded from: classes4.dex */
abstract class ChaCha20Base implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, ISO7816.INS_MANAGE_CHANNEL, 97, 110, ISOFileInfo.FMD_BYTE, 32, 51, ISO7816.INS_INCREASE, 45, ISOFileInfo.FCP_BYTE, 121, 116, 101, 32, 107});
    private final int initialCounter;
    int[] key;

    private static int rotateLeft(int x, int y) {
        return (x >>> (-y)) | (x << y);
    }

    abstract int[] createInitialState(final int[] nonce, int counter);

    abstract int nonceSizeInBytes();

    ChaCha20Base(final byte[] key, int initialCounter) throws InvalidKeyException {
        if (key.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = toIntArray(key);
        this.initialCounter = initialCounter;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        if (plaintext.length > Integer.MAX_VALUE - nonceSizeInBytes()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(nonceSizeInBytes() + plaintext.length);
        encrypt(byteBufferAllocate, plaintext);
        return byteBufferAllocate.array();
    }

    void encrypt(ByteBuffer output, final byte[] plaintext) throws GeneralSecurityException {
        if (output.remaining() - nonceSizeInBytes() < plaintext.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] bArrRandBytes = Random.randBytes(nonceSizeInBytes());
        output.put(bArrRandBytes);
        process(bArrRandBytes, output, ByteBuffer.wrap(plaintext));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(ciphertext));
    }

    byte[] decrypt(ByteBuffer ciphertext) throws GeneralSecurityException {
        if (ciphertext.remaining() < nonceSizeInBytes()) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr = new byte[nonceSizeInBytes()];
        ciphertext.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(ciphertext.remaining());
        process(bArr, byteBufferAllocate, ciphertext);
        return byteBufferAllocate.array();
    }

    private void process(final byte[] nonce, ByteBuffer output, ByteBuffer input) throws GeneralSecurityException {
        int iRemaining = input.remaining();
        int i = iRemaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferChacha20Block = chacha20Block(nonce, this.initialCounter + i3);
            if (i3 == i) {
                Bytes.xor(output, input, byteBufferChacha20Block, iRemaining % 64);
            } else {
                Bytes.xor(output, input, byteBufferChacha20Block, 64);
            }
        }
    }

    ByteBuffer chacha20Block(final byte[] nonce, int counter) {
        int[] iArrCreateInitialState = createInitialState(toIntArray(nonce), counter);
        int[] iArr = (int[]) iArrCreateInitialState.clone();
        shuffleState(iArr);
        for (int i = 0; i < iArrCreateInitialState.length; i++) {
            iArrCreateInitialState[i] = iArrCreateInitialState[i] + iArr[i];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrCreateInitialState, 0, 16);
        return byteBufferOrder;
    }

    static void setSigmaAndKey(int[] state, final int[] key) {
        int[] iArr = SIGMA;
        System.arraycopy(iArr, 0, state, 0, iArr.length);
        System.arraycopy(key, 0, state, iArr.length, 8);
    }

    static void shuffleState(final int[] state) {
        for (int i = 0; i < 10; i++) {
            quarterRound(state, 0, 4, 8, 12);
            quarterRound(state, 1, 5, 9, 13);
            quarterRound(state, 2, 6, 10, 14);
            quarterRound(state, 3, 7, 11, 15);
            quarterRound(state, 0, 5, 10, 15);
            quarterRound(state, 1, 6, 11, 12);
            quarterRound(state, 2, 7, 8, 13);
            quarterRound(state, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] x, int a, int b, int c, int d) {
        int i = x[a] + x[b];
        x[a] = i;
        int iRotateLeft = rotateLeft(i ^ x[d], 16);
        x[d] = iRotateLeft;
        int i2 = x[c] + iRotateLeft;
        x[c] = i2;
        int iRotateLeft2 = rotateLeft(x[b] ^ i2, 12);
        x[b] = iRotateLeft2;
        int i3 = x[a] + iRotateLeft2;
        x[a] = i3;
        int iRotateLeft3 = rotateLeft(x[d] ^ i3, 8);
        x[d] = iRotateLeft3;
        int i4 = x[c] + iRotateLeft3;
        x[c] = i4;
        x[b] = rotateLeft(x[b] ^ i4, 7);
    }

    static int[] toIntArray(final byte[] input) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
