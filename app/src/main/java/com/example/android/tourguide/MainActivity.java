package com.example.android.tourguide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.tourguide.locationsfragment.ArchitectureLocationFragment;
import com.example.android.tourguide.locationsfragment.ArtsLocationFragment;
import com.example.android.tourguide.locationsfragment.CulturesLocationFragment;
import com.example.android.tourguide.locationsfragment.DessertsLocationFragment;
import com.example.android.tourguide.locationsfragment.FoodLocationFragment;
import com.example.android.tourguide.locationsfragment.HistoryLocationFragment;
import com.example.android.tourguide.locationsfragment.NatureLocationFragment;
import com.example.android.tourguide.locationsfragment.ShopsLocationFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Fragment fragment;
    private Class fragmentClass;
    private NavigationView navigationView;
    private static boolean RUN_ONCE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup drawer view
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                // Create a new FragmentManager object
                FragmentManager fragmentManager;

                // set item as selected to persist highlight
                menuItem.setChecked(true);

                // set action bar title
                // setTitle(menuItem.getTitle());
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here (in this case, we use case)
                switch (menuItem.getItemId()){
                    case R.id.nav_shop:
                        fragmentClass = ShopsLocationFragment.class;
                        break;
                    case R.id.nav_history:
                        fragmentClass = HistoryLocationFragment.class;
                        break;
                    case R.id.nav_arts:
                        fragmentClass = ArtsLocationFragment.class;
                        break;
                    case R.id.nav_architecture:
                        fragmentClass = ArchitectureLocationFragment.class;
                        break;
                    case R.id.nav_nature:
                        fragmentClass = NatureLocationFragment.class;
                        break;
                    case R.id.nav_culture:
                        fragmentClass = CulturesLocationFragment.class;
                        break;
                    case R.id.nav_food:
                        fragmentClass = FoodLocationFragment.class;
                        break;
                    case R.id.nav_dessert:
                        fragmentClass = DessertsLocationFragment.class;
                        break;

                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.content_frame, fragment).commit();

                return true;
            }
        });

        runOnce();

        // load the existing fragment after clicking up/back button
        if(RUN_ONCE = false){
            Intent i = new Intent(this, DetailActivity.class);
            startActivityForResult(i, 1);
        }

    }

    // A method to detect the first time an Activity is opened
    private void runOnce(){
        if(RUN_ONCE){
            RUN_ONCE = false;

            // If it is first time, that means we check the default
            // Create a new Menu object by calling getSpecificMenu method
            Menu menu = getSpecificMenu();
            // Make sure that the menu is checked on startup
            menu.getItem(0).setChecked(true);
            // Display the default fragment on startup
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.content_frame, new ShopsLocationFragment());
            tx.commit();
        }
    }

    // A method to set action bar title
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    // A method to get item menu (which is then used for getting item id)
    public Menu getSpecificMenu(){
        Menu menuNav = navigationView.getMenu();
        return menuNav;
    }

    // Opens up the nav drawer menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    // Get the intent itemId to display the activity result
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                // Set the result by getting the intent from DetailActivity
                getIntent().getStringExtra("ItemIdMenu");
            }
        }
    }
}
