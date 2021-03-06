package com.pan.testapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.pan.cleverimage.CleverImageView;
import com.pan.cleverimage.ImageGetter;
import com.pan.cleverimage.ImageAnotherChanger;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTest;
    private CleverImageView cleverImageView;
    private static final String FILE_URL0 = "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/" +
            "u=522425600,1333123193&fm=173&s=9225BD08EA322A8EF73D7401030060C9&w=218&h=146&img.JPEG";
    private static final String FILE_URL1 = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/" +
            "u=2861671602,4205204930&fm=173&s=50019D5786616CA4793D90CB03008031&w=218&h=146&img.JPEG";
    private static final String FILE_LARGE = "http://download.sdk.mob.com/web/images/2017/" +
            "11/13/15/1510557801245/790_11339_3550.8359375.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();

        ImageAnotherChanger.init();

        cleverImageView = (CleverImageView) findViewById(R.id.cleverImageView);
        findViewById(R.id.btnGetPic0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ImageGetter.Request request = imageView.setImageUrl(FILE_URL0);
                cleverImageView.setImageUrl(FILE_LARGE);
                cleverImageView.setImageUrl(FILE_URL0);
            }
        });
        findViewById(R.id.btnGetPic1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleverImageView.setImageUrl(FILE_URL1);
            }
        });

        findViewById(R.id.btnClearMemCache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageGetter.getInstance().clearMemCache();
            }
        });
        findViewById(R.id.btnClearDiskCache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageGetter.getInstance().clearDiskCache();
            }
        });
        findViewById(R.id.btnCircle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleverImageView.setOval(true);
            }
        });
        findViewById(R.id.btnDisableCircle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleverImageView.setOval(false);
            }
        });
        findViewById(R.id.btnSetRes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleverImageView.setImageResource(R.mipmap.ic_launcher);
            }
        });
    }

    public void checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
}
