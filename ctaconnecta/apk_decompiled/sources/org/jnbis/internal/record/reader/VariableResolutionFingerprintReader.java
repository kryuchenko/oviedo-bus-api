package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.VariableResolutionFingerprint;

/* loaded from: classes6.dex */
public class VariableResolutionFingerprintReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public VariableResolutionFingerprint read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T14::NULL pointer to T14 record");
        }
        VariableResolutionFingerprint variableResolutionFingerprint = new VariableResolutionFingerprint();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T14::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        Integer numValueOf = Integer.valueOf(i2);
        variableResolutionFingerprint.setLogicalRecordLength(numValueOf.toString());
        while (true) {
            token.pos++;
            NistHelper.Tag tagInfo2 = getTagInfo(token);
            if (tagInfo2.field == 999) {
                numValueOf.getClass();
                int i3 = i2 - (token.pos - i);
                byte[] bArr = new byte[i3];
                System.arraycopy(token.buffer, token.pos, bArr, 0, i3);
                token.pos += i3;
                variableResolutionFingerprint.setImageData(bArr);
                return variableResolutionFingerprint;
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tagInfo2.field) {
                case 1:
                    variableResolutionFingerprint.setLogicalRecordLength(strNextWord);
                    break;
                case 2:
                    variableResolutionFingerprint.setImageDesignationCharacter(strNextWord);
                    break;
                case 3:
                    variableResolutionFingerprint.setImpressionType(strNextWord);
                    break;
                case 4:
                    variableResolutionFingerprint.setSourceAgency(strNextWord);
                    break;
                case 5:
                    variableResolutionFingerprint.setCaptureDate(strNextWord);
                    break;
                case 6:
                    variableResolutionFingerprint.setHorizontalLineLength(strNextWord);
                    break;
                case 7:
                    variableResolutionFingerprint.setVerticalLineLength(strNextWord);
                    break;
                case 8:
                    variableResolutionFingerprint.setScaleUnits(strNextWord);
                    break;
                case 9:
                    variableResolutionFingerprint.setHorizontalPixelScale(strNextWord);
                    break;
                case 10:
                    variableResolutionFingerprint.setVerticalPixelScale(strNextWord);
                    break;
                case 11:
                    variableResolutionFingerprint.setCompressionAlgorithm(strNextWord);
                    break;
                case 12:
                    variableResolutionFingerprint.setBitsPerPixel(strNextWord);
                    break;
                case 13:
                    variableResolutionFingerprint.setFingerPosition(strNextWord);
                    break;
                case 14:
                    variableResolutionFingerprint.setPrintPositionDescriptors(strNextWord);
                    break;
                case 15:
                    variableResolutionFingerprint.setPrintPositionCoordinates(strNextWord);
                    break;
                case 16:
                    variableResolutionFingerprint.setScannedHorizontalPixelScale(strNextWord);
                    break;
                case 17:
                    variableResolutionFingerprint.setScannedVerticalPixelScale(strNextWord);
                    break;
                case 18:
                    variableResolutionFingerprint.setAmputatedOrBandaged(strNextWord);
                    break;
                case 20:
                    variableResolutionFingerprint.setComment(strNextWord);
                    break;
                case 21:
                    variableResolutionFingerprint.setFingerprintSegmentationPosition(strNextWord);
                    break;
                case 22:
                    variableResolutionFingerprint.setNistQualityMetric(strNextWord);
                    break;
                case 23:
                    variableResolutionFingerprint.setSegmentationQualityMetric(strNextWord);
                    break;
                case 24:
                    variableResolutionFingerprint.setFingerprintQualityMetric(strNextWord);
                    break;
                case 25:
                    variableResolutionFingerprint.setAlternateFingerSegmentPosition(strNextWord);
                    break;
                case 30:
                    variableResolutionFingerprint.setDeviceMonitoringMode(strNextWord);
                    break;
            }
        }
    }
}
