package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@19.0.0 */
/* loaded from: classes3.dex */
public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    /* compiled from: com.google.android.gms:play-services-maps@@19.0.0 */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        return initialize(context, null, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:47|10|11|12|(8:14|(1:(0)(1:18))|43|20|(1:22)|23|27|(1:29))|19|43|20|(0)|23|27|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        android.util.Log.e(com.google.android.gms.maps.MapsInitializer.zza, "Failed to retrieve renderer type or log initialization.", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[Catch: RemoteException -> 0x005e, all -> 0x0090, TryCatch #1 {RemoteException -> 0x005e, blocks: (B:20:0x004c, B:22:0x0052, B:23:0x0056), top: B:43:0x004c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0022, B:9:0x0028, B:10:0x002c, B:12:0x003b, B:14:0x0040, B:20:0x004c, B:22:0x0052, B:23:0x0056, B:27:0x0066, B:29:0x007d, B:26:0x005f, B:33:0x0085, B:34:0x008a, B:36:0x008c), top: B:42:0x0003, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int initialize(Context context, Renderer renderer, OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        Preconditions.checkNotNull(context, "Context is null");
        Log.d(zza, "preferredRenderer: ".concat(String.valueOf(String.valueOf(renderer))));
        if (!zzb) {
            try {
                com.google.android.gms.maps.internal.zzf zzfVarZza = zzcc.zza(context, renderer);
                try {
                    CameraUpdateFactory.zza(zzfVarZza.zze());
                    BitmapDescriptorFactory.zza(zzfVarZza.zzj());
                    int i = 1;
                    zzb = true;
                    if (renderer != null) {
                        int iOrdinal = renderer.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal == 1) {
                                i = 2;
                            }
                        }
                        if (zzfVarZza.zzd() == 2) {
                            zzc = Renderer.LATEST;
                        }
                        zzfVarZza.zzl(ObjectWrapper.wrap(context), i);
                        Log.d(zza, "loadedRenderer: ".concat(String.valueOf(String.valueOf(zzc))));
                        if (onMapsSdkInitializedCallback != null) {
                            onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
                        }
                    }
                    i = 0;
                    if (zzfVarZza.zzd() == 2) {
                    }
                    zzfVarZza.zzl(ObjectWrapper.wrap(context), i);
                    Log.d(zza, "loadedRenderer: ".concat(String.valueOf(String.valueOf(zzc))));
                    if (onMapsSdkInitializedCallback != null) {
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (GooglePlayServicesNotAvailableException e2) {
                return e2.errorCode;
            }
        } else if (onMapsSdkInitializedCallback != null) {
            onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
        }
        return 0;
    }
}
