package com.ccamacho.desafioventurus.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ccamacho.desafioventurus.R;
import com.ccamacho.desafioventurus.di.DaggerRetrofitComponent;
import com.ccamacho.desafioventurus.model.GalleryData;
import com.ccamacho.desafioventurus.retrofit.ImageAPI;
import com.ccamacho.desafioventurus.util.NetworkUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CatListViewModel extends ViewModel {

    @Inject
    ImageAPI imageAPI;

    public CatListViewModel() {
        DaggerRetrofitComponent.create().inject(this);
    }

    public MutableLiveData<List<GalleryData>> galleryListMutableLiveData = new MutableLiveData<>();

    public void getCatGalleryList(Context context) {
        if (!NetworkUtil.isOnline(context)) {
            Toast.makeText(context, context.getString(R.string.error_network), Toast.LENGTH_LONG).show();
            return;
        }
        String search = "cat";
        imageAPI.getGalleryWithString(search)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gallery -> {
                    galleryListMutableLiveData.setValue(gallery.getGalleryDataList());
                });
    }
}
