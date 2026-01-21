package jj2000.disp;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Scrollbar;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/* loaded from: classes5.dex */
public class ImgScrollPane extends Container {
    static final float BLOCK_INCREMENT_PROPORTION = 0.8f;
    static final int INTERNAL_GAP = 0;
    public static final float MAX_ZOOM = 32.0f;
    public static final int SCROLLBARS_ALWAYS = 1;
    public static final int SCROLLBARS_AS_NEEDED = 0;
    public static final int SCROLLBARS_NEVER = 2;
    static final int SCROLLBAR_THICKNESS = 16;
    private boolean copyScroll;
    ISPScrollbar hsbar;
    private ImageScrollDisplay imgDisplay;
    private Dimension lastSize;
    private float lastZoom;
    private int sbType;
    ISPScrollbar vsbar;
    private float zoom;

    public ImgScrollPane() {
        this(0);
    }

    public ImgScrollPane(int i) {
        this.zoom = 1.0f;
        this.copyScroll = true;
        super.setLayout(new BorderLayout(0, 0));
        this.sbType = i;
        this.hsbar = new ISPScrollbar(0, 0, 1, 0, 1);
        this.vsbar = new ISPScrollbar(1, 0, 1, 0, 1);
        this.imgDisplay = new ImageScrollDisplay();
        super.add(this.hsbar, "South");
        super.add(this.vsbar, "East");
        super.add(this.imgDisplay, "Center");
        if (i != 0) {
            if (i == 1) {
                this.hsbar.setVisible(true);
                this.vsbar.setVisible(true);
                return;
            } else if (i != 2) {
                throw new IllegalArgumentException();
            }
        }
        this.hsbar.setVisible(false);
        this.vsbar.setVisible(false);
    }

    public void setImage(Image image) {
        this.imgDisplay.setImage(image);
    }

    public synchronized Image getImage() {
        return this.imgDisplay.img;
    }

    public synchronized void setZoom(float f) {
        float f2 = this.zoom;
        if (f != f2 && (f <= 32.0f || f2 != 32.0f)) {
            this.zoom = f;
            if (f > 32.0f) {
                this.zoom = 32.0f;
            }
            setScrollbars();
            if (this.sbType == 0) {
                doLayout();
            }
            this.imgDisplay.erase = true;
            this.imgDisplay.repaint();
        }
    }

    public synchronized void zoom(float f) {
        setZoom(this.zoom * f);
    }

    public synchronized float getZoom() {
        return this.zoom;
    }

    public Adjustable getHAdjustable() {
        return this.hsbar;
    }

    public Adjustable getVAdjustable() {
        return this.vsbar;
    }

    public int getScrollbarDisplayPolicy() {
        return this.sbType;
    }

    public void setScrollbarDisplayPolicy(int i) {
        int i2 = this.sbType;
        if (i == i2) {
            return;
        }
        if (i2 == 0) {
            this.hsbar.setVisible(false);
            this.vsbar.setVisible(false);
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalArgumentException();
            }
            this.hsbar.setVisible(false);
            this.vsbar.setVisible(false);
        } else {
            this.hsbar.setVisible(true);
            this.vsbar.setVisible(true);
        }
        doLayout();
    }

    public synchronized void setScrollPosition(int i, int i2) {
        this.hsbar.setValueI(i);
        this.vsbar.setValueI(i2);
        int value = this.hsbar.getValue();
        int value2 = this.vsbar.getValue();
        if (this.imgDisplay.lastUpdateOffset != null && this.imgDisplay.lastUpdateOffset.x == value && this.imgDisplay.lastUpdateOffset.y == value2) {
            return;
        }
        this.imgDisplay.repaint();
    }

    public synchronized void setScrollPosition(Point point) {
        setScrollPosition(point.x, point.y);
    }

    public Point getScrollPosition() {
        return new Point(this.hsbar.getValue(), this.vsbar.getValue());
    }

    public Dimension getViewportSize() {
        return this.imgDisplay.getSize();
    }

    public synchronized void setCopyScroll(boolean z) {
        this.copyScroll = z;
    }

    public synchronized boolean getCopyScroll() {
        return this.copyScroll;
    }

    public synchronized void doLayout() {
        if (this.sbType == 0 && this.imgDisplay.calcDim()) {
            Dimension size = getSize();
            Dimension preferredSize = this.imgDisplay.getPreferredSize();
            if (size.width >= preferredSize.width) {
                if (size.height >= preferredSize.height) {
                    this.hsbar.setVisible(false);
                    this.vsbar.setVisible(false);
                } else {
                    this.vsbar.setVisible(true);
                    if (size.width >= preferredSize.width + 16) {
                        this.hsbar.setVisible(false);
                    } else {
                        this.hsbar.setVisible(true);
                    }
                }
            } else {
                this.hsbar.setVisible(true);
                if (size.height >= preferredSize.height + 16) {
                    this.vsbar.setVisible(false);
                } else {
                    this.vsbar.setVisible(true);
                }
            }
        }
        this.imgDisplay.erase = true;
        super.doLayout();
        if (this.hsbar.isVisible() && this.vsbar.isVisible()) {
            Rectangle bounds = this.hsbar.getBounds();
            if (bounds.width > 16) {
                bounds.width -= 16;
            }
            this.hsbar.setBounds(bounds);
        }
        setScrollbars();
    }

    public synchronized void addFocusListener(FocusListener focusListener) {
        super.addFocusListener(focusListener);
        this.imgDisplay.addFocusListener(focusListener);
        this.hsbar.addFocusListener(focusListener);
        this.vsbar.addFocusListener(focusListener);
    }

    public synchronized void removeFocusListener(FocusListener focusListener) {
        super.removeFocusListener(focusListener);
        this.imgDisplay.removeFocusListener(focusListener);
        this.hsbar.removeFocusListener(focusListener);
        this.vsbar.removeFocusListener(focusListener);
    }

    public synchronized void addKeyListener(KeyListener keyListener) {
        super.addKeyListener(keyListener);
        this.imgDisplay.addKeyListener(keyListener);
        this.hsbar.addKeyListener(keyListener);
        this.vsbar.addKeyListener(keyListener);
    }

    public synchronized void removeKeyListener(KeyListener keyListener) {
        super.removeKeyListener(keyListener);
        this.imgDisplay.removeKeyListener(keyListener);
        this.hsbar.removeKeyListener(keyListener);
        this.vsbar.removeKeyListener(keyListener);
    }

    public synchronized void addMouseListener(MouseListener mouseListener) {
        super.addMouseListener(mouseListener);
        this.imgDisplay.addMouseListener(mouseListener);
    }

    public synchronized void removeMouseListener(MouseListener mouseListener) {
        super.removeMouseListener(mouseListener);
        this.imgDisplay.removeMouseListener(mouseListener);
    }

    public synchronized void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        super.addMouseMotionListener(mouseMotionListener);
        this.imgDisplay.addMouseMotionListener(mouseMotionListener);
    }

    public synchronized void removeMouseMotionListener(MouseMotionListener mouseMotionListener) {
        super.removeMouseMotionListener(mouseMotionListener);
        this.imgDisplay.removeMouseMotionListener(mouseMotionListener);
    }

    public synchronized void setBackground(Color color) {
        super.setBackground(color);
        this.imgDisplay.setBackground(color);
        this.hsbar.setBackground(color);
        this.vsbar.setBackground(color);
    }

    public synchronized void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.imgDisplay.setCursor(cursor);
    }

    public synchronized void setEnabled(boolean z) {
        super.setEnabled(z);
        this.imgDisplay.setEnabled(z);
        this.hsbar.setEnabled(z);
        this.vsbar.setEnabled(z);
    }

    public synchronized void setForeground(Color color) {
        super.setForeground(color);
        this.imgDisplay.setForeground(color);
        this.hsbar.setForeground(color);
        this.vsbar.setForeground(color);
    }

    public Component add(Component component) {
        throw new IllegalArgumentException();
    }

    public Component add(String str, Component component) {
        throw new IllegalArgumentException();
    }

    public Component add(Component component, int i) {
        throw new IllegalArgumentException();
    }

    public void add(Component component, Object obj) {
        throw new IllegalArgumentException();
    }

    public void add(Component component, Object obj, int i) {
        throw new IllegalArgumentException();
    }

    public void remove(int i) {
        throw new IllegalArgumentException();
    }

    public void remove(Component component) {
        throw new IllegalArgumentException();
    }

    public void removeAll() {
        throw new IllegalArgumentException();
    }

    public void setLayout(LayoutManager layoutManager) {
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollbars() {
        if (this.imgDisplay.calcDim()) {
            Dimension size = this.imgDisplay.getSize();
            Dimension preferredSize = this.imgDisplay.getPreferredSize();
            if (this.lastZoom == 0.0f) {
                this.lastZoom = this.zoom;
            }
            if (this.lastSize == null) {
                this.lastSize = new Dimension(size.width, size.height);
            }
            int i = size.width < preferredSize.width ? size.width : preferredSize.width;
            int i2 = size.height < preferredSize.height ? size.height : preferredSize.height;
            int value = (int) ((((this.hsbar.getValue() + (this.lastSize.width / 2.0f)) / this.lastZoom) * this.zoom) - (i / 2.0f));
            if (value > preferredSize.width - size.width) {
                value = preferredSize.width - size.width;
            }
            if (value < 0) {
                value = 0;
            }
            if (size.width <= 0) {
                size.width = 1;
            }
            if (preferredSize.width <= 0) {
                preferredSize.width = 1;
            }
            this.hsbar.setValues(value, size.width, 0, preferredSize.width);
            size.width = (int) (size.width * BLOCK_INCREMENT_PROPORTION);
            if (size.width <= 0) {
                size.width = 1;
            }
            this.hsbar.setBlockIncrementI(size.width);
            int value2 = (int) ((((this.vsbar.getValue() + (this.lastSize.height / 2.0f)) / this.lastZoom) * this.zoom) - (i2 / 2.0f));
            if (value2 > preferredSize.height - size.height) {
                value2 = preferredSize.height - size.height;
            }
            if (value2 < 0) {
                value2 = 0;
            }
            if (size.height <= 0) {
                size.height = 1;
            }
            if (preferredSize.height <= 0) {
                preferredSize.height = 1;
            }
            this.vsbar.setValues(value2, size.height, 0, preferredSize.height);
            size.height = (int) (size.height * BLOCK_INCREMENT_PROPORTION);
            if (size.height <= 0) {
                size.height = 1;
            }
            this.vsbar.setBlockIncrementI(size.height);
            this.lastZoom = this.zoom;
            this.lastSize.width = i;
            this.lastSize.height = i2;
        }
    }

    private class ImageScrollDisplay extends Canvas {
        Dimension dim;
        int dimFlags;
        boolean erase;
        Image img;
        Dimension imgDim;
        Point lastUpdateOffset;

        private ImageScrollDisplay() {
            this.dim = new Dimension();
            this.imgDim = new Dimension();
        }

        void setImage(Image image) {
            synchronized (ImgScrollPane.this) {
                if (image == null) {
                    throw new IllegalArgumentException();
                }
                if (this.img == image) {
                    return;
                }
                this.dimFlags = 0;
                this.img = image;
                ImgScrollPane.this.lastSize = null;
                ImgScrollPane.this.lastZoom = 0.0f;
                ImgScrollPane.this.setScrollbars();
                this.erase = true;
                ImgScrollPane.this.prepareImage(image, this);
            }
        }

        public Dimension getMinimumSize() {
            return new Dimension(0, 0);
        }

        public Dimension getMaximumSize() {
            return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Dimension getPreferredSize() {
            return this.dim;
        }

        public boolean imageUpdate(Image image, int i, int i2, int i3, int i4, int i5) {
            if (this.img != image) {
                return false;
            }
            if ((i & 3) != 0) {
                synchronized (ImgScrollPane.this) {
                    if ((i & 1) != 0) {
                        try {
                            this.imgDim.width = i4;
                            this.dimFlags |= 1;
                        } finally {
                        }
                    }
                    if ((i & 2) != 0) {
                        this.imgDim.height = i5;
                        this.dimFlags |= 2;
                    }
                    if (this.dimFlags == 3) {
                        ImgScrollPane.this.doLayout();
                    }
                }
            }
            return super.imageUpdate(image, i, i2, i3, i4, i5);
        }

        public void paint(Graphics graphics) {
            update(graphics);
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0281  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0296  */
        /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x027b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void update(Graphics graphics) {
            int iCheckImage;
            int value;
            int value2;
            boolean z;
            int i;
            int i2;
            Image image;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int iCeil;
            int iCeil2;
            int i18;
            int i19;
            int i20;
            Image image2;
            int i21;
            int i22;
            int i23;
            int i24;
            int i25;
            int i26;
            int i27;
            int i28;
            int i29;
            int i30;
            int i31;
            int i32;
            synchronized (ImgScrollPane.this) {
                Image image3 = this.img;
                float f = ImgScrollPane.this.zoom;
                boolean z2 = this.erase;
                boolean z3 = ImgScrollPane.this.copyScroll;
                this.erase = false;
                if (image3 != null && (iCheckImage = checkImage(image3, null)) != 0) {
                    Rectangle bounds = getBounds();
                    int i33 = bounds.width > this.dim.width ? (bounds.width - this.dim.width) / 2 : 0;
                    int i34 = bounds.height > this.dim.height ? (bounds.height - this.dim.height) / 2 : 0;
                    Rectangle clipBounds = graphics.getClipBounds();
                    if (this.lastUpdateOffset != null && (clipBounds.width < bounds.width || clipBounds.height < bounds.height)) {
                        value = this.lastUpdateOffset.x;
                        value2 = this.lastUpdateOffset.y;
                    } else {
                        value = ImgScrollPane.this.hsbar.getValue();
                        value2 = ImgScrollPane.this.vsbar.getValue();
                    }
                    if (this.lastUpdateOffset == null) {
                        this.lastUpdateOffset = new Point();
                    }
                    int i35 = this.lastUpdateOffset.x;
                    int i36 = this.lastUpdateOffset.y;
                    boolean z4 = z2;
                    this.lastUpdateOffset.x = value;
                    this.lastUpdateOffset.y = value2;
                    if (f == 1.0f) {
                        z = z3;
                        i2 = iCheckImage;
                        image = image3;
                        i13 = i33 - value;
                        i15 = i34 - value2;
                        i12 = 0;
                        i14 = 0;
                        i16 = 0;
                        i = 0;
                        i10 = 0;
                        i11 = 0;
                        i8 = 0;
                        i9 = 0;
                    } else {
                        z = z3;
                        if (this.dimFlags != 3) {
                            return;
                        }
                        int i37 = this.imgDim.width;
                        int i38 = this.imgDim.height;
                        i = i37;
                        int i39 = this.dim.width;
                        int i40 = i38;
                        int i41 = this.dim.height;
                        i2 = iCheckImage;
                        if (i39 > bounds.width) {
                            int i42 = bounds.width;
                            if (f > 1.0f) {
                                image = image3;
                                iCeil2 = (int) Math.ceil(f);
                            } else {
                                image = image3;
                                iCeil2 = 0;
                            }
                            int iCeil3 = i42 + iCeil2;
                            if (((int) f) == f) {
                                iCeil3 = (int) (f * Math.ceil(iCeil3 / f));
                            }
                            float f2 = value;
                            i5 = (int) (f2 / f);
                            i3 = iCeil3;
                            i = ((int) (iCeil3 / f)) + i5;
                            i4 = (int) ((i5 * f) - f2);
                        } else {
                            image = image3;
                            i3 = i39;
                            i4 = 0;
                            i5 = 0;
                        }
                        if (i41 > bounds.height) {
                            int i43 = bounds.height;
                            if (f > 1.0f) {
                                i17 = i43;
                                iCeil = (int) Math.ceil(f);
                            } else {
                                i17 = i43;
                                iCeil = 0;
                            }
                            int iCeil4 = i17 + iCeil;
                            if (((int) f) == f) {
                                iCeil4 = (int) (f * Math.ceil(iCeil4 / f));
                            }
                            i41 = iCeil4;
                            float f3 = value2;
                            i6 = (int) (f3 / f);
                            i7 = (int) ((i6 * f) - f3);
                            i40 = ((int) (i41 / f)) + i6;
                        } else {
                            i6 = 0;
                            i7 = 0;
                        }
                        int i44 = i4 + i33;
                        int i45 = i7 + i34;
                        int i46 = i41 + i45;
                        i8 = i40;
                        i9 = i3 + i44;
                        i10 = i44;
                        i11 = i5;
                        i12 = i6;
                        i13 = i33;
                        i14 = i45;
                        i15 = i34;
                        i16 = i46;
                    }
                    int i47 = i2 & 32;
                    if (i47 == 0 && (i35 != value || i36 != value2)) {
                        z4 = true;
                    }
                    if (z4) {
                        i18 = i47;
                        graphics.setClip(0, 0, bounds.width, bounds.height);
                        graphics.setColor(getBackground());
                        graphics.fillRect(0, 0, bounds.width, bounds.height);
                    } else {
                        i18 = i47;
                    }
                    if (!z || z4 || ((i35 == value && i36 == value2) || i18 == 0)) {
                        int i48 = i13;
                        int i49 = i15;
                        int i50 = i14;
                        int i51 = i16;
                        int i52 = i;
                        int i53 = i10;
                        Image image4 = image;
                        int i54 = i11;
                        int i55 = i8;
                        int i56 = i9;
                        if (f == 1.0f) {
                            graphics.drawImage(image4, i48, i49, this);
                            return;
                        } else {
                            graphics.drawImage(image4, i53, i50, i56, i51, i54, i12, i52, i55, this);
                            return;
                        }
                    }
                    int i57 = clipBounds.x;
                    int i58 = clipBounds.y;
                    int i59 = clipBounds.width + clipBounds.x;
                    int i60 = clipBounds.height + clipBounds.y;
                    int i61 = i35 - value;
                    int i62 = i36 - value2;
                    int i63 = i13;
                    int i64 = bounds.width + i61;
                    int i65 = bounds.height + i62;
                    int i66 = i16;
                    int i67 = i57 > i61 ? i57 : i61;
                    int i68 = value;
                    int i69 = i58 > i62 ? i58 : i62;
                    if (i59 < i64) {
                        i64 = i59;
                    }
                    if (i60 < i65) {
                        i65 = i60;
                    }
                    if (i67 >= i64 || i69 >= i65) {
                        int i70 = i15;
                        int i71 = i14;
                        int i72 = i;
                        int i73 = i10;
                        Image image5 = image;
                        int i74 = i11;
                        int i75 = i8;
                        int i76 = i9;
                        if (f == 1.0f) {
                            graphics.drawImage(image5, i63, i70, this);
                            return;
                        } else {
                            graphics.drawImage(image5, i73, i71, i76, i66, i74, i12, i72, i75, this);
                            return;
                        }
                    }
                    int i77 = i15;
                    int i78 = i64 - i67;
                    int i79 = i69;
                    int i80 = i64;
                    graphics.copyArea((i67 + i68) - i35, (value2 + i69) - i36, i78, i65 - i69, i61, i62);
                    if (i57 < i67) {
                        graphics.setClip(i57, i58, i67 - i57, i60 - i58);
                        if (f == 1.0f) {
                            image2 = image;
                            graphics.drawImage(image2, i63, i77, this);
                            i19 = i78;
                            i20 = i66;
                            i27 = i59;
                            i21 = i11;
                            i23 = i9;
                            i29 = i80;
                            i24 = i65;
                            i25 = i;
                            i26 = i10;
                            i28 = i14;
                            i22 = i8;
                            if (i29 >= i27) {
                                int i81 = i23;
                                graphics.setClip(i29, i58, i27 - i29, i60 - i58);
                                if (f == 1.0f) {
                                    graphics.drawImage(image2, i63, i77, this);
                                    i31 = i79;
                                    i30 = i28;
                                    i23 = i81;
                                    if (i58 < i31) {
                                        graphics.setClip(i67, i58, i19, i31 - i58);
                                        if (f == 1.0f) {
                                            graphics.drawImage(image2, i63, i77, this);
                                        } else {
                                            graphics.drawImage(image2, i26, i30, i23, i20, i21, i12, i25, i22, this);
                                        }
                                    }
                                    i32 = i24;
                                    if (i32 < i60) {
                                        graphics.setClip(i67, i32, i19, i60 - i32);
                                        if (f == 1.0f) {
                                            graphics.drawImage(image2, i63, i77, this);
                                            return;
                                        } else {
                                            graphics.drawImage(image2, i26, i30, i23, i20, i21, i12, i25, i22, this);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                i30 = i28;
                                i23 = i81;
                                graphics.drawImage(image2, i26, i30, i23, i20, i21, i12, i25, i22, this);
                            } else {
                                i30 = i28;
                            }
                            i31 = i79;
                            if (i58 < i31) {
                            }
                            i32 = i24;
                            if (i32 < i60) {
                            }
                        } else {
                            i19 = i78;
                            int i82 = i14;
                            i20 = i66;
                            int i83 = i10;
                            image2 = image;
                            i21 = i11;
                            i22 = i8;
                            i23 = i9;
                            i24 = i65;
                            i25 = i;
                            graphics.drawImage(image2, i83, i82, i23, i20, i21, i12, i25, i22, this);
                            i26 = i83;
                            i28 = i82;
                            i27 = i59;
                        }
                    } else {
                        i19 = i78;
                        int i84 = i14;
                        i20 = i66;
                        image2 = image;
                        i21 = i11;
                        i22 = i8;
                        i23 = i9;
                        i24 = i65;
                        i25 = i;
                        i26 = i10;
                        i27 = i59;
                        i28 = i84;
                    }
                    i29 = i80;
                    if (i29 >= i27) {
                    }
                    i31 = i79;
                    if (i58 < i31) {
                    }
                    i32 = i24;
                    if (i32 < i60) {
                    }
                }
            }
        }

        boolean calcDim() {
            if (this.dimFlags != 3) {
                return false;
            }
            if (ImgScrollPane.this.zoom == 1.0f) {
                this.dim.width = this.imgDim.width;
                this.dim.height = this.imgDim.height;
                return true;
            }
            this.dim.width = (int) (ImgScrollPane.this.zoom * this.imgDim.width);
            this.dim.height = (int) (ImgScrollPane.this.zoom * this.imgDim.height);
            return true;
        }
    }

    class ISPScrollbar extends Scrollbar {
        ISPScrollbar(int i, int i2, int i3, int i4, int i5) {
            super(i, i2, i3, i4, i5);
        }

        public Dimension getPreferredSize() {
            Dimension preferredSize = super.getPreferredSize();
            if (getOrientation() == 0) {
                preferredSize.height = 16;
                return preferredSize;
            }
            preferredSize.width = 16;
            return preferredSize;
        }

        public void setMinimum(int i) {
            throw new IllegalArgumentException();
        }

        public void setMaximum(int i) {
            throw new IllegalArgumentException();
        }

        public void setVisibleAmount(int i) {
            throw new IllegalArgumentException();
        }

        public void setBlockIncrement(int i) {
            throw new IllegalArgumentException();
        }

        void setBlockIncrementI(int i) {
            super.setBlockIncrement(i);
        }

        void setValueI(int i) {
            super.setValue(i);
        }

        public void setValue(int i) {
            synchronized (ImgScrollPane.this) {
                super.setValue(i);
                int value = getValue();
                if (ImgScrollPane.this.imgDisplay.lastUpdateOffset != null) {
                    if (getOrientation() == 0) {
                        if (ImgScrollPane.this.imgDisplay.lastUpdateOffset.x == value) {
                            return;
                        }
                    } else if (ImgScrollPane.this.imgDisplay.lastUpdateOffset.y == value) {
                        return;
                    }
                }
                ImgScrollPane.this.imgDisplay.repaint();
            }
        }
    }
}
