package com.trodev.tourtripguide.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.trodev.tourtripguide.R;
import com.trodev.tourtripguide.activities.BangladeshActivity;


public class HomeFragment extends Fragment {

    LinearLayout dhakaLl;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        /*init views*/
        dhakaLl = view.findViewById(R.id.dhakaLl);

        /*set on click listener*/
        dhakaLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BangladeshActivity.class));
            }
        });

        return view;
    }
}