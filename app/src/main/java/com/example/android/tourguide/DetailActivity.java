package com.example.android.tourguide;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.tourguide.architecturelocationfragmentdetail.ArchitectureLocationFragmentPagerAdapter;
import com.example.android.tourguide.artslocationfragmentdetail.ArtsLocationFragmentPagerAdapter;
import com.example.android.tourguide.cultureslocationfragmentdetail.CulturesLocationFragmentPagerAdapter;
import com.example.android.tourguide.dessertslocationfragmentdetail.DessertsLocationFragmentPagerAdapter;
import com.example.android.tourguide.foodslocationfragmentdetail.FoodLocationFragmentPagerAdapter;
import com.example.android.tourguide.historylocationfragmentdetail.HistoryLocationFragmentPagerAdapter;
import com.example.android.tourguide.naturelocationfragmentdetail.BotanicGardensDetailFragment;
import com.example.android.tourguide.naturelocationfragmentdetail.NatureLocationFragmentPagerAdapter;
import com.example.android.tourguide.shopslocationfragmentdetail.ShopsLocationFragmentPagerAdapter;

public class DetailActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    private int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Find the ViewPager id to refer to the PagerAdapter
        final ViewPager viewPager = (ViewPager) findViewById(R.id.locationDetailViewPager);

        // Get the intent
        Intent intent = getIntent();

        // Create an int variable position based on the intent from LocationFragment
        int position = intent.getIntExtra("ItemPosition", 0);

        // Create an int variable itemId based on the intent from LocationFragment (maybe the itemid is useful when click up button so that it can go back to the previous itemid)
        itemId = intent.getIntExtra("ItemId", 0);

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

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup up button view
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        // Set the fragment from fragmentPagerAdapter object based on position of ArrayList
        viewPager.setCurrentItem(position);

        // Create a new OnPageChangeListener object
        ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // To know the position of Fragment in FragmentPagerAdapter that resides in ViewPager
                Toast.makeText(DetailActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                setActionBarTitle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        viewPager.addOnPageChangeListener(pageChangeListener);
        // Call the method onPageSelected in order to initiate
        pageChangeListener.onPageSelected(position);

    }

    /**
     * Set action bar title based on the FragmentPagerAdapter position in ViewPager
     * @param position position of the item to be clicked on in list view item
     */
    public void setActionBarTitle(int position) {
        // Check itemId for setting the actionbar title
        switch (itemId){
            case R.id.nav_shop:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.shilla_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.gassan_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.dfs_wines_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.dfs_wines_tanah_merah_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.dfs_wines_harbourfront_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.t_galleria_title));
                } else if (position == 6){
                    getSupportActionBar().setTitle(getString(R.string.tangs_title));
                }
                break;
            case R.id.nav_history:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.battlebox_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.east_coast_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.northern_resilience_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.southern_resilience_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.temasek_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.bukit_chandu_title));
                }
                break;
            case R.id.nav_arts:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.tiong_bahru_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.chinatown_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.little_india_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.macpherson_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.haji_lane_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.everton_title));
                }
                break;
            case R.id.nav_architecture:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.chijmes_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.esplanade_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.merlion_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.singapore_flyer_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.old_parliament_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.national_gallery_title));
                } else if (position == 6){
                    getSupportActionBar().setTitle(getString(R.string.istana_title));
                } else if (position == 7){
                    getSupportActionBar().setTitle(getString(R.string.fullerton_title));
                } else if (position == 8){
                    getSupportActionBar().setTitle(getString(R.string.helix_bridge_title));
                } else if (position == 9){
                    getSupportActionBar().setTitle(getString(R.string.parkview_title));
                } else if (position == 10){
                    getSupportActionBar().setTitle(getString(R.string.cenotaph_title));
                } else if (position == 11){
                    getSupportActionBar().setTitle(getString(R.string.marina_bay_title));
                }
                break;
            case R.id.nav_nature:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.botanic_gardens_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.gardens_by_the_bay_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.southern_ridges_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.segway_eco_adventure_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.pulau_ubin_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.sungei_buloh_title));
                }
                break;
            case R.id.nav_culture:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.fengshui_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.sultan_of_spice_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.india_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.chinese_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.religion_title));
                }
                break;
            case R.id.nav_food:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.maxwell_food_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.lau_pa_sat_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.tekka_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.tiong_bahru_market_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.abc_food_centre_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.adam_road_title));
                } else if (position == 6){
                    getSupportActionBar().setTitle(getString(R.string.chomp_chomp_title));
                } else if (position == 7){
                    getSupportActionBar().setTitle(getString(R.string.golden_mile_title));
                } else if (position == 8){
                    getSupportActionBar().setTitle(getString(R.string.bedok_marketplace_title));
                }
                break;
            case R.id.nav_dessert:
                if(position == 0){
                    getSupportActionBar().setTitle(getString(R.string.chendol_title));
                } else if (position == 1){
                    getSupportActionBar().setTitle(getString(R.string.tau_huay_title));
                } else if (position == 2){
                    getSupportActionBar().setTitle(getString(R.string.pulut_hitam_title));
                } else if (position == 3){
                    getSupportActionBar().setTitle(getString(R.string.ice_kachang_title));
                } else if (position == 4){
                    getSupportActionBar().setTitle(getString(R.string.gulab_jamun_title));
                } else if (position == 5){
                    getSupportActionBar().setTitle(getString(R.string.cheng_teng_title));
                } else if (position == 6){
                    getSupportActionBar().setTitle(getString(R.string.bubur_chacha_title));
                } else if (position == 7){
                    getSupportActionBar().setTitle(getString(R.string.sugee_title));
                }
                break;
        }
    }

    // Navigate up to parent activity while at the same time passing the itemId into it
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Set the activity result when pressed 'back' button
    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("ItemIdMenu", itemId);
        setResult(RESULT_OK, i);
        finish();
    }

}
