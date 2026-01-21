package com.google.android.libraries.places.api.net;

import android.net.Uri;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class FetchResolvedPhotoUriResponse {
    public static FetchResolvedPhotoUriResponse newInstance(Uri uri) {
        return new zzl(uri);
    }

    public abstract Uri getUri();
}
