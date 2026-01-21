package com.cexmobility.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.location.LocationManager;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class MapUtils {
    public static final int RESULT_GPS = 0;

    static /* synthetic */ void lambda$showDialogToEnableGPS$1(DialogInterface dialogInterface, int i) {
    }

    public static boolean isLocationEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        return locationManager != null && locationManager.isProviderEnabled("gps");
    }

    public static void showDialogToEnableGPS(final Context context, String message, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message).setCancelable(cancelable).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() { // from class: com.cexmobility.core.utils.MapUtils$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        if (!cancelable) {
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() { // from class: com.cexmobility.core.utils.MapUtils$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MapUtils.lambda$showDialogToEnableGPS$1(dialogInterface, i);
                }
            });
        }
        builder.create().show();
    }

    public static void askUserToEnableLocationSystemSettings(final Activity context) {
        LocationServices.getSettingsClient(context).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(LocationRequest.create().setPriority(100)).build()).addOnFailureListener(new OnFailureListener() { // from class: com.cexmobility.core.utils.MapUtils$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MapUtils.lambda$askUserToEnableLocationSystemSettings$2(context, exc);
            }
        });
    }

    static /* synthetic */ void lambda$askUserToEnableLocationSystemSettings$2(Activity activity, Exception exc) {
        if (exc instanceof ResolvableApiException) {
            try {
                ((ResolvableApiException) exc).startResolutionForResult(activity, 0);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }
}
