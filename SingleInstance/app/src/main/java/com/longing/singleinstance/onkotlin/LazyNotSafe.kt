package com.longing.singleinstance.onkotlin

class LazyNotSafe private constructor() {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            LazyNotSafe()
        }
    }
}