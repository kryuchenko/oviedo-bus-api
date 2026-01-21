package org.jnbis.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jnbis.internal.record.BaseImageRecord;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public class FacialAndSmtImage extends BaseImageRecord {

    @JsonProperty("color_space")
    private String colorSpace;

    @JsonProperty("colors_present")
    private String colorsPresent;

    @JsonProperty("device_monitoring_mode")
    private String deviceMonitoringMode;

    @JsonProperty("facial_feature_points")
    private String facialFeaturePoints;

    @JsonProperty("horizontal_pixel_scale")
    private String horizontalPixelScale;

    @JsonProperty("image_type")
    private String imageType;

    @JsonProperty("ncic_designation_code")
    private String ncicDesignationCode;

    @JsonProperty("photo_acquisition_source")
    private String photoAcquisitionSource;

    @JsonProperty("photo_date")
    private String photoDate;

    @JsonProperty("photo_description")
    private String photoDescription;

    @JsonProperty("pose_offset_angle")
    private String poseOffsetAngle;

    @JsonProperty("scale_units")
    private String scaleUnits;

    @JsonProperty("scanned_horizontal_pixel_scale")
    private String scannedHorizontalPixelScale;

    @JsonProperty("scanned_vertical_pixel_scale")
    private String scannedVerticalPixelScale;

    @JsonProperty("scar_mark_tattoo_size")
    private String scarMarkTattooSize;

    @JsonProperty("smt_descriptors")
    private String smtDescriptors;

    @JsonProperty("source_agency")
    private String sourceAgency;

    @JsonProperty("subject_acquisition_profile")
    private String subjectAcquisitionProfile;

    @JsonProperty("subject_eye_color")
    private String subjectEyeColor;

    @JsonProperty("subject_facial_description")
    private String subjectFacialDescription;

    @JsonProperty("subject_hair_color")
    private String subjectHairColor;

    @JsonProperty("subject_pose")
    private String subjectPose;

    @JsonProperty("subject_pose_angles")
    private String subjectPoseAngles;

    @JsonProperty("subject_quality_score")
    private String subjectQualityScore;

    @JsonProperty("vertical_pixel_scale")
    private String verticalPixelScale;

    public String getImageType() {
        return this.imageType;
    }

    public void setImageType(String str) {
        this.imageType = str;
    }

    public String getSourceAgency() {
        return this.sourceAgency;
    }

    public void setSourceAgency(String str) {
        this.sourceAgency = str;
    }

    public String getPhotoDate() {
        return this.photoDate;
    }

    public void setPhotoDate(String str) {
        this.photoDate = str;
    }

    public String getScaleUnits() {
        return this.scaleUnits;
    }

    public void setScaleUnits(String str) {
        this.scaleUnits = str;
    }

    public String getHorizontalPixelScale() {
        return this.horizontalPixelScale;
    }

    public void setHorizontalPixelScale(String str) {
        this.horizontalPixelScale = str;
    }

    public String getVerticalPixelScale() {
        return this.verticalPixelScale;
    }

    public void setVerticalPixelScale(String str) {
        this.verticalPixelScale = str;
    }

    public String getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(String str) {
        this.colorSpace = str;
    }

    public String getSubjectAcquisitionProfile() {
        return this.subjectAcquisitionProfile;
    }

    public void setSubjectAcquisitionProfile(String str) {
        this.subjectAcquisitionProfile = str;
    }

    public String getScannedHorizontalPixelScale() {
        return this.scannedHorizontalPixelScale;
    }

    public void setScannedHorizontalPixelScale(String str) {
        this.scannedHorizontalPixelScale = str;
    }

    public String getScannedVerticalPixelScale() {
        return this.scannedVerticalPixelScale;
    }

    public void setScannedVerticalPixelScale(String str) {
        this.scannedVerticalPixelScale = str;
    }

    public String getSubjectPose() {
        return this.subjectPose;
    }

    public void setSubjectPose(String str) {
        this.subjectPose = str;
    }

    public String getPoseOffsetAngle() {
        return this.poseOffsetAngle;
    }

    public void setPoseOffsetAngle(String str) {
        this.poseOffsetAngle = str;
    }

    public String getPhotoDescription() {
        return this.photoDescription;
    }

    public void setPhotoDescription(String str) {
        this.photoDescription = str;
    }

    public String getPhotoAcquisitionSource() {
        return this.photoAcquisitionSource;
    }

    public void setPhotoAcquisitionSource(String str) {
        this.photoAcquisitionSource = str;
    }

    public String getSubjectQualityScore() {
        return this.subjectQualityScore;
    }

    public void setSubjectQualityScore(String str) {
        this.subjectQualityScore = str;
    }

    public String getSubjectPoseAngles() {
        return this.subjectPoseAngles;
    }

    public void setSubjectPoseAngles(String str) {
        this.subjectPoseAngles = str;
    }

    public String getSubjectFacialDescription() {
        return this.subjectFacialDescription;
    }

    public void setSubjectFacialDescription(String str) {
        this.subjectFacialDescription = str;
    }

    public String getSubjectEyeColor() {
        return this.subjectEyeColor;
    }

    public void setSubjectEyeColor(String str) {
        this.subjectEyeColor = str;
    }

    public String getSubjectHairColor() {
        return this.subjectHairColor;
    }

    public void setSubjectHairColor(String str) {
        this.subjectHairColor = str;
    }

    public String getFacialFeaturePoints() {
        return this.facialFeaturePoints;
    }

    public void setFacialFeaturePoints(String str) {
        this.facialFeaturePoints = str;
    }

    public String getDeviceMonitoringMode() {
        return this.deviceMonitoringMode;
    }

    public void setDeviceMonitoringMode(String str) {
        this.deviceMonitoringMode = str;
    }

    public String getNcicDesignationCode() {
        return this.ncicDesignationCode;
    }

    public void setNcicDesignationCode(String str) {
        this.ncicDesignationCode = str;
    }

    public String getScarMarkTattooSize() {
        return this.scarMarkTattooSize;
    }

    public void setScarMarkTattooSize(String str) {
        this.scarMarkTattooSize = str;
    }

    public String getSmtDescriptors() {
        return this.smtDescriptors;
    }

    public void setSmtDescriptors(String str) {
        this.smtDescriptors = str;
    }

    public String getColorsPresent() {
        return this.colorsPresent;
    }

    public void setColorsPresent(String str) {
        this.colorsPresent = str;
    }
}
