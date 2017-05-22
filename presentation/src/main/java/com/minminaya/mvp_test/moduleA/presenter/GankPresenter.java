package com.minminaya.mvp_test.moduleA.presenter;

import android.util.Log;

import com.minminaya.data.network.Network;
import com.minminaya.data.network.model.GankModel;
import com.minminaya.mvp_test.moduleA.activity.GankActivity;
import com.minminaya.mvp_test.mvp.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Niwa on 2017/5/21.
 */

public class GankPresenter extends BasePresenter<GankActivity> {
    private boolean isLoad = true;
    private int index = 1;
    Observer<GankModel> observer = new Observer<GankModel>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(GankModel value) {
            Log.e("gankUrl:", value.getResults().get(1).getUrl());
            loadThread();
        }

        @Override
        public void onError(Throwable e) {
            Log.e("gank", "错误");
        }

        @Override
        public void onComplete() {

        }
    };

    public void loadThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isLoad) {
                    try {
                        Thread.sleep(1000);
                        Log.e("线程打印", "线程次数：" + index++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
