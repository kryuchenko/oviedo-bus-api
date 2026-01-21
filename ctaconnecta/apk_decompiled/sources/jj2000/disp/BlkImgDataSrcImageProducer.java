package jj2000.disp;

import androidx.core.view.ViewCompat;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.util.Vector;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.Coord;
import jj2000.j2k.image.DataBlkInt;

/* loaded from: classes5.dex */
public class BlkImgDataSrcImageProducer implements ImageProducer {
    private static final int GRAY = 0;
    private static final int RGB = 1;
    private static final int RGBA = 2;
    private static final ColorModel cm = ColorModel.getRGBdefault();
    private volatile Vector consumers;
    private BlkImgDataSrc src;
    private int type;

    public void requestTopDownLeftRightResend(ImageConsumer imageConsumer) {
    }

    public BlkImgDataSrcImageProducer(BlkImgDataSrc blkImgDataSrc) {
        int numComps = blkImgDataSrc.getNumComps();
        if (numComps == 1) {
            this.type = 0;
        } else if (numComps == 3) {
            this.type = 1;
        } else if (numComps == 4) {
            this.type = 2;
        } else {
            throw new IllegalArgumentException("Only 1, 3, and 4 components supported");
        }
        int compImgHeight = blkImgDataSrc.getCompImgHeight(0);
        int compImgWidth = blkImgDataSrc.getCompImgWidth(0);
        for (int numComps2 = blkImgDataSrc.getNumComps() - 1; numComps2 >= 0; numComps2--) {
            if (blkImgDataSrc.getCompImgHeight(numComps2) != compImgHeight || blkImgDataSrc.getCompImgWidth(numComps2) != compImgWidth) {
                throw new IllegalArgumentException("All components must have the same dimensions and no subsampling");
            }
            if (blkImgDataSrc.getNomRangeBits(numComps2) > 8) {
                throw new IllegalArgumentException("Depths greater than 8 bits per component is not supported");
            }
        }
        this.src = blkImgDataSrc;
        this.consumers = new Vector();
    }

    public static Image createImage(BlkImgDataSrc blkImgDataSrc) {
        return Toolkit.getDefaultToolkit().createImage(new BlkImgDataSrcImageProducer(blkImgDataSrc));
    }

    public static Image createImage(BlkImgDataSrc blkImgDataSrc, Component component) {
        return component.getToolkit().createImage(new BlkImgDataSrcImageProducer(blkImgDataSrc));
    }

    public final synchronized void addConsumer(ImageConsumer imageConsumer) {
        if (imageConsumer != null) {
            if (!this.consumers.contains(imageConsumer)) {
                this.consumers.addElement(imageConsumer);
            }
        }
    }

    public boolean isConsumer(ImageConsumer imageConsumer) {
        return this.consumers.contains(imageConsumer);
    }

    public synchronized void removeConsumer(ImageConsumer imageConsumer) {
        this.consumers.removeElement(imageConsumer);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x035f A[LOOP:5: B:132:0x035d->B:133:0x035f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startProduction(ImageConsumer imageConsumer) {
        int size;
        ImageConsumer[] imageConsumerArr;
        int fixedPoint;
        DataBlkInt dataBlkInt;
        int nomRangeBits;
        int nomRangeBits2;
        int nomRangeBits3;
        int nomRangeBits4;
        int fixedPoint2;
        DataBlkInt dataBlkInt2;
        int nomRangeBits5;
        int nomRangeBits6;
        int fixedPoint3;
        DataBlkInt dataBlkInt3;
        DataBlkInt dataBlkInt4;
        int i;
        boolean z;
        int i2;
        int i3;
        DataBlkInt dataBlkInt5;
        int i4;
        boolean z2;
        this.src.getNumTiles(null);
        if (imageConsumer != null) {
            addConsumer(imageConsumer);
        }
        synchronized (this) {
            size = this.consumers.size();
            imageConsumerArr = new ImageConsumer[size];
            this.consumers.copyInto(imageConsumerArr);
        }
        if (this.src == null) {
            for (int i5 = size - 1; i5 >= 0; i5--) {
                imageConsumerArr[i5].imageComplete(1);
            }
            return;
        }
        int i6 = this.type;
        if (i6 != 0) {
            if (i6 == 1) {
                dataBlkInt = null;
                nomRangeBits3 = 0;
                nomRangeBits4 = 0;
                fixedPoint2 = 0;
            } else if (i6 == 2) {
                dataBlkInt = new DataBlkInt();
                nomRangeBits3 = 1 << (this.src.getNomRangeBits(3) - 1);
                nomRangeBits4 = (1 << this.src.getNomRangeBits(3)) - 1;
                fixedPoint2 = this.src.getFixedPoint(3);
            } else {
                throw new Error("Internal JJ2000 error");
            }
            dataBlkInt2 = new DataBlkInt();
            nomRangeBits5 = 1 << (this.src.getNomRangeBits(2) - 1);
            nomRangeBits6 = (1 << this.src.getNomRangeBits(2)) - 1;
            fixedPoint3 = this.src.getFixedPoint(2);
            DataBlkInt dataBlkInt6 = new DataBlkInt();
            nomRangeBits = 1 << (this.src.getNomRangeBits(1) - 1);
            nomRangeBits2 = (1 << this.src.getNomRangeBits(1)) - 1;
            fixedPoint = this.src.getFixedPoint(1);
            dataBlkInt3 = dataBlkInt6;
        } else {
            fixedPoint = 0;
            dataBlkInt = null;
            nomRangeBits = 0;
            nomRangeBits2 = 0;
            nomRangeBits3 = 0;
            nomRangeBits4 = 0;
            fixedPoint2 = 0;
            dataBlkInt2 = null;
            nomRangeBits5 = 0;
            nomRangeBits6 = 0;
            fixedPoint3 = 0;
            dataBlkInt3 = null;
        }
        DataBlkInt dataBlkInt7 = new DataBlkInt();
        int nomRangeBits7 = 1 << (this.src.getNomRangeBits(0) - 1);
        int nomRangeBits8 = (1 << this.src.getNomRangeBits(0)) - 1;
        int i7 = fixedPoint;
        int fixedPoint4 = this.src.getFixedPoint(0);
        Coord numTiles = this.src.getNumTiles(null);
        int i8 = numTiles.x == 1 ? 30 : 25;
        int i9 = size - 1;
        int i10 = i9;
        while (i10 >= 0) {
            int i11 = i10;
            imageConsumerArr[i11].setColorModel(cm);
            imageConsumerArr[i11].setDimensions(this.src.getCompImgWidth(0), this.src.getCompImgHeight(0));
            imageConsumerArr[i11].setHints(i8);
            i10 = i11 - 1;
            nomRangeBits = nomRangeBits;
            nomRangeBits3 = nomRangeBits3;
            fixedPoint2 = fixedPoint2;
        }
        int i12 = nomRangeBits;
        int i13 = nomRangeBits3;
        int i14 = fixedPoint2;
        int[] iArr = null;
        int i15 = 0;
        int i16 = 0;
        while (i16 < numTiles.y) {
            int i17 = 0;
            while (i17 < numTiles.x) {
                this.src.setTile(i17, i16);
                int i18 = i17;
                int tileCompHeight = this.src.getTileCompHeight(i15, 0);
                Coord coord = numTiles;
                int tileCompWidth = this.src.getTileCompWidth(i15, 0);
                if (iArr == null || iArr.length < tileCompWidth) {
                    iArr = new int[tileCompWidth];
                }
                int[] iArr2 = iArr;
                int i19 = i15;
                int compULX = this.src.getCompULX(0) - ((int) Math.ceil(this.src.getImgULX() / this.src.getCompSubsX(0)));
                int compULY = this.src.getCompULY(0) - ((int) Math.ceil(this.src.getImgULY() / this.src.getCompSubsY(0)));
                int i20 = 0;
                while (i20 < tileCompHeight) {
                    int i21 = this.type;
                    int i22 = compULY;
                    if (i21 != 0) {
                        if (i21 == 1) {
                            z2 = false;
                        } else if (i21 == 2) {
                            dataBlkInt.ulx = 0;
                            dataBlkInt.uly = i20;
                            dataBlkInt.w = tileCompWidth;
                            dataBlkInt.h = 1;
                            this.src.getInternCompData(dataBlkInt, 3);
                            z2 = dataBlkInt.progressive;
                        } else {
                            i2 = i20;
                            dataBlkInt4 = dataBlkInt3;
                            i = i16;
                            i3 = this.type;
                            if (i3 != 0) {
                                dataBlkInt5 = dataBlkInt4;
                                int[] iArr3 = dataBlkInt7.data;
                                int i23 = (dataBlkInt7.offset + tileCompWidth) - 1;
                                int i24 = tileCompWidth - 1;
                                while (i24 >= 0) {
                                    int i25 = i23 - 1;
                                    int i26 = (iArr3[i23] >> fixedPoint4) + nomRangeBits7;
                                    if (i26 < 0) {
                                        i26 = 0;
                                    } else if (i26 > nomRangeBits8) {
                                        i26 = nomRangeBits8;
                                    }
                                    iArr2[i24] = (i26 << 16) | ViewCompat.MEASURED_STATE_MASK | (i26 << 8) | i26;
                                    i24--;
                                    i23 = i25;
                                }
                            } else if (i3 == 1) {
                                int[] iArr4 = dataBlkInt7.data;
                                int[] iArr5 = dataBlkInt4.data;
                                int[] iArr6 = dataBlkInt2.data;
                                int i27 = (dataBlkInt7.offset + tileCompWidth) - 1;
                                int i28 = (dataBlkInt4.offset + tileCompWidth) - 1;
                                dataBlkInt5 = dataBlkInt4;
                                int i29 = (dataBlkInt2.offset + tileCompWidth) - 1;
                                int i30 = tileCompWidth - 1;
                                int i31 = i28;
                                int i32 = i27;
                                while (i30 >= 0) {
                                    int i33 = i32 - 1;
                                    int i34 = (iArr4[i32] >> fixedPoint4) + nomRangeBits7;
                                    if (i34 < 0) {
                                        i34 = 0;
                                    } else if (i34 > nomRangeBits8) {
                                        i34 = nomRangeBits8;
                                    }
                                    int i35 = i31 - 1;
                                    int i36 = i29;
                                    int i37 = (iArr5[i31] >> i7) + i12;
                                    if (i37 < 0) {
                                        i37 = 0;
                                    } else if (i37 > nomRangeBits2) {
                                        i37 = nomRangeBits2;
                                    }
                                    int i38 = i36 - 1;
                                    int i39 = i37;
                                    int i40 = (iArr6[i36] >> fixedPoint3) + nomRangeBits5;
                                    if (i40 < 0) {
                                        i40 = 0;
                                    } else if (i40 > nomRangeBits6) {
                                        i40 = nomRangeBits6;
                                    }
                                    iArr2[i30] = i40 | (i34 << 16) | ViewCompat.MEASURED_STATE_MASK | (i39 << 8);
                                    i30--;
                                    i29 = i38;
                                    i32 = i33;
                                    i31 = i35;
                                }
                            } else if (i3 != 2) {
                                dataBlkInt5 = dataBlkInt4;
                            } else {
                                int[] iArr7 = dataBlkInt7.data;
                                int[] iArr8 = dataBlkInt4.data;
                                int[] iArr9 = dataBlkInt2.data;
                                int[] iArr10 = dataBlkInt.data;
                                int i41 = (dataBlkInt7.offset + tileCompWidth) - 1;
                                int i42 = (dataBlkInt4.offset + tileCompWidth) - 1;
                                int i43 = (dataBlkInt2.offset + tileCompWidth) - 1;
                                int i44 = tileCompWidth - 1;
                                int i45 = (dataBlkInt.offset + tileCompWidth) - 1;
                                int i46 = i41;
                                while (i44 >= 0) {
                                    int i47 = i46 - 1;
                                    int i48 = (iArr7[i46] >> fixedPoint4) + nomRangeBits7;
                                    if (i48 < 0) {
                                        i48 = 0;
                                    } else if (i48 > nomRangeBits8) {
                                        i48 = nomRangeBits8;
                                    }
                                    int i49 = i42 - 1;
                                    int i50 = i48;
                                    int i51 = (iArr8[i42] >> i7) + i12;
                                    if (i51 < 0) {
                                        i51 = 0;
                                    } else if (i51 > nomRangeBits2) {
                                        i51 = nomRangeBits2;
                                    }
                                    int i52 = i43 - 1;
                                    int i53 = i51;
                                    int i54 = (iArr9[i43] >> fixedPoint3) + nomRangeBits5;
                                    if (i54 < 0) {
                                        i54 = 0;
                                    } else if (i54 > nomRangeBits6) {
                                        i54 = nomRangeBits6;
                                    }
                                    int i55 = i45 - 1;
                                    int i56 = i54;
                                    int i57 = (iArr10[i45] >> i14) + i13;
                                    if (i57 < 0) {
                                        i57 = 0;
                                    } else if (i57 > nomRangeBits4) {
                                        i57 = nomRangeBits4;
                                    }
                                    iArr2[i44] = (i57 << 24) | (i50 << 16) | (i53 << 8) | i56;
                                    i44--;
                                    i45 = i55;
                                    i46 = i47;
                                    i43 = i52;
                                    i42 = i49;
                                }
                                dataBlkInt5 = dataBlkInt4;
                            }
                            for (i4 = i9; i4 >= 0; i4--) {
                                imageConsumerArr[i4].setPixels(compULX, i22 + i2, tileCompWidth, 1, cm, iArr2, 0, tileCompWidth);
                            }
                            i20 = i2 + 1;
                            i16 = i;
                            compULY = i22;
                            dataBlkInt3 = dataBlkInt5;
                        }
                        dataBlkInt2.ulx = 0;
                        boolean z3 = z2;
                        dataBlkInt4 = dataBlkInt3;
                        dataBlkInt4.ulx = 0;
                        dataBlkInt2.uly = i20;
                        dataBlkInt4.uly = i20;
                        dataBlkInt2.w = tileCompWidth;
                        dataBlkInt4.w = tileCompWidth;
                        dataBlkInt2.h = 1;
                        dataBlkInt4.h = 1;
                        i = i16;
                        this.src.getInternCompData(dataBlkInt2, 2);
                        boolean z4 = z3 || dataBlkInt2.progressive;
                        this.src.getInternCompData(dataBlkInt4, 1);
                        z = z4 || dataBlkInt4.progressive;
                    } else {
                        dataBlkInt4 = dataBlkInt3;
                        i = i16;
                        z = false;
                    }
                    dataBlkInt7.ulx = 0;
                    dataBlkInt7.uly = i20;
                    dataBlkInt7.w = tileCompWidth;
                    dataBlkInt7.h = 1;
                    i2 = i20;
                    this.src.getInternCompData(dataBlkInt7, 0);
                    if (z || dataBlkInt7.progressive) {
                        while (i9 >= 0) {
                            imageConsumerArr[i9].imageComplete(4);
                            i9--;
                        }
                        return;
                    }
                    i3 = this.type;
                    if (i3 != 0) {
                    }
                    while (i4 >= 0) {
                    }
                    i20 = i2 + 1;
                    i16 = i;
                    compULY = i22;
                    dataBlkInt3 = dataBlkInt5;
                }
                i17 = i18 + 1;
                i15 = i19 + 1;
                numTiles = coord;
                iArr = iArr2;
                dataBlkInt3 = dataBlkInt3;
            }
            i16++;
            dataBlkInt3 = dataBlkInt3;
        }
        for (int i58 = i9; i58 >= 0; i58--) {
            imageConsumerArr[i58].imageComplete(2);
        }
        for (int i59 = i9; i59 >= 0; i59--) {
            imageConsumerArr[i59].imageComplete(3);
        }
        synchronized (this) {
            while (i9 >= 0) {
                this.consumers.removeElement(imageConsumerArr[i9]);
                i9--;
            }
        }
    }
}
