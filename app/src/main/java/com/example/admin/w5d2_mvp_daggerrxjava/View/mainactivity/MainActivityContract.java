package com.example.admin.w5d2_mvp_daggerrxjava.View.mainactivity;

import com.example.admin.w5d2_mvp_daggerrxjava.View.BasePresenter;
import com.example.admin.w5d2_mvp_daggerrxjava.View.BaseView;

/**
 * Created by Admin on 9/26/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView {
        void updateView(String s);
        void updateViewRange(Integer i);
        void updateViewFilter(Integer i);
        void updateViewTake(Integer i);
    }

    interface Presenter extends BasePresenter<View>{
        void validateInput(String inputString);
        void validateInput2();
        void validateInput3();
        void validateInput4();
    }



}
