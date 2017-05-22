package com.minminaya.mvp_test;

import android.app.Application;

/**
 * Created by Niwa on 2017/5/21.
 */

public class App extends Application {
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
    /**
     *  全局获取application对象
     *
     * */
    public static App getINSTANCE() {
        return INSTANCE;
    }

}
