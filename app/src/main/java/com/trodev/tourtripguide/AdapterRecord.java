package com.trodev.tourtripguide;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.HolderRecord> {

    //variables
    Context context;
    ArrayList<ModelRecords> recordsList;

    //db helper
    MyHelper dbHelper;

    public AdapterRecord(Context context, ArrayList<ModelRecords> recordsList) {
        this.context = context;
        this.recordsList = recordsList;

        dbHelper = new MyHelper(context);
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_record, parent, false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {

        ModelRecords model = recordsList.get(position);

        String id = model.getId();
        String name = model.getName();
        String phone = model.getPhone();
        String ticket = model.getTicket();
        String date = model.getDate();
        String bio = model.getBio();
        String addedTime = model.getAddedTime();
        String updateTime = model.getUpdateTime();
        //   String image = model.getImage();


        /*---------------------------------------------------*/
        //set data to views
        holder.nameTv.setText("Journey by place: " + name);
        holder.phoneTv.setText("☎ Manager Number: " + phone);
        holder.dateTv.setText("📅 Travel Date: " + date);
        holder.ticketTv.setText("🎫 Ticket Number: " + ticket);
        // holder.profileIv.setImageURI(Uri.parse(image));

        /*----------------------------------------------------*/
        //handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Journey by place " + name, Toast.LENGTH_SHORT).show();
            }
        });

        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMoreDialog(
                        "" + position,
                        "" + id,
                        "" + name,
                        "" + phone,
                        "" + date,
                        "" + ticket,
                        "" + bio,
                        "" + addedTime,
                        "" + updateTime
                );

            }
        });

    }

    private void showMoreDialog(String position, String id, String name, String phone, String date, String ticket, String bio, String addedTime, String updatedTime) {

        // options to display
        String[] options = {"Edit", "Delete"};
        //dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //add items to dialog
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //handle click
                if (which == 0) {
                    Intent intent = new Intent(context, UploadTicketActivity.class);
                    intent.putExtra("ID", id);
                    ;
                    intent.putExtra("NAME", name);
                    intent.putExtra("PHONE", phone);
                    intent.putExtra("DATE", date);
                    intent.putExtra("TICKET", ticket);
                    intent.putExtra("BIO", bio);
                    intent.putExtra("ADDED_TIME", addedTime);
                    intent.putExtra("UPDATED_TIME", updatedTime);
                    intent.putExtra("isEditMode", true);
                    context.startActivity(intent);
                } else if (which == 1) {
                    dbHelper.deleteData(id);
                    //refresh record by calling activities onResume method
                    ((TicketManagerActivity) context).onResume();
                }

            }
        });

        //show dialog
        builder.create().show();

    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    class HolderRecord extends RecyclerView.ViewHolder {

        CircleImageView profileIv;
        ImageView moreBtn;
        TextView nameTv, phoneTv, ticketTv, dateTv;

        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            phoneTv = itemView.findViewById(R.id.phoneTv);
            ticketTv = itemView.findViewById(R.id.ticketTv);
            dateTv = itemView.findViewById(R.id.dateTv);
            moreBtn = itemView.findViewById(R.id.moreBtn);

        }
    }


}
