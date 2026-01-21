package org.jnbis;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/* loaded from: classes6.dex */
public class ImageUtils {
    public static final int[] MASKS = {255, 255, 255};

    public byte[] bitmap2jpeg(Bitmap bitmap) {
        return convert(bitmap, "jpeg");
    }

    public byte[] bitmap2gif(Bitmap bitmap) {
        return convert(bitmap, "gif");
    }

    public byte[] bitmap2png(Bitmap bitmap) {
        return convert(bitmap, "png");
    }

    private byte[] convert(Bitmap bitmap, String str) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        WritableRaster writableRasterCreatePackedRaster = Raster.createPackedRaster(new DataBufferByte(bitmap.getPixels(), bitmap.getLength()), width, height, width, MASKS, (Point) null);
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        bufferedImage.setData(writableRasterCreatePackedRaster);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ImageIO.write(bufferedImage, str, byteArrayOutputStream);
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
