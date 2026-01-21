package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        double dNextDouble3 = 0.0d;
        double dNextDouble4 = 0.0d;
        int iNextInt = 0;
        int iJsonToColor = 0;
        int iJsonToColor2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    strNextString = jsonReader.nextString();
                    break;
                case 1:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 2:
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case 3:
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > DocumentData.Justification.CENTER.ordinal() || iNextInt2 < 0) {
                        justification2 = DocumentData.Justification.CENTER;
                        break;
                    } else {
                        justification2 = DocumentData.Justification.values()[iNextInt2];
                        break;
                    }
                    break;
                case 4:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 5:
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case 6:
                    dNextDouble3 = jsonReader.nextDouble();
                    break;
                case 7:
                    iJsonToColor = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    iJsonToColor2 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    dNextDouble4 = jsonReader.nextDouble();
                    break;
                case 10:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(strNextString, strNextString2, dNextDouble, justification2, iNextInt, dNextDouble2, dNextDouble3, iJsonToColor, iJsonToColor2, dNextDouble4, zNextBoolean);
    }
}
