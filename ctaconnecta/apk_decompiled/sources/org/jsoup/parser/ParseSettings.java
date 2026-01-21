package org.jsoup.parser;

import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;

/* loaded from: classes6.dex */
public class ParseSettings {
    public static final ParseSettings htmlDefault = new ParseSettings(false, false);
    public static final ParseSettings preserveCase = new ParseSettings(true, true);
    private final boolean preserveAttributeCase;
    private final boolean preserveTagCase;

    public ParseSettings(boolean z, boolean z2) {
        this.preserveTagCase = z;
        this.preserveAttributeCase = z2;
    }

    String normalizeTag(String str) {
        String strTrim = str.trim();
        return !this.preserveTagCase ? Normalizer.lowerCase(strTrim) : strTrim;
    }

    String normalizeAttribute(String str) {
        String strTrim = str.trim();
        return !this.preserveAttributeCase ? Normalizer.lowerCase(strTrim) : strTrim;
    }

    Attributes normalizeAttributes(Attributes attributes) {
        if (!this.preserveAttributeCase) {
            attributes.normalize();
        }
        return attributes;
    }
}
