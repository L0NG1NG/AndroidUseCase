package com.longing.singleinstance.onkotlin

/**
 * 双重校验
 */
class LazyThreadSafeDoubleCheck private constructor() {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            LazyThreadSafeDoubleCheck()
        }
    }

}