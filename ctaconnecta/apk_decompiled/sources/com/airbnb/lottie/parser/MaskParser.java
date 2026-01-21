package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

/* loaded from: classes.dex */
class MaskParser {
    private MaskParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String strNextName;
        char c;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue shapeData = null;
        AnimatableIntegerValue integer = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            strNextName = jsonReader.nextName();
            strNextName.hashCode();
            c = 2;
            switch (strNextName) {
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "pt":
                    shapeData = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString.hashCode()) {
                        case 97:
                            if (!strNextString.equals("a")) {
                                c = 65535;
                                break;
                            } else {
                                c = 0;
                                break;
                            }
                        case 105:
                            if (strNextString.equals("i")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 115:
                            if (!strNextString.equals("s")) {
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case 1:
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            Logger.warning("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, shapeData, integer, zNextBoolean);
    }
}
