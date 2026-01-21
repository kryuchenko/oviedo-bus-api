package com.google.android.gms.internal.mlkit_common;

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
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes3.dex */
public class zzie {
    public static final zzie zza;
    public static final zzie zzb;
    public static final zzie zzc;
    public static final zzie zzd;
    public static final zzie zze;
    public static final zzie zzf;
    public static final zzie zzg;
    public static final zzie zzh;
    public static final zzie zzi;
    public static final zzie zzj;
    public static final zzie zzk;
    public static final zzie zzl;
    public static final zzie zzm;
    public static final zzie zzn;
    public static final zzie zzo;
    public static final zzie zzp;
    public static final zzie zzq;
    public static final zzie zzr;
    private static final /* synthetic */ zzie[] zzu;
    private final zzih zzs;
    private final int zzt;

    public static zzie[] values() {
        return (zzie[]) zzu.clone();
    }

    private zzie(String str, int i, zzih zzihVar, int i2) {
        this.zzs = zzihVar;
        this.zzt = i2;
    }

    public final zzih zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzie(String str, int i, zzih zzihVar, int i2, zzib zzibVar) {
        this(str, i, zzihVar, i2);
    }

    static {
        zzie zzieVar = new zzie("DOUBLE", 0, zzih.DOUBLE, 1);
        zza = zzieVar;
        zzie zzieVar2 = new zzie("FLOAT", 1, zzih.FLOAT, 5);
        zzb = zzieVar2;
        final int i = 2;
        zzie zzieVar3 = new zzie("INT64", 2, zzih.LONG, 0);
        zzc = zzieVar3;
        final int i2 = 3;
        zzie zzieVar4 = new zzie("UINT64", 3, zzih.LONG, 0);
        zzd = zzieVar4;
        zzie zzieVar5 = new zzie("INT32", 4, zzih.INT, 0);
        zze = zzieVar5;
        zzie zzieVar6 = new zzie("FIXED64", 5, zzih.LONG, 1);
        zzf = zzieVar6;
        zzie zzieVar7 = new zzie("FIXED32", 6, zzih.INT, 5);
        zzg = zzieVar7;
        zzie zzieVar8 = new zzie("BOOL", 7, zzih.BOOLEAN, 0);
        zzh = zzieVar8;
        final zzih zzihVar = zzih.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzie zzieVar9 = new zzie(str, i3, zzihVar, i) { // from class: com.google.android.gms.internal.mlkit_common.zzid
            {
                int i4 = 2;
                zzib zzibVar = null;
                int i5 = 8;
            }
        };
        zzi = zzieVar9;
        final zzih zzihVar2 = zzih.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzie zzieVar10 = new zzie(str2, i4, zzihVar2, i2) { // from class: com.google.android.gms.internal.mlkit_common.zzig
            {
                int i5 = 3;
                zzib zzibVar = null;
                int i6 = 9;
            }
        };
        zzj = zzieVar10;
        final zzih zzihVar3 = zzih.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzie zzieVar11 = new zzie(str3, i5, zzihVar3, i) { // from class: com.google.android.gms.internal.mlkit_common.zzif
            {
                int i6 = 2;
                zzib zzibVar = null;
                int i7 = 10;
            }
        };
        zzk = zzieVar11;
        final zzih zzihVar4 = zzih.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzie zzieVar12 = new zzie(str4, i6, zzihVar4, i) { // from class: com.google.android.gms.internal.mlkit_common.zzii
            {
                int i7 = 2;
                zzib zzibVar = null;
                int i8 = 11;
            }
        };
        zzl = zzieVar12;
        zzie zzieVar13 = new zzie("UINT32", 12, zzih.INT, 0);
        zzm = zzieVar13;
        zzie zzieVar14 = new zzie("ENUM", 13, zzih.ENUM, 0);
        zzn = zzieVar14;
        zzie zzieVar15 = new zzie("SFIXED32", 14, zzih.INT, 5);
        zzo = zzieVar15;
        zzie zzieVar16 = new zzie("SFIXED64", 15, zzih.LONG, 1);
        zzp = zzieVar16;
        zzie zzieVar17 = new zzie("SINT32", 16, zzih.INT, 0);
        zzq = zzieVar17;
        zzie zzieVar18 = new zzie("SINT64", 17, zzih.LONG, 0);
        zzr = zzieVar18;
        zzu = new zzie[]{zzieVar, zzieVar2, zzieVar3, zzieVar4, zzieVar5, zzieVar6, zzieVar7, zzieVar8, zzieVar9, zzieVar10, zzieVar11, zzieVar12, zzieVar13, zzieVar14, zzieVar15, zzieVar16, zzieVar17, zzieVar18};
    }
}
