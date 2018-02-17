package com.example.micha.firebasemvp.article;

import com.example.micha.firebasemvp.utils.LoginAuthenticator;

/**
 * Created by micha on 2/15/2018.
 */

public class ArticlePresenter implements ArticleContract.APresenter,LoginAuthenticator.LogoutFacilitator{

    private LoginAuthenticator authenticator;
    private ArticleContract.AView view;

    @Override
    public void attachView(ArticleContract.AView view) {
        this.view = view;
        authenticator = new LoginAuthenticator(this);
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
    public void logout() {
        view.logout();
    }

    @Override
    public void signOut() {
        authenticator.logout();
    }
}
