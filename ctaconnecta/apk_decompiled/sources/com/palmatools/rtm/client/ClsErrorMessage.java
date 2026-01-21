package com.palmatools.rtm.client;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes5.dex */
public class ClsErrorMessage extends ClsReaderMessage {
    public int errorCode;
    public Throwable innerException;
    public String text;

    public ClsErrorMessage(String str) {
        this.text = str;
    }

    public ClsErrorMessage(Throwable th) {
        this.innerException = th;
        this.text = th.getMessage();
    }

    public String toString() {
        String string;
        if (this.innerException == null) {
            string = "";
        } else {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            this.innerException.printStackTrace(printWriter);
            printWriter.flush();
            string = stringWriter.toString();
        }
        return this.errorCode + "\"" + this.text + "\"" + string;
    }
}
