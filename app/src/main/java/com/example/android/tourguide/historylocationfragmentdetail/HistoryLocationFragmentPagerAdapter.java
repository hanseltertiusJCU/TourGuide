package com.example.android.tourguide.historylocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HistoryLocationFragmentPagerAdapter extends FragmentPagerAdapter {

    public HistoryLocationFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    /**
     * Get the specific item in Fragment based on the position of list item
     * @param position from list item
     * @return Fragment object that contains a DetailFragment
     */
    @Override
    public Fragment getItem(int position) {

        Fragment fragmentView;

        switch (position){
            case 0:
                fragmentView = new BattleboxDetailFragment();
                break;
            case 1:
                fragmentView = new EastCoastDetailFragment();
                break;
            case 2:
                fragmentView = new NorthernResilienceDetailFragment();
                break;
            case 3:
                fragmentView = new SouthernResilienceDetailFragment();
                break;
            case 4:
                fragmentView = new TemasekDetailFragment();
                break;
            case 5:
                fragmentView = new BukitChanduDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.historylocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.historylocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 6;
    }
}
