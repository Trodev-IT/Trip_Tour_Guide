package com.trodev.tourtripguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TicketManagerActivity extends AppCompatActivity {
    FloatingActionButton addRecord;
    RecyclerView recordRv;
    MyHelper dbHelper;

    //sort options
    String orderByNewest = Constants.C_ADDED_TIMESTAMP + " DESC";
    String orderByOldest = Constants.C_ADDED_TIMESTAMP + " ASC";
    String orderByTitleAse = Constants.C_NAME + " ASC";
    String orderByTitleDesc = Constants.C_NAME + " DESC";

    //if refreshing record, refresh with last choosen sort options
    String currentOrderByStatus = orderByNewest;


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
        loadREcords(orderByNewest);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(TicketManagerActivity.this, UploadTicketActivity.class);
                intent.putExtra("isEditMode", false);
                startActivity(intent);

            }
        });

    }

    private void loadREcords(String orderBy) {
        currentOrderByStatus = orderBy;
        AdapterRecord adapterRecord = new AdapterRecord(TicketManagerActivity.this, dbHelper.getAllRecords(orderBy));

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
        loadREcords(currentOrderByStatus);
    }


    /*search code*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu
        getMenuInflater().inflate(R.menu.menu_ticket, menu);

        //searchVie
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //handle menu item
        int id = item.getItemId();
        if (id == R.id.action_sort) {

            sortOptionDialog();

        } else if (id == R.id.action_delete) {

            // delete all records
            dbHelper.deleteAllData();
            onResume();
        }

        return super.onOptionsItemSelected(item);
    }

    private void sortOptionDialog() {

        //options to display in dialog
        String[] options = {"Title Ascending", "Title Descending", "Newest", "Oldest"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort By")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //handle options click
                        if (which == 0) {
                            loadREcords(orderByTitleAse);
                        } else if (which == 1) {
                            loadREcords(orderByTitleDesc);
                        } else if (which == 2) {
                            loadREcords(orderByNewest);
                        } else if (which == 3) {
                            loadREcords(orderByOldest);
                        }
                    }
                })
                .create().show();
    }
}