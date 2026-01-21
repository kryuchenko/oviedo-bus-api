package com.iecisa.ctausuario.model.transportcardrequest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class DoBUserDataModel implements Parcelable {

    @SerializedName(PlaceTypes.ADDRESS)
    @Expose
    private String address;

    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    @SerializedName("dictaminationResult")
    @Expose
    private String dictaminationResult;

    @SerializedName("docNum")
    @Expose
    private String docNum;

    @SerializedName("docType")
    @Expose
    private Integer docType;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("isComplete")
    @Expose
    private Boolean isComplete;

    @SerializedName("isForeigner")
    @Expose
    private Boolean isForeigner;

    @SerializedName("isRepresentative")
    @Expose
    private Boolean isRepresentative;

    @SerializedName("lastName2")
    @Expose
    private String lastName;

    @SerializedName(PlaceTypes.LOCALITY)
    @Expose
    private String locality;

    @SerializedName("lopd")
    @Expose
    private Boolean lopd;

    @SerializedName("manualRevision")
    @Expose
    private Boolean manualRevision;

    @SerializedName("mobilePhone")
    @Expose
    private String mobilePhone;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    @Expose
    private String name;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("province")
    @Expose
    private String province;

    @SerializedName("relationId")
    @Expose
    private Integer relationId;

    @SerializedName("representantHolderNumDoc")
    @Expose
    private String representantHolderNumDoc;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;

    @SerializedName("lastName1")
    @Expose
    private String surname;

    @SerializedName("userId")
    @Expose
    private String userId;
    public static final Integer STATUS_CODE_USER_EXISTS = 1;
    public static final Integer STATUS_CODE_REPRESENTATIVE_EXISTS = 2;
    public static final Integer STATUS_CODE_IN_PROGRESS = 3;
    public static final Parcelable.Creator<DoBUserDataModel> CREATOR = new Parcelable.Creator<DoBUserDataModel>() { // from class: com.iecisa.ctausuario.model.transportcardrequest.DoBUserDataModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoBUserDataModel createFromParcel(Parcel in) {
            return new DoBUserDataModel(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoBUserDataModel[] newArray(int size) {
            return new DoBUserDataModel[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected DoBUserDataModel(Parcel in) {
        Boolean boolValueOf;
        Boolean boolValueOf2;
        Boolean boolValueOf3;
        Boolean boolValueOf4;
        Boolean boolValueOf5;
        if (in.readByte() == 0) {
            this.statusCode = null;
        } else {
            this.statusCode = Integer.valueOf(in.readInt());
        }
        byte b = in.readByte();
        if (b == 0) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(b == 1);
        }
        this.isComplete = boolValueOf;
        this.dictaminationResult = in.readString();
        this.docNum = in.readString();
        this.name = in.readString();
        this.surname = in.readString();
        this.lastName = in.readString();
        this.userId = in.readString();
        if (in.readByte() == 0) {
            this.docType = null;
        } else {
            this.docType = Integer.valueOf(in.readInt());
        }
        this.sex = in.readString();
        this.birthDate = in.readString();
        byte b2 = in.readByte();
        if (b2 == 0) {
            boolValueOf2 = null;
        } else {
            boolValueOf2 = Boolean.valueOf(b2 == 1);
        }
        this.isForeigner = boolValueOf2;
        this.address = in.readString();
        this.locality = in.readString();
        this.postalCode = in.readString();
        this.province = in.readString();
        this.phone = in.readString();
        this.mobilePhone = in.readString();
        this.email = in.readString();
        this.photo = in.readString();
        byte b3 = in.readByte();
        if (b3 == 0) {
            boolValueOf3 = null;
        } else {
            boolValueOf3 = Boolean.valueOf(b3 == 1);
        }
        this.lopd = boolValueOf3;
        byte b4 = in.readByte();
        if (b4 == 0) {
            boolValueOf4 = null;
        } else {
            boolValueOf4 = Boolean.valueOf(b4 == 1);
        }
        this.isRepresentative = boolValueOf4;
        byte b5 = in.readByte();
        if (b5 == 0) {
            boolValueOf5 = null;
        } else {
            boolValueOf5 = Boolean.valueOf(b5 == 1);
        }
        this.manualRevision = boolValueOf5;
        this.representantHolderNumDoc = in.readString();
        if (in.readByte() == 0) {
            this.relationId = null;
        } else {
            this.relationId = Integer.valueOf(in.readInt());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.statusCode == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.statusCode.intValue());
        }
        Boolean bool = this.isComplete;
        int i = 2;
        dest.writeByte((byte) (bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        dest.writeString(this.dictaminationResult);
        dest.writeString(this.docNum);
        dest.writeString(this.name);
        dest.writeString(this.surname);
        dest.writeString(this.lastName);
        dest.writeString(this.userId);
        if (this.docType == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.docType.intValue());
        }
        dest.writeString(this.sex);
        dest.writeString(this.birthDate);
        Boolean bool2 = this.isForeigner;
        dest.writeByte((byte) (bool2 == null ? 0 : bool2.booleanValue() ? 1 : 2));
        dest.writeString(this.address);
        dest.writeString(this.locality);
        dest.writeString(this.postalCode);
        dest.writeString(this.province);
        dest.writeString(this.phone);
        dest.writeString(this.mobilePhone);
        dest.writeString(this.email);
        dest.writeString(this.photo);
        Boolean bool3 = this.lopd;
        dest.writeByte((byte) (bool3 == null ? 0 : bool3.booleanValue() ? 1 : 2));
        Boolean bool4 = this.isRepresentative;
        dest.writeByte((byte) (bool4 == null ? 0 : bool4.booleanValue() ? 1 : 2));
        Boolean bool5 = this.manualRevision;
        if (bool5 == null) {
            i = 0;
        } else if (bool5.booleanValue()) {
            i = 1;
        }
        dest.writeByte((byte) i);
        dest.writeString(this.representantHolderNumDoc);
        if (this.relationId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.relationId.intValue());
        }
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getComplete() {
        return this.isComplete;
    }

    public void setComplete(Boolean complete) {
        this.isComplete = complete;
    }

    public String getDictaminationResult() {
        return this.dictaminationResult;
    }

    public void setDictaminationResult(String dictaminationResult) {
        this.dictaminationResult = dictaminationResult;
    }

    public String getDocNum() {
        return this.docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDocType() {
        return this.docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getForeigner() {
        return this.isForeigner;
    }

    public void setForeigner(Boolean foreigner) {
        this.isForeigner = foreigner;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return this.locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getLopd() {
        return this.lopd;
    }

    public void setLopd(Boolean lopd) {
        this.lopd = lopd;
    }

    public Boolean getRepresentative() {
        return this.isRepresentative;
    }

    public void setRepresentative(Boolean representative) {
        this.isRepresentative = representative;
    }

    public Boolean getManualRevision() {
        return this.manualRevision;
    }

    public void setManualRevision(Boolean manualRevision) {
        this.manualRevision = manualRevision;
    }

    public String getRepresentantHolderNumDoc() {
        return this.representantHolderNumDoc;
    }

    public void setRepresentantHolderNumDoc(String representantHolderNumDoc) {
        this.representantHolderNumDoc = representantHolderNumDoc;
    }

    public Integer getRelationId() {
        return this.relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }
}
