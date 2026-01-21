package com.cexmobility.core.utils.swipe.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import com.cexmobility.core.utils.swipe.SwipeLayout;
import com.cexmobility.core.utils.swipe.implments.SwipeItemMangerImpl;
import com.cexmobility.core.utils.swipe.interfaces.SwipeAdapterInterface;
import com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface;
import com.cexmobility.core.utils.swipe.util.Attributes;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SimpleCursorSwipeAdapter extends SimpleCursorAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    private SwipeItemMangerImpl mItemManger;

    protected SimpleCursorSwipeAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    protected SimpleCursorSwipeAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        this.mItemManger.bind(view, position);
        return view;
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void openItem(int position) {
        this.mItemManger.openItem(position);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void closeItem(int position) {
        this.mItemManger.closeItem(position);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void closeAllExcept(SwipeLayout layout) {
        this.mItemManger.closeAllExcept(layout);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public List<Integer> getOpenItems() {
        return this.mItemManger.getOpenItems();
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public List<SwipeLayout> getOpenLayouts() {
        return this.mItemManger.getOpenLayouts();
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void removeShownLayouts(SwipeLayout layout) {
        this.mItemManger.removeShownLayouts(layout);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public boolean isOpen(int position) {
        return this.mItemManger.isOpen(position);
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public Attributes.Mode getMode() {
        return this.mItemManger.getMode();
    }

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface
    public void setMode(Attributes.Mode mode) {
        this.mItemManger.setMode(mode);
    }
}
