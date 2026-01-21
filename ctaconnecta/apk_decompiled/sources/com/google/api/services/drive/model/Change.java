package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* loaded from: classes4.dex */
public final class Change extends GenericJson {

    @Key
    private File file;

    @Key
    private String fileId;

    @Key
    private String kind;

    @Key
    private Boolean removed;

    @Key
    private TeamDrive teamDrive;

    @Key
    private String teamDriveId;

    @Key
    private DateTime time;

    @Key
    private String type;

    public File getFile() {
        return this.file;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public String getFileId() {
        return this.fileId;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Change setKind(String str) {
        this.kind = str;
        return this;
    }

    public Boolean getRemoved() {
        return this.removed;
    }

    public Change setRemoved(Boolean bool) {
        this.removed = bool;
        return this;
    }

    public TeamDrive getTeamDrive() {
        return this.teamDrive;
    }

    public Change setTeamDrive(TeamDrive teamDrive) {
        this.teamDrive = teamDrive;
        return this;
    }

    public String getTeamDriveId() {
        return this.teamDriveId;
    }

    public Change setTeamDriveId(String str) {
        this.teamDriveId = str;
        return this;
    }

    public DateTime getTime() {
        return this.time;
    }

    public Change setTime(DateTime dateTime) {
        this.time = dateTime;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Change setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}
