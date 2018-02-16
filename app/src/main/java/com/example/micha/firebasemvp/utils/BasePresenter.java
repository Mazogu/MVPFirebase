package com.example.micha.firebasemvp.utils;

/**
 * Created by micha on 2/15/2018.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
    boolean checkLogin();
}
