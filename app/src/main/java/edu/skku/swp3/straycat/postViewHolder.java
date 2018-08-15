package edu.skku.swp3.straycat;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class postViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView ivImg;
    public CheckBox cbLike;
    public TextView tvLikeCount, tvUserName, tvPostText;
    private PostAdapter postAdapter;
    public TextView UserName;
    public ImageView profileImg;
    public ImageView comment;

    public postViewHolder(View itemView, final PostAdapter postAdapter) {
        super(itemView);
        this.postAdapter = postAdapter;
        ivImg = (ImageView) itemView.findViewById(R.id.iv_img);
        profileImg = (ImageView) itemView.findViewById(R.id.profile_photo);
        cbLike = (CheckBox) itemView.findViewById(R.id.cb_like);
        comment = (ImageView) itemView.findViewById(R.id.speech_bubble);

        tvLikeCount = (TextView) itemView.findViewById(R.id.tv_like_count);
        tvPostText = (TextView) itemView.findViewById(R.id.tv_posttext);
        tvUserName = (TextView) itemView.findViewById(R.id.tv_username);
        UserName = (TextView) itemView.findViewById(R.id.username);


        cbLike.setOnClickListener(this);
        comment.setOnClickListener(this);
        cbLike.setChecked(false);

        cbLike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = getAdapterPosition();
                Log.d("postViewHolder"," 여기");
                postAdapter.onLikeClicked(position);
            }
        });

        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CommentActivity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();

        switch (itemView.getId()){

            case R.id.cb_like:
                Log.d("postViewHolder","여기");
                postAdapter.onLikeClicked(position);

                break;

        }
    }


}
