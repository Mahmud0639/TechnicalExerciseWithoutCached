package com.manuni.androidtechnicalexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.manuni.androidtechnicalexercise.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyTag";
    ActivityMainBinding binding;

    RandomImageGenerator randomImageGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        randomImageGenerator = new RandomImageGenerator(MainActivity.this);

        binding.clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randomForWidthOrHeight = new Random();
                int width = randomForWidthOrHeight.nextInt(101) + 200;
                int height = randomForWidthOrHeight.nextInt(101) + 300;

                randomImageGenerator.showImageRandomly(binding.imageViw, width, height);


            }
        });


    }


}