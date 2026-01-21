package com.iecisa.ctausuario.utils.maputils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.libraries.places.api.model.Place;
import com.google.maps.android.ui.IconGenerator;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.model.SearchAddress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class MapUtils {
    protected static final int MAX_ADDRESSES_BY_COORDS = 5;
    private static BitmapDescriptor currentPositionMarker;
    private static BitmapDescriptor mapStopMarker;
    private static BitmapDescriptor selectedMapStopMarker;

    public static BitmapDescriptor getMapStopMarker(Context context) {
        if (mapStopMarker == null) {
            mapStopMarker = bitmapDescriptorFromVector(context, R.drawable.ic_marker_stop);
        }
        return mapStopMarker;
    }

    public static BitmapDescriptor getCurrentPositionMarker(Context context) {
        if (currentPositionMarker == null) {
            currentPositionMarker = bitmapDescriptorFromVector(context, R.drawable.ic_marker_position);
        }
        return currentPositionMarker;
    }

    public static BitmapDescriptor getSelectedMapStopMarker(Context context) {
        if (selectedMapStopMarker == null) {
            selectedMapStopMarker = bitmapDescriptorFromVector(context, R.drawable.ic_marker_selected_stop);
        }
        return selectedMapStopMarker;
    }

    public static BitmapDescriptor getSelectedDestinationMarker(Context context) {
        if (selectedMapStopMarker == null) {
            selectedMapStopMarker = bitmapDescriptorFromVector(context, R.drawable.ic_marker_selected_destination);
        }
        return selectedMapStopMarker;
    }

    public static BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable drawable = ContextCompat.getDrawable(context, vectorResId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap);
    }

    public static BitmapDescriptor createTextMarkerIcon(Context context, String text, int backgroundDrawableRes) {
        float f = context.getResources().getDisplayMetrics().density;
        int i = (int) (100 * f);
        int i2 = (int) (48 * f);
        Drawable drawable = ContextCompat.getDrawable(context, backgroundDrawableRes);
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        IconGenerator iconGenerator = new IconGenerator(context);
        iconGenerator.setBackground(null);
        iconGenerator.setContentPadding(0, 0, 0, 0);
        iconGenerator.setTextAppearance(R.style.TextViewWhite);
        Bitmap bitmapMakeIcon = iconGenerator.makeIcon(text);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
        canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        canvas2.drawBitmap(bitmapMakeIcon, (float) ((i * 4.5d) / 12.0d), (i2 - bitmapMakeIcon.getHeight()) / 4.0f, (Paint) null);
        return BitmapDescriptorFactory.fromBitmap(bitmapCreateBitmap2);
    }

    public static void animateSlideUp(Context context, ConstraintLayout viewSlide) {
        viewSlide.startAnimation(AnimationUtils.loadAnimation(context, R.anim.view_slide_up));
        viewSlide.setVisibility(0);
    }

    public static void animateSlideDown(final Context context, final ConstraintLayout viewSlide) {
        if (viewSlide.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.view_slide_down);
            viewSlide.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.iecisa.ctausuario.utils.maputils.MapUtils.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewSlide.setVisibility(8);
                }
            });
        }
    }

    public static Address getAddressByCoordinates(double lat, double lng, Context context) throws IOException {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> arrayList = new ArrayList<>();
        try {
            arrayList = geocoder.getFromLocation(lat, lng, 5);
        } catch (IOException e) {
            Timber.e(e);
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return arrayList.get(0);
    }

    public static SearchAddress buildSearchAddress(Address address) {
        StringBuilder sb = new StringBuilder();
        if (address == null) {
            return null;
        }
        if (!TextUtils.isEmpty(address.getThoroughfare())) {
            sb.append(address.getThoroughfare());
        }
        if (!TextUtils.isEmpty(address.getSubThoroughfare())) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(", ");
            }
            sb.append(address.getSubThoroughfare());
        }
        if (!TextUtils.isEmpty(address.getLocality())) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(", ");
            }
            sb.append(address.getLocality());
        }
        return new SearchAddress(sb.toString(), calculateDetailAdress(address).toString(), Double.valueOf(address.getLongitude()), Double.valueOf(address.getLatitude()));
    }

    public static SearchAddress buildSearchAddress(Place place, Context context) {
        String strCalculateDetailAdress;
        StringBuilder sb = new StringBuilder(place.getName());
        Address addressByCoordinates = getAddressByCoordinates(place.getLatLng().latitude, place.getLatLng().longitude, context);
        if (addressByCoordinates == null) {
            strCalculateDetailAdress = "";
        } else {
            if (!TextUtils.isEmpty(addressByCoordinates.getLocality())) {
                if (!TextUtils.isEmpty(sb)) {
                    sb.append(", ");
                }
                sb.append(addressByCoordinates.getLocality());
            }
            strCalculateDetailAdress = calculateDetailAdress(addressByCoordinates);
        }
        return new SearchAddress(sb.toString(), strCalculateDetailAdress, Double.valueOf(place.getLatLng().longitude), Double.valueOf(place.getLatLng().latitude));
    }

    private static String calculateDetailAdress(Address address) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(address.getPostalCode())) {
            sb.append(address.getPostalCode());
        }
        if (!TextUtils.isEmpty(address.getSubAdminArea())) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(", ");
            }
            sb.append(address.getSubAdminArea());
        }
        if (!TextUtils.isEmpty(address.getCountryName())) {
            if (!TextUtils.isEmpty(sb)) {
                sb.append(", ");
            }
            sb.append(address.getCountryName());
        }
        return sb.toString();
    }
}
