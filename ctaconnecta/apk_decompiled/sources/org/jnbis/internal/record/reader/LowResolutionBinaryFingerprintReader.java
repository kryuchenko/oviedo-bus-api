package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.LowResolutionBinaryFingerprint;

/* loaded from: classes6.dex */
public class LowResolutionBinaryFingerprintReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public LowResolutionBinaryFingerprint read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T3::NULL pointer to T3 record");
        }
        LowResolutionBinaryFingerprint lowResolutionBinaryFingerprint = new LowResolutionBinaryFingerprint();
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
        lowResolutionBinaryFingerprint.setImageDesignationCharacter(Integer.toString(b));
        lowResolutionBinaryFingerprint.setImageData(bArr);
        lowResolutionBinaryFingerprint.setLogicalRecordLength(numValueOf.toString());
        return lowResolutionBinaryFingerprint;
    }
}
