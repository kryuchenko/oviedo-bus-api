package jj2000.disp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import jj2000.j2k.decoder.Decoder;

/* loaded from: classes5.dex */
public class ExitHandler extends WindowAdapter {
    private Decoder dec;

    public ExitHandler(Decoder decoder) {
        this.dec = decoder;
    }

    public void windowClosing(WindowEvent windowEvent) {
        this.dec.exit();
    }
}
