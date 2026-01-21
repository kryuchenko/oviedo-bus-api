package com.tecalis.identitysdk.models;

import com.iecisa.ctausuario.utils.Constants;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AuthData {
    public String auth_uuid;
    public int expireAt;
    public String message;
    public String pst_frm_url;
    public String pwcs_url;
    public String sdr_frm_url;
    public String token_pwcs;

    public AuthData(JSONObject jSONObject) {
        this.auth_uuid = jSONObject.optString("auth_uuid");
        this.message = jSONObject.optString(Constants.Notification.DATA_MESSAGE);
        this.token_pwcs = jSONObject.optString("token_pwcs");
        this.expireAt = jSONObject.optInt("expireAt");
        this.pwcs_url = jSONObject.optString("pwcs_url");
        this.sdr_frm_url = jSONObject.optString("sdr_frm_url");
        this.pst_frm_url = jSONObject.optString("pst_frm_url");
    }
}
