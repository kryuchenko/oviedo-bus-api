package com.palmatools.rtm.client;

import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes5.dex */
public final class ServicioSam {
    public static String TAG = "ServicioSam";
    private static Gson gsonExt;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ClsReaderMessage.class, new ClsReaderMessageAdapter());
        gsonExt = gsonBuilder.create();
    }

    public static ClsReaderMessage download(String str, ClsReaderMessage clsReaderMessage) throws IOException {
        Log.d(TAG, "download: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
        outputStreamWriter.write(gsonExt.toJson(clsReaderMessage));
        outputStreamWriter.flush();
        outputStreamWriter.close();
        return (ClsReaderMessage) gsonExt.fromJson((Reader) new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())), ClsReaderMessage.class);
    }

    public static String[] downloadTasknames(String str) throws IOException {
        Log.d(TAG, "downloadTasknames: " + str);
        return (String[]) gsonExt.fromJson((Reader) new BufferedReader(new InputStreamReader(((HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()))).getInputStream())), String[].class);
    }

    public static ClsReaderMessage download(String str) throws IOException {
        Log.d(TAG, "download: " + str);
        return (ClsReaderMessage) gsonExt.fromJson((Reader) new BufferedReader(new InputStreamReader(((HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()))).getInputStream())), ClsReaderMessage.class);
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String byteArrayToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }
}
