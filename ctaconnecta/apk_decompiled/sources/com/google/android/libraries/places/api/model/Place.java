package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.internal.zznx;
import com.google.android.libraries.places.internal.zzok;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public abstract class Place implements Parcelable {
    public static final int PRICE_LEVEL_MAX_VALUE = 4;
    public static final int PRICE_LEVEL_MIN_VALUE = 0;
    public static final double RATING_MAX_VALUE = 5.0d;
    public static final double RATING_MIN_VALUE = 1.0d;

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public enum BooleanPlaceAttributeValue implements Parcelable {
        UNKNOWN,
        TRUE,
        FALSE;

        public static final Parcelable.Creator<BooleanPlaceAttributeValue> CREATOR = new zzcf();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public static abstract class Builder {
        public Place build() {
            Place placeZza = zza();
            List<String> attributions = placeZza.getAttributions();
            if (attributions != null) {
                Iterator<String> it = attributions.iterator();
                while (it.hasNext()) {
                    zzmt.zzp(!TextUtils.isEmpty(it.next()), "Attributions must not contain null or empty values.");
                }
            }
            Integer priceLevel = placeZza.getPriceLevel();
            if (priceLevel != null) {
                zzmt.zzs(zzok.zzb(0, 4).zzd(priceLevel), "Price Level must not be out-of-range: %s to %s, but was: %s.", 0, 4, priceLevel);
            }
            Double rating = placeZza.getRating();
            if (rating != null) {
                Double dValueOf = Double.valueOf(1.0d);
                Double dValueOf2 = Double.valueOf(5.0d);
                zzmt.zzs(zzok.zzb(dValueOf, dValueOf2).zzd(rating), "Rating must not be out-of-range: %s to %s, but was: %s.", dValueOf, dValueOf2, rating);
            }
            Integer userRatingsTotal = placeZza.getUserRatingsTotal();
            if (userRatingsTotal != null) {
                zzmt.zzr(zzok.zza(0).zzd(userRatingsTotal), "User Ratings Total must not be < 0, but was: %s.", userRatingsTotal);
            }
            if (attributions != null) {
                setAttributions(zznx.zzj(attributions));
            }
            List<PhotoMetadata> photoMetadatas = placeZza.getPhotoMetadatas();
            if (photoMetadatas != null) {
                setPhotoMetadatas(zznx.zzj(photoMetadatas));
            }
            List<String> placeTypes = placeZza.getPlaceTypes();
            if (placeTypes != null) {
                setPlaceTypes(zznx.zzj(placeTypes));
            }
            List<Type> types = placeZza.getTypes();
            if (types != null) {
                setTypes(zznx.zzj(types));
            }
            List<OpeningHours> secondaryOpeningHours = placeZza.getSecondaryOpeningHours();
            if (secondaryOpeningHours != null) {
                setSecondaryOpeningHours(zznx.zzj(secondaryOpeningHours));
            }
            List<Review> reviews = placeZza.getReviews();
            if (reviews != null) {
                setReviews(zznx.zzj(reviews));
            }
            return zza();
        }

        public abstract String getAddress();

        public abstract AddressComponents getAddressComponents();

        public abstract List<String> getAttributions();

        public abstract BusinessStatus getBusinessStatus();

        public abstract BooleanPlaceAttributeValue getCurbsidePickup();

        public abstract OpeningHours getCurrentOpeningHours();

        public abstract BooleanPlaceAttributeValue getDelivery();

        public abstract BooleanPlaceAttributeValue getDineIn();

        public abstract String getEditorialSummary();

        public abstract String getEditorialSummaryLanguageCode();

        public abstract Integer getIconBackgroundColor();

        public abstract String getIconUrl();

        public abstract String getId();

        public abstract LatLng getLatLng();

        public abstract String getName();

        public abstract String getNameLanguageCode();

        public abstract OpeningHours getOpeningHours();

        public abstract String getPhoneNumber();

        public abstract List<PhotoMetadata> getPhotoMetadatas();

        public abstract List<String> getPlaceTypes();

        public abstract PlusCode getPlusCode();

        public abstract Integer getPriceLevel();

        public abstract String getPrimaryType();

        public abstract Double getRating();

        public abstract BooleanPlaceAttributeValue getReservable();

        public abstract List<Review> getReviews();

        public abstract List<OpeningHours> getSecondaryOpeningHours();

        public abstract BooleanPlaceAttributeValue getServesBeer();

        public abstract BooleanPlaceAttributeValue getServesBreakfast();

        public abstract BooleanPlaceAttributeValue getServesBrunch();

        public abstract BooleanPlaceAttributeValue getServesDinner();

        public abstract BooleanPlaceAttributeValue getServesLunch();

        public abstract BooleanPlaceAttributeValue getServesVegetarianFood();

        public abstract BooleanPlaceAttributeValue getServesWine();

        public abstract BooleanPlaceAttributeValue getTakeout();

        @Deprecated
        public abstract List<Type> getTypes();

        public abstract Integer getUserRatingsTotal();

        public abstract Integer getUtcOffsetMinutes();

        public abstract LatLngBounds getViewport();

        public abstract Uri getWebsiteUri();

        public abstract BooleanPlaceAttributeValue getWheelchairAccessibleEntrance();

        public abstract Builder setAddress(String str);

        public abstract Builder setAddressComponents(AddressComponents addressComponents);

        public abstract Builder setAttributions(List<String> list);

        public abstract Builder setBusinessStatus(BusinessStatus businessStatus);

        public abstract Builder setCurbsidePickup(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setCurrentOpeningHours(OpeningHours openingHours);

        public abstract Builder setDelivery(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setDineIn(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setEditorialSummary(String str);

        public abstract Builder setEditorialSummaryLanguageCode(String str);

        public abstract Builder setIconBackgroundColor(Integer num);

        public abstract Builder setIconUrl(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLatLng(LatLng latLng);

        public abstract Builder setName(String str);

        public abstract Builder setNameLanguageCode(String str);

        public abstract Builder setOpeningHours(OpeningHours openingHours);

        public abstract Builder setPhoneNumber(String str);

        public abstract Builder setPhotoMetadatas(List<PhotoMetadata> list);

        public abstract Builder setPlaceTypes(List<String> list);

        public abstract Builder setPlusCode(PlusCode plusCode);

        public abstract Builder setPriceLevel(Integer num);

        public abstract Builder setPrimaryType(String str);

        public abstract Builder setRating(Double d);

        public abstract Builder setReservable(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setReviews(List<Review> list);

        public abstract Builder setSecondaryOpeningHours(List<OpeningHours> list);

        public abstract Builder setServesBeer(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesBreakfast(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesBrunch(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesDinner(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesLunch(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesVegetarianFood(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setServesWine(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder setTakeout(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        @Deprecated
        public abstract Builder setTypes(List<Type> list);

        public abstract Builder setUserRatingsTotal(Integer num);

        public abstract Builder setUtcOffsetMinutes(Integer num);

        public abstract Builder setViewport(LatLngBounds latLngBounds);

        public abstract Builder setWebsiteUri(Uri uri);

        public abstract Builder setWheelchairAccessibleEntrance(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        abstract Place zza();
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public enum BusinessStatus implements Parcelable {
        OPERATIONAL,
        CLOSED_TEMPORARILY,
        CLOSED_PERMANENTLY;

        public static final Parcelable.Creator<BusinessStatus> CREATOR = new zzcg();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    public enum Field implements Parcelable {
        ADDRESS,
        ADDRESS_COMPONENTS,
        BUSINESS_STATUS,
        CURBSIDE_PICKUP,
        CURRENT_OPENING_HOURS,
        DELIVERY,
        DINE_IN,
        EDITORIAL_SUMMARY,
        ICON_BACKGROUND_COLOR,
        ICON_URL,
        ID,
        LAT_LNG,
        NAME,
        OPENING_HOURS,
        PHONE_NUMBER,
        PHOTO_METADATAS,
        PLUS_CODE,
        PRICE_LEVEL,
        PRIMARY_TYPE,
        RATING,
        RESERVABLE,
        REVIEWS,
        SECONDARY_OPENING_HOURS,
        SERVES_BEER,
        SERVES_BREAKFAST,
        SERVES_BRUNCH,
        SERVES_DINNER,
        SERVES_LUNCH,
        SERVES_VEGETARIAN_FOOD,
        SERVES_WINE,
        TAKEOUT,
        TYPES,
        USER_RATINGS_TOTAL,
        UTC_OFFSET,
        VIEWPORT,
        WEBSITE_URI,
        WHEELCHAIR_ACCESSIBLE_ENTRANCE;

        public static final Parcelable.Creator<Field> CREATOR = new zzch();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@3.5.0 */
    @Deprecated
    public enum Type implements Parcelable {
        OTHER,
        ACCOUNTING,
        ADMINISTRATIVE_AREA_LEVEL_1,
        ADMINISTRATIVE_AREA_LEVEL_2,
        ADMINISTRATIVE_AREA_LEVEL_3,
        ADMINISTRATIVE_AREA_LEVEL_4,
        ADMINISTRATIVE_AREA_LEVEL_5,
        AIRPORT,
        AMUSEMENT_PARK,
        AQUARIUM,
        ARCHIPELAGO,
        ART_GALLERY,
        ATM,
        BAKERY,
        BANK,
        BAR,
        BEAUTY_SALON,
        BICYCLE_STORE,
        BOOK_STORE,
        BOWLING_ALLEY,
        BUS_STATION,
        CAFE,
        CAMPGROUND,
        CAR_DEALER,
        CAR_RENTAL,
        CAR_REPAIR,
        CAR_WASH,
        CASINO,
        CEMETERY,
        CHURCH,
        CITY_HALL,
        CLOTHING_STORE,
        COLLOQUIAL_AREA,
        CONTINENT,
        CONVENIENCE_STORE,
        COUNTRY,
        COURTHOUSE,
        DENTIST,
        DEPARTMENT_STORE,
        DOCTOR,
        DRUGSTORE,
        ELECTRICIAN,
        ELECTRONICS_STORE,
        EMBASSY,
        ESTABLISHMENT,
        FINANCE,
        FIRE_STATION,
        FLOOR,
        FLORIST,
        FOOD,
        FUNERAL_HOME,
        FURNITURE_STORE,
        GAS_STATION,
        GENERAL_CONTRACTOR,
        GEOCODE,
        GROCERY_OR_SUPERMARKET,
        GYM,
        HAIR_CARE,
        HARDWARE_STORE,
        HEALTH,
        HINDU_TEMPLE,
        HOME_GOODS_STORE,
        HOSPITAL,
        INSURANCE_AGENCY,
        INTERSECTION,
        JEWELRY_STORE,
        LAUNDRY,
        LAWYER,
        LIBRARY,
        LIGHT_RAIL_STATION,
        LIQUOR_STORE,
        LOCAL_GOVERNMENT_OFFICE,
        LOCALITY,
        LOCKSMITH,
        LODGING,
        MEAL_DELIVERY,
        MEAL_TAKEAWAY,
        MOSQUE,
        MOVIE_RENTAL,
        MOVIE_THEATER,
        MOVING_COMPANY,
        MUSEUM,
        NATURAL_FEATURE,
        NEIGHBORHOOD,
        NIGHT_CLUB,
        PAINTER,
        PARK,
        PARKING,
        PET_STORE,
        PHARMACY,
        PHYSIOTHERAPIST,
        PLACE_OF_WORSHIP,
        PLUMBER,
        PLUS_CODE,
        POINT_OF_INTEREST,
        POLICE,
        POLITICAL,
        POST_BOX,
        POST_OFFICE,
        POSTAL_CODE_PREFIX,
        POSTAL_CODE_SUFFIX,
        POSTAL_CODE,
        POSTAL_TOWN,
        PREMISE,
        PRIMARY_SCHOOL,
        REAL_ESTATE_AGENCY,
        RESTAURANT,
        ROOFING_CONTRACTOR,
        ROOM,
        ROUTE,
        RV_PARK,
        SCHOOL,
        SECONDARY_SCHOOL,
        SHOE_STORE,
        SHOPPING_MALL,
        SPA,
        STADIUM,
        STORAGE,
        STORE,
        STREET_ADDRESS,
        STREET_NUMBER,
        SUBLOCALITY_LEVEL_1,
        SUBLOCALITY_LEVEL_2,
        SUBLOCALITY_LEVEL_3,
        SUBLOCALITY_LEVEL_4,
        SUBLOCALITY_LEVEL_5,
        SUBLOCALITY,
        SUBPREMISE,
        SUBWAY_STATION,
        SUPERMARKET,
        SYNAGOGUE,
        TAXI_STAND,
        TOURIST_ATTRACTION,
        TOWN_SQUARE,
        TRAIN_STATION,
        TRANSIT_STATION,
        TRAVEL_AGENCY,
        UNIVERSITY,
        VETERINARY_CARE,
        ZOO;

        public static final Parcelable.Creator<Type> CREATOR = new zzci();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }
    }

    public static Builder builder() {
        zzw zzwVar = new zzw();
        zzwVar.setCurbsidePickup(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setDelivery(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setDineIn(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setReservable(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesBeer(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesBreakfast(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesBrunch(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesDinner(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesLunch(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesVegetarianFood(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setServesWine(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setTakeout(BooleanPlaceAttributeValue.UNKNOWN);
        zzwVar.setWheelchairAccessibleEntrance(BooleanPlaceAttributeValue.UNKNOWN);
        return zzwVar;
    }

    public abstract String getAddress();

    public abstract AddressComponents getAddressComponents();

    public abstract List<String> getAttributions();

    public abstract BusinessStatus getBusinessStatus();

    public abstract BooleanPlaceAttributeValue getCurbsidePickup();

    public abstract OpeningHours getCurrentOpeningHours();

    public abstract BooleanPlaceAttributeValue getDelivery();

    public abstract BooleanPlaceAttributeValue getDineIn();

    public abstract String getEditorialSummary();

    public abstract String getEditorialSummaryLanguageCode();

    public abstract Integer getIconBackgroundColor();

    public abstract String getIconUrl();

    public abstract String getId();

    public abstract LatLng getLatLng();

    public abstract String getName();

    public abstract String getNameLanguageCode();

    public abstract OpeningHours getOpeningHours();

    public abstract String getPhoneNumber();

    public abstract List<PhotoMetadata> getPhotoMetadatas();

    public abstract List<String> getPlaceTypes();

    public abstract PlusCode getPlusCode();

    public abstract Integer getPriceLevel();

    public abstract String getPrimaryType();

    public abstract Double getRating();

    public abstract BooleanPlaceAttributeValue getReservable();

    public abstract List<Review> getReviews();

    public abstract List<OpeningHours> getSecondaryOpeningHours();

    public abstract BooleanPlaceAttributeValue getServesBeer();

    public abstract BooleanPlaceAttributeValue getServesBreakfast();

    public abstract BooleanPlaceAttributeValue getServesBrunch();

    public abstract BooleanPlaceAttributeValue getServesDinner();

    public abstract BooleanPlaceAttributeValue getServesLunch();

    public abstract BooleanPlaceAttributeValue getServesVegetarianFood();

    public abstract BooleanPlaceAttributeValue getServesWine();

    public abstract BooleanPlaceAttributeValue getTakeout();

    @Deprecated
    public abstract List<Type> getTypes();

    public abstract Integer getUserRatingsTotal();

    public abstract Integer getUtcOffsetMinutes();

    public abstract LatLngBounds getViewport();

    public abstract Uri getWebsiteUri();

    public abstract BooleanPlaceAttributeValue getWheelchairAccessibleEntrance();

    @Deprecated
    public Boolean isOpen() {
        return isOpen(System.currentTimeMillis());
    }

    @Deprecated
    public Boolean isOpen(long j) {
        return zzce.zzb(this, j);
    }
}
