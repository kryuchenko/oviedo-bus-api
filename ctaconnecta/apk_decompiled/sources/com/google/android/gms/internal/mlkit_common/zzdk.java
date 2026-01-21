package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public final class zzdk {
    public static zzal zza(int i) {
        switch (i) {
            case 0:
                return zzal.NO_ERROR;
            case 1:
                return zzal.INCOMPATIBLE_INPUT;
            case 2:
                return zzal.INCOMPATIBLE_OUTPUT;
            case 3:
                return zzal.INCOMPATIBLE_TFLITE_VERSION;
            case 4:
                return zzal.MISSING_OP;
            case 5:
                return zzal.DATA_TYPE_ERROR;
            case 6:
                return zzal.TFLITE_INTERNAL_ERROR;
            case 7:
                return zzal.TFLITE_UNKNOWN_ERROR;
            case 8:
                return zzal.TIME_OUT_FETCHING_MODEL_METADATA;
            case 9:
                return zzal.MODEL_NOT_DOWNLOADED;
            case 10:
                return zzal.URI_EXPIRED;
            case 11:
                return zzal.NO_NETWORK_CONNECTION;
            case 12:
                return zzal.METERED_NETWORK;
            case 13:
                return zzal.DOWNLOAD_FAILED;
            case 14:
                return zzal.MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS;
            case 15:
                return zzal.MODEL_INFO_DOWNLOAD_NO_HASH;
            case 16:
                return zzal.MODEL_INFO_DOWNLOAD_CONNECTION_FAILED;
            case 17:
                return zzal.NO_VALID_MODEL;
            case 18:
                return zzal.LOCAL_MODEL_INVALID;
            case 19:
                return zzal.REMOTE_MODEL_INVALID;
            case 20:
                return zzal.REMOTE_MODEL_LOADER_ERROR;
            case 21:
                return zzal.REMOTE_MODEL_LOADER_LOADS_NO_MODEL;
            case 22:
                return zzal.SMART_REPLY_LANG_ID_DETECTAION_FAILURE;
            case 23:
                return zzal.MODEL_NOT_REGISTERED;
            case 24:
                return zzal.MODEL_TYPE_MISUSE;
            case 25:
                return zzal.MODEL_HASH_MISMATCH;
            default:
                return zzal.UNKNOWN_ERROR;
        }
    }
}
