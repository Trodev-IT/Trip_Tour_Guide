package com.trodev.tourtripguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.trodev.tourtripguide.R;

public class CityFinderActivity extends AppCompatActivity {

    RelativeLayout done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        // set title in activity
        getSupportActionBar().setTitle("Search City");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final EditText editText = findViewById(R.id.searchCity);
        done = findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newCity = editText.getText().toString();
                Intent intent = new Intent(CityFinderActivity.this, WeatherActivity.class);
                intent.putExtra("City", newCity);
                startActivity(intent);
                finishAffinity();

            }
        });
    }

}