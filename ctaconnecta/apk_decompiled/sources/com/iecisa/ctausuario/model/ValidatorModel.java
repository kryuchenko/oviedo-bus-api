package com.iecisa.ctausuario.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes5.dex */
public class ValidatorModel {
    private boolean isActivated = false;
    private Boolean isChecked;
    private TextView repeatView;
    private int typeValidator;
    private View view;

    public ValidatorModel(int typeValidator, TextView view) {
        this.typeValidator = typeValidator;
        this.view = view;
    }

    public ValidatorModel(int typeValidator, ImageView view) {
        this.typeValidator = typeValidator;
        this.view = view;
    }

    public ValidatorModel(int typeValidator, TextView view, TextView repeatView) {
        this.typeValidator = typeValidator;
        this.view = view;
        this.repeatView = repeatView;
    }

    public ValidatorModel(int typeValidator, boolean isChecked) {
        this.typeValidator = typeValidator;
        this.isChecked = Boolean.valueOf(isChecked);
    }

    public int getTypeValidator() {
        return this.typeValidator;
    }

    public void setTypeValidator(int typeValidator) {
        this.typeValidator = typeValidator;
    }

    public View getView() {
        return this.view;
    }

    public TextView getTextView() {
        return (TextView) this.view;
    }

    public ImageView getImageView() {
        return (ImageView) this.view;
    }

    public void setView(TextView view) {
        this.view = view;
    }

    public TextView getRepeatView() {
        return this.repeatView;
    }

    public void setRepeatView(TextView repeatView) {
        this.repeatView = repeatView;
    }

    public boolean isActivated() {
        return this.isActivated;
    }

    public void setActivated(boolean activated) {
        this.isActivated = activated;
    }

    public boolean isChecked() {
        return this.isChecked.booleanValue();
    }

    public void setChecked(boolean checked) {
        this.isChecked = Boolean.valueOf(checked);
    }
}
