package com.azvk.nationalhockeyteams.presenters;

import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter implements Presenter {

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        configureCompositeSubscription();
    }

    private CompositeSubscription configureCompositeSubscription() {
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed()){
            compositeSubscription = new CompositeSubscription();
        }
        return compositeSubscription;
    }

    @Override
    public void OnStop() {
        unsubscribeAll();
    }

    private void unsubscribeAll() {
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }
}
