package com.trodev.tourtripguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<ModelClass> list;

    public CustomAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*set data on short views*/
        holder.nameTv.setText(list.get(position).name);
        holder.shortbioTv.setText(list.get(position).shortbio);

        Glide
                .with(context)
                .load(list.get(position).getImg())
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(holder.imageIv);

        /*on click listener*/
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FullDataActivity.class);
                intent.putExtra("name", list.get(position).name);
                intent.putExtra("shortbio", list.get(position).shortbio);
                intent.putExtra("historyhead", list.get(position).historyhead);
                intent.putExtra("historybio", list.get(position).historybio);
                intent.putExtra("img", list.get(position).getImg());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv, shortbioTv;
        ImageView imageIv;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /*init views*/
            nameTv = itemView.findViewById(R.id.nameTv);
            shortbioTv = itemView.findViewById(R.id.shortbioTv);
            imageIv = itemView.findViewById(R.id.imageIv);
            cardView = itemView.findViewById(R.id.cardMc);

        }
    }
}
