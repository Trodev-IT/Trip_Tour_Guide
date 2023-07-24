package com.trodev.tourtripguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.trodev.tourtripguide.activities.UploadTicketActivity;

public class TicketManagerActivity extends AppCompatActivity {
    FloatingActionButton addRecord;
    RecyclerView recordRv;
    MyHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_manager);


        getSupportActionBar().setTitle("Ticket managements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addRecord = findViewById(R.id.addRecord);
        recordRv = findViewById(R.id.recordRv);

        //init db
        dbHelper = new MyHelper(this);

        //load records
        loadREcords();

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TicketManagerActivity.this, UploadTicketActivity.class));
            }
        });

    }

    private void loadREcords() {

        AdapterRecord adapterRecord = new AdapterRecord(TicketManagerActivity.this, dbHelper.getAllRecords(Constants.C_ADDED_TIMESTAMP + "  DESC"));

        recordRv.setAdapter(adapterRecord);

    }


    private void searchRecords(String query) {

        AdapterRecord adapterRecord = new AdapterRecord(TicketManagerActivity.this, dbHelper.searchAllRecords(query));

        recordRv.setAdapter(adapterRecord);
        getSupportActionBar().setSubtitle("Total: " + dbHelper.getRecordsCount());

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadREcords();
    }


    /*search code*/
    /*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu
        getMenuInflater().inflate(R.menu.menu_ticket, menu);

        //searchView
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecords(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //
                searchRecords(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}