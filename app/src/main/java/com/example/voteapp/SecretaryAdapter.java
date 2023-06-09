package com.example.voteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecretaryAdapter extends RecyclerView.Adapter<SecretaryAdapter.ViewHolder> {

    SecActivity secActivity;
    ArrayList<Member> seclist;


    public SecretaryAdapter(SecActivity secActivity, ArrayList<Member> seclist) {
        this.secActivity = secActivity;
        this.seclist = seclist;
    }

    @NonNull
    @Override
    public SecretaryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(secActivity).inflate(R.layout.item_sec,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecretaryAdapter.ViewHolder holder, int position) {
        Member member = seclist.get(position);
        holder.tvsecre.setText(member.getThird());
    }

    @Override
    public int getItemCount() {
        return seclist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvsecre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvsecre = itemView.findViewById(R.id.tvSecr);
        }
    }
}
