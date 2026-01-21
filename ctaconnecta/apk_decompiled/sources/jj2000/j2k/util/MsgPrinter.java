package jj2000.j2k.util;

import java.io.PrintWriter;

/* loaded from: classes5.dex */
public class MsgPrinter {
    private static final int IS_EOS = -1;
    private static final int IS_NEWLINE = -2;
    public int lw;

    public MsgPrinter(int i) {
        this.lw = i;
    }

    public int getLineWidth() {
        return this.lw;
    }

    public void setLineWidth(int i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        this.lw = i;
    }

    public void print(PrintWriter printWriter, int i, int i2, String str) {
        int i3 = this.lw - i;
        int i4 = 0;
        int iNextWord = 0;
        while (true) {
            int iNextLineEnd = nextLineEnd(str, i4);
            if (iNextLineEnd == -1) {
                i2 = i;
                break;
            }
            if (iNextLineEnd == -2) {
                for (int i5 = 0; i5 < i; i5++) {
                    printWriter.print(" ");
                }
                printWriter.println(str.substring(iNextWord, i4));
                if (nextWord(str, i4) == str.length()) {
                    printWriter.println("");
                    i2 = i;
                    iNextWord = i4;
                    break;
                }
            } else {
                int i6 = iNextLineEnd - i4;
                if (i3 > i6) {
                    i3 -= i6;
                    i4 = iNextLineEnd;
                } else {
                    for (int i7 = 0; i7 < i; i7++) {
                        printWriter.print(" ");
                    }
                    if (iNextWord == i4) {
                        printWriter.println(str.substring(iNextWord, iNextLineEnd));
                        i4 = iNextLineEnd;
                    } else {
                        printWriter.println(str.substring(iNextWord, i4));
                    }
                }
            }
            i3 = this.lw - i2;
            iNextWord = nextWord(str, i4);
            if (iNextWord == -1) {
                i4 = iNextWord;
                break;
            } else {
                i = i2;
                i4 = iNextWord;
            }
        }
        if (i4 != iNextWord) {
            for (int i8 = 0; i8 < i2; i8++) {
                printWriter.print(" ");
            }
            printWriter.println(str.substring(iNextWord, i4));
        }
    }

    private int nextLineEnd(String str, int i) {
        int length = str.length();
        char cCharAt = 0;
        while (i < length && (cCharAt = str.charAt(i)) != '\n' && Character.isWhitespace(cCharAt)) {
            i++;
        }
        if (cCharAt == '\n') {
            return -2;
        }
        if (i >= length) {
            return -1;
        }
        while (i < length && !Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int nextWord(String str, int i) {
        int length = str.length();
        char cCharAt = 0;
        while (i < length && (cCharAt = str.charAt(i)) != '\n' && Character.isWhitespace(cCharAt)) {
            i++;
        }
        if (i >= length) {
            return -1;
        }
        return cCharAt == '\n' ? i + 1 : i;
    }
}
