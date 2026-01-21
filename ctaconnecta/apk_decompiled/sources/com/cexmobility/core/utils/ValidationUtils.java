package com.cexmobility.core.utils;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ValidationUtils {
    private static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

    public static boolean validateEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean validateString(String text, int min, int max) {
        return text != null && text.length() >= min && text.length() <= max;
    }

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }
}
