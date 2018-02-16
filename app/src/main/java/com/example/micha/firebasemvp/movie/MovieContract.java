package com.example.micha.firebasemvp.movie;

import com.example.micha.firebasemvp.model.Movie;
import com.example.micha.firebasemvp.utils.BasePresenter;
import com.example.micha.firebasemvp.utils.BaseView;

/**
 * Created by micha on 2/15/2018.
 */

public interface MovieContract {
    interface MoView extends BaseView{

        void logout();

        void getLoginStatus(boolean b);
    }

    interface MoPresenter extends BasePresenter<MoView> {

        void signOut();

        void addMovie(Movie movie);

        void checkLogin();
    }
}
