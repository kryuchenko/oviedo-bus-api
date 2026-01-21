package org.jnbis;

import java.util.Set;
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
public abstract class DecodedData {
    public abstract FacialAndSmtImage getFacialAndSmtImage(Integer num);

    public abstract Set<Integer> getFacialSmtKeys();

    public abstract Set<Integer> getHiResBinaryFingerPrintKeys();

    public abstract HighResolutionBinaryFingerprint getHiResBinaryFingerprint(Integer num);

    public abstract Set<Integer> getHiResGrayscaleFingerPrintKeys();

    public abstract HighResolutionGrayscaleFingerprint getHiResGrayscaleFingerprint(Integer num);

    public abstract IrisImage getIrisImage(Integer num);

    public abstract Set<Integer> getIrisImageKeys();

    public abstract Set<Integer> getLowResBinaryFingerPrintKeys();

    public abstract LowResolutionBinaryFingerprint getLowResBinaryFingerprint(Integer num);

    public abstract Set<Integer> getLowResGrayscaleFingerPrintKeys();

    public abstract LowResolutionGrayscaleFingerprint getLowResGrayscaleFingerprint(Integer num);

    public abstract MinutiaeData getMinutiaeData(Integer num);

    public abstract Set<Integer> getMinutiaeDataKeys();

    public abstract SignatureImage getSignature(Integer num);

    public abstract Set<Integer> getSignatureKeys();

    public abstract TransactionInformation getTransactionInfo(Integer num);

    public abstract Set<Integer> getTransactionKeys();

    public abstract UserDefinedImage getUserDefinedImage(Integer num);

    public abstract Set<Integer> getUserDefinedImageKeys();

    public abstract UserDefinedDescriptiveText getUserDefinedText(Integer num);

    public abstract Set<Integer> getUserDefinedTextKeys();

    public abstract VariableResolutionFingerprint getVariableResFingerprint(Integer num);

    public abstract Set<Integer> getVariableResFingerprintKeys();

    public abstract VariableResolutionLatentImage getVariableResLatentImage(Integer num);

    public abstract Set<Integer> getVariableResLatentImageKeys();

    public abstract VariableResolutionPalmprint getVariableResPalmprint(Integer num);

    public abstract Set<Integer> getVariableResPalmprintKeys();

    public enum Format {
        JPEG("jpeg"),
        GIF("gif"),
        PNG("png");

        private final String code;

        public String code() {
            return this.code;
        }

        Format(String str) {
            this.code = str;
        }
    }
}
