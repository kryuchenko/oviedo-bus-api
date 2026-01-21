package defpackage;

import jj2000.j2k.decoder.CmdLnDecoder;

/* loaded from: classes.dex */
public class JJ2KDecoder {
    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            System.err.println("JJ2KDecoder: JJ2000's JPEG 2000 Decoder\n");
            System.err.println("    use JJ2KDecoder -u to get help\n");
            System.exit(1);
        }
        CmdLnDecoder.main(strArr);
    }
}
