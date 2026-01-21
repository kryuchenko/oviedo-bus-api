package com.palmatools.rtm.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class NfcHandler {
    private static final String TAG = "NfcHandler";
    Activity context;
    Callback mCallback;
    NfcAdapter nfcAdapter;
    PendingIntent pendingIntent;
    String Server = null;
    boolean isWorking = false;
    Executor exec = null;
    String command = null;
    Map<String, String> args = null;
    boolean active = true;

    public interface Callback {
        void onError(ClsErrorMessage clsErrorMessage);

        void onPreExecute();

        void onProgressUpdate(ClsApduMessage clsApduMessage);

        void onSuccess(ClsTextMessage clsTextMessage);

        void onTasknames(String[] strArr);
    }

    public void setExecutor(Executor executor) {
        this.exec = executor;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setTaskname(String str) {
        this.command = str;
        this.args = null;
    }

    public void setTaskname(String str, Map<String, String> map) {
        setTaskname(str);
        this.args = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NfcHandler(Activity activity) {
        this.nfcAdapter = null;
        this.mCallback = null;
        this.context = activity;
        if (activity instanceof Callback) {
            this.mCallback = (Callback) activity;
        }
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(activity);
        this.pendingIntent = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()).addFlags(536870912), 0);
    }

    public void setServer(String str) {
        this.Server = str;
    }

    public void startForeGroundDispatch() {
        Log.d(TAG, "startForeGroundDispatch");
        if (this.active) {
            Callback callback = this.mCallback;
            if (callback == null) {
                throw new NullPointerException("NON Listener is set");
            }
            if (this.Server == null) {
                throw new NullPointerException("NON metadata com.palmatools.rtm.server is set");
            }
            NfcAdapter nfcAdapter = this.nfcAdapter;
            if (nfcAdapter == null) {
                callback.onError(new ClsErrorMessage("NFC is not soport"));
                return;
            }
            if (!nfcAdapter.isEnabled()) {
                this.mCallback.onError(new ClsErrorMessage("NFC DIABLED"));
                return;
            }
            if (!recycledIntent()) {
                processIntent(this.context.getIntent());
            }
            this.nfcAdapter.enableForegroundDispatch(this.context, this.pendingIntent, null, null);
        }
    }

    public void stopForeGroundDispatch() {
        NfcAdapter nfcAdapter = this.nfcAdapter;
        if (nfcAdapter == null || !this.active) {
            return;
        }
        nfcAdapter.disableForegroundDispatch(this.context);
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean z) {
        boolean z2 = this.active;
        if (z2 && !z) {
            stopForeGroundDispatch();
            this.active = z;
        } else {
            if (z2 || !z) {
                return;
            }
            this.active = z;
            startForeGroundDispatch();
        }
    }

    private void processIntent(Intent intent) {
        String str = TAG;
        Log.d(str, "processIntent");
        try {
            if (intent == null) {
                Log.d(str, "intent null");
                return;
            }
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag == null) {
                Log.d(str, "no tagFromIntent set");
                return;
            }
            Log.d(str, "TagTecgnologic: " + Arrays.toString(tag.getTechList()));
            IsoDep isoDep = IsoDep.get(tag);
            if (isoDep != null) {
                Log.d(str, "RtmSeverTask start for IsoDep");
                synchronized (this) {
                    if (this.isWorking) {
                        return;
                    }
                    this.isWorking = true;
                    try {
                        isoDep.connect();
                        String strByteArrayToHex = ServicioSam.byteArrayToHex(isoDep.transceive(ServicioSam.hexStringToByteArray("70004000")));
                        if (this.exec != null) {
                            new RtmSeverTask(isoDep, tag.getId(), strByteArrayToHex).executeOnExecutor(this.exec, new String[0]);
                        } else {
                            new RtmSeverTask(isoDep, tag.getId(), strByteArrayToHex).execute(new String[0]);
                        }
                    } catch (TagLostException unused) {
                        Log.d(TAG, "TagLostException");
                        synchronized (this) {
                            this.isWorking = false;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.isWorking = false;
                Log.d(TAG, "processIntent throw exception", th);
                this.mCallback.onError(new ClsErrorMessage(th));
            }
        }
    }

    private boolean recycledIntent() {
        if ((this.context.getIntent().getFlags() & 1048576) != 1048576) {
            return false;
        }
        Log.i(TAG, "Launched from history, killing recycled intent");
        this.context.setIntent(new Intent());
        return true;
    }

    class RtmSeverTask extends AsyncTask<String, ClsApduMessage, ClsReaderMessage> {
        String apduResp;
        private byte[] id;
        String strId;
        private IsoDep tag;

        RtmSeverTask(IsoDep isoDep, byte[] bArr, String str) {
            this.tag = isoDep;
            this.id = bArr;
            this.strId = ServicioSam.byteArrayToHex(bArr);
            this.apduResp = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ClsReaderMessage doInBackground(String... strArr) {
            try {
                Uri.Builder builderBuildUpon = Uri.parse(NfcHandler.this.Server + String.format("%s/newComando/%s", NfcHandler.this.command, this.strId)).buildUpon();
                if (NfcHandler.this.args != null) {
                    for (Map.Entry<String, String> entry : NfcHandler.this.args.entrySet()) {
                        builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                }
                String string = builderBuildUpon.build().toString();
                Log.d(NfcHandler.TAG, "ID read:" + this.strId);
                ClsReaderMessage clsReaderMessageDownload = ServicioSam.download(string);
                Log.d(NfcHandler.TAG, "respond: " + clsReaderMessageDownload.toString());
                if (!(clsReaderMessageDownload instanceof ClsApduMessage)) {
                    return clsReaderMessageDownload;
                }
                ClsReaderMessage clsReaderMessageDownload2 = ServicioSam.download(NfcHandler.this.Server + String.format("%s/callBack/%s", NfcHandler.this.command, this.strId), new ClsApduMessage(this.apduResp, 0));
                Log.d(NfcHandler.TAG, "respond: " + clsReaderMessageDownload2.toString());
                int i = 0;
                while (clsReaderMessageDownload2 instanceof ClsApduMessage) {
                    int i2 = i + 1;
                    if (i < 100) {
                        ClsApduMessage clsApduMessage = (ClsApduMessage) clsReaderMessageDownload2;
                        publishProgress(clsApduMessage);
                        this.apduResp = "6700";
                        try {
                            this.apduResp = ServicioSam.byteArrayToHex(this.tag.transceive(ServicioSam.hexStringToByteArray(clsApduMessage.getApdu())));
                        } catch (TagLostException unused) {
                            Log.d(NfcHandler.TAG, "TagLostException");
                        }
                        clsReaderMessageDownload2 = ServicioSam.download(NfcHandler.this.Server + String.format("%s/callBack/%s", NfcHandler.this.command, this.strId), new ClsApduMessage(this.apduResp, Integer.valueOf(i2)));
                        Log.d(NfcHandler.TAG, "respond: " + clsReaderMessageDownload2.toString());
                        i = i2;
                    }
                }
                try {
                    this.tag.close();
                } catch (Throwable unused2) {
                }
                return clsReaderMessageDownload2;
            } catch (Throwable th) {
                try {
                    Log.d(NfcHandler.TAG, "doInBackground throw exception", th);
                    ClsErrorMessage clsErrorMessage = new ClsErrorMessage(th);
                    try {
                        this.tag.close();
                    } catch (Throwable unused3) {
                    }
                    return clsErrorMessage;
                } finally {
                    try {
                        this.tag.close();
                    } catch (Throwable unused4) {
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ClsReaderMessage clsReaderMessage) {
            synchronized (NfcHandler.this) {
                NfcHandler.this.isWorking = false;
            }
            if (clsReaderMessage instanceof ClsErrorMessage) {
                NfcHandler.this.mCallback.onError((ClsErrorMessage) clsReaderMessage);
            } else if (clsReaderMessage instanceof ClsTextMessage) {
                NfcHandler.this.mCallback.onSuccess((ClsTextMessage) clsReaderMessage);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (NfcHandler.this.command == null || NfcHandler.this.command.isEmpty()) {
                cancel(true);
            } else {
                NfcHandler.this.mCallback.onPreExecute();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(ClsApduMessage... clsApduMessageArr) {
            NfcHandler.this.mCallback.onProgressUpdate(clsApduMessageArr[0]);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.palmatools.rtm.client.NfcHandler$1] */
    public void GetTasksNames() {
        new AsyncTask<Void, Void, String[]>() { // from class: com.palmatools.rtm.client.NfcHandler.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String[] doInBackground(Void... voidArr) {
                try {
                    return ServicioSam.downloadTasknames(NfcHandler.this.Server + "Sams/GetRtmCommands");
                } catch (IOException e) {
                    Log.w(NfcHandler.TAG, "GetTasksNames throws exception", e);
                    return new String[0];
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String[] strArr) {
                NfcHandler.this.mCallback.onTasknames(strArr);
            }
        }.execute(new Void[0]);
    }
}
