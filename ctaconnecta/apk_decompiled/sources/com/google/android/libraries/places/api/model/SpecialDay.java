package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class SpecialDay implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public abstract SpecialDay build();

        public abstract LocalDate getDate();

        public abstract boolean isExceptional();

        public abstract Builder setDate(LocalDate localDate);

        public abstract Builder setExceptional(boolean z);
    }

    public static Builder builder(LocalDate localDate) {
        zzaf zzafVar = new zzaf();
        zzafVar.setDate(localDate);
        zzafVar.setExceptional(false);
        return zzafVar;
    }

    public abstract LocalDate getDate();

    public abstract boolean isExceptional();
}
