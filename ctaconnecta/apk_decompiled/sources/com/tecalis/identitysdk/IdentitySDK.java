package com.tecalis.identitysdk;

import android.content.Context;
import com.tecalis.identitysdk.models.Customer;
import com.tecalis.identitysdk.models.Operation;

/* loaded from: classes5.dex */
public class IdentitySDK {
    private static SDK sdk;

    public interface CallbackOperation {
        void onFail(String str);

        void onSuccess(Operation operation);
    }

    public interface CallbackProgress {
        void getAuthUuid(String str);

        void onFail(String str);

        void onFlowComplete(Customer customer);

        void onSuccess();
    }

    public enum Environment {
        INTEGRATION,
        PRODUCTION
    }

    public static void init(Context context, String str, String str2, String str3, String str4) {
        init(context, str, str2, str3, str4, Environment.INTEGRATION);
    }

    public static void init(Context context, String str, String str2, String str3, String str4, Environment environment) {
        if (sdk == null) {
            sdk = SDK.init(context, str, str2, str3, str4, environment);
        }
    }

    public static void startProcess(CallbackProgress callbackProgress) {
        sdk.startProcess(callbackProgress);
    }

    public static void closeProcess(String str) {
        sdk.closeProcess(str);
    }

    public static void getOperation(String str, CallbackOperation callbackOperation) {
        sdk.getOperation(str, callbackOperation);
    }
}
