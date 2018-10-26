package com.example.android.tourguide;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.tourguide.cultureslocationfragmentdetail.CulturesLocationFragmentPagerAdapter;
import com.example.android.tourguide.dessertslocationfragmentdetail.DessertsLocationFragmentPagerAdapter;
import com.example.android.tourguide.locationsfragment.CulturesLocationFragment;
import com.example.android.tourguide.locationsfragment.DessertsLocationFragment;

public class DetailActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Find the ViewPager id to refer to the PagerAdapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.locationDetailViewPager);

        // Get the intent
        Intent intent = getIntent();

        // Create a int variable position based on the intent from LocationFragment
        int position = intent.getIntExtra("ItemPosition", 0);

        int itemId = intent.getIntExtra("ItemId", 0);

        // Create an adapter to be attached to ViewPager
        // (todo: we will use if/else or case from the Fragment thing, which decides on which fragments to use)
        switch (itemId){
            case R.id.nav_shop:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_history:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_arts:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_landmarks:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_culture:
                fragmentPagerAdapter = new CulturesLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_food:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_dessert:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            default:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
        }

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
