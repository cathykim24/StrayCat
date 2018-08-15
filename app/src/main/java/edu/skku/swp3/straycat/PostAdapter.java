package edu.skku.swp3.straycat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<postViewHolder> {

    private Context context;
    private ArrayList<PostItem> postItems;

    public PostAdapter(ArrayList<PostItem> context){
        this.postItems = context;
    }

    @Override
    public postViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new postViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(postViewHolder holder, int position) {
        postViewHolder postViewHolder = (postViewHolder) holder;

        PostItem postItem = postItems.get(position);

        holder.tvUserName.setText(postItem.getUsername());
        holder.tvPostText.setText(postItem.getPostText());
        holder.tvLikeCount.setText("냥냥펀치 "+String.valueOf(postItem.getPostLikeCount())+"개");
        holder.ivImg.setImageResource(postItems.get(position).getImgUri());
        holder.UserName.setText(postItem.getProfileUserName());
        holder.profileImg.setImageResource(postItems.get(position).getProfileImgUri());
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }


    public void onLikeClicked(int position) {
        PostItem item = postItems.get(position);
        item.addidx();
        if(item.getidx()%2 ==1){
            item.setPostLikeCount(item.getPostLikeCount()+1);
        }
        else{
            item.setPostLikeCount(item.getPostLikeCount()-1);
        }
        notifyDataSetChanged();
        notifyItemChanged(position);
    }
}
