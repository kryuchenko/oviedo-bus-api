package com.palmatools.sdk.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* compiled from: ClsReaderMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/palmatools/sdk/model/ClsReaderMessage;", "", "ClsReaderMessageId", "", "(I)V", "getClsReaderMessageId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Deserializer", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClsReaderMessage {
    private final int ClsReaderMessageId;

    public static /* synthetic */ ClsReaderMessage copy$default(ClsReaderMessage clsReaderMessage, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = clsReaderMessage.ClsReaderMessageId;
        }
        return clsReaderMessage.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getClsReaderMessageId() {
        return this.ClsReaderMessageId;
    }

    public final ClsReaderMessage copy(int ClsReaderMessageId) {
        return new ClsReaderMessage(ClsReaderMessageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClsReaderMessage) && this.ClsReaderMessageId == ((ClsReaderMessage) other).ClsReaderMessageId;
    }

    public int hashCode() {
        return this.ClsReaderMessageId;
    }

    public String toString() {
        return "ClsReaderMessage(ClsReaderMessageId=" + this.ClsReaderMessageId + ")";
    }

    public ClsReaderMessage(int i) {
        this.ClsReaderMessageId = i;
    }

    public final int getClsReaderMessageId() {
        return this.ClsReaderMessageId;
    }

    /* compiled from: ClsReaderMessage.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/palmatools/sdk/model/ClsReaderMessage$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/palmatools/sdk/model/ClsReaderMessage;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Deserializer implements JsonDeserializer<ClsReaderMessage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public ClsReaderMessage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            JsonObject asJsonObject;
            JsonElement jsonElement;
            return new ClsReaderMessage((json == null || (asJsonObject = json.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("ClsReaderMessageId")) == null) ? -1 : jsonElement.getAsInt());
        }
    }
}
