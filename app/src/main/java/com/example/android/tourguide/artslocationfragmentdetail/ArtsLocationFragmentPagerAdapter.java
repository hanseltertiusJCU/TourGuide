package com.example.android.tourguide.artslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ArtsLocationFragmentPagerAdapter extends FragmentPagerAdapter {

    public ArtsLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new TiongBahruDetailFragment();
                break;
            case 1:
                fragmentView = new ChinatownDetailFragment();
                break;
            case 2:
                fragmentView = new LittleIndiaDetailFragment();
                break;
            case 3:
                fragmentView = new MacPhersonDetailFragment();
                break;
            case 4:
                fragmentView = new HajiLaneDetailFragment();
                break;
            case 5:
                fragmentView = new EvertonDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.artslocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.artslocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 6;
    }

}
