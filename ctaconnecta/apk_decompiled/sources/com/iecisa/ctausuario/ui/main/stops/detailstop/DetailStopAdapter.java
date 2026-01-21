package com.iecisa.ctausuario.ui.main.stops.detailstop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

/* loaded from: classes5.dex */
class DetailStopAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragmentList;

    public DetailStopAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.mFragmentList = new ArrayList<>();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment) {
        if (this.mFragmentList.contains(fragment)) {
            return;
        }
        this.mFragmentList.add(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragmentList.size();
    }
}
