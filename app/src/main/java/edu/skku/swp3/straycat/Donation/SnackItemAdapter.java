package edu.skku.swp3.straycat.Donation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.skku.swp3.straycat.R;

public class SnackItemAdapter extends RecyclerView.Adapter {
    private ArrayList<SnackItem> snackItemList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snack, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return new SnackItemViewHolder(itemView);
    }

    public void addItem(SnackItem newItem){
        snackItemList.add(newItem);
        notifyDataSetChanged();
    }

    public void setItems(ArrayList<SnackItem> items) {
        this.snackItemList = items;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SnackItem snackItem = snackItemList.get(position);
        SnackItemAdapter.SnackItemViewHolder viewHolder = (SnackItemViewHolder)holder;

        viewHolder.tv_money.setText(String.valueOf(snackItem.money.toString()));
        viewHolder.tv_snack_name.setText(snackItem.snackName);
        viewHolder.iv_snack.setImageResource(snackItem.imageResId);

    }

    @Override
    public int getItemCount() {
        return snackItemList.size();
    }

    public SnackItem get(int index) {
        return snackItemList.get(index);
    }

    class SnackItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv_money,tv_snack_name;
        ImageView iv_snack;
        public SnackItemViewHolder(View itemView){
            super(itemView);
            tv_money = itemView.findViewById(R.id.tv_money);
            tv_snack_name = itemView.findViewById(R.id.tv_snack_name);
            iv_snack = itemView.findViewById(R.id.iv_snack);
        }

    }
}
