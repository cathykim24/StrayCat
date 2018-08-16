package edu.skku.swp3.straycat;

import android.app.Activity;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    private static final String TAG = "NextActivity";
    Context context = this;

    PostFragment postFragment;

    TextView textView;

    //widgets
    private EditText mCaption;

    //vars
    private String mAppend = "file:/";
    private int imageCount = 0;
    private String imgUrl;
    private Bitmap bitmap;
    private Intent intent;

    private String caption;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        mCaption = (EditText) findViewById(R.id.caption) ;
        textView = (TextView) findViewById(R.id.tag_cat_name);
        button = (Button) findViewById(R.id.btn_tagcat);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagCat();
            }
        });

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

                setCaption(caption);

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
    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return caption;
    }

    public void tagCat(){
        Intent intent = new Intent(this, TagCatActivity.class);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1000) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                textView.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }
    }

}
