package edu.skku.swp3.straycat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CatListAdapter extends RecyclerView.Adapter {
    private ArrayList<CatList> CatList = null;

    public CatListAdapter(ArrayList<edu.skku.swp3.straycat.CatList> catList) {
        this.CatList = CatList;
    }

    public void addItem(CatList newItem){
        CatList.add(newItem);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catlist, parent, false);
        return new CatListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CatList catList = CatList.get(position);
        CatListAdapter.CatListViewHolder viewHolder = (CatListAdapter.CatListViewHolder)holder;

        viewHolder.ivCatImage.setImageResource(catList.imageResId);
        viewHolder.tvCatAddress.setText(catList.catAddress);
        viewHolder.tvCatSpecies.setText(catList.catSpecies);

    }

    @Override
    public int getItemCount() {
        return CatList.size();
    }

    class CatListViewHolder extends RecyclerView.ViewHolder {
        TextView tvCatAddress,tvCatSpecies;
        ImageView ivCatImage;
        public CatListViewHolder(View itemView) {
            super(itemView);
            ivCatImage= itemView.findViewById(R.id.iv_cat);
            tvCatAddress = itemView.findViewById(R.id.tv_cat_address);
            tvCatSpecies = itemView.findViewById(R.id.tv_cat_species);
        }
    }
}
