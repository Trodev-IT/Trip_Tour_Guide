package com.trodev.tourtripguide.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.trodev.tourtripguide.fragments.HomeFragment;
import com.trodev.tourtripguide.R;
import com.trodev.tourtripguide.fragments.TourGroupFragment;

import java.util.Objects;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    SmoothBottomBar smoothBottomBar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*init all drawer layout*/
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        /*init views*/
        smoothBottomBar = findViewById(R.id.bottombar);


        // #######################
        // Drawer Layout implement
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // #################################################################
        // navigation view work process
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        /*When apps start show HomeFragments*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();


        /*set all status bar, navigation bar, toolbar color*/
        smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
        getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
        getWindow().setStatusBarColor(Color.parseColor("#2196F3"));


        /*smooth bar working process*/
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                if (i == 0) {
                    setTitle("Dashboard");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
                    getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
                    getWindow().setStatusBarColor(Color.parseColor("#2196F3"));

                }

                if (i == 1) {
                    setTitle("Tour Group");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new TourGroupFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
                    getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
                    getWindow().setStatusBarColor(Color.parseColor("#2196F3"));


                }

/*                if (i == 2) {
                    setTitle("Weather");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new WeatherFragment());
                    fragmentTransaction.commit();

                    *//*set all status bar, navigation bar, toolbar color*//*
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
                    getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
                    getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
                }*/

                return false;
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        int itemId = item.getItemId();

        if (itemId == R.id.menu_developer) {
            Toast.makeText(this, "Developer & Contact", Toast.LENGTH_SHORT).show();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.contact_bottomsheet_layout);

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);
        } else if (itemId == R.id.menu_ticket_manager) {
            Toast.makeText(this, "Keep your ticket safe", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, TicketManagerActivity.class));

        } else if (itemId == R.id.menu_notification) {
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        } else if (itemId == R.id.menu_weather) {
            Toast.makeText(this, "Check Weather", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, WeatherActivity.class));

        } else if (itemId == R.id.menu_privacy) {
            startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
            Toast.makeText(this, "Privacy Policy", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_apps) {
            Toast.makeText(this, "Our Apps", Toast.LENGTH_SHORT).show();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6580660399707616800")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6580660399707616800")));
            }
        }

        return super.onOptionsItemSelected(item);
    }

    // In this code, android lifecycle exit on 2 times back-pressed.
    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

}