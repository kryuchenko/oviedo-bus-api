package com.palmatools.rtm.client;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public class ClsReaderMessageAdapter implements JsonDeserializer<ClsReaderMessage> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ClsReaderMessage deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Type type2;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (FieldExists("errorCode", asJsonObject).booleanValue()) {
            type2 = ClsErrorMessage.class;
        } else if (FieldExists("apdu", asJsonObject).booleanValue()) {
            type2 = ClsApduMessage.class;
        } else if (FieldExists("text", asJsonObject).booleanValue()) {
            type2 = ClsTextMessage.class;
        } else {
            type2 = ClsReaderMessage.class;
        }
        return (ClsReaderMessage) jsonDeserializationContext.deserialize(asJsonObject, type2);
    }

    private Boolean FieldExists(String str, JsonObject jsonObject) {
        return Boolean.valueOf(jsonObject.has(str));
    }
}
