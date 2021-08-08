package com.example.p4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] images;
        Button btn = findViewById(R.id.chngBtn);
        images = new int[]{R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4, R.mipmap.pic5, R.mipmap.pic6, R.mipmap.pic7};

        btn.setOnClickListener(v -> {
            Random random = new Random();
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            int randomVal = random.nextInt(images.length);
            try {
                wallpaperManager.setResource(images[randomVal]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(btn::performClick, 30000);
        });
    }
}