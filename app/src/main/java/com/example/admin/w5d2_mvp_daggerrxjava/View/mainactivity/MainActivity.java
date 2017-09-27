package com.example.admin.w5d2_mvp_daggerrxjava.View.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w5d2_mvp_daggerrxjava.R;
import com.example.admin.w5d2_mvp_daggerrxjava.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{


    private static final String TAG = "MainActivityTag";
    @BindView(R.id.tvUsingJust)
    TextView tvUsingJust;
    @BindView(R.id.tvUsingRange)
    TextView tvUsingRange;
    @BindView(R.id.tvUsingTimer)
    TextView tvUsingTimer;

    @BindView(R.id.tvUsingFilter)
    TextView tvUsingFilter;
    @BindView(R.id.tvUsingTake)
    TextView tvUsingTake;


    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        getInject();
        presenter.attachView(this);

        //DaggerMainComponent

    }

    private void getInject() {
        DaggerMainActivityComponent.create().inject(this);
    }


    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: "+ s);

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void updateView(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        tvUsingJust.setText(s);


      }

    @Override
    public void updateViewRange(Integer i) {
        Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show();
        tvUsingRange.setText(i.toString());
    }

    @Override
    public void updateViewFilter(Integer i) {
        Toast.makeText(this,i.toString(), Toast.LENGTH_SHORT).show();
        tvUsingFilter.setText(i.toString());

    }

    @Override
    public void updateViewTake(Integer i) {
        Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show();
        tvUsingTake.setText(i.toString());
    }

    public void clickingButton(View view) {
        switch (view.getId()){

            case R.id.btnUsingJust:

                presenter.validateInput("test");



                break;
            case R.id.btnUsingRange:
                presenter.validateInput2();

                break;

            case R.id.btnUsingTimer:


                break;



            case R.id.btnUsingFilter:
                presenter.validateInput3();
                break;
            case R.id.btnUsingTake:
                presenter.validateInput4();
        }

    }
}
