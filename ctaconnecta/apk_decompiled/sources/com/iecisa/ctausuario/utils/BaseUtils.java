package com.iecisa.ctausuario.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.auth0.android.jwt.JWT;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.ConditionsResponseModel;
import com.iecisa.ctausuario.utils.Constants;
import com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog;

/* loaded from: classes5.dex */
public class BaseUtils {
    public static final int INFO_MESSAGE_VISIBILITY_MS = 5000;
    public static final int MS_PER_SECOND = 1000;

    public interface onDialogListener {
        void onClickNegative();

        void onClickPositive();
    }

    public interface onGetConditions {
        void onError(Integer code, String message);

        void onSuccess(ConditionsResponseModel model);
    }

    public interface onInfoBlockDialogListener {
        void onClickPositive();

        void onDismiss();
    }

    public interface onPositiveDialogListener {
        void onClickPositive();
    }

    public interface onRefreshToken {
        void onError();

        void onSuccess();
    }

    static /* synthetic */ void lambda$showDialog$2(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$showInfoDialog$10(DialogInterface dialogInterface) {
    }

    static /* synthetic */ void lambda$showInfoDialog$15() {
    }

    static /* synthetic */ void lambda$showKoDialog$16() {
    }

    private static BaseOptionsDialog buildDialog(Context context, int baseDialog, String title, String description) {
        BaseOptionsDialog baseOptionsDialog = new BaseOptionsDialog(context);
        if (!baseOptionsDialog.isShowing()) {
            baseOptionsDialog.setDialogType(baseDialog);
            baseOptionsDialog.setAnimationEnable(true);
            baseOptionsDialog.setTitleText(title);
            baseOptionsDialog.setContentText(description);
        }
        return baseOptionsDialog;
    }

    public static BaseOptionsDialog showDialog(Context context, int baseDialog, String title, String description, String positiveText, String negativeText, final onDialogListener listener) {
        final BaseOptionsDialog baseOptionsDialogBuildDialog = buildDialog(context, baseDialog, title, description);
        if (!baseOptionsDialogBuildDialog.isShowing()) {
            baseOptionsDialogBuildDialog.setPositiveListener(positiveText, new BaseOptionsDialog.onClickCommentsDialog() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda0
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialog
                public final void onClickPositive(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showDialog$0(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setNegativeListener(negativeText, new BaseOptionsDialog.onClickCommentsDialogNegative() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda9
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialogNegative
                public final void onClickNegative(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showDialog$1(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showDialog$2(dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showDialog$3(listener, baseOptionsDialogBuildDialog, dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.show();
        }
        return baseOptionsDialogBuildDialog;
    }

    static /* synthetic */ void lambda$showDialog$0(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        ondialoglistener.onClickPositive();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showDialog$1(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        ondialoglistener.onClickNegative();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showDialog$3(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, DialogInterface dialogInterface) {
        ondialoglistener.onClickNegative();
        baseOptionsDialog.dismiss();
    }

    public static BaseOptionsDialog showBlockDialog(Context context, int baseDialog, String title, String description, String positiveText, String negativeText, final onDialogListener listener) {
        final BaseOptionsDialog baseOptionsDialogBuildDialog = buildDialog(context, baseDialog, title, description);
        if (!baseOptionsDialogBuildDialog.isShowing()) {
            baseOptionsDialogBuildDialog.setPositiveListener(positiveText, new BaseOptionsDialog.onClickCommentsDialog() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda2
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialog
                public final void onClickPositive(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showBlockDialog$4(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setNegativeListener(negativeText, new BaseOptionsDialog.onClickCommentsDialogNegative() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda3
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialogNegative
                public final void onClickNegative(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showBlockDialog$5(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showBlockDialog$6(listener, baseOptionsDialogBuildDialog, dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showBlockDialog$7(listener, baseOptionsDialogBuildDialog, dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.show();
        }
        return baseOptionsDialogBuildDialog;
    }

    static /* synthetic */ void lambda$showBlockDialog$4(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        ondialoglistener.onClickPositive();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showBlockDialog$5(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        ondialoglistener.onClickNegative();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showBlockDialog$6(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, DialogInterface dialogInterface) {
        ondialoglistener.onClickNegative();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showBlockDialog$7(onDialogListener ondialoglistener, BaseOptionsDialog baseOptionsDialog, DialogInterface dialogInterface) {
        ondialoglistener.onClickNegative();
        baseOptionsDialog.dismiss();
    }

    public static BaseOptionsDialog showInfoDialog(Context context, int baseDialog, String title, String description, String positiveText, final onPositiveDialogListener listener) {
        final BaseOptionsDialog baseOptionsDialogBuildDialog = buildDialog(context, baseDialog, title, description);
        if (!baseOptionsDialogBuildDialog.isShowing()) {
            baseOptionsDialogBuildDialog.setPositiveListener(positiveText, new BaseOptionsDialog.onClickCommentsDialog() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda12
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialog
                public final void onClickPositive(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showInfoDialog$8(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setNegativeListener(new BaseOptionsDialog.onClickCommentsDialogNegative() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda13
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialogNegative
                public final void onClickNegative(BaseOptionsDialog baseOptionsDialog) {
                    baseOptionsDialogBuildDialog.dismiss();
                }
            });
            baseOptionsDialogBuildDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda14
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showInfoDialog$10(dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda15
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    BaseUtils.lambda$showInfoDialog$11(listener, baseOptionsDialogBuildDialog, dialogInterface);
                }
            });
            baseOptionsDialogBuildDialog.show();
        }
        return baseOptionsDialogBuildDialog;
    }

    static /* synthetic */ void lambda$showInfoDialog$8(onPositiveDialogListener onpositivedialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        onpositivedialoglistener.onClickPositive();
        baseOptionsDialog.dismiss();
    }

    static /* synthetic */ void lambda$showInfoDialog$11(onPositiveDialogListener onpositivedialoglistener, BaseOptionsDialog baseOptionsDialog, DialogInterface dialogInterface) {
        onpositivedialoglistener.onClickPositive();
        baseOptionsDialog.dismiss();
    }

    public static BaseOptionsDialog showBlockInfoDialog(Context context, int baseDialog, String title, String description, String positiveText, final onInfoBlockDialogListener listener) {
        final BaseOptionsDialog baseOptionsDialogBuildDialog = buildDialog(context, baseDialog, title, description);
        if (!baseOptionsDialogBuildDialog.isShowing()) {
            baseOptionsDialogBuildDialog.setPositiveListener(positiveText, new BaseOptionsDialog.onClickCommentsDialog() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda16
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialog
                public final void onClickPositive(BaseOptionsDialog baseOptionsDialog) {
                    BaseUtils.lambda$showBlockInfoDialog$12(listener, baseOptionsDialogBuildDialog, baseOptionsDialog);
                }
            });
            baseOptionsDialogBuildDialog.setNegativeListener(new BaseOptionsDialog.onClickCommentsDialogNegative() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda17
                @Override // com.iecisa.ctausuario.utils.dialog.BaseOptionsDialog.onClickCommentsDialogNegative
                public final void onClickNegative(BaseOptionsDialog baseOptionsDialog) {
                    baseOptionsDialogBuildDialog.dismiss();
                }
            });
            baseOptionsDialogBuildDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    listener.onDismiss();
                }
            });
            baseOptionsDialogBuildDialog.show();
        }
        return baseOptionsDialogBuildDialog;
    }

    static /* synthetic */ void lambda$showBlockInfoDialog$12(onInfoBlockDialogListener oninfoblockdialoglistener, BaseOptionsDialog baseOptionsDialog, BaseOptionsDialog baseOptionsDialog2) {
        oninfoblockdialoglistener.onClickPositive();
        baseOptionsDialog.dismiss();
    }

    public static void showInfoDialog(Context context, String title, String description) {
        showInfoDialog(context, 0, title, description, context.getString(R.string.label_understand), new onPositiveDialogListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda7
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                BaseUtils.lambda$showInfoDialog$15();
            }
        });
    }

    public static void showKoDialog(Context context, String description) {
        showKoDialog(context, context.getString(R.string.label_something_go_wrong), description);
    }

    public static void showKoDialog(Context context, String title, String description) {
        showInfoDialog(context, 2, title, description, context.getString(R.string.label_understand), new onPositiveDialogListener() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda6
            @Override // com.iecisa.ctausuario.utils.BaseUtils.onPositiveDialogListener
            public final void onClickPositive() {
                BaseUtils.lambda$showKoDialog$16();
            }
        });
    }

    public static void setupAdapter(ArrayAdapter adapter, AutoCompleteTextView actv) {
        if (adapter != null) {
            adapter.getFilter().filter(null);
        }
        actv.performCompletion();
    }

    public static void showInfoMessage(final TextView textView) {
        Handler handler = new Handler();
        textView.setVisibility(0);
        handler.postDelayed(new Runnable() { // from class: com.iecisa.ctausuario.utils.BaseUtils$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                textView.setVisibility(8);
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb.toString().replaceAll("\\s+", "");
    }

    public static byte[] hexToByteArray(String adpu) {
        int length = adpu.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(adpu.charAt(i), 16) << 4) + Character.digit(adpu.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static Integer millisecondsToSeconds(Long milliseconds) {
        return Integer.valueOf((int) (milliseconds.longValue() / 1000));
    }

    public static String getUserId(String bearerToken) {
        return new JWT(bearerToken).getClaim("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier").asString();
    }

    public static boolean isValidLocation(Double latitude, Double longitude) {
        return longitude.doubleValue() >= Constants.MapBorder.East.doubleValue() && longitude.doubleValue() <= Constants.MapBorder.West.doubleValue() && latitude.doubleValue() <= Constants.MapBorder.North.doubleValue() && latitude.doubleValue() >= Constants.MapBorder.South.doubleValue();
    }

    public static BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable drawable = ContextCompat.getDrawable(context, vectorResId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
    }
}
