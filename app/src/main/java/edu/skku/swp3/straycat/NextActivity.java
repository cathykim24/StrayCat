package edu.skku.swp3.straycat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "NextActivity";
    Context context = this;

    PostActivity postActivity;

    //widgets
    private EditText mCaption;

    //vars
    private String mAppend = "file:/";
    private int imageCount = 0;
    private String imgUrl;
    private Bitmap bitmap;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mCaption = (EditText) findViewById(R.id.caption) ;

        ImageView backArrow = (ImageView) findViewById(R.id.ivBackArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing the activity");
                finish();
            }
        });


        TextView share = (TextView) findViewById(R.id.tvShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to the final share screen.");
                String caption = mCaption.getText().toString();

                if(intent.hasExtra("selected_image")){
                    imgUrl = intent.getStringExtra("selected_image");
                }
                else if(intent.hasExtra("selected_bitmap")){
                    bitmap = (Bitmap) intent.getParcelableExtra("selected_bitmap");
                }

                //postActivity.addData();
                //todo: 데이터 추가되는거 만들기
                //back to home
                Intent intent = new Intent (context, TabActivity.class);
                context.startActivity(intent);
            }
        });
        setImage();
    }

    /**
     * gets the image url from the incoming intent and displays the chosen image
     */
    private void setImage(){
        intent = getIntent();
        ImageView image = (ImageView) findViewById(R.id.imageShare);
        Log.d(TAG,"여기");
        if(intent.hasExtra("selected_image")){
            imgUrl = intent.getStringExtra("selected_image");
            Log.d(TAG, "setImage: got new image url: " + imgUrl);
            UniversalImageLoader.setImage(imgUrl, image, mAppend);
        }
        else if(intent.hasExtra("selected_bitmap")){
            bitmap = (Bitmap) intent.getParcelableExtra("selected_bitmap");
            Log.d(TAG, "setImage: got new bitmap");
            image.setImageBitmap(bitmap);
        }
    }
}
