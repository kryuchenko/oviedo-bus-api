package com.auth0.android.jwt;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class JWT implements Parcelable {
    public static final Parcelable.Creator<JWT> CREATOR = new Parcelable.Creator<JWT>() { // from class: com.auth0.android.jwt.JWT.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JWT createFromParcel(Parcel parcel) {
            return new JWT(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JWT[] newArray(int i) {
            return new JWT[i];
        }
    };
    private static final String ENCODING_UTF_8 = "UTF-8";
    private static final String TAG = "JWT";
    private Map<String, String> header;
    private JWTPayload payload;
    private String signature;
    private final String token;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JWT(String str) {
        decode(str);
        this.token = str;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getIssuer() {
        return this.payload.iss;
    }

    public String getSubject() {
        return this.payload.sub;
    }

    public List<String> getAudience() {
        return this.payload.aud;
    }

    public Date getExpiresAt() {
        return this.payload.exp;
    }

    public Date getNotBefore() {
        return this.payload.nbf;
    }

    public Date getIssuedAt() {
        return this.payload.iat;
    }

    public String getId() {
        return this.payload.jti;
    }

    public Claim getClaim(String str) {
        return this.payload.claimForName(str);
    }

    public Map<String, Claim> getClaims() {
        return this.payload.tree;
    }

    public boolean isExpired(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("The leeway must be a positive value.");
        }
        long jFloor = (long) (Math.floor(new Date().getTime() / 1000) * 1000.0d);
        long j2 = j * 1000;
        return ((this.payload.exp == null || !new Date(jFloor - j2).after(this.payload.exp)) && (this.payload.iat == null || !new Date(jFloor + j2).before(this.payload.iat))) ? false : true;
    }

    public String toString() {
        return this.token;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
    }

    private void decode(String str) {
        String[] strArrSplitToken = splitToken(str);
        this.header = (Map) parseJson(base64Decode(strArrSplitToken[0]), new TypeToken<Map<String, String>>() { // from class: com.auth0.android.jwt.JWT.2
        }.getType());
        this.payload = (JWTPayload) parseJson(base64Decode(strArrSplitToken[1]), JWTPayload.class);
        this.signature = strArrSplitToken[2];
    }

    private String[] splitToken(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 2 && str.endsWith(".")) {
            strArrSplit = new String[]{strArrSplit[0], strArrSplit[1], ""};
        }
        if (strArrSplit.length == 3) {
            return strArrSplit;
        }
        throw new DecodeException(String.format("The token was expected to have 3 parts, but got %s.", Integer.valueOf(strArrSplit.length)));
    }

    private String base64Decode(String str) {
        try {
            return new String(Base64.decode(str, 11), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new DecodeException("Device doesn't support UTF-8 charset encoding.", e);
        } catch (IllegalArgumentException e2) {
            throw new DecodeException("Received bytes didn't correspond to a valid Base64 encoded string.", e2);
        }
    }

    private <T> T parseJson(String str, Type type) {
        try {
            return (T) getGson().fromJson(str, type);
        } catch (Exception e) {
            throw new DecodeException("The token's payload had an invalid JSON format.", e);
        }
    }

    static Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(JWTPayload.class, new JWTDeserializer()).create();
    }
}
