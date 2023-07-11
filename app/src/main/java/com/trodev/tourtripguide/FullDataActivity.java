package com.trodev.tourtripguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullDataActivity extends AppCompatActivity {

    TextView nameTv, shortbioTv, historyheadTv, historybioTv;
    ImageView imageIv;
    String name, shortbio, historyhead, historybio, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_data);

        /*init views*/
        nameTv = findViewById(R.id.name);
        shortbioTv = findViewById(R.id.shortbio);
        historyheadTv = findViewById(R.id.historyhead);
        historybioTv = findViewById(R.id.historybio);
        imageIv = findViewById(R.id.image);

        /*get data from custom adapter*/
        name = getIntent().getStringExtra("name");
        shortbio = getIntent().getStringExtra("shortbio");
        historyhead = getIntent().getStringExtra("historyhead");
        historybio = getIntent().getStringExtra("historybio");
        image = getIntent().getStringExtra("img");

        /*get image on json data*/
        Glide
                .with(FullDataActivity.this)
                .load(image)
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(imageIv);

        /*set data on views*/
        nameTv.setText(name);
        shortbioTv.setText(shortbio);
        historyheadTv.setText(historyhead);
        historybioTv.setText(historybio);

    }
}