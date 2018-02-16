package com.example.micha.firebasemvp.main;

import com.example.micha.firebasemvp.utils.BasePresenter;
import com.example.micha.firebasemvp.utils.BaseView;

/**
 * Created by micha on 2/15/2018.
 */

public interface MainContract {
    interface MView extends BaseView{
        void loginComplete(boolean isLoggedIn);
    }

    interface MPresenter extends BasePresenter<MView>{
        void createUser(String email, String password);
        void login(String email, String password);
    }
}
