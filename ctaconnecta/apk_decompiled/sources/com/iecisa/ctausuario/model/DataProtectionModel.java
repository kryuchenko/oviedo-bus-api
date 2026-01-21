package com.iecisa.ctausuario.model;

/* loaded from: classes5.dex */
public class DataProtectionModel {
    private int id;
    private boolean isChecked;
    private boolean isMandatory;
    private String name;

    public DataProtectionModel(int id, String name, boolean isChecked, boolean isMandatory) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.isMandatory = isMandatory;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }

    public boolean isMandatory() {
        return this.isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.isMandatory = mandatory;
    }
}
