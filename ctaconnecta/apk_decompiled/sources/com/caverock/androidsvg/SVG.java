package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final List<SvgObject> EMPTY_CHILD_LIST = new ArrayList(0);
    protected static final long SPECIFIED_ALL = -1;
    protected static final long SPECIFIED_CLIP = 1048576;
    protected static final long SPECIFIED_CLIP_PATH = 268435456;
    protected static final long SPECIFIED_CLIP_RULE = 536870912;
    protected static final long SPECIFIED_COLOR = 4096;
    protected static final long SPECIFIED_DIRECTION = 68719476736L;
    protected static final long SPECIFIED_DISPLAY = 16777216;
    protected static final long SPECIFIED_FILL = 1;
    protected static final long SPECIFIED_FILL_OPACITY = 4;
    protected static final long SPECIFIED_FILL_RULE = 2;
    protected static final long SPECIFIED_FONT_FAMILY = 8192;
    protected static final long SPECIFIED_FONT_SIZE = 16384;
    protected static final long SPECIFIED_FONT_STYLE = 65536;
    protected static final long SPECIFIED_FONT_WEIGHT = 32768;
    protected static final long SPECIFIED_MARKER_END = 8388608;
    protected static final long SPECIFIED_MARKER_MID = 4194304;
    protected static final long SPECIFIED_MARKER_START = 2097152;
    protected static final long SPECIFIED_MASK = 1073741824;
    protected static final long SPECIFIED_NON_INHERITING = 68133849088L;
    protected static final long SPECIFIED_OPACITY = 2048;
    protected static final long SPECIFIED_OVERFLOW = 524288;
    protected static final long SPECIFIED_SOLID_COLOR = 2147483648L;
    protected static final long SPECIFIED_SOLID_OPACITY = 4294967296L;
    protected static final long SPECIFIED_STOP_COLOR = 67108864;
    protected static final long SPECIFIED_STOP_OPACITY = 134217728;
    protected static final long SPECIFIED_STROKE = 8;
    protected static final long SPECIFIED_STROKE_DASHARRAY = 512;
    protected static final long SPECIFIED_STROKE_DASHOFFSET = 1024;
    protected static final long SPECIFIED_STROKE_LINECAP = 64;
    protected static final long SPECIFIED_STROKE_LINEJOIN = 128;
    protected static final long SPECIFIED_STROKE_MITERLIMIT = 256;
    protected static final long SPECIFIED_STROKE_OPACITY = 16;
    protected static final long SPECIFIED_STROKE_WIDTH = 32;
    protected static final long SPECIFIED_TEXT_ANCHOR = 262144;
    protected static final long SPECIFIED_TEXT_DECORATION = 131072;
    protected static final long SPECIFIED_VECTOR_EFFECT = 34359738368L;
    protected static final long SPECIFIED_VIEWPORT_FILL = 8589934592L;
    protected static final long SPECIFIED_VIEWPORT_FILL_OPACITY = 17179869184L;
    protected static final long SPECIFIED_VISIBILITY = 33554432;
    private static final double SQRT2 = 1.414213562373095d;
    protected static final String SUPPORTED_SVG_VERSION = "1.2";
    private static final String TAG = "AndroidSVG";
    private static final String VERSION = "1.2.1";
    private Svg rootElement = null;
    private String title = "";
    private String desc = "";
    private SVGExternalFileResolver fileResolver = null;
    private float renderDPI = 96.0f;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();

    protected enum GradientSpread {
        pad,
        reflect,
        repeat;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static GradientSpread[] valuesCustom() {
            GradientSpread[] gradientSpreadArrValuesCustom = values();
            int length = gradientSpreadArrValuesCustom.length;
            GradientSpread[] gradientSpreadArr = new GradientSpread[length];
            System.arraycopy(gradientSpreadArrValuesCustom, 0, gradientSpreadArr, 0, length);
            return gradientSpreadArr;
        }
    }

    protected interface HasTransform {
        void setTransform(Matrix matrix);
    }

    protected interface NotDirectlyRendered {
    }

    protected interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    protected interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    protected interface SvgContainer {
        void addChild(SvgObject svgObject) throws SAXException;

        List<SvgObject> getChildren();
    }

    protected interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    protected interface TextRoot {
    }

    protected enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Unit[] valuesCustom() {
            Unit[] unitArrValuesCustom = values();
            int length = unitArrValuesCustom.length;
            Unit[] unitArr = new Unit[length];
            System.arraycopy(unitArrValuesCustom, 0, unitArr, 0, length);
            return unitArr;
        }
    }

    protected SVG() {
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new SVGParser().parse(inputStream);
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new SVGParser().parse(new ByteArrayInputStream(str.getBytes()));
    }

    public static SVG getFromResource(Context context, int i) throws SVGParseException {
        return getFromResource(context.getResources(), i);
    }

    public static SVG getFromResource(Resources resources, int i) throws SVGParseException {
        return new SVGParser().parse(resources.openRawResource(i));
    }

    public static SVG getFromAsset(AssetManager assetManager, String str) throws IOException, SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream inputStreamOpen = assetManager.open(str);
        SVG svg = sVGParser.parse(inputStreamOpen);
        inputStreamOpen.close();
        return svg;
    }

    public void registerExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        this.fileResolver = sVGExternalFileResolver;
    }

    public void setRenderDPI(float f) {
        this.renderDPI = f;
    }

    public float getRenderDPI() {
        return this.renderDPI;
    }

    public Picture renderToPicture() {
        float fFloatValue;
        Length length = this.rootElement.width;
        if (length != null) {
            float fFloatValue2 = length.floatValue(this.renderDPI);
            Box box = this.rootElement.viewBox;
            if (box != null) {
                fFloatValue = (box.height * fFloatValue2) / box.width;
            } else {
                Length length2 = this.rootElement.height;
                fFloatValue = length2 != null ? length2.floatValue(this.renderDPI) : fFloatValue2;
            }
            return renderToPicture((int) Math.ceil(fFloatValue2), (int) Math.ceil(fFloatValue));
        }
        return renderToPicture(512, 512);
    }

    public Picture renderToPicture(int i, int i2) {
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i, i2), new Box(0.0f, 0.0f, i, i2), this.renderDPI).renderDocument(this, null, null, false);
        picture.endRecording();
        return picture;
    }

    public Picture renderViewToPicture(String str, int i, int i2) {
        SvgObject elementById = getElementById(str);
        if (elementById == null || !(elementById instanceof View)) {
            return null;
        }
        View view = (View) elementById;
        if (view.viewBox == null) {
            Log.w(TAG, "View element is missing a viewBox attribute.");
            return null;
        }
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i, i2), new Box(0.0f, 0.0f, i, i2), this.renderDPI).renderDocument(this, view.viewBox, view.preserveAspectRatio, false);
        picture.endRecording();
        return picture;
    }

    public void renderToCanvas(Canvas canvas) {
        renderToCanvas(canvas, null);
    }

    public void renderToCanvas(Canvas canvas, RectF rectF) {
        Box box;
        if (rectF != null) {
            box = Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
        } else {
            box = new Box(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, box, this.renderDPI).renderDocument(this, null, null, true);
    }

    public void renderViewToCanvas(String str, Canvas canvas) {
        renderViewToCanvas(str, canvas, null);
    }

    public void renderViewToCanvas(String str, Canvas canvas, RectF rectF) {
        Box box;
        SvgObject elementById = getElementById(str);
        if (elementById != null && (elementById instanceof View)) {
            View view = (View) elementById;
            if (view.viewBox == null) {
                Log.w(TAG, "View element is missing a viewBox attribute.");
                return;
            }
            if (rectF != null) {
                box = Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box = new Box(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            }
            new SVGAndroidRenderer(canvas, box, this.renderDPI).renderDocument(this, view.viewBox, view.preserveAspectRatio, true);
        }
    }

    public static String getVersion() {
        return VERSION;
    }

    public String getDocumentTitle() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.title;
    }

    public String getDocumentDescription() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return this.desc;
    }

    public String getDocumentSVGVersion() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return svg.version;
    }

    public Set<String> getViewList() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        List<SvgObject> elementsByTagName = getElementsByTagName(View.class);
        HashSet hashSet = new HashSet(elementsByTagName.size());
        Iterator<SvgObject> it = elementsByTagName.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view.id != null) {
                hashSet.add(view.id);
            } else {
                Log.w(TAG, "getViewList(): found a <view> without an id attribute");
            }
        }
        return hashSet;
    }

    public float getDocumentWidth() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).width;
    }

    public void setDocumentWidth(float f) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.width = new Length(f);
    }

    public void setDocumentWidth(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        try {
            svg.width = SVGParser.parseLength(str);
        } catch (SAXException e) {
            throw new SVGParseException(e.getMessage());
        }
    }

    public float getDocumentHeight() {
        if (this.rootElement == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        return getDocumentDimensions(this.renderDPI).height;
    }

    public void setDocumentHeight(float f) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.height = new Length(f);
    }

    public void setDocumentHeight(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        try {
            svg.height = SVGParser.parseLength(str);
        } catch (SAXException e) {
            throw new SVGParseException(e.getMessage());
        }
    }

    public void setDocumentViewBox(float f, float f2, float f3, float f4) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.viewBox = new Box(f, f2, f3, f4);
    }

    public RectF getDocumentViewBox() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (svg.viewBox == null) {
            return null;
        }
        return this.rootElement.viewBox.toRectF();
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.preserveAspectRatio = preserveAspectRatio;
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        if (svg.preserveAspectRatio == null) {
            return null;
        }
        return this.rootElement.preserveAspectRatio;
    }

    public float getDocumentAspectRatio() {
        float fFloatValue;
        float fFloatValue2;
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        Length length = svg.width;
        Length length2 = this.rootElement.height;
        if (length != null && length2 != null && length.unit != Unit.percent && length2.unit != Unit.percent) {
            if (length.isZero() || length2.isZero()) {
                return -1.0f;
            }
            fFloatValue = length.floatValue(this.renderDPI);
            fFloatValue2 = length2.floatValue(this.renderDPI);
        } else {
            if (this.rootElement.viewBox == null || this.rootElement.viewBox.width == 0.0f || this.rootElement.viewBox.height == 0.0f) {
                return -1.0f;
            }
            fFloatValue = this.rootElement.viewBox.width;
            fFloatValue2 = this.rootElement.viewBox.height;
        }
        return fFloatValue / fFloatValue2;
    }

    protected Svg getRootElement() {
        return this.rootElement;
    }

    protected void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    protected SvgObject resolveIRI(String str) {
        if (str != null && str.length() > 1 && str.startsWith("#")) {
            return getElementById(str.substring(1));
        }
        return null;
    }

    private Box getDocumentDimensions(float f) {
        float fFloatValue;
        Length length = this.rootElement.width;
        Length length2 = this.rootElement.height;
        if (length == null || length.isZero() || length.unit == Unit.percent || length.unit == Unit.em || length.unit == Unit.ex) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float fFloatValue2 = length.floatValue(f);
        if (length2 != null) {
            if (length2.isZero() || length2.unit == Unit.percent || length2.unit == Unit.em || length2.unit == Unit.ex) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            fFloatValue = length2.floatValue(f);
        } else {
            fFloatValue = this.rootElement.viewBox != null ? (this.rootElement.viewBox.height * fFloatValue2) / this.rootElement.viewBox.width : fFloatValue2;
        }
        return new Box(0.0f, 0.0f, fFloatValue2, fFloatValue);
    }

    protected void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    protected List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    protected boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    protected static class Box implements Cloneable {
        public float height;
        public float minX;
        public float minY;
        public float width;

        public Box(float f, float f2, float f3, float f4) {
            this.minX = f;
            this.minY = f2;
            this.width = f3;
            this.height = f4;
        }

        public static Box fromLimits(float f, float f2, float f3, float f4) {
            return new Box(f, f2, f3 - f, f4 - f2);
        }

        public RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        public float maxX() {
            return this.minX + this.width;
        }

        public float maxY() {
            return this.minY + this.height;
        }

        public void union(Box box) {
            float f = box.minX;
            if (f < this.minX) {
                this.minX = f;
            }
            float f2 = box.minY;
            if (f2 < this.minY) {
                this.minY = f2;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }

        public String toString() {
            return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
        }
    }

    protected static class Style implements Cloneable {
        public static final int FONT_WEIGHT_BOLD = 700;
        public static final int FONT_WEIGHT_BOLDER = 1;
        public static final int FONT_WEIGHT_LIGHTER = -1;
        public static final int FONT_WEIGHT_NORMAL = 400;
        public CSSClipRect clip;
        public String clipPath;
        public FillRule clipRule;
        public Colour color;
        public TextDirection direction;
        public Boolean display;
        public SvgPaint fill;
        public Float fillOpacity;
        public FillRule fillRule;
        public List<String> fontFamily;
        public Length fontSize;
        public FontStyle fontStyle;
        public Integer fontWeight;
        public String markerEnd;
        public String markerMid;
        public String markerStart;
        public String mask;
        public Float opacity;
        public Boolean overflow;
        public SvgPaint solidColor;
        public Float solidOpacity;
        public long specifiedFlags = 0;
        public SvgPaint stopColor;
        public Float stopOpacity;
        public SvgPaint stroke;
        public Length[] strokeDashArray;
        public Length strokeDashOffset;
        public LineCaps strokeLineCap;
        public LineJoin strokeLineJoin;
        public Float strokeMiterLimit;
        public Float strokeOpacity;
        public Length strokeWidth;
        public TextAnchor textAnchor;
        public TextDecoration textDecoration;
        public VectorEffect vectorEffect;
        public SvgPaint viewportFill;
        public Float viewportFillOpacity;
        public Boolean visibility;

        public enum FillRule {
            NonZero,
            EvenOdd;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static FillRule[] valuesCustom() {
                FillRule[] fillRuleArrValuesCustom = values();
                int length = fillRuleArrValuesCustom.length;
                FillRule[] fillRuleArr = new FillRule[length];
                System.arraycopy(fillRuleArrValuesCustom, 0, fillRuleArr, 0, length);
                return fillRuleArr;
            }
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static FontStyle[] valuesCustom() {
                FontStyle[] fontStyleArrValuesCustom = values();
                int length = fontStyleArrValuesCustom.length;
                FontStyle[] fontStyleArr = new FontStyle[length];
                System.arraycopy(fontStyleArrValuesCustom, 0, fontStyleArr, 0, length);
                return fontStyleArr;
            }
        }

        public enum LineCaps {
            Butt,
            Round,
            Square;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static LineCaps[] valuesCustom() {
                LineCaps[] lineCapsArrValuesCustom = values();
                int length = lineCapsArrValuesCustom.length;
                LineCaps[] lineCapsArr = new LineCaps[length];
                System.arraycopy(lineCapsArrValuesCustom, 0, lineCapsArr, 0, length);
                return lineCapsArr;
            }
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static LineJoin[] valuesCustom() {
                LineJoin[] lineJoinArrValuesCustom = values();
                int length = lineJoinArrValuesCustom.length;
                LineJoin[] lineJoinArr = new LineJoin[length];
                System.arraycopy(lineJoinArrValuesCustom, 0, lineJoinArr, 0, length);
                return lineJoinArr;
            }
        }

        public enum TextAnchor {
            Start,
            Middle,
            End;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextAnchor[] valuesCustom() {
                TextAnchor[] textAnchorArrValuesCustom = values();
                int length = textAnchorArrValuesCustom.length;
                TextAnchor[] textAnchorArr = new TextAnchor[length];
                System.arraycopy(textAnchorArrValuesCustom, 0, textAnchorArr, 0, length);
                return textAnchorArr;
            }
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextDecoration[] valuesCustom() {
                TextDecoration[] textDecorationArrValuesCustom = values();
                int length = textDecorationArrValuesCustom.length;
                TextDecoration[] textDecorationArr = new TextDecoration[length];
                System.arraycopy(textDecorationArrValuesCustom, 0, textDecorationArr, 0, length);
                return textDecorationArr;
            }
        }

        public enum TextDirection {
            LTR,
            RTL;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextDirection[] valuesCustom() {
                TextDirection[] textDirectionArrValuesCustom = values();
                int length = textDirectionArrValuesCustom.length;
                TextDirection[] textDirectionArr = new TextDirection[length];
                System.arraycopy(textDirectionArrValuesCustom, 0, textDirectionArr, 0, length);
                return textDirectionArr;
            }
        }

        public enum VectorEffect {
            None,
            NonScalingStroke;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static VectorEffect[] valuesCustom() {
                VectorEffect[] vectorEffectArrValuesCustom = values();
                int length = vectorEffectArrValuesCustom.length;
                VectorEffect[] vectorEffectArr = new VectorEffect[length];
                System.arraycopy(vectorEffectArrValuesCustom, 0, vectorEffectArr, 0, length);
                return vectorEffectArr;
            }
        }

        protected Style() {
        }

        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1L;
            style.fill = Colour.BLACK;
            style.fillRule = FillRule.NonZero;
            Float fValueOf = Float.valueOf(1.0f);
            style.fillOpacity = fValueOf;
            style.stroke = null;
            style.strokeOpacity = fValueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCaps.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = fValueOf;
            style.color = Colour.BLACK;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            style.overflow = true;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = Boolean.TRUE;
            style.visibility = Boolean.TRUE;
            style.stopColor = Colour.BLACK;
            style.stopOpacity = fValueOf;
            style.clipPath = null;
            style.clipRule = FillRule.NonZero;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = fValueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = fValueOf;
            style.vectorEffect = VectorEffect.None;
            return style;
        }

        public void resetNonInheritingProperties() {
            resetNonInheritingProperties(false);
        }

        public void resetNonInheritingProperties(boolean z) {
            this.display = Boolean.TRUE;
            this.overflow = z ? Boolean.TRUE : Boolean.FALSE;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }

        protected Object clone() {
            try {
                Style style = (Style) super.clone();
                Length[] lengthArr = this.strokeDashArray;
                if (lengthArr != null) {
                    style.strokeDashArray = (Length[]) lengthArr.clone();
                }
                return style;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    protected static abstract class SvgPaint implements Cloneable {
        protected SvgPaint() {
        }
    }

    protected static class Colour extends SvgPaint {
        public static final Colour BLACK = new Colour(0);
        public int colour;

        public Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.colour));
        }
    }

    protected static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        public static CurrentColor getInstance() {
            return instance;
        }
    }

    protected static class PaintReference extends SvgPaint {
        public SvgPaint fallback;
        public String href;

        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return String.valueOf(this.href) + " " + this.fallback;
        }
    }

    protected static class Length implements Cloneable {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit;
        Unit unit;
        float value;

        static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit() {
            int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[Unit.valuesCustom().length];
            try {
                iArr2[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit = iArr2;
            return iArr2;
        }

        public Length(float f, Unit unit) {
            this.value = 0.0f;
            Unit unit2 = Unit.px;
            this.value = f;
            this.unit = unit;
        }

        public Length(float f) {
            this.value = 0.0f;
            this.unit = Unit.px;
            this.value = f;
            this.unit = Unit.px;
        }

        public float floatValue() {
            return this.value;
        }

        public float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit()[this.unit.ordinal()]) {
                case 9:
                    Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                    if (currentViewPortInUserUnits != null) {
                        break;
                    } else {
                        break;
                    }
            }
            return this.value;
        }

        public float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                return (this.value * currentViewPortInUserUnits.height) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                float f = currentViewPortInUserUnits.width;
                if (f == currentViewPortInUserUnits.height) {
                    return (this.value * f) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f * f) + (r7 * r7)) / SVG.SQRT2))) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public float floatValue(float f) {
            int i = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit()[this.unit.ordinal()];
            if (i == 1) {
                return this.value;
            }
            switch (i) {
                case 4:
                    return this.value * f;
                case 5:
                    return (this.value * f) / 2.54f;
                case 6:
                    return (this.value * f) / 25.4f;
                case 7:
                    return (this.value * f) / 72.0f;
                case 8:
                    return (this.value * f) / 6.0f;
                default:
                    return this.value;
            }
        }

        public boolean isZero() {
            return this.value == 0.0f;
        }

        public boolean isNegative() {
            return this.value < 0.0f;
        }

        public String toString() {
            return String.valueOf(String.valueOf(this.value)) + this.unit;
        }
    }

    protected static class CSSClipRect {
        public Length bottom;
        public Length left;
        public Length right;
        public Length top;

        public CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    protected static class SvgObject {
        public SVG document;
        public SvgContainer parent;

        protected SvgObject() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    protected static class SvgElementBase extends SvgObject {
        public String id = null;
        public Boolean spacePreserve = null;
        public Style baseStyle = null;
        public Style style = null;
        public List<String> classNames = null;

        protected SvgElementBase() {
        }
    }

    protected static class SvgElement extends SvgElementBase {
        public Box boundingBox = null;

        protected SvgElement() {
        }
    }

    protected static class SvgConditionalElement extends SvgElement implements SvgConditional {
        public Set<String> requiredFeatures = null;
        public String requiredExtensions = null;
        public Set<String> systemLanguage = null;
        public Set<String> requiredFormats = null;
        public Set<String> requiredFonts = null;

        protected SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    protected static class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        public List<SvgObject> children = new ArrayList();
        public Set<String> requiredFeatures = null;
        public String requiredExtensions = null;
        public Set<String> systemLanguage = null;
        public Set<String> requiredFormats = null;
        public Set<String> requiredFonts = null;

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        protected SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            this.children.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }
    }

    protected static class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        public PreserveAspectRatio preserveAspectRatio = null;

        protected SvgPreserveAspectRatioContainer() {
        }
    }

    protected static class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        public Box viewBox;

        protected SvgViewBoxContainer() {
        }
    }

    protected static class Svg extends SvgViewBoxContainer {
        public Length height;
        public String version;
        public Length width;
        public Length x;
        public Length y;

        protected Svg() {
        }
    }

    protected static class Group extends SvgConditionalContainer implements HasTransform {
        public Matrix transform;

        protected Group() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    protected static class Defs extends Group implements NotDirectlyRendered {
        protected Defs() {
        }
    }

    protected static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        public Matrix transform;

        protected GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    protected static class Use extends Group {
        public Length height;
        public String href;
        public Length width;
        public Length x;
        public Length y;

        protected Use() {
        }
    }

    protected static class Path extends GraphicsElement {
        public PathDefinition d;
        public Float pathLength;

        protected Path() {
        }
    }

    protected static class Rect extends GraphicsElement {
        public Length height;
        public Length rx;
        public Length ry;
        public Length width;
        public Length x;
        public Length y;

        protected Rect() {
        }
    }

    protected static class Circle extends GraphicsElement {
        public Length cx;
        public Length cy;
        public Length r;

        protected Circle() {
        }
    }

    protected static class Ellipse extends GraphicsElement {
        public Length cx;
        public Length cy;
        public Length rx;
        public Length ry;

        protected Ellipse() {
        }
    }

    protected static class Line extends GraphicsElement {
        public Length x1;
        public Length x2;
        public Length y1;
        public Length y2;

        protected Line() {
        }
    }

    protected static class PolyLine extends GraphicsElement {
        public float[] points;

        protected PolyLine() {
        }
    }

    protected static class Polygon extends PolyLine {
        protected Polygon() {
        }
    }

    protected static class TextContainer extends SvgConditionalContainer {
        protected TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    protected static class TextPositionedContainer extends TextContainer {
        public List<Length> dx;
        public List<Length> dy;
        public List<Length> x;
        public List<Length> y;

        protected TextPositionedContainer() {
        }
    }

    protected static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        public Matrix transform;

        protected Text() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    protected static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        protected TSpan() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    protected static class TextSequence extends SvgObject implements TextChild {
        public String text;
        private TextRoot textRoot;

        public TextSequence(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String toString() {
            return String.valueOf(getClass().getSimpleName()) + " '" + this.text + "'";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    protected static class TRef extends TextContainer implements TextChild {
        public String href;
        private TextRoot textRoot;

        protected TRef() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    protected static class TextPath extends TextContainer implements TextChild {
        public String href;
        public Length startOffset;
        private TextRoot textRoot;

        protected TextPath() {
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }
    }

    protected static class Switch extends Group {
        protected Switch() {
        }
    }

    protected static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        protected Symbol() {
        }
    }

    protected static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length markerHeight;
        public boolean markerUnitsAreUser;
        public Length markerWidth;
        public Float orient;
        public Length refX;
        public Length refY;

        protected Marker() {
        }
    }

    protected static class GradientElement extends SvgElementBase implements SvgContainer {
        public List<SvgObject> children = new ArrayList();
        public Matrix gradientTransform;
        public Boolean gradientUnitsAreUser;
        public String href;
        public GradientSpread spreadMethod;

        protected GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + svgObject + " elements.");
        }
    }

    protected static class Stop extends SvgElementBase implements SvgContainer {
        public Float offset;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
        }

        protected Stop() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return SVG.EMPTY_CHILD_LIST;
        }
    }

    protected static class SvgLinearGradient extends GradientElement {
        public Length x1;
        public Length x2;
        public Length y1;
        public Length y2;

        protected SvgLinearGradient() {
        }
    }

    protected static class SvgRadialGradient extends GradientElement {
        public Length cx;
        public Length cy;
        public Length fx;
        public Length fy;
        public Length r;

        protected SvgRadialGradient() {
        }
    }

    protected static class ClipPath extends Group implements NotDirectlyRendered {
        public Boolean clipPathUnitsAreUser;

        protected ClipPath() {
        }
    }

    protected static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length height;
        public String href;
        public Boolean patternContentUnitsAreUser;
        public Matrix patternTransform;
        public Boolean patternUnitsAreUser;
        public Length width;
        public Length x;
        public Length y;

        protected Pattern() {
        }
    }

    protected static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        public Length height;
        public String href;
        public Matrix transform;
        public Length width;
        public Length x;
        public Length y;

        protected Image() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    protected static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        protected View() {
        }
    }

    protected static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        public Length height;
        public Boolean maskContentUnitsAreUser;
        public Boolean maskUnitsAreUser;
        public Length width;
        public Length x;
        public Length y;

        protected Mask() {
        }
    }

    protected static class SolidColor extends SvgElementBase implements SvgContainer {
        public Length solidColor;
        public Length solidOpacity;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
        }

        protected SolidColor() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return SVG.EMPTY_CHILD_LIST;
        }
    }

    protected void setTitle(String str) {
        this.title = str;
    }

    protected void setDesc(String str) {
        this.desc = str;
    }

    protected SVGExternalFileResolver getFileResolver() {
        return this.fileResolver;
    }

    protected static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private List<Byte> commands;
        private List<Float> coords;

        public PathDefinition() {
            this.commands = null;
            this.coords = null;
            this.commands = new ArrayList();
            this.coords = new ArrayList();
        }

        public boolean isEmpty() {
            return this.commands.isEmpty();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            this.commands.add((byte) 0);
            this.coords.add(Float.valueOf(f));
            this.coords.add(Float.valueOf(f2));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.commands.add((byte) 1);
            this.coords.add(Float.valueOf(f));
            this.coords.add(Float.valueOf(f2));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.commands.add((byte) 2);
            this.coords.add(Float.valueOf(f));
            this.coords.add(Float.valueOf(f2));
            this.coords.add(Float.valueOf(f3));
            this.coords.add(Float.valueOf(f4));
            this.coords.add(Float.valueOf(f5));
            this.coords.add(Float.valueOf(f6));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.commands.add((byte) 3);
            this.coords.add(Float.valueOf(f));
            this.coords.add(Float.valueOf(f2));
            this.coords.add(Float.valueOf(f3));
            this.coords.add(Float.valueOf(f4));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.commands.add(Byte.valueOf((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0))));
            this.coords.add(Float.valueOf(f));
            this.coords.add(Float.valueOf(f2));
            this.coords.add(Float.valueOf(f3));
            this.coords.add(Float.valueOf(f4));
            this.coords.add(Float.valueOf(f5));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.commands.add((byte) 8);
        }

        public void enumeratePath(PathInterface pathInterface) {
            Iterator<Float> it = this.coords.iterator();
            Iterator<Byte> it2 = this.commands.iterator();
            while (it2.hasNext()) {
                byte bByteValue = it2.next().byteValue();
                if (bByteValue == 0) {
                    pathInterface.moveTo(it.next().floatValue(), it.next().floatValue());
                } else if (bByteValue == 1) {
                    pathInterface.lineTo(it.next().floatValue(), it.next().floatValue());
                } else if (bByteValue == 2) {
                    pathInterface.cubicTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (bByteValue == 3) {
                    pathInterface.quadTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                } else if (bByteValue == 8) {
                    pathInterface.close();
                } else {
                    pathInterface.arcTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), (bByteValue & 2) != 0, (bByteValue & 1) != 0, it.next().floatValue(), it.next().floatValue());
                }
            }
        }
    }

    protected SvgObject getElementById(String str) {
        if (str.equals(this.rootElement.id)) {
            return this.rootElement;
        }
        return getElementById(this.rootElement, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.id)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.id)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (elementById = getElementById((SvgContainer) obj, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    protected List<SvgObject> getElementsByTagName(Class cls) {
        return getElementsByTagName(this.rootElement, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<SvgObject> getElementsByTagName(SvgContainer svgContainer, Class cls) {
        ArrayList arrayList = new ArrayList();
        if (svgContainer.getClass() == cls) {
            arrayList.add((SvgObject) svgContainer);
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj.getClass() == cls) {
                arrayList.add(obj);
            }
            if (obj instanceof SvgContainer) {
                getElementsByTagName((SvgContainer) obj, cls);
            }
        }
        return arrayList;
    }
}
