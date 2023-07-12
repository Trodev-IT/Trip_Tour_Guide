package com.trodev.tourtripguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.tourtripguide.R;

public class PrivacyPolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        // set title in activity
        getSupportActionBar().setTitle("Privacy Policy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}