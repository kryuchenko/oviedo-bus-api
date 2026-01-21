package org.jmrtd.protocol;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.util.Hex;
import org.jmrtd.APDULevelReadBinaryCapable;

/* loaded from: classes6.dex */
public class ReadBinaryAPDUSender implements APDULevelReadBinaryCapable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;
    private CardService service;

    public ReadBinaryAPDUSender(CardService cardService) {
        this.service = cardService;
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    @Override // org.jmrtd.APDULevelReadBinaryCapable
    public synchronized void sendSelectApplet(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        if (bArr == null) {
            throw new IllegalArgumentException("AID cannot be null");
        }
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 4, 12, bArr);
        checkStatusWordAfterFileOperation(commandAPDU, this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU));
    }

    @Override // org.jmrtd.APDULevelReadBinaryCapable
    public synchronized void sendSelectFile(APDUWrapper aPDUWrapper, short s) throws CardServiceException {
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 2, 12, new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)}, 0);
        ResponseAPDU responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
        if (responseAPDUTransmit == null) {
            return;
        }
        checkStatusWordAfterFileOperation(commandAPDU, responseAPDUTransmit);
    }

    @Override // org.jmrtd.APDULevelReadBinaryCapable
    public synchronized byte[] sendReadBinary(APDUWrapper aPDUWrapper, int i, int i2, int i3, boolean z, boolean z2) throws CardServiceException {
        CommandAPDU commandAPDU;
        CommandAPDU commandAPDU2;
        int i4;
        int sw;
        ResponseAPDU responseAPDUTransmit = null;
        if (i3 == 0) {
            return null;
        }
        byte b = (byte) ((65280 & i2) >> 8);
        byte b2 = (byte) (i2 & 255);
        if (z2) {
            int i5 = i3 < 128 ? i3 + 2 : i3 < 256 ? i3 + 3 : i3;
            int i6 = i5 > 256 ? 256 : i5;
            commandAPDU2 = new CommandAPDU(0, -79, 0, 0, new byte[]{84, 2, b, b2}, i6);
            i4 = i6;
        } else {
            if (z) {
                commandAPDU = new CommandAPDU(0, -80, (byte) i, b2, i3);
            } else {
                commandAPDU = new CommandAPDU(0, -80, b, b2, i3);
            }
            commandAPDU2 = commandAPDU;
            i4 = i3;
        }
        try {
            responseAPDUTransmit = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU2);
            sw = responseAPDUTransmit.getSW();
        } catch (CardServiceException e) {
            if (this.service.isConnectionLost(e)) {
                throw e;
            }
            LOGGER.log(Level.FINE, "Exception during READ BINARY", (Throwable) e);
            sw = e.getSW();
        }
        short s = (short) sw;
        byte[] responseData = getResponseData(responseAPDUTransmit, z2);
        if (responseData == null || responseData.length == 0) {
            LOGGER.warning("Empty response data: response APDU bytes = " + Arrays.toString(responseData) + ", le = " + i4 + ", sw = " + Integer.toHexString(s));
        } else {
            checkStatusWordAfterFileOperation(commandAPDU2, responseAPDUTransmit);
        }
        return responseData;
    }

    private static byte[] getResponseData(ResponseAPDU responseAPDU, boolean z) throws CardServiceException {
        if (responseAPDU == null) {
            return null;
        }
        byte[] data = responseAPDU.getData();
        if (data == null) {
            throw new CardServiceException("Malformed read binary long response data");
        }
        if (!z) {
            return data;
        }
        if (data[0] != 83) {
            throw new CardServiceException("Malformed read binary long response data");
        }
        int i = data[1];
        int i2 = (((byte) (i & 128)) == Byte.MIN_VALUE ? (i & 15) + 1 : 1) + 1;
        int length = data.length - i2;
        byte[] bArr = new byte[length];
        System.arraycopy(data, i2, bArr, 0, length);
        return bArr;
    }

    private static void checkStatusWordAfterFileOperation(CommandAPDU commandAPDU, ResponseAPDU responseAPDU) throws CardServiceException {
        short sw = (short) responseAPDU.getSW();
        String str = "CAPDU = " + Hex.bytesToHexString(commandAPDU.getBytes()) + ", RAPDU = " + Hex.bytesToHexString(responseAPDU.getBytes());
        if (sw != -28672) {
            if (sw != 27010) {
                if (sw == 27266) {
                    throw new CardServiceException("File not found, " + str, sw);
                }
                if (sw != 27013 && sw != 27014) {
                    throw new CardServiceException("Error occured, " + str, sw);
                }
            }
            throw new CardServiceException("Access to file denied, " + str, sw);
        }
    }
}
