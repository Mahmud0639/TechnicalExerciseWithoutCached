package com.manuni.androidtechnicalexercise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

public class RandomImageGenerator {

    public Context mContext;
    RequestQueue queue;

    public RandomImageGenerator(Context context){
        this.mContext = context;
        queue = Volley.newRequestQueue(context.getApplicationContext());
    }


    public void showImageRandomly(final ImageView imageView,final int width, final
    int height) {



        ImageRequest imageRequest = new ImageRequest(Constant.BASE_URL+width+"/"+height, new Response.Listener<Bitmap>() {
            @SuppressLint("CheckResult")
            @Override
            public void onResponse(Bitmap response) {

                try {
                    Glide.with(mContext).load(response).placeholder(R.drawable.ic_image_placeholder).into(imageView);
                } catch (Exception e) {
                    Glide.with(mContext).load(R.drawable.ic_image_placeholder);
                }
                // imageView.setImageBitmap(response);
            }

        }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(imageRequest);


    }
}
