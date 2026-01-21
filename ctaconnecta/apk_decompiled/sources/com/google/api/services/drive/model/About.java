package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class About extends GenericJson {

    @Key
    private Boolean appInstalled;

    @Key
    private Boolean canCreateTeamDrives;

    @Key
    private Map<String, List<String>> exportFormats;

    @Key
    private List<String> folderColorPalette;

    @Key
    private Map<String, List<String>> importFormats;

    @Key
    private String kind;

    @JsonString
    @Key
    private Map<String, Long> maxImportSizes;

    @JsonString
    @Key
    private Long maxUploadSize;

    @Key
    private StorageQuota storageQuota;

    @Key
    private List<TeamDriveThemes> teamDriveThemes;

    @Key
    private User user;

    static {
        Data.nullOf(TeamDriveThemes.class);
    }

    public Boolean getAppInstalled() {
        return this.appInstalled;
    }

    public About setAppInstalled(Boolean bool) {
        this.appInstalled = bool;
        return this;
    }

    public Boolean getCanCreateTeamDrives() {
        return this.canCreateTeamDrives;
    }

    public About setCanCreateTeamDrives(Boolean bool) {
        this.canCreateTeamDrives = bool;
        return this;
    }

    public Map<String, List<String>> getExportFormats() {
        return this.exportFormats;
    }

    public About setExportFormats(Map<String, List<String>> map) {
        this.exportFormats = map;
        return this;
    }

    public List<String> getFolderColorPalette() {
        return this.folderColorPalette;
    }

    public About setFolderColorPalette(List<String> list) {
        this.folderColorPalette = list;
        return this;
    }

    public Map<String, List<String>> getImportFormats() {
        return this.importFormats;
    }

    public About setImportFormats(Map<String, List<String>> map) {
        this.importFormats = map;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public About setKind(String str) {
        this.kind = str;
        return this;
    }

    public Map<String, Long> getMaxImportSizes() {
        return this.maxImportSizes;
    }

    public About setMaxImportSizes(Map<String, Long> map) {
        this.maxImportSizes = map;
        return this;
    }

    public Long getMaxUploadSize() {
        return this.maxUploadSize;
    }

    public About setMaxUploadSize(Long l) {
        this.maxUploadSize = l;
        return this;
    }

    public StorageQuota getStorageQuota() {
        return this.storageQuota;
    }

    public About setStorageQuota(StorageQuota storageQuota) {
        this.storageQuota = storageQuota;
        return this;
    }

    public List<TeamDriveThemes> getTeamDriveThemes() {
        return this.teamDriveThemes;
    }

    public About setTeamDriveThemes(List<TeamDriveThemes> list) {
        this.teamDriveThemes = list;
        return this;
    }

    public User getUser() {
        return this.user;
    }

    public About setUser(User user) {
        this.user = user;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public About set(String str, Object obj) {
        return (About) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public About clone() {
        return (About) super.clone();
    }

    public static final class StorageQuota extends GenericJson {

        @JsonString
        @Key
        private Long limit;

        @JsonString
        @Key
        private Long usage;

        @JsonString
        @Key
        private Long usageInDrive;

        @JsonString
        @Key
        private Long usageInDriveTrash;

        public Long getLimit() {
            return this.limit;
        }

        public StorageQuota setLimit(Long l) {
            this.limit = l;
            return this;
        }

        public Long getUsage() {
            return this.usage;
        }

        public StorageQuota setUsage(Long l) {
            this.usage = l;
            return this;
        }

        public Long getUsageInDrive() {
            return this.usageInDrive;
        }

        public StorageQuota setUsageInDrive(Long l) {
            this.usageInDrive = l;
            return this;
        }

        public Long getUsageInDriveTrash() {
            return this.usageInDriveTrash;
        }

        public StorageQuota setUsageInDriveTrash(Long l) {
            this.usageInDriveTrash = l;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public StorageQuota set(String str, Object obj) {
            return (StorageQuota) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public StorageQuota clone() {
            return (StorageQuota) super.clone();
        }
    }

    public static final class TeamDriveThemes extends GenericJson {

        @Key
        private String backgroundImageLink;

        @Key
        private String colorRgb;

        @Key
        private String id;

        public String getBackgroundImageLink() {
            return this.backgroundImageLink;
        }

        public TeamDriveThemes setBackgroundImageLink(String str) {
            this.backgroundImageLink = str;
            return this;
        }

        public String getColorRgb() {
            return this.colorRgb;
        }

        public TeamDriveThemes setColorRgb(String str) {
            this.colorRgb = str;
            return this;
        }

        public String getId() {
            return this.id;
        }

        public TeamDriveThemes setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public TeamDriveThemes set(String str, Object obj) {
            return (TeamDriveThemes) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public TeamDriveThemes clone() {
            return (TeamDriveThemes) super.clone();
        }
    }
}
