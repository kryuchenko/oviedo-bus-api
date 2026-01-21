package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
class GradientStrokeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
    private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of("p", "k");
    private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");

    private GradientStrokeParser() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0026. Please report as an issue. */
    static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str;
        ArrayList arrayList = new ArrayList();
        GradientType gradientType = null;
        String strNextString = null;
        AnimatableGradientColorValue gradientColor = null;
        AnimatableIntegerValue integer = null;
        AnimatablePointValue point = null;
        AnimatablePointValue point2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        float fNextDouble = 0.0f;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            GradientType gradientType2 = gradientType;
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    strNextString = jsonReader.nextString();
                    gradientType = gradientType2;
                    break;
                case 1:
                    str = strNextString;
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        int iSelectName = jsonReader.selectName(GRADIENT_NAMES);
                        if (iSelectName == 0) {
                            iNextInt = jsonReader.nextInt();
                        } else if (iSelectName == 1) {
                            gradientColor = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, iNextInt);
                        } else {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    gradientType = gradientType2;
                    strNextString = str;
                    break;
                case 2:
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 3:
                    str = strNextString;
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    strNextString = str;
                    break;
                case 4:
                    point = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 5:
                    point2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 6:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 7:
                    str = strNextString;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    gradientType = gradientType2;
                    strNextString = str;
                    break;
                case 8:
                    str = strNextString;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    gradientType = gradientType2;
                    strNextString = str;
                    break;
                case 9:
                    str = strNextString;
                    fNextDouble = (float) jsonReader.nextDouble();
                    gradientType = gradientType2;
                    strNextString = str;
                    break;
                case 10:
                    zNextBoolean = jsonReader.nextBoolean();
                    gradientType = gradientType2;
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.hasNext()) {
                            int iSelectName2 = jsonReader.selectName(DASH_PATTERN_NAMES);
                            if (iSelectName2 != 0) {
                                String str2 = strNextString;
                                if (iSelectName2 == 1) {
                                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                } else {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                }
                                strNextString = str2;
                            } else {
                                strNextString2 = jsonReader.nextString();
                            }
                        }
                        String str3 = strNextString;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (strNextString2.equals("d") || strNextString2.equals("g")) {
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            strNextString = str3;
                        }
                        strNextString = str3;
                    }
                    str = strNextString;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    gradientType = gradientType2;
                    strNextString = str;
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    gradientType = gradientType2;
                    break;
            }
        }
        return new GradientStroke(strNextString, gradientType, gradientColor, integer, point, point2, animatableFloatValue, lineCapType, lineJoinType, fNextDouble, arrayList, animatableFloatValue2, zNextBoolean);
    }
}
