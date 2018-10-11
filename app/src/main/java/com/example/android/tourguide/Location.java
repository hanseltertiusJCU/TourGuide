package com.example.android.tourguide;

public class Location {
    private String mLocationTitle;
    private String mLocationContent;
    private int mImageResource;

    public Location(String locationTitle, String locationContent, int imageResource){
        mLocationTitle = locationTitle;
        mLocationContent = locationContent;
        mImageResource = imageResource;
    }

    public String getLocationTitle() {
        return mLocationTitle;
    }

    public String getLocationContent() {
        return mLocationContent;
    }

    public int getImageResource() {
        return mImageResource;
    }
}
