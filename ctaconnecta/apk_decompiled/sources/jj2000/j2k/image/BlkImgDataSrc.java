package jj2000.j2k.image;

/* loaded from: classes5.dex */
public interface BlkImgDataSrc extends ImgData {
    DataBlk getCompData(DataBlk dataBlk, int i);

    int getFixedPoint(int i);

    DataBlk getInternCompData(DataBlk dataBlk, int i);
}
