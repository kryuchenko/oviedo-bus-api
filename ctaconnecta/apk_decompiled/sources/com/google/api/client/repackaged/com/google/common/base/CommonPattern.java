package com.google.api.client.repackaged.com.google.common.base;

/* loaded from: classes4.dex */
abstract class CommonPattern {
    public abstract boolean equals(Object obj);

    abstract int flags();

    public abstract int hashCode();

    abstract CommonMatcher matcher(CharSequence charSequence);

    abstract String pattern();

    public abstract String toString();

    CommonPattern() {
    }
}
