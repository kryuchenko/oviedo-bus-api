package org.jnbis.record;

import androidx.window.embedding.EmbeddingCompat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jnbis.internal.record.BaseRecord;

@JsonIgnoreProperties(ignoreUnknown = EmbeddingCompat.DEBUG)
/* loaded from: classes6.dex */
public class TransactionInformation extends BaseRecord {

    @JsonProperty("control_number")
    private String controlNumber;

    @JsonProperty("control_reference_number")
    private String controlReferenceNumber;

    @JsonProperty("date")
    private String date;

    @JsonProperty("destination_agency_id")
    private String destinationAgencyId;

    @JsonProperty("directory_of_charsets")
    private String directoryOfCharsets;

    @JsonProperty("domain_name")
    private String domainName;

    @JsonProperty("file_content")
    private String fileContent;

    @JsonProperty("greenwich_mean_time")
    private String greenwichMeanTime;

    @JsonProperty("native_scanning_resolution")
    private String nativeScanningResolution;

    @JsonProperty("nominal_transmitting_resolution")
    private String nominalTransmittingResolution;

    @JsonProperty("originating_agency_id")
    private String originatingAgencyId;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("type_of_transaction")
    private String typeOfTransaction;

    @JsonProperty("version")
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getFileContent() {
        return this.fileContent;
    }

    public void setFileContent(String str) {
        this.fileContent = str;
    }

    public String getTypeOfTransaction() {
        return this.typeOfTransaction;
    }

    public void setTypeOfTransaction(String str) {
        this.typeOfTransaction = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public String getDestinationAgencyId() {
        return this.destinationAgencyId;
    }

    public void setDestinationAgencyId(String str) {
        this.destinationAgencyId = str;
    }

    public String getOriginatingAgencyId() {
        return this.originatingAgencyId;
    }

    public void setOriginatingAgencyId(String str) {
        this.originatingAgencyId = str;
    }

    public String getControlNumber() {
        return this.controlNumber;
    }

    public void setControlNumber(String str) {
        this.controlNumber = str;
    }

    public String getControlReferenceNumber() {
        return this.controlReferenceNumber;
    }

    public void setControlReferenceNumber(String str) {
        this.controlReferenceNumber = str;
    }

    public String getNativeScanningResolution() {
        return this.nativeScanningResolution;
    }

    public void setNativeScanningResolution(String str) {
        this.nativeScanningResolution = str;
    }

    public String getNominalTransmittingResolution() {
        return this.nominalTransmittingResolution;
    }

    public void setNominalTransmittingResolution(String str) {
        this.nominalTransmittingResolution = str;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public String getGreenwichMeanTime() {
        return this.greenwichMeanTime;
    }

    public void setGreenwichMeanTime(String str) {
        this.greenwichMeanTime = str;
    }

    public String getDirectoryOfCharsets() {
        return this.directoryOfCharsets;
    }

    public void setDirectoryOfCharsets(String str) {
        this.directoryOfCharsets = str;
    }
}
