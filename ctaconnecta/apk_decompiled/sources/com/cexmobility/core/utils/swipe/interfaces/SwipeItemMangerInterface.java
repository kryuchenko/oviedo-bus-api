package com.cexmobility.core.utils.swipe.interfaces;

import com.cexmobility.core.utils.swipe.SwipeLayout;
import com.cexmobility.core.utils.swipe.util.Attributes;
import java.util.List;

/* loaded from: classes.dex */
public interface SwipeItemMangerInterface {
    void closeAllExcept(SwipeLayout layout);

    void closeAllItems();

    void closeItem(int position);

    Attributes.Mode getMode();

    List<Integer> getOpenItems();

    List<SwipeLayout> getOpenLayouts();

    boolean isOpen(int position);

    void openItem(int position);

    void removeShownLayouts(SwipeLayout layout);

    void setMode(Attributes.Mode mode);
}
