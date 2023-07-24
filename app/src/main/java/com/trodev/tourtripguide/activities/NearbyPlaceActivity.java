package com.trodev.tourtripguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.tourtripguide.R;

public class NearbyPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_place);

        // set title in activity
        getSupportActionBar().setTitle("Near By Places");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}