package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
