package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes4.dex */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
