package org.ejbca.cvc;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.ejbca.cvc.exception.ConstructionException;
import org.ejbca.cvc.exception.ParseException;

/* loaded from: classes6.dex */
public final class CertificateParser {
    private CertificateParser() {
    }

    public static CVCObject parseCVCObject(byte[] bArr) throws ConstructionException, ParseException {
        return decode(bArr, (CVCTagEnum) null);
    }

    public static CVCertificate parseCertificate(byte[] bArr) throws ConstructionException, ParseException {
        return (CVCertificate) decode(bArr, CVCTagEnum.CV_CERTIFICATE);
    }

    private static CVCObject decode(byte[] bArr, CVCTagEnum cVCTagEnum) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    CVCObject cVCObjectDecode = decode(new DataInputStream(byteArrayInputStream2), cVCTagEnum);
                    byteArrayInputStream2.close();
                    return cVCObjectDecode;
                } catch (Throwable th) {
                    th = th;
                    byteArrayInputStream = byteArrayInputStream2;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e) {
            throw new ParseException(e);
        }
    }

    private static CVCObject decode(DataInputStream dataInputStream, CVCTagEnum cVCTagEnum) throws ConstructionException, IOException, ParseException {
        CVCTagEnum cVCTagEnumFindTagFromValue = findTagFromValue(decodeTag(dataInputStream));
        if (cVCTagEnum != null && cVCTagEnumFindTagFromValue != cVCTagEnum) {
            throw new ParseException("Expected first tag " + cVCTagEnum + " but found " + cVCTagEnumFindTagFromValue);
        }
        int iDecodeLength = CVCObject.decodeLength(dataInputStream);
        if (cVCTagEnumFindTagFromValue.isSequence()) {
            int iAvailable = dataInputStream.available() - iDecodeLength;
            AbstractSequence abstractSequenceCreateSequence = SequenceFactory.createSequence(cVCTagEnumFindTagFromValue);
            while (dataInputStream.available() > iAvailable) {
                abstractSequenceCreateSequence.addSubfield(decode(dataInputStream, (CVCTagEnum) null));
            }
            return abstractSequenceCreateSequence instanceof GenericPublicKeyField ? KeyFactory.createInstance((GenericPublicKeyField) abstractSequenceCreateSequence) : abstractSequenceCreateSequence;
        }
        byte[] bArr = new byte[iDecodeLength];
        dataInputStream.read(bArr, 0, iDecodeLength);
        return FieldFactory.decodeField(cVCTagEnumFindTagFromValue, bArr);
    }

    private static CVCTagEnum findTagFromValue(int i) throws ParseException {
        CVCTagEnum cVCTagEnum;
        CVCTagEnum[] cVCTagEnumArrValues = CVCTagEnum.values();
        int length = cVCTagEnumArrValues.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                cVCTagEnum = null;
                break;
            }
            cVCTagEnum = cVCTagEnumArrValues[i2];
            if (cVCTagEnum.getValue() == i) {
                break;
            }
            i2++;
        }
        if (cVCTagEnum != null) {
            return cVCTagEnum;
        }
        throw new ParseException("Unknown CVC tag value " + Integer.toHexString(i));
    }

    private static int decodeTag(DataInputStream dataInputStream) throws IOException {
        int unsignedByte = dataInputStream.readUnsignedByte();
        if ((unsignedByte & 31) != 31) {
            return unsignedByte;
        }
        return (unsignedByte << 8) + dataInputStream.readByte();
    }
}
