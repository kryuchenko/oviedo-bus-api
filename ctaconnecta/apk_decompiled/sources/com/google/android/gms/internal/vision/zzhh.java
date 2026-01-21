package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class zzhh extends IOException {
    private zzih zzxw;

    public zzhh(String str) {
        super(str);
        this.zzxw = null;
    }

    public final zzhh zzg(zzih zzihVar) {
        this.zzxw = zzihVar;
        return this;
    }

    static zzhh zzgn() {
        return new zzhh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzhh zzgo() {
        return new zzhh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzhh zzgp() {
        return new zzhh("CodedInputStream encountered a malformed varint.");
    }

    static zzhh zzgq() {
        return new zzhh("Protocol message contained an invalid tag (zero).");
    }

    static zzhh zzgr() {
        return new zzhh("Protocol message end-group tag did not match expected tag.");
    }

    static zzhg zzgs() {
        return new zzhg("Protocol message tag had invalid wire type.");
    }

    static zzhh zzgt() {
        return new zzhh("Failed to parse the message.");
    }

    static zzhh zzgu() {
        return new zzhh("Protocol message had invalid UTF-8.");
    }
}
