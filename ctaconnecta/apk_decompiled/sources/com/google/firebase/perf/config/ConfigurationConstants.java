package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class ConfigurationConstants {
    ConfigurationConstants() {
    }

    protected static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        private CollectionDeactivated() {
        }

        protected static synchronized CollectionDeactivated getInstance() {
            if (instance == null) {
                instance = new CollectionDeactivated();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return false;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }
    }

    protected static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        private CollectionEnabled() {
        }

        protected static synchronized CollectionEnabled getInstance() {
            if (instance == null) {
                instance = new CollectionEnabled();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return true;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }
    }

    protected static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        protected SdkEnabled() {
        }

        protected static synchronized SdkEnabled getInstance() {
            if (instance == null) {
                instance = new SdkEnabled();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return true;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }
    }

    protected static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        protected SdkDisabledVersions() {
        }

        protected static synchronized SdkDisabledVersions getInstance() {
            if (instance == null) {
                instance = new SdkDisabledVersions();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return "";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }
    }

    protected static final class TraceSamplingRate extends ConfigurationFlag<Double> {
        private static TraceSamplingRate instance;

        private TraceSamplingRate() {
        }

        protected static synchronized TraceSamplingRate getInstance() {
            if (instance == null) {
                instance = new TraceSamplingRate();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }
    }

    protected static final class NetworkRequestSamplingRate extends ConfigurationFlag<Double> {
        private static NetworkRequestSamplingRate instance;

        private NetworkRequestSamplingRate() {
        }

        protected static synchronized NetworkRequestSamplingRate getInstance() {
            if (instance == null) {
                instance = new NetworkRequestSamplingRate();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(1.0d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            if (instance == null) {
                instance = new SessionsCpuCaptureFrequencyForegroundMs();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            if (instance == null) {
                instance = new SessionsCpuCaptureFrequencyBackgroundMs();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            if (instance == null) {
                instance = new SessionsMemoryCaptureFrequencyForegroundMs();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 100L;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefaultOnRcFetchFail() {
            return Long.valueOf(getDefault().longValue() * 3);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        public static synchronized SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            if (instance == null) {
                instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 0L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }
    }

    protected static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        private SessionsMaxDurationMinutes() {
        }

        public static synchronized SessionsMaxDurationMinutes getInstance() {
            if (instance == null) {
                instance = new SessionsMaxDurationMinutes();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 240L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }
    }

    protected static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        private TraceEventCountForeground() {
        }

        public static synchronized TraceEventCountForeground getInstance() {
            if (instance == null) {
                instance = new TraceEventCountForeground();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 300L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }
    }

    protected static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        private TraceEventCountBackground() {
        }

        public static synchronized TraceEventCountBackground getInstance() {
            if (instance == null) {
                instance = new TraceEventCountBackground();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 30L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }
    }

    protected static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        private NetworkEventCountForeground() {
        }

        public static synchronized NetworkEventCountForeground getInstance() {
            if (instance == null) {
                instance = new NetworkEventCountForeground();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 700L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }
    }

    protected static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        private NetworkEventCountBackground() {
        }

        public static synchronized NetworkEventCountBackground getInstance() {
            if (instance == null) {
                instance = new NetworkEventCountBackground();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 70L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }
    }

    protected static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        private RateLimitSec() {
        }

        public static synchronized RateLimitSec getInstance() {
            if (instance == null) {
                instance = new RateLimitSec();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Long getDefault() {
            return 600L;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }
    }

    protected static final class SessionsSamplingRate extends ConfigurationFlag<Double> {
        private static SessionsSamplingRate instance;

        private SessionsSamplingRate() {
        }

        public static synchronized SessionsSamplingRate getInstance() {
            if (instance == null) {
                instance = new SessionsSamplingRate();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.01d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefaultOnRcFetchFail() {
            return Double.valueOf(getDefault().doubleValue() / 1000.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }
    }

    protected static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants.LogSourceName.1
            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }
        });
        private static LogSourceName instance;

        private LogSourceName() {
        }

        public static synchronized LogSourceName getInstance() {
            if (instance == null) {
                instance = new LogSourceName();
            }
            return instance;
        }

        protected static String getLogSourceName(long j) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j));
        }

        protected static boolean isLogSourceKnown(long j) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }
    }

    protected static final class FragmentSamplingRate extends ConfigurationFlag<Double> {
        private static FragmentSamplingRate instance;

        private FragmentSamplingRate() {
        }

        protected static synchronized FragmentSamplingRate getInstance() {
            if (instance == null) {
                instance = new FragmentSamplingRate();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Double getDefault() {
            return Double.valueOf(0.0d);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_fragment_sampling_rate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.FragmentSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "fragment_sampling_percentage";
        }
    }

    protected static final class ExperimentTTID extends ConfigurationFlag<Boolean> {
        private static ExperimentTTID instance;

        private ExperimentTTID() {
        }

        protected static synchronized ExperimentTTID getInstance() {
            if (instance == null) {
                instance = new ExperimentTTID();
            }
            return instance;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public Boolean getDefault() {
            return false;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_experiment_app_start_ttid";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.ExperimentTTID";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "experiment_app_start_ttid";
        }
    }
}
