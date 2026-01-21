package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.HighResolutionGrayscaleFingerprint;

/* loaded from: classes6.dex */
public class HighResolutionGrayscaleFingerprintReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public HighResolutionGrayscaleFingerprint read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T4::NULL pointer to T4 record");
        }
        HighResolutionGrayscaleFingerprint highResolutionGrayscaleFingerprint = new HighResolutionGrayscaleFingerprint();
        int i = (int) readInt(token);
        Integer numValueOf = Integer.valueOf(i);
        byte b = token.buffer[token.pos + 6];
        numValueOf.getClass();
        int length = i - 18;
        if (token.pos + length + 17 > token.buffer.length) {
            length += (token.buffer.length - token.pos) - 18;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(token.buffer, token.pos + 18, bArr, 0, length);
        int i2 = token.pos;
        numValueOf.getClass();
        token.pos = i2 + i;
        highResolutionGrayscaleFingerprint.setImageDesignationCharacter(Integer.toString(b));
        highResolutionGrayscaleFingerprint.setImageData(bArr);
        highResolutionGrayscaleFingerprint.setLogicalRecordLength(numValueOf.toString());
        return highResolutionGrayscaleFingerprint;
    }
}
