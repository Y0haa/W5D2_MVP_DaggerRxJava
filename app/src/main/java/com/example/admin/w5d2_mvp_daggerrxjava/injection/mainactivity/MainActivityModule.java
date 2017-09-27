package com.example.admin.w5d2_mvp_daggerrxjava.injection.mainactivity;

import com.example.admin.w5d2_mvp_daggerrxjava.View.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 9/26/2017.
 */

@Module
public class MainActivityModule {

    //add the dependancy using the @provides for each method
    @Provides
    MainActivityPresenter getMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
