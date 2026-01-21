package com.iecisa.ctausuario.utils;

import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ValidatorModel;
import com.iecisa.ctausuario.model.ValidatorResponseModel;
import com.iecisa.ctausuario.utils.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class ValidatorUtils {
    public static final Pattern MOBILE_PHONE_PATTERN = Pattern.compile("(6|7)[ ]*([0-9][ ]*){8}");
    public static final Pattern FIXED_PHONE_PATTERN = Pattern.compile("(8|9)[ ]*([0-9][ ]*){8}");
    public static final Pattern PHONE_PATTERN = Pattern.compile("(6|7|8|9)[ ]*([0-9][ ]*){8}");
    public static final Pattern DNI_PATTERN = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");

    private ValidatorUtils() {
    }

    public static ValidatorResponseModel validateField(Context context, List<ValidatorModel> validatorModelList) {
        if (validatorModelList != null && !validatorModelList.isEmpty()) {
            for (ValidatorModel validatorModel : validatorModelList) {
                switch (validatorModel.getTypeValidator()) {
                    case 0:
                        String string = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_price_empty), validatorModel);
                        }
                    case 1:
                        String string2 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string2.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_email_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !Patterns.EMAIL_ADDRESS.matcher(string2).matches()) {
                            return new ValidatorResponseModel(context.getString(R.string.label_error_invalid_mail), validatorModel);
                        }
                        break;
                    case 2:
                        String string3 = validatorModel.getTextView().getText().toString();
                        String string4 = validatorModel.getRepeatView().getText().toString();
                        if (validatorModel.isActivated() && !string3.equals(string4)) {
                            return new ValidatorResponseModel(context.getString(R.string.label_error_invalid_repeat_mail), validatorModel);
                        }
                        break;
                    case 3:
                        if (validatorModel.isActivated() && !validatorModel.isChecked()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_check_terms), validatorModel);
                        }
                        break;
                    case 4:
                        String string5 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string5.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_number_card_empty), validatorModel);
                        }
                        break;
                    case 5:
                        String string6 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string6.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.label_error_void_field), validatorModel);
                        }
                        break;
                    case 6:
                        String string7 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string7.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !PHONE_PATTERN.matcher(string7).matches()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_error), validatorModel);
                        }
                        break;
                        break;
                    case 7:
                        String string8 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string8.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !MOBILE_PHONE_PATTERN.matcher(string8).matches()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_error), validatorModel);
                        }
                        break;
                        break;
                    case 8:
                        String string9 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && !string9.isEmpty() && !MOBILE_PHONE_PATTERN.matcher(string9).matches()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_error), validatorModel);
                        }
                        break;
                    case 9:
                        String string10 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && !string10.isEmpty() && !FIXED_PHONE_PATTERN.matcher(string10).matches()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_phone_error), validatorModel);
                        }
                        break;
                        break;
                    case 10:
                        String string11 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string11.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.label_empty_card_field), validatorModel);
                        }
                    case 11:
                        String string12 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string12.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.error_origin_and_destination_empty), validatorModel);
                        }
                        break;
                    case 12:
                        String string13 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string13.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.label_error_void_field), validatorModel);
                        }
                        if (validatorModel.getTextView().length() != 5) {
                            return new ValidatorResponseModel(context.getString(R.string.label_error_postal_code), validatorModel);
                        }
                        break;
                    case 13:
                        String string14 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string14.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.error_login_user_name_empty), validatorModel);
                        }
                        break;
                    case 14:
                        String string15 = validatorModel.getTextView().getText().toString();
                        if (!validatorModel.isActivated() || !string15.isEmpty()) {
                            break;
                        } else {
                            return new ValidatorResponseModel(context.getString(R.string.error_login_pwd_empty), validatorModel);
                        }
                        break;
                    case 15:
                        String string16 = validatorModel.getTextView().getText().toString();
                        String string17 = validatorModel.getRepeatView().getText().toString();
                        if (validatorModel.isActivated() && !string16.equals(string17)) {
                            return new ValidatorResponseModel(context.getString(R.string.error_login_pwd_diferent), validatorModel);
                        }
                        break;
                    case 16:
                        String string18 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string18.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_price_empty), validatorModel);
                        }
                        if (Utils.INSTANCE.getCentsForEuro(string18) > Constants.AutoRecharge.MAX_RECHARGE_QUANTITY.intValue() || Utils.INSTANCE.getCentsForEuro(string18) < Constants.AutoRecharge.MIN_RECHARGE_QUANTITY.intValue()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_auto_recharge_quantity, Double.valueOf(Utils.INSTANCE.getEuros(Constants.AutoRecharge.MIN_RECHARGE_QUANTITY)), Double.valueOf(Utils.INSTANCE.getEuros(Constants.AutoRecharge.MAX_RECHARGE_QUANTITY))), validatorModel);
                        }
                        break;
                        break;
                    case 17:
                        String string19 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string19.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_recharge_payment_price_empty), validatorModel);
                        }
                        if (Utils.INSTANCE.getCentsForEuro(string19) > Constants.AutoRecharge.MAX_THRESHOLD.intValue() || Utils.INSTANCE.getCentsForEuro(string19) < Constants.AutoRecharge.MIN_THRESHOLD.intValue()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_auto_recharge_threshold, Double.valueOf(Utils.INSTANCE.getEuros(Constants.AutoRecharge.MIN_THRESHOLD)), Double.valueOf(Utils.INSTANCE.getEuros(Constants.AutoRecharge.MAX_THRESHOLD))), validatorModel);
                        }
                        break;
                    case 19:
                        String string20 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string20.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !validateDni(string20)) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_error), validatorModel);
                        }
                        break;
                    case 20:
                        String string21 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string21.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !validateNie(string21)) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_error), validatorModel);
                        }
                        break;
                        break;
                    case 21:
                        String string22 = validatorModel.getTextView().getText().toString();
                        if (validatorModel.isActivated() && string22.isEmpty()) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_empty), validatorModel);
                        }
                        if (validatorModel.isActivated() && !validateDni(string22) && !validateNie(string22)) {
                            return new ValidatorResponseModel(context.getString(R.string.error_request_card_data_id_document_error), validatorModel);
                        }
                        break;
                        break;
                }
            }
        }
        if (validatorModelList != null && validatorModelList.size() > 0) {
            Iterator<ValidatorModel> it = validatorModelList.iterator();
            while (it.hasNext()) {
                if (!it.next().isActivated()) {
                    return new ValidatorResponseModel("", null);
                }
            }
        }
        return new ValidatorResponseModel(null, null);
    }

    private static ValidatorModel findValidator(View view, List<ValidatorModel> validatorModelList) {
        if (validatorModelList == null) {
            return null;
        }
        for (ValidatorModel validatorModel : validatorModelList) {
            View view2 = validatorModel.getView();
            if (view2 != null && view2.equals(view)) {
                return validatorModel;
            }
        }
        return null;
    }

    public static void activateValidator(View view, List<ValidatorModel> validatorModelList) {
        ValidatorModel validatorModelFindValidator;
        if (validatorModelList == null || validatorModelList.isEmpty() || view == null || (validatorModelFindValidator = findValidator(view, validatorModelList)) == null) {
            return;
        }
        validatorModelFindValidator.setActivated(true);
    }

    public static void deactivateValidator(View view, List<ValidatorModel> validatorModelList) {
        ValidatorModel validatorModelFindValidator;
        if (validatorModelList == null || validatorModelList.isEmpty() || view == null || (validatorModelFindValidator = findValidator(view, validatorModelList)) == null) {
            return;
        }
        validatorModelFindValidator.setActivated(false);
    }

    public static void setValidatorChecked(boolean checked, List<ValidatorModel> validatorModelList) {
        if (validatorModelList != null) {
            for (ValidatorModel validatorModel : validatorModelList) {
                if (3 == validatorModel.getTypeValidator()) {
                    validatorModel.setActivated(true);
                    validatorModel.setChecked(checked);
                }
            }
        }
    }

    public static void showErrorField(ValidatorModel responseModel, List<ValidatorModel> validatorModelList) {
        if (validatorModelList != null) {
            for (ValidatorModel validatorModel : validatorModelList) {
                if (validatorModel == responseModel) {
                    loadBackgroundResource(validatorModel.getView(), true);
                } else {
                    loadBackgroundResource(validatorModel.getView(), false);
                }
            }
        }
    }

    public static void loadBackgroundResource(View view, boolean isError) {
        if (view != null) {
            if (view instanceof ImageView) {
                view.setBackgroundResource(isError ? R.drawable.shape_image_error : R.drawable.shape_image_border);
            } else {
                view.setBackgroundResource(isError ? R.drawable.shape_text_red_error : R.drawable.shape_text_grey);
            }
        }
    }

    public static boolean validateDni(String dni) {
        Matcher matcher = DNI_PATTERN.matcher(dni);
        if (matcher.matches()) {
            String strGroup = matcher.group(2);
            int i = Integer.parseInt(matcher.group(1)) % 23;
            String strSubstring = "TRWAGMYFPDXBNJZSQVHLCKE".substring(i, i + 1);
            if (dni.length() == 9 && strSubstring.equalsIgnoreCase(strGroup)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateNie(String nie) {
        char cCharAt = nie.toUpperCase().charAt(0);
        if (cCharAt != 'X' && cCharAt != 'Y' && cCharAt != 'Z') {
            return false;
        }
        return validateDni((cCharAt != 'X' ? cCharAt != 'Y' ? '2' : '1' : '0') + nie.substring(1));
    }
}
