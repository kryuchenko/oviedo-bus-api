package org.jnbis.internal;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* loaded from: classes6.dex */
public class NistHelper {
    public static final int FIELD_MAX_LENGTH = 1024;
    public static final int RT_FACIAL_N_SMT_IMAGE_DATA = 10;
    public static final int RT_HR_BINARY_FINGERPRINT = 6;
    public static final int RT_HR_GS_FINGERPRINT = 4;
    public static final int RT_IRIS_IMAGE = 17;
    public static final int RT_LR_BINARY_FINGERPRINT = 5;
    public static final int RT_LR_GS_FINGERPRINT = 3;
    public static final int RT_MINUTIAE_DATA = 9;
    public static final int RT_SIGNATURE_IMAGE = 8;
    public static final int RT_TRANSACTION_INFO = 1;
    public static final int RT_USER_DEFINED_IMAGE = 7;
    public static final int RT_USER_DEFINED_TEXT = 2;
    public static final int RT_VR_FINGERPRINT = 14;
    public static final int RT_VR_LATENT_IMAGE = 13;
    public static final int RT_VR_PALMPRINT = 15;
    static final char SEP_RS = 30;
    static final char SEP_US = 31;
    static final CharsetDecoder CP1256 = Charset.forName("cp1256").newDecoder();
    public static final CharsetDecoder USASCII = Charset.forName("US-ASCII").newDecoder();
    static final CharsetDecoder UTF8 = Charset.forName(Key.STRING_CHARSET_NAME).newDecoder();
    static final CharsetDecoder UTF16 = Charset.forName("UTF-16").newDecoder();
    public static final char[] TAG_SEP_DOT = {'.', '.'};
    public static final char[] TAG_SEP_COLN = {':', ':'};
    static final char SEP_GS = 29;
    public static final char SEP_FS = 28;
    public static final char[] TAG_SEP_GSFS = {SEP_GS, SEP_FS};

    public static class Tag {
        public final int field;
        public final int type;

        public Tag(int i, int i2) {
            this.type = i;
            this.field = i2;
        }
    }

    public static class Token {
        public final byte[] buffer;
        public CharsetDecoder charset = NistHelper.CP1256;
        public int crt;
        public String header;
        public int pos;

        Token(byte[] bArr) {
            this.buffer = bArr;
        }

        public void setCharSetDecoder(String str) {
            if (str != null) {
                if (str.startsWith("000")) {
                    this.charset = NistHelper.CP1256;
                } else if (str.startsWith("002")) {
                    this.charset = NistHelper.UTF16;
                } else if (str.startsWith("003")) {
                    this.charset = NistHelper.UTF8;
                }
            }
        }
    }
}
