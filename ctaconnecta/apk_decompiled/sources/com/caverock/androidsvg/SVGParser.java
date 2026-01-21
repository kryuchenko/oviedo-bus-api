package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.logging.type.LogSeverity;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import kotlinx.coroutines.DebugKt;
import org.spongycastle.crypto.tls.CipherSuite;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

/* loaded from: classes.dex */
public class SVGParser extends DefaultHandler2 {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr = null;
    private static final String CURRENTCOLOR = "currentColor";
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String TAG_A = "a";
    private static final String TAG_CIRCLE = "circle";
    private static final String TAG_CLIPPATH = "clipPath";
    private static final String TAG_DEFS = "defs";
    private static final String TAG_DESC = "desc";
    private static final String TAG_ELLIPSE = "ellipse";
    private static final String TAG_G = "g";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_LINE = "line";
    private static final String TAG_LINEARGRADIENT = "linearGradient";
    private static final String TAG_MARKER = "marker";
    private static final String TAG_MASK = "mask";
    private static final String TAG_PATH = "path";
    private static final String TAG_PATTERN = "pattern";
    private static final String TAG_POLYGON = "polygon";
    private static final String TAG_POLYLINE = "polyline";
    private static final String TAG_RADIALGRADIENT = "radialGradient";
    private static final String TAG_RECT = "rect";
    private static final String TAG_SOLIDCOLOR = "solidColor";
    private static final String TAG_STOP = "stop";
    private static final String TAG_STYLE = "style";
    private static final String TAG_SVG = "svg";
    private static final String TAG_SWITCH = "switch";
    private static final String TAG_SYMBOL = "symbol";
    private static final String TAG_TEXT = "text";
    private static final String TAG_TEXTPATH = "textPath";
    private static final String TAG_TITLE = "title";
    private static final String TAG_TREF = "tref";
    private static final String TAG_TSPAN = "tspan";
    private static final String TAG_USE = "use";
    private static final String TAG_VIEW = "view";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    private int ignoreDepth;
    private static HashMap<String, Integer> colourKeywords = new HashMap<>();
    private static HashMap<String, SVG.Length> fontSizeKeywords = new HashMap<>(9);
    private static HashMap<String, Integer> fontWeightKeywords = new HashMap<>(13);
    private static HashMap<String, SVG.Style.FontStyle> fontStyleKeywords = new HashMap<>(3);
    private static HashMap<String, PreserveAspectRatio.Alignment> aspectRatioKeywords = new HashMap<>();
    protected static HashSet<String> supportedFeatures = new HashSet<>();
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private String metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;
    private HashSet<String> supportedFormats = null;

    private void debug(String str, Object... objArr) {
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVGAttr.valuesCustom().length];
        try {
            iArr2[SVGAttr.CLASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVGAttr.UNSUPPORTED.ordinal()] = 92;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVGAttr.clip.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SVGAttr.clipPathUnits.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[SVGAttr.clip_path.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[SVGAttr.clip_rule.ordinal()] = 5;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[SVGAttr.color.ordinal()] = 6;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[SVGAttr.cx.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[SVGAttr.cy.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[SVGAttr.d.ordinal()] = 14;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[SVGAttr.direction.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[SVGAttr.display.ordinal()] = 15;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[SVGAttr.dx.ordinal()] = 10;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[SVGAttr.dy.ordinal()] = 11;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[SVGAttr.fill.ordinal()] = 16;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[SVGAttr.fill_opacity.ordinal()] = 18;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[SVGAttr.fill_rule.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[SVGAttr.font.ordinal()] = 19;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[SVGAttr.font_family.ordinal()] = 20;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr2[SVGAttr.font_size.ordinal()] = 21;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr2[SVGAttr.font_style.ordinal()] = 23;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr2[SVGAttr.font_weight.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr2[SVGAttr.fx.ordinal()] = 12;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr2[SVGAttr.fy.ordinal()] = 13;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr2[SVGAttr.gradientTransform.ordinal()] = 24;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            iArr2[SVGAttr.gradientUnits.ordinal()] = 25;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            iArr2[SVGAttr.height.ordinal()] = 26;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            iArr2[SVGAttr.href.ordinal()] = 27;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            iArr2[SVGAttr.id.ordinal()] = 28;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            iArr2[SVGAttr.marker.ordinal()] = 29;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            iArr2[SVGAttr.markerHeight.ordinal()] = 33;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            iArr2[SVGAttr.markerUnits.ordinal()] = 34;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            iArr2[SVGAttr.markerWidth.ordinal()] = 35;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            iArr2[SVGAttr.marker_end.ordinal()] = 32;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            iArr2[SVGAttr.marker_mid.ordinal()] = 31;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            iArr2[SVGAttr.marker_start.ordinal()] = 30;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            iArr2[SVGAttr.mask.ordinal()] = 36;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            iArr2[SVGAttr.maskContentUnits.ordinal()] = 37;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            iArr2[SVGAttr.maskUnits.ordinal()] = 38;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            iArr2[SVGAttr.media.ordinal()] = 39;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            iArr2[SVGAttr.offset.ordinal()] = 40;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            iArr2[SVGAttr.opacity.ordinal()] = 41;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            iArr2[SVGAttr.orient.ordinal()] = 42;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            iArr2[SVGAttr.overflow.ordinal()] = 43;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            iArr2[SVGAttr.pathLength.ordinal()] = 44;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            iArr2[SVGAttr.patternContentUnits.ordinal()] = 45;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            iArr2[SVGAttr.patternTransform.ordinal()] = 46;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            iArr2[SVGAttr.patternUnits.ordinal()] = 47;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            iArr2[SVGAttr.points.ordinal()] = 48;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            iArr2[SVGAttr.preserveAspectRatio.ordinal()] = 49;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            iArr2[SVGAttr.r.ordinal()] = 50;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            iArr2[SVGAttr.refX.ordinal()] = 51;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            iArr2[SVGAttr.refY.ordinal()] = 52;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            iArr2[SVGAttr.requiredExtensions.ordinal()] = 54;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            iArr2[SVGAttr.requiredFeatures.ordinal()] = 53;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            iArr2[SVGAttr.requiredFonts.ordinal()] = 56;
        } catch (NoSuchFieldError unused56) {
        }
        try {
            iArr2[SVGAttr.requiredFormats.ordinal()] = 55;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            iArr2[SVGAttr.rx.ordinal()] = 57;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            iArr2[SVGAttr.ry.ordinal()] = 58;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            iArr2[SVGAttr.solid_color.ordinal()] = 59;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            iArr2[SVGAttr.solid_opacity.ordinal()] = 60;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            iArr2[SVGAttr.spreadMethod.ordinal()] = 61;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            iArr2[SVGAttr.startOffset.ordinal()] = 62;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            iArr2[SVGAttr.stop_color.ordinal()] = 63;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            iArr2[SVGAttr.stop_opacity.ordinal()] = 64;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            iArr2[SVGAttr.stroke.ordinal()] = 65;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            iArr2[SVGAttr.stroke_dasharray.ordinal()] = 66;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            iArr2[SVGAttr.stroke_dashoffset.ordinal()] = 67;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            iArr2[SVGAttr.stroke_linecap.ordinal()] = 68;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            iArr2[SVGAttr.stroke_linejoin.ordinal()] = 69;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            iArr2[SVGAttr.stroke_miterlimit.ordinal()] = 70;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            iArr2[SVGAttr.stroke_opacity.ordinal()] = 71;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            iArr2[SVGAttr.stroke_width.ordinal()] = 72;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            iArr2[SVGAttr.style.ordinal()] = 73;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            iArr2[SVGAttr.systemLanguage.ordinal()] = 74;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            iArr2[SVGAttr.text_anchor.ordinal()] = 75;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            iArr2[SVGAttr.text_decoration.ordinal()] = 76;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            iArr2[SVGAttr.transform.ordinal()] = 77;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            iArr2[SVGAttr.type.ordinal()] = 78;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            iArr2[SVGAttr.vector_effect.ordinal()] = 79;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            iArr2[SVGAttr.version.ordinal()] = 80;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            iArr2[SVGAttr.viewBox.ordinal()] = 81;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            iArr2[SVGAttr.viewport_fill.ordinal()] = 89;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            iArr2[SVGAttr.viewport_fill_opacity.ordinal()] = 90;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            iArr2[SVGAttr.visibility.ordinal()] = 91;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            iArr2[SVGAttr.width.ordinal()] = 82;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            iArr2[SVGAttr.x.ordinal()] = 83;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            iArr2[SVGAttr.x1.ordinal()] = 85;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            iArr2[SVGAttr.x2.ordinal()] = 87;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            iArr2[SVGAttr.y.ordinal()] = 84;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            iArr2[SVGAttr.y1.ordinal()] = 86;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            iArr2[SVGAttr.y2.ordinal()] = 88;
        } catch (NoSuchFieldError unused92) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr = iArr2;
        return iArr2;
    }

    private enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        id,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SVGAttr[] valuesCustom() {
            SVGAttr[] sVGAttrArrValuesCustom = values();
            int length = sVGAttrArrValuesCustom.length;
            SVGAttr[] sVGAttrArr = new SVGAttr[length];
            System.arraycopy(sVGAttrArrValuesCustom, 0, sVGAttrArr, 0, length);
            return sVGAttrArr;
        }

        public static SVGAttr fromString(String str) {
            if (str.equals("class")) {
                return CLASS;
            }
            if (str.indexOf(95) != -1) {
                return UNSUPPORTED;
            }
            try {
                return valueOf(str.replace('-', '_'));
            } catch (IllegalArgumentException unused) {
                return UNSUPPORTED;
            }
        }
    }

    static {
        colourKeywords.put("aliceblue", 15792383);
        colourKeywords.put("antiquewhite", 16444375);
        colourKeywords.put("aqua", 65535);
        colourKeywords.put("aquamarine", 8388564);
        colourKeywords.put("azure", 15794175);
        colourKeywords.put("beige", 16119260);
        colourKeywords.put("bisque", 16770244);
        colourKeywords.put("black", 0);
        colourKeywords.put("blanchedalmond", 16772045);
        colourKeywords.put("blue", 255);
        colourKeywords.put("blueviolet", 9055202);
        colourKeywords.put("brown", 10824234);
        colourKeywords.put("burlywood", 14596231);
        colourKeywords.put("cadetblue", 6266528);
        colourKeywords.put("chartreuse", 8388352);
        colourKeywords.put("chocolate", 13789470);
        colourKeywords.put("coral", 16744272);
        colourKeywords.put("cornflowerblue", 6591981);
        colourKeywords.put("cornsilk", 16775388);
        colourKeywords.put("crimson", 14423100);
        colourKeywords.put("cyan", 65535);
        colourKeywords.put("darkblue", Integer.valueOf(CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA));
        colourKeywords.put("darkcyan", 35723);
        colourKeywords.put("darkgoldenrod", 12092939);
        colourKeywords.put("darkgray", 11119017);
        colourKeywords.put("darkgreen", 25600);
        colourKeywords.put("darkgrey", 11119017);
        colourKeywords.put("darkkhaki", 12433259);
        colourKeywords.put("darkmagenta", 9109643);
        colourKeywords.put("darkolivegreen", 5597999);
        colourKeywords.put("darkorange", 16747520);
        colourKeywords.put("darkorchid", 10040012);
        colourKeywords.put("darkred", 9109504);
        colourKeywords.put("darksalmon", 15308410);
        colourKeywords.put("darkseagreen", 9419919);
        colourKeywords.put("darkslateblue", 4734347);
        colourKeywords.put("darkslategray", 3100495);
        colourKeywords.put("darkslategrey", 3100495);
        colourKeywords.put("darkturquoise", 52945);
        colourKeywords.put("darkviolet", 9699539);
        colourKeywords.put("deeppink", 16716947);
        colourKeywords.put("deepskyblue", 49151);
        colourKeywords.put("dimgray", 6908265);
        colourKeywords.put("dimgrey", 6908265);
        colourKeywords.put("dodgerblue", 2003199);
        colourKeywords.put("firebrick", 11674146);
        colourKeywords.put("floralwhite", 16775920);
        colourKeywords.put("forestgreen", 2263842);
        colourKeywords.put("fuchsia", 16711935);
        colourKeywords.put("gainsboro", 14474460);
        colourKeywords.put("ghostwhite", 16316671);
        colourKeywords.put("gold", 16766720);
        colourKeywords.put("goldenrod", 14329120);
        colourKeywords.put("gray", 8421504);
        colourKeywords.put("green", 32768);
        colourKeywords.put("greenyellow", 11403055);
        colourKeywords.put("grey", 8421504);
        colourKeywords.put("honeydew", 15794160);
        colourKeywords.put("hotpink", 16738740);
        colourKeywords.put("indianred", 13458524);
        colourKeywords.put("indigo", 4915330);
        colourKeywords.put("ivory", 16777200);
        colourKeywords.put("khaki", 15787660);
        colourKeywords.put("lavender", 15132410);
        colourKeywords.put("lavenderblush", 16773365);
        colourKeywords.put("lawngreen", 8190976);
        colourKeywords.put("lemonchiffon", 16775885);
        colourKeywords.put("lightblue", 11393254);
        colourKeywords.put("lightcoral", 15761536);
        colourKeywords.put("lightcyan", 14745599);
        colourKeywords.put("lightgoldenrodyellow", 16448210);
        colourKeywords.put("lightgray", 13882323);
        colourKeywords.put("lightgreen", 9498256);
        colourKeywords.put("lightgrey", 13882323);
        colourKeywords.put("lightpink", 16758465);
        colourKeywords.put("lightsalmon", 16752762);
        colourKeywords.put("lightseagreen", 2142890);
        colourKeywords.put("lightskyblue", 8900346);
        colourKeywords.put("lightslategray", 7833753);
        colourKeywords.put("lightslategrey", 7833753);
        colourKeywords.put("lightsteelblue", 11584734);
        colourKeywords.put("lightyellow", 16777184);
        colourKeywords.put("lime", 65280);
        colourKeywords.put("limegreen", 3329330);
        colourKeywords.put("linen", 16445670);
        colourKeywords.put("magenta", 16711935);
        colourKeywords.put("maroon", 8388608);
        colourKeywords.put("mediumaquamarine", 6737322);
        colourKeywords.put("mediumblue", 205);
        colourKeywords.put("mediumorchid", 12211667);
        colourKeywords.put("mediumpurple", 9662683);
        colourKeywords.put("mediumseagreen", 3978097);
        colourKeywords.put("mediumslateblue", 8087790);
        colourKeywords.put("mediumspringgreen", 64154);
        colourKeywords.put("mediumturquoise", 4772300);
        colourKeywords.put("mediumvioletred", 13047173);
        colourKeywords.put("midnightblue", 1644912);
        colourKeywords.put("mintcream", 16121850);
        colourKeywords.put("mistyrose", 16770273);
        colourKeywords.put("moccasin", 16770229);
        colourKeywords.put("navajowhite", 16768685);
        colourKeywords.put("navy", 128);
        colourKeywords.put("oldlace", 16643558);
        colourKeywords.put("olive", 8421376);
        colourKeywords.put("olivedrab", 7048739);
        colourKeywords.put("orange", 16753920);
        colourKeywords.put("orangered", 16729344);
        colourKeywords.put("orchid", 14315734);
        colourKeywords.put("palegoldenrod", 15657130);
        colourKeywords.put("palegreen", 10025880);
        colourKeywords.put("paleturquoise", 11529966);
        colourKeywords.put("palevioletred", 14381203);
        colourKeywords.put("papayawhip", 16773077);
        colourKeywords.put("peachpuff", 16767673);
        colourKeywords.put("peru", 13468991);
        colourKeywords.put("pink", 16761035);
        colourKeywords.put("plum", 14524637);
        colourKeywords.put("powderblue", 11591910);
        colourKeywords.put("purple", 8388736);
        colourKeywords.put("red", 16711680);
        colourKeywords.put("rosybrown", 12357519);
        colourKeywords.put("royalblue", 4286945);
        colourKeywords.put("saddlebrown", 9127187);
        colourKeywords.put("salmon", 16416882);
        colourKeywords.put("sandybrown", 16032864);
        colourKeywords.put("seagreen", 3050327);
        colourKeywords.put("seashell", 16774638);
        colourKeywords.put("sienna", 10506797);
        colourKeywords.put("silver", 12632256);
        colourKeywords.put("skyblue", 8900331);
        colourKeywords.put("slateblue", 6970061);
        colourKeywords.put("slategray", 7372944);
        colourKeywords.put("slategrey", 7372944);
        colourKeywords.put("snow", 16775930);
        colourKeywords.put("springgreen", 65407);
        colourKeywords.put("steelblue", 4620980);
        colourKeywords.put("tan", 13808780);
        colourKeywords.put("teal", 32896);
        colourKeywords.put("thistle", 14204888);
        colourKeywords.put("tomato", 16737095);
        colourKeywords.put("turquoise", 4251856);
        colourKeywords.put("violet", 15631086);
        colourKeywords.put("wheat", 16113331);
        colourKeywords.put("white", Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK));
        colourKeywords.put("whitesmoke", 16119285);
        colourKeywords.put("yellow", 16776960);
        colourKeywords.put("yellowgreen", 10145074);
        fontSizeKeywords.put("xx-small", new SVG.Length(0.694f, SVG.Unit.pt));
        fontSizeKeywords.put("x-small", new SVG.Length(0.833f, SVG.Unit.pt));
        fontSizeKeywords.put("small", new SVG.Length(10.0f, SVG.Unit.pt));
        fontSizeKeywords.put("medium", new SVG.Length(12.0f, SVG.Unit.pt));
        fontSizeKeywords.put("large", new SVG.Length(14.4f, SVG.Unit.pt));
        fontSizeKeywords.put("x-large", new SVG.Length(17.3f, SVG.Unit.pt));
        fontSizeKeywords.put("xx-large", new SVG.Length(20.7f, SVG.Unit.pt));
        fontSizeKeywords.put("smaller", new SVG.Length(83.33f, SVG.Unit.percent));
        fontSizeKeywords.put("larger", new SVG.Length(120.0f, SVG.Unit.percent));
        fontWeightKeywords.put("normal", 400);
        fontWeightKeywords.put("bold", 700);
        fontWeightKeywords.put("bolder", 1);
        fontWeightKeywords.put("lighter", -1);
        fontWeightKeywords.put("100", 100);
        fontWeightKeywords.put("200", 200);
        fontWeightKeywords.put("300", 300);
        fontWeightKeywords.put("400", 400);
        fontWeightKeywords.put("500", 500);
        fontWeightKeywords.put("600", 600);
        fontWeightKeywords.put("700", 700);
        fontWeightKeywords.put("800", Integer.valueOf(LogSeverity.EMERGENCY_VALUE));
        fontWeightKeywords.put("900", Integer.valueOf(TypedValues.Custom.TYPE_INT));
        fontStyleKeywords.put("normal", SVG.Style.FontStyle.Normal);
        fontStyleKeywords.put("italic", SVG.Style.FontStyle.Italic);
        fontStyleKeywords.put("oblique", SVG.Style.FontStyle.Oblique);
        aspectRatioKeywords.put("none", PreserveAspectRatio.Alignment.None);
        aspectRatioKeywords.put("xMinYMin", PreserveAspectRatio.Alignment.XMinYMin);
        aspectRatioKeywords.put("xMidYMin", PreserveAspectRatio.Alignment.XMidYMin);
        aspectRatioKeywords.put("xMaxYMin", PreserveAspectRatio.Alignment.XMaxYMin);
        aspectRatioKeywords.put("xMinYMid", PreserveAspectRatio.Alignment.XMinYMid);
        aspectRatioKeywords.put("xMidYMid", PreserveAspectRatio.Alignment.XMidYMid);
        aspectRatioKeywords.put("xMaxYMid", PreserveAspectRatio.Alignment.XMaxYMid);
        aspectRatioKeywords.put("xMinYMax", PreserveAspectRatio.Alignment.XMinYMax);
        aspectRatioKeywords.put("xMidYMax", PreserveAspectRatio.Alignment.XMidYMax);
        aspectRatioKeywords.put("xMaxYMax", PreserveAspectRatio.Alignment.XMaxYMax);
        supportedFeatures.add("Structure");
        supportedFeatures.add("BasicStructure");
        supportedFeatures.add("ConditionalProcessing");
        supportedFeatures.add("Image");
        supportedFeatures.add("Style");
        supportedFeatures.add("ViewportAttribute");
        supportedFeatures.add("Shape");
        supportedFeatures.add("BasicText");
        supportedFeatures.add("PaintAttribute");
        supportedFeatures.add("BasicPaintAttribute");
        supportedFeatures.add("OpacityAttribute");
        supportedFeatures.add("BasicGraphicsAttribute");
        supportedFeatures.add("Marker");
        supportedFeatures.add("Gradient");
        supportedFeatures.add("Pattern");
        supportedFeatures.add("Clip");
        supportedFeatures.add("BasicClip");
        supportedFeatures.add("Mask");
        supportedFeatures.add("View");
    }

    protected void setSupportedFormats(String[] strArr) {
        HashSet<String> hashSet = new HashSet<>(strArr.length);
        this.supportedFormats = hashSet;
        Collections.addAll(hashSet, strArr);
    }

    protected SVG parse(InputStream inputStream) throws IOException, SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int i = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (i == 35615) {
                inputStream = new GZIPInputStream(inputStream);
            }
        } catch (IOException unused) {
        }
        try {
            try {
                try {
                    XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                    xMLReader.setContentHandler(this);
                    xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                    xMLReader.parse(new InputSource(inputStream));
                    return this.svgDocument;
                } catch (SAXException e) {
                    throw new SVGParseException("SVG parse error: " + e.getMessage(), e);
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    Log.e(TAG, "Exception thrown closing input stream");
                }
            }
        } catch (IOException e2) {
            throw new SVGParseException("File error", e2);
        } catch (ParserConfigurationException e3) {
            throw new SVGParseException("XML Parser problem", e3);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
        this.svgDocument = new SVG();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        super.startElement(str, str2, str3, attributes);
        if (this.ignoring) {
            this.ignoreDepth++;
            return;
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.equals(TAG_SVG)) {
                svg(attributes);
                return;
            }
            if (str2.equals(TAG_G)) {
                g(attributes);
                return;
            }
            if (str2.equals(TAG_DEFS)) {
                defs(attributes);
                return;
            }
            if (str2.equals(TAG_USE)) {
                use(attributes);
                return;
            }
            if (str2.equals(TAG_PATH)) {
                path(attributes);
                return;
            }
            if (str2.equals(TAG_RECT)) {
                rect(attributes);
                return;
            }
            if (str2.equals(TAG_CIRCLE)) {
                circle(attributes);
                return;
            }
            if (str2.equals(TAG_ELLIPSE)) {
                ellipse(attributes);
                return;
            }
            if (str2.equals(TAG_LINE)) {
                line(attributes);
                return;
            }
            if (str2.equals(TAG_POLYLINE)) {
                polyline(attributes);
                return;
            }
            if (str2.equals(TAG_POLYGON)) {
                polygon(attributes);
                return;
            }
            if (str2.equals("text")) {
                text(attributes);
                return;
            }
            if (str2.equals(TAG_TSPAN)) {
                tspan(attributes);
                return;
            }
            if (str2.equals(TAG_TREF)) {
                tref(attributes);
                return;
            }
            if (str2.equals(TAG_SWITCH)) {
                zwitch(attributes);
                return;
            }
            if (str2.equals(TAG_SYMBOL)) {
                symbol(attributes);
                return;
            }
            if (str2.equals(TAG_MARKER)) {
                marker(attributes);
                return;
            }
            if (str2.equals(TAG_LINEARGRADIENT)) {
                linearGradient(attributes);
                return;
            }
            if (str2.equals(TAG_RADIALGRADIENT)) {
                radialGradient(attributes);
                return;
            }
            if (str2.equals(TAG_STOP)) {
                stop(attributes);
                return;
            }
            if (str2.equals(TAG_A)) {
                g(attributes);
                return;
            }
            if (str2.equals("title") || str2.equals(TAG_DESC)) {
                this.inMetadataElement = true;
                this.metadataTag = str2;
                return;
            }
            if (str2.equals(TAG_CLIPPATH)) {
                clipPath(attributes);
                return;
            }
            if (str2.equals(TAG_TEXTPATH)) {
                textPath(attributes);
                return;
            }
            if (str2.equals(TAG_PATTERN)) {
                pattern(attributes);
                return;
            }
            if (str2.equals(TAG_IMAGE)) {
                image(attributes);
                return;
            }
            if (str2.equals(TAG_VIEW)) {
                view(attributes);
                return;
            }
            if (str2.equals(TAG_MASK)) {
                mask(attributes);
                return;
            }
            if (str2.equals(TAG_STYLE)) {
                style(attributes);
            } else if (str2.equals(TAG_SOLIDCOLOR)) {
                solidColor(attributes);
            } else {
                this.ignoring = true;
                this.ignoreDepth = 1;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i2);
            }
            this.metadataElementContents.append(cArr, i, i2);
            return;
        }
        if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i2);
            }
            this.styleElementContents.append(cArr, i, i2);
            return;
        }
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer instanceof SVG.TextContainer) {
            SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) svgContainer;
            int size = svgConditionalContainer.children.size();
            SVG.SvgObject svgObject = size == 0 ? null : svgConditionalContainer.children.get(size - 1);
            if (svgObject instanceof SVG.TextSequence) {
                SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
                textSequence.text = String.valueOf(textSequence.text) + new String(cArr, i, i2);
                return;
            }
            ((SVG.SvgConditionalContainer) this.currentElement).addChild(new SVG.TextSequence(new String(cArr, i, i2)));
        }
    }

    @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (!this.ignoring && this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i2);
            }
            this.styleElementContents.append(cArr, i, i2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        StringBuilder sb;
        super.endElement(str, str2, str3);
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
                return;
            }
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.equals("title") || str2.equals(TAG_DESC)) {
                this.inMetadataElement = false;
                if (this.metadataTag.equals("title")) {
                    this.svgDocument.setTitle(this.metadataElementContents.toString());
                } else if (this.metadataTag.equals(TAG_DESC)) {
                    this.svgDocument.setDesc(this.metadataElementContents.toString());
                }
                this.metadataElementContents.setLength(0);
                return;
            }
            if (str2.equals(TAG_STYLE) && (sb = this.styleElementContents) != null) {
                this.inStyleElement = false;
                parseCSSStyleSheet(sb.toString());
                this.styleElementContents.setLength(0);
                return;
            }
            if (str2.equals(TAG_SVG) || str2.equals(TAG_DEFS) || str2.equals(TAG_G) || str2.equals(TAG_USE) || str2.equals(TAG_IMAGE) || str2.equals("text") || str2.equals(TAG_TSPAN) || str2.equals(TAG_SWITCH) || str2.equals(TAG_SYMBOL) || str2.equals(TAG_MARKER) || str2.equals(TAG_LINEARGRADIENT) || str2.equals(TAG_RADIALGRADIENT) || str2.equals(TAG_STOP) || str2.equals(TAG_CLIPPATH) || str2.equals(TAG_TEXTPATH) || str2.equals(TAG_PATTERN) || str2.equals(TAG_VIEW) || str2.equals(TAG_MASK) || str2.equals(TAG_SOLIDCOLOR)) {
                this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    private void dumpNode(SVG.SvgObject svgObject, String str) {
        Log.d(TAG, String.valueOf(str) + svgObject);
        if (svgObject instanceof SVG.SvgConditionalContainer) {
            String str2 = String.valueOf(str) + "  ";
            Iterator<SVG.SvgObject> it = ((SVG.SvgConditionalContainer) svgObject).children.iterator();
            while (it.hasNext()) {
                dumpNode(it.next(), str2);
            }
        }
    }

    private void svg(Attributes attributes) throws SAXException {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                svg.height = parseLength(strTrim);
                if (svg.height.isNegative()) {
                    throw new SAXException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 != 80) {
                switch (i2) {
                    case 82:
                        svg.width = parseLength(strTrim);
                        if (svg.width.isNegative()) {
                            throw new SAXException("Invalid <svg> element. width cannot be negative");
                        }
                        break;
                    case 83:
                        svg.x = parseLength(strTrim);
                        break;
                    case 84:
                        svg.y = parseLength(strTrim);
                        break;
                }
            } else {
                svg.version = strTrim;
            }
        }
    }

    private void g(Attributes attributes) throws SAXException {
        debug("<g>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Group group = new SVG.Group();
        group.document = this.svgDocument;
        group.parent = this.currentElement;
        parseAttributesCore(group, attributes);
        parseAttributesStyle(group, attributes);
        parseAttributesTransform(group, attributes);
        parseAttributesConditional(group, attributes);
        this.currentElement.addChild(group);
        this.currentElement = group;
    }

    private void defs(Attributes attributes) throws SAXException {
        debug("<defs>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Defs defs = new SVG.Defs();
        defs.document = this.svgDocument;
        defs.parent = this.currentElement;
        parseAttributesCore(defs, attributes);
        parseAttributesStyle(defs, attributes);
        parseAttributesTransform(defs, attributes);
        this.currentElement.addChild(defs);
        this.currentElement = defs;
    }

    private void use(Attributes attributes) throws SAXException {
        debug("<use>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Use use = new SVG.Use();
        use.document = this.svgDocument;
        use.parent = this.currentElement;
        parseAttributesCore(use, attributes);
        parseAttributesStyle(use, attributes);
        parseAttributesTransform(use, attributes);
        parseAttributesConditional(use, attributes);
        parseAttributesUse(use, attributes);
        this.currentElement.addChild(use);
        this.currentElement = use;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesUse(SVG.Use use, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                use.height = parseLength(strTrim);
                if (use.height.isNegative()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 27) {
                switch (i2) {
                    case 82:
                        use.width = parseLength(strTrim);
                        if (use.width.isNegative()) {
                            throw new SAXException("Invalid <use> element. width cannot be negative");
                        }
                        break;
                    case 83:
                        use.x = parseLength(strTrim);
                        break;
                    case 84:
                        use.y = parseLength(strTrim);
                        break;
                }
            } else if (XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                use.href = strTrim;
            }
        }
    }

    private void image(Attributes attributes) throws SAXException {
        debug("<image>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Image image = new SVG.Image();
        image.document = this.svgDocument;
        image.parent = this.currentElement;
        parseAttributesCore(image, attributes);
        parseAttributesStyle(image, attributes);
        parseAttributesTransform(image, attributes);
        parseAttributesConditional(image, attributes);
        parseAttributesImage(image, attributes);
        this.currentElement.addChild(image);
        this.currentElement = image;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesImage(SVG.Image image, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                image.height = parseLength(strTrim);
                if (image.height.isNegative()) {
                    throw new SAXException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 27) {
                if (i2 != 49) {
                    switch (i2) {
                        case 82:
                            image.width = parseLength(strTrim);
                            if (image.width.isNegative()) {
                                throw new SAXException("Invalid <use> element. width cannot be negative");
                            }
                            break;
                        case 83:
                            image.x = parseLength(strTrim);
                            break;
                        case 84:
                            image.y = parseLength(strTrim);
                            break;
                    }
                } else {
                    parsePreserveAspectRatio(image, strTrim);
                }
            } else if (XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                image.href = strTrim;
            }
        }
    }

    private void path(Attributes attributes) throws SAXException {
        debug("<path>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Path path = new SVG.Path();
        path.document = this.svgDocument;
        path.parent = this.currentElement;
        parseAttributesCore(path, attributes);
        parseAttributesStyle(path, attributes);
        parseAttributesTransform(path, attributes);
        parseAttributesConditional(path, attributes);
        parseAttributesPath(path, attributes);
        this.currentElement.addChild(path);
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 14) {
                path.d = parsePath(strTrim);
            } else if (i2 != 44) {
                continue;
            } else {
                path.pathLength = Float.valueOf(parseFloat(strTrim));
                if (path.pathLength.floatValue() < 0.0f) {
                    throw new SAXException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void rect(Attributes attributes) throws SAXException {
        debug("<rect>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Rect rect = new SVG.Rect();
        rect.document = this.svgDocument;
        rect.parent = this.currentElement;
        parseAttributesCore(rect, attributes);
        parseAttributesStyle(rect, attributes);
        parseAttributesTransform(rect, attributes);
        parseAttributesConditional(rect, attributes);
        parseAttributesRect(rect, attributes);
        this.currentElement.addChild(rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0093, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                rect.height = parseLength(strTrim);
                if (rect.height.isNegative()) {
                    throw new SAXException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 57) {
                rect.rx = parseLength(strTrim);
                if (rect.rx.isNegative()) {
                    throw new SAXException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 58) {
                switch (i2) {
                    case 82:
                        rect.width = parseLength(strTrim);
                        if (rect.width.isNegative()) {
                            throw new SAXException("Invalid <rect> element. width cannot be negative");
                        }
                        break;
                    case 83:
                        rect.x = parseLength(strTrim);
                        break;
                    case 84:
                        rect.y = parseLength(strTrim);
                        break;
                }
            } else {
                rect.ry = parseLength(strTrim);
                if (rect.ry.isNegative()) {
                    throw new SAXException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void circle(Attributes attributes) throws SAXException {
        debug("<circle>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Circle circle = new SVG.Circle();
        circle.document = this.svgDocument;
        circle.parent = this.currentElement;
        parseAttributesCore(circle, attributes);
        parseAttributesStyle(circle, attributes);
        parseAttributesTransform(circle, attributes);
        parseAttributesConditional(circle, attributes);
        parseAttributesCircle(circle, attributes);
        this.currentElement.addChild(circle);
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                circle.cx = parseLength(strTrim);
            } else if (i2 == 8) {
                circle.cy = parseLength(strTrim);
            } else if (i2 != 50) {
                continue;
            } else {
                circle.r = parseLength(strTrim);
                if (circle.r.isNegative()) {
                    throw new SAXException("Invalid <circle> element. r cannot be negative");
                }
            }
        }
    }

    private void ellipse(Attributes attributes) throws SAXException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Ellipse ellipse = new SVG.Ellipse();
        ellipse.document = this.svgDocument;
        ellipse.parent = this.currentElement;
        parseAttributesCore(ellipse, attributes);
        parseAttributesStyle(ellipse, attributes);
        parseAttributesTransform(ellipse, attributes);
        parseAttributesConditional(ellipse, attributes);
        parseAttributesEllipse(ellipse, attributes);
        this.currentElement.addChild(ellipse);
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                ellipse.cx = parseLength(strTrim);
            } else if (i2 == 8) {
                ellipse.cy = parseLength(strTrim);
            } else if (i2 == 57) {
                ellipse.rx = parseLength(strTrim);
                if (ellipse.rx.isNegative()) {
                    throw new SAXException("Invalid <ellipse> element. rx cannot be negative");
                }
            } else if (i2 != 58) {
                continue;
            } else {
                ellipse.ry = parseLength(strTrim);
                if (ellipse.ry.isNegative()) {
                    throw new SAXException("Invalid <ellipse> element. ry cannot be negative");
                }
            }
        }
    }

    private void line(Attributes attributes) throws SAXException {
        debug("<line>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Line line = new SVG.Line();
        line.document = this.svgDocument;
        line.parent = this.currentElement;
        parseAttributesCore(line, attributes);
        parseAttributesStyle(line, attributes);
        parseAttributesTransform(line, attributes);
        parseAttributesConditional(line, attributes);
        parseAttributesLine(line, attributes);
        this.currentElement.addChild(line);
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 85:
                    line.x1 = parseLength(strTrim);
                    break;
                case 86:
                    line.y1 = parseLength(strTrim);
                    break;
                case 87:
                    line.x2 = parseLength(strTrim);
                    break;
                case 88:
                    line.y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void polyline(Attributes attributes) throws SAXException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polyLine = new SVG.PolyLine();
        polyLine.document = this.svgDocument;
        polyLine.parent = this.currentElement;
        parseAttributesCore(polyLine, attributes);
        parseAttributesStyle(polyLine, attributes);
        parseAttributesTransform(polyLine, attributes);
        parseAttributesConditional(polyLine, attributes);
        parseAttributesPolyLine(polyLine, attributes, TAG_POLYLINE);
        this.currentElement.addChild(polyLine);
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i));
                ArrayList arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    Float fNextFloat = textScanner.nextFloat();
                    if (fNextFloat == null) {
                        throw new SAXException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    textScanner.skipCommaWhitespace();
                    Float fNextFloat2 = textScanner.nextFloat();
                    if (fNextFloat2 == null) {
                        throw new SAXException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    textScanner.skipCommaWhitespace();
                    arrayList.add(fNextFloat);
                    arrayList.add(fNextFloat2);
                }
                polyLine.points = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    polyLine.points[i2] = ((Float) it.next()).floatValue();
                    i2++;
                }
            }
        }
    }

    private void polygon(Attributes attributes) throws SAXException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Polygon polygon = new SVG.Polygon();
        polygon.document = this.svgDocument;
        polygon.parent = this.currentElement;
        parseAttributesCore(polygon, attributes);
        parseAttributesStyle(polygon, attributes);
        parseAttributesTransform(polygon, attributes);
        parseAttributesConditional(polygon, attributes);
        parseAttributesPolyLine(polygon, attributes, TAG_POLYGON);
        this.currentElement.addChild(polygon);
    }

    private void text(Attributes attributes) throws SAXException {
        debug("<text>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Text text = new SVG.Text();
        text.document = this.svgDocument;
        text.parent = this.currentElement;
        parseAttributesCore(text, attributes);
        parseAttributesStyle(text, attributes);
        parseAttributesTransform(text, attributes);
        parseAttributesConditional(text, attributes);
        parseAttributesTextPosition(text, attributes);
        this.currentElement.addChild(text);
        this.currentElement = text;
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 10) {
                textPositionedContainer.dx = parseLengthList(strTrim);
            } else if (i2 == 11) {
                textPositionedContainer.dy = parseLengthList(strTrim);
            } else if (i2 == 83) {
                textPositionedContainer.x = parseLengthList(strTrim);
            } else if (i2 == 84) {
                textPositionedContainer.y = parseLengthList(strTrim);
            }
        }
    }

    private void tspan(Attributes attributes) throws SAXException {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SAXException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.TSpan tSpan = new SVG.TSpan();
        tSpan.document = this.svgDocument;
        tSpan.parent = this.currentElement;
        parseAttributesCore(tSpan, attributes);
        parseAttributesStyle(tSpan, attributes);
        parseAttributesConditional(tSpan, attributes);
        parseAttributesTextPosition(tSpan, attributes);
        this.currentElement.addChild(tSpan);
        this.currentElement = tSpan;
        if (tSpan.parent instanceof SVG.TextRoot) {
            tSpan.setTextRoot((SVG.TextRoot) tSpan.parent);
        } else {
            tSpan.setTextRoot(((SVG.TextChild) tSpan.parent).getTextRoot());
        }
    }

    private void tref(Attributes attributes) throws SAXException {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SAXException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.TRef tRef = new SVG.TRef();
        tRef.document = this.svgDocument;
        tRef.parent = this.currentElement;
        parseAttributesCore(tRef, attributes);
        parseAttributesStyle(tRef, attributes);
        parseAttributesConditional(tRef, attributes);
        parseAttributesTRef(tRef, attributes);
        this.currentElement.addChild(tRef);
        if (tRef.parent instanceof SVG.TextRoot) {
            tRef.setTextRoot((SVG.TextRoot) tRef.parent);
        } else {
            tRef.setTextRoot(((SVG.TextChild) tRef.parent).getTextRoot());
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 27 && XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                tRef.href = strTrim;
            }
        }
    }

    private void zwitch(Attributes attributes) throws SAXException {
        debug("<switch>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Switch r0 = new SVG.Switch();
        r0.document = this.svgDocument;
        r0.parent = this.currentElement;
        parseAttributesCore(r0, attributes);
        parseAttributesStyle(r0, attributes);
        parseAttributesTransform(r0, attributes);
        parseAttributesConditional(r0, attributes);
        this.currentElement.addChild(r0);
        this.currentElement = r0;
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 74) {
                switch (i2) {
                    case 53:
                        svgConditional.setRequiredFeatures(parseRequiredFeatures(strTrim));
                        break;
                    case 54:
                        svgConditional.setRequiredExtensions(strTrim);
                        break;
                    case 55:
                        svgConditional.setRequiredFormats(parseRequiredFormats(strTrim));
                        break;
                    case 56:
                        List<String> fontFamily = parseFontFamily(strTrim);
                        svgConditional.setRequiredFonts(fontFamily != null ? new HashSet(fontFamily) : new HashSet(0));
                        break;
                }
            } else {
                svgConditional.setSystemLanguage(parseSystemLanguage(strTrim));
            }
        }
    }

    private void symbol(Attributes attributes) throws SAXException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Symbol symbol = new SVG.Symbol();
        symbol.document = this.svgDocument;
        symbol.parent = this.currentElement;
        parseAttributesCore(symbol, attributes);
        parseAttributesStyle(symbol, attributes);
        parseAttributesConditional(symbol, attributes);
        parseAttributesViewBox(symbol, attributes);
        this.currentElement.addChild(symbol);
        this.currentElement = symbol;
    }

    private void marker(Attributes attributes) throws SAXException {
        debug("<marker>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Marker marker = new SVG.Marker();
        marker.document = this.svgDocument;
        marker.parent = this.currentElement;
        parseAttributesCore(marker, attributes);
        parseAttributesStyle(marker, attributes);
        parseAttributesConditional(marker, attributes);
        parseAttributesViewBox(marker, attributes);
        parseAttributesMarker(marker, attributes);
        this.currentElement.addChild(marker);
        this.currentElement = marker;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00aa, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 42) {
                if (i2 == 51) {
                    marker.refX = parseLength(strTrim);
                } else if (i2 == 52) {
                    marker.refY = parseLength(strTrim);
                } else {
                    switch (i2) {
                        case 33:
                            marker.markerHeight = parseLength(strTrim);
                            if (marker.markerHeight.isNegative()) {
                                throw new SAXException("Invalid <marker> element. markerHeight cannot be negative");
                            }
                            break;
                        case 34:
                            if ("strokeWidth".equals(strTrim)) {
                                marker.markerUnitsAreUser = false;
                                break;
                            } else if ("userSpaceOnUse".equals(strTrim)) {
                                marker.markerUnitsAreUser = true;
                                break;
                            } else {
                                throw new SAXException("Invalid value for attribute markerUnits");
                            }
                        case 35:
                            marker.markerWidth = parseLength(strTrim);
                            if (marker.markerWidth.isNegative()) {
                                throw new SAXException("Invalid <marker> element. markerWidth cannot be negative");
                            }
                            break;
                    }
                }
            } else if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(strTrim)) {
                marker.orient = Float.valueOf(Float.NaN);
            } else {
                marker.orient = Float.valueOf(parseFloat(strTrim));
            }
        }
    }

    private void linearGradient(Attributes attributes) throws SAXException {
        debug("<linearGradiant>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
        svgLinearGradient.document = this.svgDocument;
        svgLinearGradient.parent = this.currentElement;
        parseAttributesCore(svgLinearGradient, attributes);
        parseAttributesStyle(svgLinearGradient, attributes);
        parseAttributesGradient(svgLinearGradient, attributes);
        parseAttributesLinearGradient(svgLinearGradient, attributes);
        this.currentElement.addChild(svgLinearGradient);
        this.currentElement = svgLinearGradient;
    }

    private void parseAttributesGradient(SVG.GradientElement gradientElement, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 24) {
                gradientElement.gradientTransform = parseTransformList(strTrim);
            } else if (i2 != 25) {
                if (i2 != 27) {
                    if (i2 != 61) {
                        continue;
                    } else {
                        try {
                            gradientElement.spreadMethod = SVG.GradientSpread.valueOf(strTrim);
                        } catch (IllegalArgumentException unused) {
                            throw new SAXException("Invalid spreadMethod attribute. \"" + strTrim + "\" is not a valid value.");
                        }
                    }
                } else if (XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                    gradientElement.href = strTrim;
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                gradientElement.gradientUnitsAreUser = false;
            } else if ("userSpaceOnUse".equals(strTrim)) {
                gradientElement.gradientUnitsAreUser = true;
            } else {
                throw new SAXException("Invalid value for attribute gradientUnits");
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 85:
                    svgLinearGradient.x1 = parseLength(strTrim);
                    break;
                case 86:
                    svgLinearGradient.y1 = parseLength(strTrim);
                    break;
                case 87:
                    svgLinearGradient.x2 = parseLength(strTrim);
                    break;
                case 88:
                    svgLinearGradient.y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void radialGradient(Attributes attributes) throws SAXException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
        svgRadialGradient.document = this.svgDocument;
        svgRadialGradient.parent = this.currentElement;
        parseAttributesCore(svgRadialGradient, attributes);
        parseAttributesStyle(svgRadialGradient, attributes);
        parseAttributesGradient(svgRadialGradient, attributes);
        parseAttributesRadialGradient(svgRadialGradient, attributes);
        this.currentElement.addChild(svgRadialGradient);
        this.currentElement = svgRadialGradient;
    }

    private void parseAttributesRadialGradient(SVG.SvgRadialGradient svgRadialGradient, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                svgRadialGradient.cx = parseLength(strTrim);
            } else if (i2 == 8) {
                svgRadialGradient.cy = parseLength(strTrim);
            } else if (i2 == 12) {
                svgRadialGradient.fx = parseLength(strTrim);
            } else if (i2 == 13) {
                svgRadialGradient.fy = parseLength(strTrim);
            } else if (i2 != 50) {
                continue;
            } else {
                svgRadialGradient.r = parseLength(strTrim);
                if (svgRadialGradient.r.isNegative()) {
                    throw new SAXException("Invalid <radialGradient> element. r cannot be negative");
                }
            }
        }
    }

    private void stop(Attributes attributes) throws SAXException {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.GradientElement)) {
            throw new SAXException("Invalid document. <stop> elements are only valid inside <linearGradiant> or <radialGradient> elements.");
        }
        SVG.Stop stop = new SVG.Stop();
        stop.document = this.svgDocument;
        stop.parent = this.currentElement;
        parseAttributesCore(stop, attributes);
        parseAttributesStyle(stop, attributes);
        parseAttributesStop(stop, attributes);
        this.currentElement.addChild(stop);
        this.currentElement = stop;
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 40) {
                stop.offset = parseGradiantOffset(strTrim);
            }
        }
    }

    private Float parseGradiantOffset(String str) throws SAXException, NumberFormatException {
        if (str.length() == 0) {
            throw new SAXException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z = false;
        }
        try {
            float f = Float.parseFloat(str.substring(0, length));
            float f2 = 100.0f;
            if (z) {
                f /= 100.0f;
            }
            if (f < 0.0f) {
                f2 = 0.0f;
            } else if (f <= 100.0f) {
                f2 = f;
            }
            return Float.valueOf(f2);
        } catch (NumberFormatException e) {
            throw new SAXException("Invalid offset value in <stop>: " + str, e);
        }
    }

    private void solidColor(Attributes attributes) throws SAXException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.SolidColor solidColor = new SVG.SolidColor();
        solidColor.document = this.svgDocument;
        solidColor.parent = this.currentElement;
        parseAttributesCore(solidColor, attributes);
        parseAttributesStyle(solidColor, attributes);
        this.currentElement.addChild(solidColor);
        this.currentElement = solidColor;
    }

    private void clipPath(Attributes attributes) throws SAXException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.ClipPath clipPath = new SVG.ClipPath();
        clipPath.document = this.svgDocument;
        clipPath.parent = this.currentElement;
        parseAttributesCore(clipPath, attributes);
        parseAttributesStyle(clipPath, attributes);
        parseAttributesTransform(clipPath, attributes);
        parseAttributesConditional(clipPath, attributes);
        parseAttributesClipPath(clipPath, attributes);
        this.currentElement.addChild(clipPath);
        this.currentElement = clipPath;
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if ($SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 4) {
                if ("objectBoundingBox".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = false;
                } else if ("userSpaceOnUse".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = true;
                } else {
                    throw new SAXException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void textPath(Attributes attributes) throws SAXException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.TextPath textPath = new SVG.TextPath();
        textPath.document = this.svgDocument;
        textPath.parent = this.currentElement;
        parseAttributesCore(textPath, attributes);
        parseAttributesStyle(textPath, attributes);
        parseAttributesConditional(textPath, attributes);
        parseAttributesTextPath(textPath, attributes);
        this.currentElement.addChild(textPath);
        this.currentElement = textPath;
        if (textPath.parent instanceof SVG.TextRoot) {
            textPath.setTextRoot((SVG.TextRoot) textPath.parent);
        } else {
            textPath.setTextRoot(((SVG.TextChild) textPath.parent).getTextRoot());
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 27) {
                if (i2 == 62) {
                    textPath.startOffset = parseLength(strTrim);
                }
            } else if (XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                textPath.href = strTrim;
            }
        }
    }

    private void pattern(Attributes attributes) throws SAXException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Pattern pattern = new SVG.Pattern();
        pattern.document = this.svgDocument;
        pattern.parent = this.currentElement;
        parseAttributesCore(pattern, attributes);
        parseAttributesStyle(pattern, attributes);
        parseAttributesConditional(pattern, attributes);
        parseAttributesViewBox(pattern, attributes);
        parseAttributesPattern(pattern, attributes);
        this.currentElement.addChild(pattern);
        this.currentElement = pattern;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesPattern(SVG.Pattern pattern, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                pattern.height = parseLength(strTrim);
                if (pattern.height.isNegative()) {
                    throw new SAXException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i2 != 27) {
                switch (i2) {
                    case 45:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = false;
                            break;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = true;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternContentUnits");
                        }
                    case 46:
                        pattern.patternTransform = parseTransformList(strTrim);
                        break;
                    case 47:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternUnitsAreUser = false;
                            break;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternUnitsAreUser = true;
                            break;
                        } else {
                            throw new SAXException("Invalid value for attribute patternUnits");
                        }
                    default:
                        switch (i2) {
                            case 82:
                                pattern.width = parseLength(strTrim);
                                if (pattern.width.isNegative()) {
                                    throw new SAXException("Invalid <pattern> element. width cannot be negative");
                                }
                                break;
                            case 83:
                                pattern.x = parseLength(strTrim);
                                break;
                            case 84:
                                pattern.y = parseLength(strTrim);
                                break;
                        }
                }
            } else if (XLINK_NAMESPACE.equals(attributes.getURI(i))) {
                pattern.href = strTrim;
            }
        }
    }

    private void view(Attributes attributes) throws SAXException {
        debug("<view>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.View view = new SVG.View();
        view.document = this.svgDocument;
        view.parent = this.currentElement;
        parseAttributesCore(view, attributes);
        parseAttributesConditional(view, attributes);
        parseAttributesViewBox(view, attributes);
        this.currentElement.addChild(view);
        this.currentElement = view;
    }

    private void mask(Attributes attributes) throws SAXException {
        debug("<mask>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        SVG.Mask mask = new SVG.Mask();
        mask.document = this.svgDocument;
        mask.parent = this.currentElement;
        parseAttributesCore(mask, attributes);
        parseAttributesStyle(mask, attributes);
        parseAttributesConditional(mask, attributes);
        parseAttributesMask(mask, attributes);
        this.currentElement.addChild(mask);
        this.currentElement = mask;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 26) {
                mask.height = parseLength(strTrim);
                if (mask.height.isNegative()) {
                    throw new SAXException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 37) {
                if (i2 == 38) {
                    if ("objectBoundingBox".equals(strTrim)) {
                        mask.maskUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(strTrim)) {
                        mask.maskUnitsAreUser = true;
                    } else {
                        throw new SAXException("Invalid value for attribute maskUnits");
                    }
                } else {
                    switch (i2) {
                        case 82:
                            mask.width = parseLength(strTrim);
                            if (mask.width.isNegative()) {
                                throw new SAXException("Invalid <mask> element. width cannot be negative");
                            }
                            break;
                        case 83:
                            mask.x = parseLength(strTrim);
                            break;
                        case 84:
                            mask.y = parseLength(strTrim);
                            break;
                    }
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                mask.maskContentUnitsAreUser = false;
            } else if ("userSpaceOnUse".equals(strTrim)) {
                mask.maskContentUnitsAreUser = true;
            } else {
                throw new SAXException("Invalid value for attribute maskContentUnits");
            }
        }
    }

    protected static class TextScanner {
        protected String input;
        protected int position = 0;

        protected boolean isEOL(int i) {
            return i == 10 || i == 13;
        }

        protected boolean isWhitespace(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public TextScanner(String str) {
            this.input = str.trim();
        }

        public boolean empty() {
            return this.position == this.input.length();
        }

        public void skipWhitespace() {
            while (this.position < this.input.length() && isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
        }

        public boolean skipCommaWhitespace() {
            skipWhitespace();
            if (this.position == this.input.length() || this.input.charAt(this.position) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        public Float nextFloat() {
            int iScanForFloat = scanForFloat();
            int i = this.position;
            if (iScanForFloat == i) {
                return null;
            }
            Float fValueOf = Float.valueOf(Float.parseFloat(this.input.substring(i, iScanForFloat)));
            this.position = iScanForFloat;
            return fValueOf;
        }

        public Float possibleNextFloat() {
            int i = this.position;
            skipCommaWhitespace();
            Float fNextFloat = nextFloat();
            if (fNextFloat != null) {
                return fNextFloat;
            }
            this.position = i;
            return null;
        }

        public Float checkedNextFloat(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        public Integer nextInteger() {
            int iScanForInteger = scanForInteger();
            int i = this.position;
            if (iScanForInteger == i) {
                return null;
            }
            Integer numValueOf = Integer.valueOf(Integer.parseInt(this.input.substring(i, iScanForInteger)));
            this.position = iScanForInteger;
            return numValueOf;
        }

        public Integer nextChar() {
            if (this.position == this.input.length()) {
                return null;
            }
            String str = this.input;
            int i = this.position;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public SVG.Length nextLength() {
            Float fNextFloat = nextFloat();
            if (fNextFloat == null) {
                return null;
            }
            SVG.Unit unitNextUnit = nextUnit();
            if (unitNextUnit == null) {
                return new SVG.Length(fNextFloat.floatValue(), SVG.Unit.px);
            }
            return new SVG.Length(fNextFloat.floatValue(), unitNextUnit);
        }

        public Boolean nextFlag() {
            if (this.position == this.input.length()) {
                return null;
            }
            char cCharAt = this.input.charAt(this.position);
            if (cCharAt != '0' && cCharAt != '1') {
                return null;
            }
            this.position++;
            return Boolean.valueOf(cCharAt == '1');
        }

        public Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        public boolean consume(char c) {
            boolean z = this.position < this.input.length() && this.input.charAt(this.position) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean consume(String str) {
            boolean z;
            int length = str.length();
            if (this.position <= this.input.length() - length) {
                String str2 = this.input;
                int i = this.position;
                z = str2.substring(i, i + length).equals(str);
            }
            if (z) {
                this.position += length;
            }
            return z;
        }

        protected int advanceChar() {
            if (this.position == this.input.length()) {
                return -1;
            }
            int i = this.position + 1;
            this.position = i;
            if (i < this.input.length()) {
                return this.input.charAt(this.position);
            }
            return -1;
        }

        public String nextToken() {
            return nextToken(' ');
        }

        public String nextToken(char c) {
            if (empty()) {
                return null;
            }
            char cCharAt = this.input.charAt(this.position);
            if (isWhitespace(cCharAt) || cCharAt == c) {
                return null;
            }
            int i = this.position;
            int iAdvanceChar = advanceChar();
            while (iAdvanceChar != -1 && iAdvanceChar != c && !isWhitespace(iAdvanceChar)) {
                iAdvanceChar = advanceChar();
            }
            return this.input.substring(i, this.position);
        }

        public String nextFunction() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int iCharAt = this.input.charAt(i);
            while (true) {
                if ((iCharAt < 97 || iCharAt > 122) && (iCharAt < 65 || iCharAt > 90)) {
                    break;
                }
                iCharAt = advanceChar();
            }
            int i2 = this.position;
            while (isWhitespace(iCharAt)) {
                iCharAt = advanceChar();
            }
            if (iCharAt == 40) {
                this.position++;
                return this.input.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        private int scanForFloat() {
            int i;
            if (empty()) {
                return this.position;
            }
            int i2 = this.position;
            int iCharAt = this.input.charAt(i2);
            if (iCharAt == 45 || iCharAt == 43) {
                iCharAt = advanceChar();
            }
            if (Character.isDigit(iCharAt)) {
                i = this.position + 1;
                iCharAt = advanceChar();
                while (Character.isDigit(iCharAt)) {
                    i = this.position + 1;
                    iCharAt = advanceChar();
                }
            } else {
                i = i2;
            }
            if (iCharAt == 46) {
                i = this.position + 1;
                iCharAt = advanceChar();
                while (Character.isDigit(iCharAt)) {
                    i = this.position + 1;
                    iCharAt = advanceChar();
                }
            }
            if (iCharAt == 101 || iCharAt == 69) {
                int iAdvanceChar = advanceChar();
                if (iAdvanceChar == 45 || iAdvanceChar == 43) {
                    iAdvanceChar = advanceChar();
                }
                if (Character.isDigit(iAdvanceChar)) {
                    int i3 = this.position + 1;
                    int iAdvanceChar2 = advanceChar();
                    i = i3;
                    while (Character.isDigit(iAdvanceChar2)) {
                        i = this.position + 1;
                        iAdvanceChar2 = advanceChar();
                    }
                }
            }
            this.position = i2;
            return i;
        }

        private int scanForInteger() {
            int i;
            if (empty()) {
                return this.position;
            }
            int i2 = this.position;
            int iCharAt = this.input.charAt(i2);
            if (iCharAt == 45 || iCharAt == 43) {
                iCharAt = advanceChar();
            }
            if (Character.isDigit(iCharAt)) {
                i = this.position + 1;
                int iAdvanceChar = advanceChar();
                while (Character.isDigit(iAdvanceChar)) {
                    i = this.position + 1;
                    iAdvanceChar = advanceChar();
                }
            } else {
                i = i2;
            }
            this.position = i2;
            return i;
        }

        public String ahead() {
            int i = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String strSubstring = this.input.substring(i, this.position);
            this.position = i;
            return strSubstring;
        }

        public SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            if (this.position > this.input.length() - 2) {
                return null;
            }
            try {
                String str = this.input;
                int i = this.position;
                SVG.Unit unitValueOf = SVG.Unit.valueOf(str.substring(i, i + 2).toLowerCase(Locale.US));
                this.position += 2;
                return unitValueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public boolean hasLetter() {
            if (this.position == this.input.length()) {
                return false;
            }
            char cCharAt = this.input.charAt(this.position);
            if (cCharAt < 'a' || cCharAt > 'z') {
                return cCharAt >= 'A' && cCharAt <= 'Z';
            }
            return true;
        }

        public String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            char cCharAt = this.input.charAt(i);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            int iAdvanceChar = advanceChar();
            while (iAdvanceChar != -1 && iAdvanceChar != cCharAt) {
                iAdvanceChar = advanceChar();
            }
            if (iAdvanceChar == -1) {
                this.position = i;
                return null;
            }
            int i2 = this.position;
            this.position = i2 + 1;
            return this.input.substring(i + 1, i2);
        }

        public String restOfText() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            this.position = this.input.length();
            return this.input.substring(i);
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.id = attributes.getValue(i).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String strTrim = attributes.getValue(i).trim();
                if ("default".equals(strTrim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(strTrim)) {
                        svgElementBase.spacePreserve = Boolean.TRUE;
                        return;
                    }
                    throw new SAXException("Invalid value for \"xml:space\" attribute: " + strTrim);
                }
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (strTrim.length() != 0) {
                int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 1) {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(strTrim);
                } else if (i2 == 73) {
                    parseStyle(svgElementBase, strTrim);
                } else {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim());
                }
            }
        }
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String strNextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (!textScanner.consume(':')) {
                return;
            }
            textScanner.skipWhitespace();
            String strNextToken2 = textScanner.nextToken(';');
            if (strNextToken2 == null) {
                return;
            }
            textScanner.skipWhitespace();
            if (textScanner.empty() || textScanner.consume(';')) {
                if (svgElementBase.style == null) {
                    svgElementBase.style = new SVG.Style();
                }
                processStyleProperty(svgElementBase.style, strNextToken, strNextToken2);
                textScanner.skipWhitespace();
            }
        }
    }

    protected static void processStyleProperty(SVG.Style style, String str, String str2) throws SAXException {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        int i = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(str).ordinal()];
        if (i == 2) {
            style.clip = parseClip(str2);
            style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            return;
        }
        if (i == 3) {
            style.clipPath = parseFunctionalIRI(str2, str);
            style.specifiedFlags |= 268435456;
            return;
        }
        if (i == 5) {
            style.clipRule = parseFillRule(str2);
            style.specifiedFlags |= 536870912;
            return;
        }
        if (i == 6) {
            style.color = parseColour(str2);
            style.specifiedFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            return;
        }
        if (i == 9) {
            style.direction = parseTextDirection(str2);
            style.specifiedFlags |= 68719476736L;
            return;
        }
        if (i == 36) {
            style.mask = parseFunctionalIRI(str2, str);
            style.specifiedFlags |= 1073741824;
            return;
        }
        if (i == 41) {
            style.opacity = Float.valueOf(parseOpacity(str2));
            style.specifiedFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            return;
        }
        if (i == 43) {
            style.overflow = parseOverflow(str2);
            style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            return;
        }
        if (i == 79) {
            style.vectorEffect = parseVectorEffect(str2);
            style.specifiedFlags |= 34359738368L;
            return;
        }
        if (i == 59) {
            if (str2.equals(CURRENTCOLOR)) {
                style.solidColor = SVG.CurrentColor.getInstance();
            } else {
                style.solidColor = parseColour(str2);
            }
            style.specifiedFlags |= 2147483648L;
            return;
        }
        if (i == 60) {
            style.solidOpacity = Float.valueOf(parseOpacity(str2));
            style.specifiedFlags |= 4294967296L;
            return;
        }
        if (i == 75) {
            style.textAnchor = parseTextAnchor(str2);
            style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            return;
        }
        if (i == 76) {
            style.textDecoration = parseTextDecoration(str2);
            style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            return;
        }
        switch (i) {
            case 15:
                if (str2.indexOf(124) < 0) {
                    if (VALID_DISPLAY_VALUES.indexOf(String.valueOf('|') + str2 + '|') != -1) {
                        style.display = Boolean.valueOf(!str2.equals("none"));
                        style.specifiedFlags |= 16777216;
                        return;
                    }
                }
                throw new SAXException("Invalid value for \"display\" attribute: " + str2);
            case 16:
                style.fill = parsePaintSpecifier(str2, "fill");
                style.specifiedFlags |= 1;
                return;
            case 17:
                style.fillRule = parseFillRule(str2);
                style.specifiedFlags |= 2;
                return;
            case 18:
                style.fillOpacity = Float.valueOf(parseOpacity(str2));
                style.specifiedFlags |= 4;
                return;
            case 19:
                parseFont(style, str2);
                return;
            case 20:
                style.fontFamily = parseFontFamily(str2);
                style.specifiedFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return;
            case 21:
                style.fontSize = parseFontSize(str2);
                style.specifiedFlags |= 16384;
                return;
            case 22:
                style.fontWeight = parseFontWeight(str2);
                style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                return;
            case 23:
                style.fontStyle = parseFontStyle(str2);
                style.specifiedFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                return;
            default:
                switch (i) {
                    case 29:
                        style.markerStart = parseFunctionalIRI(str2, str);
                        style.markerMid = style.markerStart;
                        style.markerEnd = style.markerStart;
                        style.specifiedFlags |= 14680064;
                        return;
                    case 30:
                        style.markerStart = parseFunctionalIRI(str2, str);
                        style.specifiedFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        return;
                    case 31:
                        style.markerMid = parseFunctionalIRI(str2, str);
                        style.specifiedFlags |= 4194304;
                        return;
                    case 32:
                        style.markerEnd = parseFunctionalIRI(str2, str);
                        style.specifiedFlags |= 8388608;
                        return;
                    default:
                        switch (i) {
                            case 63:
                                if (str2.equals(CURRENTCOLOR)) {
                                    style.stopColor = SVG.CurrentColor.getInstance();
                                } else {
                                    style.stopColor = parseColour(str2);
                                }
                                style.specifiedFlags |= 67108864;
                                return;
                            case 64:
                                style.stopOpacity = Float.valueOf(parseOpacity(str2));
                                style.specifiedFlags |= 134217728;
                                return;
                            case 65:
                                style.stroke = parsePaintSpecifier(str2, "stroke");
                                style.specifiedFlags |= 8;
                                return;
                            case 66:
                                if ("none".equals(str2)) {
                                    style.strokeDashArray = null;
                                } else {
                                    style.strokeDashArray = parseStrokeDashArray(str2);
                                }
                                style.specifiedFlags |= 512;
                                return;
                            case 67:
                                style.strokeDashOffset = parseLength(str2);
                                style.specifiedFlags |= 1024;
                                return;
                            case 68:
                                style.strokeLineCap = parseStrokeLineCap(str2);
                                style.specifiedFlags |= 64;
                                return;
                            case 69:
                                style.strokeLineJoin = parseStrokeLineJoin(str2);
                                style.specifiedFlags |= 128;
                                return;
                            case 70:
                                style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                                style.specifiedFlags |= 256;
                                return;
                            case 71:
                                style.strokeOpacity = Float.valueOf(parseOpacity(str2));
                                style.specifiedFlags |= 16;
                                return;
                            case 72:
                                style.strokeWidth = parseLength(str2);
                                style.specifiedFlags |= 32;
                                return;
                            default:
                                switch (i) {
                                    case 89:
                                        if (str2.equals(CURRENTCOLOR)) {
                                            style.viewportFill = SVG.CurrentColor.getInstance();
                                        } else {
                                            style.viewportFill = parseColour(str2);
                                        }
                                        style.specifiedFlags |= 8589934592L;
                                        return;
                                    case 90:
                                        style.viewportFillOpacity = Float.valueOf(parseOpacity(str2));
                                        style.specifiedFlags |= 17179869184L;
                                        return;
                                    case 91:
                                        if (str2.indexOf(124) < 0) {
                                            if (VALID_VISIBILITY_VALUES.indexOf(String.valueOf('|') + str2 + '|') != -1) {
                                                style.visibility = Boolean.valueOf(str2.equals("visible"));
                                                style.specifiedFlags |= 33554432;
                                                return;
                                            }
                                        }
                                        throw new SAXException("Invalid value for \"visibility\" attribute: " + str2);
                                    default:
                                        return;
                                }
                        }
                }
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 49) {
                parsePreserveAspectRatio(svgViewBoxContainer, strTrim);
            } else if (i2 == 81) {
                svgViewBoxContainer.viewBox = parseViewBox(strTrim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    private Matrix parseTransformList(String str) throws SAXException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String strNextFunction = textScanner.nextFunction();
            if (strNextFunction == null) {
                throw new SAXException("Bad transform function encountered in transform list: " + str);
            }
            if (strNextFunction.equals("matrix")) {
                textScanner.skipWhitespace();
                Float fNextFloat = textScanner.nextFloat();
                textScanner.skipCommaWhitespace();
                Float fNextFloat2 = textScanner.nextFloat();
                textScanner.skipCommaWhitespace();
                Float fNextFloat3 = textScanner.nextFloat();
                textScanner.skipCommaWhitespace();
                Float fNextFloat4 = textScanner.nextFloat();
                textScanner.skipCommaWhitespace();
                Float fNextFloat5 = textScanner.nextFloat();
                textScanner.skipCommaWhitespace();
                Float fNextFloat6 = textScanner.nextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat6 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{fNextFloat.floatValue(), fNextFloat3.floatValue(), fNextFloat5.floatValue(), fNextFloat2.floatValue(), fNextFloat4.floatValue(), fNextFloat6.floatValue(), 0.0f, 0.0f, 1.0f});
                matrix.preConcat(matrix2);
            } else if (strNextFunction.equals("translate")) {
                textScanner.skipWhitespace();
                Float fNextFloat7 = textScanner.nextFloat();
                Float fPossibleNextFloat = textScanner.possibleNextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat7 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (fPossibleNextFloat == null) {
                    matrix.preTranslate(fNextFloat7.floatValue(), 0.0f);
                } else {
                    matrix.preTranslate(fNextFloat7.floatValue(), fPossibleNextFloat.floatValue());
                }
            } else if (strNextFunction.equals("scale")) {
                textScanner.skipWhitespace();
                Float fNextFloat8 = textScanner.nextFloat();
                Float fPossibleNextFloat2 = textScanner.possibleNextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat8 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (fPossibleNextFloat2 == null) {
                    matrix.preScale(fNextFloat8.floatValue(), fNextFloat8.floatValue());
                } else {
                    matrix.preScale(fNextFloat8.floatValue(), fPossibleNextFloat2.floatValue());
                }
            } else if (strNextFunction.equals("rotate")) {
                textScanner.skipWhitespace();
                Float fNextFloat9 = textScanner.nextFloat();
                Float fPossibleNextFloat3 = textScanner.possibleNextFloat();
                Float fPossibleNextFloat4 = textScanner.possibleNextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat9 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                if (fPossibleNextFloat3 == null) {
                    matrix.preRotate(fNextFloat9.floatValue());
                } else if (fPossibleNextFloat4 != null) {
                    matrix.preRotate(fNextFloat9.floatValue(), fPossibleNextFloat3.floatValue(), fPossibleNextFloat4.floatValue());
                } else {
                    throw new SAXException("Invalid transform list: " + str);
                }
            } else if (strNextFunction.equals("skewX")) {
                textScanner.skipWhitespace();
                Float fNextFloat10 = textScanner.nextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat10 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew((float) Math.tan(Math.toRadians(fNextFloat10.floatValue())), 0.0f);
            } else if (strNextFunction.equals("skewY")) {
                textScanner.skipWhitespace();
                Float fNextFloat11 = textScanner.nextFloat();
                textScanner.skipWhitespace();
                if (fNextFloat11 == null || !textScanner.consume(')')) {
                    throw new SAXException("Invalid transform list: " + str);
                }
                matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(fNextFloat11.floatValue())));
            } else if (strNextFunction != null) {
                throw new SAXException("Invalid transform list fn: " + strNextFunction + ")");
            }
            if (textScanner.empty()) {
                break;
            }
            textScanner.skipCommaWhitespace();
        }
        return matrix;
    }

    protected static SVG.Length parseLength(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVG.Unit unitValueOf = SVG.Unit.px;
        char cCharAt = str.charAt(length - 1);
        if (cCharAt == '%') {
            length--;
            unitValueOf = SVG.Unit.percent;
        } else if (length > 2 && Character.isLetter(cCharAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unitValueOf = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVG.Length(Float.parseFloat(str.substring(0, length)), unitValueOf);
        } catch (NumberFormatException e) {
            throw new SAXException("Invalid length value: " + str, e);
        }
    }

    private static List<SVG.Length> parseLengthList(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            Float fNextFloat = textScanner.nextFloat();
            if (fNextFloat == null) {
                throw new SAXException("Invalid length list value: " + textScanner.ahead());
            }
            SVG.Unit unitNextUnit = textScanner.nextUnit();
            if (unitNextUnit == null) {
                unitNextUnit = SVG.Unit.px;
            }
            arrayList.add(new SVG.Length(fNextFloat.floatValue(), unitNextUnit));
            textScanner.skipCommaWhitespace();
        }
        return arrayList;
    }

    private static float parseFloat(String str) throws SAXException {
        if (str.length() == 0) {
            throw new SAXException("Invalid float value (empty string)");
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            throw new SAXException("Invalid float value: " + str, e);
        }
    }

    private static float parseOpacity(String str) throws SAXException {
        float f = parseFloat(str);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static SVG.Box parseViewBox(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        Float fNextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float fNextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float fNextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        Float fNextFloat4 = textScanner.nextFloat();
        if (fNextFloat == null || fNextFloat2 == null || fNextFloat3 == null || fNextFloat4 == null) {
            throw new SAXException("Invalid viewBox definition - should have four numbers");
        }
        if (fNextFloat3.floatValue() < 0.0f) {
            throw new SAXException("Invalid viewBox. width cannot be negative");
        }
        if (fNextFloat4.floatValue() < 0.0f) {
            throw new SAXException("Invalid viewBox. height cannot be negative");
        }
        return new SVG.Box(fNextFloat.floatValue(), fNextFloat2.floatValue(), fNextFloat3.floatValue(), fNextFloat4.floatValue());
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SAXException {
        PreserveAspectRatio.Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String strNextToken = textScanner.nextToken();
        if ("defer".equals(strNextToken)) {
            textScanner.skipWhitespace();
            strNextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = aspectRatioKeywords.get(strNextToken);
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            scale = null;
        } else {
            String strNextToken2 = textScanner.nextToken();
            if (strNextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.Meet;
            } else if (strNextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.Slice;
            } else {
                throw new SAXException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        svgPreserveAspectRatioContainer.preserveAspectRatio = new PreserveAspectRatio(alignment, scale);
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str, String str2) throws SAXException {
        if (str.startsWith("url(")) {
            int iIndexOf = str.indexOf(")");
            if (iIndexOf == -1) {
                throw new SAXException("Bad " + str2 + " attribute. Unterminated url() reference");
            }
            String strTrim = str.substring(4, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            return new SVG.PaintReference(strTrim, strTrim2.length() > 0 ? parseColourSpecifer(strTrim2) : null);
        }
        return parseColourSpecifer(str);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (str.equals(CURRENTCOLOR)) {
            return SVG.CurrentColor.getInstance();
        }
        return parseColour(str);
    }

    private static SVG.Colour parseColour(String str) throws SAXException, NumberFormatException {
        if (str.charAt(0) == '#') {
            try {
                if (str.length() == 7) {
                    return new SVG.Colour(Integer.parseInt(str.substring(1), 16));
                }
                if (str.length() == 4) {
                    int i = Integer.parseInt(str.substring(1), 16);
                    int i2 = i & 3840;
                    int i3 = i & 240;
                    int i4 = i & 15;
                    return new SVG.Colour(i4 | (i2 << 12) | (i2 << 16) | (i3 << 8) | (i3 << 4) | (i4 << 4));
                }
                throw new SAXException("Bad hex colour value: " + str);
            } catch (NumberFormatException unused) {
                throw new SAXException("Bad colour value: " + str);
            }
        }
        if (str.toLowerCase(Locale.US).startsWith("rgb(")) {
            TextScanner textScanner = new TextScanner(str.substring(4));
            textScanner.skipWhitespace();
            int colourComponent = parseColourComponent(textScanner);
            textScanner.skipCommaWhitespace();
            int colourComponent2 = parseColourComponent(textScanner);
            textScanner.skipCommaWhitespace();
            int colourComponent3 = parseColourComponent(textScanner);
            textScanner.skipWhitespace();
            if (!textScanner.consume(')')) {
                throw new SAXException("Bad rgb() colour value: " + str);
            }
            return new SVG.Colour((colourComponent << 16) | (colourComponent2 << 8) | colourComponent3);
        }
        return parseColourKeyword(str);
    }

    private static int parseColourComponent(TextScanner textScanner) throws SAXException {
        float fFloatValue = textScanner.nextFloat().floatValue();
        if (textScanner.consume('%')) {
            fFloatValue = (fFloatValue * 256.0f) / 100.0f;
        }
        if (fFloatValue < 0.0f) {
            return 0;
        }
        if (fFloatValue > 255.0f) {
            return 255;
        }
        return (int) fFloatValue;
    }

    private static SVG.Colour parseColourKeyword(String str) throws SAXException {
        Integer num = colourKeywords.get(str.toLowerCase(Locale.US));
        if (num == null) {
            throw new SAXException("Invalid colour keyword: " + str);
        }
        return new SVG.Colour(num.intValue());
    }

    private static void parseFont(SVG.Style style, String str) throws SAXException {
        String strNextToken;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".indexOf(String.valueOf('|') + str + '|') != -1) {
            return;
        }
        TextScanner textScanner = new TextScanner(str);
        Integer num = null;
        SVG.Style.FontStyle fontStyle = null;
        String str2 = null;
        while (true) {
            strNextToken = textScanner.nextToken(JsonPointer.SEPARATOR);
            textScanner.skipWhitespace();
            if (strNextToken == null) {
                throw new SAXException("Invalid font style attribute: missing font size and family");
            }
            if (num != null && fontStyle != null) {
                break;
            }
            if (!strNextToken.equals("normal") && (num != null || (num = fontWeightKeywords.get(strNextToken)) == null)) {
                if (fontStyle != null || (fontStyle = fontStyleKeywords.get(strNextToken)) == null) {
                    if (str2 != null || !strNextToken.equals("small-caps")) {
                        break;
                    } else {
                        str2 = strNextToken;
                    }
                }
            }
        }
        SVG.Length fontSize = parseFontSize(strNextToken);
        if (textScanner.consume(JsonPointer.SEPARATOR)) {
            textScanner.skipWhitespace();
            String strNextToken2 = textScanner.nextToken();
            if (strNextToken2 == null) {
                throw new SAXException("Invalid font style attribute: missing line-height");
            }
            parseLength(strNextToken2);
            textScanner.skipWhitespace();
        }
        style.fontFamily = parseFontFamily(textScanner.restOfText());
        style.fontSize = fontSize;
        style.fontWeight = Integer.valueOf(num == null ? 400 : num.intValue());
        if (fontStyle == null) {
            fontStyle = SVG.Style.FontStyle.Normal;
        }
        style.fontStyle = fontStyle;
        style.specifiedFlags |= 122880;
    }

    private static List<String> parseFontFamily(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String strNextQuotedString = textScanner.nextQuotedString();
            if (strNextQuotedString == null) {
                strNextQuotedString = textScanner.nextToken(',');
            }
            if (strNextQuotedString == null) {
                return arrayList;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) throws SAXException {
        SVG.Length length = fontSizeKeywords.get(str);
        return length == null ? parseLength(str) : length;
    }

    private static Integer parseFontWeight(String str) throws SAXException {
        Integer num = fontWeightKeywords.get(str);
        if (num != null) {
            return num;
        }
        throw new SAXException("Invalid font-weight property: " + str);
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) throws SAXException {
        SVG.Style.FontStyle fontStyle = fontStyleKeywords.get(str);
        if (fontStyle != null) {
            return fontStyle;
        }
        throw new SAXException("Invalid font-style property: " + str);
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.TextDecoration.None;
        }
        if ("underline".equals(str)) {
            return SVG.Style.TextDecoration.Underline;
        }
        if ("overline".equals(str)) {
            return SVG.Style.TextDecoration.Overline;
        }
        if ("line-through".equals(str)) {
            return SVG.Style.TextDecoration.LineThrough;
        }
        if ("blink".equals(str)) {
            return SVG.Style.TextDecoration.Blink;
        }
        throw new SAXException("Invalid text-decoration property: " + str);
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) throws SAXException {
        if ("ltr".equals(str)) {
            return SVG.Style.TextDirection.LTR;
        }
        if ("rtl".equals(str)) {
            return SVG.Style.TextDirection.RTL;
        }
        throw new SAXException("Invalid direction property: " + str);
    }

    private static SVG.Style.FillRule parseFillRule(String str) throws SAXException {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        throw new SAXException("Invalid fill-rule property: " + str);
    }

    private static SVG.Style.LineCaps parseStrokeLineCap(String str) throws SAXException {
        if ("butt".equals(str)) {
            return SVG.Style.LineCaps.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCaps.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCaps.Square;
        }
        throw new SAXException("Invalid stroke-linecap property: " + str);
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) throws SAXException {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        throw new SAXException("Invalid stroke-linejoin property: " + str);
    }

    private static SVG.Length[] parseStrokeDashArray(String str) throws SAXException {
        SVG.Length lengthNextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (lengthNextLength = textScanner.nextLength()) == null) {
            return null;
        }
        if (lengthNextLength.isNegative()) {
            throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
        }
        float fFloatValue = lengthNextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lengthNextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVG.Length lengthNextLength2 = textScanner.nextLength();
            if (lengthNextLength2 == null) {
                throw new SAXException("Invalid stroke-dasharray. Non-Length content found: " + str);
            }
            if (lengthNextLength2.isNegative()) {
                throw new SAXException("Invalid stroke-dasharray. Dash segemnts cannot be negative: " + str);
            }
            arrayList.add(lengthNextLength2);
            fFloatValue += lengthNextLength2.floatValue();
        }
        if (fFloatValue == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) throws SAXException {
        if ("start".equals(str)) {
            return SVG.Style.TextAnchor.Start;
        }
        if ("middle".equals(str)) {
            return SVG.Style.TextAnchor.Middle;
        }
        if ("end".equals(str)) {
            return SVG.Style.TextAnchor.End;
        }
        throw new SAXException("Invalid text-anchor property: " + str);
    }

    private static Boolean parseOverflow(String str) throws SAXException {
        if ("visible".equals(str) || DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str)) {
            return Boolean.TRUE;
        }
        if ("hidden".equals(str) || "scroll".equals(str)) {
            return Boolean.FALSE;
        }
        throw new SAXException("Invalid toverflow property: " + str);
    }

    private static SVG.CSSClipRect parseClip(String str) throws SAXException {
        if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str)) {
            return null;
        }
        if (!str.toLowerCase(Locale.US).startsWith("rect(")) {
            throw new SAXException("Invalid clip attribute shape. Only rect() is supported.");
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.skipWhitespace();
        SVG.Length lengthOrAuto = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto2 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto3 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto4 = parseLengthOrAuto(textScanner);
        textScanner.skipWhitespace();
        if (!textScanner.consume(')')) {
            throw new SAXException("Bad rect() clip definition: " + str);
        }
        return new SVG.CSSClipRect(lengthOrAuto, lengthOrAuto2, lengthOrAuto3, lengthOrAuto4);
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            return new SVG.Length(0.0f);
        }
        return textScanner.nextLength();
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) throws SAXException {
        if ("none".equals(str)) {
            return SVG.Style.VectorEffect.None;
        }
        if ("non-scaling-stroke".equals(str)) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        throw new SAXException("Invalid vector-effect property: " + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x03ed, code lost:
    
        android.util.Log.e(com.caverock.androidsvg.SVGParser.TAG, "Bad path coords for " + ((char) r11) + " path segment");
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0400 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SVG.PathDefinition parsePath(String str) throws SAXException {
        int iIntValue;
        TextScanner textScanner = new TextScanner(str);
        SVG.PathDefinition pathDefinition = new SVG.PathDefinition();
        if (!textScanner.empty() && ((iIntValue = textScanner.nextChar().intValue()) == 77 || iIntValue == 109)) {
            int iIntValue2 = iIntValue;
            float fFloatValue = 0.0f;
            float fFloatValue2 = 0.0f;
            float fFloatValue3 = 0.0f;
            float fFloatValue4 = 0.0f;
            float f = 0.0f;
            float f2 = 0.0f;
            while (true) {
                textScanner.skipWhitespace();
                switch (iIntValue2) {
                    case 65:
                    case 97:
                        Float fNextFloat = textScanner.nextFloat();
                        Float fCheckedNextFloat = textScanner.checkedNextFloat(fNextFloat);
                        Float fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
                        Boolean boolCheckedNextFlag = textScanner.checkedNextFlag(fCheckedNextFloat2);
                        Boolean boolCheckedNextFlag2 = textScanner.checkedNextFlag(boolCheckedNextFlag);
                        Float fCheckedNextFloat3 = textScanner.checkedNextFloat(boolCheckedNextFlag2);
                        Float fCheckedNextFloat4 = textScanner.checkedNextFloat(fCheckedNextFloat3);
                        if (fCheckedNextFloat4 == null || fNextFloat.floatValue() < 0.0f || fCheckedNextFloat.floatValue() < 0.0f) {
                            break;
                        } else {
                            if (iIntValue2 == 97) {
                                fCheckedNextFloat3 = Float.valueOf(fCheckedNextFloat3.floatValue() + fFloatValue);
                                fCheckedNextFloat4 = Float.valueOf(fCheckedNextFloat4.floatValue() + fFloatValue3);
                            }
                            pathDefinition.arcTo(fNextFloat.floatValue(), fCheckedNextFloat.floatValue(), fCheckedNextFloat2.floatValue(), boolCheckedNextFlag.booleanValue(), boolCheckedNextFlag2.booleanValue(), fCheckedNextFloat3.floatValue(), fCheckedNextFloat4.floatValue());
                            fFloatValue = fCheckedNextFloat3.floatValue();
                            fFloatValue3 = fCheckedNextFloat4.floatValue();
                            fFloatValue2 = fFloatValue;
                            fFloatValue4 = fFloatValue3;
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                                break;
                            } else if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                        }
                        break;
                    case 67:
                    case 99:
                        Float fNextFloat2 = textScanner.nextFloat();
                        Float fCheckedNextFloat5 = textScanner.checkedNextFloat(fNextFloat2);
                        Float fCheckedNextFloat6 = textScanner.checkedNextFloat(fCheckedNextFloat5);
                        Float fCheckedNextFloat7 = textScanner.checkedNextFloat(fCheckedNextFloat6);
                        Float fCheckedNextFloat8 = textScanner.checkedNextFloat(fCheckedNextFloat7);
                        Float fCheckedNextFloat9 = textScanner.checkedNextFloat(fCheckedNextFloat8);
                        if (fCheckedNextFloat9 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 99) {
                                fCheckedNextFloat8 = Float.valueOf(fCheckedNextFloat8.floatValue() + fFloatValue);
                                fCheckedNextFloat9 = Float.valueOf(fCheckedNextFloat9.floatValue() + fFloatValue3);
                                fNextFloat2 = Float.valueOf(fNextFloat2.floatValue() + fFloatValue);
                                fCheckedNextFloat5 = Float.valueOf(fCheckedNextFloat5.floatValue() + fFloatValue3);
                                fCheckedNextFloat6 = Float.valueOf(fCheckedNextFloat6.floatValue() + fFloatValue);
                                fCheckedNextFloat7 = Float.valueOf(fCheckedNextFloat7.floatValue() + fFloatValue3);
                            }
                            Float f3 = fCheckedNextFloat6;
                            Float f4 = fCheckedNextFloat8;
                            Float f5 = fCheckedNextFloat7;
                            pathDefinition.cubicTo(fNextFloat2.floatValue(), fCheckedNextFloat5.floatValue(), f3.floatValue(), f5.floatValue(), f4.floatValue(), fCheckedNextFloat9.floatValue());
                            fFloatValue2 = f3.floatValue();
                            fFloatValue4 = f5.floatValue();
                            fFloatValue = f4.floatValue();
                            fFloatValue3 = fCheckedNextFloat9.floatValue();
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 72:
                    case 104:
                        Float fNextFloat3 = textScanner.nextFloat();
                        if (fNextFloat3 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 104) {
                                fNextFloat3 = Float.valueOf(fNextFloat3.floatValue() + fFloatValue);
                            }
                            pathDefinition.lineTo(fNextFloat3.floatValue(), fFloatValue3);
                            fFloatValue = fNextFloat3.floatValue();
                            fFloatValue2 = fFloatValue;
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 76:
                    case 108:
                        Float fNextFloat4 = textScanner.nextFloat();
                        Float fCheckedNextFloat10 = textScanner.checkedNextFloat(fNextFloat4);
                        if (fCheckedNextFloat10 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 108) {
                                fNextFloat4 = Float.valueOf(fNextFloat4.floatValue() + fFloatValue);
                                fCheckedNextFloat10 = Float.valueOf(fCheckedNextFloat10.floatValue() + fFloatValue3);
                            }
                            pathDefinition.lineTo(fNextFloat4.floatValue(), fCheckedNextFloat10.floatValue());
                            fFloatValue = fNextFloat4.floatValue();
                            fFloatValue3 = fCheckedNextFloat10.floatValue();
                            fFloatValue2 = fFloatValue;
                            fFloatValue4 = fFloatValue3;
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 77:
                    case 109:
                        Float fNextFloat5 = textScanner.nextFloat();
                        Float fCheckedNextFloat11 = textScanner.checkedNextFloat(fNextFloat5);
                        if (fCheckedNextFloat11 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 109 && !pathDefinition.isEmpty()) {
                                fNextFloat5 = Float.valueOf(fNextFloat5.floatValue() + fFloatValue);
                                fCheckedNextFloat11 = Float.valueOf(fCheckedNextFloat11.floatValue() + fFloatValue3);
                            }
                            pathDefinition.moveTo(fNextFloat5.floatValue(), fCheckedNextFloat11.floatValue());
                            fFloatValue = fNextFloat5.floatValue();
                            fFloatValue3 = fCheckedNextFloat11.floatValue();
                            fFloatValue2 = fFloatValue;
                            f = fFloatValue2;
                            fFloatValue4 = fFloatValue3;
                            f2 = fFloatValue4;
                            iIntValue2 = iIntValue2 != 109 ? 76 : 108;
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 81:
                    case 113:
                        Float fNextFloat6 = textScanner.nextFloat();
                        Float fCheckedNextFloat12 = textScanner.checkedNextFloat(fNextFloat6);
                        Float fCheckedNextFloat13 = textScanner.checkedNextFloat(fCheckedNextFloat12);
                        Float fCheckedNextFloat14 = textScanner.checkedNextFloat(fCheckedNextFloat13);
                        if (fCheckedNextFloat14 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 113) {
                                fCheckedNextFloat13 = Float.valueOf(fCheckedNextFloat13.floatValue() + fFloatValue);
                                fCheckedNextFloat14 = Float.valueOf(fCheckedNextFloat14.floatValue() + fFloatValue3);
                                fNextFloat6 = Float.valueOf(fNextFloat6.floatValue() + fFloatValue);
                                fCheckedNextFloat12 = Float.valueOf(fCheckedNextFloat12.floatValue() + fFloatValue3);
                            }
                            pathDefinition.quadTo(fNextFloat6.floatValue(), fCheckedNextFloat12.floatValue(), fCheckedNextFloat13.floatValue(), fCheckedNextFloat14.floatValue());
                            fFloatValue2 = fNextFloat6.floatValue();
                            fFloatValue4 = fCheckedNextFloat12.floatValue();
                            fFloatValue = fCheckedNextFloat13.floatValue();
                            fFloatValue3 = fCheckedNextFloat14.floatValue();
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 83:
                    case 115:
                        float f6 = (fFloatValue * 2.0f) - fFloatValue2;
                        Float fValueOf = Float.valueOf(f6);
                        float f7 = (2.0f * fFloatValue3) - fFloatValue4;
                        Float fValueOf2 = Float.valueOf(f7);
                        Float fNextFloat7 = textScanner.nextFloat();
                        Float fCheckedNextFloat15 = textScanner.checkedNextFloat(fNextFloat7);
                        SVG.PathDefinition pathDefinition2 = pathDefinition;
                        Float fCheckedNextFloat16 = textScanner.checkedNextFloat(fCheckedNextFloat15);
                        Float fCheckedNextFloat17 = textScanner.checkedNextFloat(fCheckedNextFloat16);
                        if (fCheckedNextFloat17 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 115) {
                                fCheckedNextFloat16 = Float.valueOf(fCheckedNextFloat16.floatValue() + fFloatValue);
                                fCheckedNextFloat17 = Float.valueOf(fCheckedNextFloat17.floatValue() + fFloatValue3);
                                fNextFloat7 = Float.valueOf(fNextFloat7.floatValue() + fFloatValue);
                                fCheckedNextFloat15 = Float.valueOf(fCheckedNextFloat15.floatValue() + fFloatValue3);
                            }
                            Float f8 = fCheckedNextFloat16;
                            fValueOf.getClass();
                            fValueOf2.getClass();
                            pathDefinition = pathDefinition2;
                            pathDefinition.cubicTo(f6, f7, fNextFloat7.floatValue(), fCheckedNextFloat15.floatValue(), f8.floatValue(), fCheckedNextFloat17.floatValue());
                            fFloatValue2 = fNextFloat7.floatValue();
                            fFloatValue4 = fCheckedNextFloat15.floatValue();
                            fFloatValue = f8.floatValue();
                            fFloatValue3 = fCheckedNextFloat17.floatValue();
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 84:
                    case 116:
                        fFloatValue2 = (fFloatValue * 2.0f) - fFloatValue2;
                        Float fValueOf3 = Float.valueOf(fFloatValue2);
                        fFloatValue4 = (2.0f * fFloatValue3) - fFloatValue4;
                        Float fValueOf4 = Float.valueOf(fFloatValue4);
                        Float fNextFloat8 = textScanner.nextFloat();
                        Float fCheckedNextFloat18 = textScanner.checkedNextFloat(fNextFloat8);
                        if (fCheckedNextFloat18 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 116) {
                                fNextFloat8 = Float.valueOf(fNextFloat8.floatValue() + fFloatValue);
                                fCheckedNextFloat18 = Float.valueOf(fCheckedNextFloat18.floatValue() + fFloatValue3);
                            }
                            fValueOf3.getClass();
                            fValueOf4.getClass();
                            pathDefinition.quadTo(fFloatValue2, fFloatValue4, fNextFloat8.floatValue(), fCheckedNextFloat18.floatValue());
                            fValueOf3.getClass();
                            fValueOf4.getClass();
                            fFloatValue = fNextFloat8.floatValue();
                            fFloatValue3 = fCheckedNextFloat18.floatValue();
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 86:
                    case 118:
                        Float fNextFloat9 = textScanner.nextFloat();
                        if (fNextFloat9 == null) {
                            Log.e(TAG, "Bad path coords for " + ((char) iIntValue2) + " path segment");
                            break;
                        } else {
                            if (iIntValue2 == 118) {
                                fNextFloat9 = Float.valueOf(fNextFloat9.floatValue() + fFloatValue3);
                            }
                            pathDefinition.lineTo(fFloatValue, fNextFloat9.floatValue());
                            fFloatValue3 = fNextFloat9.floatValue();
                            fFloatValue4 = fFloatValue3;
                            textScanner.skipCommaWhitespace();
                            if (!textScanner.empty()) {
                            }
                        }
                        break;
                    case 90:
                    case 122:
                        pathDefinition.close();
                        fFloatValue = f;
                        fFloatValue2 = fFloatValue;
                        fFloatValue3 = f2;
                        fFloatValue4 = fFloatValue3;
                        textScanner.skipCommaWhitespace();
                        if (!textScanner.empty()) {
                        }
                        break;
                }
                return pathDefinition;
            }
        }
        return pathDefinition;
    }

    private static Set<String> parseRequiredFeatures(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            if (strNextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(strNextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseSystemLanguage(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            int iIndexOf = strNextToken.indexOf(45);
            if (iIndexOf != -1) {
                strNextToken = strNextToken.substring(0, iIndexOf);
            }
            hashSet.add(new Locale(strNextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) throws SAXException {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static String parseFunctionalIRI(String str, String str2) throws SAXException {
        if (str.equals("none")) {
            return null;
        }
        if (!str.startsWith("url(") || !str.endsWith(")")) {
            throw new SAXException("Bad " + str2 + " attribute. Expected \"none\" or \"url()\" format");
        }
        return str.substring(4, str.length() - 1).trim();
    }

    private void style(Attributes attributes) throws SAXException {
        debug("<style>", new Object[0]);
        if (this.currentElement == null) {
            throw new SAXException("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean zEquals = true;
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVGParser$SVGAttr()[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 39) {
                str = strTrim;
            } else if (i2 == 78) {
                zEquals = strTrim.equals("text/css");
            }
        }
        if (zEquals && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
            this.inStyleElement = true;
        } else {
            this.ignoring = true;
            this.ignoreDepth = 1;
        }
    }

    private void parseCSSStyleSheet(String str) throws SAXException {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen).parse(str));
    }
}
