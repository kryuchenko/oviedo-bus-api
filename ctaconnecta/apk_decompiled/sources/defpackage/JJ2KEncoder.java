package defpackage;

import jj2000.j2k.encoder.CmdLnEncoder;

/* loaded from: classes.dex */
public class JJ2KEncoder {
    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            System.err.println("JJ2KEncoder: JJ2000's JPEG 2000 Encoder\n");
            System.err.println("    use JJ2KEncoder -u to get help\n");
            System.exit(1);
        }
        CmdLnEncoder.main(strArr);
    }
}
