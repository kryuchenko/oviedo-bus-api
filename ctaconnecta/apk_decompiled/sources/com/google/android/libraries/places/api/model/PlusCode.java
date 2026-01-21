package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class PlusCode implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public abstract PlusCode build();

        public abstract String getCompoundCode();

        public abstract String getGlobalCode();

        public abstract Builder setCompoundCode(String str);

        public abstract Builder setGlobalCode(String str);
    }

    public static Builder builder() {
        return new zzz();
    }

    public abstract String getCompoundCode();

    public abstract String getGlobalCode();
}
