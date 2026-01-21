package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class AddressComponents implements Parcelable {
    public static AddressComponents newInstance(List<AddressComponent> list) {
        return new zzam(list);
    }

    public abstract List<AddressComponent> asList();
}
