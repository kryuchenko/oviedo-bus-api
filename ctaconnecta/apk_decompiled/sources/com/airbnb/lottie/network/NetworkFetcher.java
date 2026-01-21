package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    private NetworkFetcher(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.url = str;
        this.networkCache = new NetworkCache(applicationContext, str);
    }

    public LottieResult<LottieComposition> fetchSync() throws IOException {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache();
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult<>(lottieCompositionFetchFromCache);
        }
        Logger.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }

    private LottieComposition fetchFromCache() throws IOException {
        LottieResult<LottieComposition> lottieResultFromJsonInputStreamSync;
        Pair<FileExtension, InputStream> pairFetch = this.networkCache.fetch();
        if (pairFetch == null) {
            return null;
        }
        FileExtension fileExtension = pairFetch.first;
        InputStream inputStream = pairFetch.second;
        if (fileExtension == FileExtension.ZIP) {
            lottieResultFromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
        } else {
            lottieResultFromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (lottieResultFromJsonInputStreamSync.getValue() != null) {
            return lottieResultFromJsonInputStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private LottieResult fetchFromNetworkInternal() throws IOException {
        Logger.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.url).openConnection()));
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                LottieResult<LottieComposition> resultFromConnection = getResultFromConnection(httpURLConnection);
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                sb.append(resultFromConnection.getValue() != null);
                Logger.debug(sb.toString());
                return resultFromConnection;
            }
            return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + getErrorFromConnection(httpURLConnection)));
        } catch (Exception e) {
            return new LottieResult((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        int iHashCode = contentType.hashCode();
        if (iHashCode == -1248325150) {
            if (contentType.equals("application/zip")) {
                Logger.debug("Handling zip response.");
                fileExtension = FileExtension.ZIP;
                lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension))), this.url);
            }
            if (lottieResultFromZipStreamSync.getValue() != null) {
                this.networkCache.renameTempFile(fileExtension);
            }
            return lottieResultFromZipStreamSync;
        }
        if (iHashCode == -43840953) {
            contentType.equals("application/json");
        }
        Logger.debug("Received json response.");
        fileExtension = FileExtension.JSON;
        lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
        if (lottieResultFromZipStreamSync.getValue() != null) {
        }
        return lottieResultFromZipStreamSync;
    }
}
