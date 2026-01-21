package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
final class zzjk {
    static String zzd(zzfm zzfmVar) {
        zzjn zzjnVar = new zzjn(zzfmVar);
        StringBuilder sb = new StringBuilder(zzjnVar.size());
        for (int i = 0; i < zzjnVar.size(); i++) {
            byte bZzao = zzjnVar.zzao(i);
            if (bZzao == 34) {
                sb.append("\\\"");
            } else if (bZzao == 39) {
                sb.append("\\'");
            } else if (bZzao != 92) {
                switch (bZzao) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZzao < 32 || bZzao > 126) {
                            sb.append('\\');
                            sb.append((char) (((bZzao >>> 6) & 3) + 48));
                            sb.append((char) (((bZzao >>> 3) & 7) + 48));
                            sb.append((char) ((bZzao & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bZzao);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
