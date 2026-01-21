package com.iecisa.ctausuario.utils.maputils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.lifecycle.LiveData;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes5.dex */
public class BoundLocationManager extends LiveData<Location> {
    private static BoundLocationManager instance;
    private FusedLocationProviderClient mFusedLocationClient;
    LocationCallback mLocationCallback = new LocationCallback() { // from class: com.iecisa.ctausuario.utils.maputils.BoundLocationManager.1
        @Override // com.google.android.gms.location.LocationCallback
        public void onLocationResult(LocationResult locationResult) {
            for (Location location : locationResult.getLocations()) {
                if (location != null) {
                    BoundLocationManager.this.setValue(location);
                }
            }
        }
    };

    public static BoundLocationManager getInstance(Context appContext) {
        if (instance == null) {
            instance = new BoundLocationManager(appContext);
        }
        return instance;
    }

    public static boolean isLocationEnabled(Context context) {
        return LocationManagerCompat.isLocationEnabled((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)) && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private BoundLocationManager(final Context appContext) {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(appContext);
        this.mFusedLocationClient = fusedLocationProviderClient;
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener() { // from class: com.iecisa.ctausuario.utils.maputils.BoundLocationManager$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$new$0(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            setValue((Location) task.getResult());
            return;
        }
        LocationRequest locationRequestCreate = LocationRequest.create();
        locationRequestCreate.setPriority(100);
        this.mFusedLocationClient.requestLocationUpdates(locationRequestCreate, this.mLocationCallback, (Looper) null);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        LocationCallback locationCallback = this.mLocationCallback;
        if (locationCallback != null) {
            this.mFusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }
}
