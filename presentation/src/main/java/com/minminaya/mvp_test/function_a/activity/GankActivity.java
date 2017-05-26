package com.minminaya.mvp_test.function_a.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import com.minminaya.mvp_test.R;
import com.minminaya.mvp_test.base.BaseActivity;
import com.minminaya.mvp_test.function_a.presenter.GankPresenter;
import com.minminaya.mvp_test.function_a.presenter.GankPresenterFactory;
import com.minminaya.mvp_test.mvp.presenter.loader.GankPresenterLoader;
import com.minminaya.mvp_test.mvp.view.MvpView;


/**
 * Created by Niwa on 2017/5/21.
 */

public class GankActivity extends BaseActivity implements MvpView, LoaderManager.LoaderCallbacks<GankPresenter> {


    private static final int LOADER_ID = 1110;
    private GankPresenter presenter = new GankPresenter();


    @Override
    public void unBind() {
        presenter.detachView(this);
    }

    @Override
    public void bind() {
        presenter.attachView(this);
        presenter.loadData();
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        getLoaderManager().initLoader(LOADER_ID, null, this);
        Log.e("presenterId",presenter.getClass().toString());
    }

    @Override
    public int getContentView() {
        return R.layout.activity_gank;
    }


    @Override
    public void onFailed(Throwable e) {

    }

    @Override
    public Loader<GankPresenter> onCreateLoader(int id, Bundle args) {
        Log.e("GankActivity", "onCreateLoader");
        return new GankPresenterLoader<GankPresenter>(this, new GankPresenterFactory());
    }

    @Override
    public void onLoadFinished(Loader<GankPresenter> loader, GankPresenter presenter) {
        Log.e("GankActivity", "onLoadFinished");

        this.presenter = presenter;
    }

    @Override
    public void onLoaderReset(Loader<GankPresenter> loader) {
        Log.e("GankActivity", "onLoaderReset");
        presenter = null;
    }
}
