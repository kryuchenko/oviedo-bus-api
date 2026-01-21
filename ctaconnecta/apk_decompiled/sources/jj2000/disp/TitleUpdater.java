package jj2000.disp;

import java.awt.Frame;
import java.awt.Point;

/* loaded from: classes5.dex */
public class TitleUpdater implements Runnable {
    static final int UPDATE_T = 100;
    String btitle;
    public volatile boolean done = false;
    ImgScrollPane isp;
    Frame win;

    public TitleUpdater(ImgScrollPane imgScrollPane, Frame frame, String str) {
        this.isp = imgScrollPane;
        this.win = frame;
        this.btitle = str;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        Point scrollPosition = this.isp.getScrollPosition();
        float zoom = this.isp.getZoom();
        while (!this.done) {
            Point scrollPosition2 = this.isp.getScrollPosition();
            float zoom2 = this.isp.getZoom();
            if (zoom2 != zoom || !scrollPosition2.equals(scrollPosition)) {
                this.win.setTitle(this.btitle + " @ (" + ((int) (scrollPosition2.x / zoom2)) + "," + ((int) (scrollPosition2.y / zoom2)) + ") : " + this.isp.getZoom());
            }
            try {
                Thread.currentThread();
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            scrollPosition = scrollPosition2;
            zoom = zoom2;
        }
    }
}
