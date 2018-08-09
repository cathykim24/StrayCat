package edu.skku.swp3.straycat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CashHistoryAdapter extends RecyclerView.Adapter {
    private ArrayList<CashHistory> historyList = null;

    public CashHistoryAdapter(ArrayList<CashHistory> historyList) {
        this.historyList = historyList;
    }

    public void addItem(CashHistory newItem){
        historyList.add(newItem);
        notifyDataSetChanged();
    }

    //뷰를 만들어주는 함수
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cashlist, parent, false);
        return new CashHistoryViewHolder(itemView);
}

    //실제 뷰에다 매칭되는 데이터를 표시해주는 함수
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CashHistory history = historyList.get(historyList.size() - position-1);
        CashHistoryViewHolder viewHolder = (CashHistoryViewHolder)holder;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        viewHolder.tvType.setText(history.title);
        viewHolder.tvDate.setText(format.format(history.date));
        viewHolder.tvMoney.setText(String.valueOf(history.money));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    class CashHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvType, tvDate, tvMoney;
        public CashHistoryViewHolder(View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tv_type);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvMoney = itemView.findViewById(R.id.tv_money);
        }
    }
}
