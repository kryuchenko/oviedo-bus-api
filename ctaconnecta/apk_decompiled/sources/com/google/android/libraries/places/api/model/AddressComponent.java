package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznx;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class AddressComponent implements Parcelable {

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public AddressComponent build() {
            AddressComponent addressComponentZzc = zzc();
            zzmt.zzp(!addressComponentZzc.getName().isEmpty(), "Name must not be empty.");
            List<String> types = addressComponentZzc.getTypes();
            Iterator<String> it = types.iterator();
            while (it.hasNext()) {
                zzmt.zzp(!TextUtils.isEmpty(it.next()), "Types must not contain null or empty values.");
            }
            zzb(zznx.zzj(types));
            return zzc();
        }

        public abstract String getShortName();

        public abstract Builder setShortName(String str);

        abstract Builder zzb(List list);

        abstract AddressComponent zzc();
    }

    public static Builder builder(String str, List<String> list) {
        zza zzaVar = new zza();
        zzaVar.zza(str);
        zzaVar.zzb(list);
        return zzaVar;
    }

    public abstract String getName();

    public abstract String getShortName();

    public abstract List<String> getTypes();
}
