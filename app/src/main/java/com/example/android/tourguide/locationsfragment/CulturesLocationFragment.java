package com.example.android.tourguide.locationsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguide.DetailActivity;
import com.example.android.tourguide.Location;
import com.example.android.tourguide.LocationAdapter;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class CulturesLocationFragment extends Fragment {

    public CulturesLocationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create ArrayList object that returns Location class
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.fengshui_title), getString(R.string.fengshui_content), R.drawable.image_fengshui));
        locations.add(new Location(getString(R.string.sultan_of_spice_title), getString(R.string.sultan_of_spice_content), R.drawable.image_sultan_of_spice));
        locations.add(new Location(getString(R.string.india_title), getString(R.string.india_content), R.drawable.image_india));
        locations.add(new Location(getString(R.string.chinese_title), getString(R.string.chinese_content), R.drawable.image_chinese));
        locations.add(new Location(getString(R.string.religion_title), getString(R.string.religion_content), R.drawable.image_religion));

        // Create LocationAdapter object that set up view
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Set listView to contain LocationAdapter object
        listView.setAdapter(adapter);

        // Actions when listView got clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Make a new intent
                Intent locationDetailIntent = new Intent(getActivity(), DetailActivity.class);
                // Put extra on intent in order to be able to pass the item position
                locationDetailIntent.putExtra("ItemPosition", position);

                startActivity(locationDetailIntent);

            }
        });

        return rootView;
    }

}
