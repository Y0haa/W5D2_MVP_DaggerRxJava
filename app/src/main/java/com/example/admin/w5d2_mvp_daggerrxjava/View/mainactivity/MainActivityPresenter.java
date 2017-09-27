package com.example.admin.w5d2_mvp_daggerrxjava.View.mainactivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 9/26/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    io.reactivex.Observable<String> mObservable;
    Observer<String> mObserver;

    io.reactivex.Observable<Integer> mObservable1;
    Observer<Integer> mObserver1;

    MainActivityContract.View view;

    @Override
    public void attachView(MainActivityContract.View view) { this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }

    @Override
    public void validateInput(String inputString) {


        mObservable = mObservable.just(inputString);

        mObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                //  tvOutputString.setText(s);
                view.updateView(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        mObservable.subscribe(mObserver);

    }

    @Override
    public void validateInput2 () {


        mObservable1 = mObservable1.range(1,9);

        mObserver1 = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");

            }

            @Override
            public void onNext(@NonNull Integer i) {
                //  tvOutputString.setText(s);
                //System.out.println("onNext: "+ integer);
                view.updateViewRange(i);


            }

            @Override
            public void onError(@NonNull Throwable e) { System.out.println("onError: ");

            }

            @Override
            public void onComplete() {System.out.println("onCompile: ");

            }
        };
//        mObservable1.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(mObservable1);
        mObservable1.subscribe(mObserver1);

    }

    @Override
    public void validateInput3 () {

        //you can use Observabale.range(1,10)
        Observable<Integer> integerObservable  = Observable.just(1,2,3,4,5,6,7,8,9,10);

        Observer<Integer> integerObserver = new Observer<Integer>(){

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Integer i) {
                view.updateViewFilter(i);
                ///System.out.println("onNext: "+ i);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: ");
            }

            @Override
            public void onComplete() {
                System.out.println("onCompile: ");
            }
        };


         integerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integerObserver);


        integerObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        return integer>9;
                    }
                });

    }


    @Override
    public void validateInput4 () {

        //you can use Observabale.range(1,10)
        Observable<Integer> integerObservable  = Observable.just(1,2,3,4,5,6,7,8,9,10);

        Observer<Integer> integerObserver = new Observer<Integer>(){

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Integer i) {
                view.updateViewTake(i);
                ///System.out.println("onNext: "+ i);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: ");
            }

            @Override
            public void onComplete() {
                System.out.println("onCompile: ");
            }
        };


        integerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integerObserver);


        integerObservable.subscribe(integerObserver);


    }







}
