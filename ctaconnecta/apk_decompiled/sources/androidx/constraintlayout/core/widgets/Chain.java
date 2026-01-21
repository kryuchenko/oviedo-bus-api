package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[PHI: r14 r15
      0x004c: PHI (r14v3 boolean) = (r14v1 boolean), (r14v33 boolean) binds: [B:28:0x004a, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r15v3 boolean) = (r15v1 boolean), (r15v8 boolean) binds: [B:28:0x004a, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e A[PHI: r14 r15
      0x004e: PHI (r14v30 boolean) = (r14v1 boolean), (r14v33 boolean) binds: [B:28:0x004a, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]
      0x004e: PHI (r15v5 boolean) = (r15v1 boolean), (r15v8 boolean) binds: [B:28:0x004a, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r4v36, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        LinearSystem linearSystem2;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor2;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i3;
        SolverVariable solverVariable4;
        float f;
        int size;
        ArrayList<ConstraintWidget> arrayList;
        float f2;
        float f3;
        boolean z4;
        boolean z5;
        int i4;
        int i5 = i;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f4 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget11 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget12 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i5] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i5 == 0) {
            z = constraintWidget10.mHorizontalChainStyle == 0;
            z2 = constraintWidget10.mHorizontalChainStyle == 1;
            z3 = constraintWidget10.mHorizontalChainStyle == 2;
        } else {
            z = constraintWidget10.mVerticalChainStyle == 0;
            z2 = constraintWidget10.mVerticalChainStyle == 1;
            if (constraintWidget10.mVerticalChainStyle == 2) {
            }
        }
        ?? r7 = constraintWidget6;
        boolean z7 = false;
        while (true) {
            if (z7) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = r7.mListAnchors[i2];
            int i6 = z3 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            boolean z8 = z6;
            boolean z9 = z3;
            boolean z10 = r7.mListDimensionBehaviors[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && r7.mResolvedMatchConstraintDefault[i5] == 0;
            if (constraintAnchor3.mTarget != null && r7 != constraintWidget6) {
                margin += constraintAnchor3.mTarget.getMargin();
            }
            int i7 = margin;
            if (z9 && r7 != constraintWidget6 && r7 != constraintWidget8) {
                i6 = 8;
            }
            boolean z11 = z10;
            if (constraintAnchor3.mTarget != null) {
                if (r7 == constraintWidget8) {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i7, 6);
                } else {
                    z4 = z7;
                    z5 = z;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i7, 8);
                }
                if (z11 && !z9) {
                    i6 = 5;
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i7, (r7 == constraintWidget8 && z9 && r7.isInBarrier(i5)) ? 5 : i6);
            } else {
                z4 = z7;
                z5 = z;
            }
            if (z8) {
                if (r7.getVisibility() == 8 || r7.mListDimensionBehaviors[i5] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4 = 0;
                } else {
                    i4 = 0;
                    linearSystem.addGreaterThan(r7.mListAnchors[i2 + 1].mSolverVariable, r7.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r7.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i4, 8);
            }
            ConstraintAnchor constraintAnchor4 = r7.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor4 != null) {
                ?? r4 = constraintAnchor4.mOwner;
                if (r4.mListAnchors[i2].mTarget != null && r4.mListAnchors[i2].mTarget.mOwner == r7) {
                    solverVariable = r4;
                }
            }
            if (solverVariable != null) {
                r7 = solverVariable;
                z7 = z4;
            } else {
                z7 = true;
            }
            z6 = z8;
            z3 = z9;
            z = z5;
            r7 = r7;
        }
        boolean z12 = z6;
        boolean z13 = z3;
        boolean z14 = z;
        if (constraintWidget9 != null) {
            int i8 = i2 + 1;
            if (constraintWidget7.mListAnchors[i8].mTarget != null) {
                ConstraintAnchor constraintAnchor5 = constraintWidget9.mListAnchors[i8];
                if (constraintWidget9.mListDimensionBehaviors[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget9.mResolvedMatchConstraintDefault[i5] == 0 && !z13 && constraintAnchor5.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 5);
                } else if (z13 && constraintAnchor5.mTarget.mOwner == constraintWidgetContainer) {
                    linearSystem.addEquality(constraintAnchor5.mSolverVariable, constraintAnchor5.mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 4);
                }
                linearSystem.addLowerThan(constraintAnchor5.mSolverVariable, constraintWidget7.mListAnchors[i8].mTarget.mSolverVariable, -constraintAnchor5.getMargin(), 6);
            }
        }
        if (z12) {
            int i9 = i2 + 1;
            linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i9].mSolverVariable, constraintWidget7.mListAnchors[i9].mSolverVariable, constraintWidget7.mListAnchors[i9].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget13 = null;
            int i10 = 0;
            float f7 = 0.0f;
            while (i10 < size) {
                ConstraintWidget constraintWidget14 = arrayList2.get(i10);
                float f8 = constraintWidget14.mWeight[i5];
                if (f8 >= f6) {
                    arrayList = arrayList2;
                    f2 = 0.0f;
                    f3 = f8;
                } else if (chainHead.mHasComplexMatchWeights) {
                    arrayList = arrayList2;
                    linearSystem.addEquality(constraintWidget14.mListAnchors[i2 + 1].mSolverVariable, constraintWidget14.mListAnchors[i2].mSolverVariable, 0, 4);
                    i10++;
                    arrayList2 = arrayList;
                    f6 = 0.0f;
                } else {
                    arrayList = arrayList2;
                    f2 = 0.0f;
                    f3 = 1.0f;
                }
                if (f3 == f2) {
                    linearSystem.addEquality(constraintWidget14.mListAnchors[i2 + 1].mSolverVariable, constraintWidget14.mListAnchors[i2].mSolverVariable, 0, 8);
                } else {
                    if (constraintWidget13 != null) {
                        SolverVariable solverVariable5 = constraintWidget13.mListAnchors[i2].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr = constraintWidget13.mListAnchors;
                        int i11 = i2 + 1;
                        SolverVariable solverVariable6 = constraintAnchorArr[i11].mSolverVariable;
                        SolverVariable solverVariable7 = constraintWidget14.mListAnchors[i2].mSolverVariable;
                        SolverVariable solverVariable8 = constraintWidget14.mListAnchors[i11].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f3, solverVariable5, solverVariable6, solverVariable7, solverVariable8);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget13 = constraintWidget14;
                    f7 = f3;
                }
                i10++;
                arrayList2 = arrayList;
                f6 = 0.0f;
            }
        }
        if (constraintWidget8 != null && (constraintWidget8 == constraintWidget9 || z13)) {
            ConstraintAnchor constraintAnchor6 = constraintWidget6.mListAnchors[i2];
            int i12 = i2 + 1;
            ConstraintAnchor constraintAnchor7 = constraintWidget7.mListAnchors[i12];
            SolverVariable solverVariable9 = constraintAnchor6.mTarget != null ? constraintAnchor6.mTarget.mSolverVariable : null;
            SolverVariable solverVariable10 = constraintAnchor7.mTarget != null ? constraintAnchor7.mTarget.mSolverVariable : null;
            ConstraintAnchor constraintAnchor8 = constraintWidget8.mListAnchors[i2];
            if (constraintWidget9 != null) {
                constraintAnchor7 = constraintWidget9.mListAnchors[i12];
            }
            if (solverVariable9 != null && solverVariable10 != null) {
                if (i5 == 0) {
                    f = constraintWidget10.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget10.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor8.mSolverVariable, solverVariable9, constraintAnchor8.getMargin(), f, solverVariable10, constraintAnchor7.mSolverVariable, constraintAnchor7.getMargin(), 7);
            }
        } else {
            if (!z14 || constraintWidget8 == null) {
                int i13 = 8;
                if (z2 && constraintWidget8 != null) {
                    boolean z15 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget15 = constraintWidget8;
                    ConstraintWidget constraintWidget16 = constraintWidget15;
                    while (constraintWidget16 != null) {
                        ConstraintWidget constraintWidget17 = constraintWidget16.mNextChainWidget[i];
                        while (constraintWidget17 != null && constraintWidget17.getVisibility() == i13) {
                            constraintWidget17 = constraintWidget17.mNextChainWidget[i];
                        }
                        if (constraintWidget16 == constraintWidget8 || constraintWidget16 == constraintWidget9 || constraintWidget17 == null) {
                            constraintWidget = constraintWidget15;
                        } else {
                            if (constraintWidget17 == constraintWidget9) {
                                constraintWidget17 = null;
                            }
                            ConstraintAnchor constraintAnchor9 = constraintWidget16.mListAnchors[i2];
                            SolverVariable solverVariable11 = constraintAnchor9.mSolverVariable;
                            if (constraintAnchor9.mTarget != null) {
                                SolverVariable solverVariable12 = constraintAnchor9.mTarget.mSolverVariable;
                            }
                            int i14 = i2 + 1;
                            SolverVariable solverVariable13 = constraintWidget15.mListAnchors[i14].mSolverVariable;
                            int margin2 = constraintAnchor9.getMargin();
                            int margin3 = constraintWidget16.mListAnchors[i14].getMargin();
                            if (constraintWidget17 != null) {
                                constraintAnchor = constraintWidget17.mListAnchors[i2];
                                solverVariable = constraintAnchor.mSolverVariable;
                                solverVariable2 = constraintAnchor.mTarget != null ? constraintAnchor.mTarget.mSolverVariable : null;
                            } else {
                                constraintAnchor = constraintWidget9.mListAnchors[i2];
                                solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                                solverVariable2 = constraintWidget16.mListAnchors[i14].mSolverVariable;
                            }
                            if (constraintAnchor != null) {
                                margin3 += constraintAnchor.getMargin();
                            }
                            int i15 = margin3;
                            int margin4 = margin2 + constraintWidget15.mListAnchors[i14].getMargin();
                            SolverVariable solverVariable14 = solverVariable;
                            int i16 = z15 ? 8 : 4;
                            if (solverVariable11 == null || solverVariable13 == null || solverVariable14 == null || solverVariable2 == null) {
                                constraintWidget = constraintWidget15;
                                constraintWidget2 = constraintWidget17;
                            } else {
                                constraintWidget2 = constraintWidget17;
                                SolverVariable solverVariable15 = solverVariable2;
                                constraintWidget = constraintWidget15;
                                linearSystem.addCentering(solverVariable11, solverVariable13, margin4, 0.5f, solverVariable14, solverVariable15, i15, i16);
                            }
                            constraintWidget17 = constraintWidget2;
                        }
                        if (constraintWidget16.getVisibility() == 8) {
                            constraintWidget16 = constraintWidget;
                        }
                        constraintWidget15 = constraintWidget16;
                        i13 = 8;
                        constraintWidget16 = constraintWidget17;
                    }
                    linearSystem2 = linearSystem;
                    ConstraintAnchor constraintAnchor10 = constraintWidget8.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor11 = constraintWidget6.mListAnchors[i2].mTarget;
                    int i17 = i2 + 1;
                    ConstraintAnchor constraintAnchor12 = constraintWidget9.mListAnchors[i17];
                    ConstraintAnchor constraintAnchor13 = constraintWidget7.mListAnchors[i17].mTarget;
                    if (constraintAnchor11 != null) {
                        if (constraintWidget8 != constraintWidget9) {
                            linearSystem2.addEquality(constraintAnchor10.mSolverVariable, constraintAnchor11.mSolverVariable, constraintAnchor10.getMargin(), 5);
                        } else if (constraintAnchor13 != null) {
                            linearSystem2.addCentering(constraintAnchor10.mSolverVariable, constraintAnchor11.mSolverVariable, constraintAnchor10.getMargin(), 0.5f, constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, constraintAnchor12.getMargin(), 5);
                        }
                    }
                    if (constraintAnchor13 != null && constraintWidget8 != constraintWidget9) {
                        linearSystem2.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor13.mSolverVariable, -constraintAnchor12.getMargin(), 5);
                    }
                }
                if ((z14 && !z2) || constraintWidget8 == null || constraintWidget8 == constraintWidget9) {
                    return;
                }
                ConstraintAnchor constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                if (constraintWidget9 == null) {
                    constraintWidget9 = constraintWidget8;
                }
                int i18 = i2 + 1;
                ConstraintAnchor constraintAnchor15 = constraintWidget9.mListAnchors[i18];
                solverVariable4 = constraintAnchor14.mTarget == null ? constraintAnchor14.mTarget.mSolverVariable : null;
                SolverVariable solverVariable16 = constraintAnchor15.mTarget == null ? constraintAnchor15.mTarget.mSolverVariable : null;
                if (constraintWidget7 != constraintWidget9) {
                    ConstraintAnchor constraintAnchor16 = constraintWidget7.mListAnchors[i18];
                    solverVariable16 = constraintAnchor16.mTarget != null ? constraintAnchor16.mTarget.mSolverVariable : null;
                }
                if (constraintWidget8 == constraintWidget9) {
                    constraintAnchor14 = constraintWidget8.mListAnchors[i2];
                    constraintAnchor15 = constraintWidget8.mListAnchors[i18];
                }
                if (solverVariable4 != null || solverVariable16 == null) {
                }
                linearSystem2.addCentering(constraintAnchor14.mSolverVariable, solverVariable4, constraintAnchor14.getMargin(), 0.5f, solverVariable16, constraintAnchor15.mSolverVariable, constraintWidget9.mListAnchors[i18].getMargin(), 5);
                return;
            }
            boolean z16 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
            ConstraintWidget constraintWidget18 = constraintWidget8;
            for (ConstraintWidget constraintWidget19 = constraintWidget18; constraintWidget19 != null; constraintWidget19 = constraintWidget4) {
                ConstraintWidget constraintWidget20 = constraintWidget19.mNextChainWidget[i5];
                while (constraintWidget20 != null && constraintWidget20.getVisibility() == 8) {
                    constraintWidget20 = constraintWidget20.mNextChainWidget[i5];
                }
                if (constraintWidget20 != null || constraintWidget19 == constraintWidget9) {
                    ConstraintAnchor constraintAnchor17 = constraintWidget19.mListAnchors[i2];
                    SolverVariable solverVariable17 = constraintAnchor17.mSolverVariable;
                    SolverVariable solverVariable18 = constraintAnchor17.mTarget != null ? constraintAnchor17.mTarget.mSolverVariable : null;
                    if (constraintWidget18 != constraintWidget19) {
                        solverVariable18 = constraintWidget18.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget19 == constraintWidget8) {
                        solverVariable18 = constraintWidget6.mListAnchors[i2].mTarget != null ? constraintWidget6.mListAnchors[i2].mTarget.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor17.getMargin();
                    int i19 = i2 + 1;
                    int margin6 = constraintWidget19.mListAnchors[i19].getMargin();
                    if (constraintWidget20 != null) {
                        constraintAnchor2 = constraintWidget20.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget7.mListAnchors[i19].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.mSolverVariable;
                        } else {
                            constraintWidget3 = constraintWidget20;
                            solverVariable3 = null;
                            SolverVariable solverVariable19 = constraintWidget19.mListAnchors[i19].mSolverVariable;
                            if (constraintAnchor2 != null) {
                                margin6 += constraintAnchor2.getMargin();
                            }
                            int margin7 = margin5 + constraintWidget18.mListAnchors[i19].getMargin();
                            if (solverVariable17 != null || solverVariable18 == null || solverVariable3 == null || solverVariable19 == null) {
                                constraintWidget4 = constraintWidget3;
                                constraintWidget5 = constraintWidget18;
                            } else {
                                if (constraintWidget19 == constraintWidget8) {
                                    margin7 = constraintWidget8.mListAnchors[i2].getMargin();
                                }
                                if (constraintWidget19 == constraintWidget9) {
                                    margin6 = constraintWidget9.mListAnchors[i19].getMargin();
                                }
                                constraintWidget4 = constraintWidget3;
                                constraintWidget5 = constraintWidget18;
                                i3 = 8;
                                linearSystem.addCentering(solverVariable17, solverVariable18, margin7, 0.5f, solverVariable3, solverVariable19, margin6, z16 ? 8 : 5);
                                constraintWidget18 = constraintWidget19.getVisibility() == i3 ? constraintWidget19 : constraintWidget5;
                                i5 = i;
                            }
                        }
                    }
                    constraintWidget3 = constraintWidget20;
                    SolverVariable solverVariable192 = constraintWidget19.mListAnchors[i19].mSolverVariable;
                    if (constraintAnchor2 != null) {
                    }
                    int margin72 = margin5 + constraintWidget18.mListAnchors[i19].getMargin();
                    if (solverVariable17 != null) {
                    }
                    constraintWidget4 = constraintWidget3;
                    constraintWidget5 = constraintWidget18;
                } else {
                    constraintWidget5 = constraintWidget18;
                    constraintWidget4 = constraintWidget20;
                }
                i3 = 8;
                if (constraintWidget19.getVisibility() == i3) {
                }
                i5 = i;
            }
        }
        linearSystem2 = linearSystem;
        if (z14) {
        }
        ConstraintAnchor constraintAnchor142 = constraintWidget8.mListAnchors[i2];
        if (constraintWidget9 == null) {
        }
        int i182 = i2 + 1;
        ConstraintAnchor constraintAnchor152 = constraintWidget9.mListAnchors[i182];
        if (constraintAnchor142.mTarget == null) {
        }
        if (constraintAnchor152.mTarget == null) {
        }
        if (constraintWidget7 != constraintWidget9) {
        }
        if (constraintWidget8 == constraintWidget9) {
        }
        if (solverVariable4 != null) {
        }
    }
}
