package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            sb.append("<");
            sb.append(next);
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            wrapDimension = wrapDimension + r4.start.margin + this.widgets.get(i).getWrapDimension() + r4.end.margin;
        }
        return wrapDimension;
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.orientation == 0) {
                next.widget.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        float f;
        int i3;
        int i4;
        int i5;
        float f2;
        boolean z;
        int i6;
        int i7;
        float f3;
        int i8;
        int i9;
        float f4;
        int i10;
        int i11;
        int i12;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i13 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i14 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i14 >= size) {
                    i14 = -1;
                    break;
                } else if (this.widgets.get(i14).widget.getVisibility() != 8) {
                    break;
                } else {
                    i14++;
                }
            }
            int i15 = size - 1;
            int i16 = i15;
            while (true) {
                if (i16 < 0) {
                    break;
                }
                if (this.widgets.get(i16).widget.getVisibility() != 8) {
                    i = i16;
                    break;
                }
                i16--;
            }
            int i17 = 0;
            while (i17 < 2) {
                int i18 = 0;
                i4 = 0;
                i5 = 0;
                int i19 = 0;
                f2 = 0.0f;
                while (i18 < size) {
                    WidgetRun widgetRun = this.widgets.get(i18);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i19++;
                        if (i18 > 0 && i18 >= i14) {
                            i4 += widgetRun.start.margin;
                        }
                        int i20 = widgetRun.dimension.value;
                        boolean z2 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z2) {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        } else {
                            if (widgetRun.matchConstraintsType == 1 && i17 == 0) {
                                i20 = widgetRun.dimension.wrapValue;
                                i5++;
                            } else if (widgetRun.dimension.resolved) {
                            }
                            z2 = true;
                        }
                        if (z2) {
                            i4 += i20;
                        } else {
                            i5++;
                            float f5 = widgetRun.widget.mWeight[this.orientation];
                            if (f5 >= 0.0f) {
                                f2 += f5;
                            }
                        }
                        if (i18 < i15 && i18 < i) {
                            i4 += -widgetRun.end.margin;
                        }
                    }
                    i18++;
                    i2 = 8;
                }
                f = 0.0f;
                if (i4 < i13 || i5 == 0) {
                    i3 = i19;
                    break;
                } else {
                    i17++;
                    i2 = 8;
                }
            }
            f = 0.0f;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f2 = 0.0f;
            int i21 = this.start.value;
            if (zIsRtl) {
                i21 = this.end.value;
            }
            if (i4 > i13) {
                i21 = zIsRtl ? i21 + ((int) (((i4 - i13) / 2.0f) + 0.5f)) : i21 - ((int) (((i4 - i13) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f6 = i13 - i4;
                int i22 = (int) ((f6 / i5) + 0.5f);
                int i23 = 0;
                int i24 = 0;
                while (i23 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i23);
                    boolean z3 = zIsRtl;
                    if (widgetRun2.widget.getVisibility() == 8 || widgetRun2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.dimension.resolved) {
                        i9 = i21;
                        f4 = f6;
                        i10 = i22;
                    } else {
                        int i25 = f2 > f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f6) / f2) + 0.5f) : i22;
                        if (this.orientation == 0) {
                            i11 = widgetRun2.widget.mMatchConstraintMaxWidth;
                            i9 = i21;
                            i12 = widgetRun2.widget.mMatchConstraintMinWidth;
                        } else {
                            i9 = i21;
                            i11 = widgetRun2.widget.mMatchConstraintMaxHeight;
                            i12 = widgetRun2.widget.mMatchConstraintMinHeight;
                        }
                        f4 = f6;
                        i10 = i22;
                        int iMax = Math.max(i12, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                        if (i11 > 0) {
                            iMax = Math.min(i11, iMax);
                        }
                        if (iMax != i25) {
                            i24++;
                            i25 = iMax;
                        }
                        widgetRun2.dimension.resolve(i25);
                    }
                    i23++;
                    zIsRtl = z3;
                    i21 = i9;
                    f6 = f4;
                    i22 = i10;
                }
                z = zIsRtl;
                i6 = i21;
                f3 = 0.5f;
                if (i24 > 0) {
                    i5 -= i24;
                    int i26 = 0;
                    for (int i27 = 0; i27 < size; i27++) {
                        WidgetRun widgetRun3 = this.widgets.get(i27);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i27 > 0 && i27 >= i14) {
                                i26 += widgetRun3.start.margin;
                            }
                            i26 += widgetRun3.dimension.value;
                            if (i27 < i15 && i27 < i) {
                                i26 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i26;
                }
                i7 = 2;
                if (this.chainStyle == 2 && i24 == 0) {
                    this.chainStyle = 0;
                }
            } else {
                z = zIsRtl;
                i6 = i21;
                i7 = 2;
                f3 = 0.5f;
            }
            if (i4 > i13) {
                this.chainStyle = i7;
            }
            if (i3 > 0 && i5 == 0 && i14 == i) {
                this.chainStyle = i7;
            }
            int i28 = this.chainStyle;
            if (i28 == 1) {
                if (i3 > 1) {
                    i8 = (i13 - i4) / (i3 - 1);
                } else {
                    i8 = i3 == 1 ? (i13 - i4) / 2 : 0;
                }
                if (i5 > 0) {
                    i8 = 0;
                }
                int i29 = i6;
                for (int i30 = 0; i30 < size; i30++) {
                    WidgetRun widgetRun4 = this.widgets.get(z ? size - (i30 + 1) : i30);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i29);
                        widgetRun4.end.resolve(i29);
                    } else {
                        if (i30 > 0) {
                            i29 = z ? i29 - i8 : i29 + i8;
                        }
                        if (i30 > 0 && i30 >= i14) {
                            if (z) {
                                i29 -= widgetRun4.start.margin;
                            } else {
                                i29 += widgetRun4.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun4.end.resolve(i29);
                        } else {
                            widgetRun4.start.resolve(i29);
                        }
                        int i31 = widgetRun4.dimension.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i31 = widgetRun4.dimension.wrapValue;
                        }
                        i29 = z ? i29 - i31 : i29 + i31;
                        if (z) {
                            widgetRun4.start.resolve(i29);
                        } else {
                            widgetRun4.end.resolve(i29);
                        }
                        widgetRun4.resolved = true;
                        if (i30 < i15 && i30 < i) {
                            if (z) {
                                i29 -= -widgetRun4.end.margin;
                            } else {
                                i29 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            if (i28 == 0) {
                int i32 = (i13 - i4) / (i3 + 1);
                if (i5 > 0) {
                    i32 = 0;
                }
                int i33 = i6;
                for (int i34 = 0; i34 < size; i34++) {
                    WidgetRun widgetRun5 = this.widgets.get(z ? size - (i34 + 1) : i34);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i33);
                        widgetRun5.end.resolve(i33);
                    } else {
                        int i35 = z ? i33 - i32 : i33 + i32;
                        if (i34 > 0 && i34 >= i14) {
                            if (z) {
                                i35 -= widgetRun5.start.margin;
                            } else {
                                i35 += widgetRun5.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun5.end.resolve(i35);
                        } else {
                            widgetRun5.start.resolve(i35);
                        }
                        int iMin = widgetRun5.dimension.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, widgetRun5.dimension.wrapValue);
                        }
                        i33 = z ? i35 - iMin : i35 + iMin;
                        if (z) {
                            widgetRun5.start.resolve(i33);
                        } else {
                            widgetRun5.end.resolve(i33);
                        }
                        if (i34 < i15 && i34 < i) {
                            if (z) {
                                i33 -= -widgetRun5.end.margin;
                            } else {
                                i33 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            if (i28 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i36 = (int) (((i13 - i4) * horizontalBiasPercent) + f3);
                if (i36 < 0 || i5 > 0) {
                    i36 = 0;
                }
                int i37 = z ? i6 - i36 : i6 + i36;
                for (int i38 = 0; i38 < size; i38++) {
                    WidgetRun widgetRun6 = this.widgets.get(z ? size - (i38 + 1) : i38);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i37);
                        widgetRun6.end.resolve(i37);
                    } else {
                        if (i38 > 0 && i38 >= i14) {
                            if (z) {
                                i37 -= widgetRun6.start.margin;
                            } else {
                                i37 += widgetRun6.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun6.end.resolve(i37);
                        } else {
                            widgetRun6.start.resolve(i37);
                        }
                        int i39 = widgetRun6.dimension.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i39 = widgetRun6.dimension.wrapValue;
                        }
                        i37 = z ? i37 - i39 : i37 + i39;
                        if (z) {
                            widgetRun6.start.resolve(i37);
                        } else {
                            widgetRun6.end.resolve(i37);
                        }
                        if (i38 < i15 && i38 < i) {
                            if (z) {
                                i37 -= -widgetRun6.end.margin;
                            } else {
                                i37 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }
}
