package com.palmatools.rtm.client;

/* loaded from: classes5.dex */
public class ClsApduMessage extends ClsReaderMessage {
    public String apdu;

    public String getApdu() {
        return this.apdu;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public ClsApduMessage(String str, Integer num) {
        this.ClsReaderMessageId = num;
        this.apdu = str;
    }

    public String toString() {
        return "ClsApduMessage{apdu='" + this.apdu + "', count=" + this.ClsReaderMessageId + "}";
    }
}
