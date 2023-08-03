package com.trodev.tourtripguide.fragments;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trodev.tourtripguide.ConnectionRecevier;
import com.trodev.tourtripguide.R;
import com.trodev.tourtripguide.activities.DhakaActivity;


public class HomeFragment extends Fragment {
    LinearLayout dhakaLl;
    CardView dhakaCv;
    BroadcastReceiver broadcastReceiver;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*init views*/
        dhakaLl = view.findViewById(R.id.dhakaLl);
        dhakaCv = view.findViewById(R.id.dhakaCv);

        broadcastReceiver = new ConnectionRecevier();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerNetworkBroadcast();
        }

        /*set on click listener*/
        dhakaCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isConnected(getContext())) {
                    startActivity(new Intent(getContext(), DhakaActivity.class));
                    Toast.makeText(getContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
                } else {
                    showDialog();
                    Toast.makeText(getContext(), "Internet Disconnect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    public boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.alert_dialog_layout, null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnOk = view.findViewById(R.id.btnOk);
        builder.setView(view);

        final Dialog dialog = builder.create();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void registerNetworkBroadcast() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
    }

    protected void unregistorNetwork(BroadcastReceiver broadcastReceiver) {
        try {
            unregistorNetwork(this.broadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}