package com.minminaya.mvp_test.function_a.presenter;

import android.util.Log;

import com.minminaya.data.network.Network;
import com.minminaya.data.network.model.GankModel;
import com.minminaya.mvp_test.function_a.activity.GankActivity;
import com.minminaya.mvp_test.mvp.presenter.base.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Niwa on 2017/5/21.
 */

public class GankPresenter extends BasePresenter<GankActivity> {
    private int index = 1;
    Observer<GankModel> observer = new Observer<GankModel>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(GankModel value) {
            Log.e("gankUrl:", value.getResults().get(1).getUrl());
            loadTheard();
        }

        @Override
        public void onError(Throwable e) {
            Log.e("gank", "错误");
        }

        @Override
        public void onComplete() {

        }
    };


    public void loadTheard() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(1000);
                        Log.e("打印线程", "" + index++);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void loadData() {
        Network.getGankApi()
                .getBeauties(10, 1)
                .compose(getMvpView().<GankModel>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
