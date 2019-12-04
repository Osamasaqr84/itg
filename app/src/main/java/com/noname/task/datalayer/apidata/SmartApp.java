package com.noname.task.datalayer.apidata;

import android.content.Context;
import android.support.multidex.MultiDexApplication;



public class SmartApp extends MultiDexApplication {
    private static SmartApp instance;
    private com.noname.task.datalayer.apidata.ServerGateway apiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        com.noname.task.datalayer.apidata.ApplicationComponent applicationComponent = com.noname.task.datalayer.apidata.DaggerApplicationComponent.builder()
                .contextModule(new com.noname.task.datalayer.apidata.ContextModule(this))
                .build();
        apiInterface = applicationComponent.getApplicationService();
    }

    public static Context getAppContext() {
        return instance;
    }

    public static SmartApp getAppInstance() {
        return instance;
    }

    public ServerGateway getApiInterface() {
        return apiInterface;
    }




}
