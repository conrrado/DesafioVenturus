package com.ccamacho.desafioventurus.retrofit;

import com.ccamacho.desafioventurus.model.Gallery;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImageAPI {
    @Headers({
            "Authorization: Client-ID f0c5609160be9f5"
    })

    @GET("gallery/search")
    Observable<Gallery> getGalleryWithString(@Query("q") String search);
}
