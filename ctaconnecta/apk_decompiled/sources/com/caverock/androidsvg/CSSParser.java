package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class CSSParser {
    private static final String CLASS = "class";
    private static final String ID = "id";
    private static final String TAG = "AndroidSVG CSSParser";
    private boolean inMediaRule = false;
    private MediaType rendererMediaType;

    private enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static AttribOp[] valuesCustom() {
            AttribOp[] attribOpArrValuesCustom = values();
            int length = attribOpArrValuesCustom.length;
            AttribOp[] attribOpArr = new AttribOp[length];
            System.arraycopy(attribOpArrValuesCustom, 0, attribOpArr, 0, length);
            return attribOpArr;
        }
    }

    private enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Combinator[] valuesCustom() {
            Combinator[] combinatorArrValuesCustom = values();
            int length = combinatorArrValuesCustom.length;
            Combinator[] combinatorArr = new Combinator[length];
            System.arraycopy(combinatorArrValuesCustom, 0, combinatorArr, 0, length);
            return combinatorArr;
        }
    }

    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        tty,
        tv;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static MediaType[] valuesCustom() {
            MediaType[] mediaTypeArrValuesCustom = values();
            int length = mediaTypeArrValuesCustom.length;
            MediaType[] mediaTypeArr = new MediaType[length];
            System.arraycopy(mediaTypeArrValuesCustom, 0, mediaTypeArr, 0, length);
            return mediaTypeArr;
        }
    }

    public static class Attrib {
        public String name;
        public AttribOp operation;
        public String value;

        public Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    private static class SimpleSelector {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp;
        public Combinator combinator;
        public String tag;
        public List<Attrib> attribs = null;
        public List<String> pseudos = null;

        static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp() {
            int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[AttribOp.valuesCustom().length];
            try {
                iArr2[AttribOp.DASHMATCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[AttribOp.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AttribOp.INCLUDES.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp = iArr2;
            return iArr2;
        }

        public SimpleSelector(Combinator combinator, String str) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        public void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        public void addPseudo(String str) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append('[');
                    sb.append(attrib.name);
                    int i = $SWITCH_TABLE$com$caverock$androidsvg$CSSParser$AttribOp()[attrib.operation.ordinal()];
                    if (i == 2) {
                        sb.append('=');
                        sb.append(attrib.value);
                    } else if (i == 3) {
                        sb.append("~=");
                        sb.append(attrib.value);
                    } else if (i == 4) {
                        sb.append("|=");
                        sb.append(attrib.value);
                    }
                    sb.append(']');
                }
            }
            List<String> list2 = this.pseudos;
            if (list2 != null) {
                for (String str2 : list2) {
                    sb.append(':');
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
    }

    public static class Ruleset {
        private List<Rule> rules = null;

        public void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i = 0; i < this.rules.size(); i++) {
                if (this.rules.get(i).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(ruleset.rules.size());
            }
            Iterator<Rule> it = ruleset.rules.iterator();
            while (it.hasNext()) {
                this.rules.add(it.next());
            }
        }

        public List<Rule> getRules() {
            return this.rules;
        }

        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    public static class Rule {
        public Selector selector;
        public SVG.Style style;

        public Rule(Selector selector, SVG.Style style) {
            this.selector = selector;
            this.style = style;
        }

        public String toString() {
            return this.selector + " {}";
        }
    }

    public static class Selector {
        public List<SimpleSelector> selector = null;
        public int specificity = 0;

        public void add(SimpleSelector simpleSelector) {
            if (this.selector == null) {
                this.selector = new ArrayList();
            }
            this.selector.add(simpleSelector);
        }

        public int size() {
            List<SimpleSelector> list = this.selector;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public SimpleSelector get(int i) {
            return this.selector.get(i);
        }

        public boolean isEmpty() {
            List<SimpleSelector> list = this.selector;
            if (list == null) {
                return true;
            }
            return list.isEmpty();
        }

        public void addedIdAttribute() {
            this.specificity += 10000;
        }

        public void addedAttributeOrPseudo() {
            this.specificity += 100;
        }

        public void addedElement() {
            this.specificity++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<SimpleSelector> it = this.selector.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(' ');
            }
            sb.append('(');
            sb.append(this.specificity);
            sb.append(')');
            return sb.toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.rendererMediaType = mediaType;
    }

    public Ruleset parse(String str) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    public static boolean mediaMatches(String str, MediaType mediaType) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        List<MediaType> mediaList = parseMediaList(cSSTextScanner);
        if (!cSSTextScanner.empty()) {
            throw new SAXException("Invalid @media type list");
        }
        return mediaMatches(mediaList, mediaType);
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    private static class CSSTextScanner extends SVGParser.TextScanner {
        public CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public String nextIdentifier() {
            int iScanForIdentifier = scanForIdentifier();
            if (iScanForIdentifier == this.position) {
                return null;
            }
            String strSubstring = this.input.substring(this.position, iScanForIdentifier);
            this.position = iScanForIdentifier;
            return strSubstring;
        }

        private int scanForIdentifier() {
            if (empty()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int iCharAt = this.input.charAt(this.position);
            if (iCharAt == 45) {
                iCharAt = advanceChar();
            }
            if ((iCharAt >= 65 && iCharAt <= 90) || ((iCharAt >= 97 && iCharAt <= 122) || iCharAt == 95)) {
                int iAdvanceChar = advanceChar();
                while (true) {
                    if ((iAdvanceChar < 65 || iAdvanceChar > 90) && ((iAdvanceChar < 97 || iAdvanceChar > 122) && !((iAdvanceChar >= 48 && iAdvanceChar <= 57) || iAdvanceChar == 45 || iAdvanceChar == 95))) {
                        break;
                    }
                    iAdvanceChar = advanceChar();
                }
                i2 = this.position;
            }
            this.position = i;
            return i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:86:0x0156, code lost:
        
            if (r4 == null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0158, code lost:
        
            r11.add(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x015b, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015c, code lost:
        
            r10.position = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x015e, code lost:
        
            return false;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean nextSimpleSelector(Selector selector) throws SAXException {
            Combinator combinator;
            SimpleSelector simpleSelector;
            AttribOp attribOp;
            String strNextAttribValue;
            if (!empty()) {
                int i = this.position;
                if (selector.isEmpty()) {
                    combinator = null;
                } else if (consume(Typography.greater)) {
                    combinator = Combinator.CHILD;
                    skipWhitespace();
                } else if (consume('+')) {
                    combinator = Combinator.FOLLOWS;
                    skipWhitespace();
                }
                if (consume('*')) {
                    simpleSelector = new SimpleSelector(combinator, null);
                } else {
                    String strNextIdentifier = nextIdentifier();
                    if (strNextIdentifier != null) {
                        SimpleSelector simpleSelector2 = new SimpleSelector(combinator, strNextIdentifier);
                        selector.addedElement();
                        simpleSelector = simpleSelector2;
                    } else {
                        simpleSelector = null;
                    }
                }
                while (true) {
                    if (!empty()) {
                        if (consume('.')) {
                            if (simpleSelector == null) {
                                simpleSelector = new SimpleSelector(combinator, null);
                            }
                            String strNextIdentifier2 = nextIdentifier();
                            if (strNextIdentifier2 == null) {
                                throw new SAXException("Invalid \".class\" selector in <style> element");
                            }
                            simpleSelector.addAttrib(CSSParser.CLASS, AttribOp.EQUALS, strNextIdentifier2);
                            selector.addedAttributeOrPseudo();
                        } else {
                            if (consume('#')) {
                                if (simpleSelector == null) {
                                    simpleSelector = new SimpleSelector(combinator, null);
                                }
                                String strNextIdentifier3 = nextIdentifier();
                                if (strNextIdentifier3 == null) {
                                    throw new SAXException("Invalid \"#id\" selector in <style> element");
                                }
                                simpleSelector.addAttrib(CSSParser.ID, AttribOp.EQUALS, strNextIdentifier3);
                                selector.addedIdAttribute();
                            }
                            if (simpleSelector == null) {
                                break;
                            }
                            if (consume('[')) {
                                skipWhitespace();
                                String strNextIdentifier4 = nextIdentifier();
                                if (strNextIdentifier4 == null) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                skipWhitespace();
                                if (consume('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (consume("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = consume("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    skipWhitespace();
                                    strNextAttribValue = nextAttribValue();
                                    if (strNextAttribValue == null) {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                    skipWhitespace();
                                } else {
                                    strNextAttribValue = null;
                                }
                                if (!consume(']')) {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                                if (attribOp == null) {
                                    attribOp = AttribOp.EXISTS;
                                }
                                simpleSelector.addAttrib(strNextIdentifier4, attribOp, strNextAttribValue);
                                selector.addedAttributeOrPseudo();
                            } else if (consume(':')) {
                                int i2 = this.position;
                                if (nextIdentifier() != null) {
                                    if (consume('(')) {
                                        skipWhitespace();
                                        if (nextIdentifier() != null) {
                                            skipWhitespace();
                                            if (!consume(')')) {
                                                this.position = i2 - 1;
                                            } else {
                                                simpleSelector.addPseudo(this.input.substring(i2, this.position));
                                                selector.addedAttributeOrPseudo();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                return false;
            }
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String strNextQuotedString = nextQuotedString();
            return strNextQuotedString != null ? strNextQuotedString : nextIdentifier();
        }

        public String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int iCharAt = this.input.charAt(this.position);
            while (iCharAt != -1 && iCharAt != 59 && iCharAt != 125 && iCharAt != 33 && !isEOL(iCharAt)) {
                if (!isWhitespace(iCharAt)) {
                    i2 = this.position + 1;
                }
                iCharAt = advanceChar();
            }
            if (this.position > i) {
                return this.input.substring(i, i2);
            }
            this.position = i;
            return null;
        }
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty()) {
            try {
                arrayList.add(MediaType.valueOf(cSSTextScanner.nextToken(',')));
                if (!cSSTextScanner.skipCommaWhitespace()) {
                    break;
                }
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws SAXException {
        String strNextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (strNextIdentifier == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (!this.inMediaRule && strNextIdentifier.equals("media")) {
            List<MediaType> mediaList = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.consume('{')) {
                throw new SAXException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.skipWhitespace();
            if (mediaMatches(mediaList, this.rendererMediaType)) {
                this.inMediaRule = true;
                ruleset.addAll(parseRuleset(cSSTextScanner));
                this.inMediaRule = false;
            } else {
                parseRuleset(cSSTextScanner);
            }
            if (!cSSTextScanner.consume('}')) {
                throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else {
            warn("Ignoring @%s rule", strNextIdentifier);
            skipAtRule(cSSTextScanner);
        }
        cSSTextScanner.skipWhitespace();
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i = 0;
        while (!cSSTextScanner.empty()) {
            int iIntValue = cSSTextScanner.nextChar().intValue();
            if (iIntValue == 59 && i == 0) {
                return;
            }
            if (iIntValue == 123) {
                i++;
            } else if (iIntValue == 125 && i > 0 && i - 1 == 0) {
                return;
            }
        }
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) throws SAXException {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                if (cSSTextScanner.consume('@')) {
                    parseAtRule(ruleset, cSSTextScanner);
                } else if (!parseRule(ruleset, cSSTextScanner)) {
                    break;
                }
            }
        }
        return ruleset;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws SAXException {
        List<Selector> selectorGroup = parseSelectorGroup(cSSTextScanner);
        if (selectorGroup == null || selectorGroup.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.consume('{')) {
            throw new SAXException("Malformed rule block in <style> element: missing '{'");
        }
        cSSTextScanner.skipWhitespace();
        SVG.Style declarations = parseDeclarations(cSSTextScanner);
        cSSTextScanner.skipWhitespace();
        Iterator<Selector> it = selectorGroup.iterator();
        while (it.hasNext()) {
            ruleset.add(new Rule(it.next(), declarations));
        }
        return true;
    }

    private List<Selector> parseSelectorGroup(CSSTextScanner cSSTextScanner) throws SAXException {
        if (cSSTextScanner.empty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        Selector selector = new Selector();
        while (!cSSTextScanner.empty() && cSSTextScanner.nextSimpleSelector(selector)) {
            if (cSSTextScanner.skipCommaWhitespace()) {
                arrayList.add(selector);
                selector = new Selector();
            }
        }
        if (!selector.isEmpty()) {
            arrayList.add(selector);
        }
        return arrayList;
    }

    private SVG.Style parseDeclarations(CSSTextScanner cSSTextScanner) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String strNextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(':')) {
                break;
            }
            cSSTextScanner.skipWhitespace();
            String strNextPropertyValue = cSSTextScanner.nextPropertyValue();
            if (strNextPropertyValue == null) {
                break;
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (!cSSTextScanner.consume("important")) {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
                cSSTextScanner.skipWhitespace();
            }
            cSSTextScanner.consume(';');
            SVGParser.processStyleProperty(style, strNextIdentifier, strNextPropertyValue);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('}')) {
                return style;
            }
        } while (!cSSTextScanner.empty());
        throw new SAXException("Malformed rule set in <style> element");
    }

    protected static List<String> parseClassAttribute(String str) throws SAXException {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String strNextIdentifier = cSSTextScanner.nextIdentifier();
            if (strNextIdentifier == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextIdentifier);
            cSSTextScanner.skipWhitespace();
        }
        return arrayList;
    }

    protected static boolean ruleMatch(Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = svgElementBase.parent; obj != null; obj = ((SVG.SvgObject) obj).parent) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatch(Selector selector, int i, List<SVG.SvgContainer> list, int i2, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i);
        if (!selectorMatch(simpleSelector, list, i2, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator == Combinator.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            while (i2 >= 0) {
                if (ruleMatchOnAncestors(selector, i - 1, list, i2)) {
                    return true;
                }
                i2--;
            }
            return false;
        }
        if (simpleSelector.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(selector, i - 1, list, i2);
        }
        int childPosition = getChildPosition(list, i2, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i - 1, list, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    private static boolean ruleMatchOnAncestors(Selector selector, int i, List<SVG.SvgContainer> list, int i2) {
        SimpleSelector simpleSelector = selector.get(i);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i2);
        if (!selectorMatch(simpleSelector, list, i2, svgElementBase)) {
            return false;
        }
        if (simpleSelector.combinator == Combinator.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            while (i2 > 0) {
                i2--;
                if (ruleMatchOnAncestors(selector, i - 1, list, i2)) {
                    return true;
                }
            }
            return false;
        }
        if (simpleSelector.combinator == Combinator.CHILD) {
            return ruleMatchOnAncestors(selector, i - 1, list, i2 - 1);
        }
        int childPosition = getChildPosition(list, i2, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i - 1, list, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        if (i < 0 || list.get(i) != svgElementBase.parent) {
            return -1;
        }
        Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next() == svgElementBase) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static boolean selectorMatch(SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        if (simpleSelector.tag != null) {
            if (simpleSelector.tag.equalsIgnoreCase("G")) {
                if (!(svgElementBase instanceof SVG.Group)) {
                    return false;
                }
            } else if (!simpleSelector.tag.equals(svgElementBase.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        if (simpleSelector.attribs != null) {
            for (Attrib attrib : simpleSelector.attribs) {
                if (attrib.name == ID) {
                    if (!attrib.value.equals(svgElementBase.id)) {
                        return false;
                    }
                } else if (attrib.name != CLASS || svgElementBase.classNames == null || !svgElementBase.classNames.contains(attrib.value)) {
                    return false;
                }
            }
        }
        if (simpleSelector.pseudos == null) {
            return true;
        }
        Iterator<String> it = simpleSelector.pseudos.iterator();
        while (it.hasNext()) {
            if (!it.next().equals("first-child") || getChildPosition(list, i, svgElementBase) != 0) {
                return false;
            }
        }
        return true;
    }
}
