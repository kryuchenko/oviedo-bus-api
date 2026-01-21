package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

/* loaded from: classes6.dex */
public class IrisImage extends BaseVariableResolutionImageRecord {
    private String acquisitionLightingSpectrum;
    private String colorSpace;
    private String deviceUniqueIdentifier;
    private String eyeColor;
    private String featureIdentifier;
    private String globalUniqueIdentifier;
    private String imagePropertyCode;
    private String imageQualityScore;
    private String irisDiameter;
    private String makeModelSerialNumber;
    private String rotationAngleOfEye;
    private String rotationUncertainty;

    public String getFeatureIdentifier() {
        return this.featureIdentifier;
    }

    public void setFeatureIdentifier(String str) {
        this.featureIdentifier = str;
    }

    public String getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(String str) {
        this.colorSpace = str;
    }

    public String getRotationAngleOfEye() {
        return this.rotationAngleOfEye;
    }

    public void setRotationAngleOfEye(String str) {
        this.rotationAngleOfEye = str;
    }

    public String getRotationUncertainty() {
        return this.rotationUncertainty;
    }

    public void setRotationUncertainty(String str) {
        this.rotationUncertainty = str;
    }

    public String getImagePropertyCode() {
        return this.imagePropertyCode;
    }

    public void setImagePropertyCode(String str) {
        this.imagePropertyCode = str;
    }

    public String getDeviceUniqueIdentifier() {
        return this.deviceUniqueIdentifier;
    }

    public void setDeviceUniqueIdentifier(String str) {
        this.deviceUniqueIdentifier = str;
    }

    public String getGlobalUniqueIdentifier() {
        return this.globalUniqueIdentifier;
    }

    public void setGlobalUniqueIdentifier(String str) {
        this.globalUniqueIdentifier = str;
    }

    public String getMakeModelSerialNumber() {
        return this.makeModelSerialNumber;
    }

    public void setMakeModelSerialNumber(String str) {
        this.makeModelSerialNumber = str;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String str) {
        this.eyeColor = str;
    }

    public String getImageQualityScore() {
        return this.imageQualityScore;
    }

    public void setImageQualityScore(String str) {
        this.imageQualityScore = str;
    }

    public String getAcquisitionLightingSpectrum() {
        return this.acquisitionLightingSpectrum;
    }

    public void setAcquisitionLightingSpectrum(String str) {
        this.acquisitionLightingSpectrum = str;
    }

    public String getIrisDiameter() {
        return this.irisDiameter;
    }

    public void setIrisDiameter(String str) {
        this.irisDiameter = str;
    }
}
