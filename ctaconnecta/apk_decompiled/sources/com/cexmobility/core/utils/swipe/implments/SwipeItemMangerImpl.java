package com.cexmobility.core.utils.swipe.implments;

import android.view.View;
import com.cexmobility.core.utils.swipe.SimpleSwipeListener;
import com.cexmobility.core.utils.swipe.SwipeLayout;
import com.cexmobility.core.utils.swipe.interfaces.SwipeAdapterInterface;
import com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface;
import com.cexmobility.core.utils.swipe.util.Attributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class SwipeItemMangerImpl implements SwipeItemMangerInterface {
    protected SwipeAdapterInterface swipeAdapterInterface;
    private Attributes.Mode mode = Attributes.Mode.Single;
    public final int INVALID_POSITION = -1;
    protected int mOpenPosition = -1;
    protected Set<Integer> mOpenPositions = new HashSet();
    protected Set<SwipeLayout> mShownLayouts = new HashSet();

    public SwipeItemMangerImpl(SwipeAdapterInterface swipeAdapterInterface) {
        if (swipeAdapterInterface == null) {
            throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
        }
        this.swipeAdapterInterface = swipeAdapterInterface;
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public Attributes.Mode getMode() {
        return this.mode;
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void setMode(Attributes.Mode mode) {
        this.mode = mode;
        this.mOpenPositions.clear();
        this.mShownLayouts.clear();
        this.mOpenPosition = -1;
    }

    public void bind(View view, int position) {
        int swipeLayoutResourceId = this.swipeAdapterInterface.getSwipeLayoutResourceId(position);
        SwipeLayout swipeLayout = (SwipeLayout) view.findViewById(swipeLayoutResourceId);
        if (swipeLayout == null) {
            throw new IllegalStateException("can not find SwipeLayout in target view");
        }
        if (swipeLayout.getTag(swipeLayoutResourceId) == null) {
            OnLayoutListener onLayoutListener = new OnLayoutListener(position);
            SwipeMemory swipeMemory = new SwipeMemory(position);
            swipeLayout.addSwipeListener(swipeMemory);
            swipeLayout.addOnLayoutListener(onLayoutListener);
            swipeLayout.setTag(swipeLayoutResourceId, new ValueBox(position, swipeMemory, onLayoutListener));
            this.mShownLayouts.add(swipeLayout);
            return;
        }
        ValueBox valueBox = (ValueBox) swipeLayout.getTag(swipeLayoutResourceId);
        valueBox.swipeMemory.setPosition(position);
        valueBox.onLayoutListener.setPosition(position);
        valueBox.position = position;
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void openItem(int position) {
        if (this.mode == Attributes.Mode.Multiple) {
            if (!this.mOpenPositions.contains(Integer.valueOf(position))) {
                this.mOpenPositions.add(Integer.valueOf(position));
            }
        } else {
            this.mOpenPosition = position;
        }
        this.swipeAdapterInterface.notifyDatasetChanged();
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void closeItem(int position) {
        if (this.mode == Attributes.Mode.Multiple) {
            this.mOpenPositions.remove(Integer.valueOf(position));
        } else if (this.mOpenPosition == position) {
            this.mOpenPosition = -1;
        }
        this.swipeAdapterInterface.notifyDatasetChanged();
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void closeAllExcept(SwipeLayout layout) {
        for (SwipeLayout swipeLayout : this.mShownLayouts) {
            if (swipeLayout != layout) {
                swipeLayout.close();
            }
        }
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void closeAllItems() {
        if (this.mode == Attributes.Mode.Multiple) {
            this.mOpenPositions.clear();
        } else {
            this.mOpenPosition = -1;
        }
        Iterator<SwipeLayout> it = this.mShownLayouts.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void removeShownLayouts(SwipeLayout layout) {
        this.mShownLayouts.remove(layout);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public List<Integer> getOpenItems() {
        if (this.mode == Attributes.Mode.Multiple) {
            return new ArrayList(this.mOpenPositions);
        }
        return Collections.singletonList(Integer.valueOf(this.mOpenPosition));
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public List<SwipeLayout> getOpenLayouts() {
        return new ArrayList(this.mShownLayouts);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public boolean isOpen(int position) {
        if (this.mode == Attributes.Mode.Multiple) {
            return this.mOpenPositions.contains(Integer.valueOf(position));
        }
        return this.mOpenPosition == position;
    }

    class ValueBox {
        OnLayoutListener onLayoutListener;
        int position;
        SwipeMemory swipeMemory;

        ValueBox(int position, SwipeMemory swipeMemory, OnLayoutListener onLayoutListener) {
            this.swipeMemory = swipeMemory;
            this.onLayoutListener = onLayoutListener;
            this.position = position;
        }
    }

    class OnLayoutListener implements SwipeLayout.OnLayout {
        private int position;

        OnLayoutListener(int position) {
            this.position = position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override // com.cexmobility.core.utils.swipe.SwipeLayout.OnLayout
        public void onLayout(SwipeLayout v) {
            if (SwipeItemMangerImpl.this.isOpen(this.position)) {
                v.open(false, false);
            } else {
                v.close(false, false);
            }
        }
    }

    class SwipeMemory extends SimpleSwipeListener {
        private int position;

        SwipeMemory(int position) {
            this.position = position;
        }

        @Override // com.cexmobility.core.utils.swipe.SimpleSwipeListener, com.cexmobility.core.utils.swipe.SwipeLayout.SwipeListener
        public void onClose(SwipeLayout layout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Multiple) {
                SwipeItemMangerImpl.this.mOpenPositions.remove(Integer.valueOf(this.position));
            } else {
                SwipeItemMangerImpl.this.mOpenPosition = -1;
            }
        }

        @Override // com.cexmobility.core.utils.swipe.SimpleSwipeListener, com.cexmobility.core.utils.swipe.SwipeLayout.SwipeListener
        public void onStartOpen(SwipeLayout layout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Single) {
                SwipeItemMangerImpl.this.closeAllExcept(layout);
            }
        }

        @Override // com.cexmobility.core.utils.swipe.SimpleSwipeListener, com.cexmobility.core.utils.swipe.SwipeLayout.SwipeListener
        public void onOpen(SwipeLayout layout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Multiple) {
                SwipeItemMangerImpl.this.mOpenPositions.add(Integer.valueOf(this.position));
                return;
            }
            SwipeItemMangerImpl.this.closeAllExcept(layout);
            SwipeItemMangerImpl.this.mOpenPosition = this.position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
