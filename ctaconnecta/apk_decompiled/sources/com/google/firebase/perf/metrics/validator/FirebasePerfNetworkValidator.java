package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLAllowlist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

/* loaded from: classes4.dex */
final class FirebasePerfNetworkValidator extends PerfMetricValidator {
    private static final int EMPTY_PORT = -1;
    private static final String HTTPS = "https";
    private static final String HTTP_SCHEMA = "http";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Context appContext;
    private final NetworkRequestMetric networkMetric;

    private boolean isValidHttpResponseCode(int i) {
        return i > 0;
    }

    private boolean isValidPayload(long j) {
        return j >= 0;
    }

    private boolean isValidPort(int i) {
        return i == -1 || i > 0;
    }

    private boolean isValidTime(long j) {
        return j >= 0;
    }

    private boolean isValidUserInfo(String str) {
        return str == null;
    }

    FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context) {
        this.appContext = context;
        this.networkMetric = networkRequestMetric;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (isEmptyUrl(this.networkMetric.getUrl())) {
            logger.warn("URL is missing:" + this.networkMetric.getUrl());
            return false;
        }
        URI resultUrl = getResultUrl(this.networkMetric.getUrl());
        if (resultUrl == null) {
            logger.warn("URL cannot be parsed");
            return false;
        }
        if (!isAllowlisted(resultUrl, this.appContext)) {
            logger.warn("URL fails allowlist rule: " + resultUrl);
            return false;
        }
        if (!isValidHost(resultUrl.getHost())) {
            logger.warn("URL host is null or invalid");
            return false;
        }
        if (!isValidScheme(resultUrl.getScheme())) {
            logger.warn("URL scheme is null or invalid");
            return false;
        }
        if (!isValidUserInfo(resultUrl.getUserInfo())) {
            logger.warn("URL user info is null");
            return false;
        }
        if (!isValidPort(resultUrl.getPort())) {
            logger.warn("URL port is less than or equal to 0");
            return false;
        }
        if (!isValidHttpMethod(this.networkMetric.hasHttpMethod() ? this.networkMetric.getHttpMethod() : null)) {
            logger.warn("HTTP Method is null or invalid: " + this.networkMetric.getHttpMethod());
            return false;
        }
        if (this.networkMetric.hasHttpResponseCode() && !isValidHttpResponseCode(this.networkMetric.getHttpResponseCode())) {
            logger.warn("HTTP ResponseCode is a negative value:" + this.networkMetric.getHttpResponseCode());
            return false;
        }
        if (this.networkMetric.hasRequestPayloadBytes() && !isValidPayload(this.networkMetric.getRequestPayloadBytes())) {
            logger.warn("Request Payload is a negative value:" + this.networkMetric.getRequestPayloadBytes());
            return false;
        }
        if (this.networkMetric.hasResponsePayloadBytes() && !isValidPayload(this.networkMetric.getResponsePayloadBytes())) {
            logger.warn("Response Payload is a negative value:" + this.networkMetric.getResponsePayloadBytes());
            return false;
        }
        if (!this.networkMetric.hasClientStartTimeUs() || this.networkMetric.getClientStartTimeUs() <= 0) {
            logger.warn("Start time of the request is null, or zero, or a negative value:" + this.networkMetric.getClientStartTimeUs());
            return false;
        }
        if (this.networkMetric.hasTimeToRequestCompletedUs() && !isValidTime(this.networkMetric.getTimeToRequestCompletedUs())) {
            logger.warn("Time to complete the request is a negative value:" + this.networkMetric.getTimeToRequestCompletedUs());
            return false;
        }
        if (this.networkMetric.hasTimeToResponseInitiatedUs() && !isValidTime(this.networkMetric.getTimeToResponseInitiatedUs())) {
            logger.warn("Time from the start of the request to the start of the response is null or a negative value:" + this.networkMetric.getTimeToResponseInitiatedUs());
            return false;
        }
        if (!this.networkMetric.hasTimeToResponseCompletedUs() || this.networkMetric.getTimeToResponseCompletedUs() <= 0) {
            logger.warn("Time from the start of the request to the end of the response is null, negative or zero:" + this.networkMetric.getTimeToResponseCompletedUs());
            return false;
        }
        if (this.networkMetric.hasHttpResponseCode()) {
            return true;
        }
        logger.warn("Did not receive a HTTP Response Code");
        return false;
    }

    private boolean isEmptyUrl(String str) {
        return isBlank(str);
    }

    private URI getResultUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            logger.warn("getResultUrl throws exception %s", e.getMessage());
            return null;
        }
    }

    private boolean isAllowlisted(URI uri, Context context) {
        if (uri == null) {
            return false;
        }
        return URLAllowlist.isURLAllowlisted(uri, context);
    }

    private boolean isValidHost(String str) {
        return (str == null || isBlank(str) || str.length() > 255) ? false : true;
    }

    private boolean isValidScheme(String str) {
        if (str == null) {
            return false;
        }
        return HTTP_SCHEMA.equalsIgnoreCase(str) || HTTPS.equalsIgnoreCase(str);
    }

    boolean isValidHttpMethod(NetworkRequestMetric.HttpMethod httpMethod) {
        return (httpMethod == null || httpMethod == NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) ? false : true;
    }

    private boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
