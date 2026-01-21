package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.SignatureImage;

/* loaded from: classes6.dex */
public class SignatureImageReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public SignatureImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T8::NULL pointer to T8 record");
        }
        SignatureImage signatureImage = new SignatureImage();
        int i = (int) readInt(token);
        Integer numValueOf = Integer.valueOf(i);
        numValueOf.getClass();
        int length = i - 12;
        if (token.pos + length + 11 > token.buffer.length) {
            length += (token.buffer.length - token.pos) - 12;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(token.buffer, token.pos + 12, bArr, 0, length);
        int i2 = token.pos;
        numValueOf.getClass();
        token.pos = i2 + i;
        signatureImage.setImageData(bArr);
        signatureImage.setLogicalRecordLength(numValueOf.toString());
        return signatureImage;
    }
}
