package jj2000.disp;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/* loaded from: classes5.dex */
public class ImgMouseListener extends MouseAdapter implements MouseMotionListener {
    ImgScrollPane isp;
    Cursor prevCursor;
    int startMouseX;
    int startMouseY;
    int startScrollX;
    int startScrollY;

    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public ImgMouseListener(ImgScrollPane imgScrollPane) {
        this.isp = imgScrollPane;
    }

    public void mousePressed(MouseEvent mouseEvent) {
        this.startMouseX = mouseEvent.getX();
        this.startMouseY = mouseEvent.getY();
        this.startScrollX = this.isp.getHAdjustable().getValue();
        this.startScrollY = this.isp.getVAdjustable().getValue();
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        Cursor cursor = this.prevCursor;
        if (cursor != null) {
            this.isp.setCursor(cursor);
            this.prevCursor = null;
        }
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        if (this.prevCursor == null) {
            this.prevCursor = this.isp.getCursor();
            this.isp.setCursor(Cursor.getPredefinedCursor(13));
        }
        this.isp.setScrollPosition((this.startScrollX + this.startMouseX) - mouseEvent.getX(), (this.startScrollY + this.startMouseY) - mouseEvent.getY());
    }
}
