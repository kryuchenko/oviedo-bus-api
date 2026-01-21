package jj2000.j2k.util;

import java.util.Enumeration;
import java.util.Properties;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class ParameterList extends Properties {
    public ParameterList() {
    }

    public ParameterList(ParameterList parameterList) {
        super(parameterList);
    }

    public ParameterList getDefaultParameterList() {
        return (ParameterList) this.defaults;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0147 A[LOOP:1: B:22:0x006b->B:69:0x0147, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0155 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseArgs(String[] strArr) {
        int i = -1;
        do {
            i++;
            if (i >= strArr.length) {
                return;
            }
        } while (strArr[i].length() <= 0);
        int i2 = 0;
        char cCharAt = strArr[i].charAt(0);
        if (cCharAt != '-' && cCharAt != '+') {
            throw new StringFormatException("Argument list does not start with an option: " + strArr[i]);
        }
        if (strArr[i].length() >= 2 && Character.isDigit(strArr[i].charAt(1))) {
            throw new StringFormatException("Numeric option name: " + strArr[i]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < strArr.length) {
            if (strArr[i].length() <= 1) {
                throw new StringFormatException("Option \"" + strArr[i] + "\" is too short.");
            }
            char cCharAt2 = strArr[i].charAt(i2);
            int i3 = i + 1;
            String str = strArr[i];
            stringBuffer.setLength(i2);
            int length = strArr.length;
            String str2 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            if (i3 >= length) {
                if (cCharAt2 != '-') {
                    str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                stringBuffer.append(str2);
            } else {
                char cCharAt3 = strArr[i3].charAt(i2);
                if (cCharAt3 == '-' || cCharAt3 == '+') {
                    if (strArr[i3].length() <= 1) {
                        throw new StringFormatException("Option or argument \"" + strArr[i3] + "\" too short");
                    }
                    if (!Character.isDigit(strArr[i3].charAt(1))) {
                        if (cCharAt2 != '-') {
                            str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        }
                        stringBuffer.append(str2);
                    }
                }
                if (stringBuffer.length() == 0) {
                    if (cCharAt2 == '+') {
                        throw new StringFormatException("Boolean option \"" + str + "\" has a value");
                    }
                    i += 2;
                    stringBuffer.append(strArr[i3]);
                    while (i < strArr.length) {
                        if (strArr[i].length() == 0) {
                            i++;
                        } else {
                            char cCharAt4 = strArr[i].charAt(0);
                            if (cCharAt4 == '-' || cCharAt4 == '+') {
                                if (strArr[i].length() <= 1) {
                                    throw new StringFormatException("Option or argument \"" + strArr[i] + "\" too short");
                                }
                                if (!Character.isDigit(strArr[i].charAt(1))) {
                                    break;
                                }
                            }
                            stringBuffer.append(' ');
                            stringBuffer.append(strArr[i]);
                            i++;
                        }
                    }
                }
                if (get(str.substring(1)) == null) {
                    throw new StringFormatException("Option \"" + str + "\" appears more than once");
                }
                put(str.substring(1), stringBuffer.toString());
                i2 = 0;
            }
            i = i3;
            if (get(str.substring(1)) == null) {
            }
        }
    }

    public String getParameter(String str) {
        String str2 = (String) get(str);
        return (str2 != null || this.defaults == null) ? str2 : this.defaults.getProperty(str);
    }

    public boolean getBooleanParameter(String str) {
        String parameter = getParameter(str);
        if (parameter == null) {
            throw new IllegalArgumentException("No parameter with name " + str);
        }
        if (parameter.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            return true;
        }
        if (parameter.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            return false;
        }
        throw new StringFormatException("Parameter \"" + str + "\" is not boolean: " + parameter);
    }

    public int getIntParameter(String str) {
        String parameter = getParameter(str);
        if (parameter == null) {
            throw new IllegalArgumentException("No parameter with name " + str);
        }
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Parameter \"" + str + "\" is not integer: " + e.getMessage());
        }
    }

    public float getFloatParameter(String str) {
        String parameter = getParameter(str);
        if (parameter == null) {
            throw new IllegalArgumentException("No parameter with name " + str);
        }
        try {
            return new Float(parameter).floatValue();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Parameter \"" + str + "\" is not floating-point: " + e.getMessage());
        }
    }

    public void checkList(char c, String[] strArr) {
        Enumeration<?> enumerationPropertyNames = propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            if (str.length() > 0 && str.charAt(0) == c) {
                if (strArr != null) {
                    for (int length = strArr.length - 1; length >= 0; length--) {
                        if (str.equals(strArr[length])) {
                            break;
                        }
                    }
                }
                throw new IllegalArgumentException("Option '" + str + "' is not a valid one.");
            }
        }
    }

    public void checkList(char[] cArr, String[] strArr) {
        Enumeration<?> enumerationPropertyNames = propertyNames();
        String str = new String(cArr);
        while (enumerationPropertyNames.hasMoreElements()) {
            String str2 = (String) enumerationPropertyNames.nextElement();
            if (str2.length() > 0 && str.indexOf(str2.charAt(0)) == -1) {
                if (strArr != null) {
                    for (int length = strArr.length - 1; length >= 0; length--) {
                        if (str2.equals(strArr[length])) {
                            break;
                        }
                    }
                }
                throw new IllegalArgumentException("Option '" + str2 + "' is not a valid one.");
            }
        }
    }

    public static String[] toNameArray(String[][] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int length = strArr.length - 1; length >= 0; length--) {
            strArr2[length] = strArr[length][0];
        }
        return strArr2;
    }
}
