package com.palmatools.sdk;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iecisa.ctausuario.utils.Constants;
import com.palmatools.sdk.NfcHandle;
import com.palmatools.sdk.model.ClsApduMessage;
import com.palmatools.sdk.model.ClsErrorMessage;
import com.palmatools.sdk.model.ClsReaderMessage;
import com.palmatools.sdk.model.ClsTextMessage;
import com.palmatools.sdk.repositories.CardRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NfcHandle.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rJ,\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/palmatools/sdk/NfcHandle;", "", "apiBaseUrl", "", "(Ljava/lang/String;)V", "callback", "Lcom/palmatools/sdk/NfcHandle$Callback;", "callbacksEnabled", "", "lastReaderMessage", "Lcom/palmatools/sdk/model/ClsReaderMessage;", "sessionId", "taskHeaders", "", "taskMethod", "Lcom/palmatools/sdk/NfcHandle$Method;", "taskName", "taskParams", "setCallback", "", "mobilibListener", "setHeaders", "headers", "setTaskname", "taskname", FirebaseAnalytics.Param.METHOD, "args", "startForeGroundDispatch", "stopForeGroundDispatch", "Callback", "Method", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NfcHandle {
    private final String apiBaseUrl;
    private Callback callback;
    private boolean callbacksEnabled;
    private ClsReaderMessage lastReaderMessage;
    private String sessionId;
    private Map<String, String> taskHeaders;
    private Method taskMethod;
    private String taskName;
    private Map<String, String> taskParams;

    /* compiled from: NfcHandle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/palmatools/sdk/NfcHandle$Callback;", "", "onError", "", NotificationCompat.CATEGORY_EVENT, "Lcom/palmatools/sdk/model/ClsErrorMessage;", "onPreExecute", "onProgressUpdate", Constants.Notification.DATA_MESSAGE, "Lcom/palmatools/sdk/model/ClsApduMessage;", "onSuccess", "reader", "Lcom/palmatools/sdk/model/ClsTextMessage;", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onError(ClsErrorMessage event);

        void onPreExecute();

        void onProgressUpdate(ClsApduMessage message);

        void onSuccess(ClsTextMessage reader);
    }

    /* compiled from: NfcHandle.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/palmatools/sdk/NfcHandle$Method;", "", "(Ljava/lang/String;I)V", "GET", "POST", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Method {
        GET,
        POST
    }

    public NfcHandle(String apiBaseUrl) {
        Intrinsics.checkNotNullParameter(apiBaseUrl, "apiBaseUrl");
        this.apiBaseUrl = apiBaseUrl;
        this.taskHeaders = new HashMap();
        this.taskParams = new HashMap();
        this.taskMethod = Method.GET;
    }

    public final void setCallback(Callback mobilibListener) {
        Intrinsics.checkNotNullParameter(mobilibListener, "mobilibListener");
        this.callback = mobilibListener;
    }

    public final void setHeaders(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.taskHeaders = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTaskname$default(NfcHandle nfcHandle, String str, Method method, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = new HashMap();
        }
        nfcHandle.setTaskname(str, method, map);
    }

    public final void setTaskname(String taskname, Method method, Map<String, String> args) {
        Intrinsics.checkNotNullParameter(taskname, "taskname");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        this.taskName = taskname;
        this.taskParams = args;
        this.taskMethod = method;
    }

    public final void startForeGroundDispatch() {
        String str = this.taskName;
        if (str != null) {
            this.callbacksEnabled = true;
            Callback callback = this.callback;
            if (callback != null) {
                callback.onPreExecute();
            }
            if (this.sessionId == null) {
                this.sessionId = new SimpleDateFormat("ddMMyyHHmmss", Locale.getDefault()).format(new Date());
            }
            String str2 = this.sessionId;
            if (str2 != null) {
                if (this.taskMethod == Method.GET) {
                    new CardRepository(this.apiBaseUrl, this.taskHeaders).getTask(str, str2, this.taskParams, new Function4<ClsApduMessage, ClsReaderMessage, ClsTextMessage, ClsErrorMessage, Unit>() { // from class: com.palmatools.sdk.NfcHandle$startForeGroundDispatch$1$1$1
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(ClsApduMessage clsApduMessage, ClsReaderMessage clsReaderMessage, ClsTextMessage clsTextMessage, ClsErrorMessage clsErrorMessage) {
                            invoke2(clsApduMessage, clsReaderMessage, clsTextMessage, clsErrorMessage);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ClsApduMessage clsApduMessage, ClsReaderMessage clsReaderMessage, ClsTextMessage clsTextMessage, ClsErrorMessage clsErrorMessage) {
                            NfcHandle.Callback callback2;
                            NfcHandle.Callback callback3;
                            NfcHandle.Callback callback4;
                            this.this$0.lastReaderMessage = clsReaderMessage;
                            if (clsApduMessage != null) {
                                NfcHandle nfcHandle = this.this$0;
                                if (!nfcHandle.callbacksEnabled || (callback4 = nfcHandle.callback) == null) {
                                    return;
                                }
                                callback4.onProgressUpdate(clsApduMessage);
                                return;
                            }
                            NfcHandle nfcHandle2 = this.this$0;
                            nfcHandle2.sessionId = null;
                            if (clsTextMessage != null) {
                                if (!nfcHandle2.callbacksEnabled || (callback3 = nfcHandle2.callback) == null) {
                                    return;
                                }
                                callback3.onSuccess(clsTextMessage);
                                return;
                            }
                            if (clsErrorMessage == null || !nfcHandle2.callbacksEnabled || (callback2 = nfcHandle2.callback) == null) {
                                return;
                            }
                            callback2.onError(clsErrorMessage);
                        }
                    });
                    return;
                }
                Map<String, String> mutableMap = MapsKt.toMutableMap(this.taskParams);
                ClsReaderMessage clsReaderMessage = this.lastReaderMessage;
                if (clsReaderMessage != null) {
                    mutableMap.put("ClsReaderMessageId", String.valueOf(clsReaderMessage.getClsReaderMessageId() + 1));
                }
                new CardRepository(this.apiBaseUrl, this.taskHeaders).postTask(str, str2, mutableMap, new Function4<ClsApduMessage, ClsReaderMessage, ClsTextMessage, ClsErrorMessage, Unit>() { // from class: com.palmatools.sdk.NfcHandle$startForeGroundDispatch$1$1$3
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(ClsApduMessage clsApduMessage, ClsReaderMessage clsReaderMessage2, ClsTextMessage clsTextMessage, ClsErrorMessage clsErrorMessage) {
                        invoke2(clsApduMessage, clsReaderMessage2, clsTextMessage, clsErrorMessage);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ClsApduMessage clsApduMessage, ClsReaderMessage clsReaderMessage2, ClsTextMessage clsTextMessage, ClsErrorMessage clsErrorMessage) {
                        NfcHandle.Callback callback2;
                        NfcHandle.Callback callback3;
                        NfcHandle.Callback callback4;
                        if (clsApduMessage != null) {
                            NfcHandle nfcHandle = this.this$0;
                            nfcHandle.lastReaderMessage = clsReaderMessage2;
                            if (!nfcHandle.callbacksEnabled || (callback4 = nfcHandle.callback) == null) {
                                return;
                            }
                            callback4.onProgressUpdate(clsApduMessage);
                            return;
                        }
                        NfcHandle nfcHandle2 = this.this$0;
                        nfcHandle2.sessionId = null;
                        if (clsTextMessage != null) {
                            if (!nfcHandle2.callbacksEnabled || (callback3 = nfcHandle2.callback) == null) {
                                return;
                            }
                            callback3.onSuccess(clsTextMessage);
                            return;
                        }
                        if (clsErrorMessage == null || !nfcHandle2.callbacksEnabled || (callback2 = nfcHandle2.callback) == null) {
                            return;
                        }
                        callback2.onError(clsErrorMessage);
                    }
                });
            }
        }
    }

    public final void stopForeGroundDispatch() {
        this.callbacksEnabled = false;
    }
}
