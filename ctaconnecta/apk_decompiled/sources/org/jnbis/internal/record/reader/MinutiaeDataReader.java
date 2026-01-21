package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.MinutiaeData;

/* loaded from: classes6.dex */
public class MinutiaeDataReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public MinutiaeData read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T9::NULL pointer to T9 record");
        }
        MinutiaeData minutiaeData = new MinutiaeData();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T9::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        token.pos++;
        getTagInfo(token);
        int i3 = i2 - (token.pos - i);
        System.arraycopy(token.buffer, token.pos, new byte[i3], 0, i3);
        token.pos += i3;
        return minutiaeData;
    }

    @Override // org.jnbis.internal.record.reader.RecordReader
    protected NistHelper.Tag getTagInfo(NistHelper.Token token) {
        String strNextWord = nextWord(token, NistHelper.TAG_SEP_DOT, 2, false);
        token.pos++;
        String strNextWord2 = nextWord(token, NistHelper.TAG_SEP_COLN, 10, false);
        token.pos++;
        return new NistHelper.Tag(Integer.parseInt(strNextWord), Integer.parseInt(strNextWord2));
    }
}
