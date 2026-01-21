package jj2000.disp;

import java.awt.Adjustable;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import jj2000.j2k.decoder.Decoder;

/* loaded from: classes5.dex */
public class ImgKeyListener extends KeyAdapter {
    public static final int ACCEL_FACTOR = 10;
    Decoder dec;
    Frame helpFrame = null;
    ImgScrollPane isp;

    public ImgKeyListener(ImgScrollPane imgScrollPane, Decoder decoder) {
        this.isp = imgScrollPane;
        this.dec = decoder;
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.isConsumed()) {
            return;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 33) {
            Adjustable vAdjustable = this.isp.getVAdjustable();
            vAdjustable.setValue(vAdjustable.getValue() - vAdjustable.getBlockIncrement());
        } else if (keyCode == 34) {
            Adjustable vAdjustable2 = this.isp.getVAdjustable();
            vAdjustable2.setValue(vAdjustable2.getValue() + vAdjustable2.getBlockIncrement());
        } else if (keyCode != 67) {
            switch (keyCode) {
                case 37:
                    Adjustable hAdjustable = this.isp.getHAdjustable();
                    hAdjustable.setValue(hAdjustable.getValue() - calcIncrement(keyEvent, hAdjustable));
                    break;
                case 38:
                    Adjustable vAdjustable3 = this.isp.getVAdjustable();
                    vAdjustable3.setValue(vAdjustable3.getValue() - calcIncrement(keyEvent, vAdjustable3));
                    break;
                case 39:
                    Adjustable hAdjustable2 = this.isp.getHAdjustable();
                    hAdjustable2.setValue(hAdjustable2.getValue() + calcIncrement(keyEvent, hAdjustable2));
                    break;
                case 40:
                    Adjustable vAdjustable4 = this.isp.getVAdjustable();
                    vAdjustable4.setValue(vAdjustable4.getValue() + calcIncrement(keyEvent, vAdjustable4));
                    break;
                default:
                    return;
            }
        } else if (keyEvent.isControlDown()) {
            this.dec.exit();
        }
        keyEvent.consume();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.isConsumed()) {
            return;
        }
        char keyChar = keyEvent.getKeyChar();
        if (keyChar == '+') {
            this.isp.zoom(2.0f);
        } else if (keyChar == '-') {
            this.isp.zoom(0.5f);
        } else if (keyChar == '1') {
            this.isp.setZoom(1.0f);
        } else if (keyChar != '=') {
            if (keyChar != 'H') {
                if (keyChar != 'Q') {
                    if (keyChar != 'h') {
                        if (keyChar != 'q') {
                            return;
                        }
                    }
                    if (this.helpFrame == null) {
                    }
                    if (!this.helpFrame.isVisible()) {
                    }
                }
                this.dec.exit();
            } else {
                if (this.helpFrame == null) {
                    Frame frame = new Frame("Tools");
                    this.helpFrame = frame;
                    frame.add(getHelp());
                    this.helpFrame.pack();
                    this.helpFrame.setResizable(false);
                    this.helpFrame.addWindowListener(new WindowAdapter() { // from class: jj2000.disp.ImgKeyListener.1
                        public void windowClosing(WindowEvent windowEvent) {
                            ImgKeyListener.this.helpFrame.setVisible(false);
                        }
                    });
                }
                if (!this.helpFrame.isVisible()) {
                    this.helpFrame.setVisible(false);
                } else {
                    this.helpFrame.setVisible(true);
                }
            }
        }
        keyEvent.consume();
    }

    private int calcIncrement(KeyEvent keyEvent, Adjustable adjustable) {
        int unitIncrement;
        if (keyEvent.isControlDown()) {
            unitIncrement = adjustable.getBlockIncrement();
        } else {
            unitIncrement = adjustable.getUnitIncrement();
        }
        return keyEvent.isShiftDown() ? unitIncrement * 10 : unitIncrement;
    }

    private static TextArea getHelp() {
        TextArea textArea = new TextArea("", 17, 61, 3);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", 0, 10));
        textArea.append("The following key sequences are recognized in the \nimage display window:\n\n");
        textArea.append("'-'           : zoom out by a factor of 2.\n");
        textArea.append("'+' or '='    : zoom in by a factor of 2.\n");
        textArea.append("'1'           : set the zoom factor to 1 (i.e. no zoom).\n");
        textArea.append("<up arrow>    : scroll the image up by one pixel.\n");
        textArea.append("<down arrow>  : scroll the image down by one pixel.\n");
        textArea.append("<left arrow>  : scroll the image left by one pixel.\n");
        textArea.append("<right arrow> : scroll the image right by one pixel.\n");
        textArea.append("<page up>     : scroll the image up by a whole page.\n");
        textArea.append("<page down>   : scroll the image down by a whole page.\n");
        textArea.append("Ctrl+<arrow>  : scroll in the direction of the arrow a \n                page at a time instead of a pixel at a time.\n");
        textArea.append("Shift+<arrow> : accelerate the scroll speed by 10.\n");
        textArea.append("'Q' or 'q'    : exit the application.\n");
        textArea.append("'Ctrl-C'      : exit the application.\n");
        return textArea;
    }
}
