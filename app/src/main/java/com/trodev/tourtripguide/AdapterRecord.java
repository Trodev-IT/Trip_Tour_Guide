package com.trodev.tourtripguide;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

    public AdapterRecord(Context context, ArrayList<ModelRecords> recordsList) {
        this.context = context;
        this.recordsList = recordsList;
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
        String addedTime = model.getAddedTime();
        String updateTime = model.getUpdateTime();
        //   String image = model.getImage();


        /*---------------------------------------------------*/
        //set data to views
        holder.nameTv.setText("Place Name: " + name);
        holder.phoneTv.setText("Manager Number: " + phone);
        holder.dateTv.setText("Journey Date: " + date);
        holder.ticketTv.setText("Ticket Number: " + ticket);
       // holder.profileIv.setImageURI(Uri.parse(image));

        /*----------------------------------------------------*/
        //handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Journey by place "+name, Toast.LENGTH_SHORT).show();
            }
        });

        //handle more button click
        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    class HolderRecord extends RecyclerView.ViewHolder {

        CircleImageView profileIv;
        ImageButton moreBtn;
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
