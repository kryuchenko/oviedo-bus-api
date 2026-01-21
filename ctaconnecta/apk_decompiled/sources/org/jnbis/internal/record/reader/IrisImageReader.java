package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.IrisImage;

/* loaded from: classes6.dex */
public class IrisImageReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public IrisImage read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T17::NULL pointer to T17 record");
        }
        IrisImage irisImage = new IrisImage();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T17::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        Integer numValueOf = Integer.valueOf(i2);
        irisImage.setLogicalRecordLength(numValueOf.toString());
        while (true) {
            token.pos++;
            NistHelper.Tag tagInfo2 = getTagInfo(token);
            if (tagInfo2.field == 999) {
                numValueOf.getClass();
                int i3 = i2 - (token.pos - i);
                byte[] bArr = new byte[i3];
                System.arraycopy(token.buffer, token.pos, bArr, 0, i3);
                token.pos += i3;
                irisImage.setImageData(bArr);
                return irisImage;
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            int i4 = tagInfo2.field;
            if (i4 != 30) {
                switch (i4) {
                    case 1:
                        irisImage.setLogicalRecordLength(strNextWord);
                        break;
                    case 2:
                        irisImage.setImageDesignationCharacter(strNextWord);
                        break;
                    case 3:
                        irisImage.setFeatureIdentifier(strNextWord);
                        break;
                    case 4:
                        irisImage.setSourceAgency(strNextWord);
                        break;
                    case 5:
                        irisImage.setCaptureDate(strNextWord);
                        break;
                    case 6:
                        irisImage.setHorizontalLineLength(strNextWord);
                        break;
                    case 7:
                        irisImage.setVerticalLineLength(strNextWord);
                        break;
                    case 8:
                        irisImage.setScaleUnits(strNextWord);
                        break;
                    case 9:
                        irisImage.setHorizontalPixelScale(strNextWord);
                        break;
                    case 10:
                        irisImage.setVerticalPixelScale(strNextWord);
                        break;
                    case 11:
                        irisImage.setCompressionAlgorithm(strNextWord);
                        break;
                    case 12:
                        irisImage.setBitsPerPixel(strNextWord);
                        break;
                    case 13:
                        irisImage.setColorSpace(strNextWord);
                        break;
                    case 14:
                        irisImage.setRotationAngleOfEye(strNextWord);
                        break;
                    case 15:
                        irisImage.setRotationUncertainty(strNextWord);
                        break;
                    case 16:
                        irisImage.setImagePropertyCode(strNextWord);
                        break;
                    case 17:
                        irisImage.setDeviceUniqueIdentifier(strNextWord);
                        break;
                    case 18:
                        irisImage.setGlobalUniqueIdentifier(strNextWord);
                        break;
                    case 19:
                        irisImage.setMakeModelSerialNumber(strNextWord);
                        break;
                    case 20:
                        irisImage.setEyeColor(strNextWord);
                        break;
                    case 21:
                        irisImage.setComment(strNextWord);
                        break;
                    case 22:
                        irisImage.setScannedHorizontalPixelScale(strNextWord);
                        break;
                    case 23:
                        irisImage.setScannedVerticalPixelScale(strNextWord);
                        break;
                    case 24:
                        irisImage.setImageQualityScore(strNextWord);
                        break;
                    case 25:
                        irisImage.setAcquisitionLightingSpectrum(strNextWord);
                        break;
                    case 26:
                        irisImage.setIrisDiameter(strNextWord);
                        break;
                }
            } else {
                irisImage.setDeviceMonitoringMode(strNextWord);
            }
        }
    }
}
