package com.example.micha.firebasemvp.movie;

import com.example.micha.firebasemvp.model.Movie;
import com.example.micha.firebasemvp.utils.BaseView;
import com.example.micha.firebasemvp.utils.FirebaseDB;
import com.example.micha.firebasemvp.utils.LoginAuthenticator;

/**
 * Created by micha on 2/15/2018.
 */

public class MoviePresenter implements MovieContract.MoPresenter,LoginAuthenticator.LogoutFacilitator{

    MovieContract.MoView view;
    FirebaseDB db;
    LoginAuthenticator authenticator;

    public MoviePresenter(){
        db = new FirebaseDB();
        authenticator = new LoginAuthenticator(this);
    }

    @Override
    public void attachView(MovieContract.MoView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void signOut() {
        authenticator.logout();
    }

    @Override
    public void addMovie(Movie movie) {
        db.addMovie(movie);
    }

    @Override
    public void checkLogin() {
        view.getLoginStatus(authenticator.checkLogin());
    }

    @Override
    public void logout() {
        view.logout();
    }
}
