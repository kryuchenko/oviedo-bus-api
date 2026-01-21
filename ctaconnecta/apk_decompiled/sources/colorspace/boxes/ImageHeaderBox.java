package colorspace.boxes;

import androidx.core.os.EnvironmentCompat;
import colorspace.ColorSpaceException;
import icc.ICCProfile;
import java.io.IOException;
import jj2000.j2k.io.RandomAccessIO;

/* loaded from: classes.dex */
public final class ImageHeaderBox extends JP2Box {
    short bpc;
    short c;
    long height;
    boolean ipr;
    int nc;
    boolean unk;
    long width;

    static {
        type = 69686472;
    }

    public ImageHeaderBox(RandomAccessIO randomAccessIO, int i) throws ColorSpaceException, IOException {
        super(randomAccessIO, i);
        readBox();
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("[ImageHeaderBox ").append(eol).append("  height= ");
        stringBufferAppend.append(String.valueOf(this.height)).append(", width= ");
        stringBufferAppend.append(String.valueOf(this.width)).append(eol).append("  nc= ");
        stringBufferAppend.append(String.valueOf(this.nc)).append(", bpc= ");
        stringBufferAppend.append(String.valueOf((int) this.bpc)).append(", c= ");
        stringBufferAppend.append(String.valueOf((int) this.c)).append(eol).append("  image colorspace is ");
        stringBufferAppend.append(new String(this.unk ? "known" : EnvironmentCompat.MEDIA_UNKNOWN));
        stringBufferAppend.append(", the image ").append(new String(this.ipr ? "contains " : "does not contain ")).append("intellectual property]");
        return stringBufferAppend.toString();
    }

    void readBox() throws IOException {
        byte[] bArr = new byte[14];
        this.in.seek(this.dataStart);
        this.in.readFully(bArr, 0, 14);
        this.height = ICCProfile.getInt(bArr, 0);
        this.width = ICCProfile.getInt(bArr, 4);
        this.nc = ICCProfile.getShort(bArr, 8);
        this.bpc = (short) (bArr[10] & 255);
        this.c = (short) (bArr[11] & 255);
        this.unk = bArr[12] == 0;
        this.ipr = bArr[13] == 1;
    }
}
