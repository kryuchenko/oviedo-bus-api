package com.google.android.gms.internal.vision;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzacj' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes3.dex */
public class zzkf {
    public static final zzkf zzacb;
    public static final zzkf zzacc;
    public static final zzkf zzacd;
    public static final zzkf zzace;
    public static final zzkf zzacf;
    public static final zzkf zzacg;
    public static final zzkf zzach;
    public static final zzkf zzaci;
    public static final zzkf zzacj;
    public static final zzkf zzack;
    public static final zzkf zzacl;
    public static final zzkf zzacm;
    public static final zzkf zzacn;
    public static final zzkf zzaco;
    public static final zzkf zzacp;
    public static final zzkf zzacq;
    public static final zzkf zzacr;
    public static final zzkf zzacs;
    private static final /* synthetic */ zzkf[] zzacv;
    private final zzki zzact;
    private final int zzacu;

    public static zzkf[] values() {
        return (zzkf[]) zzacv.clone();
    }

    private zzkf(String str, int i, zzki zzkiVar, int i2) {
        this.zzact = zzkiVar;
        this.zzacu = i2;
    }

    public final zzki zziq() {
        return this.zzact;
    }

    public final int zzir() {
        return this.zzacu;
    }

    /* synthetic */ zzkf(String str, int i, zzki zzkiVar, int i2, zzkc zzkcVar) {
        this(str, i, zzkiVar, i2);
    }

    static {
        zzkf zzkfVar = new zzkf("DOUBLE", 0, zzki.DOUBLE, 1);
        zzacb = zzkfVar;
        zzkf zzkfVar2 = new zzkf("FLOAT", 1, zzki.FLOAT, 5);
        zzacc = zzkfVar2;
        final int i = 2;
        zzkf zzkfVar3 = new zzkf("INT64", 2, zzki.LONG, 0);
        zzacd = zzkfVar3;
        final int i2 = 3;
        zzkf zzkfVar4 = new zzkf("UINT64", 3, zzki.LONG, 0);
        zzace = zzkfVar4;
        zzkf zzkfVar5 = new zzkf("INT32", 4, zzki.INT, 0);
        zzacf = zzkfVar5;
        zzkf zzkfVar6 = new zzkf("FIXED64", 5, zzki.LONG, 1);
        zzacg = zzkfVar6;
        zzkf zzkfVar7 = new zzkf("FIXED32", 6, zzki.INT, 5);
        zzach = zzkfVar7;
        zzkf zzkfVar8 = new zzkf("BOOL", 7, zzki.BOOLEAN, 0);
        zzaci = zzkfVar8;
        final zzki zzkiVar = zzki.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzkf zzkfVar9 = new zzkf(str, i3, zzkiVar, i) { // from class: com.google.android.gms.internal.vision.zzke
            {
                int i4 = 2;
                zzkc zzkcVar = null;
                int i5 = 8;
            }
        };
        zzacj = zzkfVar9;
        final zzki zzkiVar2 = zzki.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzkf zzkfVar10 = new zzkf(str2, i4, zzkiVar2, i2) { // from class: com.google.android.gms.internal.vision.zzkh
            {
                int i5 = 3;
                zzkc zzkcVar = null;
                int i6 = 9;
            }
        };
        zzack = zzkfVar10;
        final zzki zzkiVar3 = zzki.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzkf zzkfVar11 = new zzkf(str3, i5, zzkiVar3, i) { // from class: com.google.android.gms.internal.vision.zzkg
            {
                int i6 = 2;
                zzkc zzkcVar = null;
                int i7 = 10;
            }
        };
        zzacl = zzkfVar11;
        final zzki zzkiVar4 = zzki.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzkf zzkfVar12 = new zzkf(str4, i6, zzkiVar4, i) { // from class: com.google.android.gms.internal.vision.zzkj
            {
                int i7 = 2;
                zzkc zzkcVar = null;
                int i8 = 11;
            }
        };
        zzacm = zzkfVar12;
        zzkf zzkfVar13 = new zzkf("UINT32", 12, zzki.INT, 0);
        zzacn = zzkfVar13;
        zzkf zzkfVar14 = new zzkf("ENUM", 13, zzki.ENUM, 0);
        zzaco = zzkfVar14;
        zzkf zzkfVar15 = new zzkf("SFIXED32", 14, zzki.INT, 5);
        zzacp = zzkfVar15;
        zzkf zzkfVar16 = new zzkf("SFIXED64", 15, zzki.LONG, 1);
        zzacq = zzkfVar16;
        zzkf zzkfVar17 = new zzkf("SINT32", 16, zzki.INT, 0);
        zzacr = zzkfVar17;
        zzkf zzkfVar18 = new zzkf("SINT64", 17, zzki.LONG, 0);
        zzacs = zzkfVar18;
        zzacv = new zzkf[]{zzkfVar, zzkfVar2, zzkfVar3, zzkfVar4, zzkfVar5, zzkfVar6, zzkfVar7, zzkfVar8, zzkfVar9, zzkfVar10, zzkfVar11, zzkfVar12, zzkfVar13, zzkfVar14, zzkfVar15, zzkfVar16, zzkfVar17, zzkfVar18};
    }
}
