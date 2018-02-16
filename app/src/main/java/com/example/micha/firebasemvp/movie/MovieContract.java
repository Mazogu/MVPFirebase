package com.example.micha.firebasemvp.movie;

import com.example.micha.firebasemvp.utils.BasePresenter;
import com.example.micha.firebasemvp.utils.BaseView;

/**
 * Created by micha on 2/15/2018.
 */

public interface MovieContract {
    public interface MoView extends BaseView{

    }

    public interface MoPresenter extends BasePresenter<BaseView> {

    }
}
