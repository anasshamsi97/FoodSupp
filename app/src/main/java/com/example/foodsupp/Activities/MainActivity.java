package com.example.foodsupp.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.foodsupp.Adapters.RVDealsAdapter;
import com.example.foodsupp.Adapters.RVDealsFeaturedSpecialOfferAdapter;
import com.example.foodsupp.POJO.Deals;
import com.example.foodsupp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;
    private RecyclerView allRestaurants, featured, specialOffers;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Deals> dealsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChatActivity.class));
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        allRestaurants = findViewById(R.id.rv_all_restuarants);
        featured = findViewById(R.id.rv_featured);
        specialOffers = findViewById(R.id.rv_special_offers);
        populateDeals();
        initAllRestaurantsRV();
        initFeaturedRV();
        initSpecialOffersRV();
    }

    private void initSpecialOffersRV() {
        specialOffers.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        specialOffers.setAdapter(new RVDealsFeaturedSpecialOfferAdapter(dealsArrayList,this));
    }

    private void initFeaturedRV() {
        featured.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        featured.setAdapter(new RVDealsFeaturedSpecialOfferAdapter(dealsArrayList,this));
    }


    private void initAllRestaurantsRV() {
        allRestaurants.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        allRestaurants.setAdapter(new RVDealsAdapter(dealsArrayList,this));
    }

    private void populateDeals() {
        dealsArrayList = new ArrayList<>();

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

        dealsArrayList.add(new Deals("<font color=#808080>Delivery time :</font>" +
                "<font color=#000>49 mins</font>"
                , "Rs 900", "Bar B Que Rolls"));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_my_cart) {
            startActivity(new Intent(this, MyCartActivity.class));
        } else if (id == R.id.nav_chat) {
            startActivity(new Intent(this, ChatActivity.class));
        } else if (id == R.id.nav_my_orders) {
            startActivity(new Intent(this, MyOrdersActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_contact_us) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"appfeedback@foodpanda.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "App feedback");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

