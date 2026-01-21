package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes3.dex */
public final class zzgj {
    private final String zza;
    private final Bundle zzb;
    private Bundle zzc;
    private final /* synthetic */ zzgh zzd;

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0120 A[Catch: NumberFormatException | JSONException -> 0x0128, NumberFormatException | JSONException -> 0x0128, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0128, blocks: (B:9:0x0025, B:42:0x0091, B:42:0x0091, B:43:0x00a2, B:43:0x00a2, B:45:0x00a8, B:45:0x00a8, B:47:0x00b6, B:47:0x00b6, B:49:0x00c8, B:49:0x00c8, B:50:0x00d1, B:50:0x00d1, B:51:0x00d5, B:51:0x00d5, B:53:0x00db, B:53:0x00db, B:55:0x00e9, B:55:0x00e9, B:57:0x00fb, B:57:0x00fb, B:58:0x0104, B:58:0x0104, B:59:0x0108, B:59:0x0108, B:60:0x0114, B:60:0x0114, B:61:0x0120, B:61:0x0120, B:20:0x0052, B:23:0x005c, B:26:0x0066, B:29:0x0070, B:32:0x007a), top: B:75:0x0025, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zza() {
        char c;
        if (this.zzc == null) {
            String string = this.zzd.zzg().getString(this.zza, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode == 100) {
                                if (string3.equals("d")) {
                                    c = 1;
                                }
                                if (c == 0) {
                                }
                            } else if (iHashCode == 108) {
                                if (string3.equals("l")) {
                                    c = 2;
                                }
                                if (c == 0) {
                                }
                            } else if (iHashCode == 115) {
                                if (string3.equals("s")) {
                                    c = 0;
                                }
                                if (c == 0) {
                                }
                            } else if (iHashCode != 3352) {
                                c = (iHashCode == 3445 && string3.equals("la")) ? (char) 4 : (char) 65535;
                                if (c == 0) {
                                    bundle.putString(string2, jSONObject.getString("v"));
                                } else if (c == 1) {
                                    bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                                } else if (c == 2) {
                                    bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                } else if (c != 3) {
                                    if (c != 4) {
                                        this.zzd.zzj().zzg().zza("Unrecognized persisted bundle type. Type", string3);
                                    } else if (zzpg.zza() && this.zzd.zze().zza(zzbf.zzca)) {
                                        JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                        int length = jSONArray2.length();
                                        long[] jArr = new long[length];
                                        for (int i2 = 0; i2 < length; i2++) {
                                            jArr[i2] = jSONArray2.optLong(i2);
                                        }
                                        bundle.putLongArray(string2, jArr);
                                    }
                                } else if (zzpg.zza() && this.zzd.zze().zza(zzbf.zzca)) {
                                    JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                    int length2 = jSONArray3.length();
                                    int[] iArr = new int[length2];
                                    for (int i3 = 0; i3 < length2; i3++) {
                                        iArr[i3] = jSONArray3.optInt(i3);
                                    }
                                    bundle.putIntArray(string2, iArr);
                                }
                            } else {
                                if (string3.equals("ia")) {
                                    c = 3;
                                }
                                if (c == 0) {
                                }
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zzd.zzj().zzg().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzc = bundle;
                } catch (JSONException unused2) {
                    this.zzd.zzj().zzg().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzc == null) {
                this.zzc = this.zzb;
            }
        }
        return this.zzc;
    }

    private final String zzb(Bundle bundle) throws IllegalStateException, JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    if (zzpg.zza() && this.zzd.zze().zza(zzbf.zzca)) {
                        if (obj instanceof String) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    public zzgj(zzgh zzghVar, String str, Bundle bundle) {
        this.zzd = zzghVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.zzd.zzg().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.zza);
        } else {
            editorEdit.putString(this.zza, zzb(bundle));
        }
        editorEdit.apply();
        this.zzc = bundle;
    }
}
