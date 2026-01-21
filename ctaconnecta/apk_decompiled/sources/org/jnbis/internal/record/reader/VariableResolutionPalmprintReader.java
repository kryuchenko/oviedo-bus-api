package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.VariableResolutionPalmprint;

/* loaded from: classes6.dex */
public class VariableResolutionPalmprintReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public VariableResolutionPalmprint read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T14::NULL pointer to T14 record");
        }
        VariableResolutionPalmprint variableResolutionPalmprint = new VariableResolutionPalmprint();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T14::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        Integer numValueOf = Integer.valueOf(i2);
        variableResolutionPalmprint.setLogicalRecordLength(numValueOf.toString());
        while (true) {
            token.pos++;
            NistHelper.Tag tagInfo2 = getTagInfo(token);
            if (tagInfo2.field == 999) {
                numValueOf.getClass();
                int i3 = i2 - (token.pos - i);
                byte[] bArr = new byte[i3];
                System.arraycopy(token.buffer, token.pos, bArr, 0, i3);
                token.pos += i3;
                variableResolutionPalmprint.setImageData(bArr);
                return variableResolutionPalmprint;
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            int i4 = tagInfo2.field;
            if (i4 == 16) {
                variableResolutionPalmprint.setScannedHorizontalPixelScale(strNextWord);
            } else if (i4 == 17) {
                variableResolutionPalmprint.setScannedVerticalPixelScale(strNextWord);
            } else if (i4 == 20) {
                variableResolutionPalmprint.setComment(strNextWord);
            } else if (i4 == 24) {
                variableResolutionPalmprint.setPalmprintQualityMetric(strNextWord);
            } else if (i4 != 30) {
                switch (i4) {
                    case 1:
                        variableResolutionPalmprint.setLogicalRecordLength(strNextWord);
                        break;
                    case 2:
                        variableResolutionPalmprint.setImageDesignationCharacter(strNextWord);
                        break;
                    case 3:
                        variableResolutionPalmprint.setImpressionType(strNextWord);
                        break;
                    case 4:
                        variableResolutionPalmprint.setSourceAgency(strNextWord);
                        break;
                    case 5:
                        variableResolutionPalmprint.setCaptureDate(strNextWord);
                        break;
                    case 6:
                        variableResolutionPalmprint.setHorizontalLineLength(strNextWord);
                        break;
                    case 7:
                        variableResolutionPalmprint.setVerticalLineLength(strNextWord);
                        break;
                    case 8:
                        variableResolutionPalmprint.setScaleUnits(strNextWord);
                        break;
                    case 9:
                        variableResolutionPalmprint.setHorizontalPixelScale(strNextWord);
                        break;
                    case 10:
                        variableResolutionPalmprint.setVerticalPixelScale(strNextWord);
                        break;
                    case 11:
                        variableResolutionPalmprint.setCompressionAlgorithm(strNextWord);
                        break;
                    case 12:
                        variableResolutionPalmprint.setBitsPerPixel(strNextWord);
                        break;
                    case 13:
                        variableResolutionPalmprint.setPalmprintPosition(strNextWord);
                        break;
                }
            } else {
                variableResolutionPalmprint.setDeviceMonitoringMode(strNextWord);
            }
        }
    }
}
