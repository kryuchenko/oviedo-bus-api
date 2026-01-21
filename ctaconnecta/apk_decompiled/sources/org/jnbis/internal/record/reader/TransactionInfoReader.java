package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.TransactionInformation;

/* loaded from: classes6.dex */
public class TransactionInfoReader extends RecordReader {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.jnbis.internal.record.reader.RecordReader
    public TransactionInformation read(NistHelper.Token token) {
        byte[] bArr;
        int i;
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T1::NULL pointer to T1 record");
        }
        TransactionInformation transactionInformation = new TransactionInformation();
        do {
            NistHelper.Tag tagInfo = getTagInfo(token);
            if (tagInfo.type != 1) {
                throw new RuntimeException("T1::Invalid Record Type : " + tagInfo.type);
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tagInfo.field) {
                case 1:
                    transactionInformation.setLogicalRecordLength(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 2:
                    transactionInformation.setVersion(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 3:
                    token.header = strNextWord;
                    transactionInformation.setFileContent(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 4:
                    transactionInformation.setTypeOfTransaction(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 5:
                    transactionInformation.setDate(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 6:
                    transactionInformation.setPriority(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 7:
                    transactionInformation.setDestinationAgencyId(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 8:
                    transactionInformation.setOriginatingAgencyId(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 9:
                    transactionInformation.setControlNumber(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 10:
                    transactionInformation.setControlReferenceNumber(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 11:
                    transactionInformation.setNativeScanningResolution(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 12:
                    transactionInformation.setNominalTransmittingResolution(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 13:
                    transactionInformation.setDomainName(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 14:
                    transactionInformation.setGreenwichMeanTime(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                case 15:
                    token.setCharSetDecoder(strNextWord);
                    transactionInformation.setDirectoryOfCharsets(strNextWord);
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
                default:
                    bArr = token.buffer;
                    i = token.pos;
                    token.pos = i + 1;
                    break;
            }
        } while (bArr[i] != 28);
        return transactionInformation;
    }
}
