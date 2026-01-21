package com.iecisa.ctausuario.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class TokenModel {

    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;

    @SerializedName("token")
    @Expose
    private String token;

    public TokenModel() {
    }

    public TokenModel(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
