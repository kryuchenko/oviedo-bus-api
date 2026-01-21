package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class FirebasePerfTraceValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final TraceMetric traceMetric;

    private boolean isValidCounterValue(Long l) {
        return l != null;
    }

    FirebasePerfTraceValidator(TraceMetric traceMetric) {
        this.traceMetric = traceMetric;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (!isValidTrace(this.traceMetric, 0)) {
            logger.warn("Invalid Trace:" + this.traceMetric.getName());
            return false;
        }
        if (!hasCounters(this.traceMetric) || areCountersValid(this.traceMetric)) {
            return true;
        }
        logger.warn("Invalid Counters for Trace:" + this.traceMetric.getName());
        return false;
    }

    private boolean hasCounters(TraceMetric traceMetric) {
        if (traceMetric.getCountersCount() > 0) {
            return true;
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (it.next().getCountersCount() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean areCountersValid(TraceMetric traceMetric) {
        return areCountersValid(traceMetric, 0);
    }

    private boolean areCountersValid(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry<String, Long> entry : traceMetric.getCountersMap().entrySet()) {
            if (!isValidCounterId(entry.getKey())) {
                logger.warn("invalid CounterId:" + entry.getKey());
                return false;
            }
            if (!isValidCounterValue(entry.getValue())) {
                logger.warn("invalid CounterValue:" + entry.getValue());
                return false;
            }
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (!areCountersValid(it.next(), i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isScreenTrace(TraceMetric traceMetric) {
        return traceMetric.getName().startsWith(Constants.SCREEN_TRACE_PREFIX);
    }

    private boolean isValidScreenTrace(TraceMetric traceMetric) {
        Long l = traceMetric.getCountersMap().get(Constants.CounterNames.FRAMES_TOTAL.toString());
        return l != null && l.compareTo((Long) 0L) > 0;
    }

    private boolean isValidTrace(TraceMetric traceMetric, int i) {
        if (traceMetric == null) {
            logger.warn("TraceMetric is null");
            return false;
        }
        if (i > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        if (!isValidTraceId(traceMetric.getName())) {
            logger.warn("invalid TraceId:" + traceMetric.getName());
            return false;
        }
        if (!isValidTraceDuration(traceMetric)) {
            logger.warn("invalid TraceDuration:" + traceMetric.getDurationUs());
            return false;
        }
        if (!traceMetric.hasClientStartTimeUs()) {
            logger.warn("clientStartTimeUs is null.");
            return false;
        }
        if (isScreenTrace(traceMetric) && !isValidScreenTrace(traceMetric)) {
            logger.warn("non-positive totalFrames in screen trace " + traceMetric.getName());
            return false;
        }
        Iterator<TraceMetric> it = traceMetric.getSubtracesList().iterator();
        while (it.hasNext()) {
            if (!isValidTrace(it.next(), i + 1)) {
                return false;
            }
        }
        return areAllAttributesValid(traceMetric.getCustomAttributesMap());
    }

    private boolean isValidTraceId(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        return !strTrim.isEmpty() && strTrim.length() <= 100;
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        return traceMetric != null && traceMetric.getDurationUs() > 0;
    }

    private boolean isValidCounterId(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            logger.warn("counterId is empty");
            return false;
        }
        if (strTrim.length() <= 100) {
            return true;
        }
        logger.warn("counterId exceeded max length 100");
        return false;
    }

    private boolean areAllAttributesValid(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                validateAttribute(entry.getKey(), entry.getValue());
            } catch (IllegalArgumentException e) {
                logger.warn(e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }
}
