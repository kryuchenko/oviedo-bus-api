package com.cexmobility.core.utils.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.cexmobility.core.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SwipeLayout extends FrameLayout {
    private static final int DRAG_BOTTOM = 8;
    private static final int DRAG_LEFT = 1;
    private static final int DRAG_RIGHT = 2;
    private static final int DRAG_TOP = 4;
    private static final DragEdge DefaultDragEdge = DragEdge.Right;

    @Deprecated
    public static final int EMPTY_LAYOUT = -1;
    View.OnClickListener clickListener;
    private GestureDetector gestureDetector;
    private Rect hitSurfaceRect;
    View.OnLongClickListener longClickListener;
    private boolean mClickToClose;
    private DragEdge mCurrentDragEdge;
    private DoubleClickListener mDoubleClickListener;
    private int mDragDistance;
    private LinkedHashMap<DragEdge, View> mDragEdges;
    private ViewDragHelper mDragHelper;
    private ViewDragHelper.Callback mDragHelperCallback;
    private float[] mEdgeSwipesOffset;
    private int mEventCounter;
    private boolean mIsBeingDragged;
    private List<OnLayout> mOnLayoutListeners;
    private Map<View, ArrayList<OnRevealListener>> mRevealListeners;
    private Map<View, Boolean> mShowEntirely;
    private ShowMode mShowMode;
    private List<SwipeDenier> mSwipeDeniers;
    private boolean mSwipeEnabled;
    private List<SwipeListener> mSwipeListeners;
    private boolean[] mSwipesEnabled;
    private int mTouchSlop;
    private float sX;
    private float sY;

    public interface DoubleClickListener {
        void onDoubleClick(SwipeLayout layout, boolean surface);
    }

    public enum DragEdge {
        Left,
        Top,
        Right,
        Bottom
    }

    public interface OnLayout {
        void onLayout(SwipeLayout v);
    }

    public interface OnRevealListener {
        void onReveal(View child, DragEdge edge, float fraction, int distance);
    }

    public enum ShowMode {
        LayDown,
        PullOut
    }

    public enum Status {
        Middle,
        Open,
        Close
    }

    public interface SwipeDenier {
        boolean shouldDenySwipe(MotionEvent ev);
    }

    public interface SwipeListener {
        void onClose(SwipeLayout layout);

        void onHandRelease(SwipeLayout layout, float xvel, float yvel);

        void onOpen(SwipeLayout layout);

        void onStartClose(SwipeLayout layout);

        void onStartOpen(SwipeLayout layout);

        void onUpdate(SwipeLayout layout, int leftOffset, int topOffset);
    }

    public SwipeLayout(Context context) {
        this(context, null);
    }

    public SwipeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurrentDragEdge = DefaultDragEdge;
        this.mDragDistance = 0;
        this.mDragEdges = new LinkedHashMap<>();
        this.mEdgeSwipesOffset = new float[4];
        this.mSwipeListeners = new ArrayList();
        this.mSwipeDeniers = new ArrayList();
        this.mRevealListeners = new HashMap();
        this.mShowEntirely = new HashMap();
        this.mSwipeEnabled = true;
        this.mSwipesEnabled = new boolean[]{true, true, true, true};
        this.mClickToClose = false;
        this.mDragHelperCallback = new ViewDragHelper.Callback() { // from class: com.cexmobility.core.utils.swipe.SwipeLayout.1
            boolean isCloseBeforeDrag = true;

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                if (child == SwipeLayout.this.getSurfaceView()) {
                    int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i == 1 || i == 2) {
                        return SwipeLayout.this.getPaddingLeft();
                    }
                    if (i != 3) {
                        if (i == 4) {
                            if (left > SwipeLayout.this.getPaddingLeft()) {
                                return SwipeLayout.this.getPaddingLeft();
                            }
                            if (left < SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.mDragDistance;
                            }
                        }
                    } else {
                        if (left < SwipeLayout.this.getPaddingLeft()) {
                            return SwipeLayout.this.getPaddingLeft();
                        }
                        if (left > SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.mDragDistance;
                        }
                    }
                } else if (SwipeLayout.this.getCurrentBottomView() == child) {
                    int i2 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return SwipeLayout.this.getPaddingLeft();
                    }
                    if (i2 == 3) {
                        if (SwipeLayout.this.mShowMode == ShowMode.PullOut && left > SwipeLayout.this.getPaddingLeft()) {
                            return SwipeLayout.this.getPaddingLeft();
                        }
                    } else if (i2 == 4 && SwipeLayout.this.mShowMode == ShowMode.PullOut && left < SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.mDragDistance) {
                        return SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.mDragDistance;
                    }
                }
                return left;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int top, int dy) {
                if (child == SwipeLayout.this.getSurfaceView()) {
                    int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 || i == 4) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        } else {
                            if (top < SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance;
                            }
                            if (top > SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        }
                    } else {
                        if (top < SwipeLayout.this.getPaddingTop()) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                        if (top > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance;
                        }
                    }
                } else {
                    View surfaceView = SwipeLayout.this.getSurfaceView();
                    int top2 = surfaceView == null ? 0 : surfaceView.getTop();
                    int i2 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3 || i2 == 4) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        } else if (SwipeLayout.this.mShowMode == ShowMode.PullOut) {
                            if (top < SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.mDragDistance;
                            }
                        } else {
                            int i3 = top2 + dy;
                            if (i3 >= SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                            if (i3 <= SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance;
                            }
                        }
                    } else if (SwipeLayout.this.mShowMode == ShowMode.PullOut) {
                        if (top > SwipeLayout.this.getPaddingTop()) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                    } else {
                        int i4 = top2 + dy;
                        if (i4 < SwipeLayout.this.getPaddingTop()) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                        if (i4 > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance;
                        }
                    }
                }
                return top;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int pointerId) {
                boolean z = child == SwipeLayout.this.getSurfaceView() || SwipeLayout.this.getBottomViews().contains(child);
                if (z) {
                    this.isCloseBeforeDrag = SwipeLayout.this.getOpenStatus() == Status.Close;
                }
                return z;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View child) {
                return SwipeLayout.this.mDragDistance;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View child) {
                return SwipeLayout.this.mDragDistance;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                SwipeLayout.this.processHandRelease(xvel, yvel, this.isCloseBeforeDrag);
                Iterator it = SwipeLayout.this.mSwipeListeners.iterator();
                while (it.hasNext()) {
                    ((SwipeListener) it.next()).onHandRelease(SwipeLayout.this, xvel, yvel);
                }
                SwipeLayout.this.invalidate();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (surfaceView == null) {
                    return;
                }
                View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                int left2 = surfaceView.getLeft();
                int right = surfaceView.getRight();
                int top2 = surfaceView.getTop();
                int bottom = surfaceView.getBottom();
                if (changedView == surfaceView) {
                    if (SwipeLayout.this.mShowMode == ShowMode.PullOut && currentBottomView != null) {
                        if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Left || SwipeLayout.this.mCurrentDragEdge == DragEdge.Right) {
                            currentBottomView.offsetLeftAndRight(dx);
                        } else {
                            currentBottomView.offsetTopAndBottom(dy);
                        }
                    }
                } else if (SwipeLayout.this.getBottomViews().contains(changedView)) {
                    if (SwipeLayout.this.mShowMode == ShowMode.PullOut) {
                        surfaceView.offsetLeftAndRight(dx);
                        surfaceView.offsetTopAndBottom(dy);
                    } else {
                        SwipeLayout swipeLayout = SwipeLayout.this;
                        Rect rectComputeBottomLayDown = swipeLayout.computeBottomLayDown(swipeLayout.mCurrentDragEdge);
                        if (currentBottomView != null) {
                            currentBottomView.layout(rectComputeBottomLayDown.left, rectComputeBottomLayDown.top, rectComputeBottomLayDown.right, rectComputeBottomLayDown.bottom);
                        }
                        int left3 = surfaceView.getLeft() + dx;
                        int top3 = surfaceView.getTop() + dy;
                        if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Left && left3 < SwipeLayout.this.getPaddingLeft()) {
                            left3 = SwipeLayout.this.getPaddingLeft();
                        } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Right && left3 > SwipeLayout.this.getPaddingLeft()) {
                            left3 = SwipeLayout.this.getPaddingLeft();
                        } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Top && top3 < SwipeLayout.this.getPaddingTop()) {
                            top3 = SwipeLayout.this.getPaddingTop();
                        } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Bottom && top3 > SwipeLayout.this.getPaddingTop()) {
                            top3 = SwipeLayout.this.getPaddingTop();
                        }
                        surfaceView.layout(left3, top3, SwipeLayout.this.getMeasuredWidth() + left3, SwipeLayout.this.getMeasuredHeight() + top3);
                    }
                }
                SwipeLayout.this.dispatchRevealEvent(left2, top2, right, bottom);
                SwipeLayout.this.dispatchSwipeEvent(left2, top2, dx, dy);
                SwipeLayout.this.invalidate();
            }
        };
        this.mEventCounter = 0;
        this.sX = -1.0f;
        this.sY = -1.0f;
        this.gestureDetector = new GestureDetector(getContext(), new SwipeDetector());
        this.mDragHelper = ViewDragHelper.create(this, this.mDragHelperCallback);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SwipeLayout);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.SwipeLayout_drag_edge, 2);
        this.mEdgeSwipesOffset[DragEdge.Left.ordinal()] = typedArrayObtainStyledAttributes.getDimension(R.styleable.SwipeLayout_leftEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Right.ordinal()] = typedArrayObtainStyledAttributes.getDimension(R.styleable.SwipeLayout_rightEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Top.ordinal()] = typedArrayObtainStyledAttributes.getDimension(R.styleable.SwipeLayout_topEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Bottom.ordinal()] = typedArrayObtainStyledAttributes.getDimension(R.styleable.SwipeLayout_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwipeLayout_clickToClose, this.mClickToClose));
        if ((i & 1) == 1) {
            this.mDragEdges.put(DragEdge.Left, null);
        }
        if ((i & 4) == 4) {
            this.mDragEdges.put(DragEdge.Top, null);
        }
        if ((i & 2) == 2) {
            this.mDragEdges.put(DragEdge.Right, null);
        }
        if ((i & 8) == 8) {
            this.mDragEdges.put(DragEdge.Bottom, null);
        }
        this.mShowMode = ShowMode.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.SwipeLayout_show_mode, ShowMode.PullOut.ordinal())];
        typedArrayObtainStyledAttributes.recycle();
    }

    public void addSwipeListener(SwipeListener l) {
        this.mSwipeListeners.add(l);
    }

    public void removeSwipeListener(SwipeListener l) {
        this.mSwipeListeners.remove(l);
    }

    public void removeAllSwipeListener() {
        this.mSwipeListeners.clear();
    }

    public void addSwipeDenier(SwipeDenier denier) {
        this.mSwipeDeniers.add(denier);
    }

    public void removeSwipeDenier(SwipeDenier denier) {
        this.mSwipeDeniers.remove(denier);
    }

    public void removeAllSwipeDeniers() {
        this.mSwipeDeniers.clear();
    }

    public void addRevealListener(int childId, OnRevealListener l) {
        View viewFindViewById = findViewById(childId);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException("Child does not belong to SwipeListener.");
        }
        if (!this.mShowEntirely.containsKey(viewFindViewById)) {
            this.mShowEntirely.put(viewFindViewById, false);
        }
        if (this.mRevealListeners.get(viewFindViewById) == null) {
            this.mRevealListeners.put(viewFindViewById, new ArrayList<>());
        }
        this.mRevealListeners.get(viewFindViewById).add(l);
    }

    public void addRevealListener(int[] childIds, OnRevealListener l) {
        for (int i : childIds) {
            addRevealListener(i, l);
        }
    }

    public void removeRevealListener(int childId, OnRevealListener l) {
        View viewFindViewById = findViewById(childId);
        if (viewFindViewById == null) {
            return;
        }
        this.mShowEntirely.remove(viewFindViewById);
        if (this.mRevealListeners.containsKey(viewFindViewById)) {
            this.mRevealListeners.get(viewFindViewById).remove(l);
        }
    }

    public void removeAllRevealListeners(int childId) {
        View viewFindViewById = findViewById(childId);
        if (viewFindViewById != null) {
            this.mRevealListeners.remove(viewFindViewById);
            this.mShowEntirely.remove(viewFindViewById);
        }
    }

    /* renamed from: com.cexmobility.core.utils.swipe.SwipeLayout$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge;

        static {
            int[] iArr = new int[DragEdge.values().length];
            $SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge = iArr;
            try {
                iArr[DragEdge.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[DragEdge.Bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[DragEdge.Left.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[DragEdge.Right.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected boolean isViewTotallyFirstShowed(View child, Rect relativePosition, DragEdge edge, int surfaceLeft, int surfaceTop, int surfaceRight, int surfaceBottom) {
        if (this.mShowEntirely.get(child).booleanValue()) {
            return false;
        }
        int i = relativePosition.left;
        int i2 = relativePosition.right;
        int i3 = relativePosition.top;
        int i4 = relativePosition.bottom;
        if (getShowMode() == ShowMode.LayDown) {
            if ((edge == DragEdge.Right && surfaceRight <= i) || ((edge == DragEdge.Left && surfaceLeft >= i2) || ((edge == DragEdge.Top && surfaceTop >= i4) || (edge == DragEdge.Bottom && surfaceBottom <= i3)))) {
                return true;
            }
        } else if (getShowMode() == ShowMode.PullOut && ((edge == DragEdge.Right && i2 <= getWidth()) || ((edge == DragEdge.Left && i >= getPaddingLeft()) || ((edge == DragEdge.Top && i3 >= getPaddingTop()) || (edge == DragEdge.Bottom && i4 <= getHeight()))))) {
            return true;
        }
        return false;
    }

    protected boolean isViewShowing(View child, Rect relativePosition, DragEdge availableEdge, int surfaceLeft, int surfaceTop, int surfaceRight, int surfaceBottom) {
        int i = relativePosition.left;
        int i2 = relativePosition.right;
        int i3 = relativePosition.top;
        int i4 = relativePosition.bottom;
        if (getShowMode() == ShowMode.LayDown) {
            int i5 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[availableEdge.ordinal()];
            return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 == 4 && surfaceRight > i && surfaceRight <= i2 : surfaceLeft < i2 && surfaceLeft >= i : surfaceBottom > i3 && surfaceBottom <= i4 : surfaceTop >= i3 && surfaceTop < i4;
        }
        if (getShowMode() != ShowMode.PullOut) {
            return false;
        }
        int i6 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[availableEdge.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 == 4 && i <= getWidth() && i2 > getWidth() : i2 >= getPaddingLeft() && i < getPaddingLeft() : i3 < getHeight() && i3 >= getPaddingTop() : i3 < getPaddingTop() && i4 >= getPaddingTop();
    }

    protected Rect getRelativePosition(View child) {
        Rect rect = new Rect(child.getLeft(), child.getTop(), 0, 0);
        View view = child;
        while (view.getParent() != null && view != getRootView() && (view = (View) view.getParent()) != this) {
            rect.left += view.getLeft();
            rect.top += view.getTop();
        }
        rect.right = rect.left + child.getMeasuredWidth();
        rect.bottom = rect.top + child.getMeasuredHeight();
        return rect;
    }

    protected void dispatchSwipeEvent(int surfaceLeft, int surfaceTop, int dx, int dy) {
        DragEdge dragEdge = getDragEdge();
        boolean z = false;
        if (dragEdge != DragEdge.Left ? dragEdge != DragEdge.Right ? dragEdge != DragEdge.Top ? dragEdge != DragEdge.Bottom || dy <= 0 : dy >= 0 : dx <= 0 : dx >= 0) {
            z = true;
        }
        dispatchSwipeEvent(surfaceLeft, surfaceTop, z);
    }

    protected void dispatchSwipeEvent(int surfaceLeft, int surfaceTop, boolean open) {
        safeBottomView();
        Status openStatus = getOpenStatus();
        if (this.mSwipeListeners.isEmpty()) {
            return;
        }
        this.mEventCounter++;
        for (SwipeListener swipeListener : this.mSwipeListeners) {
            if (this.mEventCounter == 1) {
                if (open) {
                    swipeListener.onStartOpen(this);
                } else {
                    swipeListener.onStartClose(this);
                }
            }
            swipeListener.onUpdate(this, surfaceLeft - getPaddingLeft(), surfaceTop - getPaddingTop());
        }
        if (openStatus == Status.Close) {
            Iterator<SwipeListener> it = this.mSwipeListeners.iterator();
            while (it.hasNext()) {
                it.next().onClose(this);
            }
            this.mEventCounter = 0;
        }
        if (openStatus == Status.Open) {
            View currentBottomView = getCurrentBottomView();
            if (currentBottomView != null) {
                currentBottomView.setEnabled(true);
            }
            Iterator<SwipeListener> it2 = this.mSwipeListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onOpen(this);
            }
            this.mEventCounter = 0;
        }
    }

    private void safeBottomView() {
        Status openStatus = getOpenStatus();
        List<View> bottomViews = getBottomViews();
        if (openStatus == Status.Close) {
            for (View view : bottomViews) {
                if (view != null && view.getVisibility() != 4) {
                    view.setVisibility(4);
                }
            }
            return;
        }
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView == null || currentBottomView.getVisibility() == 0) {
            return;
        }
        currentBottomView.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void dispatchRevealEvent(final int surfaceLeft, final int surfaceTop, final int surfaceRight, final int surfaceBottom) {
        float f;
        int height;
        Iterator<OnRevealListener> it;
        if (this.mRevealListeners.isEmpty()) {
            return;
        }
        for (Map.Entry<View, ArrayList<OnRevealListener>> entry : this.mRevealListeners.entrySet()) {
            View key = entry.getKey();
            Rect relativePosition = getRelativePosition(key);
            if (isViewShowing(key, relativePosition, this.mCurrentDragEdge, surfaceLeft, surfaceTop, surfaceRight, surfaceBottom)) {
                int paddingTop = 0;
                this.mShowEntirely.put(key, false);
                float f2 = 0.0f;
                if (getShowMode() == ShowMode.LayDown) {
                    int i = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[this.mCurrentDragEdge.ordinal()];
                    if (i == 1) {
                        paddingTop = relativePosition.top - surfaceTop;
                        f = paddingTop;
                        height = key.getHeight();
                    } else if (i == 2) {
                        paddingTop = relativePosition.bottom - surfaceBottom;
                        f = paddingTop;
                        height = key.getHeight();
                    } else if (i == 3) {
                        paddingTop = relativePosition.left - surfaceLeft;
                        f = paddingTop;
                        height = key.getWidth();
                    } else {
                        if (i == 4) {
                            paddingTop = relativePosition.right - surfaceRight;
                            f = paddingTop;
                            height = key.getWidth();
                        }
                        it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            it.next().onReveal(key, this.mCurrentDragEdge, Math.abs(f2), paddingTop);
                            if (Math.abs(f2) == 1.0f) {
                                this.mShowEntirely.put(key, true);
                            }
                        }
                    }
                    f2 = f / height;
                    it = entry.getValue().iterator();
                    while (it.hasNext()) {
                    }
                } else {
                    if (getShowMode() == ShowMode.PullOut) {
                        int i2 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[this.mCurrentDragEdge.ordinal()];
                        if (i2 == 1) {
                            paddingTop = relativePosition.bottom - getPaddingTop();
                            f = paddingTop;
                            height = key.getHeight();
                        } else if (i2 == 2) {
                            paddingTop = relativePosition.top - getHeight();
                            f = paddingTop;
                            height = key.getHeight();
                        } else if (i2 == 3) {
                            paddingTop = relativePosition.right - getPaddingLeft();
                            f = paddingTop;
                            height = key.getWidth();
                        } else if (i2 == 4) {
                            paddingTop = relativePosition.left - getWidth();
                            f = paddingTop;
                            height = key.getWidth();
                        }
                        f2 = f / height;
                    }
                    it = entry.getValue().iterator();
                    while (it.hasNext()) {
                    }
                }
            }
            if (isViewTotallyFirstShowed(key, relativePosition, this.mCurrentDragEdge, surfaceLeft, surfaceTop, surfaceRight, surfaceBottom)) {
                this.mShowEntirely.put(key, true);
                Iterator<OnRevealListener> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    OnRevealListener next = it2.next();
                    if (this.mCurrentDragEdge == DragEdge.Left || this.mCurrentDragEdge == DragEdge.Right) {
                        next.onReveal(key, this.mCurrentDragEdge, 1.0f, key.getWidth());
                    } else {
                        next.onReveal(key, this.mCurrentDragEdge, 1.0f, key.getHeight());
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void addOnLayoutListener(OnLayout l) {
        if (this.mOnLayoutListeners == null) {
            this.mOnLayoutListeners = new ArrayList();
        }
        this.mOnLayoutListeners.add(l);
    }

    public void removeOnLayoutListener(OnLayout l) {
        List<OnLayout> list = this.mOnLayoutListeners;
        if (list != null) {
            list.remove(l);
        }
    }

    public void clearDragEdge() {
        this.mDragEdges.clear();
    }

    public void setDrag(DragEdge dragEdge, int childId) {
        clearDragEdge();
        addDrag(dragEdge, childId);
    }

    public void setDrag(DragEdge dragEdge, View child) {
        clearDragEdge();
        addDrag(dragEdge, child);
    }

    public void addDrag(DragEdge dragEdge, int childId) {
        addDrag(dragEdge, findViewById(childId), null);
    }

    public void addDrag(DragEdge dragEdge, View child) {
        addDrag(dragEdge, child, null);
    }

    public void addDrag(DragEdge dragEdge, View child, ViewGroup.LayoutParams params) {
        int i;
        if (child == null) {
            return;
        }
        if (params == null) {
            params = generateDefaultLayoutParams();
        }
        if (!checkLayoutParams(params)) {
            params = generateLayoutParams(params);
        }
        int i2 = AnonymousClass4.$SwitchMap$com$cexmobility$core$utils$swipe$SwipeLayout$DragEdge[dragEdge.ordinal()];
        if (i2 == 1) {
            i = 48;
        } else if (i2 != 2) {
            i = 3;
            if (i2 != 3) {
                i = i2 != 4 ? -1 : 5;
            }
        } else {
            i = 80;
        }
        if (params instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) params).gravity = i;
        }
        addView(child, 0, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        int iIntValue;
        if (child == null) {
            return;
        }
        try {
            iIntValue = ((Integer) params.getClass().getField("gravity").get(params)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(iIntValue, ViewCompat.getLayoutDirection(this));
            if ((absoluteGravity & 3) == 3) {
                this.mDragEdges.put(DragEdge.Left, child);
            }
            if ((absoluteGravity & 5) == 5) {
                this.mDragEdges.put(DragEdge.Right, child);
            }
            if ((absoluteGravity & 48) == 48) {
                this.mDragEdges.put(DragEdge.Top, child);
            }
            if ((absoluteGravity & 80) == 80) {
                this.mDragEdges.put(DragEdge.Bottom, child);
            }
        } else {
            Iterator<Map.Entry<DragEdge, View>> it = this.mDragEdges.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<DragEdge, View> next = it.next();
                if (next.getValue() == null) {
                    this.mDragEdges.put(next.getKey(), child);
                    break;
                }
            }
        }
        if (child.getParent() == this) {
            return;
        }
        super.addView(child, index, params);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        updateBottomViews();
        if (this.mOnLayoutListeners != null) {
            for (int i = 0; i < this.mOnLayoutListeners.size(); i++) {
                this.mOnLayoutListeners.get(i).onLayout(this);
            }
        }
    }

    void layoutPullOut() {
        Rect rectComputeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
            bringChildToFront(surfaceView);
        }
        Rect rectComputeBottomLayoutAreaViaSurface = computeBottomLayoutAreaViaSurface(ShowMode.PullOut, rectComputeSurfaceLayoutArea);
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            currentBottomView.layout(rectComputeBottomLayoutAreaViaSurface.left, rectComputeBottomLayoutAreaViaSurface.top, rectComputeBottomLayoutAreaViaSurface.right, rectComputeBottomLayoutAreaViaSurface.bottom);
        }
    }

    void layoutLayDown() {
        Rect rectComputeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
            bringChildToFront(surfaceView);
        }
        Rect rectComputeBottomLayoutAreaViaSurface = computeBottomLayoutAreaViaSurface(ShowMode.LayDown, rectComputeSurfaceLayoutArea);
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            currentBottomView.layout(rectComputeBottomLayoutAreaViaSurface.left, rectComputeBottomLayoutAreaViaSurface.top, rectComputeBottomLayoutAreaViaSurface.right, rectComputeBottomLayoutAreaViaSurface.bottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkCanDrag(MotionEvent ev) {
        boolean z;
        DragEdge dragEdge;
        if (this.mIsBeingDragged) {
            return;
        }
        if (getOpenStatus() == Status.Middle) {
            this.mIsBeingDragged = true;
            return;
        }
        Status openStatus = getOpenStatus();
        float rawX = ev.getRawX() - this.sX;
        float rawY = ev.getRawY() - this.sY;
        float degrees = (float) Math.toDegrees(Math.atan(Math.abs(rawY / rawX)));
        if (getOpenStatus() == Status.Close) {
            if (degrees < 45.0f) {
                if (rawX > 0.0f && isLeftSwipeEnabled()) {
                    dragEdge = DragEdge.Left;
                } else if (rawX >= 0.0f || !isRightSwipeEnabled()) {
                    return;
                } else {
                    dragEdge = DragEdge.Right;
                }
            } else if (rawY > 0.0f && isTopSwipeEnabled()) {
                dragEdge = DragEdge.Top;
            } else if (rawY >= 0.0f || !isBottomSwipeEnabled()) {
                return;
            } else {
                dragEdge = DragEdge.Bottom;
            }
            setCurrentDragEdge(dragEdge);
        }
        if (this.mCurrentDragEdge != DragEdge.Right) {
            z = false;
        } else {
            boolean z2 = (openStatus == Status.Open && rawX > ((float) this.mTouchSlop)) || (openStatus == Status.Close && rawX < ((float) (-this.mTouchSlop))) || openStatus == Status.Middle;
            if (degrees > 30.0f || !z2) {
                z = true;
            }
        }
        if (this.mCurrentDragEdge == DragEdge.Left) {
            boolean z3 = (openStatus == Status.Open && rawX < ((float) (-this.mTouchSlop))) || (openStatus == Status.Close && rawX > ((float) this.mTouchSlop)) || openStatus == Status.Middle;
            if (degrees > 30.0f || !z3) {
                z = true;
            }
        }
        if (this.mCurrentDragEdge == DragEdge.Top) {
            boolean z4 = (openStatus == Status.Open && rawY < ((float) (-this.mTouchSlop))) || (openStatus == Status.Close && rawY > ((float) this.mTouchSlop)) || openStatus == Status.Middle;
            if (degrees < 60.0f || !z4) {
                z = true;
            }
        }
        if (this.mCurrentDragEdge == DragEdge.Bottom) {
            boolean z5 = (openStatus == Status.Open && rawY > ((float) this.mTouchSlop)) || (openStatus == Status.Close && rawY < ((float) (-this.mTouchSlop))) || openStatus == Status.Middle;
            if (degrees < 60.0f || !z5) {
                z = true;
            }
        }
        this.mIsBeingDragged = !z;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ViewParent parent;
        if (!isSwipeEnabled()) {
            return false;
        }
        if (this.mClickToClose && getOpenStatus() == Status.Open && isTouchOnSurface(ev)) {
            return true;
        }
        for (SwipeDenier swipeDenier : this.mSwipeDeniers) {
            if (swipeDenier != null && swipeDenier.shouldDenySwipe(ev)) {
                return false;
            }
        }
        int action = ev.getAction();
        if (action == 0) {
            this.mDragHelper.processTouchEvent(ev);
            this.mIsBeingDragged = false;
            this.sX = ev.getRawX();
            this.sY = ev.getRawY();
            if (getOpenStatus() == Status.Middle) {
                this.mIsBeingDragged = true;
            }
        } else if (action == 1) {
            this.mIsBeingDragged = false;
            this.mDragHelper.processTouchEvent(ev);
        } else if (action == 2) {
            boolean z = this.mIsBeingDragged;
            checkCanDrag(ev);
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!z && this.mIsBeingDragged) {
                return false;
            }
        } else if (action != 3) {
            this.mDragHelper.processTouchEvent(ev);
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        if (!isSwipeEnabled()) {
            return super.onTouchEvent(event);
        }
        int actionMasked = event.getActionMasked();
        this.gestureDetector.onTouchEvent(event);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.mIsBeingDragged = false;
                this.mDragHelper.processTouchEvent(event);
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    this.mDragHelper.processTouchEvent(event);
                }
            }
            return !super.onTouchEvent(event) || this.mIsBeingDragged || actionMasked == 0;
        }
        this.mDragHelper.processTouchEvent(event);
        this.sX = event.getRawX();
        this.sY = event.getRawY();
        checkCanDrag(event);
        if (this.mIsBeingDragged) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mDragHelper.processTouchEvent(event);
        }
        if (super.onTouchEvent(event)) {
        }
    }

    public boolean isClickToClose() {
        return this.mClickToClose;
    }

    public void setClickToClose(boolean mClickToClose) {
        this.mClickToClose = mClickToClose;
    }

    public void setSwipeEnabled(boolean enabled) {
        this.mSwipeEnabled = enabled;
    }

    public boolean isSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    public boolean isLeftSwipeEnabled() {
        View view = this.mDragEdges.get(DragEdge.Left);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[DragEdge.Left.ordinal()];
    }

    public void setLeftSwipeEnabled(boolean leftSwipeEnabled) {
        this.mSwipesEnabled[DragEdge.Left.ordinal()] = leftSwipeEnabled;
    }

    public boolean isRightSwipeEnabled() {
        View view = this.mDragEdges.get(DragEdge.Right);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[DragEdge.Right.ordinal()];
    }

    public void setRightSwipeEnabled(boolean rightSwipeEnabled) {
        this.mSwipesEnabled[DragEdge.Right.ordinal()] = rightSwipeEnabled;
    }

    public boolean isTopSwipeEnabled() {
        View view = this.mDragEdges.get(DragEdge.Top);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[DragEdge.Top.ordinal()];
    }

    public void setTopSwipeEnabled(boolean topSwipeEnabled) {
        this.mSwipesEnabled[DragEdge.Top.ordinal()] = topSwipeEnabled;
    }

    public boolean isBottomSwipeEnabled() {
        View view = this.mDragEdges.get(DragEdge.Bottom);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[DragEdge.Bottom.ordinal()];
    }

    public void setBottomSwipeEnabled(boolean bottomSwipeEnabled) {
        this.mSwipesEnabled[DragEdge.Bottom.ordinal()] = bottomSwipeEnabled;
    }

    private boolean insideAdapterView() {
        return getAdapterView() != null;
    }

    private AdapterView getAdapterView() {
        ViewParent parent = getParent();
        if (parent instanceof AdapterView) {
            return (AdapterView) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAdapterViewItemClick() {
        AdapterView adapterView;
        int positionForView;
        if (getOpenStatus() != Status.Close) {
            return;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof AdapterView) || (positionForView = (adapterView = (AdapterView) parent).getPositionForView(this)) == -1) {
            return;
        }
        adapterView.performItemClick(adapterView.getChildAt(positionForView - adapterView.getFirstVisiblePosition()), positionForView, adapterView.getAdapter().getItemId(positionForView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performAdapterViewItemLongClick() throws NoSuchMethodException, SecurityException {
        AdapterView<?> adapterView;
        int positionForView;
        if (getOpenStatus() != Status.Close) {
            return false;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof AdapterView) || (positionForView = (adapterView = (AdapterView) parent).getPositionForView(this)) == -1) {
            return false;
        }
        long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
        try {
            Method declaredMethod = AbsListView.class.getDeclaredMethod("performLongPress", View.class, Integer.TYPE, Long.TYPE);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(adapterView, this, Integer.valueOf(positionForView), Long.valueOf(itemIdAtPosition))).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            boolean zOnItemLongClick = adapterView.getOnItemLongClickListener() != null ? adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition) : false;
            if (zOnItemLongClick) {
                adapterView.performHapticFeedback(0);
            }
            return zOnItemLongClick;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (insideAdapterView()) {
            if (this.clickListener == null) {
                setOnClickListener(new View.OnClickListener() { // from class: com.cexmobility.core.utils.swipe.SwipeLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SwipeLayout.this.performAdapterViewItemClick();
                    }
                });
            }
            if (this.longClickListener == null) {
                setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cexmobility.core.utils.swipe.SwipeLayout.3
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View v) throws NoSuchMethodException, SecurityException {
                        SwipeLayout.this.performAdapterViewItemLongClick();
                        return true;
                    }
                });
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        super.setOnClickListener(l);
        this.clickListener = l;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener l) {
        super.setOnLongClickListener(l);
        this.longClickListener = l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchOnSurface(MotionEvent ev) {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return false;
        }
        if (this.hitSurfaceRect == null) {
            this.hitSurfaceRect = new Rect();
        }
        surfaceView.getHitRect(this.hitSurfaceRect);
        return this.hitSurfaceRect.contains((int) ev.getX(), (int) ev.getY());
    }

    class SwipeDetector extends GestureDetector.SimpleOnGestureListener {
        SwipeDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            if (SwipeLayout.this.mClickToClose && SwipeLayout.this.isTouchOnSurface(e)) {
                SwipeLayout.this.close();
            }
            return super.onSingleTapUp(e);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            if (SwipeLayout.this.mDoubleClickListener != null) {
                View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (currentBottomView == null || e.getX() <= currentBottomView.getLeft() || e.getX() >= currentBottomView.getRight() || e.getY() <= currentBottomView.getTop() || e.getY() >= currentBottomView.getBottom()) {
                    currentBottomView = surfaceView;
                }
                SwipeLayout.this.mDoubleClickListener.onDoubleClick(SwipeLayout.this, currentBottomView == surfaceView);
            }
            return true;
        }
    }

    public void setDragDistance(int max) {
        if (max < 0) {
            max = 0;
        }
        this.mDragDistance = dp2px(max);
        requestLayout();
    }

    public void setShowMode(ShowMode mode) {
        this.mShowMode = mode;
        requestLayout();
    }

    public DragEdge getDragEdge() {
        return this.mCurrentDragEdge;
    }

    public int getDragDistance() {
        return this.mDragDistance;
    }

    public ShowMode getShowMode() {
        return this.mShowMode;
    }

    public View getSurfaceView() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public View getCurrentBottomView() {
        List<View> bottomViews = getBottomViews();
        if (this.mCurrentDragEdge.ordinal() < bottomViews.size()) {
            return bottomViews.get(this.mCurrentDragEdge.ordinal());
        }
        return null;
    }

    public List<View> getBottomViews() {
        ArrayList arrayList = new ArrayList();
        for (DragEdge dragEdge : DragEdge.values()) {
            arrayList.add(this.mDragEdges.get(dragEdge));
        }
        return arrayList;
    }

    public Status getOpenStatus() {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return Status.Close;
        }
        int left = surfaceView.getLeft();
        int top = surfaceView.getTop();
        if (left == getPaddingLeft() && top == getPaddingTop()) {
            return Status.Close;
        }
        if (left == getPaddingLeft() - this.mDragDistance || left == getPaddingLeft() + this.mDragDistance || top == getPaddingTop() - this.mDragDistance || top == getPaddingTop() + this.mDragDistance) {
            return Status.Open;
        }
        return Status.Middle;
    }

    protected void processHandRelease(float xvel, float yvel, boolean isCloseBeforeDragged) {
        float minVelocity = this.mDragHelper.getMinVelocity();
        View surfaceView = getSurfaceView();
        DragEdge dragEdge = this.mCurrentDragEdge;
        if (dragEdge == null || surfaceView == null) {
            return;
        }
        float f = isCloseBeforeDragged ? 0.25f : 0.75f;
        if (dragEdge == DragEdge.Left) {
            if (xvel > minVelocity) {
                open();
                return;
            }
            if (xvel < (-minVelocity)) {
                close();
                return;
            } else if ((getSurfaceView().getLeft() * 1.0f) / this.mDragDistance > f) {
                open();
                return;
            } else {
                close();
                return;
            }
        }
        if (dragEdge == DragEdge.Right) {
            if (xvel > minVelocity) {
                close();
                return;
            }
            if (xvel < (-minVelocity)) {
                open();
                return;
            } else if (((-getSurfaceView().getLeft()) * 1.0f) / this.mDragDistance > f) {
                open();
                return;
            } else {
                close();
                return;
            }
        }
        if (dragEdge == DragEdge.Top) {
            if (yvel > minVelocity) {
                open();
                return;
            }
            if (yvel < (-minVelocity)) {
                close();
                return;
            } else if ((getSurfaceView().getTop() * 1.0f) / this.mDragDistance > f) {
                open();
                return;
            } else {
                close();
                return;
            }
        }
        if (dragEdge == DragEdge.Bottom) {
            if (yvel > minVelocity) {
                close();
                return;
            }
            if (yvel < (-minVelocity)) {
                open();
            } else if (((-getSurfaceView().getTop()) * 1.0f) / this.mDragDistance > f) {
                open();
            } else {
                close();
            }
        }
    }

    public void open() {
        open(true, true);
    }

    public void open(boolean smooth) {
        open(smooth, true);
    }

    public void open(boolean smooth, boolean notify) {
        View surfaceView = getSurfaceView();
        View currentBottomView = getCurrentBottomView();
        if (surfaceView == null) {
            return;
        }
        Rect rectComputeSurfaceLayoutArea = computeSurfaceLayoutArea(true);
        if (smooth) {
            this.mDragHelper.smoothSlideViewTo(surfaceView, rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top);
        } else {
            int left = rectComputeSurfaceLayoutArea.left - surfaceView.getLeft();
            int top = rectComputeSurfaceLayoutArea.top - surfaceView.getTop();
            surfaceView.layout(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
            if (getShowMode() == ShowMode.PullOut) {
                Rect rectComputeBottomLayoutAreaViaSurface = computeBottomLayoutAreaViaSurface(ShowMode.PullOut, rectComputeSurfaceLayoutArea);
                if (currentBottomView != null) {
                    currentBottomView.layout(rectComputeBottomLayoutAreaViaSurface.left, rectComputeBottomLayoutAreaViaSurface.top, rectComputeBottomLayoutAreaViaSurface.right, rectComputeBottomLayoutAreaViaSurface.bottom);
                }
            }
            if (notify) {
                dispatchRevealEvent(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
                dispatchSwipeEvent(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, left, top);
            } else {
                safeBottomView();
            }
        }
        invalidate();
    }

    public void open(DragEdge edge) {
        setCurrentDragEdge(edge);
        open(true, true);
    }

    public void open(boolean smooth, DragEdge edge) {
        setCurrentDragEdge(edge);
        open(smooth, true);
    }

    public void open(boolean smooth, boolean notify, DragEdge edge) {
        setCurrentDragEdge(edge);
        open(smooth, notify);
    }

    public void close() {
        close(true, true);
    }

    public void close(boolean smooth) {
        close(smooth, true);
    }

    public void close(boolean smooth, boolean notify) {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return;
        }
        if (smooth) {
            this.mDragHelper.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
        } else {
            Rect rectComputeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
            int left = rectComputeSurfaceLayoutArea.left - surfaceView.getLeft();
            int top = rectComputeSurfaceLayoutArea.top - surfaceView.getTop();
            surfaceView.layout(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
            if (notify) {
                dispatchRevealEvent(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, rectComputeSurfaceLayoutArea.right, rectComputeSurfaceLayoutArea.bottom);
                dispatchSwipeEvent(rectComputeSurfaceLayoutArea.left, rectComputeSurfaceLayoutArea.top, left, top);
            } else {
                safeBottomView();
            }
        }
        invalidate();
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean smooth) {
        if (getOpenStatus() == Status.Open) {
            close(smooth);
        } else if (getOpenStatus() == Status.Close) {
            open(smooth);
        }
    }

    private Rect computeSurfaceLayoutArea(boolean open) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (open) {
            if (this.mCurrentDragEdge == DragEdge.Left) {
                paddingLeft = this.mDragDistance + getPaddingLeft();
            } else if (this.mCurrentDragEdge == DragEdge.Right) {
                paddingLeft = getPaddingLeft() - this.mDragDistance;
            } else if (this.mCurrentDragEdge == DragEdge.Top) {
                paddingTop = this.mDragDistance + getPaddingTop();
            } else {
                paddingTop = getPaddingTop() - this.mDragDistance;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    private Rect computeBottomLayoutAreaViaSurface(ShowMode mode, Rect surfaceArea) {
        View currentBottomView = getCurrentBottomView();
        int i = surfaceArea.left;
        int i2 = surfaceArea.top;
        int measuredWidth = surfaceArea.right;
        int measuredHeight = surfaceArea.bottom;
        if (mode == ShowMode.PullOut) {
            if (this.mCurrentDragEdge == DragEdge.Left) {
                i = surfaceArea.left - this.mDragDistance;
            } else if (this.mCurrentDragEdge == DragEdge.Right) {
                i = surfaceArea.right;
            } else if (this.mCurrentDragEdge == DragEdge.Top) {
                i2 = surfaceArea.top - this.mDragDistance;
            } else {
                i2 = surfaceArea.bottom;
            }
            if (this.mCurrentDragEdge == DragEdge.Left || this.mCurrentDragEdge == DragEdge.Right) {
                int i3 = surfaceArea.bottom;
                measuredWidth = i + (currentBottomView != null ? currentBottomView.getMeasuredWidth() : 0);
                measuredHeight = i3;
            } else {
                measuredHeight = (currentBottomView != null ? currentBottomView.getMeasuredHeight() : 0) + i2;
                measuredWidth = surfaceArea.right;
            }
        } else if (mode == ShowMode.LayDown) {
            if (this.mCurrentDragEdge == DragEdge.Left) {
                measuredWidth = i + this.mDragDistance;
            } else if (this.mCurrentDragEdge == DragEdge.Right) {
                i = measuredWidth - this.mDragDistance;
            } else if (this.mCurrentDragEdge == DragEdge.Top) {
                measuredHeight = i2 + this.mDragDistance;
            } else {
                i2 = measuredHeight - this.mDragDistance;
            }
        }
        return new Rect(i, i2, measuredWidth, measuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect computeBottomLayDown(DragEdge dragEdge) {
        int measuredWidth;
        int measuredHeight;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (dragEdge == DragEdge.Right) {
            paddingLeft = getMeasuredWidth() - this.mDragDistance;
        } else if (dragEdge == DragEdge.Bottom) {
            paddingTop = getMeasuredHeight() - this.mDragDistance;
        }
        if (dragEdge == DragEdge.Left || dragEdge == DragEdge.Right) {
            measuredWidth = this.mDragDistance + paddingLeft;
            measuredHeight = getMeasuredHeight();
        } else {
            measuredWidth = getMeasuredWidth() + paddingLeft;
            measuredHeight = this.mDragDistance;
        }
        return new Rect(paddingLeft, paddingTop, measuredWidth, measuredHeight + paddingTop);
    }

    public void setOnDoubleClickListener(DoubleClickListener doubleClickListener) {
        this.mDoubleClickListener = doubleClickListener;
    }

    private int dp2px(float dp) {
        return (int) ((dp * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public void setDragEdge(DragEdge dragEdge) {
        clearDragEdge();
        if (getChildCount() >= 2) {
            this.mDragEdges.put(dragEdge, getChildAt(getChildCount() - 2));
        }
        setCurrentDragEdge(dragEdge);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        for (Map.Entry entry : new HashMap(this.mDragEdges).entrySet()) {
            if (entry.getValue() == child) {
                this.mDragEdges.remove(entry.getKey());
            }
        }
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.mDragEdges;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.mDragEdges.keySet());
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> dragEdges) {
        clearDragEdge();
        int iMin = Math.min(dragEdges.size(), getChildCount() - 1);
        for (int i = 0; i < iMin; i++) {
            this.mDragEdges.put(dragEdges.get(i), getChildAt(i));
        }
        if (dragEdges.size() == 0 || dragEdges.contains(DefaultDragEdge)) {
            setCurrentDragEdge(DefaultDragEdge);
        } else {
            setCurrentDragEdge(dragEdges.get(0));
        }
    }

    @Deprecated
    public void setDragEdges(DragEdge... mDragEdges) {
        clearDragEdge();
        setDragEdges(Arrays.asList(mDragEdges));
    }

    @Deprecated
    public void setBottomViewIds(int leftId, int rightId, int topId, int bottomId) {
        addDrag(DragEdge.Left, findViewById(leftId));
        addDrag(DragEdge.Right, findViewById(rightId));
        addDrag(DragEdge.Top, findViewById(topId));
        addDrag(DragEdge.Bottom, findViewById(bottomId));
    }

    private float getCurrentOffset() {
        DragEdge dragEdge = this.mCurrentDragEdge;
        if (dragEdge == null) {
            return 0.0f;
        }
        return this.mEdgeSwipesOffset[dragEdge.ordinal()];
    }

    private void setCurrentDragEdge(DragEdge dragEdge) {
        this.mCurrentDragEdge = dragEdge;
        updateBottomViews();
    }

    private void updateBottomViews() {
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            if (this.mCurrentDragEdge == DragEdge.Left || this.mCurrentDragEdge == DragEdge.Right) {
                this.mDragDistance = currentBottomView.getMeasuredWidth() - dp2px(getCurrentOffset());
            } else {
                this.mDragDistance = currentBottomView.getMeasuredHeight() - dp2px(getCurrentOffset());
            }
        }
        if (this.mShowMode == ShowMode.PullOut) {
            layoutPullOut();
        } else if (this.mShowMode == ShowMode.LayDown) {
            layoutLayDown();
        }
        safeBottomView();
    }
}
