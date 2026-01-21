package jj2000.j2k.encoder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.util.StringFormatException;

/* loaded from: classes5.dex */
public class CmdLnEncoder {
    private ParameterList defpl = new ParameterList();
    private Encoder enc;
    private ParameterList pl;

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            FacilityManager.getMsgLogger().println("CmdLnEncoder: JJ2000's JPEG 2000 Encoder\n    use jj2000.j2k.encoder.CmdLnEncoder -u to get help\n", 0, 0);
            System.exit(1);
        }
        new CmdLnEncoder(strArr);
    }

    public CmdLnEncoder(String[] strArr) throws IOException {
        String[][] allParameters = Encoder.getAllParameters();
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
                ParameterList parameterList2 = new ParameterList();
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.pl.getParameter("pfile")));
                    parameterList2.load(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                        System.out.println("[WARNING] Could not close the argument file after reading");
                    }
                    Enumeration enumerationKeys = parameterList2.keys();
                    while (enumerationKeys.hasMoreElements()) {
                        String str2 = (String) enumerationKeys.nextElement();
                        if (this.pl.get(str2) == null) {
                            this.pl.put(str2, parameterList2.get(str2));
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    System.err.println("Could not load the argument file " + this.pl.getParameter("pfile"));
                    return;
                } catch (IOException unused3) {
                    System.err.println("An error occurred while reading from the argument file " + this.pl.getParameter("pfile"));
                    return;
                }
            }
            try {
                this.pl.checkList(Encoder.vprfxs, ParameterList.toNameArray(allParameters));
                Encoder encoder = new Encoder(this.pl);
                this.enc = encoder;
                if (encoder.getExitCode() != 0) {
                    System.exit(this.enc.getExitCode());
                }
                try {
                    this.enc.run();
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        if (this.enc.getExitCode() == 0) {
                        }
                    } finally {
                        if (this.enc.getExitCode() != 0) {
                            System.exit(this.enc.getExitCode());
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } catch (StringFormatException e2) {
            System.err.println("An error occurred while parsing the arguments:\n" + e2.getMessage());
        }
    }
}
