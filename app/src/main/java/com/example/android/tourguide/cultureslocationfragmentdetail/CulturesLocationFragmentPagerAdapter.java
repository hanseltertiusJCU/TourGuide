package com.example.android.tourguide.cultureslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguide.dessertslocationfragmentdetail.BuburChaChaDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.ChendolDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.ChengTengDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.GulabJamunDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.IceKachangDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.PulutHitamDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.SugeeDetailFragment;
import com.example.android.tourguide.dessertslocationfragmentdetail.TauHuayDetailFragment;

public class CulturesLocationFragmentPagerAdapter extends FragmentPagerAdapter {


    public CulturesLocationFragmentPagerAdapter(FragmentManager fm){
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
                fragmentView = new FengshuiDetailFragment();
                break;
            case 1:
                fragmentView = new SultanOfSpiceDetailFragment();
                break;
            case 2:
                fragmentView = new IndiaDetailFragment();
                break;
            case 3:
                fragmentView = new ChineseDetailFragment();
                break;
            case 4:
                fragmentView = new ReligionDetailFragment();
                break;
            default:
                fragmentView = null;
                break;
        }
        // Return a Fragment object based on Fragment class in
        // com.example.android.tourguide.cultureslocationfragmentdetail
        return fragmentView;
    }

    /**
     * Get a total number of fragments
     * @return number of fragments in com.example.android.tourguide.cultureslocationfragmentdetail
     */
    @Override
    public int getCount() {
        return 5;
    }

}
