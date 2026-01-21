package com.google.mlkit.vision.common.internal;

import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class MultiFlavorDetectorCreator {
    private final Map<Class<? extends DetectorOptions<?>>, Provider<? extends DetectorCreator<?, ?>>> zza = new HashMap();

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public interface DetectorCreator<ResultT, OptionsT extends DetectorOptions<ResultT>> {
        MobileVisionBase<ResultT> create(OptionsT optionst);
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public interface DetectorOptions<ResultT> {
    }

    public static synchronized MultiFlavorDetectorCreator getInstance() {
        return (MultiFlavorDetectorCreator) MlKitContext.getInstance().get(MultiFlavorDetectorCreator.class);
    }

    MultiFlavorDetectorCreator(Set<Registration> set) {
        for (Registration registration : set) {
            this.zza.put(registration.zza(), registration.zzb());
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    public static class Registration {
        private final Class<? extends DetectorOptions<?>> zza;
        private final Provider<? extends DetectorCreator<?, ?>> zzb;

        /* JADX WARN: Multi-variable type inference failed */
        public <ResultT, OptionsT extends DetectorOptions<ResultT>> Registration(Class<? extends OptionsT> cls, Provider<? extends DetectorCreator<ResultT, OptionsT>> provider) {
            this.zza = cls;
            this.zzb = provider;
        }

        final Class<? extends DetectorOptions<?>> zza() {
            return this.zza;
        }

        final Provider<? extends DetectorCreator<?, ?>> zzb() {
            return this.zzb;
        }
    }

    public <ResultT, OptionsT extends DetectorOptions<ResultT>> MobileVisionBase<ResultT> create(OptionsT optionst) {
        return (MobileVisionBase<ResultT>) this.zza.get(optionst.getClass()).get().create(optionst);
    }
}
