package com.minminaya.mvp_test.mvp.presenter.loader;

import android.content.Context;
import android.content.Loader;

import com.minminaya.mvp_test.mvp.presenter.base.BasePresenter;
import com.minminaya.mvp_test.function_a.presenter.GankPresenterFactory;

/**
 * Created by Niwa on 2017/5/21.
 */

public class GankPresenterLoader<T extends BasePresenter> extends Loader<T>{

    private GankPresenterFactory factory;
    private T presenter;
//    private BasePresenterDefault presenter;

    public GankPresenterLoader(Context context, GankPresenterFactory factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if(presenter != null){
            deliverResult((T) presenter);
            return;
        }
        forceLoad();
    }


    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        presenter = (T) factory.create();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        super.onReset();
        presenter.onDestroyed();
        presenter = null;
    }
}
