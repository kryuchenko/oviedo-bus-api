package org.spongycastle.jce;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;

/* loaded from: classes6.dex */
public class ECNamedCurveTable {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r0 = org.spongycastle.asn1.x9.ECNamedCurveTable.getByName(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        X9ECParameters byName = CustomNamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = CustomNamedCurves.getByOID(new ASN1ObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
            }
            if (byName == null && byName == null) {
                try {
                    byName = org.spongycastle.asn1.x9.ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(str));
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        if (byName == null) {
            return null;
        }
        X9ECParameters x9ECParameters = byName;
        return new ECNamedCurveParameterSpec(str, x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
    }

    public static Enumeration getNames() {
        return org.spongycastle.asn1.x9.ECNamedCurveTable.getNames();
    }
}
