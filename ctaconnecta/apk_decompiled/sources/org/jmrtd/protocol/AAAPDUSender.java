package org.jmrtd.protocol;

import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.util.Hex;
import org.jmrtd.APDULevelAACapable;

/* loaded from: classes6.dex */
public class AAAPDUSender implements APDULevelAACapable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public AAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a1  */
    @Override // org.jmrtd.APDULevelAACapable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized byte[] sendInternalAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        ResponseAPDU responseAPDUTransmit;
        int sw;
        short s;
        if (bArr != null) {
            if (bArr.length == 8) {
                CommandAPDU commandAPDU = new CommandAPDU(0, -120, 0, 0, bArr, 256);
                byte[] data = null;
                try {
                    responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
                    try {
                        sw = responseAPDUTransmit.getSW();
                    } catch (CardServiceException e) {
                        e = e;
                        LOGGER.log(Level.INFO, "Exception during transmission of command APDU = " + Hex.bytesToHexString(commandAPDU.getBytes()), (Throwable) e);
                        sw = e.getSW();
                        s = (short) sw;
                        if (s != -28672) {
                        }
                        if ((65280 & s) != 24832) {
                        }
                    }
                } catch (CardServiceException e2) {
                    e = e2;
                    responseAPDUTransmit = null;
                }
                s = (short) sw;
                if (s != -28672 && responseAPDUTransmit != null) {
                    return responseAPDUTransmit.getData();
                }
                if ((65280 & s) != 24832) {
                    byte[] data2 = responseAPDUTransmit == null ? null : responseAPDUTransmit.getData();
                    ResponseAPDU responseAPDUTransmit2 = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, -120, 0, 0, bArr, 65536));
                    if (responseAPDUTransmit2 != null) {
                        data = responseAPDUTransmit2.getData();
                    }
                    if (data2 == null && data == null) {
                        throw new CardServiceException("Internal Authenticate failed", s);
                    }
                    return (data2 == null || data != null) ? (data2 != null || data == null) ? data2.length > data.length ? data2 : data : data : data2;
                }
                if (responseAPDUTransmit != null && responseAPDUTransmit.getData() != null) {
                    LOGGER.warning("Internal Authenticate may not have succeeded, got status word " + Integer.toHexString(s & UShort.MAX_VALUE));
                    return responseAPDUTransmit.getData();
                }
                throw new CardServiceException("Internal Authenticate failed", s);
            }
        }
        throw new IllegalArgumentException("rndIFD wrong length");
    }
}
