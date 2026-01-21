package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<PointF>) keyframe, f);
    }

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        float f2;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = keyframe.startValue;
        PointF pointF2 = keyframe.endValue;
        if (this.valueCallback != null) {
            f2 = f;
            PointF pointF3 = (PointF) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF, pointF2, f2, getLinearCurrentKeyframeProgress(), getProgress());
            if (pointF3 != null) {
                return pointF3;
            }
        } else {
            f2 = f;
        }
        this.point.set(pointF.x + ((pointF2.x - pointF.x) * f2), pointF.y + ((pointF2.y - pointF.y) * f2));
        return this.point;
    }
}
