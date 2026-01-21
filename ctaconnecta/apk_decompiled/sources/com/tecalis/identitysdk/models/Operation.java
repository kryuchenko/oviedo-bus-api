package com.tecalis.identitysdk.models;

import androidx.core.app.NotificationCompat;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class Operation {
    private Customer customer;
    private String status;
    private String validation_comment;

    public Operation() {
    }

    public Operation(JSONObject jSONObject) {
        this.status = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
        this.validation_comment = jSONObject.optString("validation_comment");
        this.customer = new Customer((JSONObject) Objects.requireNonNull(jSONObject.optJSONObject("customer")));
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getValidation_comment() {
        return this.validation_comment;
    }

    public void setValidation_comment(String str) {
        this.validation_comment = str;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
