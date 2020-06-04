package com.ccamacho.desafioventurus.di;

import com.ccamacho.desafioventurus.BuildConfig;
import com.ccamacho.desafioventurus.retrofit.ImageAPI;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitImageModule {

    @Provides
    public ImageAPI getRetrofitImageConfig() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ImageAPI.class);
    }
}
