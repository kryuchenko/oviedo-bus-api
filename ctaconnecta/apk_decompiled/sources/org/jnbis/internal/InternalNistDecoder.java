package org.jnbis.internal;

import org.jnbis.Bitmap;
import org.jnbis.DecodedData;
import org.jnbis.ImageUtils;
import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.internal.record.reader.factory.RecordReaderFactory;
import org.jnbis.record.FacialAndSmtImage;
import org.jnbis.record.HighResolutionBinaryFingerprint;
import org.jnbis.record.HighResolutionGrayscaleFingerprint;
import org.jnbis.record.IrisImage;
import org.jnbis.record.LowResolutionBinaryFingerprint;
import org.jnbis.record.LowResolutionGrayscaleFingerprint;
import org.jnbis.record.MinutiaeData;
import org.jnbis.record.SignatureImage;
import org.jnbis.record.TransactionInformation;
import org.jnbis.record.UserDefinedDescriptiveText;
import org.jnbis.record.UserDefinedImage;
import org.jnbis.record.VariableResolutionFingerprint;
import org.jnbis.record.VariableResolutionLatentImage;
import org.jnbis.record.VariableResolutionPalmprint;

/* loaded from: classes6.dex */
public class InternalNistDecoder {
    private InternalWsqDecoder wsqDecoder = new InternalWsqDecoder();
    private ImageUtils imageUtils = new ImageUtils();
    private RecordReaderFactory readerFactory = new RecordReaderFactory();

    public DecodedData decode(byte[] bArr, DecodedData.Format format) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("data is null or zero length");
        }
        NistHelper.Token token = new NistHelper.Token(bArr);
        InternalDecodedData internalDecodedData = new InternalDecodedData();
        internalDecodedData.putTransactionInfo(Integer.valueOf(internalDecodedData.getTransactionKeys().size()), (TransactionInformation) this.readerFactory.read(token));
        while (nextRecord(token)) {
            if (token.crt >= 2) {
                BaseRecord baseRecord = this.readerFactory.read(token);
                if (baseRecord instanceof UserDefinedDescriptiveText) {
                    internalDecodedData.putUserDefinedText(Integer.valueOf(internalDecodedData.getUserDefinedTextKeys().size()), (UserDefinedDescriptiveText) baseRecord);
                } else if (baseRecord instanceof LowResolutionGrayscaleFingerprint) {
                    internalDecodedData.putLowResGrayscaleFingerPrint(Integer.valueOf(internalDecodedData.getLowResGrayscaleFingerPrintKeys().size()), (LowResolutionGrayscaleFingerprint) baseRecord);
                } else if (baseRecord instanceof HighResolutionGrayscaleFingerprint) {
                    HighResolutionGrayscaleFingerprint highResolutionGrayscaleFingerprint = (HighResolutionGrayscaleFingerprint) baseRecord;
                    if (WsqHelper.isWsqFormat(highResolutionGrayscaleFingerprint.getImageData())) {
                        Bitmap bitmapDecode = this.wsqDecoder.decode(highResolutionGrayscaleFingerprint.getImageData());
                        int i = AnonymousClass1.$SwitchMap$org$jnbis$DecodedData$Format[format.ordinal()];
                        if (i == 1) {
                            highResolutionGrayscaleFingerprint.setImageData(this.imageUtils.bitmap2jpeg(bitmapDecode));
                        } else if (i == 2) {
                            highResolutionGrayscaleFingerprint.setImageData(this.imageUtils.bitmap2gif(bitmapDecode));
                        } else if (i == 3) {
                            highResolutionGrayscaleFingerprint.setImageData(this.imageUtils.bitmap2png(bitmapDecode));
                        } else {
                            throw new RuntimeException("unsupported image format.");
                        }
                    }
                    internalDecodedData.putHiResGrayscaleFingerPrint(Integer.valueOf(internalDecodedData.getHiResGrayscaleFingerPrintKeys().size()), highResolutionGrayscaleFingerprint);
                } else if (baseRecord instanceof LowResolutionBinaryFingerprint) {
                    internalDecodedData.putLowResBinaryFingerPrint(Integer.valueOf(internalDecodedData.getLowResBinaryFingerPrintKeys().size()), (LowResolutionBinaryFingerprint) baseRecord);
                } else if (baseRecord instanceof HighResolutionBinaryFingerprint) {
                    internalDecodedData.putHiResBinaryFingerPrint(Integer.valueOf(internalDecodedData.getHiResBinaryFingerPrintKeys().size()), (HighResolutionBinaryFingerprint) baseRecord);
                } else if (baseRecord instanceof UserDefinedImage) {
                    internalDecodedData.putUserDefinedImage(Integer.valueOf(internalDecodedData.getUserDefinedImageKeys().size()), (UserDefinedImage) baseRecord);
                } else if (baseRecord instanceof SignatureImage) {
                    internalDecodedData.putSignature(Integer.valueOf(internalDecodedData.getSignatureKeys().size()), (SignatureImage) baseRecord);
                } else if (baseRecord instanceof MinutiaeData) {
                    internalDecodedData.putMinutiaeData(Integer.valueOf(internalDecodedData.getMinutiaeDataKeys().size()), (MinutiaeData) baseRecord);
                } else if (baseRecord instanceof FacialAndSmtImage) {
                    internalDecodedData.putFacialSmtImage(Integer.valueOf(internalDecodedData.getFacialSmtKeys().size()), (FacialAndSmtImage) baseRecord);
                } else if (baseRecord instanceof VariableResolutionLatentImage) {
                    internalDecodedData.putVariableResLatentImage(Integer.valueOf(internalDecodedData.getVariableResLatentImageKeys().size()), (VariableResolutionLatentImage) baseRecord);
                } else if (baseRecord instanceof VariableResolutionFingerprint) {
                    internalDecodedData.putVariableResFingerprint(Integer.valueOf(internalDecodedData.getVariableResFingerprintKeys().size()), (VariableResolutionFingerprint) baseRecord);
                } else if (baseRecord instanceof VariableResolutionPalmprint) {
                    internalDecodedData.putVariableResPalmprint(Integer.valueOf(internalDecodedData.getVariableResPalmprintKeys().size()), (VariableResolutionPalmprint) baseRecord);
                } else if (baseRecord instanceof IrisImage) {
                    internalDecodedData.putIrisImage(Integer.valueOf(internalDecodedData.getIrisImageKeys().size()), (IrisImage) baseRecord);
                }
            }
        }
        return internalDecodedData;
    }

    /* renamed from: org.jnbis.internal.InternalNistDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jnbis$DecodedData$Format;

        static {
            int[] iArr = new int[DecodedData.Format.values().length];
            $SwitchMap$org$jnbis$DecodedData$Format = iArr;
            try {
                iArr[DecodedData.Format.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jnbis$DecodedData$Format[DecodedData.Format.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jnbis$DecodedData$Format[DecodedData.Format.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean nextRecord(NistHelper.Token token) {
        if (token.header.length() == 0) {
            return false;
        }
        int iIndexOf = token.header.indexOf(30);
        if (iIndexOf == -1) {
            iIndexOf = token.header.length() - 1;
        }
        token.crt = Integer.parseInt(token.header.substring(0, token.header.indexOf(31)));
        token.header = token.header.substring(iIndexOf + 1);
        return true;
    }
}
