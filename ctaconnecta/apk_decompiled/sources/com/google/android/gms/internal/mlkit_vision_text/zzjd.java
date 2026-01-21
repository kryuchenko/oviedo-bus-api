package com.google.android.gms.internal.mlkit_vision_text;

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
/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@16.0.0 */
/* loaded from: classes3.dex */
public class zzjd {
    public static final zzjd zza;
    public static final zzjd zzb;
    public static final zzjd zzc;
    public static final zzjd zzd;
    public static final zzjd zze;
    public static final zzjd zzf;
    public static final zzjd zzg;
    public static final zzjd zzh;
    public static final zzjd zzi;
    public static final zzjd zzj;
    public static final zzjd zzk;
    public static final zzjd zzl;
    public static final zzjd zzm;
    public static final zzjd zzn;
    public static final zzjd zzo;
    public static final zzjd zzp;
    public static final zzjd zzq;
    public static final zzjd zzr;
    private static final /* synthetic */ zzjd[] zzu;
    private final zzjg zzs;
    private final int zzt;

    public static zzjd[] values() {
        return (zzjd[]) zzu.clone();
    }

    private zzjd(String str, int i, zzjg zzjgVar, int i2) {
        this.zzs = zzjgVar;
        this.zzt = i2;
    }

    public final zzjg zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzjd(String str, int i, zzjg zzjgVar, int i2, zzja zzjaVar) {
        this(str, i, zzjgVar, i2);
    }

    static {
        zzjd zzjdVar = new zzjd("DOUBLE", 0, zzjg.DOUBLE, 1);
        zza = zzjdVar;
        zzjd zzjdVar2 = new zzjd("FLOAT", 1, zzjg.FLOAT, 5);
        zzb = zzjdVar2;
        final int i = 2;
        zzjd zzjdVar3 = new zzjd("INT64", 2, zzjg.LONG, 0);
        zzc = zzjdVar3;
        final int i2 = 3;
        zzjd zzjdVar4 = new zzjd("UINT64", 3, zzjg.LONG, 0);
        zzd = zzjdVar4;
        zzjd zzjdVar5 = new zzjd("INT32", 4, zzjg.INT, 0);
        zze = zzjdVar5;
        zzjd zzjdVar6 = new zzjd("FIXED64", 5, zzjg.LONG, 1);
        zzf = zzjdVar6;
        zzjd zzjdVar7 = new zzjd("FIXED32", 6, zzjg.INT, 5);
        zzg = zzjdVar7;
        zzjd zzjdVar8 = new zzjd("BOOL", 7, zzjg.BOOLEAN, 0);
        zzh = zzjdVar8;
        final zzjg zzjgVar = zzjg.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzjd zzjdVar9 = new zzjd(str, i3, zzjgVar, i) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzjc
            {
                int i4 = 2;
                zzja zzjaVar = null;
                int i5 = 8;
            }
        };
        zzi = zzjdVar9;
        final zzjg zzjgVar2 = zzjg.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzjd zzjdVar10 = new zzjd(str2, i4, zzjgVar2, i2) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzjf
            {
                int i5 = 3;
                zzja zzjaVar = null;
                int i6 = 9;
            }
        };
        zzj = zzjdVar10;
        final zzjg zzjgVar3 = zzjg.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzjd zzjdVar11 = new zzjd(str3, i5, zzjgVar3, i) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzje
            {
                int i6 = 2;
                zzja zzjaVar = null;
                int i7 = 10;
            }
        };
        zzk = zzjdVar11;
        final zzjg zzjgVar4 = zzjg.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzjd zzjdVar12 = new zzjd(str4, i6, zzjgVar4, i) { // from class: com.google.android.gms.internal.mlkit_vision_text.zzjh
            {
                int i7 = 2;
                zzja zzjaVar = null;
                int i8 = 11;
            }
        };
        zzl = zzjdVar12;
        zzjd zzjdVar13 = new zzjd("UINT32", 12, zzjg.INT, 0);
        zzm = zzjdVar13;
        zzjd zzjdVar14 = new zzjd("ENUM", 13, zzjg.ENUM, 0);
        zzn = zzjdVar14;
        zzjd zzjdVar15 = new zzjd("SFIXED32", 14, zzjg.INT, 5);
        zzo = zzjdVar15;
        zzjd zzjdVar16 = new zzjd("SFIXED64", 15, zzjg.LONG, 1);
        zzp = zzjdVar16;
        zzjd zzjdVar17 = new zzjd("SINT32", 16, zzjg.INT, 0);
        zzq = zzjdVar17;
        zzjd zzjdVar18 = new zzjd("SINT64", 17, zzjg.LONG, 0);
        zzr = zzjdVar18;
        zzu = new zzjd[]{zzjdVar, zzjdVar2, zzjdVar3, zzjdVar4, zzjdVar5, zzjdVar6, zzjdVar7, zzjdVar8, zzjdVar9, zzjdVar10, zzjdVar11, zzjdVar12, zzjdVar13, zzjdVar14, zzjdVar15, zzjdVar16, zzjdVar17, zzjdVar18};
    }
}
