package com.minminaya.mvp_test.mvp.presenter;

/**
 * presenter与Activity接入的几个方法
 * Created by Niwa on 2017/5/21.
 */

public interface IPresenter<T> {
    void attachView(T view);

    void detachView(T view);

    void onDestroyed();

    boolean isAttachView(T view);

    T getMvpView();
}
