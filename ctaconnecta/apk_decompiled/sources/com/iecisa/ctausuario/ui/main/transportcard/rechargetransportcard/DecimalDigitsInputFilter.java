package com.iecisa.ctausuario.ui.main.transportcard.rechargetransportcard;

import android.text.InputFilter;
import android.text.Spanned;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class DecimalDigitsInputFilter implements InputFilter {
    Pattern mPattern;

    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
        String str = String.format("\\%s", Character.valueOf(new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator()));
        this.mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((" + str + "[0-9]{0," + (digitsAfterZero - 1) + "})?)||(" + str + ")?");
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (this.mPattern.matcher(dest).matches()) {
            return null;
        }
        return "";
    }
}
