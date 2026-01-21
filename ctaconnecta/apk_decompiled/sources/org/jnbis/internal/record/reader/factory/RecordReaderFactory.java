package org.jnbis.internal.record.reader.factory;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.internal.record.reader.FacialAndSmtImageReader;
import org.jnbis.internal.record.reader.HighResolutionBinaryFingerprintReader;
import org.jnbis.internal.record.reader.HighResolutionGrayscaleFingerprintReader;
import org.jnbis.internal.record.reader.IrisImageReader;
import org.jnbis.internal.record.reader.LowResolutionBinaryFingerprintReader;
import org.jnbis.internal.record.reader.LowResolutionGrayscaleFingerprintReader;
import org.jnbis.internal.record.reader.MinutiaeDataReader;
import org.jnbis.internal.record.reader.RecordReader;
import org.jnbis.internal.record.reader.SignatureImageReader;
import org.jnbis.internal.record.reader.TransactionInfoReader;
import org.jnbis.internal.record.reader.UserDefinedImageReader;
import org.jnbis.internal.record.reader.UserDefinedTextReader;
import org.jnbis.internal.record.reader.VariableResolutionFingerprintReader;
import org.jnbis.internal.record.reader.VariableResolutionLatentImageReader;
import org.jnbis.internal.record.reader.VariableResolutionPalmprintReader;

/* loaded from: classes6.dex */
public class RecordReaderFactory {
    private static final RecordReader NOT_SUPPORTED;
    private static final RecordReader[] READERS;

    static {
        RecordReader recordReader = new RecordReader() { // from class: org.jnbis.internal.record.reader.factory.RecordReaderFactory.1
            @Override // org.jnbis.internal.record.reader.RecordReader
            public BaseRecord read(NistHelper.Token token) {
                throw new UnsupportedOperationException("record type: " + token.crt + " no supported!");
            }
        };
        NOT_SUPPORTED = recordReader;
        READERS = new RecordReader[]{new TransactionInfoReader(), new TransactionInfoReader(), new UserDefinedTextReader(), new LowResolutionGrayscaleFingerprintReader(), new HighResolutionGrayscaleFingerprintReader(), new LowResolutionBinaryFingerprintReader(), new HighResolutionBinaryFingerprintReader(), new UserDefinedImageReader(), new SignatureImageReader(), new MinutiaeDataReader(), new FacialAndSmtImageReader(), recordReader, recordReader, new VariableResolutionLatentImageReader(), new VariableResolutionFingerprintReader(), new VariableResolutionPalmprintReader(), recordReader, new IrisImageReader()};
    }

    public RecordReader reader(NistHelper.Token token) {
        return READERS[token.crt];
    }

    public BaseRecord read(NistHelper.Token token) {
        return reader(token).read(token);
    }
}
