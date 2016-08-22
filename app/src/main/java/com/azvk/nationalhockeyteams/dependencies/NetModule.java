package com.azvk.nationalhockeyteams.dependencies;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    private void make (GsonConverterFactory gsonConverterFactory){

    }

    private void make (RxJavaCallAdapterFactory rxJavaCallAdapterFactory){

    }
}
