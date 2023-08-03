package com.trodev.tourtripguide.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.trodev.tourtripguide.R;

public class NotificationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // set title in activity
        getSupportActionBar().setTitle("Near By Places");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}