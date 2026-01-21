package org.jsoup.helper;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.UncheckedIOException;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;

/* loaded from: classes6.dex */
public final class DataUtil {
    static final int boundaryLength = 32;
    static final int bufferSize = 32768;
    static final String defaultCharset = "UTF-8";
    private static final int firstReadBufferSize = 5120;
    private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    private static final char[] mimeBoundaryChars = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private DataUtil() {
    }

    public static Document load(File file, String str, String str2) throws IOException {
        return parseInputStream(new FileInputStream(file), str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2) throws IOException {
        return parseInputStream(inputStream, str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return parseInputStream(inputStream, str, str2, parser);
    }

    static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    static Document parseInputStream(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        if (inputStream == null) {
            return new Document(str2);
        }
        ConstrainableInputStream constrainableInputStreamWrap = ConstrainableInputStream.wrap(inputStream, 32768, 0);
        constrainableInputStreamWrap.mark(32768);
        ByteBuffer toByteBuffer = readToByteBuffer(constrainableInputStreamWrap, 5119);
        boolean z = constrainableInputStreamWrap.read() == -1;
        constrainableInputStreamWrap.reset();
        BomCharset bomCharsetDetectCharsetFromBom = detectCharsetFromBom(toByteBuffer);
        if (bomCharsetDetectCharsetFromBom != null) {
            str = bomCharsetDetectCharsetFromBom.charset;
        }
        Document input = null;
        if (str == null) {
            Document input2 = parser.parseInput(Charset.forName("UTF-8").decode(toByteBuffer).toString(), str2);
            Iterator<Element> it = input2.select("meta[http-equiv=content-type], meta[charset]").iterator();
            String strAttr = null;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.hasAttr("http-equiv")) {
                    strAttr = getCharsetFromContentType(next.attr(FirebaseAnalytics.Param.CONTENT));
                }
                if (strAttr == null && next.hasAttr("charset")) {
                    strAttr = next.attr("charset");
                }
                if (strAttr != null) {
                    break;
                }
            }
            if (strAttr == null && input2.childNodeSize() > 0 && (input2.childNode(0) instanceof XmlDeclaration)) {
                XmlDeclaration xmlDeclaration = (XmlDeclaration) input2.childNode(0);
                if (xmlDeclaration.name().equals("xml")) {
                    strAttr = xmlDeclaration.attr("encoding");
                }
            }
            String strValidateCharset = validateCharset(strAttr);
            if (strValidateCharset != null && !strValidateCharset.equalsIgnoreCase("UTF-8")) {
                str = strValidateCharset.trim().replaceAll("[\"']", "");
            } else if (z) {
                input = input2;
            }
        } else {
            Validate.notEmpty(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (input == null) {
            String str3 = str != null ? str : "UTF-8";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(constrainableInputStreamWrap, str3), 32768);
            if (bomCharsetDetectCharsetFromBom != null && bomCharsetDetectCharsetFromBom.offset) {
                bufferedReader.skip(1L);
            }
            try {
                input = parser.parseInput(bufferedReader, str2);
                input.outputSettings().charset(str3);
            } catch (UncheckedIOException e) {
                throw e.ioException();
            }
        }
        constrainableInputStreamWrap.close();
        return input;
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        return ConstrainableInputStream.wrap(inputStream, 32768, i).readToByteBuffer(i);
    }

    static ByteBuffer readToByteBuffer(InputStream inputStream) throws IOException {
        return readToByteBuffer(inputStream, 0);
    }

    static ByteBuffer readFileToByteBuffer(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[(int) randomAccessFile2.length()];
                randomAccessFile2.readFully(bArr);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                randomAccessFile2.close();
                return byteBufferWrap;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static ByteBuffer emptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = charsetPattern.matcher(str);
        if (matcher.find()) {
            return validateCharset(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    private static String validateCharset(String str) {
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(strReplaceAll)) {
                    return strReplaceAll;
                }
                String upperCase = strReplaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    static String mimeBoundary() {
        StringBuilder sb = new StringBuilder(32);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = mimeBoundaryChars;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    private static BomCharset detectCharsetFromBom(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b = bArr[0];
        if ((b == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new BomCharset("UTF-32", false);
        }
        if ((b == -2 && bArr[1] == -1) || (b == -1 && bArr[1] == -2)) {
            return new BomCharset("UTF-16", false);
        }
        if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new BomCharset("UTF-8", true);
        }
        return null;
    }

    private static class BomCharset {
        private final String charset;
        private final boolean offset;

        public BomCharset(String str, boolean z) {
            this.charset = str;
            this.offset = z;
        }
    }
}
