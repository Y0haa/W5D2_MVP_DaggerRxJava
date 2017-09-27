package com.example.admin.w5d2_mvp_daggerrxjava.injection.mainactivity;

import com.example.admin.w5d2_mvp_daggerrxjava.View.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 9/26/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject (MainActivity mainActivity);
}
