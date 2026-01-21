package com.tecalis.identitysdk;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tecalis.identitysdk.IdentitySDK;
import com.tecalis.identitysdk.activities.kyc.KycActivity;
import com.tecalis.identitysdk.listeners.URLs;
import com.tecalis.identitysdk.models.AuthData;
import com.tecalis.identitysdk.models.Customer;
import com.tecalis.identitysdk.models.Operation;
import com.tecalis.identitysdk.network.NetworkManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SDK {
    private static String AUTH_URL = null;
    private static final int MAX_ATTEMPTS = 3;
    private static String NFC_UPDATE = null;
    private static String OPERATION_URL = null;
    private static String PROFILE_CONFIG_URL = null;
    private static final String STATUS_KO = "Verification KO";
    private static final String STATUS_OK = "Verification OK";
    private static SDK instance;
    private final String apiKey;
    private AuthData authData;
    private final Context context;
    private IdentitySDK.CallbackProgress currentCallbackProgress;
    private final IdentitySDK.Environment environment;
    private final String fcmToken;
    private final String profile;
    private final String webhook;
    private int attempts = 0;
    private String img = "";
    private String img_picture = "";
    private JSONObject profileConfig = new JSONObject();

    static /* synthetic */ void lambda$getProfileConfig$7(VolleyError volleyError) {
    }

    private SDK(Context context, String str, String str2, String str3, String str4, IdentitySDK.Environment environment) {
        this.context = context;
        this.apiKey = str;
        this.profile = str2;
        this.webhook = str3;
        this.fcmToken = str4;
        this.environment = environment;
        String str5 = environment == IdentitySDK.Environment.INTEGRATION ? URLs.BASE_URL : URLs.BASE_URL_PRODUCTION;
        AUTH_URL = str5.concat("/auth");
        NFC_UPDATE = str5.concat("/nfc-update");
        OPERATION_URL = str5.concat("/customer");
        PROFILE_CONFIG_URL = str5 + "/profile-config/" + str + RemoteSettings.FORWARD_SLASH_STRING + str2;
    }

    public static SDK init(Context context, String str, String str2, String str3, String str4) {
        return init(context, str, str2, str3, str4, IdentitySDK.Environment.INTEGRATION);
    }

    public static SDK init(Context context, String str, String str2, String str3, String str4, IdentitySDK.Environment environment) {
        if (instance == null) {
            instance = new SDK(context, str, str2, str3, str4, environment);
        }
        instance.getProfileConfig();
        return instance;
    }

    public static Context getAppContext() {
        return instance.context;
    }

    public static boolean checkNFC() {
        NfcAdapter defaultAdapter = ((NfcManager) instance.context.getSystemService("nfc")).getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static void addAttempts() {
        instance.attempts++;
    }

    public static boolean maxAttemptsReached() {
        return instance.attempts >= 3;
    }

    public static void setImage(String str) {
        instance.img = str;
    }

    public static void setImagePicture(String str) {
        instance.img_picture = str;
    }

    public static void startKycProcess(final AppCompatActivity appCompatActivity) {
        NetworkManager.post(AUTH_URL, instance.profileConfig, new Response.Listener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda0
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                SDK.lambda$startKycProcess$0(appCompatActivity, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda1
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                SDK.lambda$startKycProcess$1(volleyError);
            }
        });
    }

    static /* synthetic */ void lambda$startKycProcess$0(AppCompatActivity appCompatActivity, JSONObject jSONObject) {
        instance.authData = new AuthData(jSONObject);
        if (appCompatActivity == null) {
            instance.currentCallbackProgress.onSuccess();
        }
        SDK sdk = instance;
        sdk.currentCallbackProgress.getAuthUuid(sdk.authData.auth_uuid);
        Intent intent = new Intent(instance.context, (Class<?>) KycActivity.class);
        intent.putExtra(ImagesContract.URL, instance.authData.pwcs_url);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        instance.context.startActivity(intent);
        if (appCompatActivity != null) {
            appCompatActivity.finish();
        }
    }

    static /* synthetic */ void lambda$startKycProcess$1(VolleyError volleyError) {
        instance.currentCallbackProgress.onFail(NetworkManager.parseVolleyError(volleyError));
        Log.e("TestSDK", NetworkManager.parseVolleyError(volleyError));
    }

    public static void nfcUpdate(boolean z, Customer customer) {
        Log.e("TestSDK", "NFC update " + z);
        NetworkManager.post(NFC_UPDATE, instance.getNfcUpdateBody(z, customer), new Response.Listener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda6
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                Log.e("TestSDK", "Correcto :" + ((JSONObject) obj).toString());
            }
        }, new Response.ErrorListener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda7
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                Log.e("TestSDK", "Error: " + volleyError.toString());
            }
        });
    }

    public static void onFlowEvent(Customer customer) {
        IdentitySDK.CallbackProgress callbackProgress = instance.currentCallbackProgress;
        if (callbackProgress != null) {
            callbackProgress.onFlowComplete(customer);
        }
    }

    public void startProcess(IdentitySDK.CallbackProgress callbackProgress) {
        SDK sdk = instance;
        sdk.attempts = 0;
        sdk.currentCallbackProgress = callbackProgress;
        sdk.startKycProcess();
    }

    public void closeProcess(String str) {
        if (KycActivity.getInstance() != null) {
            KycActivity.getInstance().finish();
        }
    }

    public void getOperation(String str, final IdentitySDK.CallbackOperation callbackOperation) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth_uuid", str);
            jSONObject.put("apiKey", instance.apiKey);
            NetworkManager.post(OPERATION_URL, jSONObject, new Response.Listener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda2
                @Override // com.android.volley.Response.Listener
                public final void onResponse(Object obj) {
                    SDK.lambda$getOperation$4(callbackOperation, (JSONObject) obj);
                }
            }, new Response.ErrorListener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda3
                @Override // com.android.volley.Response.ErrorListener
                public final void onErrorResponse(VolleyError volleyError) {
                    SDK.lambda$getOperation$5(callbackOperation, volleyError);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$getOperation$4(IdentitySDK.CallbackOperation callbackOperation, JSONObject jSONObject) {
        callbackOperation.onSuccess(new Operation(jSONObject.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)));
        Log.e("TestSDK", jSONObject.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).toString());
    }

    static /* synthetic */ void lambda$getOperation$5(IdentitySDK.CallbackOperation callbackOperation, VolleyError volleyError) {
        callbackOperation.onFail(NetworkManager.parseVolleyError(volleyError));
        Log.e("TestSDK", NetworkManager.parseVolleyError(volleyError));
    }

    private void getProfileConfig() {
        NetworkManager.get(PROFILE_CONFIG_URL, new Response.Listener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) throws JSONException {
                this.f$0.m929lambda$getProfileConfig$6$comtecalisidentitysdkSDK((JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.tecalis.identitysdk.SDK$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                SDK.lambda$getProfileConfig$7(volleyError);
            }
        });
    }

    /* renamed from: lambda$getProfileConfig$6$com-tecalis-identitysdk-SDK, reason: not valid java name */
    /* synthetic */ void m929lambda$getProfileConfig$6$comtecalisidentitysdkSDK(JSONObject jSONObject) throws JSONException {
        try {
            this.profileConfig.put("apiKey", this.apiKey);
            this.profileConfig.put("fcmToken", this.fcmToken);
            this.profileConfig.put("deviceOs", "android");
            this.profileConfig.put("config", jSONObject.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE));
            this.profileConfig.optJSONObject("config").optJSONObject("configuration").optJSONObject("kyc").put("status_post_url", this.webhook);
            this.profileConfig.optJSONObject("config").optJSONObject("configuration").optJSONObject("front").optJSONObject("fallback").optJSONObject("fallback_config").optJSONObject("configuration").optJSONObject("kyc").put("status_post_url", this.webhook);
        } catch (JSONException e) {
            Log.e("SDK", e.getLocalizedMessage());
        }
    }

    private void startKycProcess() {
        startKycProcess(null);
    }

    private JSONObject getNfcBody() {
        try {
            return new JSONObject("{\n    \"apiKey\":\"" + instance.apiKey + "\",\n    \"fcmToken\":\"" + instance.fcmToken + "\",\n    \"deviceOs\":\"android\",\n    \"config\": {\n    \"configuration\": {\n            \"kyc\": {\n                \"excludedDocTypes\": [],\n                \"allowedDocTypes\": [\n                ],\n                \"additionalData\": {\n                    \"signedCertificate\": false\n                },\n                \"status_post_url\": \"" + instance.webhook + "\",\n                \"status_report\": [\n                    \"Verification OK\", \"Verification KO\"\n                ],\n                \"methods\": {\n                    \"ReadMrz\": false,\n                    \"VerifyData\": false,\n                    \"Images\": true,\n                    \"Liveness\": false,\n                    \"FaceMatch\": false,\n                    \"FacialRecognition\": false,\n                    \"Selfie\": false,\n                    \"FraudScoring\": false,\n                    \"ImagesUrl\": false,\n                    \"StorageUpload\": true,\n                    \"Otp\": false,\n                    \"Location\": false,\n                    \"CheckFacesNumber\": false,\n                    \"NfcData\": true\n                },\n                \"fraudScoring\": {\n                    \"aeat\": false,\n                    \"expirationDate\": false,\n                    \"legalAge\": false,\n                    \"photocopyCheck\": false,\n                    \"hologramCheck\": false\n                }\n            }\n        }\n    }\n}");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject getNfcUpdateBody(boolean z, Customer customer) {
        try {
            return new JSONObject("{\n   \"apiKey\":\"" + instance.apiKey + "\",\n   \"auth_uuid\":\"" + instance.authData.auth_uuid + "\",\n   \"token_pwcs\":\"" + instance.authData.token_pwcs + "\",\n   \"status\":\"" + (z ? "Verification OK" : "Verification KO") + "\",\n   \"data\":{\n      \"country_code\":\"" + customer.getCountry_code() + "\",\n      \"identifier\":\"" + customer.getIdentifier() + "\",\n      \"b_year\":\"" + customer.getB_year() + "\",\n      \"b_month\":\"" + customer.getB_month() + "\",\n      \"b_day\":\"" + customer.getB_day() + "\",\n      \"gender\":\"" + customer.getGender() + "\",\n      \"exp_year\":\"" + customer.getExp_year() + "\",\n      \"exp_month\":\"" + customer.getExp_month() + "\",\n      \"exp_day\":\"" + customer.getExp_day() + "\",\n      \"nationality\":\"" + customer.getNationality() + "\",\n      \"sn1\":\"" + customer.getSn1() + "\",\n      \"sn2\":\"" + customer.getSn2() + "\",\n      \"sn3\":\"" + customer.getSn3() + "\",\n      \"n1\":\"" + customer.getN1() + "\",\n      \"n2\":\"" + customer.getN2() + "\",\n      \"n3\":\"" + customer.getN3() + "\",\n      \"n4\":\"" + customer.getN4() + "\",\n      \"doc_type\":\"" + customer.getDoc_type() + "\",\n      \"address\":{\n         \"direction\":\"" + customer.getAddress().getDirection() + "\",\n         \"location\":\"" + customer.getAddress().getLocation() + "\",\n         \"postal_code\":\"" + customer.getAddress().getPostal_code() + "\",\n         \"province\":\"" + customer.getAddress().getProvince() + "\"\n      }\n   },\n   \"imgs\":{\n      \"img\":\"data:image/jpeg;base64," + instance.img + "\",\n      \"img_picture\":\"data:image/jpeg;base64," + instance.img_picture + "\"\n   }\n}");
        } catch (JSONException e) {
            Log.e("TestSDK", e.toString());
            return new JSONObject();
        }
    }

    private JSONObject getKycBody() {
        try {
            return new JSONObject("{\n    \"apiKey\":\"" + instance.apiKey + "\",\n    \"fcmToken\":\"" + instance.fcmToken + "\",\n    \"deviceOs\":\"android\",\n    \"config\": {\n    \"configuration\": {\n            \"kyc\": {\n                \"excludedDocTypes\": [],\n                \"allowedDocTypes\": [\n                    \"ESP_DNI\",\n                    \"ESP_NIE\",\n                    \"PASSPORT\"\n                ],\n                \"additionalData\": {\n                    \"signedCertificate\": false,\n                    \"readAddress\": true\n                },\n                \"status_post_url\": \"" + instance.webhook + "\",\n                \"status_report\": [\n                    \"Verification OK\"\n                ],\n                \"methods\": {\n                    \"ReadMrz\": true,\n                    \"VerifyData\": true,\n                    \"Images\": true,\n                    \"Liveness\": true,\n                    \"FaceMatch\": true,\n                    \"FacialRecognition\": true,\n                    \"Selfie\": false,\n                    \"FraudScoring\": true,\n                    \"ImagesUrl\": false,\n                    \"StorageUpload\": true,\n                    \"Otp\": true,\n                    \"Location\": true,\n                    \"CheckFacesNumber\": true\n                },\n                \"fraudScoring\": {\n                    \"aeat\": true,\n                    \"expirationDate\": true,\n                    \"legalAge\": false,\n                    \"photocopyCheck\": true,\n                    \"hologramCheck\": true\n                }\n            },\n            \"front\": {\n                \"skin\": \"dark\",\n                \"iccid\": false,\n                \"msisdn\": false,\n                \"barcode_min\": false,\n                \"borders\": true,\n                \"auditoria\": false,\n                \"css_url\": false,\n                \"title_kyc\": \"KYC\",\n                \"headless_barcode\": false,\n                \"wait_after_kyc_success\": true,\n                \"prioridad_interrupcion\": \"postergado\",\n                \"borders_percentage\": 50,\n                \"borders_width\": 50,\n                \"video_mode\": \"native\",\n                \"final_imprimible\": false,\n                \"mirror_mode_pc\": false,\n                \"kyc_mode\": \"auto\",\n                \"liveness_guidance_mode\": \"smile\",\n                \"location_config\": \"optional\",\n                \"adapt_detector_to_passport\": true,\n                \"no-spinner\": false,\n                \"default_lang\": \"en\",\n                \"force_lang\": \"es\",\n                \"retries_before_manual_pc\": 1,\n                \"retries_before_manual_others\": 3,\n                \"logs\": false,\n                \"redirect\": false,\n                \"accept_manual_text\": \"\",\n                \"fallback\": {\n                    \"mrz_timeout_sec\": 80,\n                    \"anverso_timeout_sec\": 80,\n                    \"facial_recognition_fallback\": true,\n                    \"fallback_profile\": null,\n                    \"fallback_config\": { \n                        \"configuration\": {\n                            \"kyc\": {\n                                \"status_post_url\": \"" + instance.webhook + "\",\n                                \"status_report\": [\n                                    \"Verification OK\",\n                                        \"Verification KO\"\n                                ],\n                                \"manualMethods\": {\n                                    \"idDocument\": true,\n                                    \"ownerPictures\": true,\n                                    \"video\": false,\n                                    \"additionalDocumentation\": false\n                                },\n                                \"excludedDocTypes\": [],\n                                \"allowedDocTypes\": [\n                                    \"ESP_DNI\",\n                                    \"ESP_NIE\",\n                                    \"PASSPORT\"\n                                ],\n                                \"fraudScoring\": {\n                                    \"aeat\": false,\n                                    \"expirationDate\": false,\n                                    \"legalAge\": false,\n                                    \"photocopyCheck\": false,\n                                    \"hologramCheck\": false\n                                }\n                            },\n                            \"platform\": {\n                                \"verification_company\": false,\n                                \"sla\": 600000,\n                                \"video_stream\": false,\n                                \"report_pending_verification\": [\n                                   \"rafael.grimm@tecalis.com\",\n                                   \"alberto.campos@tecalis.com\",\n                                   \"support@tecalis.com\"\n                                ]                            },\n                            \"front\": {\n                                \"skin\": \"dark\",\n                                \"borders\": true,\n                                \"css_url\": false,\n                                \"title_kyc\": \"KYC\",\n                                \"wait_after_kyc_success\": true,\n                                \"camera_label_first\": \"Live camera\",\n                                \"prioridad_interrupcion\": \"postergado\",\n                                \"max_dni_width\": 800,\n                                \"borders_percentage\": 50,\n                                \"borders_width\": 50,\n                                \"video_mode\": \"native\",\n                                \"mirror_mode_pc\": false,\n                                \"kyc_mode\": \"manual\",\n                                \"liveness_guidance_mode\": \"smile\",\n                                \"location_config\": \"optional\",\n                                \"adapt_detector_to_passport\": true,\n                                \"redirect\": false,\n                                \"no-spinner\": false,\n                                \"default_lang\": \"en\",\n                                \"force_lang\": \"es\",\n                                \"retries_before_manual_pc\": 1,\n                                \"retries_before_manual_others\": 3,\n                                \"accept_manual_text\": \"Estamos viendo que estás teniendo problemas en la verificación automática. Vamos a proceder a tomarte unas fotos del documento y de tu rostro para que un agente pueda validarlo\"\n                            }\n                        }\n                    }\n                }\n            }\n        }\n    }\n}");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
