package com.example.android.tourguide.dessertslocationfragmentdetail;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguide.DetailActivity;
import com.example.android.tourguide.Location;
import com.example.android.tourguide.LocationDetailAdapter;
import com.example.android.tourguide.MainActivity;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class GulabJamunDetailFragment extends Fragment {
    // Constructor for calling an object
    public GulabJamunDetailFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a new view object based on location_list_detail xml file
        View rootView = inflater.inflate(R.layout.location_list_detail, container, false);

        // Create a new ArrayList that returns Location class
        final ArrayList<Location> locationDetail = new ArrayList<Location>();

        // Add a new Location object onto ArrayList locationDetail
        locationDetail.add(new Location(getString(R.string.gulab_jamun_title), getString(R.string.gulab_jamun_content), R.drawable.image_gulab_jamun));

        // Create a new LocationDetailAdapter object
        LocationDetailAdapter adapter = new LocationDetailAdapter(getActivity(), locationDetail);

        ListView listView = (ListView) rootView.findViewById(R.id.list_detail);

        // Set the content of listView to contain the LocationAdapter object
        listView.setAdapter(adapter);

        return rootView;
    }

//    public void onResume(){
//        super.onResume();
//
//        // Set title bar
//        ((DetailActivity) getActivity())
//                .setActionBarTitle(getString(R.string.gulab_jamun_title));
//
//    }

}
