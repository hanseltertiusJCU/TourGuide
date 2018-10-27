package com.example.android.tourguide.locationsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguide.DetailActivity;
import com.example.android.tourguide.Location;
import com.example.android.tourguide.LocationAdapter;
import com.example.android.tourguide.MainActivity;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class NatureLocationFragment extends Fragment{

    public NatureLocationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create ArrayList object that returns Location class
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.botanic_gardens_title), getString(R.string.botanic_gardens_content), R.drawable.image_botanic_gardens));
        locations.add(new Location(getString(R.string.gardens_by_the_bay_title), getString(R.string.gardens_by_the_bay_content), R.drawable.image_gardens_by_the_bay));
        locations.add(new Location(getString(R.string.southern_ridges_title), getString(R.string.southern_ridges_content), R.drawable.image_southern_ridges));
        locations.add(new Location(getString(R.string.segway_eco_adventure_title), getString(R.string.segway_eco_adventure_content), R.drawable.image_segway_eco_adventure));
        locations.add(new Location(getString(R.string.pulau_ubin_title), getString(R.string.pulau_ubin_content), R.drawable.image_pulau_ubin));
        locations.add(new Location(getString(R.string.sungei_buloh_title), getString(R.string.sungei_buloh_content), R.drawable.image_sungei_buloh));

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
                // Create a menuItem object by finding it based on navigation id
                MenuItem menuItem = ((MainActivity) getActivity()).getSpecificMenu().findItem(R.id.nav_landmarks);
                // Get the itemId based on MenuItem object
                int itemId = menuItem.getItemId();
                // Put extra on intent in order to be able to pass the item position as well as itemId into the specified Activity
                locationDetailIntent.putExtra("ItemPosition", position);
                locationDetailIntent.putExtra("ItemId", itemId);

                startActivity(locationDetailIntent);

            }
        });

        return rootView;
    }
}
