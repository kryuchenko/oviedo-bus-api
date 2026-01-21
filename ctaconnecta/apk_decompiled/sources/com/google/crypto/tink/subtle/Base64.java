package com.google.crypto.tink.subtle;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

/* loaded from: classes4.dex */
public final class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;
    private static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int len);

        public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        Coder() {
        }
    }

    public static byte[] decode(String input) {
        return decode(input, 2);
    }

    public static byte[] urlSafeDecode(String input) {
        return decode(input, 11);
    }

    public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(UTF_8), flags);
    }

    public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder decoder = new Decoder(flags, new byte[(len * 3) / 4]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        byte[] bArr = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
        return bArr;
    }

    static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int flags, byte[] output) {
            this.output = output;
            this.alphabet = (flags & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 3) / 4) + 10;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            int i = this.state;
            if (i == 6) {
                return false;
            }
            int i2 = len + offset;
            int i3 = this.value;
            byte[] bArr = this.output;
            int[] iArr = this.alphabet;
            int i4 = i3;
            int i5 = 0;
            int i6 = i;
            int i7 = offset;
            while (i7 < i2) {
                if (i6 == 0) {
                    while (true) {
                        int i8 = i7 + 4;
                        if (i8 > i2 || (i4 = (iArr[input[i7] & 255] << 18) | (iArr[input[i7 + 1] & 255] << 12) | (iArr[input[i7 + 2] & 255] << 6) | iArr[input[i7 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr[i5 + 2] = (byte) i4;
                        bArr[i5 + 1] = (byte) (i4 >> 8);
                        bArr[i5] = (byte) (i4 >> 16);
                        i5 += 3;
                        i7 = i8;
                    }
                    if (i7 >= i2) {
                        break;
                    }
                }
                int i9 = i7 + 1;
                int i10 = iArr[input[i7] & 255];
                if (i6 != 0) {
                    if (i6 == 1) {
                        if (i10 < 0) {
                            if (i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i10 |= i4 << 6;
                    } else if (i6 == 2) {
                        if (i10 < 0) {
                            if (i10 == -2) {
                                bArr[i5] = (byte) (i4 >> 4);
                                i5++;
                                i6 = 4;
                            } else if (i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i10 |= i4 << 6;
                    } else if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 == 5 && i10 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i10 == -2) {
                            i6++;
                        } else if (i10 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i10 >= 0) {
                        int i11 = i10 | (i4 << 6);
                        bArr[i5 + 2] = (byte) i11;
                        bArr[i5 + 1] = (byte) (i11 >> 8);
                        bArr[i5] = (byte) (i11 >> 16);
                        i5 += 3;
                        i4 = i11;
                        i6 = 0;
                    } else if (i10 == -2) {
                        bArr[i5 + 1] = (byte) (i4 >> 2);
                        bArr[i5] = (byte) (i4 >> 10);
                        i5 += 2;
                        i6 = 5;
                    } else if (i10 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i6++;
                    i4 = i10;
                } else if (i10 >= 0) {
                    i6++;
                    i4 = i10;
                } else if (i10 != -1) {
                    this.state = 6;
                    return false;
                }
                i7 = i9;
            }
            if (!finish) {
                this.state = i6;
                this.value = i4;
                this.op = i5;
                return true;
            }
            if (i6 == 1) {
                this.state = 6;
                return false;
            }
            if (i6 == 2) {
                bArr[i5] = (byte) (i4 >> 4);
                i5++;
            } else if (i6 == 3) {
                int i12 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 10);
                i5 += 2;
                bArr[i12] = (byte) (i4 >> 2);
            } else if (i6 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i6;
            this.op = i5;
            return true;
        }
    }

    public static String encode(final byte[] input) {
        return encodeToString(input, 2);
    }

    public static String urlSafeEncode(final byte[] input) {
        return encodeToString(input, 11);
    }

    public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);
        int i = (len / 3) * 4;
        if (encoder.doPadding) {
            if (len % 3 > 0) {
                i += 4;
            }
        } else {
            int i2 = len % 3;
            if (i2 == 1) {
                i += 2;
            } else if (i2 == 2) {
                i += 3;
            }
        }
        if (encoder.doNewline && len > 0) {
            i += (((len - 1) / 57) + 1) * (encoder.doCr ? 2 : 1);
        }
        encoder.output = new byte[i];
        encoder.process(input, offset, len, true);
        return encoder.output;
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, ISOFileInfo.FMD_BYTE, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ISO7816.INS_DECREASE, 49, ISO7816.INS_INCREASE, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, ISOFileInfo.FMD_BYTE, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ISO7816.INS_DECREASE, 49, ISO7816.INS_INCREASE, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean doCr;
        public final boolean doNewline;
        public final boolean doPadding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int flags, byte[] output) {
            this.output = output;
            this.doPadding = (flags & 1) == 0;
            boolean z = (flags & 2) == 0;
            this.doNewline = z;
            this.doCr = (flags & 4) != 0;
            this.alphabet = (flags & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z ? 19 : -1;
        }

        @Override // com.google.crypto.tink.subtle.Base64.Coder
        public int maxOutputSize(int len) {
            return ((len * 8) / 5) + 10;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        @Override // com.google.crypto.tink.subtle.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            int i;
            int i2;
            int i3;
            byte b;
            byte b2;
            byte b3;
            int i4;
            int i5;
            byte[] bArr = this.alphabet;
            byte[] bArr2 = this.output;
            int i6 = this.count;
            int i7 = len + offset;
            int i8 = this.tailLen;
            int i9 = 0;
            if (i8 != 1) {
                if (i8 == 2 && (i5 = offset + 1) <= i7) {
                    byte[] bArr3 = this.tail;
                    i2 = ((bArr3[1] & 255) << 8) | ((bArr3[0] & 255) << 16) | (input[offset] & 255);
                    this.tailLen = 0;
                    i = i5;
                } else {
                    i = offset;
                    i2 = -1;
                }
            } else if (offset + 2 <= i7) {
                i = offset + 2;
                i2 = (input[offset + 1] & 255) | ((this.tail[0] & 255) << 16) | ((input[offset] & 255) << 8);
                this.tailLen = 0;
            }
            if (i2 != -1) {
                bArr2[0] = bArr[(i2 >> 18) & 63];
                bArr2[1] = bArr[(i2 >> 12) & 63];
                bArr2[2] = bArr[(i2 >> 6) & 63];
                bArr2[3] = bArr[i2 & 63];
                i6--;
                if (i6 == 0) {
                    if (this.doCr) {
                        bArr2[4] = 13;
                        i4 = 5;
                    } else {
                        i4 = 4;
                    }
                    i3 = i4 + 1;
                    bArr2[i4] = 10;
                    i6 = 19;
                } else {
                    i3 = 4;
                }
            } else {
                i3 = 0;
            }
            while (true) {
                int i10 = i + 3;
                if (i10 > i7) {
                    break;
                }
                int i11 = ((input[i + 1] & 255) << 8) | ((input[i] & 255) << 16) | (input[i + 2] & 255);
                bArr2[i3] = bArr[(i11 >> 18) & 63];
                bArr2[i3 + 1] = bArr[(i11 >> 12) & 63];
                bArr2[i3 + 2] = bArr[(i11 >> 6) & 63];
                bArr2[i3 + 3] = bArr[i11 & 63];
                int i12 = i3 + 4;
                i6--;
                if (i6 == 0) {
                    if (this.doCr) {
                        bArr2[i12] = 13;
                        i12 = i3 + 5;
                    }
                    i3 = i12 + 1;
                    bArr2[i12] = 10;
                    i = i10;
                    i6 = 19;
                } else {
                    i3 = i12;
                    i = i10;
                }
            }
            if (finish) {
                int i13 = this.tailLen;
                if (i - i13 == i7 - 1) {
                    if (i13 > 0) {
                        b3 = this.tail[0];
                        i9 = 1;
                    } else {
                        b3 = input[i];
                    }
                    int i14 = (b3 & 255) << 4;
                    this.tailLen = i13 - i9;
                    bArr2[i3] = bArr[(i14 >> 6) & 63];
                    int i15 = i3 + 2;
                    bArr2[i3 + 1] = bArr[i14 & 63];
                    if (this.doPadding) {
                        bArr2[i15] = kotlin.io.encoding.Base64.padSymbol;
                        i15 = i3 + 4;
                        bArr2[i3 + 3] = kotlin.io.encoding.Base64.padSymbol;
                    }
                    if (this.doNewline) {
                        if (this.doCr) {
                            bArr2[i15] = 13;
                            i15++;
                        }
                        bArr2[i15] = 10;
                        i15++;
                    }
                    i3 = i15;
                } else if (i - i13 == i7 - 2) {
                    if (i13 > 1) {
                        b = this.tail[0];
                        i9 = 1;
                    } else {
                        byte b4 = input[i];
                        i++;
                        b = b4;
                    }
                    int i16 = (b & 255) << 10;
                    if (i13 > 0) {
                        b2 = this.tail[i9];
                        i9++;
                    } else {
                        b2 = input[i];
                    }
                    int i17 = i16 | ((b2 & 255) << 2);
                    this.tailLen = i13 - i9;
                    bArr2[i3] = bArr[(i17 >> 12) & 63];
                    bArr2[i3 + 1] = bArr[(i17 >> 6) & 63];
                    int i18 = i3 + 3;
                    bArr2[i3 + 2] = bArr[i17 & 63];
                    if (this.doPadding) {
                        bArr2[i18] = kotlin.io.encoding.Base64.padSymbol;
                        i18 = i3 + 4;
                    }
                    if (this.doNewline) {
                        if (this.doCr) {
                            bArr2[i18] = 13;
                            i18++;
                        }
                        bArr2[i18] = 10;
                        i18++;
                    }
                    i3 = i18;
                } else if (this.doNewline && i3 > 0 && i6 != 19) {
                    if (this.doCr) {
                        bArr2[i3] = 13;
                        i3++;
                    }
                    bArr2[i3] = 10;
                    i3++;
                }
            } else if (i == i7 - 1) {
                byte[] bArr4 = this.tail;
                int i19 = this.tailLen;
                this.tailLen = i19 + 1;
                bArr4[i19] = input[i];
            } else if (i == i7 - 2) {
                byte[] bArr5 = this.tail;
                int i20 = this.tailLen;
                int i21 = i20 + 1;
                this.tailLen = i21;
                bArr5[i20] = input[i];
                this.tailLen = i20 + 2;
                bArr5[i21] = input[i + 1];
            }
            this.op = i3;
            this.count = i6;
            return true;
        }
    }

    private Base64() {
    }
}
