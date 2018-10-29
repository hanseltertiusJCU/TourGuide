package com.example.android.tourguide.foodslocationfragmentdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguide.Location;
import com.example.android.tourguide.LocationDetailAdapter;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class TekkaDetailFragment extends Fragment {

    public TekkaDetailFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a new view object based on location_list_detail xml file
        View rootView = inflater.inflate(R.layout.location_list_detail, container, false);

        // Create a new ArrayList that returns Location class
        final ArrayList<Location> locationDetail = new ArrayList<Location>();

        // Add a new Location object onto ArrayList locationDetail
        locationDetail.add(new Location(getString(R.string.tekka_title), getString(R.string.tekka_content), R.drawable.image_tekka));

        // Create a new LocationDetailAdapter object
        LocationDetailAdapter adapter = new LocationDetailAdapter(getActivity(), locationDetail);

        ListView listView = (ListView) rootView.findViewById(R.id.list_detail);

        // Set the content of listView to contain the LocationAdapter object
        listView.setAdapter(adapter);

        return rootView;
    }
}
