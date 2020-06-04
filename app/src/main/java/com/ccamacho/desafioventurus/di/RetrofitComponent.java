package com.ccamacho.desafioventurus.di;

import com.ccamacho.desafioventurus.viewmodel.CatListViewModel;

import dagger.Component;

@Component(modules = {RetrofitImageModule.class})
public interface RetrofitComponent {

    void inject(CatListViewModel viewModel);
}
