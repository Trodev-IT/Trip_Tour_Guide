package com.trodev.tourtripguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.tourtripguide.R;

public class TicketManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_manager);

        // set title in activity
        getSupportActionBar().setTitle("Ticket managements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}