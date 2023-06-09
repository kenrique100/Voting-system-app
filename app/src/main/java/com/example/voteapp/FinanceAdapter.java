package com.example.voteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FinanceAdapter extends RecyclerView.Adapter<FinanceAdapter.ViewHolder> {

    FinanceActivity financeActivity;
    ArrayList<Member> financlist;


    public FinanceAdapter(FinanceActivity financeActivity, ArrayList<Member> financlist) {
        this.financeActivity = financeActivity;
        this.financlist = financlist;
    }

    @NonNull
    @Override
    public FinanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(financeActivity).inflate(R.layout.item_fin,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FinanceAdapter.ViewHolder holder, int position) {
        Member member = financlist.get(position);
        holder.tvfinan.setText(member.getFourth());
    }

    @Override
    public int getItemCount() {
        return financlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvfinan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvfinan = itemView.findViewById(R.id.tvFina);
        }
    }
}
