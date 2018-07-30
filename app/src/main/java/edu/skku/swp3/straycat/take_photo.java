package edu.skku.swp3.straycat;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class take_photo extends AppCompatActivity {

    private static int PICK_FROM_CAMERA = 2;
    ImageView imgView;
    static final String TAG = "MainActivity";
    private Uri mImageCaptureUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //로드버튼 클릭시 실행
    public void takePhoto(View view) {
        //Intent 생성
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //ACTION_PIC과 차이점?
        String url = "tmp_"+String.valueOf(System.currentTimeMillis())+".jpg";
        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),url));

        intent.putExtra(MediaStore.EXTRA_OUTPUT,mImageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    //이미지 선택작업을 후의 결과 처리
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            //이미지를 하나 골랐을때
            if (requestCode == PICK_FROM_CAMERA && resultCode == RESULT_OK && null != data) {


//                //이미지가 한계이상(?) 크면 불러 오지 못하므로 사이즈를 줄여 준다.
//                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
//                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);
//
                imgView = (ImageView) findViewById(R.id.imageView);
//                imgView.setImageBitmap(scaled);


            } else {
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "로딩에 오류가 있습니다.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
