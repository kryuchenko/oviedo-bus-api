package org.jnbis.internal;

/* loaded from: classes6.dex */
public class WsqHelper {
    static final int ANY_WSQ = 65535;
    static int[] BITMASK = {0, 1, 3, 7, 15, 31, 63, 127, 255};
    static final int COM_WSQ = 65448;
    static final int DHT_WSQ = 65446;
    static final int DQT_WSQ = 65445;
    static final int DRT_WSQ = 65447;
    static final int DTT_WSQ = 65444;
    static final int EOI_WSQ = 65441;
    static final int MAX_DHT_TABLES = 8;
    static final int MAX_HUFFBITS = 16;
    static final int MAX_HUFFCOUNTS_WSQ = 256;
    static final int MAX_SUBBANDS = 64;
    static final int NUM_SUBBANDS = 60;
    static final int Q_TREELEN = 64;
    static final int SOB_WSQ = 65443;
    static final int SOF_WSQ = 65442;
    static final int SOI_WSQ = 65440;
    static final int STRT_SIZE_REGION_2 = 4;
    static final int STRT_SIZE_REGION_3 = 51;
    static final int STRT_SUBBAND_2 = 19;
    static final int STRT_SUBBAND_3 = 52;
    static final int STRT_SUBBAND_DEL = 60;
    static final int TBLS_N_SOB = 4;
    static final int TBLS_N_SOF = 2;
    static final int W_TREELEN = 20;

    static class WavletTree {
        int invcl;
        int invrw;
        int lenx;
        int leny;
        int x;
        int y;

        WavletTree() {
        }
    }

    static class TableDTT {
        int hidef;
        float[] hifilt;
        int hisz;
        int lodef;
        float[] lofilt;
        int losz;

        TableDTT() {
        }
    }

    static class HuffCode {
        int code;
        int size;

        HuffCode() {
        }
    }

    static class HeaderFrm {
        int black;
        int height;
        float mShift;
        float rScale;
        int software;
        int white;
        int width;
        int wsqEncoder;

        HeaderFrm() {
        }
    }

    static class HuffmanTable {
        int bytesLeft;
        int[] huffbits;
        int[] huffvalues;
        int tableId;
        int tableLen;

        HuffmanTable() {
        }
    }

    static class TableDHT {
        private static final int MAX_HUFFBITS = 16;
        private static final int MAX_HUFFCOUNTS_WSQ = 256;
        int[] huffbits = new int[16];
        int[] huffvalues = new int[257];
        byte tabdef;

        TableDHT() {
        }
    }

    static class Table_DQT {
        public static final int MAX_SUBBANDS = 64;
        float binCenter;
        char dqtDef;
        float[] qBin = new float[64];
        float[] zBin = new float[64];

        Table_DQT() {
        }
    }

    static class QuantTree {
        int lenx;
        int leny;
        int x;
        int y;

        QuantTree() {
        }
    }

    static class IntRef {
        int value;

        public IntRef(int i) {
            this.value = i;
        }
    }

    static class Token {
        byte[] buffer;
        int pointer = 0;
        QuantTree[] qtree;
        TableDHT[] tableDHT;
        Table_DQT tableDQT;
        TableDTT tableDTT;
        WavletTree[] wtree;

        Token(byte[] bArr) {
            this.buffer = bArr;
        }

        void initialize() {
            this.tableDTT = new TableDTT();
            this.tableDQT = new Table_DQT();
            this.tableDHT = new TableDHT[8];
            for (int i = 0; i < 8; i++) {
                this.tableDHT[i] = new TableDHT();
                this.tableDHT[i].tabdef = (byte) 0;
            }
        }

        long readInt() {
            byte[] bArr = this.buffer;
            int i = this.pointer;
            int i2 = i + 1;
            this.pointer = i2;
            byte b = bArr[i];
            int i3 = i + 2;
            this.pointer = i3;
            byte b2 = bArr[i2];
            this.pointer = i + 3;
            byte b3 = bArr[i3];
            this.pointer = i + 4;
            return ((b2 & 255) << 16) | ((b & 255) << 24) | ((b3 & 255) << 8) | (bArr[r5] & 255);
        }

        int readShort() {
            byte[] bArr = this.buffer;
            int i = this.pointer;
            int i2 = i + 1;
            this.pointer = i2;
            byte b = bArr[i];
            this.pointer = i + 2;
            return (bArr[i2] & 255) | ((b & 255) << 8);
        }

        int readByte() {
            byte[] bArr = this.buffer;
            int i = this.pointer;
            this.pointer = i + 1;
            return bArr[i] & 255;
        }

        byte[] readBytes(int i) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr2 = this.buffer;
                int i3 = this.pointer;
                this.pointer = i3 + 1;
                bArr[i2] = bArr2[i3];
            }
            return bArr;
        }
    }

    static boolean isWsqFormat(byte[] bArr) {
        return bArr[0] == -1 && bArr[1] == -96 && bArr[bArr.length + (-2)] == -1 && bArr[bArr.length - 1] == -95;
    }
}
