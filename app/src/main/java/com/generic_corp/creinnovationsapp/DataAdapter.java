package com.generic_corp.creinnovationsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<model_for_outer_data> arrayList;
    db DB;


    public DataAdapter(ArrayList<model_for_outer_data> arrayList){
        this.arrayList=arrayList;

    }
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title_tv_trial.setText(arrayList.get(position).getFirst_name());
        holder.title_email_trial.setText(arrayList.get(position).getEmail());
        holder.title_id_trial.setText(arrayList.get(position).getId());
        holder.title_lastName_trial.setText(arrayList.get(position).getLast_name());
        Picasso.get().load(arrayList.get(position).getAvatar()).into(holder.imageview_trial);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),secondPage.class);
                i.putExtra("imageLink",arrayList.get(position).getAvatar());
                view.getContext().startActivity(i);

            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview_trial;
        TextView title_tv_trial,title_lastName_trial,title_email_trial,title_id_trial;
        CardView layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview_trial = (ImageView) itemView.findViewById(R.id.imageview_trial);
            title_tv_trial = (TextView) itemView.findViewById(R.id.title_tv_trial);
            title_lastName_trial = (TextView) itemView.findViewById(R.id.title_lastName_trial);
            title_email_trial = (TextView) itemView.findViewById(R.id.title_email_trial);
            title_id_trial = (TextView) itemView.findViewById(R.id.title_id_trial);
            layout = itemView.findViewById(R.id.cardView_layout);
        }


    }
}
