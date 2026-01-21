package com.iecisa.ctausuario.utils;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class DateUtils {
    public static final String CARD_DETAIL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATE_REPORT_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";
    public static final String DATE_TIME_SECONDS_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String HOUR_AND_MINUTE_FORMAT = "HH:mm";
    public static final String TEXT_DATE_FORMAT = "HH:mm, dd MMM yyyy";
    public static final String ZULU_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static String formatDate(String date, String inputDateFormat, String outputDateFormat) {
        if (date != null) {
            try {
                return new SimpleDateFormat(outputDateFormat).format(new SimpleDateFormat(inputDateFormat).parse(date));
            } catch (ParseException e) {
                Timber.e(e, "Error formateando fecha [date=" + date + " | inputDateFormat=" + inputDateFormat + " | outputDateFormat=" + outputDateFormat + "]", new Object[0]);
                return "";
            }
        }
        return "";
    }

    public static String getDate(String date) {
        return formatDate(date, CARD_DETAIL_DATE_FORMAT, DATE_FORMAT);
    }

    public static String getDateTime(String date) {
        return formatDate(date, CARD_DETAIL_DATE_FORMAT, DATE_TIME_FORMAT);
    }

    public static String getTime(String date) {
        return formatDate(date, CARD_DETAIL_DATE_FORMAT, HOUR_AND_MINUTE_FORMAT);
    }

    public static Object getDateReport(String date) {
        return formatDate(date, DATE_FORMAT, DATE_REPORT_FORMAT);
    }

    public static String getDateTimeReports(String date) {
        return formatDate(date, DATE_FORMAT, CARD_DETAIL_DATE_FORMAT);
    }

    public static String getDateTimeReportsEnd(String date) {
        return formatDate(date + " 23:59:59", DATE_TIME_SECONDS_FORMAT, CARD_DETAIL_DATE_FORMAT);
    }

    public static String dateToString(Date date) {
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
    }

    public static String dateToZuluString() {
        return new SimpleDateFormat(ZULU_DATE_FORMAT, Locale.getDefault()).format(Calendar.getInstance().getTime());
    }

    public static boolean beforeNow(String dateString) throws ParseException {
        if (dateString != null) {
            try {
                Date date = new SimpleDateFormat(CARD_DETAIL_DATE_FORMAT).parse(dateString);
                if (date != null) {
                    return date.before(new Date());
                }
                return false;
            } catch (ParseException e) {
                Timber.e(e, "Error comporbando si la fecha [dateString=" + dateString + "] es anterior a la actual", new Object[0]);
            }
        }
        return false;
    }

    public static boolean afterNow(String dateString) throws ParseException {
        if (dateString != null) {
            try {
                Date date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
                if (date != null) {
                    return date.after(new Date());
                }
                return false;
            } catch (ParseException unused) {
                Timber.e("Error comporbando si la fecha [dateString=" + dateString + "] es posterior a la actual", new Object[0]);
            }
        }
        return false;
    }

    public static boolean compareDates(String dateSinceString, String dateToString) throws ParseException {
        if (dateSinceString != null && dateToString != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                Date date = simpleDateFormat.parse(dateSinceString);
                Date date2 = simpleDateFormat.parse(dateToString);
                if (date == null || date2 == null) {
                    return false;
                }
                return date2.before(date);
            } catch (ParseException unused) {
                Timber.e("Error comporbando si la fecha [dateString=" + dateSinceString + "] es menor a lla fecha [dateString=" + dateToString, new Object[0]);
            }
        }
        return false;
    }

    public static int calculateAge(String birthDate) {
        Calendar calendar = Calendar.getInstance();
        if (!TextUtils.isEmpty(birthDate)) {
            String[] strArrSplit = birthDate.split(RemoteSettings.FORWARD_SLASH_STRING);
            calendar.set(Integer.valueOf(strArrSplit[2]).intValue(), Integer.valueOf(strArrSplit[1]).intValue() - 1, Integer.valueOf(strArrSplit[0]).intValue());
        }
        Calendar calendar2 = Calendar.getInstance();
        int i = calendar2.get(1) - calendar.get(1);
        return (calendar.get(2) > calendar2.get(2) || (calendar.get(2) == calendar2.get(2) && calendar.get(5) > calendar2.get(5))) ? i - 1 : i;
    }
}
