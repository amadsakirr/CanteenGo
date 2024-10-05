package com.waaztech.jmti;

import android.app.Application;

import com.waaztech.jmti.util.Stash;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stash.init(this);
    }
}
