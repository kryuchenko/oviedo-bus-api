package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.tlv.TLVUtil;
import org.jmrtd.APDULevelEACCACapable;
import org.jmrtd.Util;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: classes6.dex */
public class EACCAAPDUSender implements APDULevelEACCACapable {
    private static final byte INS_BSI_GENERAL_AUTHENTICATE = -122;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public EACCAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    @Override // org.jmrtd.APDULevelEACCACapable
    public synchronized void sendMSEKAT(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException {
        byte[] bArr3 = new byte[bArr.length + (bArr2 != null ? bArr2.length : 0)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        }
        CommandAPDU commandAPDU = new CommandAPDU(0, 34, 65, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256, bArr3);
        commandAPDU.getBytes();
        short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU).getSW();
        if (sw != -28672) {
            throw new CardServiceException("Sending MSE KAT failed", sw);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0007, B:8:0x0010, B:9:0x0023, B:14:0x0038, B:24:0x006c, B:25:0x0073, B:18:0x0061, B:13:0x002f, B:15:0x004b), top: B:30:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[Catch: all -> 0x0074, TRY_ENTER, TryCatch #0 {, blocks: (B:5:0x0007, B:8:0x0010, B:9:0x0023, B:14:0x0038, B:24:0x006c, B:25:0x0073, B:18:0x0061, B:13:0x002f, B:15:0x004b), top: B:30:0x0007, inners: #1 }] */
    @Override // org.jmrtd.APDULevelEACCACapable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void sendMSESetATIntAuth(APDUWrapper aPDUWrapper, String str, BigInteger bigInteger) throws CardServiceException {
        ResponseAPDU responseAPDUTransmit;
        short sw;
        if (bigInteger != null) {
            if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
                responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 65, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, Util.toOIDBytes(str)));
                sw = responseAPDUTransmit == null ? (short) -1 : (short) responseAPDUTransmit.getSW();
                if (sw != -28672) {
                    throw new CardServiceException("Sending MSE AT failed", sw);
                }
            } else {
                byte[] oIDBytes = Util.toOIDBytes(str);
                byte[] bArrWrapDO = TLVUtil.wrapDO(CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, Util.i2os(bigInteger));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayOutputStream.write(oIDBytes);
                    byteArrayOutputStream.write(bArrWrapDO);
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Exception", (Throwable) e);
                }
                responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 65, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, byteArrayOutputStream.toByteArray()));
                if (responseAPDUTransmit == null) {
                }
                if (sw != -28672) {
                }
            }
        } else {
            responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 65, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, Util.toOIDBytes(str)));
            if (responseAPDUTransmit == null) {
            }
            if (sw != -28672) {
            }
        }
    }

    @Override // org.jmrtd.APDULevelEACCACapable
    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, boolean z) throws CardServiceException {
        return sendGeneralAuthenticate(aPDUWrapper, bArr, 256, z);
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i, boolean z) throws CardServiceException {
        byte[] data;
        byte[] bArrWrapDO = TLVUtil.wrapDO(124, bArr);
        ResponseAPDU responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z ? 0 : 16, -122, 0, 0, bArrWrapDO, i));
        short sw = (short) responseAPDUTransmit.getSW();
        if (sw == 26368) {
            responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z ? 0 : 16, -122, 0, 0, bArrWrapDO, 256));
        }
        if (sw != -28672) {
            throw new CardServiceException("Sending general authenticate failed", sw);
        }
        data = responseAPDUTransmit.getData();
        try {
            data = TLVUtil.unwrapDO(124, data);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not unwrap response to GENERAL AUTHENTICATE", (Throwable) e);
        }
        return data;
    }
}
