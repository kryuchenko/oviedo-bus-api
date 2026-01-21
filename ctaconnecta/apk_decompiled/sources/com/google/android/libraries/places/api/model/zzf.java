package com.google.android.libraries.places.api.model;

import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
abstract class zzf extends AuthorAttributions {
    private final List zza;

    zzf(List list) {
        if (list == null) {
            throw new NullPointerException("Null asList");
        }
        this.zza = list;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttributions
    public final List<AuthorAttribution> asList() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthorAttributions) {
            return this.zza.equals(((AuthorAttributions) obj).asList());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "AuthorAttributions{asList=" + this.zza.toString() + "}";
    }
}
