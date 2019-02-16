package com.example.myfirebase;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    List<CustomClass> data;
    Context context;

    public CustomAdapter(ArrayList<CustomClass> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_list_item,parent,false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(data.get(position).getName());
        holder.textView.setText(data.get(position).getSurname());
        holder.textView.setText(data.get(position).getGender());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog builder = new Dialog(context);
                builder.setTitle("İnfo:"+position);
                builder.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                builder.setCancelable(true);
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        CardView card;
        public ViewHolder(View itemView)
        {
            super(itemView);

            textView=itemView.findViewById(R.id.nametxt);
            card=itemView.findViewById(R.id.card);
        }

    }
}