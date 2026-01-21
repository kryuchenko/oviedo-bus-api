package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public class InetSocketAddressDeserializer extends FromStringDeserializer<InetSocketAddress> {
    public static final InetSocketAddressDeserializer instance = new InetSocketAddressDeserializer();
    private static final long serialVersionUID = 1;

    public InetSocketAddressDeserializer() {
        super(InetSocketAddress.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public InetSocketAddress _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        if (str.startsWith("[")) {
            int iLastIndexOf = str.lastIndexOf(93);
            if (iLastIndexOf == -1) {
                throw new InvalidFormatException("Bracketed IPv6 address must contain closing bracket.", str, InetSocketAddress.class);
            }
            int iIndexOf = str.indexOf(58, iLastIndexOf);
            return new InetSocketAddress(str.substring(0, iLastIndexOf + 1), iIndexOf > -1 ? Integer.parseInt(str.substring(iIndexOf + 1)) : 0);
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 != -1 && str.indexOf(58, iIndexOf2 + 1) == -1) {
            return new InetSocketAddress(str.substring(0, iIndexOf2), Integer.parseInt(str.substring(iIndexOf2)));
        }
        return new InetSocketAddress(str, 0);
    }
}
