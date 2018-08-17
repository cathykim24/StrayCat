package edu.skku.swp3.straycat.Feed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.skku.swp3.straycat.R;

public class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView comment;
    private CommentActivity commentActivity;
    private CommentAdapter commentAdapter;
    public TextView comment_username;
    public ImageView comment_profile_img;
    public TextView comment_time_posted;


    public CommentViewHolder(View itemView, final CommentAdapter commentAdapter) {
        super(itemView);
        this.commentAdapter = commentAdapter;

        comment_profile_img = (ImageView) itemView.findViewById(R.id.comment_profile_image);
        comment_username = (TextView) itemView.findViewById(R.id.comment_username);
        comment = (TextView) itemView.findViewById(R.id.comment);
        comment_time_posted = (TextView) itemView.findViewById(R.id.comment_time_posted);



//        input_comment_finished.setOnClickListener(this);

//        input_comment_finished.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                commentActivity.addData();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();

        switch (itemView.getId()){

        }
    }


}
