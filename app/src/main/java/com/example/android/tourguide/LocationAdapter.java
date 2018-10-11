package com.example.android.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    // Create constructor for LocationAdapter in order to be used on the Fragment
    public LocationAdapter(Activity context, ArrayList<Location> locations){
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Convert View into listItemView, which is the variable to be returned
        View listItemView = convertView;
        // Check if existing view is being reused, otherwise inflate the view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the ImageView from {@link list_item} with the ID location_image
        ImageView resourceImageView = (ImageView) listItemView.findViewById(R.id.location_image);
        // Set the value of image resource from {@link Location}
        resourceImageView.setImageResource(currentLocation.getImageResource());

        // Find the TextView from {@link list_item} with the ID location_title
        TextView locationTitleTextView = (TextView) listItemView.findViewById(R.id.location_title);
        // Set the value of location title from {@link Location}
        locationTitleTextView.setText(currentLocation.getLocationTitle());

        // Find the TextView from {@link list_item} with the ID location_content
        TextView locationContentTextView = (TextView) listItemView.findViewById(R.id.location_content);
        // Set the value of location content from {@link Location}
        locationContentTextView.setText(currentLocation.getLocationContent());

        return listItemView;
    }




}
