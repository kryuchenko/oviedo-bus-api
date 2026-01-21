package com.google.firebase.sessions.settings;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jmrtd.cbeff.ISO781611;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteSettings.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {125, 128, ISO781611.CREATION_DATE_AND_TIME_TAG, 133, 134, 136}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: classes4.dex */
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0163, code lost:
    
        if (r13.updateSessionCacheDuration(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a7, code lost:
    
        if (r12.this$0.getSettingsCache().updateSessionCacheUpdatedTime(kotlin.coroutines.jvm.internal.Boxing.boxLong(java.lang.System.currentTimeMillis()), r12) == r4) goto L66;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
    /* JADX WARN: Type inference failed for: r13v13, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Boolean bool;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Integer num;
        Double d;
        Integer num2;
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject = (JSONObject) this.L$0;
                Log.d(RemoteSettings.TAG, "Fetched settings: " + jSONObject);
                Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
                if (jSONObject.has("app_quality")) {
                    Object obj2 = jSONObject.get("app_quality");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    try {
                        bool = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                        try {
                            if (jSONObject2.has("sampling_rate")) {
                                objectRef6.element = (Double) jSONObject2.get("sampling_rate");
                            }
                            if (jSONObject2.has("session_timeout_seconds")) {
                                objectRef.element = (Integer) jSONObject2.get("session_timeout_seconds");
                            }
                            if (jSONObject2.has("cache_duration")) {
                                objectRef7.element = (Integer) jSONObject2.get("cache_duration");
                            }
                        } catch (JSONException e) {
                            e = e;
                            Log.e(RemoteSettings.TAG, "Error parsing the configs remotely fetched: ", e);
                            if (bool == null) {
                            }
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        bool = null;
                    }
                } else {
                    bool = null;
                }
                if (bool == null) {
                    RemoteSettings remoteSettings = this.this$0;
                    bool.booleanValue();
                    SettingsCache settingsCache = remoteSettings.getSettingsCache();
                    this.L$0 = objectRef6;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef7;
                    this.label = 1;
                    if (settingsCache.updateSettingsEnabled(bool, this) != coroutine_suspended) {
                        objectRef4 = objectRef6;
                        objectRef5 = objectRef;
                        objectRef3 = objectRef7;
                        objectRef = objectRef5;
                        objectRef2 = objectRef4;
                        num = (Integer) objectRef.element;
                        if (num != null) {
                            RemoteSettings remoteSettings2 = this.this$0;
                            num.intValue();
                            SettingsCache settingsCache2 = remoteSettings2.getSettingsCache();
                            Integer num3 = (Integer) objectRef.element;
                            this.L$0 = objectRef2;
                            this.L$1 = objectRef3;
                            this.L$2 = null;
                            this.label = 2;
                            if (settingsCache2.updateSessionRestartTimeout(num3, this) != coroutine_suspended) {
                            }
                        }
                        d = (Double) objectRef2.element;
                        if (d != null) {
                            RemoteSettings remoteSettings3 = this.this$0;
                            d.doubleValue();
                            SettingsCache settingsCache3 = remoteSettings3.getSettingsCache();
                            Double d2 = (Double) objectRef2.element;
                            this.L$0 = objectRef3;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 3;
                            if (settingsCache3.updateSamplingRate(d2, this) != coroutine_suspended) {
                            }
                        }
                        num2 = (Integer) objectRef3.element;
                        if (num2 == null) {
                            unit = null;
                            if (unit == null) {
                                SettingsCache settingsCache4 = this.this$0.getSettingsCache();
                                Integer numBoxInt = Boxing.boxInt(86400);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 5;
                                if (settingsCache4.updateSessionCacheDuration(numBoxInt, this) != coroutine_suspended) {
                                }
                            }
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 6;
                            break;
                        } else {
                            RemoteSettings remoteSettings4 = this.this$0;
                            num2.intValue();
                            SettingsCache settingsCache5 = remoteSettings4.getSettingsCache();
                            Integer num4 = (Integer) objectRef3.element;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 4;
                            break;
                        }
                    }
                    return coroutine_suspended;
                }
                objectRef2 = objectRef6;
                objectRef3 = objectRef7;
                num = (Integer) objectRef.element;
                if (num != null) {
                }
                d = (Double) objectRef2.element;
                if (d != null) {
                }
                num2 = (Integer) objectRef3.element;
                if (num2 == null) {
                }
            case 1:
                objectRef3 = (Ref.ObjectRef) this.L$2;
                objectRef5 = (Ref.ObjectRef) this.L$1;
                objectRef4 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef5;
                objectRef2 = objectRef4;
                num = (Integer) objectRef.element;
                if (num != null) {
                }
                d = (Double) objectRef2.element;
                if (d != null) {
                }
                num2 = (Integer) objectRef3.element;
                if (num2 == null) {
                }
                break;
            case 2:
                objectRef3 = (Ref.ObjectRef) this.L$1;
                objectRef2 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                d = (Double) objectRef2.element;
                if (d != null) {
                }
                num2 = (Integer) objectRef3.element;
                if (num2 == null) {
                }
                break;
            case 3:
                objectRef3 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                num2 = (Integer) objectRef3.element;
                if (num2 == null) {
                }
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                unit = Unit.INSTANCE;
                if (unit == null) {
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                break;
            case 5:
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 6;
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
