package com.google.android.libraries.places.internal;

import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sf.scuba.smartcards.ISO7816;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public class zzbwf implements Serializable, Comparable {
    public static final zzbwe zza = new zzbwe(null);
    public static final zzbwf zzb = new zzbwf(new byte[0]);
    private final byte[] zzc;
    private transient int zzd;
    private transient String zze;

    public zzbwf(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.zzc = data;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzbwf other = (zzbwf) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        int iZzc = zzc();
        int iZzc2 = other.zzc();
        int iMin = Math.min(iZzc, iZzc2);
        for (int i = 0; i < iMin; i++) {
            int iZza = zza(i) & 255;
            int iZza2 = other.zza(i) & 255;
            if (iZza != iZza2) {
                return iZza >= iZza2 ? 1 : -1;
            }
        }
        if (iZzc == iZzc2) {
            return 0;
        }
        return iZzc >= iZzc2 ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbwf) {
            zzbwf zzbwfVar = (zzbwf) obj;
            int iZzc = zzbwfVar.zzc();
            byte[] bArr = this.zzc;
            int length = bArr.length;
            return iZzc == length && zzbwfVar.zzl(0, bArr, 0, length);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.zzc);
        this.zzd = iHashCode;
        return iHashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x004e, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0064, code lost:
    
        r6 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        int i;
        byte[] bArr = this.zzc;
        int length = bArr.length;
        if (length == 0) {
            return "[size=0]";
        }
        int i2 = zzbwy.zza;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                break;
            }
            byte b = bArr[i3];
            if (b >= 0) {
                i = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if (b != 10 && b != 13 && (b < 32 || b >= Byte.MAX_VALUE)) {
                    break;
                }
                i5++;
                i3++;
                while (i3 < length) {
                    byte b2 = bArr[i3];
                    if (b2 >= 0) {
                        i3++;
                        int i6 = i + 1;
                        if (i != 64) {
                            if (b2 != 10 && b2 != 13 && (b2 < 32 || b2 >= Byte.MAX_VALUE)) {
                                break loop0;
                            }
                            i5++;
                            i = i6;
                        } else {
                            break loop0;
                        }
                    }
                }
                i4 = i;
            } else if ((b >> 5) == -2) {
                int i7 = i3 + 1;
                if (length > i7) {
                    byte b3 = bArr[i7];
                    if ((b3 & ISO7816.INS_GET_RESPONSE) == 128) {
                        int i8 = (b << 6) ^ (b3 ^ 3968);
                        if (i8 >= 128) {
                            i = i4 + 1;
                            if (i4 != 64) {
                                if (i8 < 160 || i8 == 65533) {
                                    break;
                                }
                                i3 += 2;
                                i5 += i8 < 65536 ? 1 : 2;
                                Unit unit = Unit.INSTANCE;
                                i4 = i;
                            } else {
                                break;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if ((b >> 4) == -2) {
                int i9 = i3 + 2;
                if (length > i9) {
                    byte b4 = bArr[i3 + 1];
                    if ((b4 & ISO7816.INS_GET_RESPONSE) == 128) {
                        byte b5 = bArr[i9];
                        if ((b5 & ISO7816.INS_GET_RESPONSE) == 128) {
                            int i10 = ((b5 ^ (-123008)) ^ (b4 << 6)) ^ (b << 12);
                            if (i10 < 2048) {
                                if (i4 != 64) {
                                    break;
                                }
                            } else if (i10 < 55296 || i10 >= 57344) {
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if (i10 == 65533) {
                                    break;
                                }
                                i3 += 3;
                                i5 += i10 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.INSTANCE;
                                i4 = i;
                            } else if (i4 != 64) {
                                break;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if ((b >> 3) == -2) {
                int i11 = i3 + 3;
                if (length > i11) {
                    byte b6 = bArr[i3 + 1];
                    if ((b6 & ISO7816.INS_GET_RESPONSE) == 128) {
                        byte b7 = bArr[i3 + 2];
                        if ((b7 & ISO7816.INS_GET_RESPONSE) == 128) {
                            byte b8 = bArr[i11];
                            if ((b8 & ISO7816.INS_GET_RESPONSE) == 128) {
                                int i12 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << 12)) ^ (b << Ascii.DC2);
                                if (i12 > 1114111) {
                                    if (i4 != 64) {
                                        break;
                                    }
                                } else if (i12 < 55296 || i12 >= 57344) {
                                    if (i12 >= 65536) {
                                        i = i4 + 1;
                                        if (i4 == 64) {
                                            break;
                                        }
                                        i5 += 2;
                                        Unit unit3 = Unit.INSTANCE;
                                        i3 += 4;
                                        i4 = i;
                                    } else if (i4 != 64) {
                                        break;
                                    }
                                } else if (i4 != 64) {
                                    break;
                                }
                            } else if (i4 != 64) {
                                break;
                            }
                        } else if (i4 != 64) {
                            break;
                        }
                    } else if (i4 != 64) {
                        break;
                    }
                } else if (i4 != 64) {
                    break;
                }
            } else if (i4 != 64) {
                break;
            }
        }
        if (i5 != -1) {
            String strZzf = zzf();
            String strSubstring = strZzf.substring(0, i5);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (i5 >= strZzf.length()) {
                return "[text=" + strReplace$default + "]";
            }
            return "[size=" + this.zzc.length + " text=" + strReplace$default + "…]";
        }
        int length2 = this.zzc.length;
        if (length2 <= 64) {
            return "[hex=" + zze() + "]";
        }
        Intrinsics.checkNotNullParameter(this, "<this>");
        byte[] bArr2 = this.zzc;
        int length3 = bArr2.length;
        if (length3 < 64) {
            throw new IllegalArgumentException("endIndex > length(" + length3 + ")");
        }
        return "[size=" + length2 + " hex=" + (length3 != 64 ? new zzbwf(ArraysKt.copyOfRange(bArr2, 0, 64)) : this).zze() + "…]";
    }

    public byte zza(int i) {
        return this.zzc[i];
    }

    public final int zzb() {
        return this.zzd;
    }

    public int zzc() {
        return this.zzc.length;
    }

    public final String zzd() {
        return zzbvu.zza(this.zzc, null, 1, null);
    }

    public String zze() {
        byte[] bArr = this.zzc;
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b : bArr) {
            cArr[i] = zzbwy.zza()[(b >> 4) & 15];
            cArr[i + 1] = zzbwy.zza()[b & 15];
            i += 2;
        }
        return StringsKt.concatToString(cArr);
    }

    public final String zzf() {
        String str = this.zze;
        if (str != null) {
            return str;
        }
        String strZza = zzbww.zza(zzo());
        this.zze = strZza;
        return strZza;
    }

    public zzbwf zzg() {
        int i = 0;
        while (true) {
            byte[] bArr = this.zzc;
            int length = bArr.length;
            if (i >= length) {
                return this;
            }
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b + 32);
                while (i2 < bArrCopyOf.length) {
                    int i3 = i2 + 1;
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                    i2 = i3;
                }
                return new zzbwf(bArrCopyOf);
            }
            i = i2;
        }
    }

    public final void zzh(int i) {
        this.zzd = i;
    }

    public final void zzi(String str) {
        this.zze = str;
    }

    public void zzj(zzbwb buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i3 = zzbwy.zza;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.zzl(this.zzc, 0, i2);
    }

    public boolean zzk(int i, zzbwf other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.zzl(0, this.zzc, 0, i3);
    }

    public boolean zzl(int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr = this.zzc;
        return i <= bArr.length - i3 && i2 >= 0 && i2 <= other.length - i3 && zzbvv.zzc(bArr, i, other, i2, i3);
    }

    public final boolean zzm(zzbwf prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return zzk(0, prefix, 0, prefix.zzc.length);
    }

    public final byte[] zzn() {
        return this.zzc;
    }

    public byte[] zzo() {
        return this.zzc;
    }

    public byte[] zzp() {
        byte[] bArr = this.zzc;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
