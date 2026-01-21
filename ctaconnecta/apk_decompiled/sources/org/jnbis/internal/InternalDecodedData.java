package org.jnbis.internal;

import java.util.HashMap;
import java.util.Set;
import org.jnbis.DecodedData;
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
public class InternalDecodedData extends DecodedData {
    private final HashMap<Integer, TransactionInformation> transactionInformation = new HashMap<>();
    private final HashMap<Integer, UserDefinedDescriptiveText> userDefinedText = new HashMap<>();
    private final HashMap<Integer, LowResolutionGrayscaleFingerprint> lowResolutionGrayscaleFingerprint = new HashMap<>();
    private final HashMap<Integer, HighResolutionGrayscaleFingerprint> hiResolutionGrayscaleFingerprint = new HashMap<>();
    private final HashMap<Integer, LowResolutionBinaryFingerprint> lowResolutionBinaryFingerprint = new HashMap<>();
    private final HashMap<Integer, HighResolutionBinaryFingerprint> hiResolutionBinaryFingerprint = new HashMap<>();
    private final HashMap<Integer, UserDefinedImage> userDefinedImage = new HashMap<>();
    private final HashMap<Integer, SignatureImage> signatureImage = new HashMap<>();
    private final HashMap<Integer, MinutiaeData> minutiaeData = new HashMap<>();
    private final HashMap<Integer, FacialAndSmtImage> facialAndSmtImage = new HashMap<>();
    private final HashMap<Integer, VariableResolutionLatentImage> variableResolutionLatentImage = new HashMap<>();
    private final HashMap<Integer, VariableResolutionFingerprint> variableResolutionFingerprint = new HashMap<>();
    private final HashMap<Integer, VariableResolutionPalmprint> variableResolutionPalmprint = new HashMap<>();
    private final HashMap<Integer, IrisImage> irisImage = new HashMap<>();

    void putTransactionInfo(Integer num, TransactionInformation transactionInformation) {
        this.transactionInformation.put(num, transactionInformation);
    }

    void putUserDefinedText(Integer num, UserDefinedDescriptiveText userDefinedDescriptiveText) {
        this.userDefinedText.put(num, userDefinedDescriptiveText);
    }

    void putLowResGrayscaleFingerPrint(Integer num, LowResolutionGrayscaleFingerprint lowResolutionGrayscaleFingerprint) {
        this.lowResolutionGrayscaleFingerprint.put(num, lowResolutionGrayscaleFingerprint);
    }

    void putHiResGrayscaleFingerPrint(Integer num, HighResolutionGrayscaleFingerprint highResolutionGrayscaleFingerprint) {
        this.hiResolutionGrayscaleFingerprint.put(num, highResolutionGrayscaleFingerprint);
    }

    void putLowResBinaryFingerPrint(Integer num, LowResolutionBinaryFingerprint lowResolutionBinaryFingerprint) {
        this.lowResolutionBinaryFingerprint.put(num, lowResolutionBinaryFingerprint);
    }

    void putHiResBinaryFingerPrint(Integer num, HighResolutionBinaryFingerprint highResolutionBinaryFingerprint) {
        this.hiResolutionBinaryFingerprint.put(num, highResolutionBinaryFingerprint);
    }

    void putUserDefinedImage(Integer num, UserDefinedImage userDefinedImage) {
        this.userDefinedImage.put(num, userDefinedImage);
    }

    void putSignature(Integer num, SignatureImage signatureImage) {
        this.signatureImage.put(num, signatureImage);
    }

    void putMinutiaeData(Integer num, MinutiaeData minutiaeData) {
        this.minutiaeData.put(num, minutiaeData);
    }

    void putFacialSmtImage(Integer num, FacialAndSmtImage facialAndSmtImage) {
        this.facialAndSmtImage.put(num, facialAndSmtImage);
    }

    void putVariableResLatentImage(Integer num, VariableResolutionLatentImage variableResolutionLatentImage) {
        this.variableResolutionLatentImage.put(num, variableResolutionLatentImage);
    }

    void putVariableResFingerprint(Integer num, VariableResolutionFingerprint variableResolutionFingerprint) {
        this.variableResolutionFingerprint.put(num, variableResolutionFingerprint);
    }

    void putVariableResPalmprint(Integer num, VariableResolutionPalmprint variableResolutionPalmprint) {
        this.variableResolutionPalmprint.put(num, variableResolutionPalmprint);
    }

    void putIrisImage(Integer num, IrisImage irisImage) {
        this.irisImage.put(num, irisImage);
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getTransactionKeys() {
        return this.transactionInformation.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getUserDefinedTextKeys() {
        return this.userDefinedText.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getLowResBinaryFingerPrintKeys() {
        return this.lowResolutionBinaryFingerprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getHiResBinaryFingerPrintKeys() {
        return this.hiResolutionBinaryFingerprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getLowResGrayscaleFingerPrintKeys() {
        return this.lowResolutionGrayscaleFingerprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getHiResGrayscaleFingerPrintKeys() {
        return this.hiResolutionGrayscaleFingerprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getUserDefinedImageKeys() {
        return this.userDefinedImage.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getSignatureKeys() {
        return this.signatureImage.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getMinutiaeDataKeys() {
        return this.minutiaeData.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getFacialSmtKeys() {
        return this.facialAndSmtImage.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getVariableResLatentImageKeys() {
        return this.variableResolutionLatentImage.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getVariableResFingerprintKeys() {
        return this.variableResolutionFingerprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getVariableResPalmprintKeys() {
        return this.variableResolutionPalmprint.keySet();
    }

    @Override // org.jnbis.DecodedData
    public Set<Integer> getIrisImageKeys() {
        return this.irisImage.keySet();
    }

    @Override // org.jnbis.DecodedData
    public TransactionInformation getTransactionInfo(Integer num) {
        if (this.transactionInformation.containsKey(num)) {
            return this.transactionInformation.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public UserDefinedDescriptiveText getUserDefinedText(Integer num) {
        if (this.userDefinedText.containsKey(num)) {
            return this.userDefinedText.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public LowResolutionGrayscaleFingerprint getLowResGrayscaleFingerprint(Integer num) {
        if (this.lowResolutionGrayscaleFingerprint.containsKey(num)) {
            return this.lowResolutionGrayscaleFingerprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public HighResolutionGrayscaleFingerprint getHiResGrayscaleFingerprint(Integer num) {
        if (this.hiResolutionGrayscaleFingerprint.containsKey(num)) {
            return this.hiResolutionGrayscaleFingerprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public LowResolutionBinaryFingerprint getLowResBinaryFingerprint(Integer num) {
        if (this.lowResolutionBinaryFingerprint.containsKey(num)) {
            return this.lowResolutionBinaryFingerprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public HighResolutionBinaryFingerprint getHiResBinaryFingerprint(Integer num) {
        if (this.hiResolutionBinaryFingerprint.containsKey(num)) {
            return this.hiResolutionBinaryFingerprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public UserDefinedImage getUserDefinedImage(Integer num) {
        if (this.userDefinedImage.containsKey(num)) {
            return this.userDefinedImage.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public SignatureImage getSignature(Integer num) {
        if (this.signatureImage.containsKey(num)) {
            return this.signatureImage.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public MinutiaeData getMinutiaeData(Integer num) {
        if (this.minutiaeData.containsKey(num)) {
            return this.minutiaeData.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public FacialAndSmtImage getFacialAndSmtImage(Integer num) {
        if (this.facialAndSmtImage.containsKey(num)) {
            return this.facialAndSmtImage.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public VariableResolutionLatentImage getVariableResLatentImage(Integer num) {
        if (this.variableResolutionLatentImage.containsKey(num)) {
            return this.variableResolutionLatentImage.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public VariableResolutionFingerprint getVariableResFingerprint(Integer num) {
        if (this.variableResolutionFingerprint.containsKey(num)) {
            return this.variableResolutionFingerprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public VariableResolutionPalmprint getVariableResPalmprint(Integer num) {
        if (this.variableResolutionPalmprint.containsKey(num)) {
            return this.variableResolutionPalmprint.get(num);
        }
        return null;
    }

    @Override // org.jnbis.DecodedData
    public IrisImage getIrisImage(Integer num) {
        if (this.irisImage.containsKey(num)) {
            return this.irisImage.get(num);
        }
        return null;
    }
}
