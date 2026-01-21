package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.VariableResolutionLatentImage;

/* loaded from: classes6.dex */
public class VariableResolutionLatentImageReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public VariableResolutionLatentImage read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T13::NULL pointer to T13 record");
        }
        VariableResolutionLatentImage variableResolutionLatentImage = new VariableResolutionLatentImage();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T13::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        Integer numValueOf = Integer.valueOf(i2);
        variableResolutionLatentImage.setLogicalRecordLength(numValueOf.toString());
        while (true) {
            token.pos++;
            NistHelper.Tag tagInfo2 = getTagInfo(token);
            if (tagInfo2.field == 999) {
                numValueOf.getClass();
                int i3 = i2 - (token.pos - i);
                byte[] bArr = new byte[i3];
                System.arraycopy(token.buffer, token.pos, bArr, 0, i3);
                token.pos += i3;
                variableResolutionLatentImage.setImageData(bArr);
                return variableResolutionLatentImage;
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            int i4 = tagInfo2.field;
            if (i4 == 20) {
                variableResolutionLatentImage.setComment(strNextWord);
            } else if (i4 != 24) {
                switch (i4) {
                    case 1:
                        variableResolutionLatentImage.setLogicalRecordLength(strNextWord);
                        break;
                    case 2:
                        variableResolutionLatentImage.setImageDesignationCharacter(strNextWord);
                        break;
                    case 3:
                        variableResolutionLatentImage.setImpressionType(strNextWord);
                        break;
                    case 4:
                        variableResolutionLatentImage.setSourceAgency(strNextWord);
                        break;
                    case 5:
                        variableResolutionLatentImage.setCaptureDate(strNextWord);
                        break;
                    case 6:
                        variableResolutionLatentImage.setHorizontalLineLength(strNextWord);
                        break;
                    case 7:
                        variableResolutionLatentImage.setVerticalLineLength(strNextWord);
                        break;
                    case 8:
                        variableResolutionLatentImage.setScaleUnits(strNextWord);
                        break;
                    case 9:
                        variableResolutionLatentImage.setHorizontalPixelScale(strNextWord);
                        break;
                    case 10:
                        variableResolutionLatentImage.setVerticalPixelScale(strNextWord);
                        break;
                    case 11:
                        variableResolutionLatentImage.setCompressionAlgorithm(strNextWord);
                        break;
                    case 12:
                        variableResolutionLatentImage.setBitsPerPixel(strNextWord);
                        break;
                    case 13:
                        variableResolutionLatentImage.setFingerPalmPosition(strNextWord);
                        break;
                    case 14:
                        variableResolutionLatentImage.setSearchPositionDescriptors(strNextWord);
                        break;
                    case 15:
                        variableResolutionLatentImage.setPrintPositionCoordinates(strNextWord);
                        break;
                    case 16:
                        variableResolutionLatentImage.setScannedHorizontalPixelScale(strNextWord);
                        break;
                    case 17:
                        variableResolutionLatentImage.setScannedVerticalPixelScale(strNextWord);
                        break;
                }
            } else {
                variableResolutionLatentImage.setLatentQualityMetric(strNextWord);
            }
        }
    }
}
