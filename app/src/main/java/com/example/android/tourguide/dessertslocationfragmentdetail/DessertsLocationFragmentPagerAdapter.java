package com.example.android.tourguide.dessertslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DessertsLocationFragmentPagerAdapter extends FragmentPagerAdapter{

    public DessertsLocationFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragmentView;

        switch (position){
            case 0:
                fragmentView = new ChendolDetailFragment();
                break;
            case 1:
                fragmentView = new TauHuayDetailFragment();
                break;
            case 2:
                fragmentView = new PulutHitamDetailFragment();
                break;
            case 3:
                fragmentView = new IceKachangDetailFragment();
                break;
            case 4:
                fragmentView = new GulabJamunDetailFragment();
                break;
            case 5:
                fragmentView = new ChengTengDetailFragment();
                break;
            case 6:
                fragmentView = new BuburChaChaDetailFragment();
                break;
            case 7:
                fragmentView = new SugeeDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.dessertslocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.dessertslocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 8;
    }
}
