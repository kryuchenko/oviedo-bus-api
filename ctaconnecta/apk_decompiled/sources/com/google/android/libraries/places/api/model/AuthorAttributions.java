package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zznx;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class AuthorAttributions implements Parcelable {
    public static AuthorAttributions newInstance(List<AuthorAttribution> list) {
        return new zzaq(zznx.zzj(list));
    }

    public abstract List<AuthorAttribution> asList();
}
