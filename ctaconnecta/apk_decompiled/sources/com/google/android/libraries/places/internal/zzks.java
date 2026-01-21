package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class zzks {
    public abstract zzks zza(List list);

    public abstract zzks zzb(String str);

    public abstract zzks zzc(String str);

    public abstract zzks zzd(LocationBias locationBias);

    public abstract zzks zze(LocationRestriction locationRestriction);

    public abstract zzks zzf(AutocompleteActivityMode autocompleteActivityMode);

    public abstract zzks zzg(zzkr zzkrVar);

    public abstract zzks zzh(List list);

    public abstract zzks zzi(int i);

    public abstract zzks zzj(int i);

    public abstract zzks zzk(String str);

    @Deprecated
    public abstract zzks zzl(TypeFilter typeFilter);

    public abstract zzks zzm(List list);

    public abstract zzkt zzn();

    @Deprecated
    public final zzks zzo(String str) {
        return zza(str == null ? zznx.zzl() : zznx.zzm(str));
    }
}
