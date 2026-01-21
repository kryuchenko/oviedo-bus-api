package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.record.FacialAndSmtImage;

/* loaded from: classes6.dex */
public class FacialAndSmtImageReader extends RecordReader {
    @Override // org.jnbis.internal.record.reader.RecordReader
    public FacialAndSmtImage read(NistHelper.Token token) throws NumberFormatException {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T10::NULL pointer to T10 record");
        }
        FacialAndSmtImage facialAndSmtImage = new FacialAndSmtImage();
        int i = token.pos;
        NistHelper.Tag tagInfo = getTagInfo(token);
        if (tagInfo.field != 1) {
            throw new RuntimeException("T10::Invalid Record type = " + tagInfo.type);
        }
        int i2 = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));
        Integer numValueOf = Integer.valueOf(i2);
        facialAndSmtImage.setLogicalRecordLength(numValueOf.toString());
        while (true) {
            token.pos++;
            NistHelper.Tag tagInfo2 = getTagInfo(token);
            if (tagInfo2.field == 999) {
                numValueOf.getClass();
                int i3 = i2 - (token.pos - i);
                byte[] bArr = new byte[i3];
                System.arraycopy(token.buffer, token.pos, bArr, 0, i3);
                token.pos += i3;
                facialAndSmtImage.setImageData(bArr);
                return facialAndSmtImage;
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            int i4 = tagInfo2.field;
            if (i4 == 16) {
                facialAndSmtImage.setScannedHorizontalPixelScale(strNextWord);
            } else if (i4 != 17) {
                switch (i4) {
                    case 1:
                        facialAndSmtImage.setLogicalRecordLength(strNextWord);
                        break;
                    case 2:
                        facialAndSmtImage.setImageDesignationCharacter(strNextWord);
                        break;
                    case 3:
                        facialAndSmtImage.setImageType(strNextWord);
                        break;
                    case 4:
                        facialAndSmtImage.setSourceAgency(strNextWord);
                        break;
                    case 5:
                        facialAndSmtImage.setPhotoDate(strNextWord);
                        break;
                    case 6:
                        facialAndSmtImage.setHorizontalLineLength(strNextWord);
                        break;
                    case 7:
                        facialAndSmtImage.setVerticalLineLength(strNextWord);
                        break;
                    case 8:
                        facialAndSmtImage.setScaleUnits(strNextWord);
                        break;
                    case 9:
                        facialAndSmtImage.setHorizontalPixelScale(strNextWord);
                        break;
                    case 10:
                        facialAndSmtImage.setVerticalPixelScale(strNextWord);
                        break;
                    case 11:
                        facialAndSmtImage.setCompressionAlgorithm(strNextWord);
                        break;
                    case 12:
                        facialAndSmtImage.setColorSpace(strNextWord);
                        break;
                    case 13:
                        facialAndSmtImage.setSubjectAcquisitionProfile(strNextWord);
                        break;
                    default:
                        switch (i4) {
                            case 20:
                                facialAndSmtImage.setSubjectPose(strNextWord);
                                break;
                            case 21:
                                facialAndSmtImage.setPoseOffsetAngle(strNextWord);
                                break;
                            case 22:
                                facialAndSmtImage.setPhotoDescription(strNextWord);
                                break;
                            case 23:
                                facialAndSmtImage.setPhotoAcquisitionSource(strNextWord);
                                break;
                            case 24:
                                facialAndSmtImage.setSubjectQualityScore(strNextWord);
                                break;
                            case 25:
                                facialAndSmtImage.setSubjectPoseAngles(strNextWord);
                                break;
                            case 26:
                                facialAndSmtImage.setSubjectFacialDescription(strNextWord);
                                break;
                            case 27:
                                facialAndSmtImage.setSubjectEyeColor(strNextWord);
                                break;
                            case 28:
                                facialAndSmtImage.setSubjectHairColor(strNextWord);
                                break;
                            case 29:
                                facialAndSmtImage.setFacialFeaturePoints(strNextWord);
                                break;
                            case 30:
                                facialAndSmtImage.setDeviceMonitoringMode(strNextWord);
                                break;
                            default:
                                switch (i4) {
                                    case 40:
                                        facialAndSmtImage.setNcicDesignationCode(strNextWord);
                                        break;
                                    case 41:
                                        facialAndSmtImage.setScarMarkTattooSize(strNextWord);
                                        break;
                                    case 42:
                                        facialAndSmtImage.setSmtDescriptors(strNextWord);
                                        break;
                                    case 43:
                                        facialAndSmtImage.setColorsPresent(strNextWord);
                                        break;
                                }
                        }
                }
            } else {
                facialAndSmtImage.setScannedVerticalPixelScale(strNextWord);
            }
        }
    }
}
