package com.example.android.tourguide;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.android.tourguide.architecturelocationfragmentdetail.ArchitectureLocationFragmentPagerAdapter;
import com.example.android.tourguide.artslocationfragmentdetail.ArtsLocationFragmentPagerAdapter;
import com.example.android.tourguide.cultureslocationfragmentdetail.CulturesLocationFragmentPagerAdapter;
import com.example.android.tourguide.dessertslocationfragmentdetail.DessertsLocationFragmentPagerAdapter;
import com.example.android.tourguide.foodslocationfragmentdetail.FoodLocationFragmentPagerAdapter;
import com.example.android.tourguide.historylocationfragmentdetail.HistoryLocationFragmentPagerAdapter;
import com.example.android.tourguide.naturelocationfragmentdetail.NatureLocationFragmentPagerAdapter;
import com.example.android.tourguide.shopslocationfragmentdetail.ShopsLocationFragmentPagerAdapter;

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

        // Create an int variable position based on the intent from LocationFragment
        int position = intent.getIntExtra("ItemPosition", 0);

        // Create an int variable itemId based on the intent from LocationFragment (maybe the itemid is useful when click up button so that it can go back to the previous itemid)
        int itemId = intent.getIntExtra("ItemId", 0);

        // Check the itemId to display the right FragmentPagerAdapter object,
        // which uses polymorphism in the process and then attached to ViewPager
        switch (itemId){
            case R.id.nav_shop:
                fragmentPagerAdapter = new ShopsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_history:
                fragmentPagerAdapter = new HistoryLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_arts:
                fragmentPagerAdapter = new ArtsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_architecture:
                fragmentPagerAdapter = new ArchitectureLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_nature:
                fragmentPagerAdapter = new NatureLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_culture:
                fragmentPagerAdapter = new CulturesLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_food:
                fragmentPagerAdapter = new FoodLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            case R.id.nav_dessert:
                fragmentPagerAdapter = new DessertsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
                break;
            default:
                fragmentPagerAdapter = new ShopsLocationFragmentPagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(fragmentPagerAdapter);
        }

        // Set the fragment from fragmentPagerAdapter object based on position of ArrayList
        viewPager.setCurrentItem(position);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup up button view
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }
}
