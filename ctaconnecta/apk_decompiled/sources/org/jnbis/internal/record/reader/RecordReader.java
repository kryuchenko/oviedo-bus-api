package org.jnbis.internal.record.reader;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;

/* loaded from: classes6.dex */
public abstract class RecordReader {
    public abstract BaseRecord read(NistHelper.Token token);

    protected NistHelper.Tag getTagInfo(NistHelper.Token token) {
        String strNextWord = nextWord(token, NistHelper.TAG_SEP_DOT, 2, false);
        token.pos++;
        String strNextWord2 = nextWord(token, NistHelper.TAG_SEP_COLN, 10, false);
        token.pos++;
        return new NistHelper.Tag(Integer.parseInt(strNextWord.replace(",", "")), Integer.parseInt(strNextWord2));
    }

    protected String nextWord(NistHelper.Token token, char[] cArr, int i, boolean z) {
        int i2 = 0;
        while (i2 < i && token.pos < token.buffer.length && token.buffer[token.pos] != cArr[0] && token.buffer[token.pos] != cArr[1]) {
            token.pos++;
            i2++;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(token.buffer, token.pos - i2, bArr, 0, i2);
        try {
            if (z) {
                return String.valueOf(token.charset.decode(ByteBuffer.wrap(bArr)));
            }
            return String.valueOf(NistHelper.USASCII.decode(ByteBuffer.wrap(bArr)));
        } catch (CharacterCodingException e) {
            throw new RuntimeException(e);
        }
    }

    protected long readInt(NistHelper.Token token) {
        return ((token.buffer[token.pos + 1] & 255) << 16) | ((token.buffer[token.pos] & 255) << 24) | ((token.buffer[token.pos + 2] & 255) << 8) | (token.buffer[token.pos + 3] & 255);
    }
}
