package com.example.micha.firebasemvp.main;

import android.app.Activity;

import com.example.micha.firebasemvp.utils.LoginAuthenticator;

/**
 * Created by micha on 2/15/2018.
 */

public class MainPresenter implements MainContract.MPresenter, LoginAuthenticator.LoginFacilitator{

    private MainContract.MView view;
    private LoginAuthenticator authenticator;

    public MainPresenter(){
        authenticator = new LoginAuthenticator(this);
    }

    @Override
    public void attachView(MainContract.MView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean checkLogin() {
        return authenticator.checkLogin();
    }

    @Override
    public void createUser(String email, String password) {
        authenticator.createUser(email, password);
    }

    @Override
    public void login(String email, String password) {
        authenticator.login(email, password);
    }

    @Override
    public void sendResult(boolean result) {
        view.loginComplete(result);
    }
}
