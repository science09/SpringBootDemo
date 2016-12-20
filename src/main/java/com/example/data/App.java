package com.example.data;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hadoop on 16-12-2.
 */

public class App {
    private static App mInstance = null;

    @Autowired
    private AppProperty appProperty;

    public App() {}

//    public static App getInstance() {
//        if (mInstance == null) {
//            synchronized (App.class) {
//                if(mInstance == null) {
//                    mInstance = new App();
//
//                }
//            }
//        }
//        return mInstance;
//    }

    public String getAppName() {
        if(appProperty == null) {
            System.out.println("appProperty is NULL");
            return "NULL";
        }
        System.out.println(appProperty.getName());
        return appProperty.getName();
    }

}
