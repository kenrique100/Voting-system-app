package com.example.voteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.ViewHolder> {

    WelfActivity welfActivity;
    ArrayList<Member> welflist;


    public WelfareAdapter(WelfActivity welfActivity, ArrayList<Member> welflist) {
        this.welfActivity = welfActivity;
        this.welflist = welflist;
    }

    @NonNull
    @Override
    public WelfareAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(welfActivity).inflate(R.layout.item_welf,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WelfareAdapter.ViewHolder holder, int position) {
        Member member = welflist.get(position);
        holder.tvWelf.setText(member.getFiveth());
    }

    @Override
    public int getItemCount() {
        return welflist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWelf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWelf = itemView.findViewById(R.id.tvWelfar);
        }
    }
}
