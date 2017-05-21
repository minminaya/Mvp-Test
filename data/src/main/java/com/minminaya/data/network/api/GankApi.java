package com.minminaya.data.network.api;

import com.minminaya.data.network.model.GankModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Niwa on 2017/5/21.
 */

public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<GankModel> getBeauties(@Path("number") int number, @Path("page") int page);
}
