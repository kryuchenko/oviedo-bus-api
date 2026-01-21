package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.UserDefinedImage;

/* loaded from: classes6.dex */
public class UserDefinedImageReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public UserDefinedImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T7::NULL pointer to T7 record");
        }
        UserDefinedImage userDefinedImage = new UserDefinedImage();
        int i = (int) readInt(token);
        Integer numValueOf = Integer.valueOf(i);
        numValueOf.getClass();
        int length = i - 5;
        if (token.pos + length + 4 > token.buffer.length) {
            length += (token.buffer.length - token.pos) - 5;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(token.buffer, token.pos + 5, bArr, 0, length);
        int i2 = token.pos;
        numValueOf.getClass();
        token.pos = i2 + i;
        userDefinedImage.setImageData(bArr);
        userDefinedImage.setLogicalRecordLength(numValueOf.toString());
        return userDefinedImage;
    }
}
