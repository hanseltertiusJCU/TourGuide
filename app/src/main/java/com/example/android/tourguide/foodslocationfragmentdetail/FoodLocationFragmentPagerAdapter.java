package com.example.android.tourguide.foodslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FoodLocationFragmentPagerAdapter extends FragmentPagerAdapter{

    public FoodLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new MaxwellFoodDetailFragment();
                break;
            case 1:
                fragmentView = new LauPaSatDetailFragment();
                break;
            case 2:
                fragmentView = new TekkaDetailFragment();
                break;
            case 3:
                fragmentView = new TiongBahruMarketDetailFragment();
                break;
            case 4:
                fragmentView = new ABCFoodCentreDetailFragment();
                break;
            case 5:
                fragmentView = new AdamRoadDetailFragment();
                break;
            case 6:
                fragmentView = new ChompChompDetailFragment();
                break;
            case 7:
                fragmentView = new GoldenMileDetailFragment();
                break;
            case 8:
                fragmentView = new BedokMarketplaceDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.foodlocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.foodlocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 9;
    }
}
