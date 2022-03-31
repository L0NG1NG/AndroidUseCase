package com.longing.singleinstance.onjava;

/**
 * 4双重校验锁
 */
public class LazyThreadSafeDoubleCheck {
    private static volatile LazyThreadSafeDoubleCheck INSTANCE;

    private LazyThreadSafeDoubleCheck() {
    }

    public LazyThreadSafeDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyThreadSafeDoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyThreadSafeDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
