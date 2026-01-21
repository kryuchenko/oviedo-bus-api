package com.iecisa.ctausuario.utils;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.room.Room;
import com.iecisa.ctausuario.data.database.AppDatabase;
import com.iecisa.ctausuario.data.database.StopsDao;
import com.iecisa.ctausuario.data.preferences.PreferencesHelper;
import com.iecisa.ctausuario.data.preferences.PreferencesHelperImpl;
import com.iecisa.ctausuario.model.MapStop;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jj2000.j2k.entropy.encoder.StdEntropyCoder;

/* loaded from: classes5.dex */
public class CTABackupAgent extends BackupAgent {
    private static String BACKUP_ENABLED_HEADER = "BACKUP_ENABLED";
    private static String FAVORITE_STOPS_HEADER = "FAVORITE_STOPS";
    private static String TAG = "CTABackupAgent";

    @Override // android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws NoSuchAlgorithmException, IOException {
        PreferencesHelperImpl preferencesHelperImpl = new PreferencesHelperImpl(getBaseContext());
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(newState.getFileDescriptor()));
        if (preferencesHelperImpl.isCloudActivated().booleanValue()) {
            byte[] favoritesData = getFavoritesData();
            byte[] backupPreferenceData = getBackupPreferenceData(preferencesHelperImpl);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(favoritesData);
                messageDigest.update(backupPreferenceData);
                String strMd5 = md5(messageDigest);
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(oldState.getFileDescriptor()));
                if ((dataInputStream.available() > 0 ? dataInputStream.readUTF() : "").compareTo(strMd5) != 0) {
                    data.writeEntityHeader(FAVORITE_STOPS_HEADER, favoritesData.length);
                    data.writeEntityData(favoritesData, favoritesData.length);
                    data.writeEntityHeader(BACKUP_ENABLED_HEADER, backupPreferenceData.length);
                    data.writeEntityData(backupPreferenceData, backupPreferenceData.length);
                    dataOutputStream.writeUTF(strMd5);
                    return;
                }
                return;
            } catch (NoSuchAlgorithmException unused) {
                Log.d(TAG, "md5 not available");
                return;
            }
        }
        data.writeEntityHeader(FAVORITE_STOPS_HEADER, -1);
        data.writeEntityHeader(BACKUP_ENABLED_HEADER, -1);
        dataOutputStream.writeUTF("");
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws NoSuchAlgorithmException, IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (data.readNextHeader()) {
                String key = data.getKey();
                int dataSize = data.getDataSize();
                byte[] bArr = new byte[dataSize];
                data.readEntityData(bArr, 0, dataSize);
                messageDigest.update(bArr);
                if (FAVORITE_STOPS_HEADER.equals(key)) {
                    restoreFavoritesFromByteArray(bArr);
                } else if (BACKUP_ENABLED_HEADER.equals(key)) {
                    restoreBackupPreferenceData(bArr);
                }
            }
            new DataOutputStream(new FileOutputStream(newState.getFileDescriptor())).writeUTF(md5(messageDigest));
        } catch (NoSuchAlgorithmException unused) {
            Log.d(TAG, "md5 not available");
        }
    }

    private byte[] getFavoritesData() throws IOException {
        AppDatabase appDatabase = (AppDatabase) Room.databaseBuilder(getBaseContext(), AppDatabase.class, "db-stops").build();
        StopsDao stopsDao = appDatabase.getStopsDao();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (MapStop mapStop : stopsDao.getAllFavouriteStopsSync()) {
            Parcel parcelObtain = Parcel.obtain();
            mapStop.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            dataOutputStream.writeInt(bArrMarshall.length);
            dataOutputStream.write(bArrMarshall);
            parcelObtain.recycle();
        }
        appDatabase.close();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] getBackupPreferenceData(PreferencesHelper preferencesHelper) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeBoolean(preferencesHelper.isCloudActivated().booleanValue());
        return byteArrayOutputStream.toByteArray();
    }

    private void restoreBackupPreferenceData(byte[] data) throws IOException {
        PreferencesHelperImpl preferencesHelperImpl = new PreferencesHelperImpl(getBaseContext());
        if (new DataInputStream(new ByteArrayInputStream(data)).readBoolean()) {
            preferencesHelperImpl.activateCloud();
        } else {
            preferencesHelperImpl.desactivateCloud();
        }
    }

    private void restoreFavoritesFromByteArray(byte[] bytes) throws IOException {
        StopsDao stopsDao = ((AppDatabase) Room.databaseBuilder(getBaseContext(), AppDatabase.class, "db-stops").build()).getStopsDao();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bytes));
        while (dataInputStream.available() > 0) {
            int i = dataInputStream.readInt();
            if (i <= dataInputStream.available()) {
                byte[] bArr = new byte[i];
                dataInputStream.read(bArr, 0, i);
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArr, 0, i);
                parcelObtain.setDataPosition(0);
                MapStop mapStopCreateFromParcel = MapStop.CREATOR.createFromParcel(parcelObtain);
                if (mapStopCreateFromParcel != null) {
                    stopsDao.insertFavouriteStopSync(mapStopCreateFromParcel);
                }
            }
        }
    }

    private String md5(MessageDigest md5Digest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : md5Digest.digest()) {
            String hexString = Integer.toHexString(b & 255);
            while (hexString.length() < 2) {
                hexString = StdEntropyCoder.DEF_THREADS_NUM + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
