package com.cexmobility.core.widgets.bottomnavigationmenu;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public class MenuNavigationItem {
    private Fragment fragment;
    private int icon;
    private int index;
    private boolean isFullScreen;
    private boolean isMainOption;
    private String name;

    public MenuNavigationItem(int index, String name, int icon, Fragment fragment) {
        this.index = index;
        this.name = name;
        this.icon = icon;
        this.fragment = fragment;
        this.isMainOption = false;
        this.isFullScreen = false;
    }

    public MenuNavigationItem(int index, String name, int icon, Fragment fragment, boolean isMainOption) {
        this.index = index;
        this.name = name;
        this.icon = icon;
        this.fragment = fragment;
        this.isMainOption = isMainOption;
        this.isFullScreen = false;
    }

    public MenuNavigationItem(int index, String name, int icon, Fragment fragment, boolean isMainOption, boolean isFullScreen) {
        this.index = index;
        this.name = name;
        this.icon = icon;
        this.fragment = fragment;
        this.isMainOption = isMainOption;
        this.isFullScreen = isFullScreen;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isMainOption() {
        return this.isMainOption;
    }

    public void setMainOption(boolean mainOption) {
        this.isMainOption = mainOption;
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.isFullScreen = fullScreen;
    }
}
