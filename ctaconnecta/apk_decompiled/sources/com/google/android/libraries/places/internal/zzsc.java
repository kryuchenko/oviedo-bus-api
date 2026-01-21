package com.google.android.libraries.places.internal;

import java.util.Iterator;
import org.jmrtd.lds.ImageInfo;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public final class zzsc {
    public static final /* synthetic */ int zza = 0;
    private static final zzob zzb = zzob.zzn("http", "https", "mailto", "ftp");
    private static final zzob zzc = zzob.zzp("audio/3gpp2", "audio/3gpp", "audio/aac", "audio/midi", "audio/mp3", "audio/mp4", "audio/mpeg", "audio/oga", "audio/ogg", "audio/opus", "audio/x-m4a", "audio/x-matroska", "audio/x-wav", "audio/wav", "audio/webm", "image/bmp", "image/gif", ImageInfo.JPEG_MIME_TYPE, "image/jpg", "image/png", "image/svg+xml", "image/tiff", "image/webp", "image/x-icon", "video/mpeg", "video/mp4", "video/ogg", "video/webm", "video/x-matroska", "font/ttf");
    private static final zzob zzd = zzob.zzk();

    public static zzsb zza(String str, zzsb zzsbVar) {
        char cCharAt;
        int i;
        char cCharAt2;
        char cCharAt3;
        zzob zzobVar = zzd;
        String strZza = zzlu.zza(str);
        zzox it = zzb.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (strZza.startsWith("data:")) {
                    String strZza2 = zzlu.zza(str);
                    if (strZza2.startsWith("data:") && strZza2.length() > 5) {
                        int i2 = 5;
                        while (i2 < strZza2.length() && (cCharAt3 = strZza2.charAt(i2)) != ';' && cCharAt3 != ',') {
                            i2++;
                        }
                        if (zzc.contains(strZza2.substring(5, i2)) && strZza2.startsWith(";base64,", i2) && (i = i2 + 8) < strZza2.length()) {
                            while (i < strZza2.length() && (cCharAt2 = strZza2.charAt(i)) != '=') {
                                if ((cCharAt2 < 'a' || cCharAt2 > 'z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '/')) {
                                    break;
                                }
                                i++;
                            }
                            while (i < strZza2.length()) {
                                if (strZza2.charAt(i) == '=') {
                                    i++;
                                }
                            }
                        }
                    }
                    return zzsbVar;
                }
                Iterator it2 = zzobVar.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (strZza.startsWith(String.valueOf(zzlu.zza(((zzry) it2.next()).name()).replace('_', '-')).concat(":"))) {
                            break;
                        }
                    } else {
                        for (int i3 = 0; i3 < str.length() && (cCharAt = str.charAt(i3)) != '#' && cCharAt != '/'; i3++) {
                            if (cCharAt != ':') {
                                if (cCharAt == '?') {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if (strZza.startsWith(String.valueOf((String) it.next()).concat(":"))) {
                    break;
                }
            }
        }
        return new zzsb(str);
    }
}
