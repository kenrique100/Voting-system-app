package com.example.voteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChairmanAdapter extends RecyclerView.Adapter<ChairmanAdapter.ViewHolder> {

    ChairActivity chair;
    ArrayList<Member> chairlist;

    public ChairmanAdapter(ChairActivity chair, ArrayList<Member> chairlist) {
        this.chair = chair;
        this.chairlist = chairlist;
    }

    @NonNull
    @Override
    public ChairmanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(chair).inflate(R.layout.item_chair,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChairmanAdapter.ViewHolder holder, int position) {
        Member member = chairlist.get(position);
        holder.tvChair.setText(member.getSecond());
    }

    @Override
    public int getItemCount() {
        return chairlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChair;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvChair = itemView.findViewById(R.id.tvChairm);
        }
    }
}
