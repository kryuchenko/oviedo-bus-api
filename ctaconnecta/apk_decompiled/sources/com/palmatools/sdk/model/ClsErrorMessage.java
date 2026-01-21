package com.palmatools.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClsErrorMessage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/palmatools/sdk/model/ClsErrorMessage;", "", "errorCode", "", "innerException", "", "text", "", "(ILjava/lang/Throwable;Ljava/lang/String;)V", "getErrorCode", "()I", "getInnerException", "()Ljava/lang/Throwable;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ClsErrorMessage {
    private final int errorCode;
    private final Throwable innerException;
    private final String text;

    public static /* synthetic */ ClsErrorMessage copy$default(ClsErrorMessage clsErrorMessage, int i, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = clsErrorMessage.errorCode;
        }
        if ((i2 & 2) != 0) {
            th = clsErrorMessage.innerException;
        }
        if ((i2 & 4) != 0) {
            str = clsErrorMessage.text;
        }
        return clsErrorMessage.copy(i, th, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component2, reason: from getter */
    public final Throwable getInnerException() {
        return this.innerException;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final ClsErrorMessage copy(int errorCode, Throwable innerException, String text) {
        return new ClsErrorMessage(errorCode, innerException, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClsErrorMessage)) {
            return false;
        }
        ClsErrorMessage clsErrorMessage = (ClsErrorMessage) other;
        return this.errorCode == clsErrorMessage.errorCode && Intrinsics.areEqual(this.innerException, clsErrorMessage.innerException) && Intrinsics.areEqual(this.text, clsErrorMessage.text);
    }

    public int hashCode() {
        int i = this.errorCode * 31;
        Throwable th = this.innerException;
        int iHashCode = (i + (th == null ? 0 : th.hashCode())) * 31;
        String str = this.text;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ClsErrorMessage(errorCode=" + this.errorCode + ", innerException=" + this.innerException + ", text=" + this.text + ")";
    }

    public ClsErrorMessage(int i, Throwable th, String str) {
        this.errorCode = i;
        this.innerException = th;
        this.text = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Throwable getInnerException() {
        return this.innerException;
    }

    public final String getText() {
        return this.text;
    }
}
