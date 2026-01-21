package com.google.api.client.googleapis.media;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.ByteStreams;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class MediaHttpUploader {
    public static final String CONTENT_LENGTH_HEADER = "X-Upload-Content-Length";
    public static final String CONTENT_TYPE_HEADER = "X-Upload-Content-Type";
    public static final int DEFAULT_CHUNK_SIZE = 10485760;
    private static final int KB = 1024;
    static final int MB = 1048576;
    public static final int MINIMUM_CHUNK_SIZE = 262144;
    private Byte cachedByte;
    private InputStream contentInputStream;
    private int currentChunkLength;
    private HttpRequest currentRequest;
    private byte[] currentRequestContentBuffer;
    private boolean directUploadEnabled;
    private boolean disableGZipContent;
    private boolean isMediaContentLengthCalculated;
    private final AbstractInputStreamContent mediaContent;
    private long mediaContentLength;
    private HttpContent metadata;
    private MediaHttpUploaderProgressListener progressListener;
    private final HttpRequestFactory requestFactory;
    private long totalBytesClientSent;
    private long totalBytesServerReceived;
    private final HttpTransport transport;
    private UploadState uploadState = UploadState.NOT_STARTED;
    private String initiationRequestMethod = "POST";
    private HttpHeaders initiationHeaders = new HttpHeaders();
    String mediaContentLengthStr = "*";
    private int chunkSize = DEFAULT_CHUNK_SIZE;
    Sleeper sleeper = Sleeper.DEFAULT;

    public enum UploadState {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpUploader(AbstractInputStreamContent abstractInputStreamContent, HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.mediaContent = (AbstractInputStreamContent) Preconditions.checkNotNull(abstractInputStreamContent);
        this.transport = (HttpTransport) Preconditions.checkNotNull(httpTransport);
        this.requestFactory = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public HttpResponse upload(GenericUrl genericUrl) throws IOException {
        Preconditions.checkArgument(this.uploadState == UploadState.NOT_STARTED);
        if (this.directUploadEnabled) {
            return directUpload(genericUrl);
        }
        return resumableUpload(genericUrl);
    }

    private HttpResponse directUpload(GenericUrl genericUrl) throws IOException {
        updateStateAndNotifyListener(UploadState.MEDIA_IN_PROGRESS);
        HttpContent contentParts = this.mediaContent;
        if (this.metadata != null) {
            contentParts = new MultipartContent().setContentParts(Arrays.asList(this.metadata, this.mediaContent));
            genericUrl.put("uploadType", "multipart");
        } else {
            genericUrl.put("uploadType", "media");
        }
        HttpRequest httpRequestBuildRequest = this.requestFactory.buildRequest(this.initiationRequestMethod, genericUrl, contentParts);
        httpRequestBuildRequest.getHeaders().putAll(this.initiationHeaders);
        HttpResponse httpResponseExecuteCurrentRequest = executeCurrentRequest(httpRequestBuildRequest);
        try {
            if (isMediaLengthKnown()) {
                this.totalBytesServerReceived = getMediaContentLength();
            }
            updateStateAndNotifyListener(UploadState.MEDIA_COMPLETE);
            return httpResponseExecuteCurrentRequest;
        } catch (Throwable th) {
            httpResponseExecuteCurrentRequest.disconnect();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        r13.totalBytesServerReceived = getMediaContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (r13.mediaContent.getCloseInputStream() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        r13.contentInputStream.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        updateStateAndNotifyListener(com.google.api.client.googleapis.media.MediaHttpUploader.UploadState.MEDIA_COMPLETE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpResponse resumableUpload(GenericUrl genericUrl) throws IOException {
        HttpResponse httpResponseExecuteCurrentRequest;
        HttpResponse httpResponseExecuteUploadInitiation = executeUploadInitiation(genericUrl);
        if (!httpResponseExecuteUploadInitiation.isSuccessStatusCode()) {
            return httpResponseExecuteUploadInitiation;
        }
        try {
            GenericUrl genericUrl2 = new GenericUrl(httpResponseExecuteUploadInitiation.getHeaders().getLocation());
            httpResponseExecuteUploadInitiation.disconnect();
            InputStream inputStream = this.mediaContent.getInputStream();
            this.contentInputStream = inputStream;
            if (!inputStream.markSupported() && isMediaLengthKnown()) {
                this.contentInputStream = new BufferedInputStream(this.contentInputStream);
            }
            while (true) {
                this.currentRequest = this.requestFactory.buildPutRequest(genericUrl2, null);
                setContentAndHeadersOnCurrentRequest();
                new MediaUploadErrorHandler(this, this.currentRequest);
                if (isMediaLengthKnown()) {
                    httpResponseExecuteCurrentRequest = executeCurrentRequestWithoutGZip(this.currentRequest);
                } else {
                    httpResponseExecuteCurrentRequest = executeCurrentRequest(this.currentRequest);
                }
                try {
                    if (httpResponseExecuteCurrentRequest.isSuccessStatusCode()) {
                        break;
                    }
                    if (httpResponseExecuteCurrentRequest.getStatusCode() != 308) {
                        return httpResponseExecuteCurrentRequest;
                    }
                    String location = httpResponseExecuteCurrentRequest.getHeaders().getLocation();
                    if (location != null) {
                        genericUrl2 = new GenericUrl(location);
                    }
                    long nextByteIndex = getNextByteIndex(httpResponseExecuteCurrentRequest.getHeaders().getRange());
                    long j = nextByteIndex - this.totalBytesServerReceived;
                    boolean z = true;
                    Preconditions.checkState(j >= 0 && j <= ((long) this.currentChunkLength));
                    long j2 = this.currentChunkLength - j;
                    if (isMediaLengthKnown()) {
                        if (j2 > 0) {
                            this.contentInputStream.reset();
                            if (j != this.contentInputStream.skip(j)) {
                                z = false;
                            }
                            Preconditions.checkState(z);
                        }
                    } else if (j2 == 0) {
                        this.currentRequestContentBuffer = null;
                    }
                    this.totalBytesServerReceived = nextByteIndex;
                    updateStateAndNotifyListener(UploadState.MEDIA_IN_PROGRESS);
                    httpResponseExecuteCurrentRequest.disconnect();
                } catch (Throwable th) {
                    httpResponseExecuteCurrentRequest.disconnect();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            httpResponseExecuteUploadInitiation.disconnect();
            throw th2;
        }
    }

    private boolean isMediaLengthKnown() throws IOException {
        return getMediaContentLength() >= 0;
    }

    private long getMediaContentLength() throws IOException {
        if (!this.isMediaContentLengthCalculated) {
            this.mediaContentLength = this.mediaContent.getLength();
            this.isMediaContentLengthCalculated = true;
        }
        return this.mediaContentLength;
    }

    private HttpResponse executeUploadInitiation(GenericUrl genericUrl) throws IOException {
        updateStateAndNotifyListener(UploadState.INITIATION_STARTED);
        genericUrl.put("uploadType", "resumable");
        HttpContent emptyContent = this.metadata;
        if (emptyContent == null) {
            emptyContent = new EmptyContent();
        }
        HttpRequest httpRequestBuildRequest = this.requestFactory.buildRequest(this.initiationRequestMethod, genericUrl, emptyContent);
        this.initiationHeaders.set(CONTENT_TYPE_HEADER, (Object) this.mediaContent.getType());
        if (isMediaLengthKnown()) {
            this.initiationHeaders.set(CONTENT_LENGTH_HEADER, (Object) Long.valueOf(getMediaContentLength()));
        }
        httpRequestBuildRequest.getHeaders().putAll(this.initiationHeaders);
        HttpResponse httpResponseExecuteCurrentRequest = executeCurrentRequest(httpRequestBuildRequest);
        try {
            updateStateAndNotifyListener(UploadState.INITIATION_COMPLETE);
            return httpResponseExecuteCurrentRequest;
        } catch (Throwable th) {
            httpResponseExecuteCurrentRequest.disconnect();
            throw th;
        }
    }

    private HttpResponse executeCurrentRequestWithoutGZip(HttpRequest httpRequest) throws IOException {
        new MethodOverride().intercept(httpRequest);
        httpRequest.setThrowExceptionOnExecuteError(false);
        return httpRequest.execute();
    }

    private HttpResponse executeCurrentRequest(HttpRequest httpRequest) throws IOException {
        if (!this.disableGZipContent && !(httpRequest.getContent() instanceof EmptyContent)) {
            httpRequest.setEncoding(new GZipEncoding());
        }
        return executeCurrentRequestWithoutGZip(httpRequest);
    }

    private void setContentAndHeadersOnCurrentRequest() throws IOException {
        int iMin;
        int i;
        int i2;
        HttpContent byteArrayContent;
        if (isMediaLengthKnown()) {
            iMin = (int) Math.min(this.chunkSize, getMediaContentLength() - this.totalBytesServerReceived);
        } else {
            iMin = this.chunkSize;
        }
        if (isMediaLengthKnown()) {
            this.contentInputStream.mark(iMin);
            long j = iMin;
            byteArrayContent = new InputStreamContent(this.mediaContent.getType(), ByteStreams.limit(this.contentInputStream, j)).setRetrySupported(true).setLength(j).setCloseInputStream(false);
            this.mediaContentLengthStr = String.valueOf(getMediaContentLength());
        } else {
            byte[] bArr = this.currentRequestContentBuffer;
            if (bArr == null) {
                Byte b = this.cachedByte;
                i2 = b == null ? iMin + 1 : iMin;
                byte[] bArr2 = new byte[iMin + 1];
                this.currentRequestContentBuffer = bArr2;
                if (b != null) {
                    bArr2[0] = b.byteValue();
                }
                i = 0;
            } else {
                i = (int) (this.totalBytesClientSent - this.totalBytesServerReceived);
                System.arraycopy(bArr, this.currentChunkLength - i, bArr, 0, i);
                Byte b2 = this.cachedByte;
                if (b2 != null) {
                    this.currentRequestContentBuffer[i] = b2.byteValue();
                }
                i2 = iMin - i;
            }
            int i3 = ByteStreams.read(this.contentInputStream, this.currentRequestContentBuffer, (iMin + 1) - i2, i2);
            if (i3 < i2) {
                int iMax = i + Math.max(0, i3);
                if (this.cachedByte != null) {
                    iMax++;
                    this.cachedByte = null;
                }
                if (this.mediaContentLengthStr.equals("*")) {
                    this.mediaContentLengthStr = String.valueOf(this.totalBytesServerReceived + iMax);
                }
                iMin = iMax;
            } else {
                this.cachedByte = Byte.valueOf(this.currentRequestContentBuffer[iMin]);
            }
            byteArrayContent = new ByteArrayContent(this.mediaContent.getType(), this.currentRequestContentBuffer, 0, iMin);
            this.totalBytesClientSent = this.totalBytesServerReceived + iMin;
        }
        this.currentChunkLength = iMin;
        this.currentRequest.setContent(byteArrayContent);
        if (iMin == 0) {
            this.currentRequest.getHeaders().setContentRange("bytes */" + this.mediaContentLengthStr);
            return;
        }
        this.currentRequest.getHeaders().setContentRange("bytes " + this.totalBytesServerReceived + "-" + ((this.totalBytesServerReceived + iMin) - 1) + RemoteSettings.FORWARD_SLASH_STRING + this.mediaContentLengthStr);
    }

    void serverErrorCallback() throws IOException {
        Preconditions.checkNotNull(this.currentRequest, "The current request should not be null");
        this.currentRequest.setContent(new EmptyContent());
        this.currentRequest.getHeaders().setContentRange("bytes */" + this.mediaContentLengthStr);
    }

    private long getNextByteIndex(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    public HttpContent getMetadata() {
        return this.metadata;
    }

    public MediaHttpUploader setMetadata(HttpContent httpContent) {
        this.metadata = httpContent;
        return this;
    }

    public HttpContent getMediaContent() {
        return this.mediaContent;
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public MediaHttpUploader setDirectUploadEnabled(boolean z) {
        this.directUploadEnabled = z;
        return this;
    }

    public boolean isDirectUploadEnabled() {
        return this.directUploadEnabled;
    }

    public MediaHttpUploader setProgressListener(MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener) {
        this.progressListener = mediaHttpUploaderProgressListener;
        return this;
    }

    public MediaHttpUploaderProgressListener getProgressListener() {
        return this.progressListener;
    }

    public MediaHttpUploader setChunkSize(int i) {
        Preconditions.checkArgument(i > 0 && i % 262144 == 0, "chunkSize must be a positive multiple of 262144.");
        this.chunkSize = i;
        return this;
    }

    public int getChunkSize() {
        return this.chunkSize;
    }

    public boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public MediaHttpUploader setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public MediaHttpUploader setSleeper(Sleeper sleeper) {
        this.sleeper = sleeper;
        return this;
    }

    public String getInitiationRequestMethod() {
        return this.initiationRequestMethod;
    }

    public MediaHttpUploader setInitiationRequestMethod(String str) {
        Preconditions.checkArgument(str.equals("POST") || str.equals("PUT") || str.equals("PATCH"));
        this.initiationRequestMethod = str;
        return this;
    }

    public MediaHttpUploader setInitiationHeaders(HttpHeaders httpHeaders) {
        this.initiationHeaders = httpHeaders;
        return this;
    }

    public HttpHeaders getInitiationHeaders() {
        return this.initiationHeaders;
    }

    public long getNumBytesUploaded() {
        return this.totalBytesServerReceived;
    }

    private void updateStateAndNotifyListener(UploadState uploadState) throws IOException {
        this.uploadState = uploadState;
        MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener = this.progressListener;
        if (mediaHttpUploaderProgressListener != null) {
            mediaHttpUploaderProgressListener.progressChanged(this);
        }
    }

    public UploadState getUploadState() {
        return this.uploadState;
    }

    public double getProgress() throws IOException {
        Preconditions.checkArgument(isMediaLengthKnown(), "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead.");
        if (getMediaContentLength() == 0) {
            return 0.0d;
        }
        return this.totalBytesServerReceived / getMediaContentLength();
    }
}
