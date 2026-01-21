package com.iecisa.ctausuario.ui.main.transportcard.mytransportcards;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.iecisa.ctausuario.R;
import com.iecisa.ctausuario.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes5.dex */
public abstract class SwipeHelper extends ItemTouchHelper.SimpleCallback {
    private List<UnderlayButton> buttons;
    private Map<Integer, List<UnderlayButton>> buttonsBuffer;
    private int cardType;
    private Context context;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener gestureListener;
    private View.OnTouchListener onTouchListener;
    private Queue<Integer> recoverQueue;
    private RecyclerView recyclerView;
    private Double space;
    private float swipeThreshold;
    private int swipedPos;

    public interface UnderlayButtonClickListener {
        void onClick(int position);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeEscapeVelocity(float defaultValue) {
        return defaultValue * 0.1f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeVelocityThreshold(float defaultValue) {
        return defaultValue * 5.0f;
    }

    public abstract void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons);

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    public SwipeHelper(Context context, RecyclerView recyclerView, Integer cardType) {
        super(0, 4);
        this.swipedPos = -1;
        this.swipeThreshold = 0.5f;
        this.space = Double.valueOf(0.3d);
        this.gestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Iterator it = SwipeHelper.this.buttons.iterator();
                while (it.hasNext() && !((UnderlayButton) it.next()).onClick(e.getX(), e.getY())) {
                }
                return true;
            }
        };
        this.onTouchListener = new View.OnTouchListener() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent e) {
                if (SwipeHelper.this.swipedPos < 0) {
                    return false;
                }
                Point point = new Point((int) e.getRawX(), (int) e.getRawY());
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = SwipeHelper.this.recyclerView.findViewHolderForAdapterPosition(SwipeHelper.this.swipedPos);
                if (viewHolderFindViewHolderForAdapterPosition != null) {
                    View view2 = viewHolderFindViewHolderForAdapterPosition.itemView;
                    Rect rect = new Rect();
                    view2.getGlobalVisibleRect(rect);
                    if (e.getAction() == 0 || e.getAction() == 1 || e.getAction() == 2) {
                        if (rect.top < point.y && rect.bottom > point.y) {
                            SwipeHelper.this.gestureDetector.onTouchEvent(e);
                        } else {
                            SwipeHelper.this.recoverQueue.add(Integer.valueOf(SwipeHelper.this.swipedPos));
                            SwipeHelper.this.swipedPos = -1;
                            SwipeHelper.this.recoverSwipedItem();
                        }
                    }
                }
                return false;
            }
        };
        this.context = context;
        this.recyclerView = recyclerView;
        this.cardType = cardType.intValue();
        this.buttons = new ArrayList();
        this.gestureDetector = new GestureDetector(context, this.gestureListener);
        this.recyclerView.setOnTouchListener(this.onTouchListener);
        this.buttonsBuffer = new HashMap();
        this.recoverQueue = new LinkedList<Integer>() { // from class: com.iecisa.ctausuario.ui.main.transportcard.mytransportcards.SwipeHelper.3
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public boolean add(Integer o) {
                if (contains(o)) {
                    return false;
                }
                return super.add((AnonymousClass3) o);
            }
        };
        attachSwipe();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int i = this.swipedPos;
        if (i != adapterPosition) {
            this.recoverQueue.add(Integer.valueOf(i));
        }
        this.swipedPos = adapterPosition;
        if (this.buttonsBuffer.containsKey(Integer.valueOf(adapterPosition))) {
            this.buttons = this.buttonsBuffer.get(Integer.valueOf(this.swipedPos));
        } else {
            this.buttons.clear();
        }
        this.buttonsBuffer.clear();
        this.swipeThreshold = this.buttons.size() * 0.5f * ((int) (viewHolder.itemView.getWidth() * this.space.doubleValue()));
        recoverSwipedItem();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.swipeThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) throws Resources.NotFoundException {
        float f;
        SwipeHelper swipeHelper;
        Canvas canvas;
        RecyclerView recyclerView2;
        RecyclerView.ViewHolder viewHolder2;
        float f2;
        int i;
        int adapterPosition = viewHolder.getAdapterPosition();
        View view = viewHolder.itemView;
        if (adapterPosition < 0) {
            this.swipedPos = adapterPosition;
            return;
        }
        if (actionState != 1 || dX >= 0.0f) {
            f = dX;
            swipeHelper = this;
            canvas = c;
            recyclerView2 = recyclerView;
            viewHolder2 = viewHolder;
            f2 = dY;
            i = actionState;
        } else {
            List<UnderlayButton> arrayList = new ArrayList<>();
            if (!this.buttonsBuffer.containsKey(Integer.valueOf(adapterPosition))) {
                instantiateUnderlayButton(viewHolder, arrayList);
                this.buttonsBuffer.put(Integer.valueOf(adapterPosition), arrayList);
            } else {
                arrayList = this.buttonsBuffer.get(Integer.valueOf(adapterPosition));
            }
            float size = ((arrayList.size() * dX) * ((int) (viewHolder.itemView.getWidth() * this.space.doubleValue()))) / view.getWidth();
            swipeHelper = this;
            List<UnderlayButton> list = arrayList;
            canvas = c;
            swipeHelper.drawButtons(canvas, view, list, adapterPosition, size, viewHolder);
            f = size;
            recyclerView2 = recyclerView;
            viewHolder2 = viewHolder;
            i = actionState;
            f2 = dY;
        }
        super.onChildDraw(canvas, recyclerView2, viewHolder2, f, f2, i, isCurrentlyActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void recoverSwipedItem() {
        while (!this.recoverQueue.isEmpty()) {
            int iIntValue = this.recoverQueue.poll().intValue();
            if (iIntValue > -1) {
                this.recyclerView.getAdapter().notifyItemChanged(iIntValue);
            }
        }
    }

    private void drawButtons(Canvas c, View itemView, List<UnderlayButton> buffer, int pos, float dX, RecyclerView.ViewHolder viewHolder) throws Resources.NotFoundException {
        float top;
        float dimension;
        float right;
        float dimension2;
        float bottom;
        float dimension3;
        itemView.getRight();
        buffer.size();
        double width = viewHolder.itemView.getWidth() * this.space.doubleValue();
        if (this.cardType == Constants.SwipeType.TRANSPORT_CARD.intValue()) {
            top = itemView.getTop();
            dimension = this.context.getResources().getDimension(R.dimen.spacing_top_transport_card_swipe);
        } else {
            top = itemView.getTop();
            dimension = this.context.getResources().getDimension(R.dimen.spacing_top_credit_card_swipe);
        }
        float f = top + dimension;
        if (this.cardType == Constants.SwipeType.TRANSPORT_CARD.intValue()) {
            right = itemView.getRight();
            dimension2 = this.context.getResources().getDimension(R.dimen.spacing_right_transport_card_swipe);
        } else {
            right = itemView.getRight();
            dimension2 = this.context.getResources().getDimension(R.dimen.spacing_right_credit_card_swipe);
        }
        float f2 = right - dimension2;
        if (this.cardType == Constants.SwipeType.TRANSPORT_CARD.intValue()) {
            bottom = itemView.getBottom();
            dimension3 = this.context.getResources().getDimension(R.dimen.spacing_bottom_transport_card_swipe);
        } else {
            bottom = itemView.getBottom();
            dimension3 = this.context.getResources().getDimension(R.dimen.spacing_bottom_credit_card_swipe);
        }
        RectF rectF = new RectF(itemView.getRight() - ((int) width), f, f2, bottom - dimension3);
        Iterator<UnderlayButton> it = buffer.iterator();
        while (it.hasNext()) {
            it.next().onDraw(c, rectF, pos);
        }
    }

    public void attachSwipe() {
        new ItemTouchHelper(this).attachToRecyclerView(this.recyclerView);
    }

    public static class UnderlayButton {
        private UnderlayButtonClickListener clickListener;
        private RectF clickRegion;
        private int color;
        private Context context;
        private int position;
        private String text;

        public UnderlayButton(Context context, String text, int color, UnderlayButtonClickListener clickListener) {
            this.context = context;
            this.text = text;
            this.color = color;
            this.clickListener = clickListener;
        }

        public boolean onClick(float x, float y) {
            RectF rectF = this.clickRegion;
            if (rectF == null || !rectF.contains(x, y)) {
                return false;
            }
            this.clickListener.onClick(this.position);
            return true;
        }

        public void onDraw(Canvas c, RectF rect, int pos) throws Resources.NotFoundException {
            Paint paint = new Paint();
            float dimension = this.context.getResources().getDimension(R.dimen.spacing_small);
            paint.setColor(this.color);
            c.drawRoundRect(rect, dimension, dimension, paint);
            paint.setColor(-1);
            paint.setTextSize(this.context.getResources().getDimension(R.dimen.font_normal));
            Rect rect2 = new Rect();
            float fHeight = rect.height();
            float fWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            String str = this.text;
            paint.getTextBounds(str, 0, str.length(), rect2);
            c.drawText(this.text, rect.left + (((fWidth / 2.0f) - (rect2.width() / 2.0f)) - rect2.left), rect.top + (((fHeight / 2.0f) + (rect2.height() / 2.0f)) - rect2.bottom), paint);
            this.clickRegion = rect;
            this.position = pos;
        }
    }
}
