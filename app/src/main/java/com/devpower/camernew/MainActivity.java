package com.devpower.camernew;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int PICTURE_RESULT = 1;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= findViewById(R.id.image_view);



    }

    public void openCam(View view) {
      /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,100);*/


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, 1);

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100&&resultCode==RESULT_OK)
        imageView.setImageBitmap((Bitmap) data.getExtras().get("data"));
        else {};



    }

    public void openMaps(View view) {
        Intent googleMap = new Intent(Intent.ACTION_VIEW);
        googleMap.setData(Uri.parse("geo:30.4059989,32.3122294?z=15.5"));
        if(googleMap.resolveActivity(getPackageManager())!=null) {
            startActivity(googleMap);
        }

    }
}
