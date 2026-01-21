package com.google.android.gms.internal.mlkit_vision_common;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzho {
    public static final zzho zza;
    public static final zzho zzb;
    public static final zzho zzc;
    public static final zzho zzd;
    public static final zzho zze;
    public static final zzho zzf;
    public static final zzho zzg;
    public static final zzho zzh;
    public static final zzho zzi;
    public static final zzho zzj;
    public static final zzho zzk;
    public static final zzho zzl;
    public static final zzho zzm;
    public static final zzho zzn;
    public static final zzho zzo;
    public static final zzho zzp;
    public static final zzho zzq;
    public static final zzho zzr;
    private static final /* synthetic */ zzho[] zzu;
    private final zzhv zzs;
    private final int zzt;

    public static zzho[] values() {
        return (zzho[]) zzu.clone();
    }

    private zzho(String str, int i, zzhv zzhvVar, int i2) {
        this.zzs = zzhvVar;
        this.zzt = i2;
    }

    public final zzhv zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzho(String str, int i, zzhv zzhvVar, int i2, zzhp zzhpVar) {
        this(str, i, zzhvVar, i2);
    }

    static {
        zzho zzhoVar = new zzho("DOUBLE", 0, zzhv.DOUBLE, 1);
        zza = zzhoVar;
        zzho zzhoVar2 = new zzho("FLOAT", 1, zzhv.FLOAT, 5);
        zzb = zzhoVar2;
        final int i = 2;
        zzho zzhoVar3 = new zzho("INT64", 2, zzhv.LONG, 0);
        zzc = zzhoVar3;
        final int i2 = 3;
        zzho zzhoVar4 = new zzho("UINT64", 3, zzhv.LONG, 0);
        zzd = zzhoVar4;
        zzho zzhoVar5 = new zzho("INT32", 4, zzhv.INT, 0);
        zze = zzhoVar5;
        zzho zzhoVar6 = new zzho("FIXED64", 5, zzhv.LONG, 1);
        zzf = zzhoVar6;
        zzho zzhoVar7 = new zzho("FIXED32", 6, zzhv.INT, 5);
        zzg = zzhoVar7;
        zzho zzhoVar8 = new zzho("BOOL", 7, zzhv.BOOLEAN, 0);
        zzh = zzhoVar8;
        final zzhv zzhvVar = zzhv.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzho zzhoVar9 = new zzho(str, i3, zzhvVar, i) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhr
            {
                int i4 = 2;
                zzhp zzhpVar = null;
                int i5 = 8;
            }
        };
        zzi = zzhoVar9;
        final zzhv zzhvVar2 = zzhv.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzho zzhoVar10 = new zzho(str2, i4, zzhvVar2, i2) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhq
            {
                int i5 = 3;
                zzhp zzhpVar = null;
                int i6 = 9;
            }
        };
        zzj = zzhoVar10;
        final zzhv zzhvVar3 = zzhv.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzho zzhoVar11 = new zzho(str3, i5, zzhvVar3, i) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzht
            {
                int i6 = 2;
                zzhp zzhpVar = null;
                int i7 = 10;
            }
        };
        zzk = zzhoVar11;
        final zzhv zzhvVar4 = zzhv.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzho zzhoVar12 = new zzho(str4, i6, zzhvVar4, i) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhs
            {
                int i7 = 2;
                zzhp zzhpVar = null;
                int i8 = 11;
            }
        };
        zzl = zzhoVar12;
        zzho zzhoVar13 = new zzho("UINT32", 12, zzhv.INT, 0);
        zzm = zzhoVar13;
        zzho zzhoVar14 = new zzho("ENUM", 13, zzhv.ENUM, 0);
        zzn = zzhoVar14;
        zzho zzhoVar15 = new zzho("SFIXED32", 14, zzhv.INT, 5);
        zzo = zzhoVar15;
        zzho zzhoVar16 = new zzho("SFIXED64", 15, zzhv.LONG, 1);
        zzp = zzhoVar16;
        zzho zzhoVar17 = new zzho("SINT32", 16, zzhv.INT, 0);
        zzq = zzhoVar17;
        zzho zzhoVar18 = new zzho("SINT64", 17, zzhv.LONG, 0);
        zzr = zzhoVar18;
        zzu = new zzho[]{zzhoVar, zzhoVar2, zzhoVar3, zzhoVar4, zzhoVar5, zzhoVar6, zzhoVar7, zzhoVar8, zzhoVar9, zzhoVar10, zzhoVar11, zzhoVar12, zzhoVar13, zzhoVar14, zzhoVar15, zzhoVar16, zzhoVar17, zzhoVar18};
    }
}
