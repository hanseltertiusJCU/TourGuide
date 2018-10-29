package com.example.android.tourguide.architecturelocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ArchitectureLocationFragmentPagerAdapter extends FragmentPagerAdapter {
    public ArchitectureLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new CHIJMESDetailFragment();
                break;
            case 1:
                fragmentView = new EsplanadeDetailFragment();
                break;
            case 2:
                fragmentView = new MerlionDetailFragment();
                break;
            case 3:
                fragmentView = new SingaporeFlyerDetailFragment();
                break;
            case 4:
                fragmentView = new OldParliamentDetailFragment();
                break;
            case 5:
                fragmentView = new NationalGalleryDetailFragment();
                break;
            case 6:
                fragmentView = new IstanaDetailFragment();
                break;
            case 7:
                fragmentView = new FullertonDetailFragment();
                break;
            case 8:
                fragmentView = new HelixBridgeDetailFragment();
                break;
            case 9:
                fragmentView = new ParkviewDetailFragment();
                break;
            case 10:
                fragmentView = new CenotaphDetailFragment();
                break;
            case 11:
                fragmentView = new MarinaBayDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.architecturelocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.architecturelocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 12;
    }
}
