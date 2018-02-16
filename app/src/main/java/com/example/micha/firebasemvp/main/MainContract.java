package com.example.micha.firebasemvp.main;

import com.example.micha.firebasemvp.utils.BasePresenter;
import com.example.micha.firebasemvp.utils.BaseView;

/**
 * Created by micha on 2/15/2018.
 */

public interface MainContract {
    public interface MView extends BaseView{
        void loginComplete(boolean isLoggedIn);
    }

    public interface MPresenter extends BasePresenter<MView>{
        boolean checkLogin();
        void createUser(String email, String password);
        void login(String email, String password);
    }
}
