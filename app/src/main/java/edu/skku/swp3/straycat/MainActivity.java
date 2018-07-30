package edu.skku.swp3.straycat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static int SELECT_IMAGE_IN_GALLERY = 1;
    private static int TAKE_PICTURE = 2;

    private int picture_num = 1;

    ImageView imgView;
    Button load_photo;
    Button take_picture;

    Uri fileUri;

    static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load_photo = (Button) findViewById(R.id.buttonLoadPic);
        take_picture = (Button) findViewById(R.id.buttonTakePic);

        load_photo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int result = new PermissionRequester.Builder(MainActivity.this)
                        .create()
                        .request(Manifest.permission.READ_EXTERNAL_STORAGE, 1000 , new PermissionRequester.OnClickDenyButtonListener() {
                            @Override
                            public void onClick(Activity activity) {
                                Log.d("RESULT", "취소함.");
                            }
                        });

                if (result == PermissionRequester.ALREADY_GRANTED) {
                    Log.d("RESULT", "권한이 이미 존재함.");
                   loadImagefromGallery();
                }
                else if(result == PermissionRequester.NOT_SUPPORT_VERSION)
                    Log.d("RESULT", "마쉬멜로우 이상 버젼 아님.");
                else if(result == PermissionRequester.REQUEST_PERMISSION)
                    Log.d("RESULT", "요청함. 응답을 기다림.");

            }
        });

        take_picture.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int result = new PermissionRequester.Builder(MainActivity.this)
                        .create()
                        .request(Manifest.permission.CAMERA, 1000 , new PermissionRequester.OnClickDenyButtonListener() {
                            @Override
                            public void onClick(Activity activity) {
                                Log.d("RESULT", "취소함.");
                            }
                        });

                if (result == PermissionRequester.ALREADY_GRANTED) {
                    Log.d("RESULT", "권한이 이미 존재함.");
                    takePicture();
                }
                else if(result == PermissionRequester.NOT_SUPPORT_VERSION)
                    Log.d("RESULT", "마쉬멜로우 이상 버젼 아님.");
                else if(result == PermissionRequester.REQUEST_PERMISSION)
                    Log.d("RESULT", "요청함. 응답을 기다림.");

            }
        });

    }

    //로드버튼 클릭시 실행
    public void loadImagefromGallery() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture in Gallery"), SELECT_IMAGE_IN_GALLERY);
    }

    public void takePicture(){
        getOutputMediaFileUri(TAKE_PICTURE);
    }

    private void getOutputMediaFileUri(int takePicture) {
        Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "MyImages");
        imagesFolder.mkdirs();

        File image = new File(imagesFolder, "image_00"+String.valueOf(picture_num)+".jpg");
        picture_num = picture_num + 1;

        Uri uriSavedImage = Uri.fromFile(image);
        imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);

        startActivityForResult(imageIntent,TAKE_PICTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            //이미지를 하나 골랐을때
            if (requestCode == SELECT_IMAGE_IN_GALLERY && resultCode == RESULT_OK && null != data) {
                //data에서 절대경로로 이미지를 가져옴
                Uri uri = data.getData();

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                //이미지가 한계이상(?) 크면 불러 오지 못하므로 사이즈를 줄여 준다.
                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                imgView = (ImageView) findViewById(R.id.imageView);
                imgView.setImageBitmap(scaled);
            } else {
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
            }

            if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK && null != data) {
                //data에서 절대경로로 이미지를 가져옴
                Uri uri = data.getData();

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                //이미지가 한계이상(?) 크면 불러 오지 못하므로 사이즈를 줄여 준다.
                int nh = (int) (bitmap.getHeight() * (1024.0 / bitmap.getWidth()));
                Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 1024, nh, true);

                imgView = (ImageView) findViewById(R.id.imageView);
                imgView.setImageBitmap(scaled);
            } else {
                Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "로딩에 오류가 있습니다.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }
}
