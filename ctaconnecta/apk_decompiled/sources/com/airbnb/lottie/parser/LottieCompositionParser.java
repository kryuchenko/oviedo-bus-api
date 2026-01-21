package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class LottieCompositionParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0044. Please report as an issue. */
    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        float f;
        JsonReader jsonReader2 = jsonReader;
        float fDpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader2.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader2.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    iNextInt = jsonReader.nextInt();
                    jsonReader2 = jsonReader;
                    break;
                case 1:
                    iNextInt2 = jsonReader.nextInt();
                    jsonReader2 = jsonReader;
                    break;
                case 2:
                    f = fDpScale;
                    fNextDouble = (float) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
                case 3:
                    f = fDpScale;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
                case 4:
                    f = fDpScale;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
                case 5:
                    String[] strArrSplit = jsonReader2.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    f = fDpScale;
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
                case 6:
                    parseLayers(jsonReader2, lottieComposition, arrayList, longSparseArray);
                    f = fDpScale;
                    jsonReader.skipValue();
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
                default:
                    f = fDpScale;
                    jsonReader.skipValue();
                    jsonReader2 = jsonReader;
                    fDpScale = f;
                    break;
            }
        }
        float f2 = fDpScale;
        lottieComposition.init(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArrayCompat, map3, arrayList2);
        return lottieComposition;
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
            if (layer.getLayerType() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
            if (i > 4) {
                Logger.warning("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
