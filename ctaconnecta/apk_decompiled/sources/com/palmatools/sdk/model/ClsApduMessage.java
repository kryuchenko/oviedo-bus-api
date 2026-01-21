package com.palmatools.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClsApduMessage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/palmatools/sdk/model/ClsApduMessage;", "", "apdu", "", "(Ljava/lang/String;)V", "getApdu", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClsApduMessage {
    private final String apdu;

    public static /* synthetic */ ClsApduMessage copy$default(ClsApduMessage clsApduMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clsApduMessage.apdu;
        }
        return clsApduMessage.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getApdu() {
        return this.apdu;
    }

    public final ClsApduMessage copy(String apdu) {
        Intrinsics.checkNotNullParameter(apdu, "apdu");
        return new ClsApduMessage(apdu);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClsApduMessage) && Intrinsics.areEqual(this.apdu, ((ClsApduMessage) other).apdu);
    }

    public int hashCode() {
        return this.apdu.hashCode();
    }

    public String toString() {
        return "ClsApduMessage(apdu=" + this.apdu + ")";
    }

    public ClsApduMessage(String apdu) {
        Intrinsics.checkNotNullParameter(apdu, "apdu");
        this.apdu = apdu;
    }

    public final String getApdu() {
        return this.apdu;
    }
}
