package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.android.tourguide.locationsfragment.CulturesLocationFragment;
import com.example.android.tourguide.locationsfragment.DessertsLocationFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Fragment fragment;
    private Class fragmentClass;

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

        NavigationView navigationView = findViewById(R.id.nav_view);
        // todo: modify the behaviour so that the default fragment is displayed when opening the app and when leaving the page, still save the existing fragment
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
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
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    case R.id.nav_history:
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    case R.id.nav_arts:
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    case R.id.nav_landmarks:
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    case R.id.nav_culture:
                        fragmentClass = CulturesLocationFragment.class;
                        break;
                    case R.id.nav_food:
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    case R.id.nav_dessert:
                        fragmentClass = DessertsLocationFragment.class;
                        break;
                    default:
                        fragmentClass = DessertsLocationFragment.class;

                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.content_frame, fragment).commit();

                return true;
            }
        });


//        // Setup drawer view
//        setupDrawerContent(navigationView);
    }


//    private void setupDrawerContent(NavigationView navigationView) {
//        navigationView.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//                        selectDrawerItem(menuItem);
//                        return true;
//                    }
//                });
//    }
//
//    // todo: modify the behaviour so that the default fragment is displayed and when leaving the page, still save the existing fragment
//    public void selectDrawerItem(MenuItem menuItem) {
//        // Add code here to update the UI based on the item selected
//        // For example, swap UI fragments here (in this case, we use case)
//        switch (menuItem.getItemId()){
//            case R.id.nav_shop:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            case R.id.nav_history:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            case R.id.nav_arts:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            case R.id.nav_landmarks:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            case R.id.nav_culture:
//                fragmentClass = CulturesLocationFragment.class;
//                break;
//            case R.id.nav_food:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            case R.id.nav_dessert:
//                fragmentClass = DessertsLocationFragment.class;
//                break;
//            default:
//                fragmentClass = DessertsLocationFragment.class;
//
//        }
//
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().
//                replace(R.id.content_frame, fragment).commit();
//
//        // set item as selected to persist highlight
//        menuItem.setChecked(true);
//        // set action bar title
//        // setTitle(menuItem.getTitle());
//        // close drawer when item is tapped
//        mDrawerLayout.closeDrawers();
//    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    };
}
