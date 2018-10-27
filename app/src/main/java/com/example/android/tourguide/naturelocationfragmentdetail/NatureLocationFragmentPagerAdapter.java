package com.example.android.tourguide.naturelocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NatureLocationFragmentPagerAdapter extends FragmentPagerAdapter {
    public NatureLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new BotanicGardensDetailFragment();
                break;
            case 1:
                fragmentView = new GardensByTheBayDetailFragment();
                break;
            case 2:
                fragmentView = new SouthernRidgesDetailFragment();
                break;
            case 3:
                fragmentView = new SegwayEcoAdventureDetailFragment();
                break;
            case 4:
                fragmentView = new PulauUbinDetailFragment();
                break;
            case 5:
                fragmentView = new SungeiBulohDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.naturelocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.naturelocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 6;
    }
}
