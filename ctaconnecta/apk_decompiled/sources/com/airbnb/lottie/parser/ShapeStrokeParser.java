package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ShapeStrokeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
    private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");

    private ShapeStrokeParser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [com.airbnb.lottie.model.animatable.AnimatableFloatValue] */
    /* JADX WARN: Type inference failed for: r15v4 */
    static ShapeStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ?? r15;
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableColorValue color = null;
        AnimatableIntegerValue integer = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        String str = null;
        float fNextDouble = 0.0f;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    strNextString = jsonReader.nextString();
                    break;
                case 1:
                    color = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 3:
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = str;
                        r15 = strNextString2;
                        while (jsonReader.hasNext()) {
                            int iSelectName = jsonReader.selectName(DASH_PATTERN_NAMES);
                            if (iSelectName == 0) {
                                strNextString2 = jsonReader.nextString();
                            } else if (iSelectName == 1) {
                                r15 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            } else {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            }
                            r15 = r15;
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(r15);
                                break;
                            case "o":
                                animatableFloatValue = r15;
                                break;
                        }
                        str = null;
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            str = null;
        }
        return new ShapeStroke(strNextString, animatableFloatValue, arrayList, color, integer, animatableFloatValue2, lineCapType, lineJoinType, fNextDouble, zNextBoolean);
    }
}
