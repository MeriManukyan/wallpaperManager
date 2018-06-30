package com.example.meri.myapplication;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.IntentSender;
import android.media.Image;
import android.service.wallpaper.WallpaperService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
Button b,b1;
int arr[];
int i=0;
WallpaperManager wallpaperManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr= new int[]{R.drawable.f, R.drawable.g, R.drawable.th,R.drawable.f, R.drawable.g, R.drawable.th};
        imageView=findViewById(R.id.iv);
        imageView.setImageResource(arr[0]);
        b=findViewById(R.id.button);
        b1=findViewById(R.id.button2);
        b1.setEnabled(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                imageView.setImageResource(arr[i]);
                b.setEnabled(true);
                if(i==0){
                    v.setEnabled(false);
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(true);
                if(arr.length==1)
                    v.setEnabled(false);
                i++;
                imageView.setImageResource(arr[i]);
                if(i==arr.length-1)
                    v.setEnabled(false);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(arr[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }

}
