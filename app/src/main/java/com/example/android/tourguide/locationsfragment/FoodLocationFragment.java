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

public class FoodLocationFragment extends Fragment {

    public FoodLocationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create ArrayList object that returns Location class
        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(getString(R.string.maxwell_food_title), getString(R.string.maxwell_food_content), R.drawable.image_maxwell));
        locations.add(new Location(getString(R.string.lau_pa_sat_title), getString(R.string.lau_pa_sat_content), R.drawable.image_lau_pa_sat));
        locations.add(new Location(getString(R.string.tekka_title), getString(R.string.tekka_content), R.drawable.image_tekka));
        locations.add(new Location(getString(R.string.tiong_bahru_market_title), getString(R.string.tiong_bahru_market_content), R.drawable.image_tiong_bahru_market));
        locations.add(new Location(getString(R.string.abc_food_centre_title), getString(R.string.abc_food_centre_content), R.drawable.image_abc_food_centre));
        locations.add(new Location(getString(R.string.adam_road_title), getString(R.string.adam_road_content), R.drawable.image_adam_road));
        locations.add(new Location(getString(R.string.chomp_chomp_title), getString(R.string.chomp_chomp_content), R.drawable.image_chomp_chomp));
        locations.add(new Location(getString(R.string.golden_mile_title), getString(R.string.golden_mile_content), R.drawable.image_golden_mile));
        locations.add(new Location(getString(R.string.bedok_marketplace_title), getString(R.string.bedok_marketplace_content), R.drawable.image_bedok_marketplace));

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
                MenuItem menuItem = ((MainActivity) getActivity()).getSpecificMenu().findItem(R.id.nav_food);
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
                .setActionBarTitle(getString(R.string.food_title));

    }
}
