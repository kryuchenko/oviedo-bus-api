package com.fasterxml.jackson.databind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class ISO8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone(GMT_ID);

    public static TimeZone timeZoneGMT() {
        return TIMEZONE_GMT;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_GMT);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_GMT);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    public static Date parse(String str) {
        String str2;
        int i;
        try {
            int i2 = parseInt(str, 0, 4);
            checkOffset(str, 4, '-');
            int i3 = parseInt(str, 5, 7);
            checkOffset(str, 7, '-');
            int i4 = parseInt(str, 8, 10);
            checkOffset(str, 10, 'T');
            int i5 = parseInt(str, 11, 13);
            checkOffset(str, 13, ':');
            int i6 = parseInt(str, 14, 16);
            checkOffset(str, 16, ':');
            int i7 = 19;
            int i8 = parseInt(str, 17, 19);
            if (str.charAt(19) == '.') {
                checkOffset(str, 19, '.');
                i7 = 23;
                i = parseInt(str, 20, 23);
            } else {
                i = 0;
            }
            char cCharAt = str.charAt(i7);
            String str3 = GMT_ID;
            if (cCharAt == '+' || cCharAt == '-') {
                str3 = GMT_ID + str.substring(i7);
            } else if (cCharAt != 'Z') {
                throw new IndexOutOfBoundsException("Invalid time zone indicator " + cCharAt);
            }
            TimeZone timeZone = TimeZone.getTimeZone(str3);
            if (!timeZone.getID().equals(str3)) {
                throw new IndexOutOfBoundsException();
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i2);
            gregorianCalendar.set(2, i3 - 1);
            gregorianCalendar.set(5, i4);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, i);
            return gregorianCalendar.getTime();
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + "'";
            }
            throw new IllegalArgumentException("Failed to parse date [" + str2 + "]: " + e.getMessage(), e);
        }
    }

    private static void checkOffset(String str, int i, char c) throws IndexOutOfBoundsException {
        char cCharAt = str.charAt(i);
        if (cCharAt == c) {
            return;
        }
        throw new IndexOutOfBoundsException("Expected '" + c + "' character but found '" + cCharAt + "'");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            int i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str);
            }
            i3 = -iDigit;
            i = i4;
        } else {
            i3 = 0;
        }
        while (i < i2) {
            int i5 = i + 1;
            int iDigit2 = Character.digit(str.charAt(i), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str);
            }
            i3 = (i3 * 10) - iDigit2;
            i = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }
}
