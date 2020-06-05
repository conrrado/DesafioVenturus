package com.ccamacho.desafioventurus.util;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageUtil {

    private static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(10f);
        progressDrawable.setCenterRadius(50f);
        progressDrawable.setBackgroundColor(Color.WHITE);
        progressDrawable.start();
        return progressDrawable;
    }

    public static void setImageView(ImageView image, String url) {
        Glide.with(image.getContext())
                .load(url)
                .into(image);
    }

    public static void setImageViewWithProgress(ImageView image, String url) {
                RequestOptions requestOptions = new RequestOptions()
                .placeholder(getProgressDrawable(image.getContext()))
                .fitCenter();
        Glide.with(image.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(image);
    }
}
