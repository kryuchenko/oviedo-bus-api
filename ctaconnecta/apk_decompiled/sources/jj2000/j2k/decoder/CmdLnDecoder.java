package jj2000.j2k.decoder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.util.StringFormatException;

/* loaded from: classes5.dex */
public class CmdLnDecoder {
    private Decoder dec;
    private ParameterList defpl = new ParameterList();
    private ParameterList pl;

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            FacilityManager.getMsgLogger().println("CmdLnDecoder: JJ2000's JPEG 2000 Decoder\n    use jj2000.j2k.decoder.CmdLnDecoder -u to get help\n", 0, 0);
            System.exit(1);
        }
        new CmdLnDecoder(strArr);
    }

    public CmdLnDecoder(String[] strArr) throws IOException {
        String[][] allParameters = Decoder.getAllParameters();
        for (int length = allParameters.length - 1; length >= 0; length--) {
            String[] strArr2 = allParameters[length];
            String str = strArr2[3];
            if (str != null) {
                this.defpl.put(strArr2[0], str);
            }
        }
        ParameterList parameterList = new ParameterList(this.defpl);
        this.pl = parameterList;
        if (strArr.length == 0) {
            throw new IllegalArgumentException("No arguments!");
        }
        try {
            parameterList.parseArgs(strArr);
            if (this.pl.getParameter("pfile") != null) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.pl.getParameter("pfile")));
                    this.pl.load(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                        System.out.println("[WARNING]: Could not close the argument file after reading");
                    }
                    try {
                        this.pl.parseArgs(strArr);
                    } catch (StringFormatException e) {
                        System.err.println("An error occurred while re-parsing the arguments:\n" + e.getMessage());
                        return;
                    }
                } catch (FileNotFoundException unused2) {
                    System.err.println("Could not load the argument file " + this.pl.getParameter("pfile"));
                    return;
                } catch (IOException unused3) {
                    System.err.println("An error occurred while reading from the argument file " + this.pl.getParameter("pfile"));
                    return;
                }
            }
            Decoder decoder = new Decoder(this.pl);
            this.dec = decoder;
            if (decoder.getExitCode() != 0) {
                System.exit(this.dec.getExitCode());
            }
            try {
                this.dec.run();
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    if (this.dec.getExitCode() == 0) {
                    }
                } finally {
                    if (this.dec.getExitCode() != 0) {
                        System.exit(this.dec.getExitCode());
                    }
                }
            }
        } catch (StringFormatException e2) {
            System.err.println("An error occurred while parsing the arguments:\n" + e2.getMessage());
        }
    }
}
