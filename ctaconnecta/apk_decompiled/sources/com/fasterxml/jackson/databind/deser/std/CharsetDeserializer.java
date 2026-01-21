package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class CharsetDeserializer extends FromStringDeserializer<Charset> {
    private static final long serialVersionUID = 1;

    public CharsetDeserializer() {
        super(Charset.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public Charset _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        return Charset.forName(str);
    }
}
