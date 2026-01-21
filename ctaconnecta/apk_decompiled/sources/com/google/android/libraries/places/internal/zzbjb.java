package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@3.5.0 */
/* loaded from: classes3.dex */
public enum zzbjb {
    NO_ERROR(0, zzbdo.zzp),
    PROTOCOL_ERROR(1, zzbdo.zzo),
    INTERNAL_ERROR(2, zzbdo.zzo),
    FLOW_CONTROL_ERROR(3, zzbdo.zzo),
    SETTINGS_TIMEOUT(4, zzbdo.zzo),
    STREAM_CLOSED(5, zzbdo.zzo),
    FRAME_SIZE_ERROR(6, zzbdo.zzo),
    REFUSED_STREAM(7, zzbdo.zzp),
    CANCEL(8, zzbdo.zzb),
    COMPRESSION_ERROR(9, zzbdo.zzo),
    CONNECT_ERROR(10, zzbdo.zzo),
    ENHANCE_YOUR_CALM(11, zzbdo.zzj.zzg("Bandwidth exhausted")),
    INADEQUATE_SECURITY(12, zzbdo.zzh.zzg("Permission denied as protocol is not secure enough to call")),
    HTTP_1_1_REQUIRED(13, zzbdo.zzc);

    private static final zzbjb[] zzo;
    private final int zzq;
    private final zzbdo zzr;

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:230)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:144)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:81)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:65)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:55)
        */
    static {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbjb.<clinit>():void");
    }

    zzbjb(int i, zzbdo zzbdoVar) {
        this.zzq = i;
        String strConcat = "HTTP/2 error code: ".concat(String.valueOf(name()));
        if (zzbdoVar.zzi() != null) {
            strConcat = strConcat + " (" + zzbdoVar.zzi() + ")";
        }
        this.zzr = zzbdoVar.zzg(strConcat);
    }

    public static zzbdo zza(long j) {
        zzbjb[] zzbjbVarArr = zzo;
        zzbjb zzbjbVar = null;
        if (j < zzbjbVarArr.length && j >= 0) {
            zzbjbVar = zzbjbVarArr[(int) j];
        }
        if (zzbjbVar != null) {
            return zzbjbVar.zzr;
        }
        return zzbdo.zzd(INTERNAL_ERROR.zzr.zza().zza()).zzg("Unrecognized HTTP/2 error code: " + j);
    }
}
