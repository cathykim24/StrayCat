package edu.skku.swp3.straycat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


    public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

        private Context context;
        private ArrayList<Comment> commentItems;

        public CommentAdapter(ArrayList<Comment> commentItems){
            this.commentItems = commentItems;
        }

        @Override
        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comment, parent, false);
            return new CommentViewHolder(v, this);
        }

        @Override
        public void onBindViewHolder(CommentViewHolder holder, int position) {
            CommentViewHolder commentViewHolder = (CommentViewHolder) holder;

            Comment comment = commentItems.get(position);

            holder.comment.setText(comment.getComment());
            holder.comment_username.setText(comment.getUser_id());
            holder.comment_profile_img.setImageResource(commentItems.get(position).getProfileImgUri());
            holder.comment_time_posted.setText(comment.getDate_created());
        }

        @Override
        public int getItemCount() {
            return commentItems.size();
        }

    }

