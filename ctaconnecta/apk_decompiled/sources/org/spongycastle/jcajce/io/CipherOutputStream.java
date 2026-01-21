package org.spongycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

/* loaded from: classes6.dex */
public class CipherOutputStream extends FilterOutputStream implements AutoCloseable {
    private final Cipher cipher;
    private final byte[] oneByte;

    public CipherOutputStream(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.cipher = cipher;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArrUpdate = this.cipher.update(bArr, i, i2);
        if (bArrUpdate != null) {
            this.out.write(bArrUpdate);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:0|(4:21|2|(1:4)|5)|19|11|(1:17)(1:18)) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (r0 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws BadPaddingException, IllegalBlockSizeException, IOException {
        IOException iOException;
        IOException iOException2;
        try {
            byte[] bArrDoFinal = this.cipher.doFinal();
            if (bArrDoFinal != null) {
                this.out.write(bArrDoFinal);
            }
            iOException2 = null;
        } catch (GeneralSecurityException e) {
            iOException = new InvalidCipherTextIOException("Error during cipher finalisation", e);
            iOException2 = iOException;
            flush();
            this.out.close();
            if (iOException2 != null) {
            }
        } catch (Exception e2) {
            iOException = new IOException("Error closing stream: " + e2);
            iOException2 = iOException;
            flush();
            this.out.close();
            if (iOException2 != null) {
            }
        }
        flush();
        this.out.close();
        if (iOException2 != null) {
            throw iOException2;
        }
    }
}
