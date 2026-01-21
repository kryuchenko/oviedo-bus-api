package com.cexmobility.core.utils.swipe.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cexmobility.core.utils.swipe.SwipeLayout;
import com.cexmobility.core.utils.swipe.implments.SwipeItemMangerImpl;
import com.cexmobility.core.utils.swipe.interfaces.SwipeAdapterInterface;
import com.cexmobility.core.utils.swipe.interfaces.SwipeItemMangerInterface;
import com.cexmobility.core.utils.swipe.util.Attributes;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSwipeAdapter extends BaseAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    protected SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);

    public abstract void fillValues(int position, View convertView);

    public abstract View generateView(int position, ViewGroup parent);

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeAdapterInterface
    public abstract int getSwipeLayoutResourceId(int position);

    @Override // com.cexmobility.core.utils.swipe.interfaces.SwipeAdapterInterface
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = generateView(position, parent);
        }
        this.mItemManger.bind(convertView, position);
        fillValues(position, convertView);
        return convertView;
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
    public void closeAllItems() {
        this.mItemManger.closeAllItems();
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
