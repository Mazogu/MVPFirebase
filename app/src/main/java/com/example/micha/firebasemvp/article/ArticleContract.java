package com.example.micha.firebasemvp.article;

import com.example.micha.firebasemvp.utils.BasePresenter;
import com.example.micha.firebasemvp.utils.BaseView;

/**
 * Created by micha on 2/15/2018.
 */

public interface ArticleContract {
    interface AView extends BaseView{
        void logout();
    }

    interface APresenter extends BasePresenter<AView> {
        void signOut();
    }
}
