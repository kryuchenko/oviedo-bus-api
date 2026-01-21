package com.iecisa.ctausuario.utils;

import android.text.Editable;
import com.auth0.android.jwt.JWT;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/iecisa/ctausuario/utils/Utils;", "", "()V", "Companion", "Cta-Usuario_1.3.1_63_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Utils {
    private static final int CENTS_PER_EURO = 100;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: Utils.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0015\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/iecisa/ctausuario/utils/Utils$Companion;", "", "()V", "CENTS_PER_EURO", "", "getAccountExpirationDate", "", "jwt", "Lcom/auth0/android/jwt/JWT;", "getAccountLastAccess", "token", "getCentsForEuro", "euros", "getDaysUntilExpiration", "(Lcom/auth0/android/jwt/JWT;)Ljava/lang/Integer;", "getEuros", "", "cent", "(Ljava/lang/Double;)D", "(Ljava/lang/Integer;)D", "getMail", "bearerToken", "numCommas", "", "text", "Landroid/text/Editable;", "replaceCommas", "editable", "Cta-Usuario_1.3.1_63_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCentsForEuro(String euros) {
            String strReplace$default;
            Double doubleOrNull;
            return (int) (((euros == null || (strReplace$default = StringsKt.replace$default(euros, ",", ".", false, 4, (Object) null)) == null || (doubleOrNull = StringsKt.toDoubleOrNull(strReplace$default)) == null) ? 0.0d : doubleOrNull.doubleValue()) * 100);
        }

        public final double getEuros(Integer cent) {
            return getEuros(cent != null ? Double.valueOf(cent.intValue()) : null);
        }

        public final double getEuros(Double cent) {
            return (cent != null ? cent.doubleValue() : 0.0d) / 100;
        }

        public final String replaceCommas(Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
            String string = editable.toString();
            int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) string, ",", 0, false, 6, (Object) null);
            if (iLastIndexOf$default == -1) {
                return string;
            }
            String strSubstring = string.substring(0, iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = string.substring(iLastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            return strSubstring + strSubstring2;
        }

        public final boolean numCommas(Editable text) {
            Intrinsics.checkNotNullParameter(text, "text");
            Editable editable = text;
            int i = 0;
            for (int i2 = 0; i2 < editable.length(); i2++) {
                if (editable.charAt(i2) == ',') {
                    i++;
                }
            }
            return i > 1;
        }

        public final String getMail(String bearerToken) {
            String strAsString;
            if (bearerToken == null || (strAsString = new JWT(bearerToken).getClaim("email").asString()) == null) {
                return null;
            }
            return StringsKt.trim((CharSequence) strAsString).toString();
        }

        public final String getAccountExpirationDate(JWT jwt) {
            Long lAsLong;
            if (jwt == null || (lAsLong = jwt.getClaim("accountExpirationDate").asLong()) == null) {
                return null;
            }
            return new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT, Locale.getDefault()).format(new Date(lAsLong.longValue() * 1000));
        }

        public final Integer getDaysUntilExpiration(JWT jwt) {
            Long lAsLong;
            if (jwt == null || (lAsLong = jwt.getClaim("accountExpirationDate").asLong()) == null) {
                return null;
            }
            long jLongValue = lAsLong.longValue();
            Long lAsLong2 = jwt.getClaim("nbf").asLong();
            if (lAsLong2 == null) {
                return null;
            }
            long jLongValue2 = jLongValue - lAsLong2.longValue();
            if (jLongValue2 <= 0) {
                return 0;
            }
            return Integer.valueOf((int) (jLongValue2 / 86400));
        }

        public final String getAccountLastAccess(String token) {
            Long lAsLong;
            if (token == null || (lAsLong = new JWT(token).getClaim("accountLastAccess").asLong()) == null) {
                return null;
            }
            Date date = new Date(lAsLong.longValue() * 1000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.DATE_TIME_FORMAT, Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(date);
        }
    }
}
