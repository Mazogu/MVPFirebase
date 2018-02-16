package com.example.micha.firebasemvp.utils;

/**
 * Created by micha on 2/15/2018.
 */

public interface BasePresenter<V extends BaseView> {
    public void attachView(V view);
    public void detachView();
}
