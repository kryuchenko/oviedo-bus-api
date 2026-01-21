package com.google.android.gms.internal.drive;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzxc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public class zznm {
    public static final zznm zzwu;
    public static final zznm zzwv;
    public static final zznm zzww;
    public static final zznm zzwx;
    public static final zznm zzwy;
    public static final zznm zzwz;
    public static final zznm zzxa;
    public static final zznm zzxb;
    public static final zznm zzxc;
    public static final zznm zzxd;
    public static final zznm zzxe;
    public static final zznm zzxf;
    public static final zznm zzxg;
    public static final zznm zzxh;
    public static final zznm zzxi;
    public static final zznm zzxj;
    public static final zznm zzxk;
    public static final zznm zzxl;
    private static final /* synthetic */ zznm[] zzxo;
    private final zznr zzxm;
    private final int zzxn;

    public static zznm[] values() {
        return (zznm[]) zzxo.clone();
    }

    private zznm(String str, int i, zznr zznrVar, int i2) {
        this.zzxm = zznrVar;
        this.zzxn = i2;
    }

    public final zznr zzfj() {
        return this.zzxm;
    }

    public final int zzfk() {
        return this.zzxn;
    }

    /* synthetic */ zznm(String str, int i, zznr zznrVar, int i2, zznl zznlVar) {
        this(str, i, zznrVar, i2);
    }

    static {
        zznm zznmVar = new zznm("DOUBLE", 0, zznr.DOUBLE, 1);
        zzwu = zznmVar;
        zznm zznmVar2 = new zznm("FLOAT", 1, zznr.FLOAT, 5);
        zzwv = zznmVar2;
        final int i = 2;
        zznm zznmVar3 = new zznm("INT64", 2, zznr.LONG, 0);
        zzww = zznmVar3;
        final int i2 = 3;
        zznm zznmVar4 = new zznm("UINT64", 3, zznr.LONG, 0);
        zzwx = zznmVar4;
        zznm zznmVar5 = new zznm("INT32", 4, zznr.INT, 0);
        zzwy = zznmVar5;
        zznm zznmVar6 = new zznm("FIXED64", 5, zznr.LONG, 1);
        zzwz = zznmVar6;
        zznm zznmVar7 = new zznm("FIXED32", 6, zznr.INT, 5);
        zzxa = zznmVar7;
        zznm zznmVar8 = new zznm("BOOL", 7, zznr.BOOLEAN, 0);
        zzxb = zznmVar8;
        final zznr zznrVar = zznr.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zznm zznmVar9 = new zznm(str, i3, zznrVar, i) { // from class: com.google.android.gms.internal.drive.zznn
            {
                int i4 = 2;
                zznl zznlVar = null;
                int i5 = 8;
            }
        };
        zzxc = zznmVar9;
        final zznr zznrVar2 = zznr.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zznm zznmVar10 = new zznm(str2, i4, zznrVar2, i2) { // from class: com.google.android.gms.internal.drive.zzno
            {
                int i5 = 3;
                zznl zznlVar = null;
                int i6 = 9;
            }
        };
        zzxd = zznmVar10;
        final zznr zznrVar3 = zznr.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zznm zznmVar11 = new zznm(str3, i5, zznrVar3, i) { // from class: com.google.android.gms.internal.drive.zznp
            {
                int i6 = 2;
                zznl zznlVar = null;
                int i7 = 10;
            }
        };
        zzxe = zznmVar11;
        final zznr zznrVar4 = zznr.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zznm zznmVar12 = new zznm(str4, i6, zznrVar4, i) { // from class: com.google.android.gms.internal.drive.zznq
            {
                int i7 = 2;
                zznl zznlVar = null;
                int i8 = 11;
            }
        };
        zzxf = zznmVar12;
        zznm zznmVar13 = new zznm("UINT32", 12, zznr.INT, 0);
        zzxg = zznmVar13;
        zznm zznmVar14 = new zznm("ENUM", 13, zznr.ENUM, 0);
        zzxh = zznmVar14;
        zznm zznmVar15 = new zznm("SFIXED32", 14, zznr.INT, 5);
        zzxi = zznmVar15;
        zznm zznmVar16 = new zznm("SFIXED64", 15, zznr.LONG, 1);
        zzxj = zznmVar16;
        zznm zznmVar17 = new zznm("SINT32", 16, zznr.INT, 0);
        zzxk = zznmVar17;
        zznm zznmVar18 = new zznm("SINT64", 17, zznr.LONG, 0);
        zzxl = zznmVar18;
        zzxo = new zznm[]{zznmVar, zznmVar2, zznmVar3, zznmVar4, zznmVar5, zznmVar6, zznmVar7, zznmVar8, zznmVar9, zznmVar10, zznmVar11, zznmVar12, zznmVar13, zznmVar14, zznmVar15, zznmVar16, zznmVar17, zznmVar18};
    }
}
