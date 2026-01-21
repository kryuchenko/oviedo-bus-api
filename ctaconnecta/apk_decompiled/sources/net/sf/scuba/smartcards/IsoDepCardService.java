package net.sf.scuba.smartcards;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class IsoDepCardService extends CardService {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private int apduCount = 0;
    private IsoDep isoDep;

    public IsoDepCardService(IsoDep isoDep) {
        this.isoDep = isoDep;
    }

    @Override // net.sf.scuba.smartcards.CardService
    public void open() throws IOException, CardServiceException {
        if (isOpen()) {
            return;
        }
        try {
            this.isoDep.connect();
            if (!this.isoDep.isConnected()) {
                throw new CardServiceException("Failed to connect");
            }
            this.state = 1;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Failed to connect", (Throwable) e);
            throw new CardServiceException(e.toString());
        }
    }

    @Override // net.sf.scuba.smartcards.CardService
    public boolean isOpen() {
        if (this.isoDep.isConnected()) {
            this.state = 1;
            return true;
        }
        this.state = 0;
        return false;
    }

    @Override // net.sf.scuba.smartcards.CardService
    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws IOException, CardServiceException {
        try {
        } catch (IOException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (!this.isoDep.isConnected()) {
                throw new CardServiceException("Not connected");
            }
            byte[] bArrTransceive = this.isoDep.transceive(commandAPDU.getBytes());
            if (bArrTransceive == null || bArrTransceive.length < 2) {
                throw new CardServiceException("Failed response");
            }
            ResponseAPDU responseAPDU = new ResponseAPDU(bArrTransceive);
            int i = this.apduCount + 1;
            this.apduCount = i;
            notifyExchangedAPDU(new APDUEvent(this, "ISODep", i, commandAPDU, responseAPDU));
            return responseAPDU;
        } catch (IOException e3) {
            e = e3;
            throw new CardServiceException(e.getMessage());
        } catch (Exception e4) {
            e = e4;
            throw new CardServiceException(e.getMessage());
        }
    }

    @Override // net.sf.scuba.smartcards.CardService
    public byte[] getATR() {
        Tag tag;
        IsoDep isoDep = this.isoDep;
        if (isoDep == null || (tag = isoDep.getTag()) == null) {
            return null;
        }
        if (NfcA.get(tag) != null) {
            return this.isoDep.getHistoricalBytes();
        }
        if (NfcB.get(tag) != null) {
            return this.isoDep.getHiLayerResponse();
        }
        return this.isoDep.getHistoricalBytes();
    }

    @Override // net.sf.scuba.smartcards.CardService
    public boolean isExtendedAPDULengthSupported() {
        return this.isoDep.isExtendedLengthApduSupported();
    }

    @Override // net.sf.scuba.smartcards.CardService
    public void close() throws IOException {
        try {
            this.isoDep.close();
            this.state = 0;
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        return false;
     */
    @Override // net.sf.scuba.smartcards.CardService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isConnectionLost(Exception exc) {
        if (exc == null) {
            return false;
        }
        boolean zIsDirectConnectionLost = isDirectConnectionLost(exc);
        Throwable th = exc;
        if (zIsDirectConnectionLost) {
            return true;
        }
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null || th == cause) {
                break;
            }
            if (isDirectConnectionLost(cause)) {
                return true;
            }
            th = cause;
        }
    }

    private boolean isDirectConnectionLost(Throwable th) {
        if (th == null) {
            return false;
        }
        String name = th.getClass().getName();
        if (name != null && name.contains("TagLostException")) {
            return true;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        return message.toLowerCase().contains("tag was lost");
    }
}
