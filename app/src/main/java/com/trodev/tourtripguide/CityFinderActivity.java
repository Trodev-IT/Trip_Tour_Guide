package com.trodev.tourtripguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CityFinderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        // set title in activity
        getSupportActionBar().setTitle("Search Location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}