package com.trodev.tourtripguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.trodev.tourtripguide.R;

public class WeatherFragment extends Fragment {

    /*import widget*/
    RelativeLayout cityFinder;


    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        /*init views id*/
        cityFinder = view.findViewById(R.id.cityFinder);

        /*onClick listener on button*/
        cityFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), CityFinderActivity.class);
                getContext().startActivity(intent);
                Toast.makeText(getContext(), "Check Weather", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}