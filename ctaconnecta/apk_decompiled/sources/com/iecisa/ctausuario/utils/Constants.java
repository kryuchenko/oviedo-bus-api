package com.iecisa.ctausuario.utils;

import com.google.api.client.http.HttpStatusCodes;
import com.iecisa.ctausuario.model.SearchAddress;
import java.util.Locale;

/* loaded from: classes5.dex */
public class Constants {
    public static final String FLAVOR_DEVELOP = "develop";
    public static final String FLAVOR_PREPRODUCTION = "preproduction";
    public static final Locale SPANISH = new Locale("es", "ES");
    public static final SearchAddress EMPTY_SEARCH_ADDRESS = new SearchAddress();

    public enum Movements {
        Recharge,
        Validation
    }

    public static class Permissions {
        public static final int MY_PERMISSIONS_CAMERA = 1003;
        public static final int MY_PERMISSIONS_READ_EXTERNAL_STORAGE = 1004;
        public static final int MY_PERMISSIONS_REQUEST_LOCATION = 1001;
        public static final int MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE = 1002;

        private Permissions() {
        }
    }

    public static class UserType {
        public static final int USER_TYPE_EXT = 3;
        public static final int USER_TYPE_EXT_LOGIN = 4;
        public static final int USER_TYPE_LOGIN = 1;
        public static final int USER_TYPE_PASS = 0;
        public static final int USER_TYPE_RTM = 2;

        private UserType() {
        }
    }

    public static class ResponseCode {
        public static final Integer BAD_REQUEST = 400;
        public static final Integer UNAUTHORIZED = 401;
        public static final Integer NOT_FOUND = Integer.valueOf(HttpStatusCodes.STATUS_CODE_NOT_FOUND);
        public static final Integer ERROR = -1;

        private ResponseCode() {
        }
    }

    public static class SwipeType {
        public static final Integer TRANSPORT_CARD = 0;
        public static final Integer PAYMENT_CARD = 1;

        private SwipeType() {
        }
    }

    public static class MapBorder {
        public static final Double North = Double.valueOf(43.6477d);
        public static final Double South = Double.valueOf(42.7667d);
        public static final Double East = Double.valueOf(-7.04095d);
        public static final Double West = Double.valueOf(-2.92528d);

        private MapBorder() {
        }
    }

    public static class IntentData {
        public static final String INTENT_ADDRESS_PICKER = "intent_address_picker";
        public static final String INTENT_CREATE_REPORT = "intent_create_report";
        public static final String INTENT_DELIVERY_METHOD = "intent_delivery_method";
        public static final String INTENT_DELIVERY_TITLE = "intent_delivery_title";
        public static final String INTENT_DELIVERY_VALUE = "intent_delivery_value";
        public static final String INTENT_DESTINATION_FILTER_ENABLED = "intent_destination_filter_enabled";
        public static final String INTENT_DETAIL_ROUTE = "intent_detail_route";
        public static final String INTENT_DOB_REPRESENTATIVE_REQUEST = "intent_dob_representative_request";
        public static final String INTENT_DOB_USER_DATA = "intent_dob_user_data";
        public static final String INTENT_DOB_USER_ID = "intent_dob_user_id";
        public static final String INTENT_FAVOURITE_TRANSPORT_CARD_DATA = "intent_favourite_transport_card_data";
        public static final String INTENT_FIRST_LOGIN_PASSWORD = "intent_first_login_password";
        public static final String INTENT_LINE_DETAIL = "intent_line_detail";
        public static final String INTENT_LOGIN_AFTER_CHANGE_PASSWORD = "intent_login_after_change_password";
        public static final String INTENT_MAP_STOP_DETAIL = "intent_map_stop_detail";
        public static final String INTENT_MIN_THRESHOLD = "intent_min_threshold";
        public static final String INTENT_NEWS_DETAIL = "intent_new_detail";
        public static final String INTENT_NOTIFICATION_BODY = "intent_notification_bode";
        public static final String INTENT_NOTIFICATION_TITLE = "intent_notification_title";
        public static final String INTENT_READ_CARD = "intent_read_card";
        public static final String INTENT_RECHARGE_ALIAS = "intent_recharge_alias";
        public static final String INTENT_RECHARGE_QUANTITY = "intent_recharge_quantity";
        public static final String INTENT_RECHARGE_TRIPS = "intent_recharge_trips";
        public static final String INTENT_RECHARGE_ZONES = "intent_recharge_zones";
        public static final String INTENT_RECOVER_PASSWORD = "intent_recover_password";
        public static final String INTENT_REQUEST_INCIDENT = "intent_request_incident";
        public static final String INTENT_SEARCH_ADDRESS = "intent_search_orgin_address";
        public static final String INTENT_SEARCH_DESTINATION_ADDRESS = "intent_search_destination_address";
        public static final String INTENT_SHOW_BIOMETRIC_SWITCH = "intent_show_biometric_switch";
        public static final String INTENT_STOP_DETAIL = "intent_stop_detail";
        public static final String INTENT_TYPE_RECHARGE_WEBVIEW = "intent_type_recharge_webview";
        public static final String INTENT_TYPE_RECHARGE_ZONES = "intent_type_recharge_zones";
        public static final String INTENT_TYPE_RECHARGE_ZONES_INIT = "intent_type_recharge_zones_init";
        public static final String INTENT_TYPE_RECHARGE_ZONES_INITIAL = "intent_type_recharge_zones_initial";
        public static final String INTENT_TYPE_TRANSPORT_CARD_ALIAS = "intent_type_transport_card_alias";
        public static final String INTENT_TYPE_TRANSPORT_CARD_QUANTITY = "intent_type_recharge_quantity";
        public static final String INTENT_TYPE_TRANSPORT_CARD_RECHARGE_RTM = "intent_type_transport_card_recharge_rtm";
        public static final String INTENT_TYPE_TRANSPORT_CARD_RMT = "intent_type_transport_card_rtm";
        public static final String INTENT_TYPE_TRANSPORT_CARD_SUBTITLE = "intent_type_transport_card_subtitle";
        public static final String INTENT_TYPE_TRANSPORT_CARD_TRIP = "intent_type_transport_card_trip";
        public static final String INTENT_TYPE_TRANSPORT_CARD_TRIPS = "intent_type_transport_card_trips";
        public static final String INTENT_TYPE_TRANSPORT_CARD_TYPE = "intent_type_transport_card_type";
        public static final String INTENT_TYPE_TRANSPORT_CARD_TYPE_NAME = "intent_type_transport_card_type_name";
        public static final String INTENT_TYPE_TRANSPORT_CARD_TYPE_RTM = "intent_type_transport_card_type_rtm";
        public static final String INTENT_TYPE_TRANSPORT_CARD_UNLOGGED_DETAIL = "intent_type_transport_unlogged_detail";
        public static final String INTENT_TYPE_TRANSPORT_CARD_USER = "intent_type_transport_card_user";
        public static final String INTENT_TYPE_TRANSPORT_LIST_ZONES = "intent_type_transport_list_zones";
        public static final String INTENT_USER_DESTINATION = "intent_user_destination";

        private IntentData() {
        }
    }

    public static class Reports {
        public static final String PDF_APP = "application/pdf";
        public static final String PROVIDER = ".provider";

        private Reports() {
        }
    }

    public static class Notification {
        public static final String DATA_INFORMATION = "information";
        public static final String DATA_MESSAGE = "message";
        public static final String DATA_TITLE = "title";
        public static final int DEVICE_TYPE = 2;

        private Notification() {
        }
    }

    public static class RequestCodes {
        public static final int RESULT_ADD_TRANSPORT_CARD = 9;
        public static final int RESULT_GALLERY = 8;
        public static final int RESULT_PAYMENT_CARD = 11;
        public static final int RESULT_PLACE_DESTINATION_ROUTE = 5;
        public static final int RESULT_PLACE_ORIGIN_ROUTE = 4;
        public static final int RESULT_PLACE_SEARCH = 3;
        public static final int RESULT_READ_CARD_INCIDENT = 0;
        public static final int RESULT_RECHARGE_TRANSPORT_CARD = 7;
        public static final int RESULT_RECHARGE_TRANSPORT_CARD_RTM = 10;
        public static final int RESULT_SHOW_PDF = 12;
        public static final int RESULT_TAKE_PHOTO = 2;
        public static final int RESULT_USER_DESTINATION = 1;
        public static final int RESULT_USER_DESTINATION_FILTER = 6;

        private RequestCodes() {
        }
    }

    public static class TransportCardCodes {
        public static final int RESULT_ACTIVATE_AUTO_RECHARGE = 13;
        public static final int RESULT_ADD_CARD = 4;
        public static final int RESULT_AUTO_RECHARGE = 15;
        public static final int RESULT_CHANGE_ALIAS = 12;
        public static final int RESULT_FAMILY_DISCOUNT_CARD = 2;
        public static final int RESULT_REACTIVATE_CARD = 1;
        public static final int RESULT_RECHARGE_CARD = 0;
        public static final int RESULT_RECHARGE_CARD_KO = 10;
        public static final int RESULT_RECHARGE_CARD_OK = 9;
        public static final int RESULT_RECHARGE_CARD_RETRY = 11;
        public static final int RESULT_TRANSPORT_CARD_LOGIN = 8;

        private TransportCardCodes() {
        }
    }

    public static class Rtm {
        public static final String RECHARGE_CARD = "RechargeCard/";

        private Rtm() {
        }
    }

    public static class NFCValues {
        public static final String NFC_KEY_ALIAS = "nameAlias";
        public static final String NFC_KEY_CARD = "idCard";
        public static final String NFC_KEY_CHARACTER = "idCharacter";

        private NFCValues() {
        }
    }

    public static class TimeValues {
        public static final Integer TIME_NEXT_ARRIVAL_VALUE = 60;

        private TimeValues() {
        }
    }

    public static class NewsValues {
        public static final Integer NUMBER_NEWS = 92;

        private NewsValues() {
        }
    }

    public static class StopsValues {
        public static final Integer MAX_MAP_RADIUS = Integer.valueOf(com.google.firebase.perf.util.Constants.MAX_URL_LENGTH);

        private StopsValues() {
        }
    }

    public static class Routes {
        public static final String ROUTE_HTTP = "https:";
        public static final String ROUTE_TRAVEL_MODE_BUS = "BUS";
        public static final String ROUTE_TRAVEL_MODE_HEAVY_RAIL = "HEAVY_RAIL";
        public static final String ROUTE_TRAVEL_MODE_TRANSIT = "TRANSIT";
        public static final String ROUTE_TRAVEL_MODE_WALKING = "WALKING";

        private Routes() {
        }
    }

    public static class Cards {
        public static final Integer TRANSPORT_CARD_TYPE_BONO_10 = 1;
        public static final Integer TRANSPORT_CARD_ABONO_CTA = 2;
        public static final Integer TRANSPORT_CARD_TYPE_BONO_CTA = 3;
        public static final Integer TRANSPORT_CARD_TYPE_BILLETE_UNICO = 4;

        private Cards() {
        }
    }

    public static class AutoRecharge {
        public static final Integer MIN_THRESHOLD = 200;
        public static final Integer MAX_THRESHOLD = Integer.valueOf(com.google.firebase.perf.util.Constants.MAX_URL_LENGTH);
        public static final Integer MIN_RECHARGE_QUANTITY = 1000;
        public static final Integer MAX_RECHARGE_QUANTITY = Integer.valueOf(BaseUtils.INFO_MESSAGE_VISIBILITY_MS);

        private AutoRecharge() {
        }
    }

    public static class Validator {
        public static final int TYPE_AUTO_QUANTITY = 16;
        public static final int TYPE_AUTO_THRESHOLD = 17;
        public static final int TYPE_CHARACTER = 10;
        public static final int TYPE_CHECK = 3;
        public static final int TYPE_DESTINY = 11;
        public static final int TYPE_DNI = 19;
        public static final int TYPE_DNI_NIE = 21;
        public static final int TYPE_FIXED_PHONE = 9;
        public static final int TYPE_IMAGE = 18;
        public static final int TYPE_LOGIN = 13;
        public static final int TYPE_MAIL = 1;
        public static final int TYPE_MOBILE_PHONE = 7;
        public static final int TYPE_NIE = 20;
        public static final int TYPE_NUMBER_CARD = 4;
        public static final int TYPE_OPTIONAL_MOBILE_PHONE = 8;
        public static final int TYPE_PASS = 14;
        public static final int TYPE_PHONE = 6;
        public static final int TYPE_POSTAL_CODE = 12;
        public static final int TYPE_QUANTITY = 0;
        public static final int TYPE_REPEAT_MAIL = 2;
        public static final int TYPE_REPEAT_PASS = 15;
        public static final int TYPE_TEXT = 5;

        private Validator() {
        }
    }

    public static class DeliveryMethod {
        public static final String ADDRESS = "postal";
        public static final String MAIL = "email";
        public static final String OFFICE = "cta";

        private DeliveryMethod() {
        }
    }

    public static class CardStatus {
        public static final Integer ACTIVE = 1;
        public static final Integer BLOCK = 2;

        private CardStatus() {
        }
    }

    public static class ReactivatedCardStatus {
        public static final Integer BLOCKED = 0;
        public static final Integer REACTIVABLE = 1;
        public static final Integer REACTIVATED = 2;

        private ReactivatedCardStatus() {
        }
    }

    public static class RechargeType {
        public static final Integer CHECKOUT_PAYMENT_GATEWAY = 0;
        public static final Integer CHECKOUT_ONE_CLICK_PAYMENT = 1;
        public static final Integer ADD_CARD = 2;

        private RechargeType() {
        }
    }

    public static class BiometricPreferences {
        public static final int BIOMETRIC_LOGIN_ACCEPTED = 2;
        public static final int BIOMETRIC_LOGIN_NOT_ACCEPTED = 1;
        public static final int BIOMETRIC_LOGIN_UNSET = 0;

        private BiometricPreferences() {
        }
    }

    public static class RtmRecharge {
        public static final int RTM_ACTIVATE_CARD = 3;
        public static final int RTM_LOGIN_TRANSPORT_CARD = 0;
        public static final int RTM_READ_CARD = 1;
        public static final int RTM_RECHARGE = 2;

        private RtmRecharge() {
        }
    }

    public static class Api {
        public static final String BEARER = "Bearer ";

        private Api() {
        }
    }

    public static class DetailTransportCardUrl {
        public static final String CTA_IMPERSONAL_PASS = "CtaImpersonalPass";
        public static final String CTA_PASS = "CtaPass";
        public static final String SINGLE_PASS = "SinglePass";
        public static final String TEN_IMPERSONAL_PASS = "CtaTenImpersonalPass";

        private DetailTransportCardUrl() {
        }
    }

    public static class CalculateZonesUrl {
        public static final String CTA_PASS_RATE = "ctaPassRate";
        public static final String CTA_TEN_PASS_RATE = "ctaTenPassRate";

        private CalculateZonesUrl() {
        }
    }

    public static class IdType {
        public static final int ID_TYPE_NFC = 1;
        public static final int ID_TYPE_OTHER_ID = 2;

        private IdType() {
        }
    }

    public static class MapStops {
        public static final int DEFAULT_BUS_REFRESH_TIME = 30000;
        public static final double DEFAULT_LOCATION_LATITUDE = 43.3623743d;
        public static final double DEFAULT_LOCATION_LONGITUDE = -5.8484256d;
        public static final String DEFAULT_LOCATION_NAME = "Oviedo, Oviedo";
        public static final float DEFAULT_MAP_ZOOM = 15.0f;
        public static final double DEFAULT_SEARCH_RADIUS = 500.0d;
        public static final long SHOW_STOPS_MESSAGE_DELAY = 3000;

        private MapStops() {
        }
    }

    public static class Firebase {
        public static final String VERSION_APP = "minVersionAndroid";
        public static final String VERSION_APP_PRE = "minVersionAndroidPre";

        private Firebase() {
        }
    }
}
