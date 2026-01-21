package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzaf;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzbb;
import com.google.android.gms.internal.drive.zzbr;
import com.google.android.gms.internal.drive.zzcb;
import com.google.android.gms.internal.drive.zzch;
import com.google.android.gms.internal.drive.zzeb;
import java.util.Set;

@Deprecated
/* loaded from: classes3.dex */
public final class Drive {

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zzaw> CLIENT_KEY;

    @Deprecated
    public static final DriveApi DriveApi;

    @Deprecated
    public static final DrivePreferencesApi DrivePreferencesApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    private static final Api.AbstractClientBuilder<zzaw, Api.ApiOptions.NoOptions> zzq;
    private static final Api.AbstractClientBuilder<zzaw, zzb> zzr;
    private static final Api.AbstractClientBuilder<zzaw, zza> zzs;
    private static final Scope zzt;
    private static final Scope zzu;
    private static final Api<zzb> zzv;
    public static final Api<zza> zzw;

    @Deprecated
    private static final zzj zzx;
    private static final zzl zzy;

    public static class zzb implements Api.ApiOptions.Optional {
    }

    private static void zza(GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        Set<Scope> requestedScopes = googleSignInAccount.getRequestedScopes();
        Preconditions.checkArgument(requestedScopes.contains(SCOPE_FILE) || requestedScopes.contains(SCOPE_APPFOLDER) || requestedScopes.contains(zzt) || requestedScopes.contains(zzu), "You must request a Drive scope in order to interact with the Drive API.");
    }

    public static class zza implements Api.ApiOptions.HasGoogleSignInAccountOptions {
        private final GoogleSignInAccount zzaa;
        private final Bundle zzz = new Bundle();

        public zza(GoogleSignInAccount googleSignInAccount) {
            this.zzaa = googleSignInAccount;
        }

        public final Bundle zzh() {
            return this.zzz;
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaa;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                zza zzaVar = (zza) obj;
                if (!Objects.equal(this.zzaa, zzaVar.getGoogleSignInAccount())) {
                    return false;
                }
                String string = this.zzz.getString("method_trace_filename");
                String string2 = zzaVar.zzz.getString("method_trace_filename");
                if (((string == null && string2 == null) || (string != null && string2 != null && string.equals(string2))) && this.zzz.getBoolean("bypass_initial_sync") == zzaVar.zzz.getBoolean("bypass_initial_sync") && this.zzz.getInt("proxy_type") == zzaVar.zzz.getInt("proxy_type")) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzaa, this.zzz.getString("method_trace_filename", ""), Integer.valueOf(this.zzz.getInt("proxy_type")), Boolean.valueOf(this.zzz.getBoolean("bypass_initial_sync")));
        }
    }

    @Deprecated
    public static DriveClient getDriveClient(Context context, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzbb(context, new zza(googleSignInAccount));
    }

    @Deprecated
    public static DriveClient getDriveClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzbb(activity, new zza(googleSignInAccount));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Context context, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzch(context, new zza(googleSignInAccount));
    }

    @Deprecated
    public static DriveResourceClient getDriveResourceClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        zza(googleSignInAccount);
        return new zzch(activity, new zza(googleSignInAccount));
    }

    private Drive() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.drive.zzj, com.google.android.gms.internal.drive.zzbr] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.drive.zzl, com.google.android.gms.internal.drive.zzeb] */
    static {
        Api.ClientKey<zzaw> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zze zzeVar = new zze();
        zzq = zzeVar;
        zzf zzfVar = new zzf();
        zzr = zzfVar;
        zzg zzgVar = new zzg();
        zzs = zzgVar;
        SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
        SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
        zzt = new Scope("https://www.googleapis.com/auth/drive");
        zzu = new Scope(Scopes.DRIVE_APPS);
        API = new Api<>("Drive.API", zzeVar, clientKey);
        zzv = new Api<>("Drive.INTERNAL_API", zzfVar, clientKey);
        zzw = new Api<>("Drive.API_CONNECTIONLESS", zzgVar, clientKey);
        DriveApi = new zzaf();
        zzx = new zzbr();
        zzy = new zzeb();
        DrivePreferencesApi = new zzcb();
    }
}
