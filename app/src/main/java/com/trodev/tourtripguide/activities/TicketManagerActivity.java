package com.trodev.tourtripguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.trodev.tourtripguide.R;
import com.trodev.tourtripguide.UploadTicketActivity;

public class TicketManagerActivity extends AppCompatActivity {

    FloatingActionButton addRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_manager);

        // set title in activity
        getSupportActionBar().setTitle("Ticket managements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addRecord = findViewById(R.id.addRecord);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TicketManagerActivity.this, UploadTicketActivity.class));
            }
        });

    }
}