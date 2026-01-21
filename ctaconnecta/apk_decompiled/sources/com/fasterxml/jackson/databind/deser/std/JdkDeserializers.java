package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class JdkDeserializers {
    private static final HashSet<String> _classNames = new HashSet<>();

    static {
        Class[] clsArr = {UUID.class, URL.class, URI.class, File.class, Currency.class, Pattern.class, Locale.class, InetAddress.class, InetSocketAddress.class, Charset.class, AtomicBoolean.class, Class.class, StackTraceElement.class, ByteBuffer.class};
        for (int i = 0; i < 14; i++) {
            _classNames.add(clsArr[i].getName());
        }
    }

    public static JsonDeserializer<?> find(Class<?> cls, String str) {
        if (!_classNames.contains(str)) {
            return null;
        }
        if (cls == URI.class) {
            return URIDeserializer.instance;
        }
        if (cls == URL.class) {
            return URLDeserializer.instance;
        }
        if (cls == File.class) {
            return FileDeserializer.instance;
        }
        if (cls == UUID.class) {
            return UUIDDeserializer.instance;
        }
        if (cls == Currency.class) {
            return CurrencyDeserializer.instance;
        }
        if (cls == Pattern.class) {
            return PatternDeserializer.instance;
        }
        if (cls == Locale.class) {
            return LocaleDeserializer.instance;
        }
        if (cls == InetAddress.class) {
            return InetAddressDeserializer.instance;
        }
        if (cls == InetSocketAddress.class) {
            return InetSocketAddressDeserializer.instance;
        }
        if (cls == Charset.class) {
            return new CharsetDeserializer();
        }
        if (cls == Class.class) {
            return ClassDeserializer.instance;
        }
        if (cls == StackTraceElement.class) {
            return StackTraceElementDeserializer.instance;
        }
        if (cls == AtomicBoolean.class) {
            return AtomicBooleanDeserializer.instance;
        }
        if (cls == ByteBuffer.class) {
            return new ByteBufferDeserializer();
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + str);
    }

    public static class URLDeserializer extends FromStringDeserializer<URL> {
        public static final URLDeserializer instance = new URLDeserializer();

        public URLDeserializer() {
            super(URL.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public URL _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return new URL(str);
        }
    }

    public static class URIDeserializer extends FromStringDeserializer<URI> {
        public static final URIDeserializer instance = new URIDeserializer();

        public URIDeserializer() {
            super(URI.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public URI _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return URI.create(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public URI _deserializeFromEmptyString() {
            return URI.create("");
        }
    }

    public static class CurrencyDeserializer extends FromStringDeserializer<Currency> {
        public static final CurrencyDeserializer instance = new CurrencyDeserializer();

        public CurrencyDeserializer() {
            super(Currency.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Currency _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return Currency.getInstance(str);
        }
    }

    public static class PatternDeserializer extends FromStringDeserializer<Pattern> {
        public static final PatternDeserializer instance = new PatternDeserializer();

        public PatternDeserializer() {
            super(Pattern.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Pattern _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return Pattern.compile(str);
        }
    }

    protected static class LocaleDeserializer extends FromStringDeserializer<Locale> {
        public static final LocaleDeserializer instance = new LocaleDeserializer();

        public LocaleDeserializer() {
            super(Locale.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Locale _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            int iIndexOf = str.indexOf(95);
            if (iIndexOf < 0) {
                return new Locale(str);
            }
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            int iIndexOf2 = strSubstring2.indexOf(95);
            if (iIndexOf2 < 0) {
                return new Locale(strSubstring, strSubstring2);
            }
            return new Locale(strSubstring, strSubstring2.substring(0, iIndexOf2), strSubstring2.substring(iIndexOf2 + 1));
        }
    }

    public static class FileDeserializer extends FromStringDeserializer<File> {
        public static final FileDeserializer instance = new FileDeserializer();

        public FileDeserializer() {
            super(File.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public File _deserialize(String str, DeserializationContext deserializationContext) {
            return new File(str);
        }
    }
}
