package com.longing.singleinstance.onjava;

import android.util.Log;

/**
 * 1懒汉
 */
public class PlainOldSingleton {
    private static  PlainOldSingleton INSTANCE = new PlainOldSingleton();

    private PlainOldSingleton() {
        Log.i("TAG", "PlainOldSingleton: I am created");
    }

    public static PlainOldSingleton getInstance() {
        return INSTANCE;
    }
}
