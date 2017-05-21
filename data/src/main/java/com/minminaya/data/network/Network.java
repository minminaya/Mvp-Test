package com.minminaya.data.network;

import com.minminaya.data.network.api.GankApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niwa on 2017/5/21.
 */

public class Network {
    private static GankApi gankApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaAdapterFactory = RxJava2CallAdapterFactory.create();

    public static GankApi getGankApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaAdapterFactory)
                .build();
        gankApi = retrofit.create(GankApi.class);
        return gankApi;
    }

}
