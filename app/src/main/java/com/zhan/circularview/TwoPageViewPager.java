package com.zhan.circularview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Zhan on 16-01-11.
 */
public class TwoPageViewPager extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
    private Fragment firstPage;
    private Fragment secondPage;

    public TwoPageViewPager(FragmentManager fm, Fragment firstPage, Fragment secondPage) {
        super(fm);
        this.firstPage = firstPage;
        this.secondPage = secondPage;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        switch(position){
            case 0:
                f = this.firstPage;
                break;
            case 1:
                f = this.secondPage;
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
