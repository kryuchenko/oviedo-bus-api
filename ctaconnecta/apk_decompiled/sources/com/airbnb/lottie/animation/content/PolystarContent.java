package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final PolystarShape.Type type;
    private final Path path = new Path();
    private CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        this.hidden = polystarShape.isHidden();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = baseKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = baseKeyframeAnimationCreateAnimation3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = baseKeyframeAnimationCreateAnimation4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = baseKeyframeAnimationCreateAnimation5;
        if (type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation3);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation4);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation5);
        if (type == PolystarShape.Type.STAR) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation5.addUpdateListener(this);
        if (type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        int i;
        float f;
        float f2;
        float fCos;
        float fSin;
        float f3;
        float f4;
        double d;
        float f5;
        int i2;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        float f9;
        float f10;
        float fFloatValue = this.pointsAnimation.getValue().floatValue();
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f11 = (float) (6.283185307179586d / d4);
        float f12 = f11 / 2.0f;
        float f13 = fFloatValue - ((int) fFloatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float fFloatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.innerRoundednessAnimation;
        float fFloatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.outerRoundednessAnimation;
        float fFloatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f5 = ((fFloatValue2 - fFloatValue3) * f13) + fFloatValue3;
            i = i3;
            f = 0.0f;
            double d5 = f5;
            f2 = 2.0f;
            float fCos2 = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.path.moveTo(fCos2, fSin);
            d = radians + ((f11 * f13) / 2.0f);
            f3 = f13;
            fCos = fCos2;
            f4 = f12;
        } else {
            i = i3;
            f = 0.0f;
            f2 = 2.0f;
            double d6 = fFloatValue2;
            fCos = (float) (Math.cos(radians) * d6);
            fSin = (float) (d6 * Math.sin(radians));
            this.path.moveTo(fCos, fSin);
            f3 = f13;
            f4 = f12;
            d = radians + f4;
            f5 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        boolean z = false;
        double d7 = d;
        float f14 = fSin;
        float f15 = fCos;
        double d8 = d7;
        while (true) {
            double d9 = i4;
            if (d9 < dCeil) {
                float f16 = z ? fFloatValue2 : fFloatValue3;
                if (f5 == f || d9 != dCeil - 2.0d) {
                    i2 = i4;
                    f6 = f4;
                } else {
                    i2 = i4;
                    f6 = (f11 * f3) / f2;
                }
                if (f5 == f || d9 != dCeil - 1.0d) {
                    d2 = d9;
                    f7 = f16;
                } else {
                    d2 = d9;
                    f7 = f5;
                }
                double d10 = f7;
                float fCos3 = (float) (d10 * Math.cos(d8));
                float f17 = f11;
                float fSin2 = (float) (d10 * Math.sin(d8));
                if (fFloatValue4 == f && fFloatValue5 == f) {
                    this.path.lineTo(fCos3, fSin2);
                    f10 = fCos3;
                    f9 = fSin2;
                    f8 = f4;
                    d3 = d8;
                } else {
                    f8 = f4;
                    d3 = d8;
                    double dAtan2 = (float) (Math.atan2(f14, f15) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    float f18 = f15;
                    float f19 = f14;
                    f9 = fSin2;
                    double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin4 = (float) Math.sin(dAtan22);
                    float f20 = z ? fFloatValue4 : fFloatValue5;
                    float f21 = z ? fFloatValue5 : fFloatValue4;
                    float f22 = z ? fFloatValue3 : fFloatValue2;
                    float f23 = z ? fFloatValue2 : fFloatValue3;
                    float f24 = f22 * f20 * POLYSTAR_MAGIC_NUMBER;
                    float f25 = fCos4 * f24;
                    float f26 = f24 * fSin3;
                    float f27 = f23 * f21 * POLYSTAR_MAGIC_NUMBER;
                    float f28 = fCos5 * f27;
                    float f29 = f27 * fSin4;
                    if (i != 0) {
                        if (i2 == 0) {
                            f25 *= f3;
                            f26 *= f3;
                        } else if (d2 == dCeil - 1.0d) {
                            f28 *= f3;
                            f29 *= f3;
                        }
                    }
                    f10 = fCos3;
                    this.path.cubicTo(f18 - f25, f19 - f26, fCos3 + f28, f9 + f29, f10, f9);
                }
                d8 = d3 + f6;
                z = !z;
                i4 = i2 + 1;
                f4 = f8;
                f15 = f10;
                f14 = f9;
                f11 = f17;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void createPolygonPath() {
        double d;
        int iFloor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        double radians = Math.toRadians((this.rotationAnimation == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        this.path.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double d5 = radians + d4;
        double dCeil = Math.ceil(d2);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d5) * d3);
            int i2 = i;
            double d6 = d5;
            float fSin2 = (float) (d3 * Math.sin(d5));
            if (fFloatValue != 0.0f) {
                d = dCeil;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan22);
                float fSin4 = (float) Math.sin(dAtan22);
                float f = fFloatValue2 * fFloatValue * POLYGON_MAGIC_NUMBER;
                this.path.cubicTo(fCos - (f * fCos3), fSin - (f * fSin3), fCos2 + (fCos4 * f), fSin2 + (f * fSin4), fCos2, fSin2);
                fCos = fCos2;
                fSin = fSin2;
            } else {
                fSin = fSin2;
                d = dCeil;
                fCos = fCos2;
                this.path.lineTo(fCos, fSin);
            }
            d5 = d6 + d4;
            i = i2 + 1;
            dCeil = d;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }
}
