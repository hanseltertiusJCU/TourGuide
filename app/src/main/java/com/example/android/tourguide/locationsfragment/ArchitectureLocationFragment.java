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

public class ArchitectureLocationFragment extends Fragment {

    public ArchitectureLocationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create ArrayList object that returns Location class
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.chijmes_title), getString(R.string.chijmes_content), R.drawable.image_chijmes));
        locations.add(new Location(getString(R.string.esplanade_title), getString(R.string.esplanade_content), R.drawable.image_esplanade));
        locations.add(new Location(getString(R.string.merlion_title), getString(R.string.merlion_content), R.drawable.image_merlion));
        locations.add(new Location(getString(R.string.singapore_flyer_title), getString(R.string.singapore_flyer_content), R.drawable.image_singapore_flyer));
        locations.add(new Location(getString(R.string.old_parliament_title), getString(R.string.old_parliament_content), R.drawable.image_old_parliament));
        locations.add(new Location(getString(R.string.national_gallery_title), getString(R.string.national_gallery_content), R.drawable.image_national_gallery));
        locations.add(new Location(getString(R.string.istana_title), getString(R.string.istana_content), R.drawable.image_istana));
        locations.add(new Location(getString(R.string.fullerton_title), getString(R.string.fullerton_content), R.drawable.image_fullerton));
        locations.add(new Location(getString(R.string.helix_bridge_title), getString(R.string.helix_bridge_content), R.drawable.image_helix));
        locations.add(new Location(getString(R.string.parkview_title), getString(R.string.parkview_content), R.drawable.image_parkview));
        locations.add(new Location(getString(R.string.cenotaph_title), getString(R.string.cenotaph_content), R.drawable.image_cenotaph));
        locations.add(new Location(getString(R.string.marina_bay_title), getString(R.string.marina_bay_content), R.drawable.image_marina_bay));

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
                MenuItem menuItem = ((MainActivity) getActivity()).getSpecificMenu().findItem(R.id.nav_architecture);
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

    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.architecture_title));

    }
}
