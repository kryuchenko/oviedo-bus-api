package org.jmrtd;

import com.bumptech.glide.load.Key;
import com.google.api.client.http.HttpStatusCodes;
import com.google.maps.android.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVUtil;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.jmrtd.lds.PACEInfo;
import org.jmrtd.lds.SecurityInfo;
import org.jmrtd.lds.icao.MRZInfo;

/* loaded from: classes6.dex */
public final class Util {
    public static final int ENC_MODE = 1;
    public static final int MAC_MODE = 2;
    public static final int PACE_MODE = 3;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final Provider BC_PROVIDER = new BouncyCastleProvider();

    private Util() {
    }

    public static Provider getBouncyCastleProvider() {
        return BC_PROVIDER;
    }

    public static SecretKey deriveKey(byte[] bArr, int i) throws GeneralSecurityException {
        return deriveKey(bArr, "DESede", 128, i);
    }

    public static SecretKey deriveKey(byte[] bArr, String str, int i, int i2) throws GeneralSecurityException {
        return deriveKey(bArr, str, i, null, i2);
    }

    public static SecretKey deriveKey(byte[] bArr, String str, int i, byte[] bArr2, int i2) throws GeneralSecurityException {
        return deriveKey(bArr, str, i, bArr2, i2, (byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SecretKey deriveKey(byte[] bArr, String str, int i, byte[] bArr2, int i2, byte b) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4;
        MessageDigest messageDigest = getMessageDigest(inferDigestAlgorithmFromCipherAlgorithmForKeyDerivation(str, i));
        messageDigest.reset();
        messageDigest.update(bArr);
        if (bArr2 != null) {
            messageDigest.update(bArr2);
        }
        messageDigest.update(new byte[]{0, 0, 0, (byte) i2});
        byte[] bArrDigest = messageDigest.digest();
        if (!"DESede".equalsIgnoreCase(str) && !"3DES".equalsIgnoreCase(str)) {
            if (!"AES".equalsIgnoreCase(str) && !str.startsWith("AES")) {
                bArr4 = null;
            } else if (i == 128) {
                bArr3 = new byte[16];
                System.arraycopy(bArrDigest, 0, bArr3, 0, 16);
            } else if (i == 192) {
                bArr3 = new byte[24];
                System.arraycopy(bArrDigest, 0, bArr3, 0, 24);
            } else if (i == 256) {
                byte[] bArr5 = new byte[32];
                System.arraycopy(bArrDigest, 0, bArr5, 0, 32);
                bArr4 = bArr5;
            } else {
                throw new IllegalArgumentException("KDF can only use AES with 128-bit, 192-bit key or 256-bit length, found: " + i + "-bit key length");
            }
            if (b != 0) {
                return new SecretKeySpec(bArr4, str);
            }
            return new PACESecretKeySpec(bArr4, str, b);
        }
        if (i == 112 || i == 128) {
            bArr3 = new byte[24];
            System.arraycopy(bArrDigest, 0, bArr3, 0, 8);
            System.arraycopy(bArrDigest, 8, bArr3, 8, 8);
            System.arraycopy(bArrDigest, 0, bArr3, 16, 8);
        } else {
            throw new IllegalArgumentException("KDF can only use DESede with 128-bit key length");
        }
        bArr4 = bArr3;
        if (b != 0) {
        }
    }

    public static byte[] computeKeySeed(String str, String str2, String str3, String str4, boolean z) throws GeneralSecurityException {
        return computeKeySeed(str + MRZInfo.checkDigit(str) + str2 + MRZInfo.checkDigit(str2) + str3 + MRZInfo.checkDigit(str3), str4, z);
    }

    public static byte[] computeKeySeed(String str, String str2, boolean z) throws GeneralSecurityException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(getBytes(str));
        byte[] bArrDigest = messageDigest.digest();
        if (!z) {
            return bArrDigest;
        }
        byte[] bArr = new byte[16];
        System.arraycopy(bArrDigest, 0, bArr, 0, 16);
        return bArr;
    }

    public static byte[] pad(byte[] bArr, int i) {
        return pad(bArr, 0, bArr.length, i);
    }

    public static byte[] pad(byte[] bArr, int i, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr, i, i2);
        byteArrayOutputStream.write(-128);
        while (byteArrayOutputStream.size() % i3 != 0) {
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] unpad(byte[] bArr) throws BadPaddingException {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        if ((bArr[length] & 255) != 128) {
            throw new BadPaddingException("Expected constant 0x80, found 0x" + Integer.toHexString(bArr[length] & 255));
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static byte[] recoverMessage(int i, byte[] bArr) {
        int i2;
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("Plaintext is too short to recover message");
        }
        if (((bArr[bArr.length - 1] & 15) ^ 12) != 0) {
            throw new NumberFormatException("Could not get M1, malformed trailer");
        }
        if (((bArr[bArr.length - 1] & 255) ^ 188) == 0) {
            i2 = 1;
        } else {
            if (((bArr[bArr.length - 1] & 255) ^ HttpStatusCodes.STATUS_CODE_NO_CONTENT) != 0) {
                throw new NumberFormatException("Not an ISO 9796-2 scheme 2 signature trailer");
            }
            i2 = 2;
        }
        byte b = bArr[0];
        if (((b & ISO7816.INS_GET_RESPONSE) ^ 64) != 0) {
            throw new NumberFormatException("Could not get M1");
        }
        if ((b & 32) == 0) {
            throw new NumberFormatException("Could not get M1, first byte indicates partial recovery not enabled: " + Integer.toHexString(bArr[0]));
        }
        int i3 = 0;
        while (i3 < bArr.length && ((bArr[i3] & 15) ^ 10) != 0) {
            i3++;
        }
        int i4 = i3 + 1;
        int length = ((bArr.length - i2) - i) - i4;
        if (length <= 0) {
            throw new NumberFormatException("Could not get M1");
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i4, bArr2, 0, length);
        return bArr2;
    }

    public static byte[] getRawECDSASignature(byte[] bArr, int i) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Enumeration objects = ((ASN1Sequence) aSN1InputStream.readObject()).getObjects();
            while (objects.hasMoreElements()) {
                byteArrayOutputStream.write(alignKeyDataToSize(((ASN1Integer) objects.nextElement()).getValue().toByteArray(), i));
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            aSN1InputStream.close();
            byteArrayOutputStream.close();
        }
    }

    public static byte[] alignKeyDataToSize(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        int length = bArr.length < i ? bArr.length : i;
        System.arraycopy(bArr, bArr.length - length, bArr2, i - length, length);
        return bArr2;
    }

    public static byte[] i2os(BigInteger bigInteger, int i) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(256L);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            BigInteger bigIntegerMod = bigInteger.mod(bigIntegerValueOf);
            bigInteger = bigInteger.divide(bigIntegerValueOf);
            bArr[(i - 1) - i2] = (byte) bigIntegerMod.intValue();
        }
        return bArr;
    }

    public static byte[] i2os(BigInteger bigInteger) {
        int length = bigInteger.toString(16).length();
        if (length % 2 != 0) {
            length++;
        }
        return i2os(bigInteger, length / 2);
    }

    public static BigInteger os2i(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException();
        }
        return os2i(bArr, 0, bArr.length);
    }

    public static BigInteger os2i(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException();
        }
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(256L);
        for (int i3 = i; i3 < i + i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.multiply(bigIntegerValueOf).add(BigInteger.valueOf(bArr[i3] & 255));
        }
        return bigIntegerAdd;
    }

    public static BigInteger os2fe(byte[] bArr, BigInteger bigInteger) {
        return os2i(bArr).mod(bigInteger);
    }

    public static String inferDigestAlgorithmFromSignatureAlgorithm(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String upperCase = str.toUpperCase();
        String str2 = upperCase.contains("WITH") ? upperCase.split("WITH")[0] : null;
        if ("SHA1".equalsIgnoreCase(str2)) {
            return "SHA-1";
        }
        if ("SHA224".equalsIgnoreCase(str2)) {
            return "SHA-224";
        }
        if ("SHA256".equalsIgnoreCase(str2)) {
            return "SHA-256";
        }
        if ("SHA384".equalsIgnoreCase(str2)) {
            return "SHA-384";
        }
        return "SHA512".equalsIgnoreCase(str2) ? "SHA-512" : str2;
    }

    public static String inferDigestAlgorithmFromCipherAlgorithmForKeyDerivation(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if ("DESede".equals(str) || "AES-128".equals(str)) {
            return "SHA-1";
        }
        if ("AES".equals(str) && i == 128) {
            return "SHA-1";
        }
        if ("AES-256".equals(str) || "AES-192".equals(str)) {
            return "SHA-256";
        }
        if ("AES".equals(str) && (i == 192 || i == 256)) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unsupported cipher algorithm or key length \"" + str + "\", " + i);
    }

    public static DHParameterSpec toExplicitDHParameterSpec(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g = dHParameters.getG();
        BigInteger q = dHParameters.getQ();
        int l = dHParameters.getL();
        if (q == null) {
            return new DHParameterSpec(p, g, l);
        }
        return new PACEInfo.DHCParameterSpec(p, g, q);
    }

    public static String getDetailedPublicKeyAlgorithm(PublicKey publicKey) {
        if (publicKey == null) {
            return BuildConfig.TRAVIS;
        }
        String algorithm = publicKey.getAlgorithm();
        if (publicKey instanceof RSAPublicKey) {
            return algorithm + " [" + ((RSAPublicKey) publicKey).getModulus().bitLength() + " bit]";
        }
        if (publicKey instanceof ECPublicKey) {
            String curveName = getCurveName(((ECPublicKey) publicKey).getParams());
            if (curveName != null) {
                return algorithm + " [" + curveName + "]";
            }
        } else if (publicKey instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            dHPublicKey.getY();
            DHParameterSpec params = dHPublicKey.getParams();
            BigInteger g = params.getG();
            return algorithm + " [p.length = " + params.getP().bitLength() + ", g.length = " + g.bitLength() + ", l = " + params.getL() + "]";
        }
        return algorithm;
    }

    public static String getDetailedPrivateKeyAlgorithm(PrivateKey privateKey) {
        String curveName;
        if (privateKey == null) {
            return BuildConfig.TRAVIS;
        }
        String algorithm = privateKey.getAlgorithm();
        if (privateKey instanceof RSAPrivateKey) {
            return algorithm + " [" + ((RSAPrivateKey) privateKey).getModulus().bitLength() + " bit]";
        }
        if (!(privateKey instanceof ECPrivateKey) || (curveName = getCurveName(((ECPrivateKey) privateKey).getParams())) == null) {
            return algorithm;
        }
        return algorithm + " [" + curveName + "]";
    }

    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        ECNamedCurveSpec namedCurveSpec = toNamedCurveSpec(eCParameterSpec);
        if (namedCurveSpec == null) {
            return null;
        }
        return namedCurveSpec.getName();
    }

    public static ECParameterSpec toExplicitECParameterSpec(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return toExplicitECParameterSpec(toECNamedCurveSpec(eCNamedCurveParameterSpec));
    }

    public static ECParameterSpec toExplicitECParameterSpec(ECParameterSpec eCParameterSpec) {
        try {
            ECPoint generator = eCParameterSpec.getGenerator();
            BigInteger order = eCParameterSpec.getOrder();
            int cofactor = eCParameterSpec.getCofactor();
            EllipticCurve curve = eCParameterSpec.getCurve();
            BigInteger a = curve.getA();
            BigInteger b = curve.getB();
            ECField field = curve.getField();
            if (field instanceof ECFieldFp) {
                return new ECParameterSpec(new EllipticCurve(new ECFieldFp(((ECFieldFp) field).getP()), a, b), generator, order, cofactor);
            }
            if (!(field instanceof ECFieldF2m)) {
                LOGGER.warning("Could not make named EC param spec explicit");
                return eCParameterSpec;
            }
            return new ECParameterSpec(new EllipticCurve(new ECFieldF2m(((ECFieldF2m) field).getM()), a, b), generator, order, cofactor);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not make named EC param spec explicit", (Throwable) e);
            return eCParameterSpec;
        }
    }

    private static ECNamedCurveSpec toNamedCurveSpec(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec == null) {
            return null;
        }
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            return (ECNamedCurveSpec) eCParameterSpec;
        }
        ArrayList list = Collections.list(ECNamedCurveTable.getNames());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ECNamedCurveSpec eCNamedCurveSpec = toECNamedCurveSpec(ECNamedCurveTable.getParameterSpec((String) it.next()));
            if (eCNamedCurveSpec.getCurve().equals(eCParameterSpec.getCurve()) && eCNamedCurveSpec.getGenerator().equals(eCParameterSpec.getGenerator()) && eCNamedCurveSpec.getOrder().equals(eCParameterSpec.getOrder()) && eCNamedCurveSpec.getCofactor() == eCParameterSpec.getCofactor()) {
                arrayList.add(eCNamedCurveSpec);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (ECNamedCurveSpec) arrayList.get(0);
        }
        return (ECNamedCurveSpec) arrayList.get(0);
    }

    public static ECNamedCurveSpec toECNamedCurveSpec(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return new ECNamedCurveSpec(eCNamedCurveParameterSpec.getName(), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.getG(), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH(), eCNamedCurveParameterSpec.getSeed());
    }

    public static SubjectPublicKeyInfo toSubjectPublicKeyInfo(PublicKey publicKey) {
        try {
            String algorithm = publicKey.getAlgorithm();
            if ("EC".equals(algorithm) || "ECDH".equals(algorithm) || (publicKey instanceof ECPublicKey)) {
                try {
                    SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject());
                    AlgorithmIdentifier algorithm2 = subjectPublicKeyInfo.getAlgorithm();
                    String id = algorithm2.getAlgorithm().getId();
                    if (!SecurityInfo.ID_EC_PUBLIC_KEY.equals(id)) {
                        throw new IllegalStateException("Was expecting id-ecPublicKey (" + SecurityInfo.ID_EC_PUBLIC_KEY_TYPE + "), found " + id);
                    }
                    ASN1Primitive aSN1Primitive = algorithm2.getParameters().toASN1Primitive();
                    if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Primitive;
                        X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
                        if (byOID == null) {
                            throw new IllegalStateException("Could not find X9.62 named curve for OID " + aSN1ObjectIdentifier.getId());
                        }
                        org.bouncycastle.math.ec.ECPoint g = byOID.getG();
                        X9ECParameters x9ECParameters = new X9ECParameters(byOID.getCurve(), new X9ECPoint(g.getCurve().createPoint(g.getAffineXCoord().toBigInteger(), g.getAffineYCoord().toBigInteger()), false), byOID.getN(), byOID.getH(), byOID.getSeed());
                        if (publicKey instanceof org.bouncycastle.jce.interfaces.ECPublicKey) {
                            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(subjectPublicKeyInfo.getAlgorithm().getAlgorithm(), x9ECParameters.toASN1Primitive()), ((org.bouncycastle.jce.interfaces.ECPublicKey) publicKey).getQ().getEncoded(false));
                        }
                    }
                    return subjectPublicKeyInfo;
                } finally {
                }
            }
            if (!"DH".equals(algorithm) && !(publicKey instanceof DHPublicKey)) {
                throw new IllegalArgumentException("Unrecognized key type, found " + publicKey.getAlgorithm() + ", should be DH or ECDH");
            }
            try {
                AlgorithmIdentifier algorithm3 = SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getAlgorithm();
                DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
                DHParameterSpec params = dHPublicKey.getParams();
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(algorithm3.getAlgorithm(), new DHParameter(params.getP(), params.getG(), params.getL()).toASN1Primitive()), new ASN1Integer(dHPublicKey.getY()));
            } finally {
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception", (Throwable) e);
            return null;
        }
        LOGGER.log(Level.WARNING, "Exception", (Throwable) e);
        return null;
    }

    public static PublicKey toPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            try {
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded("DER"));
                try {
                    return KeyFactory.getInstance("DH").generatePublic(x509EncodedKeySpec);
                } catch (GeneralSecurityException e) {
                    LOGGER.log(Level.FINE, "Not DH public key? Fine, let's try EC public key", (Throwable) e);
                    return KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(x509EncodedKeySpec);
                }
            } catch (Exception e2) {
                LOGGER.log(Level.WARNING, "Exception", (Throwable) e2);
                return null;
            }
        } catch (GeneralSecurityException e3) {
            LOGGER.log(Level.WARNING, "Exception", (Throwable) e3);
            return null;
        }
    }

    public static PublicKey reconstructPublicKey(PublicKey publicKey) {
        if (!(publicKey instanceof ECPublicKey)) {
            return publicKey;
        }
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            return KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(new ECPublicKeySpec(eCPublicKey.getW(), toExplicitECParameterSpec(eCPublicKey.getParams())));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not make public key param spec explicit", (Throwable) e);
            return publicKey;
        }
    }

    public static ECPoint os2ECPoint(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            try {
                if (dataInputStream.read() != 4) {
                    throw new IllegalArgumentException("Expected encoded ECPoint to start with 0x04");
                }
                int length = (bArr.length - 1) / 2;
                byte[] bArr2 = new byte[length];
                byte[] bArr3 = new byte[length];
                dataInputStream.readFully(bArr2);
                dataInputStream.readFully(bArr3);
                dataInputStream.close();
                ECPoint eCPoint = new ECPoint(os2i(bArr2), os2i(bArr3));
                try {
                    return eCPoint;
                } catch (IOException e) {
                    return eCPoint;
                }
            } catch (IOException e2) {
                throw new IllegalArgumentException("Exception", e2);
            }
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", (Throwable) e3);
            }
        }
    }

    public static byte[] ecPoint2OS(ECPoint eCPoint, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        try {
            byteArrayOutputStream.write(4);
            double d = i / 8.0d;
            byteArrayOutputStream.write(i2os(affineX, (int) Math.ceil(d)));
            byteArrayOutputStream.write(i2os(affineY, (int) Math.ceil(d)));
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("Exception", e);
        }
    }

    public static String inferProtocolIdentifier(PublicKey publicKey) {
        String algorithm = publicKey.getAlgorithm();
        if ("EC".equals(algorithm) || "ECDH".equals(algorithm)) {
            return SecurityInfo.ID_PK_ECDH;
        }
        if ("DH".equals(algorithm)) {
            return SecurityInfo.ID_PK_DH;
        }
        throw new IllegalArgumentException("Wrong key type. Was expecting ECDH or DH public key.");
    }

    public static ECPoint add(ECPoint eCPoint, ECPoint eCPoint2, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).add(toBouncyCastleECPoint(eCPoint2, eCParameterSpec)));
    }

    public static ECPoint multiply(BigInteger bigInteger, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).multiply(bigInteger));
    }

    public static boolean isPointOnCurve(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        BigInteger prime = getPrime(eCParameterSpec);
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a = curve.getA();
        return affineY.multiply(affineY).mod(prime).equals(affineX.multiply(affineX).multiply(affineX).add(a.multiply(affineX)).add(curve.getB()).mod(prime));
    }

    public static byte[] getBytes(String str) {
        byte[] bytes = str.getBytes();
        try {
            return str.getBytes(Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.WARNING, "Exception", (Throwable) e);
            return bytes;
        }
    }

    public static BigInteger getPrime(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec == null) {
            throw new IllegalArgumentException("Parameters null");
        }
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            return ((DHParameterSpec) algorithmParameterSpec).getP();
        }
        if (algorithmParameterSpec instanceof ECParameterSpec) {
            ECField field = ((ECParameterSpec) algorithmParameterSpec).getCurve().getField();
            if (!(field instanceof ECFieldFp)) {
                throw new IllegalStateException("Was expecting prime field of type ECFieldFp, found " + field.getClass().getCanonicalName());
            }
            return ((ECFieldFp) field).getP();
        }
        throw new IllegalArgumentException("Unsupported agreement algorithm, was expecting DHParameterSpec or ECParameterSpec, found " + algorithmParameterSpec.getClass().getCanonicalName());
    }

    public static String inferKeyAgreementAlgorithm(PublicKey publicKey) {
        if (publicKey instanceof ECPublicKey) {
            return "ECDH";
        }
        if (publicKey instanceof DHPublicKey) {
            return "DH";
        }
        throw new IllegalArgumentException("Unsupported public key: " + publicKey);
    }

    public static BigInteger computeAffineY(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        ECCurve bouncyCastleECCurve = toBouncyCastleECCurve(eCParameterSpec);
        ECFieldElement a = bouncyCastleECCurve.getA();
        ECFieldElement b = bouncyCastleECCurve.getB();
        ECFieldElement eCFieldElementFromBigInteger = bouncyCastleECCurve.fromBigInteger(bigInteger);
        return eCFieldElementFromBigInteger.multiply(eCFieldElementFromBigInteger).add(a).multiply(eCFieldElementFromBigInteger).add(b).sqrt().toBigInteger();
    }

    public static org.bouncycastle.math.ec.ECPoint toBouncyCastleECPoint(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return toBouncyCastleECCurve(eCParameterSpec).createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECPoint fromBouncyCastleECPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
        org.bouncycastle.math.ec.ECPoint eCPointNormalize = eCPoint.normalize();
        if (!eCPointNormalize.isValid()) {
            LOGGER.warning("point not valid");
        }
        return new ECPoint(eCPointNormalize.getAffineXCoord().toBigInteger(), eCPointNormalize.getAffineYCoord().toBigInteger());
    }

    public static boolean isValid(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return toBouncyCastleECPoint(eCPoint, eCParameterSpec).isValid();
    }

    public static ECPoint normalize(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).normalize());
    }

    private static ECCurve toBouncyCastleECCurve(ECParameterSpec eCParameterSpec) {
        EllipticCurve curve = eCParameterSpec.getCurve();
        ECField field = curve.getField();
        if (!(field instanceof ECFieldFp)) {
            throw new IllegalArgumentException("Only prime field supported (for now), found " + field.getClass().getCanonicalName());
        }
        int cofactor = eCParameterSpec.getCofactor();
        return new ECCurve.Fp(getPrime(eCParameterSpec), curve.getA(), curve.getB(), eCParameterSpec.getOrder(), BigInteger.valueOf(cofactor));
    }

    public static ECPublicKeyParameters toBouncyECPublicKeyParameters(ECPublicKey eCPublicKey) {
        ECParameterSpec params = eCPublicKey.getParams();
        return new ECPublicKeyParameters(toBouncyCastleECPoint(eCPublicKey.getW(), params), toBouncyECDomainParameters(params));
    }

    public static ECPrivateKeyParameters toBouncyECPrivateKeyParameters(ECPrivateKey eCPrivateKey) {
        return new ECPrivateKeyParameters(eCPrivateKey.getS(), toBouncyECDomainParameters(eCPrivateKey.getParams()));
    }

    public static ECDomainParameters toBouncyECDomainParameters(ECParameterSpec eCParameterSpec) {
        return new ECDomainParameters(toBouncyCastleECCurve(eCParameterSpec), toBouncyCastleECPoint(eCParameterSpec.getGenerator(), eCParameterSpec), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static Cipher getCipher(String str) throws GeneralSecurityException {
        try {
            return Cipher.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this cipher, falling back to explicit BC", (Throwable) e);
            return Cipher.getInstance(str, BC_PROVIDER);
        }
    }

    public static Cipher getCipher(String str, int i, java.security.Key key) throws GeneralSecurityException {
        try {
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(i, key);
            return cipher;
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Cipher, falling back to explicit BC", (Throwable) e);
            Cipher cipher2 = Cipher.getInstance(str, BC_PROVIDER);
            cipher2.init(i, key);
            return cipher2;
        }
    }

    public static KeyAgreement getKeyAgreement(String str) throws GeneralSecurityException {
        try {
            return KeyAgreement.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Agreement, falling back to explicit BC", (Throwable) e);
            return KeyAgreement.getInstance(str, BC_PROVIDER);
        }
    }

    public static KeyPairGenerator getKeyPairGenerator(String str) throws GeneralSecurityException {
        try {
            return KeyPairGenerator.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Pair Generator, falling back to explicit BC", (Throwable) e);
            return KeyPairGenerator.getInstance(str, BC_PROVIDER);
        }
    }

    public static Mac getMac(String str) throws GeneralSecurityException {
        try {
            return Mac.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", (Throwable) e);
            return Mac.getInstance(str, BC_PROVIDER);
        }
    }

    public static Mac getMac(String str, java.security.Key key) throws GeneralSecurityException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", (Throwable) e);
            Mac mac2 = Mac.getInstance(str, BC_PROVIDER);
            mac2.init(key);
            return mac2;
        }
    }

    public static MessageDigest getMessageDigest(String str) throws GeneralSecurityException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Message Digest, falling back to explicit BC", (Throwable) e);
            return MessageDigest.getInstance(str, BC_PROVIDER);
        }
    }

    public static PublicKey getPublicKey(String str, KeySpec keySpec) throws GeneralSecurityException {
        try {
            return KeyFactory.getInstance(str).generatePublic(keySpec);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Factory or Public Key, falling back to explicit BC", (Throwable) e);
            return KeyFactory.getInstance(str, BC_PROVIDER).generatePublic(keySpec);
        }
    }

    public static Signature getSignature(String str) throws GeneralSecurityException {
        try {
            return Signature.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Signature, falling back to explicit BC", (Throwable) e);
            return Signature.getInstance(str, BC_PROVIDER);
        }
    }

    public static CertificateFactory getCertificateFactory(String str) throws GeneralSecurityException {
        try {
            return CertificateFactory.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Certificate Factory, falling back ot explicit BC", (Throwable) e);
            return CertificateFactory.getInstance(str, BC_PROVIDER);
        }
    }

    public static byte[] toOIDBytes(String str) {
        try {
            TLVInputStream tLVInputStream = new TLVInputStream(new ByteArrayInputStream(new ASN1ObjectIdentifier(str).getEncoded()));
            try {
                tLVInputStream.readTag();
                tLVInputStream.readLength();
                byte[] value = tLVInputStream.readValue();
                tLVInputStream.close();
                return TLVUtil.wrapDO(128, value);
            } catch (Throwable th) {
                tLVInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Illegal OID: \"" + str, e);
        }
    }

    public static List<byte[]> partition(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr == null || i <= 0) {
            throw new IllegalArgumentException("Cannot partition");
        }
        int iMin = Math.min(bArr.length, i);
        int length = bArr.length / iMin;
        int length2 = bArr.length % iMin;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(bArr, i2, bArr2, 0, iMin);
            arrayList.add(bArr2);
            i2 += iMin;
        }
        if (length2 != 0) {
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, i2, bArr3, 0, length2);
            arrayList.add(bArr3);
        }
        return arrayList;
    }

    public static byte[] stripLeadingZeroes(byte[] bArr) {
        if (bArr != null && bArr.length > 1) {
            while (bArr.length > 0 && bArr[0] == 0) {
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                bArr = bArr2;
            }
        }
        return bArr;
    }
}
