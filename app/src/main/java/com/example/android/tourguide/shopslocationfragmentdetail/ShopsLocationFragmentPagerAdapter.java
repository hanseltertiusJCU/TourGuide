package com.example.android.tourguide.shopslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguide.naturelocationfragmentdetail.BotanicGardensDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.GardensByTheBayDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.PulauUbinDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.SegwayEcoAdventureDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.SouthernRidgesDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.SungeiBulohDetailFragment;

public class ShopsLocationFragmentPagerAdapter extends FragmentPagerAdapter {

    public ShopsLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new ShillaDetailFragment();
                break;
            case 1:
                fragmentView = new GassanDetailFragment();
                break;
            case 2:
                fragmentView = new DFSWinesDetailFragment();
                break;
            case 3:
                fragmentView = new DFSWinesTanahMerahDetailFragment();
                break;
            case 4:
                fragmentView = new DFSWinesHarbourFrontDetailFragment();
                break;
            case 5:
                fragmentView = new TGalleriaDetailFragment();
                break;
            case 6:
                fragmentView = new TangsDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.shopslocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.shopslocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 7;
    }
}
