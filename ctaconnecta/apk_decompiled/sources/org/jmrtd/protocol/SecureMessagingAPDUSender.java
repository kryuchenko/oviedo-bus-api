package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUEvent;
import net.sf.scuba.smartcards.APDUListener;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.util.Hex;
import org.jmrtd.Util;
import org.jmrtd.WrappedAPDUEvent;

/* loaded from: classes6.dex */
public class SecureMessagingAPDUSender {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private int apduCount = 0;
    private CardService service;

    public SecureMessagingAPDUSender(CardService cardService) {
        this.service = cardService;
    }

    public ResponseAPDU transmit(APDUWrapper aPDUWrapper, CommandAPDU commandAPDU) throws Throwable {
        CommandAPDU commandAPDU2;
        CommandAPDU commandAPDU3;
        CommandAPDU commandAPDUWrap = aPDUWrapper != null ? aPDUWrapper.wrap(commandAPDU) : commandAPDU;
        ResponseAPDU responseAPDUTransmit = this.service.transmit(commandAPDUWrap);
        short sw = (short) responseAPDUTransmit.getSW();
        if (aPDUWrapper == null) {
            int i = this.apduCount + 1;
            this.apduCount = i;
            notifyExchangedAPDU(new APDUEvent(this, "PLAIN", i, commandAPDUWrap, responseAPDUTransmit));
            return responseAPDUTransmit;
        }
        try {
            try {
                if (responseAPDUTransmit.getBytes().length <= 2) {
                    commandAPDU3 = commandAPDU;
                    try {
                        throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU3.getBytes()), sw);
                    } catch (CardServiceException e) {
                        e = e;
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU3.getBytes()), e, sw);
                    }
                }
                try {
                    ResponseAPDU responseAPDUUnwrap = aPDUWrapper.unwrap(responseAPDUTransmit);
                    String type = aPDUWrapper.getType();
                    int i2 = this.apduCount + 1;
                    this.apduCount = i2;
                    notifyExchangedAPDU(new WrappedAPDUEvent(this, type, i2, commandAPDU, responseAPDUUnwrap, commandAPDUWrap, responseAPDUTransmit));
                    return responseAPDUUnwrap;
                } catch (CardServiceException e3) {
                    e = e3;
                    throw e;
                } catch (Exception e4) {
                    e = e4;
                    commandAPDU3 = commandAPDU;
                    throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU3.getBytes()), e, sw);
                } catch (Throwable th) {
                    th = th;
                    commandAPDU2 = commandAPDU;
                    responseAPDUTransmit = responseAPDUTransmit;
                    Throwable th2 = th;
                    String type2 = aPDUWrapper.getType();
                    int i3 = this.apduCount + 1;
                    this.apduCount = i3;
                    notifyExchangedAPDU(new WrappedAPDUEvent(this, type2, i3, commandAPDU2, responseAPDUTransmit, commandAPDUWrap, responseAPDUTransmit));
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (CardServiceException e5) {
            e = e5;
        } catch (Exception e6) {
            e = e6;
            commandAPDU3 = commandAPDU;
        } catch (Throwable th4) {
            th = th4;
            commandAPDU2 = commandAPDU;
        }
    }

    public boolean isExtendedAPDULengthSupported() {
        return this.service.isExtendedAPDULengthSupported();
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        this.service.addAPDUListener(aPDUListener);
    }

    public void removeAPDUListener(APDUListener aPDUListener) {
        this.service.removeAPDUListener(aPDUListener);
    }

    protected void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> aPDUListeners = this.service.getAPDUListeners();
        if (aPDUListeners == null || aPDUListeners.isEmpty()) {
            return;
        }
        Iterator<APDUListener> it = aPDUListeners.iterator();
        while (it.hasNext()) {
            it.next().exchangedAPDU(aPDUEvent);
        }
    }

    private List<ResponseAPDU> sendUsingCommandChaining(CommandAPDU commandAPDU, int i) throws CardServiceException {
        List<byte[]> listPartition = Util.partition(i, commandAPDU.getData());
        ArrayList arrayList = new ArrayList(listPartition.size());
        int i2 = 0;
        for (byte[] bArr : listPartition) {
            i2++;
            boolean z = i2 >= listPartition.size();
            int cla = commandAPDU.getCLA();
            if (!z) {
                cla |= 16;
            }
            arrayList.add(this.service.transmit(new CommandAPDU(cla, commandAPDU.getINS(), commandAPDU.getP1(), commandAPDU.getP2(), bArr, commandAPDU.getNe())));
        }
        return arrayList;
    }

    private byte[] continueSendingUsingResponseChaining(APDUWrapper aPDUWrapper, short s, byte[] bArr) throws IOException, CardServiceException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            if ((65280 & s) != 24832) {
                break;
            }
            try {
                try {
                    byteArrayOutputStream.write(bArr);
                    int i = s & 255;
                    if (i <= 0) {
                        break;
                    }
                    ResponseAPDU responseAPDUTransmit = transmit(aPDUWrapper, new CommandAPDU(0, -64, 0, 0, i));
                    byte[] data = responseAPDUTransmit.getData();
                    s = (short) responseAPDUTransmit.getSW();
                    bArr = data;
                } finally {
                }
            } catch (IOException e) {
                throw new CardServiceException("Could not write to stream", e, s);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e2) {
            LOGGER.log(Level.FINE, "Error closing stream", (Throwable) e2);
            return byteArray;
        }
    }
}
