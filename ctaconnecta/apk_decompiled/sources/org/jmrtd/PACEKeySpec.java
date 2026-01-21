package org.jmrtd;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import net.sf.scuba.util.Hex;
import org.jmrtd.protocol.PACEProtocol;

/* loaded from: classes6.dex */
public class PACEKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -7113246293247012560L;
    private byte[] key;
    private byte keyReference;

    public PACEKeySpec(String str, byte b) {
        this(Util.getBytes(str), b);
    }

    public PACEKeySpec(byte[] bArr, byte b) {
        this.keyReference = b;
        this.key = bArr;
    }

    public static PACEKeySpec createMRZKey(BACKeySpec bACKeySpec) throws GeneralSecurityException {
        return new PACEKeySpec(PACEProtocol.computeKeySeedForPACE(bACKeySpec), (byte) 1);
    }

    public static PACEKeySpec createCANKey(String str) {
        return new PACEKeySpec(str, (byte) 2);
    }

    public static PACEKeySpec createPINKey(String str) {
        return new PACEKeySpec(str, (byte) 3);
    }

    public static PACEKeySpec createPUKKey(String str) {
        return new PACEKeySpec(str, (byte) 4);
    }

    @Override // org.jmrtd.AccessKeySpec
    public String getAlgorithm() {
        return "PACE";
    }

    public byte getKeyReference() {
        return this.keyReference;
    }

    @Override // org.jmrtd.AccessKeySpec
    public byte[] getKey() {
        return this.key;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.key) + 31) * 31) + this.keyReference;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEKeySpec pACEKeySpec = (PACEKeySpec) obj;
        return Arrays.equals(this.key, pACEKeySpec.key) && this.keyReference == pACEKeySpec.keyReference;
    }

    public String toString() {
        return "PACEKeySpec [key: " + Hex.bytesToHexString(this.key) + ", keyReference: " + keyReferenceToString(this.keyReference) + "]";
    }

    private static String keyReferenceToString(byte b) {
        if (b == 0) {
            return "NO";
        }
        if (b == 1) {
            return "MRZ";
        }
        if (b == 2) {
            return "CAN";
        }
        if (b == 3) {
            return "PIN";
        }
        if (b == 4) {
            return "PUK";
        }
        return Integer.toString(b);
    }
}
