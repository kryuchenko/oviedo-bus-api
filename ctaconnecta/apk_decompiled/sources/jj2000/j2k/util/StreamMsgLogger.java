package jj2000.j2k.util;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/* loaded from: classes5.dex */
public class StreamMsgLogger implements MsgLogger {
    private PrintWriter err;
    private MsgPrinter mp;
    private PrintWriter out;

    public StreamMsgLogger(OutputStream outputStream, OutputStream outputStream2, int i) {
        this.out = new PrintWriter(outputStream, true);
        this.err = new PrintWriter(outputStream2, true);
        this.mp = new MsgPrinter(i);
    }

    public StreamMsgLogger(Writer writer, Writer writer2, int i) {
        this.out = new PrintWriter(writer, true);
        this.err = new PrintWriter(writer2, true);
        this.mp = new MsgPrinter(i);
    }

    public StreamMsgLogger(PrintWriter printWriter, PrintWriter printWriter2, int i) {
        this.out = printWriter;
        this.err = printWriter2;
        this.mp = new MsgPrinter(i);
    }

    @Override // jj2000.j2k.util.MsgLogger
    public void printmsg(int i, String str) {
        PrintWriter printWriter;
        String str2;
        if (i == 0) {
            printWriter = this.out;
            str2 = "[LOG]: ";
        } else if (i == 1) {
            printWriter = this.out;
            str2 = "[INFO]: ";
        } else if (i == 2) {
            printWriter = this.err;
            str2 = "[WARNING]: ";
        } else if (i == 3) {
            printWriter = this.err;
            str2 = "[ERROR]: ";
        } else {
            throw new IllegalArgumentException("Severity " + i + " not valid.");
        }
        this.mp.print(printWriter, 0, str2.length(), str2 + str);
        printWriter.flush();
    }

    @Override // jj2000.j2k.util.MsgLogger
    public void println(String str, int i, int i2) {
        this.mp.print(this.out, i, i2, str);
    }

    @Override // jj2000.j2k.util.MsgLogger
    public void flush() {
        this.out.flush();
    }
}
