package com.ccamacho.desafioventurus.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtil {

//    private static CircularProgressDrawable getProgressDrawable(Context context) {
//        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
//        progressDrawable.setStrokeWidth(10f);
//        progressDrawable.setCenterRadius(50f);
//        progressDrawable.setBackgroundColor(Color.WHITE);
//        progressDrawable.start();
//        return progressDrawable;
//    }

    public static void setImageView(ImageView image, String url) {
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(getProgressDrawable(image.getContext()))
//                .fitCenter();
        Glide.with(image.getContext())
//                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(image);
    }
}
