package icc.types;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class ICCDateTime {
    public static final int size = 12;
    public short wDay;
    public short wHours;
    public short wMinutes;
    public short wMonth;
    public short wSeconds;
    public short wYear;

    public ICCDateTime(short s, short s2, short s3, short s4, short s5, short s6) {
        this.wYear = s;
        this.wMonth = s2;
        this.wDay = s3;
        this.wHours = s4;
        this.wMinutes = s5;
        this.wSeconds = s6;
    }

    public void write(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.writeShort(this.wYear);
        randomAccessFile.writeShort(this.wMonth);
        randomAccessFile.writeShort(this.wDay);
        randomAccessFile.writeShort(this.wHours);
        randomAccessFile.writeShort(this.wMinutes);
        randomAccessFile.writeShort(this.wSeconds);
    }

    public String toString() {
        return String.valueOf((int) this.wYear) + RemoteSettings.FORWARD_SLASH_STRING + String.valueOf((int) this.wMonth) + RemoteSettings.FORWARD_SLASH_STRING + String.valueOf((int) this.wDay) + " " + String.valueOf((int) this.wHours) + ":" + String.valueOf((int) this.wMinutes) + ":" + String.valueOf((int) this.wSeconds);
    }
}
