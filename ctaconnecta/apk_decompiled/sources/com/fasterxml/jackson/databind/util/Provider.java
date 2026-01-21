package com.fasterxml.jackson.databind.util;

import java.util.Collection;

@Deprecated
/* loaded from: classes3.dex */
public interface Provider<T> {
    Collection<T> provide();
}
