package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* loaded from: classes.dex */
public class SVGAndroidRenderer {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin = null;
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final int LUMINANCE_FACTOR_SHIFT = 15;
    private static final int LUMINANCE_TO_ALPHA_BLUE = 2362;
    private static final int LUMINANCE_TO_ALPHA_GREEN = 23442;
    private static final int LUMINANCE_TO_ALPHA_RED = 6963;
    private static final String TAG = "SVGAndroidRenderer";
    private Stack<Bitmap> bitmapStack;
    private Canvas canvas;
    private Stack<Canvas> canvasStack;
    private SVG.Box canvasViewPort;
    private boolean directRenderingMode;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private RendererState state;
    private Stack<RendererState> stateStack;

    private int clamp255(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PreserveAspectRatio.Alignment.valuesCustom().length];
        try {
            iArr2[PreserveAspectRatio.Alignment.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 10;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 7;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 9;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMin.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.FillRule.valuesCustom().length];
        try {
            iArr2[SVG.Style.FillRule.EvenOdd.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.FillRule.NonZero.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineCaps.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineCaps.Butt.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Square.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineJoin.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin = iArr2;
        return iArr2;
    }

    private class RendererState implements Cloneable {
        public boolean directRendering;
        public Paint fillPaint;
        public boolean hasFill;
        public boolean hasStroke;
        public boolean spacePreserve;
        public Paint strokePaint;
        public SVG.Style style;
        public SVG.Box viewBox;
        public SVG.Box viewPort;

        public RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(385);
            this.fillPaint.setStyle(Paint.Style.FILL);
            this.fillPaint.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(385);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(Typeface.DEFAULT);
            this.style = SVG.Style.getDefaultStyle();
        }

        protected Object clone() {
            try {
                RendererState rendererState = (RendererState) super.clone();
                rendererState.style = (SVG.Style) this.style.clone();
                rendererState.fillPaint = new Paint(this.fillPaint);
                rendererState.strokePaint = new Paint(this.strokePaint);
                return rendererState;
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e.toString());
            }
        }
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        this.state.viewPort = this.canvasViewPort;
        this.state.spacePreserve = false;
        this.state.directRendering = this.directRenderingMode;
        this.stateStack.push((RendererState) this.state.clone());
        this.canvasStack = new Stack<>();
        this.bitmapStack = new Stack<>();
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    protected SVGAndroidRenderer(Canvas canvas, SVG.Box box, float f) {
        this.canvas = canvas;
        this.dpi = f;
        this.canvasViewPort = box;
    }

    protected float getDPI() {
        return this.dpi;
    }

    protected float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    protected float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    protected SVG.Box getCurrentViewPortInUserUnits() {
        if (this.state.viewBox != null) {
            return this.state.viewBox;
        }
        return this.state.viewPort;
    }

    protected void renderDocument(SVG svg, SVG.Box box, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.document = svg;
        this.directRenderingMode = z;
        SVG.Svg rootElement = svg.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        SVG.Length length = rootElement.width;
        SVG.Length length2 = rootElement.height;
        if (box == null) {
            box = rootElement.viewBox;
        }
        SVG.Box box2 = box;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = rootElement.preserveAspectRatio;
        }
        render(rootElement, length, length2, box2, preserveAspectRatio);
    }

    private void render(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVG.Svg) {
            render((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            render((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            render((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            render((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            render((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            render((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            render((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            render((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            render((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            render((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            render((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            render((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            render((SVG.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z) {
        if (z) {
            parentPush(svgContainer);
        }
        Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z) {
            parentPop();
        }
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = (RendererState) this.state.clone();
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        if (svgElementBase.baseStyle != null) {
            updateStyle(rendererState, svgElementBase.baseStyle);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        if (svgElementBase.style != null) {
            updateStyle(rendererState, svgElementBase.style);
        }
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.SvgElementBase) {
            SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) svgObject;
            if (svgElementBase.spacePreserve != null) {
                this.state.spacePreserve = svgElementBase.spacePreserve.booleanValue();
            }
        }
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(((SVG.PaintReference) this.state.style.fill).href);
            if (svgObjectResolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) svgObjectResolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        if (this.state.style.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.canvas.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.canvas.drawPath(path2, this.state.strokePaint);
            this.canvas.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, this.state.strokePaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private static void info(String str, Object... objArr) {
        Log.i(TAG, String.format(str, objArr));
    }

    private void render(SVG.Svg svg) {
        render(svg, svg.width, svg.height);
    }

    private void render(SVG.Svg svg, SVG.Length length, SVG.Length length2) {
        render(svg, length, length2, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Length length, SVG.Length length2, SVG.Box box, PreserveAspectRatio preserveAspectRatio) {
        float fFloatValueY;
        debug("Svg render", new Object[0]);
        if (length == null || !length.isZero()) {
            if (length2 == null || !length2.isZero()) {
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = svg.preserveAspectRatio != null ? svg.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
                }
                updateStyleForElement(this.state, svg);
                if (display()) {
                    if (svg.parent != null) {
                        fFloatValueX = svg.x != null ? svg.x.floatValueX(this) : 0.0f;
                        fFloatValueY = svg.y != null ? svg.y.floatValueY(this) : 0.0f;
                    } else {
                        fFloatValueY = 0.0f;
                    }
                    SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
                    this.state.viewPort = new SVG.Box(fFloatValueX, fFloatValueY, length != null ? length.floatValueX(this) : currentViewPortInUserUnits.width, length2 != null ? length2.floatValueY(this) : currentViewPortInUserUnits.height);
                    if (!this.state.style.overflow.booleanValue()) {
                        setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
                    }
                    checkForClipPath(svg, this.state.viewPort);
                    if (box != null) {
                        this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
                        this.state.viewBox = svg.viewBox;
                    } else {
                        this.canvas.translate(fFloatValueX, fFloatValueY);
                    }
                    boolean zPushLayer = pushLayer();
                    viewportFill();
                    renderChildren(svg, true);
                    if (zPushLayer) {
                        popLayer(svg);
                    }
                    updateParentBoundingBox(svg);
                }
            }
        }
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            if (group.transform != null) {
                this.canvas.concat(group.transform);
            }
            checkForClipPath(group);
            boolean zPushLayer = pushLayer();
            renderChildren(group, true);
            if (zPushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            RectF rectF = new RectF(f, f2, f, f2);
            for (int i = 2; i <= 6; i += 2) {
                if (fArr[i] < rectF.left) {
                    rectF.left = fArr[i];
                }
                if (fArr[i] > rectF.right) {
                    rectF.right = fArr[i];
                }
                int i2 = i + 1;
                if (fArr[i2] < rectF.top) {
                    rectF.top = fArr[i2];
                }
                if (fArr[i2] > rectF.bottom) {
                    rectF.bottom = fArr[i2];
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
            if (svgElement2.boundingBox == null) {
                svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                svgElement2.boundingBox.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private boolean pushLayer() {
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 4);
        this.stateStack.push(this.state);
        RendererState rendererState = (RendererState) this.state.clone();
        this.state = rendererState;
        if (rendererState.style.mask != null && this.state.directRendering) {
            SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(this.state.style.mask);
            if (svgObjectResolveIRI == null || !(svgObjectResolveIRI instanceof SVG.Mask)) {
                error("Mask reference '%s' not found", this.state.style.mask);
                this.state.style.mask = null;
            } else {
                this.canvasStack.push(this.canvas);
                duplicateCanvas();
            }
        }
        return true;
    }

    private void popLayer(SVG.SvgElement svgElement) {
        if (this.state.style.mask != null && this.state.directRendering) {
            SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(this.state.style.mask);
            duplicateCanvas();
            renderMask((SVG.Mask) svgObjectResolveIRI, svgElement);
            Bitmap bitmapProcessMaskBitmaps = processMaskBitmaps();
            Canvas canvasPop = this.canvasStack.pop();
            this.canvas = canvasPop;
            canvasPop.save();
            this.canvas.setMatrix(new Matrix());
            this.canvas.drawBitmap(bitmapProcessMaskBitmaps, 0.0f, 0.0f, this.state.fillPaint);
            bitmapProcessMaskBitmaps.recycle();
            this.canvas.restore();
        }
        statePop();
    }

    private boolean requiresCompositing() {
        if (this.state.style.mask != null && !this.state.directRendering) {
            warn("Masks are not supported when using getPicture()", new Object[0]);
        }
        if (this.state.style.opacity.floatValue() >= 1.0f) {
            return this.state.style.mask != null && this.state.directRendering;
        }
        return true;
    }

    private void duplicateCanvas() {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.canvas.getWidth(), this.canvas.getHeight(), Bitmap.Config.ARGB_8888);
            this.bitmapStack.push(bitmapCreateBitmap);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.setMatrix(this.canvas.getMatrix());
            this.canvas = canvas;
        } catch (OutOfMemoryError e) {
            error("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e;
        }
    }

    private Bitmap processMaskBitmaps() {
        Bitmap bitmapPop = this.bitmapStack.pop();
        Bitmap bitmapPop2 = this.bitmapStack.pop();
        int width = bitmapPop.getWidth();
        int height = bitmapPop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i = 0;
        while (i < height) {
            int i2 = width;
            int i3 = i;
            bitmapPop.getPixels(iArr, 0, i2, 0, i3, i2, 1);
            int[] iArr3 = iArr;
            int[] iArr4 = iArr2;
            Bitmap bitmap = bitmapPop2;
            bitmap.getPixels(iArr4, 0, i2, 0, i3, i2, 1);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = iArr3[i4];
                int i6 = i5 & 255;
                int i7 = (i5 >> 8) & 255;
                int i8 = (i5 >> 16) & 255;
                int i9 = (i5 >> 24) & 255;
                if (i9 == 0) {
                    iArr4[i4] = 0;
                } else {
                    int i10 = ((((i8 * LUMINANCE_TO_ALPHA_RED) + (i7 * LUMINANCE_TO_ALPHA_GREEN)) + (i6 * LUMINANCE_TO_ALPHA_BLUE)) * i9) / 8355840;
                    int i11 = iArr4[i4];
                    iArr4[i4] = (i11 & ViewCompat.MEASURED_SIZE_MASK) | (((((i11 >> 24) & 255) * i10) / 255) << 24);
                }
            }
            width = i2;
            bitmap.setPixels(iArr4, 0, width, 0, i3, width, 1);
            i = i3 + 1;
            bitmapPop2 = bitmap;
            iArr2 = iArr4;
            iArr = iArr3;
        }
        bitmapPop.recycle();
        return bitmapPop2;
    }

    private void render(SVG.Switch r3) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r3);
        if (display()) {
            if (r3.transform != null) {
                this.canvas.concat(r3.transform);
            }
            checkForClipPath(r3);
            boolean zPushLayer = pushLayer();
            renderSwitchChild(r3);
            if (zPushLayer) {
                popLayer(r3);
            }
            updateParentBoundingBox(r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch r8) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = this.document.getFileResolver();
        for (SVG.SvgObject svgObject : r8.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures == null || (!requiredFeatures.isEmpty() && SVGParser.supportedFeatures.containsAll(requiredFeatures))) {
                        Set<String> requiredFormats = svgConditional.getRequiredFormats();
                        if (requiredFormats != null) {
                            if (!requiredFormats.isEmpty() && fileResolver != null) {
                                Iterator<String> it = requiredFormats.iterator();
                                while (it.hasNext()) {
                                    if (!fileResolver.isFormatSupported(it.next())) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> requiredFonts = svgConditional.getRequiredFonts();
                        if (requiredFonts != null) {
                            if (!requiredFonts.isEmpty() && fileResolver != null) {
                                Iterator<String> it2 = requiredFonts.iterator();
                                while (it2.hasNext()) {
                                    if (fileResolver.resolveFont(it2.next(), this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        render(svgObject);
                        return;
                    }
                }
            }
        }
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        if (use.width == null || !use.width.isZero()) {
            if (use.height == null || !use.height.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVG.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
                    if (svgObjectResolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    if (use.transform != null) {
                        this.canvas.concat(use.transform);
                    }
                    Matrix matrix = new Matrix();
                    matrix.preTranslate(use.x != null ? use.x.floatValueX(this) : 0.0f, use.y != null ? use.y.floatValueY(this) : 0.0f);
                    this.canvas.concat(matrix);
                    checkForClipPath(use);
                    boolean zPushLayer = pushLayer();
                    parentPush(use);
                    if (svgObjectResolveIRI instanceof SVG.Svg) {
                        statePush();
                        SVG.Svg svg = (SVG.Svg) svgObjectResolveIRI;
                        render(svg, use.width != null ? use.width : svg.width, use.height != null ? use.height : svg.height);
                        statePop();
                    } else if (svgObjectResolveIRI instanceof SVG.Symbol) {
                        SVG.Length length = use.width != null ? use.width : new SVG.Length(100.0f, SVG.Unit.percent);
                        SVG.Length length2 = use.height != null ? use.height : new SVG.Length(100.0f, SVG.Unit.percent);
                        statePush();
                        render((SVG.Symbol) svgObjectResolveIRI, length, length2);
                        statePop();
                    } else {
                        render(svgObjectResolveIRI);
                    }
                    parentPop();
                    if (zPushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (path.transform != null) {
                    this.canvas.concat(path.transform);
                }
                Path path2 = new PathConverter(path.d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradiantsAndPatterns(path);
                checkForClipPath(path);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (zPushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        if (rect.width == null || rect.height == null || rect.width.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            if (rect.transform != null) {
                this.canvas.concat(rect.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradiantsAndPatterns(rect);
            checkForClipPath(rect);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        if (circle.r == null || circle.r.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            if (circle.transform != null) {
                this.canvas.concat(circle.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradiantsAndPatterns(circle);
            checkForClipPath(circle);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        if (ellipse.rx == null || ellipse.ry == null || ellipse.rx.isZero() || ellipse.ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            if (ellipse.transform != null) {
                this.canvas.concat(ellipse.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradiantsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean zPushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, pathMakePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(pathMakePathAndBoundingBox);
            }
            if (zPushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            if (line.transform != null) {
                this.canvas.concat(line.transform);
            }
            Path pathMakePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradiantsAndPatterns(line);
            checkForClipPath(line);
            boolean zPushLayer = pushLayer();
            doStroke(pathMakePathAndBoundingBox);
            renderMarkers(line);
            if (zPushLayer) {
                popLayer(line);
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        float fFloatValueX = line.x1 != null ? line.x1.floatValueX(this) : 0.0f;
        float fFloatValueY = line.y1 != null ? line.y1.floatValueY(this) : 0.0f;
        float fFloatValueX2 = line.x2 != null ? line.x2.floatValueX(this) : 0.0f;
        float fFloatValueY2 = line.y2 != null ? line.y2.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f = fFloatValueX2 - fFloatValueX;
        float f2 = fFloatValueY2 - fFloatValueY;
        arrayList.add(new MarkerVector(fFloatValueX, fFloatValueY, f, f2));
        arrayList.add(new MarkerVector(fFloatValueX2, fFloatValueY2, f, f2));
        return arrayList;
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polyLine.transform != null) {
                    this.canvas.concat(polyLine.transform);
                }
                if (polyLine.points.length < 2) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                checkForGradiantsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (zPushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        int length = polyLine.points.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MarkerVector markerVector = new MarkerVector(polyLine.points[0], polyLine.points[1], 0.0f, 0.0f);
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < length) {
            float f3 = polyLine.points[i];
            float f4 = polyLine.points[i + 1];
            markerVector.add(f3, f4);
            arrayList.add(markerVector);
            i += 2;
            markerVector = new MarkerVector(f3, f4, f3 - markerVector.x, f4 - markerVector.y);
            f = f3;
            f2 = f4;
        }
        if (!(polyLine instanceof SVG.Polygon)) {
            arrayList.add(markerVector);
            return arrayList;
        }
        if (f != polyLine.points[0] && f2 != polyLine.points[1]) {
            float f5 = polyLine.points[0];
            float f6 = polyLine.points[1];
            markerVector.add(f5, f6);
            arrayList.add(markerVector);
            MarkerVector markerVector2 = new MarkerVector(f5, f6, f5 - markerVector.x, f6 - markerVector.y);
            markerVector2.add((MarkerVector) arrayList.get(0));
            arrayList.add(markerVector2);
            arrayList.set(0, markerVector2);
        }
        return arrayList;
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            if (this.state.hasStroke || this.state.hasFill) {
                if (polygon.transform != null) {
                    this.canvas.concat(polygon.transform);
                }
                if (polygon.points.length < 2) {
                    return;
                }
                Path pathMakePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradiantsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean zPushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, pathMakePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(pathMakePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (zPushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                this.canvas.concat(text.transform);
            }
            float fFloatValueY = 0.0f;
            float fFloatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : text.x.get(0).floatValueX(this);
            float fFloatValueY2 = (text.y == null || text.y.size() == 0) ? 0.0f : text.y.get(0).floatValueY(this);
            float fFloatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            if (text.dy != null && text.dy.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradiantsAndPatterns(text);
            checkForClipPath(text);
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY));
            if (zPushLayer) {
                popLayer(text);
            }
        }
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        if (this.state.style.direction == SVG.Style.TextDirection.LTR || this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
            return this.state.style.textAnchor;
        }
        return this.state.style.textAnchor == SVG.Style.TextAnchor.Start ? SVG.Style.TextAnchor.End : SVG.Style.TextAnchor.Start;
    }

    private class PlainTextDrawer extends TextProcessor {
        public float x;
        public float y;

        public PlainTextDrawer(float f, float f2) {
            super(SVGAndroidRenderer.this, null);
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x, this.y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.x, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private abstract class TextProcessor {
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        private TextProcessor() {
        }

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, TextProcessor textProcessor) {
            this();
        }
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator<SVG.SvgObject> it = textContainer.children.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.SvgObject next = it.next();
                if (next instanceof SVG.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) next).text, z, !it.hasNext()));
                } else {
                    processTextChild(next, textProcessor);
                }
                z = false;
            }
        }
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f;
        float fFloatValueY;
        float fFloatValueX;
        if (textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                statePush();
                renderTextPath((SVG.TextPath) svgObject);
                statePop();
                return;
            }
            if (svgObject instanceof SVG.TSpan) {
                debug("TSpan render", new Object[0]);
                statePush();
                SVG.TSpan tSpan = (SVG.TSpan) svgObject;
                updateStyleForElement(this.state, tSpan);
                if (display()) {
                    boolean z = textProcessor instanceof PlainTextDrawer;
                    float fFloatValueY2 = 0.0f;
                    if (z) {
                        float fFloatValueX2 = (tSpan.x == null || tSpan.x.size() == 0) ? ((PlainTextDrawer) textProcessor).x : tSpan.x.get(0).floatValueX(this);
                        fFloatValueY = (tSpan.y == null || tSpan.y.size() == 0) ? ((PlainTextDrawer) textProcessor).y : tSpan.y.get(0).floatValueY(this);
                        fFloatValueX = (tSpan.dx == null || tSpan.dx.size() == 0) ? 0.0f : tSpan.dx.get(0).floatValueX(this);
                        if (tSpan.dy != null && tSpan.dy.size() != 0) {
                            fFloatValueY2 = tSpan.dy.get(0).floatValueY(this);
                        }
                        f = fFloatValueY2;
                        fFloatValueY2 = fFloatValueX2;
                    } else {
                        f = 0.0f;
                        fFloatValueY = 0.0f;
                        fFloatValueX = 0.0f;
                    }
                    checkForGradiantsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                    if (z) {
                        PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                        plainTextDrawer.x = fFloatValueY2 + fFloatValueX;
                        plainTextDrawer.y = fFloatValueY + f;
                    }
                    boolean zPushLayer = pushLayer();
                    enumerateTextSpans(tSpan, textProcessor);
                    if (zPushLayer) {
                        popLayer(tSpan);
                    }
                }
                statePop();
                return;
            }
            if (svgObject instanceof SVG.TRef) {
                statePush();
                SVG.TRef tRef = (SVG.TRef) svgObject;
                updateStyleForElement(this.state, tRef);
                if (display()) {
                    checkForGradiantsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                    SVG.SvgObject svgObjectResolveIRI = svgObject.document.resolveIRI(tRef.href);
                    if (svgObjectResolveIRI == null || !(svgObjectResolveIRI instanceof SVG.TextContainer)) {
                        error("Tref reference '%s' not found", tRef.href);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        extractRawText((SVG.TextContainer) svgObjectResolveIRI, sb);
                        if (sb.length() > 0) {
                            textProcessor.processText(sb.toString());
                        }
                    }
                }
                statePop();
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            SVG.SvgObject svgObjectResolveIRI = textPath.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVG.Path path = (SVG.Path) svgObjectResolveIRI;
            Path path2 = new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            float fFloatValue = textPath.startOffset != null ? textPath.startOffset.floatValue(this, new PathMeasure(path2, false).getLength()) : 0.0f;
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValue -= fCalculateTextWidth;
            }
            checkForGradiantsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
            boolean zPushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, fFloatValue, 0.0f));
            if (zPushLayer) {
                popLayer(textPath);
            }
        }
    }

    private class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        public PathTextDrawer(Path path, float f, float f2) {
            super(f, f2);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            String str2;
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    str2 = str;
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str2, this.path, this.x, this.y, SVGAndroidRenderer.this.state.fillPaint);
                } else {
                    str2 = str;
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str2, this.path, this.x, this.y, SVGAndroidRenderer.this.state.strokePaint);
                }
            } else {
                str2 = str;
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str2);
        }
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.x;
    }

    private class TextWidthCalculator extends TextProcessor {
        public float x;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.x = 0.0f;
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, TextWidthCalculator textWidthCalculator) {
            this();
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private class TextBoundsCalculator extends TextProcessor {
        RectF bbox;
        float x;
        float y;

        public TextBoundsCalculator(float f, float f2) {
            super(SVGAndroidRenderer.this, null);
            this.bbox = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject svgObjectResolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (svgObjectResolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) svgObjectResolveIRI;
            Path path2 = SVGAndroidRenderer.this.new PathConverter(path.d).getPath();
            if (path.transform != null) {
                path2.transform(path.transform);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.bbox.union(rectF);
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) next, sb);
            } else if (next instanceof SVG.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVG.TextSequence) next).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private String textXMLSpaceTransform(String str, boolean z, boolean z2) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String strReplaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            strReplaceAll = strReplaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            strReplaceAll = strReplaceAll.replaceAll("\\s+$", "");
        }
        return strReplaceAll.replaceAll("\\s{2,}", " ");
    }

    private void render(SVG.Symbol symbol, SVG.Length length, SVG.Length length2) {
        debug("Symbol render", new Object[0]);
        if (length == null || !length.isZero()) {
            if (length2 == null || !length2.isZero()) {
                PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio != null ? symbol.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
                updateStyleForElement(this.state, symbol);
                this.state.viewPort = new SVG.Box(0.0f, 0.0f, length != null ? length.floatValueX(this) : this.state.viewPort.width, length2 != null ? length2.floatValueX(this) : this.state.viewPort.height);
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
                }
                if (symbol.viewBox != null) {
                    this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, symbol.viewBox, preserveAspectRatio));
                    this.state.viewBox = symbol.viewBox;
                }
                boolean zPushLayer = pushLayer();
                renderChildren(symbol, true);
                if (zPushLayer) {
                    popLayer(symbol);
                }
                updateParentBoundingBox(symbol);
            }
        }
    }

    private void render(SVG.Image image) {
        debug("Image render", new Object[0]);
        if (image.width == null || image.width.isZero() || image.height == null || image.height.isZero() || image.href == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio != null ? image.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        Bitmap bitmapCheckForImageDataURL = checkForImageDataURL(image.href);
        if (bitmapCheckForImageDataURL == null) {
            SVGExternalFileResolver fileResolver = this.document.getFileResolver();
            if (fileResolver == null) {
                return;
            } else {
                bitmapCheckForImageDataURL = fileResolver.resolveImage(image.href);
            }
        }
        if (bitmapCheckForImageDataURL == null) {
            error("Could not locate image '%s'", image.href);
            return;
        }
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            if (image.transform != null) {
                this.canvas.concat(image.transform);
            }
            this.state.viewPort = new SVG.Box(image.x != null ? image.x.floatValueX(this) : 0.0f, image.y != null ? image.y.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(this.state.viewPort.minX, this.state.viewPort.minY, this.state.viewPort.width, this.state.viewPort.height);
            }
            image.boundingBox = new SVG.Box(0.0f, 0.0f, bitmapCheckForImageDataURL.getWidth(), bitmapCheckForImageDataURL.getHeight());
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, image.boundingBox, preserveAspectRatio));
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean zPushLayer = pushLayer();
            viewportFill();
            this.canvas.drawBitmap(bitmapCheckForImageDataURL, 0.0f, 0.0f, this.state.fillPaint);
            if (zPushLayer) {
                popLayer(image);
            }
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int iIndexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (iIndexOf = str.indexOf(44)) == -1 || iIndexOf < 12 || !";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    private boolean display() {
        if (this.state.style.display != null) {
            return this.state.style.display.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        if (this.state.style.visibility != null) {
            return this.state.style.visibility.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        if (r6 != 10) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[PHI: r4
      0x0095: PHI (r4v2 float) = (r4v1 float), (r4v3 float) binds: [B:32:0x0088, B:36:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Matrix calculateViewBoxTransform(SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        if (preserveAspectRatio != null && preserveAspectRatio.getAlignment() != null) {
            float f3 = box.width / box2.width;
            float f4 = box.height / box2.height;
            float f5 = -box2.minX;
            float f6 = -box2.minY;
            if (preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(f3, f4);
                matrix.preTranslate(f5, f6);
                return matrix;
            }
            float fMax = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.Slice ? Math.max(f3, f4) : Math.min(f3, f4);
            float f7 = box.width / fMax;
            float f8 = box.height / fMax;
            int i = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()];
            if (i == 3) {
                f = (box2.width - f7) / 2.0f;
                f5 -= f;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    case 5:
                    case 6:
                    case 7:
                        f2 = (box2.height - f8) / 2.0f;
                        break;
                    case 8:
                    case 9:
                    case 10:
                        f2 = box2.height - f8;
                        break;
                    default:
                        matrix.preTranslate(box.minX, box.minY);
                        matrix.preScale(fMax, fMax);
                        matrix.preTranslate(f5, f6);
                        break;
                }
                f6 -= f2;
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(fMax, fMax);
                matrix.preTranslate(f5, f6);
            } else {
                if (i != 4) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 9) {
                            }
                        }
                    }
                    f = (box2.width - f7) / 2.0f;
                    f5 -= f;
                    switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    }
                    f6 -= f2;
                    matrix.preTranslate(box.minX, box.minY);
                    matrix.preScale(fMax, fMax);
                    matrix.preTranslate(f5, f6);
                }
                f = box2.width - f7;
                f5 -= f;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                }
                f6 -= f2;
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(fMax, fMax);
                matrix.preTranslate(f5, f6);
            }
        }
        return matrix;
    }

    private boolean isSpecified(SVG.Style style, long j) {
        return (j & style.specifiedFlags) != 0;
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        SVG svg;
        if (isSpecified(style, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) {
            rendererState.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            rendererState.hasFill = style.fill != null;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            rendererState.hasStroke = style.stroke != null;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            rendererState.style.strokeWidth = style.strokeWidth;
            rendererState.strokePaint.setStrokeWidth(rendererState.style.strokeWidth.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps()[style.strokeLineCap.ordinal()];
            if (i == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i2 = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin()[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typefaceCheckGenericFont = null;
        if (isSpecified(style, 1536L)) {
            if (rendererState.style.strokeDashArray == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length = rendererState.style.strokeDashArray.length;
                int i3 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    float fFloatValue = rendererState.style.strokeDashArray[i4 % length].floatValue(this);
                    fArr[i4] = fFloatValue;
                    f += fFloatValue;
                }
                if (f == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float fFloatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (fFloatValue2 < 0.0f) {
                        fFloatValue2 = (fFloatValue2 % f) + f;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, fFloatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style2 = rendererState.style;
                style2.fontWeight = Integer.valueOf(style2.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && rendererState.style.fontWeight.intValue() < 900) {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() + 100);
            } else {
                rendererState.style.fontWeight = style.fontWeight;
            }
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            if (rendererState.style.fontFamily != null && (svg = this.document) != null) {
                SVGExternalFileResolver fileResolver = svg.getFileResolver();
                for (String str : rendererState.style.fontFamily) {
                    Typeface typefaceCheckGenericFont2 = checkGenericFont(str, rendererState.style.fontWeight, rendererState.style.fontStyle);
                    typefaceCheckGenericFont = (typefaceCheckGenericFont2 != null || fileResolver == null) ? typefaceCheckGenericFont2 : fileResolver.resolveFont(str, rendererState.style.fontWeight.intValue(), String.valueOf(rendererState.style.fontStyle));
                    if (typefaceCheckGenericFont != null) {
                        break;
                    }
                }
            }
            if (typefaceCheckGenericFont == null) {
                typefaceCheckGenericFont = checkGenericFont(DEFAULT_FONT_FAMILY, rendererState.style.fontWeight, rendererState.style.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typefaceCheckGenericFont);
            rendererState.strokePaint.setTypeface(typefaceCheckGenericFont);
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            rendererState.style.textDecoration = style.textDecoration;
            rendererState.fillPaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            rendererState.fillPaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
            rendererState.strokePaint.setStrikeThruText(style.textDecoration == SVG.Style.TextDecoration.LineThrough);
            rendererState.strokePaint.setUnderlineText(style.textDecoration == SVG.Style.TextDecoration.Underline);
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
    }

    private void setPaintColour(RendererState rendererState, boolean z, SVG.SvgPaint svgPaint) {
        int i;
        SVG.Style style = rendererState.style;
        float fFloatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = rendererState.style.color.colour;
        }
        int iClamp255 = i | (clamp255(fFloatValue) << 24);
        if (z) {
            rendererState.fillPaint.setColor(iClamp255);
        } else {
            rendererState.strokePaint.setColor(iClamp255);
        }
    }

    private Typeface checkGenericFont(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        int i = 1;
        boolean z = fontStyle == SVG.Style.FontStyle.Italic;
        if (num.intValue() <= 500) {
            i = z ? 2 : 0;
        } else if (z) {
            i = 3;
        }
        if (str.equals("serif")) {
            return Typeface.create(Typeface.SERIF, i);
        }
        if (str.equals(DEFAULT_FONT_FAMILY)) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        if (str.equals("fantasy")) {
            return Typeface.create(Typeface.SANS_SERIF, i);
        }
        return null;
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule == null) {
            return Path.FillType.WINDING;
        }
        if ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule()[this.state.style.fillRule.ordinal()] == 2) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void setClipRect(float f, float f2, float f3, float f4) {
        float fFloatValueX = f3 + f;
        float fFloatValueY = f4 + f2;
        if (this.state.style.clip != null) {
            f += this.state.style.clip.left.floatValueX(this);
            f2 += this.state.style.clip.top.floatValueY(this);
            fFloatValueX -= this.state.style.clip.right.floatValueX(this);
            fFloatValueY -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f, f2, fFloatValueX, fFloatValueY);
    }

    private void viewportFill() {
        int iClamp255;
        if (this.state.style.viewportFill instanceof SVG.Colour) {
            iClamp255 = ((SVG.Colour) this.state.style.viewportFill).colour;
        } else if (!(this.state.style.viewportFill instanceof SVG.CurrentColor)) {
            return;
        } else {
            iClamp255 = this.state.style.color.colour;
        }
        if (this.state.style.viewportFillOpacity != null) {
            iClamp255 |= clamp255(this.state.style.viewportFillOpacity.floatValue()) << 24;
        }
        this.canvas.drawColor(iClamp255);
    }

    private class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        public PathConverter(SVG.PathDefinition pathDefinition) {
            pathDefinition.enumeratePath(this);
        }

        public Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.PathInterface pathInterface) {
        double d;
        double d2;
        double d3;
        float fSqrt;
        float fSqrt2;
        if (f == f6 && f2 == f7) {
            return;
        }
        if (f3 == 0.0f || f4 == 0.0f) {
            pathInterface.lineTo(f6, f7);
            return;
        }
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        double radians = (float) Math.toRadians(f5 % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d4 = (f - f6) / 2.0d;
        double d5 = (f2 - f7) / 2.0d;
        double d6 = (dCos * d4) + (dSin * d5);
        double d7 = ((-dSin) * d4) + (d5 * dCos);
        double d8 = fAbs * fAbs;
        double d9 = fAbs2 * fAbs2;
        double d10 = d6 * d6;
        double d11 = d7 * d7;
        double d12 = (d10 / d8) + (d11 / d9);
        if (d12 > 1.0d) {
            fSqrt = ((float) Math.sqrt(d12)) * fAbs;
            fSqrt2 = ((float) Math.sqrt(d12)) * fAbs2;
            d3 = fSqrt * fSqrt;
            d = dSin;
            d2 = fSqrt2 * fSqrt2;
        } else {
            d = dSin;
            d2 = d9;
            d3 = d8;
            fSqrt = fAbs;
            fSqrt2 = fAbs2;
        }
        double d13 = d2;
        double d14 = z == z2 ? -1 : 1;
        double d15 = d3 * d13;
        double d16 = d3 * d11;
        double d17 = d13 * d10;
        double d18 = ((d15 - d16) - d17) / (d16 + d17);
        if (d18 < 0.0d) {
            d18 = 0.0d;
        }
        double dSqrt = d14 * Math.sqrt(d18);
        double d19 = fSqrt;
        double d20 = fSqrt2;
        double d21 = ((d19 * d7) / d20) * dSqrt;
        double d22 = (-((d20 * d6) / d19)) * dSqrt;
        double d23 = ((f + f6) / 2.0d) + ((dCos * d21) - (d * d22));
        double d24 = ((f2 + f7) / 2.0d) + (d * d21) + (dCos * d22);
        double d25 = (d6 - d21) / d19;
        double d26 = (d7 - d22) / d20;
        double d27 = ((-d6) - d21) / d19;
        double d28 = ((-d7) - d22) / d20;
        double d29 = (d25 * d25) + (d26 * d26);
        double degrees = Math.toDegrees((d26 < 0.0d ? -1.0d : 1.0d) * Math.acos(d25 / Math.sqrt(d29)));
        double degrees2 = Math.toDegrees(((d25 * d28) - (d26 * d27) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d25 * d27) + (d26 * d28)) / Math.sqrt(d29 * ((d27 * d27) + (d28 * d28)))));
        if (!z2 && degrees2 > 0.0d) {
            degrees2 -= 360.0d;
        } else if (z2 && degrees2 < 0.0d) {
            degrees2 += 360.0d;
        }
        float[] fArrArcToBeziers = arcToBeziers(degrees % 360.0d, degrees2 % 360.0d);
        Matrix matrix = new Matrix();
        matrix.postScale(fSqrt, fSqrt2);
        matrix.postRotate(f5);
        matrix.postTranslate((float) d23, (float) d24);
        matrix.mapPoints(fArrArcToBeziers);
        fArrArcToBeziers[fArrArcToBeziers.length - 2] = f6;
        fArrArcToBeziers[fArrArcToBeziers.length - 1] = f7;
        for (int i = 0; i < fArrArcToBeziers.length; i += 6) {
            pathInterface.cubicTo(fArrArcToBeziers[i], fArrArcToBeziers[i + 1], fArrArcToBeziers[i + 2], fArrArcToBeziers[i + 3], fArrArcToBeziers[i + 4], fArrArcToBeziers[i + 5]);
        }
    }

    private static float[] arcToBeziers(double d, double d2) {
        int iCeil = (int) Math.ceil(Math.abs(d2) / 90.0d);
        double radians = Math.toRadians(d);
        double radians2 = (float) (Math.toRadians(d2) / iCeil);
        double d3 = radians2 / 2.0d;
        double dSin = (Math.sin(d3) * 1.3333333333333333d) / (Math.cos(d3) + 1.0d);
        float[] fArr = new float[iCeil * 6];
        int i = 0;
        int i2 = 0;
        while (i < iCeil) {
            double d4 = (i * r3) + radians;
            double dCos = Math.cos(d4);
            double dSin2 = Math.sin(d4);
            double d5 = radians;
            fArr[i2] = (float) (dCos - (dSin * dSin2));
            fArr[i2 + 1] = (float) (dSin2 + (dCos * dSin));
            double d6 = d4 + radians2;
            double dCos2 = Math.cos(d6);
            double dSin3 = Math.sin(d6);
            fArr[i2 + 2] = (float) ((dSin * dSin3) + dCos2);
            fArr[i2 + 3] = (float) (dSin3 - (dSin * dCos2));
            int i3 = i2 + 5;
            fArr[i2 + 4] = (float) dCos2;
            i2 += 6;
            fArr[i3] = (float) dSin3;
            i++;
            radians = d5;
            iCeil = iCeil;
        }
        return fArr;
    }

    private class MarkerVector {
        public float dx;
        public float dy;
        public float x;
        public float y;

        public MarkerVector(float f, float f2, float f3, float f4) {
            this.dx = 0.0f;
            this.dy = 0.0f;
            this.x = f;
            this.y = f2;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                this.dx = (float) (f3 / dSqrt);
                this.dy = (float) (f4 / dSqrt);
            }
        }

        public void add(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double dSqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (dSqrt != 0.0d) {
                this.dx += (float) (f3 / dSqrt);
                this.dy += (float) (f4 / dSqrt);
            }
        }

        public void add(MarkerVector markerVector) {
            this.dx += markerVector.dx;
            this.dy += markerVector.dy;
        }

        public String toString() {
            return "(" + this.x + "," + this.y + " " + this.dx + "," + this.dy + ")";
        }
    }

    private class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        public MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
        }

        public List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f;
            this.startY = f2;
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f, f2, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f, f2, f - this.lastPos.x, f2 - this.lastPos.y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f, f2);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = SVGAndroidRenderer.this.new MarkerVector(f3, f4, f3 - f, f4 - f2);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.startArc = true;
            this.normalCubic = false;
            SVGAndroidRenderer.arcTo(this.lastPos.x, this.lastPos.y, f, f2, f3, z, z2, f4, f5, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }
    }

    private void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        SVG.Marker marker2;
        SVG.Marker marker3;
        List<MarkerVector> listCalculateMarkerPositions;
        int size;
        if (this.state.style.markerStart == null && this.state.style.markerMid == null && this.state.style.markerEnd == null) {
            return;
        }
        if (this.state.style.markerStart == null) {
            marker = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI = graphicsElement.document.resolveIRI(this.state.style.markerStart);
            if (svgObjectResolveIRI != null) {
                marker = (SVG.Marker) svgObjectResolveIRI;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
                marker = null;
            }
        }
        if (this.state.style.markerMid == null) {
            marker2 = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI2 = graphicsElement.document.resolveIRI(this.state.style.markerMid);
            if (svgObjectResolveIRI2 != null) {
                marker2 = (SVG.Marker) svgObjectResolveIRI2;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerMid);
                marker2 = null;
            }
        }
        if (this.state.style.markerEnd == null) {
            marker3 = null;
        } else {
            SVG.SvgObject svgObjectResolveIRI3 = graphicsElement.document.resolveIRI(this.state.style.markerEnd);
            if (svgObjectResolveIRI3 != null) {
                marker3 = (SVG.Marker) svgObjectResolveIRI3;
            } else {
                error("Marker reference '%s' not found", this.state.style.markerEnd);
                marker3 = null;
            }
        }
        if (graphicsElement instanceof SVG.Path) {
            listCalculateMarkerPositions = new MarkerPositionCalculator(((SVG.Path) graphicsElement).d).getMarkers();
        } else if (graphicsElement instanceof SVG.Line) {
            listCalculateMarkerPositions = calculateMarkerPositions((SVG.Line) graphicsElement);
        } else {
            listCalculateMarkerPositions = calculateMarkerPositions((SVG.PolyLine) graphicsElement);
        }
        if (listCalculateMarkerPositions == null || (size = listCalculateMarkerPositions.size()) == 0) {
            return;
        }
        SVG.Style style = this.state.style;
        SVG.Style style2 = this.state.style;
        this.state.style.markerEnd = null;
        style2.markerMid = null;
        style.markerStart = null;
        if (marker != null) {
            renderMarker(marker, listCalculateMarkerPositions.get(0));
        }
        if (marker2 != null) {
            for (int i = 1; i < size - 1; i++) {
                renderMarker(marker2, listCalculateMarkerPositions.get(i));
            }
        }
        if (marker3 != null) {
            renderMarker(marker3, listCalculateMarkerPositions.get(size - 1));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128 A[PHI: r1
      0x0128: PHI (r1v1 float) = (r1v0 float), (r1v2 float) binds: [B:62:0x011d, B:66:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarker(SVG.Marker marker, MarkerVector markerVector) {
        float fFloatValue;
        float f;
        float f2;
        float f3;
        statePush();
        float f4 = 0.0f;
        if (marker.orient == null) {
            fFloatValue = 0.0f;
        } else if (!Float.isNaN(marker.orient.floatValue())) {
            fFloatValue = marker.orient.floatValue();
        } else if (markerVector.dx != 0.0f || markerVector.dy != 0.0f) {
            fFloatValue = (float) Math.toDegrees(Math.atan2(markerVector.dy, markerVector.dx));
        }
        float fFloatValue2 = marker.markerUnitsAreUser ? 1.0f : this.state.style.strokeWidth.floatValue(this.dpi);
        this.state = findInheritFromAncestorState(marker);
        Matrix matrix = new Matrix();
        matrix.preTranslate(markerVector.x, markerVector.y);
        matrix.preRotate(fFloatValue);
        matrix.preScale(fFloatValue2, fFloatValue2);
        float fFloatValueX = marker.refX != null ? marker.refX.floatValueX(this) : 0.0f;
        float fFloatValueY = marker.refY != null ? marker.refY.floatValueY(this) : 0.0f;
        float fFloatValueX2 = marker.markerWidth != null ? marker.markerWidth.floatValueX(this) : 3.0f;
        float fFloatValueY2 = marker.markerHeight != null ? marker.markerHeight.floatValueY(this) : 3.0f;
        if (marker.viewBox != null) {
            float fMax = fFloatValueX2 / marker.viewBox.width;
            float f5 = fFloatValueY2 / marker.viewBox.height;
            PreserveAspectRatio preserveAspectRatio = marker.preserveAspectRatio != null ? marker.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
            if (!preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                fMax = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.Slice ? Math.max(fMax, f5) : Math.min(fMax, f5);
                f5 = fMax;
            }
            matrix.preTranslate((-fFloatValueX) * fMax, (-fFloatValueY) * f5);
            this.canvas.concat(matrix);
            float f6 = marker.viewBox.width * fMax;
            float f7 = marker.viewBox.height * f5;
            int i = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()];
            if (i == 3) {
                f = (fFloatValueX2 - f6) / 2.0f;
                f2 = 0.0f - f;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    case 5:
                    case 6:
                    case 7:
                        f3 = (fFloatValueY2 - f7) / 2.0f;
                        f4 = 0.0f - f3;
                        if (!this.state.style.overflow.booleanValue()) {
                            setClipRect(f2, f4, fFloatValueX2, fFloatValueY2);
                        }
                        matrix.reset();
                        matrix.preScale(fMax, f5);
                        this.canvas.concat(matrix);
                        break;
                    case 8:
                    case 9:
                    case 10:
                        f3 = fFloatValueY2 - f7;
                        f4 = 0.0f - f3;
                        if (!this.state.style.overflow.booleanValue()) {
                        }
                        matrix.reset();
                        matrix.preScale(fMax, f5);
                        this.canvas.concat(matrix);
                        break;
                    default:
                        if (!this.state.style.overflow.booleanValue()) {
                        }
                        matrix.reset();
                        matrix.preScale(fMax, f5);
                        this.canvas.concat(matrix);
                        break;
                }
            } else {
                if (i != 4) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 9) {
                                if (i != 10) {
                                    f2 = 0.0f;
                                    switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                                    }
                                }
                            }
                        }
                    }
                    f = (fFloatValueX2 - f6) / 2.0f;
                    f2 = 0.0f - f;
                    switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    }
                }
                f = fFloatValueX2 - f6;
                f2 = 0.0f - f;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                }
            }
        } else {
            matrix.preTranslate(-fFloatValueX, -fFloatValueY);
            this.canvas.concat(matrix);
            if (!this.state.style.overflow.booleanValue()) {
                setClipRect(0.0f, 0.0f, fFloatValueX2, fFloatValueY2);
            }
        }
        boolean zPushLayer = pushLayer();
        renderChildren(marker, false);
        if (zPushLayer) {
            popLayer(marker);
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            if (svgObject.parent == null) {
                break;
            }
            svgObject = (SVG.SvgObject) svgObject.parent;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVG.SvgElementBase) it.next());
        }
        rendererState.viewBox = this.document.getRootElement().viewBox;
        if (rendererState.viewBox == null) {
            rendererState.viewBox = this.canvasViewPort;
        }
        rendererState.viewPort = this.canvasViewPort;
        rendererState.directRendering = this.state.directRendering;
        return rendererState;
    }

    private void checkForGradiantsAndPatterns(SVG.SvgElement svgElement) {
        if (this.state.style.fill instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) this.state.style.fill);
        }
        if (this.state.style.stroke instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) this.state.style.stroke);
        }
    }

    private void decodePaintReference(boolean z, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject svgObjectResolveIRI = this.document.resolveIRI(paintReference.href);
        if (svgObjectResolveIRI == null) {
            error("%s reference '%s' not found", z ? "Fill" : "Stroke", paintReference.href);
            if (paintReference.fallback != null) {
                setPaintColour(this.state, z, paintReference.fallback);
                return;
            } else if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (svgObjectResolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradiant(z, box, (SVG.SvgLinearGradient) svgObjectResolveIRI);
        }
        if (svgObjectResolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradiant(z, box, (SVG.SvgRadialGradient) svgObjectResolveIRI);
        }
        if (svgObjectResolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z, (SVG.SolidColor) svgObjectResolveIRI);
        }
    }

    private void makeLinearGradiant(boolean z, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float fFloatValue;
        float fFloatValue2;
        float f;
        float f2;
        if (svgLinearGradient.href != null) {
            fillInChainedGradientFields(svgLinearGradient, svgLinearGradient.href);
        }
        int i = 0;
        boolean z2 = svgLinearGradient.gradientUnitsAreUser != null && svgLinearGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            float fFloatValueX = svgLinearGradient.x1 != null ? svgLinearGradient.x1.floatValueX(this) : 0.0f;
            fFloatValue = svgLinearGradient.y1 != null ? svgLinearGradient.y1.floatValueY(this) : 0.0f;
            float fFloatValueX2 = svgLinearGradient.x2 != null ? svgLinearGradient.x2.floatValueX(this) : currentViewPortInUserUnits.width;
            fFloatValue2 = svgLinearGradient.y2 != null ? svgLinearGradient.y2.floatValueY(this) : 0.0f;
            f2 = fFloatValueX2;
            f = fFloatValueX;
        } else {
            float fFloatValue3 = svgLinearGradient.x1 != null ? svgLinearGradient.x1.floatValue(this, 1.0f) : 0.0f;
            fFloatValue = svgLinearGradient.y1 != null ? svgLinearGradient.y1.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue4 = svgLinearGradient.x2 != null ? svgLinearGradient.x2.floatValue(this, 1.0f) : 1.0f;
            fFloatValue2 = svgLinearGradient.y2 != null ? svgLinearGradient.y2.floatValue(this, 1.0f) : 0.0f;
            f = fFloatValue3;
            f2 = fFloatValue4;
        }
        float f3 = fFloatValue2;
        float f4 = fFloatValue;
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgLinearGradient.gradientTransform != null) {
            matrix.preConcat(svgLinearGradient.gradientTransform);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgLinearGradient.children.iterator();
        float fFloatValue5 = -1.0f;
        while (it.hasNext()) {
            int[] iArr2 = iArr;
            float[] fArr2 = fArr;
            SVG.Stop stop = (SVG.Stop) it.next();
            if (i == 0 || stop.offset.floatValue() >= fFloatValue5) {
                fArr2[i] = stop.offset.floatValue();
                fFloatValue5 = stop.offset.floatValue();
            } else {
                fArr2[i] = fFloatValue5;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr2[i] = colour.colour | (clamp255(this.state.style.stopOpacity.floatValue()) << 24);
            i++;
            statePop();
            iArr = iArr2;
            fArr = fArr2;
        }
        if ((f == f2 && f4 == f3) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgLinearGradient.spreadMethod != null) {
            if (svgLinearGradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgLinearGradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        LinearGradient linearGradient = new LinearGradient(f, f4, f2, f3, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private void makeRadialGradiant(boolean z, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f;
        float fFloatValue;
        float f2;
        if (svgRadialGradient.href != null) {
            fillInChainedGradientFields(svgRadialGradient, svgRadialGradient.href);
        }
        int i = 0;
        boolean z2 = svgRadialGradient.gradientUnitsAreUser != null && svgRadialGradient.gradientUnitsAreUser.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
        if (z2) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            float fFloatValueX = svgRadialGradient.cx != null ? svgRadialGradient.cx.floatValueX(this) : length.floatValueX(this);
            float fFloatValueY = svgRadialGradient.cy != null ? svgRadialGradient.cy.floatValueY(this) : length.floatValueY(this);
            if (svgRadialGradient.r != null) {
                length = svgRadialGradient.r;
            }
            fFloatValue = length.floatValue(this);
            f = fFloatValueX;
            f2 = fFloatValueY;
        } else {
            float fFloatValue2 = svgRadialGradient.cx != null ? svgRadialGradient.cx.floatValue(this, 1.0f) : 0.5f;
            float fFloatValue3 = svgRadialGradient.cy != null ? svgRadialGradient.cy.floatValue(this, 1.0f) : 0.5f;
            f = fFloatValue2;
            fFloatValue = svgRadialGradient.r != null ? svgRadialGradient.r.floatValue(this, 1.0f) : 0.5f;
            f2 = fFloatValue3;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        if (svgRadialGradient.gradientTransform != null) {
            matrix.preConcat(svgRadialGradient.gradientTransform);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgRadialGradient.children.iterator();
        float fFloatValue4 = -1.0f;
        while (it.hasNext()) {
            float[] fArr2 = fArr;
            SVG.Stop stop = (SVG.Stop) it.next();
            if (i == 0 || stop.offset.floatValue() >= fFloatValue4) {
                fArr2[i] = stop.offset.floatValue();
                fFloatValue4 = stop.offset.floatValue();
            } else {
                fArr2[i] = fFloatValue4;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Colour colour = (SVG.Colour) this.state.style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i] = colour.colour | (clamp255(this.state.style.stopOpacity.floatValue()) << 24);
            i++;
            statePop();
            fArr = fArr2;
        }
        if (fFloatValue == 0.0f || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (svgRadialGradient.spreadMethod != null) {
            if (svgRadialGradient.spreadMethod == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (svgRadialGradient.spreadMethod == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        RadialGradient radialGradient = new RadialGradient(f, f2, fFloatValue, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject svgObjectResolveIRI = gradientElement.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) svgObjectResolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) svgObjectResolveIRI);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) svgObjectResolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        if (gradientElement2.href != null) {
            fillInChainedGradientFields(gradientElement, gradientElement2.href);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.x1 == null) {
            svgLinearGradient.x1 = svgLinearGradient2.x1;
        }
        if (svgLinearGradient.y1 == null) {
            svgLinearGradient.y1 = svgLinearGradient2.y1;
        }
        if (svgLinearGradient.x2 == null) {
            svgLinearGradient.x2 = svgLinearGradient2.x2;
        }
        if (svgLinearGradient.y2 == null) {
            svgLinearGradient.y2 = svgLinearGradient2.y2;
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.r == null) {
            svgRadialGradient.r = svgRadialGradient2.r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
    }

    private void setSolidColor(boolean z, SVG.SolidColor solidColor) {
        if (z) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                this.state.style.fill = solidColor.baseStyle.solidColor;
                this.state.hasFill = solidColor.baseStyle.solidColor != null;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState = this.state;
                setPaintColour(rendererState, z, rendererState.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            this.state.style.stroke = solidColor.baseStyle.solidColor;
            this.state.hasStroke = solidColor.baseStyle.solidColor != null;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState2 = this.state;
            setPaintColour(rendererState2, z, rendererState2.style.stroke);
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.clipPath == null) {
            return;
        }
        SVG.SvgObject svgObjectResolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (svgObjectResolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) svgObjectResolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        boolean z = clipPath.clipPathUnitsAreUser == null || clipPath.clipPathUnitsAreUser.booleanValue();
        if ((svgElement instanceof SVG.Group) && !z) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getClass().getSimpleName());
            return;
        }
        clipStatePush();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
            this.canvas.concat(matrix);
        }
        if (clipPath.transform != null) {
            this.canvas.concat(clipPath.transform);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path path = new Path();
        Iterator<SVG.SvgObject> it = clipPath.children.iterator();
        while (it.hasNext()) {
            addObjectToClip(it.next(), true, path, new Matrix());
        }
        this.canvas.clipPath(path);
        clipStatePop();
    }

    private void addObjectToClip(SVG.SvgObject svgObject, boolean z, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVG.Use) {
                if (z) {
                    addObjectToClip((SVG.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVG.Path) {
                addObjectToClip((SVG.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.Text) {
                addObjectToClip((SVG.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.GraphicsElement) {
                addObjectToClip((SVG.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.getClass().getSimpleName());
            }
            clipStatePop();
        }
    }

    private void clipStatePush() {
        this.canvas.save(1);
        this.stateStack.push(this.state);
        this.state = (RendererState) this.state.clone();
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule == null) {
            return Path.FillType.WINDING;
        }
        if ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule()[this.state.style.clipRule.ordinal()] == 2) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void addObjectToClip(SVG.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            if (path.transform != null) {
                matrix.preConcat(path.transform);
            }
            Path path3 = new PathConverter(path.d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void addObjectToClip(SVG.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path pathMakePathAndBoundingBox;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            if (graphicsElement.transform != null) {
                matrix.preConcat(graphicsElement.transform);
            }
            if (graphicsElement instanceof SVG.Rect) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVG.Circle) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVG.Ellipse) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Ellipse) graphicsElement);
            } else if (!(graphicsElement instanceof SVG.PolyLine)) {
                return;
            } else {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.PolyLine) graphicsElement);
            }
            checkForClipPath(graphicsElement);
            path.setFillType(pathMakePathAndBoundingBox.getFillType());
            path.addPath(pathMakePathAndBoundingBox, matrix);
        }
    }

    private void addObjectToClip(SVG.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            if (use.transform != null) {
                matrix.preConcat(use.transform);
            }
            SVG.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
            if (svgObjectResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
            } else {
                checkForClipPath(use);
                addObjectToClip(svgObjectResolveIRI, false, path, matrix);
            }
        }
    }

    private void addObjectToClip(SVG.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            if (text.transform != null) {
                matrix.preConcat(text.transform);
            }
            float fFloatValueY = 0.0f;
            float fFloatValueX = (text.x == null || text.x.size() == 0) ? 0.0f : text.x.get(0).floatValueX(this);
            float fFloatValueY2 = (text.y == null || text.y.size() == 0) ? 0.0f : text.y.get(0).floatValueY(this);
            float fFloatValueX2 = (text.dx == null || text.dx.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            if (text.dy != null && text.dy.size() != 0) {
                fFloatValueY = text.dy.get(0).floatValueY(this);
            }
            if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
                float fCalculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                    fCalculateTextWidth /= 2.0f;
                }
                fFloatValueX -= fCalculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(fFloatValueX, fFloatValueY2);
                enumerateTextSpans(text, textBoundsCalculator);
                text.boundingBox = new SVG.Box(textBoundsCalculator.bbox.left, textBoundsCalculator.bbox.top, textBoundsCalculator.bbox.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    private class PlainTextToPath extends TextProcessor {
        public Path textAsPath;
        public float x;
        public float y;

        public PlainTextToPath(float f, float f2, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.x = f;
            this.y = f2;
            this.textAsPath = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            String str2;
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                str2 = str;
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str2, 0, str.length(), this.x, this.y, path);
                this.textAsPath.addPath(path);
            } else {
                str2 = str;
            }
            this.x += SVGAndroidRenderer.this.state.fillPaint.measureText(str2);
        }
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        float fFloatValueX = line.x1 == null ? 0.0f : line.x1.floatValueX(this);
        float fFloatValueY = line.y1 == null ? 0.0f : line.y1.floatValueY(this);
        float fFloatValueX2 = line.x2 == null ? 0.0f : line.x2.floatValueX(this);
        float fFloatValueY2 = line.y2 != null ? line.y2.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(fFloatValueX, fFloatValueY), Math.min(fFloatValueY, fFloatValueY2), Math.abs(fFloatValueX2 - fFloatValueX), Math.abs(fFloatValueY2 - fFloatValueY));
        }
        Path path = new Path();
        path.moveTo(fFloatValueX, fFloatValueY);
        path.lineTo(fFloatValueX2, fFloatValueY2);
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Rect rect) {
        float fFloatValueX;
        float fFloatValueY;
        if (rect.rx == null && rect.ry == null) {
            fFloatValueX = 0.0f;
            fFloatValueY = 0.0f;
        } else {
            if (rect.rx == null) {
                fFloatValueX = rect.ry.floatValueY(this);
            } else if (rect.ry == null) {
                fFloatValueX = rect.rx.floatValueX(this);
            } else {
                fFloatValueX = rect.rx.floatValueX(this);
                fFloatValueY = rect.ry.floatValueY(this);
            }
            fFloatValueY = fFloatValueX;
        }
        float fMin = Math.min(fFloatValueX, rect.width.floatValueX(this) / 2.0f);
        float fMin2 = Math.min(fFloatValueY, rect.height.floatValueY(this) / 2.0f);
        float fFloatValueX2 = rect.x != null ? rect.x.floatValueX(this) : 0.0f;
        float fFloatValueY2 = rect.y != null ? rect.y.floatValueY(this) : 0.0f;
        float fFloatValueX3 = rect.width.floatValueX(this);
        float fFloatValueY3 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
            rect.boundingBox = new SVG.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueY3);
        }
        float f = fFloatValueX3 + fFloatValueX2;
        float f2 = fFloatValueY2 + fFloatValueY3;
        Path path = new Path();
        if (fMin == 0.0f || fMin2 == 0.0f) {
            path.moveTo(fFloatValueX2, fFloatValueY2);
            path.lineTo(f, fFloatValueY2);
            path.lineTo(f, f2);
            path.lineTo(fFloatValueX2, f2);
            path.lineTo(fFloatValueX2, fFloatValueY2);
        } else {
            float f3 = fMin * BEZIER_ARC_FACTOR;
            float f4 = BEZIER_ARC_FACTOR * fMin2;
            float f5 = fFloatValueY2 + fMin2;
            path.moveTo(fFloatValueX2, f5);
            float f6 = f5 - f4;
            float f7 = fFloatValueX2 + fMin;
            float f8 = f7 - f3;
            path.cubicTo(fFloatValueX2, f6, f8, fFloatValueY2, f7, fFloatValueY2);
            float f9 = f - fMin;
            path.lineTo(f9, fFloatValueY2);
            float f10 = f9 + f3;
            path.cubicTo(f10, fFloatValueY2, f, f6, f, f5);
            float f11 = f2 - fMin2;
            path.lineTo(f, f11);
            float f12 = f11 + f4;
            path.cubicTo(f, f12, f10, f2, f9, f2);
            path.lineTo(f7, f2);
            float f13 = fFloatValueX2;
            path.cubicTo(f8, f2, f13, f12, fFloatValueX2, f11);
            path.lineTo(f13, f5);
        }
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        float fFloatValueX = circle.cx != null ? circle.cx.floatValueX(this) : 0.0f;
        float fFloatValueY = circle.cy != null ? circle.cy.floatValueY(this) : 0.0f;
        float fFloatValue = circle.r.floatValue(this);
        float f = fFloatValueX - fFloatValue;
        float f2 = fFloatValueY - fFloatValue;
        float f3 = fFloatValueX + fFloatValue;
        float f4 = fFloatValueY + fFloatValue;
        if (circle.boundingBox == null) {
            float f5 = 2.0f * fFloatValue;
            circle.boundingBox = new SVG.Box(f, f2, f5, f5);
        }
        float f6 = fFloatValue * BEZIER_ARC_FACTOR;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f6;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = fFloatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f6;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        float fFloatValueX = ellipse.cx != null ? ellipse.cx.floatValueX(this) : 0.0f;
        float fFloatValueY = ellipse.cy != null ? ellipse.cy.floatValueY(this) : 0.0f;
        float fFloatValueX2 = ellipse.rx.floatValueX(this);
        float fFloatValueY2 = ellipse.ry.floatValueY(this);
        float f = fFloatValueX - fFloatValueX2;
        float f2 = fFloatValueY - fFloatValueY2;
        float f3 = fFloatValueX + fFloatValueX2;
        float f4 = fFloatValueY + fFloatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f, f2, fFloatValueX2 * 2.0f, 2.0f * fFloatValueY2);
        }
        float f5 = fFloatValueX2 * BEZIER_ARC_FACTOR;
        float f6 = fFloatValueY2 * BEZIER_ARC_FACTOR;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f5;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = fFloatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f5;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        path.moveTo(polyLine.points[0], polyLine.points[1]);
        for (int i = 2; i < polyLine.points.length; i += 2) {
            path.lineTo(polyLine.points[i], polyLine.points[i + 1]);
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        path.setFillType(getClipRuleFromState());
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fillWithPattern(SVG.SvgElement svgElement, Path path, SVG.Pattern pattern) {
        float fFloatValueX;
        float fFloatValueY;
        float fFloatValueY2;
        float fFloatValueX2;
        float f;
        boolean z = pattern.patternUnitsAreUser != null && pattern.patternUnitsAreUser.booleanValue();
        if (pattern.href != null) {
            fillInChainedPatternFields(pattern, pattern.href);
        }
        if (z) {
            fFloatValueX = pattern.x != null ? pattern.x.floatValueX(this) : 0.0f;
            fFloatValueY2 = pattern.y != null ? pattern.y.floatValueY(this) : 0.0f;
            fFloatValueX2 = pattern.width != null ? pattern.width.floatValueX(this) : 0.0f;
            fFloatValueY = pattern.height != null ? pattern.height.floatValueY(this) : 0.0f;
        } else {
            float fFloatValue = pattern.x != null ? pattern.x.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue2 = pattern.y != null ? pattern.y.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue3 = pattern.width != null ? pattern.width.floatValue(this, 1.0f) : 0.0f;
            float fFloatValue4 = pattern.height != null ? pattern.height.floatValue(this, 1.0f) : 0.0f;
            fFloatValueX = (fFloatValue * svgElement.boundingBox.width) + svgElement.boundingBox.minX;
            float f2 = (fFloatValue2 * svgElement.boundingBox.height) + svgElement.boundingBox.minY;
            float f3 = fFloatValue3 * svgElement.boundingBox.width;
            fFloatValueY = fFloatValue4 * svgElement.boundingBox.height;
            fFloatValueY2 = f2;
            fFloatValueX2 = f3;
        }
        if (fFloatValueX2 == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = pattern.preserveAspectRatio != null ? pattern.preserveAspectRatio : PreserveAspectRatio.LETTERBOX;
        statePush();
        this.canvas.clipPath(path);
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        rendererState.style.overflow = false;
        this.state = findInheritFromAncestorState(pattern, rendererState);
        SVG.Box box = svgElement.boundingBox;
        if (pattern.patternTransform != null) {
            this.canvas.concat(pattern.patternTransform);
            Matrix matrix = new Matrix();
            if (pattern.patternTransform.invert(matrix)) {
                f = fFloatValueX;
                float[] fArr = {svgElement.boundingBox.minX, svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.minY, svgElement.boundingBox.maxX(), svgElement.boundingBox.maxY(), svgElement.boundingBox.minX, svgElement.boundingBox.maxY()};
                matrix.mapPoints(fArr);
                float f4 = fArr[0];
                float f5 = fArr[1];
                RectF rectF = new RectF(f4, f5, f4, f5);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                box = new SVG.Box(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
            } else {
                f = fFloatValueX;
            }
        }
        float fFloor = f + (((float) Math.floor((box.minX - f) / fFloatValueX2)) * fFloatValueX2);
        float fMaxX = box.maxX();
        float fMaxY = box.maxY();
        SVG.Box box2 = new SVG.Box(0.0f, 0.0f, fFloatValueX2, fFloatValueY);
        for (float fFloor2 = fFloatValueY2 + (((float) Math.floor((box.minY - fFloatValueY2) / fFloatValueY)) * fFloatValueY); fFloor2 < fMaxY; fFloor2 += fFloatValueY) {
            for (float f6 = fFloor; f6 < fMaxX; f6 += fFloatValueX2) {
                box2.minX = f6;
                box2.minY = fFloor2;
                statePush();
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(box2.minX, box2.minY, box2.width, box2.height);
                }
                if (pattern.viewBox != null) {
                    this.canvas.concat(calculateViewBoxTransform(box2, pattern.viewBox, preserveAspectRatio));
                } else {
                    boolean z2 = pattern.patternContentUnitsAreUser == null || pattern.patternContentUnitsAreUser.booleanValue();
                    this.canvas.translate(f6, fFloor2);
                    if (!z2) {
                        this.canvas.scale(svgElement.boundingBox.width, svgElement.boundingBox.height);
                    }
                }
                boolean zPushLayer = pushLayer();
                Iterator<SVG.SvgObject> it = pattern.children.iterator();
                while (it.hasNext()) {
                    render(it.next());
                }
                if (zPushLayer) {
                    popLayer(pattern);
                }
                statePop();
            }
        }
        statePop();
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject svgObjectResolveIRI = pattern.document.resolveIRI(str);
        if (svgObjectResolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(svgObjectResolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (svgObjectResolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) svgObjectResolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.x == null) {
            pattern.x = pattern2.x;
        }
        if (pattern.y == null) {
            pattern.y = pattern2.y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        if (pattern2.href != null) {
            fillInChainedPatternFields(pattern, pattern2.href);
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement) {
        float fFloatValueX;
        float fFloatValueY;
        debug("Mask render", new Object[0]);
        if (mask.maskUnitsAreUser != null && mask.maskUnitsAreUser.booleanValue()) {
            fFloatValueX = mask.width != null ? mask.width.floatValueX(this) : svgElement.boundingBox.width;
            fFloatValueY = mask.height != null ? mask.height.floatValueY(this) : svgElement.boundingBox.height;
            if (mask.x != null) {
                mask.x.floatValueX(this);
            } else {
                float f = svgElement.boundingBox.minX;
                float f2 = svgElement.boundingBox.width;
            }
            if (mask.y != null) {
                mask.y.floatValueY(this);
            } else {
                float f3 = svgElement.boundingBox.minY;
                float f4 = svgElement.boundingBox.height;
            }
        } else {
            if (mask.x != null) {
                mask.x.floatValue(this, 1.0f);
            }
            if (mask.y != null) {
                mask.y.floatValue(this, 1.0f);
            }
            float fFloatValue = mask.width != null ? mask.width.floatValue(this, 1.0f) : 1.2f;
            float fFloatValue2 = mask.height != null ? mask.height.floatValue(this, 1.0f) : 1.2f;
            float f5 = svgElement.boundingBox.minX;
            float f6 = svgElement.boundingBox.width;
            float f7 = svgElement.boundingBox.minY;
            float f8 = svgElement.boundingBox.height;
            fFloatValueX = fFloatValue * svgElement.boundingBox.width;
            fFloatValueY = fFloatValue2 * svgElement.boundingBox.height;
        }
        if (fFloatValueX == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        statePush();
        RendererState rendererStateFindInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = rendererStateFindInheritFromAncestorState;
        rendererStateFindInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        if (mask.maskContentUnitsAreUser != null && !mask.maskContentUnitsAreUser.booleanValue()) {
            this.canvas.translate(svgElement.boundingBox.minX, svgElement.boundingBox.minY);
            this.canvas.scale(svgElement.boundingBox.width, svgElement.boundingBox.height);
        }
        renderChildren(mask, false);
        statePop();
    }
}
