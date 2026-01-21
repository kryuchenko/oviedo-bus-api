package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;

/* loaded from: classes6.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    private static int[] MOD17 = null;
    private static int[] MOD3 = null;
    private static int[] MOD5 = null;
    private static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;
    private long[] kw;
    private long[] t = new long[5];

    static long rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    static long xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    static {
        int[] iArr = new int[80];
        MOD9 = iArr;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i >= iArr2.length) {
                return;
            }
            MOD17[i] = i % 17;
            iArr2[i] = i % 9;
            MOD5[i] = i % 5;
            MOD3[i] = i % 3;
            i++;
        }
    }

    public ThreefishEngine(int i) {
        int i2 = i / 8;
        this.blocksizeBytes = i2;
        int i3 = i2 / 8;
        this.blocksizeWords = i3;
        this.currentBlock = new long[i3];
        this.kw = new long[(i3 * 2) + 1];
        if (i == 256) {
            this.cipher = new Threefish256Cipher(this.kw, this.t);
        } else if (i == 512) {
            this.cipher = new Threefish512Cipher(this.kw, this.t);
        } else {
            if (i == 1024) {
                this.cipher = new Threefish1024Cipher(this.kw, this.t);
                return;
            }
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] key;
        byte[] tweak;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            key = tweakableBlockCipherParameters.getKey().getKey();
            tweak = tweakableBlockCipherParameters.getTweak();
        } else if (cipherParameters instanceof KeyParameter) {
            key = ((KeyParameter) cipherParameters).getKey();
            tweak = null;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
        }
        if (key == null) {
            jArr = null;
        } else {
            if (key.length != this.blocksizeBytes) {
                throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
            }
            int i = this.blocksizeWords;
            jArr = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = bytesToWord(key, i2 * 8);
            }
        }
        if (tweak != null) {
            if (tweak.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[]{bytesToWord(tweak, 0), bytesToWord(tweak, 8)};
        }
        init(z, jArr, jArr2);
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    private void setKey(long[] jArr) {
        if (jArr.length != this.blocksizeWords) {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
        long j = C_240;
        int i = 0;
        while (true) {
            int i2 = this.blocksizeWords;
            if (i < i2) {
                long[] jArr2 = this.kw;
                long j2 = jArr[i];
                jArr2[i] = j2;
                j ^= j2;
                i++;
            } else {
                long[] jArr3 = this.kw;
                jArr3[i2] = j;
                System.arraycopy(jArr3, 0, jArr3, i2 + 1, i2);
                return;
            }
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.t;
        long j = jArr[0];
        jArr2[0] = j;
        long j2 = jArr[1];
        jArr2[1] = j2;
        jArr2[2] = j ^ j2;
        jArr2[3] = j;
        jArr2[4] = j2;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.blocksizeBytes; i5 += 8) {
            this.currentBlock[i5 >> 3] = bytesToWord(bArr, i + i5);
        }
        long[] jArr = this.currentBlock;
        processBlock(jArr, jArr);
        while (true) {
            int i6 = this.blocksizeBytes;
            if (i4 >= i6) {
                return i6;
            }
            wordToBytes(this.currentBlock[i4 >> 3], bArr2, i2 + i4);
            i4 += 8;
        }
    }

    public int processBlock(long[] jArr, long[] jArr2) throws IllegalStateException, DataLengthException {
        long[] jArr3 = this.kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            this.cipher.encryptBlock(jArr, jArr2);
        } else {
            this.cipher.decryptBlock(jArr, jArr2);
        }
        return this.blocksizeWords;
    }

    public static long bytesToWord(byte[] bArr, int i) {
        if (i + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        if (i + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    private static abstract class ThreefishCipher {
        protected final long[] kw;
        protected final long[] t;

        abstract void decryptBlock(long[] jArr, long[] jArr2);

        abstract void encryptBlock(long[] jArr, long[] jArr2);

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.kw = jArr;
            this.t = jArr2;
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = j + jArr3[0];
            long j6 = j2 + jArr3[1] + jArr4[0];
            long j7 = j3 + jArr3[2] + jArr4[1];
            long j8 = j4 + jArr3[3];
            int i = 1;
            while (i < 18) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                long j9 = j5 + j6;
                long jRotlXor = ThreefishEngine.rotlXor(j6, 14, j9);
                long j10 = j7 + j8;
                long jRotlXor2 = ThreefishEngine.rotlXor(j8, 16, j10);
                long[] jArr5 = jArr3;
                long j11 = j9 + jRotlXor2;
                long jRotlXor3 = ThreefishEngine.rotlXor(jRotlXor2, 52, j11);
                long j12 = j10 + jRotlXor;
                long jRotlXor4 = ThreefishEngine.rotlXor(jRotlXor, 57, j12);
                long j13 = j11 + jRotlXor4;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor4, 23, j13);
                long j14 = j12 + jRotlXor3;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor3, 40, j14);
                long j15 = j13 + jRotlXor6;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor6, 5, j15);
                long j16 = j14 + jRotlXor5;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor5, 37, j16);
                long j17 = j15 + jArr5[i2];
                int i4 = i2 + 1;
                long j18 = jRotlXor8 + jArr5[i4] + jArr4[i3];
                int i5 = i2 + 2;
                int i6 = i3 + 1;
                long j19 = j16 + jArr5[i5] + jArr4[i6];
                int i7 = i2 + 3;
                long j20 = i;
                long j21 = jRotlXor7 + jArr5[i7] + j20;
                long j22 = j17 + j18;
                long jRotlXor9 = ThreefishEngine.rotlXor(j18, 25, j22);
                long j23 = j19 + j21;
                long jRotlXor10 = ThreefishEngine.rotlXor(j21, 33, j23);
                long j24 = j22 + jRotlXor10;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor10, 46, j24);
                long j25 = j23 + jRotlXor9;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor9, 12, j25);
                long j26 = j24 + jRotlXor12;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor12, 58, j26);
                long j27 = j25 + jRotlXor11;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor11, 22, j27);
                long j28 = j26 + jRotlXor14;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor14, 32, j28);
                long j29 = j27 + jRotlXor13;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor13, 32, j29);
                long j30 = j28 + jArr5[i4];
                long j31 = jRotlXor16 + jArr5[i5] + jArr4[i6];
                j7 = j29 + jArr5[i7] + jArr4[i3 + 2];
                j8 = jRotlXor15 + jArr5[i2 + 4] + j20 + 1;
                i += 2;
                j6 = j31;
                j5 = j30;
                jArr3 = jArr5;
            }
            jArr2[0] = j5;
            jArr2[1] = j6;
            jArr2[2] = j7;
            jArr2[3] = j8;
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD5;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long jXorRotr = jArr[3];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j4 = j - jArr3[i5];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j5 = j2 - (jArr3[i6] + jArr4[i7]);
                int i8 = i3 + 3;
                long j6 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                long j7 = i2;
                long jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr - ((jArr3[i3 + 4] + j7) + 1), 32, j4);
                long j8 = j4 - jXorRotr2;
                long[] jArr5 = jArr3;
                long jXorRotr3 = ThreefishEngine.xorRotr(j5, 32, j6);
                long j9 = j6 - jXorRotr3;
                long[] jArr6 = jArr4;
                long jXorRotr4 = ThreefishEngine.xorRotr(jXorRotr3, 58, j8);
                long j10 = j8 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(jXorRotr2, 22, j9);
                long j11 = j9 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(jXorRotr5, 46, j10);
                long j12 = j10 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(jXorRotr4, 12, j11);
                long j13 = j11 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr7, 25, j12);
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr6, 33, j13);
                long j14 = (j12 - jXorRotr8) - jArr5[i3];
                long j15 = jXorRotr8 - (jArr5[i5] + jArr6[i4]);
                long j16 = (j13 - jXorRotr9) - (jArr5[i6] + jArr6[i7]);
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr9 - (jArr5[i8] + j7), 5, j14);
                long j17 = j14 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(j15, 37, j16);
                long j18 = j16 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr11, 23, j17);
                long j19 = j17 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr10, 40, j18);
                long j20 = j18 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr13, 52, j19);
                long j21 = j19 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr12, 57, j20);
                long j22 = j20 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr15, 14, j21);
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr14, 16, j22);
                j3 = j22 - jXorRotr;
                i2 -= 2;
                j2 = jXorRotr16;
                jArr3 = jArr5;
                i = 1;
                j = j21 - jXorRotr16;
                jArr4 = jArr6;
                iArr = iArr;
            }
            long[] jArr7 = jArr3;
            long[] jArr8 = jArr4;
            long j23 = j - jArr7[0];
            long j24 = j2 - (jArr7[1] + jArr8[0]);
            long j25 = j3 - (jArr7[2] + jArr8[1]);
            long j26 = jXorRotr - jArr7[3];
            jArr2[0] = j23;
            jArr2[1] = j24;
            jArr2[2] = j25;
            jArr2[3] = j26;
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = j + jArr3[0];
            long j10 = j2 + jArr3[1];
            long j11 = j3 + jArr3[2];
            long j12 = j4 + jArr3[3];
            long j13 = j5 + jArr3[4];
            long j14 = j6 + jArr3[5] + jArr4[0];
            long j15 = j7 + jArr3[6] + jArr4[1];
            long j16 = j9;
            long j17 = j8 + jArr3[7];
            long j18 = j15;
            long j19 = j11;
            long j20 = j14;
            long j21 = j13;
            long j22 = j12;
            int i = 1;
            while (i < 18) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                long j23 = j22;
                long j24 = j16 + j10;
                long jRotlXor = ThreefishEngine.rotlXor(j10, 46, j24);
                long[] jArr5 = jArr3;
                long j25 = j19 + j23;
                long[] jArr6 = jArr4;
                int[] iArr3 = iArr;
                int[] iArr4 = iArr2;
                long jRotlXor2 = ThreefishEngine.rotlXor(j23, 36, j25);
                long j26 = j21 + j20;
                long jRotlXor3 = ThreefishEngine.rotlXor(j20, 19, j26);
                long j27 = j18 + j17;
                long jRotlXor4 = ThreefishEngine.rotlXor(j17, 37, j27);
                long j28 = j25 + jRotlXor;
                long jRotlXor5 = ThreefishEngine.rotlXor(jRotlXor, 33, j28);
                long j29 = j26 + jRotlXor4;
                long jRotlXor6 = ThreefishEngine.rotlXor(jRotlXor4, 27, j29);
                long j30 = j27 + jRotlXor3;
                long jRotlXor7 = ThreefishEngine.rotlXor(jRotlXor3, 14, j30);
                long j31 = j24 + jRotlXor2;
                long jRotlXor8 = ThreefishEngine.rotlXor(jRotlXor2, 42, j31);
                long j32 = j29 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 17, j32);
                long j33 = j30 + jRotlXor8;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor8, 49, j33);
                long j34 = j31 + jRotlXor7;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor7, 36, j34);
                long j35 = j28 + jRotlXor6;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor6, 39, j35);
                int i4 = i;
                long j36 = j33 + jRotlXor9;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor9, 44, j36);
                long j37 = j34 + jRotlXor12;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor12, 9, j37);
                long j38 = j35 + jRotlXor11;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor11, 54, j38);
                long j39 = j32 + jRotlXor10;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor10, 56, j39);
                long j40 = j37 + jArr5[i2];
                int i5 = i2 + 1;
                long j41 = jRotlXor13 + jArr5[i5];
                int i6 = i2 + 2;
                long j42 = j38 + jArr5[i6];
                int i7 = i2 + 3;
                long j43 = jRotlXor16 + jArr5[i7];
                int i8 = i2 + 4;
                long j44 = j39 + jArr5[i8];
                int i9 = i2 + 5;
                long j45 = jRotlXor15 + jArr5[i9] + jArr6[i3];
                int i10 = i2 + 6;
                int i11 = i3 + 1;
                long j46 = j36 + jArr5[i10] + jArr6[i11];
                int i12 = i2 + 7;
                long j47 = i4;
                long j48 = jRotlXor14 + jArr5[i12] + j47;
                long j49 = j40 + j41;
                long jRotlXor17 = ThreefishEngine.rotlXor(j41, 39, j49);
                long j50 = j42 + j43;
                long jRotlXor18 = ThreefishEngine.rotlXor(j43, 30, j50);
                long j51 = j44 + j45;
                long jRotlXor19 = ThreefishEngine.rotlXor(j45, 34, j51);
                long j52 = j46 + j48;
                long jRotlXor20 = ThreefishEngine.rotlXor(j48, 24, j52);
                long j53 = j50 + jRotlXor17;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor17, 13, j53);
                long j54 = j51 + jRotlXor20;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor20, 50, j54);
                long j55 = j52 + jRotlXor19;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor19, 10, j55);
                long j56 = j49 + jRotlXor18;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor18, 17, j56);
                long j57 = j54 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 25, j57);
                long j58 = j55 + jRotlXor24;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor24, 29, j58);
                long j59 = j56 + jRotlXor23;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor23, 39, j59);
                long j60 = j53 + jRotlXor22;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor22, 43, j60);
                long j61 = j58 + jRotlXor25;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor25, 8, j61);
                long j62 = j59 + jRotlXor28;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor28, 35, j62);
                long j63 = j60 + jRotlXor27;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor27, 56, j63);
                long j64 = j57 + jRotlXor26;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor26, 22, j64);
                long j65 = j62 + jArr5[i5];
                long j66 = jRotlXor29 + jArr5[i6];
                long j67 = j63 + jArr5[i7];
                long j68 = jRotlXor32 + jArr5[i8];
                long j69 = j64 + jArr5[i9];
                long j70 = jRotlXor31 + jArr5[i10] + jArr6[i11];
                j18 = j61 + jArr5[i12] + jArr6[i3 + 2];
                j19 = j67;
                j16 = j65;
                j21 = j69;
                jArr4 = jArr6;
                iArr = iArr3;
                j10 = j66;
                j20 = j70;
                j17 = jArr5[i2 + 8] + j47 + 1 + jRotlXor30;
                i = i4 + 2;
                iArr2 = iArr4;
                j22 = j68;
                jArr3 = jArr5;
            }
            jArr2[0] = j16;
            jArr2[1] = j10;
            jArr2[2] = j19;
            jArr2[3] = j22;
            jArr2[4] = j21;
            jArr2[5] = j20;
            jArr2[6] = j18;
            jArr2[7] = j17;
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD9;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long jXorRotr = jArr[3];
            long j4 = jArr[4];
            long jXorRotr2 = jArr[5];
            long j5 = jArr[6];
            long jXorRotr3 = jArr[7];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j6 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j7 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j8 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j9 = jXorRotr - jArr3[i8];
                int i9 = i3 + 5;
                long j10 = j4 - jArr3[i9];
                int i10 = i3 + 6;
                int i11 = i4 + 1;
                long j11 = jXorRotr2 - (jArr3[i10] + jArr4[i11]);
                int i12 = i3 + 7;
                long[] jArr5 = jArr3;
                long j12 = j5 - (jArr3[i12] + jArr4[i4 + 2]);
                long[] jArr6 = jArr4;
                long j13 = i2;
                long j14 = jXorRotr3 - ((jArr5[i3 + 8] + j13) + 1);
                int[] iArr3 = iArr2;
                long jXorRotr4 = ThreefishEngine.xorRotr(j7, 8, j12);
                long j15 = j12 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j14, 35, j6);
                long j16 = j6 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j11, 56, j8);
                long j17 = j8 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j9, 22, j10);
                long j18 = j10 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(jXorRotr4, 25, j18);
                long j19 = j18 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(jXorRotr7, 29, j15);
                long j20 = j15 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr6, 39, j16);
                long j21 = j16 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr5, 43, j17);
                long j22 = j17 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr8, 13, j22);
                long j23 = j22 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr11, 50, j19);
                long j24 = j19 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr10, 10, j20);
                long j25 = j20 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr9, 17, j21);
                long j26 = j21 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr12, 39, j26);
                long j27 = j26 - jXorRotr16;
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr15, 30, j23);
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr14, 34, j24);
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr13, 24, j25);
                long j28 = j25 - jXorRotr19;
                long j29 = j27 - jArr5[i3];
                long j30 = jXorRotr16 - jArr5[i5];
                long j31 = (j23 - jXorRotr17) - jArr5[i6];
                long j32 = jXorRotr17 - jArr5[i7];
                long j33 = (j24 - jXorRotr18) - jArr5[i8];
                long j34 = jXorRotr18 - (jArr5[i9] + jArr6[i4]);
                long j35 = j28 - (jArr5[i10] + jArr6[i11]);
                long j36 = jXorRotr19 - (jArr5[i12] + j13);
                long jXorRotr20 = ThreefishEngine.xorRotr(j30, 44, j35);
                long j37 = j35 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(j36, 9, j29);
                long j38 = j29 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(j34, 54, j31);
                long j39 = j31 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(j32, 56, j33);
                long j40 = j33 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr20, 17, j40);
                long j41 = j40 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr23, 49, j37);
                long j42 = j37 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr22, 36, j38);
                long j43 = j38 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr21, 39, j39);
                long j44 = j39 - jXorRotr27;
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr24, 33, j44);
                long j45 = j44 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr27, 27, j41);
                long j46 = j41 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr26, 14, j42);
                long j47 = j42 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr25, 42, j43);
                long j48 = j43 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr28, 46, j48);
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr31, 36, j45);
                j3 = j45 - jXorRotr;
                jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr30, 19, j46);
                jXorRotr3 = ThreefishEngine.xorRotr(jXorRotr29, 37, j47);
                j5 = j47 - jXorRotr3;
                j2 = jXorRotr32;
                j = j48 - jXorRotr32;
                iArr = iArr;
                iArr2 = iArr3;
                i = 1;
                j4 = j46 - jXorRotr2;
                i2 -= 2;
                jArr3 = jArr5;
                jArr4 = jArr6;
            }
            long[] jArr7 = jArr3;
            long[] jArr8 = jArr4;
            long j49 = j - jArr7[0];
            long j50 = j2 - jArr7[1];
            long j51 = j3 - jArr7[2];
            long j52 = jXorRotr - jArr7[3];
            long j53 = j4 - jArr7[4];
            long j54 = jXorRotr2 - (jArr7[5] + jArr8[0]);
            long j55 = j5 - (jArr7[6] + jArr8[1]);
            long j56 = jXorRotr3 - jArr7[7];
            jArr2[0] = j49;
            jArr2[1] = j50;
            jArr2[2] = j51;
            jArr2[3] = j52;
            jArr2[4] = j53;
            jArr2[5] = j54;
            jArr2[6] = j55;
            jArr2[7] = j56;
        }
    }

    private static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            int i = 13;
            long j14 = jArr[13];
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = j + jArr3[0];
            long j18 = j2 + jArr3[1];
            long j19 = j3 + jArr3[2];
            long j20 = j4 + jArr3[3];
            long j21 = j5 + jArr3[4];
            long j22 = j6 + jArr3[5];
            long j23 = j7 + jArr3[6];
            long j24 = j8 + jArr3[7];
            long j25 = j9 + jArr3[8];
            long j26 = j10 + jArr3[9];
            long j27 = j11 + jArr3[10];
            long j28 = j12 + jArr3[11];
            long j29 = j13 + jArr3[12];
            long j30 = j14 + jArr3[13] + jArr4[0];
            long j31 = j15 + jArr3[14] + jArr4[1];
            long j32 = j22;
            long j33 = j24;
            long j34 = j26;
            long j35 = j28;
            long j36 = j30;
            long j37 = j16 + jArr3[15];
            long j38 = j21;
            long j39 = j17;
            long j40 = j20;
            int i2 = 1;
            while (i2 < 20) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                long j41 = j40;
                long j42 = j39 + j18;
                long jRotlXor = ThreefishEngine.rotlXor(j18, 24, j42);
                long j43 = j19 + j41;
                long jRotlXor2 = ThreefishEngine.rotlXor(j41, i, j43);
                int i5 = i2;
                long j44 = j32;
                long j45 = j38 + j44;
                long jRotlXor3 = ThreefishEngine.rotlXor(j44, 8, j45);
                long[] jArr5 = jArr3;
                long j46 = j33;
                long j47 = j23 + j46;
                long[] jArr6 = jArr4;
                long jRotlXor4 = ThreefishEngine.rotlXor(j46, 47, j47);
                long j48 = j34;
                long j49 = j25 + j48;
                int[] iArr3 = iArr2;
                long jRotlXor5 = ThreefishEngine.rotlXor(j48, 8, j49);
                long j50 = j35;
                long j51 = j27 + j50;
                long jRotlXor6 = ThreefishEngine.rotlXor(j50, 17, j51);
                long j52 = j36;
                long j53 = j29 + j52;
                long jRotlXor7 = ThreefishEngine.rotlXor(j52, 22, j53);
                long j54 = j37;
                long j55 = j31 + j54;
                long jRotlXor8 = ThreefishEngine.rotlXor(j54, 37, j55);
                long j56 = j42 + jRotlXor5;
                long jRotlXor9 = ThreefishEngine.rotlXor(jRotlXor5, 38, j56);
                long j57 = j43 + jRotlXor7;
                long jRotlXor10 = ThreefishEngine.rotlXor(jRotlXor7, 19, j57);
                long j58 = j47 + jRotlXor6;
                long jRotlXor11 = ThreefishEngine.rotlXor(jRotlXor6, 10, j58);
                long j59 = j45 + jRotlXor8;
                long jRotlXor12 = ThreefishEngine.rotlXor(jRotlXor8, 55, j59);
                long j60 = j51 + jRotlXor4;
                long jRotlXor13 = ThreefishEngine.rotlXor(jRotlXor4, 49, j60);
                long j61 = j53 + jRotlXor2;
                long jRotlXor14 = ThreefishEngine.rotlXor(jRotlXor2, 18, j61);
                long j62 = j55 + jRotlXor3;
                long jRotlXor15 = ThreefishEngine.rotlXor(jRotlXor3, 23, j62);
                long j63 = j49 + jRotlXor;
                long jRotlXor16 = ThreefishEngine.rotlXor(jRotlXor, 52, j63);
                long j64 = j56 + jRotlXor13;
                long jRotlXor17 = ThreefishEngine.rotlXor(jRotlXor13, 33, j64);
                long j65 = j57 + jRotlXor15;
                long jRotlXor18 = ThreefishEngine.rotlXor(jRotlXor15, 4, j65);
                long j66 = j59 + jRotlXor14;
                long jRotlXor19 = ThreefishEngine.rotlXor(jRotlXor14, 51, j66);
                long j67 = j58 + jRotlXor16;
                long jRotlXor20 = ThreefishEngine.rotlXor(jRotlXor16, 13, j67);
                long j68 = j61 + jRotlXor12;
                long jRotlXor21 = ThreefishEngine.rotlXor(jRotlXor12, 34, j68);
                long j69 = j62 + jRotlXor10;
                long jRotlXor22 = ThreefishEngine.rotlXor(jRotlXor10, 41, j69);
                long j70 = j63 + jRotlXor11;
                long jRotlXor23 = ThreefishEngine.rotlXor(jRotlXor11, 59, j70);
                long j71 = j60 + jRotlXor9;
                long jRotlXor24 = ThreefishEngine.rotlXor(jRotlXor9, 17, j71);
                long j72 = j64 + jRotlXor21;
                long jRotlXor25 = ThreefishEngine.rotlXor(jRotlXor21, 5, j72);
                long j73 = j65 + jRotlXor23;
                long jRotlXor26 = ThreefishEngine.rotlXor(jRotlXor23, 20, j73);
                long j74 = j67 + jRotlXor22;
                long jRotlXor27 = ThreefishEngine.rotlXor(jRotlXor22, 48, j74);
                long j75 = j66 + jRotlXor24;
                long jRotlXor28 = ThreefishEngine.rotlXor(jRotlXor24, 41, j75);
                long j76 = j69 + jRotlXor20;
                long jRotlXor29 = ThreefishEngine.rotlXor(jRotlXor20, 47, j76);
                long j77 = j70 + jRotlXor18;
                long jRotlXor30 = ThreefishEngine.rotlXor(jRotlXor18, 28, j77);
                long j78 = j71 + jRotlXor19;
                long jRotlXor31 = ThreefishEngine.rotlXor(jRotlXor19, 16, j78);
                long j79 = j68 + jRotlXor17;
                long jRotlXor32 = ThreefishEngine.rotlXor(jRotlXor17, 25, j79);
                long j80 = j72 + jArr5[i3];
                int i6 = i3 + 1;
                long j81 = jRotlXor29 + jArr5[i6];
                int i7 = i3 + 2;
                long j82 = j73 + jArr5[i7];
                int i8 = i3 + 3;
                long j83 = jRotlXor31 + jArr5[i8];
                int i9 = i3 + 4;
                long j84 = j75 + jArr5[i9];
                int i10 = i3 + 5;
                long j85 = jRotlXor30 + jArr5[i10];
                int i11 = i3 + 6;
                long j86 = j74 + jArr5[i11];
                int i12 = i3 + 7;
                long j87 = jRotlXor32 + jArr5[i12];
                int i13 = i3 + 8;
                long j88 = j77 + jArr5[i13];
                int i14 = i3 + 9;
                long j89 = jRotlXor28 + jArr5[i14];
                int i15 = i3 + 10;
                long j90 = j78 + jArr5[i15];
                int i16 = i3 + 11;
                long j91 = jRotlXor26 + jArr5[i16];
                int i17 = i3 + 12;
                long j92 = j79 + jArr5[i17];
                int i18 = i3 + 13;
                long j93 = jRotlXor27 + jArr5[i18] + jArr6[i4];
                int i19 = i3 + 14;
                int i20 = i4 + 1;
                long j94 = j76 + jArr5[i19] + jArr6[i20];
                int i21 = i3 + 15;
                long j95 = i5;
                long j96 = jRotlXor25 + jArr5[i21] + j95;
                long j97 = j80 + j81;
                long jRotlXor33 = ThreefishEngine.rotlXor(j81, 41, j97);
                long j98 = j82 + j83;
                long jRotlXor34 = ThreefishEngine.rotlXor(j83, 9, j98);
                long j99 = j84 + j85;
                long jRotlXor35 = ThreefishEngine.rotlXor(j85, 37, j99);
                long j100 = j86 + j87;
                long jRotlXor36 = ThreefishEngine.rotlXor(j87, 31, j100);
                long j101 = j88 + j89;
                long jRotlXor37 = ThreefishEngine.rotlXor(j89, 12, j101);
                long j102 = j90 + j91;
                long jRotlXor38 = ThreefishEngine.rotlXor(j91, 47, j102);
                long j103 = j92 + j93;
                long jRotlXor39 = ThreefishEngine.rotlXor(j93, 44, j103);
                long j104 = j94 + j96;
                long jRotlXor40 = ThreefishEngine.rotlXor(j96, 30, j104);
                long j105 = j97 + jRotlXor37;
                long jRotlXor41 = ThreefishEngine.rotlXor(jRotlXor37, 16, j105);
                long j106 = j98 + jRotlXor39;
                long jRotlXor42 = ThreefishEngine.rotlXor(jRotlXor39, 34, j106);
                long j107 = j100 + jRotlXor38;
                long jRotlXor43 = ThreefishEngine.rotlXor(jRotlXor38, 56, j107);
                long j108 = j99 + jRotlXor40;
                long jRotlXor44 = ThreefishEngine.rotlXor(jRotlXor40, 51, j108);
                long j109 = j102 + jRotlXor36;
                long jRotlXor45 = ThreefishEngine.rotlXor(jRotlXor36, 4, j109);
                long j110 = j103 + jRotlXor34;
                long jRotlXor46 = ThreefishEngine.rotlXor(jRotlXor34, 53, j110);
                long j111 = j104 + jRotlXor35;
                long jRotlXor47 = ThreefishEngine.rotlXor(jRotlXor35, 42, j111);
                long j112 = j101 + jRotlXor33;
                long jRotlXor48 = ThreefishEngine.rotlXor(jRotlXor33, 41, j112);
                long j113 = j105 + jRotlXor45;
                long jRotlXor49 = ThreefishEngine.rotlXor(jRotlXor45, 31, j113);
                long j114 = j106 + jRotlXor47;
                long jRotlXor50 = ThreefishEngine.rotlXor(jRotlXor47, 44, j114);
                long j115 = j108 + jRotlXor46;
                long jRotlXor51 = ThreefishEngine.rotlXor(jRotlXor46, 47, j115);
                long j116 = j107 + jRotlXor48;
                long jRotlXor52 = ThreefishEngine.rotlXor(jRotlXor48, 46, j116);
                long j117 = j110 + jRotlXor44;
                long jRotlXor53 = ThreefishEngine.rotlXor(jRotlXor44, 19, j117);
                long j118 = j111 + jRotlXor42;
                long jRotlXor54 = ThreefishEngine.rotlXor(jRotlXor42, 42, j118);
                long j119 = j112 + jRotlXor43;
                long jRotlXor55 = ThreefishEngine.rotlXor(jRotlXor43, 44, j119);
                long j120 = j109 + jRotlXor41;
                long jRotlXor56 = ThreefishEngine.rotlXor(jRotlXor41, 25, j120);
                long j121 = j113 + jRotlXor53;
                long jRotlXor57 = ThreefishEngine.rotlXor(jRotlXor53, 9, j121);
                long j122 = j114 + jRotlXor55;
                long jRotlXor58 = ThreefishEngine.rotlXor(jRotlXor55, 48, j122);
                long j123 = j116 + jRotlXor54;
                long jRotlXor59 = ThreefishEngine.rotlXor(jRotlXor54, 35, j123);
                long j124 = j115 + jRotlXor56;
                long jRotlXor60 = ThreefishEngine.rotlXor(jRotlXor56, 52, j124);
                long j125 = j118 + jRotlXor52;
                long jRotlXor61 = ThreefishEngine.rotlXor(jRotlXor52, 23, j125);
                long j126 = j119 + jRotlXor50;
                long jRotlXor62 = ThreefishEngine.rotlXor(jRotlXor50, 31, j126);
                long j127 = j120 + jRotlXor51;
                long jRotlXor63 = ThreefishEngine.rotlXor(jRotlXor51, 37, j127);
                long j128 = j117 + jRotlXor49;
                long jRotlXor64 = ThreefishEngine.rotlXor(jRotlXor49, 20, j128);
                long j129 = jArr5[i6] + j121;
                long j130 = jRotlXor61 + jArr5[i7];
                long j131 = j122 + jArr5[i8];
                long j132 = jRotlXor63 + jArr5[i9];
                long j133 = j124 + jArr5[i10];
                long j134 = jRotlXor62 + jArr5[i11];
                long j135 = j123 + jArr5[i12];
                long j136 = jRotlXor64 + jArr5[i13];
                long j137 = j126 + jArr5[i14];
                j34 = jRotlXor60 + jArr5[i15];
                long j138 = j127 + jArr5[i16];
                long j139 = jRotlXor58 + jArr5[i17];
                j29 = j128 + jArr5[i18];
                j36 = jRotlXor59 + jArr5[i19] + jArr6[i20];
                long j140 = j125 + jArr5[i21] + jArr6[i4 + 2];
                j37 = jRotlXor57 + jArr5[i3 + 16] + j95 + 1;
                j23 = j135;
                j25 = j137;
                j38 = j133;
                j18 = j130;
                j19 = j131;
                i2 = i5 + 2;
                j40 = j132;
                j27 = j138;
                j35 = j139;
                j32 = j134;
                i = 13;
                j33 = j136;
                j39 = j129;
                j31 = j140;
                jArr3 = jArr5;
                jArr4 = jArr6;
                iArr = iArr;
                iArr2 = iArr3;
            }
            jArr2[0] = j39;
            jArr2[1] = j18;
            jArr2[2] = j19;
            jArr2[3] = j40;
            jArr2[4] = j38;
            jArr2[5] = j32;
            jArr2[6] = j23;
            jArr2[7] = j33;
            jArr2[8] = j25;
            jArr2[9] = j34;
            jArr2[10] = j27;
            jArr2[11] = j35;
            jArr2[12] = j29;
            jArr2[13] = j36;
            jArr2[14] = j31;
            jArr2[15] = j37;
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.kw;
            long[] jArr4 = this.t;
            int[] iArr = ThreefishEngine.MOD17;
            int[] iArr2 = ThreefishEngine.MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            int i2 = 9;
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            long j14 = jArr[13];
            long j15 = jArr[14];
            long jXorRotr = jArr[15];
            int i3 = 19;
            while (i3 >= i) {
                int i4 = iArr[i3];
                int i5 = iArr2[i3];
                int i6 = i4 + 1;
                long j16 = j - jArr3[i6];
                int i7 = i4 + 2;
                long j17 = j2 - jArr3[i7];
                int i8 = i4 + 3;
                long j18 = j3 - jArr3[i8];
                int i9 = i4 + 4;
                long j19 = j4 - jArr3[i9];
                int i10 = i4 + 5;
                long j20 = j5 - jArr3[i10];
                int i11 = i4 + 6;
                long[] jArr5 = jArr3;
                long j21 = j6 - jArr3[i11];
                int i12 = i4 + 7;
                long[] jArr6 = jArr4;
                long j22 = j7 - jArr5[i12];
                int i13 = i4 + 8;
                int[] iArr3 = iArr2;
                long j23 = j8 - jArr5[i13];
                int i14 = i4 + 9;
                long j24 = j9 - jArr5[i14];
                int i15 = i4 + 10;
                long j25 = j10 - jArr5[i15];
                int i16 = i4 + 11;
                long j26 = j11 - jArr5[i16];
                int i17 = i4 + 12;
                long j27 = j12 - jArr5[i17];
                int i18 = i4 + 13;
                long j28 = j13 - jArr5[i18];
                int i19 = i4 + 14;
                int i20 = i5 + 1;
                long j29 = j14 - (jArr5[i19] + jArr6[i20]);
                int i21 = i4 + 15;
                long j30 = j15 - (jArr5[i21] + jArr6[i5 + 2]);
                long j31 = i3;
                long jXorRotr2 = ThreefishEngine.xorRotr(jXorRotr - ((jArr5[i4 + 16] + j31) + 1), i2, j16);
                long j32 = j16 - jXorRotr2;
                long jXorRotr3 = ThreefishEngine.xorRotr(j27, 48, j18);
                long j33 = j18 - jXorRotr3;
                long jXorRotr4 = ThreefishEngine.xorRotr(j29, 35, j22);
                long j34 = j22 - jXorRotr4;
                long jXorRotr5 = ThreefishEngine.xorRotr(j25, 52, j20);
                long j35 = j20 - jXorRotr5;
                long jXorRotr6 = ThreefishEngine.xorRotr(j17, 23, j30);
                long j36 = j30 - jXorRotr6;
                long jXorRotr7 = ThreefishEngine.xorRotr(j21, 31, j24);
                long j37 = j24 - jXorRotr7;
                long jXorRotr8 = ThreefishEngine.xorRotr(j19, 37, j26);
                long j38 = j26 - jXorRotr8;
                long jXorRotr9 = ThreefishEngine.xorRotr(j23, 20, j28);
                long j39 = j28 - jXorRotr9;
                long jXorRotr10 = ThreefishEngine.xorRotr(jXorRotr9, 31, j32);
                long j40 = j32 - jXorRotr10;
                long jXorRotr11 = ThreefishEngine.xorRotr(jXorRotr7, 44, j33);
                long j41 = j33 - jXorRotr11;
                long jXorRotr12 = ThreefishEngine.xorRotr(jXorRotr8, 47, j35);
                long j42 = j35 - jXorRotr12;
                long jXorRotr13 = ThreefishEngine.xorRotr(jXorRotr6, 46, j34);
                long j43 = j34 - jXorRotr13;
                long jXorRotr14 = ThreefishEngine.xorRotr(jXorRotr2, 19, j39);
                long j44 = j39 - jXorRotr14;
                long jXorRotr15 = ThreefishEngine.xorRotr(jXorRotr4, 42, j36);
                long j45 = j36 - jXorRotr15;
                long jXorRotr16 = ThreefishEngine.xorRotr(jXorRotr3, 44, j37);
                long j46 = j37 - jXorRotr16;
                long jXorRotr17 = ThreefishEngine.xorRotr(jXorRotr5, 25, j38);
                long j47 = j38 - jXorRotr17;
                long jXorRotr18 = ThreefishEngine.xorRotr(jXorRotr17, 16, j40);
                long j48 = j40 - jXorRotr18;
                long jXorRotr19 = ThreefishEngine.xorRotr(jXorRotr15, 34, j41);
                long j49 = j41 - jXorRotr19;
                long jXorRotr20 = ThreefishEngine.xorRotr(jXorRotr16, 56, j43);
                long j50 = j43 - jXorRotr20;
                long jXorRotr21 = ThreefishEngine.xorRotr(jXorRotr14, 51, j42);
                long j51 = j42 - jXorRotr21;
                long jXorRotr22 = ThreefishEngine.xorRotr(jXorRotr10, 4, j47);
                long j52 = j47 - jXorRotr22;
                long jXorRotr23 = ThreefishEngine.xorRotr(jXorRotr12, 53, j44);
                long j53 = j44 - jXorRotr23;
                long jXorRotr24 = ThreefishEngine.xorRotr(jXorRotr11, 42, j45);
                long j54 = j45 - jXorRotr24;
                long jXorRotr25 = ThreefishEngine.xorRotr(jXorRotr13, 41, j46);
                long j55 = j46 - jXorRotr25;
                long jXorRotr26 = ThreefishEngine.xorRotr(jXorRotr25, 41, j48);
                long j56 = j48 - jXorRotr26;
                long jXorRotr27 = ThreefishEngine.xorRotr(jXorRotr23, 9, j49);
                long jXorRotr28 = ThreefishEngine.xorRotr(jXorRotr24, 37, j51);
                long j57 = j51 - jXorRotr28;
                long jXorRotr29 = ThreefishEngine.xorRotr(jXorRotr22, 31, j50);
                long j58 = j50 - jXorRotr29;
                long jXorRotr30 = ThreefishEngine.xorRotr(jXorRotr18, 12, j55);
                long j59 = j55 - jXorRotr30;
                long jXorRotr31 = ThreefishEngine.xorRotr(jXorRotr20, 47, j52);
                long j60 = j52 - jXorRotr31;
                long jXorRotr32 = ThreefishEngine.xorRotr(jXorRotr19, 44, j53);
                long j61 = j53 - jXorRotr32;
                long jXorRotr33 = ThreefishEngine.xorRotr(jXorRotr21, 30, j54);
                long j62 = j54 - jXorRotr33;
                long j63 = j56 - jArr5[i4];
                long j64 = jXorRotr26 - jArr5[i6];
                long j65 = (j49 - jXorRotr27) - jArr5[i7];
                long j66 = jXorRotr27 - jArr5[i8];
                long j67 = j57 - jArr5[i9];
                long j68 = jXorRotr28 - jArr5[i10];
                long j69 = j58 - jArr5[i11];
                long j70 = jXorRotr29 - jArr5[i12];
                long j71 = j59 - jArr5[i13];
                long j72 = jXorRotr30 - jArr5[i14];
                long j73 = j60 - jArr5[i15];
                long j74 = jXorRotr31 - jArr5[i16];
                long j75 = j61 - jArr5[i17];
                long j76 = jXorRotr32 - (jArr5[i18] + jArr6[i5]);
                long j77 = j62 - (jArr5[i19] + jArr6[i20]);
                long jXorRotr34 = ThreefishEngine.xorRotr(jXorRotr33 - (jArr5[i21] + j31), 5, j63);
                long j78 = j63 - jXorRotr34;
                long jXorRotr35 = ThreefishEngine.xorRotr(j74, 20, j65);
                long j79 = j65 - jXorRotr35;
                long jXorRotr36 = ThreefishEngine.xorRotr(j76, 48, j69);
                long j80 = j69 - jXorRotr36;
                long jXorRotr37 = ThreefishEngine.xorRotr(j72, 41, j67);
                long j81 = j67 - jXorRotr37;
                long jXorRotr38 = ThreefishEngine.xorRotr(j64, 47, j77);
                long j82 = j77 - jXorRotr38;
                long jXorRotr39 = ThreefishEngine.xorRotr(j68, 28, j71);
                long j83 = j71 - jXorRotr39;
                long jXorRotr40 = ThreefishEngine.xorRotr(j66, 16, j73);
                long j84 = j73 - jXorRotr40;
                long jXorRotr41 = ThreefishEngine.xorRotr(j70, 25, j75);
                long j85 = j75 - jXorRotr41;
                long jXorRotr42 = ThreefishEngine.xorRotr(jXorRotr41, 33, j78);
                long j86 = j78 - jXorRotr42;
                long jXorRotr43 = ThreefishEngine.xorRotr(jXorRotr39, 4, j79);
                long j87 = j79 - jXorRotr43;
                long jXorRotr44 = ThreefishEngine.xorRotr(jXorRotr40, 51, j81);
                long j88 = j81 - jXorRotr44;
                long jXorRotr45 = ThreefishEngine.xorRotr(jXorRotr38, 13, j80);
                long j89 = j80 - jXorRotr45;
                long jXorRotr46 = ThreefishEngine.xorRotr(jXorRotr34, 34, j85);
                long j90 = j85 - jXorRotr46;
                long jXorRotr47 = ThreefishEngine.xorRotr(jXorRotr36, 41, j82);
                long j91 = j82 - jXorRotr47;
                long jXorRotr48 = ThreefishEngine.xorRotr(jXorRotr35, 59, j83);
                long j92 = j83 - jXorRotr48;
                long jXorRotr49 = ThreefishEngine.xorRotr(jXorRotr37, 17, j84);
                long j93 = j84 - jXorRotr49;
                long jXorRotr50 = ThreefishEngine.xorRotr(jXorRotr49, 38, j86);
                long j94 = j86 - jXorRotr50;
                long jXorRotr51 = ThreefishEngine.xorRotr(jXorRotr47, 19, j87);
                long j95 = j87 - jXorRotr51;
                long jXorRotr52 = ThreefishEngine.xorRotr(jXorRotr48, 10, j89);
                long j96 = j89 - jXorRotr52;
                long jXorRotr53 = ThreefishEngine.xorRotr(jXorRotr46, 55, j88);
                long j97 = j88 - jXorRotr53;
                long jXorRotr54 = ThreefishEngine.xorRotr(jXorRotr42, 49, j93);
                long j98 = j93 - jXorRotr54;
                long jXorRotr55 = ThreefishEngine.xorRotr(jXorRotr44, 18, j90);
                long j99 = j90 - jXorRotr55;
                long jXorRotr56 = ThreefishEngine.xorRotr(jXorRotr43, 23, j91);
                long j100 = j91 - jXorRotr56;
                long jXorRotr57 = ThreefishEngine.xorRotr(jXorRotr45, 52, j92);
                long j101 = j92 - jXorRotr57;
                long jXorRotr58 = ThreefishEngine.xorRotr(jXorRotr57, 24, j94);
                long j102 = j94 - jXorRotr58;
                long jXorRotr59 = ThreefishEngine.xorRotr(jXorRotr55, 13, j95);
                j3 = j95 - jXorRotr59;
                long jXorRotr60 = ThreefishEngine.xorRotr(jXorRotr56, 8, j97);
                long j103 = j97 - jXorRotr60;
                long jXorRotr61 = ThreefishEngine.xorRotr(jXorRotr54, 47, j96);
                long j104 = j96 - jXorRotr61;
                long jXorRotr62 = ThreefishEngine.xorRotr(jXorRotr50, 8, j101);
                long j105 = j101 - jXorRotr62;
                long jXorRotr63 = ThreefishEngine.xorRotr(jXorRotr52, 17, j98);
                long j106 = j98 - jXorRotr63;
                long jXorRotr64 = ThreefishEngine.xorRotr(jXorRotr51, 22, j99);
                j13 = j99 - jXorRotr64;
                jXorRotr = ThreefishEngine.xorRotr(jXorRotr53, 37, j100);
                j15 = j100 - jXorRotr;
                j12 = jXorRotr63;
                j11 = j106;
                jArr3 = jArr5;
                jArr4 = jArr6;
                iArr = iArr;
                j7 = j104;
                j6 = jXorRotr60;
                j = j102;
                i2 = 9;
                j4 = jXorRotr59;
                j14 = jXorRotr64;
                j8 = jXorRotr61;
                i3 -= 2;
                j10 = jXorRotr62;
                j5 = j103;
                j2 = jXorRotr58;
                i = 1;
                j9 = j105;
                iArr2 = iArr3;
            }
            long[] jArr7 = jArr3;
            long[] jArr8 = jArr4;
            long j107 = j - jArr7[0];
            long j108 = j2 - jArr7[1];
            long j109 = j3 - jArr7[2];
            long j110 = j4 - jArr7[3];
            long j111 = j5 - jArr7[4];
            long j112 = j6 - jArr7[5];
            long j113 = j7 - jArr7[6];
            long j114 = j8 - jArr7[7];
            long j115 = j9 - jArr7[8];
            long j116 = j10 - jArr7[9];
            long j117 = j11 - jArr7[10];
            long j118 = j12 - jArr7[11];
            long j119 = j13 - jArr7[12];
            long j120 = j14 - (jArr7[13] + jArr8[0]);
            long j121 = j15 - (jArr7[14] + jArr8[1]);
            long j122 = jXorRotr - jArr7[15];
            jArr2[0] = j107;
            jArr2[1] = j108;
            jArr2[2] = j109;
            jArr2[3] = j110;
            jArr2[4] = j111;
            jArr2[5] = j112;
            jArr2[6] = j113;
            jArr2[7] = j114;
            jArr2[8] = j115;
            jArr2[9] = j116;
            jArr2[10] = j117;
            jArr2[11] = j118;
            jArr2[12] = j119;
            jArr2[13] = j120;
            jArr2[14] = j121;
            jArr2[15] = j122;
        }
    }
}
