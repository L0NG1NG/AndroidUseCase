package com.longing.singleinstance.onjava;

/**
 * 2懒加载 线程不安全
 */
public class LazyNotSafe {
    private static LazyNotSafe INSTANCE;

    private LazyNotSafe() {
    }

    public static LazyNotSafe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyNotSafe();
        }
        return INSTANCE;
    }
}
