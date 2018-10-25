package com.example.android.tourguide.locationsfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguide.Location;
import com.example.android.tourguide.LocationAdapter;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class DessertsLocationFragment extends Fragment{

    public DessertsLocationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.chendol_title), getString(R.string.chendol_content), R.drawable.image_chendol));
        locations.add(new Location(getString(R.string.tau_huay_title), getString(R.string.tau_huay_content), R.drawable.image_tau_huay));
        locations.add(new Location(getString(R.string.pulut_hitam_title), getString(R.string.pulut_hitam_content), R.drawable.image_pulut_hitam));
        locations.add(new Location(getString(R.string.ice_kachang_title), getString(R.string.ice_kachang_content), R.drawable.image_ice_kachang));
        locations.add(new Location(getString(R.string.gulab_jamun_title), getString(R.string.gulab_jamun_content), R.drawable.image_gulab_jamun));
        locations.add(new Location(getString(R.string.cheng_teng_title), getString(R.string.cheng_teng_content), R.drawable.image_cheng_teng));
        locations.add(new Location(getString(R.string.bubur_chacha_title), getString(R.string.bubur_chacha_content), R.drawable.image_bubur_chacha));
        locations.add(new Location(getString(R.string.sugee_title), getString(R.string.sugee_content), R.drawable.image_sugee_cake));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
