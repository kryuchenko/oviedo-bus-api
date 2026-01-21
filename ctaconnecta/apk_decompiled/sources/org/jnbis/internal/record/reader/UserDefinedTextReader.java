package org.jnbis.internal.record.reader;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.jnbis.internal.NistHelper;
import org.jnbis.record.UserDefinedDescriptiveText;

/* loaded from: classes6.dex */
public class UserDefinedTextReader extends RecordReader {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.jnbis.internal.record.reader.RecordReader
    public UserDefinedDescriptiveText read(NistHelper.Token token) {
        byte[] bArr;
        int i;
        if (token.pos >= token.buffer.length) {
            throw new IllegalArgumentException("T1::NULL pointer to T2 record");
        }
        UserDefinedDescriptiveText userDefinedDescriptiveText = new UserDefinedDescriptiveText();
        do {
            NistHelper.Tag tagInfo = getTagInfo(token);
            if (tagInfo.type != 2) {
                throw new RuntimeException("T2::Invalid Record type = " + tagInfo.type);
            }
            String strNextWord = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, true);
            int i2 = tagInfo.field;
            switch (i2) {
                case 1:
                    userDefinedDescriptiveText.setLogicalRecordLength(strNextWord);
                    break;
                case 2:
                    userDefinedDescriptiveText.setImageDesignationCharacter(strNextWord);
                    break;
                case 3:
                    userDefinedDescriptiveText.setField003(strNextWord);
                    break;
                case 4:
                    userDefinedDescriptiveText.setField004(strNextWord);
                    break;
                case 5:
                    userDefinedDescriptiveText.setField005(strNextWord);
                    break;
                case 6:
                    userDefinedDescriptiveText.setField006(strNextWord);
                    break;
                case 7:
                    userDefinedDescriptiveText.setField007(strNextWord);
                    break;
                case 8:
                    userDefinedDescriptiveText.setField008(strNextWord);
                    break;
                case 9:
                    userDefinedDescriptiveText.setField009(strNextWord);
                    break;
                case 10:
                    userDefinedDescriptiveText.setField010(strNextWord);
                    break;
                case 11:
                    userDefinedDescriptiveText.setField011(strNextWord);
                    break;
                case 12:
                    userDefinedDescriptiveText.setField012(strNextWord);
                    break;
                case 13:
                    userDefinedDescriptiveText.setField013(strNextWord);
                    break;
                case 14:
                    userDefinedDescriptiveText.setField014(strNextWord);
                    break;
                case 15:
                    userDefinedDescriptiveText.setField015(strNextWord);
                    break;
                case 16:
                    userDefinedDescriptiveText.setField016(strNextWord);
                    break;
                case 17:
                    userDefinedDescriptiveText.setField017(strNextWord);
                    break;
                case 18:
                    userDefinedDescriptiveText.setField018(strNextWord);
                    break;
                default:
                    switch (i2) {
                        case 20:
                            userDefinedDescriptiveText.setField020(strNextWord);
                            break;
                        case 21:
                            userDefinedDescriptiveText.setField021(strNextWord);
                            break;
                        case 22:
                            userDefinedDescriptiveText.setField022(strNextWord);
                            break;
                        case 23:
                            userDefinedDescriptiveText.setField023(strNextWord);
                            break;
                        case 24:
                            userDefinedDescriptiveText.setField024(strNextWord);
                            break;
                        case 25:
                            userDefinedDescriptiveText.setField025(strNextWord);
                            break;
                        case 26:
                            userDefinedDescriptiveText.setField026(strNextWord);
                            break;
                        case 27:
                            userDefinedDescriptiveText.setField027(strNextWord);
                            break;
                        case 28:
                            userDefinedDescriptiveText.setField028(strNextWord);
                            break;
                        case 29:
                            userDefinedDescriptiveText.setField029(strNextWord);
                            break;
                        case 30:
                            userDefinedDescriptiveText.setField030(strNextWord);
                            break;
                        case 31:
                            userDefinedDescriptiveText.setField031(strNextWord);
                            break;
                        case 32:
                            userDefinedDescriptiveText.setField032(strNextWord);
                            break;
                        case 33:
                            userDefinedDescriptiveText.setField033(strNextWord);
                            break;
                        case 34:
                            userDefinedDescriptiveText.setField034(strNextWord);
                            break;
                        case 35:
                            userDefinedDescriptiveText.setField035(strNextWord);
                            break;
                        case 36:
                            userDefinedDescriptiveText.setField036(strNextWord);
                            break;
                        case 37:
                            userDefinedDescriptiveText.setField037(strNextWord);
                            break;
                        case 38:
                            userDefinedDescriptiveText.setField038(strNextWord);
                            break;
                        case 39:
                            userDefinedDescriptiveText.setField039(strNextWord);
                            break;
                        case 40:
                            userDefinedDescriptiveText.setField040(strNextWord);
                            break;
                        case 41:
                            userDefinedDescriptiveText.setField041(strNextWord);
                            break;
                        case 42:
                            userDefinedDescriptiveText.setField042(strNextWord);
                            break;
                        case 43:
                            userDefinedDescriptiveText.setField043(strNextWord);
                            break;
                        case 44:
                            userDefinedDescriptiveText.setField044(strNextWord);
                            break;
                        case 45:
                            userDefinedDescriptiveText.setField045(strNextWord);
                            break;
                        case 46:
                            userDefinedDescriptiveText.setField046(strNextWord);
                            break;
                        case 47:
                            userDefinedDescriptiveText.setField047(strNextWord);
                            break;
                        case 48:
                            userDefinedDescriptiveText.setField048(strNextWord);
                            break;
                        case 49:
                            userDefinedDescriptiveText.setField049(strNextWord);
                            break;
                        case 50:
                            userDefinedDescriptiveText.setField050(strNextWord);
                            break;
                        case 51:
                            userDefinedDescriptiveText.setField051(strNextWord);
                            break;
                        case 52:
                            userDefinedDescriptiveText.setField052(strNextWord);
                            break;
                        case 53:
                            userDefinedDescriptiveText.setField053(strNextWord);
                            break;
                        case 54:
                            userDefinedDescriptiveText.setField054(strNextWord);
                            break;
                        case 55:
                            userDefinedDescriptiveText.setField055(strNextWord);
                            break;
                        case 56:
                            userDefinedDescriptiveText.setField056(strNextWord);
                            break;
                        case 57:
                            userDefinedDescriptiveText.setField057(strNextWord);
                            break;
                        case 58:
                            userDefinedDescriptiveText.setField058(strNextWord);
                            break;
                        case 59:
                            userDefinedDescriptiveText.setField059(strNextWord);
                            break;
                        case 60:
                            userDefinedDescriptiveText.setField060(strNextWord);
                            break;
                        case 61:
                            userDefinedDescriptiveText.setField061(strNextWord);
                            break;
                        case 62:
                            userDefinedDescriptiveText.setField062(strNextWord);
                            break;
                        case 63:
                            userDefinedDescriptiveText.setField063(strNextWord);
                            break;
                        case 64:
                            userDefinedDescriptiveText.setField064(strNextWord);
                            break;
                        case 65:
                            userDefinedDescriptiveText.setField065(strNextWord);
                            break;
                        case 66:
                            userDefinedDescriptiveText.setField066(strNextWord);
                            break;
                        case 67:
                            userDefinedDescriptiveText.setField067(strNextWord);
                            break;
                        case 68:
                            userDefinedDescriptiveText.setField068(strNextWord);
                            break;
                        case 69:
                            userDefinedDescriptiveText.setField069(strNextWord);
                            break;
                        case 70:
                            userDefinedDescriptiveText.setField070(strNextWord);
                            break;
                        case 71:
                            userDefinedDescriptiveText.setField071(strNextWord);
                            break;
                        case 72:
                            userDefinedDescriptiveText.setField072(strNextWord);
                            break;
                        case 73:
                            userDefinedDescriptiveText.setField073(strNextWord);
                            break;
                        case 74:
                            userDefinedDescriptiveText.setField074(strNextWord);
                            break;
                        case 75:
                            userDefinedDescriptiveText.setField075(strNextWord);
                            break;
                        case 76:
                            userDefinedDescriptiveText.setField076(strNextWord);
                            break;
                        case 77:
                            userDefinedDescriptiveText.setField077(strNextWord);
                            break;
                        case 78:
                            userDefinedDescriptiveText.setField078(strNextWord);
                            break;
                        case 79:
                            userDefinedDescriptiveText.setField079(strNextWord);
                            break;
                        case 80:
                            userDefinedDescriptiveText.setField080(strNextWord);
                            break;
                        case 81:
                            userDefinedDescriptiveText.setField081(strNextWord);
                            break;
                        case 82:
                            userDefinedDescriptiveText.setField082(strNextWord);
                            break;
                        case 83:
                            userDefinedDescriptiveText.setField083(strNextWord);
                            break;
                        case 84:
                            userDefinedDescriptiveText.setField084(strNextWord);
                            break;
                        case 85:
                            userDefinedDescriptiveText.setField085(strNextWord);
                            break;
                        case 86:
                            userDefinedDescriptiveText.setField086(strNextWord);
                            break;
                        case 87:
                            userDefinedDescriptiveText.setField087(strNextWord);
                            break;
                        case 88:
                            userDefinedDescriptiveText.setField088(strNextWord);
                            break;
                        case 89:
                            userDefinedDescriptiveText.setField089(strNextWord);
                            break;
                        case 90:
                            userDefinedDescriptiveText.setField090(strNextWord);
                            break;
                        case 91:
                            userDefinedDescriptiveText.setField091(strNextWord);
                            break;
                        case 92:
                            userDefinedDescriptiveText.setField092(strNextWord);
                            break;
                        case 93:
                            userDefinedDescriptiveText.setField093(strNextWord);
                            break;
                        case 94:
                            userDefinedDescriptiveText.setField094(strNextWord);
                            break;
                        case 95:
                            userDefinedDescriptiveText.setField095(strNextWord);
                            break;
                        case 96:
                            userDefinedDescriptiveText.setField096(strNextWord);
                            break;
                        case 97:
                            userDefinedDescriptiveText.setField097(strNextWord);
                            break;
                        case 98:
                            userDefinedDescriptiveText.setField098(strNextWord);
                            break;
                        case 99:
                            userDefinedDescriptiveText.setField099(strNextWord);
                            break;
                        case 100:
                            userDefinedDescriptiveText.setField100(strNextWord);
                            break;
                        default:
                            switch (i2) {
                                case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                                    userDefinedDescriptiveText.setField901(strNextWord);
                                    break;
                                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                                    userDefinedDescriptiveText.setField902(strNextWord);
                                    break;
                                case TypedValues.Custom.TYPE_STRING /* 903 */:
                                    userDefinedDescriptiveText.setField903(strNextWord);
                                    break;
                                case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                                    userDefinedDescriptiveText.setField904(strNextWord);
                                    break;
                                case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                                    userDefinedDescriptiveText.setField905(strNextWord);
                                    break;
                                case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                                    userDefinedDescriptiveText.setField906(strNextWord);
                                    break;
                                case 907:
                                    userDefinedDescriptiveText.setField907(strNextWord);
                                    break;
                                case 908:
                                    userDefinedDescriptiveText.setField908(strNextWord);
                                    break;
                                case 909:
                                    userDefinedDescriptiveText.setField909(strNextWord);
                                    break;
                                case 910:
                                    userDefinedDescriptiveText.setField910(strNextWord);
                                    break;
                                case 911:
                                    userDefinedDescriptiveText.setField911(strNextWord);
                                    break;
                                case 912:
                                    userDefinedDescriptiveText.setField912(strNextWord);
                                    break;
                                case 913:
                                    userDefinedDescriptiveText.setField913(strNextWord);
                                    break;
                                case 914:
                                    userDefinedDescriptiveText.setField914(strNextWord);
                                    break;
                                case 915:
                                    userDefinedDescriptiveText.setField915(strNextWord);
                                    break;
                                case 916:
                                    userDefinedDescriptiveText.setField916(strNextWord);
                                    break;
                                case 917:
                                    userDefinedDescriptiveText.setField917(strNextWord);
                                    break;
                                case 918:
                                    userDefinedDescriptiveText.setField918(strNextWord);
                                    break;
                                case 919:
                                    userDefinedDescriptiveText.setField919(strNextWord);
                                    break;
                                case 920:
                                    userDefinedDescriptiveText.setField920(strNextWord);
                                    break;
                                case 921:
                                    userDefinedDescriptiveText.setField921(strNextWord);
                                    break;
                                case 922:
                                    userDefinedDescriptiveText.setField922(strNextWord);
                                    break;
                                case 923:
                                    userDefinedDescriptiveText.setField923(strNextWord);
                                    break;
                                case 924:
                                    userDefinedDescriptiveText.setField924(strNextWord);
                                    break;
                                case 925:
                                    userDefinedDescriptiveText.setField925(strNextWord);
                                    break;
                                case 926:
                                    userDefinedDescriptiveText.setField926(strNextWord);
                                    break;
                                case 927:
                                    userDefinedDescriptiveText.setField927(strNextWord);
                                    break;
                                case 928:
                                    userDefinedDescriptiveText.setField928(strNextWord);
                                    break;
                                case 929:
                                    userDefinedDescriptiveText.setField929(strNextWord);
                                    break;
                                case 930:
                                    userDefinedDescriptiveText.setField930(strNextWord);
                                    break;
                                default:
                                    switch (i2) {
                                        case 941:
                                            userDefinedDescriptiveText.setField941(strNextWord);
                                            break;
                                        case 942:
                                            userDefinedDescriptiveText.setField942(strNextWord);
                                            break;
                                        case 943:
                                            userDefinedDescriptiveText.setField943(strNextWord);
                                            break;
                                        case 944:
                                            userDefinedDescriptiveText.setField944(strNextWord);
                                            break;
                                        case 945:
                                            userDefinedDescriptiveText.setField945(strNextWord);
                                            break;
                                        case 946:
                                            userDefinedDescriptiveText.setField946(strNextWord);
                                            break;
                                        case 947:
                                            userDefinedDescriptiveText.setField947(strNextWord);
                                            break;
                                        case 948:
                                            userDefinedDescriptiveText.setField948(strNextWord);
                                            break;
                                        case 949:
                                            userDefinedDescriptiveText.setField949(strNextWord);
                                            break;
                                        case 950:
                                            userDefinedDescriptiveText.setField950(strNextWord);
                                            break;
                                        case 951:
                                            userDefinedDescriptiveText.setField951(strNextWord);
                                            break;
                                        case 952:
                                            userDefinedDescriptiveText.setField952(strNextWord);
                                            break;
                                        case 953:
                                            userDefinedDescriptiveText.setField953(strNextWord);
                                            break;
                                        case 954:
                                            userDefinedDescriptiveText.setField954(strNextWord);
                                            break;
                                        case 955:
                                            userDefinedDescriptiveText.setField955(strNextWord);
                                            break;
                                        case 956:
                                            userDefinedDescriptiveText.setField956(strNextWord);
                                            break;
                                    }
                            }
                    }
            }
            bArr = token.buffer;
            i = token.pos;
            token.pos = i + 1;
        } while (bArr[i] != 28);
        return userDefinedDescriptiveText;
    }
}
