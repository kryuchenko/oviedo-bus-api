package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.net.InetAddress;

/* loaded from: classes3.dex */
class InetAddressDeserializer extends FromStringDeserializer<InetAddress> {
    public static final InetAddressDeserializer instance = new InetAddressDeserializer();
    private static final long serialVersionUID = 1;

    public InetAddressDeserializer() {
        super(InetAddress.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public InetAddress _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        return InetAddress.getByName(str);
    }
}
