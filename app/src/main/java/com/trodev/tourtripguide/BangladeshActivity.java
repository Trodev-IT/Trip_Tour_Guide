package com.trodev.tourtripguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BangladeshActivity extends AppCompatActivity {
    private static final String json_url = "https://zobayer-dev-e12aa.web.app/dhaka_place.json";
    RecyclerView recyclerView;
    List<ModelClass> list;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladesh);

        getSupportActionBar().hide();

        /*init views*/
        recyclerView = findViewById(R.id.dataRv);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        list = new ArrayList<>();

        GetData getData = new GetData();
        getData.execute();


    }


    public class GetData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(json_url);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data != -1) {
                    current += (char) data;
                    data = inputStreamReader.read();
                }

                return current;
            } catch (Exception e) {

            } finally {
                if (urlConnection != null) {

                    urlConnection.disconnect();
                }
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {

                progressBar.setVisibility(View.INVISIBLE);

                JSONObject jsonObject = new JSONObject(s);

                JSONArray jsonArray = jsonObject.getJSONArray("detailsinfo");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    /*create model class variable, object*/
                    ModelClass modelClass = new ModelClass();

                    /*set data on recyclerview*/
                    modelClass.setName(jsonObject1.getString("name"));

                    modelClass.setHistoryhead(jsonObject1.getString("historyhead"));

                    modelClass.setHistorybio(jsonObject1.getString("historybio"));

                    modelClass.setShortbio(jsonObject1.getString("shortbio"));

                    modelClass.setImg(jsonObject1.getString("image"));

                    /*add model data on empty model class*/
                    list.add(modelClass);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            PutDataIntoRecyclerview(list);
        }
    }

    private void PutDataIntoRecyclerview(List<ModelClass> list) {

        progressBar.setVisibility(View.INVISIBLE);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(customAdapter);

    }
}
