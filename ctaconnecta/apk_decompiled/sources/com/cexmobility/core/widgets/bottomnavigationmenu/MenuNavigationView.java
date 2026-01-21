package com.cexmobility.core.widgets.bottomnavigationmenu;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cexmobility.core.R;
import java.util.List;
import java.util.Locale;
import timber.log.Timber;

/* loaded from: classes.dex */
public class MenuNavigationView extends LinearLayout {
    private Fragment activeFragment;
    private ConstraintLayout base;
    private FrameLayout container;
    private FragmentManager fragmentManager;
    private List<MenuNavigationItem> items;
    private ConstraintLayout root;

    public MenuNavigationView(Context context) {
        super(context);
        init();
    }

    public MenuNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MenuNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MenuNavigationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.menu_nav_view, this);
        this.root = (ConstraintLayout) findViewById(R.id.menu_root);
        this.base = (ConstraintLayout) findViewById(R.id.menu_base);
        this.container = (FrameLayout) findViewById(R.id.menu_container);
    }

    public void inflateItems(FragmentActivity activity, List<MenuNavigationItem> items) {
        this.fragmentManager = activity.getSupportFragmentManager();
        this.items = items;
        for (int i = 1; i < items.size(); i++) {
            Guideline guideline = new Guideline(getContext());
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.validate();
            float size = (1.0f / items.size()) * i;
            layoutParams.guidePercent = size;
            Timber.i("guide " + i + " - " + size, new Object[0]);
            layoutParams.orientation = 1;
            guideline.setLayoutParams(layoutParams);
            guideline.setId(View.generateViewId());
            guideline.setTag(String.format(Locale.ENGLISH, "tab_gl_%d", Integer.valueOf(i)));
            this.base.addView(guideline);
        }
        for (int i2 = 0; i2 < items.size(); i2++) {
            final MenuNavigationItem menuNavigationItem = items.get(i2);
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.menu_nav_cell, null);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
            layoutParams2.validate();
            if (i2 == 0) {
                layoutParams2.startToStart = 0;
                layoutParams2.endToStart = this.base.findViewWithTag(String.format(Locale.ENGLISH, "tab_gl_%d", Integer.valueOf(i2 + 1))).getId();
            } else if (i2 == items.size() - 1) {
                layoutParams2.startToStart = this.base.findViewWithTag(String.format(Locale.ENGLISH, "tab_gl_%d", Integer.valueOf(i2))).getId();
                layoutParams2.endToEnd = 0;
            } else {
                String str = String.format(Locale.ENGLISH, "tab_gl_%d", Integer.valueOf(i2));
                String str2 = String.format(Locale.ENGLISH, "tab_gl_%d", Integer.valueOf(i2 + 1));
                layoutParams2.startToEnd = this.base.findViewWithTag(str).getId();
                layoutParams2.endToStart = this.base.findViewWithTag(str2).getId();
            }
            layoutParams2.bottomToBottom = 0;
            if (!menuNavigationItem.isMainOption()) {
                layoutParams2.topToBottom = this.base.findViewById(R.id.separator).getId();
            } else {
                layoutParams2.topToTop = this.base.findViewById(R.id.menu_base).getId();
            }
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setId(View.generateViewId());
            String str3 = String.format(Locale.ENGLISH, "tab_cell_%d", Integer.valueOf(i2));
            linearLayout.setTag(str3);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.mnu_cell_icon);
            imageView.setImageResource(menuNavigationItem.getIcon());
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.cexmobility.core.widgets.bottomnavigationmenu.MenuNavigationView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$inflateItems$0(menuNavigationItem, view);
                }
            });
            this.base.addView(linearLayout);
            if (menuNavigationItem.isMainOption()) {
                this.activeFragment = menuNavigationItem.getFragment();
                imageView.setSelected(true);
                this.fragmentManager.beginTransaction().add(R.id.menu_container, menuNavigationItem.getFragment(), str3).commit();
            } else {
                this.fragmentManager.beginTransaction().add(R.id.menu_container, menuNavigationItem.getFragment(), str3).hide(menuNavigationItem.getFragment()).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnItemMenuListener, reason: merged with bridge method [inline-methods] */
    public void lambda$inflateItems$0(View view, MenuNavigationItem navigationItem) {
        Timber.i("Pressed : %s", (String) view.getTag());
        for (int i = 0; i < this.items.size(); i++) {
            ((ImageView) ((LinearLayout) this.base.findViewWithTag(String.format(Locale.ENGLISH, "tab_cell_%d", Integer.valueOf(i)))).findViewById(R.id.mnu_cell_icon)).setSelected(false);
        }
        ((ImageView) view.findViewById(R.id.mnu_cell_icon)).setSelected(true);
        selectItemMenu(navigationItem);
    }

    private void selectItemMenu(MenuNavigationItem navigationItem) {
        this.fragmentManager.beginTransaction().hide(this.activeFragment).show(navigationItem.getFragment()).commit();
        this.activeFragment = navigationItem.getFragment();
    }

    private void configureFragmentSpace(boolean isFullScreen) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.container.getLayoutParams();
        layoutParams.validate();
        if (isFullScreen) {
            layoutParams.bottomToBottom = this.root.getId();
        }
        this.container.setLayoutParams(layoutParams);
    }

    /* renamed from: showMenu, reason: merged with bridge method [inline-methods] */
    public void lambda$showMenu$1(boolean withAnimation) {
        ConstraintLayout constraintLayout = this.base;
        if (constraintLayout == null || constraintLayout.getVisibility() != 4) {
            return;
        }
        this.base.setVisibility(0);
    }

    public void showMenu(final boolean withAnimation, long delay) {
        new Handler().postDelayed(new Runnable() { // from class: com.cexmobility.core.widgets.bottomnavigationmenu.MenuNavigationView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showMenu$1(withAnimation);
            }
        }, delay);
    }

    /* renamed from: hideMenu, reason: merged with bridge method [inline-methods] */
    public void lambda$hideMenu$2(boolean withAnimation) {
        ConstraintLayout constraintLayout = this.base;
        if (constraintLayout == null || constraintLayout.getVisibility() != 0) {
            return;
        }
        this.base.setVisibility(4);
    }

    public void hideMenu(final boolean withAnimation, long delay) {
        new Handler().postDelayed(new Runnable() { // from class: com.cexmobility.core.widgets.bottomnavigationmenu.MenuNavigationView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideMenu$2(withAnimation);
            }
        }, delay);
    }

    public boolean isMenuVisible() {
        ConstraintLayout constraintLayout = this.base;
        return constraintLayout != null && constraintLayout.getVisibility() == 0;
    }
}
