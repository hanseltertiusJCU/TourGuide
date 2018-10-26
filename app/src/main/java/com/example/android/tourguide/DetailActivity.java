package com.example.android.tourguide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.tourguide.dessertslocationfragmentdetail.DessertsLocationFragmentPagerAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Find the ViewPager id to refer to the PagerAdapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.locationDetailViewPager);

        // Create an adapter to be attached to ViewPager
        DessertsLocationFragmentPagerAdapter locationDetailAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());

        // Create a int variable position based on the intent from LocationFragment
        int position = getIntent().getIntExtra("ItemPosition", 0);

        viewPager.setAdapter(locationDetailAdapter);

        // Set the fragment from locationDetailAdapter based on position of ArrayList
        viewPager.setCurrentItem(position);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup up button view
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }
}
